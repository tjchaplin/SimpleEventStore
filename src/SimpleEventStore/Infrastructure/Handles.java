package SimpleEventStore.Infrastructure;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/21/13
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Handles<T> {
    void Handle(T message);
}
