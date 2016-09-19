package project.model;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * Created on 15.08.2016.
 */
public class MotorShow {

    private Integer id;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    private String name;

    @NotNull(message = "Field is empty")
    @NotEmpty (message = "Field is empty")
    private String address;

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
