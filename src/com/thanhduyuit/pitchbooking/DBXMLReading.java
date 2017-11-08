package com.thanhduyuit.pitchbooking;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import com.thanhduyuit.modal.CustomerModal;
import com.thanhduyuit.modal.OwnerModal;
import com.thanhduyuit.modal.UserModal;

import java.io.File;

public class DBXMLReading {

	final private static String DATABASE_PATH= "C:/Users/duydt2/Desktop/PitchBooking/PitchBooking/PitchBooking/src/com/thanhduyuit/database/";
//	public static void main(String argv[]) {
//
//	    try {
//
//	    //C:\Users\duydt2\Desktop\PitchBooking\PitchBooking\PitchBooking\src\com\thanhduyuit\database	
//		File fXmlFile = new File(DATABASE_PATH + "staff.xml");
//		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//		Document doc = dBuilder.parse(fXmlFile);
//
//		//optional, but recommended
//		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
//		doc.getDocumentElement().normalize();
//
//		NodeList nList = doc.getElementsByTagName("staff");
//		for (int temp = 0; temp < nList.getLength(); temp++) {
//
//			Node nNode = nList.item(temp);
//			System.out.println("nNode id : " + nList);
//			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//				Element eElement = (Element) nNode;
//				System.out.println("nNode id : " + eElement);
//				System.out.println("nNode id : " + eElement);
////				System.out.println("Staff id : " + eElement.getAttribute("id"));
////				System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
////				System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
////				System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
////				System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
//
//			}
//		}
//	    } catch (Exception e) {
//		e.printStackTrace();
//	    }
//	  }
	
	public static Element ReadXML(String username) { 

	    try {

	    //C:\Users\duydt2\Desktop\PitchBooking\PitchBooking\PitchBooking\src\com\thanhduyuit\database	
		File fXmlFile = new File(DATABASE_PATH + "Users.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("user");
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				if(eElement.getElementsByTagName("username").item(0).getTextContent().equalsIgnoreCase(username)){
					return eElement;
				}
				
//				System.out.println("Staff id : " + eElement.getAttribute("id"));
//				System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
//				System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
//				System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
//				System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

			}
		}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	    
	    return null;
		
	}
	public static UserModal getUsers(Element eElement){
		UserModal user = new UserModal();
		
		
		
		return user;
		
	}
	
	//public static UserModal checkLogin(String uname, String pwd) throws Exception {
	public static UserModal checkLogin(String uname, String pwd){
		UserModal user = null;
		Element eElement = ReadXML(uname);
		if(eElement.getElementsByTagName("password").item(0).getTextContent().equalsIgnoreCase(pwd)){
			System.out.println("Success");
			return ConvertUser(user,eElement);
		}
		
		
		return user;
		
	}
	public static UserModal ConvertUser(UserModal user, Element eElement){
		if(eElement.getElementsByTagName("userType").item(0).getTextContent().equalsIgnoreCase("Owner")){
			user = new OwnerModal();
			user.setEmail(eElement.getElementsByTagName("username").item(0).getTextContent());
			user.setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());
			user.setFullName(eElement.getElementsByTagName("fullname").item(0).getTextContent());
			user.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
			user.setPhoneNumber(eElement.getElementsByTagName("phoneNumber").item(0).getTextContent());
			user.setUserType(eElement.getElementsByTagName("userType").item(0).getTextContent());
			user.setNote(eElement.getElementsByTagName("note").item(0).getTextContent());
			
		}
		
		if(eElement.getElementsByTagName("userType").item(0).getTextContent().equalsIgnoreCase("Customer")){
			user = new CustomerModal();
			user.setEmail(eElement.getElementsByTagName("username").item(0).getTextContent());
			user.setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());
			user.setFullName(eElement.getElementsByTagName("fullname").item(0).getTextContent());
			user.setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
			user.setPhoneNumber(eElement.getElementsByTagName("phoneNumber").item(0).getTextContent());
			user.setUserType(eElement.getElementsByTagName("userType").item(0).getTextContent());
			user.setNote(eElement.getElementsByTagName("note").item(0).getTextContent());
		}
		return user;
		
	}
	
	
}
