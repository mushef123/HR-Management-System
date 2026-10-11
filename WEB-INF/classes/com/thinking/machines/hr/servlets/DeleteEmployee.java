    package com.thinking.machines.hr.servlets;
    import com.thinking.machines.hr.dl.*;
    import com.thinking.machines.hr.beans.*;
    import javax.servlet.http.*;
    import javax.servlet.*;
    import java.math.*;
    import java.util.*;
    import java.text.*;

    
    public class DeleteEmployee extends HttpServlet
    {
        public void doGet(HttpServletRequest request,HttpServletResponse response)
    {
        try
        {
        EmployeeBean employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
        String employeeId=employeeBean.getEmployeeId();        
        EmployeeDAO employeeDAO=new EmployeeDAO();
        EmployeeDTO employeeDTO;
    RequestDispatcher requestDispatcher;
    
 employeeDAO.deleteByEmployeeId(employeeId);
    MessageBean messageBean=new MessageBean();
    messageBean.setHeading("Employee (Delete Module)");
    messageBean.setMessage("Employee Deleted");
    messageBean.setGenerateButtons(true);

    messageBean.setButtonOneText("Ok");
    messageBean.setButtonOneAction("/Employees.jsp");
    request.setAttribute("messageBean",messageBean);
    requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
    requestDispatcher.forward(request,response);






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