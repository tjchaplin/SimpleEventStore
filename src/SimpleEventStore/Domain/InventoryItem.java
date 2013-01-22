package SimpleEventStore.Domain;

import SimpleEventStore.Core.Event;
import SimpleEventStore.Events.InventoryItemCreated;
import SimpleEventStore.Events.InventoryItemDeactivated;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/21/13
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class InventoryItem extends AggregateRoot {

    private boolean  activated;

    public InventoryItem() {
    }

    public InventoryItem(int id,String name) {
        ApplyChange(new InventoryItemCreated(id,name));
    }

    void Apply(InventoryItemCreated event) {
        Id = event.Id;
        activated = true;
    }

    void Apply(InventoryItemDeactivated event) {
        Id = event.Id;
        activated = false;
    }

    @Override
    void Apply(Event event) {
        if (event instanceof InventoryItemCreated)
            Apply((InventoryItemCreated)event);

        if (event instanceof InventoryItemDeactivated)
            Apply((InventoryItemDeactivated)event);

        throw new IllegalArgumentException("UnknownEvent Type:"+event);
    }
}
