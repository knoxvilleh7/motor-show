package project.dao;

import project.model.MotorShow;

import java.util.List;

/**
 * Created on 15.08.2016.
 */
public interface MotorShowDao {
    String SQL_GET_ALL_MS = "SELECT * FROM motor_shows";
    String SQL_SAVE_MS = "INSERT INTO motor_shows (name, address) VALUES (?,?);";
    String SQL_UPDATE_MS = "UPDATE motor_shows SET name=?,  address=? WHERE id=?";
    String SQL_GET_MS_BY_ID = "SELECT * FROM motor_shows WHERE id=?";
    String SQL_GET_MS_BY_NAME = "SELECT * FROM motor_shows WHERE name=?";
    String SQL_DELETE_MS = "DELETE FROM motor_shows WHERE id = ?";
    
    List<MotorShow> getMotorShows();

    void saveMotorShow(MotorShow motorShow);

    MotorShow getMotorShowById(Integer id);

    MotorShow getMotorShowByName(String name);

    void deleteMotorShow(Integer id);
}
