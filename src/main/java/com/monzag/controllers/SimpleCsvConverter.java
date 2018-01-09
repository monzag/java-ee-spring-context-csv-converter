package com.monzag.controllers;

import com.monzag.models.FileType;

import java.io.File;

public class SimpleCsvConverter {

    public void convert(File file) {
        System.out.println("convert from csv file");
    }

    public void convert(File file, FileType type) {
        System.out.println("convert from file and type");
    }
}
