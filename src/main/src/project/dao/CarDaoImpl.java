package project.dao;

import project.model.Car;
import project.util.DBconnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static project.constants.CarConst.*;

/**
 * Created on 15.08.2016.
 */
public class CarDaoImpl implements CarDao {
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<Car>();
        Statement statement;
        Connection connection = DBconnect.connCreate();
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_GET_ALL_CARS);
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt(ID));
                car.setModel(resultSet.getString(MODEL));
                car.setProductionDate(resultSet.getString(PD));
                car.setManufacturerEmail(resultSet.getString(MEMAIL));
                car.setMotorShowId(resultSet.getInt(MSID));
                car.setManufacturer(resultSet.getString(MANUFACTURER));
                car.setPrice(resultSet.getDouble(PRICE));
                car.setEngineVolume(resultSet.getDouble(EVOL));
                car.setVinCode(resultSet.getString(VIN));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconnect.connClose(connection);
        }
        return cars;
    }

    public void saveCar(Car car) {
        Connection connection = DBconnect.connCreate();
        PreparedStatement preparedStatement;
        if (car.getId() == null) {
            try {
                preparedStatement = connection.prepareStatement(SQL_SAVE_CAR);
                preparedStatement.setString(1, car.getModel());
                preparedStatement.setString(2, car.getManufacturerEmail());
                preparedStatement.setString(3, car.getProductionDate());
                preparedStatement.setInt(4, car.getMotorShowId());
                preparedStatement.setString(5, car.getManufacturer());
                preparedStatement.setDouble(6, car.getPrice());
                preparedStatement.setDouble(7, car.getEngineVolume());
                preparedStatement.setString(8, car.getVinCode());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBconnect.connClose(connection);
            }
        } else {
            try {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_CAR);
                preparedStatement.setString(1, car.getModel());
                preparedStatement.setString(2, car.getManufacturerEmail());
                preparedStatement.setString(3, car.getProductionDate());
                preparedStatement.setInt(4, car.getMotorShowId());
                preparedStatement.setInt(5, car.getId());
                preparedStatement.setString(6, car.getManufacturer());
                preparedStatement.setDouble(7, car.getPrice());
                preparedStatement.setDouble(8, car.getEngineVolume());
                preparedStatement.setString(9, car.getVinCode());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBconnect.connClose(connection);
            }
        }
    }

    public Car getCarById(Integer id) {
        Connection connection = DBconnect.connCreate();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Car car = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_GET_CAR_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getInt(ID));
                car.setModel(resultSet.getString(MODEL));
                car.setProductionDate(resultSet.getString(PD));
                car.setManufacturerEmail(resultSet.getString(MEMAIL));
                car.setMotorShowId(resultSet.getInt(MSID));
                car.setManufacturer(resultSet.getString(MANUFACTURER));
                car.setPrice(resultSet.getDouble(PRICE));
                car.setEngineVolume(resultSet.getDouble(EVOL));
                car.setVinCode(resultSet.getString(VIN));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconnect.connClose(connection);
        }
        return car;
    }

    public Car getCarByVin(Integer vin) {
        Connection connection = DBconnect.connCreate();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Car car = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_GET_CAR_BY_VIN);
            preparedStatement.setInt(1, vin);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getInt(ID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconnect.connClose(connection);
        }
        return car;
    }

    public void deleteCar(Integer id) {
        Connection connection = DBconnect.connCreate();
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_CAR);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconnect.connClose(connection);
        }
    }

    public List<Car> getCarsByMSId(Integer msid) {
        List<Car> cars = new ArrayList<Car>();
        PreparedStatement preparedStatement;
        Connection connection = DBconnect.connCreate();
        Car car;
        try {
            preparedStatement = connection.prepareStatement(SQL_GET_CARS_BY_MSID);
            preparedStatement.setInt(1, msid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getInt(ID));
                car.setModel(resultSet.getString(MODEL));
                car.setProductionDate(resultSet.getString(PD));
                car.setManufacturerEmail(resultSet.getString(MEMAIL));
                car.setMotorShowId(resultSet.getInt(MSID));
                car.setManufacturer(resultSet.getString(MANUFACTURER));
                car.setPrice(resultSet.getDouble(PRICE));
                car.setEngineVolume(resultSet.getDouble(EVOL));
                car.setVinCode(resultSet.getString(VIN));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBconnect.connClose(connection);
        }
        return cars;

    }
}
