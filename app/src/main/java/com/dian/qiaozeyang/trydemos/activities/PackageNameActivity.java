package com.dian.qiaozeyang.trydemos.activities;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.dian.qiaozeyang.trydemos.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PackageNameActivity extends ActionBarActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_view);
        String [] strings = {"img", "name", "paN", "paS"};
        int [] ids = {R.id.item_list_image, R.id.item_list_text1, R.id.item_list_text2, R.id.item_list_text3};
        SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.item_list, strings, ids);
        listView.setAdapter(adapter);
    }

    private List<HashMap<String, Object>> getData(){
        ArrayList<HashMap<String, Object>>  list = new ArrayList<>();
        PackageManager packageManager = getPackageManager();
        List<PackageInfo> packageInfoList = packageManager.getInstalledPackages(0);
        HashMap<String, Object> map = null;
        for (int i = 0; i < packageInfoList.size(); i++){
            map = new HashMap<>();

            map.put("name", packageManager.getApplicationLabel(packageInfoList.get(i).applicationInfo).toString());
            map.put("paN", packageInfoList.get(i).applicationInfo.packageName);
            try {
                map.put("img", packageManager.getApplicationInfo(packageInfoList.get(i).packageName, 0).loadIcon(packageManager));
//                map.put("paS", packageManager.getPackageInfo(packageInfoList.get(i).packageName, PackageManager.GET_SIGNATURES).signatures[0].toCharsString());
            }catch (Exception e){
                e.printStackTrace();
            }

            list.add(map);
        }
        return list;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnClick(View view){

    }
}
