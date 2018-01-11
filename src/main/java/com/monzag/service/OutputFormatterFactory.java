package com.monzag.service;

import com.monzag.models.FileType;

public class OutputFormatterFactory {

    public OutputFormatter createByFormat(FileType outputFormat) {

        switch (outputFormat) {
            case CSV:
                return new TableOutputFormatter();

            case XML:
                return new XmlOutputFormatter();

            case JSON:
                return new JsonOutputFormatter();

            default:
                return null;
        }
    }
}
