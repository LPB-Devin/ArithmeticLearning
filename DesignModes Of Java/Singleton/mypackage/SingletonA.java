package mypackage;

public class SingletonA {
    public static boolean instanceFlag = false;

    private  int i = 0;

    /**
     * 声明一个私有的空白构造函数
     * 无法在外部类中调用并初始化该单例类
     */
    private SingletonA(){
    }

    public int getNum(){
        return i;
    }
    public void setNum(){
        i++;
    }
    public static SingletonA getInstance(){
        if(! instanceFlag){
            instanceFlag = true;
            return new SingletonA();
        }
        return null;
    }

    public void finalize(){
        instanceFlag = false;
    }
}
