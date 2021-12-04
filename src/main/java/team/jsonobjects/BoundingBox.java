package team.jsonobjects;

import lombok.Data;

import java.io.Serializable;

@Data
public class BoundingBox implements Serializable {
    Lr lr;
    Ul ul;
}
