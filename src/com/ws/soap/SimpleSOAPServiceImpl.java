package com.ws.soap;

import java.util.Random;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class SimpleSOAPServiceImpl {

	 public String sayHello(@WebParam(name="echo") String echo) {
	        
//	            Thread.sleep(1000*60*5); // Sleep for 5 minutes
//	        	Thread.sleep(1000*60*1);
		 final String s = echo;
        	Thread thread = new Thread(){
        	    public void run(){
        	    	try {
        	    		///Service1
	        	    		Thread.sleep(500*60*1);
		        	      System.out.println("Request For " + s);
		        	      String res = test("Response For " + s + " Thread Running");
		        	     //Client2
		        	      //call Service2 method
		        	      System.out.println(res);
        	    	}catch(InterruptedException ex) {
        	          ex.printStackTrace();
        	        }
        	    }
        	};
        	thread.start(); 
	        
	        return "Hello "+ echo;
	    }
	 
	 private String test(String str){
		 return str + new Random().nextInt();
	 }
	 
	    //this is added by kiran
	
}
