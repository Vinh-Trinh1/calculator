/*  This piece of code will serve as the "front end", getting the number(s) 
* from the user. It will then call the correct operation that the user wants 
* and return the results */ 

import java.util.Scanner; 
import java.util.regex.Pattern; // for regular expressions, to detect numbers and operations
import java.util.regex.Matcher; // for regular expressions, to search for numbers or operations in the string
import java.util.Stack; // creates the stack object from java 

public class Output{
    private String expression; // creates a string that holds the expression e.x "2+2x3" 
    private Arithmetic arithmetic; 
    private Stack<Integer> numStack; 
    private Stack<String> operationStack; 
    public static void main(String[] args) {
        Output o = new Output();
        o.userInput(); 
    }

    public Output(){
        expression = ""; 
        arithmetic = new Arithmetic(); 
        numStack = new Stack<Integer>(); 
        operationStack = new Stack<String>(); 
    }

    // gets the expression from the user and add it to expression 
    public void userInput(){
        Scanner obj = new Scanner(System.in); // creates user input 
        System.out.println("Enter the expression you want to calculate: ");
        boolean endLoop = true; 
        // while loop to continously get user input until "=" is entered and then loop is stopped
        while(endLoop){
            String operation = obj.nextLine(); 
            expression += operation; 
                // stops the expression when an "=" is entered 
                if(operation.contains("=")) { endLoop=false; }
               // else if (){}
            
            }
        }



    // this searches the expression for operations or string and then calls the correct method 
    public void searcher() throws Unrecognizedexpression{ 
        Pattern numberPattern = Pattern.compile("\\d+"); // creates the number to search for 
        Matcher numberMatcher = numberPattern.matcher(expression); // returns the matcher for number object 

        Pattern additionSubtractionPattern = Pattern.compile("[+-]"); // creates operation to search for 
        Matcher additionSubtractionMatcher = additionSubtractionPattern.matcher(expression); // returns the number for operation 

        Pattern bracketsPattern = Pattern.compile("[()]"); 
        Matcher bracketsMatcher = bracketsPattern.matcher(expression); 

        Pattern multiplicationDivisionPattern = Pattern.compile("[*/]");
        Matcher multiplicationDivisionMatcher = multiplicationDivisionPattern.matcher(expression); 


        // iterates through the string checking for numbers
        while(numberMatcher.find()){
            String numberStr = numberMatcher.group(); 
            // adds the number into an array 
            numStack.push(Integer.parseInt(numberStr)); 
        }

        // iterates through the string checking for operations
        while(additionSubtractionMatcher.find()){
            String s = additionSubtractionMatcher.group(); 
            operationStack.push(s); 
            this.doOperation(s); 
        }

        while(multiplicationDivisionMatcher.find()){
            String s = multiplicationDivisionMatcher.group(); 
            operationStack.push(s); 
        }
        while(bracketsMatcher.find()){
            String s = bracketsMatcher.group(); 
            operationStack.push(s); 
        }
    }

    // checks which operation the user wants to do from getOperation 
    public void doOperation(String s) {
        if(operationStack.empty()){
            return; 
        }
        if(s.equals("(")){
            if(s.equals("+")){
            arithmetic.add(2, 1); 
            } else if(s.equals("-")){
                arithmetic.subtract(); 
            } else if(s.equals("*")){
                arithmetic.multiplication();
            } else if (s.equals("/")){
                arithmetic.division(); 
            }
        }
        
        if(s.equals("+")){
            arithmetic.add(1, 2); 
        } else if(s.equals("-")){
            arithmetic.subtract(); 
        } else if(s.equals("*")){
            arithmetic.multiplication();
        } else if (s.equals("/")){
            arithmetic.division(); 
        }

    }
    
    // think of how to implement this later
    public String toString(){
        return ""; 
    }
}
