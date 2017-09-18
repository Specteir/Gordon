package user;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UserManager {
	ArrayList<User> userList;

	public UserManager(String filename) {

	}

	public ArrayList<User> readUsers() {
		ArrayList<User> returnList = new ArrayList<User>();
		try {
			File xmlFile = new File("Users/UserList.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("user");

			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) node;

					User user = new User();
					user.setUserName(eElement.getAttribute("id"));
					user.setMusicViolations(Integer
							.parseInt(eElement.getElementsByTagName("musicViolations").item(0).getTextContent()));
					user.setTextViolations(
							Integer.parseInt(eElement.getElementsByTagName("textViolations").item(0).getTextContent()));
					;
					user.setStartDate(eElement.getElementsByTagName("startDate").item(0).getTextContent());

					returnList.add(user);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnList;
	}
}
