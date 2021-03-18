package cn.tuna.gof.flyWeight;

public class BigString {
    private BigChar[] bigchars;
    public BigString(String string,boolean shared){
        if(shared){
            initShared(string);
        }else{
            initUnshared(string);
        }
    }
    private void initShared(String string){
        bigchars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < bigchars.length; i++) {
            // 返回指定索引处的char值
//            System.out.println("shared string.charAt("+i+") -- " + string.charAt(i));
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }
    private void initUnshared(String string){
        bigchars = new BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            // 返回指定索引处的char值
//            System.out.println("unshared string.charAt("+i+") -- " + string.charAt(i));
            bigchars[i] = new BigChar(string.charAt(i));
        }
    }
    public void print(){
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i].print();
        }
    }
}
