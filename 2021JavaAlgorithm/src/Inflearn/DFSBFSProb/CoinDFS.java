
package Inflearn.DFSBFSProb;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//DFS �� üũ�迭�� ������ �ʾƵ� ��.
//Time BFS�� 10MS ����.
public class CoinDFS {
    static int cnt;
    static int target;
    static int answer = Integer.MAX_VALUE; //answer �� ���� DFS �� ���� Math.min ���� ���ؼ� �� ���� �� ���.

    public void DFS(int L, int sum, Integer[] type) {
        if(sum>target) return;
        if(L>=answer) return;
        if(sum == target) {
            answer = Math.min(answer, L);
        }
        else {
            //���� ���� Ž��
            for(int i=0; i<cnt; i++) {
                    DFS(L+1, sum+type[i], type);
                }
            }
        }

    public static void main(String[] args) {
        CoinDFS T = new CoinDFS();
        Scanner sc = new Scanner(System.in);
        cnt = sc.nextInt();
        Integer[] type = new Integer[cnt];
        for(int i=0;i<cnt;i++) {
            type[i] = sc.nextInt();
        }
        Arrays.sort(type, Collections.reverseOrder());

        target = sc.nextInt();
        T.DFS(0,0, type);
        System.out.println(answer);
    }

}
