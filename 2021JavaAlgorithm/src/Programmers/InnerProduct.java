package Programmers;

public class InnerProduct {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        //이중 for문 안쓰고
        for(int i=0;i<a.length;i++) {
            answer+=a[i]*b[i];
        }
        return answer;
    }
}
