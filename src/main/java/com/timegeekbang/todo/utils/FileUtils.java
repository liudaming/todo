package com.timegeekbang.todo.utils;

import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public void createAndCreateFile(String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName, true);
        FileChannel channel = fos.getChannel();
        channel.close();
        fos.close();
    }

    public List<String> readFile(String fileName){
        File file = new File(fileName);
        List<String> list = new ArrayList<>();
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            int i = 1;
            while ((line = br.readLine()) != null) {
                list.add(line.trim());
                i++;
            }
            reader.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<String> writeFile(String fileName, String content) {
        try {
            content = content+"\r\n";
            FileOutputStream fos = null;
            fos = new FileOutputStream(fileName, true);
            FileChannel channel = fos.getChannel();
            ByteBuffer buf = ByteBuffer.wrap(content.toString().getBytes());
            buf.put(content.toString().getBytes());
            buf.flip();
            channel.write(buf);
            channel.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readFile(fileName);
    }
}
