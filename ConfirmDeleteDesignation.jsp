<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>

<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>
<tm:Module name='DESIGNATION'/>
<script src='/styletwo/js/ConfirmDeleteDesignation.js'></script>
<jsp:include page='/MasterPageTopSection.jsp'/>
<h2>Designation (delete Module)</h2>
<form method='post' action='/styletwo/DeleteDesignation.jsp' onsubmit='return validateForm(this)'>
<input type='hidden' name='code' id='code' value='${designationBean.code}'>
Designation: <b>${designationBean.title}</b><br><br>
Are you sure you want to delete this designation ?<br>
<button type='submit'>delete</button>
<button type='Button' onclick='CancelAddition()'>Cancel</button>
</form>





<form id='cancelButtonAddition' action='/styletwo/designations.jsp'></form>
<jsp:include page='/MasterPageBottomSection.jsp'/>
