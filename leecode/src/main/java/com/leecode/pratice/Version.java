package com.leecode.pratice;

import org.testng.annotations.Test;

public class Version {

    public int compareVersion(String version1, String version2) {
        String[] ver1s=version1.split("\\.");
        String[] ver2s=version2.split("\\.");
        int len=(ver1s.length>ver2s.length)? ver1s.length:ver2s.length;
        for(int i=0;i<len;i++){
            String ver1=(i>=ver1s.length)?"0":ver1s[i];
            String ver2=(i>=ver2s.length)?"0":ver2s[i];
            int diff=Integer.valueOf(ver1)-Integer.valueOf(ver2);
            if(diff!=0)return diff;
        }
        return 0;
    }

    @Test
    public void test(){
        compareVersion("0.1","1.1");
    }
}
