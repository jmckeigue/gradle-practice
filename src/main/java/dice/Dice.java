package dice;

import java.util.Random;

public class Dice {
    public int roll(int sides) {
        Random random = new Random();

        return random.nextInt(sides) + 1;
    }
}