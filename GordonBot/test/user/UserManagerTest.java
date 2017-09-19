package user;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class UserManagerTest {

	@Test
	public void testReadUsers() {
		UserManager manager = new UserManager("Users/UserList.xml");
		ArrayList<User> list = manager.getUserList();

		assertTrue(list.get(0).toString().startsWith("Specteir"));
	}

}
