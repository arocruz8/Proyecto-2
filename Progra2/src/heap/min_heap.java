package heap;
import java.util.Collection;

public class min_heap<T extends Comparable<T>> extends heap<T> {

    public min_heap() {
	super(-1);
    }

    public min_heap(Collection<T> contenido) {
	super(-1, contenido);
    }
}