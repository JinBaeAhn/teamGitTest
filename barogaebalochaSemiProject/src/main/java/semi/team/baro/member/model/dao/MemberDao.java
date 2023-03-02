package semi.team.baro.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.member.model.vo.Member;

public class MemberDao {

	public MemberDao() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Member selectOneMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		
		String query = "select * from member_tbl where member_id=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setEnrollDate(rset.getString("enroll_date"));
				m.setFilepath(rset.getString("filepath"));
				m.setMemberAddr(rset.getString("member_addr"));
				m.setMemberContent(rset.getString("member_content"));
				m.setMemberCredit(rset.getInt("member_credit"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberLevel(rset.getInt("member_level"));
				m.setMemberMail(rset.getString("member_mail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return m;
	}
	public ArrayList<Member> selectAllMember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from member_tbl order by 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				m.setEnrollDate(rset.getString("enrollDate_date"));
				m.setMemberAddr(rset.getString("member_addr"));
				m.setMemberId(rset.getString("member_Id"));
				m.setMemberLevel(rset.getInt("member_level"));

				m.setMemberName(rset.getString("member_name"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberPw(rset.getString("member_pw"));


				list.add(m);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}
	

	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into member_tbl values(member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, 2, to_char(sysdate,'yyyy-mm-dd'), ?, 0)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getMemberMail());
			pstmt.setString(5, m.getMemberPhone());
			pstmt.setString(6, m.getMemberAddr());
			pstmt.setString(7, m.getMemberContent());
			pstmt.setString(8, m.getFilepath());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
}

