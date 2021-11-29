import java.util.List;
import java.util.ArrayList;

public class leetcode_md_1570_sparsevector {
    int[] nums;
    List<Integer> idx;
    boolean issparse;

    // 31m
    leetcode_md_1570_sparsevector(int[] nums) {
        this.nums = nums;
        idx = new ArrayList<>();
        for(int i=0; i<nums.length; ++i){
            if(nums[i] != 0){
                idx.add(i);
            }
        }
        issparse = idx.size() < (nums.length * 2/3);
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(leetcode_md_1570_sparsevector vec) {
        if(this.issparse && vec.issparse){
            return dotProductSparse(vec);
        } 

        int val = 0;
        for(int i=0; i<vec.nums.length; ++i){
            val += this.nums[i] * vec.nums[i];
        }
        return val;
    }

    public int dotProductSparse(leetcode_md_1570_sparsevector vec) {
        int this_i = 0, vec_i = 0, product = 0;
        while(this_i < this.idx.size() && vec_i < vec.idx.size()){
            int thisidx = this.idx.get(this_i), vecidx = vec.idx.get(vec_i);
            if(thisidx == vecidx){
                product += this.nums[thisidx] * vec.nums[vecidx];
                ++this_i; ++vec_i;
            } else if(thisidx < vecidx){
                ++this_i;
            } else {
                ++vec_i;
            }
        }

        return product;
    }
}
