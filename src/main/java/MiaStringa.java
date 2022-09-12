public class MiaStringa implements Lista<Character> {
    private final ListaLinked<Character> list = new ListaLinked<>();

    @Override
    public Character get(int index) {
        return list.prendi(index);
    }

    @Override
    public boolean contains(Character check) {
        return list.contiene(check);
    }

    @Override
    public int size() {
        return list.dimensione();
    }

    @Override
    public void add(Character object) {
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
        StringBuilder testo = new StringBuilder();
        for (int indice = 0; indice < list.dimensione(); indice++)
            testo.append(list.prendi(indice));
        return testo.toString();
    }

    @Override
    public boolean equals(Object object) {
        return toString().equals(object.toString());
    }
}
