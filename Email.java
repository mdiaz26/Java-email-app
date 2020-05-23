import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;
    private String companySuffix = "aecompany.com";

    // Constructor to receive the firstName and lastName
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        // Call a method asking for the department
        this.department = setDepartment();
        // System.out.println("Department is " + this.department);
        
        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        // System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + "." + companySuffix;
        System.out.println(email);
    }
    // Ask for the department
        private String setDepartment() {
            System.out.print("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code");
            Scanner in = new Scanner(System.in);
            int depChoice = in.nextInt();
            if (depChoice == 1) {return "sales";}
            else if (depChoice == 2) {return "dev";}
            else if (depChoice == 3) {return "acct";}
            else {return "";}
        }
    // Generate a random password
        private String randomPassword(int length) {
            String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
            char[] password = new char[length];
            for (int i = 0; i < length; i++) {
                int random = (int) (Math.random() * passwordSet.length());
                password[i] = passwordSet.charAt(random);
            }
            return new String(password);
        }
    // Set the mailbox capcity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set the alternateEmail
    public void setAltEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    } 

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName + 
        "\nCOMPANY EMAIL: " + email + 
        "\nMAILBOX CAPACITY" + mailboxCapacity + "mb";
    }
}