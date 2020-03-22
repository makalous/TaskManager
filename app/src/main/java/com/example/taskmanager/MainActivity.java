package com.example.taskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<String> toDoList;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;

    List<String> titles = new ArrayList<>();
    List<String> descs = new ArrayList<>();
    List<String> dates = new ArrayList<>();
    List<String> spiners = new ArrayList<>();
    List<String> status = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //((GlobalVariable) this.getApplication()).setStarted(false);
        toDoList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this,R.layout.list_view_layout, toDoList);
        listView = findViewById(R.id.id_list_view);
        listView.setAdapter(arrayAdapter);

        //if (((GlobalVariable) this.getApplication()).isStarted()==false)
        //{openData(); ((GlobalVariable) this.getApplication()).setStarted(true);}

        if(getIntent().hasExtra("s_s")) {
            titles=getIntent().getStringArrayListExtra("s_t");
            descs=getIntent().getStringArrayListExtra("s_d");
            dates=getIntent().getStringArrayListExtra("s_da");
            spiners=getIntent().getStringArrayListExtra("s_s");
            status=getIntent().getStringArrayListExtra("s_st");

            for(int i=0; i<titles.size(); i++){
                toDoList.add(i + ": " + spiners.get(i) + ": " + titles.get(i) + ", Status: " + status.get(i));
                //listView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_add_icon, 0, 0, 0);
                arrayAdapter.notifyDataSetChanged();
            }
        }

        arrayAdapter.notifyDataSetChanged();


        if(getIntent().hasExtra("titles")
                && getIntent().hasExtra("descs")
                && getIntent().hasExtra("dates")
                && getIntent().hasExtra("spiners")) {
            Bundle extras = getIntent().getExtras();
            titles.add(extras.getString("titles"));
            descs.add(extras.getString("descs"));
            dates.add(extras.getString("dates"));
            spiners.add(extras.getString("spiners"));
            status.add("Not Done");
            toDoList.add(titles.size()-1 + ": " + extras.getString("spiners") + ": " + extras.getString("titles") + ", Status: Not Done" );
            arrayAdapter.notifyDataSetChanged();

        }
        arrayAdapter.notifyDataSetChanged();

        if (toDoList.size()<=0) openData();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "Click ListItem Number " + position, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putStringArrayListExtra("s_t", (ArrayList<String>) titles);
                intent.putStringArrayListExtra("s_d", (ArrayList<String>) descs);
                intent.putStringArrayListExtra("s_da", (ArrayList<String>) dates);
                intent.putStringArrayListExtra("s_s", (ArrayList<String>) spiners);
                intent.putStringArrayListExtra("s_st", (ArrayList<String>) status);
                intent.putExtra("which_element", position);
                startActivity(intent);
            }
        });
        saveData();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                openAddItemActivity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openAddItemActivity(){
        Intent intent = new Intent(this, AddItemActivity.class);
        intent.putStringArrayListExtra("s_t", (ArrayList<String>) titles);
        intent.putStringArrayListExtra("s_d", (ArrayList<String>) descs);
        intent.putStringArrayListExtra("s_da", (ArrayList<String>) dates);
        intent.putStringArrayListExtra("s_s", (ArrayList<String>) spiners);
        intent.putStringArrayListExtra("s_st", (ArrayList<String>) status);
        startActivity(intent);
    }

    public void saveData(){
        TinyDB tinydb = new TinyDB(this);
        tinydb.putListString("titles", (ArrayList<String>) titles);
        tinydb.putListString("descs", (ArrayList<String>) descs);
        tinydb.putListString("dates", (ArrayList<String>) dates);
        tinydb.putListString("spiners", (ArrayList<String>) spiners);
        tinydb.putListString("status", (ArrayList<String>) status);
    }

    public void openData(){
        TinyDB tinydb = new TinyDB(this);
        titles=tinydb.getListString("titles");
        descs=tinydb.getListString("descs");
        dates=tinydb.getListString("dates");
        spiners=tinydb.getListString("spiners");
        status=tinydb.getListString("status");
            for(int i=0; i<titles.size(); i++){
                toDoList.add(i + ": " + spiners.get(i) + ": " + titles.get(i) + ", Status: " + status.get(i));
                //listView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_add_icon, 0, 0, 0);
                arrayAdapter.notifyDataSetChanged();
            }

    }
}

