package clempie.suivistock;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import clempie.suivistock.model.Box;
import clempie.suivistock.model.Category;
import clempie.suivistock.model.Reference;
import clempie.suivistock.model.sqlite.BoxManager;
import clempie.suivistock.model.sqlite.ContentManager;
import clempie.suivistock.model.sqlite.ReferenceManager;
import clempie.suivistock.util.BoxListAdapter;

/**
 * Created by Clem on 26/04/2016.
 */
public class NewItemTabCreateItem extends Fragment {
    private View fragmentView;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        fragmentView = inflater.inflate(R.layout.tab_create_item, container, false);

        GridView gridview = (GridView) fragmentView.findViewById(R.id.conteneurs);
        gridview.setAdapter(new BoxListAdapter(fragmentView.getContext(), gridview));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //TODO Verifier champs et ajouter item

                final EditText nameField = (EditText) fragmentView.findViewById(R.id.nomAliment);
                final EditText uniteField = (EditText) fragmentView.findViewById(R.id.uniteAliment);
                final EditText categorieField = (EditText) fragmentView.findViewById(R.id.categorieAliment);
                final EditText marqueField = (EditText) fragmentView.findViewById(R.id.marqueAliment);
                final EditText prixMoyField = (EditText) fragmentView.findViewById(R.id.prixMoyenAliment);
                final EditText ingredientsField = (EditText) fragmentView.findViewById(R.id.ingredientsAliment);
                final EditText remarquesField = (EditText) fragmentView.findViewById(R.id.remarquesAliment);


                String name = nameField.getText().toString();
                String unite = uniteField.getText().toString();
                String categorie = categorieField.getText().toString();
                String marque = marqueField.getText().toString();
                String prixMoy = prixMoyField.getText().toString();
                String ingredients = ingredientsField.getText().toString();
                String remarques = remarquesField.getText().toString();

                BoxManager bm = new BoxManager(container.getContext());
                bm.open();
                TextView tv = (TextView) v.findViewById(R.id.textView1);
                Box currentBox = bm.getBox(tv.getText().toString());

                ContentManager cm = new ContentManager(getView().getContext());
                cm.open();



                ReferenceManager rm = new ReferenceManager(getView().getContext());
                rm.open();

                Reference ref = null;

                if(rm.isReference(name)){
                    ref = rm.getReference(name);
                }else{
                    ref = new Reference(0, name, "", marque, "", 1, 1, "", Integer.parseInt(prixMoy),new Category(0, "none"));
                    rm.addReference(ref);
                }





            }
        });


        return fragmentView;


    }
}
