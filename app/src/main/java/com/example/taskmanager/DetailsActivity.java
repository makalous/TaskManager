package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    List<String> titles = new ArrayList<>();
    List<String> descs = new ArrayList<>();
    List<String> dates = new ArrayList<>();
    List<String> spiners = new ArrayList<>();
    List<String> status = new ArrayList<>();
    TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tv1 = (TextView)findViewById(R.id.textView1);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);

        if(getIntent().hasExtra("s_s")) {
            titles=getIntent().getStringArrayListExtra("s_t");
            descs=getIntent().getStringArrayListExtra("s_d");
            dates=getIntent().getStringArrayListExtra("s_da");
            spiners=getIntent().getStringArrayListExtra("s_s");
            status=getIntent().getStringArrayListExtra("s_st");
        }


        tv1.setText("Your task number: "+getIntent().getExtras().getInt("which_element")+"\n");
        tv2.setText(
                "Task: " + spiners.get(getIntent().getExtras().getInt("which_element"))+"\n"+
                "Title: " + titles.get(getIntent().getExtras().getInt("which_element"))+"\n"+
                "Description: " + descs.get(getIntent().getExtras().getInt("which_element"))+"\n"+
                "Date: " + dates.get(getIntent().getExtras().getInt("which_element"))+"\n"+
                "Status: " + status.get(getIntent().getExtras().getInt("which_element"))+"\n");
        switch(spiners.get(getIntent().getExtras().getInt("which_element"))){
            case "ToDo":
                tv3.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.ic_todo);
                break;
            case "E-mail":
                tv3.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.ic_email);
                break;
            case "Meeting":
                tv3.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.ic_meeting);
                break;
            default:
                tv3.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.ic_phone);
                break;

        }


        tv1.setOnTouchListener(new OnSwipeTouchListener(DetailsActivity.this) {
            public void onSwipeRight() {
                status.set(getIntent().getExtras().getInt("which_element"), "Done");

                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                intent.putStringArrayListExtra("s_t", (ArrayList<String>) titles);
                intent.putStringArrayListExtra("s_d", (ArrayList<String>) descs);
                intent.putStringArrayListExtra("s_da", (ArrayList<String>) dates);
                intent.putStringArrayListExtra("s_s", (ArrayList<String>) spiners);
                intent.putStringArrayListExtra("s_st", (ArrayList<String>) status);
                startActivity(intent);
            }
            public void onSwipeLeft() {
                titles.remove(getIntent().getExtras().getInt("which_element"));
                descs.remove(getIntent().getExtras().getInt("which_element"));
                dates.remove(getIntent().getExtras().getInt("which_element"));
                spiners.remove(getIntent().getExtras().getInt("which_element"));
                status.remove(getIntent().getExtras().getInt("which_element"));

                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                intent.putStringArrayListExtra("s_t", (ArrayList<String>) titles);
                intent.putStringArrayListExtra("s_d", (ArrayList<String>) descs);
                intent.putStringArrayListExtra("s_da", (ArrayList<String>) dates);
                intent.putStringArrayListExtra("s_s", (ArrayList<String>) spiners);
                intent.putStringArrayListExtra("s_st", (ArrayList<String>) status);
                startActivity(intent);
            }

        });

        tv2.setOnTouchListener(new OnSwipeTouchListener(DetailsActivity.this) {
            public void onSwipeRight() {
                status.set(getIntent().getExtras().getInt("which_element"), "Done");

                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                intent.putStringArrayListExtra("s_t", (ArrayList<String>) titles);
                intent.putStringArrayListExtra("s_d", (ArrayList<String>) descs);
                intent.putStringArrayListExtra("s_da", (ArrayList<String>) dates);
                intent.putStringArrayListExtra("s_s", (ArrayList<String>) spiners);
                intent.putStringArrayListExtra("s_st", (ArrayList<String>) status);
                startActivity(intent);
            }
            public void onSwipeLeft() {
                titles.remove(getIntent().getExtras().getInt("which_element"));
                descs.remove(getIntent().getExtras().getInt("which_element"));
                dates.remove(getIntent().getExtras().getInt("which_element"));
                spiners.remove(getIntent().getExtras().getInt("which_element"));
                status.remove(getIntent().getExtras().getInt("which_element"));

                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                intent.putStringArrayListExtra("s_t", (ArrayList<String>) titles);
                intent.putStringArrayListExtra("s_d", (ArrayList<String>) descs);
                intent.putStringArrayListExtra("s_da", (ArrayList<String>) dates);
                intent.putStringArrayListExtra("s_s", (ArrayList<String>) spiners);
                intent.putStringArrayListExtra("s_st", (ArrayList<String>) status);
                startActivity(intent);
            }

        });

        tv3.setOnTouchListener(new OnSwipeTouchListener(DetailsActivity.this) {
            public void onSwipeRight() {
                status.set(getIntent().getExtras().getInt("which_element"), "Done");

                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                intent.putStringArrayListExtra("s_t", (ArrayList<String>) titles);
                intent.putStringArrayListExtra("s_d", (ArrayList<String>) descs);
                intent.putStringArrayListExtra("s_da", (ArrayList<String>) dates);
                intent.putStringArrayListExtra("s_s", (ArrayList<String>) spiners);
                intent.putStringArrayListExtra("s_st", (ArrayList<String>) status);
                startActivity(intent);
            }
            public void onSwipeLeft() {
                titles.remove(getIntent().getExtras().getInt("which_element"));
                descs.remove(getIntent().getExtras().getInt("which_element"));
                dates.remove(getIntent().getExtras().getInt("which_element"));
                spiners.remove(getIntent().getExtras().getInt("which_element"));
                status.remove(getIntent().getExtras().getInt("which_element"));

                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                intent.putStringArrayListExtra("s_t", (ArrayList<String>) titles);
                intent.putStringArrayListExtra("s_d", (ArrayList<String>) descs);
                intent.putStringArrayListExtra("s_da", (ArrayList<String>) dates);
                intent.putStringArrayListExtra("s_s", (ArrayList<String>) spiners);
                intent.putStringArrayListExtra("s_st", (ArrayList<String>) status);
                startActivity(intent);
            }

        });



    }
}
