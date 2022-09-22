package Inflearn.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
Comparable �� ������ ���� Ŭ������ ���׸� Ÿ���� ������� �Ѵ�.
���׸��� �� ����?
(1) ����ȯ�� ���ŷο��� ���̷��� - ������ �ʴ� Ÿ���� ����Ǵ� �� ��
(2) ��ü�� Ÿ���� ������ �� üũ�ؼ� Ÿ�� �������� ��������.
(3) Ÿ�� üũ, ����ȯ�� �ذ�Ǵ� �ڵ尡 ����������.

Comparable
���ڵ� ascending order �� �����ȴ�. �ð��� ���� ���, ������ �ð���(end) ���� �;� �Ѵ�. �׷��� ������ �ð�����(end) ��������� �տ� �ִ� ���ĺ� �ֱ�.
arrive, leave �� ���� ���� arrive �� �տ� leave �� �ڿ� ���ĵȴ�.
 */

class Visit implements Comparable<Visit> {
    int time;
    Character type;

    Visit(int time, Character type) {
        this.time = time;
        this.type = type;
    }

    @Override
    public int compareTo(Visit o) {
        if(this.time == o.time) {
            return this.type - o.type;
        }
        else {
            return this.time - o.time;
        }
    }
}

class Wedding {

    int count;
    int answer = 0;

    public int solution(ArrayList<Visit> arr) {
        //�ϳ��� arrayList�� ���鼭, s�� +, e��� -�� �Ѵ�.
        for(Visit o:arr) {
            if (o.type == 's')
                count++;
            else count --;
            answer = Math.max(count, answer);
        }
        return answer;
    }
//for each���� ���� n�� �Ѱ��� �ʿ䰡 ����. for������ ������ arr.get(i).type �̷� ������ �ؾ��ϴµ�, for each�� �ݺ����� �ξ� �����ϴ�.

    public static void main(String[] args) {
        Wedding T = new Wedding();
        Scanner sc = new Scanner(System.in);
        int guest = sc.nextInt();
        ArrayList<Visit> arr = new ArrayList<>();
        for (int i = 0; i < guest; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Visit(x, 's')); //���������� ǥ��
            arr.add(new Visit(y, 'e')); //������ ǥ��
        }

            Collections.sort(arr);
            //������ ����� �Ǿ����� Ȯ��
//            for (int i = 0; i < arr.size(); i++) {
//                System.out.println(arr.get(i).time + " " + arr.get(i).type);
//            }

            System.out.println(T.solution(arr));

        }
    }
