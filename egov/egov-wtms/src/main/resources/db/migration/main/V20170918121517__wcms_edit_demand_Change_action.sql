update eg_action set url = '/search/waterSearch/commonSearch/editdemand', queryparams =null  where name ='EditDemand-wcms' and contextroot ='wtms' and application = (select id from eg_module  where name = 'Water Tax Management');