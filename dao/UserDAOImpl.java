package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


import model.User;

public class UserDAOImpl implements UserDAO {

	private static Connection con;
	public static int uid;

	static {
		try {

			con = ConnectorUtility.getCon();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
public int getUid() {
	return this.uid;
}

	@Override
	public boolean signIn(String email, String password) {

		try {
			System.out.println("Reached DAO");
			PreparedStatement pst = con.prepareStatement("select * from user where email = ? and password = ?");
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				this.uid=rs.getInt(1);
				System.out.println(uid);
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean signUp(User user) {
		boolean res = false;
		try {
			PreparedStatement pst = con.prepareStatement("insert into user (email,password,fullname) values (?,?,?)");

			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			pst.setString(3,user.getFullname());
			
			res = (pst.executeUpdate() == 1) ? true : false ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<User> view() throws SQLException {

		ArrayList<User> list = new ArrayList<User>();

//		PreparedStatement pst = con.prepareStatement("select * from user where fullname like ?");
		PreparedStatement pst = con.prepareStatement("select * from user;");
//		pst.setString(1,'%'+name+'%');
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			list.add(new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4)));
		}

		return list;
	
	}

	
}
