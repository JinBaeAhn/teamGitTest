package semi.team.baro.blacklist.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

	public ArrayList<Blacklist> selectAdminBlacklistList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Blacklist> list = new ArrayList<Blacklist>();
		String query = "select member_id,member_level, black_no, member_no, black_member, black_title, black_content, reg_date, black_filepath, black_status  from ADMIN_BLACK_LIST left join member_tbl using(member_no)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Blacklist b = new Blacklist();
				b.setMemberId(rset.getString("member_id"));
				b.setMemberLevel(rset.getInt("member_level"));
				b.setBlackNo(rset.getInt("black_no"));
				b.setMemberNo(rset.getInt("member_no"));
				b.setBlackMember(rset.getString("black_member"));
				b.setBlackTitle(rset.getString("black_title"));
				b.setBlackContent(rset.getString("black_content"));
				b.setRegDate(rset.getString("reg_date"));
				b.setBlackFilepath(rset.getString("black_filepath"));
				b.setBlackStatus(rset.getInt("black_status"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int selectAdminBlacklistCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from blacklist";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return totalCount;
	}

}
