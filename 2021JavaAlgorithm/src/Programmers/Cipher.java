package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

/*
3��: ���α׷��ӽ� ����
(1) Ȱ��: �ƽ�Ű �ڵ�
�ƽ�Ű �ڵ带 ���ϰ� (char)�� ���ָ� �ٽ� ĳ���� ��ȯ�� �����ϴ�.
char ��, 'c'-2 = 2; �� ����� �ȴ�. charŸ���� ���ڰ� ����ȴٱ⺸��, 2byteũ���� ���������� �����Ѵ�
(�����ϴ� �����ڵ� ���ڰ� ����Ѵٰ� �����ϱ�)

������ ����, �������� ���ȴ�. https://devlog-wjdrbs96.tistory.com/76
'��' sms
(2) ��Ʈ���� += �� �����൵ �ȴ�.
*/


public class Cipher {
    public String solution(String s, int n) {
        String answer = "";
        n = n%26; //26�� ���� ��, -26�� ���ִ� �ͺ��� �������� ����ϱ�.

//        char[] arr = s.toCharArray();
        for(int i=0;i<s.length();i++) {
            char temp = s.charAt(i); // String �� charArray�� �ٲ��� �ʰ�, charAt�� ���� Ư�� �ε����� Character ��ȯ ����.
            if(Character.isLowerCase(temp)) {
                temp = (char) ((temp -'a'+n) % 26 +'a');
            } else if(Character.isUpperCase(temp)){
                temp = (char) ((temp -'A'+n) % 26 +'A');
            }
            answer += temp; //������ ��� �б�ó�� ���� �״�� ��������.
        }
        return answer;

        }
    }
