package Programmers.Prac;

//�ڱ��ڽ��� �����ְ�, 1���� �ڱ��ڽ��� ���� ������ ��ȸ�Ѵ�.
public class Divisor {
    public int solution(int n) {
        int answer = 0;
        answer+=n;
        for(int i=1;i<=2/n;i++) {
            if(n%i==0) { //�������� 0�̸�
                answer+=n/i; //���� �����ش�
            }
        }
        return answer;
    }
}
