package cn.tuna.gof.dxc;

public class Task implements Runnable{

    private int num;
    private int num1;

    public Task(int num, int num1) {
        this.num = num;
        this.num1 = num1;
    }

    @Override
    public void run() {
        int sum = num/num1;
        System.out.println("线程t的运算结果：" + sum);
    }

    public static void main(String[] args) {
        Task task = new Task(4, 2);
        Thread t = new Thread(task,"t");
        t.start();
    }
}
