package semi.team.baro.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.board.model.dao.BoardDao;
import semi.team.baro.board.model.vo.Board;
import semi.team.baro.board.model.vo.BoardComment;
import semi.team.baro.board.model.vo.BoardPageData;
import semi.team.baro.board.model.vo.BoardViewData;

public class BoardService {
	BoardDao boardDao;

	public BoardService() {
		super();
		boardDao = new BoardDao();
	}

	public BoardPageData selectBoardList(int boardPage) {
		Connection connection = JDBCTemplate.getConnection();
		//한 페이지 당 게시물 수 지정 -> [10]개
		int numberOfPerPage = 10;
		int end = numberOfPerPage*boardPage;
		int start = end - numberOfPerPage + 1 ;
		ArrayList<Board> boardList = boardDao.selectBoardList(connection, start, end);
		//페이징 제작을 위해 총 게시물 수가 필요함
		int totalCount = boardDao.selectBoardCount(connection);
		//마지막 페이지 설정
		int totalPage = (int) Math.ceil((double)totalCount/numberOfPerPage);
		//navigation size / start number setting 
		int pageNavigationSize = 5;
		//reqPage 1~5 : 1 2 3 4 5 , reqPage 6~10 6 7 8 9 10, reqPage 11~15 11 12 13 14 15
		int pageNo = ((boardPage-1)/pageNavigationSize)*pageNavigationSize+1;
		//패아자 네비게이션 제작 시작
		String pageNavigation = "<ul class = 'pagination'>";
		//이전버튼
		if(pageNo != 1) {
			pageNavigation += "<li>";
			pageNavigation += 	"<a class='page-item' href='/freeBoardList.do?boardPage="+(pageNo-1)+"'>";
			pageNavigation += 		"<span class='material-icons'>chevron_left</span>";
			pageNavigation += 	"</a>";
			pageNavigation += "</li>";
		}
		//page 숫자
		for(int i=0;i<pageNavigationSize;i++) {
			if(pageNo == boardPage) {
				pageNavigation += "<li>";
				pageNavigation += 	"<a class='page-item active-page' href='/freeBoardList.do?boardPage="+(pageNo)+"'>";
				pageNavigation += 		pageNo;
				pageNavigation += 	"</a>";
				pageNavigation += "</li>";
			} else {
				pageNavigation += "<li>";
				pageNavigation += 	"<a class='page-item' href='/freeBoardList.do?boardPage="+(pageNo)+"'>";
				pageNavigation += 		pageNo;
				pageNavigation += 	"</a>";
				pageNavigation += "</li>";
			}
			pageNo++;
			if(pageNo>totalPage) break;
		}
		//다음버튼
		if(pageNo <= totalPage) {
			pageNavigation += "<li>";
			pageNavigation += 	"<a class='page-item' href='/freeBoardList.do?boardPage="+(pageNo)+"'>";
			pageNavigation += 		"<span class='material-icons'>chevron_right</span>";
			pageNavigation += 	"</a>";
			pageNavigation += "</li>";
		}
		pageNavigation += "</ul>";
		BoardPageData boardPageData = new BoardPageData(boardList,pageNavigation,start);
		JDBCTemplate.close(connection);
		return boardPageData;
	}

	public int insertBoard(Board board) {
		Connection connection = JDBCTemplate.getConnection();
		int result = boardDao.insertBoard(connection, board);
		if(result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}
		JDBCTemplate.close(connection);
		return result;
	}

	public BoardViewData selectOneBoard(int photoNo) {
		Connection connection = JDBCTemplate.getConnection();
		int result = boardDao.updateReadCount(connection,photoNo);
		if(result > 0) {
			JDBCTemplate.commit(connection);
			Board board = boardDao.selectOneBoard(connection, photoNo);
			board.setMemberId(boardDao.getBoardWriter(connection, photoNo));
			//일반댓글 조회
			ArrayList<BoardComment> boardCommentList = boardDao.selectBoardComments(connection,photoNo);
			//대댓글조회
			ArrayList<BoardComment> boardReCommentList = boardDao.selectBoardReComments(connection,photoNo);
			
			//작성자 삽입
			for(BoardComment comment :boardCommentList) {
				comment.setMemberId(boardDao.getCommentWriter(connection, comment.getBoardCommentWriter(),comment.getBoardCommentNo()));
			}
			for(BoardComment comment :boardReCommentList) {
				comment.setMemberId(boardDao.getCommentWriter(connection, comment.getBoardCommentWriter(),comment.getBoardCommentNo()));
			}
			board.setMemberId(boardDao.getBoardWriter(connection, photoNo));
			BoardViewData boardViewData = new BoardViewData(board, boardCommentList, boardReCommentList);
			JDBCTemplate.close(connection);
			return boardViewData;
		} else {
			JDBCTemplate.rollback(connection);
			JDBCTemplate.close(connection);
			return null;
		}
	}

	public Board getBoard(int photoNo) {
		Connection connection = JDBCTemplate.getConnection();
		Board board = boardDao.selectOneBoard(connection,photoNo);
		board.setMemberId(boardDao.getBoardWriter(connection, photoNo));
		JDBCTemplate.close(connection);
		return board;
	}

	public int updateBoard(Board board) {
		Connection connection = JDBCTemplate.getConnection();
		int result = boardDao.updateBoard(connection, board);
		if(result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}
		JDBCTemplate.close(connection);
		return result;
	}

	public Board removeBoard(int photoNo) {
		Connection connection = JDBCTemplate.getConnection();
		Board board = boardDao.selectOneBoard(connection, photoNo);
		int result = boardDao.removeBoard(connection,photoNo);
		if(result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
			board = null;
		}
		JDBCTemplate.close(connection);
		return board;
	}

	public int freeBoardCommentWrite(BoardComment boardComment) {
		Connection connection = JDBCTemplate.getConnection();
		int result = boardDao.freeBoardCommentWrite(connection, boardComment);
		if(result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}
		JDBCTemplate.close(connection);
		return result;
	}

	public int removeFreeBoardComment(int boardCommentNo) {
		Connection connection = JDBCTemplate.getConnection();
		int result = boardDao.removeFreeBoardComment(connection, boardCommentNo);
		if(result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}
		JDBCTemplate.close(connection);
		return result;
	}

	public int freeBoardCommentUpdate(BoardComment boardComment) {
		Connection connection = JDBCTemplate.getConnection();
		int result = boardDao.freeBoardCommentUpdate(connection, boardComment);
		if(result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}
		JDBCTemplate.close(connection);
		return result;
	}
}