package com.monzag.exceptions;

public class FileNotFoundException extends Exception {

    public FileNotFoundException() {
        super("No input file defined");
    }
}
