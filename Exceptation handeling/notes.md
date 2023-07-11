#_Exception Handeling_#

1. syntax error: error in spelling
2. logical error:
   ` int a = 10;
     int b = 20;
     sum = a - b;
     print(sum);`
3. runtime error
   `  // normal statement
        int a = 10;
        int b = 0;
        // critical exceptation
        try {
            int temp = a / b;
            System.out.println(temp);
        } catch (Exception e) {
            System.err.println("Some error occured");
        }
        System.out.println("Bye");`

        #Output
        `Some error occured
         Bye`
