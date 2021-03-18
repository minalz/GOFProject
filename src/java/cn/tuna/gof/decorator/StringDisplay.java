package cn.tuna.gof.decorator;

public class StringDisplay extends Display {
    private String string; // 要显示的字符串
    public StringDisplay(String string){
        this.string = string;
    }
    @Override
    public int getColumns() {
        return string.getBytes().length;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int rows) {
        if(rows == 0){
            return string;
        }else {
            return null;
        }
    }
}
