package ltm.caro.server.database.impl;

import ltm.caro.server.database.IPlayerDAO;
import ltm.caro.server.entity.Player;


public class PlayerDAO extends AbstracDAO<Integer, Player> implements IPlayerDAO
{
	@Override
	public Player findByAccount(String account)
	{
		return findEqualUnique("account", account);
	}

	@Override
	public Player findByEmail(String email)
	{
		return findEqualUnique("email", email);
	}
}
