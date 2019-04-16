<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Post"%>
<%@ page import="dao.UserDAOImpl"%>
<%@ page import="dao.PostDAOImpl"%>

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
    <script src="js/homepage.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC|Gloria+Hallelujah|Satisfy|Shadows+Into+Light" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
    <link rel="stylesheet" href="css/homepage.css">
    <style>
    <style>
/* Remove the navbar's default margin-bottom and rounded borders */
.fa {
	font-size: 40px;
	padding: 20px;
	border-radius: 50%;
}

@
keyframes magnifyicons { 0% {
	transform: translateY(50%) scale(1);
}

50%
{
transform


:

 

translateY


(0%)
scale


(1
.5


);
}
100%
{
transform


:

 

translateY


(50%)
scale


(1);
}
}
.rotateI {
	animation: magnifyicons 3s infinite 0s linear;
}

@
keyframes magnifycards1 { 0% {
	transform: scale(1);
}

50%
{
transform


:

 

scale


(1
.07


);
}
100%
{
transform


:

 

scale


(1);
}
}
.magnifycards {
	animation: magnifycards1 1s infinite 0s linear;
}

@media ( max-width :425px) {
	.carousel {
		height: 300px;
	}
	.carousel-caption {
		bottom: 300px !important;
	}
	.img1 {
		min-height: 262px;
	}
}

input {
	color: black;
}

.fa:hover {
	box-shadow: 0px 0px 20px black;
	transition-duration: .4s;
	background-color: white;
	transition-duration: 1s;
}

.card-body:hover {
	background-color: white;
	color: black;
	box-shadow: 0px 0px 20px black;
	transition-duration: 1s;
}

.fa-android {
	color: green;
}

.fa-github {
	color: grey;
}

.fa-youtube {
	color: rgb(109, 0, 0);
}

.fa-amazon {
	color: rgb(180, 87, 0)
}

.fa-facebook {
	color: rgb(0, 0, 53);
}

.fa-whatsapp {
	color: green;
}

.fa-css3 {
	color: orange;
}

.fa-html5 {
	color: orangered;
}

.fa-twitter {
	color: rgb(84, 185, 219);
}

img {
	border-radius: 20px;
}

.jumbotron, footer {
	background-color: rgb(54, 54, 54);
}

.card-body {
	background-color: rgb(49, 49, 49);
	padding: 10px;
	border-radius: 20px;
}

.blue {
	color: blue
}

.green {
	color: green;
}

.red {
	color: red;
}

body, html {
	width: 100%;
	height: 100%;
	background-color: rgb(37, 37, 37);
	color: white;
}

.item {
	height: 500px;
}

img:hover {
	box-shadow: 0px 0px 50px rgb(199, 199, 199);
	transition-duration: .5s;
}

.navbar {
	margin-bottom: 0;
	border-radius: 0;
}
/* Add a gray background color and some padding to the footer */
footer {
	padding: 25px;
}

tr:hover {
	background-color: rgba(207, 207, 207, 0.432);
	transition-duration: .5s;
}
</style>
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
                <a class="navbar-brand" style="font-family: 'Berkshire Swash', cursive;" href="#">L-Art.com</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li><a href="home.jsp">Home</a></li>
                    <li ><a href="myprofile.jsp">My Posts</a></li>
                     <li class="active"><a href="#">Search Posts</a></li>

                    <li><input class="form-control" style=" margin-top: 5%;" type="text" placeholder="Search"></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="http://localhost:8080/app/resources/login.jsp"><span class="glyphicon
                                    glyphicon-log-in"></span> Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container-fluid" style="width:100%;">

        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" style="width:100%; height:300px;">
                <div class="item active">
                    <img src="${pageContext.request.contextPath}/resources/images/bg-02.jpg" class="img1" alt="Los
                            Angeles" style="width:100%;">

                </div>

                <div class="item">
                    <img src="${pageContext.request.contextPath}/resources/images/bg-04.jpg" alt="Chicago" style="width:100%;">

                </div>

                <div class="item">
                    <img src="${pageContext.request.contextPath}/resources/images/bg-3.jpg" class="img1" alt="New York" style="width:100%;">

                </div>

            </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    
    <br><br>

  
	<div class="container">
		<div class="jumbotron">
			<h2 class="text-center">Search Post</h2>
			<form action="/app/searchPost" method="post">
				<div class="form-group">
					<label for="formGroupExampleInput">Post Title</label> <input type="text"
						class="form-control" id="formGroupExampleInput" name="postTitle"
						placeholder="Enter the title to be searched">
				</div>
				<button class="btn btn-danger btn-lg">Submit</button>
			</form>
		</div>
	</div>

	<%
// 		List<Post> list = (List<Post>) request.getAttribute("list");
	PostDAOImpl postImpl = new PostDAOImpl();
	UserDAOImpl user=new UserDAOImpl();
	
List<Post> postlist=null;
	postlist  =(List<Post>) request.getAttribute("list");
	%>
	<%
	if(postlist!= null){
		for (Post post : postlist) {
	%>
	<div class="container">
		
			<div class="jumbotron">

				<form>
				<h3 style="display:hidden" name="post_id"><%= post.getPost_id() %></h3>
					<div class="form-group">

						<h2><%=post.getPost_title()%></h2>
					</div>
					<div class="form-group">

						<h4>
							<%=post.getPost_body()%>
						</h4>
					</div>
					<div class="form-group">

						<h4>Posted by user no:
							<%=post.getUser_id()%>
						</h4>
						
					</div>
<!-- 					   <button class="btn btn-primary btn-lg" type="submit"> Edit Post</button> -->
              
					 <a href="http://localhost:8080/app/resources/post.jsp"><button class="btn btn-success btn-md">
							 View Comments</button></a>

				</form>
			</div>
		
	</div>
	<%
		}
	}
	%>
	
	

	
    <div class="container">
        <div class="text-center liner-color">
            <h2>
                Font Awesome Icons
            </h2>
            <div class="row">
                <i class="fa fa-facebook"></i>
                <i class="fa fa-whatsapp"></i>
                <i class="fa fa-css3"></i>
                <i class="fa fa-html5"></i>
                <i class="fa fa-twitter"></i>
                <i class="fa fa-github"></i>
                <i class="fa fa-youtube"></i>
                <i class="fa fa-amazon"></i>
                <i class="fa fa-android"></i>

            </div>
        </div>
    </div>

    <br><br>
    <br><br>
    <br><br>
    <br><br>


    <footer class="container-fluid text-center">
        <p>Footer Text</p>

    </footer>
    <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
    <script>
        AOS.init();
    </script>
</body>


</html>