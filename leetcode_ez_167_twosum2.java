// import java.util.HashMap;
class leetcode_ez_167_twosum2{

    // 18m
    public int[] twoSum(int[] numbers, int target) {
        // // hashmap solution, space = O(n)
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0; i<numbers.length; ++i){
        //     if(map.containsKey(numbers[i])){
        //         return new int[] { map.get(numbers[i]), i+1 };
        //     }
        //     map.put(target - numbers[i], i+1);
        // }
        
        // return new int[] { -1, -1 };


        // 2 pointer solution, space = O(1)
        int lo = 0, hi = numbers.length-1;
        while(lo < hi){
            int sum = numbers[lo] + numbers[hi];
            if(target == sum)
                return new int[] { lo+1, hi+1 };
            else if(target < sum)
                --hi;
            else
                ++lo;
        }

        return new int[] { -1, -1 };
    }
}