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

    //����� �ȵ�. ������ ����� ����� ���� ���. 1�� ������ 1�̱� ������, 1,2,3 �̾����. 2,3�� NAN �� ������.

}
