package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
�Ǽ�
(1) reportList�� report �� �־�� �ϴµ�, id_list ����. �̸� ������ ��.
(2) String �� �񱳴� equals
(3) entry�� ���� �� null�� ���� �ɷ��� �ϴµ�, ���� null üũ�� �ڿ� ���� ���� null pointer exception �� �߻��ߴ�.
�̴� ���� ������ ���� �� �˻��ϰ� ���� ������ ���� ������. �׷��� null�� �տ� ����.
if (entry.getValue() != null && entry.getValue().size() >= k)

 */
public class Solution {

  public int[] solution(String[] id_list, String[] report, int k) {
    /*
    ������ �Ű��ϴ� ���� �Ÿ��� ���ؼ�, List -> Set���� �ɷ�����
    map<�ǽŰ���, �Ű���>: �� �Ű��ο� ���� �Ű��� ����Ʈ
    �ʱ�ȭ �۾�. id_list�� ��� key�� ������ֱ�
     */
    HashSet<String> reportList = new HashSet<>(Arrays.asList(report));
    HashMap<String, ArrayList<String>> map = new HashMap<>(); //<�ǽŰ���, �Ű���>

    for (int i = 0; i < id_list.length; i++) {
      map.put(id_list[i], null);
    }

    for (String x : reportList) {
      int location = x.indexOf(" ");
      String reporter = x.substring(0, location);
      String reportee = x.substring(location + 1);
    /*
    getOrDefault: Ű�� ���� �����ϸ� �ش� ���� ��ȯ�ϰ�, �ƴϸ� null��ȯ.
    �ٸ� �Ű����� �־��ٸ�, list�� �����ͼ� �����ϰ�, �ƴϸ� �� ����Ʈ�� �����.
     */

      ArrayList<String> reporterList = map.getOrDefault(reportee, null);
      if (reporterList == null) {
        reporterList = new ArrayList<>();
        reporterList.add(reporter);
      } else {
        reporterList.add(reporter);
      }
      map.put(reportee, reporterList);
    }

    //�Ű� Ƚ�� k �� �̻�����, ���ܵ� ����� ����Ʈ �����.
    ArrayList<String> blockedReportee = new ArrayList<>();
    //blockedReportee ����Ʈ�� �����.- entryset�� �����ͼ� �� �з��ϰ�, ���� �ش��ϴ� Ű ��������.
    ArrayList<String> emailList = new ArrayList<>();

    for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
      if (entry.getValue() != null && entry.getValue().size() >= k) {
        blockedReportee.add(entry.getKey());
        for (int i = 0; i < entry.getValue().size(); i++) {
          emailList.add(entry.getValue().get(i));
        }
      }
    }
        /*
         �Ű��ڸ� ��ȸ�ϸ鼭
         emailList �� ��Ҹ� id_list�� �ε����� �°� answerList �� ��ȯ�ϱ�.
         */

    int[] answerList = new int[id_list.length];
    for (int i = 0; i < emailList.size(); i++) {
      for (int j = 0; j < id_list.length; j++) {
        if (emailList.get(i).equals(id_list[j])) {
          answerList[j]++;
        }
      }
    }
    return answerList;
  }

  public static void main(String[] args) {
    Solution T = new Solution();
    String[] id_List = {"muzi", "frodo", "apeach", "neo"};
    String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
    int k = 2;
    System.out.println(T.solution(id_List, report, k));
  }
}
