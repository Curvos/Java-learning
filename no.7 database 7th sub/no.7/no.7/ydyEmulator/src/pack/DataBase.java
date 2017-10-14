package pack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBase
{
	public static final String user = "root";
	public static final String password = "root";
	private static String sql = "Select * from table_1530416012";
	private static final String driver = "org.gjt.mm.mysql.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/bio2015";// 机房数据库，如不存在请自行创建数据库“bio2015!!”
	// private static final String url =
	// "jdbc:mysql://localhost:3306/user_data";// 本地数据库
	private static Statement stmt;
	public static int rows;
	public static int columns;
	private static final String inLocation = "import" + File.separator + "import_data.txt";
	private static final String exLocation = "export/table_1530416012.txt";

	public static Connection getDataBaseConnection()
	{
		// String driver = "org.gjt.mm.mysql.Driver";
		// String url = "jdbc:mysql://localhost:3306/user_data";

		// 加载驱动程序
		try
		{
			Class.forName(driver);
			// System.out.println("驱动程序加载成功");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		// 链接数据库
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
			{
				System.out.println("连接数据库成功");

				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			}
		} catch (SQLException e)
		{
			System.out.println("链接数据库失败: " + e.getMessage());
			MyWindow.nameField.setText("链接数据库失败");
		}

		return conn;
	}

	// public static List<Map<String, Object>> selectAll(Connection conn) throws
	// SQLException
	// {
	// return convertList(stmt.executeQuery(sql)); // 此处sql需要用static修饰 why？
	// }

	public static Object[][] selectAll(Connection conn) throws SQLException
	{
		return convert(stmt.executeQuery(sql)); // 此处sql需要用static修饰 why？
	}

	// private static List<Map<String, Object>> convertList(ResultSet rs) throws
	// SQLException
	// {// 将ResultSet转换为List
	//
	// List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	//
	// ResultSetMetaData md = rs.getMetaData();
	//
	// int columnCount = md.getColumnCount();
	//
	// while (rs.next())
	// {
	//
	// Map<String, Object> rowData = new HashMap<String, Object>();
	//
	// for (int i = 1; i <= columnCount; i++)
	// {
	//
	// rowData.put(md.getColumnName(i), rs.getObject(i));
	//
	// }
	//
	// list.add(rowData);
	//
	// }
	// return list;
	//
	// }

	private static Object[][] convert(ResultSet rs) throws SQLException
	{

		ResultSetMetaData m = null;
		m = rs.getMetaData();
		rs.last();
		rows = rs.getRow();
		rs.beforeFirst();
		columns = m.getColumnCount();
		// int rows = 20;
		for (int i = 1; i <= columns; i++)
		{
			System.out.print(m.getColumnName(i));
			System.out.print("\t\t");
		}
		System.out.println();
		Object[][] objs = new Object[rows][columns];
		int temp = 0;
		// 显示表格内容
		while (rs.next())
		{

			for (int i = 1; i <= columns; i++)
			{
				objs[temp][i - 1] = rs.getString(i);
				System.out.print(rs.getString(i));
				System.out.print("\t\t");
			}
			temp++;
			System.out.println();
		}

		return objs;
	}

	public static void update(String userString) throws SQLException
	{
		stmt.executeUpdate(userString);
	}

	public static Object[][] query(String userString) throws SQLException
	{
		ResultSet set = null;
		ResultSetMetaData m = null;
		set = stmt.executeQuery(userString);
		m = set.getMetaData();
		set.last();
		rows = set.getRow();
		set.beforeFirst();
		columns = m.getColumnCount();
		// int rows = 20;
		for (int i = 1; i <= columns; i++)
		{
			System.out.print(m.getColumnName(i));
			System.out.print("\t\t");
		}
		System.out.println();
		Object[][] objs = new Object[rows][columns];
		int temp = 0;
		// 显示表格内容
		while (set.next())
		{

			for (int i = 1; i <= columns; i++)
			{
				objs[temp][i - 1] = set.getString(i);
				System.out.print(set.getString(i));
				System.out.print("\t\t");
			}
			temp++;
			System.out.println();
		}
		return objs;
	}

	public static void CreateTable() throws SQLException
	{
		String create = "CREATE TABLE `table_1530416012` (`doc_id` int(11) NOT NULL AUTO_INCREMENT,`password` varchar(32) NOT NULL,`id` varchar(18) NOT NULL,`name` varchar(12) NOT NULL,`doc_status` int(11) NOT NULL,`doc_endDate` date NOT NULL,PRIMARY KEY (`doc_id`)) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;";
		stmt.execute(create);
	}

	public static void Import() throws SQLException, FileNotFoundException
	{
		// File f=new File("res" + File.separator + "dna_data.txt");
		// stmt.execute("load data local infile " + inLocation
		// + " inLoa into table
		// table_1530416012(doc_id,password,id,name,doc_status,doc_endDate)");
		// stmt.execute(
		// "INSERT INTO table_1530416012 SELECT * FROM
		// OPENROWSET('MICROSOFT.JET.OLEDB.4.0','Excel
		// 5.0;HDR=YES;DATABASE=res\table_1530416012.xls',sheet1$)");
		File f = new File(inLocation);
		Scanner scan = new Scanner(new FileReader(f));
		while (scan.hasNext())
		{
			stmt.execute(scan.nextLine());
		}
		scan.close();
		// stmt.execute("INSERT INTO `table_1530416012` VALUES
		// (1,'12345','370211198106134438','张三',2,'2017-08-03');");
	}

	public static void Export() throws SQLException
	{
		String temp = "/r/n";
		stmt.execute("select doc_id,password,id,name,doc_status,doc_endDate into outfile" + exLocation
				+ " lines terminated by" + temp + " from person;");
	}
}