package com.ticktockdevelopment.simpleeventstore.DAO;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/25/13
 * Time: 9:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class InventoryItemDetailsDto {
    public int Id;
    public String Name;
    public int CurrentCount;
    public int Version;

    public InventoryItemDetailsDto(int id, String name, int currentCount, int version) {
        Id = id;
        Name = name;
        CurrentCount = currentCount;
        Version = version;
    }

    @Override
    public String toString() {
        String detail = "InventoryId:"+Id+" InventoryName:"+Name+" Version:"+Version+" CurrentCount:"+CurrentCount;
        return detail;
    }
}
