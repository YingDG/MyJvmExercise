package yingdg.exercise.jvm.oom;

/**
 * Created by yingdg on 2018/1/17 0017.
 */
public class JavaVMStackOOM {
    // 多线程情形
    private void doNotStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    doNotStop();
                }
            });
            thread.start();
        }
    }

    /*
    -Xss2m

   win中运行系统死机
     */
    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
