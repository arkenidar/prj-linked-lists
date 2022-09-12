public class MiaStringa extends ListaComune<Character> {
    public String toString() {
        StringBuilder testo = new StringBuilder();
        for (int indice = 0; indice < list.dimensione(); indice++)
            testo.append(list.prendi(indice));
        return testo.toString();
    }

    public boolean equals(Object object) {
        return toString().equals(object.toString());
    }
}
