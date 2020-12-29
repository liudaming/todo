package com.timegeekbang.todo.input;

import com.timegeekbang.todo.utils.FileUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class TodoInput {

    private String input;

    private List<String> items = new ArrayList<>();

    public TodoInput(String input) {
        this.input = input;
    }

    public String getItem() {
        FileUtils fileUtils = new FileUtils();
        this.items = fileUtils.readFile("liudaming");
        if (input.indexOf("todo add") >= 0) {
            String index = getIndex();
            String item = index + input.replaceAll("todo add ", "");
            items.add(item);
            fileUtils.writeFile("liudaming",item);
        }
        if (!CollectionUtils.isEmpty(items)) {
            return items.get(items.size() - 1);
        } else {
            return "请输入有效的指令";
        }

    }

    private String getIndex() {
        if (CollectionUtils.isEmpty(items)) {
            return "1.";
        } else {
            return items.size()+1 + ".";
        }
    }
}
