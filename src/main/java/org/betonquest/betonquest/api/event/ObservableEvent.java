package org.betonquest.betonquest.api.event;

import java.util.function.Consumer;

/**
 * An adapter to make other event systems observable. It represents the observable part of the observer design pattern.
 * A {@link Consumer} has to be used for the observer.
 *
 * @param <E> the provided event
 */
public interface ObservableEvent<E> {

    /**
     *
     *
     * @param observer
     */
    void attachObserver(int priority, Consumer<E> observer);

    /**
     * @param observer
     */
    void detachObserver(int priority, Consumer<E> observer);

    /**
     * @param observer
     */
    void detachObserverFromAll(Consumer<E> observer);

    /**
     *
     */
    void detachAll();

    /**
     * @param priority
     * @return
     */
    void notify(int priority, E event);
}
