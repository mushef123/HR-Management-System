package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class AddDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
HttpSession session=request.getSession();
DesignationBean designationBean=(DesignationBean)request.getAttribute("designationBean");
String title=designationBean.getTitle();
DesignationDTO designationDTO=new DesignationDTO();
designationDTO.setTitle(title);
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();

try
{
designationDAO.add(designationDTO);
designationBean.setCode(designationDTO.getCode());
MessageBean messageBean=new MessageBean();
messageBean.setHeading("Designation (AddModule)");
messageBean.setMessage("Designation Added wants to Add More ?");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(true);
messageBean.setButtonOneText("Yes");
messageBean.setButtonOneAction("DesignationAddForm.jsp");
messageBean.setButtonTwoText("No");
messageBean.setButtonTwoAction("Designations.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);

}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/DesignationAddForm.jsp");

try
{
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
try
{
requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
System.out.println("something happen: "+exception.getMessage());
requestDispatcher.forward(request,response);
}catch(Exception e)
{
System.out.println(e.getMessage());
}
}

}catch(Exception e)
{
e.printStackTrace();
System.out.println(e.getMessage());
}

}
}