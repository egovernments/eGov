/*
 *    eGov  SmartCity eGovernance suite aims to improve the internal efficiency,transparency,
 *    accountability and the service delivery of the government  organizations.
 *
 *     Copyright (C) 2018  eGovernments Foundation
 *
 *     The updated version of eGov suite of products as by eGovernments Foundation
 *     is available at http://www.egovernments.org
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program. If not, see http://www.gnu.org/licenses/ or
 *     http://www.gnu.org/licenses/gpl.html .
 *
 *     In addition to the terms of the GPL license to be adhered to in using this
 *     program, the following additional terms are to be complied with:
 *
 *         1) All versions of this program, verbatim or modified must carry this
 *            Legal Notice.
 *            Further, all user interfaces, including but not limited to citizen facing interfaces,
 *            Urban Local Bodies interfaces, dashboards, mobile applications, of the program and any
 *            derived works should carry eGovernments Foundation logo on the top right corner.
 *
 *            For the logo, please refer http://egovernments.org/html/logo/egov_logo.png.
 *            For any further queries on attribution, including queries on brand guidelines,
 *            please contact contact@egovernments.org
 *
 *         2) Any misrepresentation of the origin of the material is prohibited. It
 *            is required that all modified versions of this material be marked in
 *            reasonable ways as different from the original version.
 *
 *         3) This license does not grant any rights to any user of the program
 *            with regards to rights under trademark law for use of the trade names
 *            or trademarks of eGovernments Foundation.
 *
 *   In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
 *
 */
var tableContainer;
$(document)
		.ready(
				function() {
					$('#draftViewTable')
							.DataTable(
									{
										"sDom" : "<'row'<'col-xs-12 hidden col-right'f>r>t<'row'<'col-md-3 col-xs-12'i><'col-md-3 col-xs-6 col-right'l><'col-md-3 col-xs-6 text-right'p>>",
										"aLengthMenu" : [ [ 10, 25, 50, -1 ],
												[ 10, 25, 50, "All" ] ],
										"order" : [ [ 0, "desc" ] ],
										sort : true,
										"autoWidth" : false
									});

					$('#draftViewTable tbody')
							.on(
									'click',
									'tr',
									function() {
										window
												.open(
														"/eventnotification/drafts/view/"
																+ $(this)
																		.children(
																				'td:first-child')
																		.text(),
														'_blank',
														"width=800, height=700, scrollbars=yes")
									});

					$("#draftSearch")
							.click(
									function() {
										$("#draftViewTable").DataTable()
												.clear().draw();
										var typeVal;
										if ($("#type option:selected").text() === "Select") {
											typeVal = "";
										} else {
											typeVal = $("#type option:selected")
													.text();
										}
										$
												.ajax({
													type : "GET",
													url : "/api/draft/search?type="
															+ typeVal
															+ "&name="
															+ $("#name").val(),
													contentType : "application/json; charset=utf-8",
													dataType : 'json',
													success : function(data) {
														$
																.each(
																		data.result,
																		function(
																				i,
																				obj) {
																			$(
																					"#draftViewTable")
																					.dataTable()
																					.fnAddData(
																							[
																									obj.id,
																									obj.name,
																									obj.draftType,
																									obj.module.name,
																									obj.category.name,
																									obj.message ]);
																		});
													},
													error : function(e) {
														console
																.log("There was an error with your request...");
														console
																.log("error: "
																		+ JSON
																				.stringify(e));
													}
												});

									});

				});

$('#btnclose')
		.click(
				function() {
					bootbox
							.confirm({
								message : 'Information entered in this screen will be lost if you close this page ? Please confirm if you want to close. ',
								buttons : {
									'cancel' : {
										label : 'No',
										className : 'btn-default pull-right'
									},
									'confirm' : {
										label : 'Yes',
										className : 'btn-danger pull-right'
									}
								},
								callback : function(result) {
									if (result) {
										window.close();
									}
								}
							});

				});

$("#buttonSubmit").click(
		function(event) {
			window.open("/eventnotification/drafts/create/", '_blank',
					"width=800, height=700, scrollbars=yes");
		});
