package lesson35.repository;

import lesson35.UserType;
import lesson35.model.Room;
import lesson35.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class RoomRepository extends Repository<Room> {

    @Override
    public long[] readIdFromFile(String path) {
        return super.readIdFromFile(path);
    }

    @Override
    public void delete(long id, String path) {
        super.delete(id, path);
    }

    @Override
    public void writeDataToFile(StringBuffer data, boolean append, String path) {
        super.writeDataToFile(data, append, path);
    }

    @Override
    boolean validateId(long id, String path) {
        return super.validateId(id, path);
    }


    StringBuffer readRoomData(Room room) {
        StringBuffer roomData = new StringBuffer();

        roomData.append(room.getId() + "," + " ");
        roomData.append(room.getNumberOfGuests() + "," + " ");
        roomData.append(room.getPrice() + "," + " ");
        roomData.append(room.isBreakfastIncluded() + "," + " ");
        roomData.append(room.isPetsAllowed() + ", ");
        roomData.append(room.getDateAvailableFrom() + ", ");
        roomData.append(room.getHotel());



        return roomData;
    }


//    Room addRoom(Room room, String path) throws Exception {
//
//        if (!validateId(room.getId(), path)) throw new Exception("Room with id " + room.getId() + " already exists");
//
//
//        writeDataToFile(readRoomData(room), true, path);
//
//
//
//        return room;
//    }

    @Override
    public Room add(Room room, String path) throws Exception {
        if (!validateId(room.getId(), path)) throw new Exception("Room with id " + room.getId() + " already exists");


        writeDataToFile(readRoomData(room), true, path);



        return room;
    }

    @Override
    public Room findById(long id, String path) {
        return null;
    }
}
