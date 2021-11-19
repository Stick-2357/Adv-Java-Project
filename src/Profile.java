public class Profile {
    public String name;
    public String emergencyNum;
    public String email;
    public String address;

    public Profile(String name, String emergencyNum, String email, String address) {
        this.name = name;
        this.emergencyNum = emergencyNum;
        this.email = email;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmergencyNum(String emergencyNum) {
        this.emergencyNum = emergencyNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
