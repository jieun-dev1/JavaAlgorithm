package Programmers;

import java.util.Scanner;
//ü������ �� ��� �ָ� answer ���� ������. 

//if, else if ������, ù ��° ���� �ĺ��� ������� ���ؼ� ����� ���� ���ǽ��� ������, 
//�ش� �� {} �� �����ϰ�, if else if �� ��ü�� �����.  
//���� ���ǽ��� �ϳ��� ������ �������� else ���� ����ȴ�. 
//else ���� ���� �����ϴ�. ���� ��� ���ǽĵ� �������� ���� ��, ������ ������ ������ �ȴ�. 
//-141, �ڹ��� ����. 
class Pe {
	
	public int solution(int n, int[] lost, int[] reserve) {

		int answer = n;
		// �켱 ����Ʈ ���� �����.
		int[] people = new int[n];

		//lost �� reserve�� �����ؼ� �� �迭 �ȿ� �־���. 
		//-1�� ������ ������, index out of bounds for length ������ ����. 
		for(int l:lost) {
			people[l]--; 
		}
		
		for(int r:reserve) {
			people[r]++;
		}
		
		//i-1 �ε��� ��ġ �� 0���� ũ�ų� ���ƾ� �ϰ�, people[i-1]�� 1�̾�� ��. 
		//�򰥸��ϱ�, ���� �۷� ���� Ǯ��. 
		
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