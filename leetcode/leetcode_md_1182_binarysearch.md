# [코테] Leetcode 1182: Shortest Distance to Target Color

Date: April 4, 2022  
Tags: Binary Search, Coding Interview Prep, Leetcode  
<br />

### Problem

---

*난이도 - Medium*

> You are given an array `colors`, in which there are three colors: `1`, `2` and `3`. You are also given some queries. Each query consists of two integers `i` and `c`, return the shortest distance between the given index `i` and the target color `c`. If there is no solution return `-1`.
> `1`, `2`, `3`만을 가지고 있는 `colors` 라는 배열과 (`i`, `c`)형태의 쿼리들이 주어졌을 때 각 쿼리를 다음과 같이 수행하시오. `colors` 의 `i`번째 요소로부터 제일 가까운 `c`까지의 거리 (불가능 할 시 `-1`)
<br />

### Examples

---

**Example 1**

```
Input: colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
Output: [3,0,3]
Explanation: 
The nearest 3 from index 1 is at index 4 (3 steps away).
The nearest 2 from index 2 is at index 2 itself (0 steps away).
The nearest 1 from index 6 is at index 3 (3 steps away).
```

**Example 2**

```
Input: colors = [1,2], queries = [[0,3]]
Output: [-1]
Explanation: There is no 3 in the array.
```

### Constraints

---

- `1 <= colors.length <= 5*10^4`
- `1 <= colors[i] <= 3`
- `1 <= queries.length <= 5*10^4`
- `queries[i].length == 2`
- `0 <= queries[i][0] < colors.length`
- `1 <= queries[i][1] <= 3`
<br />

### Solution

---

**Brute Force** 

각 쿼리를 실제 `colors`에 적용시켜 찾기

*Time Complexity*: O(nq)

- 쿼리의 길이: q  

- `colors`의 길이: n

*Space Complexity*: O(1)

<br />

**Binary Search**

매 쿼리를 수행할 때 마다 `colors`를 도는 것은 비효율적이니, 이를 효과적으로 담아줄 방법이 필요합니다. 주어진 `colors`내의 값이 딱 3개밖에 없으니, 각각의 값들이 위치하는 index를 저장하고 사용해봅시다.

<br />

앞서 나온 예시1을 살펴봅시다.

`[1,1,2,1,3,2,2,3,3]`의 값을 가지는 array에 대해 다음과 같이 전처리를 해줄 수 있습니다.

`1: [0, 1, 3], 2: [2, 5, 6], 3: [4, 7, 8]`이와 같이 1, 2, 3이 위치한 index정보를 가지고 쿼리 `[[1,3],[2,2],[6,1]]`를 다음과 같이 수행할 수 있습니다. 

<br />
 

먼저, 첫번째 쿼리 `[1, 3]`의 경우 다음과 같이 수행됩니다.

`3`에 해당하는 index array `3: [4, 7, 8]`에 대해 `1`이 들어갈 위치를 찾은 뒤 해당 위치의 앞, 뒤 요소와의 절대값의 차이중 더 작은 쪽을 가져오면 됩니다. 해당 예시의 경우, 제일 첫번째에 위치하기 때문에 뒤의 요소인 `4`와의 절대값 차이인 `3`을 가져오게 됩니다. 

이와 마찬가지로 `[2,2],[6,1]`또한 `2-2=0`, `6-3=3`의 값을 가지게 됩니다. 

<br />

앞서 언급한 brute force 해답이 각 쿼리별로 linear하니 이보다 나은 시간 복잡도를 주려면 logarithmic하게 위치를 찾아야 합니다. 마침 위에서와 같이 `color`을 한번 돌며 전처리를 해주면 각각의 값이 정렬되어 있으니 binary search를 사용할 수 있습니다. 별다른 수정이 필요한 게 아니니, Java의 built-in 함수를 사용할 것입니다. 

예외 케이스의 경우 해당 쿼리가 원하는 숫자가 아예 존재하지 않을 경우 (-1) 나 해당 쿼리가 고른 위치가 원하는 숫자일 경우 (0) 정도가 있겠습니다. 

```java
class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer>[] c_idx = new List[3];
        for(int i=0; i<colors.length; ++i){ // 전처리
            int color = colors[i]-1;
            if(c_idx[color]==null)
                c_idx[color] = new ArrayList<>();
            c_idx[color].add(i);
        }
        
        List<Integer> retval = new LinkedList<>();
        for(int[] query: queries){
            int color = query[1]-1;
            
            if(c_idx[color]==null)
                retval.add(-1);
            else{ // binary search
                int idx = Collections.binarySearch(c_idx[color], query[0]);
                if(idx>=0)
                    retval.add(0);
                else{
                    idx = -idx-1;
                    int left = Math.max(0, idx-1), right = Math.min(idx, c_idx[color].size()-1);
                    int l_val = Math.abs(query[0] - c_idx[color].get(left));
                    int r_val = Math.abs(query[0] - c_idx[color].get(right));
                    retval.add(Math.min(l_val, r_val));
                }
            }
        }
        return retval;
    }
}
```

*Time Complexity*: O(n+q log n)

- 주어진 `color`에 대해 전처리를 진행: O(n)

- 각 쿼리별로 전처리된 데이터 내에서 binary search: O(q log n)

*Space Complexity*: O(n)  

<br>

**Optimal solution (redo)**

사실상 주어진 `color` array가 3가지의 색밖에 가지고 있지 않기에, 해당 array의 모든 위치에서 부터 주어진 색들의 가장 가까운 거리를 모두 계산할 수 있습니다. 

<br />

앞서 나온 예시1을 살펴봅시다. 

`[1,1,2,1,3,2,2,3,3]`와 같은 배열에 대해 다음과 같은 거리를 표현한 배열을 만들 수 있습니다. 

| index | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| color 1 |  |  |  |  |  |  |  |  |
| color 2 |  |  |  |  |  |  |  |  |
| color 3 |  |  |  |  |  |  |  |  |

위에서 생성된 거리 테이블을 채우기 위해서 `colors`배열에 대해 양방향으로 돌며 각 위치로부터 제일 짧은 거리들을 알아야 합니다. 이는 다음과 같이 두 개의 단계로 나눌 수 있습니다. 

1. 왼쪽에서 오른쪽으로 순환하며 각 위치 기준 왼쪽에 위치한 제일 짧은 거리 파악
2. 오른쪽에서 왼쪽으로 순환하며 각 위치 기준 오른쪽에 위치한 제일 짧은 거리 파악

이해를 위해 왼쪽에서 오른쪽으로 순환하는 예시1를 살펴보겠습니다.

<br />

각 순환 별로 제일 짧은 거리를 파악하기 위해 각 color의 마지막으로 본 위치를 기억해주는 array를 다음과 같이 생성하겠습니다. 

| color | 1 | 2 | 3 |
| --- | --- | --- | --- |
| index | 0 | 0 | 0 |

<br />

이제, `[1,1,2,1,3,2,2,3,3]`에서 앞의 두 1을 처리해주었을 때 다음과 같은 형태를 띕니다.

| color | 1 | 2 | 3 |
| --- | --- | --- | --- |
| index | 2 | 0 | 0 |

| index | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| color 1 | 0 | 0 |  |  |  |  |  |  |
| color 2 |  |  |  |  |  |  |  |  |
| color 3 |  |  |  |  |  |  |  |  |

<br />

이후에 오는 2를 (inner-loop까지) 처리해 줄 경우 다음과 같이 변합니다. 

| color | 1 | 2 | 3 |
| --- | --- | --- | --- |
| index | 2 | 3 | 0 |

| index | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| color 1 | 0 | 0 |  |  |  |  |  |  |
| color 2 | 2 | 1 | 0 |  |  |  |  |  |
| color 3 |  |  |  |  |  |  |  |  |

<br />

위와 같이 왼쪽 → 오른쪽 순환에 대해 각 테이블 값을 채워주면 다음과 같이 정의됩니다. 

| color | 1 | 2 | 3 |
| --- | --- | --- | --- |
| index | 4 | 7 | 8 |

| index | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| color 1 | 0 | 0 | 1 | 0 |  |  |  |  |
| color 2 | 2 | 1 | 0 | 2 | 1 | 0 | 0 |  |
| color 3 | 4 | 3 | 2 | 1 | 0 | 2 | 1 | 0 |

<br />

이를 역방향, 오른쪽 → 왼쪽, 으로 다시 같은 방법을 적용해주면, 최종적으로 모든 위치에서 모든 색에 대한 제일 짧은 거리 값을 구할 수 있습니다. 두 번째 순환에서 거리 테이블 내의 값이 `-1` 또는 현재 거리 값보다 큰 경우에만 업데이트를 해줌으로서 최소 거리값을 알아냅니다.

```java
class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;
        int[][] dist = new int[3][n]; 

        // do it this way as outer-loop dim gets smaller at init
        for(int i=0; i<3; ++i)
            Arrays.fill(dist[i], -1);
        
        int[] lastseen = new int[3];
        
        // left to right
        for(int i=0; i<n; ++i){
            int color = colors[i]-1;
            for(int j=lastseen[color]; j<=i; ++j)
                dist[color][j] = i-j;
            lastseen[color] = i+1;
        }

        // right to left
        Arrays.fill(lastseen, n-1);
        for(int i=n-1; i>=0; --i){
            int color = colors[i]-1;
            for(int j=lastseen[color]; j>=i; --j)
                if(dist[color][j] == -1 || dist[color][j] > j-i)
                    dist[color][j] = j-i;
            lastseen[color] = i-1;
        }
        
        List<Integer> retval = new LinkedList<>();
        for(int i=0; i<queries.length; ++i)
            retval.add(dist[queries[i][1]-1][queries[i][0]]);
        
        return retval;
    }
}
```

*Time Complexity*: O(n+q)

- 처음 dist array를 지정해 줄 때: O(3n) ~ O(n)

- 순환 wctc: O(2n) ~ O(n)

- 리턴값 지정: O(q)

- 최종: O(3n+2n+2n+q) ~ O(n+q)

*Space Complexity*: O(3n) ~ O(n)
