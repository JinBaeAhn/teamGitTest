package semi.team.baro.history.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.mercenary.model.vo.Mercenary;

public class HistoryDao {

	public ArrayList<Mercenary> history(Connection conn, int memberNo, String categoryName) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Mercenary> mcList = new ArrayList<Mercenary>();
		String query = "select * from mercenary join ground_tbl using(ground_no) where member_no = ? order by mercenary_no";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				//mercenaryNo, game_location, ground_name, game_date, game_time, mercenary_whether, reg_date;
				Mercenary mc = new Mercenary();
				mc.setMercenaryNo(rset.getInt("mercenary_no"));
				mc.setLocation(rset.getString("game_location"));
				mc.setGroundName(rset.getString("ground_name"));
				mc.setGameDate(rset.getString("game_date"));
				mc.setGameTime(rset.getInt("game_time"));
				mc.setMercenaryWhether(rset.getInt("mercenary_whether"));
				mc.setRegDate(rset.getString("reg_date"));
				mcList.add(mc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return mcList;
	}

}
