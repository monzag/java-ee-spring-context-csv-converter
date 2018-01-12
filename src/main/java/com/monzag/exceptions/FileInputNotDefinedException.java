package com.monzag.exceptions;

public class FileInputNotDefinedException extends Exception {

    public FileInputNotDefinedException() {
        super("No input file defined");
    }
}
