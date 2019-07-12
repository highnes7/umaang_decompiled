package in.spicedigital.umang.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.package_7.FragmentActivity;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView.a;
import f.l.a.b.ClassWriter;
import f.l.a.b.d;
import f.l.a.b.f.a;
import internal.view.menu.k;
import k.a.a.a.Al;
import k.a.a.a.Bl;
import k.a.a.a.Cl;
import k.a.a.a.Dl;
import k.a.a.a.El;
import k.a.a.a.Fl;
import k.a.a.a.Gl;
import k.a.a.a.tl;
import k.a.a.a.ul;
import k.a.a.a.vl;
import k.a.a.a.wl;
import k.a.a.a.xl;
import k.a.a.a.yl;
import k.a.a.a.zl;
import k.a.a.c.i;
import k.a.a.m.Fa;
import k.a.a.m.Log;
import org.json.JSONObject;

public class MyProfileGeneral
  extends BaseActivity
{
  public a F = new xl(this);
  public Uri PHONES_WITH_PRESENCE_URI;
  public String TAG = "MyProfileGeneral";
  public TextView a;
  public ClassWriter b;
  public f.l.a.b.f c;
  public k.a.a.m.f d;
  public TextView e;
  public TextView f;
  public TextView g;
  public LinearLayout h;
  public BroadcastReceiver headsetPlugReceiver;
  public TextView i;
  public ImageView image;
  public TextView lang;
  public k mPopup;
  public TextView mTitleView;
  public Toolbar mToolbar;
  public View mViewPager;
  public TextView n;
  public TextView name;
  public boolean p = false;
  public TextView q;
  public TextView t;
  public TextView tabs;
  public TextView textView;
  public Snackbar this$0 = null;
  public TextView tv;
  public TextView type;
  public TextView v;
  public NestedScrollView x;
  public ImageView z;
  
  public MyProfileGeneral() {}
  
  private void a()
    throws Exception
  {
    k.a.a.m.System localSystem = new k.a.a.m.System(this);
    i localI = localSystem.get();
    a.setText(localSystem.getString(localI.getData()));
    textView.setText(localSystem.getString(localI.clear()));
    name.setText(localI.remove());
    lang.setText(localI.h());
    tv.setText(localSystem.getString(localI.getString()));
    f.setText(localSystem.getString(localI.getName()));
    type.setText(localSystem.getString(localI.e()));
    n.setText(localSystem.getString(localI.t()));
    i.setText(localSystem.getString(localI.a()));
    g.setText(localSystem.getString(localI.getTitle()));
    q.setText(localSystem.getString(localI.c()));
    e.setText(localSystem.getString(localI.get()));
    v.setText(localSystem.getString(localI.getData()));
    if (localSystem.getString(localI.getData()).equalsIgnoreCase("")) {
      v.setVisibility(8);
    }
    t.setText(d.get(k.a.a.m.f.g, ""));
    if (localI.getValue().equalsIgnoreCase("M"))
    {
      z.setVisibility(0);
      z.setImageResource(2131231235);
    }
    else if (localI.getValue().equalsIgnoreCase("F"))
    {
      z.setVisibility(0);
      z.setImageResource(2131231042);
    }
    else if (localI.getValue().equalsIgnoreCase("T"))
    {
      z.setVisibility(0);
      z.setImageResource(2131231690);
    }
    else
    {
      z.setVisibility(0);
      z.setImageResource(2131231690);
    }
    if (localI.add().length() > 0) {
      c.a(localI.add(), z, b, F);
    }
    if (localSystem.getString(localI.clear()).length() > 0)
    {
      if (localSystem.getLabel().equalsIgnoreCase("0"))
      {
        image.setImageResource(2131231011);
        image.setEnabled(true);
        image.setVisibility(0);
        p = false;
      }
      else if (localSystem.getLabel().equalsIgnoreCase("1"))
      {
        image.setImageResource(2131231010);
        image.setEnabled(false);
        image.setVisibility(0);
        p = true;
      }
      else
      {
        image.setVisibility(8);
      }
    }
    else {
      image.setVisibility(8);
    }
    x.setVisibility(0);
  }
  
  private void init()
  {
    h = ((LinearLayout)findViewById(2131296979));
    x = ((NestedScrollView)findViewById(2131296834));
    a = ((TextView)findViewById(2131297307));
    textView = ((TextView)findViewById(2131297303));
    f = ((TextView)findViewById(2131297304));
    name = ((TextView)findViewById(2131297302));
    lang = ((TextView)findViewById(2131297308));
    type = ((TextView)findViewById(2131297313));
    n = ((TextView)findViewById(2131297300));
    i = ((TextView)findViewById(2131297298));
    g = ((TextView)findViewById(2131297301));
    q = ((TextView)findViewById(2131297297));
    tv = ((TextView)findViewById(2131297296));
    e = ((TextView)findViewById(2131297312));
    v = ((TextView)findViewById(2131296863));
    t = ((TextView)findViewById(2131296862));
    image = ((ImageView)findViewById(2131297578));
    image.setVisibility(8);
    image.setOnClickListener((View.OnClickListener)new Al(this));
    z = ((ImageView)findViewById(2131297986));
    h.setVisibility(0);
    x.setVisibility(8);
  }
  
  private void onPostExecute(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this$0 = Snackbar.make(x, getResources().getString(2131756005), -2);
      paramString = this$0.getView();
      paramString.setBackgroundColor(getResources().getColor(2131099887));
      ((Button)paramString.findViewById(2131297588)).setOnClickListener((View.OnClickListener)new tl(this));
      this$0.show();
      return;
    }
    paramString = this$0;
    if (paramString != null) {
      paramString.dismiss();
    }
  }
  
  private void registerNetworkReceiver()
  {
    Fa localFa = new Fa(new Gl(this), this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    headsetPlugReceiver = ((BroadcastReceiver)localFa.c());
    registerReceiver(headsetPlugReceiver, localIntentFilter);
  }
  
  private void set()
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject3 = Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject3;
      k.a.a.m.f localF = d;
      String str = k.a.a.m.f.g;
      localJSONObject3.put("mno", localF.get(str, ""));
      localJSONObject3.put("type", "general");
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      new k.a.a.l.List((k.a.a.i.List)new Bl(this), "https://app.umang.gov.in/umang/coreapi/ws2/fp", localJSONObject2, this).execute(new Object[0]);
    }
  }
  
  private void showDialog()
  {
    Dialog localDialog = new Dialog(this);
    localDialog.getWindow();
    localDialog.requestWindowFeature(1);
    localDialog.setContentView(2131493203);
    TextView localTextView = (TextView)localDialog.findViewById(2131297550);
    localDialog.setCancelable(true);
    localDialog.show();
    ((TextView)localDialog.findViewById(2131297427)).setOnClickListener((View.OnClickListener)new Dl(this, localDialog));
    localTextView.setOnClickListener((View.OnClickListener)new El(this, localDialog));
  }
  
  private void update()
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject3 = Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject3;
      TextView localTextView = textView;
      localJSONObject3.put("email", localTextView.getText().toString());
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      new k.a.a.l.List((k.a.a.i.List)new Fl(this), "https://app.umang.gov.in/umang/coreapi/ws2/reever", localJSONObject2, this).execute(new Object[0]);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2016) && (paramInt2 == -1))
    {
      if (!isFinishing()) {
        runOnUiThread((Runnable)new ul(this));
      }
    }
    else if (paramInt1 == 203)
    {
      paramIntent = CropImage.a(paramIntent);
      if (paramInt2 == -1)
      {
        if (!isFinishing()) {
          runOnUiThread((Runnable)new vl(this, paramIntent));
        }
      }
      else
      {
        if (paramInt2 == 204)
        {
          paramIntent.d();
          isFinishing();
          return;
        }
        if (!isFinishing()) {
          runOnUiThread((Runnable)new wl(this));
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131493155);
    Log.execute(this, "UMANG Profile Screen");
    d = new k.a.a.m.f(this);
    c = f.l.a.b.f.a();
    b = f.sufficientlysecure.rootcommands.util.StringBuilder.a(true, true).get(Bitmap.Config.RGB_565).getString();
    mToolbar = ((Toolbar)findViewById(2131297768));
    f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, mToolbar, true);
    mViewPager = mToolbar.getRootView();
    tabs = ((TextView)mViewPager.findViewById(2131297758));
    f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755776, tabs);
    try
    {
      paramBundle = getIntent().getStringExtra("notifId");
      if (paramBundle != null)
      {
        k.a.a.e.System.getInstance(this).set(paramBundle);
        Log.update(this, getIntent().getStringExtra("campaignId"), "Notification Clicked", "clicked", "Notification");
      }
    }
    catch (Exception paramBundle)
    {
      k.a.a.m.StringBuilder.append(paramBundle);
    }
    mTitleView = ((TextView)mViewPager.findViewById(2131296696));
    mTitleView.setOnClickListener((View.OnClickListener)new yl(this));
    init();
    ((AppBarLayout)findViewById(2131296858)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener)new zl(this));
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
        k.a.a.e.System.getInstance(this).set(paramIntent);
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
  
  public void onPause()
  {
    super.onPause();
    unregisterReceiver(headsetPlugReceiver);
  }
  
  public void onResume()
  {
    super.onResume();
    registerNetworkReceiver();
    if (d.get(k.a.a.m.f.text, "").length() == 0)
    {
      updateLog();
      return;
    }
    set();
  }
  
  public void updateLog()
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = Log.execute(this);
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      new k.a.a.l.List((k.a.a.i.List)new Cl(this), "https://app.umang.gov.in/umang/coreapi/ws2/fstqu", localJSONObject2, this).execute(new Object[0]);
    }
  }
}
