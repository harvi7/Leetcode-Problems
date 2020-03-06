class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // the areas of two rectangles
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        
        int overlap = 0;
		// if they overlap, just calculate the overlapped area
        if (!(E > C || G < A || F > D || H < B)) 
            overlap = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        return area1 + area2 - overlap;
    }
}