package com.example.samsungproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button sendBtn;
    EditText editMsg;
    RecyclerView messagesRecycler;

    static final Boolean bot = true, man = false;
    Boolean cityB = false,cityA = false;

    String message;
    ArrayList<Message> messages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = findViewById(R.id.sendMsg);
        editMsg = findViewById(R.id.editMsg);
        messagesRecycler = findViewById(R.id.recycler);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editMsg.getText().toString();

                if(cityB && cityA){
                    cityB = false;
                    cityA = false;
                }else if(cityB && !cityA){
                    cityA=true;
                }

                if(message.equals("")) {
                    Toast.makeText(getApplicationContext(), "Введите сообщение", Toast.LENGTH_SHORT).show();
                    return;
                }
                Message input = new Message(message,man);
                DataAdapter dataAdapter = new DataAdapter(MainActivity.this, messages);
                messagesRecycler.setAdapter(dataAdapter);
                messagesRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                editMsg.setText("");
                messages.add(input);

                Bot Bot = new Bot();

                String answer = Bot.answer(message, MainActivity.this, cityB);
                if(answer.equals("Введите город")){
                    cityB = true;
                }
                Message output = new Message(answer,bot);
                messages.add(output);
            }
        });

    }
}
