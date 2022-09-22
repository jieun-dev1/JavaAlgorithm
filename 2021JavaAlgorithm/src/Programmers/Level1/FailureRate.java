package Programmers.Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
��������
1.IndexOutOfBounds ����: EX. �迭�� ũ�Ⱑ 5�ε�, 5��° �ε����� ������ �� (4��°�� �ƴϰ�)
2.failCount[i] = Collections.frequency(Arrays.asList(stages), i+1); // ī���� �ȵǴ� �޼��� - Object �� ���ڴ� �ν��� ���ϴ� �� ����.
3.������ 0�� ���, ó�����ֱ�.
4.���� stages ������ 200000���� ������ ��, n ���� �ð����⵵�� ����.
5.�и� 0�� ��� ����.
 */


public class FailureRate {

    //������ HashMap�� �����ϱ�.

    public int[] solution(int N, int[] stages) {
        ArrayList<Integer> ansArr = new ArrayList<>();
        int[] answer; // ���� �� ��: ������ ���� ������� ���� ����

        double[] failRate = new double[N];
        int[] failCount = new int[N];

        double temp = stages.length; //int �� ����� �ȵȴ�. double ���� ������ ����� �Ǽ� �׷� �� ����.

        //�ڹ� - 2���� �迭 ���ֱ�
        for(int i=0;i<N;i++) {
            for(int j=0;j<stages.length;j++) {
                if (stages[j] == i+1) {
                    failCount[i]++; //[3,0,0]
                }
            }
        }

        //temp �� 0�� ��� ���� 0.0�� �־���.
        for(int i=0;i<N;i++){
          if(i==0) {
                failRate[i] = failCount[i]/temp;
            } else if (i>0&&i< stages.length) {
                temp = temp - failCount[i-1];
                if (temp!=0) {
                    failRate[i] = failCount[i]/temp;
                } else {
                    failRate[i] = 0.0;
                }
            }
        }

        //Value ������ �������� �ؽø� ����
        HashMap<Integer, Double> hm = new HashMap<Integer, Double>();

        for(int i=0;i<failRate.length;i++) {
            if(failCount[i] == 0) {
                hm.put(i+1, 0.0);
            }
            else {
                hm.put(i+1, failRate[i]);
            }
        }

        List<Map.Entry<Integer,Double>> entryList = new LinkedList<>(hm.entrySet());
        entryList.sort(Collections.reverseOrder(Map.Entry.comparingByValue())); //���� ����
        for(Map.Entry<Integer,Double> entry:entryList) {
            ansArr.add(entry.getKey());
            System.out.println("key: "+entry.getKey() +"value: " +entry.getValue());
        }

        answer = ansArr.stream().mapToInt(i->i.intValue()).toArray();

        return answer;
    }

}
