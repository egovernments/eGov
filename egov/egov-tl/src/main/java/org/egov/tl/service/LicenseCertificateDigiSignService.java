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

package org.egov.tl.service;

import org.egov.eis.service.PositionMasterService;
import org.egov.infra.config.persistence.datasource.routing.annotation.ReadOnly;
import org.egov.infra.filestore.entity.FileStoreMapper;
import org.egov.infra.filestore.service.FileStoreService;
import org.egov.infra.reporting.engine.ReportOutput;
import org.egov.pims.commons.Position;
import org.egov.tl.entity.TradeLicense;
import org.egov.tl.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.egov.infra.reporting.engine.ReportFormat.PDF;
import static org.egov.infra.reporting.util.ReportUtil.CONTENT_TYPES;
import static org.egov.tl.utils.Constants.TL_FILE_STORE_DIR;
import static org.egov.tl.utils.Constants.WF_ACTION_DIGI_PENDING;

@Service
@Transactional(readOnly = true)
public class LicenseCertificateDigiSignService {

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    @Qualifier("tradeLicenseService")
    private TradeLicenseService tradeLicenseService;

    @Autowired
    private FileStoreService fileStoreService;

    @Autowired
    private PositionMasterService positionMasterService;

    @Autowired
    @Qualifier("licenseApplicationService")
    private LicenseApplicationService licenseApplicationService;

    @Transactional
    public void digitalSignTransition(List<String> applicationNumbers) {
        for (String applicationNumber : applicationNumbers) {
            TradeLicense license = tradeLicenseService.getLicenseByApplicationNumber(applicationNumber);
            if (license.isNewWorkflow()) {
                licenseApplicationService.processDigitalSignature(applicationNumber);
            } else {
                tradeLicenseService.digitalSignTransition(applicationNumber);
            }
        }
    }

    @ReadOnly
    public List<TradeLicense> getLicensePendingForDigiSign(Long licenseAppTypeId) {
        List<Position> currentUserPositions = positionMasterService.getCurrentUserPositions();
        return licenseAppTypeId == 0 ?
                licenseRepository.findByStateNextActionAndStateOwnerPositionIn(WF_ACTION_DIGI_PENDING, currentUserPositions)
                :
                licenseRepository.findByLicenseAppTypeIdAndStateNextActionAndStateOwnerPositionIn(licenseAppTypeId,
                        WF_ACTION_DIGI_PENDING, currentUserPositions);

    }

    public List<TradeLicense> generateLicenseCertificateForDigiSign(List<Long> licenseIds) {

        List<TradeLicense> licenses = new ArrayList<>();
        for (Long licenseId : licenseIds) {
            TradeLicense license = tradeLicenseService.getLicenseById(licenseId);
            ReportOutput reportOutput = tradeLicenseService.generateLicenseCertificate(license, false);
            FileStoreMapper fileStore = fileStoreService.store(reportOutput.getReportOutputData(),
                    license.generateCertificateFileName() + ".pdf", CONTENT_TYPES.get(PDF), TL_FILE_STORE_DIR);
            license.setDigiSignedCertFileStoreId(fileStore.getFileStoreId());
            tradeLicenseService.save(license);
            licenses.add(license);
        }
        return licenses;
    }
}
