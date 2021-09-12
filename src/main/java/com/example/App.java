package com.example;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class App {
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("o", "output-file", true, "output file");
        options.addOption("c", "counts", true, "0 - 1,000,000");

        CommandLine cmd = null;
        CommandLineParser parser = new DefaultParser();
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        String file = cmd.getOptionValue("o");
        int counts = Integer.parseInt(cmd.getOptionValue("c")); 

        System.out.println("file:" + file);
        System.out.println(String.format("counts:%d", counts));

        long stime = System.currentTimeMillis();
        try {
            new GenDat().create(counts, file);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        long etime = System.currentTimeMillis();
        System.out.println(String.format("time[sec]:%d", (etime - stime)/1000));
    }
}
