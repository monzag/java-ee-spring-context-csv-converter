package com.monzag;

import com.monzag.exceptions.FileNotFoundException;

public class ConverterApplication
{
    public static void main( String[] args ) {
        try {
            if (args.length > 0) {
                System.out.println("ho ho");

            } else {
                throw new FileNotFoundException();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
