package semi.team.baro.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.board.model.vo.Board;

public class BoardDao {

	public ArrayList<Board> selectBoardList(Connection connection, int start, int end) {
		String query = "SELECT * FROM (SELECT ROWNUM AS LIST_COUNT, BOARD_LIST.* FROM (SELECT PHOTO_NO, MEMBER_ID, PHOTO_TITLE, PHOTO_CONTENT, READ_COUNT, REG_DATE FROM PHOTO_BOARD JOIN MEMBER_TBL USING(MEMBER_NO) ORDER BY 1 DESC) BOARD_LIST) WHERE LIST_COUNT BETWEEN ? AND ?";
		ArrayList<Board> boardList = new ArrayList<Board>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, start);
			preparedStatement.setInt(2, end);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int photoNo = resultSet.getInt("PHOTO_NO");
				String memberId = resultSet.getString("MEMBER_ID");
				String photoTitle = resultSet.getString("PHOTO_TITLE");
				String photoContent = resultSet.getString("PHOTO_CONTENT");
				int readCount = resultSet.getInt("READ_COUNT");
				String regDate = resultSet.getString("reg_date");
				Board board = new Board(photoNo, photoTitle, photoContent, readCount, regDate, memberId);
				boardList.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
			JDBCTemplate.close(resultSet);
		}
		return boardList;
	}

	public int selectBoardCount(Connection connection) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String quert = "select count(*) as total_count from photo_board";
		int totalCount = 0;
		try {
			preparedStatement = connection.prepareStatement(quert);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				totalCount = resultSet.getInt("total_count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
			JDBCTemplate.close(resultSet);
		}
		return totalCount;
	}

	public int insertBoard(Connection connection, Board board) {
		PreparedStatement preparedStatement = null;
		String query = "insert into PHOTO_BOARD values (PHOTO_BOARD_SEQ.nextval,?,?,?,0,(TO_CHAR(SYSDATE,'yyyy-mm-dd / HH24:MI:SS')),?,?)";
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, board.getMemberNo());
			preparedStatement.setString(2, board.getPhotoTitle());
			preparedStatement.setString(3, board.getPhotoContent());
			preparedStatement.setString(4, board.getFilename());
			preparedStatement.setString(5, board.getFilepath());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
		}
		return result;
	}

	public int updateReadCount(Connection connection, int photoNo) {
		PreparedStatement preparedStatement = null;
		String query = "update photo_board set read_count = (read_count+ 1) where photo_no = ?";
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, photoNo);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
		}
		return result;
	}

	public Board selectOneBoard(Connection connection, int photoNo) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from photo_board where photo_no = ?";
		Board board = new Board();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, photoNo);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				board.setMemberNo(resultSet.getInt("member_no"));
				board.setPhotoContent(resultSet.getString("photo_content"));
				board.setPhotoNo(resultSet.getInt("photo_no"));
				board.setPhotoTitle(resultSet.getString("photo_title"));
				board.setReadCount(resultSet.getInt("read_count"));
				board.setRegDate(resultSet.getString("reg_date"));
				board.setFilename(resultSet.getString("filename"));
				board.setFilepath(resultSet.getString("filepath"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
			JDBCTemplate.close(resultSet);
		}
		return board;
	}

	public String getBoardWriter(Connection connection, int photoNo) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select member_id from photo_board join member_tbl using(member_no) where photo_no = ?";
		String memberId = "";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, photoNo);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				memberId = resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
			JDBCTemplate.close(resultSet);
		}
		return memberId;
	}

	public int updateBoard(Connection connection, Board board) {
		PreparedStatement preparedStatement = null;
		String query = "update photo_board set photo_title = ? , photo_content = ?, filename = ?, filepath=? where photo_no = ?";
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, board.getPhotoTitle());
			preparedStatement.setString(2, board.getPhotoContent());
			preparedStatement.setString(3, board.getFilename());
			preparedStatement.setString(4, board.getFilepath());
			preparedStatement.setInt(5, board.getPhotoNo());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
		}
		return result;
	}

	public int removeBoard(Connection connection, int photoNo) {
		PreparedStatement preparedStatement = null;
		String query = "delete from PHOTO_BOARD where PHOTO_NO = ?";
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, photoNo);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
		}
		return result;
	}


}
