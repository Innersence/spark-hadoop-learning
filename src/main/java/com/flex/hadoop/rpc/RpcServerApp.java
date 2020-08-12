package com.flex.hadoop.rpc;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.ProtocolSignature;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

public class RpcServerApp {

    public static void main(String[] args) {

        Configuration conf = new Configuration();
        String ADDRESS = "localhost";
        int port = 9998;
        RPC.Server server;
        try {
            server = new RPC.Builder(conf).setProtocol(MathApi.class)
                    .setInstance(new MathApiImpl())
                    .setBindAddress(ADDRESS)
                    .setPort(port)
                    .setNumHandlers(1).build();
            server.start();
        } catch (HadoopIllegalArgumentException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
