package team.jsonobjects;

import lombok.Data;

import java.io.Serializable;

@Data
public class Sign implements Serializable {
    String extraText;
    String text;
    int type;
    String url;
    int direction;
}
