package Programmers.Level1;

import java.util.Arrays;

/*
2차원 배열을 읽어온다. 2차원 배열의 i번째 원소를 꺼낸다.
1번째 원소의 i(first)와 j(second)를 읽어온다. array[i-1:j-1] 을 가져온다.
오름차 순으로 정렬한다.
k번째 숫자를 인쇄한다.
int[] result = new int[commands.length]. result 배열에 하나씩 넣기.

참고
(1) Arrays.asList;//배열을 ArrayList 로 변환해주는 것 (혼동해서 참고로 써둠)
(2) Arrays.copyOfRange(array, 시작, 끝 +1); 인덱스가 0부터 시작하니까, (주어진 시작 숫자-1, 끝 숫자)


 */
public class NumK {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; //주어진 Commands 의 갯수(길이)만큼 return 길이 설정.

        for(int i=0;i<commands.length;i++) {
            int first = commands[i][0];
            int second = commands[i][1];
            int k = commands[i][2];
            int[] arr2 = Arrays.copyOfRange(array, first-1, second);
            Arrays.sort(arr2);//오름차순으로 정렬해줌.
//            for(int j=0;i<arr2.length;i++) {
//                System.out.println(arr2[i]);
//            }
            answer[i] = arr2[k-1]; //arr2에 인덱스를 해서, answer에 따로 넣어줘야 함.
        }
            return answer;
    }

}
