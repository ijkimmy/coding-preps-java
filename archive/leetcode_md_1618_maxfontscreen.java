/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 *     // Return the width of char ch when fontSize is used.
 *     public int getWidth(int fontSize, char ch) {}
 *     // Return Height of any char when fontSize is used.
 *     public int getHeight(int fontSize)
 * }
 */

public class leetcode_md_1618_maxfontscreen {
    interface FontInfo{
        public int getWidth(int fontsize, char ch);
        public int getHeight(int fontsize);
    }


    // 33m
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        // binary search, time: O(t + 26logf), space: O(26)
        cntchars = new char[26];
        this.fontInfo = fontInfo;
        for(int i=0; i<text.length(); ++i){
            ++cntchars[text.charAt(i)-'a'];
        }

        if(getWidth(fonts[0]) > w || fontInfo.getHeight(fonts[0]) > h){
            return -1;
        }

        int l = 0, r = fonts.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;

            int fsize = fonts[mid], width = getWidth(fsize), height = fontInfo.getHeight(fsize);
            
            if(w < width || h < height){
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return fonts[l-1];
    }

    char[] cntchars;
    FontInfo fontInfo;
    public int getWidth(int fsize){
        int width = 0;
        for(int i=0; i<cntchars.length; ++i){
            width += cntchars[i] * fontInfo.getWidth(fsize, (char)(i+'a'));
        }
        return width;
    }
}
