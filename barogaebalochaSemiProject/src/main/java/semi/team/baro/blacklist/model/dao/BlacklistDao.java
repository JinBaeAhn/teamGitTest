package semi.team.baro.blacklist.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.SQLException;

import common.JDBCTemplate;
import semi.team.baro.blacklist.model.vo.Blacklist;


public class BlacklistDao {

	public int blacklistInsert(Connection conn, Blacklist bl) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into admin_black_list values(admin_black_list_seq.nextval, ?, ?, ?, ?, to_char(sysdate, 'yyyy-mm-dd/hh24:mi:ss'), ?, 0)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bl.getMemberNo());
			pstmt.setString(2, bl.getMemberId());
			pstmt.setString(3, bl.getBlackTitle());
			pstmt.setString(4, bl.getBlackContent());
			pstmt.setString(5, bl.getBlackFilepath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Blacklist blacklistView(Connection conn, int blackNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Blacklist bla = null;
		String query = "select * from admin_black_list join member_tbl using(member_no) where black_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, blackNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				bla = new Blacklist();
				bla.setBlackContent(rset.getString("black_content"));
				bla.setBlackFilepath(rset.getString("black_filepath"));
				bla.setBlackMember(rset.getString("black_member"));
				bla.setBlackNo(rset.getInt("black_no"));
				bla.setBlackStatus(rset.getInt("black_status"));
				bla.setBlackTitle(rset.getString("black_title"));
				bla.setMemberId(rset.getString("member_id"));
				bla.setMemberNo(rset.getInt("member_no"));
				bla.setRegDate(rset.getString("reg_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return bla;
	}
}


