package Sample;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // �Ű� �ϱ� ���� �ߺ��� �Ű����� Ȯ���ϱ�.
        // �Ű��� ��� : �Ű� ���� id ����Ʈ
        // !! �ش� ������ �Ű��� ��� �������� ���� ����� ���Ϸ� �߼��մϴ�. �� Ƚ���� return !!
        // �� ȸ���� set, ������ �Ű��� ����̸�. hashMap<String, set> �Ű���� ��� : �Ű��� ����� ����
        // hashMap<String, Integer> : �Ű���� ���� : �Ű� ������ Ƚ�� => k�� ��
        // int[] result
        // ��ü ���̵� �����ͼ� �Ű���� Ƚ�� üũ�ϴ� hashmap �����.

        // Ž�� ����!! � �ڷᱸ���� ����� ������.
        // �ܰ踦 �� ������ ����!! :
        // �ð����⵵.
        // ���� 1 īī�� ���� ����, ���� 2
        // 1. hashMap<String, set>

        // hashMap<String, set> �Ű���� ��� : �Ű��� ����� ����
        Map<String, Set<String>> reportedUserMap = new HashMap<>();

        for(String r : report) {
            String[] pair = r.split(" ");
            String reported = pair[1];
            String reporter = pair[0];
            if (!reportedUserMap.containsKey(reported)) {
                reportedUserMap.put(reported, new HashSet<>());
            }
            reportedUserMap.get(reported).add(reporter);
        }

        Map<String, Integer> reporterUserCountMap = new HashMap<>();

        // 2. ����� �����
        //collection stream
        // ����
        reportedUserMap.entrySet().forEach(entry -> {
            if(k <= entry.getValue().size()) {
                // muzi, frodo
                for(String reporter : entry.getValue()) {
                    if(!reporterUserCountMap.containsKey(reporter)) {
                        reporterUserCountMap.put(reporter, 0);
                    }
                    Integer a = reporterUserCountMap.get(reporter) + 1;
                    reporterUserCountMap.put(reporter, a);
                }
            }
        });

        //3. ����
        int[] answer = new int[id_list.length];
        // id_list[i] ���� �����ͼ� => reporterUserCountMap key�� ã�� => answer[i]
        for(int i = 0; i < id_list.length; i++) {
            answer[i] = reporterUserCountMap.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}