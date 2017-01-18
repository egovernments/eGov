<%--
  ~ eGov suite of products aim to improve the internal efficiency,transparency,
  ~    accountability and the service delivery of the government  organizations.
  ~
  ~     Copyright (C) <2015>  eGovernments Foundation
  ~
  ~     The updated version of eGov suite of products as by eGovernments Foundation
  ~     is available at http://www.egovernments.org
  ~
  ~     This program is free software: you can redistribute it and/or modify
  ~     it under the terms of the GNU General Public License as published by
  ~     the Free Software Foundation, either version 3 of the License, or
  ~     any later version.
  ~
  ~     This program is distributed in the hope that it will be useful,
  ~     but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  ~     GNU General Public License for more details.
  ~
  ~     You should have received a copy of the GNU General Public License
  ~     along with this program. If not, see http://www.gnu.org/licenses/ or
  ~     http://www.gnu.org/licenses/gpl.html .
  ~
  ~     In addition to the terms of the GPL license to be adhered to in using this
  ~     program, the following additional terms are to be complied with:
  ~
  ~         1) All versions of this program, verbatim or modified must carry this
  ~            Legal Notice.
  ~
  ~         2) Any misrepresentation of the origin of the material is prohibited. It
  ~            is required that all modified versions of this material be marked in
  ~            reasonable ways as different from the original version.
  ~
  ~         3) This license does not grant any rights to any user of the program
  ~            with regards to rights under trademark law for use of the trade names
  ~            or trademarks of eGovernments Foundation.
  ~
  ~   In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
  --%>

<%@ include file="/includes/taglibs.jsp"%>

<style type="text/css">
.yui-dt table {
	width: 100%;
}

.yui-dt-col-Add {
	width: 5%;
}

.yui-dt-col-Delete {
	width: 5%;
}

body {
	font-size: 14px;
	font-family: regular;
}
</style>
<script src="<cdn:url value='/resources/js/master/contractor.js?rnd=${app_release_no}'/>"></script>

<html>
<head>
<title><s:text name="contractor.header" /></title>
</head>
<body>
	<s:if test="%{hasErrors()}">
		<div class="alert alert-danger fade in">
			<s:actionerror />
			<s:fielderror />
		</div>
	</s:if>
	<s:if test="%{hasActionMessages()}">
		<div class="messagestyle">
			<s:actionmessage theme="simple" />
		</div>
	</s:if>
	<s:form action="contractor-save" theme="simple" name="contractor"
		cssClass="form-horizontal form-groups-bordered">
<s:hidden name="model.id" />
<s:hidden name="id" id="id"/>
<s:hidden name="mode" id="mode" />
<s:hidden name="mandatory" id="mandatory" value = "%{dropdownData.contractorMasterMandatoryFields}" />
<s:hidden name="hide" id="hide" value = "%{dropdownData.contractorMasterHiddenFields}" />

<input type="hidden" id="codeErrorMsg" value="<s:text name='contractor.code.null' />" />
<input type="hidden" id="nameErrorMsg" value="<s:text name='contractor.name.null' />" />
<input type="hidden" id="panNumberErrorMsg" value="<s:text name='contractor.pannumber.null' />" />
<input type="hidden" id="tinNumberErrorMsg" value="<s:text name='contractor.tinnumber.null' />" />
<input type="hidden" id="contactPersonErrorMsg" value="<s:text name='contractor.contactperson.null' />" />
<input type="hidden" id="ifscCodeErrorMsg" value="<s:text name='contractor.ifsccode.null' />" />
<input type="hidden" id="correspondenceAddressErrorMsg" value="<s:text name='contractor.correspondenceAddress.null' />" />
<input type="hidden" id="paymentAddressErrorMsg" value="<s:text name='contractor.paymentAddress.null' />" />
<input type="hidden" id="bankErrorMsg" value="<s:text name='bank.name.null' />" />
<input type="hidden" id="bankAccountNumberErrorMsg" value="<s:text name='contractor.bankaccount.null' />" />
<input type="hidden" id="emailErrorMsg" value="<s:text name='depositworks.roadcut.enter.email' />" />
<input type="hidden" id="narrationMsg" value="<s:text name='contractor.narration.null' />" />
<input type="hidden" id="pwdApprovalCodeErrorMsg" value="<s:text name='contractor.pwdApprovalCode.null' />" />
<input type="hidden" id="exemptionFormErrorMsg" value="<s:text name='contractor.exemptionForm.null' />" />
<input type="hidden" id="emailInvalidErrorMsg" value="<s:text name='contractor.email.null' />" />
<input type="hidden" id="bankAccountAlphaNeumericErrorMsg" value="<s:text name='contractor.bankAccount.alphaNumeric' />" />
<input type="hidden" id="paymentAddressAlphaNeumericErrorMsg" value="<s:text name='contractor.paymentAddress.alphaNumeric' />" />
<input type="hidden" id="correspondenceAddressAlphaNeumericErrorMsg" value="<s:text name='contractor.correspondenceAddress.alphaNumeric' />" />
<input type="hidden" id="ifscCodeAlphaNeumericErrorMsg" value="<s:text name='contractor.ifscCode.alphaNumeric' />" />
<input type="hidden" id="tinNumberAlphaNeumericErrorMsg" value="<s:text name='contractor.tinNumber.alphaNumeric' />" />
<input type="hidden" id="codeAlphaNeumericErrorMsg" value="<s:text name='contractor.code.alphaNumeric' />" />
<input type="hidden" id="nameAlphaNeumericErrorMsg" value="<s:text name='contractor.name.alphaNumeric' />" />
<input type="hidden" id="mobileNumberErrorMsg" value="<s:text name='depositworks.roadcut.invalid.mobileno' />" />
<input type="hidden" id="bankAccountErrorMsg" value="<s:text name='contractor.bankaccount.null' />" />
<input type="hidden" id="registrationNumberErrorMsg" value="<s:text name='contractordetail.registrationnumber.required' />" />
<input type="hidden" id="departmentErrorMsg" value="<s:text name='contractorDetails.department.required' />" />
<input type="hidden" id="contractorClassErrorMsg" value="<s:text name='contractordetail.grade.required' />" />
<input type="hidden" id="startDateErrorMsg" value="<s:text name='contractorDetails.fromDate_empty' />" />
<input type="hidden" id="mobileNumberFormatErrorMsg" value="<s:text name='depositworks.roadcut.invalid.mobileno.length' />" />
<input type="hidden" id="contactPersonAlphaNeumericErrorMsg" value="<s:text name='contractor.contactPerson.alphaNumeric' />" />
<input type="hidden" id="registrationNumberAlphaNeumericErrorMsg" value="<s:text name='contractorDetail.registrationNumber.alphaNumeric' />" />

<input type="hidden" value="<s:text name='contractor.panNumber.alphaNumeric' />" id='panNumberMessage'>
		<%@ include file='contractor-form.jsp'%>
		<p class="text-center">
			<s:if test="%{model.id!=null && mode != 'view'}">
				<s:submit type="submit" cssClass="btn btn-primary" value="Modify"
					id="modifyButton" name="button" method="save" onclick="return validateContractorFormAndSubmit();" />&nbsp;
		</s:if>
			<s:if test="%{model.id==null}">
				<s:submit type="submit" cssClass="btn btn-primary" value="Save"
					id="saveButton" name="button" method="save" onclick="return validateContractorFormAndSubmit();"/>&nbsp;

		</s:if>
			<input type="button" class="btn btn-default" value="Close"
				id="closeButton" name="closeButton" onclick="window.close();" />
		</p>
	</s:form>

</body>
</html>
