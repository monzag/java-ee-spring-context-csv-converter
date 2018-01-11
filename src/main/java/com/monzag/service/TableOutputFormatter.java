package com.monzag.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TableOutputFormatter implements OutputFormatter {

    public void printToConsole(InputStream inputStream) {
        BufferedReader br;
        String line;
        StringBuilder sb;

        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

            System.out.println(sb.toString());
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
