public interface Lista<T> {
    T get(int index);

    boolean contains(T check);

    int size();

    void add(T object);

    boolean remove(int index);

    void clear();
}
