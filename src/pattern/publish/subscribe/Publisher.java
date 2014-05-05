package pattern.publish.subscribe;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class Publisher<T> {

	Map<Class<? extends T>, Collection<Subscriber<T>>> subscribers;

	public Publisher() {
		this.subscribers = new HashMap<Class<? extends T>, Collection<Subscriber<T>>>();
	}

	public void publish(T publication) {
		Class<? extends Object> publicationType = publication.getClass();

		for (Class<? extends Object> subscriberType : subscribers.keySet()) {
			if (subscriberType.isAssignableFrom(publicationType)) {
				for (Subscriber<T> subscriber : subscribers.get(subscriberType)) {
					subscriber.inform(publication);
				}
			}
		}
	}

	public void subscribe(Class<? extends T> publicationType, Subscriber<T> subscriber) {
		if (!subscribers.containsKey(publicationType)) {
			subscribers.put(publicationType, new HashSet<Subscriber<T>>());
		}
		subscribers.get(publicationType).add(subscriber);
	}
}
