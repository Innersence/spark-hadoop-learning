package com.flex.hadoop.rpc;


import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Point  implements Writable {
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int x = 0;
    public int y = 1;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    };

    public Point(){

    };
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(x);
        out.writeInt(y);
    }
    /*
     * 反序列化方法
     * 注意序列化的顺序和反序列化的顺序要一致
     */

    @Override
    public void readFields(DataInput in) throws IOException {
        this.x = in.readInt();
        this.y = in.readInt();
    }
    @Override
    public String toString() {
        return "x="+x+"\ty="+y;
    }


}
