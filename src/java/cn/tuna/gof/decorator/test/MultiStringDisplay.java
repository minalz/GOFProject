package cn.tuna.gof.decorator.test;

import cn.tuna.gof.decorator.Display;

import java.util.ArrayList;

public class MultiStringDisplay extends Display {

    private ArrayList body = new ArrayList();
    private int columns = 0;
    public void add(String msg){
        this.body.add(msg);
        updateColumn(msg);
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return body.size();
    }

    @Override
    public String getRowText(int rows) {
        return (String)body.get(rows);
    }

    private void updateColumn(String msg){
        if(msg.getBytes().length > columns){
            System.out.println("ago" + columns);
            columns = msg.getBytes().length;
            System.out.println("after" + columns);
        }
        for (int i = 0; i < body.size(); i++) {
            int fills = columns - ((String)body.get(i)).getBytes().length;
            if(fills > 0){
                body.set(i,body.get(i)+spaces(fills));
            }
        }
    }

    private String spaces(int count){
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(' ');
        }
        return buf.toString();
    }
}
