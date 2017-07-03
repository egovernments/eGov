/*
 * eGov suite of products aim to improve the internal efficiency,transparency,
 *    accountability and the service delivery of the government  organizations.
 *
 *     Copyright (C) <2015>  eGovernments Foundation
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
 */


var tableContainer;
jQuery(document).ready(function($) {
	$('#baseregisterheader').hide();
	$("#report-footer").hide();
	tableContainer = $("#aplicationSearchResults");
	 document.onkeydown=function(evt){
		 var keyCode = evt ? (evt.which ? evt.which : evt.keyCode) : event.keyCode;
	if(keyCode == 13){
		submitButton();	
	}
	 }
	 
	 $('.slide-history-menu').click(function(){
			$(this).parent().find('.history-slide').slideToggle();
			if($(this).parent().find('#toggle-his-icon').hasClass('fa fa-angle-down'))
			{
				$(this).parent().find('#toggle-his-icon').removeClass('fa fa-angle-down').addClass('fa fa-angle-up');
				//$('#see-more-link').hide();
				}else{
				$(this).parent().find('#toggle-his-icon').removeClass('fa fa-angle-up').addClass('fa fa-angle-down');
				//$('#see-more-link').show();
			}
		}); 
});


$(".btn-primary").click(function(event){
	
	
	$('#aplicationSearchResults').show();
	var wardName=$('#ward').val();
	
	
	if(wardName == '') {
				bootbox.alert("Please select ward name");
				return false;
			}
			else {
				submitButton();
				return true;
			}
		event.preventDefault();
	});


var prevdatatable;
function submitButton() {
	oTable = $("#aplicationSearchResults");
	$("#report-footer").show();
	$('#baseregisterheader').show();
	if(prevdatatable){
		prevdatatable.fnClearTable();
		$('#aplicationSearchResults thead tr').remove();
	}
	$.post("/stms/reports/baseregisterresult/",$('#sewerageBaseRegisterForm').serialize())
	.done(function(baseRegisterResultList) {
	prevdatatable = oTable.dataTable({
		"sDom": "<'row'<'col-xs-12 hidden col-right'f>r>t<'row'<'col-md-3 col-xs-12'i><'col-md-3 col-xs-6 col-right'l><'col-xs-12 col-md-3 col-right'<'export-data'T>><'col-md-3 col-xs-6 text-right'p>>",
		"aLengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
		"autoWidth": false,
		"bDestroy": true,
		"type" : 'POST',
		"oTableTools" : {
			"sSwfPath" : "../../../../../../egi/resources/global/swf/copy_csv_xls_pdf.swf",
			"aButtons" : [ 
			               {
				             "sExtends": "pdf",
                             "sTitle": "Base Register Report",
                             "sPdfOrientation": "landscape"
			                },
			                {
					             "sExtends": "xls",
                                 "sTitle": "Base Register Report"
				             },{
					             "sExtends": "print",
                                 "sTitle": "Base Register Report"
				               }],
		},

		data : baseRegisterResultList,
		columns : [
					  { title : "S.H.S.C Number",class : 'row-detail', data:"shscNumber"},
					  { title : "assesmentno", data: "assementNo"},
					  { title : 'ownerName', data : 'ownerName'},
					  { title : "ward", data: "revenueWard"},
					  { title : "doorNo", data: "doorNo"},
					  { title : "Property type", data: "propertyType"},
					  { title : "Residential closets", data:"residentialClosets"},
					  { title : "Non-Residential closets", data:"nonResidentialClosets"},
					  { title : "Period", data: "period"},
					  { title : "Arrears Demand", data: "arrears"},
					  { title : "Current Tax Demand", data: "currentDemand"},
					  { title : "Total Demand", data: "totalDemand"},
					  { title : "Arrears Collected", data: "arrearsCollected"},
					  { title : "Current Tax Collected", data: "currentTaxCollected"},
					  { title : "Total Tax Collected", data: "totalTaxCollected"},
					  { title : "Advance amount Collected", data: "advanceAmount"},
					  ],
		
		"footerCallback" : function(row, data, start, end, display) {
			var api = this.api(), data;
			if (data.length == 0) {
				$('#report-footer').hide();
			} else {
				$('#report-footer').show();
			}
			if (data.length > 0) {
				updateTotalFooter(9, api);
				updateTotalFooter(10, api);
				updateTotalFooter(11, api);
				updateTotalFooter(12, api);
				updateTotalFooter(13, api);
				updateTotalFooter(14, api);
				updateTotalFooter(15, api);

			}
		},
		"aoColumnDefs" : [ {
			"aTargets" : [9, 10, 11, 12,13,14,15 ],
			"mRender" : function(data, type, full) {
				return formatNumberInr(data);
			}
		} ]
				});
	
	});
}


function updateTotalFooter(colidx, api) {
	// Remove the formatting to get integer data for summation
	var intVal = function(i) {
		return typeof i === 'string' ? i.replace(/[\$,]/g, '') * 1
				: typeof i === 'number' ? i : 0;
	};

	// Total over all pages
	total = api.column(colidx).data().reduce(function(a, b) {
		return intVal(a) + intVal(b);
	});

	// Total over this page
	pageTotal = api.column(colidx, {
		page : 'current'
	}).data().reduce(function(a, b) {
		return intVal(a) + intVal(b);
	}, 0);

	// Update footer
	$(api.column(colidx).footer()).html(
			formatNumberInr(pageTotal) + ' (' + formatNumberInr(total) + ')');
}


// inr formatting number
function formatNumberInr(x) {
	if (x) {
		x = x.toString();
		var afterPoint = '';
		if (x.indexOf('.') > 0)
			afterPoint = x.substring(x.indexOf('.'), x.length);
		x = Math.floor(x);
		x = x.toString();
		var lastThree = x.substring(x.length - 3);
		var otherNumbers = x.substring(0, x.length - 3);
		if (otherNumbers != '')
			lastThree = ',' + lastThree;
		var res = otherNumbers.replace(/\B(?=(\d{2})+(?!\d))/g, ",")
				+ lastThree + afterPoint;
		return res;
	}
	return x;
}

//To Select all wards
$('#selectall').click( function() {
    $('select#ward > option').prop('selected', 'selected');
});