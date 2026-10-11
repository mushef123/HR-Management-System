package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import javax.servlet.jsp.*;
public class FormIDTagHandler extends TagSupport
{
public int doStartTag()
{
String formId=UUID.randomUUID().toString();
pageContext.setAttribute(formId,formId,pageContext.SESSION_SCOPE);
JspWriter jw=pageContext.getOut();
try
{
jw.print("<input type='hidden'  id='formId' name='formId' value='"+formId+"'>");
}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}


return super.SKIP_BODY;
}
public int doEndTag()
{
return super.EVAL_PAGE;
}
}