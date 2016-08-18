package com.example.jek.telegrambot.data;

/**
 * Created by jek on 26.07.16.
 */
public class TelegramResult {
    private long update_id;
    private TelegramMessage message;


    public long getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(long update_id) {
        this.update_id = update_id;
    }

    public TelegramMessage getMessage() {
        return message;
    }

    public void setMessage(TelegramMessage message) {
        this.message = message;
    }
}
