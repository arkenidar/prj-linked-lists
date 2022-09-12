public class ListaDiInteri extends ListaComune<Integer> {
    public String toString() {
        StringBuilder testo = new StringBuilder("[ ");
        for (int indice = 0; indice < list.dimensione(); indice++)
            testo.append(list.prendi(indice)).append(", ");
        testo.append(" ]");
        return testo.toString();
    }
}
