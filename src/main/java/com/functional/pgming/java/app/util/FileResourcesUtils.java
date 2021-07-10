package com.functional.pgming.java.app.util;

import com.functional.pgming.java.app.netflix.constants.DataSetConstants;
import com.functional.pgming.java.app.netflix.model.DataSetModel;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

public class FileResourcesUtils {

    // get a file from the resources folder
    // works everywhere, IDEA, unit test and JAR file.
    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    /*
        The resource URL is not working in the JAR
        If we try to access a file that is inside a JAR,
        It throws NoSuchFileException (linux), InvalidPathException (Windows)

        Resource URL Sample: file:java-io.jar!/json/file1.json
     */
    public static File getFileFromResource(String fileName)  {

        ClassLoader classLoader = FileResourcesUtils.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        Objects.requireNonNull(resource,"File not found!");
        try {
            return new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    // print input stream
    private static void printInputStream(InputStream is) {

        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<DataSetModel> dataSetFromSourceFile(String sourceFile,
                                                           Class modelClass) {
        Objects.requireNonNull(sourceFile);

        File dataFile = getFileFromResource(DataSetConstants.BASE_FILE_PATH+
                    sourceFile);
        List<DataSetModel> modelList =  CsvHelper.beanBuilder(dataFile.toPath(), modelClass);
        return modelList;

    }

    // print a file
    private static void printFile(File file) {

        List<String> lines;
        try {

            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
