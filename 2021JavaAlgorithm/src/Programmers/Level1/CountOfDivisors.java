package Programmers.Level1;

import java.util.Scanner;

public class CountOfDivisors {
    public int solution(int left, int right) {
        int answer = 0;
        int[] cntOfDivisors = new int[right+1]; //cntOfDivisors �� 0���� 17(right)���� �ε����� ����. �ε����� �� (�ش� �ε����� ����� ����)
        int length = right-left+1; //17-13+1 = 5
        int[] num = new int[length];
        for(int i=0;i<length;i++) {
            num[i] = left+i; //int[] num = {13,14,15,16,17};
        }

        //��� ���ϱ�
        //13�� ���� ��, 1 - 6.5���� ��ȸ�ϸ鼭 ����.
        for(int i=0;i<num.length;i++) {
            //�ڱ��ڽ��� default �� ���Ѵ� ù ���� for ���� �� ������, cnt �� �ʱ�ȭ �Ǿ�� �ϴ�,for �� �ȿ��� ������ �ʱ�ȭ
            int cnt = 1;
            for(int j=1;j<=(int)num[i]/2;j++) { //13�� 1���� 6���� ������.
                if(num[i]%j==0) {
                    cnt++; //����� ������ ���ϴ� �Ŵϱ� �������� 0�� ��, cnt�� ++:
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
