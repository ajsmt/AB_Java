package AB.Set;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class MySet<T> implements Iterable<T> {
    private ArrayList<T> set;

    public MySet() {
        this.set = new ArrayList<>();
    }

    public MySet(T x) {
        this.set = new ArrayList<>();
        add(x);
    }

    public MySet(MySet<T> other) {
        this.set = new ArrayList<>(other.set);
    }

    public MySet(ArrayList<T> other) {
        this.set = new ArrayList<>(other);
    }

    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public void clear() {
        set.clear();
    }

    @Override
    public String toString() {
        return set.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        @SuppressWarnings("unchecked")
        MySet<T> other = (MySet<T>) o;
        if (this.size() != other.size())
            return false;
        for (int i = 0; i < this.size(); i++) {
            if (!this.set.get(i).equals(other.set.get(i)))
                return false;
        }
        return true;
    }

    public void add(T x) {
        if (!set.contains(x))
            set.add(x);
    }

    public void remove(T x) {
        set.remove(x);
    }

    public void addAll(MySet<T> other) {
        for (T element : other.set) {
            add(element);
        }
    }

    public MySet<T> getUnion(MySet<T> other) {
        MySet<T> unionSet = new MySet<>();
        unionSet.addAll(this);
        unionSet.addAll(other);
        return unionSet;
    }

    public MySet<T> getIntersection(MySet<T> other) {
        MySet<T> intersectionSet = new MySet<>();
        for (T x : this.set) {
            if (other.set.contains(x)) {
                intersectionSet.add(x);
            }
        }
        return intersectionSet;
    }

    public MySet<T> getDiffrence(MySet<T> other) {
        MySet<T> diffrenceSet = new MySet<>();
        for (T x : this.set) {
            if (!other.set.contains(x)) {
                diffrenceSet.add(x);
            }
        }
        return diffrenceSet;
    }

    public JList<T> getJList() {
        JList<T> result = new JList<>();

        DefaultListModel<T> resultModel = new DefaultListModel<>();
        for (T x : this.set) {
            resultModel.addElement(x);
        }
        result.setModel(resultModel);

        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new MySetIterator();
    }

    public class MySetIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < set.size();
        }

        @Override
        public T next() {
            if(hasNext()){
                return set.get(currentIndex++);
            }
            throw new IndexOutOfBoundsException();
        }
        
        public T CurrentItem() {
            return set.get(currentIndex);
        }
    }
}
