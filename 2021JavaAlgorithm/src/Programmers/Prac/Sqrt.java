package Programmers.Prac;

public class Sqrt {
    public long solution(long n) {
        long answer = 0;
        double result = Math.sqrt(n);
        if(result == Math.floor(result)) {
//            answer = (long) Math.pow((result+1),2); //Math.pow Ȱ���ϱ�.
//            answer = (long) ((result+1)*(result+1)); //OK
// �Ʒ� �ڵ�� �ϸ�, �Ϻ� �׽�Ʈ fail ��. answer�� Long �ε� (int)�� ��ȯ�� ���� ����
//            answer = (int)(result+1)*(int)(result+1);

        } else {
            answer = -1;
        }
        return answer;
    }
}
