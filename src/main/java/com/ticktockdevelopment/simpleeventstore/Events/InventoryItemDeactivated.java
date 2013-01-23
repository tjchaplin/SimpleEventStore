package com.ticktockdevelopment.simpleeventstore.Events;

import com.ticktockdevelopment.simpleeventstore.Core.Event;

public class InventoryItemDeactivated extends Event {
    public int Id;

    public InventoryItemDeactivated(int id) {
        Id = id;
    }
}
