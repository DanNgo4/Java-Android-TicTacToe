package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {
    private String _name1;
    private String _name2;
    private boolean _isPlayerATurn = true;
    private Button[][] _grid = new Button[3][3];
    private int _moveCount = 0;
    private TextView _turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setNames();
        initiateGame();
        _turn = findViewById(R.id.name);
        updateTurn();
    }

    private void setNames() {
        Intent i = getIntent();
        _name1 = i.getStringExtra("Player A");
        _name2 = i.getStringExtra("Player B");

        if (_name1.isEmpty()) {
            _name1 = "Player A";
        }
        ((TextView)findViewById(R.id.textView4)).setText(_name1);


        if (_name2.isEmpty()) {
            _name2 = "Player B";
        }
        ((TextView)findViewById(R.id.textView6)).setText(_name2);
    }

    private void updateTurn() {
        _turn.setText((_isPlayerATurn ? _name1 : _name2) + "'s turn");
    }

    private void initiateGame() {
        _grid[0][0] = findViewById(R.id.grid1);
        _grid[0][1] = findViewById(R.id.grid2);
        _grid[0][2] = findViewById(R.id.grid3);
        _grid[1][0] = findViewById(R.id.grid4);
        _grid[1][1] = findViewById(R.id.grid5);
        _grid[1][2] = findViewById(R.id.grid6);
        _grid[2][0] = findViewById(R.id.grid7);
        _grid[2][1] = findViewById(R.id.grid8);
        _grid[2][2] = findViewById(R.id.grid9);
    }

    public void gridClick(View v) {
        Button b = (Button) v;
        if (!b.getText().toString().equals("")) {   // ensure players don't overwrite the written grids
            return;
        }

        if (_isPlayerATurn) {
            b.setText("X");
        } else {
            b.setText("O");
        }

        _moveCount++;
        if (checkWin()) {
            if (_isPlayerATurn) {
                showMessage(_name1 + " wins!");
            } else {
                showMessage(_name2 + " wins!");
            }
            restartGame();
        } else if (_moveCount == 9) {
            showMessage("It's a draw!");
            restartGame();
        } else {
            _isPlayerATurn = !_isPlayerATurn;
            updateTurn();
        }
    }

    private boolean checkWin() {
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = _grid[i][j].getText().toString();
            }
        }

        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals("")) {
                return true;
            }
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals("")) {
                return true;
            }
        }

        if (field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].equals("")) {
            return true;
        }

        if (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals("")) {
            return true;
        }

        return false;
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void exitGame(View v) {
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK); // ensuring the new activity become root and clear any existing task
        startActivity(i);
        finish();
    }

    public void restartGame() {
        _moveCount = 0;
        _isPlayerATurn = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                _grid[i][j].setText("");
            }
        }
    }
}