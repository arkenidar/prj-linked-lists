// https://replit.com/@dariocangialosi/liste-collegate-liste-linked#main.c

public class ListaLinked<T> {
    private Nodo<T> primo, ultimo;

    public void rimuovi(Nodo<T> quale) {
        if (quale == null) return;
        if (quale == primo) primo = quale.successivo;
        if (quale == ultimo) ultimo = quale.precedente;
        if (quale.precedente != null) quale.precedente.successivo = quale.successivo;
        if (quale.successivo != null) quale.successivo.precedente = quale.precedente;
    }

    public Nodo<T> prendi(int indice) {
        Nodo<T> scorre = primo;
        for (int i = 0; scorre != null; i++) {
            if (i == indice)
                return scorre;
            scorre = scorre.successivo;
        }
        return null;
    }

    public void aggiungi(T elemento) {
        Nodo<T> corrente = new Nodo<>();
        corrente.contenuto = elemento;
        corrente.successivo = null;
        corrente.precedente = ultimo;
        if (ultimo == null) primo = corrente;
        else ultimo.successivo = corrente;
        ultimo = corrente;
    }

    public void scorri() {
        Nodo<T> scorre;
        scorre = primo;
        while (scorre != null) {
            System.out.println(scorre.contenuto);
            scorre = scorre.successivo;
        }
    }

    public void scorriInverso() {
        Nodo<T> scorre;
        scorre = ultimo;
        while (scorre != null) {
            System.out.println(scorre.contenuto);
            scorre = scorre.precedente;
        }
    }
}

class Nodo<T> {
    T contenuto;
    Nodo<T> successivo, precedente;
}