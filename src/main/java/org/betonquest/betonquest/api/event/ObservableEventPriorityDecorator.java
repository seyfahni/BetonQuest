package org.betonquest.betonquest.api.event;

import org.bukkit.event.Listener;

import java.util.function.Consumer;
import java.util.function.ToIntFunction;

public class ObservableEventPriorityDecorator<E, P> extends ObservableEventDecorator<E> implements Listener {

    private final ToIntFunction<P> priorityAdapter;

    public ObservableEventPriorityDecorator(final ObservableEvent<E> decorated, final ToIntFunction<P> priorityAdapter) {
        super(decorated);
        this.priorityAdapter = priorityAdapter;
    }

    public void attachObserver(final P priority, final Consumer<E> observer) {
        attachObserver(priorityAdapter.applyAsInt(priority), observer);
    }

    public void detachObserver(final P priority, final Consumer<E> observer) {
        detachObserver(priorityAdapter.applyAsInt(priority), observer);
    }

    public void notify(final P priority, final E event) {
        notify(priorityAdapter.applyAsInt(priority), event);
    }
}
