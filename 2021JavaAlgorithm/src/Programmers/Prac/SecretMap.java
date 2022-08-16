package Programmers.Prac;


/*
https://school.programmers.co.kr/learn/courses/30/lessons/17681

Integer.toBinaryString: 받은 문자열을 2진법 형식으로 바꿈.
Integer.parseInt: 받은 문자열을 정수형으로 바꿈.
%5d - 5자리 표현 -> 뒤에값이 5자리 미만이라면 공백으로 표시
Integer.parseInt 범위 초가 -> Long.parseLong();
int 범위가 초과되면 자동으로 Long으로 promote 된다. https://stackoverflow.com/questions/24590725/java-parseint-vs-parselong
 */

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String [] answer = new String[n];
        //숫자를 변환.String으로 바꿔서.
        for (int i = 0; i < n; i++) {
            int temp = arr1[i] | arr2[i]; //1이 하나라도 있으면 1을 변환. 결과 배열에 해당하는 수가 나옴.
//            String tempBinary = Integer.toBinaryString(temp); 이진수로 변환은 해주지만, 5자리에 맞게 0을 붙여주지 않는다.
            String tempBinary = String.format("%0"+n+"d", Long.parseLong((Integer.toBinaryString(temp))));
            String answer1 = new String();
            for (int j = 0; j < tempBinary.length(); j++) {
                if(tempBinary.charAt(j) == '1') {
                    answer1+='#';
                } else {
                    answer1+= ' ';
                }
            }
            answer[i] = answer1;
        }
            //결과 배열이 만들어졌으니,
        return answer;
    }

}
