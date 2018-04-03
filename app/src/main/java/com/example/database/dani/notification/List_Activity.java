package com.example.database.dani.notification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class List_Activity extends AppCompatActivity {


   public static ListView listView;
   private static String[] Names = new String[]{
           "Tom","Marks","John","Jack","Patrik","Wajid","Hanif","Hassan","Akmal","Aniq","Zafar","Farhan"   };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_);

        listView = findViewById(R.id.list);

        listview();
    }
    public  void listview(){
        CustomAdapterClass customAdapterClass =new CustomAdapterClass(this,R.layout.namelist,Names);
        listView.setAdapter(customAdapterClass);
    }
}
