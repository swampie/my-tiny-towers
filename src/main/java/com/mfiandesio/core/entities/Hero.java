package com.mfiandesio.core.entities;
import static forplay.core.ForPlay.assetManager;
import static forplay.core.ForPlay.graphics;
import static forplay.core.ForPlay.log;

import java.util.ArrayList;
import java.util.List;

import com.mfiandesio.core.ext.PositionImage;

import forplay.core.AssetWatcher;
import forplay.core.CanvasLayer;
import forplay.core.ForPlay;
import forplay.core.Image;
import forplay.core.Json;
import forplay.core.ResourceCallback;
public class Hero {
	
	final static float HERO_X= 245;
	final static float HERO_Y= 185;
	final static float breathInc = 0.1f;
	float breathAmt = 0;
	float breathMax = 2;
	float breathDir = 1;
	
	List<PositionImage> imageComponents = new ArrayList<PositionImage>();
	
	
	
	CanvasLayer heroLayer = graphics().createCanvasLayer(490, 220);
	public Hero(final ResourceCallback<CanvasLayer> callback) {
		assetManager().getText("images/hero.json", new ResourceCallback<String>() {
			
			@Override
			public void error(Throwable err) {
				log().error("Error loading image!", err);
			}
			
			@Override
			public void done(String resource) {
				AssetWatcher assetWatcher = new AssetWatcher(new AssetWatcher.Listener() {
					
					@Override
					public void error(Throwable e) {
						log().error("Error on assetWatcher!", e);
						
					}
					
					@Override
					public void done() {
						callback.done(heroLayer);
					}
				});
				Json.Object document = ForPlay.json().parse(resource);
				Json.Array hero = document.getArray("Hero");
				for (int i = 0; i < hero.length(); i++) {
					Json.Object jsonEntity = hero.getObject(i);
					  
			          String type = jsonEntity.getString("type");
			          Image current = null;
			          if(type.equals("image")){
			        	  log().debug(jsonEntity.getString("path"));
			        	  assetWatcher.add(current = assetManager().getImage(jsonEntity.getString("path")));
			        	  String xDelta = jsonEntity.getString("x");
				          String yDelta = jsonEntity.getString("y");
				          boolean ba = jsonEntity.getBoolean("ba");
				          imageComponents.add(new PositionImage(current,HERO_X + Float.parseFloat(xDelta), HERO_Y +Float.parseFloat(yDelta),ba));
			          }else if(type.equals("circle")){
			        	  //CanvasUtils.drawCircle(heroLayer.canvas(), (float)HERO_X + Float.parseFloat(jsonEntity.getString("x")) , (float)HERO_Y + Float.parseFloat(jsonEntity.getString("y"))- breathAmt, ((int)jsonEntity.getNumber("radius")), Color.toARGB(jsonEntity.getString("color")),Color.toARGB(jsonEntity.getString("strokeColor")));
			          }
			          
				}
			assetWatcher.start();
			}
		});
	}
	
	public CanvasLayer getLayer() {
		return heroLayer;
	}
	
	public void update(float alpha){
		heroLayer.canvas().clear();
		breath();
		for (PositionImage p : this.imageComponents) {
			float y = p.isBreathAffected()?p.getY()-breathAmt:p.getY();
			getLayer().canvas().drawImage(p.getI(), p.getX(), y);
		}
	}
	public void breath(){
		if (breathDir == 1) {  // breath in
		    breathAmt -= breathInc;
		    if (breathAmt < -breathMax) {
		      breathDir = -1;
		    }
		  } else {  // breath out
		    breathAmt += breathInc;
		    if(breathAmt > breathMax) {
		      breathDir = 1;
		    }
		  }
	}
	
	
}
