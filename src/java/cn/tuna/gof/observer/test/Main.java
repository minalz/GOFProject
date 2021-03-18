package cn.tuna.gof.observer.test;

import cn.tuna.gof.observer.DigitObserver;
import cn.tuna.gof.observer.GraphObserver;
import cn.tuna.gof.observer.NumberGenerator;
import cn.tuna.gof.observer.Observer;

public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new IncrementalNumberGenerator(10,50,5);
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}
