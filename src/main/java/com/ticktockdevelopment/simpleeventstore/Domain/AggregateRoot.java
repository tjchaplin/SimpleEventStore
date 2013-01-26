package com.ticktockdevelopment.simpleeventstore.Domain;

import com.ticktockdevelopment.simpleeventstore.Messaging.Events.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/21/13
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */

public abstract class AggregateRoot {
    private List<Event> _changes = new ArrayList<Event>();

    public int Id;
    public int Version;

    protected AggregateRoot() {
    }

    public int getId() {
        return Id;
    }

    public int getVersion() {
        return Version;
    }

    private void setVersion(int version) {
        Version = version;
    }

    public List<Event> GetUncommittedChanges()
    {
        return _changes;
    }

    public void MarkChangesAsCommitted()
    {
        _changes.clear();
    }

    public void LoadsFromHistory(List<Event> history)
    {
        for (Event event : history){
            ApplyChange(event, false);
        }
    }

    protected void ApplyChange(Event event)
    {
        ApplyChange(event, true);
    }

    abstract void Apply(Event event);


    private void ApplyChange(Event event,boolean isNew)
    {
        this.Apply(event);
        if(isNew)
            _changes.add(event);
    }
}
