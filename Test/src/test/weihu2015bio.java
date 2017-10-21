package db;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class weihu2015bio extends JDialog {
	private JTextField textField;
	private JTextField txtLiman;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			weihu2015bio dialog = new weihu2015bio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public weihu2015bio() {
		setBounds(100, 100, 702, 552);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u589E\u52A0\u5B66\u751F\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				
				String url="jdbc:mysql://localhost:3306/bio2015";  
				Connection con=null;
				 Statement stmt=null;
				 ResultSet rs=null;
				 boolean moreRecords=false;
				 try {
					con=DriverManager.getConnection(url,"root","root");
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				
				try {
					stmt = con.createStatement();
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				// create insert sql
				String idstr=textField.getText();
				String namestr=txtLiman.getText();
				
				String insertSql="insert into bioinfo values("+idstr+","+"'"+namestr+"'"+");";
				    try {
						 int result=stmt.executeUpdate(insertSql);
						 if(result==0){
							 textField_1.setText("增加信息失败！！");
						 }
						 else{
							 textField_1.setText("增加信息成功！！");
						 }
					} catch (SQLException ee) {
						// TODO 自动生成的 catch 块
						ee.printStackTrace();
					} 
				    
				    
				    
				    
				
			}
		});
		btnNewButton.setBounds(36, 334, 116, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539\u5B66\u751F\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				
				String url="jdbc:mysql://localhost:3306/bio2015";  
				Connection con=null;
				 Statement stmt=null;
				 ResultSet rs=null;
				 boolean moreRecords=false;
				 try {
					con=DriverManager.getConnection(url,"root","root");
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				
				try {
					stmt = con.createStatement();
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				// create insert sql
				String idstr=textField.getText();
				String namestr=txtLiman.getText();
				
				//String insertSql="insert into bioinfo values("+idstr+","+"'"+namestr+"'"+");";
				String updateSql="update bioinfo set name="+"'"+namestr+"'"+" where id="+idstr+";";
				    try {
						 int result=stmt.executeUpdate(updateSql);
						 if(result==0){
							 textField_1.setText("修改信息失败！！");
						 }
						 else{
							 textField_1.setText("修改信息成功！！");
						 }
					} catch (SQLException ee) {
						// TODO 自动生成的 catch 块
						ee.printStackTrace();
					} 
				    
				
			}
		});
		btnNewButton_1.setBounds(189, 334, 105, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664\u5B66\u751F\u4FE1\u606F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				
				String url="jdbc:mysql://localhost:3306/bio2015";  
				Connection con=null;
				 Statement stmt=null;
				 ResultSet rs=null;
				 boolean moreRecords=false;
				 try {
					con=DriverManager.getConnection(url,"root","root");
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				
				try {
					stmt = con.createStatement();
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				// create insert sql
				String idstr=textField.getText();
				String namestr=txtLiman.getText();
				
				String deleteSql="delete FROM bioinfo where id="+idstr+";";
				    try {
						 int result=stmt.executeUpdate(deleteSql);
						 if(result==0){
							 textField_1.setText("删除信息失败！！");
						 }
						 else{
							 textField_1.setText("删除信息成功！！");
						 }
					} catch (SQLException ee) {
						// TODO 自动生成的 catch 块
						ee.printStackTrace();
					} 
				    
				
			}
		});
		btnNewButton_2.setBounds(337, 334, 105, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u67E5\u8BE2\u5B66\u751F\u4FE1\u606F");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				
				String url="jdbc:mysql://localhost:3306/bio2015";  
				Connection con=null;
				 Statement stmt=null;
				 ResultSet rs=null;
				 boolean moreRecords=false;
				 try {
					con=DriverManager.getConnection(url,"root","root");
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				
				try {
					stmt = con.createStatement();
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				// create insert sql
				String idstr=textField.getText();
				String namestr=txtLiman.getText();
				
				String selectSql=" SELECT name,id FROM bioinfo where id="+idstr+";";
				try {
					 rs=stmt.executeQuery(selectSql);
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				} 
			    
			    try {
					moreRecords = rs.next();
					if(moreRecords){
						textField_1.setText("有该学生的信息");
						String name=rs.getString("name");
				    	int id=rs.getInt("id");
				    	//System.out.println("name:"+name+" age:"+age);
				    	
				    	txtLiman.setText(""+name);
				    }
					else{
						textField_1.setText("没有该学生的信息");						
					}
				} catch (SQLException ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBounds(476, 334, 116, 23);
		getContentPane().add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setText("2015001");
		textField.setBounds(134, 81, 66, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(39, 84, 54, 15);
		getContentPane().add(lblId);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(39, 122, 54, 15);
		getContentPane().add(lblNewLabel);
		
		txtLiman = new JTextField();
		txtLiman.setText("liman");
		txtLiman.setBounds(134, 119, 66, 21);
		getContentPane().add(txtLiman);
		txtLiman.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7ED3\u679C\u4FE1\u606F");
		lblNewLabel_1.setBounds(39, 398, 54, 15);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(507, 398, 126, 83);
		getContentPane().add(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(123, 395, 220, 64);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
