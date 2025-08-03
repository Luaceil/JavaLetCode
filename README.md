<img width="1134" height="492" alt="无标题" src="https://github.com/user-attachments/assets/669174d7-f37f-418a-a987-e2a77fbd2c9b" />大佬blog https://cyborg2077.github.io/categories/%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0/page/3/

基础语法:https://leetcode.cn/discuss/post/138449/java-shua-ti-ji-chu-chang-yong-yu-fa-by-zhujiachen/

集合转换: ArrayList<Integer> numsArray = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));

输入输出

Scanner scanner = new Scanner(System.in);
int num = scanner.nextInt();  // 读取整数后，换行符仍留在缓冲区
scanner.nextLine();  // 消耗掉残留的换行符
String text = scanner.nextLine();  // 正确读取下一行文本
Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).forEach(System.out::println);

stream
遍历
匿名函数表达式
自定义排序
