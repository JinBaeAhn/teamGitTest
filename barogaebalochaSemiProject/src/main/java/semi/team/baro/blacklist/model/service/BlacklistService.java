package semi.team.baro.blacklist.model.service;

import semi.team.baro.blacklist.model.dao.BlacklistDao;

public class BlacklistService {
	private BlacklistDao dao;

	public BlacklistService() {
		super();
		dao = new BlacklistDao();
	}
	
}
