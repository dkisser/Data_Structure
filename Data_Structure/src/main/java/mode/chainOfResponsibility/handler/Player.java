package mode.chainOfResponsibility.handler;

public abstract class Player {

    private Player successor;//下一个处理者

    //处理请求
    public abstract void doHandler (int index);

    //设置下一个接受者
    public void setSuccessor(Player successor){
        this.successor = successor;
    }

    public Player getSuccessor(){
        return successor;
    }

}
