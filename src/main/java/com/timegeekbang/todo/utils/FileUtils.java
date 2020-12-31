package com.timegeekbang.todo.utils;

import com.timegeekbang.todo.user.UserContext;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

  public void createFile() throws IOException {
    String fileName = UserContext.getUserID();
    FileOutputStream fos = new FileOutputStream(fileName, true);
    FileChannel channel = fos.getChannel();
    channel.close();
    fos.close();
  }

  public List<String> readFile() {
    String fileName = UserContext.getUserID();
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

  public List<String> writeFile(String content) {
    String fileName = UserContext.getUserID();
    try {
      content = content + "\r\n";
      FileOutputStream fos = null;
      fos = new FileOutputStream(fileName, true);
      FileChannel channel = fos.getChannel();
      ByteBuffer buf = ByteBuffer.wrap(content.getBytes());
      buf.put(content.getBytes());
      buf.flip();
      channel.write(buf);
      channel.close();
      fos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return readFile();
  }

  public List<String> writeFileByList(List<String> newStrings) {
    String fileName = UserContext.getUserID();
    try {
      deleteFile();
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
    return readFile();
  }

  public boolean deleteFile() {
    String fileName = UserContext.getUserID();
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

  public Boolean updateFile(String oldStr, String newStr) {
    String fileName = UserContext.getUserID();
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
