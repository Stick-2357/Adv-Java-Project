package team.jsonobjects;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Info implements Serializable {
    int statuscode;
    Copyright copyright;
    List<Object> messages;
}
