package semi.team.baro.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.notice.model.dao.NoticeDao;
import semi.team.baro.notice.model.vo.Notice;
import semi.team.baro.notice.model.vo.NoticePageData;

public class NoticeService {
	private NoticeDao noticeDao;

	public NoticeService() {
		super();
		noticeDao = new NoticeDao();
	}
	public int insertNotice(Notice notice) {
		Connection connection = JDBCTemplate.getConnection();
		int result = noticeDao.insertNotice(connection, notice);
		if(result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.close(connection);
		}
		JDBCTemplate.close(connection);
		return result;
	}
	public NoticePageData selectNoticeList(int noticePage) {
		Connection connection = JDBCTemplate.getConnection();
		//한 페이지 당 게시물 수 지정 -> [10]개
		int numberOfPerPage = 10;
		int end = numberOfPerPage*noticePage;
		int start = end - numberOfPerPage + 1 ;
		ArrayList<Notice> noticeList = noticeDao.selectNoticeList(connection, start, end);
		//페이징 제작을 위해 총 게시물 수가 필요함
		int totalCount = noticeDao.selectNoticeCount(connection);
		//마지막 페이지 설정
		int totalPage = (int) Math.ceil((double)totalCount/numberOfPerPage);
		//navigation size / start number setting 
		int pageNavigationSize = 5;
		//reqPage 1~5 : 1 2 3 4 5 , reqPage 6~10 6 7 8 9 10, reqPage 11~15 11 12 13 14 15
		int pageNo = ((noticePage-1)/pageNavigationSize)*pageNavigationSize+1;
		//패아자 네비게이션 제작 시작
		String pageNavigation = "<ul class = 'pagination'>";
		//이전버튼
		if(pageNo != 1) {
			pageNavigation += "<li>";
			pageNavigation += 	"<a class='page-item' href='/noticeList.do?noticePage="+(pageNo-1)+"'>";
			pageNavigation += 		"<span class='material-icons'>chevron_left</span>";
			pageNavigation += 	"</a>";
			pageNavigation += "</li>";
		}
		//page 숫자
		for(int i=0;i<pageNavigationSize;i++) {
			if(pageNo == noticePage) {
				pageNavigation += "<li>";
				pageNavigation += 	"<a class='page-item active-page' href='/noticeList.do?noticePage="+(pageNo)+"'>";
				pageNavigation += 		pageNo;
				pageNavigation += 	"</a>";
				pageNavigation += "</li>";
			} else {
				pageNavigation += "<li>";
				pageNavigation += 	"<a class='page-item' href='/noticeList.do?noticePage="+(pageNo)+"'>";
				pageNavigation += 		pageNo;
				pageNavigation += 	"</a>";
				pageNavigation += "</li>";
			}
			pageNo++;
			if(pageNo>totalPage) break;
		}
		//다음버튼
		if(pageNo <= totalPage) {
			pageNavigation += "<li>";
			pageNavigation += 	"<a class='page-item' href='/noticeList.do?noticePage="+(pageNo)+"'>";
			pageNavigation += 		"<span class='material-icons'>chevron_right</span>";
			pageNavigation += 	"</a>";
			pageNavigation += "</li>";
		}
		pageNavigation += "</ul>";
		NoticePageData noticePageData = new NoticePageData(noticeList,pageNavigation,start);
		JDBCTemplate.close(connection);
		return noticePageData;
	}
	public Notice getNotice(int noticeNo) {
		Connection connection = JDBCTemplate.getConnection();
		Notice notice = noticeDao.selectOneNotice(connection,noticeNo);
		notice.setMemberId(noticeDao.getNoticeWriter(connection, noticeNo));
		JDBCTemplate.close(connection);
		return notice;
	}
	public Notice selectOneNotice(int noticeNo) {
		Connection connection = JDBCTemplate.getConnection();
		int result = noticeDao.updateReadCount(connection,noticeNo);
		if(result > 0) {
			JDBCTemplate.commit(connection);
			Notice notice = noticeDao.selectOneNotice(connection, noticeNo);
			notice.setMemberId(noticeDao.getNoticeWriter(connection, noticeNo));
			JDBCTemplate.close(connection);
			return notice;
		} else {
			JDBCTemplate.rollback(connection);
			JDBCTemplate.close(connection);
			return null;
		}
	}
	public String getNoticeWriter(int noticeNo) {
		Connection connection = JDBCTemplate.getConnection();
		String memberId = noticeDao.getNoticeWriter(connection, noticeNo);
		JDBCTemplate.close(connection);
		return memberId;
	}
	public int removeNotice(int noticeNo) {
		Connection connection = JDBCTemplate.getConnection();
		int result = noticeDao.removeNotice(connection,noticeNo);
		if(result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}
		JDBCTemplate.close(connection);
		return result;
	}
	public int noticeUpdate(Notice notice) {
		Connection connection = JDBCTemplate.getConnection();
		int result = noticeDao.noticeUpdate(connection, notice);
		if(result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}
		JDBCTemplate.close(connection);
		return result;
	}
}
