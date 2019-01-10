package com.jtodo.workWithFiles;

import com.jtodo.toDoObjects.*;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface IDataWorker {
    IMainList convertDataFromFiles(File dir) throws Exception;
    void convertDataToFiles(IMainList mainList, File dir) throws Exception;
    void deleteDifferences(IMainList mainList, File dir) throws  Exception;
}
