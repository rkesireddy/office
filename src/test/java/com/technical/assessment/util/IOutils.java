package com.technical.assessment.util;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IOutils {

    public File loadFileFromResources(String fileName) throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource("testdata/" + fileName).getFile());
    }

    public List<String> findRegNumber(File file) throws IOException {
        String data = FileUtils.readFileToString(file, "UTF-8");
        List<String> words = Arrays.asList(data.split(" "));
        String pat = "[A-Z0-9 ]{4,8}[A-Z0-9 ]";
        Pattern pattern = Pattern.compile(pat);
        return words.stream().filter(w -> pattern.matcher(w).matches()).collect(Collectors.toList());
    }

    public List<String> readOutputData(File filepath) throws IOException {
        Path path = Paths.get(String.valueOf(filepath));
        return Files.lines(path).skip(1).collect(Collectors.toList());
    }
}
