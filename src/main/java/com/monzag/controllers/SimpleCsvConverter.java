package com.monzag.controllers;

import com.monzag.models.FileType;
import com.monzag.service.FileReader;
import com.monzag.service.OutputFormatter;
import com.monzag.service.OutputFormatterFactory;

import java.io.File;

public class SimpleCsvConverter {

    private FileReader reader;
    private OutputFormatterFactory outputFormatterFactory;

    public SimpleCsvConverter(FileReader reader, OutputFormatterFactory outputFormatterFactory) {
        this.reader = reader;
        this.outputFormatterFactory = outputFormatterFactory;
    }

    public void convert(File file) {
        OutputFormatter outputFormatter = outputFormatterFactory.createByFormat();
        System.out.println("convert from csv file");
    }

    public void convert(File file, FileType type) {
        OutputFormatter outputFormatter = outputFormatterFactory.createByFormat(type);
        System.out.println("convert from file and type");
    }
}
