package com.monzag.controllers;

import com.monzag.models.FileType;
import com.monzag.service.FileReader;
import com.monzag.service.OutputFormatter;
import com.monzag.service.OutputFormatterFactory;

import java.io.IOException;
import java.nio.file.Path;

public class SimpleCsvConverter {

    private FileReader reader;
    private OutputFormatterFactory outputFormatterFactory;

    public SimpleCsvConverter(FileReader reader, OutputFormatterFactory outputFormatterFactory) {
        this.reader = reader;
        this.outputFormatterFactory = outputFormatterFactory;
    }

    public void convert(Path path) throws IOException {
        OutputFormatter outputFormatter = outputFormatterFactory.createByFormat();
        outputFormatter.printToConsole(reader.readData(path.toFile()));
        System.out.println("done from csv file");
    }

    public void convert(Path path, FileType type) throws IOException {
        OutputFormatter outputFormatter = outputFormatterFactory.createByFormat(type);
        outputFormatter.printToConsole(reader.readData(path.toFile()));
        System.out.println("done from file and type");
    }
}
