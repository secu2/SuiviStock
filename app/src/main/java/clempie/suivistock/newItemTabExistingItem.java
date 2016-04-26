package clempie.suivistock;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Ref;
import java.util.ArrayList;

import clempie.suivistock.model.Reference;
import clempie.suivistock.model.sqlite.ReferenceManager;

/**
 * Created by Clem on 26/04/2016.
 */
public class NewItemTabExistingItem extends Fragment{
    private View fragmentView;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.tab_existing_item, container, false);

        ListView listeItems = (ListView) fragmentView.findViewById(R.id.listViewRefList);

        ArrayList<String> referenceStringList = new ArrayList<>();
        ReferenceManager rm = new ReferenceManager(fragmentView.getContext());
        rm.open();

        ArrayList<Reference> referencesList = rm.getReferences();
        for (Reference ref:referencesList
             ) {
            referenceStringList.add(ref.getName());

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(fragmentView.getContext(),R.layout.tab_existing_item, referenceStringList);
        //listeItems.setAdapter(adapter);

        return fragmentView;
    }
}
