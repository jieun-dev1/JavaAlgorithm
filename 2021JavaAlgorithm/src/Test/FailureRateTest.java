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

    //����� �ȵ�. ������ ����� ����� ���� ���. 1�� ������ 1�̱� ������, 1,2,3 �̾����. 2,3�� NAN �� ������.
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

