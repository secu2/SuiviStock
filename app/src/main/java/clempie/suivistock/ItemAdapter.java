package clempie.suivistock;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by clementbrocard on 30/03/2016.
 */
public class ItemAdapter extends BaseAdapter {
    private Context mContext;
    private ListView listView;

    public ItemAdapter(Context c, ListView v) {
        super();
        mContext = c;
        this.listView = v;
    }

    public int getCount() {
        return itemList.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        textView = new TextView(mContext);
        textView.setText(itemList[position]);
        return textView;
    }

    // references to our images
    private String[] itemList = {
            "Item 2", "Item 2", "Item 3", "..."
    };

}
