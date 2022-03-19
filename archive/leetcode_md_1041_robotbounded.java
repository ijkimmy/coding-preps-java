public class leetcode_md_1041_robotbounded {


    // 34m
    public boolean isRobotBounded(String instructions) {
        // logic: if (ending loc != origin && deg == 0) return false;
        // time: O(n), space: O(1)
        final int deg90 = 90, deg360 = 360;
        int deg = 0, x = 0, y = 0;
        for(int i=0; i<instructions.length(); ++i){
            char c = instructions.charAt(i);
            if(c == 'L'){
                deg = (deg - deg90) % deg360;
            } else if(c == 'R') {
                deg = (deg + deg90) % deg360;
            } else {
                switch(deg){
                    case 0: 
                        ++y;
                        break;
                    case -90: 
                    case 270:
                        --x;
                        break;
                    case -180:
                    case 180:
                        --y;
                        break;
                    case -270:
                    case 90:
                        ++x;
                        break;
                }
            }
        }

        if(deg == 0 && (x != 0 || y != 0))
            return false;

        return true;
    }
}
