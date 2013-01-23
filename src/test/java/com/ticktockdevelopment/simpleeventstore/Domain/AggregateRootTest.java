package com.ticktockdevelopment.simpleeventstore.Domain;

import com.ticktockdevelopment.simpleeventstore.Core.Event;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/23/13
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class AggregateRootTest extends AggregateRoot {
    public boolean didLoadFromHistory = false;

    @Override
    public void LoadsFromHistory(List<Event> history) {
        super.LoadsFromHistory(history);
        didLoadFromHistory = true;
    }

    @Override
    void Apply(Event event) {

    }
}
