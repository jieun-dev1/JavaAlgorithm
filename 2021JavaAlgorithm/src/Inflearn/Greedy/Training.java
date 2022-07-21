package Inflearn.Greedy;

import java.util.*;

/*
 전체 카운트 - lost 학생 수: default 값
 lost 배열을 Queue에 넣는다.
 if lost[i] 가 reserve 의 앞이나 뒤라면, +1을 리턴.
 reserve 배열 읽기

  */
public class Training {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int noShow = 0; // 최종적으로 체육수업 불참하는 학생 수.

        //주어진 배열을 ArrayList에 담기
        ArrayList<Integer> lostList = new ArrayList<Integer>();
        for (int i = 0; i < lost.length; i++) {
            lostList.add(lost[i]);
        }

        ArrayList<Integer> reserveList = new ArrayList<Integer>();
        for (int i = 0; i < reserve.length; i++) {
            reserveList.add(reserve[i]);
        }

        //lost 와 reserve 에 모두 존재하는 값이 있다면 제거해주기 - 여벌을 가져왔는데, 잃어버림 = 못 빌려줌 & 수업은 참여 가능
        ArrayList<Integer>dupList = new ArrayList<>();
        dupList.addAll(reserveList);
        dupList.retainAll(lostList);
        lostList.removeAll(dupList);
        reserveList.removeAll(dupList);

        //이중 for 문을 쓰지 않으려면? - Queue 에 담아서 비교해봄
        Queue<Integer> lostQ = new LinkedList<>();
        for (int i : lostList) {
            lostQ.offer(i);
        }

        ArrayList<Integer> removedList = new ArrayList<>();
        //reserveList 를 삭제해주지 않으면, lost 의 두 원소가 reserveList 의 양옆 값일 때 filter 가 안되지 않을까?
        for (int j : reserveList) {
            if (!lostQ.isEmpty()) {
                if (j == lostQ.peek() - 1 || j == lostQ.peek() + 1) {
                    removedList.add(lostQ.poll()); //poll()하면서 reserveList에서도 지워준다.
                }
            }

            if (!removedList.isEmpty()) {
                reserveList.removeAll(removedList);
            }
        }

        //lostQ가 존재한다면, lostQ의 크기를 반환.

        if(lostQ.isEmpty()) noShow = 0;
        else {
            noShow = lostQ.size();
        }

        answer = n - noShow;
        //두 배열의 원소 비교.
        return answer;
    }
    }


    //Queue 사용한 경우

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
//                //위에 해당하지 않는다면 lostQ는 그대로 있음.
//            }
//
//            //Q가 비어 있다면 더 이상 반복하지 않는다.
//            else  {
//                break;
//            }
//            //QUEUE가 아니라 RESERVE가 비어있는지 체크해야 하지 않나?
//        }
//
//        if(lostQ.isEmpty()) noShow = 0;
//        else {
//            noShow = lostQ.size();
//        }
//
//        answer = n - noShow;
//        //두 배열의 원소 비교.
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


