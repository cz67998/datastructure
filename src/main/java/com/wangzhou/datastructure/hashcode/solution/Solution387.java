package com.wangzhou.datastructure.hashcode.solution;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/13
 * Time:15:54
 **/
public class Solution387 {
    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
//        HashMap<String, Integer> map = new HashMap();
//        for (int i = 0; i < s.length(); i++) {
//            String c = s.charAt(i)+"";
//            if (!map.containsKey(c)) {
//                System.out.println(map);
//                map.put(c, 1);
//            } else {
//                map.put(c, map.get(c) + 1);
//            }
//        }
//        System.out.println(map);
//        for (String i : map.keySet()) {
//            if (map.get(i) == 1) {
//                return s.indexOf(i);
//            }
//        }
//        return -1;
    }

    public static void main(String[] args) {
//        HashMap<Integer, Integer> map = new HashMap();
//        map.put(1, 1);
//        System.out.println(map.containsKey(1));
//        System.out.println(map.containsKey(0));

        firstUniqChar("loveleetcode");
        System.out.println(Integer.MAX_VALUE);
    }
}
