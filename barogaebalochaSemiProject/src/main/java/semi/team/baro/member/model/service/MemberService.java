package semi.team.baro.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.JDBCTemplate;
import semi.team.baro.member.model.dao.MemberDao;
import semi.team.baro.member.model.vo.AdminPageData;
import semi.team.baro.member.model.vo.Member;

public class MemberService {
	private MemberDao dao;

	public MemberService() {
		super();
		dao = new MemberDao();
	}


	public Member selectOneMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = dao.selectOneMember(conn, memberId);
		JDBCTemplate.close(conn);
		return m;
	}
	

	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertMember(conn, m);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = dao.selectAllMember(conn);
		JDBCTemplate.close(conn);
		return list;

	}


	public Member selectOneMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		Member member = dao.selectOneMember(conn, m);
		JDBCTemplate.close(conn);
		return member;
	}


	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateMember(conn, m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}JDBCTemplate.close(conn);
		return result;
	}



	public int deleteMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		String memberId = m.getMemberId();
		int result = dao.insertDelMember(conn, m);
		if(result>0) {
			result = dao.deleteMember(conn, memberId);
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}JDBCTemplate.close(conn);
		
		return result;
		
	}


	public int changeLevel(int memberNo, int memberLevel) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changeLevel(conn,memberNo,memberLevel);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}


	public boolean checkedChangeLevel(String no, String level) {
		Connection conn = JDBCTemplate.getConnection();
		StringTokenizer sT1 = new StringTokenizer(no,"/");
		StringTokenizer sT2 = new StringTokenizer(level,"/");
		boolean result = true;
		while(sT1.hasMoreTokens()) {
			int memberNo = Integer.parseInt(sT1.nextToken());
			int memberLevel = Integer.parseInt(sT2.nextToken());
			int changeResult = dao.changeLevel(conn, memberNo, memberLevel);
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



	public int updateMemberCredit(String memberId, int totalCredit) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateMemberCredit(conn, memberId, totalCredit);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}JDBCTemplate.close(conn);
		return result;
	}


	public Member selectOneMember(String memberName, String memberPhone) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = dao.selectOneMember(conn, memberName, memberPhone);
		JDBCTemplate.close(conn);
		return m;
	}


	public Member selectOneMember(String memberId, String memberPhone, String memberMail) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = dao.selectOneMember(conn, memberId, memberPhone, memberMail);
		JDBCTemplate.close(conn);
		return m;
	}


	public int updateMember(String memberId, String randomCode) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateMember(conn, memberId, randomCode);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}JDBCTemplate.close(conn);
		return result;
	}
	

	public AdminPageData selectAllMember(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 5;
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;
		ArrayList<Member> list = dao.selectAllMember(conn,start,end);
		int totalCount = dao.selectAdminCount(conn);
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage + 1;
		}
		
		int pageNaviSize = 5;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		String pageNavi = "<ul class='pagination circle-style'>";
		if(pageNo !=1) {
			pageNavi += "<li>";
			pageNavi +="<a class='page-item' href='/adminPage.do?reqPage="+(pageNo-1)+"'>";
			pageNavi +="<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi +="<a class='page-item active-page' href='/adminPage.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}else {
				pageNavi += "<li>";
				pageNavi +="<a class='page-item' href='/adminPage.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		if(pageNo <= totalPage) {
			pageNavi += "<li>";
			pageNavi +="<a class='page-item' href='/adminPage.do?reqPage="+(pageNo)+"'>";
			pageNavi +="<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi +="</ul>";
		
		JDBCTemplate.close(conn);
		AdminPageData apd = new AdminPageData(list,pageNavi,start);
		return apd;
	}


	public ArrayList<Member> adminselectAllMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = dao.adminselectAllMember(conn, memberId);
		JDBCTemplate.close(conn);
		return list;
	}


}
