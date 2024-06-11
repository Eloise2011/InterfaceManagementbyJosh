package elo.pra.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-06-11 20:39
 */
public class FileUtils {
    public static StringBuilder extracted(File testFile, StringBuilder sb) {
        String line;
        int count = 0;
        try (FileReader fileReader = new FileReader(testFile); BufferedReader br = new BufferedReader(fileReader)) {
            line = br.readLine();
            while (line != null) {
                count++;
                //System.out.println(line);
                sb.append(line);
                // Notice: the following statement is necessary.
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("count = " + count);
        return sb;
    }
}