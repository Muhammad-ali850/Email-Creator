import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class email {
    private String firstName;
    private String lastName;
    private String department;
    private String companySuffix = "company.com"; //could be any company
    private String password;
    private String email;
    private int passwordlength = 8; //could be any length
    
    public email(){
        setFirstName(firstName);
        setLastName(lastName);
        setDepartment(department);
        setPassword(passwordlength);
        email = getFirstName().toLowerCase() + "." + getLastName().toLowerCase() + "@" + getDepartment() + "." + companySuffix;
        System.out.println("\nEmail: " + email);
        System.out.println("Password: " + getPassword());
        SaveToFile();
    }
    
    Scanner s = new Scanner(System.in);

    public String getPassword() {
        return password;
    }
    public void setPassword(int length) {
        String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#/$*-";
        char passwordSetArray[] = passwordSet.toCharArray();
        char password[] = new char[length];
        for(int i=0; i<length; i++){
            int randomNum = (int) (Math.random() * passwordSet.length());
            password[i]=passwordSetArray[randomNum];
        }
        String readyPassword = new String(password);
        this.password = readyPassword;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        System.out.println("First name?");
        firstName = s.next();
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        System.out.println("Last name?");
        lastName = s.next();
        this.lastName = lastName;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        System.out.println("\t" + "*" + getFirstName() + " " + getLastName() + "*" + "\n" + "Choose Departement by pressing:\n" + "1 for HR\n2 for Finance\n3 for Marketing\n4 for IT\n5 for Customer Service\n\n0 for other"); //could be more departments
        int a = s.nextInt();
        if(a==1) department="hr";
        else if(a==2) department="fin";
        else if(a==3) department="mark";
        else if(a==4) department="it";
        else if(a==5) department="customerser";
        else department="other";
        this.department = department;
    }

    public void SaveToFile(){
        try {
            FileWriter f = new FileWriter("file.txt", true);
            f.write("\t\t\t\t" + getFirstName() + " " + getLastName() + "\n" + "Email: " + email + " | Password: " + getPassword() + "\n\n");
            f.close();
            System.out.println("Successfully saved to file." + "\n\t_____________");
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}