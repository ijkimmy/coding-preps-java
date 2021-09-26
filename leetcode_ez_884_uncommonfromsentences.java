import java.util.HashMap;
import java.util.LinkedList;
public class leetcode_ez_884_uncommonfromsentences {

    // 9m
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> wordcnt = new HashMap<>();
        for(String word: s1.split(" "))
            wordcnt.put(word, wordcnt.getOrDefault(word, 0) + 1);
        for(String word: s2.split(" "))
            wordcnt.put(word, wordcnt.getOrDefault(word, 0) + 1);
        
        LinkedList<String> lans = new LinkedList<>();
        for(String word: wordcnt.keySet()){
            if(wordcnt.get(word)==1)
                lans.add(word);
        }
        
        return lans.toArray(new String[0]);
    }
}
