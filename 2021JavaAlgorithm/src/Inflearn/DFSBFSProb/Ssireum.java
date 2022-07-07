package Inflearn.DFSBFSProb;

//x�� y��� �� �� �������, answer arraylist ���� �����ϱ�.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Greedy: ���� �ð����� �ּ��� ������ �ϴ� ��.
 * Ű ������ ������ �� ù ��° ���� ������  answer ++;
 * ���� ����, ��� �����԰� max ������ ũ�ٸ� (�ڽź��� Ű�� ū ������ ������ ��) ++;
 *
 */
class Spec implements Comparable<Spec> {
    int x;
    int y;

    Spec(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //�������� ������ �ʿ���.
    @Override
    public int compareTo(Spec o) {
            if(this.x == o.x)  return o.y-this.y;
            else return o.x - this.x;
        }
    }

class Ssireum {

    public int solution(ArrayList<Spec> arr) {
        int max = Integer.MIN_VALUE; //Min Value ���� �����ϸ� ù��° ���� ������ ++ ��.
        int answer = 0;
        //������ ������ ������ �Ǿ� ���� �� ù ���� ���� ������ ���� max ���� ũ��.
        //if �� �� ���� �� {} ����� �ִ� �� �������. �׷��� ������ if ���ο� ������� ����.
        for(Spec ob:arr) {
            if(ob.y>max) {
                max = ob.y;
                answer ++;
            }
            }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ssireum T = new Ssireum();
        int cnt = sc.nextInt();
        ArrayList<Spec> arr = new ArrayList<>();

        for(int i=0;i<cnt;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Spec(x,y));
        }

        Collections.sort(arr);
//        for(Spec o:arr) {
//            System.out.println(o.x+" "+o.y);
//        }
        System.out.println(T.solution(arr));

    }
}
