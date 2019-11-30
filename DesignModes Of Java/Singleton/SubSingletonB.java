import java.util.Objects;

public class SubSingletonB extends SingletonB{
    public static boolean instanceFlag = false;

    public SubSingletonB() throws SingletonException{
        if(instanceFlag){
            throw new SingletonException("Only can create a instance !");
        }else{
            instanceFlag = true;
            super.Register("Sub1",this);
        }
    }
    public void finalize(){
        instanceFlag = false;
    }
}
