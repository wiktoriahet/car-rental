package pl.hetman.wiktoria.solvd.carrental;

import pl.hetman.wiktoria.solvd.customlinkedlist.GenericLinkedList;

import java.util.Objects;

//Generics and collections task
public class Basket<T> extends GenericLinkedList<T> {

    private GenericLinkedList<T> basket;

    public Basket() {
        this.basket = new GenericLinkedList<>();
    }

    public Basket(GenericLinkedList<T> basket) {
        this.basket = basket;
    }

    public GenericLinkedList<T> getBasket() {
        return basket;
    }

    public void setBasket(GenericLinkedList<T> basket) {
        this.basket = basket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Basket<?> basket1)) return false;
        return Objects.equals(getBasket(), basket1.getBasket());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBasket());
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basket=" + basket +
                '}';
    }
}
