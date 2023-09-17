public class ListaComune<T> implements Lista<T> {
    protected final ListaLinked<T> list = new ListaLinked<>();

    public T get(int index) {
        return list.prendi(index);
    }

    public boolean contains(T check) {
        return list.contiene(check);
    }

    public int size() {
        return list.dimensione();
    }

    public void add(T object) {
        list.aggiungi(object);
    }

    public boolean remove(int index) {
        return list.rimuovi(index);
    }

    public void clear() {
        list.svuota();
    }

}
