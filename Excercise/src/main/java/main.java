import jdk.dynalink.beans.StaticClass;
import model.User;

import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.SwitchPoint;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.BreakIterator;
import java.util.zip.Checksum;

public class main {
	private static User userSession = null;
	private static String sqlquery = null;
	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws SQLException, IOException {
		Connect connect = new Connect();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		login(connect, preparedStatement, resultSet);

		int choice;

		if (userSession.getRoleName().equals("Admin")) {
			AdminMenu();
			choice = Integer.parseInt(bufferedReader.readLine());
			switch (choice) {
				case 1: // view all user.
					getUsers(connect, preparedStatement, resultSet);
					break;
				case 2: // Create User
					createUser(connect, preparedStatement, resultSet);
					break;
				case 3: // update User
					updateUser(connect, preparedStatement, resultSet);
					break;
				case 4: // Delete User.
					deleteUser(connect, preparedStatement, resultSet);
					break;
				case 5: // view warehouses
					getWareHouses(connect, preparedStatement, resultSet);
					break;
				case 6: // create warehouse
					createWarehouse(connect, preparedStatement, resultSet);
					break;
				case 7: // update warehouse
					updateWareHouse(connect, preparedStatement, resultSet);
					break;
				case 8: // delete warehouse
					try{
						deleteWareHouse(connect, preparedStatement, resultSet);
					} catch( SQLException e){
						System.out.println("Cannot delete warehouse has product or User binded on the warehouse");
					}
				case 9: // set warehouse user
					setUsertoWareHouse(connect, preparedStatement, resultSet);
					break;
				case 10:// import product by excel file
				case 11:// logout
					break;
			}
		} else if (!userSession.getRoleName().equals("Admin")) {
			UserMenu();
			choice = Integer.parseInt(bufferedReader.readLine());
			switch (choice){
				case 1: // view all products in warehouse
				case 2: // import product by excel file
				case 3: //log out:
					break;
			}
		} else if (userSession == null) {
			System.exit(0);
		}
	}

	//login- done
//		login(connect, preparedStatement, resultSet);
/*		//get roles-done
		getRoles(connect, preparedStatement, resultSet);*/


	private static void login(Connect connect, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException, IOException {
		System.out.println("Login screen ");
		System.out.print("Input username: ");
		String userName = bufferedReader.readLine();

		System.out.print("input password: ");
		String password = bufferedReader.readLine();

		if (userName.equals("Admin")) {

			sqlquery = "Select u.USERID, r.ROLENAME " +
					"From WAREHOUSE_USER u, WAREHOUSE_ROLE r " +
					"Where   u.ROLEID = r.ROLEID" +
					"    AND u.USERNAME = '" + userName + "'" +
					"    AND u.PASSWORD = '" + password + "'";
		} else {
			sqlquery = "Select u.USERID, r.ROLENAME,w.WAREHOUSEID " +
					"From WAREHOUSE_USER u, WAREHOUSE_ROLE r, WAREHOUSE w " +
					"Where   u.ROLEID = r.ROLEID" +
					"    AND u.WAREHOUSEID = w.WAREHOUSEID" +
					"    AND u.USERNAME = '" + userName + "'" +
					"    AND u.PASSWORD = '" + password + "'";
		}

		connect.openConnect();
		preparedStatement = connect.getConn().prepareStatement(sqlquery);
		resultSet = preparedStatement.executeQuery();
		try {
			if (resultSet.isBeforeFirst()) {
				while (resultSet.next()) {
					if (!userName.equals("Admin")) {
						userSession = new User(
								resultSet.getInt("USERID"),
								resultSet.getString("ROLENAME"),
								resultSet.getInt("WAREHOUSEID")
						);
					} else {

						userSession = new User(
								resultSet.getInt("USERID"),
								resultSet.getString("ROLENAME")
						);
					}
					System.out.println(userSession.getUserID() + " " + userSession.getRoleName() + " " + userSession.getWareHouseID());
				}
			} else System.out.println("wrong username or password");
		} finally {
			if (connect != null) connect.closeConnect();
			if (preparedStatement != null) preparedStatement.close();
			if (resultSet != null) resultSet.close();
		}
	}

	// get Roles
	private static void getRoles(Connect connect, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {

		sqlquery = "select * from WAREHOUSE_ROLE";

		connect.openConnect();
		preparedStatement = connect.getConn().prepareStatement(sqlquery);
		resultSet = preparedStatement.executeQuery();
		try {
			if (resultSet.isBeforeFirst()) {
				int index = 1;
				while (resultSet.next()) {
					System.out.println(index + " " + resultSet.getString("ROLENAME"));
					index++;
				}
			} else System.out.println("ko thấy role :D");
		} finally {
			if (connect != null) connect.closeConnect();
			if (preparedStatement != null) preparedStatement.close();
			if (resultSet != null) resultSet.close();
		}
	}

	// get view all user
	private static void getUsers(Connect connect, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
		sqlquery = "select u.USERID, u.USERNAME, u.PASSWORD, r.ROLENAME, w.WAREHOUSENAME " +
				"from WAREHOUSE_USER u " +
				"full outer join WAREHOUSE_ROLE r on u.ROLEID = r.ROLEID " +
				"full outer join WAREHOUSE w on u.WAREHOUSEID = w.WAREHOUSEID";
		connect.openConnect();
		preparedStatement = connect.getConn().prepareStatement(sqlquery);
		resultSet = preparedStatement.executeQuery();
		try {
			if (resultSet.isBeforeFirst()) {
				while (resultSet.next()) {
					System.out.println(
							resultSet.getString("USERID") + " " +
									resultSet.getString("USERNAME") + " " +
									resultSet.getString("PASSWORD") + " " +
									resultSet.getString("ROLENAME") + " " +
									resultSet.getString("WAREHOUSENAME"));
				}
			} else System.out.println("có gi do sai sai :D ");
		} finally {
			if (connect != null) connect.closeConnect();
			if (preparedStatement != null) preparedStatement.close();
			if (resultSet != null) resultSet.close();
		}
	}

	private static void createUser(Connect connect, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException, IOException {
		System.out.print("Input new username for the user: ");
		String userName = bufferedReader.readLine();
		System.out.print("Input new password for the user: ");
		String password = bufferedReader.readLine();
		int roleid = 0;
		CheckPoint:
		for (; ; ) {
			System.out.print("Input role for the user (1. admin, 2. User): ");
			roleid = Integer.parseInt(bufferedReader.readLine());
			if (roleid == 1 || roleid == 2) {
				break CheckPoint;
			} else {
				System.out.println("invalid input");
			}
		}
		sqlquery = "insert into WAREHOUSE_USER (USERNAME,PASSWORD,ROLEID)" +
				"    values ('" + userName + "', '" + password + "'," + roleid + ")";
		connect.openConnect();
		preparedStatement = connect.getConn().prepareStatement(sqlquery);
		resultSet = preparedStatement.executeQuery();

		if (connect != null) connect.closeConnect();
		if (preparedStatement != null) preparedStatement.close();
		if (resultSet != null) resultSet.close();

	}

	private static void updateUser(Connect connect, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException, IOException {
		getUsers(connect, preparedStatement, resultSet);
		int userID;
		CheckPoint:
		for (; ; ) {
			System.out.print("input UserID need update: ");
			userID = Integer.parseInt(bufferedReader.readLine());
			if (userID == 1) {
				System.out.println("You cannot update on Admin");
				continue CheckPoint;
			} else if (userID != 1) {
				break CheckPoint;
			}
		}

		System.out.print("input new username: ");
		String username = bufferedReader.readLine();

		System.out.print("input new password: ");
		String password = bufferedReader.readLine();
		sqlquery = "Update WAREHOUSE_USER " +
				"set USERNAME ='" + username + "', PASSWORD = '" + password + "'" +
				"where USERID =" + userID + "";
		connect.openConnect();
		preparedStatement = connect.getConn().prepareStatement(sqlquery);
		resultSet = preparedStatement.executeQuery();

		if (connect != null) connect.closeConnect();
		if (preparedStatement != null) preparedStatement.close();
		if (resultSet != null) resultSet.close();
	}

	private static void deleteUser(Connect connect, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException, IOException {
		getUsers(connect, preparedStatement, resultSet);
		int userID;
		CheckPoint:
		for (; ; ) {
			System.out.print("input UserID need  delete: ");
			userID = Integer.parseInt(bufferedReader.readLine());
			if (userID == 1) {
				System.out.println("You cannot delete on Admin");
				continue CheckPoint;
			} else if (userID != 1) {
				break CheckPoint;
			}
		}
		// check the User is owned warehouse or his warehouse is empty.
		sqlquery = "select *" +
				"from WAREHOUSE_USER u " +
				"full outer join WAREHOUSE w on u.WAREHOUSEID = w.WAREHOUSEID " +
				"full outer join WAREHOUSE_PRODUCT p on w.WAREHOUSEID = p.WAREHOUSEID " +
				"where   USERID =" + userID + " ";
		connect.openConnect();
		preparedStatement = connect.getConn().prepareStatement(sqlquery);
		resultSet = preparedStatement.executeQuery();

		if (resultSet.isBeforeFirst()) {
			while (resultSet.next()) {
				int user = resultSet.getInt("USERID");
				int warehouseID = resultSet.getInt("WAREHOUSEID");
				int productID = resultSet.getInt("PRODUCTID");
				if (warehouseID == 0 && productID == 0 || warehouseID != 0 && productID == 0) {
					deleteUserbyID(connect, preparedStatement, resultSet, user);
					deleteWareHousebyID(connect, preparedStatement, resultSet, productID);
				} else {
					deleteUserbyID(connect, preparedStatement, resultSet, user);
				}
			}
			if (connect != null) connect.closeConnect();
			if (preparedStatement != null) preparedStatement.close();
			if (resultSet != null) resultSet.close();


		}
}
	private static void deleteUserbyID(Connect connect, PreparedStatement preparedStatement, ResultSet resultSet,
											int id) throws SQLException, IOException{

		sqlquery = "delete from WAREHOUSE_USER where USERID =" + id +"";
		connect.openConnect();
		preparedStatement = connect.getConn().prepareStatement(sqlquery);
		resultSet = preparedStatement.executeQuery();
		if (connect != null) connect.closeConnect();
		if (preparedStatement != null) preparedStatement.close();
		if (resultSet != null) resultSet.close();
	}
	private static void deleteWareHousebyID(Connect connect, PreparedStatement preparedStatement, ResultSet resultSet,
									int warehoudID) throws SQLException, IOException{

		sqlquery = "delete from WAREHOUSE where WAREHOUSEID =" + warehoudID +"";
	connect.openConnect();
	preparedStatement = connect.getConn().prepareStatement(sqlquery);
	resultSet = preparedStatement.executeQuery();
	if (connect != null) connect.closeConnect();
	if (preparedStatement != null) preparedStatement.close();
	if (resultSet != null) resultSet.close();
}
	private static void getWareHouses(Connect connect, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {

		sqlquery = "select * from WAREHOUSE";

		connect.openConnect();
		preparedStatement = connect.getConn().prepareStatement(sqlquery);
		resultSet = preparedStatement.executeQuery();
		try {
			if (resultSet.isBeforeFirst()) {
				int index = 1;
				while (resultSet.next()) {
					System.out.println(index + " " + resultSet.getString("WAREHOUSENAME"));
					index++;
				}
			} else System.out.println("có gì đó sai sai");
		} finally {
			if (connect != null) connect.closeConnect();
			if (preparedStatement != null) preparedStatement.close();
			if (resultSet != null) resultSet.close();
		}
	}

	private static void createWarehouse(Connect connect, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException, IOException {
		System.out.print("Input new warehouse: ");
		String warehouse = bufferedReader.readLine();
		sqlquery = "insert into WAREHOUSE (WAREHOUSENAME)" +
				"    values ('" + warehouse + "')";
		connect.openConnect();
		preparedStatement = connect.getConn().prepareStatement(sqlquery);
		resultSet = preparedStatement.executeQuery();

		if (connect != null) connect.closeConnect();
		if (preparedStatement != null) preparedStatement.close();
		if (resultSet != null) resultSet.close();

	}

	private static void updateWareHouse(Connect connect, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException, IOException {
		getWareHouses(connect, preparedStatement, resultSet);
		System.out.print("input warehouseid need update: ");
		int id = Integer.parseInt(bufferedReader.readLine());

		System.out.print("input new warehouse name: ");
		String warehouse = bufferedReader.readLine();

		sqlquery = "Update WAREHOUSE " +
				"set WAREHOUSENAME ='" + warehouse + "' " +
				"where WAREHOUSEID =" + id + "";
		connect.openConnect();
		preparedStatement = connect.getConn().prepareStatement(sqlquery);
		resultSet = preparedStatement.executeQuery();

		if (connect != null) connect.closeConnect();
		if (preparedStatement != null) preparedStatement.close();
		if (resultSet != null) resultSet.close();
	}

	private static void deleteWareHouse(Connect connect, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException, IOException {
		getWareHouses(connect, preparedStatement, resultSet);
		System.out.print("input warehouseid need delete: ");
		int id = Integer.parseInt(bufferedReader.readLine());



		sqlquery = "Delete from WAREHOUSE " +
					"where WAREHOUSEID =" + id + "";
		connect.openConnect();
		preparedStatement = connect.getConn().prepareStatement(sqlquery);
		resultSet = preparedStatement.executeQuery();

		if (connect != null) connect.closeConnect();
		if (preparedStatement != null) preparedStatement.close();
		if (resultSet != null) resultSet.close();
	}

	private static void getWarehouseUsers(Connect connect, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
		sqlquery = "select u.userid, u.username, w.warehouseid, w.warehousename " +
					"from WAREHOUSE_USER u right join WAREHOUSE w " +
					"on w.WAREHOUSEID =u.WAREHOUSEID";
		connect.openConnect();
		preparedStatement = connect.getConn().prepareStatement(sqlquery);
		resultSet = preparedStatement.executeQuery();
		try {
			if (resultSet.isBeforeFirst(		)) {
				while (resultSet.next()) {
					System.out.println(
							resultSet.getString("USERID") + " " +
									resultSet.getString("USERNAME") + " " +
									resultSet.getString("WAREHOUSEID") + " " +
									resultSet.getString("WAREHOUSENAME"));
				}
			} else System.out.println("có gi do sai sai :D ");
		} finally {
			if (connect != null) connect.closeConnect();
			if (preparedStatement != null) preparedStatement.close();
			if (resultSet != null) resultSet.close();
		}
	}

	private static void setUsertoWareHouse(Connect connect, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException,IOException{
		getWarehouseUsers(connect, preparedStatement, resultSet);
		getUsers(connect, preparedStatement, resultSet);

		System.out.print("Input userID: ");
		int userid = Integer.parseInt(bufferedReader.readLine());

		System.out.print("Input warehouse ID: ");
		int warehouseid = Integer.parseInt(bufferedReader.readLine());

		sqlquery = "update WAREHOUSE_USER " +
					"set WAREHOUSEID = "+ warehouseid +" " +
					"where USERID = " + userid + " ";
		connect.openConnect();
		preparedStatement = connect.getConn().prepareStatement(sqlquery);
		resultSet = preparedStatement.executeQuery();
		if (connect != null) connect.closeConnect();
		if (preparedStatement != null) preparedStatement.close();
		if (resultSet != null) resultSet.close();
	}


		//Menu
		private static void AdminMenu () {
			System.out.println("Admin menu");
			System.out.println("1. view users");
			System.out.println("2. Creat User");
			System.out.println("3. Update User");
			System.out.println("4. Delete User");

			System.out.println("5. view warehouses");
			System.out.println("6. Creat warehouse");
			System.out.println("7. Update warehouse");
			System.out.println("8. Delete warehouse");

			System.out.println("9. Set warehouse user");
			System.out.println("10. import products to warehouse by excel file");
			System.out.println("11. logout");
			System.out.print("Your choice: ");
		}

		private static void UserMenu () {
			System.out.println("1. View products in warehouse");
			System.out.println("2. import products to warehouse by excel file");
			System.out.println("3. logout");
			System.out.print("Your choice: ");
		}
	}
