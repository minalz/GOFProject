package cn.tuna.gof.observer.test;

import cn.tuna.gof.observer.NumberGenerator;

public class IncrementalNumberGenerator extends NumberGenerator {
    private int start;
    private int end;
    private int step;
    private int index;
    public IncrementalNumberGenerator(int start,int end,int step){
        this.start = start;
        this.end = end;
        this.step = step;
    }
    @Override
    public int getNumber() {
        return index;
    }

    @Override
    public void execute() {
        for (int i = start; i < end; i=i+step) {
            index = i;
            notifyObservers();
        }
    }
}
