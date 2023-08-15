package Generikks;
import java.util.Arrays;
public class ArrChng<N> {
    private N[] n;
    private N v;
    public ArrChng(N... n) {
        this.n = n;
    }
    public String chngElts(int x, int y) {
        x -=1;
        y -=1;
        v = n[x];
        n[x] = n[y];
        n[y] = v;
        return Arrays.toString(n);
    }
}
