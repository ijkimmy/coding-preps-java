public class matchhere_day5_q1 {
    public static void main(String[] args){
        final int bound = 10000;
        boolean[] isdn = new boolean[bound+1];
        for(int i=1; i<=bound; ++i){
            int dn = nextself(i);
            if(dn <= bound)
                isdn[dn] = true;
        }

        for(int i=1; i<=bound; ++i){
            if(!isdn[i])
                System.out.println(i);
        }
    }

    public static int nextself(int n){
        int val = n;
        while(n > 0){
            val += n%10;
            n /= 10;
        }

        return val;
    }
}
