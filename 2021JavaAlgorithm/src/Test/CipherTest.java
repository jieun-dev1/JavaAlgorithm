package Test;

import Programmers.Cipher;
import org.junit.*;

public class CipherTest {
    private Cipher cipher;

    @Before
    public void init() {
        cipher = new Cipher();
    }

    @Test
    public void Test1() {
        String s = "AB";
        int n = 1;
        String actual = this.cipher.solution(s, n) ;
        String expected = "BC";

        Assert.assertEquals(actual, expected);
    }

}
