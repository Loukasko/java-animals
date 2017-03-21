import java.util.*;
public abstract class Animal {
    private int life ;
    private int repro;
    private int blocks;
    private int x;
    private int y;

    public Animal(int x , int y){
        this.x=x;
        this.y=y;
    }

    //public void setLife(int a){
      //  life=a;
    //}

    public int reduceLife(){
        life--;
        return life;
    }

    public int getLife(){
        return life;
    }

    public void setRepro(int b){
        repro=b;
    }

    public int repro(){
        return repro;
    }
    
    public int reduceRepro(){
        repro--;
        return repro;
    }

    public void setBlocks(int c){
        blocks=c;
    }

    public int getBlocks(){
        return blocks;
    }

    public void setX(int i){
        x=i;
    }
    
    public int getX(){
        return x;
    }


    public void setY(int j){
        y=j;
    }

    public int getY(){
        return y;
    }

    public void setInitialLife(int a){
        life=a;
    }

    public void setInitialRepro(int b){
        repro=b;
    }

    public abstract void setInitialLife();

    public abstract void setInitialRepro();
    
    public abstract void reduceSum();
}
