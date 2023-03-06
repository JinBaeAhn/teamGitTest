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

}
