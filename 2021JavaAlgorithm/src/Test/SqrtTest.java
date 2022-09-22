package Test;

import Programmers.Level1.Sqrt;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//10,11,12,14,2,4,7 ½ÇÆÐ

public class SqrtTest {

    private Sqrt sqrt;

    @Before
    public void init(){
        sqrt = new Sqrt();
    }

    @Test
    public void Test1() {
        int n = 3;
        long actual = sqrt.solution((long)3);
        long expected = -1;
        Assert.assertEquals(expected, actual);

    }
}
