package Inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class If03 {

	// sc.nextLine()은 입력값을 한 줄로 입력받음.
	// StringTokenizer(지정한 구분자로 문자열을 나눠줌)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		String input = kb.nextLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		ArrayList<String> list = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}

//		System.out.println(list);
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));

		ArrayList<Integer> lengthList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			lengthList.add(list.get(i).length());
		}

//		System.out.println(lengthList);
		int max = Collections.max(lengthList);
		ArrayList<String> resultList = new ArrayList<String>();

		for (int i = 0; i < lengthList.size(); i++) {
			if (lengthList.get(i) == max) {
				// 답인 것들을 다 인쇄.
				resultList.add(list.get(i));
			} else {
				i++;
			}
		}
//		System.out.println(resultList);
		System.out.println(resultList.get(0));
	}
}
