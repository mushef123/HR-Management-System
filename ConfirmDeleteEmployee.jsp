<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean'/>

<tm:Module name='EMPLOYEE'/>
<jsp:include page='MasterPageTopSection.jsp'/>
<h2>Employee (Delete Module)</h2>
<form action='/styletwo/DeleteEmployee.jsp' onsubmit='return validateForm(this)'>

<input type='hidden' id='employeeId' name='employeeId' value='${employeeBean.employeeId}'>
<table>
<tr>
<td>EmployeeId: </td>
<td><b>${employeeBean.employeeId}</b> </td>
</tr>
<tr>
<td>Name: </td>
<td><b>${employeeBean.name}</b></td>
</tr>
<tr>
<td>Designation: </td>
<td><b>${employeeBean.designation}</b>
</tr>
<tr>
<td>Date Of Birth: </td>
<td><b>${employeeBean.dateOfBirth}</b></td>
</tr>
<tr>

<td>Gender: </td>
<td><b>${employeeBean.gender=='M'? 'Male':'Female'}</b></td>  
</tr>
<tr>
<td>Basic Salary: </td>
<td><b>${employeeBean.basicSalary}</b></td>
</tr>
<tr>

<td>indian: </td>
<td><b>${employeeBean.isIndian}</b></td>
</tr>
<tr>
<td>PAN Number: </td>
<td><b>${employeeBean.panNumber}</b></td>
</tr>
<tr>
<td>Aadhar Card Number: </td>
<td><b>${employeeBean.aadharCardNumber}</b><td>
</tr>
</table>
<br>

Are you sure,you want to delete this Employee ?<br>
&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;

<button type='submit'>Yes</button>

<button type='Button' onclick='CancelAddition()'>No</button>
</form>	







<form id='cancelButtonAddition' action='/styletwo/Employees.jsp'></form>

<jsp:include page='MasterPageBottomSection.jsp'/>