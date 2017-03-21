
public class CarniFast extends Carnivore{
    private int iniLife=4;
    private int iniRepro=5;
    private static float sum=0;
    
    public CarniFast (int x , int y){
        super(x,y);
        setInitialLife(iniLife);
        setInitialRepro(iniRepro);
        setBlocks(2);
        sum++;
    }

    public void setInitialLife(){
        setInitialLife(iniLife);
    }

    public void setInitialRepro(){
        setInitialRepro(iniRepro);
    }
    
     public static float getSum(){
        return sum;
    }
    
    public void reduceSum(){
        sum--;
    }
}