public class ListaDiInteri implements Lista<Integer> {
    private final ListaLinked<Integer> list = new ListaLinked<>();

    @Override
    public Integer get(int index) {
        return list.prendi(index);
    }

    @Override
    public boolean contains(Integer check) {
        return list.contiene(check);
    }

    @Override
    public int size() {
        return list.dimensione();
    }

    @Override
    public void add(Integer object) {
        list.aggiungi(object);
    }

    @Override
    public boolean remove(int index) {
        return list.rimuovi(index);
    }

    @Override
    public void clear() {
        list.svuota();
    }

    @Override
    public String toString() {
        StringBuilder testo = new StringBuilder("[ ");
        for (int indice = 0; indice < list.dimensione(); indice++)
            testo.append(list.prendi(indice)).append(", ");
        testo.append(" ]");
        return testo.toString();
    }
}
