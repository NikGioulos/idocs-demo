package com.idocs.demo.gioulos;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoMain {

    public static void main(String... args) throws Exception{

        if(args.length<3){
            throw new Exception(
                    "Please provide 3 input parameters. 2 Input files and 1 output file");
        }

        String inputFile1 = args[0];
        String inputFile2 = args[1];
        String outputFile = args[2];

        //load input file 1
        List<String> inputLines1 = readFile(inputFile1);

        //load input file 2
        List<String> inputLines2 = readFile(inputFile2);

        //populate the output file content
        List<String> outputLines = process(inputLines1,inputLines2);

        //write content to output file
        writeFile(outputFile,outputLines);

    }

    /**
     * this method accepts two lists with String and creates a new list (avoiding duplicates)
     * containing the intersection of two list, lexicographily sorted avoiding duplicates
     * @param inputLines1
     * @param inputLines2
     * @return
     */
    private static List<String> process(List<String> inputLines1, List<String> inputLines2) {
        log("start process");
        //find the list with the less elements
        List<String> shorterList;
        List<String> largerList;
        if(inputLines1.size()>inputLines2.size()){
            shorterList = inputLines2;
            largerList = inputLines1;
        }else{
            shorterList = inputLines1;
            largerList = inputLines2;
        }

        //sort list for better performance
        Collections.sort(shorterList);

        //create the list for the output file
        List<String> outputLines = new ArrayList<>();

        //keep the last processed line in order to avoid the scanning of duplicates
        String savedLine = "";

        //loop in shorter list for performance
        for(String line:shorterList){

            //if this line found for first time
            if(!savedLine.equalsIgnoreCase(line)){

                //save this new line
                savedLine = line;

                //if this line found in both input lists
                if(largerList.contains(line)){

                    //add the line to the output file lines
                    outputLines.add(line);

                }
            }
        }

        return outputLines;
    }

    /**
     * JAVA7 way to read Files  using try-with resources
     * @param filename: the name of the file
     * @return : file content in lines
     * @throws IOException
     */
    private static List<String> readFile(String filename) throws IOException {
        log("start readFile " + filename);

        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = br.readLine()) !=null) {
                lines.add(line);
            }
        }
        return lines;
    }

    /**
     * write to File line by line
     * @param filename: the name of the file where lines will be added
     *                the file will be created if it does not exist
     * @param lines: the lines to be added
     * @return
     * @throws IOException
     */
    private static void writeFile(String filename, List<String> lines) throws IOException {
        log("start writeFile" + filename);
        FileWriter fileWriter = new FileWriter(filename);

        PrintWriter printWriter = new PrintWriter(fileWriter);

        //java8
        lines.forEach(printWriter::println);

        //always deallocate resources
        printWriter.close();
    }

    /**
     * Log in standard output
     * @param msg
     */
    private static void log(String msg){
        System.out.println(msg);
    }
}
