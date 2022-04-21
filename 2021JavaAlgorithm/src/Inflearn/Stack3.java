package Inflearn;

import java.util.*;

//���� ���� ��� 2���� �迭�� Į������ [0,1],[1,1],[2,1]... Stack �� ������� �� ������? [i][pos-1]
//������ �ϼ��ϰ� ���� ���� �ȿ��� ���Ӱ��� �Ͷ߸� ����� ��������.. �׷��ϱ� ������ �״� ��������  �� ��.
//else ��� �ȿ� break�� ������, �ڵ尡 ���� �� break�� ���� �ʰ�, ������ �ϳ� �� �����Ե�.

public class Stack3 {
    public int solution(int[][] arr, int[] moveArr) {
        Stack<Integer> sc = new Stack<>();
        int answer = 0;
        //2���� �迭 for ���� ���鼭, if 0�� �ƴ� ��. stack�� push �ϰ�. 0���� �ٲٰ�
        //�ذ�å: �ӽ� int ���� ���� ���⼭ ��. �׸��� �� �� ���� ���� 0���� �ٲ��־�� ���� ���� �о�� �� ����.
        for(int i=0;i<moveArr.length;i++){
            int pos = moveArr[i]-1;
            for(int j=0;j<arr.length;j++) {
                if (arr[j][pos] != 0) {
                    int tmp = arr[j][pos];
                    arr[j][pos] = 0;
                    if (!sc.empty() && sc.peek()==tmp) {
                        answer +=2;
                        sc.pop();
                    }
                    else
                        sc.push(tmp);

                    break;
                    //push �� �������� �׸� �־�� ��. break �� for �� Ż�� �� ���� column����. //break�� else ��Ͽ� ������, (!sc.empty() && sc.peek()==tmp �ڵ尡 ���� �� break�� �ȵȴ�.
                  //�� �÷��� �о����� true�̵� false �̵� break�� ������ �ؾ��Ѵ� �׷��� ������
                  //{} ����� ���� ������ �ϳ��� ������ ���� �� ����. �ϳ� ���� ���� {} �Ƚᵵ �ȴ�. ���⼭�� else �϶��� push �� ���常 �ϸ� �Ǵϱ� ��ȣ ���� ����.
                  //break�� ������ ���� for���� Ż���Ѵ�. ������ i=1�� �Ѿ.

                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack3 T = new Stack3();
        Scanner sc = new Scanner(System.in);
        int column = sc.nextInt();
        //ex) column ����x���� 2���� �迭 ����
        int[][] arr = new int[column][column];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int move = sc.nextInt();
        int[] moveArr = new int[move];
        for(int i=0;i<moveArr.length;i++){
            moveArr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr, moveArr));

        }
    }
