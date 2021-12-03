package team.jsonobjects;

import lombok.Data;

import java.util.List;

@Data
public class Info {
    int statuscode;
    Copyright copyright;
    List<Object> messages;
}