package com.ticktockdevelopment.simpleeventstore.Infrastructure;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/21/13
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ICommandSender<T> {
    void Send(T command);
}
