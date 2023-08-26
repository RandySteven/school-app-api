package com.module.common.utils;

public class QueryUtil {

    public void joinTableWhereTableIdIsSame(String table1, String table2, String tableIdName, String tableIdValue){
        String query = String.format("SELECT * FROM %s JOIN %s WHERE %s.%s=%s.%s WHERE %s=%s",
                table1,
                table2,
                table1,
                tableIdName,
                table2,
                tableIdName,
                tableIdValue);
    }

}
