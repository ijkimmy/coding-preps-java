import java.util.HashMap;
public class leetcode_md_1166_filesystem {
    class Folder{
        HashMap<String, Folder> subdir = new HashMap<>();
        int val;
    }

    Folder home;


    // 32m
    public leetcode_md_1166_filesystem() {
        home = new Folder();
    }
    
    public boolean createPath(String path, int value) {
        String[] folders = path.split("/");

        Folder curr = home;
        for(int i=1; i<folders.length; ++i){
            if(!curr.subdir.containsKey(folders[i])){
                if(i==folders.length-1)
                    curr.subdir.put(folders[i], new Folder());
                else 
                    return false;
            }

            curr = curr.subdir.get(folders[i]);
        }
        if(curr.val != 0) return false;
        curr.val = value;
        return true;
    }
    
    public int get(String path) {
        String[] folders = path.split("/");

        Folder curr = home;
        for(int i=1; i<folders.length; ++i){
            if(!curr.subdir.containsKey(folders[i])) return -1;
            curr = curr.subdir.get(folders[i]);
        }

        return curr.val;
    }
}
