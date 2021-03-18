package cn.tuna.gof.memento;

import cn.tuna.gof.memento.game.Gamer;
import cn.tuna.gof.memento.game.Memento;

import java.io.*;
import java.util.StringJoiner;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class Main {
    public static final String SAVEFILENAME = "game.dat";
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
//        Memento memento = gamer.createMemento();
        Memento memento = loadMemento(gamer);
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);
            System.out.println("当前状态:" + gamer);

            gamer.bet();
            System.out.println("所持金钱为" + gamer.getMoney() + "元");

            if (gamer.getMoney() > memento.getMoney()){
                System.out.println("（所持金钱增加了许多，因此保存游戏当前的状态）");
                memento = gamer.createMemento();
                saveMemento(memento);
            }else if (gamer.getMoney() < memento.getMoney() / 2){
                System.out.println("（所持金钱减少了许多，因此将游戏恢复至以前的状态）");
                gamer.restoreMemento(memento);
            }
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
    public static void saveMemento(Memento memento){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new DeflaterOutputStream(new FileOutputStream(SAVEFILENAME)));
            out.writeObject(memento);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Memento loadMemento(Gamer gamer){
        Memento memento = gamer.createMemento();
        try {
            ObjectInputStream in = new ObjectInputStream(new InflaterInputStream(new FileInputStream(SAVEFILENAME)));
            memento = (Memento) in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return memento;
    }
}
