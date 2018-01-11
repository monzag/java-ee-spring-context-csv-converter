package com.monzag.controllers;

import com.monzag.models.FileType;
import com.monzag.service.FileReader;

import java.io.File;

public class SimpleCsvConverter {

    private FileReader reader;

    public SimpleCsvConverter(FileReader reader) {
        this.reader = reader;
    }

    public void convert(File file) {
        System.out.println("convert from csv file");
    }

    public void convert(File file, FileType type) {
        System.out.println("convert from file and type");
    }
}
