package com.AT.whiteboard;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class Whiteboard extends AppCompatActivity {

    DrawableView drawableView;
    Button up, down, undo;
    Spinner changeColor;
    DrawableViewConfig config;
    int stroke, index;

    private ArrayList<ColorItem> colorList;
    private ColorAdapter colorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whiteboard);

        drawableView = findViewById(R.id.drawView);
        up = findViewById(R.id.buttonUP);
        down = findViewById(R.id.buttonDown);
        changeColor = findViewById(R.id.spinnerColor);
        undo = findViewById(R.id.buttonUndo);

        config = new DrawableViewConfig();
        config.setStrokeColor(getResources().getColor(android.R.color.black));
        index = 1;
        config.setStrokeWidth(3);
        config.setShowCanvasBounds(true);
        config.setMinZoom(1.0f);
        config.setMaxZoom(3.0f);
        config.setCanvasHeight(10080);
        config.setCanvasWidth(10000);

        initList();

        drawableView.setConfig(config);

        colorAdapter = new ColorAdapter(this,colorList);
        changeColor.setAdapter(colorAdapter);



        changeColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ColorItem clickedItem = (ColorItem) parent.getItemAtPosition(position);
                config.setStrokeColor(getResources().getColor(clickedItem.getColorImage()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stroke++;
                Toast.makeText(Whiteboard.this, "Stroke is " + stroke, Toast.LENGTH_SHORT).show();
                config.setStrokeWidth(stroke);
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (stroke == 0) {
                    stroke = 0;
                    Toast.makeText(Whiteboard.this, "Stroke is " + stroke, Toast.LENGTH_SHORT).show();
                } else {
                    stroke--;
                    Toast.makeText(Whiteboard.this, "Stroke is " + stroke, Toast.LENGTH_SHORT).show();
                    config.setStrokeWidth(stroke);
                }
            }
        });


        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawableView.undo();
            }
        });

    }

    public void initList(){
        colorList = new ArrayList();
        colorList.add(new ColorItem(R.color.black));
        colorList.add(new ColorItem(R.color.red));
        colorList.add(new ColorItem(R.color.blue));
        colorList.add(new ColorItem(R.color.green));
        colorList.add(new ColorItem(R.color.purple_200));
        colorList.add(new ColorItem(R.color.green));
        colorList.add(new ColorItem(R.color.orange1));
        colorList.add(new ColorItem(R.color.orange2));
        colorList.add(new ColorItem(R.color.purple1));
        colorList.add(new ColorItem(R.color.purple2));
        colorList.add(new ColorItem(R.color.purple3));
        colorList.add(new ColorItem(R.color.green1));
        colorList.add(new ColorItem(R.color.yellow));
        colorList.add(new ColorItem(R.color.maroon));
        colorList.add(new ColorItem(R.color.cyan));
        colorList.add(new ColorItem(R.color.teal_700));
        colorList.add(new ColorItem(R.color.green2));
    }
}

