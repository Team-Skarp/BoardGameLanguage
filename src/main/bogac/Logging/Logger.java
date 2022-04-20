package Logging;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Logger file to log information of file location and date
*/
public class Logger {
    Boolean log;
    Boolean logAll = true;
    int stampLength = 50;

    public Logger(Boolean log){
        this.log = log;
    }
    public Logger(){
        //set default log
        this.log = false;
    }
    public void g(Object str){
        str = str.toString();
        if(log || logAll){
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            String timestamp2 = timestamp.toString().substring(11,19);
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            String dir = stackTraceElements[2].getClassName()+"/"+stackTraceElements[2].getMethodName();
            int dirLength = dir.length();
            while(dir.length()+timestamp2.length()+5 > this.stampLength){
                dir = dir.substring(1);
            }
            if(dirLength != dir.length()){
                dir = ".."+dir+": ";
            }else{
                dir = dir+":   ";
            }

            String stamp = timestamp2+" "+dir;
            while(stamp.length() <= this.stampLength){
                stamp = stamp+" ";
            }
            System.out.println(stamp+str);
        }

    }

}
