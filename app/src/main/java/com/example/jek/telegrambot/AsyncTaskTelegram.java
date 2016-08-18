package com.example.jek.telegrambot;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jek.telegrambot.data.TelegramGetUpdates;

import java.io.IOException;

/**
 * Created by jek on 26.07.16.
 */
public class AsyncTaskTelegram extends AsyncTask<Void, Void, TelegramGetUpdates> {

    private Activity activity;

    public AsyncTaskTelegram(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected TelegramGetUpdates doInBackground(Void... params) {
        TelegramClient telegramClient = new TelegramClient();

        try {
            return telegramClient.getUpdates();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(TelegramGetUpdates telegramGetUpdates) {
        super.onPostExecute(telegramGetUpdates);
        if(telegramGetUpdates!= null && telegramGetUpdates.isOk()) {
            ListView listView = (ListView) activity.findViewById(R.id.listViewTelegram);
            ((MessageAdapter) listView.getAdapter()).getMessages().clear();
            ((MessageAdapter) listView.getAdapter()).getMessages().addAll(telegramGetUpdates.getResult());
            ((MessageAdapter) listView.getAdapter()).notifyDataSetChanged();
        } else  {
            Toast.makeText(activity, "Текста нет", Toast.LENGTH_LONG).show();
        }
    }
}
