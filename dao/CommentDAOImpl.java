package dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import model.Comment;


public class CommentDAOImpl implements CommentDAO {
	private static Connection con;

	static {
		try {

			con = ConnectorUtility.getCon();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	@Override
	public int insert(Comment comment) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("insert into comment (comment_body,post_id,user_id) values(?,?,?)");
			pst.setString(1, comment.getComment_body());
			pst.setInt(2, comment.getPost_id());
			pst.setInt(3, comment.getUser_id());
		
			res = pst.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(Comment comment) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("update comment set comment_body = ? where comment_id = ?");
			pst.setString(1, comment.getComment_body());
			pst.setInt(2, comment.getComment_id());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int comment_id) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("delete from comment where comment_id = ?");
			pst.setInt(1, comment_id);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public List<Comment> view(int post_id) throws SQLException {
		List<Comment> list = new ArrayList<Comment>();

		PreparedStatement pst = con.prepareStatement("select * from comment where post_id = ?");
		pst.setInt(1, post_id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			list.add(new Comment(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
		}
System.out.println("comment body:"+list);
		return list;
	}
}