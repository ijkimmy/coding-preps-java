import java.util.Random;
public class leetcode_md_384_shufflearr {
    int[] org;
    int[] arr;
    Random rand;


    // 40m
    public leetcode_md_384_shufflearr(int[] nums) {
        org = nums;
        arr = nums.clone();
        rand = new Random();
    }
    
    public int[] reset() {
        arr = org;
        return arr;
    }
    
    public int[] shuffle() {
        for(int i=0; i<arr.length; ++i){
            int j = randRange(i, arr.length);
            swap(i, j);
        }

        return arr;
    }

    public int randRange(int min, int max){
        return rand.nextInt(max-min) + min; 
    }

    public void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
