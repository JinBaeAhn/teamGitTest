package semi.team.baro.history.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.blacklist.model.vo.Blacklist;
import semi.team.baro.history.model.dao.HistoryDao;
import semi.team.baro.history.model.vo.HistoryPageData;
import semi.team.baro.mercenary.model.vo.Mercenary;
import semi.team.baro.mercenary.model.vo.MercenaryRequest;

public class HistoryService {
	
	private HistoryDao dao;

	public HistoryService() {
		super();
		dao = new HistoryDao();
	}

	public HistoryPageData mercenaryMyHistory(int memberNo, int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;
		//rnum포함 쿼리문 작성
		ArrayList<Mercenary> mcList = dao.mercenaryMyHistory(conn, memberNo, start, end);
		//페이징제작
		//1. 전체페이지수계산
		int totalCount = dao.mercenaryMyHistoryCount(conn, memberNo);
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/ numPerPage + 1;
		}
		int pageNaviSize = 5;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		
		String pageNavi = "<ul class='pagination circle-style'>";
		//이전버튼(<)
		///historyMercenary.do?memberNo=<%=m.getMemberNo()%>&reqPage=1&categoryName=mercenary
		if(pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/historyMercenary.do?memberNo="+memberNo+"&reqPage="+(pageNo-1)+"&categoryName=mercenary'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}
		//페이지 숫자(1 2 3 4 5)
		for(int i=0; i<pageNaviSize; i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/historyMercenary.do?memberNo="+memberNo+"&reqPage="+(pageNo)+"&categoryName=mercenary'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/historyMercenary.do?memberNo="+memberNo+"&reqPage="+(pageNo)+"&categoryName=mercenary'>";
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
			pageNavi += "<a class='page-item' href='/historyMercenary.do?memberNo="+memberNo+"&reqPage="+(pageNo)+"&categoryName=mercenary'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";
		
		HistoryPageData hpd = new HistoryPageData();
		hpd.setMcList(mcList);
		hpd.setPageNavi(pageNavi);
		hpd.setStart(start);

		JDBCTemplate.close(conn);
		
		return hpd;

	}
	public HistoryPageData merceneryRequestMyHistory(int memberNo, int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;
		//rnum포함 쿼리문 작성
		ArrayList<MercenaryRequest> mcReqList = dao.mercenaryRequestMyHistory(conn, memberNo, start, end);
		//페이징제작
		//1. 전체페이지수계산
		int totalCount = dao.mercenaryRequestMyHistoryCount(conn, memberNo);
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/ numPerPage + 1;
		}
		int pageNaviSize = 5;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		
		String pageNavi = "<ul class='pagination circle-style'>";
		//이전버튼(<)
		///historyMercenary.do?memberNo=<%=m.getMemberNo()%>&reqPage=1&categoryName=mercenary
		if(pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/historyMercenaryRequest.do?memberNo="+memberNo+"&reqPage="+(pageNo-1)+"&categoryName=mercenaryRequest'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}
		//페이지 숫자(1 2 3 4 5)
		for(int i=0; i<pageNaviSize; i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/historyMercenaryRequest.do?memberNo="+memberNo+"&reqPage="+(pageNo)+"&categoryName=mercenaryRequest'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/historyMercenaryRequest.do?memberNo="+memberNo+"&reqPage="+(pageNo)+"&categoryName=mercenaryRequest'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		//다음버튼
		if(pageNo <= totalPage) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/historyMercenaryRequest.do?memberNo="+memberNo+"&reqPage="+(pageNo)+"&categoryName=mercenaryRequest'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";
		
		HistoryPageData hpd = new HistoryPageData();
		hpd.setMcReqList(mcReqList);
		hpd.setPageNavi(pageNavi);
		hpd.setStart(start);

		JDBCTemplate.close(conn);
		
		return hpd;
	}

	public HistoryPageData blacklistMyHistory(int memberNo, int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;
		//rnum포함 쿼리문 작성
		ArrayList<Blacklist> blaList = dao.blackListMyHistory(conn, memberNo, start, end);
		//페이징제작
		//1. 전체페이지수계산
		int totalCount = dao.blackListHistoryCount(conn, memberNo);
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/ numPerPage + 1;
		}
		int pageNaviSize = 5;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		
		String pageNavi = "<ul class='pagination circle-style'>";
		//이전버튼(<)
		///historyMercenary.do?memberNo=<%=m.getMemberNo()%>&reqPage=1&categoryName=mercenary
		if(pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/historyBlacklist.do?memberNo="+memberNo+"&reqPage="+(pageNo-1)+"&categoryName=blacklist'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}
		//페이지 숫자(1 2 3 4 5)
		for(int i=0; i<pageNaviSize; i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/historyBlacklist.do?memberNo="+memberNo+"&reqPage="+(pageNo)+"&categoryName=blacklist'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/historyBlacklist.do?memberNo="+memberNo+"&reqPage="+(pageNo)+"&categoryName=blacklist'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		//다음버튼
		if(pageNo <= totalPage) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/historyBlacklist.do?memberNo="+memberNo+"&reqPage="+(pageNo)+"&categoryName=blacklist'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";
		
		HistoryPageData hpd = new HistoryPageData();
		hpd.setBlaList(blaList);
		hpd.setPageNavi(pageNavi);
		hpd.setStart(start);

		JDBCTemplate.close(conn);
		
		return hpd;
	}

}
