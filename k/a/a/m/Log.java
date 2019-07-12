package k.a.a.m;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.ContactsContract.PhoneLookup;
import android.provider.Settings.Secure;
import android.support.v4.package_7.ActivityCompat;
import android.support.v4.package_7.DialogFragment;
import android.support.v4.package_7.FragmentActivity;
import android.support.v4.package_7.FragmentManager;
import android.support.v7.app.AlertDialog.Builder;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.Base64;
import android.util.Patterns;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.webkit.WebStorage;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.android.analytics.HitBuilders.EventBuilder;
import com.google.android.android.analytics.HitBuilders.HitBuilder;
import com.google.android.android.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.android.analytics.Tracker;
import f.l.a.b.ClassWriter;
import in.spicedigital.umang.activities.AadhaarProfileScreen;
import in.spicedigital.umang.activities.AccountSettingScreen;
import in.spicedigital.umang.activities.BrowserScreen;
import in.spicedigital.umang.activities.DigiLockerMenuScreen;
import in.spicedigital.umang.activities.DigilockerTabScreen;
import in.spicedigital.umang.activities.DowntimeScreen;
import in.spicedigital.umang.activities.FeedbackScreen;
import in.spicedigital.umang.activities.HelpScreen;
import in.spicedigital.umang.activities.MainActivity;
import in.spicedigital.umang.activities.MyProfileGeneral;
import in.spicedigital.umang.activities.MyProfileScreen;
import in.spicedigital.umang.activities.ServiceInformationScreenNew;
import in.spicedigital.umang.activities.SettingScreen;
import in.spicedigital.umang.activities.SocialMediaAccountScreen;
import in.spicedigital.umang.activities.WebActivity;
import in.spicedigital.umang.application.MyApplication;
import in.spicedigital.umang.services.BigQueryUploadDataService;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k.a.a.c.ByteVector;
import k.a.a.c.i;
import k.a.a.l.LoaderTask;
import org.json.JSONException;
import org.json.JSONObject;
import org.yaxim.androidclient.MainWindow;
import org.yaxim.androidclient.chat.ChatWindow;
import org.yaxim.androidclient.util.PreferenceConstants;
import support.android.v4.content.ContextCompat;

public class Log
{
  public static final String LOG_NAME = "MyUtils";
  public static internal.view.menu.k connectThread;
  
  public Log() {}
  
  public static internal.view.menu.k a(Activity paramActivity)
  {
    internal.view.menu.k localK = new internal.view.menu.k(paramActivity, 5);
    localK.a().a(ContextCompat.getColor(paramActivity, 2131099718));
    localK.show(paramActivity.getResources().getString(2131755614));
    localK.setCancelable(false);
    localK.show();
    return localK;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    Activity localActivity = (Activity)paramContext;
    paramContext = getValue(localActivity, 2130903065, paramString2);
    paramString2 = getValue(localActivity, 2130903064, paramString2);
    int i = 0;
    localActivity = paramContext[0];
    while (i < paramString2.length)
    {
      if (paramString1.equalsIgnoreCase(paramString2[i])) {
        return paramContext[i];
      }
      i += 1;
    }
    return localActivity;
  }
  
  public static void a(Activity paramActivity, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    Dialog localDialog = f.sufficientlysecure.rootcommands.util.StringBuilder.create(paramActivity, 1, 2131492959, true);
    LinearLayout localLinearLayout1 = (LinearLayout)localDialog.findViewById(2131296636);
    LinearLayout localLinearLayout2 = (LinearLayout)localDialog.findViewById(2131296639);
    LinearLayout localLinearLayout3 = (LinearLayout)localDialog.findViewById(2131296638);
    localLinearLayout3.setVisibility(8);
    LinearLayout localLinearLayout4 = (LinearLayout)localDialog.findViewById(2131296640);
    localLinearLayout4.setVisibility(8);
    LinearLayout localLinearLayout5 = (LinearLayout)localDialog.findViewById(2131296644);
    localLinearLayout5.setVisibility(8);
    Object localObject1 = (LinearLayout)localDialog.findViewById(2131297421);
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        ((View)localObject1).setVisibility(0);
      } else {
        ((View)localObject1).setVisibility(8);
      }
    }
    else {
      ((View)localObject1).setVisibility(8);
    }
    ((View)localObject1).setOnClickListener(new Settings.3(localDialog, paramActivity));
    localObject1 = new f(paramActivity);
    Object localObject2 = new System(paramActivity);
    if (paramBoolean1) {}
    try
    {
      localObject2 = ((System)localObject2).write();
      int i = ((ByteVector)localObject2).b().length();
      if (i > 0)
      {
        str = f.p;
        ((f)localObject1).append(str, ((ByteVector)localObject2).b());
      }
      i = ((ByteVector)localObject2).get().length();
      if (i > 0)
      {
        str = f.b;
        ((f)localObject1).append(str, ((ByteVector)localObject2).get());
      }
      i = ((ByteVector)localObject2).e().length();
      if (i > 0)
      {
        str = f.h;
        ((f)localObject1).append(str, ((ByteVector)localObject2).e());
      }
      i = ((ByteVector)localObject2).read().length();
      if (i <= 0) {
        break label396;
      }
      String str = f.m;
      ((f)localObject1).append(str, ((ByteVector)localObject2).read());
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
      ((f)localObject1).append(f.p, "");
      ((f)localObject1).append(f.b, "");
      ((f)localObject1).append(f.m, "");
    }
    localObject2 = f.p;
    ((f)localObject1).append((String)localObject2, "");
    localObject2 = f.b;
    ((f)localObject1).append((String)localObject2, "");
    localObject2 = f.m;
    ((f)localObject1).append((String)localObject2, "");
    label396:
    if (((f)localObject1).get(f.p, "").length() > 0) {
      localLinearLayout3.setVisibility(0);
    }
    if (((f)localObject1).get(f.b, "").length() > 0) {
      localLinearLayout4.setVisibility(0);
    }
    if (((f)localObject1).get(f.m, "").length() > 0) {
      localLinearLayout5.setVisibility(0);
    }
    localLinearLayout1.setOnClickListener(new Settings.1(localDialog, paramActivity, paramUri));
    localLinearLayout2.setOnClickListener(new k(localDialog, paramActivity));
    localLinearLayout3.setOnClickListener(new HomeActivity.6((f)localObject1, paramActivity, localDialog));
    localLinearLayout4.setOnClickListener(new MainActivity.1((f)localObject1, paramActivity, localDialog));
    localLinearLayout5.setOnClickListener(new e((f)localObject1, paramActivity, localDialog));
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      f localF = new f(paramContext);
      String str = f.FALSE;
      localF.put(str, "true");
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
    }
    try
    {
      Intent localIntent = new Intent(paramContext, DowntimeScreen.class);
      localIntent.setFlags(268468224);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      Object localObject = new f(paramContext);
      String str = f.version;
      boolean bool = ((f)localObject).add(str, "y").equalsIgnoreCase("y");
      if (bool)
      {
        localObject = new Intent(paramContext, BigQueryUploadDataService.class);
        ((Intent)localObject).putExtra("type", "exception");
        ((Intent)localObject).putExtra("log", paramString);
        paramContext.startService((Intent)localObject);
        return;
      }
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
    }
  }
  
  public static void a(Context paramContext, k.a.a.c.Log paramLog, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ServiceInformationScreenNew.class);
    localIntent.putExtra("SERVICE_NAME", paramLog.getValue());
    localIntent.putExtra("SERVICE_IMG", paramLog.getText());
    localIntent.putExtra("SERVICE_DESCP", paramLog.getDesc());
    localIntent.putExtra("SERVICE_RATING", paramLog.getID());
    localIntent.putExtra("SERVICE_LAT", paramLog.getSort());
    localIntent.putExtra("SERVICE_LNG", paramLog.i());
    localIntent.putExtra("SERVICE_PHONE", paramLog.get());
    localIntent.putExtra("SERVICE_URL", paramLog.readClass());
    localIntent.putExtra("SERVICE_CAT", paramLog.getNumber());
    localIntent.putExtra("SERVICE_ID", paramLog.getName());
    localIntent.putExtra("SERVICE_WEBSITE", paramLog.getTAG());
    localIntent.putExtra("SERVICE_EMAIL", paramLog.getColor());
    localIntent.putExtra("SERVICE_ADDRESS", paramLog.e());
    localIntent.putExtra("SERVICE_WORKING_HOURS", paramLog.getLog());
    localIntent.putExtra("SERVICE_IS_FAVOURITE", paramLog.isEnabled());
    localIntent.putExtra("SERVICE_STATE_ID", paramLog.save());
    localIntent.putExtra("SERVICE_TYPE", paramLog.write());
    localIntent.putExtra("showDesc", paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  public static void access$getDismiss(ProgressDialog paramProgressDialog)
  {
    paramProgressDialog.dismiss();
  }
  
  public static String add(Context paramContext)
  {
    f localF = new f(paramContext);
    try
    {
      paramContext = new System(paramContext).get();
      String str = f.g;
      localF.append(str, paramContext.get());
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
    }
    return localF.get(f.g, "");
  }
  
  public static String add(String paramString)
  {
    try
    {
      paramString = paramString.split(" ");
      int i = 0;
      while (i < paramString.length)
      {
        String str = paramString[i];
        int j = str.length();
        if (j == 6)
        {
          boolean bool = log(str);
          if (bool) {
            return str;
          }
        }
        i += 1;
      }
      return "";
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
  }
  
  public static void add(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    start(paramContext, paramString1);
    call(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5);
    if (new f(paramContext).get(f.mCallback, "").equalsIgnoreCase("Y"))
    {
      paramContext.startActivity(new Intent(paramContext, DigilockerTabScreen.class));
      return;
    }
    paramContext.startActivity(new Intent(paramContext, DigiLockerMenuScreen.class));
  }
  
  public static boolean apply(String paramString)
  {
    boolean bool2 = Pattern.compile("\\d{12}").matcher(paramString).matches();
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = Label.b(paramString);
    }
    return bool1;
  }
  
  public static void call(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Object localObject1;
    try
    {
      String str = new System(paramContext).getKey();
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    try
    {
      JSONObject localJSONObject = execute(paramContext);
      localObject1 = localJSONObject;
      localJSONObject.put("tstamp", "");
      localJSONObject.put("usrid", localObject2);
      localJSONObject.put("apptab", paramString2);
      localJSONObject.put("appsection", paramString3);
      localJSONObject.put("state", paramString4);
      localJSONObject.put("bannerid", paramString5);
      localJSONObject.put("mode", "app");
      localJSONObject.put("deptid", paramString1);
      localJSONObject.put("srvid", "0");
      localJSONObject.put("subsrvid", "0");
      localJSONObject.put("subsrvid2", "0");
      localJSONObject.put("formtrkr", "0");
    }
    catch (Exception paramString1)
    {
      StringBuilder.append(paramString1);
      localObject1 = null;
    }
    if (localObject1 != null) {
      new k.a.a.l.List(new OverlayList(), "https://app.umang.gov.in/umang/coreapi/ws2/bilogs", (JSONObject)localObject1, paramContext).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }
  }
  
  public static boolean check(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static String checksum(Context paramContext, String paramString)
  {
    String str = "";
    try
    {
      new f(paramContext);
      paramContext = MessageDigest.getInstance("MD5");
      java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("|");
      paramString = MyApplication.f;
      localStringBuilder.append(paramString);
      paramContext.update(localStringBuilder.toString().getBytes());
      paramContext = paramContext.digest();
      paramString = new StringBuffer("");
      int i = 0;
      while (i < paramContext.length)
      {
        int j = paramContext[i];
        paramString.append(Integer.toString((j & 0xFF) + 256, 16).substring(1));
        i += 1;
      }
      paramContext = paramString.toString();
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
      paramContext = str;
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("getMD5 : ", paramContext);
    return paramContext;
  }
  
  public static ArrayList collectAndSendLog(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramContext.getResources().getString(2131756191));
    localArrayList.add(paramContext.getResources().getString(2131756192));
    localArrayList.add(paramContext.getResources().getString(2131756193));
    localArrayList.add(paramContext.getResources().getString(2131756194));
    localArrayList.add(paramContext.getResources().getString(2131756195));
    return localArrayList;
  }
  
  public static void collectAndSendLog(Context paramContext, Throwable paramThrowable)
  {
    StringBuilder.e(paramThrowable);
    new AlertDialog.Builder(paramContext).setMessage(paramThrowable.getMessage()).setPositiveButton(17039370, new Log.FireIntent()).show();
  }
  
  public static String convertToHex(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[i] >>> 4 & 0xF;
      int j = 0;
      for (;;)
      {
        if ((k >= 0) && (k <= 9)) {
          localStringBuffer.append((char)(k + 48));
        } else {
          localStringBuffer.append((char)(k - 10 + 97));
        }
        k = paramArrayOfByte[i] & 0xF;
        if (j >= 1)
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static void create(Context paramContext, String paramString)
  {
    Dialog localDialog = new Dialog(paramContext);
    localDialog.getWindow();
    localDialog.requestWindowFeature(1);
    localDialog.setContentView(2131493187);
    localDialog.setCancelable(true);
    ((TextView)localDialog.findViewById(2131296456)).setOnClickListener(new Functions.1(localDialog));
    ((TextView)localDialog.findViewById(2131297566)).setOnClickListener(new EditEventView.6(localDialog, paramContext));
    ((TextView)localDialog.findViewById(2131297143)).setText(Html.fromHtml(paramString));
    localDialog.show();
  }
  
  public static String d(Context paramContext)
  {
    return new f(paramContext).get(f.tag, "");
  }
  
  public static String decrypt(Context paramContext, String paramString)
  {
    String str = "";
    try
    {
      new f(paramContext);
      paramContext = MessageDigest.getInstance("SHA-256");
      java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("|");
      paramString = MyApplication.t;
      localStringBuilder.append(paramString);
      paramContext.update(localStringBuilder.toString().getBytes());
      paramContext = paramContext.digest();
      paramString = new StringBuffer("");
      int i = 0;
      while (i < paramContext.length)
      {
        int j = paramContext[i];
        paramString.append(Integer.toString((j & 0xFF) + 256, 16).substring(1));
        i += 1;
      }
      paramContext = paramString.toString();
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
      paramContext = str;
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("getMD5 : ", paramContext);
    return paramContext;
  }
  
  public static String doInBackground(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64);
      paramContext = signatures;
      if (paramContext.length > 0)
      {
        paramContext = paramContext[0];
        Object localObject = MessageDigest.getInstance("SHA");
        ((MessageDigest)localObject).update(paramContext.toByteArray());
        paramContext = Base64.encodeToString(((MessageDigest)localObject).digest(), 0);
        localObject = new java.lang.StringBuilder();
        ((java.lang.StringBuilder)localObject).append("...............................");
        ((java.lang.StringBuilder)localObject).append(paramContext);
        ((java.lang.StringBuilder)localObject).toString();
        paramContext = paramContext.trim();
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
    }
    return "";
  }
  
  public static String doInBackground(Context paramContext, String paramString)
  {
    if (ContextCompat.checkSelfPermission(paramContext, "android.permission.READ_EXTERNAL_STORAGE") == 0)
    {
      try
      {
        String str = new System(paramContext).getKey();
      }
      catch (Exception localException) {}
      try
      {
        StringBuilder.append(localException);
        Object localObject1 = "";
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localObject1 = new java.lang.StringBuilder();
        ((java.lang.StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().toString());
        ((java.lang.StringBuilder)localObject1).append("/UMANG/Digilocker/");
        ((java.lang.StringBuilder)localObject1).append(decrypt(paramContext, (String)localObject2));
        paramContext = ((java.lang.StringBuilder)localObject1).toString();
        localObject1 = new java.lang.StringBuilder();
        ((java.lang.StringBuilder)localObject1).append("Path: ");
        ((java.lang.StringBuilder)localObject1).append(paramContext);
        ((java.lang.StringBuilder)localObject1).toString();
        paramContext = new File(paramContext).listFiles();
        int i = 0;
        while (i < paramContext.length)
        {
          localObject1 = paramContext[i];
          boolean bool = ((File)localObject1).getName().equalsIgnoreCase(paramString);
          if (bool)
          {
            paramContext = paramContext[i];
            paramContext = paramContext.getAbsolutePath();
            return paramContext;
          }
          i += 1;
        }
        return "";
      }
      catch (Exception paramContext)
      {
        StringBuilder.append(paramContext);
      }
    }
  }
  
  public static String doInBackground(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      Charset localCharset = StandardCharsets.UTF_8;
      paramString = Base64.encodeToString(localMessageDigest.digest(paramString.getBytes(localCharset)), 0).trim();
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public static String e(Context paramContext)
  {
    return new f(paramContext).get(f.name, "");
  }
  
  public static void exec(Context paramContext)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append(paramContext.getExternalFilesDir(null).getPath());
    paramContext = f.sufficientlysecure.rootcommands.util.StringBuilder.append("logcat -f ", f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, File.separator, "umang_app.log"), " -v time -d *:V");
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("command: ", paramContext);
    try
    {
      Runtime.getRuntime().exec(paramContext);
      return;
    }
    catch (IOException paramContext)
    {
      StringBuilder.append(paramContext);
    }
  }
  
  public static String execute()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static JSONObject execute(Context paramContext)
    throws Exception
  {
    f localF = new f(paramContext);
    String str = getResourcesgetConfigurationlocale.toString();
    if (str.contains("GB")) {
      str = f.sufficientlysecure.rootcommands.util.StringBuilder.format(str, -3, 0);
    } else {
      str = "en";
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("==>", str);
    str = localF.get(f.c, str);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("did", getValue(paramContext));
    localJSONObject.put("imei", getDeviceId(paramContext));
    localJSONObject.put("imsi", getPhoneNumber(paramContext));
    localJSONObject.put("hmk", get());
    localJSONObject.put("hmd", getName());
    localJSONObject.put("os", getString());
    localJSONObject.put("osver", execute());
    localJSONObject.put("pkg", paramContext.getPackageName());
    localJSONObject.put("ver", getVersion(paramContext));
    localJSONObject.put("tkn", localF.get(f.this$0, ""));
    localJSONObject.put("rot", getValue());
    localJSONObject.put("mod", "app");
    localJSONObject.put("mcc", start(paramContext));
    localJSONObject.put("mnc", get(paramContext));
    localJSONObject.put("lac", parse(paramContext));
    localJSONObject.put("clid", getCurrentCell(paramContext));
    localJSONObject.put("acc", "");
    localJSONObject.put("lat", "");
    localJSONObject.put("lon", "");
    localJSONObject.put("peml", getAccountName(paramContext));
    localJSONObject.put("lang", str);
    localJSONObject.put("aadhr", d(paramContext));
    localJSONObject.put("node", value(paramContext));
    return localJSONObject;
  }
  
  public static void execute(Activity paramActivity, String paramString)
  {
    try
    {
      paramActivity = paramActivity.getApplication();
      paramActivity = (MyApplication)paramActivity;
      paramActivity = paramActivity.get();
      paramActivity.setScreenName(paramString);
      paramActivity.send(new HitBuilders.ScreenViewBuilder().build());
      return;
    }
    catch (Exception paramActivity)
    {
      StringBuilder.append(paramActivity);
    }
  }
  
  public static void execute(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool = paramContext instanceof Activity;
    Object localObject2 = null;
    if (bool) {
      update((Activity)paramContext, null, "Attention Dialog Button", "clicked", "On Attention Dialog");
    }
    Object localObject1;
    if (paramString1.equalsIgnoreCase("youtube"))
    {
      localObject1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
    }
    else if (paramString1.equalsIgnoreCase("playstore"))
    {
      localObject1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
    }
    else if (paramString1.equalsIgnoreCase("browser"))
    {
      localObject1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
    }
    else if (paramString1.equalsIgnoreCase("webview"))
    {
      paramString1 = paramString2.split("\\|");
      paramString2 = paramString1[0];
      paramString1 = f.sufficientlysecure.rootcommands.util.StringBuilder.get(paramContext, BrowserScreen.class, "title", paramString1[1]);
      localObject1 = paramString1;
      paramString1.putExtra("url", paramString2);
    }
    else if (paramString1.equalsIgnoreCase("rating"))
    {
      localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.get(paramContext, MainActivity.class, "showRating", "showRating");
    }
    else if (paramString1.equalsIgnoreCase("share"))
    {
      localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.get(paramContext, MainActivity.class, "share", "share");
    }
    else if (paramString1.equalsIgnoreCase("openAppWithTab"))
    {
      localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.get(paramContext, MainActivity.class, "openAppWithTab", paramString2);
    }
    else if (paramString1.equalsIgnoreCase("openAppWithScreen"))
    {
      if (paramString2.equalsIgnoreCase("settings")) {
        localObject1 = new Intent(paramContext, SettingScreen.class);
      } else if (paramString2.equalsIgnoreCase("help")) {
        localObject1 = new Intent(paramContext, HelpScreen.class);
      } else if (paramString2.equalsIgnoreCase("social")) {
        localObject1 = new Intent(paramContext, SocialMediaAccountScreen.class);
      } else if (paramString2.equalsIgnoreCase("aadhaar")) {
        localObject1 = new Intent(paramContext, AadhaarProfileScreen.class);
      } else if (paramString2.equalsIgnoreCase("feedback")) {
        localObject1 = new Intent(paramContext, FeedbackScreen.class);
      } else if (paramString2.equalsIgnoreCase("accountsettings")) {
        localObject1 = new Intent(paramContext, AccountSettingScreen.class);
      } else if (paramString2.equalsIgnoreCase("myprofile")) {
        localObject1 = new Intent(paramContext, MyProfileScreen.class);
      } else if (paramString2.equalsIgnoreCase("myprofilegeneral")) {
        localObject1 = new Intent(paramContext, MyProfileGeneral.class);
      } else {
        localObject1 = new Intent(paramContext, MainActivity.class);
      }
    }
    else
    {
      localObject1 = localObject2;
      if (paramString1.equalsIgnoreCase("service"))
      {
        paramString1 = paramString2.split("\\|");
        String str1 = paramString1[0];
        paramString2 = paramString1[1];
        String str2 = paramString1[2];
        if (str2 != null)
        {
          if (!str2.equalsIgnoreCase(""))
          {
            paramString1 = k.a.a.e.System.getInstance(paramContext).read(str2);
            if (paramString1 != null)
            {
              paramString1.getText();
              paramString1 = paramString1.getValue();
            }
            else
            {
              paramString1 = paramContext.getResources().getString(2131755289);
            }
            if ((paramString2 != null) && (!paramString2.equalsIgnoreCase(""))) {
              paramString1 = paramString2;
            }
            if (setText(str1))
            {
              add(paramContext, str2, "attention_screen", "", "", "");
              localObject1 = localObject2;
            }
            else
            {
              paramString2 = f.sufficientlysecure.rootcommands.util.StringBuilder.get(paramContext, WebActivity.class, "fromNotif", "fromNotif");
              localObject1 = paramString2;
              paramString2.putExtra("service_name", paramString1);
              paramString2.putExtra("service_url", str1);
              paramString2.putExtra("service_id", str2);
              paramString2.putExtra("source_tab", "attention_screen");
              paramString2.putExtra("source_section", "");
              paramString2.putExtra("source_state", "");
              paramString2.putExtra("source_banner", "");
            }
          }
          else
          {
            localObject1 = new Intent(paramContext, MainActivity.class);
          }
        }
        else {
          localObject1 = new Intent(paramContext, MainActivity.class);
        }
      }
    }
    if (localObject1 != null) {
      try
      {
        paramContext.startActivity((Intent)localObject1);
        return;
      }
      catch (Exception paramContext)
      {
        StringBuilder.append(paramContext);
      }
    }
  }
  
  public static String f(Context paramContext, String paramString)
  {
    new f(paramContext);
    return paramString;
  }
  
  public static String findBinary(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = new String[8];
    arrayOfString[0] = "/sbin/";
    arrayOfString[1] = "/system/bin/";
    arrayOfString[2] = "/system/xbin/";
    arrayOfString[3] = "/data/local/xbin/";
    arrayOfString[4] = "/data/local/bin/";
    arrayOfString[5] = "/system/sd/xbin/";
    arrayOfString[6] = "/system/bin/failsafe/";
    arrayOfString[7] = "/data/local/";
    int j = arrayOfString.length;
    int i = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        String str = arrayOfString[i];
        try
        {
          java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(paramString);
          bool1 = new File(localStringBuilder.toString()).exists();
          if (bool1) {
            bool1 = true;
          } else {
            i += 1;
          }
        }
        catch (Exception paramString)
        {
          StringBuilder.append(paramString);
          bool1 = bool2;
        }
      }
    }
    paramString = new java.lang.StringBuilder();
    paramString.append("ROOTED : ");
    paramString.append(bool1);
    paramString.toString();
    if (bool1) {
      return "yes";
    }
    return "no";
  }
  
  public static String format(double paramDouble)
  {
    if (paramDouble < 1024.0D) {
      return f.sufficientlysecure.rootcommands.util.StringBuilder.toString(String.valueOf(paramDouble), " bytes");
    }
    if (paramDouble < 1048576.0D) {
      return f.sufficientlysecure.rootcommands.util.StringBuilder.toString(String.valueOf(round(paramDouble / 1024.0D)), " KB");
    }
    if (paramDouble < 1.073741824E9D) {
      return f.sufficientlysecure.rootcommands.util.StringBuilder.toString(String.valueOf(round(paramDouble / 1024.0D / 1024.0D)), " MB");
    }
    return f.sufficientlysecure.rootcommands.util.StringBuilder.toString(String.valueOf(round(paramDouble / 1024.0D / 1024.0D / 1024.0D)), " GB");
  }
  
  public static String format(String paramString)
  {
    try
    {
      paramString = paramString.substring(0, paramString.indexOf("."));
      Locale localLocale = Locale.US;
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", localLocale).parse(paramString);
      localLocale = Locale.US;
      paramString = new SimpleDateFormat("E, MMM d", localLocale).format(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return "";
  }
  
  public static String formatDate(String paramString)
  {
    Locale localLocale = Locale.US;
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", localLocale).parse(paramString);
      localLocale = Locale.US;
      paramString = new SimpleDateFormat("dd MMM yyyy HH:mm", localLocale).format(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return "";
  }
  
  public static String formatDate(String paramString1, String paramString2)
  {
    Object localObject = Locale.US;
    try
    {
      localObject = new SimpleDateFormat("dd/MM/yyyy HH:mm", (Locale)localObject);
      java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString2);
      paramString1 = ((SimpleDateFormat)localObject).parse(localStringBuilder.toString());
      paramString2 = Locale.US;
      paramString1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", paramString2).format(paramString1);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      StringBuilder.append(paramString1);
    }
    return "";
  }
  
  public static String get()
  {
    try
    {
      Object localObject = new java.lang.StringBuilder();
      ((java.lang.StringBuilder)localObject).append("");
      String str = Build.MANUFACTURER;
      ((java.lang.StringBuilder)localObject).append(str);
      localObject = ((java.lang.StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
    }
    return "";
  }
  
  public static String get(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSystemService("phone");
      paramContext = (TelephonyManager)paramContext;
      paramContext = paramContext.getNetworkOperator();
      if (paramContext != null)
      {
        boolean bool = paramContext.equalsIgnoreCase("");
        if (!bool)
        {
          paramContext = paramContext.substring(3);
          return paramContext;
        }
      }
      else
      {
        return "";
      }
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
    }
    return "";
  }
  
  public static String get(Context paramContext, String paramString)
  {
    String[] arrayOfString = paramContext.getResources().getStringArray(2130903065);
    paramContext = paramContext.getResources().getStringArray(2130903064);
    int i = 0;
    String str = arrayOfString[0];
    while (i < paramContext.length)
    {
      if (paramString.equalsIgnoreCase(paramContext[i])) {
        return arrayOfString[i];
      }
      i += 1;
    }
    return str;
  }
  
  public static String get(String paramString)
    throws Exception
  {
    if (paramString.length() > 0)
    {
      GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
      GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
      int i = 0;
      paramString = new SimpleDateFormat("dd-MM-yyyy", Locale.US).parse(paramString);
      Date localDate = new Date();
      localGregorianCalendar1.setTime(paramString);
      localGregorianCalendar2.setTime(localDate);
      if (localGregorianCalendar2.get(6) < localGregorianCalendar1.get(6)) {
        i = -1;
      }
      return f.sufficientlysecure.rootcommands.util.StringBuilder.toString("", localGregorianCalendar2.get(1) - localGregorianCalendar1.get(1) + i);
    }
    return "";
  }
  
  public static Account getAccount(Context paramContext, AccountManager paramAccountManager)
  {
    try
    {
      int i = ContextCompat.checkSelfPermission(paramContext, "android.permission.GET_ACCOUNTS");
      if (i == 0)
      {
        paramContext = paramAccountManager.getAccountsByType("com.google");
        if (paramContext.length > 0) {
          return paramContext[0];
        }
      }
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
    }
    return null;
  }
  
  public static String getAccountName(Context paramContext)
  {
    paramContext = getAccount(paramContext, AccountManager.get(paramContext));
    if (paramContext == null) {
      return "";
    }
    return name;
  }
  
  public static String getAppName(Context paramContext)
  {
    return paramContext.getPackageName();
  }
  
  public static String getChecksum(String paramString)
  {
    try
    {
      paramString = paramString.split("\\|");
      return paramString[1];
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return "3";
  }
  
  public static String getCurrentCell(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSystemService("phone");
      paramContext = (TelephonyManager)paramContext;
      int i = paramContext.getPhoneType();
      if (i == 1)
      {
        paramContext = paramContext.getCellLocation();
        paramContext = (GsmCellLocation)paramContext;
        if (paramContext != null)
        {
          java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramContext.getCid());
          paramContext = localStringBuilder.toString();
          return paramContext;
        }
      }
      else
      {
        return "";
      }
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String getDate()
  {
    return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
  }
  
  public static String getDate(String paramString)
  {
    try
    {
      paramString = paramString.substring(0, paramString.indexOf("."));
      Locale localLocale = Locale.US;
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", localLocale).parse(paramString);
      localLocale = Locale.US;
      paramString = new SimpleDateFormat("MMMM dd 'at' hh:mm a", localLocale).format(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return "";
  }
  
  public static String getDeviceId(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSystemService("phone");
      paramContext = (TelephonyManager)paramContext;
      paramContext = paramContext.getDeviceId();
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    paramContext = "";
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("IMEI : ", paramContext);
    return paramContext;
  }
  
  public static String getID(String paramString)
  {
    String str = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
    if (str.equalsIgnoreCase("banner1eng")) {
      str = "drawable://2131230867";
    } else if (str.equalsIgnoreCase("banner_cbse_eng2")) {
      str = "drawable://2131230868";
    } else if (str.equalsIgnoreCase("pmkvy_eng")) {
      str = "drawable://2131230869";
    } else if (str.equalsIgnoreCase("banner_ncert")) {
      str = "drawable://2131230870";
    } else if (str.equalsIgnoreCase("banner_pmay")) {
      str = "drawable://2131230871";
    } else {
      str = paramString;
    }
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append("BANNER IMAGE URL : ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("------------");
    localStringBuilder.append(str);
    localStringBuilder.toString();
    return str;
  }
  
  public static void getImage(Activity paramActivity)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
      localIntent.addCategory("android.intent.category.OPENABLE");
      localIntent.setType("image/*");
      paramActivity.startActivityForResult(localIntent, 2019);
      MyApplication.started = true;
      return;
    }
    catch (Exception paramActivity)
    {
      StringBuilder.append(paramActivity);
    }
  }
  
  public static String getImeiHash(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
  }
  
  public static String getListTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    return new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.US).format(localCalendar.getTime());
  }
  
  public static String getListTime(String paramString)
  {
    Locale localLocale = Locale.US;
    try
    {
      paramString = new SimpleDateFormat("dd/MM/yyyy", localLocale).parse(paramString);
      localLocale = Locale.US;
      paramString = new SimpleDateFormat("EEE", localLocale).format(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return "";
  }
  
  public static String getLocalIpAddress(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSystemService("connectivity");
      paramContext = (ConnectivityManager)paramContext;
      boolean bool1 = paramContext.getNetworkInfo(1).isConnected();
      boolean bool2 = paramContext.getNetworkInfo(0).isConnected();
      if (bool1) {
        return "wifi";
      }
      if (bool2) {
        return "mobile_data";
      }
      return "no_newtork";
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
      java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
      localStringBuilder.append("");
      return f.sufficientlysecure.rootcommands.util.StringBuilder.e(paramContext, localStringBuilder);
    }
  }
  
  public static String getLog(String paramString)
  {
    String str = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
    if (str.equalsIgnoreCase("USP_01")) {
      paramString = "drawable://2131231552";
    } else if (str.equalsIgnoreCase("tour2")) {
      paramString = "drawable://2131231553";
    } else if (str.equalsIgnoreCase("tour3")) {
      paramString = "drawable://2131231554";
    } else if (str.equalsIgnoreCase("img_tour4_new")) {
      paramString = "drawable://2131231555";
    } else if (str.equalsIgnoreCase("multilingual_support")) {
      paramString = "drawable://2131231556";
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("tour img....................", paramString);
    return paramString;
  }
  
  public static ArrayList getLog(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramContext.getResources().getString(2131756197));
    localArrayList.add(paramContext.getResources().getString(2131756198));
    localArrayList.add(paramContext.getResources().getString(2131756199));
    localArrayList.add(paramContext.getResources().getString(2131756200));
    localArrayList.add(paramContext.getResources().getString(2131756201));
    return localArrayList;
  }
  
  public static String getMimeType(String paramString)
  {
    try
    {
      int i = paramString.lastIndexOf(".");
      if (i != -1)
      {
        i = paramString.lastIndexOf(".");
        paramString = paramString.substring(i + 1);
        paramString = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString.toLowerCase());
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return "";
  }
  
  public static String getName()
  {
    try
    {
      Object localObject = new java.lang.StringBuilder();
      ((java.lang.StringBuilder)localObject).append("");
      String str = Build.MODEL;
      ((java.lang.StringBuilder)localObject).append(str);
      localObject = ((java.lang.StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
    }
    return "";
  }
  
  public static boolean getName(Context paramContext, String paramString)
  {
    paramString = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(paramString));
    paramContext = paramContext.getContentResolver().query(paramString, new String[] { "_id", "number", "display_name" }, null, null, null);
    try
    {
      boolean bool = paramContext.moveToFirst();
      if (bool)
      {
        paramContext.close();
        return true;
      }
      paramContext.close();
      return false;
    }
    catch (Throwable paramString)
    {
      if (paramContext != null) {
        paramContext.close();
      }
      throw paramString;
    }
  }
  
  public static String getNetworkInfo(Context paramContext)
  {
    return ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
  }
  
  public static String getPhoneNumber(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      paramContext = paramContext.getSubscriberId();
    }
    catch (Exception paramContext)
    {
      java.lang.StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Ex in getImsiNumber...");
      localStringBuilder.append(paramContext.getMessage());
      localStringBuilder.toString();
      paramContext = "";
    }
    if (paramContext == null) {
      return "";
    }
    return paramContext;
  }
  
  public static String getString()
  {
    try
    {
      Object localObject = new java.lang.StringBuilder();
      ((java.lang.StringBuilder)localObject).append("Android ");
      String str = Build.VERSION.RELEASE;
      ((java.lang.StringBuilder)localObject).append(str);
      localObject = ((java.lang.StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
    }
    return "";
  }
  
  public static String getTime()
  {
    try
    {
      Object localObject = Calendar.getInstance();
      Locale localLocale = Locale.US;
      localObject = new SimpleDateFormat("dd-MMM-yyyy", localLocale).format(((Calendar)localObject).getTime());
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
    }
    return "";
  }
  
  public static String getTime(String paramString)
  {
    try
    {
      paramString = paramString.substring(0, paramString.indexOf("."));
      Locale localLocale = Locale.US;
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", localLocale).parse(paramString);
      localLocale = Locale.US;
      paramString = new SimpleDateFormat("dd-MM-yyyy HH:mm", localLocale).format(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return "";
  }
  
  public static String getTimestamp(String paramString)
  {
    Locale localLocale = Locale.US;
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", localLocale).parse(paramString);
      localLocale = Locale.US;
      paramString = new SimpleDateFormat("dd MMM yyyy", localLocale).format(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return "";
  }
  
  public static String getType(Context paramContext, Uri paramUri)
  {
    try
    {
      paramContext = paramContext.getContentResolver().getType(paramUri);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
    }
    return "";
  }
  
  public static String getValue()
  {
    if (Utils.isDeviceRooted()) {
      return "yes";
    }
    return "no";
  }
  
  public static String getValue(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    paramContext = "";
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("DEVICE ID : ", paramContext);
    return paramContext;
  }
  
  public static String[] getValue(Activity paramActivity, int paramInt, String paramString)
  {
    try
    {
      Configuration localConfiguration = new Configuration(paramActivity.getResources().getConfiguration());
      localConfiguration.setLocale(new Locale(paramString));
      paramActivity = paramActivity.createConfigurationContext(localConfiguration).getResources().getStringArray(paramInt);
      return paramActivity;
    }
    catch (Exception paramActivity)
    {
      StringBuilder.append(paramActivity);
    }
    return new String[0];
  }
  
  public static String getVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
      localStringBuilder.append("");
      int i = versionCode;
      localStringBuilder.append(i);
      paramContext = localStringBuilder.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
    }
    return "";
  }
  
  public static void hide(Activity paramActivity)
  {
    try
    {
      Object localObject = paramActivity.getSystemService("input_method");
      localObject = (InputMethodManager)localObject;
      ((InputMethodManager)localObject).hideSoftInputFromWindow(paramActivity.getCurrentFocus().getWindowToken(), 0);
      return;
    }
    catch (Exception paramActivity)
    {
      StringBuilder.append(paramActivity);
    }
  }
  
  public static ArrayList i(Context paramContext)
  {
    paramContext = new ArrayList();
    paramContext.add("");
    paramContext.add("Hindi");
    paramContext.add("Assamese");
    paramContext.add("Bengali");
    paramContext.add("Gujarati");
    paramContext.add("Kannada");
    paramContext.add("Malayalam");
    paramContext.add("Marathi");
    paramContext.add("Oriya");
    paramContext.add("Punjabi");
    paramContext.add("Tamil");
    paramContext.add("Telugu");
    paramContext.add("Urdu");
    return paramContext;
  }
  
  public static long init(int paramInt1, int paramInt2)
  {
    return new SecureRandom().nextInt(paramInt2 - paramInt1 + 1) + paramInt1;
  }
  
  public static String init(Activity paramActivity, int paramInt, String paramString)
  {
    try
    {
      Configuration localConfiguration = new Configuration(paramActivity.getResources().getConfiguration());
      localConfiguration.setLocale(new Locale(paramString));
      paramActivity = paramActivity.createConfigurationContext(localConfiguration).getResources().getString(paramInt);
      return paramActivity;
    }
    catch (Exception paramActivity)
    {
      StringBuilder.append(paramActivity);
    }
    return "";
  }
  
  public static String init(String paramString)
  {
    Locale localLocale = Locale.US;
    try
    {
      paramString = new SimpleDateFormat("dd/MM/yyyy", localLocale).parse(paramString);
      localLocale = Locale.US;
      paramString = new SimpleDateFormat("MMM", localLocale).format(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return "";
  }
  
  public static void init(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("in.spicedigital.umang", 64);
      paramContext = signatures;
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramContext[i];
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA");
        localMessageDigest.update(localObject.toByteArray());
        Base64.encodeToString(localMessageDigest.digest(), 0);
        i += 1;
      }
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}catch (NoSuchAlgorithmException paramContext) {}
  }
  
  public static void init(Context paramContext, String paramString)
  {
    paramContext = new Dialog(paramContext);
    paramContext.getWindow();
    paramContext.requestWindowFeature(1);
    paramContext.setContentView(2131493031);
    paramContext.setCancelable(true);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    ((TextView)paramContext.findViewById(2131296634)).setText(paramString);
    ((TextView)paramContext.findViewById(2131297214)).setOnClickListener(new ErrorActivity.3(paramContext));
  }
  
  public static void init(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      Intent localIntent = new Intent(paramContext, BigQueryUploadDataService.class);
      localIntent.putExtra("type", paramString1);
      localIntent.putExtra("resCode", paramString2);
      localIntent.putExtra("rc", paramString3);
      localIntent.putExtra("rd", paramString4);
      localIntent.putExtra("auth", paramString5);
      paramContext.startService(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
    }
  }
  
  public static void init(Context paramContext, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if ((paramJSONObject != null) && (paramBoolean))
    {
      try
      {
        String str1 = paramJSONObject.getString("id");
        paramBoolean = "".equalsIgnoreCase(str1);
        if (paramBoolean) {
          return;
        }
        Object localObject1 = paramJSONObject.getString("title");
        str1 = paramJSONObject.getString("bimg");
        Object localObject2 = paramJSONObject.getString("des");
        Object localObject3 = paramJSONObject.getString("bTxt");
        String str2 = paramJSONObject.getString("actionType");
        paramJSONObject = paramJSONObject.getString("actionUrl");
        Dialog localDialog = new Dialog(paramContext);
        localDialog.getWindow();
        localDialog.requestWindowFeature(1);
        Object localObject4 = localDialog.getWindow();
        ((Window)localObject4).setBackgroundDrawable(new ColorDrawable(0));
        localDialog.setContentView(2131493037);
        localDialog.setCancelable(false);
        localDialog.setCanceledOnTouchOutside(false);
        localDialog.show();
        localObject4 = localDialog.findViewById(2131296852);
        TextView localTextView1 = (TextView)localObject4;
        localObject4 = localDialog.findViewById(2131296620);
        TextView localTextView2 = (TextView)localObject4;
        localObject4 = localDialog.findViewById(2131296324);
        localObject4 = (TextView)localObject4;
        Object localObject5 = localDialog.findViewById(2131296386);
        localObject5 = (ImageView)localObject5;
        Object localObject6 = localDialog.findViewById(2131296540);
        localObject6 = (ImageView)localObject6;
        localTextView1.setText((CharSequence)localObject1);
        localTextView2.setText(Html.fromHtml((String)localObject2));
        ((TextView)localObject4).setText((CharSequence)localObject3);
        localObject1 = f.l.a.b.f.a();
        localObject2 = new f.l.a.b.d().add(2131230872).d(2131230872).getString(2131230872).setId(true).read(true);
        localObject3 = Bitmap.Config.RGB_565;
        localObject2 = ((f.l.a.b.d)localObject2).get((Bitmap.Config)localObject3).getString();
        if (str1 != null)
        {
          paramBoolean = str1.isEmpty();
          if (!paramBoolean)
          {
            ((ImageView)localObject5).setVisibility(0);
            ((f.l.a.b.f)localObject1).a(str1, (ImageView)localObject5, (ClassWriter)localObject2);
            break label364;
          }
        }
        ((ImageView)localObject5).setVisibility(8);
        label364:
        ((View)localObject4).setOnClickListener(new MainActivity.8(localDialog, paramContext, str2, paramJSONObject));
        ((View)localObject6).setOnClickListener(new EulaActivity.1(localDialog));
      }
      catch (Throwable paramContext)
      {
        break label413;
      }
      catch (JSONException paramContext)
      {
        StringBuilder.append(paramContext);
      }
      return;
      label413:
      throw paramContext;
    }
  }
  
  public static void init(Context paramContext, boolean paramBoolean, String paramString)
  {
    Dialog localDialog = new Dialog(paramContext);
    localDialog.requestWindowFeature(1);
    localDialog.setCancelable(true);
    localDialog.setCanceledOnTouchOutside(false);
    localDialog.setContentView(2131493036);
    ImageView localImageView = (ImageView)localDialog.findViewById(2131296889);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131297708);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131297719);
    if (paramBoolean)
    {
      localImageView.setImageResource(2131231216);
      localTextView1.setText(paramContext.getResources().getString(2131756303));
      localTextView2.setVisibility(8);
    }
    ((TextView)localDialog.findViewById(2131296542)).setOnClickListener(new l(localDialog, paramContext, paramString));
    localDialog.setOnCancelListener(new FileChooserActivity.7(paramContext, paramString));
    paramString = new EditActivity.4(localDialog, paramContext);
    localDialog.findViewById(2131297045).setOnClickListener(new Main.8(paramContext, localDialog));
    localDialog.findViewById(2131297022).setOnClickListener(new Dialog.3(paramContext, localDialog));
    localDialog.findViewById(2131297027).setOnClickListener(new FileDialog.4(paramContext, localDialog));
    localDialog.findViewById(2131297802).setOnClickListener(paramString);
    localDialog.show();
  }
  
  public static void init(EditText paramEditText, int paramInt)
  {
    paramEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
  }
  
  public static String initialize(Context paramContext)
  {
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType())
    {
    default: 
      return "Unknown";
    case 13: 
      return "4G";
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return "3G";
    }
    return "2G";
  }
  
  public static void inject(Activity paramActivity, View paramView)
  {
    if (!(paramView instanceof EditText)) {
      paramView.setOnTouchListener(new MainMenu.1(paramActivity));
    }
    if ((paramView instanceof ViewGroup))
    {
      int i = 0;
      for (;;)
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        if (i >= localViewGroup.getChildCount()) {
          break;
        }
        inject(paramActivity, localViewGroup.getChildAt(i));
        i += 1;
      }
    }
  }
  
  public static boolean isAppInstalled(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getPackageInfo(paramString, 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return false;
  }
  
  public static boolean isValidEmail(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return false;
    }
    return Patterns.EMAIL_ADDRESS.matcher(paramCharSequence).matches();
  }
  
  public static void load(Context paramContext)
  {
    f localF = new f(paramContext);
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject3 = execute(paramContext);
      JSONObject localJSONObject1 = localJSONObject3;
      java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(java.lang.System.currentTimeMillis());
      localJSONObject3.put("requestId", localStringBuilder.toString());
      localJSONObject3.put("mno", "");
      localJSONObject3.put("st", "");
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      new LoaderTask(new LogActivity.1(paramContext, localF), localJSONObject2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }
  }
  
  public static String log()
  {
    return new SimpleDateFormat("HH:mm:ss SSS", Locale.US).format(new Date());
  }
  
  public static boolean log(String paramString)
  {
    try
    {
      Double.parseDouble(paramString);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return false;
  }
  
  public static boolean log(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm", Locale.US);
    try
    {
      paramString2 = localSimpleDateFormat.parse(paramString2);
      boolean bool = localSimpleDateFormat.parse(paramString1).before(paramString2);
      return bool;
    }
    catch (Exception paramString1)
    {
      StringBuilder.append(paramString1);
    }
    return false;
  }
  
  public static boolean matches(String paramString)
  {
    boolean bool2 = Pattern.compile("\\d{16}").matcher(paramString).matches();
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = Label.b(paramString);
    }
    return bool1;
  }
  
  public static String message(String paramString)
  {
    String str = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
    if (str.equalsIgnoreCase("u1")) {
      paramString = "drawable://2131231297";
    } else if (str.equalsIgnoreCase("u2")) {
      paramString = "drawable://2131231298";
    } else if (str.equalsIgnoreCase("u3")) {
      paramString = "drawable://2131231299";
    } else if (str.equalsIgnoreCase("u4")) {
      paramString = "drawable://2131231300";
    } else if (str.equalsIgnoreCase("u5")) {
      paramString = "drawable://2131231301";
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("tour img....................", paramString);
    return paramString;
  }
  
  public static void onCreate(Activity paramActivity)
  {
    if (ContextCompat.checkSelfPermission(paramActivity, "android.permission.READ_EXTERNAL_STORAGE") != 0)
    {
      if (ActivityCompat.shouldShowRequestPermissionRationale(paramActivity, "android.permission.READ_EXTERNAL_STORAGE"))
      {
        showDialog(paramActivity, paramActivity.getResources().getString(2131755271));
        return;
      }
      ActivityCompat.requestPermissions(paramActivity, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 1104);
      return;
    }
    getImage(paramActivity);
  }
  
  public static void onCreateDialog(Context paramContext, String paramString)
  {
    paramString = new Dialog(paramContext);
    paramString.getWindow();
    paramString.requestWindowFeature(1);
    paramString.setContentView(2131493015);
    paramString.setCancelable(true);
    paramString.setCanceledOnTouchOutside(false);
    paramString.show();
    TextView localTextView1 = (TextView)paramString.findViewById(2131296645);
    TextView localTextView2 = (TextView)paramString.findViewById(2131296646);
    f localF = new f(paramContext);
    localTextView1.setOnClickListener(new BitmapFragment.1(localF, paramContext));
    localTextView2.setOnClickListener(new BitmapFragment.2(localF, paramContext));
    ((Button)paramString.findViewById(2131297214)).setOnClickListener(new NavitAddressSearchActivity.7(paramString));
  }
  
  public static internal.view.menu.k onOptionsItemSelected(Activity paramActivity)
  {
    internal.view.menu.k localK = new internal.view.menu.k(paramActivity, 5);
    localK.a().a(ContextCompat.getColor(paramActivity, 2131099718));
    localK.show(paramActivity.getResources().getString(2131755874));
    localK.setCancelable(false);
    try
    {
      boolean bool = paramActivity.isFinishing();
      if (!bool)
      {
        localK.show();
        return localK;
      }
    }
    catch (Exception paramActivity)
    {
      StringBuilder.append(paramActivity);
    }
    return localK;
  }
  
  public static String onPostExecute(Context paramContext, String paramString)
  {
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append("getStateIdFromName()..........stateName");
    localStringBuilder.append(paramString);
    localStringBuilder.toString();
    String[] arrayOfString1 = paramContext.getResources().getStringArray(2130903065);
    String[] arrayOfString2 = paramContext.getResources().getStringArray(2130903064);
    int i = 0;
    localStringBuilder = arrayOfString2[0];
    for (;;)
    {
      paramContext = localStringBuilder;
      if (i >= arrayOfString1.length) {
        break;
      }
      if (paramString.equalsIgnoreCase(arrayOfString1[i]))
      {
        paramContext = arrayOfString2[i];
        break;
      }
      i += 1;
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("getStateIdFromName()..........stateName", paramContext);
    return paramContext;
  }
  
  public static void onPostExecute(Context paramContext)
  {
    f localF = new f(paramContext);
    if (localF.get(f.playlist, "false").equalsIgnoreCase("true"))
    {
      boolean bool = PreferenceConstants.isExistingUser;
      int i = 0;
      if ((bool) || (PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance(paramContext)).getBoolean("is_already_connected", false))) {
        i = 1;
      }
      Intent localIntent;
      if (i == 0)
      {
        localIntent = new Intent(paramContext, MainWindow.class);
        localIntent.putExtra("username", localF.get(f.val$name, ""));
        localIntent.putExtra("password", localF.get(f.val$data, ""));
      }
      else
      {
        localIntent = new Intent(paramContext, ChatWindow.class);
        localIntent.setData(Uri.parse("bot@reporting.umang.gov.in"));
        localIntent.addFlags(268435456);
        localIntent.putExtra(ChatWindow.INTENT_EXTRA_USERNAME, "bot@reporting.umang.gov.in");
        localIntent.putExtra("FROM_CHAT_NOTIFICATION", "1");
      }
      paramContext.startActivity(localIntent);
      return;
    }
    load(paramContext);
  }
  
  public static long parse(String paramString)
  {
    try
    {
      Object localObject = new java.lang.StringBuilder();
      ((java.lang.StringBuilder)localObject).append(getTime());
      ((java.lang.StringBuilder)localObject).append(" ");
      ((java.lang.StringBuilder)localObject).append(paramString);
      paramString = ((java.lang.StringBuilder)localObject).toString();
      localObject = Locale.US;
      long l = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", (Locale)localObject).parse(paramString).getTime();
      return l;
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return java.lang.System.currentTimeMillis();
  }
  
  public static String parse(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSystemService("phone");
      paramContext = (TelephonyManager)paramContext;
      paramContext = paramContext.getCellLocation();
      paramContext = (GsmCellLocation)paramContext;
      int i = paramContext.getLac();
      return String.valueOf(i);
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return "";
  }
  
  public static ArrayList parse()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("en");
    localArrayList.add("hi");
    localArrayList.add("as");
    localArrayList.add("bn");
    localArrayList.add("gu");
    localArrayList.add("kn");
    localArrayList.add("ml");
    localArrayList.add("mr");
    localArrayList.add("or");
    localArrayList.add("pa");
    localArrayList.add("ta");
    localArrayList.add("te");
    localArrayList.add("ur");
    return localArrayList;
  }
  
  public static JSONObject parse(JSONObject paramJSONObject, String paramString1, String paramString2)
    throws Exception
  {
    paramJSONObject.remove("lat");
    paramJSONObject.remove("lon");
    paramJSONObject.put("lat", paramString1);
    paramJSONObject.put("lon", paramString2);
    return paramJSONObject;
  }
  
  public static String parseDate(String paramString)
  {
    try
    {
      paramString = paramString.substring(0, paramString.indexOf("."));
      Locale localLocale = Locale.US;
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", localLocale).parse(paramString);
      localLocale = Locale.US;
      paramString = new SimpleDateFormat("hh:mm aa", localLocale).format(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return "";
  }
  
  public static boolean parseDate(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    try
    {
      paramString2 = localSimpleDateFormat.parse(paramString2);
      boolean bool = localSimpleDateFormat.parse(paramString1).before(paramString2);
      return bool;
    }
    catch (Exception paramString1)
    {
      StringBuilder.append(paramString1);
    }
    return false;
  }
  
  public static String parseUrl(String paramString)
  {
    try
    {
      paramString = paramString.split("\\|");
      return paramString[2];
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return "3";
  }
  
  public static String read()
  {
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("");
    ((java.lang.StringBuilder)localObject).append(java.lang.System.currentTimeMillis());
    localObject = ((java.lang.StringBuilder)localObject).toString();
    int i = 0;
    while (i < 5)
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject);
      ((java.lang.StringBuilder)localObject).append(init(0, 9));
      localObject = ((java.lang.StringBuilder)localObject).toString();
      i += 1;
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("getUniqueNumber : ", (String)localObject);
    return localObject;
  }
  
  public static ArrayList read(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramContext.getResources().getString(2131755655));
    localArrayList.add(paramContext.getResources().getString(2131755810));
    localArrayList.add(paramContext.getResources().getString(2131755301));
    localArrayList.add(paramContext.getResources().getString(2131755324));
    localArrayList.add(paramContext.getResources().getString(2131755796));
    localArrayList.add(paramContext.getResources().getString(2131755851));
    localArrayList.add(paramContext.getResources().getString(2131755904));
    localArrayList.add(paramContext.getResources().getString(2131755915));
    localArrayList.add(paramContext.getResources().getString(2131756062));
    localArrayList.add(paramContext.getResources().getString(2131756188));
    localArrayList.add(paramContext.getResources().getString(2131756470));
    localArrayList.add(paramContext.getResources().getString(2131756474));
    localArrayList.add(paramContext.getResources().getString(2131756606));
    return localArrayList;
  }
  
  public static String readLine(String paramString)
  {
    try
    {
      boolean bool = "".equalsIgnoreCase(paramString);
      if (bool) {
        return "3";
      }
      paramString = paramString.split("\\|");
      return paramString[0];
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return "3";
  }
  
  public static String readResource(String paramString)
  {
    Locale localLocale = Locale.US;
    try
    {
      paramString = new SimpleDateFormat("dd-MM-yyyy", localLocale).parse(paramString);
      localLocale = Locale.US;
      paramString = new SimpleDateFormat("dd MMM yyyy", localLocale).format(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return "";
  }
  
  public static void refresh(Activity paramActivity, Uri paramUri)
  {
    if ((ContextCompat.checkSelfPermission(paramActivity, "android.permission.CAMERA") == 0) && (ContextCompat.checkSelfPermission(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0))
    {
      start(paramActivity, paramUri);
      return;
    }
    paramUri = new ArrayList();
    int j = 0;
    int i = j;
    if (ContextCompat.checkSelfPermission(paramActivity, "android.permission.CAMERA") != 0) {
      if (ActivityCompat.shouldShowRequestPermissionRationale(paramActivity, "android.permission.CAMERA"))
      {
        i = 1;
      }
      else
      {
        paramUri.add("android.permission.CAMERA");
        i = j;
      }
    }
    j = i;
    if (ContextCompat.checkSelfPermission(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
      if (ActivityCompat.shouldShowRequestPermissionRationale(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE"))
      {
        j = i + 1;
      }
      else
      {
        paramUri.add("android.permission.WRITE_EXTERNAL_STORAGE");
        j = i;
      }
    }
    if (j > 0)
    {
      showDialog(paramActivity, paramActivity.getResources().getString(2131755264));
      return;
    }
    if (paramUri.size() > 0) {
      ActivityCompat.requestPermissions(paramActivity, (String[])paramUri.toArray(new String[paramUri.size()]), 1101);
    }
  }
  
  public static double round(double paramDouble)
  {
    return Double.valueOf(new DecimalFormat("#.#").format(paramDouble)).doubleValue();
  }
  
  public static boolean setText(String paramString)
  {
    return paramString.equalsIgnoreCase("umang://digilocker");
  }
  
  public static void show(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getSystemService("input_method");
      paramActivity = (InputMethodManager)paramActivity;
      paramActivity.toggleSoftInput(2, 0);
      return;
    }
    catch (Exception paramActivity)
    {
      StringBuilder.append(paramActivity);
    }
  }
  
  public static void show(Activity paramActivity, boolean paramBoolean, String paramString1, String paramString2)
  {
    paramActivity = (FragmentActivity)paramActivity;
    if (paramActivity.getSupportFragmentManager().findFragmentByTag("mpinDialog") == null)
    {
      paramString1 = k.a.a.f.d.newInstance(paramBoolean, paramString1, paramString2);
      paramString1.show(paramActivity.getSupportFragmentManager(), "mpinDialog");
      paramString1.setCancelable(paramBoolean);
    }
  }
  
  public static void show(Context paramContext)
  {
    try
    {
      boolean bool = check(paramContext);
      if (bool)
      {
        Toast.makeText(paramContext, paramContext.getResources().getString(2131755981), 0).show();
        return;
      }
      Toast.makeText(paramContext, paramContext.getResources().getString(2131755982), 0).show();
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
    }
  }
  
  public static void show(Context paramContext, String paramString)
  {
    paramContext = new Dialog(paramContext);
    paramContext.getWindow();
    paramContext.requestWindowFeature(1);
    paramContext.setContentView(2131493031);
    paramContext.setCancelable(true);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    ((TextView)paramContext.findViewById(2131296634)).setText(Html.fromHtml(paramString));
    ((TextView)paramContext.findViewById(2131297214)).setOnClickListener(new Credits.1(paramContext));
  }
  
  public static void showDialog(Activity paramActivity, String paramString)
  {
    Dialog localDialog = new Dialog(paramActivity);
    localDialog.getWindow();
    localDialog.requestWindowFeature(1);
    localDialog.setContentView(2131493031);
    localDialog.setCancelable(true);
    localDialog.setCanceledOnTouchOutside(false);
    localDialog.show();
    ((TextView)localDialog.findViewById(2131296634)).setText(paramString);
    ((TextView)localDialog.findViewById(2131297214)).setOnClickListener(new Util.1(localDialog, paramActivity));
  }
  
  public static void showDialog(Context paramContext)
  {
    Dialog localDialog = new Dialog(paramContext);
    localDialog.getWindow();
    localDialog.requestWindowFeature(1);
    localDialog.setContentView(2131493035);
    localDialog.setCancelable(true);
    localDialog.setCanceledOnTouchOutside(true);
    localDialog.show();
    TextView localTextView1 = (TextView)localDialog.findViewById(2131297058);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131297394);
    localTextView1.setOnClickListener(new ColorPickerDialog(localDialog, paramContext));
    localTextView2.setOnClickListener(new HomeScreen.1(localDialog, paramContext));
  }
  
  public static void showDialog(Context paramContext, String paramString)
  {
    Dialog localDialog = new Dialog(paramContext);
    localDialog.getWindow();
    localDialog.requestWindowFeature(1);
    localDialog.setContentView(2131493186);
    localDialog.setCancelable(true);
    ((TextView)localDialog.findViewById(2131296456)).setOnClickListener(new MainActivity.2(localDialog));
    ((TextView)localDialog.findViewById(2131297566)).setOnClickListener(new EditEventView.5(localDialog, paramContext));
    ((TextView)localDialog.findViewById(2131297143)).setText(paramString);
    localDialog.show();
  }
  
  public static void showDialog(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new Dialog(paramContext);
    paramContext.getWindow();
    paramContext.requestWindowFeature(1);
    paramContext.setContentView(2131493032);
    paramContext.setCancelable(true);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    ((TextView)paramContext.findViewById(2131296633)).setText(paramString1);
    ((TextView)paramContext.findViewById(2131296634)).setText(Html.fromHtml(paramString2));
    ((TextView)paramContext.findViewById(2131297214)).setOnClickListener(new TestActivity.1(paramContext));
  }
  
  public static void showErrorDialog(Context paramContext)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setTitle("GPS Settings");
    localBuilder.setMessage("Please enable GPS");
    localBuilder.setPositiveButton("OK", new StartupActivity.3(paramContext));
    localBuilder.setNegativeButton("Cancel", new Log.1());
    localBuilder.show();
  }
  
  public static ProgressDialog showProgressDialog(Context paramContext, String paramString)
  {
    paramContext = new ProgressDialog(paramContext);
    paramContext.setMessage(paramString);
    paramContext.setProgressStyle(0);
    paramContext.setCancelable(false);
    paramContext.show();
    return paramContext;
  }
  
  public static String start(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSystemService("phone");
      paramContext = (TelephonyManager)paramContext;
      paramContext = paramContext.getNetworkOperator();
      if (paramContext != null)
      {
        boolean bool = paramContext.equalsIgnoreCase("");
        if (!bool)
        {
          paramContext = paramContext.substring(0, 3);
          return paramContext;
        }
      }
      else
      {
        return "";
      }
    }
    catch (Exception paramContext)
    {
      StringBuilder.append(paramContext);
    }
    return "";
  }
  
  public static void start(Activity paramActivity, Uri paramUri)
  {
    try
    {
      Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      localIntent.putExtra("output", paramUri);
      paramActivity.startActivityForResult(localIntent, 2016);
      MyApplication.started = true;
      return;
    }
    catch (Exception paramActivity)
    {
      StringBuilder.append(paramActivity);
    }
  }
  
  public static void start(Context paramContext, String paramString)
  {
    Object localObject2 = "";
    Object localObject1;
    try
    {
      String str = new System(paramContext).getKey();
    }
    catch (Exception localException)
    {
      StringBuilder.append(localException);
      localObject1 = "";
    }
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    try
    {
      JSONObject localJSONObject = execute(paramContext);
      localObject2 = localJSONObject;
      localJSONObject.put("sid", paramString);
      localJSONObject.put("uid", localObject1);
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
      localObject2 = null;
    }
    if (localObject2 != null) {
      new k.a.a.l.List(new NodeList(), "https://app.umang.gov.in/umang/coreapi/ws2/rser", (JSONObject)localObject2, paramContext).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }
  }
  
  public static boolean start(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    try
    {
      paramString2 = localSimpleDateFormat.parse(paramString2);
      boolean bool = localSimpleDateFormat.parse(paramString1).equals(paramString2);
      return bool;
    }
    catch (Exception paramString1)
    {
      StringBuilder.append(paramString1);
    }
    return false;
  }
  
  public static String toGMTString()
  {
    return new SimpleDateFormat("ddMMyyyy", Locale.US).format(new Date());
  }
  
  public static String toString(Context paramContext, String paramString)
  {
    new f(paramContext);
    paramContext = new java.lang.StringBuilder();
    paramContext.append("|");
    paramContext.append(paramString);
    paramContext.append("|");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramContext, MyApplication.g, "|");
  }
  
  public static void update(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      paramActivity = paramActivity.getApplication();
      paramActivity = (MyApplication)paramActivity;
      paramActivity = paramActivity.get();
      if (paramString1 == null)
      {
        paramActivity.send(new HitBuilders.EventBuilder().setCategory(paramString2).setAction(paramString3).setLabel(paramString4).setValue(1L).build());
        return;
      }
      paramString1 = new HitBuilders.EventBuilder().setCustomDimension(1, paramString1);
      paramString1 = (HitBuilders.EventBuilder)paramString1;
      paramActivity.send(paramString1.setCategory(paramString2).setAction(paramString3).setLabel(paramString4).setValue(1L).build());
      return;
    }
    catch (Exception paramActivity)
    {
      StringBuilder.append(paramActivity);
    }
  }
  
  public static void v(Context paramContext)
  {
    WebStorage.getInstance().deleteAllData();
  }
  
  public static String value(Context paramContext)
  {
    return new f(paramContext).get(f.k, "");
  }
}
