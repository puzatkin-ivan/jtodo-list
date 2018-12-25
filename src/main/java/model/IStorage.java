package model;

public interface IStorage {
    void setName(String name);
    String getName(String name);

    void addList(IList list) throws Exception;
}