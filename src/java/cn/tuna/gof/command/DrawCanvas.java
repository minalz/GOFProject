package cn.tuna.gof.command;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {
    private Color color;
    private int radius;
    private MacroCommand history;
    public DrawCanvas(int width,int height,MacroCommand history){
        setSize(width,height);
        setBackground(Color.white);
        this.history = history;
        init();
    }
    // 这个方法是系统内部执行的 java.awt会默认调用paint方法 当repaint的时候
    public void paint(Graphics g){
        history.execute();
    }
    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x-radius,y-radius,radius*2,radius*2);
    }

    @Override
    public void init() {
        color = Color.red;
        radius = 6;
        history.append(new ColorCommand(this,color));
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
