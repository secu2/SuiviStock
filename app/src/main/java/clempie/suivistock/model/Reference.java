package clempie.suivistock.model;

/**
 * Created by pierrick on 23/03/16.
 */
public class Reference {

    private int reference_id;
    private String reference_name;

    public Reference(int id, String name) {
        this.reference_id = id;
        this.reference_name = name;
    }

    public int getId() {
        return reference_id;
    }

    public void setId(int id) {
        this.reference_id = id;
    }

    public String getName() {
        return reference_name;
    }

    public void setName(String name) {
        this.reference_name = name;
    }
}
