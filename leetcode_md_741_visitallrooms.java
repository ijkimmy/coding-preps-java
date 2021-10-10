import java.util.List;
public class leetcode_md_741_visitallrooms {

    // 18m
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] open = new boolean[rooms.size()];
        dfs(0, rooms, open);

        for(boolean isopen: open)
            if(!isopen) return false;
        
        return true;
    }

    public void dfs(int room, List<List<Integer>> rooms, boolean[] open){
        open[room] = true;
        for(int next: rooms.get(room)){
            if(!open[next])
                dfs(next, rooms, open);
        }
    }
}
