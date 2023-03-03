package semi.team.baro.location.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.location.model.dao.LocationDao;
import semi.team.baro.location.model.vo.Location;
import semi.team.baro.location.model.vo.LocationPageData;
import semi.team.baro.location.model.vo.LocationViewData;

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
		//전체 페이지 수 계산
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage+1;
		}
		//네비게이션 사이즈
		int pageNaviSize = 5;
		
		//페이지네비게이션 시작번호
		//reqPage 1~5 : 1 2 3 4 5 = 1
		//reqPage 6~10 : 6 7 8  9 10 = 2
		//reqPage 11~15 : 11 12 13 14 15 = 3
		
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		
		//페이지 네비게이션 제작 시작
		String pageNavi = "<ul class='pagination circle-style'>";
		//이전버튼
		if(pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/locationList.do?requestPage="+(pageNo-1)+"'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}
		//페이지 숫자
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/locationList.do?requestPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/locationList.do?requestPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		//다음버튼
		if(pageNo <= totalPage) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/locationList.do?requestPage="+(pageNo)+"'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";
		
		JDBCTemplate.close(conn);
		LocationPageData lpd = new LocationPageData(list, pageNavi, start);
		
		return lpd;
	}

	public LocationViewData selectOneLocation(int groundNo) {
		Connection conn = JDBCTemplate.getConnection();
		Location l = dao.selectOneLocation(conn, groundNo);
		LocationViewData lvd = new LocationViewData(l);
		JDBCTemplate.close(conn);
		return lvd;
	}
	
}
