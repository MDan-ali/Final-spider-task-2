package com.example.danish.edityourtext;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;


public class Editing extends Activity {

    TextView finalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing);

        Intent i = getIntent();
        String colour = i.getStringExtra("colour");
        String size = i.getStringExtra("size");
        String bold = i.getStringExtra("bold");
        String italic = i.getStringExtra("italic");
        String font = i.getStringExtra("font");
        String input = i.getStringExtra("input");

        finalText = (TextView) findViewById(R.id.finalOutput);
        finalText.setText(input);

        funcSize(size);
        funcfont(font);
        funccolour(colour);
        funcbolditalics(bold,italic);
    }

    private void funcSize (String size) {
        if (size.equalsIgnoreCase("12")) {
            finalText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        }
        if (size.equalsIgnoreCase("18")) {
            finalText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        }
        if (size.equalsIgnoreCase("24")){
            finalText.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
        }
        if (size.equalsIgnoreCase("36")) {
            finalText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
        }
        if (size.equalsIgnoreCase("48")) {
            finalText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 48);
        }

    }

    private void funcbolditalics(String bold, String italics) {
        if(bold.equals("true")&&italics.equals("true")){
            finalText.setTypeface(null, Typeface.BOLD_ITALIC);
        }
        if(bold.equals("true")&&italics.equals("false")){
            finalText.setTypeface(null, Typeface.BOLD);
        }
        if(bold.equals("false")&&italics.equals("true")) {
            finalText.setTypeface(null, Typeface.ITALIC);
        }
        if(bold.equals("false")&&italics.equals("false")){
            finalText.setTypeface(null, Typeface.NORMAL);
        }
    }

    private void funccolour(String colour) {
        if (colour.equalsIgnoreCase("Red")){
            finalText.setTextColor(Color.RED);}
        if (colour.equalsIgnoreCase("Blue")){
            finalText.setTextColor(Color.BLUE);}
        if (colour.equalsIgnoreCase("Green")){
            finalText.setTextColor(Color.GREEN);}
        if (colour.equalsIgnoreCase("Yellow")){
            finalText.setTextColor(Color.YELLOW);}
        if (colour.equalsIgnoreCase("White")){
            finalText.setTextColor(Color.WHITE);}
    }

    private void funcfont(String font) {

        if(font.equalsIgnoreCase("Arial")){
            Typeface face= Typeface.createFromAsset(getAssets(), "fonts/arial.ttf");
            finalText.setTypeface(face);
        }
        if(font.equalsIgnoreCase("Times New Roman")){
            Typeface face= Typeface.createFromAsset(getAssets(), "fonts/times.ttf");
            finalText.setTypeface(face);
        }
        if(font.equalsIgnoreCase("Sans Serif")){
            finalText.setTypeface(Typeface.SANS_SERIF);
        }
        if(font.equalsIgnoreCase("Monospace")){
            finalText.setTypeface(Typeface.MONOSPACE);
        }
        if(font.equalsIgnoreCase("Serif")) {
            finalText.setTypeface(Typeface.SERIF);
        }

    }

    public void exit(View view){
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);



    }
    public  void edit(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
