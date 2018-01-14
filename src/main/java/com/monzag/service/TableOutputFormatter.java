package com.monzag.service;

import com.opencsv.CSVReader;
import dnl.utils.text.table.TextTable;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TableOutputFormatter implements OutputFormatter {

    private static final int COLUMN_NAMES_INDEX = 0;

    public void printToConsole(InputStream inputStream) throws IOException {
        CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
        List records = csvReader.readAll();
        String[] columnNames = (String[]) records.get(COLUMN_NAMES_INDEX);
        Object[][] data = new Object[records.size()-1][columnNames.length];

        for (int i = 0; i < records.size(); i++) {
            int columnNumber = 0;
            if (i > 0) {
                for (String cellValue : (String[]) records.get(i)) {
                    data[i-1][columnNumber] = cellValue;
                    columnNumber++;
                }
            }
        }

        TextTable table = new TextTable(columnNames, data);
        table.printTable();
    }
}
