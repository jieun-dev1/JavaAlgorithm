package Inflearn.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * �ٽ� Ǯ ��
 *
 * Comparable �������̽���?
 * �ش� �������̽��� ������ ��ü����
 * Collection.sort Ȥ�� Arrays.sort �� �ڵ� ����.
 *
 * (1) Comparable �� �����ϴ� Unit Ŭ���� ����.
 * (2) ���ڿ� ���� this ���� ���ؼ� �����Ѵ�.
 * (3) ArrayList �� ��� �μ����ش�.
 * Override�� �޼��忡�� ���� ������ ����ش�.
 */

class Unit implements Comparable<Unit>
        {
    int x;
    int y;

    Unit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Unit o) {
        if(this.x == o.x) return this.y-o.y; //���� ���� �������, this�� o ���� �տ� �´�. ������, o�� this ���� �տ� ��.
        else return this.x-o.x; // ���� �ʴٸ�, y���� �� �ʿ� ���� x ������ �����ָ� ��.
    }
}

class Coordinate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        ArrayList<Unit> arr = new ArrayList<>();

        for(int i=0;i<cnt;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.add(new Unit(a,b));
        }
        Collections.sort(arr); //sort �� ȣ���ϸ�,, compareTo�� ȣ���ؼ� ����.
        for(Unit o:arr) {
            System.out.println(o.x+" "+o.y);
        }
    }
}
