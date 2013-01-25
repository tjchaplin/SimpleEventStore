package com.ticktockdevelopment.simpleeventstore.Views;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/25/13
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IDatabase {
    <T> void  Create(int Id, T object);
    <T> void  Update(int Id, T object);
    <T> void  Delete(int Id);
    <T> void  Read(int Id);
}
