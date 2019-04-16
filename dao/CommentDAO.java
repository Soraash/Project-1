package dao;

import java.sql.SQLException;
import java.util.List;

import model.Comment;

public interface CommentDAO {

	int insert(Comment comment);
	int update(Comment comment);
	int delete(int comment_id);
	List<Comment> view(int post_id) throws SQLException;
	

}