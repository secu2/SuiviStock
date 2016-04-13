package clempie.suivistock.util;

import android.content.Context;
import android.util.Log;

import java.util.Date;

import clempie.suivistock.model.Box;
import clempie.suivistock.model.Category;
import clempie.suivistock.model.Content;
import clempie.suivistock.model.Reference;
import clempie.suivistock.model.sqlite.BoxManager;
import clempie.suivistock.model.sqlite.CategoryManager;
import clempie.suivistock.model.sqlite.ContentManager;
import clempie.suivistock.model.sqlite.ReferenceManager;

/**
 * Created by pierrick on 13/04/16.
 */
public class test {

    public void db(Context context) {
        Log.d("Projet", "1");
        ContentManager cm = new ContentManager(context);
        Log.d("Projet", "2");
        cm.open();

        Log.d("Projet", "3");

        BoxManager bm = new BoxManager(context);
        bm.open();

        Log.d("Projet", "4");

        CategoryManager cam = new CategoryManager(context);
        cam.open();

        Log.d("Projet", "5");

        ReferenceManager rm = new ReferenceManager(context);
        rm.open();

        Log.d("Projet", "6");

        Category cat = new Category(0, "MacDouglas");
        cat.setId(cam.addCategory(cat));

        Log.d("Projet", "7");

        Box box = new Box(0, "Frigo");
        box.setId(bm.addBox(box));

        Log.d("Projet", "8");

        Reference ref = new Reference(0, "poivron", "mfw.jpg", "Carrefour", "unité", 1, 200, "12354497856", 1000, cat);
        ref.setId(rm.addReference(ref));

        Log.d("Projet", "9");

        Content co = new Content(0, 12, new Date(), box, ref);
        co.setId(cm.addContent(co));

        Log.d("Projet", co.toString());


    }

}
