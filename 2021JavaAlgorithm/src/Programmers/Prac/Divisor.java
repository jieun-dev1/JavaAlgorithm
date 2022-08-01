package Programmers.Prac;

//자기자신은 더해주고, 1부터 자기자신의 절반 까지만 순회한다.
public class Divisor {
    public int solution(int n) {
        int answer = 0;
        answer+=n;
        for(int i=1;i<=2/n;i++) {
            if(n%i==0) { //나머지가 0이면
                answer+=n/i; //몫을 더해준다
            }
        }
        return answer;
    }
}
