package ltm.caro.server.database;

import ltm.caro.server.entity.Player;


public interface IPlayerDAO extends GenericDAO<Integer, Player>
{
    Player findByAccount(String account);
    Player findByEmail(String email);
}
