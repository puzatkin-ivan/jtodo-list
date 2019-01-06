package com.jtodo;

import com.jtodo.model.storage.*;
import java.util.*;

public class Main {
  public static void main(String[] $args) {
    try {
      IStorage storage = new Storage();
      Scanner inStream = new Scanner(System.in);
      String path = "";
      CApplication app = new CApplication(inStream, path, storage);
      app.doExecute();
    } catch (Exception ex) {
      System.err.println(ex.toString());
    }
  }
}
