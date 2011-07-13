package com.mfiandesio.html;

import com.google.gwt.core.client.EntryPoint;
import com.mfiandesio.core.MyTinyTowersGame;

import forplay.core.ForPlay;
import forplay.html.HtmlAssetManager;
import forplay.html.HtmlPlatform;

public class MyTinyTowersEntryPoint implements EntryPoint {

    public void onModuleLoad() {
        HtmlPlatform platform = HtmlPlatform.register();
        HtmlAssetManager assets = platform.assetManager();
        assets.setPathPrefix("MyTinyTowers/");
        ForPlay.run(new MyTinyTowersGame());
    }
}
