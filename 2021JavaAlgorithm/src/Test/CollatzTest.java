package Test;

import Programmers.Level1.Collatz;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CollatzTest {
    private Collatz collatz;

    @Before
    public void init() {
        collatz = new Collatz();
    }

    @Test
    public void Test1() {
        int n = 6;
        int actual = this.collatz.solution(n) ;
        int expected = 8;
        Assert.assertEquals(expected, actual);
    }
}
