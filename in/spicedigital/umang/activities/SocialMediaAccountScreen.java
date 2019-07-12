package in.spicedigital.umang.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.package_7.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.login.LoginManager;
import com.google.android.android.auth.dashclock.Auth;
import com.google.android.android.auth.dashclock.signin.GoogleSignInAccount;
import com.google.android.android.auth.dashclock.signin.GoogleSignInApi;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions.Builder;
import com.google.android.android.auth.dashclock.signin.GoogleSignInResult;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.GoogleApiClient.Builder;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.android.common.package_9.PendingResult;
import com.google.android.android.common.package_9.ResultCallback;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import de.hdodenhof.circleimageview.CircleImageView;
import f.l.a.b.ClassWriter;
import f.l.a.b.d;
import f.l.a.b.f.a;
import f.u.a.a.a.a.l;
import f.u.a.a.a.n;
import f.u.a.a.a.y;
import f.u.a.a.i;
import internal.view.menu.k;
import java.util.Arrays;
import k.a.a.a.Ar;
import k.a.a.a.Br;
import k.a.a.a.Cr;
import k.a.a.a.Fr;
import k.a.a.a.mr;
import k.a.a.a.nr;
import k.a.a.a.or;
import k.a.a.a.qr;
import k.a.a.a.rr;
import k.a.a.a.sr;
import k.a.a.a.tr;
import k.a.a.a.ur;
import k.a.a.a.wr;
import k.a.a.a.xr;
import k.a.a.a.yr;
import k.a.a.a.zr;
import k.a.a.c.ByteVector;
import k.a.a.m.Log;
import k.a.a.m.Ma;
import org.json.JSONObject;

public class SocialMediaAccountScreen
  extends BaseActivity
  implements GoogleApiClient.OnConnectionFailedListener
{
  public static final int CV_CAP_PROP_IOS_DEVICE_FOCUS = 9001;
  public static final int KEYCODE_F10 = 140;
  public String TAG = "SocialMediaAccount";
  public String a = "google";
  public GoogleSignInOptions ac;
  public k.a.a.m.f b;
  public String c = "facebook";
  public TextView cancelButton;
  public TextView color;
  public CallbackManager controller;
  public l d;
  public f.l.a.b.f f;
  public TwitterAuthConfig field_6;
  public String g = "";
  public LinearLayout header;
  public GoogleApiClient httpClient;
  public int i = 2001;
  public a j = new sr(this);
  public LinearLayout l;
  public LinearLayout listView;
  public ImageView mBack;
  public CircleImageView mCircleView;
  public TextView mHeader;
  public ImageView mNext;
  public ImageView mPlayPauseButton;
  public k mPopup;
  public TextView mSectionsPagerAdapter;
  public Toolbar mToolbar;
  public View mViewPager;
  public LinearLayout mainLayout;
  public TextView name;
  public TextView okButton;
  public ClassWriter out;
  public String p = "twitter";
  public final java.util.List<String> q = Arrays.asList(new String[] { "email", "public_profile" });
  public ByteVector r;
  public LinearLayout rootView;
  public ClassWriter s;
  public ClassWriter state;
  public CardView text;
  public LinearLayout title;
  public ImageView toolbar;
  public CardView type;
  public CircleImageView updater;
  public CircleImageView x;
  
  public SocialMediaAccountScreen() {}
  
  private void a()
  {
    try
    {
      Object localObject = new k.a.a.m.System(this).write();
      r = ((ByteVector)localObject);
      if (r != null)
      {
        localObject = r;
        int k = ((ByteVector)localObject).b().length();
        if (k > 0)
        {
          localObject = b;
          str = k.a.a.m.f.p;
          localByteVector = r;
          ((k.a.a.m.f)localObject).append(str, localByteVector.b());
        }
        else
        {
          localObject = b;
          str = k.a.a.m.f.p;
          ((k.a.a.m.f)localObject).append(str, "");
        }
        localObject = r;
        k = ((ByteVector)localObject).get().length();
        if (k > 0)
        {
          localObject = b;
          str = k.a.a.m.f.b;
          localByteVector = r;
          ((k.a.a.m.f)localObject).append(str, localByteVector.get());
        }
        else
        {
          localObject = b;
          str = k.a.a.m.f.b;
          ((k.a.a.m.f)localObject).append(str, "");
        }
        localObject = r;
        k = ((ByteVector)localObject).read().trim().length();
        if (k > 0)
        {
          localObject = b;
          str = k.a.a.m.f.m;
          localByteVector = r;
          ((k.a.a.m.f)localObject).append(str, localByteVector.read());
        }
        else
        {
          localObject = b;
          str = k.a.a.m.f.m;
          ((k.a.a.m.f)localObject).append(str, "");
        }
        localObject = b;
        String str = k.a.a.m.f.j;
        ByteVector localByteVector = r;
        ((k.a.a.m.f)localObject).append(str, localByteVector.length());
        localObject = b;
        str = k.a.a.m.f.n;
        localByteVector = r;
        ((k.a.a.m.f)localObject).append(str, localByteVector.a());
        localObject = b;
        str = k.a.a.m.f.h;
        localByteVector = r;
        ((k.a.a.m.f)localObject).append(str, localByteVector.e());
        localObject = b;
        str = k.a.a.m.f.s;
        localByteVector = r;
        ((k.a.a.m.f)localObject).append(str, localByteVector.utf8());
        localObject = b;
        str = k.a.a.m.f.A;
        localByteVector = r;
        ((k.a.a.m.f)localObject).append(str, localByteVector.add());
      }
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append((Exception)localException);
      r = null;
    }
    onCreateView();
  }
  
  private void add()
  {
    if ((b.get(k.a.a.m.f.p, "").length() > 0) && (b.get(k.a.a.m.f.b, "").length() > 0) && (b.get(k.a.a.m.f.m, "").length() > 0))
    {
      type.setVisibility(0);
      text.setVisibility(8);
      okButton.setVisibility(0);
      cancelButton.setVisibility(8);
      return;
    }
    if ((b.get(k.a.a.m.f.p, "").length() <= 0) && (b.get(k.a.a.m.f.b, "").length() <= 0) && (b.get(k.a.a.m.f.m, "").length() <= 0))
    {
      type.setVisibility(8);
      text.setVisibility(0);
      okButton.setVisibility(8);
      cancelButton.setVisibility(0);
      return;
    }
    type.setVisibility(0);
    text.setVisibility(0);
    okButton.setVisibility(0);
    cancelButton.setVisibility(0);
  }
  
  private void add(String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString)
  {
    Object localObject;
    try
    {
      JSONObject localJSONObject2 = Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject2;
      localObject = b;
      String str = k.a.a.m.f.g;
      localJSONObject2.put("mno", ((k.a.a.m.f)localObject).get(str, ""));
      localJSONObject2.put("aid", paramString2);
      localJSONObject2.put("atyp", paramString1);
      localJSONObject2.put("aname", paramString3);
      localJSONObject2.put("aimg", paramString4);
      localObject = localJSONObject1;
      if (paramArrayOfString != null)
      {
        localObject = c;
        boolean bool = paramString1.equalsIgnoreCase((String)localObject);
        if (bool)
        {
          localObject = paramArrayOfString[2];
          localJSONObject2.put("fblang", localObject);
          localObject = paramArrayOfString[1];
          localJSONObject2.put("fbgndr", localObject);
          localObject = paramArrayOfString[4];
          localJSONObject2.put("fbloc", localObject);
          localObject = paramArrayOfString[3];
          localJSONObject2.put("fbtz", localObject);
          paramArrayOfString = paramArrayOfString[0];
          localJSONObject2.put("fbemail", paramArrayOfString);
          localObject = localJSONObject1;
        }
        else
        {
          localObject = a;
          bool = paramString1.equalsIgnoreCase((String)localObject);
          if (bool)
          {
            paramArrayOfString = paramArrayOfString[0];
            localJSONObject2.put("goemail", paramArrayOfString);
            localObject = localJSONObject1;
          }
          else
          {
            localObject = p;
            bool = paramString1.equalsIgnoreCase((String)localObject);
            localObject = localJSONObject1;
            if (bool)
            {
              localObject = paramArrayOfString[0];
              localJSONObject2.put("twitlang", localObject);
              localObject = paramArrayOfString[1];
              localJSONObject2.put("twitloc", localObject);
              localObject = paramArrayOfString[2];
              localJSONObject2.put("twittz", localObject);
              paramArrayOfString = paramArrayOfString[3];
              localJSONObject2.put("twitemail", paramArrayOfString);
              localObject = localJSONObject1;
            }
          }
        }
      }
    }
    catch (Exception paramArrayOfString)
    {
      k.a.a.m.StringBuilder.append(paramArrayOfString);
      localObject = null;
    }
    if (localObject != null)
    {
      paramString1 = new k.a.a.l.List((k.a.a.i.List)new Fr(this, paramString1, paramString3, paramString2, paramString4), "https://app.umang.gov.in/umang/coreapi/ws2/linksa", (JSONObject)localObject, this);
      if (!isFinishing()) {
        paramString1.execute(new Object[0]);
      }
    }
  }
  
  private void b(String paramString, ImageView paramImageView, ClassWriter paramClassWriter)
  {
    f.l.a.b.f localF = f;
    a localA = j;
    try
    {
      localF.a(paramString, paramImageView, paramClassWriter, localA);
      return;
    }
    catch (Exception paramString)
    {
      k.a.a.m.StringBuilder.append(paramString);
    }
  }
  
  private void d()
  {
    rootView.setVisibility(8);
    mainLayout.setVisibility(8);
    l.setVisibility(8);
    if (b.get(k.a.a.m.f.p, "").length() == 0) {
      rootView.setVisibility(0);
    }
    if (b.get(k.a.a.m.f.b, "").length() == 0) {
      mainLayout.setVisibility(0);
    }
    if (b.get(k.a.a.m.f.m, "").length() == 0) {
      l.setVisibility(0);
    }
  }
  
  private void describe(GoogleSignInResult paramGoogleSignInResult)
  {
    if (paramGoogleSignInResult != null)
    {
      if (paramGoogleSignInResult.isSuccess())
      {
        localObject = paramGoogleSignInResult.getSignInAccount();
        if (((GoogleSignInAccount)localObject).getPhotoUrl() != null) {
          paramGoogleSignInResult = ((GoogleSignInAccount)localObject).getPhotoUrl().toString();
        } else {
          paramGoogleSignInResult = "";
        }
        String str = ((GoogleSignInAccount)localObject).getEmail();
        add(a, ((GoogleSignInAccount)localObject).getId(), ((GoogleSignInAccount)localObject).getDisplayName(), paramGoogleSignInResult, new String[] { str });
        return;
      }
      paramGoogleSignInResult = Auth.GoogleSignInApi;
      localObject = httpClient;
    }
    try
    {
      paramGoogleSignInResult = paramGoogleSignInResult.signOut((GoogleApiClient)localObject);
      localObject = new nr(this);
      localObject = (ResultCallback)localObject;
      paramGoogleSignInResult.setResultCallback((ResultCallback)localObject);
      return;
    }
    catch (Exception paramGoogleSignInResult) {}
    paramGoogleSignInResult = Auth.GoogleSignInApi;
    Object localObject = httpClient;
    paramGoogleSignInResult = paramGoogleSignInResult.signOut((GoogleApiClient)localObject);
    localObject = new or(this);
    localObject = (ResultCallback)localObject;
    paramGoogleSignInResult.setResultCallback((ResultCallback)localObject);
    return;
  }
  
  private void e()
  {
    d = new l();
    d.a(this, new mr(this));
  }
  
  private void handleMessages()
  {
    startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(httpClient), 9001);
  }
  
  public static void onCreate(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 22)
    {
      CookieManager.getInstance().removeAllCookies(null);
      CookieManager.getInstance().flush();
      return;
    }
    paramContext = CookieSyncManager.createInstance(paramContext);
    paramContext.startSync();
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.removeAllCookie();
    localCookieManager.removeSessionCookie();
    paramContext.stopSync();
    paramContext.sync();
  }
  
  private void onCreateView()
  {
    okButton = ((TextView)findViewById(2131297005));
    cancelButton = ((TextView)findViewById(2131297240));
    okButton.setVisibility(8);
    cancelButton.setVisibility(8);
    type = ((CardView)findViewById(2131297004));
    text = ((CardView)findViewById(2131297241));
    type.setVisibility(8);
    text.setVisibility(8);
    title = ((LinearLayout)findViewById(2131296779));
    header = ((LinearLayout)findViewById(2131296838));
    listView = ((LinearLayout)findViewById(2131297915));
    title.setVisibility(8);
    header.setVisibility(8);
    listView.setVisibility(8);
    rootView = ((LinearLayout)findViewById(2131296781));
    mainLayout = ((LinearLayout)findViewById(2131296839));
    l = ((LinearLayout)findViewById(2131297917));
    rootView.setVisibility(8);
    mainLayout.setVisibility(8);
    l.setVisibility(8);
    mCircleView = ((CircleImageView)findViewById(2131296763));
    updater = ((CircleImageView)findViewById(2131296840));
    x = ((CircleImageView)findViewById(2131297918));
    color = ((TextView)findViewById(2131296764));
    name = ((TextView)findViewById(2131296841));
    mHeader = ((TextView)findViewById(2131297919));
    mBack = ((ImageView)findViewById(2131297001));
    mNext = ((ImageView)findViewById(2131297002));
    mPlayPauseButton = ((ImageView)findViewById(2131297003));
    rootView.setOnClickListener((View.OnClickListener)new xr(this));
    mainLayout.setOnClickListener((View.OnClickListener)new yr(this));
    l.setOnClickListener((View.OnClickListener)new zr(this));
    add();
    d();
    update();
    title.setOnClickListener((View.OnClickListener)new Ar(this));
    header.setOnClickListener((View.OnClickListener)new Br(this));
    listView.setOnClickListener((View.OnClickListener)new Cr(this));
  }
  
  private void onCreateView(String paramString)
  {
    Dialog localDialog = f.sufficientlysecure.rootcommands.util.StringBuilder.create(this, 1, 2131493277, true);
    TextView localTextView = (TextView)localDialog.findViewById(2131297966);
    if (paramString == c) {
      localTextView.setText(String.format(getResources().getString(2131756581), new Object[] { getResources().getString(2131755713) }));
    }
    if (paramString == a) {
      localTextView.setText(String.format(getResources().getString(2131756581), new Object[] { getResources().getString(2131755789) }));
    }
    if (paramString == p) {
      localTextView.setText(String.format(getResources().getString(2131756581), new Object[] { getResources().getString(2131756566) }));
    }
    ((TextView)localDialog.findViewById(2131297214)).setOnClickListener((View.OnClickListener)new rr(this, localDialog, paramString));
  }
  
  private void save()
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject3 = Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject3;
      k.a.a.m.f localF = b;
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
      new k.a.a.l.List((k.a.a.i.List)new tr(this), "https://app.umang.gov.in/umang/coreapi/ws2/fp", localJSONObject2, this).execute(new Object[0]);
    }
  }
  
  private void set(String paramString1, String paramString2, String paramString3)
  {
    Ma localMa = new Ma();
    JSONObject localJSONObject1;
    try
    {
      JSONObject localJSONObject2 = Log.execute(this);
      localJSONObject1 = localJSONObject2;
      localJSONObject2.put("type", "social");
      if (paramString1 == c) {
        localJSONObject2.put("fbid", paramString2);
      }
      if (paramString1 == a) {
        localJSONObject2.put("goid", paramString2);
      }
      if (paramString1 == p) {
        localJSONObject2.put("twitid", paramString2);
      }
      localJSONObject2.put("mpin", localMa.a(Log.toString(this, paramString3)));
    }
    catch (Exception paramString2)
    {
      k.a.a.m.StringBuilder.append(paramString2);
      localJSONObject1 = null;
    }
    if (localJSONObject1 != null) {
      new k.a.a.l.List((k.a.a.i.List)new qr(this, paramString1), "https://app.umang.gov.in/umang/coreapi/ws2/uadhrv1", localJSONObject1, this).execute(new Object[0]);
    }
  }
  
  private void update()
  {
    title.setVisibility(8);
    header.setVisibility(8);
    Object localObject2 = listView;
    Object localObject1 = this;
    ((View)localObject2).setVisibility(8);
    CircleImageView localCircleImageView;
    ClassWriter localClassWriter;
    if (b.get(k.a.a.m.f.p, "").length() > 0)
    {
      s = new d().add(2131231034).d(2131231034).getString(2131231034).setId(false).read(true).get(Bitmap.Config.RGB_565).getString();
      localObject2 = title;
      ((View)localObject2).setVisibility(0);
      color.setText(b.get(k.a.a.m.f.j, ""));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("https://graph.facebook.com/");
      ((StringBuilder)localObject2).append(b.get(k.a.a.m.f.p, ""));
      ((StringBuilder)localObject2).append("/picture?type=large");
      localObject2 = ((StringBuilder)localObject2).toString();
      localCircleImageView = mCircleView;
      localClassWriter = s;
      ((SocialMediaAccountScreen)localObject1).b((String)localObject2, (ImageView)localCircleImageView, localClassWriter);
    }
    localObject1 = this;
    localObject2 = localObject1;
    if (b.get(k.a.a.m.f.b, "").length() > 0)
    {
      out = new d().add(2131231061).d(2131231061).getString(2131231061).setId(false).read(true).get(Bitmap.Config.RGB_565).getString();
      name.setText(b.get(k.a.a.m.f.n, ""));
      localObject2 = b.get(k.a.a.m.f.h, "");
      localCircleImageView = updater;
      localClassWriter = out;
      ((SocialMediaAccountScreen)localObject1).b((String)localObject2, (ImageView)localCircleImageView, localClassWriter);
      localObject2 = header;
      ((View)localObject2).setVisibility(0);
      localObject2 = localObject1;
    }
    if (b.get(k.a.a.m.f.m, "").length() > 0)
    {
      state = new d().add(2131231676).d(2131231676).getString(2131231676).setId(false).read(true).get(Bitmap.Config.RGB_565).getString();
      mHeader.setText(b.get(k.a.a.m.f.s, ""));
      localObject1 = b.get(k.a.a.m.f.A, "");
      localCircleImageView = x;
      localClassWriter = state;
      ((SocialMediaAccountScreen)localObject2).b((String)localObject1, (ImageView)localCircleImageView, localClassWriter);
      listView.setVisibility(0);
    }
  }
  
  public void b()
  {
    if ((y)f.u.a.a.a.f.l().p().c() != null)
    {
      onCreate(this);
      y localY = (y)f.u.a.a.a.f.l().p().c();
      onCreate(getApplicationContext());
      i.p().a();
      i.d();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    f.sufficientlysecure.rootcommands.util.StringBuilder.append("calling onActivityResult ", paramInt1);
    if (paramInt1 == 9001)
    {
      describe(Auth.GoogleSignInApi.getSignInResultFromIntent(paramIntent));
      return;
    }
    Object localObject;
    if (paramInt1 == 140)
    {
      localObject = d;
      if (localObject != null) {
        ((l)localObject).a(paramInt1, paramInt2, paramIntent);
      }
    }
    else if (paramInt1 == i)
    {
      if (paramIntent.getStringExtra("MPIN_TXT").length() > 2)
      {
        paramIntent = paramIntent.getStringExtra("MPIN_TXT");
        localObject = g;
        if (localObject == p) {
          set((String)localObject, b.get(k.a.a.m.f.m, ""), paramIntent);
        }
        localObject = g;
        if (localObject == a) {
          set((String)localObject, b.get(k.a.a.m.f.b, ""), paramIntent);
        }
        localObject = g;
        if (localObject == c) {
          set((String)localObject, b.get(k.a.a.m.f.p, ""), paramIntent);
        }
      }
      else if (paramIntent.getStringExtra("MPIN_TXT").length() == 0)
      {
        f.sufficientlysecure.rootcommands.util.StringBuilder.show(this, 2131755673, this, 1);
      }
    }
    else
    {
      controller.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131493240);
    Log.execute(this, "Social Accounts Screen");
    b = new k.a.a.m.f(this);
    f = f.l.a.b.f.a();
    mToolbar = ((Toolbar)findViewById(2131297768));
    f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, mToolbar, true);
    mViewPager = mToolbar.getRootView();
    mSectionsPagerAdapter = ((TextView)mViewPager.findViewById(2131297758));
    f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131756389, mSectionsPagerAdapter);
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
    toolbar = ((ImageView)mViewPager.findViewById(2131296872));
    toolbar.setOnClickListener((View.OnClickListener)new ur(this));
    FacebookSdk.sdkInitialize(getApplicationContext());
    AppEventsLogger.activateApp(this);
    controller = new CallbackManagerImpl();
    ac = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestProfile().build();
    httpClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, ac).build();
    b = new k.a.a.m.f(this);
    a();
    LoginManager.getInstance().registerCallback(controller, (FacebookCallback)new wr(this));
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
}
