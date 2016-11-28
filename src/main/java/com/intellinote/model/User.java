package model;

import javax.persistence.*;

/**
 * Created by shashankbhardwaj on 26/11/16.ss
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer UserId;

    @Column(name = "first_name")
    private String  firstName;

    @Column(name = "last_name")
    private String  lastName;

    @Column(name = "email")
    private String  Email;

    @Column(name = "phone")
    private Long    phone;

    @Column(name = "psswd_id")
    private int psswdId;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return UserId.equals(user.UserId);

    }

    @Override
    public int hashCode() {
        return UserId.hashCode();
    }

    public int getPsswdId() {

        return psswdId;
    }

    public void setPsswdId(int psswdId) {
        this.psswdId = psswdId;
    }

}
