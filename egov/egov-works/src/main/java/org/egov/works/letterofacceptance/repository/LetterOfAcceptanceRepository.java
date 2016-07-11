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
package org.egov.works.letterofacceptance.repository;

import java.util.List;

import org.egov.works.workorder.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LetterOfAcceptanceRepository extends JpaRepository<WorkOrder, Long> {

    WorkOrder findById(final Long id);

    List<WorkOrder> findByWorkOrderNumberContainingIgnoreCase(final String workOrderNumber);

    List<WorkOrder> findByEstimateNumberContainingIgnoreCase(final String name);

    List<WorkOrder> findByEstimateNumberAndEgwStatus_codeEquals(final String estimateNumber, final String statusCode);

    List<WorkOrder> findByWorkOrderNumberContainingIgnoreCaseAndEgwStatus_codeEquals(final String workOrderNumber,
            final String statusCode);

    List<WorkOrder> findByEstimateNumberContainingIgnoreCaseAndEgwStatus_codeEquals(final String estimateNumber,
            final String statusCode);

    @Query("select distinct(wo.contractor.name) from WorkOrder as wo where wo.contractor.name like :name or wo.contractor.code like :name")
    List<String> findDistinctContractorByContractor_codeAndNameContainingIgnoreCase(@Param("name") final String name);

    WorkOrder findByWorkOrderNumberAndEgwStatus_codeNotLike(final String workOrderNumber, final String statusCode);

    WorkOrder findByEstimateNumberAndEgwStatus_codeNotLike(final String estimateNumber, final String statusCode);

    WorkOrder findByWorkOrderNumberAndEgwStatus_codeEquals(final String workOrderNumber, final String statusCode);

    @Query("select distinct(woe.workOrder.workOrderNumber) from WorkOrderEstimate as woe where upper(woe.workOrder.workOrderNumber) like upper(:workOrderNumber) and woe.workOrder.egwStatus.code = :approvedStatus and not exists (select distinct(cbr.workOrderEstimate) from ContractorBillRegister as cbr where woe.id = cbr.workOrderEstimate.id and upper(cbr.billstatus) != :status and cbr.billtype = :billtype) ")
    List<String> findWorkOrderNumberForContractorBill(@Param("workOrderNumber") String workOrderNumber,
            @Param("approvedStatus") String approvedStatus, @Param("status") String status, @Param("billtype") String billtype);

    @Query("select distinct(woe.workOrder.workOrderNumber) from WorkOrderEstimate as woe where upper(woe.workOrder.workOrderNumber) like upper(:workOrderNumber) and woe.workOrder.egwStatus.code = :approvedStatus and not exists (select distinct(cbr.workOrderEstimate) from ContractorBillRegister as cbr where woe.id = cbr.workOrderEstimate.id and upper(cbr.billstatus) != :status and cbr.billtype = :billtype) and exists (select distinct mh.workOrderEstimate from MBHeader mh where mh.egwStatus.code =:approvedStatus )")
    List<String> findWorkOrderNumberForContractorBillWithMB(@Param("workOrderNumber") String workOrderNumber,
            @Param("approvedStatus") String approvedStatus, @Param("status") String status, @Param("billtype") String billtype);

    @Query("select distinct(woe.workOrder.estimateNumber) from WorkOrderEstimate as woe where upper(woe.workOrder.estimateNumber) like upper(:estimateNumber) and woe.workOrder.egwStatus.code = :approvedStatus and not exists (select distinct(cbr.workOrderEstimate) from ContractorBillRegister as cbr where woe.id = cbr.workOrderEstimate.id and upper(cbr.billstatus) != :status and cbr.billtype = :billtype)")
    List<String> findEstimateNumberForContractorBill(@Param("estimateNumber") String estimateNumber,
            @Param("approvedStatus") String approvedStatus, @Param("status") String status, @Param("billtype") String billtype);

    @Query("select distinct(woe.workOrder.estimateNumber) from WorkOrderEstimate as woe where upper(woe.workOrder.estimateNumber) like upper(:estimateNumber) and woe.workOrder.egwStatus.code = :approvedStatus and not exists (select distinct(cbr.workOrderEstimate) from ContractorBillRegister as cbr where woe.id = cbr.workOrderEstimate.id and upper(cbr.billstatus) != :status and cbr.billtype = :billtype) and exists (select distinct mh.workOrderEstimate from MBHeader mh where mh.egwStatus.code =:approvedStatus )")
    List<String> findEstimateNumberForContractorBillWithMB(@Param("estimateNumber") String estimateNumber,
            @Param("approvedStatus") String approvedStatus, @Param("status") String status, @Param("billtype") String billtype);

    @Query("select distinct(woe.workOrder.contractor.name) from WorkOrderEstimate as woe where upper(woe.workOrder.contractor.name) like upper(:contractorname) and woe.workOrder.egwStatus.code = :approvedStatus and not exists (select distinct(cbr.workOrderEstimate) from ContractorBillRegister as cbr where woe.id = cbr.workOrderEstimate.id and upper(cbr.billstatus) != :status and cbr.billtype = :billtype) ")
    List<String> findContractorForContractorBill(@Param("contractorname") String contractorname,
            @Param("approvedStatus") String approvedStatus, @Param("status") String status, @Param("billtype") String billtype);

    @Query("select distinct(woe.workOrder.contractor.name) from WorkOrderEstimate as woe where upper(woe.workOrder.contractor.name) like upper(:contractorname) and woe.workOrder.egwStatus.code = :approvedStatus and not exists (select distinct(cbr.workOrderEstimate) from ContractorBillRegister as cbr where woe.id = cbr.workOrderEstimate.id and upper(cbr.billstatus) != :status and cbr.billtype = :billtype) and exists (select distinct mh.workOrderEstimate from MBHeader mh where mh.egwStatus.code =:approvedStatus )")
    List<String> findContractorForContractorBillWithMB(@Param("contractorname") String contractorname,
            @Param("approvedStatus") String approvedStatus, @Param("status") String status, @Param("billtype") String billtype);

    @Query("select distinct(cbr.workOrderEstimate.workOrder.workOrderNumber) from ContractorBillRegister as cbr where upper(cbr.billstatus) != :status and cbr.billtype = :billtype")
    List<String> getDistinctNonCancelledWorkOrderNumbersByBillType(@Param("status") String billstatus,
            @Param("billtype") String finalBill);

    @Query("select distinct(cbr.workOrderEstimate.workOrder.workOrderNumber) from ContractorBillRegister as cbr where cbr.workOrderEstimate.workOrder.id = :workOrderId and upper(cbr.billstatus) not in (:billstatus1,:billstatus2)")
    List<String> getContractorBillInWorkflowForWorkorder(@Param("workOrderId") Long workOrderId,
            @Param("billstatus1") String billstatus1, @Param("billstatus2") String billstatus2);

    @Query("select distinct(led.projectCode.code) from LineEstimateDetails as led  where upper(led.projectCode.code) like upper(:code) and exists (select distinct(wo.estimateNumber) from WorkOrder as wo where led.estimateNumber = wo.estimateNumber)")
    List<String> findWorkIdentificationNumberToCreateMilestone(@Param("code") String code);

    @Query("select sum(br.billamount) from EgBillregister as br where br.workOrderEstimate.workOrder.id = (select id from WorkOrder as wo where wo.workOrderNumber = :workOrderNumber and wo.egwStatus.code = :status) and br.billstatus != :billStatus")
    Double getGrossBillAmountOfBillsCreated(@Param("workOrderNumber") String workOrderNumber, @Param("status") String status,
            @Param("billStatus") String billstatus);

    @Query("select distinct(wo.workOrderNumber) from WorkOrder as wo where wo.egwStatus.code = :workOrderStatus and not exists (select distinct(cbr.workOrderEstimate.workOrder) from ContractorBillRegister as cbr where wo.id = cbr.workOrderEstimate.workOrder.id and upper(cbr.billstatus) != :status and cbr.billtype = :billtype)")
    List<String> findWorkOrderNumbersToModifyLoa(@Param("workOrderStatus") String workOrderStatus, @Param("status") String status,
            @Param("billtype") String billtype);

    @Query("select distinct(led.projectCode.code) from LineEstimateDetails as led  where upper(led.projectCode.code) like upper(:code) and exists (select distinct(wo.estimateNumber) from WorkOrder as wo where led.estimateNumber = wo.estimateNumber and egwStatus.code = :status)")
    List<String> findWorkIdentificationNumbersToSearchLOAToCancel(@Param("code") String code,
            @Param("status") String status);

    @Query("select distinct(wo.contractor.name) from WorkOrder as wo where upper(wo.contractor.name) like upper(:code) and wo.egwStatus.code = :status")
    List<String> findContractorsToSearchLOAToCancel(@Param("code") String code, @Param("status") String status);

    @Query("select distinct(woe.workOrder.estimateNumber) from WorkOrderEstimate as woe where woe.workOrder.egwStatus.code != :workorderstatus and not exists(select distinct(woa.workOrderEstimate.estimate.estimateNumber) from WorkOrderActivity woa where woa.workOrderEstimate = woe) and  woe.estimate.lineEstimateDetails.lineEstimate.id =:lineestimateid")
    List<String> findEstimateNumbersToCancelLineEstimate(@Param("lineestimateid") Long linEstimateId,
            @Param("workorderstatus") String workOrderStatus);

    @Query("select distinct(wo.id) from WorkOrder as wo where wo.id = (select distinct(os.objectId) from OfflineStatus as os where os.id = (select max(status.id) from OfflineStatus status where status.objectType = :objectType and os.objectId = wo.id) and os.objectId = wo.id and os.egwStatus.code = :offlineStatus and os.objectType = :objectType )")
    List<Long> findWorkOrderForLoaStatus(@Param("offlineStatus") String offlineStatus, @Param("objectType") String objectType);
}
