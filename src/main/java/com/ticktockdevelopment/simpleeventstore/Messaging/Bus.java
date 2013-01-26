package com.ticktockdevelopment.simpleeventstore.Messaging;

import com.ticktockdevelopment.simpleeventstore.Infrastructure.ICommandSender;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IEventPublisher;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IHandler;
import com.ticktockdevelopment.simpleeventstore.Messaging.Commands.Command;
import com.ticktockdevelopment.simpleeventstore.Messaging.Events.Event;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/25/13
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bus implements ICommandSender, IEventPublisher {
    List<IHandler> handlers;

    public Bus(List<IHandler> handlers) {
        this.handlers = handlers;
    }

    public void RegisterHandler(IHandler handler)
    {
        if(!handlers.contains(handler))
            handlers.add(handler);
    }

    @Override
    public <T extends Command> void Send(T command) {
        for(IHandler handler : handlers)
        {
            if(handler.CanHandle(command))
            {
                handler.Handle(command);
                break;
            }
        }
    }

    @Override
    public <T extends Event> void Publish(T event) {
        for(IHandler handler : handlers)
        {
            if(handler.CanHandle(event))
                handler.Handle(event);
        }
    }
}
