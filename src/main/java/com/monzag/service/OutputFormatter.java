package com.monzag.service;

import java.io.IOException;
import java.io.InputStream;

public interface OutputFormatter {

    void printToConsole(InputStream inputStream) throws IOException ;
}
