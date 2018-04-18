package main;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Test.TestBeanRemote;

public class Main {
	
	public static TestBeanRemote remote;
	
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        props.put(Context.PROVIDER_URL, "remote://localhost:4447"); 
        props.put(Context.SECURITY_PRINCIPAL, "zuhi");
        props.put(Context.SECURITY_CREDENTIALS, "afoj");
        
		Context ctx = new InitialContext(props);
		remote = (TestBeanRemote)ctx.lookup("/EJBServer/TestBean!Test.TestBeanRemote");
		String result =  remote.tstPlus("Ahoj", "Kikus");
		
		for(int i = 0;i < 10000 ; i++) {
			
			System.out.println(result);
		}
	}

}  
