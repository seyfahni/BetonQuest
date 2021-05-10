package org.betonquest.betonquest.api.event;

import java.util.function.Consumer;

public abstract class ObservableEventDecorator<E> implements ObservableEvent<E> {

    protected final ObservableEvent<E> decorated;

    protected ObservableEventDecorator(final ObservableEvent<E> decorated) {
        this.decorated = decorated;
    }

    @Override
    public void attachObserver(final int priority, final Consumer<E> observer) {
        decorated.attachObserver(priority, observer);
    }

    @Override
    public void detachObserver(final int priority, final Consumer<E> observer) {
        decorated.detachObserver(priority, observer);
    }

    @Override
    public void detachObserverFromAll(final Consumer<E> observer) {
        decorated.detachObserverFromAll(observer);
    }

    @Override
    public void detachAll() {
        decorated.detachAll();
    }

    @Override
    public void notify(final int priority, final E event) {
        decorated.notify(priority, event);
    }
}
