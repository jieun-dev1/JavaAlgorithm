package Programmers.Prac;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
nums[] ���� �������� key�� ����� �����Ѵ�.
nums �� ������ value �� �����Ѵ�.
Math.Min(key�� ��, nums/2)

������
�� ��ĳ������ �ұ�?
ex. Student student = new Student();
Human student = student;
(1) �ڽ� Ÿ���� �ν��Ͻ��� �����, �θ� Ÿ������ ��ȯ�϶�.
�ڽ� Ÿ���� �θ� Ÿ�Կ� ���ǵ� �޼���/�������� �����ϰ� �Ϸ���.

(2) �Ű������� �θ� Ÿ���� �� ��, �б� ó���� ���ص� ��.
https://velog.io/@sezzzini/Java-Casting

 */
public class PocketMon {
    public int solution(int[] nums) {
        int answer = 0;
        Set hs = new HashSet();
        for(int i=0;i<nums.length;i++) {
            hs.add(nums[i]);
        }
        answer = Math.min(hs.size(), nums.length/2);

        return answer;
    }
}
