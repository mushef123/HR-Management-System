    package com.thinking.machines.hr.servlets;
    import com.thinking.machines.hr.dl.*;
    import com.thinking.machines.hr.beans.*;
    import javax.servlet.http.*;
    import javax.servlet.*;
    import java.math.*;
    import java.util.*;
    import java.text.*;

    
    public class EditEmployee extends HttpServlet
    {
        public void doGet(HttpServletRequest request,HttpServletResponse response)
    {
        try
        {
		String employeeId=request.getParameter("employeeId");
        EmployeeDTO employeeDTO=new EmployeeDTO();
        EmployeeDAO employeeDAO=new EmployeeDAO();
        EmployeeBean employeeBean=new EmployeeBean();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            employeeDTO=employeeDAO.getByEmployeeId(employeeId);
            employeeBean.setEmployeeId(employeeId);
            employeeBean.setName(employeeDTO.getName());
            employeeBean.setDesignationCode(employeeDTO.getDesignationCode());
            employeeBean.setDesignation(employeeDTO.getDesignation());
            employeeBean.setDateOfBirth(simpleDateFormat.format(employeeDTO.getDateOfBirth()));
            employeeBean.setGender(employeeDTO.getGender());
            employeeBean.setIsIndian(employeeDTO.getIsIndian());
            employeeBean.setBasicSalary(employeeDTO.getBasicSalary().toPlainString());
            employeeBean.setPanNumber(employeeDTO.getPANNumber());
            employeeBean.setAadharCardNumber(employeeDTO.getAadharCardNumber());
            request.setAttribute("employeeBean",employeeBean);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/EmployeeEditForm.jsp");
            requestDispatcher.forward(request,response);

            




        

    }catch(DAOException daoException)
    {
    System.out.println(daoException.getMessage());
            RequestDispatcher requestDispatcher;
            requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
            requestDispatcher.forward(request,response);

    }


        }catch(Exception exception)
        {
            RequestDispatcher requestDispatcher;
            System.out.println(exception.getMessage());
            requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
           try
           {
            requestDispatcher.forward(request,response);
           }catch(Exception ee)
           {
            System.out.println(ee.getMessage());
           }
        
        }



    }
    }