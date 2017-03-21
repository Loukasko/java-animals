import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Image;
import java.awt.*;
import java.util.Random;
import java.util.*;

public class Simulation extends JFrame implements ActionListener{ //to extend iparxei gia th dhmiourgia tou frame kai to actionListener gia to koumpi exit

    private static int meat;
    private static int rip;
    private static int lap=0;

    private static boolean[][] grass;
    private static int[][] myAnimal ;
    private static JButton[][] myJButton;

    static ArrayList<Animal> myList = new ArrayList<Animal>();
    static JPanel maPane=new JPanel();

    JButton EXIT=new JButton ("EXIT");

    public Simulation (int numRows,int numColumns){
        super("Simulation");    // dhmiourgia frame apo yperklash 
        setSize(200,200);       //megethos frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        EXIT.addActionListener(this);
        JPanel siPane = new JPanel();   //dhmiourgia panel gia topothethsh exit
        siPane.add(EXIT);
        add(siPane);        //prosthiki panel sto frame
        setVisible(true);
        BoxLayout box=new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        setLayout(box);

        for (int i=0;i<numRows;i++){
            for (int j=0;j<numColumns;j++){         /* oi duo loops analoga to stoixeio toy pinaka myAnimal dimiourgoun koympi me eikona, tou dinoun megethos
                , to prosthetoun sto pinaka me buttons kai meta to kathe button to prosthetoun sto panel maPane*/

                if(myAnimal[i][j]==2){
                    Image trex=new ImageIcon(this.getClass().getResource("/t-rex.png")).getImage();
                    JButton jb=new JButton();
                    jb.setPreferredSize(new Dimension(64,64));
                    jb.setIcon(new ImageIcon(trex));
                    myJButton[i][j]=jb;
                    maPane.add(jb);
                }else if(myAnimal[i][j]==1){
                    Image velociraptor=new ImageIcon(this.getClass().getResource("/velociraptor.png")).getImage();
                    JButton jb=new JButton();
                    jb.setPreferredSize(new Dimension(64,64));
                    jb.setIcon(new ImageIcon(velociraptor));
                    myJButton[i][j]=jb;
                    maPane.add(jb);
                }else if(myAnimal[i][j]==3){
                    Image parasaurolophus=new ImageIcon(this.getClass().getResource("/parasaurolophus.png")).getImage();
                    JButton jb=new JButton();
                    jb.setPreferredSize(new Dimension(64,64));
                    jb.setIcon(new ImageIcon(parasaurolophus));
                    myJButton[i][j]=jb;
                    maPane.add(jb);
                }else if(myAnimal[i][j]==4){
                    Image antarctosaurosus=new ImageIcon(this.getClass().getResource("/antarctosaurosus.png")).getImage();
                    JButton jb=new JButton();
                    jb.setPreferredSize(new Dimension(64,64));
                    jb.setIcon(new ImageIcon(antarctosaurosus));
                    myJButton[i][j]=jb;
                    maPane.add(jb);
                }else if (grass[i][j]==true ){
                    Image grass=new ImageIcon(this.getClass().getResource("/grass.png")).getImage();
                    JButton jb=new JButton();
                    jb.setPreferredSize(new Dimension(64,64));
                    jb.setIcon(new ImageIcon(grass));
                    myJButton[i][j]=jb;
                    maPane.add(jb);

                }else{
                    Image ground=new ImageIcon(this.getClass().getResource("/ground.png")).getImage();
                    JButton jb=new JButton();
                    jb.setPreferredSize(new Dimension(64,64));
                    jb.setIcon(new ImageIcon(ground));
                    myJButton[i][j]=jb;
                    maPane.add(jb);

                }
            }
        }

        GridLayout map=new GridLayout(numRows,numColumns);      //diaxeirisths diatakshs  gia emfanish twn buttons se morfh pinaka
        maPane.setLayout(map);
        add(maPane);
        pack();
        setVisible(true);       //kanei to frame orato meta apo thn katallhlh diamorfosh apo tis entoles maPane.setLayout(map), add(maPane), pack()

    }

    public static float percentageOfGrass(int numRows,int numColumns){      //h methodos auth epistrefei to twn futwn pou uparxei ston kosmo
        float num=0;
        for (int i=0;i<numRows;i++){
            for (int j=0;j<numColumns;j++){
                if (grass[i][j]==true){
                    num++;
                }
            }
        }
        return (num/(numRows*numColumns))*100;
    }

    public static void remove(int numRows,int numColumns){      //h methodos auth einai voithitikh kai sto telos tou kathe gurou tha diagrapsei ta prohgoumena buttons
        for(int i=0;i<numRows;i++){
            for (int j=0;j<numColumns;j++){
                maPane.remove(myJButton[i][j]);
            }
        }

    }

    public void actionPerformed(ActionEvent evt){       //h methodos auth xreisimopoihtai gia to koumpli exit 
        Object source=evt.getSource();
        if (source==EXIT){
            System.exit(1);
        }

    }

    public static int[][] fillWithAnimals(int numRows,int numColumns){    //h methodos auth dhmiourgei enan pinaka me tuxaies times pou antistoixoun se zwa, futa h edafos
        Random random=new Random();
        for(int i=0;i<numRows;i++){
            for (int j=0;j<numColumns;j++){
                if (i%2==0 && j%2==0){
                    myAnimal[i][j]=random.nextInt(5);
                }
            }
        }
        return myAnimal;
    }

    public static boolean[][] fillWithGrass(int numRows,int numColumns){   /*h methodos auth gemizei enan allon pinaka tupou boolean me true h' false, opou uparxei true uparxei 
        kai grasidi*/
        Random random=new Random();
        for(int i=0;i<numRows;i++){
            for (int j=0;j<numColumns;j++){
                grass[i][j] = random.nextBoolean();
            }
        }       
        return grass;
    }

    public static void isItMom (){      //h methodos auth xrhsimopoieitai gia ton elenxo an kapoio zwo tha anaparaxthei
        for(int i=0;i<myList.size();i++){
            int x=myList.get(i).getX();     //me thn dhmiourgia tou kathe stigmiotupou dinontai ws orisma se auto oi theseis pou vriksontai ston pinaka. Me auton ton tropo 
            //  antistoixizoume sto x kai sto ythn thesh tou stigmiotupou 
            int y=myList.get(i).getY();
            boolean mom=false;
            if (myList.get(i).repro()==0){
                myList.get(i).setInitialRepro();
                for( int row = x - 1; row <= x + 1; row++)
                {
                    for(int col =  y - 1;  col <= y + 1; col++)   //oi 2 loops xrhsimopoiountai gia ton elenxo twn geitwnikwn tetragwnwn  
                    {
                        if( !(x == row &&  y == col) && row >= 0 && col >= 0 && row < myAnimal.length && col < myAnimal[0].length && myAnimal[row][col]==0 && mom==false)
                        //H parapanw if elenxei an to geitoniko stoixeio pou tha genithei to neogno einai entos twn oriwn tou pinaka kai den einai auto pou tha gennisei
                        //kai an exei genisei ston teleutaio guro 
                        {
                            mom=true;
                            //Oi parakatw if xrhsimopoiountai gia thn dhmiourgiou tou katallhlou eidous dinosaurou
                            if (myAnimal[x][y]==1){
                                CarniFast cf=new CarniFast(row,col);
                                myList.add(cf);
                                myAnimal[row][col]=1;
                            }else if (myAnimal[x][y]==2){
                                CarniSlow cs=new CarniSlow(row,col);
                                myList.add(cs);
                                myAnimal[row][col]=2;
                            }else if (myAnimal[x][y]==3){
                                HerbiFast hb=new HerbiFast(row,col);
                                myList.add(hb);
                                myAnimal[row][col]=3;
                            }else if (myAnimal[x][y]==4){
                                HerbiSlow hs=new HerbiSlow(row,col);
                                myList.add(hs);
                                myAnimal[row][col]=4;
                            }
                        }
                    }
                }
            }
            else {
                myList.get(i).reduceRepro(); //an den exei anaparaxthei meiwnete o arithmos twn gurwn gia anaparagwgh
            }
        }
    }

    public static void fillTheList(int numRows,int numColumns){      /* h methodos xrhsimopoieitai gia th prosthiki twn zwwn sth lista analoga thn ypoklash pou anikoun */
        for (int i=0;i<numRows;i++){
            for (int j=0;j<numColumns;j++){
                if (myAnimal[i][j]==1){
                    CarniFast cf=new CarniFast(i,j);
                    myList.add(cf);
                }else if (myAnimal[i][j]==2){
                    CarniSlow cs=new CarniSlow(i,j);
                    myList.add(cs);
                }else if (myAnimal[i][j]==3){
                    HerbiFast hb=new HerbiFast(i,j);
                    myList.add(hb);
                }else if (myAnimal[i][j]==4){
                    HerbiSlow hs=new HerbiSlow(i,j);
                    myList.add(hs);
                }
            }
        }

    }

    public static void isThereFood(){  // h methodos xrhsimopoieitai gia th trofh
        Random random=new Random();
        rip=0;      //metrites gia plhthos thanatwn apo peina kai oswn fagwthkan antistoixa
        meat=0;
        for(int i=0;i<myList.size();i++){
            int x=myList.get(i).getX();
            int y=myList.get(i).getY();
            boolean eat=false;
            if(myList.get(i) instanceof Herbivore){ //h if elegxei an to stoixeio ths listas einai stigmiotupo ths herbivore
                if (grass[x][y]==true){ 
                    myList.get(i).setInitialLife();     // an faei kaleitai h methodos kai epanaferei tis zwes pou eixame orisei arxika
                    grass[x][y]=false;
                }else{
                    myList.get(i).reduceLife();
                    if (myList.get(i).getLife()==0){        //an teleiwsoun oi zwes tou fytofagou afaireitai apo th lista 
                        myList.get(i).reduceSum();
                        myList.remove(i);
                        myAnimal[x][y]=0;
                        rip++;
                    }
                }
            }else{          // alliws tha nai stigmiotupo ths carnivore
                for( int row = x - 1; row <= x + 1; row++)
                {
                    for(int col =  y - 1;  col <= y + 1; col++)   //loops gia elegxo twn geitwnikwn tetragwnwn
                    {
                        if( !(x == row &&  y == col) && row >= 0 && col >= 0 && row < myAnimal.length && col < myAnimal[0].length && eat==false)
                        {       //elegxos an to stoixeio pou tha fagwthei den einai to idio me auto pou tha to faei kai einai entos twn oriwn tou pinaka kai den exei idi faei sauto ton guro
                            if (myAnimal[row][col]==3 || myAnimal[row][col]==4){    //Elegxos an einai futofago, an einai tote diagrafete apo ton xarth 
                                myAnimal[row][col]=0;
                                grass[row][col]=false;
                                eat=true;
                                meat++;
                                for (int k=0;k<myList.size();k++){      
                                    if (myList.get(k).getX()==row && myList.get(k).getY()==col){
                                        myList.get(k).reduceSum();
                                        myList.remove(k); 
                                    }

                                }
                            }
                        }
                    }
                }
                if (eat==false) {   // an den faei to sarkofago meiwnetai h zwh tou
                    myList.get(i).reduceLife();
                    if (myList.get(i).getLife()==0){        // an ginoun 0 oi zwes tou afaireitai apo prosomoiwsh kai xarth
                        myList.get(i).reduceSum();
                        rip++;
                        myList.remove(i);
                        myAnimal[x][y]=0;
                    }
                }
            }
        }
    }

    public static boolean areThereAnyCarni(){       // methodos gia an yparxoun sarkofaga 
        for(int i=0;i<myList.size();i++){
            if (myList.get(i) instanceof Carnivore){
                return true; 
            }
        }
        return false;
    }

    public static void movements(int numRows,int numColumns){    // methodos gia tis kinhseis twn zwwn 
        Random random=new Random();
        int i=0;

        for(i=0;i<myList.size();i++){
            int x=myList.get(i).getX();
            int y=myList.get(i).getY();
            int l=myList.get(i).getBlocks();
            int k=random.nextInt(4);
            switch (k){     //o tyxaios arithmos k kathorizei thn kateuthinsi pou tha kinhthoun ta zwa kai meta kanei allagh ston pinaka
                case 0: 
                if (x-l>=0){        //elegxos an einai entos twn oriwn tou pinaka
                    if (myAnimal[x-l][y]==0){
                        myAnimal[x-l][y]=myAnimal[x][y];
                        myAnimal[x][y]=0;
                        myList.get(i).setX(x-l);

                    }
                }
                break;
                case 1: 
                if (y+l<numColumns){
                    if (myAnimal[x][y+l]==0){
                        myAnimal[x][y+l]=myAnimal[x][y];
                        myAnimal[x][y]=0;
                        myList.get(i).setY(y+l);
                    }
                }
                break;
                case 2:
                if (x+l<numRows){
                    if (myAnimal[x+l][y]==0){
                        myAnimal[x+l][y]=myAnimal[x][y];
                        myAnimal[x][y]=0;
                        myList.get(i).setX(x+l);

                    }
                }
                break;
                case 3: 
                if (y-l>=0){
                    if (myAnimal[x][y-l]==0){
                        myAnimal[x][y-l]=myAnimal[x][y];
                        myAnimal[x][y]=0;
                        myList.get(i).setY(y-l);
                    }
                }
                break;
            }
        }
    }

    public static void main(String[] args){
        System.out.println("  Once Upon A Time ,2 Billion Years Ago While Dinosaurs Were Still Alive ,\nThere Were Four Friends \n\nThe Herbivores:\n ");
        System.out.println("\t1) Parasaurolophus, The Fast Herbivore\n\t2) Antarctosaurosus, The Slow, Long Necked Herbivore\n\nThe Carnivores:\n ");
        System.out.println("\t1)Velociraptor, the Fastest Of All Carnivores ,And Finally\n\t2)T-REX The Slow Though Very Tough Carnivore\n\n");
        
        System.out.println("Type The Size of the Rows : ");     // o xristis dinei megethos pinaka 
        Scanner loukas=new Scanner(System.in);
        int numRows=loukas.nextInt();

        System.out.println("Type The Size of the Columns: ");
        Scanner mixalis=new Scanner(System.in);
        int numColumns=mixalis.nextInt();

        grass=new boolean[numRows][numColumns];     //dhlwsh kai arxikopoihsh xarth 
        myAnimal = new int[numRows][numColumns];
        myJButton=new JButton[numRows][numColumns];
        fillWithGrass(numRows,numColumns);
        fillWithAnimals(numRows,numColumns);
        fillTheList(numRows,numColumns);

        do{
            
            Simulation simulation=new Simulation(numRows,numColumns);

            System.out.println("Round :" + lap);
            System.out.println("The Number Of Animals That Died From Hunger Is : " + rip);
            System.out.println("The Number Of Animals That Were Eaten Is : " + meat);

            float p1=(HerbiFast.getSum()/myList.size())*100;
            float p2=(HerbiSlow.getSum()/myList.size())*100;
            float p3=(CarniFast.getSum()/myList.size())*100;
            float p4=(CarniSlow.getSum()/myList.size())*100;

            System.out.println("The Percentage Of The Fast Herbivore Dinosaurs is : " + p1 + " %");
            System.out.println("The Percentage Of The Slow Herbivore Dinosaurs is : " + p2 + " %");
            System.out.println("The Percentage Of The Fast Carnivore Dinosaurs is : " + p3 + " %");
            System.out.println("The Percentage Of The Slow Carnivore Dinosaurs is : " + p4 + " %");

            isThereFood();
            movements(numRows,numColumns);
            isItMom();

            System.out.println("The Percentage Of The Grass Is : " + percentageOfGrass(numRows,numColumns) + " %");
            System.out.println("Type Any Interger To Proceed To The Next Round");
            try{
                Scanner alkis=new Scanner(System.in);
                int n=alkis.nextInt();
            }catch(InputMismatchException e){

                System.out.println("Wrong Type Of Input. Please Re-Run The Programm ");
                System.exit(1);
            }
            remove(numRows,numColumns);
            lap++;

        }while(areThereAnyCarni() && percentageOfGrass(numRows,numColumns)>0 );
        if (areThereAnyCarni()==false ){
            System.out.println("No More Carnivore Animals. ENDGAME");
        }else{
            System.out.println("No More Grass. ENDGAME");
        }
        System.exit(1);
    }
}