package Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.HobbyGroupElements;

@Dao
public interface HobbyDAO {
    @Insert
    public long addHobby(HobbyGroupElements hobby);
    @Update
    public  void updateHobby(HobbyGroupElements hobby);
    @Delete
    public void delteHobby(HobbyGroupElements hobby);
    @Query("select * from hobbies")
    public List<HobbyGroupElements> getAllHobbies();
    @Query("select * from hobbies where id ==:hobbyId ")
    public HobbyGroupElements getHobby(long hobbyId);
}
