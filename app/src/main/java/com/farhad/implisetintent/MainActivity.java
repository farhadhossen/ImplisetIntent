package com.farhad.implisetintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.idbutton);

        final ListView dynamic = findViewById(R.id.iddynamic);


        //Create an array of elements
        final ArrayList<String> classes = new ArrayList<>();
        classes.add("01911568618");
        classes.add("01911568617");
        classes.add("01911568616");
        classes.add("01911568615");
        classes.add("01911568614");

        //Create adapter for ArrayList
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, classes);

        //Insert Adapter into List
        dynamic.setAdapter(adapter);

        //set click functionality for each list item
        dynamic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("User clicked ", classes.get(position));
                Toast.makeText(MainActivity.this, ""+classes.get(position), Toast.LENGTH_SHORT).show();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent smsIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:" + classes));
//                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + "01911568618,01911568617,01911568616"));
                smsIntent.putExtra("sms_body", "Hi Friends & Families, My Location is feeling unsafe in this location");
                startActivity(smsIntent);

            }
        });
    }
}