package in.spicedigital.umang.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.BaseOnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.design.widget.TabLayout.TabLayoutOnPageChangeListener;
import android.support.v4.package_7.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import internal.view.menu.k;
import java.util.concurrent.Executor;
import k.a.a.a.Ye;
import k.a.a.a.Ze;
import k.a.a.a._e;
import k.a.a.b.q;
import k.a.a.e.System;
import k.a.a.i.List;
import k.a.a.l.v;
import k.a.a.m.Log;
import k.a.a.m.f;
import org.json.JSONObject;
import support.android.v4.content.ContextCompat;
import support.android.v4.view.PagerAdapter;

public class DigilockerTabScreen
  extends BaseActivity
{
  public String TAG = "DigilockerTabScreen";
  public View c;
  public TextView d;
  public ImageView mIcon;
  public k mPopup;
  public System mStore;
  public TabLayout mTabLayout;
  public String mTitle;
  public String mUrl;
  public ViewPager mViewPager;
  public Toolbar this$0;
  public f updater;
  
  public DigilockerTabScreen() {}
  
  private void onCreate()
  {
    updater = new f(this);
    mStore = System.getInstance(this);
    Object localObject = (TextView)LayoutInflater.from(this).inflate(2131493163, null);
    TextView localTextView = (TextView)LayoutInflater.from(this).inflate(2131493163, null);
    mTabLayout = ((TabLayout)findViewById(2131297667));
    TabLayout localTabLayout = mTabLayout;
    localTabLayout.addTab(localTabLayout.newTab().setText(getResources().getString(2131755848).toUpperCase()));
    localTabLayout = mTabLayout;
    localTabLayout.addTab(localTabLayout.newTab().setText(getResources().getString(2131756603).toUpperCase()));
    mTabLayout.setTabGravity(0);
    mTabLayout.getTabAt(0).setCustomView((View)localObject);
    mTabLayout.getTabAt(1).setCustomView(localTextView);
    ((TextView)mTabLayout.getTabAt(0).getCustomView()).setTextColor(ContextCompat.getColor(this, 2131099898));
    mIcon = ((ImageView)findViewById(2131297101));
    mTitle = getIntent().getStringExtra("intentType");
    mUrl = getIntent().getStringExtra("intentValue");
    if (mTitle == null)
    {
      mTitle = "";
      mUrl = "";
    }
    if (mTitle.equalsIgnoreCase("getDoc")) {
      mIcon.setVisibility(8);
    } else {
      mIcon.setVisibility(0);
    }
    mViewPager = ((ViewPager)findViewById(2131297258));
    localObject = new q(getSupportFragmentManager(), mTabLayout.getTabCount());
    mViewPager.setAdapter((PagerAdapter)localObject);
    mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    mTabLayout.setOnTabSelectedListener((TabLayout.BaseOnTabSelectedListener)new Ze(this));
  }
  
  private void startDownload()
  {
    Object localObject;
    try
    {
      JSONObject localJSONObject = Log.execute(this);
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = new v((List)new _e(this), "https://app.umang.gov.in/umang/modsapi/digilockerNew/ws1/unlink", (JSONObject)localObject, this);
      Executor localExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
      ((AsyncTask)localObject).executeOnExecutor(localExecutor, new Object[0]);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 2050) {
      return;
    }
    setResult(-1, paramIntent);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131493065);
    this$0 = ((Toolbar)findViewById(2131297768));
    f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, this$0, true);
    c = this$0.getRootView();
    d = ((TextView)c.findViewById(2131297758));
    f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755577, d);
    onCreate();
    mIcon.setOnClickListener((View.OnClickListener)new Ye(this));
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
