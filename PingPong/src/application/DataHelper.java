package application;

public class DataHelper {
	public static DataAccess Query = new DataAccess(
		      "jdbc:mysql://localhost:3306/userpingpong?useSSL=false&autoReconnect=true&user=pingponguser&password=password",
		      20);
}
