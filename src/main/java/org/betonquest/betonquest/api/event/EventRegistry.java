package org.betonquest.betonquest.api.event;

import java.util.function.Consumer;

/**
 * TODO.
 * Higher priority means later execution but more control over the result.
 */
public interface EventRegistry {

    /**
     * @param eventClass
     * @param observableEvent
     * @param <E>
     */
    <E> void registerEventProvider(Class<E> eventClass, ObservableEvent<? extends E> observableEvent);

    /**
     * @param eventClass
     * @param priority
     * @param observer
     * @param <E>
     */
    <E> void attachObserver(Class<E> eventClass, int priority, Consumer<E> observer);

    /**
     * @param eventClass
     * @param priority
     * @param observer
     * @param <E>
     */
    <E> void detachObserver(Class<E> eventClass, int priority, Consumer<E> observer);

    /**
     * @param observer
     * @param <E>
     */
    <E> void detachObserverFromAll(Consumer<E> observer);
}
