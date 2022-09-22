package Programmers.Level1;

/*
완전탐색

막히는 부분: 2차원 배열에서 index를 어떻게 찾지?
배열이 아니라, stack, Queue 등 다른 구조를 활용해야 하나?

 1. 긴 숫자를 한 쪽으로 몰아넣는다.(ex. w - 가로 길이)
 2. 0번째를 읽으면서 가로 길이의 최대값을, 1번째를 읽으면서 세로 길이의 최대값을 찾는다.
 */
public class MinSquare {
    public int solution(int[][] sizes) {
        int answer = 0;
        int temp = 0;
        int maxW = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;
        for(int i=0;i<sizes.length;i++) {
                if (sizes[i][0]<sizes[i][1]) {
                    temp = sizes[i][1];
                    sizes[i][1] = sizes[i][0];
                    sizes[i][0] = temp;
                } //바꿈
            }

        for(int i=0;i<sizes.length;i++) {
            maxW = Math.max(maxW, sizes[i][0]);
            maxH = Math.max(maxH, sizes[i][1]);
        }

        answer = maxW*maxH;

        return answer;
    }
}
