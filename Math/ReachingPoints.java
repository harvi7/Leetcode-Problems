// https://www.youtube.com/watch?v=tPr5Uae6Drc&ab_channel=TonyTeaches

class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy)
                return true;
            if (tx > ty)
                tx %= ty;
            else
                ty %= tx;
                
            if (tx == sx) 
                if ((ty - sy) % tx == 0)
                    return true;
                else
                    return false;
                
            if (ty == sy)
                if ((tx - sx) % ty == 0)
                    return true;
                else
                    return false;
        }     
        return false;
    }
}