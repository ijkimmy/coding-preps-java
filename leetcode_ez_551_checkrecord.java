public class leetcode_ez_551_checkrecord {

    // 17m
    public boolean checkRecord(String s) {
        // // linear solution, O(n)
        // int absent = 0;
        // for(int i=0; i<s.length(); ++i){
        //     if(s.charAt(i)=='A')
        //         ++absent;
        //     if(absent > 1) return false;
        // }

        // return s.indexOf("LLL") < 0;


        // regular expression, O(n) 
        return !s.matches(".*(A.*A|LLL).*");
    }
}
