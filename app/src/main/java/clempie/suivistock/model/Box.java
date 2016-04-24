package clempie.suivistock.model;

import java.io.Serializable;

/**
 * Created by pierrick on 23/03/16.
 */
public class Box  implements Serializable {

    private long box_id;
    private String box_name;

    public Box(int id, String name) {
        this.box_id = id;
        this.box_name = name;
    }

    public long getId() {
        return box_id;
    }

    public void setId(long id) {
        this.box_id = id;
    }

    public String getName() {
        return box_name;
    }

    public void setName(String name) {
        this.box_name = name;
    }

    @Override
    public String toString() {
        return "Box{" +
                "box_id=" + box_id +
                ", box_name='" + box_name + '\'' +
                '}';
    }
}
