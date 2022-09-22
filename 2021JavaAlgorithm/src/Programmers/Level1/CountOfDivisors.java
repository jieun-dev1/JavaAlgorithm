package Programmers.Level1;

import java.util.Scanner;

public class CountOfDivisors {
    public int solution(int left, int right) {
        int answer = 0;
        int[] cntOfDivisors = new int[right+1]; //cntOfDivisors 는 0부터 17(right)까지 인덱스를 가짐. 인덱스의 값 (해당 인덱스의 약수의 개수)
        int length = right-left+1; //17-13+1 = 5
        int[] num = new int[length];
        for(int i=0;i<length;i++) {
            num[i] = left+i; //int[] num = {13,14,15,16,17};
        }

        //약수 구하기
        //13을 읽을 때, 1 - 6.5까지 순회하면서 나눔.
        for(int i=0;i<num.length;i++) {
            //자기자신을 default 로 더한다 첫 번쨰 for 문이 돌 때마다, cnt 가 초기화 되어야 하니,for 문 안에서 변수를 초기화
            int cnt = 1;
            for(int j=1;j<=(int)num[i]/2;j++) { //13을 1부터 6까지 나눈다.
                if(num[i]%j==0) {
                    cnt++; //약수의 개수를 구하는 거니까 나머지가 0일 떄, cnt를 ++:
                }
            }
            cntOfDivisors[num[i]]= cnt;
            if(cnt%2 ==0) {
                answer+=num[i];
            } else {
                answer-=num[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CountOfDivisors T = new CountOfDivisors();
        int left = sc.nextInt();
        int right = sc.nextInt();
        System.out.println(T.solution(left, right));
    }
}
