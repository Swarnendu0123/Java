import java.util.Scanner;

class Student {
    private int age = 0;
    private String name = "";
    private String dept = "";
    private String password = "";
    Scanner in = new Scanner(System.in);

    public void setData() {
        if (name != "" || age != 0 || password != "" || dept != "") {
            return;
        }
        System.out.println("Welcome First create an account");
        System.out.println("Enter your name: ");
        String name = in.nextLine();
        this.name = name;
        System.out.println("Enter your age: ");
        int age = in.nextInt();
        this.age = age;
        System.out.println("Enter your department: ");
        String dept = in.next();
        this.dept = dept;

        String password1;
        String password2;
        do {
            System.out.println("Enter password: ");
            password1 = in.next();
            System.out.println("Re-enter password: ");
            password2 = in.next();
            if (password1.equals(password2)) {
                this.password = password1;
                break;
            }
            System.out.println("Passwords are not matching please re-enter");
        } while (password1 != password2);

        if (password1.equals(password2)) {
            this.password = password1;
        }

    }

    public void changePassword() {
        System.out.println("Enter Your current Password to change password: ");
        String oldPassword = in.next();

        if (oldPassword.equals(password)) {
            System.out.println("enter your new password:");
            String newPassword = in.next();
            this.password = newPassword;
            System.out.println("Password changed successfully");
        } else {
            System.out.println("You have entered wrong password.");
            System.out.println("Forget Password?");
            System.out.println("Enter 1 to change password");
            System.out.println("Enter 2 to try again");
            System.out.println("Enter any key to exit");
            System.out.println("Choice: ");
            int choice = in.nextInt();
            if (choice == 1) {
                changePassword();
            } else {
                return;
            }
        }
    }

    public void changeAge() {
        System.out.println("Enter Your current Password to change age: ");
        String enteredPassword = in.next();
        if (enteredPassword.equals(password)) {
            System.out.println("Enter your new age: ");
            int age = in.nextInt();
            int temp = this.age;
            this.age = age;
            System.out.print("Age: " + temp);
            System.out.println(" -> " + age);
        } else {
            System.out.println("You have entered wrong password.");
            System.out.println("Forget Password?");
            System.out.println("Enter 1 to change password");
            System.out.println("Enter 2 to try again");
            System.out.println("Enter any key to exit");
            System.out.println("Choice: ");
            int choice = in.nextInt();
            if (choice == 1) {
                changePassword();
                changeAge();
            } else if (choice == 2) {
                changeAge();
            } else {
                return;
            }
        }

    }

    public void changeName() {
        System.out.println("Enter Your current Password to change name: ");
        String enteredPassword = in.next();
        if (enteredPassword.equals(password)) {
            System.out.println("Enter your new name: ");
            String name = in.next();
            String temp = this.name;
            this.name = name;
            System.out.print("Name: " + temp);
            System.out.println(" -> " + name);
        } else {
            System.out.println("You have entered wrong password :(");
            System.out.println("Forget Password?");
            System.out.println("Enter 1 to change password");
            System.out.println("Enter 2 to try again");
            System.out.println("Enter any key to exit");
            System.out.println("Choice: ");
            int choice = in.nextInt();
            if (choice == 1) {
                changePassword();
                changeName();
            } else if (choice == 2) {
                changeName();
            } else {
                return;
            }
        }
    }

    public void showData() {
        System.out.println("Enter Your current Password to acess your profile data: ");
        String enteredPassword = in.next();
        if (enteredPassword.equals(password)) {
            System.out.println("Name: " + name + ", Age: " + age + ", Department: " + dept);
        } else {
            System.out.println("You have entered wrong password.");
            System.out.println("Forget Password?");
            System.out.println("Enter 1 to change password");
            System.out.println("Enter 2 to try again");
            System.out.println("Enter any key to exit");
            System.out.println("Choice: ");
            int choice = in.nextInt();
            if (choice == 1) {
                changePassword();
                showData();
            } else if (choice == 2) {
                showData();
            } else {
                return;
            }
        }
    }

}

public class encapculation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();

        do {
            System.out.println("1 => Student 1\n 2 => Student 2 \n 3 => Student 3\n 0 => EXIT ");
            System.out.println("Enter student Number :");
            int studentChoice = in.nextInt();
            if (studentChoice == 1) {
                // show data
                student1.setData();
                System.out.println();
                System.out.println("Enter 2 to change your name");
                System.out.println("Enter 3 to change your age");
                System.out.println("Enter 4 to change your psaaword");
                System.out.println("Enter 5 to see profile data");
                System.out.println("Enter 6 to Exit");
                System.out.println();
                System.out.print("Choice:");
                int choice = in.nextInt();
                switch (choice) {
                    case 2:// change name
                        student1.changeName();
                        break;
                    case 3:// change age
                        student1.changeAge();
                        break;
                    case 4:// chnaging passwords
                        student1.changePassword();
                        break;
                    case 5:// show data
                        student1.showData();
                        break;
                    case 6:// exit
                        System.out.println("Logged out");
                        break;
                    default:
                        System.out.println("you entered wrong input");
                        break;
                }

            } else if (studentChoice == 2) {
                // show data
                student2.setData();
                System.out.println();
                System.out.println("Enter 2 to change your name");
                System.out.println("Enter 3 to change your age");
                System.out.println("Enter 4 to change your psaaword");
                System.out.println("Enter 5 to see profile data");
                System.out.println("Enter 6 to Exit");
                System.out.println();
                System.out.print("Choice:");
                int choice = in.nextInt();
                switch (choice) {
                    case 2:// change name
                        student2.changeName();
                        break;
                    case 3:// change age
                        student2.changeAge();
                        break;
                    case 4:// chnaging passwords
                        student2.changePassword();
                        break;
                    case 5:// show data
                        student2.showData();
                        break;
                    case 6:// exit
                        System.out.println("Logged out");
                        break;
                    default:
                        System.out.println("you entered wrong input");
                        break;
                }

            } else if (studentChoice == 3) {
                // show data
                student3.setData();
                System.out.println();
                System.out.println("Enter 2 to change your name");
                System.out.println("Enter 3 to change your age");
                System.out.println("Enter 4 to change your psaaword");
                System.out.println("Enter 5 to see profile data");
                System.out.println("Enter 6 to Exit");
                System.out.println();
                System.out.print("Choice:");
                int choice = in.nextInt();
                switch (choice) {
                    case 2:// change name
                        student3.changeName();
                        break;
                    case 3:// change age
                        student3.changeAge();
                        break;
                    case 4:// chnaging passwords
                        student3.changePassword();
                        break;
                    case 5:// show data
                        student3.showData();
                        break;
                    case 6:// exit
                        System.out.println("Logged out");
                        break;
                    default:
                        System.out.println("you entered wrong input");
                        break;
                }

            } else if (studentChoice == 0) {
                return;
            }
        } while (true);

    }
}
