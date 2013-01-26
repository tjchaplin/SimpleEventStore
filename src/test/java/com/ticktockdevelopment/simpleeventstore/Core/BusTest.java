package com.ticktockdevelopment.simpleeventstore.Core;

import com.ticktockdevelopment.simpleeventstore.Commands.Command;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IHandles;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/26/13
 * Time: 9:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class BusTest {
    private Bus bus;
    private IHandles handler;

    @Before
    public void setUp() throws Exception {
        handler = mock(IHandles.class);
        List<IHandles> handlers = new ArrayList<IHandles>();
        handlers.add(handler);
        bus = new Bus(handlers);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void When_Registering_Handlers_That_Dont_Exist_Should_Add_Handlers() throws Exception {
        IHandles unRegisteredHandler = mock(IHandles.class);

        bus.RegisterHandler(unRegisteredHandler);
        Assert.assertTrue(bus.handlers.contains(unRegisteredHandler));
    }

    @Test
    public void When_Registering_Handlers_That_Exist_Should_Not_Add_Handlers() throws Exception {
        bus.RegisterHandler(handler);
        Assert.assertTrue(bus.handlers.size() == 1);
    }

    @Test
    public void When_Publishing_Event_Should_Handle_If_It_Can_Handle() throws Exception {
        when(handler.CanHandle(any(Event.class))).thenReturn(true);
        bus.Publish(new Event());
        verify(handler).Handle(any(Event.class));
    }

    @Test
    public void When_Publishing_Event_Should_Not_Handle_If_It_Cant_Handle() throws Exception {
        when(handler.CanHandle(any(Event.class))).thenReturn(false);
        bus.Publish(new Event());
        verify(handler, never()).Handle(any(Event.class));
    }


    @Test
    public void When_Sending_Command_Should_Handle_If_It_Can_Handle() throws Exception {
        when(handler.CanHandle(any(Command.class))).thenReturn(true);
        bus.Send(new Command());
        verify(handler).Handle(any(Command.class));
    }

    @Test
    public void When_Publishing_Command_Should_Not_Handle_If_It_Cant_Handle() throws Exception {
        when(handler.CanHandle(any(Command.class))).thenReturn(false);
        bus.Send(new Command());
        verify(handler, never()).Handle(any(Command.class));
    }
}
