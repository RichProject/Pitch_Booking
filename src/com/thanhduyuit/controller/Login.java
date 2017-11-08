package com.thanhduyuit.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;

import com.thanhduyuit.modal.UserModal;
import com.thanhduyuit.pitchbooking.DBConnection;
import com.thanhduyuit.pitchbooking.DBXMLReading;
import com.thanhduyuit.pitchbooking.Utilities;


//Path: http://localhost/<appln-folder-name>/login
@Path("/login")
public class Login {

	
		private UserModal user;
	// HTTP Get Method
		@GET 
		// Path: http://localhost/<appln-folder-name>/login/dologin
		@Path("/dologin")
		// Produces JSON as response
		@Produces(MediaType.APPLICATION_JSON) 
		// Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
		public JSONObject doLogin(@QueryParam("username") String uname, @QueryParam("password") String pwd){
			
			UserModal user = checkCredentials(uname, pwd);
			
			if(user != null){
				return Utilities.constructJSON(user,true);
			}else{
				return Utilities.constructJSON(false, "Incorrect Email or Password");
			}
		}

		/**
		 * Method to check whether the entered credential is valid
		 * 
		 * @param uname
		 * @param pwd
		 * @return
		 */
		private UserModal checkCredentials(String uname, String pwd){
			System.out.println("Inside checkCredentials");
			UserModal user = null;
			if(Utilities.isNotNull(uname) && Utilities.isNotNull(pwd)){
				try {
//					user = DBConnection.checkLogin(uname, pwd);
					user = DBXMLReading.checkLogin(uname, pwd);
					//System.out.println("Inside checkCredentials try "+result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//System.out.println("Inside checkCredentials catch");
					return user;
				}
			}else{
				//System.out.println("Inside checkCredentials else");
				return user;
			}

			return user;
		}

}
