## Exception Handling 

Exception handling is a crucial aspect of programming that allows developers to gracefully handle and manage errors that occur during the execution of a program. Here are three common types of errors and their corresponding exception handling techniques:

1. Syntax Error: Error in Spelling

A syntax error occurs when there are mistakes in the code that violate the programming language's syntax rules. These errors are typically detected by the compiler or interpreter during the compilation or interpretation process. They need to be fixed before the program can run successfully.

2. Logical Error:

A logical error refers to a flaw in the algorithm or logic of a program. It may result in incorrect output or unexpected behavior, but it does not cause the program to terminate abnormally or throw exceptions. Identifying and rectifying logical errors requires careful debugging and analysis of the code.

```java
int a = 10;
int b = 20;
int sum = a - b;
System.out.println(sum);
```

3. Runtime Error:

A runtime error, also known as an exception, occurs during the execution of a program when an unexpected condition arises. These errors may be due to factors such as invalid input, division by zero, or resource unavailability. By using exception handling, we can catch and handle these runtime errors, preventing the program from crashing and providing appropriate feedback to the user.

# Example 1
```java
// Normal statements
int a = 10;
int b = 0;

// Critical exception handling
try {
    int temp = a / b;
    System.out.println(temp);
} catch (Exception e) {
    System.err.println("Some error occurred");
}

System.out.println("Bye");
```

Output:
```
Some error occurred
Bye
```

In the above code snippet, a division by zero occurs when `a` is divided by `b`. To prevent the program from terminating abruptly, we catch the `Exception` and display a custom error message. The program continues to execute, and "Bye" is printed after the exception handling block.

Exception handling is a valuable technique for building robust and fault-tolerant applications. It allows programmers to gracefully handle errors and provide appropriate feedback to users, improving the overall user experience.

# Example 2
```java
// normal statement
        int data[] = { 1, 2, 3, 4, 5 };
        // critical exceptation
        try {
            int temp = data[data.length];
            System.out.println(temp);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        System.out.println("Bye");
```

Output:
```
Bye
Error: java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
```

# Example 3

```Java
class Demo {
    public void a() {
        try {
            b();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    void b() throws Exception {
        int num1 = 10;
        int num2 = 0;
        int result = num1 / num2;
        System.out.println(result);
    }
}

public class test1 {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.a();
    }
}
```

# Example 4
we can also create the exceptation 
```
public class test3 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = -2;
        try {
            if (num2 < 0) {
                Exception e = new ArithmeticException();
                throw e;
            }
            int result = num1 / num2;
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Enter a valid number");
            System.out.println("Error: " + e);
        }
    }
}

```
Output: 
```
Enter a valid number
Error: java.lang.ArithmeticException
```