package semi.team.baro.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.board.model.dao.BoardDao;
import semi.team.baro.board.model.vo.Board;
import semi.team.baro.board.model.vo.BoardPageData;

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
}