package f.p.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.preference.PreferenceManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.wb.myspeed.common.NPTApplication;
import f.g.e.r;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  public static final char[] numbersAndLetters = "0123456789ABCDEF".toCharArray();
  
  public static int ReadInt(Context paramContext, String paramString, int paramInt)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString, paramInt);
  }
  
  public static int a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    return getColor(paramContext.getString(paramString, localStringBuilder.toString()));
  }
  
  public static Object a(String paramString, Class paramClass)
  {
    try
    {
      r localR = new r();
      if (paramString != null)
      {
        paramString = localR.a(paramString, paramClass);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(long paramLong)
  {
    return new SimpleDateFormat("ddMMyyyy_hh-mm-ss-SSSa").format(new Date(paramLong)).toString();
  }
  
  public static String a(Context paramContext)
  {
    Object localObject8 = "";
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
    boolean bool1 = NPTApplication.y;
    bool1 = send(paramContext);
    boolean bool2 = e.a();
    Object localObject1;
    if (!NPTApplication.y)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getIP_SPNAddress called. isWiFi=");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append("; isRooted=");
      ((StringBuilder)localObject1).append(bool2);
      ((StringBuilder)localObject1).toString();
    }
    if ((!bool1) && (!bool2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ClassWriter.c);
      ((StringBuilder)localObject1).append("?tm=");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ClassWriter.c);
      ((StringBuilder)localObject1).append("?tm=");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject4 = localObject8;
    Object localObject7;
    try
    {
      HashMap localHashMap = new HashMap();
      localObject4 = localObject8;
      localHashMap.put("req", "ip");
      localObject4 = localObject8;
      localHashMap.put("uid", getString(paramContext, "uuid", ""));
      localObject7 = null;
      localObject4 = ClassWriter.a;
      Object localObject9 = ClassWriter.z;
      localObject3 = localObject1;
      Object localObject2;
      try
      {
        bool3 = ((String)localObject4).equalsIgnoreCase((String)localObject9);
        Object localObject5;
        if (bool3)
        {
          try
          {
            localObject4 = add(paramContext, (String)localObject1, "POST", 5000);
          }
          catch (Exception localException3)
          {
            if (!NPTApplication.y)
            {
              localObject3 = localObject1;
              localException3.getMessage();
            }
            localObject3 = localObject1;
            localObject9 = new StringBuilder();
            localObject3 = localObject1;
            ((StringBuilder)localObject9).append("try1-fail, cause:");
            localObject3 = localObject1;
            ((StringBuilder)localObject9).append(localException3.getMessage());
            localObject3 = localObject1;
            ((StringBuilder)localObject9).toString();
            localObject3 = localObject1;
            localObject5 = new StringBuilder();
            localObject9 = ClassWriter.b;
            localObject3 = localObject1;
            ((StringBuilder)localObject5).append((String)localObject9);
            localObject3 = localObject1;
            ((StringBuilder)localObject5).append("?tm=");
            localObject3 = localObject1;
            ((StringBuilder)localObject5).append(System.currentTimeMillis());
            localObject3 = localObject1;
            localObject5 = ((StringBuilder)localObject5).toString();
            localObject1 = localObject5;
            localObject3 = localObject1;
            localObject5 = add(paramContext, (String)localObject5, "POST", 5000);
          }
          localObject9 = null;
          localObject3 = localObject1;
          localObject7 = localObject5;
          localObject1 = localObject9;
        }
        else
        {
          try
          {
            localObject5 = add((String)localObject1, "POST");
            localObject3 = localObject1;
            localObject1 = localObject5;
          }
          catch (Exception localException4)
          {
            if (!NPTApplication.y)
            {
              localObject3 = localObject1;
              localException4.getMessage();
            }
            localObject3 = localObject1;
            localObject6 = new StringBuilder();
            localObject9 = ClassWriter.b;
            localObject3 = localObject1;
            ((StringBuilder)localObject6).append((String)localObject9);
            localObject3 = localObject1;
            ((StringBuilder)localObject6).append("?tm=");
            localObject3 = localObject1;
            ((StringBuilder)localObject6).append(System.currentTimeMillis());
            localObject3 = localObject1;
            localObject6 = ((StringBuilder)localObject6).toString();
            localObject1 = localObject6;
            localObject3 = localObject1;
            localObject6 = add((String)localObject6, "POST");
            localObject3 = localObject1;
            localObject1 = localObject6;
          }
        }
        localObject6 = localObject8;
      }
      catch (Exception localException1)
      {
        localObject6 = localObject8;
        localObject9 = new StringBuilder();
        localObject6 = localObject8;
        ((StringBuilder)localObject9).append("try2-fail, cause:Exception 1:");
        localObject10 = (Exception)localException1;
        localObject6 = localObject8;
        ((StringBuilder)localObject9).append(((Exception)localObject10).getMessage());
        localObject6 = localObject8;
        ((StringBuilder)localObject9).toString();
        bool3 = NPTApplication.y;
        localObject2 = (Exception)localException1;
        localObject6 = localObject8;
        ((Exception)localObject2).printStackTrace();
        localObject2 = null;
      }
      localObject9 = new StringBuilder();
      Object localObject10 = ClassWriter.a;
      localObject6 = localObject8;
      ((StringBuilder)localObject9).append((String)localObject10);
      localObject6 = localObject8;
      ((StringBuilder)localObject9).append((String)localObject3);
      localObject6 = localObject8;
      localHashMap.put("key", a(((StringBuilder)localObject9).toString()));
      localObject6 = localObject8;
      localObject7 = a(localHashMap, (HttpsURLConnection)localObject7, (HttpURLConnection)localObject2);
      localObject3 = localObject7;
      int j = 1;
      int i = j;
      if (localObject7 != null)
      {
        localObject6 = localObject3;
        localObject8 = a(paramContext, (String)localObject7);
        if (localObject8 == null) {
          i = j;
        } else {
          i = 0;
        }
      }
      if (i != 0)
      {
        bool3 = NPTApplication.y;
        localObject6 = localObject3;
        localObject7 = new StringBuilder();
        localObject8 = ClassWriter.b;
        localObject6 = localObject3;
        ((StringBuilder)localObject7).append((String)localObject8);
        localObject6 = localObject3;
        ((StringBuilder)localObject7).append("?tm=");
        localObject6 = localObject3;
        ((StringBuilder)localObject7).append(System.currentTimeMillis());
        localObject6 = localObject3;
        localObject7 = ((StringBuilder)localObject7).toString();
        localObject6 = localObject3;
        localObject8 = add(paramContext, (String)localObject7, "POST", 5000);
        localObject6 = localObject3;
        localObject9 = new StringBuilder();
        localObject10 = ClassWriter.a;
        localObject6 = localObject3;
        ((StringBuilder)localObject9).append((String)localObject10);
        localObject6 = localObject3;
        ((StringBuilder)localObject9).append((String)localObject7);
        localObject6 = localObject3;
        localHashMap.put("key", a(((StringBuilder)localObject9).toString()));
        localObject6 = localObject3;
        localObject2 = a(localHashMap, (HttpsURLConnection)localObject8, (HttpURLConnection)localObject2);
        localObject6 = localObject2;
        localObject7 = localObject2;
        if (localObject2 != null)
        {
          a(paramContext, (String)localObject2);
          return localObject2;
        }
      }
    }
    catch (Exception localException2)
    {
      Object localObject6;
      Object localObject3 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("try2-fail, cause: Exception 3:");
      ((StringBuilder)localObject3).append(((Exception)localException2).getMessage());
      ((StringBuilder)localObject3).toString();
      boolean bool3 = NPTApplication.y;
      ((Exception)localException2).printStackTrace();
      a(paramContext, bool1, bool2);
      return localObject6;
    }
    return localObject7;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      String str1 = toString(paramString);
      String str2 = c(paramString);
      String str3 = getString(paramString, "dl_url");
      String str4 = getString(paramString, "ul_url");
      String str5 = getString(paramString, "ping_host");
      String str6 = getString(paramString, "log_server");
      String str7 = getString(paramString, "log_server1");
      String str8 = getString(paramString, "XXXX");
      String str9 = getString(paramString, "VAL1");
      send(paramContext, "network_operator_name", str2);
      send(paramContext, "spn_name", str1);
      send(paramContext, "download_server", str3);
      send(paramContext, "upload_server", str4);
      send(paramContext, "log_server", str6);
      send(paramContext, "log_server1", str7);
      send(paramContext, "ping_url", str5);
      send(paramContext, "check", str8);
      send(paramContext, "VAL1", str9);
      d(paramContext, "time_offset", 0);
      if (NPTApplication.y) {
        return paramString;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("Server response:", paramString);
      return paramString;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return null;
    return paramString;
  }
  
  public static String a(String paramString)
  {
    if (NPTApplication.a.isEmpty())
    {
      NPTApplication.a = "Z8Ra6QosmCiiw5N5KLAWPzoS070AAACBAOF3pEwWUC93LPKtJ4jvrHIz8G3Xng8x";
      if (!NPTApplication.y)
      {
        StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("key=");
        localStringBuilder.append(NPTApplication.a);
        localStringBuilder.toString();
      }
    }
    return encode(paramString, NPTApplication.a, "HmacMD5");
  }
  
  public static String a(String paramString1, String paramString2)
  {
    float f = length(paramString1) / length(paramString2);
    paramString1 = new DecimalFormat();
    paramString1.setMaximumFractionDigits(2);
    return paramString1.format(Float.valueOf(f));
  }
  
  public static String a(HashMap paramHashMap, HttpsURLConnection paramHttpsURLConnection, HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpsURLConnection != null) {
      localObject1 = paramHttpsURLConnection;
    } else {
      localObject1 = paramHttpURLConnection;
    }
    Object localObject2 = null;
    Object localObject3 = (HttpURLConnection)localObject1;
    Object localObject1 = localObject2;
    try
    {
      localObject3 = ((HttpURLConnection)localObject3).getOutputStream();
      bool = NPTApplication.y;
      localObject1 = localObject2;
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter((OutputStream)localObject3, "UTF-8"));
      if (!NPTApplication.y)
      {
        localObject1 = localObject2;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = localObject2;
        localStringBuilder.append("query==");
        localObject1 = localObject2;
        localStringBuilder.append(parse(paramHashMap));
        localObject1 = localObject2;
        localStringBuilder.toString();
      }
      localObject1 = localObject2;
      localBufferedWriter.write(parse(paramHashMap));
      localObject1 = localObject2;
      localBufferedWriter.flush();
      localObject1 = localObject2;
      localBufferedWriter.close();
      localObject1 = localObject2;
      ((OutputStream)localObject3).close();
      if (paramHttpsURLConnection == null) {
        paramHttpsURLConnection = paramHttpURLConnection;
      }
      paramHashMap = (HttpURLConnection)paramHttpsURLConnection;
      localObject1 = localObject2;
      paramHttpsURLConnection = toString(paramHashMap.getInputStream());
      paramHashMap = paramHttpsURLConnection;
      if (!NPTApplication.y)
      {
        localObject1 = paramHashMap;
        paramHttpURLConnection = new StringBuilder();
        localObject1 = paramHashMap;
        paramHttpURLConnection.append("response==");
        localObject1 = paramHashMap;
        paramHttpURLConnection.append(paramHttpsURLConnection);
        localObject1 = paramHashMap;
        paramHttpURLConnection.toString();
        return paramHttpsURLConnection;
      }
    }
    catch (Exception paramHashMap)
    {
      boolean bool = NPTApplication.y;
      paramHashMap.printStackTrace();
      return localObject1;
    }
    return paramHttpsURLConnection;
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    send(paramContext, "network_operator_name", null);
    send(paramContext, "spn_name", null);
    send(paramContext, "check", "TRAI");
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      send(paramContext, "download_server", "http://testserver.myspeed.co.in/150MB.dat");
      send(paramContext, "upload_server", "http://testserver.myspeed.co.in/upload.php");
      send(paramContext, "log_server", "https://review.redmangoanalytics.com/api/MeM.php");
      send(paramContext, "log_server1", "https://log.myspeed.co.in/api/MeM.php");
      send(paramContext, "ping_url", "google.com");
      return;
    }
    send(paramContext, "download_server", "http://testserver.myspeed.co.in/150MB.dat");
    send(paramContext, "upload_server", "http://testserver.myspeed.co.in/upload.php");
    send(paramContext, "log_server", "https://review.redmangoanalytics.com/api/MeM.php");
    send(paramContext, "log_server1", "https://log.myspeed.co.in/api/MeM.php");
    send(paramContext, "ping_url", "google.com");
  }
  
  public static void a(File paramFile)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory());
    ((StringBuilder)localObject).append("/MySpeed_Debug");
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append("/");
    localStringBuilder.append(paramFile.getName());
    a(paramFile, localStringBuilder.toString());
  }
  
  public static void a(File paramFile, String paramString)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      paramString = new File(paramString);
      paramString = new FileOutputStream(paramString);
      write(localFileInputStream, paramString);
      localFileInputStream.close();
      paramString.flush();
      paramString.close();
      return;
    }
    catch (IOException paramString)
    {
      for (;;) {}
    }
    if (!NPTApplication.y)
    {
      paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failed to copy sdcard file: ");
      paramString.append(paramFile.getName());
      paramString.toString();
      return;
    }
  }
  
  public static boolean a(File paramFile, long paramLong)
  {
    if ((paramFile != null) && (paramLong >= 0L)) {}
    try
    {
      bool = paramFile.exists();
      if (bool)
      {
        l = paramFile.length();
        if (l == paramLong)
        {
          bool = NPTApplication.y;
          return true;
        }
        paramFile.delete();
      }
      Object localObject = paramFile.getParentFile();
      bool = ((File)localObject).exists();
      if (!bool) {
        ((File)localObject).mkdirs();
      }
      bool = NPTApplication.y;
      paramFile = new FileOutputStream(paramFile);
      paramFile = new BufferedOutputStream(paramFile);
      long l = paramLong / 256L;
      int j = (int)(paramLong % 256L);
      localObject = new byte['?'];
      Arrays.fill((byte[])localObject, (byte)97);
      int i = 0;
      while (i < l)
      {
        paramFile.write((byte[])localObject);
        i += 1;
      }
      if (j > 0) {
        paramFile.write((byte[])localObject, 0, j);
      }
      try
      {
        paramFile.close();
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
      }
      bool = NPTApplication.y;
      return true;
    }
    catch (Exception paramFile)
    {
      ((Exception)paramFile).printStackTrace();
      boolean bool = NPTApplication.y;
    }
    bool = NPTApplication.y;
    return false;
    return false;
  }
  
  public static long add(double paramDouble, String paramString)
  {
    if (paramString.equalsIgnoreCase("GB"))
    {
      paramDouble *= 1024.0D;
      paramDouble *= 1024.0D;
    }
    do
    {
      return (paramDouble * 1024.0D);
      if (paramString.equalsIgnoreCase("MB")) {
        break;
      }
    } while (paramString.equalsIgnoreCase("KB"));
    return 0L;
  }
  
  public static HttpURLConnection add(String paramString1, String paramString2)
  {
    return get(paramString1, paramString2, true);
  }
  
  public static HttpsURLConnection add(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    return get(paramContext, paramString1, paramString2, true, paramInt);
  }
  
  public static String apply(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    String str2 = "";
    if (i >= 23)
    {
      paramContext = SubscriptionManager.from(paramContext).getActiveSubscriptionInfoList();
      if ((paramContext != null) && (paramContext.size() > 1))
      {
        localObject = (SubscriptionInfo)paramContext.get(1);
        paramContext = ((SubscriptionInfo)localObject).getCarrierName().toString();
        str1 = String.valueOf(((SubscriptionInfo)localObject).getMcc());
        localObject = String.valueOf(((SubscriptionInfo)localObject).getMnc());
        break label85;
      }
    }
    Object localObject = "";
    String str1 = "";
    paramContext = str2;
    label85:
    paramContext = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(",,", paramContext, ",", str1, ","), (String)localObject, ",,,,,,,,,,,,,");
    if (!NPTApplication.y) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("SIM2 details:", paramContext);
    }
    return paramContext;
  }
  
  public static void b(String paramString)
  {
    if (!NPTApplication.b) {
      return;
    }
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(), NPTApplication.d, "/logs/");
    try
    {
      localObject = new File((String)localObject);
      boolean bool = ((File)localObject).exists();
      if (!bool) {
        ((File)localObject).mkdirs();
      }
      localObject = new File((File)localObject, "debug_log.txt");
      localObject = new FileWriter((File)localObject, true);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(System.currentTimeMillis()));
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n");
      ((FileWriter)localObject).append(localStringBuilder.toString());
      ((FileWriter)localObject).flush();
      ((FileWriter)localObject).close();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (!NPTApplication.b) {
      return;
    }
    try
    {
      Object localObject = new File(Environment.getExternalStorageDirectory(), "NPT");
      boolean bool = ((File)localObject).exists();
      if (!bool) {
        ((File)localObject).mkdirs();
      }
      paramString1 = new File((File)localObject, paramString1);
      paramString1 = new FileWriter(paramString1, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("\n");
      paramString1.append(((StringBuilder)localObject).toString());
      paramString1.flush();
      paramString1.close();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static int c(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 22)
    {
      paramContext = SubscriptionManager.from(paramContext).getActiveSubscriptionInfoList();
      if (paramContext == null) {
        return 0;
      }
      i = paramContext.size();
      if (i <= 0) {
        return 0;
      }
    }
    else
    {
      return 0;
    }
    return i;
  }
  
  public static String c(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return "NA";
          }
          return "4G";
        }
        return "3G";
      }
      return "2G";
    }
    return "CDMA";
  }
  
  public static String c(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      boolean bool = paramString.has("ip");
      if (bool)
      {
        paramString = paramString.getString("ip");
        return paramString;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static void clearAll(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove(paramString);
    paramContext.commit();
  }
  
  public static HttpsURLConnection close(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    return get(paramContext, paramString1, paramString2, paramBoolean, 10000);
  }
  
  public static void copy(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = paramContext.open(paramString1);
      paramString2 = new File(paramString2);
      paramString2.createNewFile();
      paramString2 = new FileOutputStream(paramString2);
      write(paramContext, paramString2);
      paramContext.close();
      paramString2.flush();
      paramString2.close();
      return;
    }
    catch (IOException paramContext)
    {
      for (;;) {}
    }
    if (!NPTApplication.y)
    {
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("Failed to copy asset file: ", paramString1);
      return;
    }
  }
  
  public static double d(String paramString)
  {
    try
    {
      double d = Double.parseDouble(paramString);
      return d;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (!NPTApplication.y) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("Error in parsing double", paramString);
    }
    return 0.0D;
  }
  
  public static String d(Context paramContext)
  {
    return "";
  }
  
  public static void d(Context paramContext, String paramString)
  {
    Toast.makeText(paramContext, paramString, 1).show();
  }
  
  public static void d(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.commit();
  }
  
  public static String delete(int paramInt)
  {
    if ((paramInt < -30) && (paramInt > 65386)) {
      return String.valueOf(paramInt);
    }
    return "NA";
  }
  
  /* Error */
  public static float doInBackground()
  {
    // Byte code:
    //   0: new 618	java/io/RandomAccessFile
    //   3: dup
    //   4: ldc_w 620
    //   7: ldc_w 622
    //   10: invokespecial 624	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: astore 18
    //   15: aload 18
    //   17: invokevirtual 627	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   20: ldc_w 525
    //   23: invokevirtual 631	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   26: astore 19
    //   28: aload 19
    //   30: iconst_5
    //   31: aaload
    //   32: astore 20
    //   34: aload 20
    //   36: invokestatic 637	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   39: lstore_0
    //   40: aload 19
    //   42: iconst_2
    //   43: aaload
    //   44: astore 20
    //   46: aload 20
    //   48: invokestatic 637	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   51: lstore_2
    //   52: aload 19
    //   54: iconst_3
    //   55: aaload
    //   56: astore 20
    //   58: aload 20
    //   60: invokestatic 637	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   63: lstore 4
    //   65: aload 19
    //   67: iconst_4
    //   68: aaload
    //   69: astore 20
    //   71: aload 20
    //   73: invokestatic 637	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   76: lstore 6
    //   78: aload 19
    //   80: bipush 6
    //   82: aaload
    //   83: astore 20
    //   85: aload 20
    //   87: invokestatic 637	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   90: lstore 8
    //   92: aload 19
    //   94: bipush 7
    //   96: aaload
    //   97: astore 20
    //   99: aload 20
    //   101: invokestatic 637	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   104: lstore 10
    //   106: aload 19
    //   108: bipush 8
    //   110: aaload
    //   111: astore 19
    //   113: aload 19
    //   115: invokestatic 637	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   118: lstore 12
    //   120: lload_2
    //   121: lload 4
    //   123: ladd
    //   124: lload 6
    //   126: ladd
    //   127: lload 8
    //   129: ladd
    //   130: lload 10
    //   132: ladd
    //   133: lload 12
    //   135: ladd
    //   136: lstore_2
    //   137: ldc2_w 638
    //   140: invokestatic 644	java/lang/Thread:sleep	(J)V
    //   143: aload 18
    //   145: lconst_0
    //   146: invokevirtual 647	java/io/RandomAccessFile:seek	(J)V
    //   149: aload 18
    //   151: invokevirtual 627	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   154: astore 19
    //   156: aload 18
    //   158: invokevirtual 648	java/io/RandomAccessFile:close	()V
    //   161: aload 19
    //   163: ldc_w 525
    //   166: invokevirtual 631	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   169: astore 18
    //   171: aload 18
    //   173: iconst_5
    //   174: aaload
    //   175: astore 19
    //   177: aload 19
    //   179: invokestatic 637	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   182: lstore 4
    //   184: aload 18
    //   186: iconst_2
    //   187: aaload
    //   188: astore 19
    //   190: aload 19
    //   192: invokestatic 637	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   195: lstore 6
    //   197: aload 18
    //   199: iconst_3
    //   200: aaload
    //   201: astore 19
    //   203: aload 19
    //   205: invokestatic 637	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   208: lstore 8
    //   210: aload 18
    //   212: iconst_4
    //   213: aaload
    //   214: astore 19
    //   216: aload 19
    //   218: invokestatic 637	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   221: lstore 10
    //   223: aload 18
    //   225: bipush 6
    //   227: aaload
    //   228: astore 19
    //   230: aload 19
    //   232: invokestatic 637	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   235: lstore 12
    //   237: aload 18
    //   239: bipush 7
    //   241: aaload
    //   242: astore 19
    //   244: aload 19
    //   246: invokestatic 637	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   249: lstore 14
    //   251: aload 18
    //   253: bipush 8
    //   255: aaload
    //   256: astore 18
    //   258: aload 18
    //   260: invokestatic 637	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   263: lstore 16
    //   265: lload 6
    //   267: lload 8
    //   269: ladd
    //   270: lload 10
    //   272: ladd
    //   273: lload 12
    //   275: ladd
    //   276: lload 14
    //   278: ladd
    //   279: lload 16
    //   281: ladd
    //   282: lstore 6
    //   284: lload 6
    //   286: lload_2
    //   287: lsub
    //   288: l2f
    //   289: lload 6
    //   291: lload 4
    //   293: ladd
    //   294: lload_2
    //   295: lload_0
    //   296: ladd
    //   297: lsub
    //   298: l2f
    //   299: fdiv
    //   300: freturn
    //   301: astore 18
    //   303: getstatic 113	com/wb/myspeed/common/NPTApplication:y	Z
    //   306: ifne +11 -> 317
    //   309: aload 18
    //   311: checkcast 382	java/io/IOException
    //   314: invokevirtual 533	java/io/IOException:printStackTrace	()V
    //   317: fconst_0
    //   318: freturn
    //   319: astore 19
    //   321: goto -178 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	257	0	l1	long
    //   51	244	2	l2	long
    //   63	229	4	l3	long
    //   76	214	6	l4	long
    //   90	178	8	l5	long
    //   104	167	10	l6	long
    //   118	156	12	l7	long
    //   249	28	14	l8	long
    //   263	17	16	l9	long
    //   13	246	18	localObject1	Object
    //   301	9	18	localIOException	IOException
    //   26	219	19	localObject2	Object
    //   319	1	19	localException	Exception
    //   32	68	20	str	String
    // Exception table:
    //   from	to	target	type
    //   0	28	301	java/io/IOException
    //   34	40	301	java/io/IOException
    //   46	52	301	java/io/IOException
    //   58	65	301	java/io/IOException
    //   71	78	301	java/io/IOException
    //   85	92	301	java/io/IOException
    //   99	106	301	java/io/IOException
    //   113	120	301	java/io/IOException
    //   143	171	301	java/io/IOException
    //   177	184	301	java/io/IOException
    //   190	197	301	java/io/IOException
    //   203	210	301	java/io/IOException
    //   216	223	301	java/io/IOException
    //   230	237	301	java/io/IOException
    //   244	251	301	java/io/IOException
    //   258	265	301	java/io/IOException
    //   137	143	319	java/lang/Exception
  }
  
  public static String doInBackground(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      boolean bool = ((Iterator)localObject1).hasNext();
      if (bool)
      {
        Object localObject2 = ((Iterator)localObject1).next();
        localObject2 = (NetworkInterface)localObject2;
        localObject2 = Collections.list(((NetworkInterface)localObject2).getInetAddresses()).iterator();
        Object localObject3;
        label128:
        do
        {
          do
          {
            do
            {
              bool = ((Iterator)localObject2).hasNext();
              if (!bool) {
                break;
              }
              localObject3 = ((Iterator)localObject2).next();
              localObject3 = (InetAddress)localObject3;
              bool = ((InetAddress)localObject3).isLoopbackAddress();
            } while (bool);
            localObject3 = ((InetAddress)localObject3).getHostAddress();
            i = ((String)localObject3).indexOf(':');
            if (i < 0) {
              i = 1;
            } else {
              i = 0;
            }
            if (!paramBoolean) {
              break label128;
            }
          } while (i == 0);
          return localObject3;
        } while (i != 0);
        int i = ((String)localObject3).indexOf('%');
        if (i < 0)
        {
          localObject1 = ((String)localObject3).toUpperCase();
          return localObject1;
        }
        localObject1 = ((String)localObject3).substring(0, i).toUpperCase();
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return "";
  }
  
  public static String e(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramContext == null) {
      return "";
    }
    localStringBuilder.append("Battery=");
    localStringBuilder.append(getBatteryLevel(paramContext));
    localStringBuilder.append(":");
    localStringBuilder.append("CPU usage=");
    localStringBuilder.append(doInBackground());
    localStringBuilder.append(":");
    localStringBuilder.append("RAM usage=");
    localStringBuilder.append(export());
    return localStringBuilder.toString();
  }
  
  public static String e(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TRAI_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static String e(Throwable paramThrowable)
  {
    Throwable localThrowable = getRootCause(paramThrowable);
    if (localThrowable == null) {
      return null;
    }
    if ((localThrowable instanceof MalformedURLException))
    {
      paramThrowable = "Malformed URL";
    }
    else if ((localThrowable instanceof UnknownHostException))
    {
      paramThrowable = "IP address of a host could not be determined";
    }
    else if ((localThrowable instanceof HttpRetryException))
    {
      paramThrowable = "HTTP request needs to be retried but cannot be retried automatically, due to streaming mode being enabled";
    }
    else if ((localThrowable instanceof SocketTimeoutException))
    {
      paramThrowable = "timeout has occurred on a socket read or accept";
    }
    else if ((localThrowable instanceof InterruptedIOException))
    {
      paramThrowable = "an I/O operation has been interrupted";
    }
    else if ((localThrowable instanceof BindException))
    {
      paramThrowable = "an error occurred while attempting to bind a socket to a local address and port. Typically, the port is in use, or the requested local address could not be assigned";
    }
    else if ((localThrowable instanceof ConnectException))
    {
      paramThrowable = "an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely (e.g., no process is listening on the remote address/port)";
    }
    else if ((localThrowable instanceof NoRouteToHostException))
    {
      paramThrowable = "an error occurred while attempting to connect a socket to a remote address and port. Typically, the remote host cannot be reached because of an intervening firewall, or if an intermediate router is down";
    }
    else if ((localThrowable instanceof PortUnreachableException))
    {
      paramThrowable = "an ICMP Port Unreachable message has been received on a connected datagram";
    }
    else if ((localThrowable instanceof SocketException))
    {
      paramThrowable = "error accessing or creating a socket";
    }
    else if ((localThrowable instanceof CertPathValidatorException))
    {
      paramThrowable = "Trust anchor for certification path not found.";
    }
    else if ((localThrowable instanceof SSLHandshakeException))
    {
      paramThrowable = "the client and server could not negotiate the desired level of security. The connection is no longer usable";
    }
    else if ((localThrowable instanceof SSLKeyException))
    {
      paramThrowable = "a bad SSL key. Normally, this indicates misconfiguration of the server or client SSL certificate and private key";
    }
    else if ((localThrowable instanceof SSLPeerUnverifiedException))
    {
      paramThrowable = "the peer's identity has not been verified. When the peer was not able to identify itself (for example; no certificate, the particular cipher suite being used does not support authentication, or no peer authentication was established during SSL handshaking) this exception is thrown";
    }
    else if ((localThrowable instanceof SSLProtocolException))
    {
      paramThrowable = "an error in the operation of the SSL protocol. Normally this indicates a flaw in one of the protocol implementations";
    }
    else if ((localThrowable instanceof SSLException))
    {
      paramThrowable = "an error detected by the SSL subsystem";
    }
    else if ((localThrowable instanceof URISyntaxException))
    {
      paramThrowable = "string could not be parsed as a URI reference";
    }
    else
    {
      paramThrowable = new StringWriter();
      localThrowable.printStackTrace(new PrintWriter(paramThrowable));
      paramThrowable = paramThrowable.toString();
    }
    if (localThrowable.getMessage() != null) {
      paramThrowable = localThrowable.getMessage();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localThrowable.getClass().getSimpleName());
    localStringBuilder.append(": ");
    localStringBuilder.append(paramThrowable);
    return localStringBuilder.toString();
  }
  
  public static String encode(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("1", "A");
    localHashMap.put("2", "B");
    localHashMap.put("3", "C");
    localHashMap.put("4", "D");
    localHashMap.put("5", "E");
    localHashMap.put("6", "F");
    localHashMap.put("7", "a");
    localHashMap.put("8", "b");
    localHashMap.put("9", "c");
    localHashMap.put("0", "d");
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((String)localHashMap.get(String.valueOf(paramString[i])));
      i += 1;
    }
    return localStringBuilder.reverse().toString();
  }
  
  public static String encode(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString2 = new SecretKeySpec(paramString2.getBytes("UTF-8"), paramString3);
      paramString3 = Mac.getInstance(paramString3);
      paramString3.init(paramString2);
      paramString1 = paramString3.doFinal(paramString1.getBytes("ASCII"));
      paramString2 = new StringBuffer();
      int i = 0;
      while (i < paramString1.length)
      {
        int j = paramString1[i];
        paramString3 = Integer.toHexString(j & 0xFF);
        j = paramString3.length();
        if (j == 1) {
          paramString2.append('0');
        }
        paramString2.append(paramString3);
        i += 1;
      }
      paramString1 = paramString2.toString();
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;) {}
    }
    catch (InvalidKeyException paramString1)
    {
      for (;;) {}
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static String exec(Context paramContext)
  {
    return ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getSSID().replace("\"", "");
  }
  
  public static String export()
  {
    try
    {
      Object localObject = new DecimalFormat();
      ((DecimalFormat)localObject).setMaximumFractionDigits(2);
      ((DecimalFormat)localObject).setMinimumFractionDigits(2);
      StringBuilder localStringBuilder = new StringBuilder();
      long l = Runtime.getRuntime().totalMemory();
      double d = l / 1048576L;
      localStringBuilder.append(((DecimalFormat)localObject).format(Double.valueOf(d)));
      localStringBuilder.append("/");
      l = Runtime.getRuntime().maxMemory();
      d = l / 1048576L;
      localStringBuilder.append(((DecimalFormat)localObject).format(Double.valueOf(d)));
      localStringBuilder.append("/");
      l = Runtime.getRuntime().freeMemory();
      d = l / 1048576L;
      localStringBuilder.append(((DecimalFormat)localObject).format(Double.valueOf(d)));
      localObject = localStringBuilder.toString();
      if (!NPTApplication.y)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("heapLogStr=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.toString();
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return "";
    }
    return localException;
  }
  
  public static HttpURLConnection get(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = ClassWriter.index;
    try
    {
      boolean bool = paramString1.startsWith(str);
      if (bool) {
        str = "";
      } else {
        str = ClassWriter.index;
      }
      if (!NPTApplication.y)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getHTTPConn URL = ");
        localStringBuilder.append(str);
        localStringBuilder.append(paramString1);
        localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramString1);
      paramString1 = new URL(localStringBuilder.toString()).openConnection();
      paramString1 = (HttpURLConnection)paramString1;
      paramString1.setRequestMethod(paramString2);
      paramString1.setConnectTimeout(10000);
      paramString1.setReadTimeout(10000);
      paramString1.setDoOutput(true);
      paramString1.setDoInput(true);
      paramString1.setUseCaches(false);
      if (paramBoolean)
      {
        paramString1.connect();
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    return paramString1;
  }
  
  public static HttpsURLConnection get(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if (paramString1.startsWith(ClassWriter.z)) {
      localObject = "";
    } else {
      localObject = ClassWriter.z;
    }
    if (!NPTApplication.y) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.toString("getHTTPSConn URL = ", (String)localObject, paramString1);
    }
    Object localObject = new URL(f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject, paramString1));
    paramString1 = (HttpsURLConnection)((URL)localObject).openConnection();
    paramContext = init(paramContext, getHost(((URL)localObject).toString()));
    if (paramContext != null) {
      paramString1.setSSLSocketFactory(paramContext);
    }
    paramString1.setRequestMethod(paramString2);
    paramString1.setConnectTimeout(paramInt);
    paramString1.setReadTimeout(10000);
    paramString1.setDoOutput(true);
    paramString1.setDoInput(true);
    paramString1.setUseCaches(false);
    if (paramBoolean) {
      paramString1.connect();
    }
    return paramString1;
  }
  
  public static long getAlarmTime(Context paramContext, String paramString, long paramLong)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString, paramLong);
  }
  
  public static int getBatteryLevel(Context paramContext)
  {
    return paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("level", -1);
  }
  
  public static boolean getBoolean(String paramString)
  {
    try
    {
      boolean bool = Boolean.parseBoolean(paramString);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (!NPTApplication.y) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("Error in parsing bool", paramString);
    }
    return false;
  }
  
  public static int getColor(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (!NPTApplication.y) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("Error in parsing int", paramString);
    }
    return 0;
  }
  
  public static String getHost(String paramString)
  {
    try
    {
      paramString = new URI(paramString).getHost();
      boolean bool = paramString.startsWith("www.");
      if (bool)
      {
        paramString = paramString.substring(4);
        return paramString;
      }
    }
    catch (URISyntaxException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    return paramString;
  }
  
  public static String getLocalIpAddress(Context paramContext)
  {
    Object localObject1 = "";
    paramContext = (Context)localObject1;
    try
    {
      Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
      paramContext = (Context)localObject1;
      boolean bool = localEnumeration1.hasMoreElements();
      paramContext = (Context)localObject1;
      if (bool)
      {
        paramContext = (Context)localObject1;
        Object localObject2 = localEnumeration1.nextElement();
        localObject2 = (NetworkInterface)localObject2;
        paramContext = (Context)localObject1;
        Enumeration localEnumeration2 = ((NetworkInterface)localObject2).getInetAddresses();
        for (localObject2 = localObject1;; localObject2 = localObject1)
        {
          paramContext = (Context)localObject2;
          bool = localEnumeration2.hasMoreElements();
          localObject1 = localObject2;
          if (!bool) {
            break;
          }
          paramContext = (Context)localObject2;
          StringBuilder localStringBuilder = new StringBuilder();
          paramContext = (Context)localObject2;
          localObject1 = localEnumeration2.nextElement();
          InetAddress localInetAddress = (InetAddress)localObject1;
          paramContext = (Context)localObject2;
          localObject1 = new StringBuilder();
          paramContext = (Context)localObject2;
          ((StringBuilder)localObject1).append(localInetAddress.getHostName());
          paramContext = (Context)localObject2;
          ((StringBuilder)localObject1).append(",");
          paramContext = (Context)localObject2;
          localStringBuilder.append(((StringBuilder)localObject1).toString());
          paramContext = (Context)localObject2;
          localObject1 = new StringBuilder();
          paramContext = (Context)localObject2;
          ((StringBuilder)localObject1).append(localInetAddress.getCanonicalHostName());
          paramContext = (Context)localObject2;
          ((StringBuilder)localObject1).append(",");
          paramContext = (Context)localObject2;
          localStringBuilder.append(((StringBuilder)localObject1).toString());
          paramContext = (Context)localObject2;
          localObject1 = new StringBuilder();
          paramContext = (Context)localObject2;
          ((StringBuilder)localObject1).append(localInetAddress.getHostAddress());
          paramContext = (Context)localObject2;
          ((StringBuilder)localObject1).append(",");
          paramContext = (Context)localObject2;
          localStringBuilder.append(((StringBuilder)localObject1).toString());
          paramContext = (Context)localObject2;
          bool = localInetAddress.isLoopbackAddress();
          localObject1 = localObject2;
          if (!bool)
          {
            localObject1 = localObject2;
            if ((localInetAddress instanceof Inet6Address))
            {
              paramContext = (Context)localObject2;
              localObject1 = localInetAddress.getHostAddress();
            }
          }
          paramContext = (Context)localObject1;
          localStringBuilder.append("\n");
        }
      }
      return paramContext;
    }
    catch (Exception localException)
    {
      localException.toString();
    }
  }
  
  public static String getNetworkTypeName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "No Network";
    case 15: 
      return "HSPA+";
    case 14: 
      return "EHRPD";
    case 13: 
      return "LTE";
    case 12: 
      return "EVDO B";
    case 11: 
      return "IDEN";
    case 10: 
      return "HSPA";
    case 9: 
      return "HSUPA";
    case 8: 
      return "HSDPA";
    case 7: 
      return "1xRTT";
    case 6: 
      return "EVDO A";
    case 5: 
      return "EVDO 0";
    case 4: 
      return "CDMA";
    case 3: 
      return "UMTS";
    case 2: 
      return "EDGE";
    case 1: 
      return "GPRS";
    }
    return "Unknown";
  }
  
  public static float getNumber(int paramInt, Float paramFloat)
  {
    return new BigDecimal(Float.toString(paramFloat.floatValue())).setScale(paramInt, 0).floatValue();
  }
  
  public static Throwable getRootCause(Throwable paramThrowable)
  {
    Throwable localThrowable = paramThrowable;
    if (paramThrowable != null) {
      for (;;)
      {
        localThrowable = paramThrowable;
        if (paramThrowable.getCause() == null) {
          break;
        }
        paramThrowable = paramThrowable.getCause();
      }
    }
    return localThrowable;
  }
  
  public static String getString(Context paramContext, String paramString1, String paramString2)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString1, paramString2);
  }
  
  public static String getString(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1);
      boolean bool = paramString1.has(paramString2);
      if (bool)
      {
        paramString1 = paramString1.getString(paramString2);
        return paramString1;
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static int getWifiState(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext != null)
    {
      if (paramContext.getType() == 1)
      {
        if (paramContext.isConnected()) {
          return 1;
        }
      }
      else {
        return 2;
      }
    }
    else {
      return 0;
    }
    return 1;
  }
  
  public static boolean hasPermission(Context paramContext, String paramString)
  {
    return paramContext.checkCallingOrSelfPermission(paramString) == 0;
  }
  
  public static SSLSocketFactory init(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        localObject1 = CertificateFactory.getInstance("X.509");
      }
      catch (Exception paramContext)
      {
        Object localObject1;
        Object localObject2;
        boolean bool;
        ((Exception)paramContext).printStackTrace();
        return null;
      }
      try
      {
        paramContext = new StringBuilder();
        localObject2 = NPTApplication.d;
        paramContext.append(localObject2);
        paramContext.append("/crt/");
        paramContext.append(paramString);
        paramContext = new BufferedInputStream(new FileInputStream(paramContext.toString()));
        bool = NPTApplication.y;
        try
        {
          paramString = ((CertificateFactory)localObject1).generateCertificate(paramContext);
          localObject1 = System.out;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ca=");
          ((StringBuilder)localObject2).append(((X509Certificate)paramString).getSubjectDN());
          ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
          paramContext.close();
          paramContext = KeyStore.getInstance(KeyStore.getDefaultType());
          paramContext.load(null, null);
          paramContext.setCertificateEntry("ca", paramString);
          paramString = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
          paramString.init(paramContext);
          paramContext = SSLContext.getInstance("TLS");
          paramContext.init(null, paramString.getTrustManagers(), null);
          paramContext = paramContext.getSocketFactory();
          return paramContext;
        }
        catch (Throwable paramString)
        {
          paramContext.close();
          throw paramString;
        }
      }
      catch (Exception paramContext) {}
    }
    if (!NPTApplication.y)
    {
      paramContext = new StringBuilder();
      paramContext.append("Could not load the cert file");
      paramContext.append(paramString);
      paramContext.toString();
      return null;
    }
    return null;
  }
  
  public static Boolean isMetric(Context paramContext, String paramString, boolean paramBoolean)
  {
    return Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, paramBoolean));
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static int isValid(Context paramContext)
  {
    int j = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
    int i = 1;
    switch (j)
    {
    default: 
      return 0;
    case 13: 
      d(paramContext, "is4GSubscriber", 1);
      return 4;
    case 3: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 15: 
      return 3;
    case 1: 
    case 2: 
      i = 2;
    }
    return i;
  }
  
  public static float length(String paramString)
  {
    try
    {
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (!NPTApplication.y) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("Error in parsing float", paramString);
    }
    return 0.0F;
  }
  
  public static void p(Context paramContext, String paramString) {}
  
  public static String parse(HashMap paramHashMap)
  {
    StringBuilder localStringBuilder2 = new StringBuilder();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = null;
      try
      {
        Object localObject2 = paramHashMap.get(str);
        localObject2 = (String)localObject2;
        localObject2 = URLEncoder.encode((String)localObject2, "UTF-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      if (localStringBuilder2.length() > 0) {
        localStringBuilder2.append("&");
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(str);
      localStringBuilder1.append("=");
      localStringBuilder1.append(localObject1);
      localStringBuilder2.append(localStringBuilder1.toString());
    }
    return localStringBuilder2.toString();
  }
  
  public static String parseFeed()
  {
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Bar", "12345");
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject, (String)localObject).getBytes(), "AES");
    try
    {
      localObject = Cipher.getInstance("AES");
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      localNoSuchPaddingException.printStackTrace();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    String str = null;
    try
    {
      str.init(2, localSecretKeySpec);
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      localInvalidKeyException.printStackTrace();
    }
    try
    {
      str = new String(str.doFinal(new byte[] { 22, -111, 93, -88, -35, 120, -85, 58, -51, 37, 67, 3, 94, -34, 62, 121, 7, 44, 78, 109, 119, -63, -82, -41, -108, 14, 73, 92, 88, 28, 85, -108, 75, -53, -126, -77, 4, 73, -112, -58, 99, -40, 61, -84, -71, -20, -95, 50 }));
      return str;
    }
    catch (BadPaddingException localBadPaddingException)
    {
      localBadPaddingException.printStackTrace();
      return null;
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      localIllegalBlockSizeException.printStackTrace();
    }
    return null;
  }
  
  public static void r(Context paramContext, String paramString)
  {
    Toast.makeText(paramContext, paramString, 0).show();
  }
  
  public static int refresh(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    int i = ReadInt(paramContext, "connected_wifi", -1);
    if (localNetworkInfo != null)
    {
      boolean bool;
      StringBuilder localStringBuilder;
      if ((i == 1) && (localNetworkInfo.getType() == 0))
      {
        bool = NPTApplication.y;
        if (!NPTApplication.y)
        {
          localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("lastNetworkType=", i, "; Active=");
          localStringBuilder.append(localNetworkInfo.getType());
          localStringBuilder.toString();
        }
        d(paramContext, "connected_wifi", localNetworkInfo.getType());
        return 1;
      }
      if ((i == 0) && (localNetworkInfo.getType() == 1))
      {
        bool = NPTApplication.y;
        if (!NPTApplication.y)
        {
          localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("lastNetworkType=", i, "; Active=");
          localStringBuilder.append(localNetworkInfo.getType());
          localStringBuilder.toString();
        }
        d(paramContext, "connected_wifi", localNetworkInfo.getType());
        return -1;
      }
      d(paramContext, "connected_wifi", localNetworkInfo.getType());
    }
    return 0;
  }
  
  public static String saveDocument(long paramLong)
  {
    return new SimpleDateFormat("dd/MM/yy hh:mm a").format(new Date(paramLong)).toString();
  }
  
  public static void saveLabelIdInPref(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong(paramString, paramLong);
    paramContext.commit();
  }
  
  public static void send(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
  
  public static boolean send(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.getType() == 1) && (paramContext.isConnected());
  }
  
  public static void setShowSystemApps(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static String toString(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    paramInputStream = "";
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInputStream);
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
        str = localStringBuilder.toString();
        paramInputStream = str;
      }
      return paramInputStream;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static String toString(String paramString)
  {
    paramString = new JSONObject(paramString);
    if (paramString.has("spn")) {
      return paramString.getString("spn");
    }
    return "";
  }
  
  public static int update(int paramInt, String paramString)
  {
    if (paramString.equalsIgnoreCase("hour")) {}
    for (int i = 3600000;; i = 60000)
    {
      return paramInt * i;
      if (!paramString.equalsIgnoreCase("min")) {
        break;
      }
    }
    i = paramInt;
    if (paramString.equalsIgnoreCase("sec")) {
      i = paramInt * 1000;
    }
    return i;
  }
  
  public static String update(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    String str2 = "";
    if (i >= 23)
    {
      paramContext = SubscriptionManager.from(paramContext).getActiveSubscriptionInfoList();
      if ((paramContext != null) && (paramContext.size() > 1))
      {
        localObject = (SubscriptionInfo)paramContext.get(1);
        paramContext = ((SubscriptionInfo)localObject).getCarrierName().toString();
        str1 = String.valueOf(((SubscriptionInfo)localObject).getMcc());
        localObject = String.valueOf(((SubscriptionInfo)localObject).getMnc());
        break label85;
      }
    }
    Object localObject = "";
    String str1 = "";
    paramContext = str2;
    label85:
    paramContext = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(",,", paramContext, ",", str1, ","), (String)localObject, ",,,,,,");
    if (!NPTApplication.y) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("SIM2 details:", paramContext);
    }
    return paramContext;
  }
  
  public static int updateNotification(Context paramContext)
  {
    return ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getRssi();
  }
  
  public static long write(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (!NPTApplication.y) {
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("Error in parsing", paramString);
    }
    return 0L;
  }
  
  public static void write(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte['?'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
}
