public class leetcode_ez_14_longestcommprefix {

    // 15m
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];

        String prefix = "";
        for(int i=0; i<strs[0].length(); ++i){
            char curr = strs[0].charAt(i);
            for(String str: strs){
                if(str.length() <= i || curr != str.charAt(i))
                    return prefix;
            }
            prefix += curr;
        }

        return prefix;
    }
}
