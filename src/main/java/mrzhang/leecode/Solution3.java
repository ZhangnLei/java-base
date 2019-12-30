package mrzhang.leecode;

/**
 * @author zhangnianlei
 * @date 2019/10/20
 */

class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int a= 0;
        int max= 0;
        boolean hasrepeat = false;
        for (int b = 1; b < s.length(); b++) {
            String window = s.substring(a, b);
            String str = s.substring(b, b+1);
            if (window.indexOf(str) == -1){
                max ++;
            }else {
                max = Math.max(max, b-a);
                a=b;
                hasrepeat = true;
            }
        }
        return hasrepeat ? max : s.length();
    }

    public static void main(String[] args) {
        int max = lengthOfLongestSubstring("pwwkew");
        System.out.println(max);
    }
}
