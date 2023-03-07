package semi.team.baro.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.JDBCTemplate;
import semi.team.baro.member.model.dao.MemberDao;
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
	public ArrayList<Member> adminOneMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = dao.adminOneMember(conn, memberId);
		JDBCTemplate.close(conn);
		return list;
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
	

}
