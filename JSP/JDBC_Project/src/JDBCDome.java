import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class JDBCDome {
	//获取数据库连接
	private static final String URL = "jdbc:mysql://localhost:3306/db_jdbc?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PWD = "admin";
	public static void update() throws SQLException {//增删改
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//导入驱动，加载具体的驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
			//与数据库建立连接
			conn = DriverManager.getConnection(URL, USER, PWD);
			//发送sql。执行增删改，查
			String sql = "update user set password=123 where id=3";
			String sql1 = "delete from user where username = 'zhangsan'";
			String sql2 = "insert into user values(?,?,?)";
			pstmt = conn.prepareStatement(sql2);//预编译
			
			
			
			pstmt.setInt(1, 4);
			pstmt.setString(2, "jianfei");
			pstmt.setString(3, "123");
			int count = pstmt.executeUpdate();
			System.out.println("操作成功："+count);
			
		
		} catch (ClassNotFoundException e) {
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
	public static void query() throws SQLException {//查
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//导入驱动，加载具体的驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
			//与数据库建立连接
			conn = DriverManager.getConnection(URL, USER, PWD);
			//登录；
			Scanner input = new Scanner(System.in);
			//System.out.println("请输入用户ID：");
			System.out.println("请输入用户名：");
			String name = input.nextLine();
			System.out.println("请输入密码：");
			String pwd = input.nextLine();
			//编写sql语句；
			String sql = "select count(*) from user where username=? and password=?";
			//预编译
			pstmt = conn.prepareStatement(sql);
			//赋值
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			//执行
			rs = pstmt.executeQuery();
			//是否操作成功判断
			int count = -1;
			if(rs.next()) {
				count = rs.getInt(1);
			}
			if(count>0) {
				System.out.println("登陆成功！");
			}else {
				System.out.println("登陆失败！");
			}
			
		
			
			
		
		} catch (ClassNotFoundException e) {
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
	public static void procedure() throws SQLException {//查
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		try {
			//导入驱动，加载具体的驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
			//与数据库建立连接
			conn = DriverManager.getConnection(URL, USER, PWD);
			//登录；


			CallableStatement cstmt = conn.prepareCall("{CALL myproc()}");
			//赋值
//			pstmt.setString(1, name);
//			pstmt.setString(2, pwd);
			//执行
			cstmt.execute();
			//int result = cstmt.getInt(1);
			
			//System.out.println(result);
		
		
			
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				conn.close();
			  //  cstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			update();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			query();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			procedure();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
