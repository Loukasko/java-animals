public class HerbiFast extends Herbivore {
    private int iniLife=3;
    private int iniRepro=4;
    static  private float sum=0;
    
    public HerbiFast (int x,int y){
        super(x,y);
        setInitialLife(iniLife);
        setInitialRepro(iniRepro);
        setBlocks(3);
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
