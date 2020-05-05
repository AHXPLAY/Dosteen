package Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "hobbies")
public class HobbyGroupElements {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String nameOfHobby;

    @ColumnInfo(name = "class")
    private String classOfHobby;

    @ColumnInfo(name = "workdays")
    private String workDays;

    @ColumnInfo(name = "location")
    private String location;

    @ColumnInfo(name = "teacher")
    private String teacher;

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Ignore
    public HobbyGroupElements() {

    }

    public HobbyGroupElements(int id, String nameOfHobby, String classOfHobby, String workDays, String location, String teacher) {
        this.id = id;
        this.nameOfHobby = nameOfHobby;
        this.classOfHobby = classOfHobby;
        this.workDays = workDays;
        this.location = location;
        this.teacher = teacher;
    }
    @Ignore
    public HobbyGroupElements(String nameOfHobby, String classOfHobby, String workDays, String location, String  teacher) {
        this.nameOfHobby = nameOfHobby;
        this.classOfHobby = classOfHobby;
        this.workDays = workDays;
        this.location = location;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfHobby() {
        return nameOfHobby;
    }

    public void setNameOfHobby(String nameOfHobby) {
        this.nameOfHobby = nameOfHobby;
    }

    public String getClassOfHobby() {
        return classOfHobby;
    }

    public void setClassOfHobby(String classOfHobby) {
        this.classOfHobby = classOfHobby;
    }

    public String getWorkDays() {
        return workDays;
    }

    public void setWorkDays(String workDays) {
        this.workDays = workDays;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
