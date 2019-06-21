package structure.chainOfResponsibility;

import structure.chainOfResponsibility.concretehandler.JiaBaoYuPlayer;
import structure.chainOfResponsibility.concretehandler.JiaHuanPlayer;
import structure.chainOfResponsibility.concretehandler.JiaMuPlayer;
import structure.chainOfResponsibility.handler.Player;

public class DrunBeater {
    private static Player successor;
    public static void main (String[] args){
        successor = new JiaMuPlayer(new JiaBaoYuPlayer(new JiaHuanPlayer(null)));
        successor.doHandler(3);
    }
}
