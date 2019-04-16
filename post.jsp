<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Post"%>
<%@ page import="model.User"%>
<%@ page import="dao.UserDAOImpl"%>
<%@ page import="dao.PostDAOImpl"%>
<%@ page import="model.Comment"%>
<%@ page import="dao.CommentDAOImpl"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>L-Art.com</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Berkshire+Swash" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="homepage.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC|Gloria+Hallelujah|Satisfy|Shadows+Into+Light" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="animate.css">
    <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
    <link rel="stylesheet" href="homepage.css">
</head>

<body>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                <a class="navbar-brand" style="font-family: 'Berkshire
                        Swash', cursive;" href="#">L-Art.com</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li><a href="hompage.html">Home</a></li>
                    <li class="active"><a href="myProfile.html">My Posts</a></li>

                    <li><input class="form-control" style="margin-top: 5%;" type="text" placeholder="Search"></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.html"><span class="glyphicon
                                    glyphicon-log-in"></span> Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <br><br>


    <div class="container">
        <div class="jumbotron">

            <form>
                <div class="form-group">

                    <h2>Title 1 is written here</h2>
                </div>
                <div class="form-group">

                    <h4>Lorem ipsum dolor sit amet consectetur adipisicing elit. In accusamus ad cum doloribus illo cumque excepturi reprehenderit quia quidem! Labore fugit veniam iste pariatur veritatis id dolore atque natus nemo?
                    </h4>
                </div>
                <button class="btn btn-primary btn-lg"> Edit Post</button>
                <button class="btn btn-danger btn-lg"> Delete</button>

            </form>
        </div>
    </div>
    <%
    PostDAOImpl postImpl = new PostDAOImpl();
    CommentDAOImpl commentImpl = new CommentDAOImpl();
	UserDAOImpl user=new UserDAOImpl();
	int id=user.getUid();
// 	int pid =post.getPostId();
	List<Comment> commentlist = null;
	commentlist = commentImpl.view(id);
	%>
	
    <div class="container">
        <div class="jumbotron">
            <div class="comments">
                <h3>Comments</h3>
                <div class="align-content-center">
                    <h4>User 1</h4>

                </div>
           <% 
 				for (Comment comment : commentlist) {
 				%> 
                <h6> <%= comment.getComment_body() %></h6>
                <button class="btn btn-sm btn-success">Edit</button>&nbsp;<button class="btn btn-sm btn-danger">Delete</button>
                <hr>
                 <%
                 }
                 %> 
                <form>

                    <div class="form-group">
                        <label for="formGroupExampleInput2">Comment</label>
                        <textarea cols="3" class="form-control" id="formGroupExampleInput2" placeholder="Enter the body"></textarea> </div>
                    <button class="btn btn-primary btn-md"> Submit</button>
                </form>
            </div>
        </div>
    </div>

    <br><br>
    <br><br>
    <br><br>
    <br><br>


    <!-- <footer class="container-fluid text-center">
        <p>Footer Text</p>

    </footer> -->
    <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
    <script>
        AOS.init();
    </script>
</body>


</html>