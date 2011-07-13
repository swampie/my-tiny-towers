package com.mfiandesio.core.ext;

import forplay.core.Image;

public class PositionImage {
	Image i;
	float x;
	float y;
	boolean breathAffected = false;
	
	public PositionImage(Image i, float x, float y,boolean breathAffected) {
		super();
		this.i = i;
		this.x = x;
		this.y = y;
		this.breathAffected = breathAffected;
	}

	public Image getI() {
		return i;
	}

	public void setI(Image i) {
		this.i = i;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public boolean isBreathAffected() {
		return breathAffected;
	}

	public void setBreathAffected(boolean breathAffected) {
		this.breathAffected = breathAffected;
	}
	
	
	
	
}
