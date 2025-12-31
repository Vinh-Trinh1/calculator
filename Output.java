/*  This piece of code will serve as the "front end", getting the number(s) 
* from the user. It will then call the correct operation that the user wants 
* and return the results */ 

import java.util.Scanner; 

public class Output{
    private String expression; // creates a string that holds the expression e.x "2+2x3" 
    private Arithmetic arithmetic; 

    public static void main(String[] args) {
        Output o = new Output(); 
        o.addNum();
        System.out.println(o.getNumArray()); 
        o.getOperation(); 
        o.addNum(); 
    }
    public Output(){
        expression = ""; 
        arithmetic = new Arithmetic(); 
    }

    // gets the number from the user and adds it to the array 
    public void addNum(){
        Scanner myObj = new Scanner(System.in);
        int userInput = myObj.nextInt(); 
        expression += String.valueOf(userInput);
    }

    // gets the operation from the user
    public String getOperation(){
        Scanner myObj = new Scanner(System.in);
        String userOperation = myObj.nextLine();
        return userOperation;
    }
    // checks which operation the user wants to do from getOperation 
    public void doOperation() throws Unrecognizedexpression{
         if(this.getOperation().isEmpty()){
            throw new Unrecognizedexpression("Please enter a valid expression."); 
        else{
            for (int i = 0; i < expression.length(); i++){
                char ch = expression.charAt(i);
                if (ch == "+"){
                    arithmetic.add(); 
                }
            }
            // } else if(this.getOperation().equals("+")){
            // // think of a better way to add numbers later
            // arithmetic.add();  

            }
        }
    }


    // think of how to implement this later
    public String toString(){
        return ""; 
    }
}
