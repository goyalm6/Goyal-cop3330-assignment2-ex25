package ex25;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static ex25.Main.passwordValidator;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void onlyNumbersShouldReturnTrue() {
        String str = "23627";
        int len = 5;
        Boolean result = ex25.Main.onlyNumbers(str, len);
        assertTrue(result);
    }

    @Test
    void onlyNumbersShouldReturnFalse() {
        String str = "wueyu";
        int len = 5;
        Boolean result = ex25.Main.onlyNumbers(str, len);
        assertFalse(result);
    }

    @Test
    void hasSpecialCharShouldReturnTrue() {
        String str = "dgw#w";
        Boolean result = ex25.Main.hasSpecialChar(str);
        assertTrue(result);
    }

    @Test
    void hasSpecialCharShouldReturnFalse() {
        String str = "dgwkw";
        Boolean result = ex25.Main.hasSpecialChar(str);
        assertFalse(result);
    }

    @Test
    void passwordValidatorShouldReturnEmptyString() {
        String pwd = "test";
        String result = passwordValidator(pwd);
        Assert.assertEquals("", "");
    }

    @Test
    void passwordValidatorShouldReturnVeryWeak() {
        String pwd = "123426";
        String result = passwordValidator(pwd);
        Assert.assertEquals("very weak", "very weak");
    }

    @Test
    void passwordValidatorShouldReturnWeak() {
        String pwd = "sfsgs";
        String result = passwordValidator(pwd);
        Assert.assertEquals("weak", "weak");
    }

    @Test
    void passwordValidatorShouldReturnStrong() {
        String pwd = "abcd12345";
        String result = passwordValidator(pwd);
        Assert.assertEquals("weak", "weak");
    }

    @Test
    void passwordValidatorShouldReturnVeryStrong() {
        String pwd = "test1234!";
        String result = passwordValidator(pwd);
        Assert.assertEquals("weak", "weak");
    }
}