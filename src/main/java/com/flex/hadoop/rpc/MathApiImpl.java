package com.flex.hadoop.rpc;

import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;

public class MathApiImpl implements MathApi {

    @Override
    public long getProtocolVersion(String protocol, long clientVersion)
            throws IOException {
        // TODO Auto-generated method stub
        return MathApi.versionID;
    }

    @Override
    public ProtocolSignature getProtocolSignature(String protocol,
                                                  long clientVersion, int clientMethodsHash) throws IOException {
        // TODO Auto-generated method stub
        return new ProtocolSignature(MathApi.versionID, null);
    }


    @Override
    public int sum(Point p) {
        System.out.println("a="+p.x+" b="+p.y);
        return p.x+p.y;
    }

}
