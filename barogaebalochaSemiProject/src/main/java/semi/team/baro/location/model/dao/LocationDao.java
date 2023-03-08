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

	public Location selectOneLocation(Connection conn, int groundNo) {
		PreparedStatement pstmt = null;
		ResultSet rset =  null;
		Location l = null;
		String query = "select * from ground_tbl  left join amenity using(ground_no) where ground_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, groundNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				l = new Location();
				l.setGroundNo(rset.getInt("ground_no"));
				l.setGroundName(rset.getString("ground_name"));
				l.setGroundPrice(rset.getInt("ground_price"));
				l.setGroundLat(rset.getString("ground_lat"));
				l.setGroundLng(rset.getString("ground_lng"));
				l.setGroundContent(rset.getString("ground_content"));
				l.setFilePath(rset.getString("file_path"));
				
				l.setParking(rset.getInt("parking"));
				l.setShower(rset.getInt("shower"));
				l.setBall(rset.getInt("ball"));
				l.setUniform(rset.getInt("uniform"));
				l.setShoes(rset.getInt("shoes"));
				l.setWater(rset.getInt("water"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return l;
	}

	public int insertLocation(Connection conn, Location l) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into ground_tbl values(ground_seq.nextval,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, l.getGroundName());
			pstmt.setInt(2, l.getGroundPrice());
			pstmt.setString(3, l.getGroundLat());
			pstmt.setString(4, l.getGroundLng());
			pstmt.setString(5, l.getGroundContent());
			pstmt.setString(6, l.getFilePath());
			pstmt.setString(7, l.getGroundLocation());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Location> locationSearchList(String location, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Location> list = new ArrayList<Location>();
		String query = "SELECT GROUND_NAME, GROUND_PRICE FROM GROUND_TBL WHERE GROUND_LOCATION LIKE ? ORDER BY 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,"%"+location+"%");
			rset = pstmt.executeQuery();
			while(rset.next()){
				Location l = new Location();
				l.setGroundName(rset.getString("ground_name"));
				l.setGroundPrice(rset.getInt("ground_price"));
				list.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			//System.out.println("리스트사이즈 잘 나오냐"+list.size());
		}
		
		return list;
	}

	public int setAmenity(Connection conn, int groundNo, int[] amenityActiveList) {
		PreparedStatement preparedStatement = null;
		String query = "insert into AMENITY values(?,?,?,?,?,?,?)";
		int reuslt = 0;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, groundNo);
			System.out.println(groundNo);
			preparedStatement.setInt(2, amenityActiveList[0]);
			preparedStatement.setInt(3, amenityActiveList[1]);
			preparedStatement.setInt(4, amenityActiveList[2]);
			preparedStatement.setInt(5, amenityActiveList[3]);
			preparedStatement.setInt(6, amenityActiveList[4]);
			preparedStatement.setInt(7, amenityActiveList[5]);
			reuslt = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(preparedStatement);
		}
		return reuslt;
	}

	public int getGroundNo(Connection conn, String groundName) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select ground_no from ground_tbl where ground_name = ?";
		int groundNo = 0;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, groundName);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				groundNo = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(preparedStatement);
			JDBCTemplate.close(resultSet);
		}
		return groundNo;
	}


}
