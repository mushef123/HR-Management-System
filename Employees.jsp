<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE'/>
<jsp:include page='MasterPageTopSection.jsp'/>

<script src='/styletwo/js/Employees.js'></script>

<link rel='stylesheet' type='text/css' href='/styletwo/css/Employees.css'/>
<div class='employeeGrid'>

<table border=1 id='EmployeeGridTable'>
<thead>
<h2>Employees</h2>
<tr>
<th colspan='6' class='employeeGridHeader'>
<a href='/styletwo/EmployeeAddForm.jsp'>Add Employee</a>
</th>
</tr>
<tr>
<th class='employeeGridSNOColumnTitle'>SNO.</th>
<th class='employeeGridIdColumnTitle'>Id.</th>

<th class='employeeGridNameColumnTitle'>Name</th>

<th class='employeeGridDesignationColumnTitle'>Designation</th>
<th class='employeeGridEditColumnTitle'>Edit</th>
<th class='employeeGridDeleteColumnTitle'>Delete</th>
</tr>
</thead>
<tbody>
<tr style='cursor:pointer' >
<td style='text-align:right;' placeHolderId='serialNumber'></td>
<td placeHolderId='employeeId'></td>
<td placeHolderId='name'></td>
<td placeHolderId='designation'></td>
<td style='text-align:center;' placeHolderId='editOption'>
</td>
<td style='text-align:center;' placeHolderId='deleteOption'>
</td>
</tr>
</tbody>
</table>
</div>
<div style='height:11vw;margin-left:5px;margin-right:5px;margin-top:5px;padding:5px;border:1px solid black'>
<label style='background:gray;color:white;padding-right:5px;'>Details</label>
<table width="100%">
<tr>
<td>Employee Id: <span id='detailsPanel_employeeId'></span></td>
<td>Name: <span id='detailsPanel_name'></span></td>
<td>Designation: <span id='detailsPanel_designation'></span></td>
</tr>
<tr>
<td>Date Of Birth: <span id='detailsPanel_dateOfBirth'></span></td>
<td>Gender: <span id='detailsPanel_gender'></span></td>
<td>Indian: <span id='detailsPanel_isIndian'></span></td>
</tr>
<tr>
<td>Basic Salary: <span id='detailsPanel_basicSalary'></span></td>
<td>PAN Number: <span id='detailsPanel_panNumber'></span></td>
<td>Aadhar Card Number: <span id='detailsPanel_aadharCardNumber'></span></td>
</tr>

</table>
</div>
<jsp:include page='/MasterPageBottomSection.jsp'/>