package com.dian.qiaozeyang.trydemos.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dian.qiaozeyang.trydemos.R;

/**
 * Created by dianmobile on 15/4/28.
 */
public class StartDaocaoActivity extends Activity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_daocao);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setData(Uri.parse("daocao://com.daocao360.daocao"));
                startActivity(intent);
            }
        });
    }
}
