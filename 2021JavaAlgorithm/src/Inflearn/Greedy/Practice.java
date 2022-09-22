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
//        int noShow = 0; // 최종적으로 체육수업 불참하는 학생 수.
//
//        //주어진 배열을 ArrayList에 담기
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
//        //lost 와 reserve 에 모두 존재하는 값이 있다면 제거해주기 - 여벌을 가져왔는데, 잃어버림 = 못 빌려줌 & 수업은 참여 가능
//        //아래 코드는 교집합을 삭제해줄 수 없음. (이미 lostList 에서 삭제가 되어서 공통원소 못찾음)
//
//        ArrayList<Integer>dupList = new ArrayList<>();
//        dupList.addAll(reserveList);
//        dupList.retainAll(lostList);
//
//        lostList.removeAll(dupList);
//        reserveList.removeAll(dupList);
//
////        //이중 for 문을 쓰지 않으려면? - Queue 에 담아서 비교해봄
////        Queue<Integer> lostQ = new LinkedList<>();
////        for (int i : lost) {
////            lostQ.offer(i);
////        }
////
////        ArrayList<Integer> removedList = new ArrayList<>();
////        //reserveList 를 삭제해주지 않으면, lost 의 두 원소가 reserveList 의 양옆 값일 때 filter 가 안되지 않을까?
////        for (int j : reserveList) {
////            if (!lostQ.isEmpty()) {
////                if (j == lostQ.peek() - 1 || j == lostQ.peek() + 1) {
////                    removedList.add(lostQ.poll()); //poll()하면서 reserveList에서도 지워준다.
////                }
////            }
////
////            if (!removedList.isEmpty()) {
////                reserveList.removeAll(removedList);
////            }
////        }
////
////        //lostQ가 존재한다면, lostQ의 크기를 반환.
////
////        if(lostQ.isEmpty()) noShow = 0;
////        else {
////            noShow = lostQ.size();
////        }
////
////        answer = n - noShow;
////        //두 배열의 원소 비교.
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
