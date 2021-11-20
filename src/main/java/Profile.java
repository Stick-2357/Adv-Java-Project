import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Profile {
    public String name;
    public String emergencyNum;
    public String email;
    public String address;
}
