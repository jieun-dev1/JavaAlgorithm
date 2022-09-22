package Inflearn.Sort;

import Inflearn.IfTwoPointer;
import java.util.Scanner;

/*
int의 범위 -2147483648 ~ 2147483647
 */
class Print1 {
    public static void main(String[] args) {
        String a = "576055795";
        long x = (long) 5760557950L;
        //String을 이진수로 변환.
        System.out.println(Integer.toBinaryString(576055795));

        System.out.println(Long.toBinaryString((long) 5760557950L)+"Binary of 5760557950L");
        System.out.println((Integer.toBinaryString(1465590654))+"Binary of 1465590654");
// 101010111010110110010001101111110
//   1010111010110110010001101111110

        System.out.println(576055795*10); //overflow 시 자바가 자동으로 처리해주는 듯함.
        long b2 =Integer.parseInt(a);
        long b = 10*Integer.parseInt(a);
        long c = 10*Long.parseLong(a);
        int d = 0;
        System.out.println(b2+ " b2 here");
        System.out.println(b+ " b here - overflow");
        System.out.println(c+ " c here");
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(d + (int) Integer.MAX_VALUE + 1);
        System.out.println((long)(d + Integer.MAX_VALUE + 1));

        System.out.println( Integer.MAX_VALUE);
    }
}
