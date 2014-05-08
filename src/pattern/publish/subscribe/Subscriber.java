package pattern.publish.subscribe;

public interface Subscriber<P> {

	void inform(P publication);
}
