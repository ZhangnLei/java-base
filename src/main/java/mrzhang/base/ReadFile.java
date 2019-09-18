package mrzhang.base;

import java.io.*;

/**
 * @author zhangnianlei
 * @create 2019/9/19.
 * @description
 */
public class ReadFile {
    public static void main(String[] args) {
        String filepath = "F:/code/java-base/src/main/java/mrzhang/base/bereadfile.txt";
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filepath))));
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                builder.append(line);
            }
            System.out.println(builder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
