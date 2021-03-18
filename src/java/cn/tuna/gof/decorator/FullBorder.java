package cn.tuna.gof.decorator;

public class FullBorder extends Border {
    public FullBorder(Display display){
        super(display);
    }
    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int rows) {
        if(rows == 0){
            return "+" + makeLine('-',display.getColumns()) + "+";
        }else if(rows == display.getRows() + 1){
            return "+" + makeLine('-',display.getColumns()) + "+";
        }else{
            return "|" + display.getRowText(rows - 1) + "|";
        }
    }

    public String makeLine(char ch,int count){
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }


}
