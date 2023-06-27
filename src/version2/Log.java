package version2;

public class Log {
    
    public static void info(Object className,String msg){

        System.out.println("INFO:"+className.getClass()+"/"+msg);
        
    }

    public static void error(Object className,String msg){

        System.out.println("ERROR!!!!!:"+className.getClass()+"/"+msg);
        
    }

    
}

