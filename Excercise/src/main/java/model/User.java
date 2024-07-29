package model;

public class User {
	/**
	 * This model combines 3 essential 3 table user, role, and warehouse
	 * purpose is this model will hold session login, and hold essential
	 * of user.
	 */
	private int userID;
	private String roleName;
	private int wareHouseID ;
	private String wareHouseName;

	public User(){

	}
	//for sesson for admin
	public User(int UserID ,String RoleName){
		this.userID = UserID;
		this.roleName = RoleName;
	}
	//for sesson for user
	public User(int UserID ,String RoleName, int WareHouseID){
		this.userID = UserID;
		this.roleName = RoleName;
		this.wareHouseID = WareHouseID;
	}

	// getter setter section
	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getWareHouseID() {
		return this.wareHouseID;
	}

	public void setWareHouseID(int wareHouseID) {
		this.wareHouseID = wareHouseID;
	}
	public void setWareHouseName( String wareHouseName){
		this.wareHouseName = wareHouseName;
	}
	public String getWareHouseName(){
		return this.wareHouseName;
	}
}
