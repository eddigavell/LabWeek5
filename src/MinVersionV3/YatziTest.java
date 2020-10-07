package MinVersionV3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class YatziTest {

    @Test
    void isYatziWhenAllDiceMatches() {
        Die[] dice = new Die[5];
        for (int i= 0; i<5; i++) {
            dice[i] = new Die();
            dice[i].setDieValue(6);
        }
        assertTrue(YatziMain.checkIfYatzi(dice));
    }

    @Test
    void isNotYatziWhenOneDieIsNotMatchingTheOther() {
        Die[] dices = new Die[5];
        for (int i=0; i<5; i++) {
            dices[i] = new Die();
            if (i == 4 ) {
                dices[i].setDieValue(1);
            } else {
                dices[i].setDieValue(6);
            }
        }
        assertFalse(YatziMain.checkIfYatzi(dices));
    }
}
