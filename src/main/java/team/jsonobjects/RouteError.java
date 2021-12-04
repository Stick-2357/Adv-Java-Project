package team.jsonobjects;

import lombok.Data;

import java.io.Serializable;

@Data
public class RouteError implements Serializable {
    int errorCode;
    String message;
}
