package Inflearn.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 2�� �õ�.
 * Greedy:
 * (1) ȸ�ǰ� ���� �ð��� ������������ �����Ѵ�.
 * (2) ������ �ð��� �����ϴٸ� ���� �ð��� �������� ����.
 * ���� for ���� �ƴϾ �Ǵ� ����.
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
        if(this.endAt == o.endAt) {
            return this.startAt - o.startAt;
        } else {
            return this.endAt - o.endAt;
        }
    }
}

class Arrange {

    public int solution(ArrayList<Meeting> arr, int cnt) {
        int tmp = 0;
        int answer = 0;

        for (Meeting o : arr) {
            if (o.startAt >= tmp) {
                tmp = o.endAt;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Meeting> arr = new ArrayList<>();
        Arrange T = new Arrange();
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
