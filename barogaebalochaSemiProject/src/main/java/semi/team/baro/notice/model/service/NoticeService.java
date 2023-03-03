package semi.team.baro.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.notice.model.dao.NoticeDao;
import semi.team.baro.notice.model.vo.Notice;

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

	public ArrayList<Notice> selectAllNoticeList() {
		Connection connection = JDBCTemplate.getConnection();
		ArrayList<Notice> noticeList = NoticeDao.selectAllNoticeList(connection);
		JDBCTemplate.close(connection);
		return noticeList;
	}
	
}
