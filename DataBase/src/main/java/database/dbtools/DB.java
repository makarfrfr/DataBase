package database.dbtools;

import database.utils.DBProvider;

import java.util.Iterator;

public class DB {
    public static void main(String args[]) {
        DBProvider provider = new DBProvider("5433");

        Iterator it = provider.getAllTables().iterator();
        while (it.hasNext()) {
            String tmp = it.next() + "";
            if(!(tmp.contains("databasechangelog") || tmp.contains("hibernate")))
            provider.executeRawSQL("DROP TABLE " + tmp + " CASCADE");
        }

    }
}
