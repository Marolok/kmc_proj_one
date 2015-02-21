import Table.ObjectEntity;
import Utils.SQLiteDB;


/**
 * Created by Marolok on 07.02.2015.
 */
public class Main {
    public static void main(final String[] args) throws Exception {
        try {
            SQLiteDB.Conn("*/resources/kmc_project_one.s3db");
            for (ObjectEntity entity : SQLiteDB.getAll()) {
                System.out.println(entity.getId() + " - " + entity.toString());
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            SQLiteDB.CloseDB();
        }
    }
}
