package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import static com.example.taskmanager.R.*;

import android.content.Intent;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddItemActivity extends AppCompatActivity {

    EditText title;
    EditText desc;
    EditText data;
    Spinner type;
    Button accept;

    List<String> titles = new ArrayList<>();
    List<String> descs = new ArrayList<>();
    List<String> dates = new ArrayList<>();
    List<String> spiners = new ArrayList<>();
    List<String> status = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_add_item);

        if(getIntent().hasExtra("s_s")) {
            titles=getIntent().getStringArrayListExtra("s_t");
            descs=getIntent().getStringArrayListExtra("s_d");
            dates=getIntent().getStringArrayListExtra("s_da");
            spiners=getIntent().getStringArrayListExtra("s_s");
            status=getIntent().getStringArrayListExtra("s_st");
        }

        title = (EditText) findViewById(id.ItemTitle);
        desc = (EditText) findViewById(id.ItemDescription);
        data = (EditText) findViewById(id.ItemDate);
        type = (Spinner) findViewById(id.ItemType);
        accept = (Button) findViewById(id.AcceptItem);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (title.getText().toString().matches("")
                        || desc.getText().toString().matches("")
                        || data.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(),"Some values are empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    openMainActivity();
                }

            }
        });

    }
    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("titles",title.getText().toString());
        intent.putExtra("descs",desc.getText().toString());
        intent.putExtra("dates",data.getText().toString());
        intent.putExtra("spiners", type.getSelectedItem().toString());


        intent.putStringArrayListExtra("s_t", (ArrayList<String>) titles);
        intent.putStringArrayListExtra("s_d", (ArrayList<String>) descs);
        intent.putStringArrayListExtra("s_da", (ArrayList<String>) dates);
        intent.putStringArrayListExtra("s_s", (ArrayList<String>) spiners);
        intent.putStringArrayListExtra("s_st", (ArrayList<String>) status);
        startActivity(intent);
    }
}