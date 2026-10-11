package com.thinking.machines.hr.bl;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import java.util.*;
import java.text.*;
public class EmployeeBL
{
private List<EmployeeBean>employees;

public List<EmployeeBean>getAll()
{
try
{
EmployeeDAO employeeDAO=new EmployeeDAO();
List<EmployeeDTO>DLEmployee=employeeDAO.getAll();
employees=new LinkedList<>();
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
for(EmployeeDTO employee:DLEmployee)
{
EmployeeBean employeeBean=new EmployeeBean();
employeeBean.setEmployeeId(employee.getEmployeeId());
employeeBean.setName(employee.getName());
employeeBean.setDesignationCode(employee.getDesignationCode());
employeeBean.setDesignation(employee.getDesignation());
employeeBean.setDateOfBirth(simpleDateFormat.format(employee.getDateOfBirth()));
employeeBean.setGender(employee.getGender());
employeeBean.setIsIndian(employee.getIsIndian());
employeeBean.setBasicSalary(employee.getBasicSalary().toPlainString());
employeeBean.setPanNumber(employee.getPANNumber());
employeeBean.setAadharCardNumber(employee.getAadharCardNumber());
employees.add(employeeBean);
}
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
return employees;





}


}