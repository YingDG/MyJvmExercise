package yingdg.exercise.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by yingdg on 2018/1/17 0017.
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    /*
    -Xmx20m
    直接内存
    -XX:MaxDirectMemorySize=10m
     */
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
