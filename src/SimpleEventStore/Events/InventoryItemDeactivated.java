package SimpleEventStore.Events;

import SimpleEventStore.Core.Event;

public class InventoryItemDeactivated extends Event {
    public int Id;

    public InventoryItemDeactivated(int id) {
        Id = id;
    }
}
