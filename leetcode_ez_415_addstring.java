public class leetcode_ez_415_addstring {

    // 46m
    public String addStrings(String num1, String num2) {
        if(num1.length() > num2.length()){  // num1.length < num2.length
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        boolean plus1 = false;
        int idx1 = num1.length()-1, idx2 = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        while(idx1 >= 0){
            int sum = (num1.charAt(idx1--)-'0') + (num2.charAt(idx2--)-'0');
            
            sum += plus1 ? 1 : 0;
            if(sum>9){
                plus1 = true;
                sum %= 10;
            } 
            else 
                plus1 = false;

            sb.append(sum);
        }

        while(idx2 >= 0){
            int sum = num2.charAt(idx2--)-'0';
            sum += plus1 ? 1 : 0;
            if(sum>9){
                plus1 = true;
                sum %= 10;
            } 
            else 
                plus1 = false;

            sb.append(sum);
        }

        if(plus1)
            sb.append(1);
        
        return sb.reverse().toString();
    }
}
