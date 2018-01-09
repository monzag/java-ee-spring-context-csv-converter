package com.monzag;

import com.monzag.controllers.SimpleCsvConverter;
import com.monzag.exceptions.FileNotFoundException;
import com.monzag.models.FileType;

import java.io.File;

public class ConverterApplication
{
    public static void main( String[] args ) {
        SimpleCsvConverter csvConverter = new SimpleCsvConverter();

        try {
            if (args.length == 1) {
                File file = new File(args[0]);
                csvConverter.convert(file);

            } else if (args.length == 2) {
                FileType type = FileType.valueOf(args[0].toUpperCase());
                File file = new File(args[1]);
                csvConverter.convert(file, type);

            } else {
                throw new FileNotFoundException();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("incorrect type");
        }
    }
}
