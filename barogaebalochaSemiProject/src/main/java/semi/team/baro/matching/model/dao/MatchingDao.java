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
		String query = "select * from (select rownum as rnum, n.* from (select b.matching_board_no, b.member_no, matching_board_title, read_count, b.matching_status, reg_date, b.reservation_no, ground_name, ground_location, reservation_date, reservation_time from matching_board b left join reservation res on (b.reservation_no = res.reservation_no) left join ground_tbl g on(res.ground_no=g.ground_no)order by matching_board_no desc)n) where rnum between ? and ? and ground_location is not null";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Matching m  = new Matching();
				//m.setMatchingNo(rset.getInt("matching_no"));
				m.setMatchingBoardNo(rset.getInt("matching_board_no"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setMatchingBoardTitle(rset.getString("matching_board_title"));
				m.setReadCount(rset.getInt("read_count"));
				m.setRegDate(rset.getString("reg_date"));
				m.setMatchingStatus(rset.getInt("matching_status"));
				m.setReservationNo(rset.getInt("reservation_no"));
				m.setGroundName(rset.getString("ground_name"));
				m.setGroundLocation(rset.getString("ground_location"));
				m.setReservationDate(rset.getString("reservation_date"));
				m.setReservationTime(rset.getInt("reservation_time"));
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
		String query = "select count(*) as cnt from (select rownum as rnum, n.* from (select b.matching_board_no, matching_board_title, read_count, b.matching_status, reg_date, b.reservation_no, ground_name, ground_location, reservation_date, reservation_time from matching_board b left join reservation res on (b.reservation_no = res.reservation_no) left join ground_tbl g on(res.ground_no=g.ground_no)order by matching_board_no desc)n) where rnum between 1 and 10 and ground_location is not null";
		
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

	public int matchingListInsert(Connection conn, int reservationNo, Matching mc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="insert into matching_board values(matching_board_seq.nextval,?,?,?,to_char(sysdate,'yyyy-mm-dd/hh24:mi:ss'),0,1,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mc.getMemberNo());
			pstmt.setString(2, mc.getMatchingBoardTitle());
			pstmt.setString(3, mc.getMatchingBoardContent());
			pstmt.setInt(4,mc.getGroundNo());
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
	public int reservationInsert(Connection conn, Matching mc) {
		PreparedStatement pstmt = null;
		int result = 0 ;
		String query = "insert into reservation values(reservation_seq.nextval,?,?,?,?,0)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mc.getMemberNo());
			pstmt.setInt(2, mc.getGroundNo());
			pstmt.setInt(3, mc.getReservationTime());
			pstmt.setString(4, mc.getReservationDate());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Matching groundSearch(Connection conn, Matching mc) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		int groundNo = 0;
		//System.out.println(mc.getGroundName()+"구장이름");
		String query = "select ground_no,ground_price from ground_tbl where ground_name like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mc.getGroundName());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mc.setGroundNo(rset.getInt("ground_no"));
				mc.setGroundPrice(rset.getInt("ground_price"));
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mc;
	}

	public int getReservationNo(Connection conn, Matching mc) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int reservationNo = 0;
		String query = "select reservation_no from reservation where member_no=? and ground_no=? and reservation_time=? and reservation_date=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mc.getMemberNo());
			pstmt.setInt(2, mc.getGroundNo());
			pstmt.setInt(3, mc.getReservationTime());
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
		String query= "select b.member_no, b.matching_board_no, matching_board_title, matching_board_content, b.matching_status, reg_date, b.reservation_no, ground_name, ground_location, reservation_date, reservation_time, ground_price from matching_board b left join reservation res on (b.reservation_no = res.reservation_no) left join ground_tbl g on(res.ground_no=g.ground_no)  where b.reservation_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reservationNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mc = new Matching();
				mc.setMemberNo(rset.getInt("member_no"));
				mc.setMatchingBoardNo(rset.getInt("matching_board_no"));
				mc.setMatchingBoardTitle(rset.getString("matching_board_title"));
				mc.setMatchingBoardContent(rset.getString("matching_board_content"));
				mc.setMatchingStatus(rset.getInt("matching_status"));
				mc.setRegDate(rset.getNString("reg_date"));
				mc.setReservationNo(rset.getInt("reservation_no"));
				mc.setGroundName(rset.getString("ground_name"));
				mc.setGroundLocation(rset.getString("ground_location"));
				mc.setReservationDate(rset.getString("reservation_date"));
				mc.setReservationTime(rset.getInt("reservation_time"));
				mc.setGroundPrice(rset.getInt("ground_price"));
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

	public int matchingMemberInsert(Connection conn, int matchingBoardNo, int memberNo) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = "insert into matching_request values(matching_request_seq.nextval, 1, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, matchingBoardNo);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int searchApplyMember(Connection conn, int matchingBoardNo, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		int memberCheck = 0;
		String query = "select count(*) as cnt from matching_request where matching_board_no=? and member_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, matchingBoardNo);
			pstmt.setInt(2, memberNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("cnt");
				if(result>0) {
					memberCheck=1;
				}else {
					memberCheck=0;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return memberCheck;
	}

	public ArrayList<Matching> selectMatchingMemberList(Connection conn, int start, int end, int matchingBoardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Matching> list = new ArrayList<Matching>();
		String query = "select * from (select rownum as rnum, n.* from (select r.matching_board_no, r.member_no, member_name, member_phone, member_mail, matching_request_status from matching_request r left join member_tbl m on(r.member_no=m.member_no) where matching_board_no = ? and r.member_no is not null order by r.member_no desc)n) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, matchingBoardNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			//System.out.println("매칭보드"+matchingBoardNo);
			//System.out.println("스타트"+start);
			//System.out.println("엔드"+end);
			
			
			while(rset.next()) {
				Matching mc = new Matching();
				mc.setMatchingBoardNo(rset.getInt("matching_board_no"));
				mc.setMemberNo(rset.getInt("member_no"));
				mc.setMemberName(rset.getString("member_name"));
				mc.setMemberPhone(rset.getString("member_phone"));
				mc.setMemberMail(rset.getString("member_mail"));
				mc.setMatchingRequestStatus(rset.getInt("matching_request_status"));
				list.add(mc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("리스트사이즈 체크"+list.size());
		return list;
	}

	public int selectMatchingMemberListCount(Connection conn, int matchingBoardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from (select r.matching_board_no, r.member_no, member_phone, member_mail, matching_request_status from matching_request r left join member_tbl m on(r.member_no=m.member_no) where matching_board_no = ? and r.member_no is not null order by r.member_no desc)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, matchingBoardNo);
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
		System.out.println("토탈 카운트 체크"+totalCount);
		return totalCount;
		
	}

	public int applyInsert(Connection conn, int memberNo, int matchingBoardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="update matching_request set matching_request_status = 2 where matching_board_no=? and member_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, matchingBoardNo);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int applyCancel(Connection conn, int memberNo, int matchingBoardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="update matching_request set matching_request_status = 1 where matching_board_no=? and member_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, matchingBoardNo);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int applyInsert2(Connection conn, int matchingBoardNo) {
		PreparedStatement pstmt = null;
		int result2 = 0;
		String query="update matching_board set matching_status = 2 where matching_board_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, matchingBoardNo);
			result2 = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result2;
	}

	public int applyCancel2(Connection conn, int matchingBoardNo) {
		PreparedStatement pstmt = null;
		int result2 = 0;
		String query="update matching_board set matching_status = 1 where matching_board_no=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, matchingBoardNo);
			result2 = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result2;
	}

	public int payCredit(Connection conn, Matching mc) {
		PreparedStatement pstmt = null;
		int payResult = 0;
		String query="update member_tbl set member_credit=member_credit-? where member_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mc.getGroundPrice());
			pstmt.setInt(2, mc.getMemberNo());
			payResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payResult;
	}
}
