package automaton.event;

import pattern.publish.subscribe.Publisher;
import pattern.publish.subscribe.Subscriber;

public abstract class EventLayer extends Publisher<Event<?>> implements Subscriber<Event<?>> {

}
