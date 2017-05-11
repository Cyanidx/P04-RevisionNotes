package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNote;
    Button btnInsert;
    Button btnShow;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNote = (EditText)findViewById(R.id.editTextNote);
        btnInsert = (Button)findViewById(R.id.buttonInsertNote);
        btnShow = (Button)findViewById(R.id.buttonShowList);
        rg = (RadioGroup)findViewById(R.id.radioGroupStars);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                String note = etNote.getText().toString();
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                String a = rb.getText().toString();
                int x = Integer.parseInt(a);

                // Insert a task
                db.insertNote(note,x);
                Toast.makeText(MainActivity.this, "Data Inserted",
                        Toast.LENGTH_LONG).show();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);

            }
        });

    }
}
