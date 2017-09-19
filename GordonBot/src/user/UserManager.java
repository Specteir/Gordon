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
		userList = readUsers(filename);
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	private ArrayList<User> readUsers(String filename) {
		ArrayList<User> returnList = new ArrayList<User>();
		try {
			File xmlFile = new File(filename);

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("server");

			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) node;

					User user = new User();
					user.setUserName(eElement.getElementsByTagName("username").item(0).getTextContent());
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

	public User getUser(String userName) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserName().equals(userName)) {
				return userList.get(i);
			}
		}
		return null;
	}

	public void addUser(User user) {
		// TODO Write the user to the XML file.

	}
}
