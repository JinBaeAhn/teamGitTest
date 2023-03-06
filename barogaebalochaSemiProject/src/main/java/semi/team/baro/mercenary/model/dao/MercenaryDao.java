package semi.team.baro.mercenary.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.mercenary.model.vo.Mercenary;
import semi.team.baro.mercenary.model.vo.MercenaryRequest;

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
		String query = "select * from (select rownum as rnum, n.* from(select * from mercenary join ground_tbl using(ground_no) order by 1 desc)n) where rnum between ? and ?";
		
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
				mc.setGroundLocation(rset.getString("ground_location"));
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
		String query = "select * from mercenary join member_tbl using(member_no) join ground_tbl using(ground_no) where mercenary_no = ?";
		
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
				mc.setGroundLocation(rset.getString("ground_location"));
				mc.setGroundLat(rset.getString("ground_lat"));
				mc.setGroundLng(rset.getString("ground_lng"));
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

	public int mercenaryUpdate(Connection conn, Mercenary mc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update mercenary set game_location = ?, game_ground_name = ?, game_date = ?, game_time = ?, mercenary_content = ?, mercenary_pay = ?, skill = ? where mercenary_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mc.getLocation());
			pstmt.setString(2, mc.getGroundName());
			pstmt.setString(3, mc.getGameDate());
			pstmt.setInt(4, mc.getGameTime());
			pstmt.setString(5, mc.getMercenaryContent());
			pstmt.setInt(6, mc.getMercenaryPay());
			pstmt.setInt(7, mc.getLevel());
			pstmt.setInt(8, mc.getMercenaryNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int mercenaryRequestInsert(Connection conn, MercenaryRequest mcReq) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into mercenary_request values(mercenary_request_seq.nextval, ?, ?, ?, 0, to_char(sysdate, 'yyyy-mm-dd HH24:MI:SS'), 0)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mcReq.getMercenaryNo());
			pstmt.setInt(2, mcReq.getMemberNo());
			pstmt.setString(3, mcReq.getMercenaryRequestContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<MercenaryRequest> mercenaryRequestList(Connection conn, int mercenaryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MercenaryRequest> list = new ArrayList<MercenaryRequest>();
		String query = "select mercenary_request_no, mercenary_no, member_no, mercenary_request_content, skill, mercenary_request_date, mercenary_request_result, member_id from mercenary_request join member_tbl using(member_no) where mercenary_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mercenaryNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				MercenaryRequest mcReq = new MercenaryRequest();
				mcReq.setLevel(rset.getInt("skill"));
				mcReq.setMemberId(rset.getString("member_id"));
				mcReq.setMemberNo(rset.getInt("member_no"));
				mcReq.setMercenaryNo(rset.getInt("mercenary_no"));
				mcReq.setMercenaryRequestContent(rset.getString("mercenary_request_content"));
				mcReq.setMercenaryRequestDate(rset.getString("mercenary_request_date"));
				mcReq.setMercenaryRequestResult(rset.getString("mercenary_request_result"));
				mcReq.setMercenaryRequestNo(rset.getInt("mercenary_request_no"));
				list.add(mcReq);
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

	public int mercenaryRequestDelete(Connection conn, int mcReqNo, int mercenaryNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from mercenary_request where mercenary_request_no = ? and mercenary_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mcReqNo);
			pstmt.setInt(2, mercenaryNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int mercenaryRequestUpdate(Connection conn, MercenaryRequest mcReq) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update mercenary_request set mercenary_request_content = ? where mercenary_request_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mcReq.getMercenaryRequestContent());
			pstmt.setInt(2, mcReq.getMercenaryRequestNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int mercenaryRequestResultAllUpdate(Connection conn, MercenaryRequest mcReq) {
		PreparedStatement pstmt = null;
		int result = 0;
		//1. mercenary_request 테이블의 mercenary_request_result를 전부 1로변경(where mercenaryNo = ?)에 해당하는것만
		String query = "update mercenary_request set mercenary_request_result = 1 where mercenary_no = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mcReq.getMercenaryNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int mercenaryRequestResultSelUpdate(Connection conn, MercenaryRequest mcReq) {		
		PreparedStatement pstmt = null;
		int result = 0;
		//2. mercenary_request 테이블의 mercenary_request_result를 해당 request를 작성한 아이디로 update
		String query = "update mercenary_request set mercenary_request_result = ? where mercenary_request_no = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mcReq.getMemberId());
			pstmt.setInt(2, mcReq.getMercenaryRequestNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int mercenaryWhetherUpdate(Connection conn, MercenaryRequest mcReq) {
		PreparedStatement pstmt = null;
		int result = 0;
		//3. mercenary 테이블의 mercenaryWhether를 0에서 1로변경(모집중 -> 모집완료)
		String query = "update mercenary set mercenary_whether = 1 where mercenary_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mcReq.getMercenaryNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int mercenaryRequestResultAllCancleUpdate(Connection conn, MercenaryRequest mcReq) {
		PreparedStatement pstmt = null;
		int result = 0;
		//1. mercenary_request 테이블의 mercenary_request_result를 전부 1로변경(where mercenaryNo = ?)에 해당하는것만
		String query = "update mercenary_request set mercenary_request_result = 0 where mercenary_no = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mcReq.getMercenaryNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int mercenaryRequestResultCancleUpdate(Connection conn, MercenaryRequest mcReq) {
		PreparedStatement pstmt = null;
		int result = 0;
		//3. mercenary 테이블의 mercenaryWhether를 0에서 1로변경(모집중 -> 모집완료)
		String query = "update mercenary set mercenary_whether = 0 where mercenary_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mcReq.getMercenaryNo());
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








