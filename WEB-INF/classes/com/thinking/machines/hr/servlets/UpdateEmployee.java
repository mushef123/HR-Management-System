    package com.thinking.machines.hr.servlets;
    import com.thinking.machines.hr.dl.*;
    import com.thinking.machines.hr.beans.*;
    import javax.servlet.http.*;
    import javax.servlet.*;
    import java.math.*;
    import java.util.*;
    import java.text.*;

    
    public class UpdateEmployee extends HttpServlet
    {
        public void doGet(HttpServletRequest request,HttpServletResponse response)
    {
        try
        {
        EmployeeBean employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
        String employeeId=employeeBean.getEmployeeId();
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
    RequestDispatcher requestDispatcher;
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    try
    {
    boolean panNumberExists=employeeDAO.panNumberExists(panNumber);
    boolean aadharCardNumberExists= employeeDAO.aadharCardNumberExists(aadharCardNumber);
    String panEmployeeId=employeeDAO.getByPANNumber(panNumber).getEmployeeId();
    String aadharEmployeeId=employeeDAO.getByAadharCardNumber(aadharCardNumber).getEmployeeId();
        if( panNumberExists && employeeId.equals(panEmployeeId)==false)
        {
            ErrorBean errorBean=new ErrorBean();
            errorBean.setPanNumberErrorSection("inValid PAN Number");
            request.setAttribute("errorBean",errorBean);
           
            requestDispatcher=request.getRequestDispatcher("/EmployeeEditForm.jsp");
            requestDispatcher.forward(request,response);
return;
        }
        if(aadharCardNumberExists && employeeId.equals(aadharEmployeeId)==false)
        {
            ErrorBean errorBean=new ErrorBean();
            errorBean.setAadharCardNumberErrorSection("Invalid Aadhar Card Number");
            request.setAttribute("errorBean",errorBean);
                requestDispatcher=request.getRequestDispatcher("/EmployeeEditForm.jsp");
            requestDispatcher.forward(request,response);
return;

        }

    employeeDTO=new EmployeeDTO();
    employeeDTO.setEmployeeId(employeeId);
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
 employeeDAO.update(employeeDTO);
    MessageBean messageBean=new MessageBean();
    messageBean.setHeading("Employee (Update Module)");
    messageBean.setMessage("Employee Updated");
    messageBean.setGenerateButtons(true);

    messageBean.setButtonOneText("Ok");
    messageBean.setButtonOneAction("/Employees.jsp");
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