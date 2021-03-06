package Programmers;

import java.util.Scanner;
//체육수업 못 듣는 애만 answer 에서 빼주자. 

//if, else if 문에서, 첫 번째 조건 식부터 순서대로 평가해서 결과가 참인 조건식을 만나면, 
//해당 블럭 {} 만 수행하고, if else if 문 자체를 벗어난다.  
//참인 조건식이 하나도 없으면 마지막의 else 블럭이 수행된다. 
//else 블럭은 생략 가능하다. 위의 어느 조건식도 만족하지 않을 때, 수행할 문장을 적으면 된다. 
//-141, 자바의 정석. 
class Pe {
	
	public int solution(int n, int[] lost, int[] reserve) {

		int answer = n;
		// 우선 리스트 부터 만들기.
		int[] people = new int[n];

		//lost 와 reserve를 구분해서 한 배열 안에 넣어줌. 
		//-1을 해주지 않으면, index out of bounds for length 에러가 난다. 
		for(int l:lost) {
			people[l]--; 
		}
		
		for(int r:reserve) {
			people[r]++;
		}
		
		//i-1 인덱스 위치 도 0보다 크거나 같아야 하고, people[i-1]도 1이어야 함. 
		//헷갈리니까, 먼저 글로 쓰고 풀기. 
		
		for(int i=0;i<people.length;i++) {
			if (people[i] == 0) {
				if (i-1>=0 && people[i-1] == 1) {
					people[i]++;
					people[i-1]--;
				}
				
				else if(i+1>=0 && people[i+1] == 1) {
					people[i]++;
					people[i+1]--;
				}
				
				else {
					answer --; 
				}
			} 
		}
		return answer;
	}
}