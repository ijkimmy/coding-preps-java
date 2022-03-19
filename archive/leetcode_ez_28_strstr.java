public class leetcode_ez_28_strstr {

    // 75m
    public int strStr(String haystack, String needle) {
        // // brute force solution, time: O(n+m), space: O(1)
        // int nlen = needle.length(), hlen = haystack.length();
        // if(nlen == 0) return 0;
        // if(nlen > hlen) return -1;

        // for(int i=0; i<=hlen-nlen; ++i){
        //     if(haystack.charAt(i) == needle.charAt(0)){
        //         boolean ismatch = true;
        //         for(int j=0; j<nlen; ++j){
        //             if(haystack.charAt(i+j) != needle.charAt(j)) {
        //                 ismatch = false;
        //                 break;
        //             }
        //         }

        //         if(ismatch) return i;
        //     }
        // }

        // return -1;


        // KMP process algorithm, time: O(n+m), space: O(m)
        if(needle.length() == 0) return 0;
        if(needle.length() > haystack.length()) return -1;
        int[] pattern = findpattern(needle);

        int i=0, j=0;
        while(i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                ++i; ++j;
            }
            else if(j > 0)
                j = pattern[j-1];
            else
                ++i;
        }

        return needle.length() == j ? i-j : -1;
    }

    public int[] findpattern(String str){
        int[] pattern = new int[str.length()];

        int i=1, j=0;
        while(i<pattern.length){
            if(str.charAt(i) == str.charAt(j))
                pattern[i++] = ++j;
            else if(j > 0)
                j = pattern[j-1];
            else
                pattern[i++] = 0;
        }

        return pattern;
    }
}
