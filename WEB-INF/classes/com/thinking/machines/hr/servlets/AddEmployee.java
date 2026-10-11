    package com.thinking.machines.hr.servlets;
    import com.thinking.machines.hr.dl.*;
    import com.thinking.machines.hr.beans.*;
    import javax.servlet.http.*;
    import javax.servlet.*;
    import java.math.*;
    import java.util.*;
    import java.text.*;

    
    public class AddEmployee extends HttpServlet
    {
        public void doGet(HttpServletRequest request,HttpServletResponse response)
    {
        try
        {
        EmployeeBean employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
        String name=employeeBean.getName();
        int designationCode=employeeBean.getDesignationCode();
        String designation=employeeBean.getDesignation();
        String dateOfBirth=employeeBean.getDateOfBirth();
        String gender=employeeBean.getGender();
        boolean isIndian=employeeBean.getIsIndian();
        String basicSalary=employeeBean.getBasicSalary();
        String panNumber=employeeBean.getPanNumber();
        String aadharCardNumber=employeeBean.getAadharCardNumber();
        EmployeeDAO employeeDAO=new EmployeeDAO();
        EmployeeDTO employeeDTO;
System.out.println(isIndian);
    RequestDispatcher requestDispatcher;
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    try
    {
    boolean panNumberExists=employeeDAO.panNumberExists(panNumber);
    boolean aadharCardNumberExists= employeeDAO.aadharCardNumberExists(aadharCardNumber);
if(panNumberExists && aadharCardNumberExists)
        {
           ErrorBean errorBean=new ErrorBean();
            errorBean.setPanNumberErrorSection("Invalid PANnumber");
            errorBean.setAadharCardNumberErrorSection("Invalid AadharCard Number");
            request.setAttribute("errorBean",errorBean);
            requestDispatcher=request.getRequestDispatcher("/EmployeeAddForm.jsp");
            requestDispatcher.forward(request,response);
return;
        }
        if(panNumberExists)
        {
            ErrorBean errorBean=new ErrorBean();
            errorBean.setPanNumberErrorSection("invalid PANNumber");
            request.setAttribute("errorBean",errorBean);
          
            requestDispatcher=request.getRequestDispatcher("/EmployeeAddForm.jsp");
            requestDispatcher.forward(request,response);
return;
        }
        if(aadharCardNumberExists)
        {
            ErrorBean errorBean=new ErrorBean();
            errorBean.setAadharCardNumberErrorSection(" invalid aadharCardNumber");
            request.setAttribute("errorBean",errorBean);
                requestDispatcher=request.getRequestDispatcher("/EmployeeAddForm.jsp");
            requestDispatcher.forward(request,response);
return;

        }

    employeeDTO=new EmployeeDTO();
    employeeDTO.setName(name);
    employeeDTO.setDesignationCode(designationCode);
    employeeDTO.setDesignation(designation);
try
{
    employeeDTO.setDateOfBirth(simpleDateFormat.parse(dateOfBirth));
}catch(ParseException pe)
{
    System.out.println(pe.getMessage());
}
if(gender.equals("M"))
{
    employeeDTO.setGender("M");
}else
{
    employeeDTO.setGender("F");

}

    employeeDTO.setBasicSalary(new BigDecimal(basicSalary));

employeeDTO.setIsIndian(isIndian);
   employeeDTO.setPANNumber(panNumber);
    employeeDTO.setAadharCardNumber(aadharCardNumber);
 employeeDAO.add(employeeDTO);
    MessageBean messageBean=new MessageBean();
    messageBean.setHeading("Employee (Add Module)");
    messageBean.setMessage("Employee Added want to Add More ?");
    messageBean.setGenerateButtons(true);

    messageBean.setButtonOneText("Yes");
    messageBean.setButtonOneAction("/EmployeeAddForm.jsp");
    messageBean.setGenerateTwoButtons(true);
    messageBean.setButtonTwoText("No");
    messageBean.setButtonTwoAction("/Employees.jsp");
    request.setAttribute("messageBean",messageBean);
    requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
    requestDispatcher.forward(request,response);





    }catch(DAOException daoException)
    {
    System.out.println(daoException.getMessage());
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