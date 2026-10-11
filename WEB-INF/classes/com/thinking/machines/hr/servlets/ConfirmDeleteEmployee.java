package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.math.*;
import java.text.*;
public class ConfirmDeleteEmployee extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)
    {
        try
        {
        String employeeId=request.getParameter("employeeId");
        
            RequestDispatcher requestDispatcher;
        if(employeeId==null || employeeId.length()==0)
        {
          requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
            requestDispatcher.forward(request,response);
            return;
        }
        EmployeeDTO employeeDTO=new EmployeeDTO();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(employeeId);
        try
        {
            EmployeeDAO employeeDAO=new EmployeeDAO();
            employeeDTO=employeeDAO.getByEmployeeId(employeeId);
            EmployeeBean employeeBean=new EmployeeBean();
            employeeBean.setEmployeeId(employeeDTO.getEmployeeId());
            employeeBean.setName(employeeDTO.getName());
            employeeBean.setDesignationCode(employeeDTO.getDesignationCode());
            employeeBean.setDesignation(employeeDTO.getDesignation());
            employeeBean.setDateOfBirth(simpleDateFormat.format(employeeDTO.getDateOfBirth()));
            employeeBean.setGender(employeeDTO.getGender());
            employeeBean.setBasicSalary(employeeDTO.getBasicSalary().toPlainString());
            employeeBean.setIsIndian(employeeDTO.getIsIndian());
            
            employeeBean.setPanNumber(employeeDTO.getPANNumber());
            employeeBean.setAadharCardNumber(employeeDTO.getAadharCardNumber());
request.setAttribute("employeeBean",employeeBean);
requestDispatcher=request.getRequestDispatcher("/ConfirmDeleteEmployee.jsp");
requestDispatcher.forward(request,response);
        }catch(DAOException daoException)
        {
            System.out.println(daoException.getMessage());
          requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
            requestDispatcher.forward(request,response);
            return;



        }



        }catch(Exception exception)
        {
            System.out.println(exception.getMessage());
          RequestDispatcher requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
 try
 {
            requestDispatcher.forward(request,response);
            return;
 }catch(Exception ee)
 {
    //do nothing
 }
        }   
    }
}