package clempie.suivistock.model;

/**
 * Created by pierrick on 23/03/16.
 */
public class Box {

    private int box_id;
    private String box_name;
    private String box_place;

    public Box(int id, String name) {
        this.box_id = id;
        this.box_name = name;
    }

    public int getId() {
        return box_id;
    }

    public void setId(int id) {
        this.box_id = id;
    }

    public String getName() {
        return box_name;
    }

    public void setName(String name) {
        this.box_name = name;
    }
}
