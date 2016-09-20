package project.model;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="motor_shows")
public class MotorShow {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    private String name;

    @Column(name="address", length=100)
    @NotNull(message = "Field is empty")
    @NotEmpty (message = "Field is empty")
    private String address;

    @OneToMany(mappedBy="motorShow")
    private Set<Car> cars;

    public MotorShow() {
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
