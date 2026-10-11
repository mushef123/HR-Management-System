function validateForm(frm)
{
var name=frm.name.value.trim();
var nameErrorSection=document.getElementById('nameErrorSection');
nameErrorSection.innerHTML='';
var valid=true;
var focusIdentify=null;
if(name.length==0)
{
nameErrorSection.innerHTML='required';
focusIdentify=frm.name;
valid=false;
}
var designationCode=frm.designationCode.value.trim();
var designationCodeErrorSection=document.getElementById('designationCodeErrorSection');
designationCodeErrorSection.innerHTML='';
if(designationCode==-1)
{
designationCodeErrorSection.innerHTML='Designation required';
if(focusIdentify==null)focusIdentify=frm.designationCode;
valid=false;

}
var dateOfBirth=frm.dateOfBirth.value;
var dateOfBirthErrorSection=document.getElementById('dateOfBirthErrorSection');
dateOfBirthErrorSection.innerHTML='';
if(dateOfBirth.length==0)
{
dateOfBirthErrorSection.innerHTML='select Date Of Birth';
if(focusIdentify==null)focusIdentify=frm.dateOfBirth;
valid=false;
}




 
var gender=frm.gender;
var genderErrorSection=document.getElementById('genderErrorSection');
genderErrorSection.innerHTML='';
if(gender[0].checked==false && gender[1].checked==false)
{
genderErrorSection.innerHTML='Gender required';
valid=false;
}

var basicSalary=frm.basicSalary.value.trim();
var basicSalaryErrorSection=document.getElementById('basicSalaryErrorSection');
basicSalaryErrorSection.innerHTML='';


if(basicSalary.length==0)
{
basicSalaryErrorSection.innerHTML='Basic Salary required';
if(focusIdentify==null)focusIdentify=frm.basicSalary;
valid=false;

}
else
{
var e='0123456789.';
var isDot=true;
for(var i=0;i<basicSalary.length;i++)
{
if(e.indexOf(basicSalary.charAt(i))==-1)
{
basicSalaryErrorSection.innerHTML='invalid BasicSalary';
if(focusIdentify==null)focusIdentify=frm.basicSalary;
valid=false;
isDot=false;
break;
}
}
if(isDot)
{
var dot=basicSalary.indexOf('.');
if(dot!=-1)
{
var numberOfFraction=basicSalary.length-(dot+1);
if(numberOfFraction>2)
{
basicSalaryErrorSection.innerHTML='invalid BasicSalary';
if(focusIdentify==null)focusIdentify=frm.basicSalary;
valid=false;
}
}
}

}


var panNumber=frm.panNumber.value.trim();
var panNumberErrorSection=document.getElementById('panNumberErrorSection');
panNumberErrorSection.innerHTML='';
if(panNumber.length==0)
{
panNumberErrorSection.innerHTML='PAN number required';
if(focusIdentify==null)focusIdentify=frm.panNumber;
valid=false;
}
var aadharCardNumber=frm.aadharCardNumber.value.trim();
var aadharCardNumberErrorSection=document.getElementById('aadharCardNumberErrorSection');
aadharCardNumberErrorSection.innerHTML='';
if(aadharCardNumber.length==0)
{
aadharCardNumberErrorSection.innerHTML='aadhar Card Number required';
if(focusIdentify==null)focusIdentify=frm.aadharCardNumber;
valid=false;
}

focusIdentify.focus();
return valid;
}
function CancelAddition()
{
document.getElementById('cancelButtonAddition').submit();
}

