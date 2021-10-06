import java.util.Set;

public class leetcode_ez_345_reversevowels {

    // 18m
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        
        int left = 0, right = chars.length-1;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        while(left < right){

            while(left < right && !vowels.contains(chars[left])) ++left;
            while(left < right && !vowels.contains(chars[right])) --right;

            if(left == right) return String.valueOf(chars);

            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }

        return String.valueOf(chars);
    }
}
