package in.spicedigital.umang.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.package_7.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import k.a.a.a.Ah;
import k.a.a.a.Bh;
import k.a.a.a.Ch;
import k.a.a.a.Dh;
import k.a.a.a.Eh;
import k.a.a.a.yh;
import k.a.a.a.zh;
import k.a.a.e.System;
import k.a.a.m.Log;
import k.a.a.m.f;

public class HelpScreen
  extends BaseActivity
{
  public final String TAG = "HelpScreen";
  public LinearLayout b;
  public LinearLayout content;
  public LinearLayout errorMessage;
  public f history;
  public LinearLayout l;
  public View loginButton;
  public LinearLayout mAdapter;
  public LinearLayout mHeader;
  public LinearLayout mToolbar;
  public TextView name;
  public View root;
  public Toolbar this$0;
  
  public HelpScreen() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131493102);
    Log.execute(this, "Help Screen");
    history = new f(this);
    this$0 = ((Toolbar)findViewById(2131297768));
    f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, this$0, true);
    root = this$0.getRootView();
    name = ((TextView)root.findViewById(2131297758));
    name.setText(getResources().getString(2131755800));
    content = ((LinearLayout)findViewById(2131297281));
    try
    {
      paramBundle = getIntent().getStringExtra("notifId");
      if (paramBundle != null)
      {
        System.getInstance(this).set(paramBundle);
        Log.update(this, getIntent().getStringExtra("campaignId"), "Notification Clicked", "clicked", "Notification");
      }
    }
    catch (Exception paramBundle)
    {
      k.a.a.m.StringBuilder.append(paramBundle);
    }
    content.setOnClickListener((View.OnClickListener)new yh(this));
    errorMessage = ((LinearLayout)findViewById(2131297017));
    loginButton = findViewById(2131298000);
    if (history.get(f.this$0, "").isEmpty())
    {
      errorMessage.setVisibility(8);
      loginButton.setVisibility(8);
    }
    errorMessage.setOnClickListener((View.OnClickListener)new zh(this));
    mToolbar = ((LinearLayout)findViewById(2131296706));
    mToolbar.setOnClickListener((View.OnClickListener)new Ah(this));
    mAdapter = ((LinearLayout)findViewById(2131296768));
    mAdapter.setOnClickListener((View.OnClickListener)new Bh(this));
    mHeader = ((LinearLayout)findViewById(2131297656));
    mHeader.setOnClickListener((View.OnClickListener)new Ch(this));
    b = ((LinearLayout)findViewById(2131297422));
    b.setOnClickListener((View.OnClickListener)new Dh(this));
    l = ((LinearLayout)findViewById(2131297980));
    l.setOnClickListener((View.OnClickListener)new Eh(this));
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    try
    {
      paramIntent = getIntent().getStringExtra("notifId");
      if (paramIntent != null)
      {
        System.getInstance(this).set(paramIntent);
        Log.update(this, getIntent().getStringExtra("campaignId"), "Notification Clicked", "clicked", "Notification");
        return;
      }
    }
    catch (Exception paramIntent)
    {
      k.a.a.m.StringBuilder.append(paramIntent);
    }
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
