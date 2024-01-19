package dice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceTest {
  @Test
    public void checkDiceInRange() {
      Dice dice = new Dice();
    
      for (int i = 0; i < 100; i++) {
        int result = dice.roll(6);
        assertTrue(result >= 1 && result <= 6);
      }
    }
}

