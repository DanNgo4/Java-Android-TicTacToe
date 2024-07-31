# Tic Tac Toe Android App in Java
## CS50x 2024 Final Project
#### Video Demo: https://youtu.be/MrOThDt5CMA
#### Description:
This project is an Android-based Tic Tac Toe game application consisting of two main activities: MainActivity and GameActivity.

##### MainActivity
The MainActivity class serves as the entry point of the application. It presents the user with a simple UI to input player names and start the game. The UI is defined in the activity_main.xml layout file and includes:
    - TextViews for displaying static text, such as the title "Tic Tac Toe" and developer's name "Dan Ngo".
    - EditTexts for players to enter their names.
    - Button to start the game, which is linked to the startGame method.

The startGame method retrieves the entered player names, packs them into an Intent, and starts the GameActivity. If no names are entered, defaults ("Player A" and "Player B") are used.

##### GameActivity
The GameActivity class is responsible for the core functionality of the Tic Tac Toe game. It includes the following elements:
    - TextViews for displaying player names and indicating the current turn.
    - GridLayout containing nine buttons representing the Tic Tac Toe grid.
    - Button to exit the game and return to MainActivity.

The onCreate method initializes the game by setting player names from the Intent, setting up the grid buttons, and indicating whose turn it is. The initiateGame method links the grid buttons to the corresponding array elements.

##### Game Logic
The game logic is implemented in the gridClick method, which handles button clicks on the grid. This method checks if a grid cell is empty before marking it with "X" or "O" based on the current player's turn. It then checks for a win or a draw using the checkWin method.
    - checkWin: This method checks all rows, columns, and diagonals for three matching symbols indicating a win.
    - updateTurn: Updates the turn indicator.
    - showMessage: Displays a Toast message announcing the game's outcome.
    - restartGame: Resets the game state for a new round.

##### Layout Files
activity_main.xml: Defines the layout for the MainActivity, containing elements like TextView, EditText, and Button.
activity_game.xml: Defines the layout for the GameActivity, including the grid layout for the game board and text views for displaying player names and the current turn.

##### Summary
This project showcases an interactive Tic Tac Toe game for Android, demonstrating fundamental concepts like UI design, event handling, and inter-activity communication using Intents. The game's logic is simple yet effective, providing a basic but complete user experience.
