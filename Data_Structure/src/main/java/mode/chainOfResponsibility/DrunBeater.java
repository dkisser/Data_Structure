package mode.chainOfResponsibility;

import mode.chainOfResponsibility.concretehandler.JiaBaoYuPlayer;
import mode.chainOfResponsibility.concretehandler.JiaHuanPlayer;
import mode.chainOfResponsibility.concretehandler.JiaMuPlayer;
import mode.chainOfResponsibility.handler.Player;

public class DrunBeater {
    private static Player successor;
    public static void main (String[] args){
        successor = new JiaMuPlayer(new JiaBaoYuPlayer(new JiaHuanPlayer(null)));
        successor.doHandler(3);
    }
}
