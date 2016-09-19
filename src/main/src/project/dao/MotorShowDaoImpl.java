package project.dao;

import project.model.MotorShow;
import project.util.DBconnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static project.constants.MotorShowConst.*;

/**
 * Created on 15.08.2016.
 */
public class MotorShowDaoImpl implements MotorShowDao {
    public List<MotorShow> getMotorShows() {
        List<MotorShow> mShows = new ArrayList<MotorShow>();
        Statement statement;
        Connection connection = DBconnect.connCreate();
        ResultSet resultSet;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_GET_ALL_MS);
            while (resultSet.next()) {
                MotorShow motorShow = new MotorShow();
                motorShow.setId(resultSet.getInt(MID));
                motorShow.setName(resultSet.getString(NAME));
                motorShow.setAddress(resultSet.getString(ADDRESS));
                mShows.add(motorShow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconnect.connClose(connection);
        }
        return mShows;
    }

    public void saveMotorShow(MotorShow motorShow) {
        Connection connection = DBconnect.connCreate();
        PreparedStatement preparedStatement;
        if (motorShow.getId() == null) {
            try {
                preparedStatement = connection.prepareStatement(SQL_SAVE_MS);
                preparedStatement.setString(1, motorShow.getName());
                preparedStatement.setString(2, motorShow.getAddress());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBconnect.connClose(connection);
            }
        } else {
            try {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_MS);
                preparedStatement.setString(1, motorShow.getName());
                preparedStatement.setString(2, motorShow.getAddress());
                preparedStatement.setInt(3, motorShow.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBconnect.connClose(connection);
            }
        }
    }

    public MotorShow getMotorShowById(Integer id) {
        Connection connection = DBconnect.connCreate();
        PreparedStatement preparedStatement;
        MotorShow motorShow = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_GET_MS_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            motorShow = new MotorShow();
            motorShow.setId(resultSet.getInt(MID));
            motorShow.setName(resultSet.getString(NAME));
            motorShow.setAddress(resultSet.getString(ADDRESS));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconnect.connClose(connection);
        }
        return motorShow;
    }

    public MotorShow getMotorShowByName(String name) {
        Connection connection = DBconnect.connCreate();
        PreparedStatement preparedStatement;
        MotorShow motorShow = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_GET_MS_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            motorShow = new MotorShow();
            motorShow.setId(resultSet.getInt(MID));
            motorShow.setName(resultSet.getString(NAME));
            motorShow.setAddress(resultSet.getString(ADDRESS));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconnect.connClose(connection);
        }
        return motorShow;
    }


    public void deleteMotorShow(Integer mid) {
        Connection connection = DBconnect.connCreate();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_MS);
            preparedStatement.setInt(1, mid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconnect.connClose(connection);
        }


    }
}
