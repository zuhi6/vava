package main;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import beans.UserBeanRemote;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static UserBeanRemote remoteUser;
	
	   public void start(Stage primaryStage) {

	        try {

	            Pane page = (Pane) FXMLLoader.load(Main.class.getResource("/view/LoginFXML.fxml"));
	            Scene scene = new Scene(page);
	            primaryStage.setScene(scene);
	            primaryStage.setTitle("Livestream Portal");
	            primaryStage.show();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }

	
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        props.put(Context.PROVIDER_URL, "remote://localhost:4447"); 
        props.put(Context.SECURITY_PRINCIPAL, "zuhi");
        props.put(Context.SECURITY_CREDENTIALS, "afoj");
        
		Context ctx = new InitialContext(props);
		remoteUser = (UserBeanRemote)ctx.lookup("/EJBServer/UserBean!beans.UserBeanRemote");
		launch(args);
		
		
	}

}  
