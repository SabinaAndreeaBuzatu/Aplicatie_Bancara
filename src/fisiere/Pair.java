package fisiere;
import java.util.*;
import produse.*;
public class Pair <U,V> {
    protected U first;
    protected V second;
    public Pair (U c,V d)
    {this.first=c;
    this.second=d;}

    public U getFirst() {
        return first;

    }

    public V getSecond() {
        return second;
    }
}
