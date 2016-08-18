package com.example.jek.telegrambot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendMessageActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText eTextSendMessage;
    private Button buttonSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        eTextSendMessage = (EditText) findViewById(R.id.editTextSendMessage);
        buttonSendMessage = (Button) findViewById(R.id.buttonSendMessage);

    }

    @Override
    public void onClick(View v) {
        String text = eTextSendMessage.getText().toString();
        long chatID = getIntent().getLongExtra(MessageAdapter.CHAT_ID, -1);
        if (chatID == -1) {
            Toast.makeText(this, "Error ID", Toast.LENGTH_SHORT).show();
        } else {
            new AsyncTaskSendMessage(this, chatID, text).execute();
        }
    }
}
