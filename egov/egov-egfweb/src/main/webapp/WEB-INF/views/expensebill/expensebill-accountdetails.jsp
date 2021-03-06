<%--
  ~    eGov  SmartCity eGovernance suite aims to improve the internal efficiency,transparency,
  ~    accountability and the service delivery of the government  organizations.
  ~
  ~     Copyright (C) 2017  eGovernments Foundation
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
  ~            Further, all user interfaces, including but not limited to citizen facing interfaces,
  ~            Urban Local Bodies interfaces, dashboards, mobile applications, of the program and any
  ~            derived works should carry eGovernments Foundation logo on the top right corner.
  ~
  ~            For the logo, please refer http://egovernments.org/html/logo/egov_logo.png.
  ~            For any further queries on attribution, including queries on brand guidelines,
  ~            please contact contact@egovernments.org
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
  ~
  --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="panel panel-primary" data-collapsed="0">
	<div class="panel-heading custom_form_panel_heading">
		<div class="panel-title">
			<spring:message code="lbl.accountdetails" />
		</div>
	</div>
	
	<div style="padding: 0 15px;">
		<table class="table table-bordered" id="tblaccountdetails">
			<thead>
				<tr>
					<th><spring:message code="lbl.account.code"/></th>
					<th><spring:message code="lbl.account.head"/></th>
					<th><spring:message code="lbl.debit.amount"/></th>
					<th><spring:message code="lbl.credit.amount"/></th>
					<th><spring:message code="lbl.action"/></th> 		
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${egBillregister.billDetails.size() == 0}">
						<tr id="accountdetailsrow" accountdetailsinvisible="true" hidden="true">
							<td>
								<form:hidden path="billDetails[0].glcodeid" id="accountDetailsGlCodeId_0" class="accountDetailsGlCodeId"/>
								<form:hidden path="billDetails[0].debitamount" id="accountDetailsDebitAmount_0" class ="debitamount"/>
								<form:hidden path="billDetails[0].creditamount" id="accountDetailsCreditAmount_0" class ="creditamount"/>
								<form:hidden path="" name="billDetails[0].detailTypeId" id="billDetails[0].detailTypeId" class="form-control table-input hidden-input accountDetailsDetailTypeId"/>
								<form:hidden path="" name="billDetails[0].detailKeyId" id="billDetails[0].detailKeyId" class="form-control table-input hidden-input accountDetailsDetailKeyId"/>
								<span class="accountDetailsGlCode_0"></span>
							</td>
							<td>
								<span class="accountDetailsAccountHead_0"></span>
							</td>
							<td>
								<span class="accountDetailsDebitAmount_0 accountDetailsDebitAmount" ></span>
							</td>
							<td>
								<span class="accountDetailsCreditAmount_0 accountDetailsCreditAmount"></span>
							</td>
							<td>
								<span class="add-padding delete_0" id="accountDetailDelete_0" onclick="deleteAccountDetails(this);"><i class="fa fa-trash" data-toggle="tooltip" title="" data-original-title="Delete!"></i></span>
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${egBillregister.billDetails}" var="billDeatils" varStatus="item">
							<tr id="accountdetailsrow">
								<td>
									<form:hidden path="billDetails[${item.index }].glcodeid" id="accountDetailsGlCodeId_${item.index }" class="accountDetailsGlCodeId" value="${billDeatils.glcodeid }"/>
									<form:hidden path="billDetails[${item.index }].debitamount" id="accountDetailsDebitAmount_${item.index }" class ="debitamount" value="${billDeatils.debitamount }"/>
									<form:hidden path="billDetails[${item.index }].creditamount" id="accountDetailsCreditAmount_${item.index }" class ="creditamount" value="${billDeatils.creditamount }"/>
									<form:hidden path="" name="billDetails[${item.index }].detailTypeId" id="billDetails[${item.index }].detailTypeId" class="form-control table-input hidden-input accountDetailsDetailTypeId_${item.index }"/>
									<form:hidden path="" name="billDetails[${item.index }].detailKeyId" id="billDetails[${item.index }].detailKeyId" class="form-control table-input hidden-input accountDetailsDetailKeyId_${item.index }"/>
									<span class="accountDetailsGlCode_${item.index }">${billDeatils.chartOfAccounts.glcode }</span>
								</td>
								<td>
									<span class="accountDetailsAccountHead_${item.index }">${billDeatils.chartOfAccounts.name }</span>
								</td>
								<td>
									<span class="accountDetailsDebitAmount_${item.index } accountDetailsDebitAmount">${billDeatils.debitamount }</span>
								</td>
								<td>
									<span class="accountDetailsCreditAmount_${item.index } accountDetailsCreditAmount">${billDeatils.creditamount }</span>
								</td>
								<td>
									<span class="add-padding delete_${item.index }"  id="accountDetailDelete_${item.index }" onclick="deleteAccountDetails(this);"><i class="fa fa-trash" data-toggle="tooltip" title="" data-original-title="Delete!"></i></span>
								</td>
							</tr>
						</c:forEach>
					
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>