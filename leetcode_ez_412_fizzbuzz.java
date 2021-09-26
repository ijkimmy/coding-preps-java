import java.util.List;
import java.util.LinkedList;
public class leetcode_ez_412_fizzbuzz {

    // 9m
    public List<String> fizzBuzz(int n) {
        List<String> lst = new LinkedList<>();
        for(int i=1; i<=n; ++i){
            if(i%15==0) lst.add("FizzBuzz");
            else if(i%3==0) lst.add("Fizz");
            else if(i%5==0) lst.add("Buzz");
            else lst.add(String.valueOf(i));
        }
        return lst;
    }
}
