class leetcode_ez_1859_sortsentece {
    // 23m
    public String sortSentence(String s) {
        String[] ordered = new String[9];

        for(String word: s.split(" ")){
            int idx = word.charAt(word.length()-1) - '1';
            ordered[idx] = word; 
        }

        StringBuilder retval = new StringBuilder();
        for(String word: ordered){
            if(word == null) break;
            retval.append(" ");
            retval.append(word);
            retval.setLength(retval.length()-1);
        }

        return retval.toString().trim();
    }
}