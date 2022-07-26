package Test;

import Programmers.Prac.FailureRate;
import Programmers.Prac.NumK;
import org.junit.*;
import org.junit.Before;

public class NumKTest {
    private NumK numK;

    @Before
    public void init() {
        numK = new NumK();
    }

    @Test
    public void Test1() {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands  = {{2,5,3},{4,4,1},{1,7,3}};
        int[] actual = this.numK.solution(array,commands);
        int[] expected = {5,6,3};
        Assert.assertArrayEquals(actual, expected);
    }

    //통과가 안됨. 끝까지 통과한 사람이 없는 경우. 1이 실패율 1이기 때문에, 1,2,3 이어야함. 2,3은 NAN 이 찍힌다.

}
