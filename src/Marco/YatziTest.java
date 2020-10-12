package Marco;

import org.junit.jupiter.api.Test;

public class YatziTest {

    @Test
    void isYatziWhenAllDiceMatches() {
        Dices[] dice = new Dices[5];
        for(Dices die: dice) {
            die.value = 6;
        }
        //Assert something?
    }

    @Test
    void isNotYatziWhenOneDieIsNotMatchingTheOther() {
        Dices[] dice = new Dices[5];
        for(Dices die: dice) {
            die.value = 6;
        }
        dice[5].value = 1;
        //Assert something?
    }
}
