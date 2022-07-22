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

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Test2() {
        String s = "z";
        int n = 1;
        String actual = this.cipher.solution(s, n) ;
        String expected = "a";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Test3() {
        String s = "a B z";
        int n = 4;
        String actual = this.cipher.solution(s, n) ;
        String expected = "e F d";

        Assert.assertEquals(expected, actual);
    }
}
