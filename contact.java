import java.util.LinkedList;
import java.util.Scanner;

public class contact {
    public String name;
    public String phone;
    public String email;
    public contact(String name, String phone,
                   String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;

    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String toString() {
        return name + " " + phone + " " + email+" ";
    }

    private static LinkedList<contact> LL = new LinkedList<>();
    public static void main(String[] args) {
        String name, phone, email;
        Scanner In = new Scanner(System.in);

        while (true){
            System.out.println("*******\n" +
                    "(A)dd\n" +
                    "(D)elete\n" +
                    "(E)mail Search\n" +
                    "(P)rint List\n" +
                    "(S)earch\n" +
                    "(Q)uit\n" +
                    "*******\n");
            String command = In.nextLine();
            command.toUpperCase();

            switch (command) {
                case "A": {
                    System.out.println("Enter name: ");
                    name = In.nextLine();
                    System.out.println("Enter email: ");
                    email = In.nextLine();
                    System.out.println("Enter Phone number: ");
                    phone = In.nextLine();
                    contact c = new contact(name, phone, email);
                    LL.add(c);
                    continue;
                }
                case "D": {
                    System.out.print("Enter Name :");
                    final String delete = In.nextLine(); 
                    boolean removed = LL.removeIf(contact -> contact.getName().equals(delete));
                    if (removed) {
                        System.out.println("** Contact Removed Successfully **");
                    } else {
                        System.out.println("** Contact Not Found **");
                    }
                    continue; 
                }
                case "E": {
                    int cnt = 0;
                    System.out.print("Search name :");
                    String fEmail = In.next();
                    for (contact c : LL) {
                        if (c.getEmail().contains(fEmail)) {
                            System.out.println(c);
                            cnt++;
                        }
                    }
                    if (cnt == 0) {
                        System.out.println("No email found with the keyword '" + fEmail + "'");
                    }
                    continue;
                }
                case "P": {
                    System.out.println("Displaying all contacts :");

                    for (contact c : LL) {
                        System.out.println(c);
                    }
                    continue;
                }
                case "S": {
                    int count = 0;
                    System.out.print("Search name :");
                    String fName = In.next();
                    for (contact c : LL) {
                        if (c.getName().contains(fName)) {
                            System.out.println(c);
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("No name found with the keyword '" + fName + "'");
                    }
                    continue;
                }
                case "Q": {
                    System.out.println("Exiting the program...");
                    In.close();
                    return;
                }
                default:
                    System.out.println("Invalid command. Please try again.");
            }

        }

    }
}

