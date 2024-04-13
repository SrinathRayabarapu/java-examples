package com.dpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements IFileSystem{

    String directoryName;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
    }

    List<IFileSystem> list = new ArrayList<>();

    void add(IFileSystem fileSystem){
        list.add(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("Printing the contents of : " + directoryName);
        for (IFileSystem fileSystem : list){
            fileSystem.ls();
        }
    }

}
