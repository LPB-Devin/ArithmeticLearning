import java.util.HashMap;

public class SingletonB{
    static private HashMap<String,SingletonB> registry = new HashMap();

    public static void Register(String name,SingletonB aInstance){
        registry.put(name,aInstance);
    }

    public static SingletonB GetInstance(String name){
        return LookUp(name);
    }

    private static SingletonB LookUp(String name) {
        return (SingletonB)registry.get(name);
    }
}