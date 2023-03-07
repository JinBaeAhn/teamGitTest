package semi.team.baro.blacklist.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import semi.team.baro.blacklist.model.dao.BlacklistDao;
import semi.team.baro.blacklist.model.vo.Blacklist;
import semi.team.baro.blacklist.model.vo.BlacklistPageData;

public class BlacklistService {
	private BlacklistDao dao;

	public BlacklistService() {
		super();
		dao = new BlacklistDao();
	}

	public BlacklistPageData adminBlacklistList(int reqPage) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
