package com.file.generate.util;

import com.file.generate.info.UserInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReplacementUtil {

    public List<String> replaceContentByUser(List<String> content, UserInfo userInfo) {
        List<String> newContent = new ArrayList<>();
        for (String key : userInfo.getInfoKeys()) {
            for (String statement : content) {
                String newStatement = statement;
                newContent.add(newStatement.replaceAll("<" + key + ">", userInfo.getInfoMap().get(key)));
            }
        }
        return newContent;
    }

    public List<List<String>> replaceContent(List<UserInfo> userInfos, List<String> templateContent) {
        List<List<String>> newContents = new ArrayList<>();
        for (UserInfo userInfo : userInfos) {
            newContents.add(replaceContentByUser(templateContent, userInfo));
        }
        return newContents;
    }

    public void generateNewSQLFile(String userInfoFileName, String templateFileName) throws IOException {
        FileUtil fileUtil = FileUtil.getInstance();
        List<String> templateContent = fileUtil.readFromFile(templateFileName);
        List<UserInfo> userIfs = fileUtil.readUserInfoFile(userInfoFileName);
        fileUtil.writeToFile(replaceContent(userIfs, templateContent), fileUtil.getTargetFileName(templateFileName));

    }


}
