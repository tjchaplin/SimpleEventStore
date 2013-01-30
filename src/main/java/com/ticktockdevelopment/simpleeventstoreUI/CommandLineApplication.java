package com.ticktockdevelopment.simpleeventstoreUI;

import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemDetailsDto;
import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemListDto;
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
import com.ticktockdevelopment.simpleeventstore.Views.InventoryItemDetailView;
import com.ticktockdevelopment.simpleeventstore.Views.InventoryItemListView;
import com.ticktockdevelopment.simpleeventstore.Views.handlers.InventoryItemDetailViewInventoryItemCreatedHandler;
import com.ticktockdevelopment.simpleeventstore.Views.handlers.InventoryItemDetailViewInventoryItemDeactivatedHandler;
import com.ticktockdevelopment.simpleeventstore.Views.handlers.InventoryItemListViewInventoryItemCreatedHandler;
import com.ticktockdevelopment.simpleeventstore.Views.handlers.InventoryItemListViewInventoryItemDeactivatedHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
                else if(commands[0].equals("delete") && commands.length == 3)
                    deleteInventoryItem(commands[1],commands[2]);
                else if(commands[0].equals("list") && commands.length == 1)
                    listInventoryItem();
                else if(commands[0].equals("listdetail") && commands.length == 1)
                    listInventoryItemDetail();
                else if (commands[0].equals("exit"))
                    break;
                else
                {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
                    String invalidCommandMessage = "Invalid Command\nUsage: [command] [value]\nValid Commands:\nadd ";
                    outputStreamWriter.write(invalidCommandMessage);
                    outputStreamWriter.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    private static void listInventoryItemDetail() {
        InventoryItemDetailView detailView = new InventoryItemDetailView();
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            for(InventoryItemDetailsDto details : detailView.GetView())
            {
                writer.write(details.toString()+"\n");

            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private static void listInventoryItem() {
        InventoryItemListView listView = new InventoryItemListView();
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            for(InventoryItemListDto details : listView.GetView())
            {
                writer.write(details.toString()+"\n");

            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
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

        bus.RegisterHandler(new InventoryItemDetailViewInventoryItemCreatedHandler());
        bus.RegisterHandler(new InventoryItemDetailViewInventoryItemDeactivatedHandler());

        bus.RegisterHandler(new InventoryItemListViewInventoryItemCreatedHandler());
        bus.RegisterHandler(new InventoryItemListViewInventoryItemDeactivatedHandler());
    }
}


