package cn.tuna.gof.dxc;

import java.util.concurrent.*;

public class Task1 implements Callable<Integer> {

    private int num;
    private int num1;

    public Task1(int num, int num1) {
        this.num = num;
        this.num1 = num1;
    }

    @Override
    public Integer call() throws Exception {
        int sum = num/num1;
        System.out.println("线程t的运算结果：" + sum);
        return sum;
    }

    public static void main(String[] args) throws Exception{
        ExecutorService service = Executors.newCachedThreadPool();
        // 提交任务且执行，这里需要注意一下的是submit是提交 和execute功能一样
//        service.submit(new Task(4,2));
        Future<Integer> future = service.submit(new Task1(6,2));
        int result = future.get();
        System.out.println("线程main的运算结果：" + result);
    }
}
