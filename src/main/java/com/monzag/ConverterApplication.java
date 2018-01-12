package com.monzag;

import com.monzag.controllers.SimpleCsvConverter;
import com.monzag.exceptions.InputNotDefinedException;
import com.monzag.models.FileType;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConverterApplication
{
    public static void main( String[] args ) {
        Path path;
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SimpleCsvConverter csvConverter = (SimpleCsvConverter) ctx.getBean("simpleCsvConverter");

        try {
            if (args.length == 1) {
                path = Paths.get(args[0]).toRealPath();
                csvConverter.convert(path);

            } else if (args.length == 2) {
                FileType type = FileType.valueOf(args[0].toUpperCase());
                path = Paths.get(args[1]).toRealPath();
                csvConverter.convert(path, type);

            } else {
                throw new InputNotDefinedException();
            }

        } catch (InputNotDefinedException e) {
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("incorrect type");

        } catch (IOException e) {
            System.out.println("File not exist");
        }
    }
}
