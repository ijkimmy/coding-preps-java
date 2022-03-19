import java.io.*;
import java.util.StringTokenizer;
public class matchhere_day15_q2 {
    public static void main(String[] args){
        // BJ 14888
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());

            int[] nums = new int[n];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0; i<n; ++i){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            final int opersize = 4;
            int[] opers = new int[opersize];
            st = new StringTokenizer(bf.readLine());
            for(int i=0; i<opersize; ++i){
                opers[i] = Integer.parseInt(st.nextToken());
            }

            dfs(nums, opers, 1, nums[0]);

            System.out.println(max);
            System.out.println(min);
        } catch(IOException e){
            System.out.print(e);
        }
    }

    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public static void dfs(int[] nums, int[] opers, int ni, int val){
        if(ni == nums.length){
            min = min>val ? val : min;
            max = max<val ? val : max;
            return;
        }

        for(int i=0; i<opers.length; ++i){
            if(opers[i] > 0){
                --opers[i];
                int nextval = 0;
                switch(i){
                    case 0:
                        nextval = val + nums[ni];
                        break;
                    case 1:
                        nextval = val - nums[ni];
                        break;
                    case 2:
                        nextval = val * nums[ni];
                        break;
                    case 3:
                        nextval = val / nums[ni];
                        break;
                }
                dfs(nums, opers, ni+1, nextval);
                ++opers[i];
            }
        }
    }
}


/* READ THE PROBLEM!!! NO CHANGE IN ORDER OF NUMBERS!!!
import java.io.*;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
public class matchhere_day15_q2 {
    public static void main(String[] args){
        // BJ 14888
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());

            int[] nums = new int[n];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0; i<n; ++i){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            final int opersize = 4;
            int[] opers = new int[opersize];
            st = new StringTokenizer(bf.readLine());
            for(int i=0; i<opersize; ++i){
                opers[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<n; ++i){
                HashSet<Integer> included = new HashSet<>();
                included.add(i);
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                dfs(nums, opers, n-1, nums[i], included, sb);
            }

            System.out.println(max);
            System.out.println(min);
        } catch(IOException e){
            System.out.print(e);
        }
    }

    static HashMap<Integer, List<String>> map = new HashMap<>();

    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public static void dfs(int[] nums, int[] opers, int exec, int val, HashSet<Integer> included, StringBuilder sb){
        if(exec == 0){
            if(!map.containsKey(val))
                map.put(val, new LinkedList<>());
            map.get(val).add(sb.toString());
            min = min>val ? val : min;
            max = max<val ? val : max;
            return;
        }

        for(int i=0; i<nums.length; ++i){
            if(!included.contains(i)){
                for(int j=0; j<opers.length; ++j){
                    if(opers[j] > 0){
                        included.add(i);
                        --opers[j];
                        int nextval = 0;
                        int orglen = sb.length();
                        switch(j){
                            case 0:
                                nextval = val + nums[i];
                                sb.append(" + " + nums[i] + "(" + nextval + ")");
                                break;
                            case 1:
                                nextval = val - nums[i];
                                sb.append(" - " + nums[i] + "(" + nextval + ")");
                                break;
                            case 2:
                                nextval = val * nums[i];
                                sb.append(" * " + nums[i] + "(" + nextval + ")");
                                break;
                            case 3:
                                nextval = val / nums[i];
                                sb.append(" / " + nums[i] + "(" + nextval + ")");
                                break;
                        }
                        dfs(nums, opers, exec-1, nextval, included, sb);
                        sb.setLength(orglen);
                        included.remove(i);
                        ++opers[j];
                    }
                }
            }
        }
    }
}
*/