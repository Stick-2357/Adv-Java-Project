import lombok.Data;

@Data
public class Profile {
    public Integer id;
    public String name;
    public String emergencyNum;
    public String email;
    public String address;

    public Profile(Integer id, String name, String emergencyNum, String email, String address) {
        this.id = id;
        this.name = name;
        this.emergencyNum = emergencyNum;
        this.email = email;
        this.address = address;
    }

    public Profile() {

    }
}
