package cn.tuna.gof.interpreter.langugage;

import java.util.concurrent.Executor;

public interface ExecutorFactory {
    public abstract Executor createExecutor(String name);
}
