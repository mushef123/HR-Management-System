<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>

<!DOCTYPE HTML>
<head>
<Meta charset='utf-8'>
<title>HR Application</title>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'/>

</head>
<body>
<!--Main Container Starts here-->
<div class='Main-Container'>
<!--header starts here -->
<div class='Header'>
<a href='/styletwo/index.html'><img src='/styletwo/images/logo.png' class='Logo'></a><div class='Brand-Name'>Thinking Machines</div>
</div><!--header section ends here-->
<!--content Section Starts here-->
<div class='Content-Section'>
<div style='width:20hw; height:auto; border:1px solid black;padding:20px;margin-left:300px;margin-right:400px'>
<form method='post' action='/styletwo/Login.jsp' autocomplete='off'>
<table>
<tr>
<td colspan="2" align="center">
<span class='error'>
<jsp:getProperty name='errorBean' property='error'/>
</span>

</td>
</tr>

<tr>
<td>UserName</td>
<td><input type='text' name='userName' id='userName' maxlength='15' size='16'></td>
</tr>
<tr>
<td>Password</td>
<td><input type='password' name='password' id='password' maxlength='15' size='16' ></td>
</tr>
<tr>
<td colspan="2" align="center">
<button type='submit'>login</button>
</td>
</tr>
</table>
</form>

</div>



</div><!--content Section ends here-->
<!--footer starts here-->
<div class='Footer'>
&copy; Thinking Machines 2026

</div>
<!--footer ends here-->


</div><!--Main Container Ends here-->

</body>
</html>