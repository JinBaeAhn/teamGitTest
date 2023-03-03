package semi.team.baro.mercenary.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.mercenary.model.dao.MercenaryDao;
import semi.team.baro.mercenary.model.vo.Mercenary;
import semi.team.baro.mercenary.model.vo.MercenaryPageData;

public class MercenaryService {
	private MercenaryDao dao;

	public MercenaryService() {
		super();
		dao = new MercenaryDao();
	}

	public int mercenaryInsert(Mercenary m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.mercenaryInsert(conn, m);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public MercenaryPageData mercenarySelectAll(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		int numPerPage = 10;//한페이지당 게시물수
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;		
		
		ArrayList<Mercenary> list = dao.mercenarySelectAll(conn, start, end);
		//페이징제작
		//전체페이지수계산 -> 총게시물/10
		int totalCount = dao.selectMercenaryCount(conn);
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = (totalCount/numPerPage) + 1;
		}
		int pageNaviSize = 5;
		//페이지 네비게이션 시작번호
		//reqPage 1 ~ 5 : 1 2 3 4 5
		//reqPage 6 ~ 10 : 6 7 8 9 10
		//reqPage 11 ~ 15 : 11 12 13 14 15
		
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		// ((reqPage-1)/5)*5 + 1
		// reqPage = 1~5 -> reqPage-1 = 0~4 
		// 0/5*5 + 1 = 1 -> 시작번호 1이 나옴 -> for문으로 증가해줄것
		
		//페이지 네비게이션 제작 시작
		String pageNavi = "<ul class='pagination circle-style'>";
		//이전버튼(<)
		if(pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/mercenaryList.do?reqPage="+(pageNo-1)+"'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}
		//페이지 숫자(1 2 3 4 5)
		for(int i=0; i<pageNaviSize; i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/mercenaryList.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/mercenaryList.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++;
			//for문을 중간에 탈출해야하는 경우가 있음 - 페이지가 끝나면 그 이후페이지(없는페이지)는 출력X
			if(pageNo>totalPage) {
				break;
			}
		}
		//다음버튼
		if(pageNo <= totalPage) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/mercenaryList.do?reqPage="+(pageNo)+"'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";
		
		MercenaryPageData mcpd = new MercenaryPageData(list, pageNavi, start);

		JDBCTemplate.close(conn);
		return mcpd;
	}

	public Mercenary mercenaryView(int mercenaryNo) {
		Connection conn = JDBCTemplate.getConnection();
		Mercenary mc = dao.mercenaryView(conn, mercenaryNo);
		JDBCTemplate.close(conn);
		return mc;
	}
	
}
