package Test;

import Inflearn.Greedy.Training;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProgrammersTest {
    private Training training;

    //Solution 객체를 만들어줘야 시작할 수 있음.
    @Before
    public void init() {
        this.training = new Training();
    }

    @Test
    public void test1() {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        int answer = 5;

        int result = training.solution(n, lost, reserve);
        Assert.assertEquals(answer, result);
    }
    //테스트 케이스를 넣어 테스트
    //Assert 로 확인


    @Test
    public void test2() {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {3};
        int answer = 4;

        int result = training.solution(n, lost, reserve);
        Assert.assertEquals(answer, result);
    }

    @Test
    public void test3() {
        int n = 3;
        int[] lost = {1,2};
        int[] reserve = {2,3};
        int answer = 2;

        int result = training.solution(n, lost, reserve);
        Assert.assertEquals(answer, result);
    }

    @Test
    public void test4() {
        int n = 5;
        int[] lost = {1,2};
        int[] reserve = {2,3};
        int answer = 4;

        int result = training.solution(n, lost, reserve);
        Assert.assertEquals(answer, result);
    }

    @Test
    public void test5() {
        int n = 5;
        int[] lost = {4,2};
        int[] reserve = {1,5,3};
        int answer = 5;

        int result = training.solution(n, lost, reserve);
        Assert.assertEquals(answer, result);
    }

    @Test
    public void test6() {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {3,1};
        int answer = 5;

        int result = training.solution(n, lost, reserve);
        Assert.assertEquals(answer, result);
    }

}
