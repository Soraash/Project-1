
package dao;

import java.sql.SQLException;
import java.util.List;

import model.Post;

public interface PostDAO {

	int insert(Post post);
	int update(Post post);
	int delete(int post_id);
	Post viewPost(int post_id);
	List<Post> view() throws SQLException;
	List<Post> viewbyUser(int user_id);
	List<Post> viewbyTitle(String postTitle);
	Post viewbyId(int pid);
}
