package cn.tuna.gof.interpreter;

public class ProgrameNode extends Node {
    private Node commandListNode;
    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }
    public void execute(){
    }

    @Override
    public String toString() {
        return "[program " + commandListNode + "]";
    }
}
