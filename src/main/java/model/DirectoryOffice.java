package model;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "directory_office")
public class DirectoryOffice {
    @Id
    @Column(name = "directory_id", nullable = false)
    private Long directoryId;

    @Column(name = "directory_name", nullable = false, length = 250)
    private String directoryName;

    @Column(name = "address_line", nullable = false, length = 250)
    private String addressLine;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @Column(name = "state", nullable = false, length = 100)
    private String state;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "zone", nullable = false, length = 100)
    private String zone;

    @Column(name = "phone", nullable = false)
    private Long phone;

    @Column(name = "phone_2", nullable = false)
    private Long phone2;

    @Column(name = "created_at", nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    public DirectoryOffice() {
    }

    public DirectoryOffice(Long directoryId, String directoryName, String addressLine, String country, String state, String city, String zone, Long phone, Long phone2, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.directoryId = directoryId;
        this.directoryName = directoryName;
        this.addressLine = addressLine;
        this.country = country;
        this.state = state;
        this.city = city;
        this.zone = zone;
        this.phone = phone;
        this.phone2 = phone2;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Long getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(Long id) {
        this.directoryId = id;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getPhone2() {
        return phone2;
    }

    public void setPhone2(Long phone2) {
        this.phone2 = phone2;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}