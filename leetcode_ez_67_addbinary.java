public class leetcode_ez_67_addbinary {

    // 24m
    public String addBinary(String a, String b) {
        if(a.length() > b.length()){    // a.length() < b.length()
            String tmp = a;
            a = b;
            b = tmp;
        }

        boolean plus1 = false;
        StringBuilder sb = new StringBuilder();
        int aidx = a.length()-1, bidx = b.length()-1;
        while(bidx >= 0){
            int sum = (b.charAt(bidx--)-'0');
            if(aidx >= 0)
                sum += (a.charAt(aidx--)-'0'); 
            
            sum += plus1? 1: 0;
            if(sum >= 2){
                plus1 = true;
                sum %= 2;
            }
            else
                plus1 = false;
            
            sb.append(sum);
        }

        if(plus1) sb.append(1);

        return sb.reverse().toString();
    }
}
 