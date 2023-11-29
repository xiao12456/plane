package com.test;

public class Test1 {

    public static void main(String[] args) {
        String str = "hello world";

        int count = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            char c = str.charAt(length);
            if (Character.isSpaceChar(c)) {
                break;
            } else {
                count++;
            }
        }

        System.out.println(count);

    }


}
