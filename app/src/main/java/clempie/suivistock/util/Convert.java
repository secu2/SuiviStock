package clempie.suivistock.util;

/**
 * Created by pierrick on 30/03/16.
 */
public class Convert {

    public static java.sql.Date convertDate(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

}
