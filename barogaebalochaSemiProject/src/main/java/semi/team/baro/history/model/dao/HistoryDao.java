package semi.team.baro.history.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.history.model.vo.HistoryPageData;
import semi.team.baro.mercenary.model.vo.Mercenary;
import semi.team.baro.mercenary.model.vo.MercenaryRequest;

public class HistoryDao {

	public ArrayList<Mercenary> mercenaryMyHistory(Connection conn, int memberNo, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println(memberNo+""+start+""+end);
		ArrayList<Mercenary> mcList = new ArrayList<Mercenary>();
		String query = "select * from (select rownum as rnum, n.* from(select * from mercenary join ground_tbl using(ground_no) where member_no = ? order by mercenary_no desc)n) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
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
			System.out.println(mcList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return mcList;
	}

	public int mercenaryMyHistoryCount(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from mercenary where member_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return totalCount;
	}
	

	public ArrayList<MercenaryRequest> mercenaryRequestMyHistory(Connection conn, int memberNo, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println(memberNo+""+start+""+end);
		ArrayList<MercenaryRequest> mcReqList = new ArrayList<MercenaryRequest>();
		String query = "select * from (select rownum as rnum, n.* from(select mercenary_no, game_location, game_time, game_date, mercenary_request_content, mercenary_request_result, mr.member_no, ground_name, mercenary_request_date from mercenary_request mr left join mercenary m using(mercenary_no) join ground_tbl using(ground_no) where mr.member_no = ?)n) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				//no 지역 구장이름 경기일 신청내용 신청결과
				MercenaryRequest mcReq = new MercenaryRequest();
				mcReq.setMercenaryNo(rset.getInt("mercenary_no"));
				mcReq.setGameLocation(rset.getString("game_location"));
				mcReq.setGroundName(rset.getString("ground_name"));
				mcReq.setGameDate(rset.getString("game_date"));
				mcReq.setGameTime(rset.getInt("game_time"));
				mcReq.setMercenaryRequestContent(rset.getString("mercenary_request_content"));
				mcReq.setMercenaryRequestResult(rset.getString("mercenary_request_result"));
				mcReqList.add(mcReq);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return mcReqList;
	}

	public int mercenaryRequestMyHistoryCount(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from mercenary_request where member_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return totalCount;
	}

}








