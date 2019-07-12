package in.spicedigital.umang.activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.package_7.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import internal.view.menu.k;
import k.a.a.a.S;
import k.a.a.a.T;
import k.a.a.a.U;
import k.a.a.a.V;
import k.a.a.a.W;
import k.a.a.a.X;
import k.a.a.a.Y;
import k.a.a.a.Z;
import k.a.a.a.aa;
import k.a.a.a.ba;
import k.a.a.a.ca;
import k.a.a.a.da;
import k.a.a.a.ea;
import k.a.a.a.fa;
import k.a.a.a.ga;
import k.a.a.a.ha;
import k.a.a.a.ia;
import k.a.a.c.i;
import k.a.a.m.Log;
import k.a.a.m.Ma;
import k.a.a.m.N;
import k.a.a.m.f;
import org.json.JSONObject;
import support.android.v4.content.ContextCompat;

public class AccountSettingScreen
  extends BaseActivity
{
  public LinearLayout artistList;
  public int b = 2001;
  public LinearLayout buttons;
  public f c;
  public LinearLayout context;
  public boolean d = false;
  public View folderButton;
  public KeyguardManager invalidated;
  public String mAmount = "AccountSettingScreen";
  public View mContext;
  public LinearLayout mItems;
  public int mMode = 2;
  public TextView mPackageName;
  public k mPopup;
  public ImageView mStatus;
  public TextView outputView;
  public LinearLayout pathbar;
  public FingerprintManager progress;
  public ImageView repeatButton;
  public ImageView shuffleButton;
  public Toolbar this$0;
  public LinearLayout title;
  public LinearLayout titleView;
  public TextView tv;
  public int x = 12;
  
  public AccountSettingScreen() {}
  
  private void a(String paramString)
  {
    JSONObject localJSONObject1;
    try
    {
      Ma localMa = new Ma();
      JSONObject localJSONObject2 = Log.execute(this);
      localJSONObject1 = localJSONObject2;
      localJSONObject2.put("mpin", localMa.a(Log.toString(this, paramString)));
    }
    catch (Exception paramString)
    {
      k.a.a.m.StringBuilder.append(paramString);
      localJSONObject1 = null;
    }
    if (localJSONObject1 != null) {
      new k.a.a.l.List((k.a.a.i.List)new U(this), "https://app.umang.gov.in/umang/coreapi/ws2/delete", localJSONObject1, this).execute(new Object[0]);
    }
  }
  
  private void execute()
  {
    if (Build.VERSION.SDK_INT > 22)
    {
      Object localObject = (KeyguardManager)getSystemService("keyguard");
      FingerprintManager localFingerprintManager = (FingerprintManager)getSystemService("fingerprint");
      if (!((KeyguardManager)localObject).isKeyguardSecure())
      {
        Toast.makeText(this, "Secure lock screen hasn't set up.\nGo to 'Settings -> Security -> Fingerprint' to set up a fingerprint", 1).show();
        return;
      }
      if (!localFingerprintManager.hasEnrolledFingerprints())
      {
        Toast.makeText(this, "Go to 'Settings -> Security -> Fingerprint' and register at least one fingerprint", 1).show();
        return;
      }
      Log.update(this, null, "Toggle Fingerprint Authentication button", "clicked", "On Account Setting Screen");
      if ("false".equalsIgnoreCase(c.get(f.right, "false")))
      {
        Log.update(this, null, "Fingerprint Authentication clicked On", "clicked", "On Account Setting Screen");
        localObject = new Intent(this, VerifyMpinScreen.class);
        ((Intent)localObject).putExtra("from", "fingerprint");
        startActivityForResult((Intent)localObject, b);
        return;
      }
      Log.update(this, null, "Fingerprint Authentication clicked Off", "clicked", "On Account Setting Screen");
      repeatButton.setImageResource(2131231475);
      c.append(f.right, "false");
    }
  }
  
  private void handleIntent()
  {
    Dialog localDialog = f.sufficientlysecure.rootcommands.util.StringBuilder.create(this, 1, 2131492996, false);
    ((TextView)localDialog.findViewById(2131296456)).setOnClickListener((View.OnClickListener)new W(this, localDialog));
    ((TextView)localDialog.findViewById(2131297214)).setOnClickListener((View.OnClickListener)new X(this, localDialog));
  }
  
  private void onCreateView()
  {
    c = new f(this);
    context = ((LinearLayout)findViewById(2131296485));
    titleView = ((LinearLayout)findViewById(2131296482));
    tv = ((TextView)findViewById(2131296349));
    title = ((LinearLayout)findViewById(2131296605));
    shuffleButton = ((ImageView)findViewById(2131297764));
    repeatButton = ((ImageView)findViewById(2131297763));
    mItems = ((LinearLayout)findViewById(2131296488));
    buttons = ((LinearLayout)findViewById(2131296823));
    pathbar = ((LinearLayout)findViewById(2131297974));
    artistList = ((LinearLayout)findViewById(2131296800));
    folderButton = findViewById(2131296801);
    try
    {
      k.a.a.m.System localSystem = new k.a.a.m.System(this);
      int i = localSystem.get().c().length();
      if (i > 0)
      {
        TextView localTextView = tv;
        localTextView.setText(localSystem.get().c());
      }
    }
    catch (Exception localException1)
    {
      k.a.a.m.StringBuilder.append(localException1);
    }
    if ("true".equalsIgnoreCase(c.get(f.buttons, "true"))) {
      shuffleButton.setImageResource(2131231477);
    } else {
      shuffleButton.setImageResource(2131231475);
    }
    if ("true".equalsIgnoreCase(c.get(f.right, "false"))) {
      repeatButton.setImageResource(2131231477);
    } else {
      repeatButton.setImageResource(2131231475);
    }
    if (Build.VERSION.SDK_INT > 22)
    {
      invalidated = ((KeyguardManager)getSystemService("keyguard"));
      progress = ((FingerprintManager)getSystemService("fingerprint"));
      if (ContextCompat.checkSelfPermission(this, "android.permission.USE_FINGERPRINT") != 0)
      {
        Toast.makeText(this, "Fingerprint authentication permission not enabled", 1).show();
        return;
      }
      if (progress != null)
      {
        Object localObject = progress;
        try
        {
          boolean bool = ((FingerprintManager)localObject).isHardwareDetected();
          if (bool) {
            return;
          }
          localObject = artistList;
          ((View)localObject).setVisibility(8);
          localObject = folderButton;
          ((View)localObject).setVisibility(8);
          return;
        }
        catch (Exception localException2)
        {
          k.a.a.m.StringBuilder.append(localException2);
          return;
        }
      }
    }
    else
    {
      artistList.setVisibility(8);
      folderButton.setVisibility(8);
    }
  }
  
  private void performSearch(String paramString)
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject3 = Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject3;
      localJSONObject3.put("amno", paramString);
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      new k.a.a.l.List((k.a.a.i.List)new T(this, paramString), "https://app.umang.gov.in/umang/coreapi/ws2/uam", localJSONObject2, this).execute(new Object[0]);
    }
  }
  
  private void show()
  {
    Dialog localDialog = f.sufficientlysecure.rootcommands.util.StringBuilder.create(this, 1, 2131492950, false);
    ((TextView)localDialog.findViewById(2131296456)).setOnClickListener((View.OnClickListener)new Y(this, localDialog));
    ((TextView)localDialog.findViewById(2131297214)).setOnClickListener((View.OnClickListener)new Z(this, localDialog));
  }
  
  private void visit(String paramString1, String paramString2)
  {
    JSONObject localJSONObject1;
    try
    {
      Ma localMa = new Ma();
      JSONObject localJSONObject2 = Log.execute(this);
      localJSONObject1 = localJSONObject2;
      localJSONObject2.put("mpin", localMa.a(Log.toString(this, paramString1)));
      localJSONObject2.put("mno", Log.add(this));
      localJSONObject2.put("nmno", paramString2);
      localJSONObject2.put("type", "null");
      localJSONObject2.put("ort", "updtmob");
    }
    catch (Exception paramString1)
    {
      k.a.a.m.StringBuilder.append(paramString1);
      localJSONObject1 = null;
    }
    if (localJSONObject1 != null) {
      new k.a.a.l.List((k.a.a.i.List)new V(this), "https://app.umang.gov.in/umang/coreapi/ws2/umobile", localJSONObject1, this).execute(new Object[0]);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      if (paramInt1 == mMode)
      {
        if (paramIntent.getStringExtra("ALT_NUM").length() > 0) {
          visit(paramIntent.getStringExtra("MPIN"), paramIntent.getStringExtra("ALT_NUM"));
        }
      }
      else if (paramInt1 == x)
      {
        if (paramIntent.getStringExtra("NEW_NUM").length() > 0)
        {
          c.append(f.g, paramIntent.getStringExtra("NEW_NUM"));
          f.sufficientlysecure.rootcommands.util.StringBuilder.startActivity(this, MyProfileGeneral.class);
        }
      }
      else if (paramInt1 == b) {
        if (paramIntent.getStringExtra("from").equalsIgnoreCase("delete"))
        {
          d = false;
          if (paramIntent.getStringExtra("MPIN_TXT").length() > 2)
          {
            a(paramIntent.getStringExtra("MPIN_TXT"));
            return;
          }
          if (paramIntent.getStringExtra("MPIN_TXT").length() == 0) {
            f.sufficientlysecure.rootcommands.util.StringBuilder.show(this, 2131755673, this, 1);
          }
        }
        else if (paramIntent.getStringExtra("from").equalsIgnoreCase("fingerprint"))
        {
          if (paramIntent.getStringExtra("MPIN_TXT").length() > 2)
          {
            paramIntent = paramIntent.getStringExtra("MPIN_TXT");
            c.put(f.NONE, N.b("umang_al_n", paramIntent));
            repeatButton.setImageResource(2131231477);
            c.append(f.right, "true");
            return;
          }
          if (paramIntent.getStringExtra("MPIN_TXT").length() == 0) {
            f.sufficientlysecure.rootcommands.util.StringBuilder.show(this, 2131755673, this, 1);
          }
        }
        else if (paramIntent.getStringExtra("MPIN_TXT").length() > 2)
        {
          paramIntent = paramIntent.getStringExtra("MPIN_TXT");
          Intent localIntent = new Intent(this, EnterNewMobScreen.class);
          f.sufficientlysecure.rootcommands.util.StringBuilder.show(this, 2131755378, localIntent, "titletext");
          localIntent.putExtra("mpin", paramIntent);
          startActivityForResult(localIntent, x);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this$0 = ((Toolbar)f.sufficientlysecure.rootcommands.util.StringBuilder.getView(this, 2131492897, this, "Account Settings Screen", 2131297768));
    f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, this$0, true);
    mContext = this$0.getRootView();
    mPackageName = ((TextView)mContext.findViewById(2131297758));
    f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755228, mPackageName);
    mStatus = ((ImageView)mContext.findViewById(2131296872));
    onCreateView();
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
    mStatus.setOnClickListener((View.OnClickListener)new aa(this));
    context.setOnClickListener((View.OnClickListener)new ba(this));
    titleView.setOnClickListener((View.OnClickListener)new ca(this));
    title.setOnClickListener((View.OnClickListener)new da(this));
    mItems.setOnClickListener((View.OnClickListener)new ea(this));
    shuffleButton.setOnClickListener((View.OnClickListener)new fa(this));
    repeatButton.setOnClickListener((View.OnClickListener)new ga(this));
    buttons.setOnClickListener((View.OnClickListener)new ha(this));
    pathbar.setOnClickListener((View.OnClickListener)new ia(this));
    findViewById(2131297034).setOnClickListener((View.OnClickListener)new S(this));
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
      try
      {
        onBackPressed();
      }
      catch (Exception paramMenuItem)
      {
        k.a.a.m.StringBuilder.append(paramMenuItem);
      }
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}
