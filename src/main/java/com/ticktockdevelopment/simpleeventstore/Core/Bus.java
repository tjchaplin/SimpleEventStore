package com.ticktockdevelopment.simpleeventstore.Core;

import com.ticktockdevelopment.simpleeventstore.Commands.Command;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.ICommandSender;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IEventPublisher;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IHandles;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/25/13
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bus implements ICommandSender, IEventPublisher {
    List<IHandles> handlers;

    public Bus(List<IHandles> handlers) {
        this.handlers = handlers;
    }

    public void RegisterHandler(IHandles handles)
    {
        if(!handlers.contains(handles))
            handlers.add(handles);
    }

    @Override
    public <T extends Command> void Send(T command) {
        for(IHandles handles : handlers)
        {
            if(handles.CanHandle(command))
            {
                handles.Handle(command);
                break;
            }
        }
    }

    @Override
    public <T extends Event> void Publish(T event) {
        for(IHandles handles : handlers)
        {
            if(handles.CanHandle(event))
                handles.Handle(event);
        }
    }
}
