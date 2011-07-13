package com.mfiandesio.core.entities;

public class Color {
	
	
	static int toARGB(String rgb){
		byte r = Byte.parseByte(rgb.substring(0,1));
		byte g = Byte.parseByte(rgb.substring(2,3));
		byte b = Byte.parseByte(rgb.substring(4,5));
		byte[] colorByteArr = { (byte) 0xFF, (byte) r, (byte) g, (byte) b };
        return byteArrToInt(colorByteArr);
	}
	
	static int toARGB(int r,int g,int b){
		byte[] colorByteArr = { (byte) 0xFF, (byte) r, (byte) g, (byte) b };
        return byteArrToInt(colorByteArr);
	}
	public static final int byteArrToInt(byte[] colorByteArr) {
        return (colorByteArr[0] << 24) + ((colorByteArr[1] & 0xFF) << 16) + ((colorByteArr[2] & 0xFF) << 8) + (colorByteArr[3] & 0xFF);
    }
}
