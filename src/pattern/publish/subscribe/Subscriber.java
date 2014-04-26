package pattern.publish.subscribe;

public interface Subscriber<T> {

	void inform(T publication);
}
