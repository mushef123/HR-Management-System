package com.thinking.machines.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class FormResubmittedTagHandler extends TagSupport
{
public int doStartTag()
{
HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
String formId=request.getParameter("formId");
if(formId==null)
{
return super.EVAL_BODY_INCLUDE;
}
String sessionFormId=(String)pageContext.getAttribute(formId,PageContext.SESSION_SCOPE);
if(sessionFormId==null)
{
return super.EVAL_BODY_INCLUDE;
}
pageContext.removeAttribute(formId,PageContext.SESSION_SCOPE);

if(formId.equals(sessionFormId))
{
return super.SKIP_BODY;
}
else
{
return super.EVAL_BODY_INCLUDE;
}


}
public int doEndTag()
{
return super.EVAL_PAGE;
}
}