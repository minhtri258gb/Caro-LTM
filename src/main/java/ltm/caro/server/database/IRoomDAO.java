package ltm.caro.server.database;

import ltm.caro.server.entity.Room;

public interface IRoomDAO extends GenericDAO<Integer, Room>
{
    Room findByMaMH();
}
