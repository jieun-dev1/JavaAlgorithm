package Programmers.Level1;

public class StringConvert {
    public String solution(String s) {
        String answer = "";
        String[] strArray = s.split(" ", -1);
        for(int i=0;i< strArray.length;i++) {
            String str = strArray[i];
            char[] charArr = str.toCharArray();
            for(int j=0;j<str.length();j++) {
                if(j%2 == 0) {
                    charArr[j] = Character.toUpperCase(charArr[j]);
                } else {
                    charArr[j] = Character.toLowerCase(charArr[j]);
                }
            }
//            String temp = charArr.toString();//이렇게 하면 객체 번호(?) 가 나옴.
            String temp = String.valueOf(charArr);
            strArray[i] = temp;
        }

        for (int i=0;i<strArray.length;i++) {
            if(i==strArray.length-1) {
                answer+=strArray[i];
            }
            else {
                answer+=strArray[i]+" ";
            }

        }
        return answer;
    }
}
