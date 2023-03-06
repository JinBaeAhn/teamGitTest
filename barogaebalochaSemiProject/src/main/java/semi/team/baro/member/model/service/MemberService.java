package semi.team.baro.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
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
	

}
