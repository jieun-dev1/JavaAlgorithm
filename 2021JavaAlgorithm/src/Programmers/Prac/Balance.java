package Programmers.Prac;

public class Balance {

    //int 로 했을 경우 19-22 실패.
    //price = 2500, count = 2500일 때, int 범위를 넘어섬.
    public long solution(long price, int money, long count) {
        return Math.max((count*(count+1)/2)*price - money,0);
    }
}

