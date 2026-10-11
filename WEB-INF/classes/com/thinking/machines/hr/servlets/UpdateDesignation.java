package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
DesignationBean designationBean;
designationBean=(DesignationBean)request.getAttribute("designationBean");
DesignationDTO designationDTO;
designationDTO=new DesignationDTO();
designationDTO.setCode(designationBean.getCode());
designationDTO.setTitle(designationBean.getTitle());
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
MessageBean messageBean;
try
{
designationDAO.update(designationDTO);
messageBean=new MessageBean();
messageBean.setHeading("Designation (Update Module)");
messageBean.setMessage("Designation Updated");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("/Designations.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
 requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
try
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/DesignationEditForm.jsp");

requestDispatcher.forward(request,response);
}catch(Exception ee)
{
System.out.println(ee.getMessage());
}
}catch(Exception e)
{
System.out.println(e.getMessage());
}







}
}