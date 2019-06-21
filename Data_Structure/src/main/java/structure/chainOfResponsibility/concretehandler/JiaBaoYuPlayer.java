package structure.chainOfResponsibility.concretehandler;

import structure.chainOfResponsibility.handler.Player;

public class JiaBaoYuPlayer extends Player {

    public JiaBaoYuPlayer(Player successor) {
        setSuccessor(successor);
    }

    @Override
    public void doHandler(int index) {
        if (index == 2){
            System.out.println("jiabaoyu -> handler request");
        } else {
            System.out.println("request pass -> jiabaoyu!");
            this.getSuccessor().doHandler(index);
        }
    }
}
