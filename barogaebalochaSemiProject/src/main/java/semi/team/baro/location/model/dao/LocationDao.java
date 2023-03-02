package semi.team.baro.location.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.location.model.vo.Location;

public class LocationDao {

	public ArrayList<Location> selectLocationList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Location> list = new ArrayList<Location>();
		String query = "SELECT*FROM (SELECT ROWNUM AS RNUM, N. * FROM(SELECT GROUND_NO, GROUND_NAME, GROUND_PRICE, GROUND_LAT, GROUND_LNG, GROUND_CONTENT, FILE_PATH FROM GROUND_TBL ORDER BY 1 DESC)N)WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Location l = new Location();
				l.setGroundNo(rset.getInt("ground_no"));
				l.setGroundName(rset.getString("ground_name"));
				l.setGroundPrice(rset.getInt("ground_price"));
				l.setGroundLat(rset.getString("ground_lat"));
				l.setGroundLng(rset.getString("ground_lng"));
				l.setGroundContent(rset.getString("ground_content"));
				l.setFilePath(rset.getString("file_path"));
				list.add(l);
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

	public int selectLocationCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from ground_tbl";
		
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
