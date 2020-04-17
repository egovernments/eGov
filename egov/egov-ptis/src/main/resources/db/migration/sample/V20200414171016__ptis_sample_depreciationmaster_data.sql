-----------------START-------------------
INSERT INTO egdm_depreciationmaster (ID, YEAR, DEPRECIATION_PCT, MODULE, lastmodifieddate, INSTALLMENT, IS_HISTORY, USERID, depreciation_name, depreciation_type, from_date, to_date) VALUES (NEXTVAL('SEQ_EGDM_DEPRECIATIONMASTER'),25,10, (select ID from EG_MODULE where name = 'Property Tax'),current_timestamp,(SELECT id FROM eg_installment_master WHERE start_date <= current_timestamp AND end_date  >= current_timestamp AND id_module = (SELECT id FROM eg_module WHERE name='Property Tax')),'N',1, '0-25', null, to_date('01/04/2004 00:00:00','dd/MM/yyyy HH24:MI:SS'), to_date('31/03/2099 23:59:59','dd/MM/yyyy HH24:MI:SS'));
INSERT INTO egdm_depreciationmaster (ID, YEAR, DEPRECIATION_PCT, MODULE, lastmodifieddate, INSTALLMENT, IS_HISTORY, USERID, depreciation_name, depreciation_type, from_date, to_date) VALUES (NEXTVAL('SEQ_EGDM_DEPRECIATIONMASTER'),25,20, (select ID from EG_MODULE where name = 'Property Tax'),current_timestamp,(SELECT id FROM eg_installment_master WHERE start_date <= current_timestamp AND end_date  >= current_timestamp AND id_module = (SELECT id FROM eg_module WHERE name='Property Tax')),'N',1, '26-40', null, to_date('01/04/2004 00:00:00','dd/MM/yyyy HH24:MI:SS'), to_date('31/03/2099 23:59:59','dd/MM/yyyy HH24:MI:SS'));
INSERT INTO egdm_depreciationmaster (ID, YEAR, DEPRECIATION_PCT, MODULE, lastmodifieddate, INSTALLMENT, IS_HISTORY, USERID, depreciation_name, depreciation_type, from_date, to_date) VALUES (NEXTVAL('SEQ_EGDM_DEPRECIATIONMASTER'),25,30, (select ID from EG_MODULE where name = 'Property Tax'),current_timestamp,(SELECT id FROM eg_installment_master WHERE start_date <= current_timestamp AND end_date  >= current_timestamp AND id_module = (SELECT id FROM eg_module WHERE name='Property Tax')),'N',1, 'Above 40', null, to_date('01/04/2004 00:00:00','dd/MM/yyyy HH24:MI:SS'), to_date('31/03/2099 23:59:59','dd/MM/yyyy HH24:MI:SS'));
------------------END---------------------
