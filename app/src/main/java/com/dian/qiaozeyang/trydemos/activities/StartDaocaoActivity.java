package com.dian.qiaozeyang.trydemos.activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dian.qiaozeyang.trydemos.R;
import com.gc.materialdesign.views.ButtonRectangle;

/**
 * Created by dianmobile on 15/4/28.
 */
public class StartDaocaoActivity extends Activity {
    private ButtonRectangle button;
    private Button trueButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_daocao);
        button = (ButtonRectangle)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent("android.intent.action.MAIN");
//                intent.setData(Uri.parse("daocao://com.daocao360.daocao"));
//                startActivity(intent);
            }
        });
        trueButton = (Button)findViewById(R.id.btn_start);
        setButtonColor(trueButton);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("re","click");
            }
        });
    }

    @TargetApi(21)
    private void setButtonColor(Button button){
        button.setHighlightColor(getResources().getColor(android.R.color.black));
    }
}
