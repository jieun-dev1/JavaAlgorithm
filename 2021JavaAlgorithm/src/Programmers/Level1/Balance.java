package Programmers.Level1;

public class Balance {

    //int �� ���� ��� 19-22 ����.
    //price = 2500, count = 2500�� ��, int ������ �Ѿ.
    public long solution(int price, int money, int count) {

        long answer;
        long temp = 0;

        for(int i=count;i>0;i--) {
            temp+=price*i;
        }

        if(temp-money>0) {
            answer = temp-money;
        } else {
            answer = 0;
        }

        return answer;
    }
}

