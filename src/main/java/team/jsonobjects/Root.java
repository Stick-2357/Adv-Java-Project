package team.jsonobjects;

import lombok.Data;

import java.io.Serializable;

@Data
public class Root implements Serializable {
    Route route;
    Info info;
}
