package yingdg.exercise.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yingdg on 2018/1/17 0017.
 */
public class HeapOOM {

    static class OomObj {

    }

    /*
    堆内存
    -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void main(String[] args) {
        List<OomObj> list = new ArrayList<>();
        while (true) {
            list.add(new OomObj());
        }
    }

}
