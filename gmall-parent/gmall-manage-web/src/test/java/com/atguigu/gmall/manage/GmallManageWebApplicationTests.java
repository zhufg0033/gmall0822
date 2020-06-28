package com.atguigu.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.Clock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {
        String tracker = GmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();


        ClientGlobal.init(tracker);

        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();

        //通过tracker获得Storage链接客户端
        StorageClient storageClient = new StorageClient(trackerServer,null);

        String[] uploadInfos = storageClient.upload_file("/Users/zhufugao/Desktop/架构师技能.jpg", "jpg", null);

        for(String str : uploadInfos){
            System.out.println(str);
        }


        //println*****************
        /*
        * group1
        * M00/00/00/wKguyl74pdWAHjlbAAFS875R_r8109.jpg
        */
        //****************
    }

}
