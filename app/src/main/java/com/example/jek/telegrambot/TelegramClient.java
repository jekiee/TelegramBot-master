package com.example.jek.telegrambot;

import android.app.DownloadManager;

import com.example.jek.telegrambot.data.TelegramGetUpdates;
import com.example.jek.telegrambot.data.TelegramSendMessage;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jek on 26.07.16.
 */
public class TelegramClient {
    public final static String API_KEY = "231495554:AAHdjjp6Miv_8RX-hhLPpWhFfs-Wy1JGLZg";
    public final static String GETUPDATES_URL = "https://api.telegram.org/bot" + API_KEY +"/getUpdates";
    public final static String SENDMESSAGE_URL = "https://api.telegram.org/bot" + API_KEY +"/sendmessage";


    private String get(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public TelegramGetUpdates getUpdates() throws IOException {
        Gson gson = new Gson();
        String json = get(GETUPDATES_URL);
        TelegramGetUpdates result = gson.fromJson(json, TelegramGetUpdates.class);
        return result;
    }

    public TelegramSendMessage sendMessage(long chat_id, String text) throws IOException {
        Gson gson = new Gson();
        String json = get(SENDMESSAGE_URL + "?chat_id=" + chat_id + "&" + "text=" + text);
        TelegramSendMessage result = gson.fromJson(json, TelegramSendMessage.class);
        return result;
    }
}