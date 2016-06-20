package ie.silvia.TaskManagerDB;

import java.util.Scanner;

import org.jboss.logging.Logger;

public class App 
{
	private static Logger THELOGGER = Logger.getLogger("SilviaLogger");
	
	
    public static void main( String[] args )
    {
    	
        double budget = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input your budget: ");
        budget = scan.nextDouble();
        if(budget < 0){
        	THELOGGER.error("negative budget");
        }else if(budget>= 0 && budget < 5000){
        	THELOGGER.warn("small budget");
        }else if(budget >= 500){
        	THELOGGER.info("ok budget");
        }
        
        System.out.println("GREETINGS");
        THELOGGER.info("GREETINGS");
    }
}
