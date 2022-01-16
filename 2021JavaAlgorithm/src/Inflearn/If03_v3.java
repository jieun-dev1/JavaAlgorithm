package Inflearn;

import java.util.Scanner;

public class If03_v3 {
	// 121MS.28MB (선생님 답)
	// StringTokenizer 는 결과값이 문자열, split은 결과값이 문자열 배열로 나온다. Tokenizer로 푼 코드는 배열을 하나
	// 더 생성했다.
	// split으로 하면 배열을 별도로 생성안해도 된다.
	// substring방법 (자바의 문자열을 인덱스 기준으로 잘라낸다)
	// m을 최솟값으로 정해놓고, 계속 값을 업데이트 하기. answer도 해당 x 로 업데이트 된다.
	public String solution(String str) {
		String answer = "";
		int m = Integer.MIN_VALUE, pos;
		// 띄어쓰기 발견 시 index 번호를 리턴. 없을 경우 -1 리턴.
		// len>m 인 이유: 같다고 하면 뒤쪽 단어가 답이 되기 때문임.
		while ((pos = str.indexOf(' ')) != -1) {
			String tmp = str.substring(0, pos);
			int len = tmp.length();
			if (len > m) {
				m = len;
				answer = tmp;
			}
			str = str.substring(pos + 1);
		}
		// 이 경우 " " 가 없는 마지막 단어는 읽어주지 못하니, 마지막 단어 처리를 따로 해줘야 함.

		if (str.length() > m) {
			answer = str;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열의 갯수가 정해져 있으면 List, 아니면 ArrayList. []
		// list 와 ArrayList는 collection framework 의 멤버다.

		// 배열:
		// 계속 최댓값으로 갱신할 것이기 때문에, MIN_VALUE로 초기화.
		If03_v3 T = new If03_v3();
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		System.out.println(T.solution(str));
	}

}
