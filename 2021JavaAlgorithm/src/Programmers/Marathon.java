package Programmers;

//public class Marathon {
//		public String solution(String[] participant, String[] completion) {
//			String answer = "";
//			HashMap<String, Integer> hm = new HashMap<>();
//			for (String player : participant)
//				hm.put(player, hm.getOrDefault(player, 0)+1);
//			for (String player : completion)
//				hm.put(player, hm.get(player) - 1);
//
//			for (String key : hm.keySet())
//				if (hm.get(key) != 0) {
//					answer = key;
//				}
//			return answer;
//
//	}
//}
import java.util.HashMap;

class Marathon {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		for (String p : participant) {
			hm.put(p, hm.getOrDefault(p, 0) + 1);
		}
		for (String p : completion) {
			hm.put(p, hm.get(p) - 1);
		}

		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) {
				answer = key + answer;
			}

		}
		return answer;
	}
}
