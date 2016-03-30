package clempie.suivistock.model;

import java.util.Date;

/**
 * Created by pierrick on 30/03/16.
 */
public class Content {

    private int content_id;
    private int content_quantity;
    private Date content_date;

    public Content(int id, int quantity, Date date) {
        this.content_id = id;
        this.content_quantity = quantity;
        this.content_date = date;
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
}
