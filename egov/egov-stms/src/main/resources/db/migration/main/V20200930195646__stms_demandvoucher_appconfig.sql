INSERT INTO eg_appconfig ( ID, KEY_NAME, DESCRIPTION, VERSION, MODULE ) VALUES (nextval('SEQ_EG_APPCONFIG'), 'STMS_DEMAND_VOUCHER_GENERATION_REQUIRED', 'Key to enable/disable demand voucher generation for sewerage charges',0, (select id from eg_module where name='Sewerage Tax Management')); 
INSERT INTO eg_appconfig_values ( ID, KEY_ID, EFFECTIVE_FROM, VALUE, VERSION ) VALUES (nextval('SEQ_EG_APPCONFIG_VALUES'), (SELECT id FROM EG_APPCONFIG WHERE KEY_NAME='STMS_DEMAND_VOUCHER_GENERATION_REQUIRED'), now(),'NO',0);
