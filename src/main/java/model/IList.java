package model;

public interface IList {
    void setName(String name);
    String getName(String name);

    void addTask(ITask task) throws Exception;
}