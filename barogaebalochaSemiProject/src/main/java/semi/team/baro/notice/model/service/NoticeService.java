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
		ArrayList<Notice> noticeList = noticeDao.selectAllNoticeList(connection);
		JDBCTemplate.close(connection);
		return noticeList;
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
