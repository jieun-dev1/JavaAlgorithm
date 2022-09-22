package Programmers.Level1;


/*
숫자를 String 으로 변환: Integer.toString은 toString(), Integer.toString(int i)등의 형태로 사용 가능. 둘다 반환 결과는 똑같다.
String을 숫자로 변환 Integer.parseInt() [primitive int type]  or Integer.valueOf()[Integer object]
replaceAll 로는 정규식을 사용할 수 있다.

그냥 s를 쓰면 numberformatException 에러가 남(replace 함수를 제대로 쓰지 않았기 때문임)
numberformatException은 숫자만 주어진게 아니라, 숫자+문자열 조합, 문자열 등이 주어졌을 떄, 문자열을 숫자형으로 바꿀 수 없어서 나는 에러다.
S = s.replace()를 호출해서 재할당해줘야 함.

입출력 예
입력: "one4seveneight"
출력: 1478
 */

import java.util.Scanner;

public class ConvertStrToNum {
    public int solution(String s) {
        int answer = 0;
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0;i<arr.length;i++) {
            //원소 zero == 0 . arr[i]가 존재하면 대체해준다는 뜻.
           s = s.replace(arr[i],Integer.toString(i));
        }
        answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConvertStrToNum T = new ConvertStrToNum();

        String s = sc.nextLine();
        System.out.println(T.solution(s));
    }
}
