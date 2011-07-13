package com.mfiandesio.core.entities;

import forplay.core.Canvas;
public class CanvasUtils {
	
	public static void drawCircle(Canvas canvas ,float centerX, float centerY, int radius, Integer color,Integer strokeColor) {
		 
		  if(color==null){
			  color=(int)0xFF000000;
		  }
		  if(strokeColor==null){
			  strokeColor=(int)0xFF000000;
		  }
		  canvas.setStrokeColor(strokeColor);
		  canvas.setFillColor(color);
		  canvas.strokeCircle(centerX, centerY, 4);
		  canvas.fillCircle(centerX, centerY, 4);
		}
	
	public static int argb(int A, int R, int G, int B){     
        byte[] colorByteArr = { (byte) A, (byte) R, (byte) G, (byte) B };
        return byteArrToInt(colorByteArr);
    }

    
    public static final int byteArrToInt(byte[] colorByteArr) {
        return (colorByteArr[0] << 24) + ((colorByteArr[1] & 0xFF) << 16) + ((colorByteArr[2] & 0xFF) << 8) + (colorByteArr[3] & 0xFF);
    }
	
	}

