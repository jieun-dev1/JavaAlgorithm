package Test;

import Programmers.Level1.FailureRate;
import org.junit.*;

public class FailureRateTest {

    private FailureRate failureRate;

    @Before
    public void init() {
        failureRate = new FailureRate();
    }

    @Test
    public void Test1() {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result = {3, 4, 2, 1, 5};
        int[] actual = this.failureRate.solution(N, stages);
        Assert.assertArrayEquals(result, actual);
    }

    //통과가 안됨. 끝까지 통과한 사람이 없는 경우. 1이 실패율 1이기 때문에, 1,2,3 이어야함. 2,3은 NAN 이 찍힌다.
    @Test
    public void Test2() {
        int N = 3;
        int[] stages = {1, 1, 1};
        int[] result = {1, 2, 3};
        int[] actual = this.failureRate.solution(N, stages);
        Assert.assertArrayEquals(result, actual);
    }

    @Test
    public void Test3() {
        int N = 5;
        int[] stages = {4, 4, 4, 4, 4};
        int[] result = {4, 1, 2, 3, 5};
        int[] actual = this.failureRate.solution(N, stages);
        Assert.assertArrayEquals(result, actual);
    }

    @Test
    public void Test4() {
        int N = 4;
        int[] stages = {1, 2, 3, 2, 1};
        int[] result = {3, 2, 1, 4};
        int[] actual = this.failureRate.solution(N, stages);
        Assert.assertArrayEquals(result, actual);
    }

    @Test
    public void Test5() {
        int N = 4;
        int[] stages = {1, 2, 3, 2, 1};
        int[] result = {3, 2, 1, 4};
        int[] actual = this.failureRate.solution(N, stages);
        Assert.assertArrayEquals(result, actual);
    }

    @Test
    public void Test6() {
        int N = 5;
        int[] stages = {2, 1, 2, 4, 2, 4, 3, 3};
        int[] result = {4, 3, 2, 1, 5};
        int[] actual = this.failureRate.solution(N, stages);
        Assert.assertArrayEquals(result, actual);
    }


}

