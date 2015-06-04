package com.dian.qiaozeyang.trydemos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dian.qiaozeyang.trydemos.activities.PackageNameActivity;
import com.dian.qiaozeyang.trydemos.activities.PhotoViewerActivity;
import com.dian.qiaozeyang.trydemos.activities.StartDaocaoActivity;
import com.dian.qiaozeyang.trydemos.activities.SwipeToFinshActivity;
import com.dian.qiaozeyang.trydemos.activities.WaveTextView;

/**
 * Created by  on 15/4/21.
 */
public class EntranceActivity extends Activity implements AdapterView.OnItemClickListener{
    private String [] dataName = {"查看包名","滑动返回","启动稻草","photoViewer", "waveLoading"};
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataName);
        listView = (ListView)findViewById(R.id.list_entrance);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }


    private Class [] dataClass = {PackageNameActivity.class, SwipeToFinshActivity.class,
            StartDaocaoActivity.class, PhotoViewerActivity.class, WaveTextView.class};


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(EntranceActivity.this, dataClass[position]);
        startActivity(intent);
    }
}
