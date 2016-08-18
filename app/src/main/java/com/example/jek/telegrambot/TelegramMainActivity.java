package com.example.jek.telegrambot;




import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.jek.telegrambot.data.TelegramResult;

import java.util.ArrayList;

public class TelegramMainActivity extends AppCompatActivity implements View.OnClickListener{

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telegram_main);

        listView = (ListView) findViewById(R.id.listViewTelegram);
        listView.setAdapter(new MessageAdapter(new ArrayList<TelegramResult>(), this));
    }

    @Override
    public void onClick(View v) {
        new AsyncTaskTelegram(this).execute();
        super.onResume();
    }
}