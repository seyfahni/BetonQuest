package org.betonquest.betonquest.api.event;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class ConcurrentEventRegistry implements EventRegistry {

    private final Map<Class<?>, ObservableEvent<?>> observables;

    public ConcurrentEventRegistry() {
        this.observables = new ConcurrentHashMap<>();
    }

    @Override
    public <E> void registerEventProvider(final Class<E> eventClass, final ObservableEvent<? extends E> observableEvent) {
        observables.put(eventClass, observableEvent);
    }

    @Override
    public <E> void attachObserver(final Class<E> eventClass, final int priority, final Consumer<E> observer) {
        getObservableEvent(eventClass).attachObserver(priority, observer);
    }

    @Override
    public <E> void detachObserver(final Class<E> eventClass, final int priority, final Consumer<E> observer) {
        getObservableEvent(eventClass).detachObserver(priority, observer);
    }

    @Override
    public <E> void detachObserverFromAll(final Consumer<E> observer) {
        observables.forEach((eventClass, observable) -> observable.detachObserverFromAll(observer));
    }

    private <E> ObservableEvent<E> getObservableEvent(final Class<E> eventClass) {
        //noinspection unchecked
        return (ObservableEvent<E>) observables.get(eventClass);
    }
}
