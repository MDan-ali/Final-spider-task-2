package com.example.danish.edityourtext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity {

    Spinner colourList,sizeList;
    CheckBox boldBox,italicBox;
    EditText inputText;
    ListView fontList;

    String font;
    String colour;
    String size;
    String bold;
    String italic;

    String [] fonts_array ={"Arial","Times New Roman","Sans Serif","Monospace","Serif"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colourList = (Spinner) findViewById(R.id.colourSpinner);
        sizeList = (Spinner) findViewById(R.id.sizeSpinner);

        boldBox=(CheckBox)findViewById(R.id.boldBox);
        bold="false";
        boldBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    bold = "true";
                }
            }
        });

        italicBox=(CheckBox)findViewById(R.id.italicBox);
        italic="false";
        italicBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    italic = "true";
                }
            }
        });

        colourList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                colour = String.valueOf(parent.getItemAtPosition(position));
                Log.d("colour", colour);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                colour = "White";
            }
        });

        sizeList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                size = String.valueOf(parent.getItemAtPosition(position));
                Log.d("size", size);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                size = "10";
            }
        });



        inputText=(EditText)findViewById(R.id.inputText);

        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fonts_array);
        fontList=(ListView)findViewById(R.id.fontList);
        fontList.setAdapter(adapter);
        fontList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                font=(String)parent.getItemAtPosition(position);

                Intent i = new Intent(getApplicationContext(), Editing.class);
                i.putExtra("colour", colour);
                i.putExtra("size", size);
                i.putExtra("bold", bold);
                i.putExtra("italic", italic);
                i.putExtra("font", font);
                i.putExtra("input", inputText.getText().toString());
                startActivity(i);
                finish();

            }
        });

    }


}

