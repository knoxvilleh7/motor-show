package project.model;

import net.sf.oval.constraint.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import project.util.VinCheck;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name= "CARS", schema="registration")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name= "car_model", length=100)
    @NotNull(message = "Field is empty")
    @NotEmpty (message = "Field is empty")
    private String model;

    @Column(name= "car_production_date")
    @Temporal(value=TemporalType.DATE)
    @DateRange (max = "today", message = "Wrong date")
    @NotNull (message = "Field is empty")
    @NotEmpty (message = "Field is empty")
    private Date productionDate;

    @Column(name= "car_manufacturer", length=100)
    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    private String manufacturer;

    @Column(name= "car_manufacturer_email", length=100)
    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Email (message = "E-mail is not real")
    private String manufacturerEmail;

    @Column(name= "car_price")
    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Min(value = 0, message = "Negative value")
    private Double price;

    @Column(name= "car_engine_volume")
    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Min(value = 0, message = "Negative value")
    private Double engineVolume;

    @Column(name= "car_vin_code")
    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @CheckWith(value = VinCheck.class, message = "Car already exists")
    private String vinCode;

    @ManyToOne(fetch=FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "motor_show_id")
    private MotorShow motorShow;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getManufacturerEmail() {
        return manufacturerEmail;
    }

    public void setManufacturerEmail(String manufacturerEmail) {
        this.manufacturerEmail = manufacturerEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public MotorShow getMotorShow() {
        return motorShow;
    }

    public void setMotorShow(MotorShow motorShow) {
        this.motorShow = motorShow;
    }
}
