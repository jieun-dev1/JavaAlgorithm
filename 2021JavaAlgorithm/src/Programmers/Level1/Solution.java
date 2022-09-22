package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
실수
(1) reportList에 report 를 넣어야 하는데, id_list 넣음. 이름 주의할 것.
(2) String 의 비교는 equals
(3) entry의 원소 중 null인 것을 걸러야 하는데, 원래 null 체크가 뒤에 있을 때는 null pointer exception 이 발생했다.
이는 앞의 로직을 먼저 다 검사하고 뒤의 로직을 보기 때문임. 그러니 null은 앞에 두자.
if (entry.getValue() != null && entry.getValue().size() >= k)

 */
public class Solution {

  public int[] solution(String[] id_list, String[] report, int k) {
    /*
    여러번 신고하는 것을 거르기 위해서, List -> Set으로 걸러낸다
    map<피신고인, 신고인>: 피 신고인에 대한 신고인 리스트
    초기화 작업. id_list를 모두 key로 등록해주기
     */
    HashSet<String> reportList = new HashSet<>(Arrays.asList(report));
    HashMap<String, ArrayList<String>> map = new HashMap<>(); //<피신고인, 신고인>

    for (int i = 0; i < id_list.length; i++) {
      map.put(id_list[i], null);
    }

    for (String x : reportList) {
      int location = x.indexOf(" ");
      String reporter = x.substring(0, location);
      String reportee = x.substring(location + 1);
    /*
    getOrDefault: 키의 값이 존재하면 해당 값을 반환하고, 아니면 null반환.
    다른 신고인이 있었다면, list를 가져와서 갱신하고, 아니면 빈 리스트를 만들기.
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

    //신고 횟수 k 번 이상으로, 차단된 사람들 리스트 만들기.
    ArrayList<String> blockedReportee = new ArrayList<>();
    //blockedReportee 리스트를 만들기.- entryset을 가져와서 값 분류하고, 값에 해당하는 키 가져오기.
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
         신고자를 조회하면서
         emailList 의 요소를 id_list의 인덱스에 맞게 answerList 에 반환하기.
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
