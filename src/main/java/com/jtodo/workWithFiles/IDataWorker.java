package workWithFiles;

import toDoObjects.IMainList;
import toDoObjects.IToDoList;
import toDoObjects.IToDoObject;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface IDataWorker {
    IMainList convertDataFromFiles(File dir) throws Exception;
    void convertDataToFiles(IMainList mainList, File dir) throws Exception;
    void deleteDifferences(IMainList mainList, File dir) throws  Exception;
}
