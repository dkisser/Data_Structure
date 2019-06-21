package structure.chainOfResponsibility.concretehandler;

import structure.chainOfResponsibility.handler.Player;

public class JiaMuPlayer extends Player {

    public JiaMuPlayer(Player successor) {
        setSuccessor(successor);
    }

    @Override
    public void doHandler(int index) {
        if (index == 1){
            System.out.println("jiamu -> handler request!");
        }  else  {
            System.out.println("request pass->jiamu!");
            this.getSuccessor().doHandler(index);
        }
    }
}
