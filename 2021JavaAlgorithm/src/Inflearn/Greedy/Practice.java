//package Inflearn.Greedy;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Practice {
//
//    public int solution(int n, int[] lost, int[] reserve) {
//        int answer = 0;
//        int noShow = 0; // ���������� ü������ �����ϴ� �л� ��.
//
//        //�־��� �迭�� ArrayList�� ���
//        ArrayList<Integer> lostList = new ArrayList<Integer>();
//        for (int i = 0; i < lost.length; i++) {
//            lostList.add(lost[i]);
//        }
//
//        ArrayList<Integer> reserveList = new ArrayList<Integer>();
//        for (int i = 0; i < reserve.length; i++) {
//            reserveList.add(reserve[i]);
//        }
//
//        //lost �� reserve �� ��� �����ϴ� ���� �ִٸ� �������ֱ� - ������ �����Դµ�, �Ҿ���� = �� ������ & ������ ���� ����
//        //�Ʒ� �ڵ�� �������� �������� �� ����. (�̹� lostList ���� ������ �Ǿ ������� ��ã��)
//
//        ArrayList<Integer>dupList = new ArrayList<>();
//        dupList.addAll(reserveList);
//        dupList.retainAll(lostList);
//
//        lostList.removeAll(dupList);
//        reserveList.removeAll(dupList);
//
////        //���� for ���� ���� ��������? - Queue �� ��Ƽ� ���غ�
////        Queue<Integer> lostQ = new LinkedList<>();
////        for (int i : lost) {
////            lostQ.offer(i);
////        }
////
////        ArrayList<Integer> removedList = new ArrayList<>();
////        //reserveList �� ���������� ������, lost �� �� ���Ұ� reserveList �� �翷 ���� �� filter �� �ȵ��� ������?
////        for (int j : reserveList) {
////            if (!lostQ.isEmpty()) {
////                if (j == lostQ.peek() - 1 || j == lostQ.peek() + 1) {
////                    removedList.add(lostQ.poll()); //poll()�ϸ鼭 reserveList������ �����ش�.
////                }
////            }
////
////            if (!removedList.isEmpty()) {
////                reserveList.removeAll(removedList);
////            }
////        }
////
////        //lostQ�� �����Ѵٸ�, lostQ�� ũ�⸦ ��ȯ.
////
////        if(lostQ.isEmpty()) noShow = 0;
////        else {
////            noShow = lostQ.size();
////        }
////
////        answer = n - noShow;
////        //�� �迭�� ���� ��.
////        return answer;
//    }
//
//
//    public static void main(String[] args) {
//        Practice T = new Practice();
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        T.solution();
//
//    }
//}
