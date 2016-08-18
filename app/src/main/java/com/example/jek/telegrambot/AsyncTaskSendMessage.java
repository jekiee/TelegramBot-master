package com.example.jek.telegrambot;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.jek.telegrambot.data.TelegramSendMessage;

import java.io.IOException;

/**
 * Created by jek on 26.07.16.
 */
public class AsyncTaskSendMessage extends AsyncTask<Void, Void, TelegramSendMessage> {

    private Activity activity;
    long chat_id;
    String text;

    public AsyncTaskSendMessage(Activity activity, long chat_id, String text) {
        this.activity = activity;
        this.chat_id = chat_id;
        this.text = text;
    }

    @Override
    protected TelegramSendMessage doInBackground(Void... params) {
        TelegramClient telegramClient = new TelegramClient();
        try {
            return telegramClient.sendMessage(chat_id, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(TelegramSendMessage telegramSendMessage) {
        super.onPostExecute(telegramSendMessage);
        if (telegramSendMessage != null && telegramSendMessage.isOk()) {
            Intent intent = new Intent(activity, TelegramMainActivity.class);
            activity.startActivity(intent);
        } else {
            Toast.makeText(activity, "Текста нет", Toast.LENGTH_LONG).show();
        }
    }
}
