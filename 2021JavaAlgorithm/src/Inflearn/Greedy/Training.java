package Inflearn.Greedy;

import java.util.*;

/*
 ��ü ī��Ʈ - lost �л� ��: default ��
 lost �迭�� Queue�� �ִ´�.
 if lost[i] �� reserve �� ���̳� �ڶ��, +1�� ����.
 reserve �迭 �б�

  */
public class Training {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int noShow = 0; // ���������� ü������ �����ϴ� �л� ��.

        //�־��� �迭�� ArrayList�� ���
        ArrayList<Integer> lostList = new ArrayList<Integer>();
        for (int i = 0; i < lost.length; i++) {
            lostList.add(lost[i]);
        }

        ArrayList<Integer> reserveList = new ArrayList<Integer>();
        for (int i = 0; i < reserve.length; i++) {
            reserveList.add(reserve[i]);
        }

        //lost �� reserve �� ��� �����ϴ� ���� �ִٸ� �������ֱ� - ������ �����Դµ�, �Ҿ���� = �� ������ & ������ ���� ����
        ArrayList<Integer>dupList = new ArrayList<>();
        dupList.addAll(reserveList);
        dupList.retainAll(lostList);
        lostList.removeAll(dupList);
        reserveList.removeAll(dupList);

        //���� for ���� ���� ��������? - Queue �� ��Ƽ� ���غ�
        Queue<Integer> lostQ = new LinkedList<>();
        for (int i : lostList) {
            lostQ.offer(i);
        }

        ArrayList<Integer> removedList = new ArrayList<>();
        //reserveList �� ���������� ������, lost �� �� ���Ұ� reserveList �� �翷 ���� �� filter �� �ȵ��� ������?
        for (int j : reserveList) {
            if (!lostQ.isEmpty()) {
                if (j == lostQ.peek() - 1 || j == lostQ.peek() + 1) {
                    removedList.add(lostQ.poll()); //poll()�ϸ鼭 reserveList������ �����ش�.
                }
            }

            if (!removedList.isEmpty()) {
                reserveList.removeAll(removedList);
            }
        }

        //lostQ�� �����Ѵٸ�, lostQ�� ũ�⸦ ��ȯ.

        if(lostQ.isEmpty()) noShow = 0;
        else {
            noShow = lostQ.size();
        }

        answer = n - noShow;
        //�� �迭�� ���� ��.
        return answer;
    }
    }


    //Queue ����� ���

//        Queue<Integer> lostQ = new LinkedList<>();
//        for(int i:lost) {
//            lostQ.offer(i);
//        }
//
//        for(int j:reserve) {
//            if(!lostQ.isEmpty()) {
//                if (j == lostQ.peek()-1 || j == lostQ.peek()+1) {
//                    lostQ.poll();
//                }
//                //���� �ش����� �ʴ´ٸ� lostQ�� �״�� ����.
//            }
//
//            //Q�� ��� �ִٸ� �� �̻� �ݺ����� �ʴ´�.
//            else  {
//                break;
//            }
//            //QUEUE�� �ƴ϶� RESERVE�� ����ִ��� üũ�ؾ� ���� �ʳ�?
//        }
//
//        if(lostQ.isEmpty()) noShow = 0;
//        else {
//            noShow = lostQ.size();
//        }
//
//        answer = n - noShow;
//        //�� �迭�� ���� ��.
//        return answer;
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Training T = new Training();
//        int n = sc.nextInt();
//        int lostN = sc.nextInt();
//        int[] lost = new int[lostN];
//        for(int i=0;i<lostN;i++){
//            lost[i] = sc.nextInt();
//        }
//        int reserveN = sc.nextInt();
//        int[] reserve = new int[reserveN];
//        for(int j=0;j<reserveN;j++){
//            reserve[j] = sc.nextInt();
//        }
//    }


