package clempie.suivistock.model;

import java.util.Date;

/**
 * Created by pierrick on 30/03/16.
 */
public class Category {

    private int category_id;
    private String category_name;

    public Category(int id, String name) {
        this.category_id = id;
        this.category_name = name;
    }

    public int getId() {
        return category_id;
    }

    public void setId(int id) {
        this.category_id = id;
    }

    public String getName() {
        return category_name;
    }

    public void setName(String name) {
        this.category_name = name;
    }
}
