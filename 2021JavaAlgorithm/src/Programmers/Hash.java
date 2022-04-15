//
//import java.util.HashMap;
//
//class Solution {
//	public String solution(String[] participant, String[] completion) {
//		String answer = "";
//		HashMap<String, Integer> hm = new HashMap<>();
//		for (String player : participant)
//			hm.put(player, hm.getOrDefault(player, 0));
//		for (String player : completion)
//			hm.put(player, hm.get(player) - 1);
//
//		for (String key : hm.keySet())
//			if (hm.get(key) != 0) {
//				answer = key;
//			}
//		return answer;
//
//	}
////    public String solution(String[] participant, String[] completion) {
////        List parti = new ArrayList<>(Arrays.asList(participant));
////        List compl =  new ArrayList<>(Arrays.asList(completion));
////        ArrayList<String> answerList = new ArrayList<String>();
////        answerList.addAll(parti);
////        answerList.removeAll(compl);
////        String answer = "";
////        for(String item: answerList) {
////            answer+=item;
////        }
////        return answer;
////    }
//
////     public static void main(String[] args) {
////         Scanner sc = new Scanner(System.in);
////         Solution so = new Solution();
////         String[] participant = sc.
////     }
//}