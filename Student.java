package assignment1;

import java.sql.*; 

public class Student {

	public static void main(String[] args) throws SQLException { 
		
		try {
		// Connect to database
		Connection conn = null;
		String connectionURL = "jdbc:mysql://localhost:3306/db1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=TRUE&useSSL=FALSE";
		
		conn = DriverManager.getConnection(connectionURL, "root", "**ABCDEF123456**");
	
		// Create a statement to retrieve objects
		Statement s = conn.createStatement();        

		// Retrieve results from the table
		ResultSet rs = s.executeQuery ("Select * from Student"); 
		
		// Print columns headers
		ResultSetMetaData rsmd =rs.getMetaData(); 
		int i =rsmd.getColumnCount( );
		
		for(int j=1; j<=i; j++) { 
			System.out.print(rsmd.getColumnName(j)+"\t\t"); 
		} 
		System.out.println("\r");

		// Print records
		while(rs.next( ) ) { 
			for(int j=1; j<=i; j++) 
			{ 
				System.out.print (rs.getString(j)+"     "+"\t");
				if(j%3 == 0)
					System.out.println("\r");
			}
		}
		}catch (Exception o) {
			System.out.println(o.getMessage());
		}
	}
}