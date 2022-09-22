package Programmers.Level1;

import java.util.HashSet;
import java.util.Set;

/*
nums[] 에서 고유값을 key로 만들어 저장한다.
nums 의 개수를 value 로 저장한다.
Math.Min(key의 수, nums/2)

다형성
왜 업캐스팅을 할까?
ex. Student student = new Student();
Human student = student;
(1) 자식 타입의 인스턴스를 만들고, 부모 타입으로 변환하라.
자식 타입이 부모 타입에 정의된 메서드/변수에만 접근하게 하려고.

(2) 매개변수로 부모 타입을 줄 때, 분기 처리를 안해도 됨.
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
