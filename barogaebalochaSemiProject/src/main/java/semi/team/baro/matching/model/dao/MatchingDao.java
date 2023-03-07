package semi.team.baro.matching.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.Query;

import common.JDBCTemplate;
import oracle.net.aso.p;
import semi.team.baro.matching.model.vo.Matching;

public class MatchingDao {

	public ArrayList<Matching> selectMatchingList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Matching> list = new ArrayList<Matching>();
		//String query = "select * from (select rownum as rnum, n.* from (select matching_no, b.matching_board_no, matching_board_title, read_count, b.matching_status, reg_date, b.reservation_no, ground_name, ground_location, reservation_date, reservation_time from matching_board b left join matching_request r on (b.matching_board_no = r.matching_board_no) left join reservation res on (b.ground_no = res.ground_no) left join ground_tbl g on(b.ground_no=g.ground_no))n) where rnum between ? and ? ";
		String query = "select * from (select rownum as rnum, n.* from (select b.matching_board_no, matching_board_title, read_count, b.matching_status, reg_date, b.reservation_no, ground_name, ground_location, reservation_date, reservation_time from matching_board b left join reservation res on (b.reservation_no = res.reservation_no) left join ground_tbl g on(res.ground_no=g.ground_no)order by matching_board_no desc)n) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Matching m  = new Matching();
				//m.setMatchingNo(rset.getInt("matching_no"));
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

	public int matchingListInsert(Connection conn, int reservationNo, int groundNo, Matching mc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="insert into matching_board values(matching_board_seq.nextval,?,?,?,to_char(sysdate,'yyyy-mm-dd/hh24:mi:ss'),0,1,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mc.getMemberNo());
			pstmt.setString(2, mc.getMatchingBoardTitle());
			pstmt.setString(3, mc.getMatchingBoardContent());
			pstmt.setInt(4,groundNo);
			pstmt.setInt(5, reservationNo);
			System.out.println("test reservationNo" + reservationNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int reservationInsert(Connection conn, int groundNo, Matching mc) {
		PreparedStatement pstmt = null;
		int result = 0 ;
		String query = "insert into reservation values(reservation_seq.nextval,?,?,?,?,0,reservation_id_seq.nextval)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mc.getMemberNo());
			pstmt.setInt(2, groundNo);
			pstmt.setString(3, mc.getReservationTime());
			pstmt.setString(4,  mc.getReservationDate());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int groundSearch(Connection conn, Matching mc) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		int groundNo = 0;
		//System.out.println(mc.getGroundName()+"구장이름");
		String query = "select ground_no from ground_tbl where ground_name like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mc.getGroundName());
			rset = pstmt.executeQuery();
			if(rset.next()) {
			groundNo = rset.getInt("ground_no");
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return groundNo;
	}

	public int getReservationNo(Connection conn, int groundNo, Matching mc) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int reservationNo = 0;
		String query = "select reservation_no from reservation where member_no=? and ground_no=? and reservation_time=? and reservation_date=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mc.getMemberNo());
			pstmt.setInt(2, groundNo);
			pstmt.setString(3, mc.getReservationTime());
			pstmt.setString(4, mc.getReservationDate());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				reservationNo= rset.getInt("reservation_no");
				//System.out.println("reservation_no테스트"+reservationNo);
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return reservationNo;
	}

	public Matching selectOneMatch(Connection conn, int reservationNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Matching mc = null;
		String query= "select b.matching_board_no, matching_board_title, b.matching_status, reg_date, b.reservation_no, ground_name, ground_location, reservation_date, reservation_time from matching_board b left join reservation res on (b.reservation_no = res.reservation_no) left join ground_tbl g on(res.ground_no=g.ground_no)  where b.reservation_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reservationNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mc = new Matching();
				mc.setMatchingBoardNo(rset.getInt("member_no"));
				mc.setMatchingBoardTitle(rset.getString("matching_board_title"));
				mc.setMatchingStatus(rset.getInt("matching_status"));
				mc.setRegDate(rset.getNString("reg_date"));
				mc.setReservationNo(rset.getInt("reservation_no"));
				mc.setGroundName(rset.getString("ground_name"));
				mc.setGroundLocation(rset.getString("ground_location"));
				mc.setReservationDate(rset.getString("reservation_date"));
				mc.setReservationTime(rset.getString("reservation_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mc;
	}

	
}
