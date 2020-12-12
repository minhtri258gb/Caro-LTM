package ltm.caro.server.database.impl;

import ltm.caro.server.database.IRoomDAO;
import ltm.caro.server.entity.Room;

public class RoomDAO extends AbstracDAO<Integer, Room> implements IRoomDAO
{
    @Override
    public Room findByMaMH() {
        return null;
    }
}
