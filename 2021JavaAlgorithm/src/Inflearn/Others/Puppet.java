package Inflearn.Others;

import java.util.*;

/**
 *�����̱�� ����� Puppet Draw��.
 *  Queue �� peek�� ���� ���� ����� ��� �о��.
 *  ArrayList�� ���� �� �ȿ� Stack �� ������� �߾��µ�,
 * �� stack �� peek() �ϸ� empty stackException�� ��.
 * �ӽ÷� ������� ��. doub[j][pos-1]
 * ���� ���ǹ��� �ɰ�, �ѹ��� ����ϰ� �ϴ� �䱸���� ó���� ���� ������.
 * ���� ���� ��, 2�����迭.length() �� = 2�����迭[0].length()
 * 1��: ������ ã�Ƽ� push �ϱ� 2�� if: Stack �� ������� �ʰ�(peek)�� �Ϸ���, stack �� ������. tmp �� stack.peek() �� ���ٸ�, pop�����ֱ�.
 * for, if, break Ȱ��.
 * break �� �ڽ��� ���Ե� ���� ����� �ݺ����� �����.
 * else �� block ���� �� ���, ���� 2�� �ȴ�. ������, break �� else ��Ͽ��� ����ǰ� if ��Ͽ��� ������� �ʾƼ�,
 * if ������ ���� �Ǿ��� �� �ι�° for ���� �� �� ������ �����̴�. if ���� break �� ������ ������ �ȴ�.
 */

public class Puppet {
    public int solution(int[][] doub, int n, int[] moves) {
        int answer = 0;
        Stack<Integer> movedArr = new Stack<>();
        for(int pos: moves) {
            for (int j = 0; j < doub.length; j++) {
                //0�� �ƴ� = ������ ã�Ҵ�.0�� �ƴ϶��, ������ 0���� ������ �� (���� �������ο� �������.
                //tmp �� ���������� ������, ��ġ�� 0���� �ٲ� ä�� ���� ���ϰ� ��.
                if (doub[j][pos-1]!=0) {
                    int tmp = doub[j][pos-1];
                    doub[j][pos-1] = 0;
                    //movedArr�� ������� �ʰ� peek �� ���� ���Ұ� ���ٸ� Pop
                    if(!movedArr.isEmpty()&&tmp == movedArr.peek()){
                            answer = answer + 2;
                            movedArr.pop();
                    //�� �� ��� ���� movedArr �� ����ִ�, peek �� ���� �ʴ� push �Ѵ�.
                    } else movedArr.push(tmp);
                        break; //���� ����� �ݺ����� doub.length ���� for��,
                    }
                }
                }
//            break; //break: �ڽ��� ���Ե� ���� ����� �ݺ����� �����.
        return answer;
    }

    public static void main(String[] args){
        Puppet T = new Puppet();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //2���� �迭�� ���� ����� ����ȭ�ϱ�
        int[][] doub = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                    doub[i][j] = sc.nextInt();
            }
        }
        int movesCnt = sc.nextInt();
        int[] moves = new int[movesCnt];
        for(int i=0;i<movesCnt;i++){ //movesCnt ������ �迭�� �����.
            moves[i] = sc.nextInt();
        }
        System.out.println(T.solution(doub, n, moves));
    }
}
