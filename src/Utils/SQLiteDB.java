package Utils;

import Table.ObjectEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Marolok on 07.02.2015.
 */

public class SQLiteDB {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    /**
     * Connects to the database on the path/URL in pathDB.
     * @param pathDB
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void Conn(String pathDB) throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:"+pathDB);
        statmt = conn.createStatement();
    }

    /**
     * Create table 'object' in database. With this table you working.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void CreateDB() throws ClassNotFoundException, SQLException    {
        statmt.execute("CREATE TABLE [object] (\n" +
                "[id] INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "[name] VARCHAR(256)  UNIQUE NOT NULL,\n" +
                "[img] VARCHAR(512)  NOT NULL,\n" +
                "[mod_3d] VARCHAR(512)  NOT NULL,\n" +
                "[x] INTEGER  NULL,\n" +
                "[y] INTEGER  NULL,\n" +
                "[z] INTEGER  NULL,\n" +
                "[link] BOOLEAN  NOT NULL,\n" +
                "[type] INTEGER  NOT NULL\n" +
                ")");
        System.out.println("Таблица создана или уже существует.");
    }

    /**
     * Add object in database.
     * @param obj
     * @throws SQLException
     */
    public static void add(ObjectEntity obj) throws SQLException {
        String sql = "INSERT INTO 'object' ('type','name','img','mod_3d','x','y','z','link') VALUES ("+obj.toString()+")";
        statmt.execute(sql);
    }

    /**
     * Add all elements into list to database.
     * @param listObj
     * @throws SQLException
     */
    public static void addList(List<ObjectEntity> listObj) throws SQLException {
        for (ObjectEntity entity : listObj) {
            SQLiteDB.add(entity);
        }
    }

    /**
     * Get object by ID.
     * @param id
     * @return
     * @throws SQLException
     */
    public static ObjectEntity get(Integer id) throws SQLException {
        ObjectEntity obj = new ObjectEntity();
        resSet = statmt.executeQuery("SELECT * FROM object WHERE id="+id);

        obj.setId(resSet.getInt("id"));
        obj.setName(resSet.getString("name"));
        obj.setImg(resSet.getString("img"));
        obj.setMod3D(resSet.getString("mod_3d"));
        obj.setX(resSet.getInt("x"));
        obj.setY(resSet.getInt("y"));
        obj.setZ(resSet.getInt("z"));
        obj.setLink(resSet.getBoolean("link"));
        obj.setType(resSet.getInt("type"));

        return obj;
    }

    /**
     * Delete object into database by ID.
     * @param id
     * @throws SQLException
     */
    public static void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM object WHERE id="+id;
        statmt.execute(sql);
    }

    /**
     * Delete object into database by NAME.
     * @param name
     * @throws SQLException
     */
    public static void delete(String name) throws SQLException {
        String sql = "DELETE FROM object WHERE name='"+name+"'";
        statmt.execute(sql);
    }

    /**
     * Update object in database. ID not changes.
     * @param obj
     * @throws SQLException
     */
    public static void update(ObjectEntity obj) throws SQLException {
        SQLiteDB.delete(obj.getId());
        String sql = "INSERT INTO object ('id','type','name','img','mod_3d','x','y','z','link') VALUES ("
                +obj.getId()+","+obj.toString()+")";
        System.out.println(sql);
        statmt.execute(sql);
    }

    /**
     * Return all objects into database.
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static List<ObjectEntity> getAll() throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM object");

        List<ObjectEntity> list = new ArrayList<ObjectEntity>();

        while(resSet.next()){
            ObjectEntity obj = new ObjectEntity();
            obj.setId(resSet.getInt("id"));
            obj.setName(resSet.getString("name"));
            obj.setImg(resSet.getString("img"));
            obj.setMod3D(resSet.getString("mod_3d"));
            obj.setX(resSet.getInt("x"));
            obj.setY(resSet.getInt("y"));
            obj.setZ(resSet.getInt("z"));
            obj.setLink(resSet.getBoolean("link"));
            obj.setType(resSet.getInt("type"));
            list.add(obj);
        }
        return list;
    }

    /**
     * Closed connection with database.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void CloseDB() throws ClassNotFoundException, SQLException {
        resSet.close();
        statmt.close();
        conn.close();
    }
}
