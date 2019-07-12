package in.spicedigital.umang.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.package_7.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import k.a.a.a.Ab;
import k.a.a.a.zb;
import k.a.a.e.System;
import k.a.a.m.Log;
import k.a.a.m.f;

public class BrowserScreen
  extends BaseActivity
{
  public final String area = "BrowserScreen";
  public boolean b = false;
  public View content;
  public String key;
  public ProgressBar loadingBar;
  public f pager;
  public Toolbar this$0;
  public TextView title;
  public LinearLayout toolbar;
  public String url;
  public LinearLayout user;
  public WebView webView;
  
  public BrowserScreen() {}
  
  private void init()
  {
    user.setVisibility(8);
    loadingBar.setVisibility(0);
    webView.setVisibility(8);
    b = false;
    key = getIntent().getStringExtra("title");
    url = getIntent().getStringExtra("url");
    Object localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("URL : ");
    ((StringBuilder)localObject1).append(url);
    ((StringBuilder)localObject1).toString();
    try
    {
      localObject1 = getIntent().getStringExtra("notifId");
      if (localObject1 != null)
      {
        System.getInstance(this).set((String)localObject1);
        Log.update(this, getIntent().getStringExtra("campaignId"), "Notification Clicked", "clicked", "Notification");
      }
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
    }
    Object localObject2 = key;
    if (localObject2 != null)
    {
      if ("".equalsIgnoreCase((String)localObject2))
      {
        f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755289, title);
      }
      else
      {
        title.setText(key);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(key);
        ((StringBuilder)localObject2).append(" Screen");
        Log.execute(this, ((StringBuilder)localObject2).toString());
        if (f.sufficientlysecure.rootcommands.util.StringBuilder.getBoolean(this, 2131755802, key))
        {
          localObject2 = (AppBarLayout)findViewById(2131296858);
          if (Build.VERSION.SDK_INT >= 21) {
            ((LinearLayout)localObject2).setElevation(0.0F);
          }
        }
      }
    }
    else {
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755289, title);
    }
    if (url == null) {
      url = "";
    }
    webView.loadUrl(url);
  }
  
  private void initUI()
  {
    pager = new f(this);
    loadingBar = ((ProgressBar)findViewById(2131297314));
    user = ((LinearLayout)findViewById(2131297433));
    toolbar = ((LinearLayout)findViewById(2131296537));
    webView = ((WebView)findViewById(2131298024));
    webView.getSettings().setJavaScriptEnabled(true);
    webView.getSettings().setDomStorageEnabled(true);
  }
  
  public void onBackPressed()
  {
    if ((webView.isFocused()) && (webView.canGoBack()))
    {
      webView.goBack();
      return;
    }
    super.onBackPressed();
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492946);
    this$0 = ((Toolbar)findViewById(2131297768));
    f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, this$0, true);
    content = this$0.getRootView();
    title = ((TextView)content.findViewById(2131297758));
    initUI();
    init();
    webView.setWebViewClient((WebViewClient)new zb(this));
    toolbar.setOnClickListener((View.OnClickListener)new Ab(this));
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    init();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      onBackPressed();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}
