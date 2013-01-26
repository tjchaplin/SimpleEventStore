package com.ticktockdevelopment.simpleeventstore.Messaging.Events;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/21/13
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */

public class InventoryItemCreated extends Event {
    public int Id;
    public String name;

    public InventoryItemCreated(int id, String name) {
        Id = id;
        this.name = name;
    }
}


