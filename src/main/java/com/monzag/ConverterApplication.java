package com.monzag;

import com.monzag.controllers.SimpleCsvConverter;
import com.monzag.exceptions.FileInputNotDefinedException;
import com.monzag.models.FileType;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConverterApplication {

    private static final int ONE_ITEM = 1;
    private static final int TWO_ITEMS = 2;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    public static void main( String[] args ) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SimpleCsvConverter csvConverter = (SimpleCsvConverter) ctx.getBean("simpleCsvConverter");
        Path path;
        FileType type = null;

        try {
            if (args.length == ONE_ITEM) {
                path = Paths.get(args[FIRST_INDEX]).toRealPath();

            } else if (args.length == TWO_ITEMS) {
                type = FileType.valueOf(args[FIRST_INDEX].toUpperCase());
                path = Paths.get(args[SECOND_INDEX]).toRealPath();

            } else {
                throw new FileInputNotDefinedException();
            }

            csvConverter.convert(path, type);

        } catch (FileInputNotDefinedException e) {
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("incorrect type");

        } catch (IOException e) {
            System.out.println("File not exist");
        }
    }
}
