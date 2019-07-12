package org.yaxim.androidclient.chat;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.preference.PreferenceManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.FileProvider;
import android.support.v4.package_7.ActivityCompat;
import android.support.v4.package_7.FragmentActivity;
import android.support.v4.package_7.LoaderManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.Toolbar;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView.a;
import in.spicedigital.umang.application.MyApplication;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import k.a.a.c.i;
import k.a.a.l.b;
import k.a.a.m.Fa;
import k.a.a.m.La;
import k.a.a.m.Log;
import org.json.JSONObject;
import org.yaxim.androidclient.BaseActivity;
import org.yaxim.androidclient.IXMPPRosterCallback.Stub;
import org.yaxim.androidclient.XMPPRosterServiceAdapter;
import org.yaxim.androidclient.data.ChatProvider;
import org.yaxim.androidclient.data.RosterProvider;
import org.yaxim.androidclient.data.YaximConfiguration;
import org.yaxim.androidclient.model.ButtonAction;
import org.yaxim.androidclient.model.Element;
import org.yaxim.androidclient.model.QuickReply;
import org.yaxim.androidclient.service.XMPPService;
import org.yaxim.androidclient.util.ConnectionState;
import org.yaxim.androidclient.util.StatusMode;
import p.H;
import p.L;
import p.M;
import p.M.a;
import p.O;
import p.O.a;
import p.U.a;
import p.Y;
import p.k;
import p.n;
import p.n.a;
import support.android.v4.content.ContextCompat;
import support.android.v4.content.CursorLoader;
import support.android.v4.content.Loader;

public class ChatWindow
  extends BaseActivity
  implements View.OnKeyListener, TextWatcher, LoaderManager.LoaderCallbacks<Cursor>
{
  public static final int CHAT_MSG_LOADER = 0;
  public static final int DELAY_NEWMSG = 2000;
  public static final String INTENT_EXTRA_MESSAGE;
  public static final String INTENT_EXTRA_USERNAME = f.sufficientlysecure.rootcommands.util.StringBuilder.get(ChatWindow.class, new StringBuilder(), ".username");
  public static final L MEDIA_TYPE_PNG = L.a("image/*");
  public static final String PAGE_KEY = "yaxim.ChatWindow";
  public static final String[] PROJECTION_FROM;
  public static final int[] PROJECTION_TO;
  public static final String[] STATUS_QUERY;
  public ArrayList<ArrayList<ButtonAction>> arrayListActionToSend;
  public ArrayList<ArrayList<Element>> arrayListElementToSend;
  public ArrayList<ArrayList<QuickReply>> arrayListQuickReplyToSend;
  public ArrayList<String> arrayListTimeStamp;
  public ChatWindow.DisconnectReceiver disconnectReceiver;
  public boolean endChat = false;
  public String fileSelectedPath = "";
  public boolean firstSend = true;
  public int flag;
  public boolean flagUserChanged = false;
  public Handler handler = new Handler();
  public boolean historyVisible = false;
  public ArrayList<Integer> idList;
  public boolean initConCalled;
  public ImageView mAttachButton = null;
  public Uri mCapturedImageURI;
  public int mChatFontSize;
  public EditText mChatInput = null;
  public YaximConfiguration mConfig;
  public ContentObserver mContactObserver = (ContentObserver)new ChatWindow.ContactObserver(this);
  public final HashSet<Integer> mImageFailedMessages = new HashSet();
  public f.l.a.b.f mImageLoader;
  public final HashSet<Integer> mImageMessages = new HashSet();
  public ProgressBar mLoadingProgress;
  public Handler mMarkHandler;
  public Runnable mMarkRunnable = (Runnable)new ChatWindow.1(this);
  public HandlerThread mMarkThread;
  public final HashSet<Integer> mReadMessages = new HashSet();
  public ContentObserver mRosterObserver = (ContentObserver)new ChatWindow.RosterObserver(this);
  public ImageView mSendButton = null;
  public XMPPChatServiceAdapter mServiceAdapter;
  public ServiceConnection mServiceConnection;
  public Intent mServiceIntent;
  public boolean mShowOrHide = true;
  public ImageView mStatusMode;
  public TextView mSubTitle;
  public TextView mTitle;
  public String mUserScreenName = null;
  public PowerManager.WakeLock mWakeLock;
  public String mWithJabberID = null;
  public Handler mainHandler = new Handler();
  public ArrayList<ButtonAction> messageActionButton;
  public ArrayList<Element> messageElements;
  public ArrayList<QuickReply> messageQuickReply;
  public ArrayList<Object> messagesListObject;
  public int mobileValidation = 0;
  public String msgToSend = "";
  public Toolbar mtoolbar;
  public ChatWindow.ChatAdapter multipleRowAdapter;
  public java.util.List<String> multipleRowModelList = new ArrayList();
  public RecyclerView multipleRowRecyclerView;
  public boolean needs_to_bind_unbind = false;
  public BroadcastReceiver networkReceiver;
  public RelativeLayout network_lay_container;
  public k.a.a.m.f pref;
  public IXMPPRosterCallback.Stub rosterCallback;
  public XMPPRosterServiceAdapter serviceAdapter;
  public String text = "";
  public String textActionButton = "";
  public TextView titleText;
  public Toolbar toolbar;
  public TextView typingText;
  public k uploadCall;
  public boolean userStartedTyping = false;
  public View view;
  
  static
  {
    INTENT_EXTRA_MESSAGE = f.sufficientlysecure.rootcommands.util.StringBuilder.get(ChatWindow.class, new StringBuilder(), ".message");
    PROJECTION_FROM = new String[] { "_id", "date", "from_me", "jid", "message", "read", "pid" };
    PROJECTION_TO = new int[] { 2131296498, 2131296499, 2131296502 };
    STATUS_QUERY = new String[] { "alias", "status_mode", "status_message" };
  }
  
  public ChatWindow() {}
  
  private void addHistoryMessageToDb(int paramInt1, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    paramString2 = new ContentValues();
    paramString2.put("from_me", Integer.valueOf(paramInt1));
    paramString2.put("jid", "bot@reporting.umang.gov.in");
    paramString2.put("message", paramString1);
    paramString2.put("read", Integer.valueOf(paramInt2));
    paramString2.put("date", Long.valueOf(paramLong));
    getContentResolver().insert(ChatProvider.CONTENT_URI, paramString2);
  }
  
  private boolean addImageMsgToReadLater(int paramInt)
  {
    f.sufficientlysecure.rootcommands.util.StringBuilder.append("Message Id to read later ", paramInt);
    if (mImageMessages.contains(Integer.valueOf(paramInt))) {
      return false;
    }
    mImageMessages.add(Integer.valueOf(paramInt));
    return true;
  }
  
  private void bindXMPPService()
  {
    Intent localIntent = mServiceIntent;
    ServiceConnection localServiceConnection = mServiceConnection;
    try
    {
      bindService(localIntent, localServiceConnection, 1);
      return;
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
    }
  }
  
  private void checkCameraPermission(Activity paramActivity)
  {
    if ((ContextCompat.checkSelfPermission(paramActivity, "android.permission.CAMERA") == 0) && (ContextCompat.checkSelfPermission(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0))
    {
      openCameraIntent();
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = j;
    if (ContextCompat.checkSelfPermission(paramActivity, "android.permission.CAMERA") != 0) {
      if (ActivityCompat.shouldShowRequestPermissionRationale(paramActivity, "android.permission.CAMERA"))
      {
        i = 1;
      }
      else
      {
        localArrayList.add("android.permission.CAMERA");
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
        localArrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        j = i;
      }
    }
    if (j > 0)
    {
      Log.showDialog(paramActivity, paramActivity.getResources().getString(2131755264));
      return;
    }
    if (localArrayList.size() > 0) {
      ActivityCompat.requestPermissions(paramActivity, (String[])localArrayList.toArray(new String[localArrayList.size()]), 1101);
    }
  }
  
  private void checkGalleryPermissions(Activity paramActivity)
  {
    if (ContextCompat.checkSelfPermission(paramActivity, "android.permission.READ_EXTERNAL_STORAGE") != 0)
    {
      if (ActivityCompat.shouldShowRequestPermissionRationale(paramActivity, "android.permission.READ_EXTERNAL_STORAGE"))
      {
        Log.showDialog(paramActivity, paramActivity.getResources().getString(2131755271));
        return;
      }
      ActivityCompat.requestPermissions(paramActivity, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 1107);
      return;
    }
    openGalleryIntent();
  }
  
  private void clearPrefsBeforeDisconnect()
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this).edit();
    localEditor.putBoolean("is_already_connected", false);
    localEditor.putString("account_jabberID", "");
    YaximConfiguration localYaximConfiguration = mConfig;
    userName = "";
    password = "";
    localEditor.apply();
    org.yaxim.androidclient.util.PreferenceConstants.isExistingUser = false;
    pref.append(k.a.a.m.f.playlist, "false");
    pref.append(k.a.a.m.f.val$name, "");
    pref.append(k.a.a.m.f.val$data, "");
    pref.append(k.a.a.m.f.Value, "false");
  }
  
  /* Error */
  private File copyInputStreamToFile(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 691	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokevirtual 695	android/content/ContextWrapper:getCacheDir	()Ljava/io/File;
    //   11: ldc_w 697
    //   14: invokespecial 700	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore 6
    //   19: new 702	java/io/FileOutputStream
    //   22: dup
    //   23: aload 6
    //   25: invokespecial 705	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   28: astore 4
    //   30: sipush 1024
    //   33: newarray byte
    //   35: astore 5
    //   37: aload 4
    //   39: astore_3
    //   40: aload_1
    //   41: aload 5
    //   43: invokevirtual 710	java/io/InputStream:read	([B)I
    //   46: istore_2
    //   47: iload_2
    //   48: ifle +18 -> 66
    //   51: aload 4
    //   53: astore_3
    //   54: aload 4
    //   56: aload 5
    //   58: iconst_0
    //   59: iload_2
    //   60: invokevirtual 714	java/io/FileOutputStream:write	([BII)V
    //   63: goto -26 -> 37
    //   66: aload 4
    //   68: invokevirtual 717	java/io/FileOutputStream:close	()V
    //   71: aload_1
    //   72: invokevirtual 718	java/io/InputStream:close	()V
    //   75: aload 6
    //   77: areturn
    //   78: astore_1
    //   79: aload_1
    //   80: invokestatic 559	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   83: aload 6
    //   85: areturn
    //   86: astore 5
    //   88: goto +12 -> 100
    //   91: astore_3
    //   92: goto +47 -> 139
    //   95: astore 5
    //   97: aconst_null
    //   98: astore 4
    //   100: aload 4
    //   102: astore_3
    //   103: aload 5
    //   105: invokestatic 559	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   108: aload 4
    //   110: ifnull +8 -> 118
    //   113: aload 4
    //   115: invokevirtual 717	java/io/FileOutputStream:close	()V
    //   118: aload_1
    //   119: invokevirtual 718	java/io/InputStream:close	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aload_1
    //   126: invokestatic 559	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   129: aconst_null
    //   130: areturn
    //   131: astore 4
    //   133: aload_3
    //   134: astore 5
    //   136: aload 4
    //   138: astore_3
    //   139: aload 5
    //   141: ifnull +8 -> 149
    //   144: aload 5
    //   146: invokevirtual 717	java/io/FileOutputStream:close	()V
    //   149: aload_1
    //   150: invokevirtual 718	java/io/InputStream:close	()V
    //   153: goto +8 -> 161
    //   156: astore_1
    //   157: aload_1
    //   158: invokestatic 559	k/a/a/m/StringBuilder:append	(Ljava/lang/Exception;)V
    //   161: goto +3 -> 164
    //   164: aload_3
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	ChatWindow
    //   0	166	1	paramInputStream	InputStream
    //   46	14	2	i	int
    //   39	15	3	localFileOutputStream1	java.io.FileOutputStream
    //   91	1	3	localThrowable1	Throwable
    //   102	63	3	localObject1	Object
    //   28	86	4	localFileOutputStream2	java.io.FileOutputStream
    //   131	6	4	localThrowable2	Throwable
    //   1	56	5	arrayOfByte	byte[]
    //   86	1	5	localException1	Exception
    //   95	9	5	localException2	Exception
    //   134	11	5	localObject2	Object
    //   17	67	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   66	75	78	java/io/IOException
    //   40	47	86	java/lang/Exception
    //   54	63	86	java/lang/Exception
    //   3	19	91	java/lang/Throwable
    //   19	30	91	java/lang/Throwable
    //   3	19	95	java/lang/Exception
    //   19	30	95	java/lang/Exception
    //   113	118	124	java/io/IOException
    //   118	122	124	java/io/IOException
    //   40	47	131	java/lang/Throwable
    //   54	63	131	java/lang/Throwable
    //   103	108	131	java/lang/Throwable
    //   144	149	156	java/io/IOException
    //   149	153	156	java/io/IOException
  }
  
  private void createChooserDialog()
  {
    Dialog localDialog = f.sufficientlysecure.rootcommands.util.StringBuilder.create(this, 1, 2131492959, true);
    LinearLayout localLinearLayout1 = (LinearLayout)localDialog.findViewById(2131296636);
    LinearLayout localLinearLayout2 = (LinearLayout)localDialog.findViewById(2131296639);
    LinearLayout localLinearLayout3 = (LinearLayout)localDialog.findViewById(2131296638);
    LinearLayout localLinearLayout4 = (LinearLayout)localDialog.findViewById(2131296640);
    LinearLayout localLinearLayout5 = (LinearLayout)localDialog.findViewById(2131296644);
    ((LinearLayout)localDialog.findViewById(2131297421)).setVisibility(8);
    localLinearLayout3.setVisibility(8);
    localLinearLayout4.setVisibility(8);
    localLinearLayout5.setVisibility(8);
    localLinearLayout1.setOnClickListener((View.OnClickListener)new ChatWindow.24(this, localDialog));
    localLinearLayout2.setOnClickListener((View.OnClickListener)new ChatWindow.25(this, localDialog));
  }
  
  private void createListFromCursor(Cursor paramCursor)
  {
    Object localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Histrory Visible Boolean =======");
    ((StringBuilder)localObject1).append(historyVisible);
    ((StringBuilder)localObject1).toString();
    if (historyVisible) {
      flag = (messagesListObject.size() - 1);
    } else {
      flag = 0;
    }
    if (paramCursor.moveToFirst()) {
      do
      {
        flag += 1;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(flag);
        ((StringBuilder)localObject1).append(" ================== ");
        ((StringBuilder)localObject1).append(messagesListObject.size());
        ((StringBuilder)localObject1).toString();
        int i;
        int j;
        String str1;
        Object localObject2;
        if ((flag <= messagesListObject.size()) && (messagesListObject.size() - flag != 1))
        {
          i = messagesListObject.size();
          j = flag;
          if ((i > j) && ((messagesListObject.get(j) instanceof ChatWindow.Message)))
          {
            localObject1 = (ChatWindow.Message)messagesListObject.get(flag - 1);
            if ((((ChatWindow.Message)localObject1).getDelivery_status() == 0) || (((ChatWindow.Message)localObject1).getDelivery_status() == 3))
            {
              i = paramCursor.getInt(paramCursor.getColumnIndex("read"));
              str1 = paramCursor.getString(paramCursor.getColumnIndex("message"));
              localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("1192======");
              ((StringBuilder)localObject2).append(((ChatWindow.Message)localObject1).getMessage());
              ((StringBuilder)localObject2).append(" ==== ");
              ((StringBuilder)localObject2).append(str1);
              ((StringBuilder)localObject2).append("====DLS====");
              ((StringBuilder)localObject2).append(((ChatWindow.Message)localObject1).getDelivery_status());
              ((StringBuilder)localObject2).append("====");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).toString();
              if ((i != 0) || (i != 3))
              {
                ((ChatWindow.Message)localObject1).setDelivery_status(i);
                updateRecycleView(flag - 1);
              }
              if ((((ChatWindow.Message)localObject1).getMessage().contains("IMAGE#")) && (i == 3)) {
                updateRecycleViewForRetry(flag - 1);
              }
            }
          }
          else
          {
            i = messagesListObject.size();
            j = flag;
            if (i == j)
            {
              localObject1 = (ChatWindow.Message)messagesListObject.get(j - 1);
              i = paramCursor.getInt(paramCursor.getColumnIndex("read"));
              str1 = paramCursor.getString(paramCursor.getColumnIndex("message"));
              localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("1203===");
              ((StringBuilder)localObject2).append(((ChatWindow.Message)localObject1).getMessage());
              ((StringBuilder)localObject2).append(" ==== ");
              ((StringBuilder)localObject2).append(str1);
              ((StringBuilder)localObject2).append(" ======DLS=====");
              ((StringBuilder)localObject2).append(((ChatWindow.Message)localObject1).getDelivery_status());
              ((StringBuilder)localObject2).append("===");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).toString();
              if (((ChatWindow.Message)localObject1).getDelivery_status() != i) {
                ((ChatWindow.Message)localObject1).setDelivery_status(i);
              }
              if (i == 1)
              {
                ((ChatWindow.Message)localObject1).setDelivery_status(i);
                updateRecycleView(flag - 1);
              }
              if ((((ChatWindow.Message)localObject1).getMessage().contains("IMAGE#")) && (i == 3)) {
                updateRecycleViewForRetry(flag - 1);
              }
            }
          }
        }
        else
        {
          long l = paramCursor.getLong(paramCursor.getColumnIndex("date"));
          i = paramCursor.getInt(paramCursor.getColumnIndex("_id"));
          str1 = getDateString(l);
          localObject2 = paramCursor.getString(paramCursor.getColumnIndex("message"));
          boolean bool;
          if (paramCursor.getInt(paramCursor.getColumnIndex("from_me")) == 1) {
            bool = true;
          } else {
            bool = false;
          }
          String str2 = paramCursor.getString(paramCursor.getColumnIndex("jid"));
          String str3 = paramCursor.getString(paramCursor.getColumnIndex("pid"));
          j = paramCursor.getInt(paramCursor.getColumnIndex("read"));
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("1131=============");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(" =========DLS========");
          ((StringBuilder)localObject1).append(j);
          ((StringBuilder)localObject1).toString();
          localObject1 = new ChatWindow.Message(this);
          ((ChatWindow.Message)localObject1).set_id(i);
          ((ChatWindow.Message)localObject1).setDateMilliseconds(l);
          ((ChatWindow.Message)localObject1).setDate(str1);
          ((ChatWindow.Message)localObject1).setMessage((String)localObject2);
          ((ChatWindow.Message)localObject1).setFrom_me(bool);
          ((ChatWindow.Message)localObject1).setJid(str2);
          ((ChatWindow.Message)localObject1).setDelivery_status(j);
          ((ChatWindow.Message)localObject1).setPacketid(str3);
          str1 = getDate(System.currentTimeMillis(), "dd/MM/yyyy");
          localObject2 = getDate(l, "dd/MM/yyyy");
          ((ChatWindow.Message)localObject1).setDateTime((String)localObject2);
          if (str1.equalsIgnoreCase((String)localObject2)) {
            ((ChatWindow.Message)localObject1).isShowDate(Boolean.valueOf(true));
          }
          if (!idList.contains(Integer.valueOf(i)))
          {
            idList.add(Integer.valueOf(i));
            if (!((ChatWindow.Message)localObject1).getMessage().contains("~~~")) {
              ((AsyncTask)new ChatWindow.Parse(this)).execute(new ChatWindow.Message[] { localObject1 });
            }
          }
        }
      } while (paramCursor.moveToNext());
    }
  }
  
  private void createUICallback()
  {
    rosterCallback = new ChatWindow.19(this);
  }
  
  private void fileUpload(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        localObject1 = getSystemService("power");
        localObject1 = (PowerManager)localObject1;
        localObject1 = ((PowerManager)localObject1).newWakeLock(1, getClass().getName());
        mWakeLock = ((PowerManager.WakeLock)localObject1);
        localObject1 = mWakeLock;
        ((PowerManager.WakeLock)localObject1).acquire();
        int i = paramString1.lastIndexOf("/");
        localObject2 = paramString1.substring(i + 1);
      }
      catch (Exception paramString1)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        Bitmap.CompressFormat localCompressFormat;
        k.a.a.m.StringBuilder.append((Exception)paramString1);
        return;
      }
      try
      {
        localObject1 = rescaleImage(this, Uri.parse(paramString1), 500);
        localObject3 = new ByteArrayOutputStream();
        localCompressFormat = Bitmap.CompressFormat.JPEG;
        ((Bitmap)localObject1).compress(localCompressFormat, 60, (OutputStream)localObject3);
        localObject1 = copyInputStreamToFile(new ByteArrayInputStream(((ByteArrayOutputStream)localObject3).toByteArray()));
        paramString1 = (String)localObject1;
      }
      catch (Exception localException) {}
    }
    paramString1 = new File(paramString1);
    localObject1 = new M.a();
    localObject3 = M.e;
    localObject1 = ((M.a)localObject1).a((L)localObject3);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("form-data; name=\"file\"; filename=\"");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("\" ");
    localObject2 = ((StringBuilder)localObject3).toString();
    localObject2 = H.a(new String[] { "Content-Disposition", localObject2 });
    localObject3 = MEDIA_TYPE_PNG;
    paramString1 = ((M.a)localObject1).a((H)localObject2, Y.a((L)localObject3, paramString1));
    localObject1 = pref;
    localObject2 = k.a.a.m.f.this$0;
    paramString1 = paramString1.a("token", ((k.a.a.m.f)localObject1).get((String)localObject2, "")).a();
    paramString1 = new U.a().a("Content-Type", "application/x-www-form-urlencoded").a("X-REQUEST-UV", Log.read()).a("requestid", UUID.randomUUID().toString()).b("https://reporting.umang.gov.in/AgentCallDistribution/file/upload").c(paramString1).a();
    localObject1 = new n.a();
    localObject1 = ((n.a)localObject1).a("*.umang.gov.in", new String[] { "sha256/mPa/P/4ZSRo/xTivFDg5ST6CpKZgfzAsS2g9wTXiE0I=" });
    localObject1 = ((n.a)localObject1).a("*.umang.gov.in", new String[] { "sha256/k2v657xBsOVe1PQRwOsHsw3bsGT2VzIqz5K+59sNQws=" });
    localObject1 = ((n.a)localObject1).a("*.umang.gov.in", new String[] { "sha256/WoiWRyIOVNa9ihaBciRSC7XHjliYS9VwUGOIud4PB18=" });
    localObject1 = ((n.a)localObject1).a("*.umang.gov.in", new String[] { "sha256/0SzLdzRsw2vMo37QKp8OACAWf2odCbQ80t1t4z1EMNA=" });
    localObject1 = ((n.a)localObject1).a("*.umang.gov.in", new String[] { "sha256/9n0izTnSRF+W4W4JTq51avSXkWhQB8duS2bxVLfzXsY=" });
    localObject1 = ((n.a)localObject1).a("*.umang.gov.in", new String[] { "sha256/JbQbUG5JMJUoI6brnx0x3vZF6jilxsapbXGVfjhN8Fg=" });
    localObject1 = ((n.a)localObject1).a("*.umang.gov.in", new String[] { "sha256/njN4rRG+22dNXAi+yb8e3UMypgzPUPHlv4+foULwl1g=" });
    localObject1 = ((n.a)localObject1).a("*.umang.gov.in", new String[] { "sha256/i7WTqTvh0OioIruIfFR4kMPnBqrS2rdiVPl/s2uC/CY=" }).a();
    localObject2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    ((TrustManagerFactory)localObject2).init(null);
    localObject2 = ((TrustManagerFactory)localObject2).getTrustManagers();
    if ((localObject2.length == 1) && ((localObject2[0] instanceof X509TrustManager)))
    {
      localObject2 = (X509TrustManager)localObject2[0];
      localObject3 = new La((X509TrustManager)localObject2);
      localObject1 = new O().u().a((n)localObject1);
      localObject3 = (SSLSocketFactory)localObject3;
      localObject1 = ((O.a)localObject1).a((SSLSocketFactory)localObject3, (X509TrustManager)localObject2);
      localObject2 = TimeUnit.SECONDS;
      localObject1 = ((O.a)localObject1).a(120L, (TimeUnit)localObject2);
      localObject2 = TimeUnit.MINUTES;
      localObject1 = ((O.a)localObject1).b(120L, (TimeUnit)localObject2);
      localObject2 = TimeUnit.SECONDS;
      paramString1 = ((O.a)localObject1).c(120L, (TimeUnit)localObject2).a().a(paramString1);
      uploadCall = paramString1;
      paramString1 = uploadCall;
      paramString1.a(new ChatWindow.26(this, paramString2));
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("Unexpected default trust managers:");
    paramString1.append(Arrays.toString((Object[])localObject2));
    paramString1 = new IllegalStateException(paramString1.toString());
    throw paramString1;
  }
  
  private void getChatHistory()
  {
    new k.a.a.m.f(this);
    Object localObject3;
    Object localObject2;
    try
    {
      localObject3 = Log.execute(this);
      Object localObject1 = localObject3;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(System.currentTimeMillis());
      ((JSONObject)localObject3).put("requestId", localStringBuilder.toString());
      ((JSONObject)localObject3).put("msisdn", new k.a.a.m.System(this).get().get());
      ((JSONObject)localObject3).put("st", "");
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
      localObject2 = null;
    }
    if (localObject2 != null)
    {
      localObject2 = new b((k.a.a.i.List)new ChatWindow.20(this), (JSONObject)localObject2);
      localObject3 = AsyncTask.THREAD_POOL_EXECUTOR;
      ((AsyncTask)localObject2).executeOnExecutor((Executor)localObject3, new Object[0]);
    }
  }
  
  public static String getDate(long paramLong, String paramString)
  {
    paramString = new SimpleDateFormat(paramString, Locale.ENGLISH);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return paramString.format(localCalendar.getTime());
  }
  
  private String getDateString(long paramLong)
  {
    return new SimpleDateFormat("HH:mm", Locale.US).format(new Date(paramLong));
  }
  
  private CharSequence getMessageFromContextMenu(MenuItem paramMenuItem)
  {
    return ((TextView)getMenuInfotargetView.findViewById(2131296502)).getText();
  }
  
  private View.OnClickListener getOnSetFileAttachListener()
  {
    return (View.OnClickListener)new ChatWindow.7(this);
  }
  
  private View.OnClickListener getOnSetListener()
  {
    return (View.OnClickListener)new ChatWindow.6(this);
  }
  
  private ArrayList getSampleArrayList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("Hello, How can i help you?");
    localArrayList.add("Lorem Ipsum text of the printing");
    localArrayList.add("Lorem Ipsum text of the printing");
    localArrayList.add("Lorem Ipsum text of the printing");
    localArrayList.add("Lorem Ipsum text of the printing");
    localArrayList.add("Lorem Ipsum text of the printing");
    localArrayList.add("Lorem Ipsum text of the printing");
    localArrayList.add("Lorem Ipsum text of the printing");
    localArrayList.add("Lorem Ipsum text of the printing");
    localArrayList.add("Lorem Ipsum text of the printing");
    localArrayList.add("Lorem Ipsum text of the printing");
    localArrayList.add("Lorem Ipsum text of the printing");
    localArrayList.add("Lorem Ipsum text of the printing");
    localArrayList.add("Lorem Ipsum text of the printing");
    return localArrayList;
  }
  
  public static boolean isTodaySure(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
  
  private void isUserTyping(boolean paramBoolean)
  {
    if (mServiceAdapter != null)
    {
      XMPPChatServiceAdapter localXMPPChatServiceAdapter = mServiceAdapter;
      String str = mWithJabberID;
      try
      {
        localXMPPChatServiceAdapter.sendPresenceMessage(str, paramBoolean);
        return;
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
    }
  }
  
  public static boolean isYesterday(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong);
    localCalendar1.add(5, -1);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(2) == localCalendar2.get(2)) && (localCalendar1.get(5) == localCalendar2.get(5));
  }
  
  private boolean markAsReadDelayed(int paramInt1, int paramInt2)
  {
    if (mReadMessages.contains(Integer.valueOf(paramInt1))) {
      return false;
    }
    mMarkHandler.removeCallbacks(mMarkRunnable);
    mReadMessages.add(Integer.valueOf(paramInt1));
    mMarkHandler.postDelayed(mMarkRunnable, paramInt2);
    return true;
  }
  
  private void markImageMessageFailedInDb()
  {
    Object localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("markImageMessageFailedInDb ==================== called ");
    ((StringBuilder)localObject1).append(mImageFailedMessages.size());
    ((StringBuilder)localObject1).toString();
    if (mImageFailedMessages.size() == 0) {
      return;
    }
    localObject1 = (HashSet)mImageFailedMessages.clone();
    Uri localUri = Uri.parse("content://in.gov.umang.negd.g2c.in.spice.Chats/chats");
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("_id IN (");
    Object localObject2 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localStringBuilder.append(((Integer)((Iterator)localObject2).next()).intValue());
      localStringBuilder.append(",");
    }
    localStringBuilder.setCharAt(localStringBuilder.length() - 1, ')');
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mImageFailedMessages ==================: ");
    ((StringBuilder)localObject2).append(localStringBuilder);
    ((StringBuilder)localObject2).toString();
    localObject2 = new ContentValues();
    ((ContentValues)localObject2).put("read", Integer.valueOf(3));
    getContentResolver().update(localUri, (ContentValues)localObject2, localStringBuilder.toString(), null);
    mImageFailedMessages.removeAll((Collection)localObject1);
  }
  
  private void markImageMessagesInDb()
  {
    Object localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("markImageMessagesInDb ==================== called ");
    ((StringBuilder)localObject1).append(mImageMessages.size());
    ((StringBuilder)localObject1).toString();
    if (mImageMessages.size() == 0) {
      return;
    }
    localObject1 = (HashSet)mImageMessages.clone();
    Uri localUri = Uri.parse("content://in.gov.umang.negd.g2c.in.spice.Chats/chats");
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("_id IN (");
    Object localObject2 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localStringBuilder.append(((Integer)((Iterator)localObject2).next()).intValue());
      localStringBuilder.append(",");
    }
    localStringBuilder.setCharAt(localStringBuilder.length() - 1, ')');
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("markAsRead ==================: ");
    ((StringBuilder)localObject2).append(localStringBuilder);
    ((StringBuilder)localObject2).toString();
    localObject2 = new ContentValues();
    ((ContentValues)localObject2).put("read", Integer.valueOf(1));
    getContentResolver().update(localUri, (ContentValues)localObject2, localStringBuilder.toString(), null);
    mImageMessages.removeAll((Collection)localObject1);
  }
  
  private void markReadMessagesInDb()
  {
    if (mReadMessages.size() == 0) {
      return;
    }
    HashSet localHashSet = (HashSet)mReadMessages.clone();
    Uri localUri = Uri.parse("content://in.gov.umang.negd.g2c.in.spice.Chats/chats");
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("_id IN (");
    Object localObject = localHashSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder.append(((Integer)((Iterator)localObject).next()).intValue());
      localStringBuilder.append(",");
    }
    localStringBuilder.setCharAt(localStringBuilder.length() - 1, ')');
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("markReadMessagesInDb == ");
    ((StringBuilder)localObject).append(localStringBuilder);
    ((StringBuilder)localObject).toString();
    localObject = new ContentValues();
    ((ContentValues)localObject).put("read", Integer.valueOf(1));
    getContentResolver().update(localUri, (ContentValues)localObject, localStringBuilder.toString(), null);
    mReadMessages.removeAll(localHashSet);
  }
  
  private void onEndChatClick()
  {
    showConfirmExitDialog();
  }
  
  private void registerChatDisconnectReceiver()
  {
    disconnectReceiver = new ChatWindow.DisconnectReceiver(this, null);
    IntentFilter localIntentFilter1 = new IntentFilter("com.toxy.DISCONNECT_CHAT");
    IntentFilter localIntentFilter2 = new IntentFilter("com.typing.status");
    registerReceiver((BroadcastReceiver)disconnectReceiver, localIntentFilter1);
    registerReceiver((BroadcastReceiver)disconnectReceiver, localIntentFilter2);
  }
  
  private void registerNetworkReceiver()
  {
    Fa localFa = new Fa(new ChatWindow.18(this), this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    networkReceiver = ((BroadcastReceiver)localFa.c());
    registerReceiver(networkReceiver, localIntentFilter);
  }
  
  private void registerXMPPService(String paramString)
  {
    mServiceIntent = new Intent(this, XMPPService.class);
    Uri localUri = Uri.parse(mWithJabberID);
    mServiceIntent.setData(localUri);
    mServiceIntent.setAction("org.yaxim.androidclient.XMPPSERVICE");
    mServiceConnection = ((ServiceConnection)new ChatWindow.5(this, paramString));
  }
  
  private void removeChatHistory(String paramString)
  {
    getContentResolver().delete(ChatProvider.CONTENT_URI, "jid = ?", new String[] { paramString });
  }
  
  private void sendEndMsg()
  {
    msgToSend = "end";
    pref.append(k.a.a.m.f.xml, "exit");
    sendEndMessage("userdisconnected", msgToSend, "false");
  }
  
  private void sendExitMsg()
  {
    msgToSend = "userdisconnected";
    pref.append(k.a.a.m.f.xml, "exit");
  }
  
  private void sendInitCon()
  {
    msgToSend = "initconversation";
    pref.append(k.a.a.m.f.xml, "");
    if (!initConCalled)
    {
      sendInitMessage(msgToSend, "false");
      initConCalled = true;
    }
  }
  
  private void sendMessageIfNotNull()
  {
    EditText localEditText = mChatInput;
    try
    {
      boolean bool = TextUtils.isEmpty(localEditText.getText().toString().trim());
      if (!bool)
      {
        localEditText = mChatInput;
        localEditText.getText().toString();
        isUserTyping(false);
        localEditText = mChatInput;
        sendMessage(localEditText.getText().toString().trim(), "true");
        return;
      }
    }
    catch (Exception localException) {}
  }
  
  private void setAttachFileButton()
  {
    mAttachButton = ((ImageView)findViewById(2131296379));
    ChatWindow.7 local7 = new ChatWindow.7(this);
    mAttachButton.setOnClickListener((View.OnClickListener)local7);
    mAttachButton.setEnabled(true);
  }
  
  private void setContactFromUri()
  {
    Intent localIntent = getIntent();
    if (localIntent.getDataString().toLowerCase() != null) {
      mWithJabberID = localIntent.getDataString().toLowerCase();
    } else {
      mWithJabberID = "bot@reporting.umang.gov.in";
    }
    if (localIntent.hasExtra(INTENT_EXTRA_USERNAME))
    {
      mUserScreenName = localIntent.getExtras().getString(INTENT_EXTRA_USERNAME);
      return;
    }
    mUserScreenName = mWithJabberID;
  }
  
  private void setCustomTitle(String paramString)
  {
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131492951, null);
    mStatusMode = ((ImageView)localView.findViewById(2131296311));
    mTitle = ((TextView)localView.findViewById(2131296313));
    mSubTitle = ((TextView)localView.findViewById(2131296312));
    mTitle.setText(paramString);
    setTitle(null);
    getSupportActionBar().setCustomView(localView);
    getSupportActionBar().setDisplayShowCustomEnabled(true);
  }
  
  private void setNetWorkConnectionLay()
  {
    network_lay_container = ((RelativeLayout)findViewById(2131297162));
    network_lay_container.setVisibility(8);
  }
  
  private void setSendButton()
  {
    mSendButton = ((ImageView)findViewById(2131296262));
    ChatWindow.6 local6 = new ChatWindow.6(this);
    mSendButton.setOnClickListener((View.OnClickListener)local6);
    mSendButton.setEnabled(false);
  }
  
  private void setSnackBarMessage() {}
  
  private void setUserInput()
  {
    Intent localIntent = getIntent();
    mChatInput = ((EditText)findViewById(2131296263));
    mChatInput.addTextChangedListener(this);
    if (localIntent.hasExtra(INTENT_EXTRA_MESSAGE)) {
      mChatInput.setText(localIntent.getExtras().getString(INTENT_EXTRA_MESSAGE));
    }
  }
  
  private void showConfirmExitDialog()
  {
    Dialog localDialog = new Dialog(this);
    localDialog.getWindow();
    localDialog.requestWindowFeature(1);
    localDialog.setContentView(2131493027);
    localDialog.setCancelable(false);
    localDialog.show();
    localDialog.show();
    ((TextView)localDialog.findViewById(2131298035)).setOnClickListener((View.OnClickListener)new ChatWindow.15(this, localDialog));
    ((TextView)localDialog.findViewById(2131297186)).setOnClickListener((View.OnClickListener)new ChatWindow.16(this, localDialog));
  }
  
  private void showDialogChooser()
  {
    File localFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), Log.getAppName(this));
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("IMG_");
    localStringBuilder.append(String.valueOf(System.currentTimeMillis()));
    localStringBuilder.append(".jpg");
    localFile = new File(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(getPackageName());
    localStringBuilder.append(".fileprovider");
    mCapturedImageURI = FileProvider.getUriForFile(this, localStringBuilder.toString(), localFile);
    Log.a(this, mCapturedImageURI, false, false);
  }
  
  private void showKeyboard()
  {
    mChatInput.requestFocus();
    new Handler(getMainLooper()).postDelayed((Runnable)new ChatWindow.12(this), 200L);
  }
  
  private void showSessionEndDialog()
  {
    Dialog localDialog = f.sufficientlysecure.rootcommands.util.StringBuilder.create(this, 1, 2131493026, false);
    ((TextView)localDialog.findViewById(2131297216)).setOnClickListener((View.OnClickListener)new ChatWindow.17(this, localDialog));
  }
  
  private void showToastNotification(int paramInt)
  {
    Toast.makeText(this, paramInt, 0).show();
  }
  
  private void unbindXMPPService()
  {
    ServiceConnection localServiceConnection = mServiceConnection;
    try
    {
      unbindService(localServiceConnection);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  private void unregisterChatDisconnectReceiver()
  {
    unregisterReceiver((BroadcastReceiver)disconnectReceiver);
  }
  
  private boolean updateConnectionState(ConnectionState paramConnectionState)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateConnectionState: ");
    localStringBuilder.append(paramConnectionState);
    localStringBuilder.toString();
    switch (((Enum)paramConnectionState).ordinal())
    {
    default: 
      return false;
    case 2: 
      return true;
    }
    return false;
  }
  
  private void updateContactStatus()
  {
    Cursor localCursor = getContentResolver().query(RosterProvider.CONTENT_URI, STATUS_QUERY, "jid = ?", new String[] { mWithJabberID }, null);
    int i = localCursor.getColumnIndex("alias");
    int j = localCursor.getColumnIndex("status_mode");
    int k = localCursor.getColumnIndex("status_message");
    if (localCursor.getCount() == 1)
    {
      localCursor.moveToFirst();
      j = localCursor.getInt(j);
      Object localObject = localCursor.getString(k);
      mTitle.setText(localCursor.getString(i));
      TextView localTextView = mSubTitle;
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 8;
      }
      localTextView.setVisibility(i);
      mSubTitle.setText((CharSequence)localObject);
      localObject = mServiceAdapter;
      if (localObject != null)
      {
        i = j;
        if (((XMPPChatServiceAdapter)localObject).isServiceAuthenticated()) {}
      }
      else
      {
        i = 0;
      }
      mStatusMode.setImageResource(StatusMode.values()[i].getDrawableId());
    }
    localCursor.close();
  }
  
  private void updateRecycleView(int paramInt)
  {
    runOnUiThread((Runnable)new ChatWindow.13(this, paramInt));
  }
  
  private void updateRecycleViewForRetry(int paramInt)
  {
    runOnUiThread((Runnable)new ChatWindow.14(this, paramInt));
  }
  
  public void abortUpload()
  {
    k localK = uploadCall;
    if (localK != null) {
      localK.cancel();
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (mChatInput.getText().length() >= 1)
    {
      mChatInput.setOnKeyListener(this);
      mSendButton.setEnabled(true);
      mSendButton.setImageResource(2131231456);
      if (!userStartedTyping) {
        isUserTyping(true);
      }
      userStartedTyping = true;
      return;
    }
    userStartedTyping = false;
    mSendButton.setImageResource(2131231453);
    isUserTyping(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void initToolBar()
  {
    mtoolbar = ((Toolbar)findViewById(2131297768));
    mtoolbar.setLogo(2131231226);
    mtoolbar.setTitleTextColor(getResources().getColor(17170443));
    setSupportActionBar(mtoolbar);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2019) && (paramInt2 == -1))
    {
      if (isFinishing()) {
        return;
      }
      try
      {
        paramIntent = new ChatWindow.21(this, paramIntent);
        paramIntent = (Runnable)paramIntent;
        runOnUiThread(paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        k.a.a.m.StringBuilder.append(paramIntent);
        Toast.makeText(this, getResources().getString(2131756127), 1).show();
        return;
      }
    }
    if (paramInt1 == 203)
    {
      paramIntent = CropImage.a(paramIntent);
      if (paramInt2 == -1)
      {
        if (!isFinishing()) {
          runOnUiThread((Runnable)new ChatWindow.22(this, paramIntent));
        }
      }
      else if (paramInt2 == 204)
      {
        paramIntent.d();
        if (!isFinishing()) {
          f.sufficientlysecure.rootcommands.util.StringBuilder.show(this, 2131756127, this, 1);
        }
      }
      else if (!isFinishing())
      {
        f.sufficientlysecure.rootcommands.util.StringBuilder.show(this, 2131756127, this, 1);
      }
    }
    else if ((paramInt1 == 2016) && (paramInt2 == -1) && (!isFinishing()))
    {
      try
      {
        paramIntent = new ChatWindow.23(this);
        paramIntent = (Runnable)paramIntent;
        runOnUiThread(paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        k.a.a.m.StringBuilder.append(paramIntent);
        Toast.makeText(this, getResources().getString(2131756127), 1).show();
      }
    }
  }
  
  public void onBackPressed()
  {
    try
    {
      sendBroadcast(new Intent("exit"));
      finish();
      return;
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
    }
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onContextItemSelected(paramMenuItem);
    case 2131296497: 
      sendMessage(getMessageFromContextMenu(paramMenuItem).toString(), "true");
      return true;
    }
    ((ClipboardManager)getSystemService("clipboard")).setText(getMessageFromContextMenu(paramMenuItem));
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    setTheme(MyApplication.getConfig(this).getTheme());
    requestWindowFeature(8);
    getWindow().setSoftInputMode(1);
    mConfig = MyApplication.getConfig(this);
    super.onCreate(paramBundle);
    pref = new k.a.a.m.f(this);
    pref.append(k.a.a.m.f.xml, "");
    org.yaxim.androidclient.util.PreferenceConstants.isExistingUser = true;
    paramBundle = PreferenceManager.getDefaultSharedPreferences(this).edit();
    paramBundle.putBoolean("is_already_connected", true);
    paramBundle.commit();
    mChatFontSize = Integer.valueOf(getConfigchatFontSize).intValue();
    setContentView(2131493142);
    try
    {
      Log.inject(this, findViewById(2131297150));
      initConCalled = false;
      Log.execute(this, "Customer Support Screen");
      toolbar = ((Toolbar)findViewById(2131297768));
      f.sufficientlysecure.rootcommands.util.StringBuilder.inflate(this, toolbar, true);
      view = toolbar.getRootView();
      titleText = ((TextView)view.findViewById(2131297758));
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755511, titleText);
      typingText = ((TextView)view.findViewById(2131297959));
      typingText.setVisibility(8);
      ((ImageView)view.findViewById(2131296717)).setOnClickListener((View.OnClickListener)new ChatWindow.2(this));
      ((TextView)view.findViewById(2131296718)).setOnClickListener((View.OnClickListener)new ChatWindow.3(this));
      org.yaxim.androidclient.util.MaxWidthLinearLayout.mMaxWidth = getWindowManager().getDefaultDisplay().getWidth() * 80 / 100;
      getContentResolver().registerContentObserver(RosterProvider.CONTENT_URI, true, mContactObserver);
      idList = new ArrayList();
      setContactFromUri();
      messagesListObject = new ArrayList();
      messageQuickReply = new ArrayList();
      arrayListQuickReplyToSend = new ArrayList();
      arrayListActionToSend = new ArrayList();
      arrayListTimeStamp = new ArrayList();
      messageElements = new ArrayList();
      arrayListElementToSend = new ArrayList();
      multipleRowRecyclerView = ((RecyclerView)findViewById(2131297150));
      paramBundle = new LinearLayoutManager(this, 1, false);
      multipleRowRecyclerView.setLayoutManager(paramBundle);
      paramBundle.setStackFromEnd(true);
      multipleRowModelList = getSampleArrayList();
      multipleRowAdapter = new ChatWindow.ChatAdapter(this, this, multipleRowModelList, PROJECTION_FROM, PROJECTION_TO, mWithJabberID, mUserScreenName);
      multipleRowRecyclerView.setAdapter((RecyclerView.Adapter)multipleRowAdapter);
      multipleRowRecyclerView.addOnLayoutChangeListener((View.OnLayoutChangeListener)new ChatWindow.4(this));
      getContentResolver().registerContentObserver(RosterProvider.CONTENT_URI, true, mRosterObserver);
      registerXMPPService("true");
      createUICallback();
      setSendButton();
      setUserInput();
      setAttachFileButton();
      setNetWorkConnectionLay();
      getSupportLoaderManager().initLoader(0, null, this);
      mLoadingProgress = ((ProgressBar)findViewById(2131297052));
      mLoadingProgress.setVisibility(0);
      paramBundle = f.sufficientlysecure.rootcommands.util.StringBuilder.append("MarkAsReadThread: ");
      paramBundle.append(mWithJabberID);
      mMarkThread = new HandlerThread(paramBundle.toString());
      mMarkThread.start();
      mMarkHandler = new Handler(mMarkThread.getLooper());
      registerChatDisconnectReceiver();
      mImageLoader = f.l.a.b.f.a();
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;) {}
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = (TextView)targetView.findViewById(2131296499);
    getMenuInflater().inflate(2131558400, paramContextMenu);
    if (!paramView.getText().equals(getString(2131755396))) {
      paramContextMenu.findItem(2131296497).setEnabled(false);
    }
  }
  
  public Loader onCreateLoader(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramBundle = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("jid='"), mWithJabberID, "'");
      return new CursorLoader(this, ChatProvider.CONTENT_URI, PROJECTION_FROM, paramBundle, null, null);
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unknown loader id returned in LoaderCallbacks.onCreateLoader: ", paramInt);
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getContentResolver().unregisterContentObserver(mRosterObserver);
    Object localObject;
    if (hasWindowFocus()) {
      localObject = mServiceConnection;
    }
    try
    {
      unbindService((ServiceConnection)localObject);
      localObject = disconnectReceiver;
      if (localObject != null) {
        unregisterReceiver((BroadcastReceiver)localObject);
      }
      getContentResolver().unregisterContentObserver(mContactObserver);
      mMarkThread.quit();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 66))
    {
      sendMessageIfNotNull();
      return true;
    }
    return false;
  }
  
  public void onLoadFinished(Loader paramLoader, Cursor paramCursor)
  {
    mLoadingProgress.setVisibility(8);
    createListFromCursor(paramCursor);
    if (mShowOrHide)
    {
      if (paramCursor.getCount() == 0) {
        showKeyboard();
      }
      mShowOrHide = false;
    }
  }
  
  public void onLoaderReset(Loader paramLoader) {}
  
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
    needs_to_bind_unbind = true;
    unregisterReceiver(networkReceiver);
    XMPPRosterServiceAdapter localXMPPRosterServiceAdapter = serviceAdapter;
    if (localXMPPRosterServiceAdapter != null) {
      localXMPPRosterServiceAdapter.unregisterUICallback(rosterCallback);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 0;
    if (paramInt != 1101)
    {
      if (paramInt != 1104) {
        return;
      }
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        openGalleryIntent();
        return;
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755552, this);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("android.permission.CAMERA", Integer.valueOf(0));
    localHashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(0));
    paramInt = i;
    while (paramInt < paramArrayOfString.length)
    {
      localHashMap.put(paramArrayOfString[paramInt], Integer.valueOf(paramArrayOfInt[paramInt]));
      paramInt += 1;
    }
    if ((((Integer)localHashMap.get("android.permission.CAMERA")).intValue() == 0) && (((Integer)localHashMap.get("android.permission.WRITE_EXTERNAL_STORAGE")).intValue() == 0))
    {
      openCameraIntent();
      return;
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.showDialog(this, 2131755546, this);
  }
  
  public void onResume()
  {
    super.onResume();
    updateContactStatus();
    registerNetworkReceiver();
    needs_to_bind_unbind = true;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (!needs_to_bind_unbind) {
      return;
    }
    ServiceConnection localServiceConnection;
    if (paramBoolean) {
      bindXMPPService();
    } else {
      localServiceConnection = mServiceConnection;
    }
    try
    {
      unbindService(localServiceConnection);
      needs_to_bind_unbind = false;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public void openBrowser(String paramString)
  {
    try
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return;
    }
    catch (Exception paramString)
    {
      k.a.a.m.StringBuilder.append(paramString);
    }
  }
  
  public void openCameraIntent()
  {
    Object localObject1 = Environment.DIRECTORY_PICTURES;
    try
    {
      Object localObject2 = new File(Environment.getExternalStoragePublicDirectory((String)localObject1), Log.getAppName(this));
      boolean bool = ((File)localObject2).exists();
      if (!bool) {
        ((File)localObject2).mkdirs();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localObject2);
      localObject2 = File.separator;
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("IMG_");
      ((StringBuilder)localObject1).append(String.valueOf(System.currentTimeMillis()));
      ((StringBuilder)localObject1).append(".jpg");
      localObject1 = new File(((StringBuilder)localObject1).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getPackageName());
      ((StringBuilder)localObject2).append(".fileprovider");
      localObject1 = FileProvider.getUriForFile(this, ((StringBuilder)localObject2).toString(), (File)localObject1);
      mCapturedImageURI = ((Uri)localObject1);
      localObject1 = mCapturedImageURI;
      localObject1 = ((Uri)localObject1).toString();
      fileSelectedPath = ((String)localObject1);
      localObject1 = new k.a.a.m.f(this);
      localObject2 = k.a.a.m.f.clientFirstMessageBare;
      Uri localUri = mCapturedImageURI;
      ((k.a.a.m.f)localObject1).append((String)localObject2, localUri.toString());
      localObject1 = new Intent("android.media.action.IMAGE_CAPTURE");
      localObject2 = mCapturedImageURI;
      ((Intent)localObject1).putExtra("output", (Parcelable)localObject2);
      startActivityForResult((Intent)localObject1, 2016);
      MyApplication.started = true;
      return;
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
    }
  }
  
  public void openGalleryIntent()
  {
    Object localObject1 = Environment.DIRECTORY_PICTURES;
    try
    {
      Object localObject2 = new File(Environment.getExternalStoragePublicDirectory((String)localObject1), Log.getAppName(this));
      boolean bool = ((File)localObject2).exists();
      if (!bool) {
        ((File)localObject2).mkdirs();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localObject2);
      localObject2 = File.separator;
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("IMG_");
      ((StringBuilder)localObject1).append(String.valueOf(System.currentTimeMillis()));
      ((StringBuilder)localObject1).append(".jpg");
      localObject1 = new File(((StringBuilder)localObject1).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getPackageName());
      ((StringBuilder)localObject2).append(".fileprovider");
      localObject1 = FileProvider.getUriForFile(this, ((StringBuilder)localObject2).toString(), (File)localObject1);
      mCapturedImageURI = ((Uri)localObject1);
      localObject1 = mCapturedImageURI;
      localObject1 = ((Uri)localObject1).toString();
      fileSelectedPath = ((String)localObject1);
      localObject1 = new Intent("android.intent.action.GET_CONTENT");
      ((Intent)localObject1).addCategory("android.intent.category.OPENABLE");
      ((Intent)localObject1).setType("image/*");
      startActivityForResult((Intent)localObject1, 2019);
      MyApplication.started = true;
      return;
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
    }
  }
  
  public Bitmap rescaleBitmap(InputStream paramInputStream, int paramInt)
    throws FileNotFoundException
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    int m = outWidth;
    int j = outHeight;
    int k = 2;
    if (paramInt != 0)
    {
      int i = 2;
      for (k = m;; k = m)
      {
        m = k / 2;
        k = i;
        if (m < paramInt) {
          break;
        }
        j /= 2;
        if (j < paramInt)
        {
          k = i;
          break;
        }
        i *= 2;
      }
    }
    localOptions = new BitmapFactory.Options();
    inSampleSize = k;
    return BitmapFactory.decodeStream(paramInputStream, null, localOptions);
  }
  
  public Bitmap rescaleImage(Context paramContext, Uri paramUri, int paramInt)
    throws FileNotFoundException
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramContext.getContentResolver().openInputStream(paramUri), null, localOptions);
    int m = outWidth;
    int j = outHeight;
    int k = 2;
    if (paramInt != 0)
    {
      int i = 2;
      for (k = m;; k = m)
      {
        m = k / 2;
        k = i;
        if (m < paramInt) {
          break;
        }
        j /= 2;
        if (j < paramInt)
        {
          k = i;
          break;
        }
        i *= 2;
      }
    }
    localOptions = new BitmapFactory.Options();
    inSampleSize = k;
    return BitmapFactory.decodeStream(paramContext.getContentResolver().openInputStream(paramUri), null, localOptions);
  }
  
  public void sendEndMessage(String paramString1, String paramString2, String paramString3)
  {
    new Thread((Runnable)new ChatWindow.11(this, paramString2, paramString1, paramString3)).start();
  }
  
  public void sendExitMessage(String paramString1, String paramString2)
  {
    new Thread((Runnable)new ChatWindow.10(this, paramString1, paramString2)).start();
  }
  
  public void sendInitMessage(String paramString1, String paramString2)
  {
    new Thread((Runnable)new ChatWindow.9(this, paramString1, paramString2)).start();
  }
  
  public void sendMessage(String paramString1, String paramString2)
  {
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("inside sendMessage...............................", paramString1);
    mChatInput.setText(null);
    mSendButton.setEnabled(false);
    new Thread((Runnable)new ChatWindow.8(this, paramString1, paramString2)).start();
  }
}
