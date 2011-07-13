package com.mfiandesio.java;

import com.mfiandesio.core.MyTinyTowersGame;

import forplay.core.ForPlay;
import forplay.java.JavaAssetManager;
import forplay.java.JavaPlatform;

public class MyTinyTowersMain {

    public static void main(String[] args) {
        JavaPlatform platform = JavaPlatform.register();
        JavaAssetManager assets = platform.assetManager();
        assets.setPathPrefix("src/main/java/com/mfiandesio/resources");
        ForPlay.run(new MyTinyTowersGame());
    }

}
