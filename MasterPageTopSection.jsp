<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Guard>
<jsp:forward page='/LoginForm.jsp'/>
</tm:Guard>

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
<a method='post' href='/styletwo/index.jsp'><img src='/styletwo/images/logo.png' class='Logo'></a><div class='Brand-Name'>Thinking Machines</div>
<div class='User-Name'>
<img src='/styletwo/images/user.png'>
${userName}&nbsp;
<a href='/styletwo/logout'>Logout</a>
</div>
</div><!--header section ends here-->
<!--content Section Starts here-->


<div class='Content-Section'>
<!--left panel starts here-->
<div class='Content-Left-Panel'>
<tm:If condition='${Module==DESIGNATION}'>
<b>Designations</b><br>
</tm:If>
<tm:If condition='${Module!=DESIGNATION}'>
<a href='/styletwo/Designations.jsp'>Designations</a><br>
</tm:If>
<tm:If condition='${Module==EMPLOYEE}'>
<b>Employees</b><br>

</tm:If>
<tm:If condition='${Module!=EMPLOYEE}'>

<a href='/styletwo/Employees.jsp'>Employees</a><br>
</tm:If>
<tm:If condition='${Module!=HOME}'>
<br>
<a href='/styletwo/index.jsp'>Home</a>
</tm:If>
</div><!--left panel ends here-->
<!--right Panel starts here-->
<div class='Content-Right-Panel'>
