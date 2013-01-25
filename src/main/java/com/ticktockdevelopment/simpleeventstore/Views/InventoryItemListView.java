package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.Core.InMemoryDatabase;
import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemListDto;
import com.ticktockdevelopment.simpleeventstore.Events.InventoryItemCreated;
import com.ticktockdevelopment.simpleeventstore.Events.InventoryItemDeactivated;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IHandles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/25/13
 * Time: 9:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class InventoryItemListView{

    public static class InventoryItemCreatedHandler implements IHandles<InventoryItemCreated> {

        @Override
        public <Y> boolean CanHandle(Y type) {
            return type instanceof InventoryItemCreated;
        }

        @Override
        public void Handle(InventoryItemCreated message) {
            InMemoryDatabase.inventoryItemList.add(new InventoryItemListDto(message.Id,message.name));
        }
    }

    public static class InventoryItemDeactivatedHanlder implements IHandles<InventoryItemDeactivated> {

        @Override
        public <Y> boolean CanHandle(Y type) {
            return type instanceof InventoryItemDeactivated;
        }

        @Override
        public void Handle(InventoryItemDeactivated message) {
            List<InventoryItemListDto> list = new ArrayList<InventoryItemListDto>(InMemoryDatabase.inventoryItemList);
            for(InventoryItemListDto inventoryItemListDto : InMemoryDatabase.inventoryItemList)
            {
                if(inventoryItemListDto.Id == message.Id)
                   InMemoryDatabase.inventoryItemList.remove(inventoryItemListDto);
            }

        }
    }
}

