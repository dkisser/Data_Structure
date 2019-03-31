package mode.chainOfResponsibility.concretehandler;

import mode.chainOfResponsibility.handler.Player;

public class JiaHuanPlayer extends Player {
    public JiaHuanPlayer(Player successor) {
        setSuccessor(successor);
    }

    @Override
    public void doHandler(int index) {
        if (index == 3){
            System.out.println("jiahuan -> handler request!");
        } else {
            System.out.println("jiahuan pass,exit");
        }
    }
}
