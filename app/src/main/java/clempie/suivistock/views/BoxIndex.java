package clempie.suivistock.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


import com.google.zxing.integration.android.IntentIntegrator;

import clempie.suivistock.NewBox;
import clempie.suivistock.NewItem;
import clempie.suivistock.R;
import clempie.suivistock.model.Box;
import clempie.suivistock.model.Content;
import clempie.suivistock.model.sqlite.BoxManager;
import clempie.suivistock.model.sqlite.ContentManager;

public class BoxIndex extends AppCompatActivity {
    private Box box;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        box = (Box) getIntent().getSerializableExtra("box");
        Log.d("BoxName", box.getName());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_index);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newItemIntent = new Intent(BoxIndex.this, NewItem.class);
                startActivityForResult(newItemIntent,2);
            }

        });
        fab.setImageResource(android.R.drawable.ic_menu_add);*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        TextView boxName = (TextView) findViewById(R.id.boxName);
        boxName.setText(box.getName());

        ListView itemListView = (ListView)findViewById(R.id.listViewContent);


        BoxManager boxM = new BoxManager(BoxIndex.this);
        boxM.open();

        ContentManager contentM = new ContentManager(BoxIndex.this);
        contentM.open();

        ArrayList<Content> itemList = new ArrayList<>();
        ArrayList<String> itemNameList = new ArrayList<>();
        int index = 0;
        for (Content item : itemList
             ) {
            itemNameList.add(itemList.get(index++).getReference().getName());

        }

        itemList = contentM.getContent(box);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemNameList);
        itemListView.setAdapter(arrayAdapter);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                Log.d("Info.SCANRESULT", data.getStringExtra("SCAN_RESULT"));
                String contents = data.getStringExtra("SCAN_RESULT");
            }
            /*if(resultCode == RESULT_CANCELLED){
                //handle cancel
            }*/
        }
    }
}
