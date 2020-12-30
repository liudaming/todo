package com.timegeekbang.todo.utils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

  public void createFile(String fileName) throws IOException {
    FileOutputStream fos = new FileOutputStream(fileName, true);
    FileChannel channel = fos.getChannel();
    channel.close();
    fos.close();
  }

  public List<String> readFile(String fileName) {
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
      content = content + "\r\n";
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

  public List<String> writeFileByList(String fileName, List<String> newStrings) {
    try {
      deleteFile(fileName);
      FileOutputStream fos = new FileOutputStream(fileName, true);
      FileChannel channel = fos.getChannel();
      StringBuffer content = new StringBuffer();
      for (String newString : newStrings) {
        content.append(newString).append("\r\n");
      }
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

  public boolean deleteFile(String fileName) {
    File file = new File(fileName);
    // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
    if (file.exists() && file.isFile()) {
      if (file.delete()) {
        System.out.println("删除单个文件" + fileName + "成功！");
        return true;
      } else {
        System.out.println("删除单个文件" + fileName + "失败！");
        return false;
      }
    } else {
      System.out.println("删除单个文件失败：" + fileName + "不存在！");
      return false;
    }
  }

  public Boolean updateFile(String fileName, String oldStr, String newStr) {
    File fileText = new File(fileName);
    BufferedReader br = null;
    PrintWriter pw = null;
    StringBuffer buff = new StringBuffer();
    String line = System.getProperty("line.separator");
    try {
      br = new BufferedReader(new FileReader(fileText));
      for (String str = br.readLine(); str != null; str = br.readLine()) {
        if (str.contains(oldStr)) {
          str = str.replaceAll(oldStr, newStr);
        }

        buff.append(str + line);
      }
      pw = new PrintWriter(new FileWriter(fileText), true);
      pw.println(buff);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (pw != null) {
        pw.close();
      }
    }
    return true;
  }

}
