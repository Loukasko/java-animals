public class HerbiSlow extends Herbivore{
    private int iniLife=3;
    private int iniRepro=4;
    private static float sum=0; 
    
    public HerbiSlow (int x,int y){
        super(x,y);
        setInitialLife(iniLife);
        setInitialRepro(iniRepro);
        setBlocks(1);
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