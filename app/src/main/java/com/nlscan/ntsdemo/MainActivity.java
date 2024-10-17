package com.nlscan.ntsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mListView = null;
    private int[] mListName = {
            R.string.wifi_hotspot,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mListView = findViewById(R.id.MainMenu);
        mListView.setOnItemClickListener(this);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));
    }

    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        for(int i = 0; i < mListName.length; i++) {
            data.add(getResources().getString(mListName[i]));
        }
        return data;
    }

    private void Start_WifiHotspot(){
        Intent mIntent = new Intent();
        mIntent.setClass(this, WifiHotspotActivity.class);
        startActivity(mIntent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mListName[position] == R.string.wifi_hotspot){
            Start_WifiHotspot();
        }
    }
}