package semi.team.baro.blacklist.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
<<<<<<< HEAD
import java.sql.ResultSet;
import java.sql.SQLException;

=======
import java.sql.SQLException;

import common.JDBCTemplate;
import semi.team.baro.blacklist.model.vo.Blacklist;

>>>>>>> main
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

}
