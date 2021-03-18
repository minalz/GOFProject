package cn.tuna.gof.interpreter.langugage;

import cn.tuna.gof.interpreter.Context;
import cn.tuna.gof.interpreter.Node;
import cn.tuna.gof.interpreter.ParseException;
import cn.tuna.gof.interpreter.ProgrameNode;

import java.util.concurrent.Executor;

public class InterpreterFacade implements Executor {
    private ExecutorFactory factory;
    private Context context;
    private Node programNode;
    public InterpreterFacade(ExecutorFactory factory){
        this.factory = factory;
    }
    public boolean parse(String text){
        boolean ok = true;
        this.context = new Context(text);
        this.context.setExecutorFactory(factory);
        this.programNode = new ProgrameNode();
        try {
            programNode.parse(context);
            System.out.println(programNode.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }
    @Override
    public void execute(Runnable command) {
    }
}
