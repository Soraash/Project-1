package com.mphasis.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.CommentDAOImpl;
import dao.PostDAOImpl;
import dao.UserDAOImpl;
import model.Comment;
import model.Post;
import model.User;


@Controller
public class HomeController {

//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	PostDAOImpl postImpl = new PostDAOImpl();
	CommentDAOImpl commentImpl = new CommentDAOImpl();
	UserDAOImpl userImpl = new UserDAOImpl();
	static int post_id;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "/resources/login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView signIn(@ModelAttribute("email") String email, @ModelAttribute("password") String password) {
		ModelAndView view1= new ModelAndView("/resources/login");
		boolean res = userImpl.signIn(email, password);
		if (res) {
			ModelAndView view = new ModelAndView("/resources/home");
			return view;
		} else {
			return view1;
		}
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signUp(@ModelAttribute("fullname") String fullname, @ModelAttribute("email") String email,
			@ModelAttribute("password") String password, @ModelAttribute("repass") String repass) {
		ModelAndView view = new ModelAndView("/resources/signup");
		if (password.equals(repass)) {
			boolean res = userImpl.signUp(new User(0, email, password, fullname));
			if(res) {
				ModelAndView view1 = new ModelAndView("/resources/home");
			return view1;
			}
			else {
				return view;
			}
		} else {
			return view;
		}
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView viewPosts() {
		
		
		ModelAndView view = new ModelAndView("home");
		
		return view;
	}
	@RequestMapping(value = "/addpost", method = RequestMethod.POST)
	public ModelAndView addPost(@ModelAttribute("postTitle") String postTitle,@ModelAttribute("postBody") String postBody) {
		System.out.println("addPost reached");
		ModelAndView view = new ModelAndView("/resources/home");
		UserDAOImpl user=new UserDAOImpl();
		int user_id = user.getUid();
		System.out.println("title:"+postTitle+"postBody:"+postBody);
		int res = postImpl.insert(new Post(0,postTitle,postBody,user_id));
		if(res==1) {
	
		return view;
		}else {
			return view;
		}
	}
	@RequestMapping(value = "/deletePost", method = RequestMethod.POST)
	public ModelAndView deletePost(@ModelAttribute("postId") int postId) {
		System.out.println("deletePost reached");
		ModelAndView view = new ModelAndView("/resources/myprofile");
		UserDAOImpl user=new UserDAOImpl();
		int user_id = user.getUid();
		System.out.println("Id:"+postId);
		int res = postImpl.delete(postId);
		if(res==1) {
		return view;
		
		}else {
			return view;
		}
	}
	@RequestMapping(value = "/searchPost", method = RequestMethod.POST)
	public ModelAndView searchPost(@ModelAttribute("postTitle") String postTitle) {
		System.out.println("deletePost reached");
		String postTitle1=" ";
		postTitle1=postTitle;
		ModelAndView view = new ModelAndView("/resources/search");
	
		System.out.println("Id:"+postTitle1);
		List<Post> list= postImpl.viewbyTitle(postTitle1);
		view.addObject("list", list);
			return view;
		
	}
	@RequestMapping(value = "/comments", method = RequestMethod.POST)
	public ModelAndView searchPostbyId(@ModelAttribute("postId") int postId) throws SQLException {
		System.out.println("commentPost reached");
		
		ModelAndView view = new ModelAndView("/resources/comments");
		System.out.println("Id:"+postId);
		
		this.post_id=postId;
		
			Post post= postImpl.viewbyId(postId);
			ArrayList commentlist= (ArrayList) commentImpl.view(postId);

			// TODO Auto-generated catch block
		
		System.out.println("Post:"+post);
		view.addObject("post", post);
		view.addObject("commentlist",commentlist);
			return view;
	}
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public ModelAndView searchPostbyId(@ModelAttribute("commentBody") String commentBody) throws SQLException {
		System.out.println("commentPost reached");
		CommentDAOImpl comment= new CommentDAOImpl();
		UserDAOImpl user=new UserDAOImpl();
		int user_id = user.getUid();
		int commentId= comment.insert(new Comment(0,commentBody,user_id,this.post_id));
		ModelAndView view = new ModelAndView("/resources/comments");

			return view;
		
	}
}
