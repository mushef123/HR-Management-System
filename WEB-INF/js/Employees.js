function Employee()
{
this.employeeId="";
this.name="";
this.designationCode=0;
this.designation="";
this.dateOfBirth="";
this.gender="";
this.isIndian=true;
this.basicSalary=0;
this.panNumber="";
this.aadharCardNumber="";
}
var employees=[];
var selectedRow=null;
var i;
function SelectEmployee(row,employeeId)
{
if(selectedRow==row)return;
if(selectedRow!=null)
{
selectedRow.style.background='white';
selectedRow.style.color='black';

}
row.style.background='#aabbcc';
row.style.color='white';
selectedRow=row;
for(i=0;i<employees.length;i++)
{
if(employees[i].employeeId==employeeId)
{
break;
}

}
var emp=employees[i];
document.getElementById('detailsPanel_employeeId').innerHTML=emp.employeeId;
document.getElementById('detailsPanel_name').innerHTML=emp.name;
document.getElementById('detailsPanel_designation').innerHTML=emp.designation;
document.getElementById('detailsPanel_dateOfBirth').innerHTML=emp.dateOfBirth;
document.getElementById('detailsPanel_gender').innerHTML=emp.gender;
if(emp.isIndian)
{
document.getElementById('detailsPanel_isIndian').innerHTML='Yes';
}
else
{
document.getElementById('detailsPanel_isIndian').innerHTML='No';

}
document.getElementById('detailsPanel_basicSalary').innerHTML=emp.basicSalary;
document.getElementById('detailsPanel_panNumber').innerHTML=emp.panNumber;
document.getElementById('detailsPanel_aadharCardNumber').innerHTML=emp.aadharCardNumber;

}

    function createDynamicRowClickHandler(rowAddress,employeeId)
    {
        return function()
        {
            SelectEmployee(rowAddress,employeeId);
        };
    }
function populateEmployeeGridTable()
{
var employeeGridTable=document.getElementById("EmployeeGridTable");
//alert(employeeGridTable);
var employeeGridTableBody=employeeGridTable.getElementsByTagName("tbody")[0];
//alert(employeeGridTableBody.innerHTML);
//alert(employees.length);
var employeeGridTableBodyRowTemplate=employeeGridTableBody.getElementsByTagName("tr")[0];
//alert(employeeGridTableBodyRowTemplate.innerHTML);
employeeGridTableBodyRowTemplate.remove();
var employeeGridTableColumnsTemplateCollection=employeeGridTableBodyRowTemplate.getElementsByTagName("td");

//alert(employeeGridTableColumnsTemplateCollection);
var cellTemplate;
var dynamicRow;
var dynamicRowCells;
var placeHolderFor;
var k;
for( k=0;k<employees.length;k++)
{
    dynamicRow=employeeGridTableBodyRowTemplate.cloneNode(true);
    employeeGridTableBody.appendChild(dynamicRow);
    dynamicRowCells=dynamicRow.getElementsByTagName("td");
    for(var i=0;i<dynamicRowCells.length;i++)
{
    cellTemplate=dynamicRowCells[i];
    placeHolderFor=cellTemplate.getAttribute("placeHolderId");
    if(placeHolderFor==null)continue;
    if(placeHolderFor=='serialNumber')cellTemplate.innerHTML=(k+1);
    if(placeHolderFor=='employeeId')cellTemplate.innerHTML=employees[k].employeeId;
    if(placeHolderFor=='name')cellTemplate.innerHTML=employees[k].name;
    if(placeHolderFor=='designation')cellTemplate.innerHTML=employees[k].designation;
    if(placeHolderFor=='designationCode')cellTemplate.innerHTML=employees[k].designationCode;
    if(placeHolderFor=='dateOfBirth')cellTemplate.innerHTML=employees[k].dateOfBirth;
    if(placeHolderFor=='gender')cellTemplate.innerHTML=employees[k].gender;
    if(placeHolderFor=='basicSalary')cellTemplate.innerHTML=employees[k].basicSalary;
    if(placeHolderFor=='panNumber')cellTemplate.innerHTML=employees[k].panNumber;
    if(placeHolderFor=='aadharCardNumber')cellTemplate.innerHTML=employees[k].aadharCardNumber;
    if(placeHolderFor=='editOption')cellTemplate.innerHTML="<a href='/styletwo/editEmployee?employeeId="+employees[k].employeeId+"'>Edit</a>";
    
    if(placeHolderFor=='deleteOption')cellTemplate.innerHTML="<a href='/styletwo/confirmDeleteEmployee?employeeId="+employees[k].employeeId+"'>Delete</a>";
    



}

dynamicRow.onclick=createDynamicRowClickHandler(dynamicRow,employees[k].employeeId);
}



}

window.addEventListener('load',populateEmployeeGridTable);

