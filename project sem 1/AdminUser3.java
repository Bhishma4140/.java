import java.util.Scanner;

class AdminUser {
    String username;
     String password;

     AdminUser() {
        this.username = "admin";
        this.password = "1234";
    }

     boolean authenticate(String username, String password) {//method for admin verification.
        return this.username.equals(username) && this.password.equals(password);
    }
}

class RestaurantChain extends AdminUser{

         String name;
     int numberOfLocations;
     double totalRevenue;

     RestaurantChain(String name, int numberOfLocations) {
        this.name = name;//initialising variables.
        this.numberOfLocations = numberOfLocations;
        this.totalRevenue = 0.0;
    }

     String getName() {
        return name;
    }

     int getNumberOfLocations() {
        return numberOfLocations;
    }

     double getTotalRevenue() {
        return totalRevenue;
    }

     void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

     void addRevenue(double revenue) {
        this.totalRevenue += revenue;
    }

     double calculateFranchiseFee() {
        double franchiseFee = this.totalRevenue * 0.05;
        return franchiseFee;
    }

     double calculateExpenses(double expenses) {
        double netRevenue = this.totalRevenue - expenses;
        return netRevenue;
    }
    
}
class Customer{
    String customerName;
    int y;
    long number,r2,r1;

    Customer(){
        
        Scanner sc=new Scanner(System.in);
        int c=0;
        System.out.println("please enter your name");
        customerName=sc.nextLine();
        
       

         long temp1=number;
         long temp2=number;
         while(temp1>0){
                 r1=temp1%10;
                 c++;
                 temp1=temp1/10;
                
             }
             if(c!=10 && (r1!=8 || r1!=7 || r1!= 9)){
                 c=0;
                 while(true){//verification of mobile number.
                     c=0;
                     System.out.println("please enter your number");
                     number=sc.nextLong();
                     long temp=number;
                     while(temp>0){
                          r2=temp%10;
                         c++;
                         temp=temp/10;
                
                     }
                     if(c==10 && (r2==9 || r2==7 || r2== 8)){
                     System.out.println("number count:" +c);
                     
                     break;
                     
                     }
                     else{
                        System.out.println("enter valid input");
                        continue;
                     }
            
                 }
             }
    }
}
class AddNewMembers extends AdminUser{
    String adminName;
    int adminId;
    int adminAge;

    AddNewMembers(){// a constructor to initialise variables.
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter Name");
        adminName=sc.nextLine();
        System.out.println("Please enter ID");
        adminId=sc.nextInt();
        System.out.println("Enter Age");
        adminAge=sc.nextInt();
    }
    void show(){//method to display information.
        System.out.println("Name:"+adminName);
        System.out.println("ID:"+ adminId);
        System.out.println("Age:"+adminAge);
    }
}
class Run{
   static String pincode;//declaration of instance variable.
    static double netRevenue;
     static double expenses;
     static double franchiseFee;
     static double defaultFranchiseFee=2500000;
     static int chcustomer ;
     static int chAdmin;
        public static void main(String args[]){
            //declaration of arrays.
            String []defaultMenu=new String[]{"Chole Bhature:300","chowmin:150","Pav Bhaji:200","Dosa:150","Pizza:100","Butter roti:15","Shahi Panner:150"};
            String []defaultFranchise=new String[]{"Bopal","Vastrapur","Law garden","South Bopal","Vasna","Prahlad Nagar"};
            int []workers=new int[]{25,30,20,20,22,25};
            Scanner sc=new Scanner(System.in);
            System.out.println("WELCOME");
            System.out.println("Please enter your choice\n1.Admin login\n2.Customer\n");
            int ch=sc.nextInt();
            int size;
             switch (ch){//switch case for user
                case 1:{
                        Scanner scanner = new Scanner(System.in);
                        AdminUser adminUser = new AdminUser();

       
                        System.out.println("Enter your username:");
                        String username = scanner.nextLine();

                        System.out.println("Enter your password:");
                        String password = scanner.nextLine();

                        // Authenticate the user
                        if (adminUser.authenticate(username, password)) {

                            System.out.println("Login successful!");
                            do{System.out.println("1.inputs of restaurant chains\n2.add new members\n3.franchise details\n4.Exit");
                            chAdmin=sc.nextInt();
                            switch(chAdmin){//switch for menu.
                                case 1:{//for inputs of restaurant chain.
                                    System.out.println("Honest the name of the restaurant chain:");
                                    // String name = scanner.nextLine();

                                    System.out.println("Enter the number of locations in the restaurant chain:");
                                    int numberOfLocations = scanner.nextInt();
        
                                    String a[]=new String[numberOfLocations];
                                    for(int i=0;i<a.length;i++){
                                        System.out.println("please enter name of locations" + (i+1));
                                        a[i]=scanner.next();
                                    }
                                    

                                    RestaurantChain restaurantChain = new RestaurantChain("Honest", numberOfLocations);//object creation.

                                    System.out.println("Enter the revenue for each location:");

                                    for (int i = 1; i <= numberOfLocations; i++) {
                                        System.out.println("Revenue for location " + i + ":");
                                        double revenue = scanner.nextDouble();
                                        restaurantChain.addRevenue(revenue);
                                    }

                                    franchiseFee = restaurantChain.calculateFranchiseFee();//method called and stored as it has a return value.
                            

                                    System.out.println("Enter the total expenses for the restaurant chain:");
                                    expenses = scanner.nextDouble();

                                    netRevenue = restaurantChain.calculateExpenses(expenses);
                                    System.out.println("Here is the revenue");
                                    System.out.println("Total revenue for " + restaurantChain.getNumberOfLocations() + " locations of " + restaurantChain.getName() + " is " + restaurantChain.getTotalRevenue() + " Ruppes");
                                    // System.out.println("Franchise fee for " + restaurantChain.getName() + " is " + franchiseFee + " Ruppes");
                                    System.out.println("Net revenue after expenses for " + restaurantChain.getName() + " is " + netRevenue + " Ruppes");
                                    
                                    break;
                                }
                                case 2:{
                                    System.out.println("enter number of entries");
                                    size=sc.nextInt();
                                    AddNewMembers []inputs=new AddNewMembers[size];
                                    for(int i=0;i<inputs.length;i++){
                                        inputs[i]=new AddNewMembers();
                                    }
                                    System.out.println();
                                    System.out.println("here are your inputs");
                                    for(int i=0;i<inputs.length;i++){
                                        inputs[i].show();
                                    }
                                    System.out.println();
                                    break;
                                }
                               
                                case 3:{
                                    System.out.println("franchise details");
                                    for(int i=0;i<defaultFranchise.length;i++){
                                        System.out.println(defaultFranchise[i] + ":" + workers[i]);
                                        
                                    }
                                    System.out.println();
                                    break;
                                }
                                case 4:{
                                    System.out.println("Thank You");
                                    System.exit(0);//try
                                }
                                default:{
                                    System.out.println("Enter valid input");
                                }
                            }}while(chAdmin!=4);
                            
                            
                            

                            
                        } 
                        else {
                            System.out.println("Login failed. Please try again.");
                        }
                        break;
                    }
                    case 2:{
                        Customer c=new Customer();
                       do{ System.out.println();
                        System.out.println("Here is the menu\n1.restaurant menu\n2.franchise details\n3.apply for franchise\n4.Exit");

                        chcustomer=sc.nextInt();
                        switch(chcustomer){
                            case 1:{//switch case for customer.
                                    for(int i=0;i<defaultMenu.length;i++){
                                    System.out.println(defaultMenu[i]);
                                    
                                }System.out.println();
                                break;
                            }
                            case 2:{
                                for(int i=0;i<defaultFranchise.length;i++){
                                    System.out.println("Honest "+defaultFranchise[i]);
                                    System.out.println("Number of workers:"+workers[i]);
                                    System.out.println();
                                }System.out.println();
                                break;
                            }
                            case 3:{
                                System.out.println("enter pin code");
                                pincode=sc.next();
                                boolean exit = false;
                                while(!exit){
                                    if(pincode.length() !=6){
                                        System.out.println("invalid pincode , please try again ,6 digits");
                                        pincode = sc.next();
                                        exit = false;
                                    }else{
                                        exit = true;
                                    }
                                }
                                
                                System.out.println("The estimate of franchise is:"+defaultFranchiseFee);
                                break;
                            }
                            case 4:{
                                System.out.println("Thank you");
                                System.exit(0);
                            }
                            default:{
                                System.out.println("please enter a valid input");
                            }
                        }
                       }while(chcustomer!=4);//do while loop to keep it running even after a function is used till exit option is entered. 
                    }
                   
        }
    }
}