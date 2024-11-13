/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controller;

import core.controller.utils.Response;
import core.controller.utils.Status;
import core.models.Calculator;
import core.models.History;
import core.models.Operation;

/**
 *
 * @author sddva
 */
public class CalculatorController {
    
    public static Response addition(String a, String b){
    double numberA;
    double numberB;
    double result;
        try {
               
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
            
            if(numberA > Double.MAX_VALUE || numberB > Double.MAX_VALUE){
                return new Response("Numbers cannot be greater than max value", Status.BAD_REQUEST);
            }
  
            if(numberA < -Double.MAX_VALUE || numberB < -Double.MAX_VALUE){
                return new Response("Numbers cannot be less than min value", Status.BAD_REQUEST);
            }
           
            if(numberA + numberB > Double.MAX_VALUE){
                return new Response("Numbers cannot add more than max value", Status.BAD_REQUEST);
            }
            
            if(numberA + numberB < -Double.MAX_VALUE){
                return new Response("Numbers cannot add less than min value", Status.BAD_REQUEST);
            }    
            
            History history = History.getIntance();
            Calculator calculator = Calculator.getIntance();
            history.addOperation(new Operation(numberA, numberB, "+", calculator.add(numberA, numberB)));
            return new Response("Numbers added", Status.OK);
            
        } catch (NumberFormatException e) {
            return new Response("number must be numeric", Status.BAD_REQUEST);
        }
    }
    
    public static Response subtraction(String a, String b){
        double numberA;
        double numberB;
        
        try {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
            
            if(numberA > Double.MAX_VALUE || numberB > Double.MAX_VALUE){
                return new Response("Numbers cannot be greater than max value", Status.BAD_REQUEST);
            }
  
            if(numberA < -Double.MAX_VALUE || numberB < -Double.MAX_VALUE){
                return new Response("Numbers cannot be less than min value", Status.BAD_REQUEST);
            }
            
            if(numberA - numberB > Double.MAX_VALUE){
                return new Response("Result cannot be greater than max value", Status.BAD_REQUEST);
            }
            
            if(numberA - numberB < -Double.MAX_VALUE){
                return new Response("Result cannot be less than min value", Status.BAD_REQUEST);
            }
            
            History history = History.getIntance();
            Calculator calculator = Calculator.getIntance();
            history.addOperation(new Operation(numberA, numberB, "-", calculator.subtract(numberA, numberB)));
            return new Response("Number subtracted succesfully", Status.OK);
            
        } catch (NumberFormatException e) {
            return new Response("number must be numeric", Status.BAD_REQUEST);
        }
    }
    
    public static Response product(String a, String b){
        double numberA;
        double numberB;
        
        try {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
            
            if(numberA > Double.MAX_VALUE || numberB > Double.MAX_VALUE){
                return new Response("Numbers cannot be greater than max value", Status.BAD_REQUEST);
            }
  
            if(numberA < -Double.MAX_VALUE || numberB < -Double.MAX_VALUE){
                return new Response("Numbers cannot be less than min value", Status.BAD_REQUEST);
            }
            
            if(numberA * numberB > Double.MAX_VALUE){
                return new Response("Result cannot be greater than max value", Status.BAD_REQUEST);
            }
            
            if(numberA * numberB < -Double.MAX_VALUE){
                return new Response("Result cannot be less than min value", Status.BAD_REQUEST);
            }
            
            History history = History.getIntance();
            Calculator calculator = Calculator.getIntance();
            history.addOperation(new Operation(numberA, numberB, "*", calculator.multiply(numberA, numberB)));
            return new Response("Number multiplied succesfully", Status.OK);
            
        } catch (NumberFormatException e) {
            return new Response("number must be numeric", Status.BAD_REQUEST);
        }
    }
    
    public static Response division(String a, String b){
        double numberA;
        double numberB;
        
        try {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
            
            if(numberA > Double.MAX_VALUE || numberB > Double.MAX_VALUE){
                return new Response("Numbers cannot be greater than max value", Status.BAD_REQUEST);
            }
  
            if(numberA < -Double.MAX_VALUE || numberB < -Double.MAX_VALUE){
                return new Response("Numbers cannot be less than min value", Status.BAD_REQUEST);
            }
            
            if(numberB == 0){
                return new Response("Divisor cannot be 0", Status.BAD_REQUEST);
            }
            
            if(numberA / numberB > Double.MAX_VALUE){
                return new Response("Result cannot be greater than max value", Status.BAD_REQUEST);
            }
            
            if(numberA / numberB < -Double.MAX_VALUE){
                return new Response("Result cannot be less than min value", Status.BAD_REQUEST);
            }
            
            History history = History.getIntance();
            Calculator calculator = Calculator.getIntance();
            history.addOperation(new Operation(numberA, numberB, "/", calculator.divide(numberA, numberB)));
            return new Response("Number divided succesfully", Status.OK);
            
        } catch (NumberFormatException e) {
            return new Response("number must be numeric", Status.BAD_REQUEST);
        }
    }
    
    public static Response power(String a, String b){
        double numberA;
        double numberB;
        double result;
        
        try {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
            
            if(numberA > Double.MAX_VALUE || numberB > Double.MAX_VALUE){
                return new Response("Numbers cannot be greater than max value", Status.BAD_REQUEST);
            }
  
            if(numberA < -Double.MAX_VALUE || numberB < -Double.MAX_VALUE){
                return new Response("Numbers cannot be less than min value", Status.BAD_REQUEST);
            }       
            
            if(Math.pow(numberA, numberB) > Double.MAX_VALUE){
                return new Response("Result cannot be greater than max value", Status.BAD_REQUEST);
            }
            
            if(Math.pow(numberA, numberB) < -Double.MAX_VALUE){
                return new Response("Result cannot be less than min value", Status.BAD_REQUEST);
            }
            
            if(Math.pow(numberA, numberB) < Double.MIN_VALUE){
                return new Response("Numbers cannot be less than min value", Status.BAD_REQUEST);
            }
            
            if(numberB == 0){
                result = 1;
                History history = History.getIntance();
                history.addOperation(new Operation(numberA, numberB, "^", result));
                return new Response("Number powered succesfully", Status.OK);
            }
            
            History history = History.getIntance();
            Calculator calculator = Calculator.getIntance();
            history.addOperation(new Operation(numberA, numberB, "^", calculator.power(numberA, numberB)));
            return new Response("Number powered succesfully", Status.OK);
            
        } catch (NumberFormatException e) {
            return new Response("number must be numeric", Status.BAD_REQUEST);
        }
    }
    
}
