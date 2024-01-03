package app.meetcode.leetcode.code002;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JavaUpdate {

    public void java9Update() {}

    /**
     * java 10 的更新内容  新增语法糖
     * [本地变量类型]引入var关键字，而不需要显示的规范变量的类型
     */
    public void java10Update() {
        var fistName = "fistName";
        var lastName = BigDecimal.ZERO;

        System.out.println(fistName);
        System.out.println(lastName);
    }

    public void java11Update() {}

    /**
     * java 12 的更新内容 switch表达式
     * 新增了关键字  yield 用于返回一个值
     * 与return区别：return会直接跳出当前循环或者方法，而yield只会跳出当前switch块
     */
    public int java12Update(String x) {
        return switch (x) {
            case "1" -> 1;
            case "2" -> 2;
            default -> {
                var result = 3;
                result = 3 * 3;
                yield result;
            }
        };
    }

    /**
     * java 13 的更新内容 Text Block
     * 使用 """ 作为文本块的开始符号和结束符号
     */
    public void java13Update() {
        String testStr = """
                test1
                test2
                test3
                test4
                123465789
                """;
        System.out.println(testStr);
    }

    /**
     * java 14 的更新内容
     */
    public void java14Update() {}

    /**
     * java 15 的更新内容
     */
    public void java15Update() {}

    public void java16Update() {}

    /**
     * java 17 的更新内容
     */
    public void java17Update() {}

    public void java18Update() {}

    /**
     * java 19 的更新内容 虚拟线程
     */
    public void java19Update() {}

    public void java20Update() {}

    public void java21Update() {}
}