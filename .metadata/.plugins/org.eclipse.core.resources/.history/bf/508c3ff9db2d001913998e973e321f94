import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		UserBean userBean = new UserBean();
		userBean.setUserId("UR7705");
		userBean.setPassword("PS7705");
		userBean.setName("Rohan");
		userBean.setIncorrectAttempts(0);
		userBean.setLockStatus(0);
		userBean.setUserType("Admin");
		
		String addStatus = addUser(userBean);
		
		System.out.println(addStatus);

	}
	
	public static String addUser(UserBean bean) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sk6785","sho987");
		
		String sql = "insert into userrecord values(?,?,?,?,?,?)";
		
		
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getUserId());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getIncorrectAttempts());
			pstmt.setInt(5, bean.getLockStatus());
			pstmt.setString(6, bean.getUserType());
			
			int result = pstmt.executeUpdate();
			
			if(result>0)
			{
				return "Success";
			}
			else{
				return "Fail";
			}
			
	}

}
