package k.a.a.m;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.TextView;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.google.android.android.auth.dashclock.Auth;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions.Builder;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.package_9.Api.ApiOptions.HasOptions;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.GoogleApiClient.Builder;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.android.common.package_9.Sample;
import f.u.a.a.a.m;
import f.u.a.a.a.n;
import f.u.a.a.a.y;
import in.spicedigital.umang.activities.InfoHomeScreen;
import internal.view.menu.k;
import java.util.Locale;
import k.a.a.c.ByteVector;
import k.a.a.c.a;
import k.a.a.h.Xb;
import k.a.a.l.h;
import k.a.a.l.r;
import org.json.JSONArray;
import org.json.JSONObject;
import org.yaxim.androidclient.data.ChatProvider;

public class System
  implements GoogleApiClient.OnConnectionFailedListener
{
  public Context context;
  public k mCurrentTarget;
  public String mSessionName = "UserProfileHandler";
  public f this$0;
  
  public System(Context paramContext)
  {
    context = paramContext;
    this$0 = new f(context);
  }
  
  private String c(String paramString)
  {
    Object localObject1 = this$0;
    Object localObject2 = f.text;
    try
    {
      localObject1 = ((f)localObject1).get((String)localObject2, "");
      localObject1 = new JSONObject((String)localObject1).getJSONArray("qualList");
      int i = 0;
      for (;;)
      {
        int j = ((JSONArray)localObject1).length();
        if (i >= j) {
          break;
        }
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        boolean bool = paramString.equalsIgnoreCase(((JSONObject)localObject2).getString("qualId"));
        if (bool)
        {
          paramString = ((JSONObject)localObject2).getString("qualName");
          return paramString;
        }
        i += 1;
      }
      return "";
    }
    catch (Exception paramString) {}
    return "";
  }
  
  private String doInBackground(String paramString)
  {
    Object localObject1 = this$0;
    Object localObject2 = f.text;
    try
    {
      localObject1 = ((f)localObject1).get((String)localObject2, "");
      localObject1 = new JSONObject((String)localObject1).getJSONArray("occuList");
      int i = 0;
      for (;;)
      {
        int j = ((JSONArray)localObject1).length();
        if (i >= j) {
          break;
        }
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        boolean bool = paramString.equalsIgnoreCase(((JSONObject)localObject2).getString("occuId"));
        if (bool)
        {
          paramString = ((JSONObject)localObject2).getString("occuName");
          return paramString;
        }
        i += 1;
      }
      return "";
    }
    catch (Exception paramString) {}
    return "";
  }
  
  private String execute(String paramString)
  {
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("State Name index for ", paramString);
    Object localObject1 = this$0;
    Object localObject2 = f.text;
    try
    {
      localObject1 = ((f)localObject1).get((String)localObject2, "");
      localObject1 = new JSONObject((String)localObject1).getJSONArray("statesList");
      int i = 0;
      for (;;)
      {
        int j = ((JSONArray)localObject1).length();
        if (i >= j) {
          break;
        }
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        boolean bool = paramString.equalsIgnoreCase(((JSONObject)localObject2).getString("stateId"));
        if (bool)
        {
          paramString = ((JSONObject)localObject2).getString("stateName");
          return paramString;
        }
        i += 1;
      }
      return "";
    }
    catch (Exception paramString) {}
    return "";
  }
  
  private void execute()
  {
    Object localObject1 = this$0.get(f.map, "");
    Sa localSa = null;
    Object localObject3;
    Object localObject2;
    try
    {
      JSONObject localJSONObject = new JSONObject((String)localObject1);
      localObject3 = localJSONObject.optJSONObject("epfoData");
      localObject1 = localSa;
      if (localObject3 != null)
      {
        localObject3 = new JSONObject();
        localObject1 = context;
        localObject1 = ((Context)localObject1).getResources().getConfiguration();
        localObject1 = locale;
        Object localObject4 = ((Locale)localObject1).toString();
        localObject1 = "en";
        boolean bool = ((String)localObject4).contains("GB");
        if (bool)
        {
          int i = ((String)localObject4).length();
          localObject1 = ((String)localObject4).substring(0, i - 3);
        }
        localObject4 = this$0;
        String str = f.c;
        localObject1 = ((f)localObject4).get(str, (String)localObject1);
        localObject4 = new java.lang.StringBuilder();
        ((java.lang.StringBuilder)localObject4).append("");
        ((java.lang.StringBuilder)localObject4).append(java.lang.System.currentTimeMillis());
        ((JSONObject)localObject3).put("trkr", ((java.lang.StringBuilder)localObject4).toString());
        localObject4 = this$0;
        str = f.this$0;
        ((JSONObject)localObject3).put("tkn", ((f)localObject4).get(str, ""));
        localObject4 = context;
        ((JSONObject)localObject3).put("lac", Log.parse((Context)localObject4));
        ((JSONObject)localObject3).put("lat", "");
        ((JSONObject)localObject3).put("lon", "");
        ((JSONObject)localObject3).put("lang", localObject1);
        localObject1 = context;
        ((JSONObject)localObject3).put("lac", Log.parse((Context)localObject1));
        ((JSONObject)localObject3).put("usag", "12");
        ((JSONObject)localObject3).put("usrid", "12");
        ((JSONObject)localObject3).put("pltfrm", "app");
        ((JSONObject)localObject3).put("srvid", "12");
        ((JSONObject)localObject3).put("mode", "android");
        ((JSONObject)localObject3).put("uan", localJSONObject.optJSONObject("epfoData").optJSONObject("value").optString("uid"));
        localObject1 = localObject3;
      }
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
      localObject2 = localSa;
    }
    if (localObject2 != null)
    {
      localSa = new Sa(this);
      localObject3 = context;
      ((AsyncTask)new h((k.a.a.i.List)localSa, "https://app.umang.gov.in/umang/depttapi/epfoApi/ws1/flogout", localObject2, (Context)localObject3)).execute(new Object[0]);
    }
  }
  
  public static void flush(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 22) {}
    try
    {
      CookieManager.getInstance().removeAllCookies(null);
      CookieManager.getInstance().flush();
      return;
    }
    catch (Exception paramContext)
    {
      CookieManager localCookieManager;
      StringBuilder.append(paramContext);
    }
    paramContext = CookieSyncManager.createInstance(paramContext);
    paramContext.startSync();
    localCookieManager = CookieManager.getInstance();
    localCookieManager.removeAllCookie();
    localCookieManager.removeSessionCookie();
    paramContext.stopSync();
    paramContext.sync();
    return;
  }
  
  private void getProxy(Context paramContext)
  {
    Object localObject1 = GoogleSignInOptions.DEFAULT_SIGN_IN;
    try
    {
      localObject1 = new GoogleSignInOptions.Builder((GoogleSignInOptions)localObject1).requestProfile().build();
      Object localObject2 = new GoogleApiClient.Builder(paramContext);
      paramContext = (AppCompatActivity)paramContext;
      paramContext = ((GoogleApiClient.Builder)localObject2).enableAutoManage(paramContext, this);
      localObject2 = Auth.GOOGLE_SIGN_IN_API;
      paramContext = paramContext.addApi((Sample)localObject2, (Api.ApiOptions.HasOptions)localObject1).build();
      localObject1 = new Ua(this, paramContext);
      localObject1 = (GoogleApiClient.ConnectionCallbacks)localObject1;
      paramContext.registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)localObject1);
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
    }
  }
  
  private void getSettings(Context paramContext)
  {
    try
    {
      FacebookSdk.sdkInitialize(paramContext.getApplicationContext());
      LoginManager.getInstance().logOut();
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
    }
  }
  
  private int onPostExecute(String paramString)
  {
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("State index for ", paramString);
    String[] arrayOfString = context.getResources().getStringArray(2130903065);
    int i = 0;
    while (i < arrayOfString.length)
    {
      if (arrayOfString[i].equalsIgnoreCase(paramString.trim())) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void parse()
  {
    Object localObject1 = this$0.get(f.map, "");
    Ra localRa = null;
    Object localObject3;
    Object localObject2;
    try
    {
      JSONObject localJSONObject = new JSONObject((String)localObject1);
      localObject3 = localJSONObject.optJSONObject("npsData");
      localObject1 = localRa;
      if (localObject3 != null)
      {
        localObject3 = new JSONObject();
        localObject1 = context;
        localObject1 = ((Context)localObject1).getResources().getConfiguration();
        localObject1 = locale;
        Object localObject4 = ((Locale)localObject1).toString();
        localObject1 = "en";
        boolean bool = ((String)localObject4).contains("GB");
        if (bool)
        {
          int i = ((String)localObject4).length();
          localObject1 = ((String)localObject4).substring(0, i - 3);
        }
        localObject4 = new java.lang.StringBuilder();
        ((java.lang.StringBuilder)localObject4).append("==>");
        ((java.lang.StringBuilder)localObject4).append((String)localObject1);
        ((java.lang.StringBuilder)localObject4).toString();
        localObject4 = this$0;
        String str = f.c;
        localObject1 = ((f)localObject4).get(str, (String)localObject1);
        localObject4 = new java.lang.StringBuilder();
        ((java.lang.StringBuilder)localObject4).append("");
        ((java.lang.StringBuilder)localObject4).append(java.lang.System.currentTimeMillis());
        ((JSONObject)localObject3).put("trkr", ((java.lang.StringBuilder)localObject4).toString());
        localObject4 = this$0;
        str = f.this$0;
        ((JSONObject)localObject3).put("tkn", ((f)localObject4).get(str, ""));
        localObject4 = context;
        ((JSONObject)localObject3).put("lac", Log.parse((Context)localObject4));
        ((JSONObject)localObject3).put("lat", "21");
        ((JSONObject)localObject3).put("lon", "12");
        ((JSONObject)localObject3).put("lang", localObject1);
        localObject1 = context;
        ((JSONObject)localObject3).put("imei", Log.getDeviceId((Context)localObject1));
        localObject1 = context;
        ((JSONObject)localObject3).put("lac", Log.parse((Context)localObject1));
        ((JSONObject)localObject3).put("usag", "12");
        ((JSONObject)localObject3).put("usrid", "12");
        ((JSONObject)localObject3).put("srvid", "12");
        ((JSONObject)localObject3).put("mode", "android");
        ((JSONObject)localObject3).put("pltfrm", "app");
        ((JSONObject)localObject3).put("did", "12");
        ((JSONObject)localObject3).put("os", "Android");
        ((JSONObject)localObject3).put("acesstkn", "");
        ((JSONObject)localObject3).put("userid", localJSONObject.optJSONObject("npsData").optString("value"));
        ((JSONObject)localObject3).put("maver", "4.0.1");
        ((JSONObject)localObject3).put("mosver", "6.0");
        ((JSONObject)localObject3).put("uid", getKey());
        localObject1 = localObject3;
      }
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
      localObject2 = localRa;
    }
    if (localObject2 != null)
    {
      localRa = new Ra(this);
      localObject3 = context;
      ((AsyncTask)new r((k.a.a.i.List)localRa, "https://app.umang.gov.in/umang/depttapi/npsApi/ws1/flogout", localObject2, (Context)localObject3)).execute(new Object[0]);
    }
  }
  
  private void reset()
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
    localEditor.putBoolean("is_already_connected", false);
    localEditor.putString("account_jabberID", "");
    localEditor.apply();
    org.yaxim.androidclient.util.PreferenceConstants.isExistingUser = false;
    new Thread((Runnable)new Va(this)).start();
  }
  
  private int update(String paramString)
  {
    String[] arrayOfString = context.getResources().getStringArray(2130903046);
    int i = 0;
    while (i < arrayOfString.length)
    {
      if (arrayOfString[i].equalsIgnoreCase(paramString.trim())) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public a a()
    throws Exception
  {
    Object localObject1 = this$0.get(f.code, "");
    Object localObject2 = new java.lang.StringBuilder();
    ((java.lang.StringBuilder)localObject2).append("==");
    ((java.lang.StringBuilder)localObject2).append((String)localObject1);
    ((java.lang.StringBuilder)localObject2).toString();
    if (((String)localObject1).length() > 0)
    {
      localObject1 = new JSONObject((String)localObject1);
      if (((JSONObject)localObject1).getString("aadhr").length() > 0)
      {
        localObject2 = new a();
        ((a)localObject2).h(((JSONObject)localObject1).getString("aadhr"));
        ((a)localObject2).r(((JSONObject)localObject1).getString("uidai_pia_name"));
        ((a)localObject2).m(((JSONObject)localObject1).getString("uidai_pia_email"));
        if (((JSONObject)localObject1).getString("uidai_pia_gender").equalsIgnoreCase("M"))
        {
          ((a)localObject2).n(context.getResources().getString(2131755773));
          ((a)localObject2).a("Male");
        }
        else if (((JSONObject)localObject1).getString("uidai_pia_gender").equalsIgnoreCase("F"))
        {
          ((a)localObject2).n(context.getResources().getString(2131755772));
          ((a)localObject2).a("Female");
        }
        else if (((JSONObject)localObject1).getString("uidai_pia_gender").equalsIgnoreCase("T"))
        {
          ((a)localObject2).n(context.getResources().getString(2131755774));
          ((a)localObject2).a("Other");
        }
        else
        {
          ((a)localObject2).n("");
        }
        ((a)localObject2).i(((JSONObject)localObject1).getString("uidai_poa_co"));
        ((a)localObject2).l(((JSONObject)localObject1).getString("uidai_pia_dob"));
        ((a)localObject2).t(((JSONObject)localObject1).getString("uidai_poa_state"));
        ((a)localObject2).k(((JSONObject)localObject1).getString("uidai_poa_dist"));
        ((a)localObject2).j(((JSONObject)localObject1).getString("uidai_poa_vtc"));
        ((a)localObject2).s(((JSONObject)localObject1).getString("uidai_poa_pc"));
        ((a)localObject2).o(((JSONObject)localObject1).getString("uidai_poa_house"));
        ((a)localObject2).q(((JSONObject)localObject1).getString("uidai_poa_loc"));
        ((a)localObject2).p(((JSONObject)localObject1).getString("consent_approve_pic_path"));
        ((a)localObject2).f(((JSONObject)localObject1).getString("adhraddr"));
        ((a)localObject2).e(getString(((JSONObject)localObject1).getString("uidai_ldata_name")));
        ((a)localObject2).c(getString(((JSONObject)localObject1).getString("uidai_ldata_co")));
        ((a)localObject2).b(getString(((JSONObject)localObject1).getString("consent_status")));
        ((a)localObject2).d(getString(((JSONObject)localObject1).getString("uidai_ldata_lang")));
        return localObject2;
      }
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    try
    {
      m localM = f.u.a.a.a.f.l().p().c();
      if ((y)localM != null)
      {
        flush(paramContext);
        paramContext = f.u.a.a.a.f.l().p().c();
        paramContext = (y)paramContext;
        flush(FacebookSdk.getApplicationContext());
        f.u.a.a.i.p().a();
        f.u.a.a.i.d();
        return;
      }
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
    }
  }
  
  public String add()
  {
    return this$0.get(f.top, "101");
  }
  
  public void add(String paramString)
  {
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("calling saveAadhaarProfileInfo ==", paramString);
    this$0.append(f.code, paramString);
  }
  
  public void call(String paramString)
  {
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("calling saveUserInfo ==", paramString);
    this$0.append(f.name, paramString);
    doInBackground();
  }
  
  public void clean()
  {
    parse();
    execute();
    Log.v(context);
    Object localObject = context;
    JSONObject localJSONObject;
    try
    {
      localObject = Log.execute((Context)localObject);
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
      localJSONObject = null;
    }
    if (localJSONObject != null)
    {
      Qa localQa = new Qa(this);
      Context localContext = context;
      new k.a.a.l.List((k.a.a.i.List)localQa, "https://app.umang.gov.in/umang/coreapi/ws2/logout", localJSONObject, localContext).execute(new Object[0]);
    }
  }
  
  public String close()
  {
    return this$0.get(f.name, "");
  }
  
  public void close(String paramString)
  {
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("calling saveUserSocialAcctInfo ==", paramString);
    this$0.append(f.mName, paramString);
  }
  
  public void d(String paramString)
  {
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("calling saveAadhaarRegionalLabels ==", paramString);
    this$0.append(f.mTag, paramString);
  }
  
  public void doInBackground()
  {
    Object localObject1 = this$0;
    Object localObject2 = f.name;
    try
    {
      localObject1 = ((f)localObject1).get((String)localObject2, "");
      if (localObject1 == null) {
        return;
      }
      int i = ((String)localObject1).length();
      if (i <= 0) {
        return;
      }
      localObject4 = new JSONObject((String)localObject1);
      localObject2 = ((JSONObject)localObject4).getString("gcmid");
      localObject3 = this$0;
      localObject1 = this;
      localObject5 = f.f;
      bool = ((f)localObject3).get((String)localObject5, "").equalsIgnoreCase("");
      if (bool)
      {
        localObject3 = new java.lang.StringBuilder();
        ((java.lang.StringBuilder)localObject3).append("saving selected state.....................");
        ((java.lang.StringBuilder)localObject3).append((String)localObject2);
        ((java.lang.StringBuilder)localObject3).toString();
        localObject2 = this$0;
        localObject3 = f.f;
        ((f)localObject2).append((String)localObject3, ((JSONObject)localObject4).getString("ostate"));
        localObject2 = this$0;
        localObject3 = f.elements;
        ((f)localObject2).append((String)localObject3, ((JSONObject)localObject4).getString("stname"));
        localObject1 = this$0;
        localObject2 = f.q;
        ((f)localObject1).append((String)localObject2, ((JSONObject)localObject4).getString("stemblem"));
        localObject1 = Xb.a;
      }
    }
    catch (Exception localException1)
    {
      Object localObject4;
      Object localObject3;
      Object localObject5;
      boolean bool;
      label226:
      String str;
      StringBuilder.append((Exception)localException1);
      return;
    }
    try
    {
      localObject1 = ((Handler)localObject1).obtainMessage();
      what = 100;
      obj = "updateTabName";
      localObject2 = Xb.a;
      ((Handler)localObject2).sendMessage((Message)localObject1);
    }
    catch (Exception localException2)
    {
      break label226;
    }
    localObject3 = this;
    localObject1 = ((JSONObject)localObject4).getString("ntfp");
    localObject5 = ((JSONObject)localObject4).getString("ntft");
    bool = ((String)localObject1).equalsIgnoreCase("0");
    localObject2 = "true";
    if (bool)
    {
      bool = ((String)localObject5).equalsIgnoreCase("0");
      if (bool)
      {
        localObject2 = "false";
        localObject1 = "none";
        break label358;
      }
    }
    bool = ((String)localObject1).equalsIgnoreCase("0");
    if (bool)
    {
      bool = ((String)localObject5).equalsIgnoreCase("1");
      if (bool)
      {
        localObject1 = "trans";
        break label358;
      }
    }
    bool = ((String)localObject1).equalsIgnoreCase("1");
    if (bool)
    {
      bool = ((String)localObject5).equalsIgnoreCase("0");
      if (bool)
      {
        localObject1 = "promo";
        break label358;
      }
    }
    localObject1 = "all";
    label358:
    localObject5 = this$0;
    str = f.mCallback;
    ((f)localObject5).append(str, ((JSONObject)localObject4).getString("dlink"));
    localObject5 = this$0;
    str = f.app;
    ((f)localObject5).append(str, ((JSONObject)localObject4).getString("datkn"));
    localObject5 = this$0;
    str = f.m_ProgressBar;
    ((f)localObject5).append(str, ((JSONObject)localObject4).getString("drtkn"));
    localObject4 = this$0;
    localObject5 = f.queue;
    ((f)localObject4).append((String)localObject5, (String)localObject2);
    localObject2 = this$0;
    localObject3 = f.cellId;
    ((f)localObject2).append((String)localObject3, (String)localObject1);
    return;
  }
  
  public void f(String paramString)
  {
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("calling saveProfileCompleteness ==", paramString);
    this$0.append(f.top, paramString);
  }
  
  public k.a.a.c.i get()
    throws Exception
  {
    String str = this$0.get(f.name, "");
    Object localObject;
    if ((str != null) && (str.length() > 0))
    {
      localObject = new java.lang.StringBuilder();
      ((java.lang.StringBuilder)localObject).append("calling getUserProfileObj ==== ");
      ((java.lang.StringBuilder)localObject).append(str);
      ((java.lang.StringBuilder)localObject).toString();
      localObject = new k.a.a.c.i();
      JSONObject localJSONObject = new JSONObject(str);
      ((k.a.a.c.i)localObject).create(getString(localJSONObject.getString("uid")));
      ((k.a.a.c.i)localObject).setTime(getString(localJSONObject.getString("mno")));
      ((k.a.a.c.i)localObject).set(getString(localJSONObject.getString("nam")));
      ((k.a.a.c.i)localObject).e(getString(localJSONObject.getString("email")));
      ((k.a.a.c.i)localObject).init(getString(localJSONObject.getString("gndr")));
      if (localJSONObject.getString("gndr").equalsIgnoreCase("M")) {
        str = context.getResources().getString(2131755773);
      } else if (localJSONObject.getString("gndr").equalsIgnoreCase("F")) {
        str = context.getResources().getString(2131755772);
      } else if (localJSONObject.getString("gndr").equalsIgnoreCase("T")) {
        str = context.getResources().getString(2131755774);
      } else {
        str = "";
      }
      ((k.a.a.c.i)localObject).setPath(str);
      ((k.a.a.c.i)localObject).setIcon(getString(localJSONObject.getString("dob")));
      ((k.a.a.c.i)localObject).normalize(getString(localJSONObject.getString("cty")));
      ((k.a.a.c.i)localObject).a(getString(localJSONObject.getString("qual")));
      ((k.a.a.c.i)localObject).d(getString(localJSONObject.getString("amno")));
      if (getString(localJSONObject.getString("gcmid")).length() > 0)
      {
        ((k.a.a.c.i)localObject).a(Integer.parseInt(localJSONObject.getString("gcmid")));
        ((k.a.a.c.i)localObject).close(execute(localJSONObject.getString("gcmid")));
      }
      else
      {
        ((k.a.a.c.i)localObject).close("");
        ((k.a.a.c.i)localObject).a(-1);
      }
      ((k.a.a.c.i)localObject).i(getString(localJSONObject.getString("dist")));
      ((k.a.a.c.i)localObject).c(getString(localJSONObject.getString("addr")));
      if (getString(localJSONObject.getString("qual")).length() > 0)
      {
        ((k.a.a.c.i)localObject).append(localJSONObject.getString("qual"));
        ((k.a.a.c.i)localObject).add(localJSONObject.getString("qual"));
        ((k.a.a.c.i)localObject).a(c(localJSONObject.getString("qual")));
      }
      else
      {
        ((k.a.a.c.i)localObject).append("");
        ((k.a.a.c.i)localObject).a("");
      }
      if (getString(localJSONObject.getString("occup")).length() > 0)
      {
        ((k.a.a.c.i)localObject).setTitle(localJSONObject.getString("occup"));
        ((k.a.a.c.i)localObject).h(doInBackground(localJSONObject.getString("occup")));
      }
      else
      {
        ((k.a.a.c.i)localObject).setTitle("");
        ((k.a.a.c.i)localObject).h("");
      }
      if (!localJSONObject.isNull("mstatus")) {
        ((k.a.a.c.i)localObject).load(localJSONObject.getString("mstatus"));
      }
      ((k.a.a.c.i)localObject).setURL(getString(localJSONObject.getString("pic")));
      if (!localJSONObject.isNull("dlink"))
      {
        ((k.a.a.c.i)localObject).b(localJSONObject.getString("dlink"));
        return localObject;
      }
    }
    else
    {
      return null;
    }
    return localObject;
  }
  
  public String getBookmarks()
    throws Exception
  {
    return get().add();
  }
  
  public String getItem()
    throws Exception
  {
    String str = this$0.get(f.name, "");
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append("calling getUserProfileObj ==== ");
    localStringBuilder.append(str);
    localStringBuilder.toString();
    str.length();
    return new JSONObject(str).getString("amnos");
  }
  
  public String getKey()
    throws Exception
  {
    return get().decode();
  }
  
  public String getLabel()
    throws Exception
  {
    String str = this$0.get(f.name, "");
    str.length();
    return new JSONObject(str).getString("emails");
  }
  
  public String getName()
    throws Exception
  {
    return get().getValue();
  }
  
  public String getServer()
  {
    return this$0.get(f.server, "");
  }
  
  public String getString(String paramString)
  {
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  public String getTitle(String paramString)
  {
    if (paramString.length() == 0) {
      return "";
    }
    return context.getResources().getStringArray(2130903047)[Integer.parseInt(paramString)];
  }
  
  public String getValue()
  {
    return this$0.get(f.mTag, "");
  }
  
  public String getValue(String paramString)
  {
    if (paramString.length() == 0) {
      return "";
    }
    return context.getResources().getStringArray(2130903051)[Integer.parseInt(paramString)];
  }
  
  public void init()
  {
    Object localObject1 = context;
    try
    {
      localObject1 = new Dialog((Context)localObject1);
      ((Dialog)localObject1).getWindow();
      ((Dialog)localObject1).requestWindowFeature(1);
      ((Dialog)localObject1).setContentView(2131493031);
      ((Dialog)localObject1).setCancelable(false);
      ((Dialog)localObject1).setCanceledOnTouchOutside(false);
      ((Dialog)localObject1).show();
      Object localObject2 = ((Dialog)localObject1).findViewById(2131296634);
      localObject2 = (TextView)localObject2;
      Context localContext = context;
      ((TextView)localObject2).setText(localContext.getResources().getString(2131756350));
      localObject2 = ((Dialog)localObject1).findViewById(2131297214);
      localObject2 = (TextView)localObject2;
      localObject1 = new Oa(this, (Dialog)localObject1);
      localObject1 = (View.OnClickListener)localObject1;
      ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
      update();
    }
  }
  
  public void init(String paramString)
  {
    Object localObject1 = context;
    try
    {
      localObject1 = new Dialog((Context)localObject1);
      ((Dialog)localObject1).getWindow();
      ((Dialog)localObject1).requestWindowFeature(1);
      ((Dialog)localObject1).setContentView(2131493031);
      ((Dialog)localObject1).setCancelable(false);
      ((Dialog)localObject1).setCanceledOnTouchOutside(false);
      ((Dialog)localObject1).show();
      Object localObject2 = ((Dialog)localObject1).findViewById(2131296634);
      localObject2 = (TextView)localObject2;
      ((TextView)localObject2).setText(paramString);
      paramString = ((Dialog)localObject1).findViewById(2131297214);
      paramString = (TextView)paramString;
      localObject1 = new Pa(this, (Dialog)localObject1);
      localObject1 = (View.OnClickListener)localObject1;
      paramString.setOnClickListener((View.OnClickListener)localObject1);
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
      update();
    }
  }
  
  public void l(String paramString)
  {
    this$0.append(f.tag, paramString);
  }
  
  public void log(String paramString)
  {
    this$0.append(f.server, paramString);
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult) {}
  
  public void onPostExecute()
  {
    parse();
    execute();
    Log.v(context);
    this$0.a();
    this$0.append(f.mMode, "true");
    this$0.append(f.mItems, "true");
    this$0.append(f.view, "true");
    this$0.append(f.id, "true");
    Object localObject = context;
    try
    {
      localObject = ((Context)localObject).getSystemService("notification");
      localObject = (NotificationManager)localObject;
      ((NotificationManager)localObject).cancelAll();
    }
    catch (Exception localException1)
    {
      StringBuilder.append(localException1);
    }
    try
    {
      reset();
    }
    catch (Exception localException2)
    {
      StringBuilder.append(localException2);
    }
    new ChatProvider().deleteDataBase(context);
    getProxy(context);
    getSettings(context);
    a(context);
    ((Activity)context).finish();
    Intent localIntent = new Intent(context, InfoHomeScreen.class);
    localIntent.setFlags(268468224);
    context.startActivity(localIntent);
  }
  
  public void p(String paramString)
  {
    this$0.append(f.title, paramString);
  }
  
  public void update()
  {
    k.a.a.e.System localSystem = k.a.a.e.System.getInstance(context);
    Object localObject1 = context;
    String str1;
    try
    {
      localObject1 = new System((Context)localObject1).getKey();
    }
    catch (Exception localException1)
    {
      StringBuilder.append(localException1);
      str1 = "";
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = "";
    }
    parse();
    execute();
    Log.v(context);
    localSystem.delete(str2);
    try
    {
      reset();
    }
    catch (Exception localException2)
    {
      StringBuilder.append(localException2);
    }
    new ChatProvider().deleteDataBase(context);
    Object localObject2 = PreferenceManager.getDefaultSharedPreferences(context).edit();
    ((SharedPreferences.Editor)localObject2).putBoolean("is_already_connected", false);
    ((SharedPreferences.Editor)localObject2).putString("account_jabberID", "");
    ((SharedPreferences.Editor)localObject2).apply();
    org.yaxim.androidclient.util.PreferenceConstants.isExistingUser = false;
    this$0.a();
    this$0.append(f.mMode, "true");
    this$0.append(f.mItems, "true");
    this$0.append(f.view, "true");
    this$0.append(f.id, "true");
    localObject2 = context;
    try
    {
      localObject2 = ((Context)localObject2).getSystemService("notification");
      localObject2 = (NotificationManager)localObject2;
      ((NotificationManager)localObject2).cancelAll();
    }
    catch (Exception localException3)
    {
      StringBuilder.append(localException3);
    }
    getProxy(context);
    getSettings(context);
    a(context);
    ((Activity)context).finish();
    Intent localIntent = new Intent(context, InfoHomeScreen.class);
    localIntent.setFlags(268468224);
    context.startActivity(localIntent);
  }
  
  public void updateModificationDate()
  {
    update();
  }
  
  public ByteVector write()
    throws Exception
  {
    Object localObject1 = this$0.get(f.mName, "");
    Object localObject2 = new java.lang.StringBuilder();
    ((java.lang.StringBuilder)localObject2).append("userSocialInfoStrObj === ");
    ((java.lang.StringBuilder)localObject2).append((String)localObject1);
    ((java.lang.StringBuilder)localObject2).toString();
    ((String)localObject1).length();
    localObject2 = new ByteVector();
    localObject1 = new JSONObject((String)localObject1);
    ((ByteVector)localObject2).add(getString(((JSONObject)localObject1).getString("fbid")));
    ((ByteVector)localObject2).write(getString(((JSONObject)localObject1).getString("fbimg")));
    ((ByteVector)localObject2).putLong(getString(((JSONObject)localObject1).getString("fbname")));
    ((ByteVector)localObject2).b(getString(((JSONObject)localObject1).getString("goid")));
    ((ByteVector)localObject2).a(getString(((JSONObject)localObject1).getString("goimg")));
    ((ByteVector)localObject2).putByte(getString(((JSONObject)localObject1).getString("goname")));
    ((ByteVector)localObject2).put(getString(((JSONObject)localObject1).getString("twitid")));
    ((ByteVector)localObject2).d(getString(((JSONObject)localObject1).getString("twitimg")));
    ((ByteVector)localObject2).putInt(getString(((JSONObject)localObject1).getString("twitname")));
    return localObject2;
  }
}
