package com.flex.hadoop.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.net.InetSocketAddress;

public class RpcClientApp {
    private MathApi mathApiProxy ;
   public RpcClientApp() throws Exception{
       mathApiProxy =  RPC.getProxy(MathApi.class,MathApi.versionID,
               new InetSocketAddress("localhost",9998),new Configuration());
   }
   public int remoteSum(int a, int b){
       Point point = new Point(a,b);
       return mathApiProxy.sum(point);
   }

    public static void main(String[] args) throws Exception{
        RpcClientApp app = new RpcClientApp();
        app.remoteSum(1,2);
    }
}
