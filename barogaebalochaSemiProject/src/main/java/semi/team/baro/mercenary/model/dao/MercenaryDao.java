package semi.team.baro.mercenary.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;
import semi.team.baro.mercenary.model.vo.Mercenary;

public class MercenaryDao {

	public int mercenaryInsert(Connection conn, Mercenary m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into mercenary values(mercenary_seq.nextval, 0, ?, ?, ?, ?, ?, ?, 0, to_char(sysdate, 'yyyy-mm-dd'), 0, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getGroundName());
			pstmt.setString(2, m.getGameDate());
			pstmt.setString(3, m.getLocation());
			pstmt.setString(4, m.getGameTime());
			pstmt.setString(5, m.getMercenaryContent());
			pstmt.setInt(6, m.getMercenaryPay());
			pstmt.setInt(7, m.getLevel());
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
