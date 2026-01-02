/*  This piece of code will serve as the "front end", getting the number(s) 
* from the user. It will then call the correct operation that the user wants 
* and return the results */ 

import java.util.Scanner; 
import java.util.regex.Pattern; // for regular expressions, to detect numbers and operations
import java.util.regex.Matcher; // for regular expressions, to search for numbers or operations in the string
import java.util.ArrayList; 

public class Output{
    private String expression; // creates a string that holds the expression e.x "2+2x3" 
    private Arithmetic arithmetic; 
    private ArrayList<Integer> numbers = new ArrayList<Integer>(); 

    public static void main(String[] args) {
        Output o = new Output(); 
        o.addNum(); 
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

    // this searches the expression for operations or string and then calls the correct method 
    public void searcher(){
        Pattern numberPattern = Pattern.compile("\\d+"); // creates the number to search for 
        Matcher numberMatcher = numberPattern.matcher(expression); // returns the matcher for number object 

        Pattern operationPattern = Pattern.compile("[]"); // creates operation to search for 
        Matcher operationMatcher = operationPattern.matcher(expression); // returns the number for operation 

        // iterates through the string checking for numbers
        while(numberMatcher.find()){
            String numberStr = numberMatcher.group(); 
            numbers.add(Integer.parseInt(numberStr)); 
        }

        // iterates through the string checking for operations
        while(operationMatcher.find()){
            this.doOperation(); 
        }
    }

    // checks which operation the user wants to do from getOperation 
    public void doOperation() {
        
        // for (int i = 0; i < expression.length(); i++){
        //     char ch = expression.charAt(i);
        //     if (ch == "+"){
        //         arithmetic.add(); 
        //     } else if (ch == "-"){
        //         arithmetic.subtract(); 
        //     }
        // }

    }
    
    // think of how to implement this later
    public String toString(){
        return ""; 
    }
}
