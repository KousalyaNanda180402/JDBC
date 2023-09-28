package com.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class One {
	static Scanner sc=new Scanner(System.in);
	static Connection con;
	static int opt;

	public static void main(String[] args) {
		One obj=new One();
		// TODO Auto-generated method stub
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/One", "root", "root");
			//System.out.println("Enter your option");
			//int opt=Integer.parseInt(sc.nextLine());
			System.out.println("Enter your option 1.insert 2.read 3.update 4.delete : ");
			opt=Integer.parseInt(sc.next());
			while(opt!=0){
			switch(opt){
				case 1:
					obj.insertData();
					break;
				case 2:
					obj.readData();
					break;
				case 3:
					obj.updateData();
					break;
				case 4:
					obj.deleteEmp();
					break;
				default:
					obj.chouseOption();	
			}
			System.out.println("Enter your option 1.insert 2.read 3.update 4.delete : ");
			opt=sc.nextInt();
			}
		}catch(Exception e) {
			System.out.println("Unable to connect");
		}
		
		
		

		}
		private void chouseOption() {
			// TODO Auto-generated method stub
			
		}
		private void insertData() throws SQLException {
			String sql_st="insert into emp values(?,?,?)";
			PreparedStatement st=con.prepareStatement(sql_st);
			
			System.out.println("Enter Emp Id:");
			int empId=Integer.parseInt(sc.nextLine());
			st.setInt(1, empId);
			
			System.out.println("Enter Emp Name");
			st.setString(2, sc.nextLine());
			
			System.out.println("Enter Emp Salary:");
			st.setInt(3, Integer.parseInt(sc.nextLine()));
			
			int row=st.executeUpdate();
			if(row>0) {
				System.out.println("Data Inserted");
			}
			else {
				System.out.println("Not Inserted");
			}
			
		}
		
		private void readData() {
			try {
				Statement st=con.createStatement();
				System.out.println("Enter Emp Id:");
				int empId=sc.nextInt();
				String sql_St="select * from emp where eid="+empId;
				ResultSet rs=st.executeQuery(sql_St);
				if(rs.next()) {
					int eid=rs.getInt(1);
					String ename=rs.getString(2);
					int esal = rs.getInt(3);
					System.out.println("Emp Id:"+eid+"-Emp Name:"+ename+"-E Salary"+esal);
				}
				else {
					System.out.println("No Data");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Data Displayed");
		}
		
		private void updateData() throws SQLException{
			System.out.println("choose which to update 1.name 2.sal 3.id");
			int x=sc.nextInt();
			switch(x) {
			case 1:String sql="Update emp set ename=? where eid=?";
			PreparedStatement s=con.prepareStatement(sql);
			System.out.println("enter the ename set value : ");
			String s1=sc.next();
			s.setString(1,s1);
			System.out.println("update the row of eid : ");
			int j=sc.nextInt();
			s.setInt(2, j);
			int r=s.executeUpdate();
			if(r>0) {
				System.out.println("Data Updated");	
			}
			else {
				System.out.println("Data not Updated");
				}
			break;
			
			case 2:String sq="Update emp set esal=? where eid=?";
			PreparedStatement ps=con.prepareStatement(sq);
			System.out.println("enter the esal set value : ");
			int s2=sc.nextInt();
			ps.setInt(1,s2);
			System.out.println("update the row of eid : ");
			int i=sc.nextInt();
			ps.setInt(2, i);
			int r1=ps.executeUpdate();
			if(r1>0) {
				System.out.println("Data Updated");	
			}
			else {
				System.out.println("Data not Updated");
				}
			break;
			case 3:String sq1="Update emp set esal=? where eid=?";
			PreparedStatement ps1=con.prepareStatement(sq1);
			System.out.println("enter the eid set value : ");
			int s3=sc.nextInt();
			ps1.setInt(1,s3);
			System.out.println("update the row of eid : ");
			int k=sc.nextInt();
			ps1.setInt(2, k);
			int r2=ps1.executeUpdate();
			if(r2>0) {
				System.out.println("Data Updated");	
			}
			else {
				System.out.println("Data not Updated");
				}
			break;
			}
			/*
			String sql="Update emp set ?=? where eid=?";
			PreparedStatement s=con.prepareStatement(sql);
			System.out.println("enter col name to be modified like ename, esal, eid : ");
			String s1=sc.nextLine();
			s.setString(1,s1);
			System.out.println("enter the set value : ");
			if(s1=="eid" || s1=="esal") {
				int i=sc.nextInt();
				s.setInt(2,i);
			}
			else if(s1=="ename") {
				String s2=sc.nextLine();
				s.setString(2,s2);
			}
			System.out.println("update the row of eid : ");
			int j=sc.nextInt();
			s.setInt(3, j);
			int r=s.executeUpdate();
			if(r>0) {
				System.out.println("Data Updated");	
			}
			else {
				System.out.println("Data not Updated");
				}
				*/
			
		}
		
		private void deleteEmp() throws SQLException {
			System.out.println("choose option : 1. Delete entire table 2. Delete the Selected row ");
			int c=sc.nextInt();
			switch(c) {
			
			case 1: Statement st=con.createStatement();
			String sql_St="delete from emp";
			int r=st.executeUpdate(sql_St);
			if(r>0) {
				System.out.println("entire table deleted");
			}
			else {
				System.out.println("entire table not deleted");
			}
			break;
			
			case 2:String sql_st="delete from emp where eid=?";
			PreparedStatement s=con.prepareStatement(sql_st);
			System.out.println("Enter eid to be deleted :");
			int y=sc.nextInt();
			s.setInt(1, y);
			int p=s.executeUpdate();
			if(p>0) {
				System.out.println("deleted");
			}
			else {
				System.out.println("not deleted");
			}
			break;
			default:System.out.println("Choose correctly");
				
			
			}
		}


	}
		

	
