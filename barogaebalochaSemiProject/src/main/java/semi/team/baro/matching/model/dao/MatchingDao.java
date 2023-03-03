package semi.team.baro.matching.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.matching.model.vo.Matching;

public class MatchingDao {

	public ArrayList<Matching> selectMatchingList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Matching> list = new ArrayList<Matching>();
		String query = "select * from (select rownum as rnum, n.* from (select matching_no, b.matching_board_no, matching_board_title, read_count, b.matching_status, reg_date, b.reservation_no, ground_name, ground_location, reservation_date, reservation_time from matching_board b left join matching_request r on (b.matching_board_no = r.matching_board_no) left join reservation res on (b.ground_no = res.ground_no) left join ground_tbl g on(b.ground_no=g.ground_no))n) where rnum between ? and ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Matching m  = new Matching();
				m.setMatchingNo(rset.getInt("matching_no"));
				m.setMatchingBoardNo(rset.getInt("matching_board_no"));
				m.setMatchingBoardTitle(rset.getString("matching_board_title"));
				m.setReadCount(rset.getInt("read_count"));
				m.setRegDate(rset.getString("reg_date"));
				m.setMatchingStatus(rset.getInt("matching_status"));
				m.setReservationNo(rset.getInt("reservation_no"));
				m.setGroundName(rset.getString("ground_name"));
				m.setGroundLocation(rset.getString("ground_location"));
				m.setReservationDate(rset.getString("reservation_date"));
				m.setReservationTime(rset.getString("reservation_time"));
				list.add(m);
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

	public int selectMatchingCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from matching_board";
		
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
