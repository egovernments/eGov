/*
 * eGov suite of products aim to improve the internal efficiency,transparency,
 * accountability and the service delivery of the government  organizations.
 *
 *  Copyright (C) 2016  eGovernments Foundation
 *
 *  The updated version of eGov suite of products as by eGovernments Foundation
 *  is available at http://www.egovernments.org
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see http://www.gnu.org/licenses/ or
 *  http://www.gnu.org/licenses/gpl.html .
 *
 *  In addition to the terms of the GPL license to be adhered to in using this
 *  program, the following additional terms are to be complied with:
 *
 *      1) All versions of this program, verbatim or modified must carry this
 *         Legal Notice.
 *
 *      2) Any misrepresentation of the origin of the material is prohibited. It
 *         is required that all modified versions of this material be marked in
 *         reasonable ways as different from the original version.
 *
 *      3) This license does not grant any rights to any user of the program
 *         with regards to rights under trademark law for use of the trade names
 *         or trademarks of eGovernments Foundation.
 *
 *  In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
 */

package org.egov.infra.elasticsearch.entity.bean;

public class ApplicationDetails {

    private String region;
    private String district;
    private String grade;
    private String ulbName;
    private String ulbCode;
    private String revZone;
    private String revWard;
    private String admZone;
    private String admWard;
    private String locality;
    private String functionaryName;
    private String functionaryCode;
    private long totalReceived = 0;
    private long totalClosed = 0;
    private long totalOpen = 0;
    private long closedWithinSLA = 0;
    private long closedBeyondSLA = 0;
    private long openWithinSLA = 0;
    private long openBeyondSLA = 0;
    private long slab1beyondSLA = 0;
    private long slab2beyondSLA = 0;
    private long slab3beyondSLA = 0;
    private long slab4beyondSLA = 0;
    private long slab5beyondSLA = 0;
    private long slaPeriod = 0;
    private long cscTotal = 0;
    private long meesevaTotal = 0;
    private long onlineTotal = 0;
    private long ulbTotal = 0;
    private long othersTotal = 0;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUlbName() {
        return ulbName;
    }

    public void setUlbName(String ulbName) {
        this.ulbName = ulbName;
    }

    public String getUlbCode() {
        return ulbCode;
    }

    public void setUlbCode(String ulbCode) {
        this.ulbCode = ulbCode;
    }

    public String getRevZone() {
        return revZone;
    }

    public void setRevZone(String revZone) {
        this.revZone = revZone;
    }

    public String getRevWard() {
        return revWard;
    }

    public void setRevWard(String revWard) {
        this.revWard = revWard;
    }

    public String getAdmZone() {
        return admZone;
    }

    public void setAdmZone(String admZone) {
        this.admZone = admZone;
    }

    public String getAdmWard() {
        return admWard;
    }

    public void setAdmWard(String admWard) {
        this.admWard = admWard;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getFunctionaryName() {
        return functionaryName;
    }

    public void setFunctionaryName(String functionaryName) {
        this.functionaryName = functionaryName;
    }

    public String getFunctionaryCode() {
        return functionaryCode;
    }

    public void setFunctionaryCode(String functionaryCode) {
        this.functionaryCode = functionaryCode;
    }

    public long getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(long totalReceived) {
        this.totalReceived = totalReceived;
    }

    public long getTotalClosed() {
        return totalClosed;
    }

    public void setTotalClosed(long totalClosed) {
        this.totalClosed = totalClosed;
    }

    public long getTotalOpen() {
        return totalOpen;
    }

    public void setTotalOpen(long totalOpen) {
        this.totalOpen = totalOpen;
    }

    public long getClosedWithinSLA() {
        return closedWithinSLA;
    }

    public void setClosedWithinSLA(long closedWithinSLA) {
        this.closedWithinSLA = closedWithinSLA;
    }

    public long getClosedBeyondSLA() {
        return closedBeyondSLA;
    }

    public void setClosedBeyondSLA(long closedBeyondSLA) {
        this.closedBeyondSLA = closedBeyondSLA;
    }

    public long getOpenWithinSLA() {
        return openWithinSLA;
    }

    public void setOpenWithinSLA(long openWithinSLA) {
        this.openWithinSLA = openWithinSLA;
    }

    public long getOpenBeyondSLA() {
        return openBeyondSLA;
    }

    public void setOpenBeyondSLA(long openBeyondSLA) {
        this.openBeyondSLA = openBeyondSLA;
    }

    public long getSlab1beyondSLA() {
        return slab1beyondSLA;
    }

    public void setSlab1beyondSLA(long slab1beyondSLA) {
        this.slab1beyondSLA = slab1beyondSLA;
    }

    public long getSlab2beyondSLA() {
        return slab2beyondSLA;
    }

    public void setSlab2beyondSLA(long slab2beyondSLA) {
        this.slab2beyondSLA = slab2beyondSLA;
    }

    public long getSlab3beyondSLA() {
        return slab3beyondSLA;
    }

    public void setSlab3beyondSLA(long slab3beyondSLA) {
        this.slab3beyondSLA = slab3beyondSLA;
    }

    public long getSlab4beyondSLA() {
        return slab4beyondSLA;
    }

    public void setSlab4beyondSLA(long slab4beyondSLA) {
        this.slab4beyondSLA = slab4beyondSLA;
    }

    public long getSlab5beyondSLA() {
        return slab5beyondSLA;
    }

    public void setSlab5beyondSLA(long slab5beyondSLA) {
        this.slab5beyondSLA = slab5beyondSLA;
    }

    public long getSlaPeriod() {
        return slaPeriod;
    }

    public void setSlaPeriod(long slaPeriod) {
        this.slaPeriod = slaPeriod;
    }

    public long getCscTotal() {
        return cscTotal;
    }

    public void setCscTotal(long cscTotal) {
        this.cscTotal = cscTotal;
    }

    public long getMeesevaTotal() {
        return meesevaTotal;
    }

    public void setMeesevaTotal(long meesevaTotal) {
        this.meesevaTotal = meesevaTotal;
    }

    public long getOnlineTotal() {
        return onlineTotal;
    }

    public void setOnlineTotal(long onlineTotal) {
        this.onlineTotal = onlineTotal;
    }

    public long getUlbTotal() {
        return ulbTotal;
    }

    public void setUlbTotal(long ulbTotal) {
        this.ulbTotal = ulbTotal;
    }

    public long getOthersTotal() {
        return othersTotal;
    }

    public void setOthersTotal(long othersTotal) {
        this.othersTotal = othersTotal;
    }

}
