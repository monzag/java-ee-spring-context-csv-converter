package com.monzag.service;

import com.monzag.models.FileType;
import org.springframework.stereotype.Component;

@Component
public class OutputFormatterFactory {

    public OutputFormatter createByFormat(FileType outputFormat) {
        OutputFormatter outputFormatter;

        if (outputFormat == null) {
            return new TableOutputFormatter();
        }

        switch (outputFormat) {
            case CSV:
                outputFormatter = new TableOutputFormatter();
                break;

            case XML:
                outputFormatter = new XmlOutputFormatter();
                break;

            case JSON:
                outputFormatter = new JsonOutputFormatter();
                break;

            default:
                outputFormatter = null;
        }

        return outputFormatter;
    }
}
