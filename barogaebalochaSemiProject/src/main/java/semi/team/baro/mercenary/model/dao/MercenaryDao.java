package semi.team.baro.mercenary.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.mercenary.model.vo.Mercenary;

public class MercenaryDao {

	public int mercenaryInsert(Connection conn, Mercenary mc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into mercenary values(mercenary_seq.nextval, ?, ?, ?, ?, ?, ?, ?, 0, to_char(sysdate, 'yyyy-mm-dd'), 0, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mc.getMemberNo());
			pstmt.setString(2, mc.getLocation());
			pstmt.setString(3, mc.getGroundName());
			pstmt.setString(4, mc.getGameDate());
			pstmt.setInt(5, mc.getGameTime());
			pstmt.setString(6, mc.getMercenaryContent());
			pstmt.setInt(7, mc.getMercenaryPay());
			pstmt.setInt(8, mc.getLevel());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Mercenary> mercenarySelectAll(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Mercenary> list = new ArrayList<Mercenary>();
		String query = "select * from (select rownum as rnum, n.* from(select * from mercenary order by 1 desc)n) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Mercenary mc = new Mercenary();
				mc.setGameDate(rset.getString("game_date"));
				mc.setGameTime(rset.getInt("game_time"));
				mc.setGroundName(rset.getString("ground_name"));
				mc.setLevel(rset.getInt("skill"));
				mc.setLocation(rset.getString("game_location"));
				mc.setMemberNo(rset.getInt("member_no"));
				mc.setMercenaryContent(rset.getString("mercenary_content"));
				mc.setMercenaryNo(rset.getInt("mercenary_no"));
				mc.setMercenaryPay(rset.getInt("mercenary_pay"));
				mc.setMercenaryWhether(rset.getInt("mercenary_whether"));
				mc.setReadCount(rset.getInt("read_count"));
				mc.setRegDate(rset.getString("reg_date"));
				list.add(mc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public Mercenary mercenaryView(Connection conn, int mercenaryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Mercenary mc = null;
		String query = "select mercenary_no, member_no, game_location, ground_name, game_date, game_time, mercenary_content, mercenary_pay, read_count, reg_date, mercenary_whether, skill, member_id from mercenary join member_tbl using(member_no) where mercenary_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mercenaryNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mc = new Mercenary();
				mc.setMercenaryNo(rset.getInt("mercenary_no"));
				mc.setMemberNo(rset.getInt("member_no"));
				mc.setGameDate(rset.getString("game_date"));
				mc.setGameTime(rset.getInt("game_time"));
				mc.setGroundName(rset.getString("ground_name"));
				mc.setLevel(rset.getInt("skill"));
				mc.setLocation(rset.getString("game_location"));
				mc.setMemberId(rset.getString("member_id"));
				mc.setMercenaryContent(rset.getString("mercenary_content"));
				mc.setMercenaryPay(rset.getInt("mercenary_pay"));
				mc.setMercenaryWhether(rset.getInt("mercenary_whether"));
				mc.setReadCount(rset.getInt("read_count"));
				mc.setRegDate(rset.getString("reg_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return mc;
	}

	public int selectMercenaryCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from mercenary";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return totalCount;
	}

	public int mercenaryDelete(Connection conn, int mercenaryNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from mercenary where mercenary_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mercenaryNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int readCountUpdate(Connection conn, int mercenaryNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update mercenary set read_count = read_count + 1 where mercenary_no = ?";		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mercenaryNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}




