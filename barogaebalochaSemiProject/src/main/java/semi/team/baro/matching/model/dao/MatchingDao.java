package semi.team.baro.matching.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import semi.team.baro.matching.model.vo.Matching;

public class MatchingDao {

	public ArrayList<Matching> selectMatchingList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Matching> list = new ArrayList<Matching>();
		return null;
	}

}
