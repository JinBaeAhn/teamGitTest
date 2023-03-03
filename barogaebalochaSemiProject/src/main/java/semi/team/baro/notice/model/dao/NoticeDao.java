package semi.team.baro.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
