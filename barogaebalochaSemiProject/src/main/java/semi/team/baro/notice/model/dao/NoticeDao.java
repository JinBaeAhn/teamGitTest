package semi.team.baro.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.notice.model.vo.Notice;

public class NoticeDao {

	public int insertNotice(Connection connection, Notice notice) {
		PreparedStatement preparedStatement = null;
		String query = "insert into notice values(notice_seq.nextval,?,?,?,?,0,(TO_CHAR(SYSDATE,'YYYY-MM-DD/HH24:MI:SS')))";
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, notice.getMemberNo());
			preparedStatement.setString(2, notice.getNoticeCategory());
			preparedStatement.setString(3, notice.getNoticeTitle());
			preparedStatement.setString(4, notice.getNoticeContent());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
		}
		return result;
	}
	public static ArrayList<Notice> selectAllNoticeList(Connection connection) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select notice_no, member_id, notice_category, notice_title, notice_content, read_count, reg_date from notice join member_tbl using(member_no) order by 1 desc";
		ArrayList<Notice> noticeList = new ArrayList<Notice>();
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				int noticeNo = resultSet.getInt(1);
				String memberId = resultSet.getString(2);
				String noticeCategory = resultSet.getString(3);
				String noticeTitle = resultSet.getString(4);
				String noticeContent = resultSet.getString(5);
				int readCount = resultSet.getInt(6);
				String regDate = resultSet.getString(7);
				Notice notice = new Notice(noticeNo, noticeCategory, noticeTitle, noticeContent, readCount, regDate, memberId);
				noticeList.add(notice);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
			JDBCTemplate.close(resultSet);
		}
		return noticeList;
	}

}
