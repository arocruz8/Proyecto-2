package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class max_heap<T extends Comparable<T>> extends Heap<T> {

    public max_heap(){
        super(1);
    }

    public max_heap(Collection<T> contenido) {
	super(1, contenido);
    }
}
