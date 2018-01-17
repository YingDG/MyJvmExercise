package yingdg.exercise.jvm.oom;

/**
 * Created by yingdg on 2018/1/17 0017.
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    /*
    栈内存
    -Xss128k
     */
    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable t) {
            System.out.println("oom stack length:" + oom.stackLength);
            throw t;
        }
    }
}
