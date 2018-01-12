package com.monzag.controllers;

import com.monzag.models.FileType;
import com.monzag.service.FileReader;
import com.monzag.service.OutputFormatter;
import com.monzag.service.OutputFormatterFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;

@Component
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
    }

    public void convert(Path path, FileType type) throws IOException {
        OutputFormatter outputFormatter = outputFormatterFactory.createByFormat(type);
        outputFormatter.printToConsole(reader.readData(path.toFile()));
    }
}
