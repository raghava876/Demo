<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginInfo</title>
</head>
<body>
<h1>Welcome To Login Page</h1>

<form action="LoginServlet" method="post">
<pre>
       <b>Enter User Name:     <input type="text" name="t1"> </b>
       
     <b>  Enter User Password: <input type="Password" name="t2"></b>
        
       <button type="submit">Submit</button>    <button type="button" onclick="logout()">Logout</button>
       
</pre>
</form>

<script>
function logout() {
    // Implement the logout functionality, for example:
    alert("Logout button clicked!");
    // Redirect to logout page or perform other logout actions
    window.location.href = "logout.jsp";  // Assuming you have a logout.jsp
}
</script>

</body>
</html> 