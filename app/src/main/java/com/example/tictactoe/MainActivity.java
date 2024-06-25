package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void startGame(View v) {
        Intent i = new Intent(this, GameActivity.class);     // create new activity

        String name1 = ((EditText)findViewById(R.id.editText1)).getText().toString();
        String name2 = ((EditText)findViewById(R.id.editText2)).getText().toString();

        // pass in players' names
        i.putExtra("Player A", name1);
        i.putExtra("Player B", name2);

        startActivity(i);   // launch the new activity
    }
}