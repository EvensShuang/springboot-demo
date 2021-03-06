package com.shuang.hadoop.mr;

import com.google.inject.internal.util.$Strings;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

/**
 * @Author: shuang.zhang
 * @Email: shuang.zhang@rograndec.com
 * @CreateTime: 2019-7-18
 * @Version: 1.0
 */
public class HdfsTest {
    public static void main(String[] args) throws IOException {
        String uri = "hdfs://192.168.33.3:9000/";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);

        // 列出hdfs上/user/fkong/目录下的所有文件和目录
        FileStatus[] statuses = fs.listStatus(new Path("/user"));
        for (FileStatus status : statuses) {
            System.out.println(status);
        }

        // 在hdfs的/user/fkong目录下创建一个文件，并写入一行文本
        FSDataOutputStream os = fs.create(new Path("/user/test.log"));
        os.write("Hello World!".getBytes());
        os.flush();
        os.close();

        
        // 显示在hdfs的/user/fkong下指定文件的内容
//        InputStream is = fs.open(new Path("/user/fkong/test.log"));
//        IOUtils.copyBytes(is, System.out, 1024, true);
    }


}