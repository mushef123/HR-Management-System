package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.beans.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class NotifyFormResubmission extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
MessageBean messageBean=new MessageBean();
messageBean.setHeading("Notification");
messageBean.setMessage("You can not be refresh the browser");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("/index.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
// do nothing
}
}


}
}