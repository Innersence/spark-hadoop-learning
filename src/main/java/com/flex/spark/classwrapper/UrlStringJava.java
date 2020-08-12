package com.flex.spark.classwrapper;

import java.io.Serializable;

public class UrlStringJava implements Serializable {
    int hash = 0;
    String url = "";
    public UrlStringJava(String url){
        hash = url.hashCode();
        this.url = url;

    }

    @Override
    public boolean equals(Object obj) {
        String str = obj.toString();

        if(this == obj){
            return true;
        }else {
            byte[] targetBytes = str.getBytes();
            byte[] srcBytes = url.getBytes();
            int targetLen  = targetBytes.length;
            int srcLen = srcBytes.length;
            if(targetLen == srcLen){
                boolean eq = true;
                for(int i =targetLen-1 ;i >= 0;i--){
                    if(srcBytes[i] != targetBytes[i]){
                        eq = false;
                        break;
                    }

                }
                return eq;
            }else{
                return false;
            }
        }


    }

    @Override
    public int hashCode(){
        return hash;
    }

    @Override
    public String toString(){
        return url;
    }
}