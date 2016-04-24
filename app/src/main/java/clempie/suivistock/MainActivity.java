package clempie.suivistock;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import clempie.suivistock.model.Content;
import clempie.suivistock.model.sqlite.BoxManager;
import clempie.suivistock.model.sqlite.CategoryManager;
import clempie.suivistock.model.sqlite.ContentManager;
import clempie.suivistock.model.sqlite.ReferenceManager;
import clempie.suivistock.util.BoxListAdapter;
import clempie.suivistock.views.BoxIndex;
import clempie.suivistock.NewItem;

public class MainActivity extends AppCompatActivity {
    public static BoxManager boxManager;
    public static CategoryManager categoryManager;
    public static ContentManager contentManager;
    public static ReferenceManager referenceManager;
    public ListAdapter boxListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boxManager = new BoxManager(MainActivity.this);
        boxManager.open();
        categoryManager = new CategoryManager(MainActivity.this);
        categoryManager.open();
        contentManager = new ContentManager(MainActivity.this);
        contentManager.open();
        referenceManager = new ReferenceManager(MainActivity.this);
        referenceManager.open();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newItem = new Intent(MainActivity.this, NewItem.class);
                startActivity(newItem);
            }
        });



        final GridView gridview = (GridView) findViewById(R.id.homeTiles);
        boxListAdapter = new BoxListAdapter(this, gridview);
        gridview.setAdapter(boxListAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                TextView tv = (TextView) v.findViewById(R.id.textView1);

                Intent boxIndex;
                if(tv.getText().equals("Nouvelle box")){
                    boxIndex = new Intent(MainActivity.this, NewBox.class);
                    startActivityForResult(boxIndex,1);
                }else {
                    boxIndex = new Intent(MainActivity.this, BoxIndex.class);
                    boxIndex.putExtra("box", boxManager.getBox(tv.getText().toString()));
                    startActivity(boxIndex);
                }
            }
        });







    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if (resultCode == RESULT_OK) {
                Intent refresh = new Intent(this, MainActivity.class);
                startActivity(refresh);
                this.finish();
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == R.id.action_logboxes){

        }
        return super.onOptionsItemSelected(item);
    }
}
