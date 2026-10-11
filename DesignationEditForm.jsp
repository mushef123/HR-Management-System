<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>
<script src='/styletwo/js/DesignationEditForm.js'></script>
<tm:Module name='DESIGNATION'/>
<jsp:include page='/MasterPageTopSection.jsp'/>
<h2>Designation (Edit Module)</h2>
<span class='error'>
<jsp:getProperty name='errorBean' property='error' />
 </span>
<form method='post' action='/styletwo/EditDesignation.jsp' onsubmit='return validateForm(this)'>
Designation
<input type='text' id='title' name='title' maxlength='35' size='36' value='${designationBean.title}'>
<span id='titleErrorSection' class='error''></span><br>
<input type='hidden' id='code' name='code' value='${designationBean.code}'>
<button type='submit'>update</button>
<button type='Button' onclick='CancelAddition()'>Cancel</button>
</form>

<form id='cancelButtonAddition' action='/styletwo/designations.jsp'></form>
<jsp:include page='/MasterPageBottomSection.jsp'/>