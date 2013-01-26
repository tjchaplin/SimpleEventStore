package com.ticktockdevelopment.simpleeventstore.Infrastructure;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/21/13
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IHandler<T> {
    <Y>boolean CanHandle(Y type);
    void Handle(T message);
}
