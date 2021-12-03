package team.requests;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class AbstractRequest implements Serializable {
    String requestName;
}
