package com.example.jek.telegrambot.dataVatarClient;

import java.util.List;

/**
 * Created by root on 18.08.16.
 */
public class TelegramResultAvatar {
    private int total_count;
    private List<TelegramPhoto> photos;

    public int getTotal_count() {
        return total_count;
    }

    public List<TelegramPhoto> getPhotos() {
        return photos;
    }
}
