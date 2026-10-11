package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
HttpSession session=request.getSession();
AdministratorBean administratorBean;
administratorBean=(AdministratorBean)request.getAttribute("administratorBean");
if(administratorBean==null)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError("username/password invalid");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;

}
String userName=administratorBean.getUserName();
String password=administratorBean.getPassword();
AdministratorDTO administrator;
try
{
administrator=new AdministratorDAO().getByUserName(userName);
if(password.equalsIgnoreCase(administrator.getPassword())==false)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError("Password: "+password+" is Invalid");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;

}
session.setAttribute("userName",userName);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/index.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
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

}catch(Exception e)
{
System.out.println(e.getMessage());
}

}
}
}