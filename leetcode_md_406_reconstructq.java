import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
public class leetcode_md_406_reconstructq {

    // 43m
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
            }
        });

        LinkedList<int[]> retval = new LinkedList<>();
        for(int[] p: people)
            retval.add(p[1], p);
        
        return retval.toArray(new int[people.length][people[0].length]);
    }
}
