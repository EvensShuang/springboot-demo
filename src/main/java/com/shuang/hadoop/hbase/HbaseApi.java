package com.shuang.hadoop.hbase;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HbaseApi {

    public static Connection connection=null;
    public static  Admin admin=null;

    static {
        Configuration configuration=HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum","192.168.33.3:2181,192.168.33.4:2181,192.168.33.5:2181");
        try {
            connection=ConnectionFactory.createConnection(configuration);
            admin=connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close()  {
      if(admin!=null){
          try {
              admin.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      if(connection!=null){
          try {
              connection.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
    }

    public static boolean isTableExist(String name) throws IOException {
            boolean bool= admin.tableExists(TableName.valueOf(name));
            return  bool;
    }

    public static void createTable(String tableName,String... cfs) throws IOException {
        if(cfs.length<=0){
            System.out.println("没有设置列族");
            return ;
        }
        if(isTableExist(tableName)){
            System.out.println("表已经存在");
            return ;
        }

        HTableDescriptor htableDescriptor=new HTableDescriptor(TableName.valueOf(tableName));
       for (String cf:cfs){
           HColumnDescriptor hcolumnDescriptor=new HColumnDescriptor(cf);
           htableDescriptor.addFamily(hcolumnDescriptor);
       }
        admin.createTable(htableDescriptor);
    }

    public static void createNameSpace(String ns) throws IOException {
        NamespaceDescriptor nd=NamespaceDescriptor.create(ns).build();
        admin.createNamespace(nd);
    }

    public static void put(String tableName,String rowKey,String cf,String cn,String value) throws IOException {
        Table table=connection.getTable(TableName.valueOf(tableName));
        Put put=new Put(Bytes.toBytes(rowKey));
        put.addColumn(Bytes.toBytes(cf),Bytes.toBytes(cn),Bytes.toBytes(value));
        table.put(put);
        table.close();
    }

    public static void  getData(String tableName,String rowKey,String cf,String cn) throws IOException {
        Table table=connection.getTable(TableName.valueOf(tableName));
        Get get=new Get(Bytes.toBytes(rowKey));
        get.addColumn(Bytes.toBytes(cf),Bytes.toBytes(cn));
        get.getMaxVersions();
        Result result=table.get(get);
        for (Cell cell:result.rawCells()){
            System.out.println("cf="+Bytes.toString(CellUtil.cloneFamily(cell))
            +" cn="+Bytes.toString(CellUtil.cloneQualifier(cell))
            +" value="+Bytes.toString(CellUtil.cloneValue(cell)));
        }
        table.close();
    }

    public static void  deleteDataKey(String tableName,String rowKey) throws IOException {
        Table table=connection.getTable(TableName.valueOf(tableName));
        Delete delete=new Delete(Bytes.toBytes(rowKey));
        table.delete(delete);
        table.close();
    }

    public static void scanTable(String tableName) throws IOException {
       Table table=connection.getTable(TableName.valueOf(tableName));
       Scan scan=new Scan();
       ResultScanner results=table.getScanner(scan);
       for (Result result:results){
           for (Cell cell:result.rawCells()){
               System.out.println("rowkey="+Bytes.toString(CellUtil.cloneRow(cell))
                       +" cf="+Bytes.toString(CellUtil.cloneFamily(cell))
                       +" cn="+Bytes.toString(CellUtil.cloneQualifier(cell))
                       +" value="+Bytes.toString(CellUtil.cloneValue(cell)));
           }
       }
       table.close();
    }

    public static void main(String[] args) throws IOException {
        //createNameSpace("0408");
        //createTable("stu_mr",new String[]{"info"});
       // put("stu","1001","info","age","30");
       //getData("stu","1001","info","name");
       // deleteDataKey("stu_mr","1001");
        scanTable("stu_mr");
        close();
    }
}
