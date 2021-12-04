package team.jsonobjects;

import lombok.Data;

import java.io.Serializable;

@Data
public class Copyright implements Serializable {
    String imageAltText;
    String imageUrl;
    String text;
}
