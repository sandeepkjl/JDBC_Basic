import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		String[] usersName = getNames();
		
		for(int i=0; i<usersName.length; i++)
		{
	
			System.out.println(usersName[i]);
		}
		
		
	

	}
	
	public static String[] getNames() throws ClassNotFoundException, SQLException
	{
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sk6785","sho987");
		
		String sql = "select Name from userrecord";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<String> userNames = new ArrayList<String>();
		
		while(rs.next())
		{

			userNames.add(rs.getString(1));
		}
		
		String[] names = new String[userNames.size()];
		 names=userNames.toArray(names);
		
		 return names;
	}

}
