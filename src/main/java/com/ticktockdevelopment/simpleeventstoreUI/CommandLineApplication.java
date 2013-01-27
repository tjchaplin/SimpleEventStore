package com.ticktockdevelopment.simpleeventstoreUI;

import com.ticktockdevelopment.simpleeventstore.EventStores.EventStore;
import com.ticktockdevelopment.simpleeventstore.EventStores.IEventStore;
import com.ticktockdevelopment.simpleeventstore.EventStores.Repository;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IHandler;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IRepository;
import com.ticktockdevelopment.simpleeventstore.Messaging.Bus;
import com.ticktockdevelopment.simpleeventstore.Messaging.CommandHandlers.CreateInventoryItemCommandHandler;
import com.ticktockdevelopment.simpleeventstore.Messaging.CommandHandlers.DeactivateInventoryItemCommandHandler;
import com.ticktockdevelopment.simpleeventstore.Messaging.Commands.CreateInventoryItem;
import com.ticktockdevelopment.simpleeventstore.Messaging.Commands.DeactivateInventoryItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/26/13
 * Time: 7:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandLineApplication {
    private static int nextId = 1;

    private static Bus bus;
    private static IEventStore eventStore;

    public CommandLineApplication() {
    }

    public static void main(String[] args)
    {
        List<IHandler> handlers = new ArrayList<IHandler>();
        bus = new Bus(handlers);
        eventStore = new EventStore(bus);

        registerHandlers(bus);

        while (true)
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            try {
                String[] commands = bufferedReader.readLine().split(" ");

                if (commands[0].equals("add") && commands.length == 2)
                    createInventoryItem(commands[1]);
                if(commands[0].equals("delete") && commands.length == 3)
                    deleteInventoryItem(commands[1],commands[2]);
                else if (commands[0].equals("exit"))
                    break;
                else
                {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
                    String invalidCommandMessage = "Invalid Command\nUsage: [command] [value]\nValid Commands:\nadd ";
                    outputStreamWriter.write(invalidCommandMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    private static void deleteInventoryItem(String id,String originalVersion) {
        DeactivateInventoryItem deactivateInventoryItem = new DeactivateInventoryItem(Integer.parseInt(id),Integer.parseInt(originalVersion));
        bus.Send(deactivateInventoryItem);
    }

    private static void createInventoryItem(String item) {
        CreateInventoryItem createInventoryItem = new CreateInventoryItem(nextId,item);
        bus.Send(createInventoryItem);
        nextId++;
    }

    private static void registerHandlers(Bus bus) {
        IRepository repository = new Repository(eventStore);
        bus.RegisterHandler(new CreateInventoryItemCommandHandler(repository));
        bus.RegisterHandler(new DeactivateInventoryItemCommandHandler(repository));
//        bus.RegisterHandler(new InventoryItemDetailViewCommandHandler());
//        bus.RegisterHandler(new InventoryItemDetailViewEventHandler());
//        bus.RegisterHandler(new InventoryItemListViewCommandHandler());
//        bus.RegisterHandler(new InventoryItemListViewEventHandler());
    }
}


