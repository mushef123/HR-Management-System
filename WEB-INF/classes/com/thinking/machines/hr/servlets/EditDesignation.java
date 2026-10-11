package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class EditDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
int code=Integer.parseInt(request.getParameter("code"));
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
DesignationDTO designationDTO;
DesignationBean designationBean;
designationBean=new DesignationBean();
try
{
designationDTO=designationDAO.getByCode(code);
designationBean.setCode(designationDTO.getCode());
designationBean.setTitle(designationDTO.getTitle());
request.setAttribute("designationBean",designationBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/DesignationEditForm.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
RequestDispatcher requestDispatcher;

requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
}
}catch(Exception exception)
{
//do nothing
}



}
}