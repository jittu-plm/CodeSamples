package com.jitendra.g4g;

public class FirstNonrepeatable {
    static char[] count = new char[256];
    public static void main(String[] args) {
        System.out.println(getFirstNonRepeatable("Jittu"));
    }

    static char getFirstNonRepeatable(String s){
        char[] c = s.toCharArray();
        getCharCount(s);

        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            System.out.println(ch + " = " + ((int)count[ch]));
            if(count[s.charAt(i)] == 1)
                return s.charAt(i);
        }
        return 0;
    }

    private static void getCharCount(String s) {
        for (int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }
    }

}
