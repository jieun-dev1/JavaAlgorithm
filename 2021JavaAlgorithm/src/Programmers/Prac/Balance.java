package Programmers.Prac;

public class Balance {

    //int �� ���� ��� 19-22 ����.
    //price = 2500, count = 2500�� ��, int ������ �Ѿ.
    public long solution(long price, int money, long count) {
        return Math.max((count*(count+1)/2)*price - money,0);
    }
}

