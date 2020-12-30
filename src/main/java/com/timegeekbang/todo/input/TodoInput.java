package com.timegeekbang.todo.input;

import com.timegeekbang.todo.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public abstract class TodoInput {

  public List<String> getItems() {
    FileUtils fileUtils = new FileUtils();
    List<String> strings = fileUtils.readFile("liudaming");
    List<String> collect = strings.stream().filter(s -> StringUtils.isNotBlank(s)).collect(Collectors.toList());
    return collect;
  }

  public String getIndex() {
    if (CollectionUtils.isEmpty(getItems())) {
      return "1";
    } else {
      return String.valueOf(getItems().size() + 1);
    }
  }

  public String showItems() {
    List<String> items = this.getItems();
    //默认过滤
    items = items.stream().filter(s -> !s.contains("<done>")).collect(Collectors.toList());
    return "清单列表为:\r\n" + StringUtils.join(items, "\r\n");
  }


}
