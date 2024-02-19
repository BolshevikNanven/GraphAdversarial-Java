package com.predict.javademo.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PythonUtils {

    //python脚本文件夹

    public static String run(String pythonUrl, String imageUrl, String model) {
        Process proc;
        try {
            String[] cmdAttr = {"C:\\Users\\BolshevikNanven\\Desktop\\scau大创\\NeuralNetworks_Attack-main\\venv\\Scripts\\python.exe", pythonUrl + model + ".py", imageUrl};

            proc = Runtime.getRuntime().exec(cmdAttr);// 执行py文件
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "gb2312"));
            List<String> line = new ArrayList<>();
            String tmpLine;
            while ((tmpLine = in.readLine()) != null) {
                line.add(tmpLine);
            }
            in.close();
            proc.waitFor();

            return line.size() > 0 ? line.get(line.size() - 1) : "null";

        } catch (IOException | InterruptedException e) {

            e.printStackTrace();
        }

        return "error";
    }

}

