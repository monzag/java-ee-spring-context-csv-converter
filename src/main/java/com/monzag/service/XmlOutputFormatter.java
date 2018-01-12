package com.monzag.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


public class XmlOutputFormatter implements OutputFormatter {

    public void printToConsole(InputStream inputStream) throws IOException {
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        CsvMapper mapper = new CsvMapper();
        List<Object> readAll = mapper.readerFor(Map.class).with(schema).readValues(inputStream).readAll();

        ObjectMapper xmlMapper = new XmlMapper();
        for (Object object : readAll) {
            System.out.println(xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object));
        }
    }
}
