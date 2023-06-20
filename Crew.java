import java.util.*;
class Password{
    int pass=1234;
    int x;
    void adminEntry(){
        System.out.println("please enter your password");
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        if(x==1234){
            System.out.println("welcome");
        }
        if(x!=1234){
            while(x!=1234){
                System.out.println("incorrect password please try again");
                x=sc.nextInt();
                if(x==1234){
                    System.out.println("welcome");
                    break;
                }
            }
        }
      

    }
}
class Admin extends Password{
    int admin_id;
    String admin_name;
    String branch;
    Admin(){
        Scanner sc=new Scanner (System.in);
        System.out.println("please enter your admin id");
        admin_id=sc.nextInt();
        System.out.println("please enter your name");
        admin_name=sc.next();
        System.out.println("please enter your branch");
        branch=sc.next();
        Password p=new Password();

        p.adminEntry();    
       
        
    }
    

}
class Addmembers{
    Addmembers//
    void addNewMembers(){
            System.out.println("please enter number of entries you want to enter");
            Scanner sc=new Scanner(System.in);
            int size=sc.nextInt();
            Admin []me=new Admin[size];
            for(int i=0;i<me.length;i++){
             me[i]=new Student();
            }
        }
        void show(){
            System.out.println
        }
}
class Run{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Admin c=new Admin();
        System.out.println("do you want to enter new data(y/n)");

        
        char chData=sc.next().charAt[0];
         if(chData=='y'){
            c.addNewMembers();
         }
    }
}