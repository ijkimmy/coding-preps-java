# [코테] Leetcode 1060: Missing Element in Sorted Array

Date: March 27, 2022  
Tags: Binary Search, Coding Interview Prep, Leetcode  
  
<br />

### Problem

---

*난이도 - Medium*

> Given an integer array `nums` which is sorted in **ascending order** and all of its elements are **unique** and given also an integer `k`, return the `kth` missing number starting from the leftmost number of the array.  
`nums` 라는 integer array가 오름차순로 정렬되있고 중복되지 않은 요소만 가지고 있다고 할 때, 해당 array의 제일 작은 숫자부터 시작해 array에 없는 `k`번째 숫자를 구하시오.

<br />

### Examples

---

**Example 1**

```
Input: nums = [4,7,9,10], k = 1
Output: 5
Explanation: The first missing number is 5.
```

**Example 2**

```
Input: nums = [4,7,9,10], k = 3
Output: 8
Explanation: The missing numbers are [5,6,8,...], hence the third missing number is 8.
```

**Example 3**

```
Input: nums = [1,2,4], k = 3
Output: 6
Explanation: The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
```

<br />

### Constraints

---

- `1 <= nums.length <= 5 * 104`
- `1 <= nums[i] <= 107`
- `nums` is sorted in **ascending order,** and all the elements are **unique**.
- `1 <= k <= 108`

<br />

### Brainstorming

---

**Brute Force** 

`nums`를 `k`만큼 돌며 찾아내기 

*Time Complexity*: $O(n+k)$  
*Space Complexity*: $O(1)$

<br />
  
**Binary Search**

Brute force가 linear하니, 적어도 logarithmic한 답을 찾아야 한다. 그렇다면 아무래도 binary search를 진행해야겠다. `nums`가 오름차순으로 정렬되어 있으니 이를 활용하면 될 듯하다. 

앞서 나온 예시1과 2를 살펴보자.  
`nums = [4, 7, 9, 10]`이라는 array 가 있을 때 각 요소의 index와 첫번째 숫자를 사용하여 원래 존재해야하는 숫자를 구할 수 있다. 이를 표현하면 `[0+4, 1+4, 2+4, 3+4]` 즉, `[4, 5, 6, 7]`이 된다. 해당 array와 `nums`의 차이가 `k`가 되는 구간을 찾을 때 까지 binary search 를 진행해보자. 

Corner case의 경우 찾아야되는 값이 `nums`의 제일 큰 값을 넘는 경우를 생각해볼 수 있다. 

```java
class Solution {
    public int missingElement(int[] nums, int k) {
        int lo=0, hi=nums.length-1;

		// 찾아야 되는 값이 array의 가장큰 값보다 클경우 간단히 계산해서 넘겨라
        if(missingcnt(nums, hi) < k)
            return nums[hi] + k - missingcnt(nums, hi);
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;

            // 예를 들어 존재하지않는 값의 수가 [.. 2, 2, 3, ...] 이고 k=3일경우
            // 맨 마지막 2에 해당하는 숫자로 부터 k - missingcnt(nums, lo-1)를 찾아야한다
            if(missingcnt(nums, mid) >= k)
                hi = mid;
            else
                lo = mid+1;
        }
        
        return nums[lo-1] + k - missingcnt(nums, lo-1);
    }
    
    public int missingcnt(int[] arr, int idx){
        // 코드를 조금 간략화 하기 위한 helper function
        return arr[idx] - arr[0] - idx;
    }
}
```

*Time Complexity*: $O(\operatorname{log} n)$  
*Space Complexity*: $O(1)$