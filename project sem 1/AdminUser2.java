import java.util.Scanner;

class AdminUser {
    String username;
     String password;

     AdminUser() {
        this.username = "admin";
        this.password = "1234";
    }

     boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

class RestaurantChain extends AdminUser{

         String name;
     int numberOfLocations;
     double totalRevenue;

     RestaurantChain(String name, int numberOfLocations) {
        this.name = name;
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
    
     
     public static void main(String[] args) {//main method.
        
        Scanner scanner = new Scanner(System.in);
        AdminUser adminUser = new AdminUser();

       
        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        // Authenticate the user
        if (adminUser.authenticate(username, password)) {
            System.out.println("Login successful!");

                    System.out.println("Enter the name of the restaurant chain:");
        String name = scanner.nextLine();

        System.out.println("Enter the number of locations in the restaurant chain:");
        int numberOfLocations = scanner.nextInt();
        
        String a[]=new String[numberOfLocations];
        for(int i=0;i<a.length;i++){
            System.out.println("please enter name of locations" + (i+1));
            a[i]=scanner.next();
        }
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

        RestaurantChain restaurantChain = new RestaurantChain(name, numberOfLocations);

        System.out.println("Enter the revenue for each location:");

        for (int i = 1; i <= numberOfLocations; i++) {
            System.out.println("Revenue for location " + i + ":");
            double revenue = scanner.nextDouble();
            restaurantChain.addRevenue(revenue);
        }

        double franchiseFee = restaurantChain.calculateFranchiseFee();
        double expenses;

        System.out.println("Enter the total expenses for the restaurant chain:");
        expenses = scanner.nextDouble();

        double netRevenue = restaurantChain.calculateExpenses(expenses);

        System.out.println("Total revenue for " + restaurantChain.getNumberOfLocations() + " locations of " + restaurantChain.getName() + " is $" + restaurantChain.getTotalRevenue());
        System.out.println("Franchise fee for " + restaurantChain.getName() + " is $" + franchiseFee);
        System.out.println("Net revenue after expenses for " + restaurantChain.getName() + " is $" + netRevenue);
           
        } else {
            System.out.println("Login failed. Please try again.");
        }
    }
}
class Run{
    public static void main(String args[]){
        System.out.println("WELCOME");
        System.out.println("1.Admin login\n2.Customer");
    }
}