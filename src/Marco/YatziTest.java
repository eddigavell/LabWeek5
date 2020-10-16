package Marco;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class YatziTest {
    Die[] die = new Die[5];

    @Test
    void isYatziWhenAllDiceMatches() {
        for (int i= 0; i<5; i++) {
            die[i] = new Die();
            die[i].setDieValue(6);
        }
        assertTrue(YatziMain.checkIfYatzi(die));
    }

    @Test
    void isNotYatziWhenOneDieIsNotMatchingTheOther() {
        for (int i=0; i<5; i++) {
            die[i] = new Die();
            if (i == 4 ) {
                die[i].setDieValue(1);
            } else {
                die[i].setDieValue(6);
            }
        }
        assertFalse(YatziMain.checkIfYatzi(die));
    }
}
