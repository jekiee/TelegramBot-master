package com.example.jek.telegrambot;

import android.app.Activity;
import android.app.Notification;
import android.os.AsyncTask;

import com.example.jek.telegrambot.dataVatarClient.TelegramGetAvatar;

/**
 * Created by root on 18.08.16.
 */
public class AsyncTaskGetAvatar extends AsyncTask<Void, Void, TelegramGetAvatar> {
    private Activity activity;
    long user_id;

    public AsyncTaskGetAvatar(Activity activity, long user_id){
        this.activity = activity;
        this.user_id = user_id;
    }

    @Override
    protected TelegramGetAvatar doInBackground(Void... params){
        TelegramClient telegramClient = new TelegramClient();
        telegramClient.getAvatar(user_id);

        return null;
    }
}
