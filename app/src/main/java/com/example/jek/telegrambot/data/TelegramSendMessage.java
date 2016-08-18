package com.example.jek.telegrambot.data;

/**
 * Created by jek on 26.07.16.
 */
public class TelegramSendMessage {
    private boolean ok;
    private TelegramResult result;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public TelegramResult getResult() {
        return result;
    }

    public void setResult(TelegramResult result) {
        this.result = result;
    }
}
