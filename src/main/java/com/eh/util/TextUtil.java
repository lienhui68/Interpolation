package com.eh.util;

import java.io.*;

/**
 * Created by David on 2016/4/10.
 */
public class TextUtil {
    public static String txt2String(String filePath) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(TextUtil.class.getClassLoader().getResourceAsStream(filePath)));
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } return sb.toString();
    }
}
