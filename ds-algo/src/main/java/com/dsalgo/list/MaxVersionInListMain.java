package com.dsalgo.list;

import java.util.*;

public class MaxVersionInListMain {

    public static void main(String[] args) {

        List<String> versionsList = new ArrayList<>();
        versionsList.add("1.1.1");
        versionsList.add("1.2.2");
        versionsList.add("3.2.1");
        versionsList.add("3.2.0");

        String maxVersion = getMaxVersion(versionsList);

        System.out.println(maxVersion);

    }

    private static String getMaxVersion(List<String> versionsList) {

        Map<String, String> map = new TreeMap<>(Comparator.reverseOrder());

        for(String version : versionsList){
            map.put(version, version);
        }

        return map.keySet().stream().findFirst().get();
    }

}
