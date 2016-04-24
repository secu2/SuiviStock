package clempie.suivistock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import clempie.suivistock.util.BoxListAdapter;
import clempie.suivistock.views.BoxIndex;

public class NewItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        GridView gridview = (GridView) findViewById(R.id.conteneurs);
        gridview.setAdapter(new BoxListAdapter(this, gridview));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //TODO Verifier champs et ajouter item

                final EditText nameField = (EditText) findViewById(R.id.nomAliment);
                final EditText uniteField = (EditText) findViewById(R.id.uniteAliment);
                final EditText categorieField = (EditText) findViewById(R.id.categorieAliment);
                final EditText marqueField = (EditText) findViewById(R.id.marqueAliment);
                final EditText prixMoyField = (EditText) findViewById(R.id.prixMoyenAliment);
                final EditText ingredientsField = (EditText) findViewById(R.id.ingredientsAliment);
                final EditText remarquesField = (EditText) findViewById(R.id.remarquesAliment);


                String name = nameField.getText().toString();
                String unite = uniteField.getText().toString();
                String categorie = categorieField.getText().toString();
                String marque = marqueField.getText().toString();
                String prixMoy = prixMoyField.getText().toString();
                String ingredients = ingredientsField.getText().toString();
                String remarques = remarquesField.getText().toString();

                Log.d("New item res", "Name:"+name+" Unité:"+unite+" Catégorie:"+categorie);
            }
        });
    }


}
