# todo
极客时间课程todo
任务分解
todo-phase-1 

添加 Todo 项
todo add <item>
1. Item added


完成 Todo 项。
todo done Item done.

查看 Todo 列表，缺省情况下，只列出未完成的 Todo 项
todo list1. 2. Total: 2 items


使用 all 参数，查看所有的 Todo 项。
todo list --all
1.<item1>
2.<item2> 
3.<Done> <item3>
Total: 3 items, 1 item done

要求：
Todo 项存储在本地文件中
Todo 项索引逐一递增

步骤1.创建文本文件存储本地

步骤2.输入todo add 1 写入文件1.1 并返回1.1

步骤3.输入todo add 2 写入文件2.2 并返回2.2

步骤4：输入todo done 1 则返回文件里面没有1.1

步骤5 输入todo list 显示都为不删除的

步骤6 输入todo list --all 显示全部的信息

步骤7 整合 读取控制台输入信息，根据信息做相应的判断

运行步骤 启动TodoApplication 然后键盘输入指令信息
如
todo add 明天记得早点起床
todo done 1
todo list -all

todo-phase-2
加入用户登录功能
则对应的本地文件用用户名和id来命名。登录之后，将用户信息存储到本地线程中
文件命名根据用户的id来命名。



