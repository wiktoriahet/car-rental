package pl.hetman.wiktoria.solvd.functionalinterfaces;

import pl.hetman.wiktoria.solvd.carrental.Basket;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface Order<T, E> {
    Basket<T> quickOrder(E e);
}
