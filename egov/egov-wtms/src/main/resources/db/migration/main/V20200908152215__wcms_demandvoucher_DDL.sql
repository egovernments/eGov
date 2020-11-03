CREATE TABLE EGWTR_DEMAND_VOUCHER
(
  ID BIGINT NOT NULL,
  CONNECTIONDETAILS BIGINT NOT NULL,
  VOUCHERHEADER BIGINT NOT NULL,
  VERSION NUMERIC DEFAULT 0,
  CREATEDBY BIGINT NOT NULL,
  LASTMODIFIEDBY BIGINT NOT NULL,
  CREATEDDATE TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  LASTMODIFIEDDATE TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT PK_EGWTR_DEMAND_VOUCHER_ID PRIMARY KEY (ID),
  CONSTRAINT FK_EGWTR_DEMAND_VOUCHER_CREATEDBY FOREIGN KEY (CREATEDBY) REFERENCES EG_USER (ID),
  CONSTRAINT FK_EGWTR_DEMAND_VOUCHER_LASTMODIFIEDBY FOREIGN KEY (LASTMODIFIEDBY) REFERENCES EG_USER (ID),
  CONSTRAINT FK_EGWTR_DEMAND_VOUCHER_CONNDET FOREIGN KEY (connectiondetails) REFERENCES EGWTR_CONNECTIONDETAILS (ID)
);

CREATE INDEX idx_wt_demandvoucher_water ON EGWTR_DEMAND_VOUCHER(connectiondetails);
CREATE INDEX idx_wt_demandvoucher_voucherheader ON EGWTR_DEMAND_VOUCHER(voucherheader);

COMMENT ON COLUMN EGWTR_DEMAND_VOUCHER.connectiondetails IS 'primary key of egwtr_connectiondetails';
COMMENT ON COLUMN EGWTR_DEMAND_VOUCHER.voucherheader IS 'primary key of voucherheader';
COMMENT ON TABLE EGWTR_DEMAND_VOUCHER IS 'This table stores link between water connection details and voucherheader';

CREATE SEQUENCE SEQ_EGWTR_DEMAND_VOUCHER;