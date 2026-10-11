package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
DesignationBean designationBean;
designationBean=(DesignationBean)request.getAttribute("designationBean");
DesignationDAO designationDAO=new DesignationDAO();
try
{
designationDAO.delete(designationBean.getCode());
MessageBean messageBean;
messageBean=new MessageBean();
messageBean.setHeading("Designation (delete Module)");
messageBean.setMessage("Designation Deleted");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Designations.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("Notification.jsp");
requestDispatcher.forward(request,response);


}catch(DAOException daoException)
{
try
{
MessageBean messageBean;
messageBean=new MessageBean();
messageBean.setHeading("Designation (delete Module)");
messageBean.setMessage(daoException.getMessage());
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Designations.jsp");
request.setAttribute("messageBean",messageBean);

RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("Notification.jsp");
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
System.out.println(exception.getMessage());

}
}
catch(Exception e)
{
System.out.println(e.getMessage());
}

}
}