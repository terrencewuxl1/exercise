package com.file.generate.util;

import com.file.generate.info.UserInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileUtil {

    private static FileUtil fileUtil = null;

    private FileUtil() {
    }

    public static FileUtil getInstance() {
        if (fileUtil == null)
            fileUtil = new FileUtil();

        return fileUtil;
    }

    public List<String> readFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        Scanner scar = new Scanner(file);
        while (scar.hasNextLine()) {
            lines.add(scar.nextLine());
        }
        scar.close();
        return lines;
    }

    public List<UserInfo> readUserInfoFile(String fileName) throws FileNotFoundException {
        List<String> contents = readFromFile(fileName);
        List<String> keys = Arrays.asList(contents.get(0).split(","));
        List<UserInfo> userIfs = new ArrayList<>();
        for (int i = 1; i < contents.size(); i++) {
            List<String> ifs = Arrays.asList(contents.get(i).split(","));
            userIfs.add(new UserInfo(keys, ifs));
        }
        return userIfs;
    }

    public void writeToFile(List<List<String>> contents, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        for (List<String> content : contents) {
            fileWriter.write("########################################################");
            fileWriter.write("");
            for (String sentence : content) {
                fileWriter.write(sentence);
            }
            fileWriter.write("");
        }
        fileWriter.close();
    }

    public String getTargetFileName(String sourceFileName) {
        int index = sourceFileName.lastIndexOf(".");
        return sourceFileName.substring(0, index) + "WithUserInfo" + sourceFileName.substring(index);
    }


}
