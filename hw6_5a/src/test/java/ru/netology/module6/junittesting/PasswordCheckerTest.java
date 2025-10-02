package ru.netology.module6.junittesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


public class PasswordCheckerTest {

    private PasswordChecker myPassword;

    @BeforeEach
    void setUp() {
        myPassword = new PasswordChecker();
        myPassword.setMinLenght(9);
        myPassword.setMaxRepeats(3);
    }


    @org.junit.jupiter.api.Test
    public void testSetMinLenght_IllegalStateException() {

        Assertions.assertThrows(IllegalStateException.class, () -> {
            myPassword.setMinLenght(-1)
            ;
        });
    }

    @org.junit.jupiter.api.Test
    public void testSetMaxRepeats_IllegalStateException() {

        Assertions.assertThrows(IllegalStateException.class, () -> {
            myPassword.setMaxRepeats(-1);
            ;
        });

        Assertions.assertThrows(IllegalStateException.class, () -> {
            myPassword.setMaxRepeats(0);
            ;
        });
    }


    @org.junit.jupiter.api.Test
    public void testVerify_success() {

        final boolean answerFalse = myPassword.verify("аллоооооуууууу");
        Assertions.assertFalse(answerFalse);

        final boolean answerTrue = myPassword.verify("абвгдежзийк");
        Assertions.assertTrue(answerTrue);


    }


}
