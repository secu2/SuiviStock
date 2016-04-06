package clempie.suivistock.model;

import java.util.Date;

/**
 * Created by pierrick on 30/03/16.
 */
public class Content {

    private int content_id;
    private int content_quantity;
    private Date content_date;
    private Box content_box;
    private Reference content_reference;

    public Content(int id, int quantity, Date date, Box box, Reference reference) {
        this.content_id = id;
        this.content_quantity = quantity;
        this.content_date = date;
        this.content_box = box;
        this.content_reference = reference;
    }

    public int getId() {
        return content_id;
    }

    public void setId(int id) {
        this.content_id = id;
    }

    public int getQuantity() {
        return content_quantity;
    }

    public void setQuantity(int quantity) {
        this.content_quantity = quantity;
    }

    public Date getDate() {
        return content_date;
    }

    public void setDate(Date content_date) {
        this.content_date = content_date;
    }

    public Box getBox() {
        return content_box;
    }

    public void setBox(Box content_box) {
        this.content_box = content_box;
    }

    public Reference getReference() {
        return content_reference;
    }

    public void setReference(Reference content_reference) {
        this.content_reference = content_reference;
    }
}
