public class leetcode_ez_504_converttobase7 {

    // 20m
    public String convertToBase7(int num) {
        if(num == 0) return "0";

        int sign = num < 0 ? -1 : 1;
        num *= sign;

        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(num%7);
            num /= 7;
        }

        if(sign == -1)
            return "-" + sb.reverse().toString();
        
        return sb.reverse().toString();



        // Somehow, this solution is much faster.. don't know why
        // if(-7 < num && num < 7) return String.valueOf(num);

        // StringBuilder sb = new StringBuilder();
        // if(num < 0){
        //     sb.append('-');
        //     num = num * -1;
        // }

        // int product = 7;
        // while(num >= product) product *= 7;
        // product /= 7;

        // while(product > 0){
        //     sb.append(num/product);
        //     num %= product;
        //     product /= 7;
        // }

        // return sb.toString();
    }
}
