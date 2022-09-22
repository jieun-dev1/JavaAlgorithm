package Test;

import Sample.Solution;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//참고 테스트: https://school.programmers.co.kr/learn/courses/30/lessons/92334

public class SolutionTest {

    private Solution solution;

    //아래 코드를 해주지 않으면, NULL POINTER EXCEPTION 이 뜬다.
    //다른 곳에서 new Solution 이라고 생성해주지 않았기 때문에 Before 에서 해야함.
    @Before
    public void init() {
        this.solution = new Solution();
    }

    @Test
    public void test1() {
        int[] result = this.solution.solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);


        Assert.assertArrayEquals(result, new int[]{2,1,1,0});
    }

    @Test
    public void test2() {
        int[] result = this.solution.solution(new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);


        Assert.assertArrayEquals(result, new int[]{0,0});
    }
}