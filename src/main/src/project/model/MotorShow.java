package project.model;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import java.util.Set;

public class MotorShow {

    private Integer id;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    private String name;

    @NotNull(message = "Field is empty")
    @NotEmpty (message = "Field is empty")
    private String address;

    private Set<Car> cars;

    public MotorShow() {
    }

    public MotorShow(String name, String address, Set<Car> cars) {
        this.name = name;
        this.address = address;
        this.cars = cars;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
