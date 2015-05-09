package com.dian.qiaozeyang.trydemos.receiver;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

import com.dian.qiaozeyang.trydemos.R;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by qiaozeyang on 15/5/9.
 * @author qiaozeyang
 * @since 2015-05-09 14:00:48
 */
public class WidgetProvider extends AppWidgetProvider{
    // 保存 widget 的id的HashSet，每新建一个 widget 都会为该 widget 分配一个 id。
    private static Set idsSet = new HashSet();
    private static final String LOG_TAG = "widget";
    private static final String BROADCAST_KEY = "com.qiaozeyang.widget";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        showText(context, "onUpdate");
        for (int appWidgetId : appWidgetIds) {
            idsSet.add(appWidgetId);
        }
        setOnClickListener(context);
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    private void setOnClickListener(Context context) {
        Intent intent = new Intent();
        intent.setAction(BROADCAST_KEY);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        RemoteViews remoteViews = getRemoteViews(context);
        remoteViews.setOnClickPendingIntent(R.id.widget_btn, pi);
        updateWidget(context, remoteViews);
        showText(context,"listener");
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        showText(context, "onDeleted");
        for (int id : appWidgetIds){
            idsSet.remove(id);
        }
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onEnabled(Context context) {
        showText(context, "onEnabled");
        super.onEnabled(context);
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        showText(context, "changeId="+appWidgetId);
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(LOG_TAG, "receive");
        if (intent.getAction().equals(BROADCAST_KEY)){
            showText(context, "buttonClick");
        }
        super.onReceive(context, intent);
    }

    private void showText(Context context, String text) {
        RemoteViews remoteViews = getRemoteViews(context);
        remoteViews.setTextViewText(R.id.widget_tv, text);
        Log.e(LOG_TAG, text);
        updateWidget(context, remoteViews);
    }

    private void updateWidget(Context context, RemoteViews remoteViews) {
        int appId;
        Iterator it = idsSet.iterator();
        while (it.hasNext()){
            appId = (Integer)it.next();
            AppWidgetManager.getInstance(context).updateAppWidget(appId, remoteViews);
        }
    }

    private RemoteViews getRemoteViews(Context context) {
        return new RemoteViews(context.getPackageName(), R.layout.appwidget);
    }

}
