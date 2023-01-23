package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DataAccess {
	public String ConnectionString;

	  private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	  private ResultSet resultSet = null;
	 
	  public DataAccess(String connectionString, int connectionTimeout) {
	    this.ConnectionString = connectionString;
	    DriverManager.setLoginTimeout(connectionTimeout);
	  }
	  
	  public String ReturnAsString(String query, Object[] parameter) {
		    String returnValue = null;

		    try {
		      Class.forName(JDBC_DRIVER);

		      // Create new connection along with prepared-statement
		      try (Connection connection = DriverManager.getConnection(this.ConnectionString);
		          PreparedStatement statement = connection.prepareStatement(query)) {

		        // Insert parameter into prepared statement
		        if (parameter != null && parameter.length > 0)
		          for (int i = 0; i < parameter.length; i++)
		            statement.setObject(i + 1, parameter[i]);

		        // Iterate through result
		        resultSet = statement.executeQuery();
		        if (resultSet.next()) {
		          returnValue = resultSet.getString(1);
		        }

		        resultSet.close();
		      } catch (Exception ex) {
		        ex.printStackTrace();
		      }
		    } catch (ClassNotFoundException e) {
		      e.printStackTrace();
		    }

		    return returnValue;
		  }
	  
	  public int ReturnAsInt(String query, Object[] parameter) {
		    int returnValue = 0;

		    try {
		      Class.forName(JDBC_DRIVER);

		      // Create new connection along with prepared-statement
		      try (Connection connection = DriverManager.getConnection(this.ConnectionString);
		          PreparedStatement statement = connection.prepareStatement(query)) {

		        // Insert parameter into prepared statement
		        if (parameter != null && parameter.length > 0)
		          for (int i = 0; i < parameter.length; i++)
		            statement.setObject(i + 1, parameter[i]);

		        // Iterate through result
		        resultSet = statement.executeQuery();
		        if (resultSet.next()) {
		          returnValue = resultSet.getInt(1);
		        }

		        resultSet.close();
		      } catch (Exception ex) {
		        ex.printStackTrace();
		      }
		    } catch (ClassNotFoundException e) {
		      e.printStackTrace();
		    }

		    return returnValue;
		  }
	  public boolean ExecuteNonQuery(String query, Object[] parameter) {
		    boolean returnValue = true;

		    try {
		      Class.forName(JDBC_DRIVER);

		      // Create new connection along with commit status
		      try (Connection connection = DriverManager.getConnection(this.ConnectionString)) {
		        connection.setAutoCommit(false);

		        try (PreparedStatement statement = connection.prepareStatement(query)) {
		          // Insert parameter into prepared statement
		          if (parameter != null && parameter.length > 0)
		            for (int i = 0; i < parameter.length; i++)
		              statement.setObject(i + 1, parameter[i]);

		          statement.executeUpdate();
		          connection.commit();
		        } catch (Exception ex2) {
		          ex2.printStackTrace();

		          try {
		            connection.rollback();
		          } catch (Exception ex3) {
		            ex3.printStackTrace();
		          }

		          returnValue = false;
		        }
		      } catch (Exception ex) {
		        ex.printStackTrace();

		        returnValue = false;
		      }

		    } catch (ClassNotFoundException e) {
		      e.printStackTrace();
		      returnValue = false;
		    }

		    return returnValue;
		  }
}
