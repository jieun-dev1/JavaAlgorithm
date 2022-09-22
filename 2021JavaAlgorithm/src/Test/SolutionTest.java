package Test;

import Sample.Solution;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//���� �׽�Ʈ: https://school.programmers.co.kr/learn/courses/30/lessons/92334

public class SolutionTest {

    private Solution solution;

    //�Ʒ� �ڵ带 ������ ������, NULL POINTER EXCEPTION �� ���.
    //�ٸ� ������ new Solution �̶�� ���������� �ʾұ� ������ Before ���� �ؾ���.
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