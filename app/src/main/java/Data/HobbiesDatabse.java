package Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import Model.HobbyGroupElements;

@Database(entities = {HobbyGroupElements.class}, version = 1)
public abstract class HobbiesDatabse extends RoomDatabase {
    public abstract HobbyDAO getHobbyDao();
}
