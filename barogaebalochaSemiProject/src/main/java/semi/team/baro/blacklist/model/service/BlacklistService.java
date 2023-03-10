package semi.team.baro.blacklist.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.JDBCTemplate;
import semi.team.baro.blacklist.model.dao.BlacklistDao;
import semi.team.baro.blacklist.model.vo.Blacklist;
import semi.team.baro.blacklist.model.vo.BlacklistPageData;
import semi.team.baro.board.model.vo.Board;

public class BlacklistService {
	private BlacklistDao dao;

	public BlacklistService() {
		super();
		dao = new BlacklistDao();
	}

	public BlacklistPageData adminBlacklistList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;
		//reqPage가 1페이지면 -> 최신글 1~10번
		//reqPage가 2페이지면 -> 최시글 11~20번
		//reqPage가 3페이지면 -> 최신글 21~30번
		//reqPage == 4 -> 31~40
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;
		ArrayList<Blacklist> list = dao.selectAdminBlacklistList(conn,start,end);
		
		//페이징제작 시작
		//전체페이지 수를 계산 -> 총 게시물 수를 조회
		int totalCount = dao.selectAdminBlacklistCount(conn);
		//전체 페이지 수 계산
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage + 1;
			
		}
		//네비게이션 사이즈
		int pageNaviSize = 5;
		
		//페이지네비게이션 시작번호
		//reqPage 1 ~ 5 : 1 2 3 4 5
		//reqPage 6 ~ 10 : 6 7 8 9 10
		//reqPage 11 ~ 15 : 11 12 13 14 15	
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		
		//페이지 네비게이션 제작 시작
		String pageNavi = "<ul class='pagination circle-style'>";
		//이전버튼
		if(pageNo != 1) {
			pageNavi += "<li>";
			pageNavi +="<a class='page-item' href='/adminBlacklistList.do?reqPage="+(pageNo-1)+"'>";
			pageNavi +="<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}
		//페이지 숫자
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi +="<a class='page-item active-page' href='/adminBlacklistList.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}else {
				pageNavi += "<li>";
				pageNavi +="<a class='page-item' href='/adminBlacklistList.do?reqPage="+(pageNo)+"'>";
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
			pageNavi +="<a class='page-item' href='/adminBlacklistList.do?reqPage="+(pageNo)+"'>";
			pageNavi +="<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi +="</ul>";
		
		JDBCTemplate.close(conn);
		BlacklistPageData bpd = new BlacklistPageData(list,pageNavi,start);
		return bpd;
	}

	public int changeStatus(int blackNo, int blackStatus) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changeStatus(conn,blackNo,blackStatus);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public boolean checkedChangeStatus(String no, String status) {
		Connection conn = JDBCTemplate.getConnection();
		StringTokenizer sT1 = new StringTokenizer(no,"/");
		StringTokenizer sT2 = new StringTokenizer(status,"/");
		boolean result = true;
		while(sT1.hasMoreTokens()) {
			int blackNo = Integer.parseInt(sT1.nextToken());
			int blackStatus = Integer.parseInt(sT2.nextToken());
			int changeResult = dao.changeStatus(conn, blackNo, blackStatus);
			if(changeResult == 0) {
				result = false;
				break;
			}
		}
		if(result) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int blacklistInsert(Blacklist bl) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.blacklistInsert(conn, bl);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public Blacklist blacklistView(int blackNo) {
		Connection conn = JDBCTemplate.getConnection();
		Blacklist bla = dao.blacklistView(conn, blackNo);
		JDBCTemplate.close(conn);
		return bla;
	}
}
