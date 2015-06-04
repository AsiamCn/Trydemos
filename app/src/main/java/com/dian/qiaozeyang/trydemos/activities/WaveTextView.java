package com.dian.qiaozeyang.trydemos.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dian.qiaozeyang.trydemos.R;
import com.romainpiel.titanic.library.Titanic;
import com.romainpiel.titanic.library.TitanicTextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by qiaozeyang on 15/5/15.
 *
 * @version 1.0
 */
public class WaveTextView extends Activity {
    Titanic titanic;
    TitanicTextView titanicTextView;
    @InjectView(R.id.titanic_tv)
    TitanicTextView titanicTv;

    @OnClick(R.id.testbutton)
    void callback() {
        Toast.makeText(WaveTextView.this, "show!", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave);
        ButterKnife.inject(this);
        titanicTextView = (TitanicTextView) findViewById(R.id.titanic_tv);
        titanic = new Titanic();
        titanic.start(titanicTextView);
        ButterKnife.inject(this);
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'activity_wave.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder {
        @InjectView(R.id.titanic_tv)
        TitanicTextView titanicTv;
        @InjectView(R.id.testbutton)
        Button testbutton;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
