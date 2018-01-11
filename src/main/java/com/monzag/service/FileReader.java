package com.monzag.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileReader {

    public InputStream readData(File file) throws FileNotFoundException{
        return new FileInputStream(file);
    }
}
