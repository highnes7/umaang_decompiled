package in.spicedigital.umang.activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.location.Location;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager.WakeLock;
import android.support.v4.content.FileProvider;
import android.support.v4.package_7.FragmentActivity;
import android.support.v4.package_7.NotificationCompat.Builder;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Base64OutputStream;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnDismissListener;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.GoogleApiClient.Builder;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.android.location.FusedLocationProviderApi;
import com.google.android.android.location.LocationListener;
import com.google.android.android.location.LocationRequest;
import com.google.android.android.location.LocationServices;
import f.l.a.b.ClassWriter;
import f.objectweb.asm.e;
import f.objectweb.asm.h;
import f.objectweb.asm.l;
import in.spicedigital.umang.application.MyApplication;
import in.spicedigital.umang.utils.CustomAdvancedWebView;
import in.spicedigital.umang.utils.CustomAdvancedWebView.b;
import internal.view.menu.k;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import k.a.a.a.Ix;
import k.a.a.a.Jx;
import k.a.a.a.Kx;
import k.a.a.a.Lx;
import k.a.a.a.Mx;
import k.a.a.a.Nx;
import k.a.a.a.Ox;
import k.a.a.a.Px;
import k.a.a.a.Qx;
import k.a.a.a.Rx;
import k.a.a.a.Sx;
import k.a.a.a.Tx;
import k.a.a.a.Ux;
import k.a.a.a.Vx;
import k.a.a.a.Wx;
import k.a.a.a.Xx;
import k.a.a.a.Yx;
import k.a.a.a.Zx;
import k.a.a.a._x;
import k.a.a.a.ay;
import k.a.a.a.by;
import k.a.a.a.cy;
import k.a.a.a.dx;
import k.a.a.a.dy;
import k.a.a.a.ex;
import k.a.a.a.ey;
import k.a.a.a.fx;
import k.a.a.a.fy;
import k.a.a.a.gx;
import k.a.a.a.gy;
import k.a.a.a.hx;
import k.a.a.a.hy;
import k.a.a.a.ix;
import k.a.a.a.iy;
import k.a.a.a.jx;
import k.a.a.a.kx;
import k.a.a.a.lx;
import k.a.a.a.mx;
import k.a.a.a.nx;
import k.a.a.a.ox;
import k.a.a.a.px;
import k.a.a.a.qx;
import k.a.a.a.rx;
import k.a.a.a.sx;
import k.a.a.a.tx;
import k.a.a.a.ux;
import k.a.a.a.vx;
import k.a.a.a.wx;
import k.a.a.a.yx;
import k.a.a.c.a;
import k.a.a.m.Fa;
import k.a.a.m.M;
import k.a.a.m.ab;
import k.a.a.m.o;
import k.a.a.o.A;
import k.a.a.o.Q;
import k.a.a.o.r;
import k.a.a.o.s;
import k.a.a.o.v;
import k.a.a.o.y;
import k.a.a.o.z;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import support.android.v4.content.ContextCompat;

public class WebActivity
  extends BaseActivity
  implements CustomAdvancedWebView.b, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener
{
  public static String CONDITIONS_NUMBER;
  public static String CONDITION_TEXT;
  public static final String EVENTLOG_URL = "service_language";
  public static final String GRABICON_URL = "service_name";
  public static final int NOTIF_CRASH_ID = 666;
  public static final String SERVICE_ID = "service_id";
  public static String STROKE;
  public static String TAG;
  public static String c;
  public static Handler connection_timeout;
  public static boolean first = false;
  public static final int forDue = 744;
  public static final int j = 669;
  public static final String mSearchText = "service_url";
  public static final int o = 667;
  public static String path;
  public static Handler protocol;
  public static final int result_maxspeedsset = 668;
  public static final int result_paused_all = 672;
  public static final int time = 670;
  public static final int u = 673;
  public static final int v = 711;
  public static final int voice_input = 671;
  public int F;
  public boolean G;
  public y L;
  public k.a.a.o.d N;
  public String P;
  public int S;
  public String V;
  public CustomAdvancedWebView a;
  public String action;
  public String authToken;
  public v b;
  public int checksum = 6000;
  public Toolbar context;
  public LinearLayout current;
  public r d;
  public String data = "";
  public TextView date;
  public View deleteItem;
  public TextView description;
  public DrawerLayout drawer;
  public Q e;
  public ThreadPoolExecutor executor;
  public f.l.a.b.f f;
  public ImageView fab;
  public IntentFilter filter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
  public TextView from;
  public String g;
  public boolean h = false;
  public Handler handle = (Handler)new Sx(this);
  public LinearLayout handler;
  public LinearLayout header;
  public BroadcastReceiver headsetPlugReceiver;
  public z i;
  public String id = "300";
  public LinearLayout image;
  public k.a.a.e.System index;
  public ClassWriter interest;
  public boolean isRunning = false;
  public ab k;
  public Date lastUpdated;
  public ProgressBar loading;
  public ListView lv;
  public LinearLayout mAdapter;
  public LinearLayout mButton;
  public GoogleApiClient mConnection;
  public LinearLayout mContainer;
  public LinearLayout mContent;
  public String mContext;
  public int mCurrentKeyMode = 0;
  public FrameLayout mHeader;
  public Location mLocation;
  public ImageView mMenuButton;
  public ImageView mNextButton;
  public PopupWindow mPopup;
  public PopupMenu mPopupMenu;
  public ImageView mProgressBar;
  public ProgressDialog mProgressDialog;
  public TextView mResultCount;
  public WebChromeClient.CustomViewCallback mService;
  public boolean mState = false;
  public String mStatus;
  public LinearLayout mTitle;
  public ValueCallback<Uri[]> mUploadMessage;
  public LinearLayout mView;
  public WebActivity.c mWebView;
  public k n;
  public String name;
  public String out;
  public LocationRequest provider;
  public s q;
  public int r = 1008;
  public BroadcastReceiver receiver = (BroadcastReceiver)new Px(this);
  public View root;
  public String s = "";
  public int size = 1009;
  public boolean status;
  public final String str = "WebActivity";
  public int t = 0;
  public k.a.a.c.Log table;
  public LinearLayout text;
  public k.a.a.m.f this$0;
  public M title;
  public int type = 4162;
  public Date unit;
  public String url;
  public ValueCallback<Uri> val$filePathsCallback;
  public String value;
  public ImageView view;
  public boolean w = false;
  public PowerManager.WakeLock wakeLock;
  public o weight;
  public PopupWindow window;
  public A x;
  public WebActivity.b y;
  public boolean z;
  
  public WebActivity() {}
  
  private void a()
  {
    if (this$0.get(k.a.a.m.f.id, "false").equalsIgnoreCase("true")) {
      return;
    }
    Object localObject = Typeface.create("sans-serif-", 0);
    localObject = new h(this).a(new f.objectweb.asm.f[] { new e(view, getResources().getString(2131756220), getResources().getString(2131756221)).b((Typeface)localObject) });
    ((h)localObject).a(true);
    ((h)localObject).c(true);
    ((h)localObject).a((l)new iy(this));
    ((h)localObject).c();
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[13] = 1;
    int m = (byte)(paramInt >> 8);
    paramArrayOfByte[14] = m;
    int i1 = (byte)(paramInt & 0xFF);
    paramArrayOfByte[15] = i1;
    paramArrayOfByte[16] = m;
    paramArrayOfByte[17] = i1;
    return paramArrayOfByte;
  }
  
  private boolean add(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    return paramInputStream.available() / 1024 <= paramInt;
  }
  
  private void addMarker(String paramString1, String paramString2)
  {
    paramString1 = f.sufficientlysecure.rootcommands.util.StringBuilder.get(this, SelectBiometricDeviceScreen.class, "successCallback", paramString1);
    paramString1.putExtra("failureCallback", paramString2);
    startActivityForResult(paramString1, 711);
  }
  
  private void call()
  {
    if (!isFinishing()) {
      try
      {
        Object localObject = new Kx(this);
        localObject = (Runnable)localObject;
        runOnUiThread((Runnable)localObject);
        return;
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
        Toast.makeText(this, getResources().getString(2131756127), 1).show();
      }
    }
  }
  
  private File createTempFile()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory());
    ((StringBuilder)localObject).append("/Android/data/");
    ((StringBuilder)localObject).append(getApplicationContext().getPackageName());
    ((StringBuilder)localObject).append("/Files");
    localObject = new File(((StringBuilder)localObject).toString());
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      return null;
    }
    String str1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("MI_", new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date()), ".jpg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getPath());
    return new File(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, File.separator, str1));
  }
  
  private void deleteCookies()
  {
    CookieManager localCookieManager = CookieManager.getInstance();
    if (Build.VERSION.SDK_INT >= 21)
    {
      localCookieManager.removeAllCookies((ValueCallback)new ay(this));
      return;
    }
    localCookieManager.removeAllCookie();
  }
  
  private void doInBackground(String paramString)
  {
    Object localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("SERVICE_URL ====");
    ((StringBuilder)localObject1).append(name);
    ((StringBuilder)localObject1).toString();
    Object localObject7 = null;
    Object localObject8;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject3;
    try
    {
      localObject8 = k.a.a.m.Log.execute(this);
      boolean bool;
      if (!status) {
        try
        {
          localObject1 = getIntent().getStringExtra("tab_state_id");
          if (localObject1 != null)
          {
            bool = ((String)localObject1).equalsIgnoreCase("");
            if (!bool)
            {
              bool = ((String)localObject1).equalsIgnoreCase("-1");
              if (!bool)
              {
                ((JSONObject)localObject8).put("tab_state_id", localObject1);
                ((JSONObject)localObject8).put("tab_state_name", k.a.a.m.Log.get(this, (String)localObject1));
              }
            }
          }
        }
        catch (Exception localException1)
        {
          k.a.a.m.StringBuilder.append(localException1);
        }
      }
      String str1 = url;
      try
      {
        bool = str1.equalsIgnoreCase("recently_viewed");
        if (bool)
        {
          str1 = url;
          url = "";
          localObject4 = "";
          localObject5 = "";
          localObject6 = "";
        }
        else
        {
          str1 = getIntent().getStringExtra("source_tab");
          localObject4 = getIntent().getStringExtra("source_section");
          localObject5 = getIntent().getStringExtra("source_state");
          localObject6 = getIntent().getStringExtra("source_banner");
        }
        if (str1 != null)
        {
          bool = str1.equalsIgnoreCase("");
          if (!bool)
          {
            ((JSONObject)localObject8).put("source_tab", str1);
            ((JSONObject)localObject8).put("source_section", localObject4);
            ((JSONObject)localObject8).put("source_state", localObject5);
            ((JSONObject)localObject8).put("source_banner", localObject6);
          }
        }
      }
      catch (Exception localException2)
      {
        localObject2 = (Exception)localException2;
        k.a.a.m.StringBuilder.append((Exception)localObject2);
      }
      Object localObject2 = value;
      ((JSONObject)localObject8).put("service_id", localObject2);
      ((JSONObject)localObject8).put("network_type", k.a.a.m.Log.initialize(this));
      if (!status)
      {
        localObject2 = this$0;
        localObject4 = k.a.a.m.f.port;
        ((JSONObject)localObject8).put("ms", ((k.a.a.m.f)localObject2).get((String)localObject4, "true"));
        localObject2 = new JSONObject(k.a.a.m.Log.e(this));
        localObject4 = this$0;
        localObject5 = k.a.a.m.f.port;
        ((JSONObject)localObject2).put("ms", ((k.a.a.m.f)localObject4).get((String)localObject5, "true"));
        ((JSONObject)localObject8).put("userinfo", localObject2);
        ((JSONObject)localObject8).put("mno", k.a.a.m.Log.add(this));
        ((JSONObject)localObject8).put("aadhr", k.a.a.m.Log.d(this));
        localObject2 = this$0;
        localObject4 = k.a.a.m.f.app;
        ((JSONObject)localObject8).put("utkn", ((k.a.a.m.f)localObject2).get((String)localObject4, ""));
        localObject2 = this$0;
        localObject4 = k.a.a.m.f.m_ProgressBar;
        ((JSONObject)localObject8).put("rtkn", ((k.a.a.m.f)localObject2).get((String)localObject4, ""));
        localObject2 = this$0;
        localObject4 = k.a.a.m.f.connection;
        bool = ((k.a.a.m.f)localObject2).get((String)localObject4, "").equalsIgnoreCase("");
        if (!bool)
        {
          localObject4 = new JSONObject();
          localObject2 = new JSONObject();
          localObject5 = this$0;
          localObject6 = k.a.a.m.f.connection;
          ((JSONObject)localObject2).put("username", ((k.a.a.m.f)localObject5).get((String)localObject6, ""));
          localObject5 = this$0;
          localObject6 = k.a.a.m.f.method;
          ((JSONObject)localObject2).put("password", ((k.a.a.m.f)localObject5).get((String)localObject6, ""));
          ((JSONObject)localObject4).put("digilocker", localObject2);
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("digilocker...................");
          ((StringBuilder)localObject4).append(((JSONObject)localObject2).toString());
          ((StringBuilder)localObject4).toString();
          ((JSONObject)localObject8).put("digilocker", localObject2);
        }
        else
        {
          ((JSONObject)localObject8).put("digilocker", null);
        }
      }
      if (action != null)
      {
        ((JSONObject)localObject8).remove("lang");
        localObject2 = action;
        ((JSONObject)localObject8).put("lang", localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("LANGUAGE---------------------------- ");
        localObject4 = action;
        ((StringBuilder)localObject2).append((String)localObject4);
        ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = this$0;
        localObject4 = k.a.a.m.f.c;
        localObject5 = ((k.a.a.m.f)localObject2).get((String)localObject4, "en");
        localObject2 = localObject5;
        localObject4 = this$0;
        localObject6 = k.a.a.m.f.this$0;
        bool = ((k.a.a.m.f)localObject4).get((String)localObject6, "").isEmpty();
        if (bool)
        {
          localObject4 = index;
          localObject6 = value;
          localObject4 = ((k.a.a.e.System)localObject4).remove((String)localObject6);
        }
        else
        {
          localObject4 = index;
          localObject6 = value;
          localObject4 = ((k.a.a.e.System)localObject4).get((String)localObject6);
        }
        bool = ((String)localObject4).contains((CharSequence)localObject5);
        if (!bool) {
          localObject2 = "en";
        }
        ((JSONObject)localObject8).remove("lang");
        ((JSONObject)localObject8).put("lang", localObject2);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("LANGUAGE---------------------------- ");
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("resJson : ");
      ((StringBuilder)localObject2).append(localObject8);
      ((StringBuilder)localObject2).toString();
      if (!status)
      {
        localObject2 = new k.a.a.m.System(this).a();
        if (localObject2 != null)
        {
          int m = ((a)localObject2).h().length();
          if (m == 12)
          {
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("adhr_name", ((a)localObject2).r());
            ((JSONObject)localObject4).put("adhr_dob", ((a)localObject2).l());
            ((JSONObject)localObject4).put("adhr_co", ((a)localObject2).i());
            ((JSONObject)localObject4).put("adhr_gndr", ((a)localObject2).n());
            ((JSONObject)localObject4).put("adhr_imgurl", ((a)localObject2).p());
            ((JSONObject)localObject4).put("adhr_state", ((a)localObject2).t());
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("adharObj.getDistrictAdhr().........................");
            ((StringBuilder)localObject5).append(((a)localObject2).k());
            ((StringBuilder)localObject5).toString();
            ((JSONObject)localObject4).put("adhr_dist", ((a)localObject2).k());
            ((JSONObject)localObject8).put("adhrinfo", localObject4);
          }
        }
        else
        {
          ((JSONObject)localObject8).put("adhrinfo", null);
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("JSON == ");
      ((StringBuilder)localObject2).append(((JSONObject)localObject8).toString());
      ((StringBuilder)localObject2).toString();
      localObject2 = ((JSONObject)localObject8).toString();
    }
    catch (Exception localException3)
    {
      localObject3 = (Exception)localException3;
    }
    try
    {
      k.a.a.m.StringBuilder.append((Exception)localObject3);
      localObject3 = localObject7;
      localObject4 = URI.create(paramString);
      localObject5 = Calendar.getInstance();
      localObject6 = Locale.US;
      localObject5 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", (Locale)localObject6).format(((Calendar)localObject5).getTime());
      localObject6 = login((String)localObject3);
      localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append("GET");
      ((StringBuilder)localObject7).append("\n");
      ((StringBuilder)localObject7).append(((String)localObject6).trim());
      ((StringBuilder)localObject7).append("\n");
      ((StringBuilder)localObject7).append("application/vnd.umang.web+json; charset=UTF-8");
      ((StringBuilder)localObject7).append("\n");
      ((StringBuilder)localObject7).append(((String)localObject5).trim());
      ((StringBuilder)localObject7).append("\n");
      ((StringBuilder)localObject7).append(((URI)localObject4).getPath().trim());
      localObject7 = sign(((StringBuilder)localObject7).toString());
      localObject4 = new HashMap();
      localObject8 = new StringBuilder();
      ((StringBuilder)localObject8).append("UM4NG");
      ((StringBuilder)localObject8).append(":");
      ((StringBuilder)localObject8).append(((String)localObject7).trim());
      ((Map)localObject4).put("X-App-Authorization", ((StringBuilder)localObject8).toString());
      ((Map)localObject4).put("X-App-Date", localObject5);
      ((Map)localObject4).put("X-App-Content", ((String)localObject6).trim());
      ((Map)localObject4).put("Accept-Encoding", "gzip");
      localObject5 = Charset.forName("UTF-8");
      ((Map)localObject4).put("X-App-Data", new String(((String)localObject3).getBytes(), (Charset)localObject5));
      ((Map)localObject4).put("Content-Type", "application/vnd.umang.web+json; charset=UTF-8");
      localObject3 = (WebView)a;
      ((WebView)localObject3).getSettings().setDefaultTextEncodingName("application/vnd.umang.web+json; charset=UTF-8");
      localObject3 = a;
      ((CustomAdvancedWebView)localObject3).loadUrl(paramString, (Map)localObject4);
      return;
    }
    catch (Exception paramString)
    {
      k.a.a.m.StringBuilder.append(paramString);
    }
  }
  
  private String encode(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
    return Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 0);
  }
  
  private boolean get(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte.length / 1024 <= paramInt;
  }
  
  private void getContent(String paramString)
  {
    try
    {
      paramString = getAssets().open(paramString);
      int m = paramString.available();
      Object localObject = new byte[m];
      paramString.read((byte[])localObject);
      paramString.close();
      paramString = Base64.encodeToString((byte[])localObject, 2);
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:(function() {var parent = document.getElementsByTagName('head').item(0);var script = document.createElement('script');script.type = 'text/javascript';script.innerHTML = window.atob('");
      localStringBuilder.append(paramString);
      localStringBuilder.append("');parent.appendChild(script)})()");
      ((CustomAdvancedWebView)localObject).loadUrl(localStringBuilder.toString());
      return;
    }
    catch (Exception paramString)
    {
      k.a.a.m.StringBuilder.append(paramString);
    }
  }
  
  private String getMimeType(Uri paramUri)
  {
    Object localObject;
    try
    {
      localObject = getContentResolver();
      localObject = MimeTypeMap.getSingleton().getExtensionFromMimeType(((ContentResolver)localObject).getType(paramUri));
      if (localObject == null)
      {
        paramUri = MimeTypeMap.getFileExtensionFromUrl(paramUri.getPath());
        return paramUri;
      }
    }
    catch (Exception paramUri)
    {
      k.a.a.m.StringBuilder.append(paramUri);
      return "";
    }
    return localObject;
  }
  
  private String getRealPathFromURI(Uri paramUri)
  {
    Cursor localCursor = getContentResolver().query(paramUri, null, null, null, null);
    if (localCursor == null) {
      return paramUri.getPath();
    }
    localCursor.moveToFirst();
    paramUri = localCursor.getString(localCursor.getColumnIndex("_data"));
    localCursor.close();
    return paramUri;
  }
  
  public static int getScale(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i1 = outHeight;
    int i2 = outWidth;
    int m = 1;
    if ((i1 > paramInt2) || (i2 > paramInt1))
    {
      i1 /= 2;
      i2 /= 2;
    }
    while ((i1 / m >= paramInt2) && (i2 / m >= paramInt1))
    {
      m *= 2;
      continue;
      return 1;
    }
    return m;
  }
  
  private void init()
  {
    loading = ((ProgressBar)findViewById(2131297314));
    header = ((LinearLayout)findViewById(2131297433));
    current = ((LinearLayout)findViewById(2131296537));
    f = f.l.a.b.f.a();
    interest = f.sufficientlysecure.rootcommands.util.StringBuilder.a(true, true).get(Bitmap.Config.RGB_565).getString();
    mButton = ((LinearLayout)findViewById(2131296411));
    mButton.setVisibility(8);
    mPopupMenu = new PopupMenu(this, mMenuButton);
    mPopupMenu.setOnDismissListener((PopupMenu.OnDismissListener)new WebActivity.d(this, null));
    mPopupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new WebActivity.e(this, null));
    mPopupMenu.inflate(2131558407);
    view = ((ImageView)root.findViewById(2131297373));
    mMenuButton = ((ImageView)root.findViewById(2131297123));
    mProgressBar = ((ImageView)root.findViewById(2131296568));
    fab = ((ImageView)root.findViewById(2131296606));
    drawer = ((DrawerLayout)findViewById(2131296686));
    a = ((CustomAdvancedWebView)findViewById(2131298023));
    handler = ((LinearLayout)findViewById(2131296876));
    lv = ((ListView)findViewById(2131297370));
    mHeader = ((FrameLayout)findViewById(2131296590));
    L = new y(this);
    N = new k.a.a.o.d(this);
    b = new v(this);
    q = new s(this);
    d = new r(this);
    e = new Q(this);
    i = new z(this);
    x = new A(this);
    ((WebView)a).getSettings().setJavaScriptEnabled(true);
    a.setGeolocationEnabled(true);
    a.a(this, this, 4000);
    CustomAdvancedWebView localCustomAdvancedWebView = a;
    Object localObject = N;
    ((WebView)localCustomAdvancedWebView).addJavascriptInterface(localObject, "Camera");
    localCustomAdvancedWebView = a;
    localObject = L;
    ((WebView)localCustomAdvancedWebView).addJavascriptInterface(localObject, "Location");
    localCustomAdvancedWebView = a;
    localObject = b;
    ((WebView)localCustomAdvancedWebView).addJavascriptInterface(localObject, "FileDownload");
    localCustomAdvancedWebView = a;
    localObject = q;
    ((WebView)localCustomAdvancedWebView).addJavascriptInterface(localObject, "Contacts");
    localCustomAdvancedWebView = a;
    localObject = d;
    ((WebView)localCustomAdvancedWebView).addJavascriptInterface(localObject, "Common");
    localCustomAdvancedWebView = a;
    localObject = e;
    ((WebView)localCustomAdvancedWebView).addJavascriptInterface(localObject, "TRAI");
    localCustomAdvancedWebView = a;
    localObject = x;
    ((WebView)localCustomAdvancedWebView).addJavascriptInterface(localObject, "NDL");
    localCustomAdvancedWebView = a;
    localObject = i;
    ((WebView)localCustomAdvancedWebView).addJavascriptInterface(localObject, "MHA");
    a.setWebViewClient((WebViewClient)new dx(this));
    ((WebView)a).getSettings().setAllowFileAccess(false);
    ((WebView)a).getSettings().setAllowContentAccess(false);
    ((WebView)a).getSettings().setAllowFileAccessFromFileURLs(false);
    ((WebView)a).getSettings().setAllowContentAccess(false);
    ((WebView)a).getSettings().setAppCacheEnabled(true);
    ((WebView)a).getSettings().setJavaScriptEnabled(true);
    ((WebView)a).getSettings().setDomStorageEnabled(true);
    ((WebView)a).getSettings().setGeolocationEnabled(true);
    ((WebView)a).getSettings().setDefaultTextEncodingName("UTF-8");
    ((WebView)a).getSettings().setAllowUniversalAccessFromFileURLs(true);
    y = new WebActivity.b(this);
    a.setWebChromeClient((WebChromeClient)y);
    localCustomAdvancedWebView = a;
    localObject = new ex(this);
    ((WebView)localCustomAdvancedWebView).setDownloadListener((DownloadListener)localObject);
    int m = Build.VERSION.SDK_INT;
    WebView.setWebContentsDebuggingEnabled(true);
    ((WebView)a).getSettings().setCacheMode(-1);
    ((WebView)a).getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
    if (!k.a.a.m.Log.check(this)) {
      ((WebView)a).getSettings().setCacheMode(1);
    }
  }
  
  private void init(String paramString)
  {
    try
    {
      paramString = getAssets().open(paramString);
      int m = paramString.available();
      Object localObject = new byte[m];
      paramString.read((byte[])localObject);
      paramString.close();
      paramString = Base64.encodeToString((byte[])localObject, 2);
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:(function() {var parent = document.getElementsByTagName('head').item(0);var style = document.createElement('style');style.type = 'text/css';style.innerHTML = window.atob('");
      localStringBuilder.append(paramString);
      localStringBuilder.append("');parent.appendChild(style)})()");
      ((CustomAdvancedWebView)localObject).loadUrl(localStringBuilder.toString());
      return;
    }
    catch (Exception paramString)
    {
      k.a.a.m.StringBuilder.append(paramString);
    }
  }
  
  private void init(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      mButton.setVisibility(0);
      paramString = (Button)findViewById(2131297161);
      paramString.setVisibility(8);
      paramString.setOnClickListener((View.OnClickListener)new wx(this));
      return;
    }
    mButton.setVisibility(8);
  }
  
  private void initialize()
  {
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131492979, null);
    mPopup = new PopupWindow(localView, -2, -2);
    mPopup.setBackgroundDrawable(new BitmapDrawable());
    mPopup.setOutsideTouchable(true);
    mPopup.setOnDismissListener((PopupWindow.OnDismissListener)new gx(this));
    text = ((LinearLayout)localView.findViewById(2131297280));
    image = ((LinearLayout)localView.findViewById(2131297015));
    text.setOnClickListener((View.OnClickListener)new hx(this));
    image.setOnClickListener((View.OnClickListener)new ix(this));
  }
  
  private boolean isAppInstalled(String paramString)
  {
    PackageManager localPackageManager = getPackageManager();
    try
    {
      localPackageManager.getPackageInfo(paramString, 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;) {}
    }
    return false;
  }
  
  private void load(Uri paramUri, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localObject1 = getContentResolver().getType(paramUri);
        localObject2 = getContentResolver().openInputStream(paramUri);
        m = ((InputStream)localObject2).available();
        localObject3 = new byte[m];
        str1 = id;
        boolean bool = get((byte[])localObject3, Integer.getInteger(str1, 5000).intValue());
        if (!bool) {}
      }
      catch (FileNotFoundException paramUri)
      {
        Object localObject1;
        Object localObject2;
        int m;
        Object localObject3;
        String str1;
        continue;
      }
      catch (IOException paramUri)
      {
        label420:
        continue;
      }
      try
      {
        localObject2 = readFile((InputStream)localObject2).replaceAll("\\s+", "");
        if (!paramBoolean) {}
      }
      catch (Exception paramUri) {}
    }
    try
    {
      paramUri = getContentResolver().query(paramUri, null, null, null, null);
      m = paramUri.getColumnIndex("_display_name");
      paramUri.moveToFirst();
      localObject3 = paramUri.getString(m);
      paramUri.close();
      paramUri = new StringBuilder();
      paramUri.append("File name:-");
      paramUri.append((String)localObject3);
      Toast.makeText(this, paramUri.toString(), 0).show();
      paramUri = new JSONObject();
      paramUri.put("fileName", localObject3);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("data:");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(";base64,");
      ((StringBuilder)localObject3).append((String)localObject2);
      paramUri.put("fileData", ((StringBuilder)localObject3).toString());
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("javascript:");
      localObject3 = c;
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(paramUri.toString());
      ((StringBuilder)localObject2).append(")");
      paramUri = ((StringBuilder)localObject2).toString();
      localObject1 = (WebView)localObject1;
      ((WebView)localObject1).evaluateJavascript(paramUri, null);
      return;
    }
    catch (Exception paramUri)
    {
      break label420;
    }
    paramUri = a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("javascript:");
    str1 = c;
    ((StringBuilder)localObject3).append(str1);
    ((StringBuilder)localObject3).append("(\"data:");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(";base64,");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("\")");
    localObject1 = ((StringBuilder)localObject3).toString();
    paramUri = (WebView)paramUri;
    paramUri.evaluateJavascript((String)localObject1, null);
    return;
    paramUri = a;
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("javascript:");
      localObject2 = TAG;
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("(\"IO_EXCEPTION\")");
      paramUri.loadUrl(((StringBuilder)localObject1).toString());
      return;
    }
    catch (FileNotFoundException paramUri)
    {
      for (;;) {}
    }
    catch (IOException paramUri)
    {
      for (;;) {}
    }
    paramUri = a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("javascript:");
    localObject2 = TAG;
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("(\"FILE_SIZE_EXCEEDED\")");
    paramUri.loadUrl(((StringBuilder)localObject1).toString());
    return;
    paramUri = a;
    localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("javascript:");
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append("(\"IO_EXCEPTION\")");
    paramUri.loadUrl(((StringBuilder)localObject1).toString());
    return;
    paramUri = a;
    localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("javascript:");
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append("(\"FILE_NOT_FOUND\")");
    paramUri.loadUrl(((StringBuilder)localObject1).toString());
  }
  
  private String login(String paramString)
    throws NoSuchAlgorithmException
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MD5 contentToEncode : ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).toString();
    localObject = MessageDigest.getInstance("MD5");
    ((MessageDigest)localObject).update(paramString.getBytes());
    paramString = new String(Base64.encode(((MessageDigest)localObject).digest(), 0));
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("MD5 result : ", paramString);
    return paramString;
  }
  
  private File moveFile(String paramString)
  {
    Object localObject = new File(Environment.getExternalStorageDirectory(), "UMANG");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new File((File)localObject, "Digilocker");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject);
    paramString = new File(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, File.separator, paramString));
    data = paramString.getAbsolutePath();
    localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("FILE PATH === ");
    ((StringBuilder)localObject).append(paramString.getAbsolutePath());
    ((StringBuilder)localObject).toString();
    return paramString;
  }
  
  private void newInstance(int paramInt, Intent paramIntent)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramInt == -1) {}
    try
    {
      localJSONObject.put("status", paramIntent.getStringExtra("status"));
      localJSONObject.put("id", paramIntent.getStringExtra("id"));
      localJSONObject.put("rating", paramIntent.getStringExtra("rating"));
      localJSONObject.put("location", paramIntent.getStringExtra("location"));
      localJSONObject.put("info", paramIntent.getStringExtra("info"));
      localJSONObject.put("comment", paramIntent.getStringExtra("comment"));
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
    localJSONObject.put("status", "f");
    setTitle(localJSONObject.toString());
  }
  
  private void onCreate()
  {
    try
    {
      Object localObject = getIntent().getExtras().getString("service_name");
      mStatus = ((String)localObject);
      localObject = getIntent().getExtras().getString("service_url");
      name = ((String)localObject);
      localObject = getIntent().getExtras().getString("service_id");
      value = ((String)localObject);
      localObject = getIntent().getExtras().getString("service_language");
      action = ((String)localObject);
      localObject = k.a.a.e.System.getInstance(this);
      String str1 = value;
      localObject = ((k.a.a.e.System)localObject).read(str1);
      table = ((k.a.a.c.Log)localObject);
      return;
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
    }
  }
  
  private void onCreate(int paramInt, Intent paramIntent)
  {
    this$0.put(k.a.a.m.f.uid, "true");
    paramIntent = new JSONObject();
    if (paramInt == -1) {}
    try
    {
      paramIntent.get("is_optimize", false);
      break label47;
      paramIntent.get("is_optimize", true);
      label47:
      paramIntent.put("optimize_dialog", "true");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    setTitle(paramIntent.toString());
  }
  
  private String open()
  {
    Object localObject = ((UsbManager)getSystemService("usb")).getDeviceList();
    Iterator localIterator = ((HashMap)localObject).values().iterator();
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("");
    localStringBuilder.append(((HashMap)localObject).size());
    localStringBuilder.toString();
    while (localIterator.hasNext())
    {
      localObject = (UsbDevice)localIterator.next();
      if ((String.valueOf(((UsbDevice)localObject).getProductId()).equalsIgnoreCase("4101")) && (String.valueOf(((UsbDevice)localObject).getVendorId()).equalsIgnoreCase("11279")))
      {
        Toast.makeText(this, "getConnectedDevice === MANTRA", 1);
        return "MANTRA";
      }
      if ((String.valueOf(((UsbDevice)localObject).getProductId()).equalsIgnoreCase("71")) && (String.valueOf(((UsbDevice)localObject).getVendorId()).equalsIgnoreCase("1947"))) {
        return "MORPHO";
      }
    }
    return null;
  }
  
  private void parse()
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject3 = k.a.a.m.Log.execute(this);
      JSONObject localJSONObject1 = localJSONObject3;
      String str1 = value;
      localJSONObject3.put("sid", str1);
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      new k.a.a.l.List((k.a.a.i.List)new ux(this), "https://app.umang.gov.in/umang/coreapi/ws2/fdptmsg", localJSONObject2, this).execute(new Object[0]);
    }
  }
  
  private byte[] put(Bitmap paramBitmap, int paramInt)
  {
    paramBitmap.getRowBytes();
    paramBitmap.getHeight();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    paramBitmap = new StringBuilder();
    paramBitmap.append(localByteArrayOutputStream.size());
    paramBitmap.append("");
    paramBitmap.toString();
    return localByteArrayOutputStream.toByteArray();
  }
  
  private byte[] read(Uri paramUri, int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = UpdateProfileScreen.rescaleImage(this, paramUri, paramInt1);
      paramInt1 = 60;
      for (paramUri = put(localBitmap, 60); paramUri.length / 1024 > paramInt2; paramUri = put(localBitmap, paramInt1)) {
        paramInt1 -= 5;
      }
      return paramUri;
    }
    catch (FileNotFoundException paramUri)
    {
      a.loadUrl(f.sufficientlysecure.rootcommands.util.StringBuilder.replace(f.sufficientlysecure.rootcommands.util.StringBuilder.append("javascript:"), TAG, "(\"", "FNF", "\")"));
      k.a.a.m.StringBuilder.append(paramUri);
    }
    return null;
  }
  
  private String readFile(InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['?'];
    localByteArrayOutputStream = new ByteArrayOutputStream();
    Base64OutputStream localBase64OutputStream = new Base64OutputStream(localByteArrayOutputStream, 0);
    try
    {
      for (;;)
      {
        int m = paramInputStream.read(arrayOfByte);
        if (m == -1) {
          break;
        }
        localBase64OutputStream.write(arrayOfByte, 0, m);
      }
      return localByteArrayOutputStream.toString();
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
      localBase64OutputStream.close();
    }
  }
  
  private boolean readFully(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    return paramInputStream.available() / 1024 >= paramInt;
  }
  
  private void registerNetworkReceiver()
  {
    Fa localFa = new Fa(new vx(this), this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    headsetPlugReceiver = ((BroadcastReceiver)localFa.c());
    registerReceiver(headsetPlugReceiver, localIntentFilter);
  }
  
  private void save(String paramString1, String paramString2)
  {
    Object localObject1 = Base64.decode(paramString1, 0);
    Bitmap localBitmap = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
    localObject1 = String.format("Pansig-%s.jpg", new Object[] { Long.valueOf(Calendar.getInstance().getTimeInMillis()) });
    Object localObject2 = new File(getFilesDir(), "Pan");
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject1 = new File((File)localObject2, (String)localObject1);
    localObject2 = null;
    try
    {
      localObject1 = new FileOutputStream((File)localObject1);
      Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.JPEG;
      localObject2 = localObject1;
      try
      {
        localBitmap.compress(localCompressFormat, 100, (OutputStream)localObject1);
      }
      catch (Throwable paramString2)
      {
        paramString1 = (String)localObject2;
        break label206;
      }
      catch (FileNotFoundException localFileNotFoundException1) {}
      localObject2 = localObject1;
    }
    catch (Throwable paramString2)
    {
      paramString1 = (String)localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException2)
    {
      localObject1 = null;
    }
    localFileNotFoundException2.printStackTrace();
    if (localObject1 != null) {}
    try
    {
      ((FileOutputStream)localObject1).close();
      localObject1 = a;
      localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("javascript:");
      f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject2, c, "(\"data:image/", paramString2, ";base64,");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("\")");
      ((CustomAdvancedWebView)localObject1).loadUrl(((StringBuilder)localObject2).toString());
      return;
      label206:
      if (paramString1 == null) {}
    }
    catch (IOException localIOException)
    {
      try
      {
        paramString1.close();
        throw paramString2;
        localIOException = localIOException;
      }
      catch (IOException paramString1)
      {
        for (;;) {}
      }
    }
  }
  
  private void show()
  {
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131492980, null);
    window = new PopupWindow(localView, -2, -2);
    window.setBackgroundDrawable(new BitmapDrawable());
    window.setOutsideTouchable(true);
    window.setOnDismissListener((PopupWindow.OnDismissListener)new jx(this));
    mAdapter = ((LinearLayout)localView.findViewById(2131298008));
    mView = ((LinearLayout)localView.findViewById(2131297350));
    mContainer = ((LinearLayout)localView.findViewById(2131297569));
    mTitle = ((LinearLayout)localView.findViewById(2131296915));
    mContent = ((LinearLayout)localView.findViewById(2131297016));
    mAdapter.setOnClickListener((View.OnClickListener)new kx(this));
    mView.setOnClickListener((View.OnClickListener)new lx(this));
    mContainer.setOnClickListener((View.OnClickListener)new mx(this));
    mTitle.setOnClickListener((View.OnClickListener)new ox(this));
    mContent.setOnClickListener((View.OnClickListener)new px(this));
  }
  
  private String sign(String paramString)
  {
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hmac data : ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).toString();
      localObject = MyApplication.q;
      localObject = new SecretKeySpec(((String)localObject).getBytes(), "HmacSHA1");
      Mac localMac = Mac.getInstance("HmacSHA1");
      localMac.init((Key)localObject);
      paramString = localMac.doFinal(paramString.getBytes());
      paramString = new String(Base64.encode(paramString, 0));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hmac result : ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).toString();
      return paramString;
    }
    catch (GeneralSecurityException paramString)
    {
      Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unexpected error while creating hash: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      ((StringBuilder)localObject).toString();
      throw new IllegalArgumentException();
    }
  }
  
  private int sizeOf(Bitmap paramBitmap)
  {
    int m = Build.VERSION.SDK_INT;
    return paramBitmap.getByteCount();
  }
  
  private void start()
  {
    try
    {
      String str1 = write();
      if (str1 != null)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("pidOptions...");
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).toString();
        localObject = new Intent();
        ((Intent)localObject).setAction("in.gov.uidai.rdservice.fp.CAPTURE");
        ((Intent)localObject).putExtra("PID_OPTIONS", str1);
        startActivityForResult((Intent)localObject, 744);
        MyApplication.started = true;
        return;
      }
    }
    catch (Exception localException)
    {
      localException.toString();
    }
  }
  
  private void storeImage(Bitmap paramBitmap)
  {
    Object localObject = createTempFile();
    if (localObject == null) {
      return;
    }
    try
    {
      localObject = new FileOutputStream((File)localObject);
      Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;
      paramBitmap.compress(localCompressFormat, 90, (OutputStream)localObject);
      ((FileOutputStream)localObject).close();
      return;
    }
    catch (IOException paramBitmap)
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Error accessing file: ");
      ((StringBuilder)localObject).append(paramBitmap.getMessage());
      ((StringBuilder)localObject).toString();
      return;
    }
    catch (FileNotFoundException paramBitmap)
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("File not found: ");
      ((StringBuilder)localObject).append(paramBitmap.getMessage());
      ((StringBuilder)localObject).toString();
    }
  }
  
  private void update()
  {
    int i1 = name.length();
    int m = 0;
    if (i1 > 0)
    {
      ((WebView)a).setVisibility(0);
      doInBackground(name);
    }
    else
    {
      ((WebView)a).setVisibility(8);
    }
    header.setVisibility(8);
    loading.setVisibility(0);
    ((WebView)a).setVisibility(8);
    h = false;
    Object localObject1 = table;
    if (localObject1 != null) {
      index.search(((k.a.a.c.Log)localObject1).getName());
    }
    new ArrayList();
    Object localObject2 = index.search();
    localObject1 = new ArrayList();
    while (m < ((ArrayList)localObject2).size())
    {
      k.a.a.c.Log localLog = index.read((String)((ArrayList)localObject2).get(m));
      if (localLog != null)
      {
        StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("RECENT SERVICE ID : ");
        localStringBuilder.append((String)((ArrayList)localObject2).get(m));
        localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("RECENT SERVICE NAME : ");
        localStringBuilder.append(localLog.getValue());
        localStringBuilder.toString();
        ((ArrayList)localObject1).add(localLog);
      }
      m += 1;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("recentServicesAlist size..................");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("recentServicesAlist size..................");
    ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
    ((StringBuilder)localObject2).toString();
    lv.setAdapter((ListAdapter)new WebActivity.a(this, (ArrayList)localObject1));
    localObject1 = mStatus;
    if (localObject1 != null)
    {
      mResultCount.setText((CharSequence)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(mStatus);
      ((StringBuilder)localObject1).append(" Department Screen");
      k.a.a.m.Log.execute(this, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void update(Intent paramIntent)
  {
    if (!isFinishing()) {
      try
      {
        paramIntent = new Ix(this, paramIntent);
        paramIntent = (Runnable)paramIntent;
        runOnUiThread(paramIntent);
        return;
      }
      catch (Exception paramIntent) {}
    }
  }
  
  private void upload(String paramString)
  {
    try
    {
      paramString = getAssets().open(paramString);
      int m = paramString.available();
      Object localObject = new byte[m];
      paramString.read((byte[])localObject);
      paramString.close();
      paramString = Base64.encodeToString((byte[])localObject, 2);
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:(function() {var parent = document.getElementsByTagName('head').item(0);var script = document.createElement('script');script.type = 'text/javascript';script.async = 'async';script.data-main = 'resources/js/main';script.innerHTML = window.atob('");
      localStringBuilder.append(paramString);
      localStringBuilder.append("');parent.appendChild(script)})()");
      ((CustomAdvancedWebView)localObject).loadUrl(localStringBuilder.toString());
      return;
    }
    catch (Exception paramString)
    {
      k.a.a.m.StringBuilder.append(paramString);
    }
  }
  
  private String write()
  {
    try
    {
      Object localObject1 = DocumentBuilderFactory.newInstance();
      ((DocumentBuilderFactory)localObject1).setNamespaceAware(true);
      localObject1 = ((DocumentBuilderFactory)localObject1).newDocumentBuilder().newDocument();
      ((Document)localObject1).setXmlStandalone(true);
      Object localObject3 = ((Document)localObject1).createElement("PidOptions");
      ((Document)localObject1).appendChild((Node)localObject3);
      Object localObject2 = ((Document)localObject1).createAttribute("ver");
      ((Attr)localObject2).setValue("1.0");
      ((Element)localObject3).setAttributeNode((Attr)localObject2);
      localObject2 = ((Document)localObject1).createElement("Opts");
      ((Element)localObject3).appendChild((Node)localObject2);
      localObject3 = ((Document)localObject1).createAttribute("fCount");
      ((Attr)localObject3).setValue(String.valueOf(1));
      ((Element)localObject2).setAttributeNode((Attr)localObject3);
      localObject3 = ((Document)localObject1).createAttribute("fType");
      ((Attr)localObject3).setValue("0");
      ((Element)localObject2).setAttributeNode((Attr)localObject3);
      localObject3 = ((Document)localObject1).createAttribute("iCount");
      ((Attr)localObject3).setValue("0");
      ((Element)localObject2).setAttributeNode((Attr)localObject3);
      localObject3 = ((Document)localObject1).createAttribute("iType");
      ((Attr)localObject3).setValue("0");
      ((Element)localObject2).setAttributeNode((Attr)localObject3);
      localObject3 = ((Document)localObject1).createAttribute("pCount");
      ((Attr)localObject3).setValue("0");
      ((Element)localObject2).setAttributeNode((Attr)localObject3);
      localObject3 = ((Document)localObject1).createAttribute("pType");
      ((Attr)localObject3).setValue("0");
      ((Element)localObject2).setAttributeNode((Attr)localObject3);
      localObject3 = ((Document)localObject1).createAttribute("format");
      ((Attr)localObject3).setValue("0");
      ((Element)localObject2).setAttributeNode((Attr)localObject3);
      localObject3 = ((Document)localObject1).createAttribute("pidVer");
      ((Attr)localObject3).setValue("2.0");
      ((Element)localObject2).setAttributeNode((Attr)localObject3);
      localObject3 = ((Document)localObject1).createAttribute("timeout");
      ((Attr)localObject3).setValue("5000");
      ((Element)localObject2).setAttributeNode((Attr)localObject3);
      ((Document)localObject1).createAttribute("otp").setValue("");
      localObject3 = ((Document)localObject1).createAttribute("env");
      ((Attr)localObject3).setValue("P");
      ((Element)localObject2).setAttributeNode((Attr)localObject3);
      localObject3 = ((Document)localObject1).createAttribute("wadh");
      ((Attr)localObject3).setValue(encode(""));
      ((Element)localObject2).setAttributeNode((Attr)localObject3);
      localObject3 = ((Document)localObject1).createAttribute("posh");
      ((Attr)localObject3).setValue("UNKNOWN");
      ((Element)localObject2).setAttributeNode((Attr)localObject3);
      localObject2 = TransformerFactory.newInstance().newTransformer();
      ((Transformer)localObject2).setOutputProperty("standalone", "yes");
      localObject1 = new DOMSource((Node)localObject1);
      localObject3 = new StringWriter();
      ((Transformer)localObject2).transform((Source)localObject1, new StreamResult((Writer)localObject3));
      localObject1 = ((StringWriter)localObject3).getBuffer().toString().replaceAll("\n|\r", "").replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();
      return localObject1;
    }
    catch (ParserConfigurationException localParserConfigurationException)
    {
      return "ERROR in PID formation";
    }
    catch (TransformerConfigurationException localTransformerConfigurationException)
    {
      return "ERROR in PID formation";
    }
    catch (TransformerException localTransformerException)
    {
      for (;;) {}
    }
    return "ERROR  in PID formation";
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new ByteArrayInputStream(Base64.decode(paramString2.getBytes(), 0));
      localObject1 = Environment.getExternalStorageDirectory();
      Object localObject2 = new File((File)localObject1, "UMANG");
      bool = ((File)localObject2).exists();
      if (!bool) {
        ((File)localObject2).mkdirs();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localObject2);
      localObject2 = File.separator;
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(paramString1);
      localObject1 = new File(((StringBuilder)localObject1).toString());
      paramString1 = new FileOutputStream((File)localObject1);
      localObject2 = new byte['?'];
      try
      {
        for (;;)
        {
          int m = paramString2.read((byte[])localObject2);
          if (m == -1) {
            break;
          }
          paramString1.write((byte[])localObject2, 0, m);
        }
        paramString1.flush();
        paramString2 = new StringBuilder();
        paramString2.append(getResources().getString(2131755609));
        paramString2.append(" : ");
        paramString2.append(((File)localObject1).getAbsolutePath());
        Toast.makeText(this, paramString2.toString(), 1).show();
        paramString1.close();
      }
      catch (Throwable paramString2)
      {
        try
        {
          paramString1.close();
        }
        catch (Throwable paramString2)
        {
          break label272;
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            k.a.a.m.StringBuilder.append((Exception)paramString2);
            try
            {
              bool = ((File)localObject1).exists();
              if (bool) {
                ((File)localObject1).delete();
              }
            }
            catch (Exception paramString2)
            {
              k.a.a.m.StringBuilder.append(paramString2);
            }
          }
        }
        paramString2 = paramString2;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          k.a.a.m.StringBuilder.append(paramString2);
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      Object localObject1;
      boolean bool;
      label272:
      k.a.a.m.StringBuilder.append((Exception)paramString1);
    }
    paramString1.close();
    throw paramString2;
    paramString1.close();
    throw paramString2;
  }
  
  public void add(String paramString1, String paramString2)
  {
    runOnUiThread((Runnable)new Ox(this, paramString1, paramString2));
  }
  
  public void add(String paramString1, String paramString2, String paramString3)
  {
    runOnUiThread((Runnable)new Nx(this, paramString2, paramString3));
  }
  
  public void add(boolean paramBoolean, String paramString1, String paramString2)
  {
    addMarker(paramString1, paramString2);
  }
  
  public void addBitmapToMemoryCache(String paramString, Bitmap paramBitmap) {}
  
  public void append(String paramString1, String paramString2, String paramString3)
  {
    runOnUiThread((Runnable)new Lx(this, paramString1, paramString2, paramString3));
  }
  
  public Bitmap brightness(Bitmap paramBitmap)
  {
    int i3 = paramBitmap.getWidth();
    int i4 = paramBitmap.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i3, i4, paramBitmap.getConfig());
    int m = 0;
    while (m < i3)
    {
      int i1 = 0;
      while (i1 < i4)
      {
        int i7 = paramBitmap.getPixel(m, i1);
        int i5 = Color.alpha(i7);
        int i2 = Color.red(i7);
        int i6 = Color.green(i7);
        i7 = Color.blue(i7);
        double d1 = i2;
        Double.isNaN(d1);
        double d2 = i6;
        Double.isNaN(d2);
        double d3 = i7;
        Double.isNaN(d3);
        if ((int)(d3 * 0.114D + (d2 * 0.587D + d1 * 0.2989D)) > 128) {
          i2 = 255;
        } else {
          i2 = 0;
        }
        localBitmap.setPixel(m, i1, Color.argb(i5, i2, i2, i2));
        i1 += 1;
      }
      m += 1;
    }
    return localBitmap;
  }
  
  public void c()
  {
    weight = new o(this);
    new o(this).b();
  }
  
  public void calculate(String paramString)
  {
    String str1 = s;
    try
    {
      int m = str1.length();
      if (m == 0)
      {
        boolean bool = paramString.contains("#/");
        if (bool)
        {
          s = paramString;
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      k.a.a.m.StringBuilder.append(paramString);
    }
  }
  
  public int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i3 = outHeight;
    int i4 = outWidth;
    int m;
    if ((i3 <= paramInt2) && (i4 <= paramInt1))
    {
      m = 1;
    }
    else
    {
      int i1 = Math.round(i3 / paramInt2);
      m = i1;
      int i2 = Math.round(i4 / paramInt1);
      if (i1 >= i2) {
        m = i2;
      }
    }
    float f1 = i4 * i3;
    while (f1 / (m * m) > paramInt1 * paramInt2 * 2) {
      m += 1;
    }
    return m;
  }
  
  public void complete()
  {
    try
    {
      Object localObject = new Tx(this);
      localObject = (Runnable)localObject;
      runOnUiThread((Runnable)localObject);
      return;
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
    }
  }
  
  public void d()
  {
    k = new ab(this);
    k.a();
  }
  
  public void disconnect()
  {
    try
    {
      mConnection = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.proxy).build();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Bitmap doInBackground(String paramString1, String paramString2)
    throws OutOfMemoryError, IOException
  {
    Object localObject1 = new BitmapFactory.Options();
    inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString1, (BitmapFactory.Options)localObject1);
    Object localObject2 = new File(paramString1);
    Object localObject3 = System.out;
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Docs size in KB is util compress :");
    localStringBuilder.append(((File)localObject2).length() / 1024L);
    ((PrintStream)localObject3).println(localStringBuilder.toString());
    int i3 = outHeight;
    int i4 = outWidth;
    float f1 = i4 / i3;
    int i2;
    if ("photo".equals(paramString2)) {
      i2 = 30;
    } else if ("sign".equals(paramString2)) {
      i2 = 60;
    } else {
      i2 = 300;
    }
    int m = i3;
    int i1 = i4;
    if (((File)localObject2).length() / 1024L > i2) {
      if (f1 < 0.70665085F)
      {
        i1 = (int)(842.0F / i3 * i4);
        m = (int)842.0F;
        System.out.println("first");
      }
      else if (f1 > 0.70665085F)
      {
        m = (int)(595.0F / i4 * i3);
        i1 = (int)595.0F;
        System.out.println("second");
      }
      else
      {
        m = (int)842.0F;
        i1 = (int)595.0F;
        System.out.println("third");
      }
    }
    inSampleSize = calculateInSampleSize((BitmapFactory.Options)localObject1, i1, m);
    inJustDecodeBounds = false;
    inDither = false;
    inPurgeable = true;
    inInputShareable = true;
    inTempStorage = new byte['?'];
    localObject2 = BitmapFactory.decodeFile(paramString1, (BitmapFactory.Options)localObject1);
    paramString2 = Bitmap.createBitmap(i1, m, Bitmap.Config.RGB_565);
    float f4 = i1;
    f1 = f4 / outWidth;
    float f3 = m;
    float f2 = f3 / outHeight;
    f4 /= 2.0F;
    f3 /= 2.0F;
    localObject1 = new Matrix();
    ((Matrix)localObject1).setScale(f1, f2, f4, f3);
    localObject3 = new Canvas(paramString2);
    ((Canvas)localObject3).setMatrix((Matrix)localObject1);
    ((Canvas)localObject3).drawBitmap((Bitmap)localObject2, f4 - ((Bitmap)localObject2).getWidth() / 2, f3 - ((Bitmap)localObject2).getHeight() / 2, new Paint(2));
    m = new ExifInterface(paramString1).getAttributeInt("Orientation", 0);
    paramString1 = new StringBuilder();
    paramString1.append("Exif: ");
    paramString1.append(m);
    paramString1.toString();
    paramString1 = new Matrix();
    if (m == 6)
    {
      paramString1.postRotate(90.0F);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Exif: ");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).toString();
    }
    else if (m == 3)
    {
      paramString1.postRotate(180.0F);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Exif: ");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).toString();
    }
    else if (m == 8)
    {
      paramString1.postRotate(270.0F);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Exif: ");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).toString();
    }
    return Bitmap.createBitmap(paramString2, 0, 0, paramString2.getWidth(), paramString2.getHeight(), paramString1, true);
  }
  
  public Uri doInBackground(Context paramContext, Bitmap paramBitmap)
    throws Exception
  {
    if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0)
    {
      paramContext = new StringBuilder();
      paramContext.append(getFilesDir().getAbsolutePath());
      paramContext.append("/.images/");
      paramContext = new File(paramContext.toString());
      if (!paramContext.isDirectory()) {
        paramContext.mkdir();
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Calendar.getInstance().getTimeInMillis());
      ((StringBuilder)localObject).append(".jpg");
      paramContext = new File(paramContext, ((StringBuilder)localObject).toString());
      localObject = new BufferedOutputStream(new FileOutputStream(paramContext));
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
      ((FilterOutputStream)localObject).close();
      return Uri.fromFile(paramContext);
    }
    k.a.a.m.Log.showDialog(this, getResources().getString(2131755558));
    throw new Exception("Storage permission not granted");
  }
  
  public String doInBackground()
  {
    if (this$0.get(k.a.a.m.f.app, "").length() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this$0.get(k.a.a.m.f.app, ""));
      localStringBuilder.append(",");
      localStringBuilder.append(this$0.get(k.a.a.m.f.m_ProgressBar, ""));
      return localStringBuilder.toString();
    }
    return "false";
  }
  
  public String encode(String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance("SHA-256");
    }
    catch (NoSuchAlgorithmException paramString)
    {
      try
      {
        Object localObject;
        paramString.update(((String)localObject).getBytes("UTF-8"));
        return Base64.encodeToString(paramString.digest(), 2);
        return "";
        paramString = paramString;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;) {}
      }
    }
    paramString = null;
    localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append(this$0.get(k.a.a.m.f.time, "2.5"), "F", "Y", "Y", "N");
    ((StringBuilder)localObject).append("N");
    localObject = ((StringBuilder)localObject).toString();
    if ((paramString == null) || (localObject != null)) {}
    return "";
  }
  
  public void execute(String paramString1, String paramString2)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("downloadBase64FileForShare === >> ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" === ");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).toString();
      localObject1 = new ByteArrayInputStream(Base64.decode(paramString2.getBytes(), 0));
      paramString2 = Environment.getExternalStorageDirectory();
      Object localObject2 = new File(paramString2, "UMANG");
      bool = ((File)localObject2).exists();
      if (!bool) {
        ((File)localObject2).mkdirs();
      }
      paramString2 = new StringBuilder();
      paramString2.append(localObject2);
      localObject2 = File.separator;
      paramString2.append((String)localObject2);
      paramString2.append(paramString1);
      paramString2 = new File(paramString2.toString());
      paramString1 = new FileOutputStream(paramString2);
      localObject2 = new byte['?'];
      try
      {
        for (;;)
        {
          int m = ((InputStream)localObject1).read((byte[])localObject2);
          if (m == -1) {
            break;
          }
          paramString1.write((byte[])localObject2, 0, m);
        }
        paramString1.flush();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getResources().getString(2131755609));
        ((StringBuilder)localObject1).append(" : ");
        ((StringBuilder)localObject1).append(paramString2.getAbsolutePath());
        Toast.makeText(this, ((StringBuilder)localObject1).toString(), 1).show();
        bool = paramString2.exists();
        if (bool)
        {
          localObject1 = new Intent("android.intent.action.SEND");
          ((Intent)localObject1).setType("application/pdf");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(getPackageName());
          ((StringBuilder)localObject2).append(".fileprovider");
          ((Intent)localObject1).putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this, ((StringBuilder)localObject2).toString(), paramString2));
          ((Intent)localObject1).addFlags(1073741824);
          ((Intent)localObject1).addFlags(1);
          startActivity(Intent.createChooser((Intent)localObject1, getString(2131756365)));
        }
        paramString1.close();
      }
      catch (Throwable localThrowable)
      {
        try
        {
          paramString1.close();
        }
        catch (Throwable paramString2)
        {
          break label457;
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            k.a.a.m.StringBuilder.append((Exception)localException3);
            try
            {
              bool = paramString2.exists();
              if (bool) {
                paramString2.delete();
              }
            }
            catch (Exception paramString2)
            {
              k.a.a.m.StringBuilder.append(paramString2);
            }
          }
        }
        localThrowable = localThrowable;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          k.a.a.m.StringBuilder.append(localException1);
          try
          {
            bool = paramString2.exists();
            if (bool) {
              paramString2.delete();
            }
          }
          catch (Exception localException2)
          {
            k.a.a.m.StringBuilder.append(localException2);
          }
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      boolean bool;
      label457:
      k.a.a.m.StringBuilder.append((Exception)paramString1);
    }
    paramString1.close();
    throw localException2;
    paramString1.close();
    throw paramString2;
  }
  
  public void execute(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("downloadBase64FileWithPDF === >> ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" === ");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).toString();
      localObject1 = new ByteArrayInputStream(Base64.decode(paramString2.getBytes(), 0));
      paramString2 = Environment.getExternalStorageDirectory();
      Object localObject2 = new File(paramString2, "UMANG");
      bool = ((File)localObject2).exists();
      if (!bool) {
        ((File)localObject2).mkdirs();
      }
      paramString2 = new StringBuilder();
      paramString2.append(localObject2);
      localObject2 = File.separator;
      paramString2.append((String)localObject2);
      paramString2.append(paramString1);
      paramString2 = new File(paramString2.toString());
      paramString1 = new FileOutputStream(paramString2);
      localObject2 = new byte['?'];
      try
      {
        for (;;)
        {
          int m = ((InputStream)localObject1).read((byte[])localObject2);
          if (m == -1) {
            break;
          }
          paramString1.write((byte[])localObject2, 0, m);
        }
        paramString1.flush();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getResources().getString(2131755609));
        ((StringBuilder)localObject1).append(" : ");
        ((StringBuilder)localObject1).append(paramString2.getAbsolutePath());
        Toast.makeText(this, ((StringBuilder)localObject1).toString(), 1).show();
        bool = paramString3.equalsIgnoreCase("excel");
        if (bool)
        {
          paramString3 = new Intent("android.intent.action.VIEW");
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(getPackageName());
          ((StringBuilder)localObject1).append(".fileprovider");
          paramString3.setDataAndType(FileProvider.getUriForFile(this, ((StringBuilder)localObject1).toString(), paramString2), "application/vnd.ms-excel");
          paramString3.addFlags(1073741824);
          paramString3.addFlags(1);
          try
          {
            startActivity(paramString3);
          }
          catch (ActivityNotFoundException paramString3)
          {
            k.a.a.m.StringBuilder.append(paramString3);
            Toast.makeText(this, getResources().getString(2131755998), 0).show();
          }
        }
        else
        {
          paramString3 = new Intent("android.intent.action.VIEW");
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(getPackageName());
          ((StringBuilder)localObject1).append(".fileprovider");
          localObject1 = FileProvider.getUriForFile(this, ((StringBuilder)localObject1).toString(), paramString2);
          paramString3.addFlags(1);
          paramString3.setDataAndType((Uri)localObject1, "application/pdf");
          paramString3.addFlags(1073741824);
          try
          {
            startActivity(paramString3);
          }
          catch (Exception paramString3)
          {
            Toast.makeText(this, getResources().getString(2131755998), 0).show();
            k.a.a.m.StringBuilder.append(paramString3);
          }
        }
        paramString1.close();
      }
      catch (Throwable paramString3)
      {
        try
        {
          paramString1.close();
        }
        catch (Throwable paramString2)
        {
          break label569;
        }
        catch (Exception paramString3)
        {
          for (;;)
          {
            k.a.a.m.StringBuilder.append((Exception)paramString3);
            try
            {
              bool = paramString2.exists();
              if (bool) {
                paramString2.delete();
              }
            }
            catch (Exception paramString2)
            {
              k.a.a.m.StringBuilder.append(paramString2);
            }
          }
        }
        paramString3 = paramString3;
      }
      catch (Exception paramString3)
      {
        for (;;)
        {
          k.a.a.m.StringBuilder.append((Exception)paramString3);
          try
          {
            bool = paramString2.exists();
            if (bool) {
              paramString2.delete();
            }
          }
          catch (Exception paramString3)
          {
            k.a.a.m.StringBuilder.append(paramString3);
          }
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      boolean bool;
      label569:
      k.a.a.m.StringBuilder.append((Exception)paramString1);
    }
    paramString1.close();
    throw paramString3;
    paramString1.close();
    throw paramString2;
  }
  
  public void execute(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject1 = new ByteArrayInputStream(paramArrayOfByte);
      paramArrayOfByte = Environment.getExternalStorageDirectory();
      Object localObject2 = new File(paramArrayOfByte, "UMANG");
      bool = ((File)localObject2).exists();
      if (!bool) {
        ((File)localObject2).mkdirs();
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(localObject2);
      localObject2 = File.separator;
      paramArrayOfByte.append((String)localObject2);
      paramArrayOfByte.append(paramString);
      paramArrayOfByte = new File(paramArrayOfByte.toString());
      paramString = new FileOutputStream(paramArrayOfByte);
      localObject2 = new byte['?'];
      try
      {
        for (;;)
        {
          int m = ((InputStream)localObject1).read((byte[])localObject2);
          if (m == -1) {
            break;
          }
          paramString.write((byte[])localObject2, 0, m);
        }
        paramString.flush();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getResources().getString(2131755609));
        ((StringBuilder)localObject1).append(" : ");
        ((StringBuilder)localObject1).append(paramArrayOfByte.getAbsolutePath());
        Toast.makeText(this, ((StringBuilder)localObject1).toString(), 1).show();
        localObject1 = new Intent("android.intent.action.VIEW");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(getPackageName());
        ((StringBuilder)localObject2).append(".fileprovider");
        ((Intent)localObject1).setDataAndType(FileProvider.getUriForFile(this, ((StringBuilder)localObject2).toString(), paramArrayOfByte), "application/pdf");
        ((Intent)localObject1).addFlags(1073741824);
        ((Intent)localObject1).addFlags(1);
        try
        {
          startActivity((Intent)localObject1);
        }
        catch (Exception localException1)
        {
          Toast.makeText(this, getResources().getString(2131755998), 0).show();
          k.a.a.m.StringBuilder.append(localException1);
        }
        paramString.close();
      }
      catch (Throwable localThrowable)
      {
        try
        {
          paramString.close();
        }
        catch (Throwable paramArrayOfByte)
        {
          break label404;
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            k.a.a.m.StringBuilder.append((Exception)localException4);
            try
            {
              bool = paramArrayOfByte.exists();
              if (bool) {
                paramArrayOfByte.delete();
              }
            }
            catch (Exception paramArrayOfByte)
            {
              k.a.a.m.StringBuilder.append(paramArrayOfByte);
            }
          }
        }
        localThrowable = localThrowable;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          k.a.a.m.StringBuilder.append((Exception)localException2);
          try
          {
            bool = paramArrayOfByte.exists();
            if (bool) {
              paramArrayOfByte.delete();
            }
          }
          catch (Exception localException3)
          {
            k.a.a.m.StringBuilder.append(localException3);
          }
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      boolean bool;
      label404:
      k.a.a.m.StringBuilder.append((Exception)paramString);
    }
    paramString.close();
    throw localException3;
    paramString.close();
    throw paramArrayOfByte;
  }
  
  public Bitmap getBitmap(InputStream paramInputStream1, InputStream paramInputStream2, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream1, null, localOptions);
    inSampleSize = getScale(localOptions, paramInt1, paramInt2);
    inJustDecodeBounds = false;
    return BitmapFactory.decodeStream(paramInputStream2, null, localOptions);
  }
  
  public String getLocation()
  {
    if (mState) {
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isLocationServiceConnedted : ");
        boolean bool = mState;
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).toString();
        Object localObject2;
        if (mLocation != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          localObject2 = mLocation;
          ((StringBuilder)localObject1).append(((Location)localObject2).getLatitude());
          ((StringBuilder)localObject1).append(",");
          localObject2 = mLocation;
          ((StringBuilder)localObject1).append(((Location)localObject2).getLongitude());
          localObject1 = ((StringBuilder)localObject1).toString();
          return localObject1;
        }
        int m = ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION");
        if (m == 0)
        {
          localObject1 = LocationServices.FusedLocationApi;
          localObject2 = mConnection;
          localObject1 = ((FusedLocationProviderApi)localObject1).getLastLocation((GoogleApiClient)localObject2);
          mLocation = ((Location)localObject1);
          if (mLocation == null)
          {
            localObject1 = LocationServices.FusedLocationApi;
            localObject2 = mConnection;
            LocationRequest localLocationRequest = provider;
            ((FusedLocationProviderApi)localObject1).requestLocationUpdates((GoogleApiClient)localObject2, localLocationRequest, this);
            return "0.0,0.0";
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          localObject2 = mLocation;
          ((StringBuilder)localObject1).append(((Location)localObject2).getLatitude());
          ((StringBuilder)localObject1).append(",");
          localObject2 = mLocation;
          ((StringBuilder)localObject1).append(((Location)localObject2).getLongitude());
          localObject1 = ((StringBuilder)localObject1).toString();
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append((Exception)localException);
      }
    }
    return "0.0,0.0";
  }
  
  public void init(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DOWNLOAD TASK CALLED ===>>");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("====");
    localStringBuilder.append(paramString2);
    localStringBuilder.toString();
    mWebView = new WebActivity.c(this);
    ((AsyncTask)mWebView).execute(new String[] { paramString1, paramString2 });
  }
  
  public void invoke()
  {
    runOnUiThread((Runnable)new dy(this));
  }
  
  public boolean isFabOpen()
  {
    return deleteItem != null;
  }
  
  public void notifyChanged()
  {
    runOnUiThread((Runnable)new by(this));
  }
  
  public void notifyChanged(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    runOnUiThread((Runnable)new Qx(this, paramString1, paramString2, paramString3, paramString4));
  }
  
  /* Error */
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: aload_3
    //   4: invokespecial 2465	android/support/v4/package_7/FragmentActivity:onActivityResult	(IILandroid/content/Intent;)V
    //   7: new 522	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   14: astore 7
    //   16: aload 7
    //   18: ldc_w 2467
    //   21: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 7
    //   27: iload_1
    //   28: invokevirtual 1535	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 7
    //   34: ldc_w 2469
    //   37: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 7
    //   43: iload_2
    //   44: invokevirtual 1535	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 7
    //   50: ldc_w 2471
    //   53: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 7
    //   59: aload_3
    //   60: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 7
    //   66: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: pop
    //   70: goto +10 -> 80
    //   73: astore 7
    //   75: aload 7
    //   77: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   80: iload_1
    //   81: sipush 711
    //   84: if_icmpne +51 -> 135
    //   87: iload_2
    //   88: iconst_m1
    //   89: if_icmpne +46 -> 135
    //   92: aload_0
    //   93: invokevirtual 490	android/app/Activity:isFinishing	()Z
    //   96: ifne +6213 -> 6309
    //   99: aload_3
    //   100: ifnull +6209 -> 6309
    //   103: aload_0
    //   104: aload_3
    //   105: ldc_w 2473
    //   108: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   111: aload_3
    //   112: ldc_w 462
    //   115: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   118: aload_3
    //   119: ldc_w 469
    //   122: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   125: invokevirtual 2475	in/spicedigital/umang/activities/WebActivity:start	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   128: return
    //   129: astore_3
    //   130: aload_3
    //   131: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   134: return
    //   135: aload_0
    //   136: getfield 266	in/spicedigital/umang/activities/WebActivity:type	I
    //   139: istore 4
    //   141: ldc -29
    //   143: astore 7
    //   145: iconst_0
    //   146: istore 6
    //   148: iload_1
    //   149: iload 4
    //   151: if_icmpne +1143 -> 1294
    //   154: iload_2
    //   155: iconst_m1
    //   156: if_icmpne +1138 -> 1294
    //   159: aload_0
    //   160: invokevirtual 490	android/app/Activity:isFinishing	()Z
    //   163: ifne +6146 -> 6309
    //   166: aload_3
    //   167: ifnull +6142 -> 6309
    //   170: iload_2
    //   171: iconst_m1
    //   172: if_icmpne +6137 -> 6309
    //   175: aload_3
    //   176: ldc_w 2477
    //   179: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   182: astore 7
    //   184: new 522	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   191: astore 8
    //   193: aload 8
    //   195: ldc_w 2479
    //   198: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 8
    //   204: aload 7
    //   206: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 8
    //   212: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: pop
    //   216: aload 7
    //   218: ifnull +145 -> 363
    //   221: aload 7
    //   223: ldc_w 2481
    //   226: invokevirtual 740	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   229: istore 5
    //   231: iload 5
    //   233: ifeq +130 -> 363
    //   236: new 522	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   243: astore_3
    //   244: aload_3
    //   245: ldc_w 2483
    //   248: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: invokestatic 1887	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   255: invokevirtual 1894	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   258: astore 8
    //   260: aload_3
    //   261: aload 8
    //   263: new 2485	org/xml/sax/InputSource
    //   266: dup
    //   267: new 2487	java/io/StringReader
    //   270: dup
    //   271: aload 7
    //   273: invokespecial 2488	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   276: invokespecial 2491	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   279: invokevirtual 2494	javax/xml/parsers/DocumentBuilder:parse	(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;
    //   282: ldc_w 2496
    //   285: invokeinterface 2500 2 0
    //   290: iconst_0
    //   291: invokeinterface 2506 2 0
    //   296: invokeinterface 2512 1 0
    //   301: ldc_w 1451
    //   304: invokeinterface 2518 2 0
    //   309: invokeinterface 2521 1 0
    //   314: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_3
    //   319: ldc_w 2523
    //   322: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_0
    //   327: aload_3
    //   328: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 2525	k/a/a/m/Log:show	(Landroid/content/Context;Ljava/lang/String;)V
    //   334: new 522	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   341: astore_3
    //   342: aload_3
    //   343: ldc_w 2527
    //   346: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_3
    //   351: aload 7
    //   353: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload_3
    //   358: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: pop
    //   362: return
    //   363: aload_3
    //   364: ldc_w 2529
    //   367: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   370: astore_3
    //   371: new 522	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   378: astore 8
    //   380: aload 8
    //   382: ldc_w 2531
    //   385: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 8
    //   391: aload_3
    //   392: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload 8
    //   398: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: pop
    //   402: aload_3
    //   403: ifnull +74 -> 477
    //   406: aload_3
    //   407: ldc -29
    //   409: invokevirtual 2207	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   412: istore 5
    //   414: iload 5
    //   416: ifne +5893 -> 6309
    //   419: aload_3
    //   420: invokevirtual 728	java/lang/String:isEmpty	()Z
    //   423: istore 5
    //   425: iload 5
    //   427: ifeq +4 -> 431
    //   430: return
    //   431: aload_3
    //   432: ldc_w 2533
    //   435: invokevirtual 2536	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   438: istore 5
    //   440: iload 5
    //   442: ifeq +35 -> 477
    //   445: new 522	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   452: astore 7
    //   454: aload 7
    //   456: ldc_w 2538
    //   459: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload 7
    //   465: aload_3
    //   466: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 7
    //   472: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: pop
    //   476: return
    //   477: invokestatic 1887	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   480: invokevirtual 1894	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   483: astore 8
    //   485: aload 8
    //   487: new 2485	org/xml/sax/InputSource
    //   490: dup
    //   491: new 2487	java/io/StringReader
    //   494: dup
    //   495: aload 7
    //   497: invokespecial 2488	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   500: invokespecial 2491	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   503: invokevirtual 2494	javax/xml/parsers/DocumentBuilder:parse	(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;
    //   506: ldc_w 2496
    //   509: invokeinterface 2500 2 0
    //   514: iconst_0
    //   515: invokeinterface 2506 2 0
    //   520: invokeinterface 2512 1 0
    //   525: ldc_w 1444
    //   528: invokeinterface 2518 2 0
    //   533: invokeinterface 2521 1 0
    //   538: astore 7
    //   540: aload_3
    //   541: ifnull +58 -> 599
    //   544: aload_3
    //   545: ldc -29
    //   547: invokevirtual 2207	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   550: istore 5
    //   552: iload 5
    //   554: ifne +45 -> 599
    //   557: aload_3
    //   558: invokevirtual 728	java/lang/String:isEmpty	()Z
    //   561: istore 5
    //   563: iload 5
    //   565: ifne +34 -> 599
    //   568: new 522	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   575: astore 8
    //   577: aload 8
    //   579: ldc_w 2540
    //   582: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload 8
    //   588: aload_3
    //   589: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload 8
    //   595: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: pop
    //   599: aload 7
    //   601: ifnull +5708 -> 6309
    //   604: aload 7
    //   606: ldc_w 2542
    //   609: invokevirtual 2207	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   612: istore 5
    //   614: iload 5
    //   616: ifeq +5693 -> 6309
    //   619: invokestatic 1887	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   622: invokevirtual 1894	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   625: astore 7
    //   627: aload 7
    //   629: new 2485	org/xml/sax/InputSource
    //   632: dup
    //   633: new 2487	java/io/StringReader
    //   636: dup
    //   637: aload_3
    //   638: invokespecial 2488	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   641: invokespecial 2491	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   644: invokevirtual 2494	javax/xml/parsers/DocumentBuilder:parse	(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;
    //   647: astore 7
    //   649: invokestatic 2547	javax/xml/xpath/XPathFactory:newInstance	()Ljavax/xml/xpath/XPathFactory;
    //   652: invokevirtual 2551	javax/xml/xpath/XPathFactory:newXPath	()Ljavax/xml/xpath/XPath;
    //   655: astore 8
    //   657: aload 8
    //   659: ldc_w 2553
    //   662: invokeinterface 2559 2 0
    //   667: astore_3
    //   668: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   671: astore 9
    //   673: aload_3
    //   674: aload 7
    //   676: aload 9
    //   678: invokeinterface 2571 3 0
    //   683: astore_3
    //   684: aload_3
    //   685: checkcast 294	java/lang/String
    //   688: astore_3
    //   689: new 522	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   696: astore 9
    //   698: aload 9
    //   700: ldc_w 2573
    //   703: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload 9
    //   709: aload_3
    //   710: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload 9
    //   716: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: pop
    //   720: aload 8
    //   722: ldc_w 2575
    //   725: invokeinterface 2559 2 0
    //   730: astore 9
    //   732: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   735: astore 10
    //   737: aload 9
    //   739: aload 7
    //   741: aload 10
    //   743: invokeinterface 2571 3 0
    //   748: astore 9
    //   750: aload 9
    //   752: checkcast 294	java/lang/String
    //   755: astore 9
    //   757: new 522	java/lang/StringBuilder
    //   760: dup
    //   761: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   764: astore 10
    //   766: aload 10
    //   768: ldc_w 2577
    //   771: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: aload 10
    //   777: aload 9
    //   779: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: pop
    //   783: aload 10
    //   785: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   788: pop
    //   789: aload 8
    //   791: ldc_w 2579
    //   794: invokeinterface 2559 2 0
    //   799: astore 10
    //   801: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   804: astore 11
    //   806: aload 10
    //   808: aload 7
    //   810: aload 11
    //   812: invokeinterface 2571 3 0
    //   817: astore 10
    //   819: aload 10
    //   821: checkcast 294	java/lang/String
    //   824: astore 10
    //   826: new 522	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   833: astore 11
    //   835: aload 11
    //   837: ldc_w 2581
    //   840: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: pop
    //   844: aload 11
    //   846: aload 10
    //   848: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: pop
    //   852: aload 11
    //   854: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   857: pop
    //   858: aload 8
    //   860: ldc_w 2583
    //   863: invokeinterface 2559 2 0
    //   868: astore 11
    //   870: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   873: astore 12
    //   875: aload 11
    //   877: aload 7
    //   879: aload 12
    //   881: invokeinterface 2571 3 0
    //   886: astore 11
    //   888: aload 11
    //   890: checkcast 294	java/lang/String
    //   893: astore 11
    //   895: new 522	java/lang/StringBuilder
    //   898: dup
    //   899: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   902: astore 12
    //   904: aload 12
    //   906: ldc_w 2585
    //   909: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: pop
    //   913: aload 12
    //   915: aload 11
    //   917: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: pop
    //   921: aload 12
    //   923: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: pop
    //   927: aload 8
    //   929: ldc_w 2587
    //   932: invokeinterface 2559 2 0
    //   937: astore 12
    //   939: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   942: astore 13
    //   944: aload 12
    //   946: aload 7
    //   948: aload 13
    //   950: invokeinterface 2571 3 0
    //   955: astore 12
    //   957: aload 12
    //   959: checkcast 294	java/lang/String
    //   962: astore 12
    //   964: new 522	java/lang/StringBuilder
    //   967: dup
    //   968: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   971: astore 13
    //   973: aload 13
    //   975: ldc_w 2589
    //   978: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: aload 13
    //   984: aload 12
    //   986: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: pop
    //   990: aload 13
    //   992: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   995: pop
    //   996: aload 8
    //   998: ldc_w 2591
    //   1001: invokeinterface 2559 2 0
    //   1006: astore 13
    //   1008: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   1011: astore 14
    //   1013: aload 13
    //   1015: aload 7
    //   1017: aload 14
    //   1019: invokeinterface 2571 3 0
    //   1024: astore 13
    //   1026: aload 13
    //   1028: checkcast 294	java/lang/String
    //   1031: astore 13
    //   1033: new 522	java/lang/StringBuilder
    //   1036: dup
    //   1037: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   1040: astore 14
    //   1042: aload 14
    //   1044: ldc_w 2593
    //   1047: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: pop
    //   1051: aload 14
    //   1053: aload 13
    //   1055: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: pop
    //   1059: aload 14
    //   1061: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: pop
    //   1065: aload 8
    //   1067: ldc_w 2553
    //   1070: invokeinterface 2559 2 0
    //   1075: astore 14
    //   1077: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   1080: astore 15
    //   1082: aload 14
    //   1084: aload 7
    //   1086: aload 15
    //   1088: invokeinterface 2571 3 0
    //   1093: astore 14
    //   1095: aload 14
    //   1097: checkcast 294	java/lang/String
    //   1100: astore 14
    //   1102: new 522	java/lang/StringBuilder
    //   1105: dup
    //   1106: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   1109: astore 15
    //   1111: aload 15
    //   1113: ldc_w 2595
    //   1116: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: pop
    //   1120: aload 15
    //   1122: aload 14
    //   1124: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: pop
    //   1128: aload 15
    //   1130: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1133: pop
    //   1134: aload 8
    //   1136: ldc_w 2597
    //   1139: invokeinterface 2559 2 0
    //   1144: astore 8
    //   1146: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   1149: astore 15
    //   1151: aload 8
    //   1153: aload 7
    //   1155: aload 15
    //   1157: invokeinterface 2571 3 0
    //   1162: astore 7
    //   1164: aload 7
    //   1166: checkcast 294	java/lang/String
    //   1169: astore 7
    //   1171: new 522	java/lang/StringBuilder
    //   1174: dup
    //   1175: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   1178: astore 8
    //   1180: aload 8
    //   1182: ldc_w 2599
    //   1185: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: pop
    //   1189: aload 8
    //   1191: aload 7
    //   1193: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: pop
    //   1197: aload 8
    //   1199: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1202: pop
    //   1203: new 522	java/lang/StringBuilder
    //   1206: dup
    //   1207: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   1210: astore 8
    //   1212: aload 8
    //   1214: aload_3
    //   1215: invokevirtual 828	java/lang/String:trim	()Ljava/lang/String;
    //   1218: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: pop
    //   1222: aload 8
    //   1224: aload 13
    //   1226: invokevirtual 828	java/lang/String:trim	()Ljava/lang/String;
    //   1229: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: pop
    //   1233: aload 8
    //   1235: aload 14
    //   1237: invokevirtual 828	java/lang/String:trim	()Ljava/lang/String;
    //   1240: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: pop
    //   1244: aload 8
    //   1246: aload 7
    //   1248: invokevirtual 828	java/lang/String:trim	()Ljava/lang/String;
    //   1251: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: pop
    //   1255: aload 8
    //   1257: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1260: pop
    //   1261: new 2601	k/a/a/a/xx
    //   1264: dup
    //   1265: aload_0
    //   1266: aload_3
    //   1267: aload 13
    //   1269: aload 7
    //   1271: aload 9
    //   1273: aload 10
    //   1275: aload 11
    //   1277: aload 12
    //   1279: invokespecial 2604	k/a/a/a/xx:<init>	(Lin/spicedigital/umang/activities/WebActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1282: astore_3
    //   1283: aload_3
    //   1284: checkcast 495	java/lang/Runnable
    //   1287: astore_3
    //   1288: aload_0
    //   1289: aload_3
    //   1290: invokevirtual 499	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   1293: return
    //   1294: iload_1
    //   1295: sipush 744
    //   1298: if_icmpne +1376 -> 2674
    //   1301: iload_2
    //   1302: iconst_m1
    //   1303: if_icmpne +1371 -> 2674
    //   1306: aload_0
    //   1307: invokevirtual 490	android/app/Activity:isFinishing	()Z
    //   1310: ifne +4999 -> 6309
    //   1313: aload_3
    //   1314: ifnull +4995 -> 6309
    //   1317: iload_2
    //   1318: iconst_m1
    //   1319: if_icmpne +4990 -> 6309
    //   1322: aload_3
    //   1323: ldc_w 2606
    //   1326: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1329: astore 8
    //   1331: new 522	java/lang/StringBuilder
    //   1334: dup
    //   1335: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   1338: astore_3
    //   1339: aload_3
    //   1340: ldc_w 2608
    //   1343: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: pop
    //   1347: aload_3
    //   1348: aload 8
    //   1350: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: pop
    //   1354: aload_3
    //   1355: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1358: pop
    //   1359: aload 8
    //   1361: ifnull +276 -> 1637
    //   1364: aload 8
    //   1366: ldc -29
    //   1368: invokevirtual 2207	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1371: istore 5
    //   1373: iload 5
    //   1375: ifne +4934 -> 6309
    //   1378: aload 8
    //   1380: invokevirtual 728	java/lang/String:isEmpty	()Z
    //   1383: istore 5
    //   1385: iload 5
    //   1387: ifeq +4 -> 1391
    //   1390: return
    //   1391: aload 8
    //   1393: ldc_w 2533
    //   1396: invokevirtual 2536	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1399: istore 5
    //   1401: iload 5
    //   1403: ifeq +32 -> 1435
    //   1406: new 522	java/lang/StringBuilder
    //   1409: dup
    //   1410: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   1413: astore_3
    //   1414: aload_3
    //   1415: ldc_w 2610
    //   1418: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: pop
    //   1422: aload_3
    //   1423: aload 8
    //   1425: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: pop
    //   1429: aload_3
    //   1430: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1433: pop
    //   1434: return
    //   1435: invokestatic 1887	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   1438: invokevirtual 1894	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   1441: astore_3
    //   1442: aload_3
    //   1443: new 2485	org/xml/sax/InputSource
    //   1446: dup
    //   1447: new 2487	java/io/StringReader
    //   1450: dup
    //   1451: aload 8
    //   1453: invokespecial 2488	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   1456: invokespecial 2491	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   1459: invokevirtual 2494	javax/xml/parsers/DocumentBuilder:parse	(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;
    //   1462: astore_3
    //   1463: aload_3
    //   1464: ldc_w 2612
    //   1467: invokeinterface 2500 2 0
    //   1472: astore 9
    //   1474: aload 9
    //   1476: ifnull +161 -> 1637
    //   1479: aload 9
    //   1481: iconst_0
    //   1482: invokeinterface 2506 2 0
    //   1487: astore 9
    //   1489: aload 9
    //   1491: checkcast 1930	org/w3c/dom/Element
    //   1494: astore 9
    //   1496: aload_3
    //   1497: ldc_w 2614
    //   1500: invokeinterface 2500 2 0
    //   1505: astore_3
    //   1506: aload_3
    //   1507: ifnull +130 -> 1637
    //   1510: aload_3
    //   1511: iconst_0
    //   1512: invokeinterface 2506 2 0
    //   1517: invokeinterface 2512 1 0
    //   1522: astore 9
    //   1524: aload 9
    //   1526: ldc_w 2616
    //   1529: invokeinterface 2518 2 0
    //   1534: astore_3
    //   1535: aload_3
    //   1536: ifnull +13 -> 1549
    //   1539: aload_3
    //   1540: invokeinterface 2521 1 0
    //   1545: astore_3
    //   1546: goto +7 -> 1553
    //   1549: ldc_w 1943
    //   1552: astore_3
    //   1553: aload 9
    //   1555: ldc_w 2618
    //   1558: invokeinterface 2518 2 0
    //   1563: astore 9
    //   1565: aload 9
    //   1567: ifnull +12 -> 1579
    //   1570: aload 9
    //   1572: invokeinterface 2521 1 0
    //   1577: astore 7
    //   1579: aload_3
    //   1580: invokestatic 2621	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1583: istore_1
    //   1584: iload_1
    //   1585: ifle +52 -> 1637
    //   1588: new 522	java/lang/StringBuilder
    //   1591: dup
    //   1592: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   1595: astore 8
    //   1597: aload 8
    //   1599: ldc_w 2623
    //   1602: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1605: pop
    //   1606: aload 8
    //   1608: aload_3
    //   1609: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: pop
    //   1613: aload 8
    //   1615: ldc_w 2625
    //   1618: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1621: pop
    //   1622: aload 8
    //   1624: aload 7
    //   1626: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: pop
    //   1630: aload 8
    //   1632: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1635: pop
    //   1636: return
    //   1637: aload 8
    //   1639: ifnull +4670 -> 6309
    //   1642: invokestatic 1887	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   1645: invokevirtual 1894	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   1648: astore_3
    //   1649: aload_3
    //   1650: new 2485	org/xml/sax/InputSource
    //   1653: dup
    //   1654: new 2487	java/io/StringReader
    //   1657: dup
    //   1658: aload 8
    //   1660: invokespecial 2488	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   1663: invokespecial 2491	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   1666: invokevirtual 2494	javax/xml/parsers/DocumentBuilder:parse	(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;
    //   1669: astore_3
    //   1670: invokestatic 2547	javax/xml/xpath/XPathFactory:newInstance	()Ljavax/xml/xpath/XPathFactory;
    //   1673: invokevirtual 2551	javax/xml/xpath/XPathFactory:newXPath	()Ljavax/xml/xpath/XPath;
    //   1676: astore 7
    //   1678: aload 7
    //   1680: ldc_w 2627
    //   1683: invokeinterface 2559 2 0
    //   1688: astore 8
    //   1690: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   1693: astore 9
    //   1695: aload 8
    //   1697: aload_3
    //   1698: aload 9
    //   1700: invokeinterface 2571 3 0
    //   1705: astore 8
    //   1707: aload 8
    //   1709: checkcast 294	java/lang/String
    //   1712: astore 8
    //   1714: new 522	java/lang/StringBuilder
    //   1717: dup
    //   1718: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   1721: astore 9
    //   1723: aload 9
    //   1725: ldc_w 2629
    //   1728: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1731: pop
    //   1732: aload 9
    //   1734: aload 8
    //   1736: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: pop
    //   1740: aload 9
    //   1742: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1745: pop
    //   1746: aload 8
    //   1748: ldc_w 1943
    //   1751: invokevirtual 298	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1754: istore 5
    //   1756: iload 5
    //   1758: ifeq +803 -> 2561
    //   1761: aload 7
    //   1763: ldc_w 2631
    //   1766: invokeinterface 2559 2 0
    //   1771: astore 8
    //   1773: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   1776: astore 9
    //   1778: aload 8
    //   1780: aload_3
    //   1781: aload 9
    //   1783: invokeinterface 2571 3 0
    //   1788: astore 8
    //   1790: aload 8
    //   1792: checkcast 294	java/lang/String
    //   1795: astore 8
    //   1797: new 522	java/lang/StringBuilder
    //   1800: dup
    //   1801: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   1804: astore 9
    //   1806: aload 9
    //   1808: ldc_w 2629
    //   1811: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: pop
    //   1815: aload 9
    //   1817: aload 8
    //   1819: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1822: pop
    //   1823: aload 9
    //   1825: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1828: pop
    //   1829: aload 7
    //   1831: ldc_w 2633
    //   1834: invokeinterface 2559 2 0
    //   1839: astore 9
    //   1841: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   1844: astore 10
    //   1846: aload 9
    //   1848: aload_3
    //   1849: aload 10
    //   1851: invokeinterface 2571 3 0
    //   1856: astore 9
    //   1858: aload 9
    //   1860: checkcast 294	java/lang/String
    //   1863: astore 9
    //   1865: new 522	java/lang/StringBuilder
    //   1868: dup
    //   1869: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   1872: astore 10
    //   1874: aload 10
    //   1876: ldc_w 2629
    //   1879: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1882: pop
    //   1883: aload 10
    //   1885: aload 9
    //   1887: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1890: pop
    //   1891: aload 10
    //   1893: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1896: pop
    //   1897: aload 7
    //   1899: ldc_w 2635
    //   1902: invokeinterface 2559 2 0
    //   1907: astore 10
    //   1909: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   1912: astore 11
    //   1914: aload 10
    //   1916: aload_3
    //   1917: aload 11
    //   1919: invokeinterface 2571 3 0
    //   1924: astore 10
    //   1926: aload 10
    //   1928: checkcast 294	java/lang/String
    //   1931: astore 10
    //   1933: new 522	java/lang/StringBuilder
    //   1936: dup
    //   1937: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   1940: astore 11
    //   1942: aload 11
    //   1944: ldc_w 2629
    //   1947: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1950: pop
    //   1951: aload 11
    //   1953: aload 10
    //   1955: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: pop
    //   1959: aload 11
    //   1961: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1964: pop
    //   1965: aload 7
    //   1967: ldc_w 2637
    //   1970: invokeinterface 2559 2 0
    //   1975: astore 11
    //   1977: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   1980: astore 12
    //   1982: aload 11
    //   1984: aload_3
    //   1985: aload 12
    //   1987: invokeinterface 2571 3 0
    //   1992: astore 11
    //   1994: aload 11
    //   1996: checkcast 294	java/lang/String
    //   1999: astore 11
    //   2001: new 522	java/lang/StringBuilder
    //   2004: dup
    //   2005: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   2008: astore 12
    //   2010: aload 12
    //   2012: ldc_w 2629
    //   2015: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2018: pop
    //   2019: aload 12
    //   2021: aload 11
    //   2023: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2026: pop
    //   2027: aload 12
    //   2029: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2032: pop
    //   2033: aload 7
    //   2035: ldc_w 2639
    //   2038: invokeinterface 2559 2 0
    //   2043: astore 12
    //   2045: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   2048: astore 13
    //   2050: aload 12
    //   2052: aload_3
    //   2053: aload 13
    //   2055: invokeinterface 2571 3 0
    //   2060: astore 12
    //   2062: aload 12
    //   2064: checkcast 294	java/lang/String
    //   2067: astore 12
    //   2069: new 522	java/lang/StringBuilder
    //   2072: dup
    //   2073: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   2076: astore 13
    //   2078: aload 13
    //   2080: ldc_w 2629
    //   2083: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2086: pop
    //   2087: aload 13
    //   2089: aload 12
    //   2091: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2094: pop
    //   2095: aload 13
    //   2097: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2100: pop
    //   2101: aload 7
    //   2103: ldc_w 2627
    //   2106: invokeinterface 2559 2 0
    //   2111: astore 13
    //   2113: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   2116: astore 14
    //   2118: aload 13
    //   2120: aload_3
    //   2121: aload 14
    //   2123: invokeinterface 2571 3 0
    //   2128: astore 13
    //   2130: aload 13
    //   2132: checkcast 294	java/lang/String
    //   2135: astore 13
    //   2137: new 522	java/lang/StringBuilder
    //   2140: dup
    //   2141: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   2144: astore 14
    //   2146: aload 14
    //   2148: ldc_w 2629
    //   2151: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2154: pop
    //   2155: aload 14
    //   2157: aload 13
    //   2159: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2162: pop
    //   2163: aload 14
    //   2165: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2168: pop
    //   2169: aload 7
    //   2171: ldc_w 2641
    //   2174: invokeinterface 2559 2 0
    //   2179: astore 13
    //   2181: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   2184: astore 14
    //   2186: aload 13
    //   2188: aload_3
    //   2189: aload 14
    //   2191: invokeinterface 2571 3 0
    //   2196: astore 13
    //   2198: aload 13
    //   2200: checkcast 294	java/lang/String
    //   2203: astore 13
    //   2205: aload 7
    //   2207: ldc_w 2643
    //   2210: invokeinterface 2559 2 0
    //   2215: astore 14
    //   2217: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   2220: astore 15
    //   2222: aload 14
    //   2224: aload_3
    //   2225: aload 15
    //   2227: invokeinterface 2571 3 0
    //   2232: astore 14
    //   2234: aload 14
    //   2236: checkcast 294	java/lang/String
    //   2239: astore 14
    //   2241: aload 7
    //   2243: ldc_w 2645
    //   2246: invokeinterface 2559 2 0
    //   2251: astore 15
    //   2253: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   2256: astore 16
    //   2258: aload 15
    //   2260: aload_3
    //   2261: aload 16
    //   2263: invokeinterface 2571 3 0
    //   2268: astore 15
    //   2270: aload 15
    //   2272: checkcast 294	java/lang/String
    //   2275: astore 15
    //   2277: aload 7
    //   2279: ldc_w 2647
    //   2282: invokeinterface 2559 2 0
    //   2287: astore 16
    //   2289: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   2292: astore 17
    //   2294: aload 16
    //   2296: aload_3
    //   2297: aload 17
    //   2299: invokeinterface 2571 3 0
    //   2304: astore 16
    //   2306: aload 16
    //   2308: checkcast 294	java/lang/String
    //   2311: astore 16
    //   2313: aload 7
    //   2315: ldc_w 2649
    //   2318: invokeinterface 2559 2 0
    //   2323: astore 7
    //   2325: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   2328: astore 17
    //   2330: aload 7
    //   2332: aload_3
    //   2333: aload 17
    //   2335: invokeinterface 2571 3 0
    //   2340: astore_3
    //   2341: aload_3
    //   2342: checkcast 294	java/lang/String
    //   2345: astore_3
    //   2346: new 640	org/json/JSONObject
    //   2349: dup
    //   2350: invokespecial 697	org/json/JSONObject:<init>	()V
    //   2353: astore 7
    //   2355: aload 7
    //   2357: ldc_w 2651
    //   2360: aload 11
    //   2362: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2365: pop
    //   2366: aload 7
    //   2368: ldc_w 2653
    //   2371: aload 10
    //   2373: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2376: pop
    //   2377: aload 7
    //   2379: ldc_w 2655
    //   2382: aload 12
    //   2384: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2387: pop
    //   2388: aload 7
    //   2390: ldc_w 2657
    //   2393: aload 9
    //   2395: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2398: pop
    //   2399: aload 7
    //   2401: ldc_w 2659
    //   2404: aload 16
    //   2406: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2409: pop
    //   2410: aload 7
    //   2412: ldc_w 2661
    //   2415: aload_3
    //   2416: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2419: pop
    //   2420: aload 7
    //   2422: ldc_w 2663
    //   2425: aload 8
    //   2427: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2430: pop
    //   2431: aload 7
    //   2433: ldc_w 2665
    //   2436: aload 13
    //   2438: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2441: pop
    //   2442: aload 7
    //   2444: ldc_w 2667
    //   2447: aload 14
    //   2449: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2452: pop
    //   2453: aload 7
    //   2455: ldc_w 2669
    //   2458: aload 15
    //   2460: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2463: pop
    //   2464: aload 7
    //   2466: invokevirtual 709	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2469: astore_3
    //   2470: new 522	java/lang/StringBuilder
    //   2473: dup
    //   2474: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   2477: astore 7
    //   2479: aload 7
    //   2481: ldc_w 2671
    //   2484: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2487: pop
    //   2488: aload 7
    //   2490: aload_3
    //   2491: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2494: pop
    //   2495: aload 7
    //   2497: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2500: pop
    //   2501: aload_0
    //   2502: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   2505: astore 7
    //   2507: new 522	java/lang/StringBuilder
    //   2510: dup
    //   2511: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   2514: astore 8
    //   2516: aload 8
    //   2518: ldc_w 2673
    //   2521: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2524: pop
    //   2525: aload 8
    //   2527: aload_3
    //   2528: ldc_w 2675
    //   2531: ldc_w 2677
    //   2534: invokevirtual 1364	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2537: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2540: pop
    //   2541: aload 8
    //   2543: ldc_w 1391
    //   2546: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2549: pop
    //   2550: aload 7
    //   2552: aload 8
    //   2554: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2557: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   2560: return
    //   2561: aload 7
    //   2563: ldc_w 2627
    //   2566: invokeinterface 2559 2 0
    //   2571: astore 7
    //   2573: getstatic 2565	javax/xml/xpath/XPathConstants:STRING	Ljavax/xml/namespace/QName;
    //   2576: astore 9
    //   2578: aload 7
    //   2580: aload_3
    //   2581: aload 9
    //   2583: invokeinterface 2571 3 0
    //   2588: astore_3
    //   2589: aload_3
    //   2590: checkcast 294	java/lang/String
    //   2593: astore_3
    //   2594: new 522	java/lang/StringBuilder
    //   2597: dup
    //   2598: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   2601: astore 7
    //   2603: aload 7
    //   2605: ldc_w 2629
    //   2608: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2611: pop
    //   2612: aload 7
    //   2614: aload_3
    //   2615: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2618: pop
    //   2619: aload 7
    //   2621: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2624: pop
    //   2625: new 522	java/lang/StringBuilder
    //   2628: dup
    //   2629: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   2632: astore 7
    //   2634: aload 7
    //   2636: ldc_w 2679
    //   2639: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2642: pop
    //   2643: aload 7
    //   2645: aload 8
    //   2647: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2650: pop
    //   2651: aload 7
    //   2653: ldc_w 2681
    //   2656: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2659: pop
    //   2660: aload 7
    //   2662: aload_3
    //   2663: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2666: pop
    //   2667: aload 7
    //   2669: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2672: pop
    //   2673: return
    //   2674: iload_1
    //   2675: sipush 2016
    //   2678: if_icmpne +30 -> 2708
    //   2681: iload_2
    //   2682: ifne +26 -> 2708
    //   2685: aload_0
    //   2686: invokevirtual 490	android/app/Activity:isFinishing	()Z
    //   2689: ifne +3620 -> 6309
    //   2692: aload_0
    //   2693: new 2683	k/a/a/a/zx
    //   2696: dup
    //   2697: aload_0
    //   2698: invokespecial 2684	k/a/a/a/zx:<init>	(Lin/spicedigital/umang/activities/WebActivity;)V
    //   2701: checkcast 495	java/lang/Runnable
    //   2704: invokevirtual 499	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   2707: return
    //   2708: iload_1
    //   2709: sipush 2016
    //   2712: if_icmpne +59 -> 2771
    //   2715: iload_2
    //   2716: iconst_m1
    //   2717: if_icmpne +54 -> 2771
    //   2720: aload_0
    //   2721: invokevirtual 490	android/app/Activity:isFinishing	()Z
    //   2724: ifne +3585 -> 6309
    //   2727: new 2686	k/a/a/a/Ax
    //   2730: dup
    //   2731: aload_0
    //   2732: invokespecial 2687	k/a/a/a/Ax:<init>	(Lin/spicedigital/umang/activities/WebActivity;)V
    //   2735: astore_3
    //   2736: aload_3
    //   2737: checkcast 495	java/lang/Runnable
    //   2740: astore_3
    //   2741: aload_0
    //   2742: aload_3
    //   2743: invokevirtual 499	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   2746: return
    //   2747: astore_3
    //   2748: aload_3
    //   2749: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   2752: aload_0
    //   2753: aload_0
    //   2754: invokevirtual 323	android/support/v7/app/AppCompatActivity:getResources	()Landroid/content/res/Resources;
    //   2757: ldc_w 506
    //   2760: invokevirtual 330	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2763: iconst_1
    //   2764: invokestatic 512	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   2767: invokevirtual 515	android/widget/Toast:show	()V
    //   2770: return
    //   2771: iload_1
    //   2772: sipush 2019
    //   2775: if_icmpne +60 -> 2835
    //   2778: iload_2
    //   2779: iconst_m1
    //   2780: if_icmpne +55 -> 2835
    //   2783: aload_0
    //   2784: invokevirtual 490	android/app/Activity:isFinishing	()Z
    //   2787: ifne +3522 -> 6309
    //   2790: new 2689	k/a/a/a/Bx
    //   2793: dup
    //   2794: aload_0
    //   2795: aload_3
    //   2796: invokespecial 2690	k/a/a/a/Bx:<init>	(Lin/spicedigital/umang/activities/WebActivity;Landroid/content/Intent;)V
    //   2799: astore_3
    //   2800: aload_3
    //   2801: checkcast 495	java/lang/Runnable
    //   2804: astore_3
    //   2805: aload_0
    //   2806: aload_3
    //   2807: invokevirtual 499	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   2810: return
    //   2811: astore_3
    //   2812: aload_3
    //   2813: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   2816: aload_0
    //   2817: aload_0
    //   2818: invokevirtual 323	android/support/v7/app/AppCompatActivity:getResources	()Landroid/content/res/Resources;
    //   2821: ldc_w 506
    //   2824: invokevirtual 330	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2827: iconst_1
    //   2828: invokestatic 512	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   2831: invokevirtual 515	android/widget/Toast:show	()V
    //   2834: return
    //   2835: iload_1
    //   2836: sipush 203
    //   2839: if_icmpne +95 -> 2934
    //   2842: aload_3
    //   2843: invokestatic 2695	com/theartofdev/edmodo/cropper/CropImage:a	(Landroid/content/Intent;)Lcom/theartofdev/edmodo/cropper/CropImage$ActivityResult;
    //   2846: astore_3
    //   2847: iload_2
    //   2848: iconst_m1
    //   2849: if_icmpne +27 -> 2876
    //   2852: aload_0
    //   2853: invokevirtual 490	android/app/Activity:isFinishing	()Z
    //   2856: ifne +3453 -> 6309
    //   2859: aload_0
    //   2860: new 2697	k/a/a/a/Cx
    //   2863: dup
    //   2864: aload_0
    //   2865: aload_3
    //   2866: invokespecial 2700	k/a/a/a/Cx:<init>	(Lin/spicedigital/umang/activities/WebActivity;Lcom/theartofdev/edmodo/cropper/CropImage$ActivityResult;)V
    //   2869: checkcast 495	java/lang/Runnable
    //   2872: invokevirtual 499	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   2875: return
    //   2876: iload_2
    //   2877: sipush 204
    //   2880: if_icmpne +31 -> 2911
    //   2883: aload_3
    //   2884: invokevirtual 2705	com/theartofdev/edmodo/cropper/CropImageView$a:d	()Ljava/lang/Exception;
    //   2887: pop
    //   2888: aload_0
    //   2889: invokevirtual 490	android/app/Activity:isFinishing	()Z
    //   2892: ifne +3417 -> 6309
    //   2895: aload_0
    //   2896: new 2707	k/a/a/a/Dx
    //   2899: dup
    //   2900: aload_0
    //   2901: invokespecial 2708	k/a/a/a/Dx:<init>	(Lin/spicedigital/umang/activities/WebActivity;)V
    //   2904: checkcast 495	java/lang/Runnable
    //   2907: invokevirtual 499	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   2910: return
    //   2911: aload_0
    //   2912: invokevirtual 490	android/app/Activity:isFinishing	()Z
    //   2915: ifne +3394 -> 6309
    //   2918: aload_0
    //   2919: new 2710	k/a/a/a/Ex
    //   2922: dup
    //   2923: aload_0
    //   2924: invokespecial 2711	k/a/a/a/Ex:<init>	(Lin/spicedigital/umang/activities/WebActivity;)V
    //   2927: checkcast 495	java/lang/Runnable
    //   2930: invokevirtual 499	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   2933: return
    //   2934: iload_1
    //   2935: sipush 1001
    //   2938: if_icmpne +17 -> 2955
    //   2941: iload_2
    //   2942: iconst_m1
    //   2943: if_icmpne +12 -> 2955
    //   2946: aload_0
    //   2947: aload_0
    //   2948: getfield 435	in/spicedigital/umang/activities/WebActivity:name	Ljava/lang/String;
    //   2951: invokespecial 1512	in/spicedigital/umang/activities/WebActivity:doInBackground	(Ljava/lang/String;)V
    //   2954: return
    //   2955: iload_1
    //   2956: aload_0
    //   2957: getfield 270	in/spicedigital/umang/activities/WebActivity:checksum	I
    //   2960: if_icmpne +24 -> 2984
    //   2963: iload_2
    //   2964: iconst_m1
    //   2965: if_icmpne +19 -> 2984
    //   2968: aload_0
    //   2969: new 2713	k/a/a/a/Fx
    //   2972: dup
    //   2973: aload_0
    //   2974: invokespecial 2714	k/a/a/a/Fx:<init>	(Lin/spicedigital/umang/activities/WebActivity;)V
    //   2977: checkcast 495	java/lang/Runnable
    //   2980: invokevirtual 499	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   2983: return
    //   2984: aload_0
    //   2985: getfield 2142	in/spicedigital/umang/activities/WebActivity:k	Lk/a/a/m/ab;
    //   2988: astore 8
    //   2990: iload_1
    //   2991: bipush 98
    //   2993: if_icmpne +29 -> 3022
    //   2996: iload_2
    //   2997: iconst_m1
    //   2998: if_icmpne +24 -> 3022
    //   3001: aload_3
    //   3002: ifnonnull +10 -> 3012
    //   3005: aload 8
    //   3007: aconst_null
    //   3008: invokevirtual 2717	k/a/a/m/ab:a	(Landroid/net/Uri;)V
    //   3011: return
    //   3012: aload 8
    //   3014: aload_3
    //   3015: invokevirtual 2721	android/content/Intent:getData	()Landroid/net/Uri;
    //   3018: invokevirtual 2717	k/a/a/m/ab:a	(Landroid/net/Uri;)V
    //   3021: return
    //   3022: iload_1
    //   3023: getstatic 2725	k/a/a/m/M:c	I
    //   3026: if_icmpne +60 -> 3086
    //   3029: iload_2
    //   3030: iconst_m1
    //   3031: if_icmpne +55 -> 3086
    //   3034: aload_0
    //   3035: invokevirtual 490	android/app/Activity:isFinishing	()Z
    //   3038: ifne +3271 -> 6309
    //   3041: new 2727	k/a/a/a/Gx
    //   3044: dup
    //   3045: aload_0
    //   3046: aload_3
    //   3047: invokespecial 2728	k/a/a/a/Gx:<init>	(Lin/spicedigital/umang/activities/WebActivity;Landroid/content/Intent;)V
    //   3050: astore_3
    //   3051: aload_3
    //   3052: checkcast 495	java/lang/Runnable
    //   3055: astore_3
    //   3056: aload_0
    //   3057: aload_3
    //   3058: invokevirtual 499	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   3061: return
    //   3062: astore_3
    //   3063: aload_3
    //   3064: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   3067: aload_0
    //   3068: aload_0
    //   3069: invokevirtual 323	android/support/v7/app/AppCompatActivity:getResources	()Landroid/content/res/Resources;
    //   3072: ldc_w 506
    //   3075: invokevirtual 330	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   3078: iconst_1
    //   3079: invokestatic 512	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   3082: invokevirtual 515	android/widget/Toast:show	()V
    //   3085: return
    //   3086: iload_1
    //   3087: getstatic 2730	k/a/a/m/M:b	I
    //   3090: if_icmpne +63 -> 3153
    //   3093: iload_2
    //   3094: iconst_m1
    //   3095: if_icmpne +58 -> 3153
    //   3098: aload_0
    //   3099: invokevirtual 490	android/app/Activity:isFinishing	()Z
    //   3102: ifne +3207 -> 6309
    //   3105: new 2732	k/a/a/a/Hx
    //   3108: dup
    //   3109: aload_0
    //   3110: invokespecial 2733	k/a/a/a/Hx:<init>	(Lin/spicedigital/umang/activities/WebActivity;)V
    //   3113: astore_3
    //   3114: aload_3
    //   3115: checkcast 495	java/lang/Runnable
    //   3118: astore_3
    //   3119: aload_0
    //   3120: aload_3
    //   3121: invokevirtual 499	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   3124: return
    //   3125: astore_3
    //   3126: aload_3
    //   3127: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   3130: aload_0
    //   3131: invokevirtual 2735	in/spicedigital/umang/activities/WebActivity:invoke	()V
    //   3134: aload_0
    //   3135: aload_0
    //   3136: invokevirtual 323	android/support/v7/app/AppCompatActivity:getResources	()Landroid/content/res/Resources;
    //   3139: ldc_w 506
    //   3142: invokevirtual 330	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   3145: iconst_1
    //   3146: invokestatic 512	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   3149: invokevirtual 515	android/widget/Toast:show	()V
    //   3152: return
    //   3153: iload_2
    //   3154: iconst_m1
    //   3155: if_icmpne +522 -> 3677
    //   3158: iload_1
    //   3159: sipush 666
    //   3162: if_icmpne +515 -> 3677
    //   3165: aload_0
    //   3166: aload_3
    //   3167: invokevirtual 2721	android/content/Intent:getData	()Landroid/net/Uri;
    //   3170: invokespecial 987	in/spicedigital/umang/activities/WebActivity:getMimeType	(Landroid/net/Uri;)Ljava/lang/String;
    //   3173: astore 8
    //   3175: aload_0
    //   3176: invokevirtual 964	android/content/ContextWrapper:getContentResolver	()Landroid/content/ContentResolver;
    //   3179: aload_3
    //   3180: invokevirtual 2721	android/content/Intent:getData	()Landroid/net/Uri;
    //   3183: invokevirtual 1344	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   3186: astore 7
    //   3188: aload 8
    //   3190: ldc_w 2737
    //   3193: invokevirtual 298	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3196: istore 5
    //   3198: iload 5
    //   3200: ifeq +185 -> 3385
    //   3203: aload_0
    //   3204: aload 7
    //   3206: sipush 300
    //   3209: invokespecial 447	in/spicedigital/umang/activities/WebActivity:add	(Ljava/io/InputStream;I)Z
    //   3212: istore 5
    //   3214: iload 5
    //   3216: ifeq +99 -> 3315
    //   3219: aload 7
    //   3221: invokevirtual 456	java/io/InputStream:available	()I
    //   3224: istore_1
    //   3225: iload_1
    //   3226: newarray byte
    //   3228: astore_3
    //   3229: aload 7
    //   3231: aload_3
    //   3232: invokevirtual 942	java/io/InputStream:read	([B)I
    //   3235: pop
    //   3236: aload_3
    //   3237: iconst_0
    //   3238: invokestatic 920	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   3241: astore_3
    //   3242: aload_0
    //   3243: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   3246: astore 7
    //   3248: new 522	java/lang/StringBuilder
    //   3251: dup
    //   3252: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   3255: astore 8
    //   3257: aload 8
    //   3259: ldc_w 1378
    //   3262: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3265: pop
    //   3266: getstatic 1379	in/spicedigital/umang/activities/WebActivity:c	Ljava/lang/String;
    //   3269: astore 9
    //   3271: aload 8
    //   3273: aload 9
    //   3275: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3278: pop
    //   3279: aload 8
    //   3281: ldc_w 2739
    //   3284: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3287: pop
    //   3288: aload 8
    //   3290: aload_3
    //   3291: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3294: pop
    //   3295: aload 8
    //   3297: ldc_w 1391
    //   3300: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3303: pop
    //   3304: aload 7
    //   3306: aload 8
    //   3308: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3311: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   3314: return
    //   3315: new 522	java/lang/StringBuilder
    //   3318: dup
    //   3319: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   3322: astore_3
    //   3323: aload_3
    //   3324: ldc_w 1378
    //   3327: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3330: pop
    //   3331: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   3334: astore 7
    //   3336: aload_3
    //   3337: aload 7
    //   3339: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3342: pop
    //   3343: aload_3
    //   3344: ldc_w 1612
    //   3347: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3350: pop
    //   3351: aload_3
    //   3352: ldc_w 2741
    //   3355: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3358: pop
    //   3359: aload_3
    //   3360: ldc_w 1391
    //   3363: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3366: pop
    //   3367: aload_3
    //   3368: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3371: astore_3
    //   3372: aload_0
    //   3373: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   3376: astore 7
    //   3378: aload 7
    //   3380: aload_3
    //   3381: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   3384: return
    //   3385: aload_0
    //   3386: invokevirtual 964	android/content/ContextWrapper:getContentResolver	()Landroid/content/ContentResolver;
    //   3389: aload_3
    //   3390: invokevirtual 2721	android/content/Intent:getData	()Landroid/net/Uri;
    //   3393: invokevirtual 1344	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   3396: astore_3
    //   3397: aload_0
    //   3398: aload_3
    //   3399: sipush 300
    //   3402: invokespecial 447	in/spicedigital/umang/activities/WebActivity:add	(Ljava/io/InputStream;I)Z
    //   3405: istore 5
    //   3407: iload 5
    //   3409: ifeq +121 -> 3530
    //   3412: aload_0
    //   3413: aload_3
    //   3414: bipush 20
    //   3416: invokespecial 2743	in/spicedigital/umang/activities/WebActivity:readFully	(Ljava/io/InputStream;I)Z
    //   3419: istore 5
    //   3421: iload 5
    //   3423: ifne +76 -> 3499
    //   3426: aload_0
    //   3427: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   3430: astore_3
    //   3431: new 522	java/lang/StringBuilder
    //   3434: dup
    //   3435: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   3438: astore 7
    //   3440: aload 7
    //   3442: ldc_w 1378
    //   3445: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3448: pop
    //   3449: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   3452: astore 8
    //   3454: aload 7
    //   3456: aload 8
    //   3458: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3461: pop
    //   3462: aload 7
    //   3464: ldc_w 1612
    //   3467: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3470: pop
    //   3471: aload 7
    //   3473: ldc_w 2745
    //   3476: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3479: pop
    //   3480: aload 7
    //   3482: ldc_w 1391
    //   3485: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3488: pop
    //   3489: aload_3
    //   3490: aload 7
    //   3492: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3495: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   3498: return
    //   3499: aload_3
    //   3500: invokevirtual 456	java/io/InputStream:available	()I
    //   3503: istore_1
    //   3504: iload_1
    //   3505: newarray byte
    //   3507: astore 7
    //   3509: aload_3
    //   3510: aload 7
    //   3512: invokevirtual 942	java/io/InputStream:read	([B)I
    //   3515: pop
    //   3516: aload_0
    //   3517: aload 7
    //   3519: iconst_0
    //   3520: invokestatic 920	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   3523: ldc_w 2747
    //   3526: invokespecial 1492	in/spicedigital/umang/activities/WebActivity:save	(Ljava/lang/String;Ljava/lang/String;)V
    //   3529: return
    //   3530: aload_0
    //   3531: aload 7
    //   3533: aload_3
    //   3534: sipush 500
    //   3537: sipush 500
    //   3540: invokevirtual 2749	in/spicedigital/umang/activities/WebActivity:getBitmap	(Ljava/io/InputStream;Ljava/io/InputStream;II)Landroid/graphics/Bitmap;
    //   3543: astore_3
    //   3544: aload_0
    //   3545: iconst_1
    //   3546: putfield 233	in/spicedigital/umang/activities/WebActivity:mCurrentKeyMode	I
    //   3549: aload_0
    //   3550: aload_0
    //   3551: aload_3
    //   3552: invokevirtual 2751	in/spicedigital/umang/activities/WebActivity:doInBackground	(Landroid/content/Context;Landroid/graphics/Bitmap;)Landroid/net/Uri;
    //   3555: invokestatic 2754	com/theartofdev/edmodo/cropper/CropImage:a	(Landroid/net/Uri;)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   3558: astore_3
    //   3559: getstatic 2759	com/theartofdev/edmodo/cropper/CropImageView$c:c	Lcom/theartofdev/edmodo/cropper/CropImageView$c;
    //   3562: astore 7
    //   3564: aload_3
    //   3565: aload 7
    //   3567: invokevirtual 2764	com/theartofdev/edmodo/cropper/CropImage$a:a	(Lcom/theartofdev/edmodo/cropper/CropImageView$c;)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   3570: aload_0
    //   3571: invokevirtual 2766	com/theartofdev/edmodo/cropper/CropImage$a:a	(Landroid/app/Activity;)V
    //   3574: return
    //   3575: astore_3
    //   3576: aload_0
    //   3577: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   3580: ldc_w 1378
    //   3583: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3586: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   3589: ldc_w 1612
    //   3592: ldc_w 2767
    //   3595: ldc_w 1391
    //   3598: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3601: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   3604: aload_3
    //   3605: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   3608: return
    //   3609: astore_3
    //   3610: aload_0
    //   3611: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   3614: ldc_w 1378
    //   3617: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3620: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   3623: ldc_w 1612
    //   3626: ldc_w 2769
    //   3629: ldc_w 1391
    //   3632: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3635: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   3638: aload_3
    //   3639: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   3642: return
    //   3643: astore_3
    //   3644: aload_0
    //   3645: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   3648: ldc_w 1378
    //   3651: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3654: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   3657: ldc_w 1612
    //   3660: ldc_w 1614
    //   3663: ldc_w 1391
    //   3666: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3669: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   3672: aload_3
    //   3673: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   3676: return
    //   3677: iload_2
    //   3678: iconst_m1
    //   3679: if_icmpne +575 -> 4254
    //   3682: iload_1
    //   3683: sipush 669
    //   3686: if_icmpne +568 -> 4254
    //   3689: aload_0
    //   3690: aload_3
    //   3691: invokevirtual 2721	android/content/Intent:getData	()Landroid/net/Uri;
    //   3694: invokespecial 987	in/spicedigital/umang/activities/WebActivity:getMimeType	(Landroid/net/Uri;)Ljava/lang/String;
    //   3697: astore 7
    //   3699: aload_0
    //   3700: invokevirtual 964	android/content/ContextWrapper:getContentResolver	()Landroid/content/ContentResolver;
    //   3703: aload_3
    //   3704: invokevirtual 2721	android/content/Intent:getData	()Landroid/net/Uri;
    //   3707: invokevirtual 1344	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   3710: astore_3
    //   3711: aload 7
    //   3713: ldc_w 2737
    //   3716: invokevirtual 298	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3719: istore 5
    //   3721: iload 5
    //   3723: ifeq +347 -> 4070
    //   3726: new 522	java/lang/StringBuilder
    //   3729: dup
    //   3730: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   3733: astore 7
    //   3735: aload 7
    //   3737: ldc_w 2771
    //   3740: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3743: pop
    //   3744: getstatic 2773	in/spicedigital/umang/activities/WebActivity:path	Ljava/lang/String;
    //   3747: astore 8
    //   3749: aload 7
    //   3751: aload 8
    //   3753: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3756: pop
    //   3757: aload 7
    //   3759: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3762: pop
    //   3763: getstatic 2773	in/spicedigital/umang/activities/WebActivity:path	Ljava/lang/String;
    //   3766: astore 7
    //   3768: aload_0
    //   3769: aload_3
    //   3770: aload 7
    //   3772: invokestatic 2621	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   3775: invokespecial 447	in/spicedigital/umang/activities/WebActivity:add	(Ljava/io/InputStream;I)Z
    //   3778: istore 5
    //   3780: iload 5
    //   3782: ifeq +218 -> 4000
    //   3785: aload_3
    //   3786: invokevirtual 456	java/io/InputStream:available	()I
    //   3789: istore_1
    //   3790: iload_1
    //   3791: newarray byte
    //   3793: astore 7
    //   3795: aload_3
    //   3796: aload 7
    //   3798: invokevirtual 942	java/io/InputStream:read	([B)I
    //   3801: pop
    //   3802: aload 7
    //   3804: iconst_0
    //   3805: invokestatic 920	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   3808: astore_3
    //   3809: getstatic 602	android/os/Build$VERSION:SDK_INT	I
    //   3812: bipush 19
    //   3814: if_icmple +105 -> 3919
    //   3817: aload_3
    //   3818: invokevirtual 757	java/lang/String:length	()I
    //   3821: istore_1
    //   3822: aload_3
    //   3823: iconst_0
    //   3824: iload_1
    //   3825: iconst_1
    //   3826: isub
    //   3827: invokevirtual 2777	java/lang/String:substring	(II)Ljava/lang/String;
    //   3830: astore 7
    //   3832: aload_0
    //   3833: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   3836: astore_3
    //   3837: new 522	java/lang/StringBuilder
    //   3840: dup
    //   3841: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   3844: astore 8
    //   3846: getstatic 1379	in/spicedigital/umang/activities/WebActivity:c	Ljava/lang/String;
    //   3849: astore 9
    //   3851: aload 8
    //   3853: aload 9
    //   3855: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3858: pop
    //   3859: aload 8
    //   3861: ldc_w 2779
    //   3864: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3867: pop
    //   3868: aload 8
    //   3870: aload 7
    //   3872: ldc_w 1361
    //   3875: ldc -29
    //   3877: invokevirtual 1364	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3880: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3883: pop
    //   3884: aload 8
    //   3886: ldc_w 2781
    //   3889: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3892: pop
    //   3893: aload 8
    //   3895: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3898: astore 7
    //   3900: aload_3
    //   3901: checkcast 879	android/webkit/WebView
    //   3904: astore_3
    //   3905: aload_3
    //   3906: aload 7
    //   3908: aconst_null
    //   3909: invokevirtual 1387	android/webkit/WebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
    //   3912: return
    //   3913: astore_3
    //   3914: aload_3
    //   3915: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   3918: return
    //   3919: aload_0
    //   3920: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   3923: astore 7
    //   3925: new 522	java/lang/StringBuilder
    //   3928: dup
    //   3929: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   3932: astore 8
    //   3934: aload 8
    //   3936: ldc_w 1378
    //   3939: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3942: pop
    //   3943: getstatic 1379	in/spicedigital/umang/activities/WebActivity:c	Ljava/lang/String;
    //   3946: astore 9
    //   3948: aload 8
    //   3950: aload 9
    //   3952: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3955: pop
    //   3956: aload 8
    //   3958: ldc_w 2779
    //   3961: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3964: pop
    //   3965: aload 8
    //   3967: aload_3
    //   3968: ldc_w 1361
    //   3971: ldc -29
    //   3973: invokevirtual 1364	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3976: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3979: pop
    //   3980: aload 8
    //   3982: ldc_w 2781
    //   3985: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3988: pop
    //   3989: aload 7
    //   3991: aload 8
    //   3993: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3996: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   3999: return
    //   4000: new 522	java/lang/StringBuilder
    //   4003: dup
    //   4004: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   4007: astore_3
    //   4008: aload_3
    //   4009: ldc_w 1378
    //   4012: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4015: pop
    //   4016: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   4019: astore 7
    //   4021: aload_3
    //   4022: aload 7
    //   4024: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4027: pop
    //   4028: aload_3
    //   4029: ldc_w 1612
    //   4032: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4035: pop
    //   4036: aload_3
    //   4037: ldc_w 2741
    //   4040: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4043: pop
    //   4044: aload_3
    //   4045: ldc_w 1391
    //   4048: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4051: pop
    //   4052: aload_3
    //   4053: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4056: astore_3
    //   4057: aload_0
    //   4058: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   4061: astore 7
    //   4063: aload 7
    //   4065: aload_3
    //   4066: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   4069: return
    //   4070: aload_0
    //   4071: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   4074: astore_3
    //   4075: new 522	java/lang/StringBuilder
    //   4078: dup
    //   4079: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   4082: astore 7
    //   4084: aload 7
    //   4086: ldc_w 1378
    //   4089: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4092: pop
    //   4093: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   4096: astore 8
    //   4098: aload 7
    //   4100: aload 8
    //   4102: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4105: pop
    //   4106: aload 7
    //   4108: ldc_w 1612
    //   4111: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4114: pop
    //   4115: aload 7
    //   4117: ldc_w 2783
    //   4120: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4123: pop
    //   4124: aload 7
    //   4126: ldc_w 1391
    //   4129: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4132: pop
    //   4133: aload_3
    //   4134: aload 7
    //   4136: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4139: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   4142: return
    //   4143: astore_3
    //   4144: aload_0
    //   4145: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   4148: ldc_w 1378
    //   4151: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4154: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   4157: ldc_w 1612
    //   4160: ldc_w 2767
    //   4163: ldc_w 1391
    //   4166: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4169: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   4172: aload_3
    //   4173: checkcast 484	java/lang/Exception
    //   4176: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   4179: return
    //   4180: astore_3
    //   4181: aload_0
    //   4182: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   4185: ldc_w 1378
    //   4188: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4191: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   4194: ldc_w 1612
    //   4197: ldc_w 2769
    //   4200: ldc_w 1391
    //   4203: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4206: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   4209: aload_3
    //   4210: checkcast 484	java/lang/Exception
    //   4213: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   4216: return
    //   4217: astore_3
    //   4218: aload_0
    //   4219: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   4222: ldc_w 1378
    //   4225: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4228: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   4231: ldc_w 1612
    //   4234: ldc_w 1614
    //   4237: ldc_w 1391
    //   4240: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4243: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   4246: aload_3
    //   4247: checkcast 484	java/lang/Exception
    //   4250: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   4253: return
    //   4254: iload_2
    //   4255: iconst_m1
    //   4256: if_icmpne +289 -> 4545
    //   4259: iload_1
    //   4260: sipush 667
    //   4263: if_icmpne +282 -> 4545
    //   4266: aload_3
    //   4267: invokevirtual 2721	android/content/Intent:getData	()Landroid/net/Uri;
    //   4270: astore 7
    //   4272: aload 7
    //   4274: invokevirtual 981	android/net/Uri:getPath	()Ljava/lang/String;
    //   4277: pop
    //   4278: aload_0
    //   4279: invokevirtual 964	android/content/ContextWrapper:getContentResolver	()Landroid/content/ContentResolver;
    //   4282: aload 7
    //   4284: invokevirtual 1344	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   4287: astore_3
    //   4288: aload_0
    //   4289: aload_3
    //   4290: bipush 30
    //   4292: invokespecial 447	in/spicedigital/umang/activities/WebActivity:add	(Ljava/io/InputStream;I)Z
    //   4295: istore 5
    //   4297: iload 5
    //   4299: ifeq +121 -> 4420
    //   4302: aload_0
    //   4303: aload_3
    //   4304: bipush 6
    //   4306: invokespecial 2743	in/spicedigital/umang/activities/WebActivity:readFully	(Ljava/io/InputStream;I)Z
    //   4309: istore 5
    //   4311: iload 5
    //   4313: ifne +76 -> 4389
    //   4316: aload_0
    //   4317: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   4320: astore_3
    //   4321: new 522	java/lang/StringBuilder
    //   4324: dup
    //   4325: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   4328: astore 7
    //   4330: aload 7
    //   4332: ldc_w 1378
    //   4335: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4338: pop
    //   4339: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   4342: astore 8
    //   4344: aload 7
    //   4346: aload 8
    //   4348: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4351: pop
    //   4352: aload 7
    //   4354: ldc_w 1612
    //   4357: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4360: pop
    //   4361: aload 7
    //   4363: ldc_w 2745
    //   4366: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4369: pop
    //   4370: aload 7
    //   4372: ldc_w 1391
    //   4375: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4378: pop
    //   4379: aload_3
    //   4380: aload 7
    //   4382: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4385: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   4388: return
    //   4389: aload_3
    //   4390: invokevirtual 456	java/io/InputStream:available	()I
    //   4393: istore_1
    //   4394: iload_1
    //   4395: newarray byte
    //   4397: astore 7
    //   4399: aload_3
    //   4400: aload 7
    //   4402: invokevirtual 942	java/io/InputStream:read	([B)I
    //   4405: pop
    //   4406: aload_0
    //   4407: aload 7
    //   4409: iconst_0
    //   4410: invokestatic 920	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   4413: ldc_w 2747
    //   4416: invokespecial 1492	in/spicedigital/umang/activities/WebActivity:save	(Ljava/lang/String;Ljava/lang/String;)V
    //   4419: return
    //   4420: aload_0
    //   4421: aload_3
    //   4422: aload_0
    //   4423: invokevirtual 964	android/content/ContextWrapper:getContentResolver	()Landroid/content/ContentResolver;
    //   4426: aload 7
    //   4428: invokevirtual 1344	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   4431: sipush 213
    //   4434: sipush 213
    //   4437: invokevirtual 2749	in/spicedigital/umang/activities/WebActivity:getBitmap	(Ljava/io/InputStream;Ljava/io/InputStream;II)Landroid/graphics/Bitmap;
    //   4440: pop
    //   4441: aload_0
    //   4442: iconst_2
    //   4443: putfield 233	in/spicedigital/umang/activities/WebActivity:mCurrentKeyMode	I
    //   4446: aload 7
    //   4448: invokestatic 2754	com/theartofdev/edmodo/cropper/CropImage:a	(Landroid/net/Uri;)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   4451: iconst_1
    //   4452: invokevirtual 2786	com/theartofdev/edmodo/cropper/CropImage$a:d	(Z)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   4455: bipush 70
    //   4457: invokevirtual 2789	com/theartofdev/edmodo/cropper/CropImage$a:h	(I)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   4460: astore_3
    //   4461: getstatic 2759	com/theartofdev/edmodo/cropper/CropImageView$c:c	Lcom/theartofdev/edmodo/cropper/CropImageView$c;
    //   4464: astore 7
    //   4466: aload_3
    //   4467: aload 7
    //   4469: invokevirtual 2764	com/theartofdev/edmodo/cropper/CropImage$a:a	(Lcom/theartofdev/edmodo/cropper/CropImageView$c;)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   4472: aload_0
    //   4473: invokevirtual 2766	com/theartofdev/edmodo/cropper/CropImage$a:a	(Landroid/app/Activity;)V
    //   4476: return
    //   4477: astore_3
    //   4478: aload_3
    //   4479: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   4482: aload_0
    //   4483: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   4486: ldc_w 1378
    //   4489: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4492: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   4495: ldc_w 1612
    //   4498: ldc_w 2767
    //   4501: ldc_w 1391
    //   4504: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4507: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   4510: return
    //   4511: astore_3
    //   4512: aload_3
    //   4513: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   4516: aload_0
    //   4517: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   4520: ldc_w 1378
    //   4523: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4526: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   4529: ldc_w 1612
    //   4532: ldc_w 1614
    //   4535: ldc_w 1391
    //   4538: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4541: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   4544: return
    //   4545: iload_2
    //   4546: iconst_m1
    //   4547: if_icmpne +639 -> 5186
    //   4550: iload_1
    //   4551: sipush 671
    //   4554: if_icmpne +632 -> 5186
    //   4557: aload_0
    //   4558: aload_3
    //   4559: invokevirtual 2721	android/content/Intent:getData	()Landroid/net/Uri;
    //   4562: invokespecial 987	in/spicedigital/umang/activities/WebActivity:getMimeType	(Landroid/net/Uri;)Ljava/lang/String;
    //   4565: astore 7
    //   4567: aload_0
    //   4568: invokevirtual 964	android/content/ContextWrapper:getContentResolver	()Landroid/content/ContentResolver;
    //   4571: aload_3
    //   4572: invokevirtual 2721	android/content/Intent:getData	()Landroid/net/Uri;
    //   4575: invokevirtual 1344	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   4578: astore 8
    //   4580: aload 7
    //   4582: ldc_w 2737
    //   4585: invokevirtual 298	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4588: istore 5
    //   4590: iload 5
    //   4592: ifeq +194 -> 4786
    //   4595: aload_0
    //   4596: getfield 237	in/spicedigital/umang/activities/WebActivity:id	Ljava/lang/String;
    //   4599: astore_3
    //   4600: aload_0
    //   4601: aload 8
    //   4603: aload_3
    //   4604: invokestatic 2792	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   4607: invokevirtual 1353	java/lang/Integer:intValue	()I
    //   4610: invokespecial 447	in/spicedigital/umang/activities/WebActivity:add	(Ljava/io/InputStream;I)Z
    //   4613: istore 5
    //   4615: iload 5
    //   4617: ifeq +99 -> 4716
    //   4620: aload 8
    //   4622: invokevirtual 456	java/io/InputStream:available	()I
    //   4625: istore_1
    //   4626: iload_1
    //   4627: newarray byte
    //   4629: astore_3
    //   4630: aload 8
    //   4632: aload_3
    //   4633: invokevirtual 942	java/io/InputStream:read	([B)I
    //   4636: pop
    //   4637: aload_3
    //   4638: iconst_0
    //   4639: invokestatic 920	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   4642: astore_3
    //   4643: aload_0
    //   4644: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   4647: astore 7
    //   4649: new 522	java/lang/StringBuilder
    //   4652: dup
    //   4653: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   4656: astore 8
    //   4658: aload 8
    //   4660: ldc_w 1378
    //   4663: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4666: pop
    //   4667: getstatic 1379	in/spicedigital/umang/activities/WebActivity:c	Ljava/lang/String;
    //   4670: astore 9
    //   4672: aload 8
    //   4674: aload 9
    //   4676: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4679: pop
    //   4680: aload 8
    //   4682: ldc_w 2739
    //   4685: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4688: pop
    //   4689: aload 8
    //   4691: aload_3
    //   4692: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4695: pop
    //   4696: aload 8
    //   4698: ldc_w 1391
    //   4701: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4704: pop
    //   4705: aload 7
    //   4707: aload 8
    //   4709: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4712: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   4715: return
    //   4716: new 522	java/lang/StringBuilder
    //   4719: dup
    //   4720: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   4723: astore_3
    //   4724: aload_3
    //   4725: ldc_w 1378
    //   4728: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4731: pop
    //   4732: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   4735: astore 7
    //   4737: aload_3
    //   4738: aload 7
    //   4740: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4743: pop
    //   4744: aload_3
    //   4745: ldc_w 1612
    //   4748: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4751: pop
    //   4752: aload_3
    //   4753: ldc_w 2741
    //   4756: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4759: pop
    //   4760: aload_3
    //   4761: ldc_w 1391
    //   4764: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4767: pop
    //   4768: aload_3
    //   4769: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4772: astore_3
    //   4773: aload_0
    //   4774: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   4777: astore 7
    //   4779: aload 7
    //   4781: aload_3
    //   4782: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   4785: return
    //   4786: aload_0
    //   4787: aload 8
    //   4789: aload_0
    //   4790: invokevirtual 964	android/content/ContextWrapper:getContentResolver	()Landroid/content/ContentResolver;
    //   4793: aload_3
    //   4794: invokevirtual 2721	android/content/Intent:getData	()Landroid/net/Uri;
    //   4797: invokevirtual 1344	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   4800: sipush 500
    //   4803: sipush 500
    //   4806: invokevirtual 2749	in/spicedigital/umang/activities/WebActivity:getBitmap	(Ljava/io/InputStream;Ljava/io/InputStream;II)Landroid/graphics/Bitmap;
    //   4809: astore_3
    //   4810: aload_0
    //   4811: getfield 2794	in/spicedigital/umang/activities/WebActivity:G	Z
    //   4814: ifeq +148 -> 4962
    //   4817: iload 6
    //   4819: istore 5
    //   4821: aload_0
    //   4822: getfield 2796	in/spicedigital/umang/activities/WebActivity:S	I
    //   4825: ifeq +20 -> 4845
    //   4828: aload_0
    //   4829: getfield 2798	in/spicedigital/umang/activities/WebActivity:F	I
    //   4832: ifne +10 -> 4842
    //   4835: iload 6
    //   4837: istore 5
    //   4839: goto +6 -> 4845
    //   4842: iconst_1
    //   4843: istore 5
    //   4845: aload_0
    //   4846: iconst_5
    //   4847: putfield 233	in/spicedigital/umang/activities/WebActivity:mCurrentKeyMode	I
    //   4850: aload_0
    //   4851: aload_0
    //   4852: aload_3
    //   4853: invokevirtual 2751	in/spicedigital/umang/activities/WebActivity:doInBackground	(Landroid/content/Context;Landroid/graphics/Bitmap;)Landroid/net/Uri;
    //   4856: invokestatic 2754	com/theartofdev/edmodo/cropper/CropImage:a	(Landroid/net/Uri;)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   4859: astore_3
    //   4860: aload_0
    //   4861: getfield 2800	in/spicedigital/umang/activities/WebActivity:V	Ljava/lang/String;
    //   4864: astore 7
    //   4866: aload 7
    //   4868: ldc_w 2802
    //   4871: invokevirtual 298	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4874: istore 6
    //   4876: iload 6
    //   4878: ifeq +30 -> 4908
    //   4881: aload_0
    //   4882: getfield 2798	in/spicedigital/umang/activities/WebActivity:F	I
    //   4885: istore_1
    //   4886: aload_0
    //   4887: getfield 2796	in/spicedigital/umang/activities/WebActivity:S	I
    //   4890: istore_2
    //   4891: aload_3
    //   4892: iload_1
    //   4893: iload_2
    //   4894: invokevirtual 2805	com/theartofdev/edmodo/cropper/CropImage$a:a	(II)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   4897: pop
    //   4898: aload_3
    //   4899: iload 5
    //   4901: invokevirtual 2786	com/theartofdev/edmodo/cropper/CropImage$a:d	(Z)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   4904: pop
    //   4905: goto +41 -> 4946
    //   4908: aload_0
    //   4909: getfield 2800	in/spicedigital/umang/activities/WebActivity:V	Ljava/lang/String;
    //   4912: astore 7
    //   4914: aload 7
    //   4916: ldc_w 2807
    //   4919: invokevirtual 298	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4922: istore 5
    //   4924: iload 5
    //   4926: ifeq +20 -> 4946
    //   4929: aload_0
    //   4930: getfield 2796	in/spicedigital/umang/activities/WebActivity:S	I
    //   4933: istore_1
    //   4934: aload_0
    //   4935: getfield 2798	in/spicedigital/umang/activities/WebActivity:F	I
    //   4938: istore_2
    //   4939: aload_3
    //   4940: iload_1
    //   4941: iload_2
    //   4942: invokevirtual 2809	com/theartofdev/edmodo/cropper/CropImage$a:c	(II)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   4945: pop
    //   4946: getstatic 2759	com/theartofdev/edmodo/cropper/CropImageView$c:c	Lcom/theartofdev/edmodo/cropper/CropImageView$c;
    //   4949: astore 7
    //   4951: aload_3
    //   4952: aload 7
    //   4954: invokevirtual 2764	com/theartofdev/edmodo/cropper/CropImage$a:a	(Lcom/theartofdev/edmodo/cropper/CropImageView$c;)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   4957: aload_0
    //   4958: invokevirtual 2766	com/theartofdev/edmodo/cropper/CropImage$a:a	(Landroid/app/Activity;)V
    //   4961: return
    //   4962: new 898	java/io/ByteArrayOutputStream
    //   4965: dup
    //   4966: invokespecial 899	java/io/ByteArrayOutputStream:<init>	()V
    //   4969: astore 8
    //   4971: aload 7
    //   4973: ldc_w 2811
    //   4976: invokevirtual 298	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4979: istore 5
    //   4981: iload 5
    //   4983: ifne +40 -> 5023
    //   4986: aload 7
    //   4988: ldc_w 2813
    //   4991: invokevirtual 298	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4994: istore 5
    //   4996: iload 5
    //   4998: ifeq +6 -> 5004
    //   5001: goto +22 -> 5023
    //   5004: getstatic 1809	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   5007: astore 9
    //   5009: aload_3
    //   5010: aload 9
    //   5012: bipush 100
    //   5014: aload 8
    //   5016: invokevirtual 911	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   5019: pop
    //   5020: goto +19 -> 5039
    //   5023: getstatic 905	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   5026: astore 9
    //   5028: aload_3
    //   5029: aload 9
    //   5031: bipush 100
    //   5033: aload 8
    //   5035: invokevirtual 911	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   5038: pop
    //   5039: aload_0
    //   5040: aload 8
    //   5042: invokevirtual 914	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   5045: iconst_0
    //   5046: invokestatic 920	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   5049: aload 7
    //   5051: invokespecial 1492	in/spicedigital/umang/activities/WebActivity:save	(Ljava/lang/String;Ljava/lang/String;)V
    //   5054: return
    //   5055: astore_3
    //   5056: aload_0
    //   5057: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   5060: ldc_w 1378
    //   5063: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5066: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   5069: ldc_w 1612
    //   5072: ldc_w 2767
    //   5075: ldc_w 1391
    //   5078: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5081: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   5084: aload_3
    //   5085: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   5088: return
    //   5089: aload_0
    //   5090: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   5093: ldc_w 1378
    //   5096: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5099: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   5102: ldc_w 1612
    //   5105: ldc_w 2769
    //   5108: ldc_w 1391
    //   5111: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5114: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   5117: return
    //   5118: astore_3
    //   5119: aload_0
    //   5120: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   5123: ldc_w 1378
    //   5126: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5129: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   5132: ldc_w 1612
    //   5135: ldc_w 2769
    //   5138: ldc_w 1391
    //   5141: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5144: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   5147: aload_3
    //   5148: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   5151: return
    //   5152: astore_3
    //   5153: aload_0
    //   5154: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   5157: ldc_w 1378
    //   5160: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5163: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   5166: ldc_w 1612
    //   5169: ldc_w 1614
    //   5172: ldc_w 1391
    //   5175: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5178: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   5181: aload_3
    //   5182: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   5185: return
    //   5186: iload_2
    //   5187: iconst_m1
    //   5188: if_icmpne +173 -> 5361
    //   5191: iload_1
    //   5192: sipush 670
    //   5195: if_icmpne +166 -> 5361
    //   5198: aload_3
    //   5199: invokevirtual 2721	android/content/Intent:getData	()Landroid/net/Uri;
    //   5202: astore_3
    //   5203: aload_3
    //   5204: invokevirtual 981	android/net/Uri:getPath	()Ljava/lang/String;
    //   5207: pop
    //   5208: aload_0
    //   5209: aload_0
    //   5210: invokevirtual 964	android/content/ContextWrapper:getContentResolver	()Landroid/content/ContentResolver;
    //   5213: aload_3
    //   5214: invokevirtual 1344	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   5217: aload_0
    //   5218: invokevirtual 964	android/content/ContextWrapper:getContentResolver	()Landroid/content/ContentResolver;
    //   5221: aload_3
    //   5222: invokevirtual 1344	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   5225: sipush 500
    //   5228: sipush 500
    //   5231: invokevirtual 2749	in/spicedigital/umang/activities/WebActivity:getBitmap	(Ljava/io/InputStream;Ljava/io/InputStream;II)Landroid/graphics/Bitmap;
    //   5234: astore_3
    //   5235: aload_0
    //   5236: iconst_4
    //   5237: putfield 233	in/spicedigital/umang/activities/WebActivity:mCurrentKeyMode	I
    //   5240: aload_0
    //   5241: aload_0
    //   5242: aload_3
    //   5243: invokevirtual 2751	in/spicedigital/umang/activities/WebActivity:doInBackground	(Landroid/content/Context;Landroid/graphics/Bitmap;)Landroid/net/Uri;
    //   5246: invokestatic 2754	com/theartofdev/edmodo/cropper/CropImage:a	(Landroid/net/Uri;)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   5249: sipush 135
    //   5252: sipush 145
    //   5255: invokevirtual 2805	com/theartofdev/edmodo/cropper/CropImage$a:a	(II)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   5258: iconst_1
    //   5259: invokevirtual 2786	com/theartofdev/edmodo/cropper/CropImage$a:d	(Z)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   5262: sipush 600
    //   5265: sipush 600
    //   5268: invokevirtual 2815	com/theartofdev/edmodo/cropper/CropImage$a:b	(II)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   5271: bipush 70
    //   5273: invokevirtual 2789	com/theartofdev/edmodo/cropper/CropImage$a:h	(I)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   5276: astore_3
    //   5277: getstatic 2759	com/theartofdev/edmodo/cropper/CropImageView$c:c	Lcom/theartofdev/edmodo/cropper/CropImageView$c;
    //   5280: astore 7
    //   5282: aload_3
    //   5283: aload 7
    //   5285: invokevirtual 2764	com/theartofdev/edmodo/cropper/CropImage$a:a	(Lcom/theartofdev/edmodo/cropper/CropImageView$c;)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   5288: aload_0
    //   5289: invokevirtual 2766	com/theartofdev/edmodo/cropper/CropImage$a:a	(Landroid/app/Activity;)V
    //   5292: return
    //   5293: astore_3
    //   5294: aload_3
    //   5295: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   5298: aload_0
    //   5299: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   5302: ldc_w 1378
    //   5305: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5308: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   5311: ldc_w 1612
    //   5314: ldc_w 2767
    //   5317: ldc_w 1391
    //   5320: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5323: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   5326: return
    //   5327: astore_3
    //   5328: aload_3
    //   5329: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   5332: aload_0
    //   5333: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   5336: ldc_w 1378
    //   5339: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5342: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   5345: ldc_w 1612
    //   5348: ldc_w 1614
    //   5351: ldc_w 1391
    //   5354: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5357: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   5360: return
    //   5361: iload_2
    //   5362: iconst_m1
    //   5363: if_icmpne +288 -> 5651
    //   5366: iload_1
    //   5367: sipush 668
    //   5370: if_icmpne +281 -> 5651
    //   5373: aload_3
    //   5374: invokevirtual 2721	android/content/Intent:getData	()Landroid/net/Uri;
    //   5377: astore 7
    //   5379: aload 7
    //   5381: invokevirtual 981	android/net/Uri:getPath	()Ljava/lang/String;
    //   5384: pop
    //   5385: aload_0
    //   5386: invokevirtual 964	android/content/ContextWrapper:getContentResolver	()Landroid/content/ContentResolver;
    //   5389: aload 7
    //   5391: invokevirtual 1344	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   5394: astore_3
    //   5395: aload_0
    //   5396: aload_3
    //   5397: bipush 60
    //   5399: invokespecial 447	in/spicedigital/umang/activities/WebActivity:add	(Ljava/io/InputStream;I)Z
    //   5402: istore 5
    //   5404: iload 5
    //   5406: ifeq +120 -> 5526
    //   5409: aload_0
    //   5410: aload_3
    //   5411: iconst_3
    //   5412: invokespecial 2743	in/spicedigital/umang/activities/WebActivity:readFully	(Ljava/io/InputStream;I)Z
    //   5415: istore 5
    //   5417: iload 5
    //   5419: ifne +76 -> 5495
    //   5422: aload_0
    //   5423: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   5426: astore_3
    //   5427: new 522	java/lang/StringBuilder
    //   5430: dup
    //   5431: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   5434: astore 7
    //   5436: aload 7
    //   5438: ldc_w 1378
    //   5441: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5444: pop
    //   5445: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   5448: astore 8
    //   5450: aload 7
    //   5452: aload 8
    //   5454: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5457: pop
    //   5458: aload 7
    //   5460: ldc_w 1612
    //   5463: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5466: pop
    //   5467: aload 7
    //   5469: ldc_w 2745
    //   5472: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5475: pop
    //   5476: aload 7
    //   5478: ldc_w 1391
    //   5481: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5484: pop
    //   5485: aload_3
    //   5486: aload 7
    //   5488: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5491: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   5494: return
    //   5495: aload_3
    //   5496: invokevirtual 456	java/io/InputStream:available	()I
    //   5499: istore_1
    //   5500: iload_1
    //   5501: newarray byte
    //   5503: astore 7
    //   5505: aload_3
    //   5506: aload 7
    //   5508: invokevirtual 942	java/io/InputStream:read	([B)I
    //   5511: pop
    //   5512: aload_0
    //   5513: aload 7
    //   5515: iconst_0
    //   5516: invokestatic 920	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   5519: ldc_w 2747
    //   5522: invokespecial 1492	in/spicedigital/umang/activities/WebActivity:save	(Ljava/lang/String;Ljava/lang/String;)V
    //   5525: return
    //   5526: aload_0
    //   5527: aload_3
    //   5528: aload_0
    //   5529: invokevirtual 964	android/content/ContextWrapper:getContentResolver	()Landroid/content/ContentResolver;
    //   5532: aload 7
    //   5534: invokevirtual 1344	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   5537: sipush 400
    //   5540: sipush 300
    //   5543: invokevirtual 2749	in/spicedigital/umang/activities/WebActivity:getBitmap	(Ljava/io/InputStream;Ljava/io/InputStream;II)Landroid/graphics/Bitmap;
    //   5546: astore_3
    //   5547: aload_0
    //   5548: iconst_3
    //   5549: putfield 233	in/spicedigital/umang/activities/WebActivity:mCurrentKeyMode	I
    //   5552: aload_0
    //   5553: aload_0
    //   5554: aload_3
    //   5555: invokevirtual 2751	in/spicedigital/umang/activities/WebActivity:doInBackground	(Landroid/content/Context;Landroid/graphics/Bitmap;)Landroid/net/Uri;
    //   5558: invokestatic 2754	com/theartofdev/edmodo/cropper/CropImage:a	(Landroid/net/Uri;)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   5561: bipush 70
    //   5563: invokevirtual 2789	com/theartofdev/edmodo/cropper/CropImage$a:h	(I)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   5566: astore_3
    //   5567: getstatic 2759	com/theartofdev/edmodo/cropper/CropImageView$c:c	Lcom/theartofdev/edmodo/cropper/CropImageView$c;
    //   5570: astore 7
    //   5572: aload_3
    //   5573: aload 7
    //   5575: invokevirtual 2764	com/theartofdev/edmodo/cropper/CropImage$a:a	(Lcom/theartofdev/edmodo/cropper/CropImageView$c;)Lcom/theartofdev/edmodo/cropper/CropImage$a;
    //   5578: aload_0
    //   5579: invokevirtual 2766	com/theartofdev/edmodo/cropper/CropImage$a:a	(Landroid/app/Activity;)V
    //   5582: return
    //   5583: astore_3
    //   5584: aload_0
    //   5585: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   5588: ldc_w 1378
    //   5591: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5594: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   5597: ldc_w 1612
    //   5600: ldc_w 2767
    //   5603: ldc_w 1391
    //   5606: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5609: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   5612: aload_3
    //   5613: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   5616: return
    //   5617: astore_3
    //   5618: aload_0
    //   5619: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   5622: ldc_w 1378
    //   5625: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5628: getstatic 1393	in/spicedigital/umang/activities/WebActivity:TAG	Ljava/lang/String;
    //   5631: ldc_w 1612
    //   5634: ldc_w 1614
    //   5637: ldc_w 1391
    //   5640: invokestatic 1618	f/sufficientlysecure/rootcommands/util/StringBuilder:replace	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5643: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   5646: aload_3
    //   5647: invokestatic 505	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   5650: return
    //   5651: iload_1
    //   5652: sipush 1124
    //   5655: if_icmpne +87 -> 5742
    //   5658: iload_2
    //   5659: iconst_m1
    //   5660: if_icmpne +82 -> 5742
    //   5663: aload_3
    //   5664: invokevirtual 1466	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   5667: ldc_w 2817
    //   5670: invokevirtual 2820	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   5673: ifeq +12 -> 5685
    //   5676: aload_3
    //   5677: ldc_w 2817
    //   5680: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   5683: astore 7
    //   5685: ldc_w 2671
    //   5688: aload 7
    //   5690: invokestatic 1425	f/sufficientlysecure/rootcommands/util/StringBuilder:get	(Ljava/lang/String;Ljava/lang/String;)V
    //   5693: aload_0
    //   5694: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   5697: astore_3
    //   5698: ldc_w 2673
    //   5701: invokestatic 618	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5704: astore 8
    //   5706: aload 8
    //   5708: aload 7
    //   5710: ldc_w 2675
    //   5713: ldc_w 2677
    //   5716: invokevirtual 1364	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5719: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5722: pop
    //   5723: aload 8
    //   5725: ldc_w 1391
    //   5728: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5731: pop
    //   5732: aload_3
    //   5733: aload 8
    //   5735: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5738: invokevirtual 951	in/spicedigital/umang/utils/CustomAdvancedWebView:loadUrl	(Ljava/lang/String;)V
    //   5741: return
    //   5742: iload_1
    //   5743: sipush 1132
    //   5746: if_icmpne +77 -> 5823
    //   5749: iload_2
    //   5750: iconst_m1
    //   5751: if_icmpne +72 -> 5823
    //   5754: aload_3
    //   5755: invokevirtual 1466	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   5758: ldc_w 2822
    //   5761: invokevirtual 2820	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   5764: ifeq +24 -> 5788
    //   5767: aload_0
    //   5768: ldc_w 1569
    //   5771: aload_3
    //   5772: ldc_w 2824
    //   5775: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   5778: aload_3
    //   5779: ldc_w 2826
    //   5782: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   5785: invokevirtual 2475	in/spicedigital/umang/activities/WebActivity:start	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5788: aload_3
    //   5789: invokevirtual 1466	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   5792: ldc_w 2828
    //   5795: invokevirtual 2820	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   5798: ifeq +511 -> 6309
    //   5801: aload_0
    //   5802: ldc_w 1563
    //   5805: aload_3
    //   5806: ldc_w 2824
    //   5809: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   5812: aload_3
    //   5813: ldc_w 2826
    //   5816: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   5819: invokevirtual 2475	in/spicedigital/umang/activities/WebActivity:start	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5822: return
    //   5823: iload_1
    //   5824: sipush 3310
    //   5827: if_icmpne +30 -> 5857
    //   5830: iload_2
    //   5831: iconst_m1
    //   5832: if_icmpne +25 -> 5857
    //   5835: aload_3
    //   5836: ldc_w 2830
    //   5839: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   5842: ifnull +467 -> 6309
    //   5845: aload_0
    //   5846: aload_3
    //   5847: ldc_w 2830
    //   5850: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   5853: invokevirtual 1460	in/spicedigital/umang/activities/WebActivity:setTitle	(Ljava/lang/String;)V
    //   5856: return
    //   5857: iload_1
    //   5858: sipush 3710
    //   5861: if_icmpne +250 -> 6111
    //   5864: iload_2
    //   5865: iconst_m1
    //   5866: if_icmpne +245 -> 6111
    //   5869: aload_3
    //   5870: ifnonnull +4 -> 5874
    //   5873: return
    //   5874: aload_3
    //   5875: ldc_w 2831
    //   5878: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   5881: ifnull +428 -> 6309
    //   5884: aload_3
    //   5885: ldc_w 2833
    //   5888: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   5891: astore 8
    //   5893: new 640	org/json/JSONObject
    //   5896: dup
    //   5897: invokespecial 697	org/json/JSONObject:<init>	()V
    //   5900: astore 7
    //   5902: aload 7
    //   5904: ldc_w 1444
    //   5907: ldc_w 2834
    //   5910: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5913: pop
    //   5914: aload 8
    //   5916: ldc_w 2836
    //   5919: invokevirtual 298	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   5922: istore 5
    //   5924: iload 5
    //   5926: ifeq +22 -> 5948
    //   5929: aload 7
    //   5931: ldc_w 2836
    //   5934: aload_3
    //   5935: ldc_w 2831
    //   5938: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   5941: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5944: pop
    //   5945: goto +143 -> 6088
    //   5948: aload_3
    //   5949: ldc_w 2831
    //   5952: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   5955: astore 8
    //   5957: new 552	java/io/File
    //   5960: dup
    //   5961: aload 8
    //   5963: invokespecial 556	java/io/File:<init>	(Ljava/lang/String;)V
    //   5966: astore 8
    //   5968: new 2838	java/io/FileInputStream
    //   5971: dup
    //   5972: aload 8
    //   5974: invokespecial 2839	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   5977: astore 9
    //   5979: aload 9
    //   5981: invokevirtual 2840	java/io/FileInputStream:available	()I
    //   5984: istore_1
    //   5985: iload_1
    //   5986: newarray byte
    //   5988: astore 10
    //   5990: aload 9
    //   5992: aload 10
    //   5994: invokevirtual 2841	java/io/FileInputStream:read	([B)I
    //   5997: pop
    //   5998: aload 9
    //   6000: invokevirtual 2842	java/io/FileInputStream:close	()V
    //   6003: aload 7
    //   6005: ldc_w 2844
    //   6008: aload 10
    //   6010: iconst_0
    //   6011: invokestatic 920	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   6014: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   6017: pop
    //   6018: aload 7
    //   6020: ldc_w 2846
    //   6023: aload_3
    //   6024: ldc_w 2846
    //   6027: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   6030: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   6033: pop
    //   6034: aload 7
    //   6036: ldc_w 2847
    //   6039: aload_3
    //   6040: ldc_w 2847
    //   6043: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   6046: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   6049: pop
    //   6050: new 522	java/lang/StringBuilder
    //   6053: dup
    //   6054: invokespecial 523	java/lang/StringBuilder:<init>	()V
    //   6057: astore_3
    //   6058: aload_3
    //   6059: ldc -29
    //   6061: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6064: pop
    //   6065: aload_3
    //   6066: aload 8
    //   6068: invokevirtual 2192	java/io/File:length	()J
    //   6071: invokevirtual 2197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6074: pop
    //   6075: aload 7
    //   6077: ldc_w 2848
    //   6080: aload_3
    //   6081: invokevirtual 555	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6084: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   6087: pop
    //   6088: aload_0
    //   6089: aload 7
    //   6091: invokevirtual 709	org/json/JSONObject:toString	()Ljava/lang/String;
    //   6094: invokevirtual 2850	in/spicedigital/umang/activities/WebActivity:onResume	(Ljava/lang/String;)V
    //   6097: return
    //   6098: astore_3
    //   6099: aload_3
    //   6100: invokevirtual 1457	java/lang/Exception:printStackTrace	()V
    //   6103: aload_0
    //   6104: ldc_w 2852
    //   6107: invokevirtual 1460	in/spicedigital/umang/activities/WebActivity:setTitle	(Ljava/lang/String;)V
    //   6110: return
    //   6111: iload_1
    //   6112: sipush 672
    //   6115: if_icmpne +13 -> 6128
    //   6118: iload_2
    //   6119: iconst_m1
    //   6120: if_icmpne +8 -> 6128
    //   6123: aload_0
    //   6124: invokespecial 2854	in/spicedigital/umang/activities/WebActivity:call	()V
    //   6127: return
    //   6128: iload_1
    //   6129: sipush 673
    //   6132: if_icmpne +14 -> 6146
    //   6135: iload_2
    //   6136: iconst_m1
    //   6137: if_icmpne +9 -> 6146
    //   6140: aload_0
    //   6141: aload_3
    //   6142: invokespecial 2856	in/spicedigital/umang/activities/WebActivity:update	(Landroid/content/Intent;)V
    //   6145: return
    //   6146: iload_1
    //   6147: sipush 1138
    //   6150: if_icmpne +20 -> 6170
    //   6153: iload_2
    //   6154: iconst_m1
    //   6155: if_icmpne +15 -> 6170
    //   6158: aload_0
    //   6159: aload_3
    //   6160: ldc_w 2858
    //   6163: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   6166: invokevirtual 1460	in/spicedigital/umang/activities/WebActivity:setTitle	(Ljava/lang/String;)V
    //   6169: return
    //   6170: iload_1
    //   6171: sipush 1139
    //   6174: if_icmpne +20 -> 6194
    //   6177: iload_2
    //   6178: iconst_m1
    //   6179: if_icmpne +15 -> 6194
    //   6182: aload_0
    //   6183: aload_3
    //   6184: ldc_w 2858
    //   6187: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   6190: invokevirtual 1460	in/spicedigital/umang/activities/WebActivity:setTitle	(Ljava/lang/String;)V
    //   6193: return
    //   6194: iload_1
    //   6195: sipush 1149
    //   6198: if_icmpne +18 -> 6216
    //   6201: iload_2
    //   6202: iconst_m1
    //   6203: if_icmpne +13 -> 6216
    //   6206: aload_0
    //   6207: aload_3
    //   6208: invokevirtual 2721	android/content/Intent:getData	()Landroid/net/Uri;
    //   6211: iconst_0
    //   6212: invokespecial 2860	in/spicedigital/umang/activities/WebActivity:load	(Landroid/net/Uri;Z)V
    //   6215: return
    //   6216: iload_1
    //   6217: sipush 1152
    //   6220: if_icmpne +18 -> 6238
    //   6223: iload_2
    //   6224: iconst_m1
    //   6225: if_icmpne +13 -> 6238
    //   6228: aload_0
    //   6229: aload_3
    //   6230: invokevirtual 2721	android/content/Intent:getData	()Landroid/net/Uri;
    //   6233: iconst_1
    //   6234: invokespecial 2860	in/spicedigital/umang/activities/WebActivity:load	(Landroid/net/Uri;Z)V
    //   6237: return
    //   6238: iload_1
    //   6239: sipush 1143
    //   6242: if_icmpne +10 -> 6252
    //   6245: aload_0
    //   6246: iload_2
    //   6247: aload_3
    //   6248: invokespecial 2862	in/spicedigital/umang/activities/WebActivity:newInstance	(ILandroid/content/Intent;)V
    //   6251: return
    //   6252: iload_1
    //   6253: sipush 1147
    //   6256: if_icmpne +10 -> 6266
    //   6259: aload_0
    //   6260: iload_2
    //   6261: aload_3
    //   6262: invokespecial 2864	in/spicedigital/umang/activities/WebActivity:onCreate	(ILandroid/content/Intent;)V
    //   6265: return
    //   6266: iload_1
    //   6267: sipush 3711
    //   6270: if_icmpne +20 -> 6290
    //   6273: iload_2
    //   6274: iconst_m1
    //   6275: if_icmpne +34 -> 6309
    //   6278: aload_0
    //   6279: getfield 1148	in/spicedigital/umang/activities/WebActivity:d	Lk/a/a/o/r;
    //   6282: aload_0
    //   6283: getfield 2866	in/spicedigital/umang/activities/WebActivity:g	Ljava/lang/String;
    //   6286: invokevirtual 2869	k/a/a/o/r:uploadDigilockerDocument	(Ljava/lang/String;)V
    //   6289: return
    //   6290: aload_0
    //   6291: getfield 877	in/spicedigital/umang/activities/WebActivity:a	Lin/spicedigital/umang/utils/CustomAdvancedWebView;
    //   6294: iload_1
    //   6295: iload_2
    //   6296: aload_3
    //   6297: invokevirtual 2871	in/spicedigital/umang/utils/CustomAdvancedWebView:a	(IILandroid/content/Intent;)V
    //   6300: return
    //   6301: astore_3
    //   6302: return
    //   6303: astore_3
    //   6304: return
    //   6305: astore_3
    //   6306: goto -1217 -> 5089
    //   6309: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6310	0	this	WebActivity
    //   0	6310	1	paramInt1	int
    //   0	6310	2	paramInt2	int
    //   0	6310	3	paramIntent	Intent
    //   139	13	4	m	int
    //   229	5696	5	bool1	boolean
    //   146	4731	6	bool2	boolean
    //   14	51	7	localStringBuilder	StringBuilder
    //   73	3	7	localException	Exception
    //   143	5947	7	localObject1	Object
    //   191	5876	8	localObject2	Object
    //   671	5328	9	localObject3	Object
    //   735	5274	10	localObject4	Object
    //   804	1557	11	localObject5	Object
    //   873	1510	12	localObject6	Object
    //   942	1495	13	localObject7	Object
    //   1011	1437	14	localObject8	Object
    //   1080	1379	15	localObject9	Object
    //   2256	149	16	localObject10	Object
    //   2292	42	17	localQName	javax.xml.namespace.QName
    // Exception table:
    //   from	to	target	type
    //   7	70	73	java/lang/Exception
    //   103	128	129	java/lang/Exception
    //   2727	2736	2747	java/lang/Exception
    //   2741	2746	2747	java/lang/Exception
    //   2790	2800	2811	java/lang/Exception
    //   2805	2810	2811	java/lang/Exception
    //   3041	3051	3062	java/lang/Exception
    //   3056	3061	3062	java/lang/Exception
    //   3105	3114	3125	java/lang/Exception
    //   3119	3124	3125	java/lang/Exception
    //   3175	3198	3575	java/lang/Exception
    //   3203	3214	3575	java/lang/Exception
    //   3219	3225	3575	java/lang/Exception
    //   3229	3242	3575	java/lang/Exception
    //   3248	3266	3575	java/lang/Exception
    //   3271	3314	3575	java/lang/Exception
    //   3315	3331	3575	java/lang/Exception
    //   3336	3372	3575	java/lang/Exception
    //   3378	3384	3575	java/lang/Exception
    //   3385	3407	3575	java/lang/Exception
    //   3412	3421	3575	java/lang/Exception
    //   3431	3449	3575	java/lang/Exception
    //   3454	3498	3575	java/lang/Exception
    //   3499	3504	3575	java/lang/Exception
    //   3509	3529	3575	java/lang/Exception
    //   3530	3544	3575	java/lang/Exception
    //   3549	3559	3575	java/lang/Exception
    //   3564	3574	3575	java/lang/Exception
    //   3175	3198	3609	java/io/IOException
    //   3203	3214	3609	java/io/IOException
    //   3219	3225	3609	java/io/IOException
    //   3229	3242	3609	java/io/IOException
    //   3248	3266	3609	java/io/IOException
    //   3271	3314	3609	java/io/IOException
    //   3315	3331	3609	java/io/IOException
    //   3336	3372	3609	java/io/IOException
    //   3378	3384	3609	java/io/IOException
    //   3385	3407	3609	java/io/IOException
    //   3412	3421	3609	java/io/IOException
    //   3431	3449	3609	java/io/IOException
    //   3454	3498	3609	java/io/IOException
    //   3499	3504	3609	java/io/IOException
    //   3509	3529	3609	java/io/IOException
    //   3530	3544	3609	java/io/IOException
    //   3549	3559	3609	java/io/IOException
    //   3564	3574	3609	java/io/IOException
    //   3175	3198	3643	java/io/FileNotFoundException
    //   3203	3214	3643	java/io/FileNotFoundException
    //   3219	3225	3643	java/io/FileNotFoundException
    //   3229	3242	3643	java/io/FileNotFoundException
    //   3248	3266	3643	java/io/FileNotFoundException
    //   3271	3314	3643	java/io/FileNotFoundException
    //   3315	3331	3643	java/io/FileNotFoundException
    //   3336	3372	3643	java/io/FileNotFoundException
    //   3378	3384	3643	java/io/FileNotFoundException
    //   3385	3407	3643	java/io/FileNotFoundException
    //   3412	3421	3643	java/io/FileNotFoundException
    //   3431	3449	3643	java/io/FileNotFoundException
    //   3454	3498	3643	java/io/FileNotFoundException
    //   3499	3504	3643	java/io/FileNotFoundException
    //   3509	3529	3643	java/io/FileNotFoundException
    //   3530	3544	3643	java/io/FileNotFoundException
    //   3549	3559	3643	java/io/FileNotFoundException
    //   3564	3574	3643	java/io/FileNotFoundException
    //   3817	3822	3913	java/lang/Exception
    //   3822	3832	3913	java/lang/Exception
    //   3837	3846	3913	java/lang/Exception
    //   3851	3900	3913	java/lang/Exception
    //   3905	3912	3913	java/lang/Exception
    //   3699	3721	4143	java/lang/Exception
    //   3726	3744	4143	java/lang/Exception
    //   3749	3763	4143	java/lang/Exception
    //   3768	3780	4143	java/lang/Exception
    //   3785	3790	4143	java/lang/Exception
    //   3795	3809	4143	java/lang/Exception
    //   3914	3918	4143	java/lang/Exception
    //   3925	3943	4143	java/lang/Exception
    //   3948	3999	4143	java/lang/Exception
    //   4000	4016	4143	java/lang/Exception
    //   4021	4057	4143	java/lang/Exception
    //   4063	4069	4143	java/lang/Exception
    //   4075	4093	4143	java/lang/Exception
    //   4098	4142	4143	java/lang/Exception
    //   3699	3721	4180	java/io/IOException
    //   3726	3744	4180	java/io/IOException
    //   3749	3763	4180	java/io/IOException
    //   3768	3780	4180	java/io/IOException
    //   3785	3790	4180	java/io/IOException
    //   3795	3809	4180	java/io/IOException
    //   3914	3918	4180	java/io/IOException
    //   3925	3943	4180	java/io/IOException
    //   3948	3999	4180	java/io/IOException
    //   4000	4016	4180	java/io/IOException
    //   4021	4057	4180	java/io/IOException
    //   4063	4069	4180	java/io/IOException
    //   4075	4093	4180	java/io/IOException
    //   4098	4142	4180	java/io/IOException
    //   3699	3721	4217	java/io/FileNotFoundException
    //   3726	3744	4217	java/io/FileNotFoundException
    //   3749	3763	4217	java/io/FileNotFoundException
    //   3768	3780	4217	java/io/FileNotFoundException
    //   3785	3790	4217	java/io/FileNotFoundException
    //   3795	3809	4217	java/io/FileNotFoundException
    //   3914	3918	4217	java/io/FileNotFoundException
    //   3925	3943	4217	java/io/FileNotFoundException
    //   3948	3999	4217	java/io/FileNotFoundException
    //   4000	4016	4217	java/io/FileNotFoundException
    //   4021	4057	4217	java/io/FileNotFoundException
    //   4063	4069	4217	java/io/FileNotFoundException
    //   4075	4093	4217	java/io/FileNotFoundException
    //   4098	4142	4217	java/io/FileNotFoundException
    //   4266	4297	4477	java/lang/Exception
    //   4302	4311	4477	java/lang/Exception
    //   4321	4339	4477	java/lang/Exception
    //   4344	4388	4477	java/lang/Exception
    //   4389	4394	4477	java/lang/Exception
    //   4399	4419	4477	java/lang/Exception
    //   4420	4441	4477	java/lang/Exception
    //   4446	4461	4477	java/lang/Exception
    //   4466	4476	4477	java/lang/Exception
    //   4266	4297	4511	java/io/FileNotFoundException
    //   4302	4311	4511	java/io/FileNotFoundException
    //   4321	4339	4511	java/io/FileNotFoundException
    //   4344	4388	4511	java/io/FileNotFoundException
    //   4389	4394	4511	java/io/FileNotFoundException
    //   4399	4419	4511	java/io/FileNotFoundException
    //   4420	4441	4511	java/io/FileNotFoundException
    //   4446	4461	4511	java/io/FileNotFoundException
    //   4466	4476	4511	java/io/FileNotFoundException
    //   4567	4590	5055	java/lang/Exception
    //   4600	4615	5055	java/lang/Exception
    //   4620	4626	5055	java/lang/Exception
    //   4630	4643	5055	java/lang/Exception
    //   4649	4667	5055	java/lang/Exception
    //   4672	4715	5055	java/lang/Exception
    //   4716	4732	5055	java/lang/Exception
    //   4737	4773	5055	java/lang/Exception
    //   4779	4785	5055	java/lang/Exception
    //   4786	4810	5055	java/lang/Exception
    //   4850	4860	5055	java/lang/Exception
    //   4866	4876	5055	java/lang/Exception
    //   4891	4905	5055	java/lang/Exception
    //   4914	4924	5055	java/lang/Exception
    //   4939	4946	5055	java/lang/Exception
    //   4951	4961	5055	java/lang/Exception
    //   4962	4981	5055	java/lang/Exception
    //   4986	4996	5055	java/lang/Exception
    //   5009	5020	5055	java/lang/Exception
    //   5028	5039	5055	java/lang/Exception
    //   5039	5054	5055	java/lang/Exception
    //   4567	4590	5118	java/io/IOException
    //   4600	4615	5118	java/io/IOException
    //   4620	4626	5118	java/io/IOException
    //   4630	4643	5118	java/io/IOException
    //   4649	4667	5118	java/io/IOException
    //   4672	4715	5118	java/io/IOException
    //   4716	4732	5118	java/io/IOException
    //   4737	4773	5118	java/io/IOException
    //   4779	4785	5118	java/io/IOException
    //   4786	4810	5118	java/io/IOException
    //   4850	4860	5118	java/io/IOException
    //   4866	4876	5118	java/io/IOException
    //   4891	4905	5118	java/io/IOException
    //   4914	4924	5118	java/io/IOException
    //   4939	4946	5118	java/io/IOException
    //   4951	4961	5118	java/io/IOException
    //   4962	4981	5118	java/io/IOException
    //   4986	4996	5118	java/io/IOException
    //   5009	5020	5118	java/io/IOException
    //   5028	5039	5118	java/io/IOException
    //   5039	5054	5118	java/io/IOException
    //   4567	4590	5152	java/io/FileNotFoundException
    //   4600	4615	5152	java/io/FileNotFoundException
    //   4620	4626	5152	java/io/FileNotFoundException
    //   4630	4643	5152	java/io/FileNotFoundException
    //   4649	4667	5152	java/io/FileNotFoundException
    //   4672	4715	5152	java/io/FileNotFoundException
    //   4716	4732	5152	java/io/FileNotFoundException
    //   4737	4773	5152	java/io/FileNotFoundException
    //   4779	4785	5152	java/io/FileNotFoundException
    //   4786	4810	5152	java/io/FileNotFoundException
    //   4850	4860	5152	java/io/FileNotFoundException
    //   4866	4876	5152	java/io/FileNotFoundException
    //   4891	4905	5152	java/io/FileNotFoundException
    //   4914	4924	5152	java/io/FileNotFoundException
    //   4939	4946	5152	java/io/FileNotFoundException
    //   4951	4961	5152	java/io/FileNotFoundException
    //   4962	4981	5152	java/io/FileNotFoundException
    //   4986	4996	5152	java/io/FileNotFoundException
    //   5009	5020	5152	java/io/FileNotFoundException
    //   5028	5039	5152	java/io/FileNotFoundException
    //   5039	5054	5152	java/io/FileNotFoundException
    //   5198	5235	5293	java/lang/Exception
    //   5240	5277	5293	java/lang/Exception
    //   5282	5292	5293	java/lang/Exception
    //   5198	5235	5327	java/io/FileNotFoundException
    //   5240	5277	5327	java/io/FileNotFoundException
    //   5282	5292	5327	java/io/FileNotFoundException
    //   5385	5404	5583	java/lang/Exception
    //   5409	5417	5583	java/lang/Exception
    //   5427	5445	5583	java/lang/Exception
    //   5450	5494	5583	java/lang/Exception
    //   5495	5500	5583	java/lang/Exception
    //   5505	5525	5583	java/lang/Exception
    //   5526	5547	5583	java/lang/Exception
    //   5552	5567	5583	java/lang/Exception
    //   5572	5582	5583	java/lang/Exception
    //   5385	5404	5617	java/io/FileNotFoundException
    //   5409	5417	5617	java/io/FileNotFoundException
    //   5427	5445	5617	java/io/FileNotFoundException
    //   5450	5494	5617	java/io/FileNotFoundException
    //   5495	5500	5617	java/io/FileNotFoundException
    //   5505	5525	5617	java/io/FileNotFoundException
    //   5526	5547	5617	java/io/FileNotFoundException
    //   5552	5567	5617	java/io/FileNotFoundException
    //   5572	5582	5617	java/io/FileNotFoundException
    //   5893	5924	6098	java/lang/Exception
    //   5929	5945	6098	java/lang/Exception
    //   5948	5957	6098	java/lang/Exception
    //   5957	5968	6098	java/lang/Exception
    //   5968	5985	6098	java/lang/Exception
    //   5990	6050	6098	java/lang/Exception
    //   6050	6088	6098	java/lang/Exception
    //   6088	6097	6098	java/lang/Exception
    //   175	184	6301	java/lang/Exception
    //   184	216	6301	java/lang/Exception
    //   221	231	6301	java/lang/Exception
    //   236	260	6301	java/lang/Exception
    //   260	334	6301	java/lang/Exception
    //   334	362	6301	java/lang/Exception
    //   363	371	6301	java/lang/Exception
    //   371	402	6301	java/lang/Exception
    //   406	414	6301	java/lang/Exception
    //   419	425	6301	java/lang/Exception
    //   431	440	6301	java/lang/Exception
    //   445	476	6301	java/lang/Exception
    //   477	485	6301	java/lang/Exception
    //   485	540	6301	java/lang/Exception
    //   544	552	6301	java/lang/Exception
    //   557	563	6301	java/lang/Exception
    //   568	599	6301	java/lang/Exception
    //   604	614	6301	java/lang/Exception
    //   619	627	6301	java/lang/Exception
    //   627	668	6301	java/lang/Exception
    //   673	684	6301	java/lang/Exception
    //   689	732	6301	java/lang/Exception
    //   737	750	6301	java/lang/Exception
    //   757	801	6301	java/lang/Exception
    //   806	819	6301	java/lang/Exception
    //   826	870	6301	java/lang/Exception
    //   875	888	6301	java/lang/Exception
    //   895	939	6301	java/lang/Exception
    //   944	957	6301	java/lang/Exception
    //   964	1008	6301	java/lang/Exception
    //   1013	1026	6301	java/lang/Exception
    //   1033	1077	6301	java/lang/Exception
    //   1082	1095	6301	java/lang/Exception
    //   1102	1146	6301	java/lang/Exception
    //   1151	1164	6301	java/lang/Exception
    //   1171	1203	6301	java/lang/Exception
    //   1203	1261	6301	java/lang/Exception
    //   1261	1283	6301	java/lang/Exception
    //   1288	1293	6301	java/lang/Exception
    //   1322	1331	6303	java/lang/Exception
    //   1331	1359	6303	java/lang/Exception
    //   1364	1373	6303	java/lang/Exception
    //   1378	1385	6303	java/lang/Exception
    //   1391	1401	6303	java/lang/Exception
    //   1406	1434	6303	java/lang/Exception
    //   1435	1442	6303	java/lang/Exception
    //   1442	1474	6303	java/lang/Exception
    //   1479	1489	6303	java/lang/Exception
    //   1496	1506	6303	java/lang/Exception
    //   1510	1535	6303	java/lang/Exception
    //   1539	1546	6303	java/lang/Exception
    //   1553	1565	6303	java/lang/Exception
    //   1570	1579	6303	java/lang/Exception
    //   1579	1584	6303	java/lang/Exception
    //   1588	1636	6303	java/lang/Exception
    //   1642	1649	6303	java/lang/Exception
    //   1649	1690	6303	java/lang/Exception
    //   1695	1707	6303	java/lang/Exception
    //   1714	1756	6303	java/lang/Exception
    //   1761	1773	6303	java/lang/Exception
    //   1778	1790	6303	java/lang/Exception
    //   1797	1841	6303	java/lang/Exception
    //   1846	1858	6303	java/lang/Exception
    //   1865	1909	6303	java/lang/Exception
    //   1914	1926	6303	java/lang/Exception
    //   1933	1977	6303	java/lang/Exception
    //   1982	1994	6303	java/lang/Exception
    //   2001	2045	6303	java/lang/Exception
    //   2050	2062	6303	java/lang/Exception
    //   2069	2113	6303	java/lang/Exception
    //   2118	2130	6303	java/lang/Exception
    //   2137	2181	6303	java/lang/Exception
    //   2186	2198	6303	java/lang/Exception
    //   2205	2217	6303	java/lang/Exception
    //   2222	2234	6303	java/lang/Exception
    //   2241	2253	6303	java/lang/Exception
    //   2258	2270	6303	java/lang/Exception
    //   2277	2289	6303	java/lang/Exception
    //   2294	2306	6303	java/lang/Exception
    //   2313	2325	6303	java/lang/Exception
    //   2330	2341	6303	java/lang/Exception
    //   2346	2470	6303	java/lang/Exception
    //   2470	2501	6303	java/lang/Exception
    //   2507	2560	6303	java/lang/Exception
    //   2561	2573	6303	java/lang/Exception
    //   2578	2589	6303	java/lang/Exception
    //   2594	2625	6303	java/lang/Exception
    //   2625	2673	6303	java/lang/Exception
    //   4567	4590	6305	java/lang/NumberFormatException
    //   4600	4615	6305	java/lang/NumberFormatException
    //   4620	4626	6305	java/lang/NumberFormatException
    //   4630	4643	6305	java/lang/NumberFormatException
    //   4649	4667	6305	java/lang/NumberFormatException
    //   4672	4715	6305	java/lang/NumberFormatException
    //   4716	4732	6305	java/lang/NumberFormatException
    //   4737	4773	6305	java/lang/NumberFormatException
    //   4779	4785	6305	java/lang/NumberFormatException
    //   4786	4810	6305	java/lang/NumberFormatException
    //   4850	4860	6305	java/lang/NumberFormatException
    //   4866	4876	6305	java/lang/NumberFormatException
    //   4891	4905	6305	java/lang/NumberFormatException
    //   4914	4924	6305	java/lang/NumberFormatException
    //   4939	4946	6305	java/lang/NumberFormatException
    //   4951	4961	6305	java/lang/NumberFormatException
    //   4962	4981	6305	java/lang/NumberFormatException
    //   4986	4996	6305	java/lang/NumberFormatException
    //   5009	5020	6305	java/lang/NumberFormatException
    //   5028	5039	6305	java/lang/NumberFormatException
    //   5039	5054	6305	java/lang/NumberFormatException
  }
  
  public void onActivityResult(String paramString)
  {
    if (Build.VERSION.SDK_INT > 19)
    {
      localObject = a;
      try
      {
        localStringBuilder = new StringBuilder();
        String str1 = r.i;
        localStringBuilder.append(str1);
        localStringBuilder.append("('");
        localStringBuilder.append(paramString.replaceAll("\\s+", ""));
        localStringBuilder.append("')");
        paramString = localStringBuilder.toString();
        localObject = (WebView)localObject;
        ((WebView)localObject).evaluateJavascript(paramString, null);
        return;
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
        return;
      }
    }
    Object localObject = a;
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("javascript:");
    localStringBuilder.append(r.i);
    localStringBuilder.append("(\"");
    localStringBuilder.append(paramString.replaceAll("\\s+", ""));
    localStringBuilder.append("\")");
    ((CustomAdvancedWebView)localObject).loadUrl(localStringBuilder.toString());
  }
  
  public void onBackPressed()
  {
    if (drawer.isDrawerOpen(8388613))
    {
      drawer.closeDrawer(8388613);
      return;
    }
    if (mPopup.isShowing())
    {
      mPopup.dismiss();
      return;
    }
    if (window.isShowing())
    {
      window.dismiss();
      return;
    }
    if (isFabOpen())
    {
      onHideCustomView();
      return;
    }
    if (s != null) {
      try
      {
        Object localObject1 = new StringBuilder();
        Object localObject2 = (WebView)a;
        ((StringBuilder)localObject1).append(((WebView)localObject2).getUrl().toString());
        ((StringBuilder)localObject1).append("====");
        localObject2 = s;
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).toString();
        localObject1 = (WebView)a;
        boolean bool = ((View)localObject1).isFocused();
        if (bool)
        {
          localObject1 = (WebView)a;
          bool = ((WebView)localObject1).canGoBack();
          if (bool)
          {
            localObject1 = (WebView)a;
            localObject1 = ((WebView)localObject1).getUrl().toString();
            localObject2 = s;
            bool = ((String)localObject1).equalsIgnoreCase((String)localObject2);
            if (bool)
            {
              finish();
              return;
            }
            localObject1 = (WebView)a;
            ((WebView)localObject1).goBack();
            return;
          }
        }
        finish();
        return;
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
        finish();
        return;
      }
    }
    finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int m = orientation;
  }
  
  public void onConnected(Bundle paramBundle)
  {
    mState = true;
    if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0)
    {
      mLocation = LocationServices.FusedLocationApi.getLastLocation(mConnection);
      if (mLocation != null)
      {
        paramBundle = f.sufficientlysecure.rootcommands.util.StringBuilder.append("lat : ");
        paramBundle.append(mLocation.getLatitude());
        paramBundle.toString();
        paramBundle = new StringBuilder();
        paramBundle.append("lng : ");
        paramBundle.append(mLocation.getLongitude());
        paramBundle.toString();
        if (!first)
        {
          first = true;
          try
          {
            paramBundle = getLocation();
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append("latLng : ");
            ((StringBuilder)localObject).append(paramBundle);
            ((StringBuilder)localObject).toString();
            localObject = y.a;
            append("S", paramBundle, (String)localObject);
            return;
          }
          catch (Exception paramBundle)
          {
            k.a.a.m.StringBuilder.append(paramBundle);
          }
        }
      }
    }
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Connection failed: ConnectionResult.getErrorCode() = ");
    localStringBuilder.append(paramConnectionResult.getErrorCode());
    localStringBuilder.toString();
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    mConnection.connect();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131493294);
    executor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    context = ((Toolbar)findViewById(2131297768));
    f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, context, true);
    root = context.getRootView();
    mResultCount = ((TextView)root.findViewById(2131297758));
    index = k.a.a.e.System.getInstance(this);
    this$0 = new k.a.a.m.f(this);
    from = ((TextView)findViewById(2131297627));
    date = ((TextView)findViewById(2131296723));
    description = ((TextView)findViewById(2131297750));
    url = "";
    status = false;
    try
    {
      paramBundle = getIntent().getStringExtra("notifId");
      if (paramBundle != null)
      {
        k.a.a.e.System localSystem = index;
        localSystem.set(paramBundle);
        k.a.a.m.Log.update(this, getIntent().getStringExtra("campaignId"), "Notification Clicked", "clicked", "Notification");
      }
    }
    catch (Exception paramBundle)
    {
      k.a.a.m.StringBuilder.append(paramBundle);
    }
    try
    {
      paramBundle = getIntent().getStringExtra("fromInfoServices");
      if (paramBundle != null)
      {
        boolean bool = paramBundle.equalsIgnoreCase("true");
        if (bool) {
          status = true;
        }
      }
    }
    catch (Exception paramBundle)
    {
      k.a.a.m.StringBuilder.append(paramBundle);
    }
    init();
    if (status)
    {
      view.setVisibility(8);
      fab.setVisibility(8);
      mMenuButton.setVisibility(8);
      drawer.setDrawerLockMode(1);
    }
    else
    {
      a();
      view.setVisibility(0);
      fab.setVisibility(0);
      mMenuButton.setVisibility(0);
    }
    onCreate();
    update();
    initialize();
    show();
    disconnect();
    provider = new LocationRequest().setPriority(100).setInterval(10000L).setFastestInterval(1000L);
    try
    {
      paramBundle = new nx(this);
      protocol = (Handler)paramBundle;
    }
    catch (Exception paramBundle)
    {
      k.a.a.m.StringBuilder.append(paramBundle);
    }
    try
    {
      paramBundle = new yx(this);
      connection_timeout = (Handler)paramBundle;
    }
    catch (Exception paramBundle)
    {
      k.a.a.m.StringBuilder.append(paramBundle);
    }
    fab.setOnClickListener((View.OnClickListener)new Jx(this));
    mMenuButton.setOnClickListener((View.OnClickListener)new Ux(this));
    view.setOnClickListener((View.OnClickListener)new ey(this));
    mProgressBar.setOnClickListener((View.OnClickListener)new fy(this));
    handler.setOnClickListener((View.OnClickListener)new gy(this));
    current.setOnClickListener((View.OnClickListener)new hy(this));
  }
  
  public void onCreate(String paramString1, String paramString2)
  {
    this$0.append(k.a.a.m.f.app, paramString1);
    this$0.append(k.a.a.m.f.m_ProgressBar, paramString2);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDisconnect(String paramString)
  {
    runOnUiThread((Runnable)new cy(this, paramString));
  }
  
  public void onHideCustomView()
  {
    y.onHideCustomView();
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramLocation.getLatitude());
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramLocation.getLongitude());
      paramLocation = ((StringBuilder)localObject).toString();
      localObject = y.a;
      append("S", paramLocation, (String)localObject);
    }
    catch (Exception paramLocation)
    {
      k.a.a.m.StringBuilder.append(paramLocation);
    }
    paramLocation = LocationServices.FusedLocationApi;
    Object localObject = mConnection;
    try
    {
      paramLocation.removeLocationUpdates((GoogleApiClient)localObject, this);
      return;
    }
    catch (Exception paramLocation)
    {
      k.a.a.m.StringBuilder.append(paramLocation);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (getIntent().getExtras().getString("service_id") != null)
    {
      z = true;
      ((WebView)a).clearHistory();
      onCreate();
      update();
    }
    try
    {
      paramIntent = getIntent().getStringExtra("notifId");
      if (paramIntent != null)
      {
        k.a.a.e.System.getInstance(this).set(paramIntent);
        k.a.a.m.Log.update(this, getIntent().getStringExtra("campaignId"), "Notification Clicked", "clicked", "Notification");
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
  
  public String onPostExecute(String paramString)
  {
    Object localObject3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    Object localObject1 = paramString.substring(paramString.indexOf("/") + 1, paramString.indexOf(";"));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(".");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = new File((File)localObject3, (String)localObject2);
    try
    {
      boolean bool = ((File)localObject3).exists();
      if (!bool) {
        ((File)localObject3).mkdirs();
      }
      bool = ((File)localObject1).exists();
      if (!bool) {
        ((File)localObject1).createNewFile();
      }
      int m = paramString.indexOf(",");
      localObject3 = Base64.decode(paramString.substring(m + 1), 0);
      Object localObject4 = new FileOutputStream((File)localObject1);
      ((FileOutputStream)localObject4).write((byte[])localObject3);
      ((FileOutputStream)localObject4).close();
      localObject3 = ((File)localObject1).toString();
      localObject4 = new fx(this);
      localObject4 = (MediaScannerConnection.OnScanCompletedListener)localObject4;
      MediaScannerConnection.scanFile(this, new String[] { localObject3 }, null, (MediaScannerConnection.OnScanCompletedListener)localObject4);
      m = paramString.indexOf(":");
      paramString = paramString.substring(m + 1, paramString.indexOf("/"));
      localObject3 = new Intent();
      ((Intent)localObject3).setAction("android.intent.action.VIEW");
      ((Intent)localObject3).addFlags(1);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(getPackageName());
      ((StringBuilder)localObject4).append(".fileprovider");
      localObject4 = FileProvider.getUriForFile(this, ((StringBuilder)localObject4).toString(), (File)localObject1);
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramString);
      ((StringBuilder)localObject5).append("/*");
      ((Intent)localObject3).setDataAndType((Uri)localObject4, ((StringBuilder)localObject5).toString());
      localObject5 = PendingIntent.getActivity(this, 0, (Intent)localObject3, 0);
      localObject2 = new NotificationCompat.Builder(this, "in.gov.umang.negd.g2c.notif.channel.downloads").setSmallIcon(2131230827).setContentText(getString(2131755603)).setContentTitle((CharSequence)localObject2).setContentIntent((PendingIntent)localObject5).build();
      flags |= 0x10;
      localObject5 = getSystemService("notification");
      localObject5 = (NotificationManager)localObject5;
      ((NotificationManager)localObject5).notify(85851, (Notification)localObject2);
      new Intent();
      ((Intent)localObject3).setAction("android.intent.action.VIEW");
      ((Intent)localObject3).addFlags(1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("/*");
      ((Intent)localObject3).setDataAndType((Uri)localObject4, ((StringBuilder)localObject2).toString());
      startActivity((Intent)localObject3);
    }
    catch (IOException paramString)
    {
      for (;;) {}
    }
    paramString = new StringBuilder();
    paramString.append("Error writing ");
    paramString.append(localObject1);
    paramString.toString();
    Toast.makeText(getApplicationContext(), 2131755694, 1).show();
    return ((File)localObject1).toString();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    Integer localInteger = Integer.valueOf(0);
    switch (paramInt)
    {
    default: 
      return;
    case 1105: 
    case 1109: 
    case 1111: 
    case 1112: 
    case 1113: 
    case 1124: 
    case 1125: 
    case 1132: 
    case 1137: 
    case 1138: 
    case 1139: 
    case 1143: 
    case 1147: 
    case 1149: 
    case 1152: 
      return;
    case 1153: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        d.getDigilockerDocument(STROKE, c);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755558, this);
      return;
    case 1151: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        b.downloadPDF(v.j, v.i);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755558, this);
      return;
    case 1150: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        e.checkRegisteredNumber(c);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755548, this);
      try
      {
        paramArrayOfString = new JSONObject();
        paramArrayOfString.put("status", "f");
        paramArrayOfString.put("message", "permission_denied");
        setTitle(paramArrayOfString.toString());
        return;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    case 1148: 
      localHashMap = new HashMap();
      localHashMap.put("android.permission.READ_CALL_LOG", localInteger);
      localHashMap.put("android.permission.READ_CONTACTS", localInteger);
      localHashMap.put("android.permission.READ_PHONE_STATE", localInteger);
      paramInt = 0;
      while (paramInt < paramArrayOfString.length)
      {
        localHashMap.put(paramArrayOfString[paramInt], Integer.valueOf(paramArrayOfInt[paramInt]));
        paramInt += 1;
      }
      if ((((Integer)localHashMap.get("android.permission.READ_CALL_LOG")).intValue() == 0) && (((Integer)localHashMap.get("android.permission.READ_CONTACTS")).intValue() == 0) && (((Integer)localHashMap.get("android.permission.READ_PHONE_STATE")).intValue() == 0))
      {
        e.setMyCallsStatus(g, c);
        return;
      }
      k.a.a.m.Log.create(this, getResources().getString(2131755267));
      try
      {
        paramArrayOfString = new JSONObject();
        paramArrayOfString.put("status", "f");
        paramArrayOfString.put("message", "permission_denied");
        setTitle(paramArrayOfString.toString());
        return;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    case 1146: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        x.openDocument(mContext, authToken, c);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755558, this);
      try
      {
        paramArrayOfString = new JSONObject();
        paramArrayOfString.put("status", "f");
        paramArrayOfString.put("message", "permission_denied");
        setTitle(paramArrayOfString.toString());
        return;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    case 1145: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        x.downloadFile(mContext, authToken, c);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755558, this);
      try
      {
        paramArrayOfString = new JSONObject();
        paramArrayOfString.put("status", "f");
        paramArrayOfString.put("message", "permission_denied");
        setTitle(paramArrayOfString.toString());
        return;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    case 1144: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        x.deleteDocument(mContext, authToken, c);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755552, this);
      try
      {
        paramArrayOfString = new JSONObject();
        paramArrayOfString.put("status", "f");
        paramArrayOfString.put("message", "permission_denied");
        setTitle(paramArrayOfString.toString());
        return;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    case 1142: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        b.f();
        return;
      }
      setText(v.h, "F");
      k.a.a.m.Log.showDialog(this, getResources().getString(2131755558));
      return;
    case 1141: 
      localHashMap = new HashMap();
      localHashMap.put("android.permission.READ_SMS", localInteger);
      localHashMap.put("android.permission.READ_PHONE_STATE", localInteger);
      localHashMap.put("android.permission.READ_CONTACTS", localInteger);
      paramInt = 0;
      while (paramInt < paramArrayOfString.length)
      {
        localHashMap.put(paramArrayOfString[paramInt], Integer.valueOf(paramArrayOfInt[paramInt]));
        paramInt += 1;
      }
      if ((((Integer)localHashMap.get("android.permission.READ_SMS")).intValue() == 0) && (((Integer)localHashMap.get("android.permission.READ_PHONE_STATE")).intValue() == 0) && (((Integer)localHashMap.get("android.permission.READ_CONTACTS")).intValue() == 0))
      {
        e.getSMSLogDetail(c, g);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755556, this);
      try
      {
        paramArrayOfString = new JSONObject();
        paramArrayOfString.put("status", "f");
        paramArrayOfString.put("message", "permission_denied");
        remove(paramArrayOfString.toString());
        return;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    case 1140: 
      localHashMap = new HashMap();
      localHashMap.put("android.permission.READ_CALL_LOG", localInteger);
      localHashMap.put("android.permission.READ_CONTACTS", localInteger);
      paramInt = 0;
      while (paramInt < paramArrayOfString.length)
      {
        localHashMap.put(paramArrayOfString[paramInt], Integer.valueOf(paramArrayOfInt[paramInt]));
        paramInt += 1;
      }
      if ((((Integer)localHashMap.get("android.permission.READ_CALL_LOG")).intValue() == 0) && (((Integer)localHashMap.get("android.permission.READ_CONTACTS")).intValue() == 0))
      {
        e.getCallLogNumber(c, g);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755549, this);
      try
      {
        paramArrayOfString = new JSONObject();
        paramArrayOfString.put("status", "f");
        paramArrayOfString.put("message", "permission_denied");
        setTitle(paramArrayOfString.toString());
        return;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    case 1136: 
      localHashMap = new HashMap();
      localHashMap.put("android.permission.SEND_SMS", localInteger);
      localHashMap.put("android.permission.READ_PHONE_STATE", localInteger);
      paramInt = 0;
      while (paramInt < paramArrayOfString.length)
      {
        localHashMap.put(paramArrayOfString[paramInt], Integer.valueOf(paramArrayOfInt[paramInt]));
        paramInt += 1;
      }
      if ((((Integer)localHashMap.get("android.permission.SEND_SMS")).intValue() == 0) && (((Integer)localHashMap.get("android.permission.READ_PHONE_STATE")).intValue() == 0))
      {
        e.sendSMS(c, g);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755554, this);
      try
      {
        paramArrayOfString = new JSONObject();
        paramArrayOfString.put("status", "f");
        paramArrayOfString.put("message", "permission_denied");
        setTitle(paramArrayOfString.toString());
        return;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    case 1135: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        e.getOperatorList(c);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755548, this);
      try
      {
        paramArrayOfString = new JSONObject();
        paramArrayOfString.put("status", "f");
        paramArrayOfString.put("message", "permission_denied");
        setTitle(paramArrayOfString.toString());
        return;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    case 1134: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        e.startOTPAutoRead(c, g);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755550, this);
      try
      {
        paramArrayOfString = new JSONObject();
        paramArrayOfString.put("status", "f");
        paramArrayOfString.put("message", "permission_denied");
        setTitle(paramArrayOfString.toString());
        return;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    case 1133: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        add(r.a, r.b, r.c);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755558, this);
      return;
    case 1131: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        e.hasOTPReadPermission(c);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755551, this);
      try
      {
        paramArrayOfString = new JSONObject();
        paramArrayOfString.put("status", "f");
        paramArrayOfString.put("message", "permission_denied");
        setTitle(paramArrayOfString.toString());
        return;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    case 1130: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        e.sendSMS(c, g);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755553, this);
      try
      {
        paramArrayOfString = new JSONObject();
        paramArrayOfString.put("status", "f");
        paramArrayOfString.put("message", "permission_denied");
        setTitle(paramArrayOfString.toString());
        return;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    case 1129: 
      localHashMap = new HashMap();
      localHashMap.put("android.permission.READ_SMS", localInteger);
      localHashMap.put("android.permission.READ_PHONE_STATE", localInteger);
      localHashMap.put("android.permission.READ_CONTACTS", localInteger);
      paramInt = 0;
      while (paramInt < paramArrayOfString.length)
      {
        localHashMap.put(paramArrayOfString[paramInt], Integer.valueOf(paramArrayOfInt[paramInt]));
        paramInt += 1;
      }
      if ((((Integer)localHashMap.get("android.permission.READ_SMS")).intValue() == 0) && (((Integer)localHashMap.get("android.permission.READ_PHONE_STATE")).intValue() == 0) && (((Integer)localHashMap.get("android.permission.READ_CONTACTS")).intValue() == 0))
      {
        e.getSMSLogs(c, g);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755555, this);
      try
      {
        paramArrayOfString = new JSONObject();
        paramArrayOfString.put("status", "f");
        paramArrayOfString.put("message", "permission_denied");
        remove(paramArrayOfString.toString());
        return;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    case 1128: 
      localHashMap = new HashMap();
      localHashMap.put("android.permission.READ_CALL_LOG", localInteger);
      localHashMap.put("android.permission.READ_CONTACTS", localInteger);
      paramInt = 0;
      while (paramInt < paramArrayOfString.length)
      {
        localHashMap.put(paramArrayOfString[paramInt], Integer.valueOf(paramArrayOfInt[paramInt]));
        paramInt += 1;
      }
      if ((((Integer)localHashMap.get("android.permission.READ_CALL_LOG")).intValue() == 0) && (((Integer)localHashMap.get("android.permission.READ_CONTACTS")).intValue() == 0))
      {
        e.getCallLogs(c, g);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755549, this);
      try
      {
        paramArrayOfString = new JSONObject();
        paramArrayOfString.put("status", "f");
        paramArrayOfString.put("message", "permission_denied");
        setTitle(paramArrayOfString.toString());
        return;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    case 1127: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        d.getDocument(c, TAG, id, P, G, F, S, V);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755552, this);
      return;
    case 1126: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        paramArrayOfString = r.e;
        paramArrayOfInt = r.d;
        try
        {
          paramArrayOfInt = paramArrayOfInt.split(",");
          paramArrayOfInt = paramArrayOfInt[1];
          execute(paramArrayOfString, paramArrayOfInt, "excel");
          return;
        }
        catch (Exception paramArrayOfString)
        {
          k.a.a.m.StringBuilder.append(paramArrayOfString);
          return;
        }
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755558, this);
      return;
    case 1123: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        d.getSignatureFile(c, TAG);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755552, this);
      return;
    case 1122: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        d.getPhotoFile(c, TAG);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755552, this);
      return;
    case 1121: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        d.proofImage(c, TAG);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755552, this);
      return;
    case 1120: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        execute(r.n, r.m.split(",")[1]);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755558, this);
      return;
    case 1119: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        setTitle();
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755546, this);
      return;
    case 1118: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        d();
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755546, this);
      return;
    case 1117: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        c();
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755558, this);
      return;
    case 1116: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        b.g();
        return;
      }
      setText(v.h, "F");
      k.a.a.m.Log.showDialog(this, getResources().getString(2131755558));
      return;
    case 1115: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        execute(r.e, r.f);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755558, this);
      return;
    case 1114: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        paramArrayOfString = r.e;
        paramArrayOfInt = r.d;
        try
        {
          paramArrayOfInt = paramArrayOfInt.split(",");
          paramArrayOfInt = paramArrayOfInt[1];
          execute(paramArrayOfString, paramArrayOfInt, "pdf");
          return;
        }
        catch (Exception paramArrayOfString)
        {
          k.a.a.m.StringBuilder.append(paramArrayOfString);
          return;
        }
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755558, this);
      return;
    case 1110: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        a(r.e, r.d.split(",")[1]);
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755558, this);
      return;
    case 1108: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        b.a();
        return;
      }
      add("FAIL", v.g);
      k.a.a.m.Log.showDialog(this, getResources().getString(2131755557));
      return;
    case 1107: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        N.b();
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755552, this);
      return;
    case 1106: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        b.e();
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755558, this);
      return;
    case 1104: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        b.c();
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755552, this);
      return;
    case 1103: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        b.b();
        return;
      }
      paramArrayOfString = new JSONObject();
      try
      {
        paramArrayOfString.put("status", "F");
      }
      catch (Exception paramArrayOfInt)
      {
        k.a.a.m.StringBuilder.append(paramArrayOfInt);
      }
      paramArrayOfInt = new JSONObject();
      try
      {
        paramArrayOfString.put("pd", paramArrayOfInt);
      }
      catch (Exception paramArrayOfInt)
      {
        k.a.a.m.StringBuilder.append(paramArrayOfInt);
      }
      add("F", paramArrayOfString.toString(), v.d);
      k.a.a.m.Log.showDialog(this, getResources().getString(2131755558));
      return;
    case 1102: 
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        L.a();
        return;
      }
      append("F", "", y.a);
      k.a.a.m.Log.showDialog(this, getResources().getString(2131755547));
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("android.permission.CAMERA", localInteger);
    localHashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", localInteger);
    paramInt = 0;
    while (paramInt < paramArrayOfString.length)
    {
      localHashMap.put(paramArrayOfString[paramInt], Integer.valueOf(paramArrayOfInt[paramInt]));
      paramInt += 1;
    }
    if ((((Integer)localHashMap.get("android.permission.CAMERA")).intValue() == 0) && (((Integer)localHashMap.get("android.permission.WRITE_EXTERNAL_STORAGE")).intValue() == 0))
    {
      N.a();
      return;
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755546, this);
  }
  
  public void onResume()
  {
    super.onResume();
    registerNetworkReceiver();
    if (!k.a.a.m.Log.check(this)) {
      init("", true);
    }
  }
  
  public void onResume(String paramString)
  {
    CustomAdvancedWebView localCustomAdvancedWebView = a;
    paramString = new rx(this, paramString);
    ((WebView)localCustomAdvancedWebView).post((Runnable)paramString);
  }
  
  public void onResume(String paramString1, String paramString2)
  {
    CustomAdvancedWebView localCustomAdvancedWebView = a;
    paramString1 = new sx(this, paramString2, paramString1);
    ((WebView)localCustomAdvancedWebView).post((Runnable)paramString1);
  }
  
  public void onResume(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5)
  {
    if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0)
    {
      CustomAdvancedWebView.a(this, paramString1, paramString2);
      return;
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755277, this);
  }
  
  public void onServiceConnected()
  {
    doInBackground();
  }
  
  public void onStart()
  {
    super.onStart();
    mConnection.connect();
  }
  
  public void onStop()
  {
    super.onStop();
    if (mConnection.isConnected())
    {
      FusedLocationProviderApi localFusedLocationProviderApi = LocationServices.FusedLocationApi;
      GoogleApiClient localGoogleApiClient = mConnection;
      try
      {
        localFusedLocationProviderApi.removeLocationUpdates(localGoogleApiClient, this);
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      mConnection.disconnect();
    }
  }
  
  public void open(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = ((UsbManager)getSystemService("usb")).getDeviceList();
    paramString3 = ((HashMap)localObject).values().iterator();
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("");
    localStringBuilder.append(((HashMap)localObject).size());
    localStringBuilder.toString();
    while (paramString3.hasNext())
    {
      localObject = (UsbDevice)paramString3.next();
      if ((String.valueOf(((UsbDevice)localObject).getProductId()).equalsIgnoreCase("4101")) && (String.valueOf(((UsbDevice)localObject).getVendorId()).equalsIgnoreCase("11279")) && ("MANTRA".equalsIgnoreCase(paramString1))) {
        runOnUiThread((Runnable)new Xx(this, (UsbDevice)localObject, paramString2));
      } else if ((String.valueOf(((UsbDevice)localObject).getProductId()).equalsIgnoreCase("71")) && (String.valueOf(((UsbDevice)localObject).getVendorId()).equalsIgnoreCase("1947")) && ("MORPHO".equalsIgnoreCase(paramString1))) {
        runOnUiThread((Runnable)new Yx(this, (UsbDevice)localObject, paramString2));
      } else {
        runOnUiThread((Runnable)new Zx(this, paramString1));
      }
    }
  }
  
  public void remove(String paramString)
  {
    CustomAdvancedWebView localCustomAdvancedWebView = a;
    paramString = new tx(this, paramString);
    ((WebView)localCustomAdvancedWebView).post((Runnable)paramString);
  }
  
  public void remove(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    runOnUiThread((Runnable)new Mx(this, paramString1, paramString2, paramString3, paramString4));
  }
  
  public void search(String paramString)
  {
    mResultCount.setText(paramString);
  }
  
  public void setMainText(int paramInt, String paramString1, String paramString2) {}
  
  public void setText(String paramString1, String paramString2)
  {
    runOnUiThread((Runnable)new Rx(this, paramString1, paramString2));
  }
  
  public void setTitle()
  {
    title = new M(this);
    title.a();
  }
  
  public void setTitle(String paramString)
  {
    CustomAdvancedWebView localCustomAdvancedWebView = a;
    paramString = new qx(this, paramString);
    ((WebView)localCustomAdvancedWebView).post((Runnable)paramString);
  }
  
  public void showProgressDialog()
  {
    mProgressDialog = new ProgressDialog(this);
    mProgressDialog.setMessage(getResources().getString(2131755614));
    mProgressDialog.setIndeterminate(true);
    mProgressDialog.setProgressStyle(1);
    mProgressDialog.setCancelable(false);
    mProgressDialog.setProgressNumberFormat(null);
    mProgressDialog.setProgressPercentFormat(null);
    mProgressDialog.setOnCancelListener((DialogInterface.OnCancelListener)new Vx(this));
    mProgressDialog.show();
  }
  
  public void start(String paramString)
  {
    paramString = ((UsbManager)getSystemService("usb")).getDeviceList();
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("");
    localStringBuilder.append(paramString.size());
    localStringBuilder.toString();
    if (paramString.size() > 0)
    {
      start();
      return;
    }
    runOnUiThread((Runnable)new Wx(this));
  }
  
  public void start(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = ((UsbManager)getSystemService("usb")).getDeviceList();
    paramString3 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("");
    paramString3.append(paramString1.size());
    paramString3.toString();
    if (paramString1.size() > 0)
    {
      out = paramString2;
      try
      {
        paramString1 = new Intent("in.gov.uidai.rdservice.fp.INFO");
        int m = type;
        startActivityForResult(paramString1, m);
        MyApplication.started = true;
        return;
      }
      catch (Exception paramString1)
      {
        paramString2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("ERROR === ");
        paramString2.append(paramString1.toString());
        paramString2.toString();
        return;
      }
      catch (ActivityNotFoundException paramString1)
      {
        paramString2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("ERROR === ");
        paramString2.append(paramString1.toString());
        paramString2.toString();
        Toast.makeText(this, getResources().getString(2131755326), 1).show();
        return;
      }
    }
    runOnUiThread((Runnable)new _x(this));
  }
  
  public void startActivity(String paramString) {}
  
  public Bitmap transform(Bitmap paramBitmap, int paramInt)
  {
    int m = paramBitmap.getWidth();
    int i1 = paramBitmap.getHeight();
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("");
    localStringBuilder.append(paramBitmap.getHeight());
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramBitmap.getWidth());
    localStringBuilder.toString();
    float f1 = m / i1;
    if (f1 > 1.0F)
    {
      m = (int)(paramInt / f1);
      i1 = paramInt;
    }
    else
    {
      float f2 = paramInt;
      i1 = (int)(f2 * f1);
      m = paramInt;
    }
    return Bitmap.createScaledBitmap(paramBitmap, i1, m, true);
  }
  
  public void update(String paramString)
  {
    if (Build.VERSION.SDK_INT > 19)
    {
      localCustomAdvancedWebView = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(r.g);
      localStringBuilder.append("(\"");
      localStringBuilder.append(paramString.replaceAll("\\s+", ""));
      localStringBuilder.append("\")");
      paramString = localStringBuilder.toString();
      ((WebView)localCustomAdvancedWebView).evaluateJavascript(paramString, null);
      return;
    }
    CustomAdvancedWebView localCustomAdvancedWebView = a;
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("javascript:");
    localStringBuilder.append(r.g);
    localStringBuilder.append("(\"");
    localStringBuilder.append(paramString.replaceAll("\\s+", ""));
    localStringBuilder.append("\")");
    localCustomAdvancedWebView.loadUrl(localStringBuilder.toString());
  }
}
