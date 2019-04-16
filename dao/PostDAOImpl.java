package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Post;

public class PostDAOImpl implements PostDAO {

	private static Connection con;

	static {
		try {

			con = ConnectorUtility.getCon();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public int insert(Post post) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("insert into posts (post_title,post_body,user_id) values(?,?,?)");
			pst.setString(1, post.getPost_title());
			pst.setString(2, post.getPost_body());
			pst.setInt(3, post.getUser_id());
			res = pst.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return res;
	}



@Override
public int update(Post post) {
	int res = -1;
	try {
		PreparedStatement pst = con.prepareStatement("update posts set post_title = ?, post_body = ? where post_id = ?");
		pst.setString(1, post.getPost_title());
		pst.setString(2, post.getPost_body());
		pst.setInt(3, post.getPost_id());
		res = pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return res;
}

@Override
public int delete(int post_id) {
	int res = -1;
	try {
		PreparedStatement pst = con.prepareStatement("delete from posts where post_id = ?");
		pst.setInt(1, post_id);
		res = pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return res;
}
@Override
public Post viewPost(int post_id) {
	
	Post post = new Post();

	try {
		PreparedStatement pst = con.prepareStatement("select * from posts where post_id = ?");
		pst.setInt(1, post_id);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			post =new Post(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return post;
	
}


@Override
public List<Post> view() throws SQLException {

	ArrayList<Post> list = new ArrayList<Post>();

	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select * from posts");
	while (rs.next()) {
		list.add(new Post(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4)));
	}
	System.out.println("List added:" +list);
	return list;
}

@Override
public List<Post> viewbyUser(int user_id) {

	ArrayList<Post> list = new ArrayList<Post>();

	try {
		PreparedStatement pst = con.prepareStatement("select * from posts where user_id = ?");
		pst.setInt(1, user_id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			list.add(new Post(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}
@Override
public List<Post> viewbyTitle(String postTitle) {
	
	ArrayList<Post> list = new ArrayList<Post>();

	try {
		PreparedStatement pst = con.prepareStatement("select * from posts where post_title like ?");
		pst.setString(1,"%"+postTitle+"%");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			list.add(new Post(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	System.out.println("Searched List: "+list);
	return list;
	
}
public Post viewbyId(int postId) {
	Post post = new Post();

	try {
		PreparedStatement pst = con.prepareStatement("select * from posts where post_id = ?");
		pst.setInt(1, postId);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			post=new Post(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	System.out.println("Searched Post: "+post);
	return post;
	
	
}
}