package com.ticktockdevelopment.simpleeventstore.Infrastructure;

import com.ticktockdevelopment.simpleeventstore.Messaging.Commands.Command;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/21/13
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ICommandSender {
    <T extends Command> void Send(T command);
}
