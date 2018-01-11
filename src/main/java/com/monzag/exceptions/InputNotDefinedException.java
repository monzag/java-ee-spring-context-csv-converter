package com.monzag.exceptions;

public class InputNotDefinedException extends Exception {

    public InputNotDefinedException() {
        super("No input file defined");
    }
}
