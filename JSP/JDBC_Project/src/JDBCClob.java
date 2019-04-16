import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCClob {
	private static final String URL = "jdbc:mysql://localhost:3306/db_jdbc?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PWD = "admin";
	public static void clob() throws SQLException {//增删改
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//导入驱动，加载具体的驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
			//与数据库建立连接
			conn = DriverManager.getConnection(URL, USER, PWD);
			//发送sql。执行增删改，查
			String sql = "insert into clob values(?,?) ";
			
			pstmt = conn.prepareStatement(sql);//预编译
			pstmt.setInt(1, 6);
			File file= new File("D:\\eclipse-workspace\\JDBC_Project\\src\\test.txt");
			InputStream in = new FileInputStream(file);
			try {
				Reader reader =new InputStreamReader(in,"GBK");
				pstmt.setCharacterStream(2,reader,file.length());
				pstmt.executeUpdate();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		} catch (ClassNotFoundException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				conn.close();
			    pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			clob();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}