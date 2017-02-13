package com.mytask.myapp4;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.mytask.model.Department;
import com.mytask.model.Models;
import com.mytask.model.Post;
import com.mytask.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws ParserConfigurationException, SAXException, IOException {
		logger.info("Welcome home! The client locale is {}.", locale);

		Department dep= new Department();
		
		List<Department> listDepartment = new ArrayList<Department>();
		List<User> listUser = new ArrayList<User>();
		List<Post> listPost = new ArrayList<Post>();
		List<Models> listModel = new ArrayList<Models>();

        
        
		File inputFile = new File("D:/natbank/podr.xml");
		
        InputStream inputStream= new FileInputStream(inputFile);
        Reader reader = new InputStreamReader(inputStream,"UTF-8");
        InputSource is = new InputSource(reader);
        is.setEncoding("UTF-8");
		
        DocumentBuilderFactory dbFactory 
           = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(is);      

        
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("Department");
        System.out.println("----------------------------");
        
        
        Department department=null;
        String chiefman="";

        
        for (int i = 0; i < nList.getLength(); i++) {
        	Node nNode=nList.item(i);
        	Element eElement=(Element) nNode;
        	//System.out.print(i+")  ");
        	
            try {
            	//System.out.println(eElement.getElementsByTagName("Chiefman").item(0).getAttributes().item(1).getTextContent());
            	chiefman=eElement.getElementsByTagName("Chiefman").item(0).getAttributes().item(1).getTextContent();
    		} catch (Exception e) {
    			// TODO: handle exception
//    			System.out.println("Chiefman is null");
    			chiefman="";
    		}
        	
        	try {
//        		System.out.println("UID : "+eElement.getAttribute("UID")
//        										+" Description : "+eElement.getAttribute("Description")
//        										+" Parent "+eElement.getElementsByTagName("Parent").item(0).getAttributes().item(1).getTextContent());
//        		
        		
        		if(eElement.getAttribute("Description")!=null && eElement.getAttribute("UID")!=null && eElement.getElementsByTagName("Name").item(0).getTextContent()!=null && eElement.getElementsByTagName("ShortName").item(0).getTextContent()!=null && eElement.getElementsByTagName("Parent").item(0).getAttributes().item(1).getTextContent()!=null){
            		department = new Department(eElement.getAttribute("Description"), 
							eElement.getAttribute("UID"),
							eElement.getElementsByTagName("Name").item(0).getTextContent(),
							eElement.getElementsByTagName("ShortName").item(0).getTextContent(), 
							eElement.getElementsByTagName("Parent").item(0).getAttributes().item(1).getTextContent(), 
							"Department");
        		
        		}

        		
        		
			} catch (Exception e) {
//				e.printStackTrace();
				
				if(eElement.getAttribute("Type").equals("") && eElement.getAttribute("Description")!="" ){
					if(eElement.getAttribute("Description")!=null && eElement.getAttribute("UID")!=null && eElement.getElementsByTagName("Name").item(0).getTextContent()!=null ){
						try {
							if(eElement.getElementsByTagName("Parent").item(0).getAttributes().item(1).getTextContent()!=""){
								department = new Department(eElement.getAttribute("Description"), 
										eElement.getAttribute("UID"),
										eElement.getAttribute("Name"),
										eElement.getElementsByTagName("Parent").item(0).getAttributes().item(1).getTextContent()
										);
//								System.out.println("Done , with parent : "+eElement.getAttribute("UID"));
							
								
							}
							
						} catch (Exception e2) {
							// TODO: handle exception
							department = new Department(eElement.getAttribute("Description"), 
									eElement.getAttribute("UID"),
									eElement.getAttribute("Name"));
							//System.out.println("Done , without parent : "+eElement.getAttribute("UID"));
						
						}
					}

				}

			}
        	department.setChiefman(chiefman);
        	
        	if(department.getParentUID()==""){
        		department.setParentUID("0");
        		System.out.println(department.getParentUID());
        		
        	}
        	
        	if(listDepartment.size()==0){
        		listDepartment.add(department);
        	}else if( !listDepartment.get(listDepartment.size()-1).getUid().equals(department.getUid())){
        		
        		listDepartment.add(department);
        	}
        	

        	
        	
        	
		}
        

       

       
       nList = doc.getElementsByTagName("User");
       System.out.println("----------------------------");
       
       
       
       
       
       for (int i = 0; i < nList.getLength(); i++) {
       	Node nNode=nList.item(i);
       	Element eElement=(Element) nNode;
       	//System.out.print(i+")  ");

       	String uDepId="";
       
       	try {
             		uDepId=eElement.getElementsByTagName("Department").item(0).getAttributes().item(1).getTextContent();
		} catch (Exception e) {
			System.out.println("");
		       
			for (Department department3 : listDepartment) {
		    	    if(department3.getChiefman().equals(eElement.getAttribute("UID"))){
		    		   uDepId=department3.getUid();
		    		    }
		    	   
				
		       }

			
			// TODO: handle exception
		}
       	User u= new User(eElement.getAttribute("Description"), 
       			eElement.getAttribute("UID"), 
       			eElement.getElementsByTagName("Name").item(0).getTextContent(), 
       			eElement.getElementsByTagName("Post").item(0).getAttributes().item(1).getTextContent(), 
       			uDepId, 
       			"Depatrment");
       	//System.out.println(u.toString());
       		listUser.add(u);


       	
       	
			}
       
       
       nList = doc.getElementsByTagName("Post");
       System.out.println("----------------------------");
       
       
       
     
       
       for (int i = 0; i < nList.getLength(); i++) {
       	Node nNode=nList.item(i);
       	Element eElement=(Element) nNode;
       	String postDesc="";
       	String  postName="";

       	try {
	if(eElement.getAttribute("Description")!="" &&  eElement.getElementsByTagName("Name").item(0).getTextContent()!=""){
           		postDesc=eElement.getAttribute("Description");
           		postName=eElement.getElementsByTagName("Name").item(0).getTextContent();
           		
           	}
		} catch (Exception e) {
			// TODO: handle exception
		}
       	
       	if(postDesc!="" &&  postName!=""){
       		
       		Post p = new Post(postDesc,eElement.getAttribute("UID"),postName);
       		
       		
            for (User user : listUser) {
//            	System.out.println("Post user ID : "+user.getPostUID());
            	if(user.getPostUID().equals(p.getUid())){
            		
            		p.setDepartment(user.getDepartmentUID());
            	}
    			
    		}
       		listPost.add(p);
//       		System.out.println(p.toString());
       	
       	}
       	
       	
 
       	
			}
       
       System.out.println("Tree");
       
		Date date = new Date();
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	
//	String formattedDate = dateFormat.format(date);
	
	Map<String, Object> mMap = new HashMap<String, Object>();
	mMap.put("department", listDepartment);
	mMap.put("user", listUser);
	mMap.put("post", listPost);
	
	model.addAttribute("serverTime", mMap );
       
	Object[][] oArray = new Object[1000][1000];
		for (int q = 0; q < listDepartment.size(); q++) {
			if(listDepartment.get(q).getParentUID()==""){
				if(oArray[0][0]==null){
					oArray[0][0]=listDepartment.get(q);
				}
			}
			
		}
		
		

        return "home";
	}
	
}
