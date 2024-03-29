package assignments.example.depthoffieldcalculator.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Data model: Store a collection of lenses.
 */
public class LensManager implements Iterable<Lens>{
    private List<Lens> lenses = new ArrayList<>();

    public void add(Lens lens) {
        lenses.add(lens);
    }
    public void remove(Lens lens) {
        lenses.remove(lens);
    }
    public Lens get(int i) {
        return lenses.get(i);
    }

    @Override
    public Iterator<Lens> iterator() {
        return lenses.iterator();
    }

    public int getNumLenses() {
        return lenses.size();
    }
}
