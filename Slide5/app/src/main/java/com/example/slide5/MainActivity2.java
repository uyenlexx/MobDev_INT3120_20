package com.example.slide5;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity2 extends Activity {
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.tab_selector);

        TabHost tabs = (TabHost) findViewById(R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec;
        spec = tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Tab 1");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Tab 2");
        tabs.addTab(spec);

        tabs.setCurrentTab(0);
    }
}
