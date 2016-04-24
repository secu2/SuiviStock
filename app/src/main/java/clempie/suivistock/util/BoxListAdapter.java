package clempie.suivistock.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import clempie.suivistock.R;
import clempie.suivistock.model.Box;
import clempie.suivistock.model.sqlite.BoxManager;

/**
 * Created by clementbrocard on 30/03/2016.
 */
public class BoxListAdapter extends BaseAdapter {

    private Integer[] mThumbIds = {android.R.drawable.ic_menu_add};
    private Integer mThumbBox = android.R.drawable.picture_frame;
    private String [] mBoxNames = {"Nouvel emplacement"};

    private Context mContext;
    private GridView gridView;
    private static LayoutInflater inflater = null;
    private ArrayList<Box> boxList;

    public BoxListAdapter(Context c, GridView width) {
        super();
        BoxManager boxManager = new BoxManager(c);
        boxManager.open();
        mContext = c;
        this.gridView = width;
        boxList = boxManager.getBox();
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return boxList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }


    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.gridview_item, null);

        holder.tv = (TextView) rowView.findViewById(R.id.textView1);
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);

        holder.tv.setText(boxList.get(position).getName());
        if(!boxList.get(position).getName().equals("Nouvelle box")){
            holder.img.setImageResource(mThumbBox);
        }
        return rowView;

    }



}
