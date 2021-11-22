// import java.util.LinkedList;
public class leetcode_ez_1592_reorderspace {

    // 44m
    public String reorderSpaces(String text) {
        // // initial solution, O(n)
        // int spacecnt = 0;
        // StringBuilder sb = new StringBuilder(); 
        // LinkedList<String> words = new LinkedList<>();
        // for(int i=0; i<text.length(); ++i){
        //     if(text.charAt(i) == ' '){
        //         if(sb.length() > 0){
        //             words.add(sb.toString());
        //             sb.setLength(0);
        //         }
        //         ++spacecnt;
        //     }
        //     else
        //         sb.append(text.charAt(i));
        // }

        // if(sb.length() > 0){
        //     words.add(sb.toString());
        //     sb.setLength(0);
        // }

        // if(spacecnt == 0) return text;
        // if(words.size() == 1) return text.trim() + " ".repeat(spacecnt); 

        // String space = " ".repeat(spacecnt / (words.size() - 1)); 
        // String leftover = " ".repeat(spacecnt % (words.size() - 1));
        // for(String word: words){
        //     sb.append(word);
        //     sb.append(space);
        // }
        
        // return sb.toString().trim() + leftover;


        // cleaner code, O(n) but may takes up more constant time
        String[] words = text.trim().split("\\s+");
        int space = (int)text.chars().filter(c -> c == ' ').count();
        int gap = words.length==1 ? 0 : space/(words.length - 1);
        int tail = space - gap * (words.length-1);
        return String.join(" ".repeat(gap), words) + " ".repeat(tail);
    }
}
