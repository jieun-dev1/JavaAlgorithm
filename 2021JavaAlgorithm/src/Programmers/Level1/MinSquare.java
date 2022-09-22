package Programmers.Level1;

/*
����Ž��

������ �κ�: 2���� �迭���� index�� ��� ã��?
�迭�� �ƴ϶�, stack, Queue �� �ٸ� ������ Ȱ���ؾ� �ϳ�?

 1. �� ���ڸ� �� ������ ���Ƴִ´�.(ex. w - ���� ����)
 2. 0��°�� �����鼭 ���� ������ �ִ밪��, 1��°�� �����鼭 ���� ������ �ִ밪�� ã�´�.
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
                } //�ٲ�
            }

        for(int i=0;i<sizes.length;i++) {
            maxW = Math.max(maxW, sizes[i][0]);
            maxH = Math.max(maxH, sizes[i][1]);
        }

        answer = maxW*maxH;

        return answer;
    }
}
