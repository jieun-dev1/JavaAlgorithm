package Inflearn.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * (1) �켱�� ������������ ����
 */

class Meeting implements Comparable<Meeting> {
    int startAt;
    int endAt;

    Meeting(int startAt, int endAt) {
        this.startAt = startAt;
        this.endAt = endAt;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.startAt == o.startAt) {
            return this.endAt - o.endAt;
        } else {
            return this.startAt - o.startAt;
        }
    }
}
class Arrange {

    public int solution(ArrayList<Meeting> arr, int cnt) {
        ArrayList<Integer> answerList = new ArrayList<>();
//        int answer=0; //���� �����ϸ� answer �� ���� �ε��� ������ �߰���.
        for(int i=0; i<cnt-1;i++) {
            int answer=1; //������ �ش� ȸ�ǽ� 1���� �����ϱ�.
            int tmp = arr.get(i).endAt;

            for(int j=i+1;j<cnt;j++) {
//                int tmp = arr.get(i).endAt; //�Ǽ�: ���� �����ϸ� endAt���� ������Ʈ �� �� �ٽ� ���� ��.
                if(tmp <= arr.get(j).startAt) {
                    tmp = arr.get(j).endAt;
                    answer ++;
                }

                else {
                    continue;
                }
            }
            answerList.add(answer);
        }

        return Collections.max(answerList);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrange T = new Arrange();
        ArrayList<Meeting> arr = new ArrayList<>();
        int cnt = sc.nextInt();
        for(int i=0;i<cnt;i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr.add(new Meeting(start, end));
        }
        Collections.sort(arr);

        System.out.println(T.solution(arr, cnt));
    }
}
