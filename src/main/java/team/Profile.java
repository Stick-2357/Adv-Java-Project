package team;

import lombok.Data;

import java.io.Serializable;

/**
 * Semester Project
 * Description: Profile object to store information for each child
 */

@Data
public class Profile implements Serializable {
    public Integer id;
    public String name;
    public String emergencyNum;
    public String email;
    public String address;

    //Main constructor
    public Profile(Integer id, String name, String emergencyNum, String email, String address) {
        this.id = id;
        this.name = name;
        this.emergencyNum = emergencyNum;
        this.email = email;
        this.address = address;
    }

    //Default constructor
    public Profile() {

    }
}
