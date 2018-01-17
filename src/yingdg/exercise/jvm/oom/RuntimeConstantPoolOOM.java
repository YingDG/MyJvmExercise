package yingdg.exercise.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yingdg on 2018/1/17 0017.
 */
public class RuntimeConstantPoolOOM {
    /*
    方法区大小
    -XX:PermSize=10M -XX:MaxPermSize=10M
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        int i = 0;
        // jdk1.7以后版本好像移除了方法区，没有什么效果
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
