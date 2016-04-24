package clempie.suivistock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import clempie.suivistock.model.Box;
import clempie.suivistock.model.sqlite.BoxManager;

public class NewBox extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_box);

        Button btnVal = (Button) findViewById(R.id.buttonValidate);
        btnVal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView nomBox = (TextView) findViewById(R.id.nomBox);
                BoxManager bm = new BoxManager(NewBox.this);
                bm.open();
                bm.addBox(new Box(0, nomBox.getText().toString()));
                setResult(RESULT_OK, null);
                finish();
            }
        });
    }
}
