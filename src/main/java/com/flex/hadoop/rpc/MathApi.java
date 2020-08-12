package com.flex.hadoop.rpc;

public interface MathApi extends org.apache.hadoop.ipc.VersionedProtocol{
    public static int versionID = 1;
    public int sum(Point p);
}
