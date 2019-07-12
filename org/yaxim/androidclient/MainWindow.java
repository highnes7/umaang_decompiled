package org.yaxim.androidclient;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.package_7.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import f.n.a.d;
import g.a.a.MemorizingTrustManager;
import in.spicedigital.umang.application.MyApplication;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import k.a.a.m.s;
import org.yaxim.androidclient.chat.ChatWindow;
import org.yaxim.androidclient.data.ChatProvider;
import org.yaxim.androidclient.data.RosterProvider;
import org.yaxim.androidclient.data.YaximConfiguration;
import org.yaxim.androidclient.dialogs.AddRosterItemDialog;
import org.yaxim.androidclient.dialogs.ChangeStatusDialog;
import org.yaxim.androidclient.dialogs.FirstStartDialog;
import org.yaxim.androidclient.dialogs.GroupNameView;
import org.yaxim.androidclient.exceptions.YaximXMPPAdressMalformedException;
import org.yaxim.androidclient.preferences.AccountPrefs;
import org.yaxim.androidclient.preferences.MainPrefs;
import org.yaxim.androidclient.service.XMPPService;
import org.yaxim.androidclient.util.ConnectionState;
import org.yaxim.androidclient.util.SpiceAlertDialog;
import org.yaxim.androidclient.util.StatusMode;
import org.yaxim.androidclient.util.Utils;
import org.yaxim.androidclient.util.XMPPHelper;

public class MainWindow
  extends BaseActivity
{
  public static final String[] GROUPS_FROM = { "roster_group", "members" };
  public static final String[] GROUPS_QUERY;
  public static final String[] GROUPS_QUERY_COUNTED;
  public static final int[] GROUPS_TO = { 2131296847, 2131297100 };
  public static final String OFFLINE_EXCLUSION;
  public static final String[] ROSTER_QUERY = { "_id", "jid", "alias", "status_mode", "status_message" };
  public static final String SETTINGS_ID = "yaxim.MainWindow";
  public static final String countAvailableMembers;
  public static final String countMembers = "SELECT COUNT() FROM roster inner_query WHERE inner_query.roster_group = main_result.roster_group";
  public final String[] GROUPS_QUERY_CONTACTS_DISABLED;
  public BroadcastReceiver broadcastReceiver;
  public final String countAvailableMembersTotals;
  public final String countMembersTotals;
  public MainWindow.DisconnectReceiver disconnectReceiver;
  public boolean flag;
  public boolean groupClicked;
  public ContentObserver mChatObserver;
  public YaximConfiguration mConfig;
  public TextView mConnectingText;
  public HashMap<String, Boolean> mGroupsExpanded;
  public ContentObserver mRosterObserver;
  public String mTheme;
  public s mTimer;
  public HashMap<String, Integer> mUnreadCounters;
  public Handler mainHandler;
  public IXMPPRosterCallback.Stub rosterCallback;
  public MainWindow.RosterExpListAdapter rosterListAdapter;
  public XMPPRosterServiceAdapter serviceAdapter;
  public boolean stillNotConnected;
  public ServiceConnection xmppServiceConnection;
  public Intent xmppServiceIntent;
  
  static
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("status_mode != ");
    localStringBuilder.append(((Enum)StatusMode.offline).ordinal());
    OFFLINE_EXCLUSION = localStringBuilder.toString();
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("SELECT COUNT() FROM roster inner_query WHERE inner_query.roster_group = main_result.roster_group AND inner_query.");
    localStringBuilder.append(OFFLINE_EXCLUSION);
    countAvailableMembers = localStringBuilder.toString();
    GROUPS_QUERY = new String[] { "_id", "roster_group" };
    GROUPS_QUERY_COUNTED = new String[] { "_id", "roster_group", f.sufficientlysecure.rootcommands.util.StringBuilder.replace(f.sufficientlysecure.rootcommands.util.StringBuilder.append("("), countAvailableMembers, ") || '/' || (", "SELECT COUNT() FROM roster inner_query WHERE inner_query.roster_group = main_result.roster_group", ") AS members") };
  }
  
  public MainWindow()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("SELECT COUNT() FROM roster inner_query WHERE inner_query.");
    localStringBuilder.append(OFFLINE_EXCLUSION);
    countAvailableMembersTotals = localStringBuilder.toString();
    countMembersTotals = "SELECT COUNT() FROM roster";
    GROUPS_QUERY_CONTACTS_DISABLED = new String[] { "_id", "'' AS roster_group", f.sufficientlysecure.rootcommands.util.StringBuilder.replace(f.sufficientlysecure.rootcommands.util.StringBuilder.append("("), countAvailableMembersTotals, ") || '/' || (", "SELECT COUNT() FROM roster", ") AS members") };
    flag = false;
    groupClicked = false;
    mainHandler = new Handler();
    mRosterObserver = ((ContentObserver)new MainWindow.RosterObserver(this));
    mChatObserver = ((ContentObserver)new MainWindow.ChatObserver(this));
    mGroupsExpanded = new HashMap();
    mUnreadCounters = new HashMap();
    broadcastReceiver = ((BroadcastReceiver)new MainWindow.2(this));
  }
  
  private void aboutDialog()
  {
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131492895, null, false);
    Object localObject2 = getString(2131755014);
    Object localObject1 = localObject2;
    try
    {
      PackageInfo localPackageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(" v");
      localObject2 = versionName;
      localStringBuilder.append((String)localObject2);
      localObject2 = localStringBuilder.toString();
      localObject1 = localObject2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
    localObject2 = (TextView)localView.findViewById(2131297796);
    if (((TextView)localObject2).getText().equals("translator-credits")) {
      ((View)localObject2).setVisibility(8);
    }
    new AlertDialog.Builder(this).setTitle(localObject1).setIcon(17301659).setView(localView).setPositiveButton(17039370, null).setNeutralButton(2131755013, (DialogInterface.OnClickListener)new MainWindow.11(this)).create().show();
  }
  
  private boolean applyMainMenuChoice(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i != 16908332) {
      switch (i)
      {
      default: 
        return false;
      case 2131297107: 
        setOfflinceContactsVisibility(mConfig.showOffline ^ true);
        updateRoster();
        return true;
      case 2131297106: 
        f.sufficientlysecure.rootcommands.util.StringBuilder.startActivity(this, MainPrefs.class);
        return true;
      case 2131297105: 
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("connstartup", false).commit();
        stopService(xmppServiceIntent);
        finish();
        return true;
      case 2131297104: 
        toggleConnection();
        return true;
      case 2131297103: 
        addToRosterDialog(null);
        return true;
      case 2131297102: 
        aboutDialog();
        return true;
      }
    }
    paramMenuItem = StatusMode.valueOf(mConfig.statusMode);
    YaximConfiguration localYaximConfiguration = mConfig;
    ((AlertDialog)new ChangeStatusDialog(this, paramMenuItem, statusMessage, statusMessageHistory)).show();
    return true;
  }
  
  private boolean applyMenuContextChoice(MenuItem paramMenuItem)
  {
    if (isChild(getMenuInfopackedPosition))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action for contact ");
      localStringBuilder.append("");
      localStringBuilder.append("/");
      localStringBuilder.append("");
      localStringBuilder.toString();
      switch (paramMenuItem.getItemId())
      {
      default: 
        break;
      case 2131297455: 
        if (!isConnected())
        {
          showToastNotification(2131755022);
          return true;
        }
        serviceAdapter.sendPresenceRequest("", "subscribe");
        return true;
      case 2131297454: 
        if (!isConnected())
        {
          showToastNotification(2131755022);
          return true;
        }
        renameRosterItemDialog("", "");
        return true;
      case 2131297453: 
        startChatActivity("", "", null);
        return true;
      case 2131297452: 
        doMarkAllAsRead("");
        return true;
      case 2131297451: 
        removeChatHistoryDialog("", "");
        return true;
      case 2131297450: 
        if (!isConnected())
        {
          showToastNotification(2131755022);
          return true;
        }
        removeRosterItemDialog("", "");
        return true;
      case 2131297449: 
        if (!isConnected())
        {
          showToastNotification(2131755022);
          return true;
        }
        moveRosterItemToGroupDialog("");
        return true;
      }
    }
    else
    {
      int i = paramMenuItem.getItemId();
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("action for group ", "");
      if (i == 2131297456) {
        break label313;
      }
    }
    return false;
    label313:
    if (!isConnected())
    {
      showToastNotification(2131755022);
      return true;
    }
    renameRosterGroupDialog("");
    return true;
  }
  
  private void bindXMPPService()
  {
    bindService(xmppServiceIntent, xmppServiceConnection, 1);
  }
  
  public static Intent createIntent(Context paramContext)
  {
    paramContext = new Intent(paramContext, MainWindow.class);
    paramContext.addFlags(67108864);
    return paramContext;
  }
  
  private void createUICallback()
  {
    rosterCallback = new MainWindow.13(this);
  }
  
  private void displayOwnStatus() {}
  
  private int getConnectDisconnectIcon()
  {
    if ((!isConnected()) && (!isConnecting())) {
      return 2131231106;
    }
    return 2131231107;
  }
  
  private String getConnectDisconnectText()
  {
    if ((!isConnected()) && (!isConnecting())) {
      return getString(2131755097);
    }
    return getString(2131755098);
  }
  
  private String getPackedItemRow(long paramLong, String paramString)
  {
    return "";
  }
  
  private int getShowHideMenuIcon()
  {
    TypedValue localTypedValue = new TypedValue();
    if (mConfig.showOffline)
    {
      getTheme().resolveAttribute(2130968585, localTypedValue, true);
      return resourceId;
    }
    getTheme().resolveAttribute(2130968576, localTypedValue, true);
    return resourceId;
  }
  
  private String getShowHideMenuText()
  {
    if (mConfig.showOffline) {
      return getString(2131755091);
    }
    return getString(2131755093);
  }
  
  private boolean isChild(long paramLong)
  {
    return ExpandableListView.getPackedPositionType(paramLong) == 1;
  }
  
  private boolean isConnected()
  {
    XMPPRosterServiceAdapter localXMPPRosterServiceAdapter = serviceAdapter;
    return (localXMPPRosterServiceAdapter != null) && (localXMPPRosterServiceAdapter.isAuthenticated());
  }
  
  private boolean isConnecting()
  {
    XMPPRosterServiceAdapter localXMPPRosterServiceAdapter = serviceAdapter;
    return (localXMPPRosterServiceAdapter != null) && (localXMPPRosterServiceAdapter.getConnectionState() == ConnectionState.CONNECTING);
  }
  
  private void loadUnreadCounters()
  {
    Cursor localCursor = getContentResolver().query(ChatProvider.CONTENT_URI, new String[] { "jid", "count(*)" }, "from_me = 0 AND read = 0) GROUP BY (jid", null, null);
    mUnreadCounters.clear();
    if (localCursor != null)
    {
      while (localCursor.moveToNext()) {
        mUnreadCounters.put(localCursor.getString(0), Integer.valueOf(localCursor.getInt(1)));
      }
      localCursor.close();
    }
  }
  
  private void registerChatDisconnectReceiver()
  {
    disconnectReceiver = new MainWindow.DisconnectReceiver(this, null);
    IntentFilter localIntentFilter = new IntentFilter("com.toxy.DISCONNECT_CHAT");
    registerReceiver((BroadcastReceiver)disconnectReceiver, localIntentFilter);
  }
  
  private void registerCrashReporter()
  {
    if (mConfig.reportCrash) {
      d.a(this, "http://duenndns.de/yaxim-crash/");
    }
  }
  
  private void registerListAdapter() {}
  
  private void registerXMPPService()
  {
    xmppServiceIntent = new Intent(this, XMPPService.class);
    xmppServiceIntent.setAction("org.yaxim.androidclient.XMPPSERVICE");
    xmppServiceConnection = ((ServiceConnection)new MainWindow.12(this));
  }
  
  private void savePreferences(String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this).edit();
    localEditor.putString("account_jabberID", paramString1);
    localEditor.putString("account_customserver", "reporting.umang.gov.in");
    localEditor.putString("account_jabberPW", paramString2);
    localEditor.putString("account_resource", paramString3);
    localEditor.putString("account_port", "5333");
    localEditor.commit();
  }
  
  private void setOfflinceContactsVisibility(boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("showOffline", paramBoolean).commit();
    invalidateOptionsMenu();
  }
  
  private void showErrorDialogExit(String paramString)
  {
    new SpiceAlertDialog(this, paramString, new MainWindow.14(this), false);
  }
  
  private void showExitDialog()
  {
    Dialog localDialog = f.sufficientlysecure.rootcommands.util.StringBuilder.create(this, 1, 2131493017, false);
    ((TextView)localDialog.findViewById(2131297214)).setOnClickListener((View.OnClickListener)new MainWindow.15(this, localDialog));
  }
  
  private void showFirstStartUpDialogIfPrefsEmpty()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("showFirstStartUpDialogIfPrefsEmpty, JID: ");
    localStringBuilder.append(mConfig.jabberID);
    localStringBuilder.toString();
    if (mConfig.jabberID.length() < 3)
    {
      PreferenceManager.setDefaultValues(this, 2131951621, false);
      PreferenceManager.setDefaultValues(this, 2131951616, false);
      PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("connstartup", false).commit();
      ((AlertDialog)new FirstStartDialog(this, serviceAdapter)).show();
    }
  }
  
  private void startChatActivity(String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(this, ChatWindow.class);
    localIntent.setData(Uri.parse(paramString1));
    localIntent.putExtra(ChatWindow.INTENT_EXTRA_USERNAME, paramString2);
    if (paramString3 != null) {
      localIntent.putExtra(ChatWindow.INTENT_EXTRA_MESSAGE, paramString3);
    }
    startActivityForResult(localIntent, 100);
  }
  
  private void toggleConnection()
  {
    if (!mConfig.jid_configured)
    {
      f.sufficientlysecure.rootcommands.util.StringBuilder.startActivity(this, AccountPrefs.class);
      return;
    }
    int i;
    if ((!isConnected()) && (!isConnecting())) {
      i = 0;
    } else {
      i = 1;
    }
    PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("connstartup", i ^ 0x1).commit();
    if (i != 0)
    {
      serviceAdapter.disconnect();
      stopService(xmppServiceIntent);
      return;
    }
    if (Utils.isNetworkAvailable(this))
    {
      if (!PreferenceManager.getDefaultSharedPreferences(this).getBoolean("acount", false))
      {
        startConnection(true);
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("acount", true).commit();
        return;
      }
      startConnection(false);
    }
  }
  
  private void unbindXMPPService()
  {
    ServiceConnection localServiceConnection = xmppServiceConnection;
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
    int i = ((Enum)paramConnectionState).ordinal();
    boolean bool = true;
    switch (i)
    {
    default: 
      return false;
    case 4: 
      bool = false;
      break;
    case 2: 
      paramConnectionState = mConnectingText;
      if (paramConnectionState != null) {
        paramConnectionState.setVisibility(4);
      }
      setSupportProgressBarIndeterminateVisibility(false);
      return true;
    case 1: 
    case 3: 
      localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("IS AUTHENTICATED ==");
      localStringBuilder.append(serviceAdapter.isAuthenticated());
      localStringBuilder.toString();
      break;
    }
    bool = false;
    if ((mConnectingText != null) && (paramConnectionState != ConnectionState.OFFLINE) && (paramConnectionState == ConnectionState.CONNECTING))
    {
      paramConnectionState = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Loading text ====");
      paramConnectionState.append(serviceAdapter.getConnectionStateString());
      paramConnectionState.toString();
      f.sufficientlysecure.rootcommands.util.StringBuilder.setText(this, 2131755874, mConnectingText);
      mConnectingText.setVisibility(0);
    }
    setSupportProgressBarIndeterminateVisibility(bool);
    return false;
  }
  
  private void verifyAndSavePreferences()
  {
    String str2 = getIntent().getStringExtra("password");
    Object localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("verifyAndSavePreferences====");
    ((StringBuilder)localObject1).append(PreferenceManager.getDefaultSharedPreferences(this).getString("account_jabberID", ""));
    ((StringBuilder)localObject1).toString();
    Object localObject2;
    try
    {
      boolean bool = PreferenceManager.getDefaultSharedPreferences(this).getString("account_jabberID", "").equalsIgnoreCase("");
      String str1;
      StringBuilder localStringBuilder;
      if (bool)
      {
        new SecureRandom().nextInt(100000);
        System.currentTimeMillis();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getIntent().getStringExtra("username"));
        ((StringBuilder)localObject1).append("@");
        ((StringBuilder)localObject1).append("reporting.umang.gov.in");
        str1 = XMPPHelper.verifyJabberID(((StringBuilder)localObject1).toString());
        localObject1 = str1;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("New Jabber id = ");
        localStringBuilder.append(str1);
        localStringBuilder.toString();
      }
      else
      {
        str1 = PreferenceManager.getDefaultSharedPreferences(this).getString("account_jabberID", "");
        localObject1 = str1;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("old jabber id = ");
        localStringBuilder.append(str1);
        localStringBuilder.toString();
      }
    }
    catch (YaximXMPPAdressMalformedException localYaximXMPPAdressMalformedException)
    {
      k.a.a.m.StringBuilder.append((Exception)localYaximXMPPAdressMalformedException);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(Utils.getDeviceId(this));
      ((StringBuilder)localObject2).append("@itx1spip-momt1");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    savePreferences((String)localObject2, str2, String.format("%s.%08X", new Object[] { getString(2131755289), Integer.valueOf(new Random().nextInt()) }));
  }
  
  public boolean addToRosterDialog(String paramString)
  {
    Object localObject = serviceAdapter;
    if ((localObject != null) && (((XMPPRosterServiceAdapter)localObject).isAuthenticated()))
    {
      localObject = new AddRosterItemDialog(this, serviceAdapter);
      userInputField.setText(paramString);
      ((AlertDialog)localObject).show();
      return true;
    }
    showToastNotification(2131755022);
    return false;
  }
  
  public void doMarkAllAsRead(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("read", Integer.valueOf(1));
    getContentResolver().update(ChatProvider.CONTENT_URI, localContentValues, "jid = ? AND from_me = 0 AND read = 0", new String[] { paramString });
  }
  
  public void editTextDialog(int paramInt, CharSequence paramCharSequence, String paramString, MainWindow.EditOk paramEditOk)
  {
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131493068, (ViewGroup)findViewById(2131296982));
    ((TextView)localView.findViewById(2131297683)).setText(paramCharSequence);
    paramCharSequence = (EditText)localView.findViewById(2131296691);
    paramCharSequence.setTransformationMethod(SingleLineTransformationMethod.getInstance());
    paramCharSequence.setText(paramString);
    new AlertDialog.Builder(this).setTitle(paramInt).setView(localView).setPositiveButton(17039370, (DialogInterface.OnClickListener)new MainWindow.7(this, paramCharSequence, paramEditOk)).setNegativeButton(17039360, null).create().show();
  }
  
  public String getGroupName(int paramInt)
  {
    ExpandableListView.getPackedPositionForGroup(paramInt);
    return "";
  }
  
  public List getRosterContacts()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = getContentResolver().query(RosterProvider.CONTENT_URI, ROSTER_QUERY, null, null, "alias");
    int i = localCursor.getColumnIndex("jid");
    int j = localCursor.getColumnIndex("alias");
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      String str2 = localCursor.getString(i);
      String str3 = localCursor.getString(j);
      String str1 = str3;
      if ((str3 == null) || (str3.length() == 0)) {
        str1 = str2;
      }
      localArrayList.add(new String[] { str2, str1 });
      localCursor.moveToNext();
    }
    localCursor.close();
    return localArrayList;
  }
  
  public List getRosterGroups()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = getContentResolver().query(RosterProvider.GROUPS_URI, GROUPS_QUERY, null, null, "roster_group");
    int i = localCursor.getColumnIndex("roster_group");
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      localArrayList.add(localCursor.getString(i));
      localCursor.moveToNext();
    }
    localCursor.close();
    return localArrayList;
  }
  
  public int getStatusActionIcon()
  {
    int i;
    if ((isConnected()) && (!isConnecting()) && (getStatusMode() != null)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return StatusMode.offline.getDrawableId();
    }
    return getStatusMode().getDrawableId();
  }
  
  public StatusMode getStatusMode()
  {
    return StatusMode.valueOf(mConfig.statusMode);
  }
  
  public void handleGroupChange(int paramInt, boolean paramBoolean)
  {
    if (groupClicked)
    {
      try
      {
        String str = getGroupName(paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("group status change: ");
        localStringBuilder.append(str);
        localStringBuilder.append(" -> ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.toString();
        mGroupsExpanded.put(str, Boolean.valueOf(paramBoolean));
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;) {}
      }
      groupClicked = false;
      return;
    }
  }
  
  public void handleJabberIntent()
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getAction();
    localObject = ((Intent)localObject).getData();
    if ((str != null) && (str.equals("android.intent.action.SENDTO")) && (localObject != null) && (((Uri)localObject).getHost().equals("jabber")))
    {
      str = (String)((Uri)localObject).getPathSegments().get(0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleJabberIntent: ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).toString();
      localObject = getRosterContacts().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String[] arrayOfString = (String[])((Iterator)localObject).next();
        if (str.equalsIgnoreCase(arrayOfString[0]))
        {
          startChatActivity(arrayOfString[0], arrayOfString[1], null);
          finish();
          return;
        }
      }
      if (!addToRosterDialog(str)) {
        finish();
      }
    }
  }
  
  public void handleSendIntent()
  {
    String str = getIntent().getAction();
    if ((str != null) && (str.equals("android.intent.action.SEND")))
    {
      showToastNotification(2131755405);
      setTitle(2131755405);
    }
  }
  
  public void moveRosterItemToGroupDialog(String paramString)
  {
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131493152, null, false);
    GroupNameView localGroupNameView = (GroupNameView)localView.findViewById(2131297136);
    localGroupNameView.setGroupList(getRosterGroups());
    new AlertDialog.Builder(this).setTitle(2131755100).setView(localView).setPositiveButton(17039370, (DialogInterface.OnClickListener)new MainWindow.10(this, localGroupNameView, paramString)).setNegativeButton(17039360, null).create().show();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 100) && (paramInt2 == -1)) {
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return applyMenuContextChoice(paramMenuItem);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    mConfig = MyApplication.getConfig(this);
    mTheme = mConfig.theme;
    super.onCreate(paramBundle);
    verifyAndSavePreferences();
    registerCrashReporter();
    showFirstStartUpDialogIfPrefsEmpty();
    getContentResolver().registerContentObserver(RosterProvider.CONTENT_URI, true, mRosterObserver);
    getContentResolver().registerContentObserver(ChatProvider.CONTENT_URI, true, mChatObserver);
    registerXMPPService();
    createUICallback();
    setupContenView();
    toggleConnection();
    paramBundle = broadcastReceiver;
    try
    {
      registerReceiver(paramBundle, new IntentFilter("exit"));
      registerChatDisconnectReceiver();
    }
    catch (Exception paramBundle)
    {
      k.a.a.m.StringBuilder.append(paramBundle);
    }
    stillNotConnected = true;
    mTimer = new MainWindow.1(this, '?', 1000L);
    mTimer.start();
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    try
    {
      paramView = (ExpandableListView.ExpandableListContextMenuInfo)paramContextMenuInfo;
      if (isChild(packedPosition))
      {
        getMenuInflater().inflate(2131558415, paramContextMenu);
        paramContextMenu.setHeaderTitle(getString(2131756288, new Object[] { String.format("%s (%s)", new Object[] { "", "" }) }));
        return;
      }
    }
    catch (ClassCastException paramContextMenu) {}
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (mTheme != null) {
      mTimer.cancel();
    }
    getContentResolver().unregisterContentObserver(mRosterObserver);
    getContentResolver().unregisterContentObserver(mChatObserver);
    BroadcastReceiver localBroadcastReceiver = broadcastReceiver;
    try
    {
      unregisterReceiver(localBroadcastReceiver);
      localBroadcastReceiver = (BroadcastReceiver)disconnectReceiver;
      unregisterReceiver(localBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      k.a.a.m.StringBuilder.append(localException);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    Object localObject = serviceAdapter;
    if (localObject != null) {
      ((XMPPRosterServiceAdapter)localObject).unregisterUICallback(rosterCallback);
    }
    getInstancereceiver.unbindDisplayActivity(this);
    localObject = xmppServiceConnection;
    try
    {
      unbindService((ServiceConnection)localObject);
      storeExpandedState();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    setMenuItem(paramMenu, 2131297104, getConnectDisconnectIcon(), getConnectDisconnectText());
    setMenuItem(paramMenu, 2131297107, getShowHideMenuIcon(), getShowHideMenuText());
    return true;
  }
  
  public void onResume()
  {
    super.onResume();
    bindXMPPService();
    getInstancereceiver.bindDisplayActivity(this);
    handleSendIntent();
  }
  
  public void removeChatHistory(String paramString)
  {
    getContentResolver().delete(ChatProvider.CONTENT_URI, "jid = ?", new String[] { paramString });
  }
  
  public void removeChatHistoryDialog(String paramString1, String paramString2)
  {
    new AlertDialog.Builder(this).setTitle(2131755534).setMessage(getString(2131755533, new Object[] { paramString2, paramString1 })).setPositiveButton(17039379, (DialogInterface.OnClickListener)new MainWindow.3(this, paramString1)).setNegativeButton(17039369, null).create().show();
  }
  
  public void removeRosterItemDialog(String paramString1, String paramString2)
  {
    new AlertDialog.Builder(this).setTitle(2131755536).setMessage(getString(2131755535, new Object[] { paramString2, paramString1 })).setPositiveButton(17039379, (DialogInterface.OnClickListener)new MainWindow.4(this, paramString1)).setNegativeButton(17039369, null).create().show();
  }
  
  public void renameRosterGroupDialog(String paramString)
  {
    editTextDialog(2131755107, getString(2131755106, new Object[] { paramString }), paramString, new MainWindow.9(this, paramString));
  }
  
  public void renameRosterItemDialog(String paramString1, String paramString2)
  {
    editTextDialog(2131755105, getString(2131755104, new Object[] { paramString2, paramString1 }), paramString2, new MainWindow.8(this, paramString1));
  }
  
  public void restoreGroupsExpanded() {}
  
  public void rosterAddRequestedDialog(String paramString1, String paramString2)
  {
    new AlertDialog.Builder(this).setTitle(2131756464).setMessage(getString(2131756463, new Object[] { paramString1, paramString2 })).setPositiveButton(17039379, (DialogInterface.OnClickListener)new MainWindow.6(this, paramString1)).setNegativeButton(17039369, (DialogInterface.OnClickListener)new MainWindow.5(this, paramString1)).create().show();
  }
  
  public void setAndSaveStatus(StatusMode paramStatusMode, String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this).edit();
    if (paramStatusMode != StatusMode.offline) {
      localEditor.putString("status_mode", ((Enum)paramStatusMode).name());
    }
    if (!paramString.equals(mConfig.statusMessage))
    {
      ArrayList localArrayList = new ArrayList(Arrays.asList(mConfig.statusMessageHistory));
      if (!localArrayList.contains(paramString)) {
        localArrayList.add(paramString);
      }
      localEditor.putString("status_message_history", TextUtils.join("\036", localArrayList));
    }
    localEditor.putString("status_message", paramString);
    localEditor.commit();
    paramString = StatusMode.offline;
    int j = 1;
    int i;
    if ((paramStatusMode == paramString) && (isConnected())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramStatusMode == StatusMode.offline) || (serviceAdapter.getConnectionState() != ConnectionState.OFFLINE)) {
      j = 0;
    }
    if ((j == 0) && (i == 0))
    {
      if (isConnected()) {
        serviceAdapter.setStatusFromConfig();
      }
    }
    else {
      toggleConnection();
    }
  }
  
  public void setMenuItem(Menu paramMenu, int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    paramMenu = paramMenu.findItem(paramInt1);
    if (paramMenu == null) {
      return;
    }
    paramMenu.setIcon(paramInt2);
    paramMenu.setTitle(paramCharSequence);
  }
  
  public void setupContenView()
  {
    setContentView(2131492953);
    mConnectingText = ((TextView)findViewById(2131297953));
    ImageView localImageView = (ImageView)findViewById(2131296912);
    localImageView.setImageResource(2131231706);
    ((AnimationDrawable)localImageView.getDrawable()).start();
  }
  
  public void showToastNotification(int paramInt)
  {
    Toast.makeText(this, paramInt, 0).show();
  }
  
  public void startConnection(boolean paramBoolean)
  {
    xmppServiceIntent.putExtra("create_account", paramBoolean);
    startService(xmppServiceIntent);
  }
  
  public void storeExpandedState()
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this).edit();
    Iterator localIterator = mGroupsExpanded.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("expanded_");
      localStringBuilder.append((String)localEntry.getKey());
      localEditor.putBoolean(localStringBuilder.toString(), ((Boolean)localEntry.getValue()).booleanValue());
    }
    localEditor.commit();
  }
  
  public void updateRoster()
  {
    restoreGroupsExpanded();
  }
}
