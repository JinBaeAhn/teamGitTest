package semi.team.baro.location.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.location.model.dao.LocationDao;
import semi.team.baro.location.model.vo.Location;
import semi.team.baro.location.model.vo.LocationPageData;

public class LocationService {
	private LocationDao dao;
	
	public LocationService() {
		super();
		dao =  new LocationDao();
		// TODO Auto-generated constructor stub
	}

	public LocationPageData selectLocationList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		//1.페이지당 게시물은 4개
		int numPerPage = 4;
		//1.요청페이지가 1페이지 -> 최신글 1~4
		//reqPage가 2페이지면 -> 최신글 5~8
		//reqPage가 3페이지면 -> 최신글 9~12
		//reqPage == 4 -> 13~16
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;
		
		ArrayList<Location> list = dao.selectLocationList(conn, start, end);
		//페이징제작 시작
		//전체 페이지 수를 계산 -> 총 게시물 수를 조회
		int totalCount = dao.selectLocationCount(conn);
		
		
		return null;
	}
	
}
