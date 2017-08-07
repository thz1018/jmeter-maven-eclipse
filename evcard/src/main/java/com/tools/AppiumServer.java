package com.tools;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by mia on 2017/7/10.
 */
public class AppiumServer {
    private static final Logger log = LogManager.getLogger(AppiumServer.class);
    Process p;

    public AppiumServer() {
        KillTask("node.exe");
        log.info("init appium server...");
    }

    public void KillTask(String taskname) {
        String Command = "taskkill /F /im " + taskname;
        log.info("kill " + taskname + " task ...");
        runCommand(Command);
    }

    public void runServer(int port, String udid) {
        log.info("run " + udid + " Appium Server in port " + port + "...");
        int bpport = port + 1;
        int chromeport = port + 4792;
        //多设备server端需要手动指定每台设备的udid,安卓无线连接下就是设备的ip:port..
        String Command = "appium.cmd -p " + port + " -bp " + bpport + " --session-override --chromedriver-port " + chromeport + " -U "
                + udid + " >c://" + port + ".txt";
        log.info(Command);
        runCommand(Command);
    }

    private void runCommand(String command) {
        try {
            p=Runtime.getRuntime().exec(command);
            log.info("Wait to Appium server restart 3600ms ");
            Thread.sleep(3600);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopserver(){
        if(p!=null){
            p.destroy();
        }
        log.info("Appium server is stopped now.");
    }

}