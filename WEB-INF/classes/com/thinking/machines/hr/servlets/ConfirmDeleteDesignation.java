package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ConfirmDeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
{
int code=Integer.parseInt(request.getParameter("code"));
DesignationDTO designationDTO;
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
DesignationBean designationBean=new DesignationBean();
try
{
designationDTO=designationDAO.getByCode(code);
designationBean.setCode(designationDTO.getCode());
designationBean.setTitle(designationDTO.getTitle());
request.setAttribute("designationBean",designationBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/ConfirmDeleteDesignation.jsp");
requestDispatcher.forward(request,response);


}catch(DAOException daoException)
{
try
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
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