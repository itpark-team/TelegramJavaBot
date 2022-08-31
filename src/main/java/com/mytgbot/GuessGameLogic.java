package com.mytgbot;

import java.util.Random;

public class GuessGameLogic {
    private Random random;
    private int compNumber;

    public GuessGameLogic() {
        random = new Random();
    }

    public void startNewGame() {
        compNumber = random.nextInt(100) + 1;
    }

    public String processUserNumber(int userNumber) {
        if (userNumber < compNumber) {
            return "введи побольше";
        } else if (userNumber > compNumber) {
            return "введи поменьше";
        } else {
            return "угадал";
        }
    }
}
