<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>

<tm:Module name='EMPLOYEE'/>
<script src='/styletwo/js/EmployeeEditForm.js'></script>
<jsp:include page='MasterPageTopSection.jsp'/>
<h2>Employee(Edit Module)</h2>
<form action='/styletwo/UpdateEmployee.jsp' onsubmit='return validateForm(this)'>

<input type='hidden' id='employeeId' name='employeeId' value='${employeeBean.employeeId}'>
<table>
<tr>
<td>Name</td>
<td><input type='text' id='name' name='name' maxlength='50' size='51' value='${employeeBean.name}'>
<span id='nameErrorSection' class='error'></span></td>
</tr>
<tr>
<td>Designation</td>
<td><select id='designationCode' name='designationCode' >

<option value='-1'>&lt;Designation&gt;</option>
<tm:EntityList populatorClass='com.thinking.machines.hr.bl.DesignationBL' populatorMethod='getAll' name='designationBean'>
<option value='${designationBean.code}' ${designationBean.code==employeeBean.designationCode ? 'selected':''}>${designationBean.title}</option>

</tm:EntityList>

</select>

<span id='designationCodeErrorSection' class='error'></span></td>
</tr>
<tr>
<td>Date Of Birth</td>
<td><input type='Date' id='dateOfBirth' name='dateOfBirth' value='${employeeBean.dateOfBirth}'>
<span id='dateOfBirthErrorSection' class='error'></span></td>
</tr>
<tr>

<td>Gender</td>
<td> Male
<input type='radio' id='male' name='gender' value='M' ${employeeBean.gender=='M' ? 'checked':'' }>
Female
<input type='radio' id='female' name='gender' value='F' ${employeeBean.gender=='F' ? 'checked':''}>
<span id='genderErrorSection' class='error'></span></td>
</tr>
<tr>
<td>Basic Salary</td>
<td><input type='text' style="text-align:right;" id='basicSalary' name='basicSalary' value='${employeeBean.basicSalary}'>
<span id='basicSalaryErrorSection' class='error'></span></td>
</tr>
<tr>

<td>indian</td>
<td><input type='checkbox' id='isIndian' name='isIndian' value="true" ${employeeBean.isIndian ? 'checked' : ''}></td>
</tr>
<tr>
<td>PAN number</td>
<td><input type='text' id='panNumber' name='panNumber' maxlength='15' size='16' value='${employeeBean.panNumber}'>
<span id='panNumberErrorSection' class='error'>
${errorBean.panNumberErrorSection}
</span></td>
</tr>
<tr>
<td>Aadhar Card Number</td>
<td><input type='text' id='adharCardNumber' name='aadharCardNumber' maxlength='15' size='16' value='${employeeBean.aadharCardNumber}'>

<span id='aadharCardNumberErrorSection' class='error'>
${errorBean.aadharCardNumberErrorSection}

</span><td>
</tr>
</table>
&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;

<button type='submit'>Update</button>

<button type='Button' onclick='CancelAddition()'>Cancel</button>
</form>	







<form id='cancelButtonAddition' action='/styletwo/Employees.jsp'></form>

<jsp:include page='MasterPageBottomSection.jsp'/>