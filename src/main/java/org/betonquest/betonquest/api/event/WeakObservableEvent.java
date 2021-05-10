package org.betonquest.betonquest.api.event;

import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;

import java.util.*;
import java.util.function.Consumer;

public abstract class WeakObservableEvent<E> implements ObservableEvent<E> {

    private final SetMultimap<Integer, Consumer<E>> observers;

    public WeakObservableEvent() {
        observers = Multimaps.synchronizedSetMultimap(
                Multimaps.newSetMultimap(new TreeMap<>(), () -> Collections.newSetFromMap(new WeakHashMap<>())));
    }

    @Override
    public void attachObserver(final int priority, final Consumer<E> observer) {
        Objects.requireNonNull(observer);
        observers.put(priority, observer);
    }

    @Override
    public void detachObserver(final int priority, final Consumer<E> observer) {
        Objects.requireNonNull(observer);
        observers.remove(priority, observer);
    }

    @Override
    public void detachObserverFromAll(final Consumer<E> observer) {
        Objects.requireNonNull(observer);
        synchronized (observers) {
            for (final int priority : observers.keySet()) {
                observers.get(priority).remove(observer);
            }
        }
    }

    @Override
    public void notify(final int priority, final E event) {
        synchronized (observers) {
            observers.get(priority).forEach(observer -> observer.accept(event));
        }
    }
}
