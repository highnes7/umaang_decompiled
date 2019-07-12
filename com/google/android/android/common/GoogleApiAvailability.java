package com.google.android.android.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentFilter;
import android.content.pm.PackageItemInfo;
import android.content.res.Resources.Theme;
import android.os.Handler;
import android.os.Message;
import android.support.v4.package_7.FragmentActivity;
import android.support.v4.package_7.NotificationCompat.BigTextStyle;
import android.support.v4.package_7.NotificationCompat.Builder;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.android.R.drawable;
import com.google.android.android.R.string;
import com.google.android.android.common.internal.ListItem;
import com.google.android.android.common.package_9.GoogleApi;
import com.google.android.android.common.package_9.GoogleApiActivity;
import com.google.android.android.common.package_9.internal.AbstractGalleryActivity;
import com.google.android.android.common.package_9.internal.zzby;
import com.google.android.android.common.package_9.internal.zzbz;
import com.google.android.android.common.package_9.internal.zzcg;
import com.google.android.android.common.package_9.internal.zzco;
import com.google.android.android.common.util.IpAddress;
import com.google.android.android.common.util.KeyguardManager;
import com.google.android.android.tasks.Task;
import com.google.android.android.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GoogleApiAvailability
  extends PingManager
{
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = PingManager.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  public static final GoogleApiAvailability zzffi = new GoogleApiAvailability();
  
  public GoogleApiAvailability() {}
  
  public static Dialog create(Context paramContext, int paramInt, ListItem paramListItem, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AlertDialog.Builder localBuilder = null;
    if (paramInt == 0) {
      return null;
    }
    Object localObject = new TypedValue();
    paramContext.getTheme().resolveAttribute(16843529, (TypedValue)localObject, true);
    if ("Theme.Dialog.Alert".equals(paramContext.getResources().getResourceEntryName(resourceId))) {
      localBuilder = new AlertDialog.Builder(paramContext, 5);
    }
    localObject = localBuilder;
    if (localBuilder == null) {
      localObject = new AlertDialog.Builder(paramContext);
    }
    ((AlertDialog.Builder)localObject).setMessage(com.google.android.android.common.internal.Resources.getValue(paramContext, paramInt));
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject).setOnCancelListener(paramOnCancelListener);
    }
    paramOnCancelListener = com.google.android.android.common.internal.Resources.getTitle(paramContext, paramInt);
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject).setPositiveButton(paramOnCancelListener, paramListItem);
    }
    paramContext = com.google.android.android.common.internal.Resources.getString(paramContext, paramInt);
    if (paramContext != null) {
      ((AlertDialog.Builder)localObject).setTitle(paramContext);
    }
    return ((AlertDialog.Builder)localObject).create();
  }
  
  private final void createNotification(Context paramContext, int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    if (paramInt == 18)
    {
      zzbt(paramContext);
      return;
    }
    if (paramPendingIntent == null) {
      return;
    }
    paramString = com.google.android.android.common.internal.Resources.getText(paramContext, paramInt);
    String str = com.google.android.android.common.internal.Resources.toString(paramContext, paramInt);
    android.content.res.Resources localResources = paramContext.getResources();
    if (IpAddress.zzcj(paramContext))
    {
      com.google.android.android.common.internal.zzbp.zzbg(KeyguardManager.zzali());
      paramString = new Notification.Builder(paramContext).setSmallIcon(getApplicationInfoicon).setPriority(2).setAutoCancel(true).setContentTitle(paramString).setStyle(new Notification.BigTextStyle().bigText(str)).addAction(R.drawable.common_full_open_on_phone, localResources.getString(R.string.common_open_on_phone), paramPendingIntent).build();
    }
    else
    {
      paramString = new NotificationCompat.Builder(paramContext, null).setSmallIcon(17301642).setTicker(localResources.getString(R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(paramPendingIntent).setContentTitle(paramString).setContentText(str).setLocalOnly(true).setStyle(new NotificationCompat.BigTextStyle().bigText(str)).build();
    }
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      paramInt = 39789;
    }
    else
    {
      paramInt = 10436;
      TransactionInput.zzfga.set(false);
    }
    ((NotificationManager)paramContext.getSystemService("notification")).notify(paramInt, paramString);
  }
  
  public static GoogleApiAvailability getInstance()
  {
    return zzffi;
  }
  
  public static Dialog show(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Object localObject = new ProgressBar(paramActivity, null, 16842874);
    ((ProgressBar)localObject).setIndeterminate(true);
    ((ProgressBar)localObject).setVisibility(0);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setView((View)localObject);
    localBuilder.setMessage(com.google.android.android.common.internal.Resources.getValue(paramActivity, 18));
    localBuilder.setPositiveButton("", null);
    localObject = localBuilder.create();
    showDialog(paramActivity, (Dialog)localObject, "GooglePlayServicesUpdatingDialog", paramOnCancelListener);
    return localObject;
  }
  
  public static void showDialog(Activity paramActivity, Dialog paramDialog, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if ((paramActivity instanceof FragmentActivity))
    {
      paramActivity = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      SupportErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
      return;
    }
    paramActivity = paramActivity.getFragmentManager();
    ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
  }
  
  public static zzby start(Context paramContext, zzbz paramZzbz)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addDataScheme("package");
    zzby localZzby = new zzby(paramZzbz);
    paramContext.registerReceiver(localZzby, localIntentFilter);
    localZzby.setContext(paramContext);
    if (!TransactionInput.load(paramContext, "com.google.android.gms"))
    {
      paramZzbz.zzage();
      localZzby.unregister();
      return null;
    }
    return localZzby;
  }
  
  public Task checkApiAvailability(GoogleApi paramGoogleApi, GoogleApi... paramVarArgs)
  {
    com.google.android.android.common.internal.zzbp.get(paramGoogleApi, "Requested API must not be null.");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      com.google.android.android.common.internal.zzbp.get(paramVarArgs[i], "Requested API must not be null.");
      i += 1;
    }
    ArrayList localArrayList = new ArrayList(paramVarArgs.length + 1);
    localArrayList.add(paramGoogleApi);
    localArrayList.addAll(Arrays.asList(paramVarArgs));
    return com.google.android.android.common.package_9.internal.zzbp.zzaho().connect(localArrayList);
  }
  
  public final boolean create(Activity paramActivity, zzcg paramZzcg, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramZzcg = create(paramActivity, paramInt1, ListItem.toString(paramZzcg, PingManager.get(paramActivity, paramInt1, "d"), 2), paramOnCancelListener);
    if (paramZzcg == null) {
      return false;
    }
    showDialog(paramActivity, paramZzcg, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return getErrorDialog(paramActivity, paramInt1, paramInt2, null);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return create(paramActivity, paramInt1, ListItem.setTitle(paramActivity, PingManager.get(paramActivity, paramInt1, "d"), paramInt2), paramOnCancelListener);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    return init(paramContext, paramInt1, paramInt2, null);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.hasResolution()) {
      return paramConnectionResult.getResolution();
    }
    return getErrorResolutionPendingIntent(paramContext, paramConnectionResult.getErrorCode(), 0);
  }
  
  public final String getErrorString(int paramInt)
  {
    return TransactionInput.getErrorString(paramInt);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    return super.isGooglePlayServicesAvailable(paramContext);
  }
  
  public final boolean isUserResolvableError(int paramInt)
  {
    return TransactionInput.isUserRecoverableError(paramInt);
  }
  
  public Task makeGooglePlayServicesAvailable(Activity paramActivity)
  {
    com.google.android.android.common.internal.zzbp.zzfy("makeGooglePlayServicesAvailable must be called from the main thread");
    int i = isGooglePlayServicesAvailable(paramActivity);
    if (i == 0) {
      return Tasks.forResult(null);
    }
    paramActivity = zzco.findAll(paramActivity);
    paramActivity.clear(new ConnectionResult(i, null), 0);
    return paramActivity.getTask();
  }
  
  public final boolean setCurrentTheme(Context paramContext, ConnectionResult paramConnectionResult, int paramInt)
  {
    PendingIntent localPendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    if (localPendingIntent != null)
    {
      createNotification(paramContext, paramConnectionResult.getErrorCode(), null, GoogleApiActivity.createPendingIntent(paramContext, localPendingIntent, paramInt));
      return true;
    }
    return false;
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return showErrorDialogFragment(paramActivity, paramInt1, paramInt2, null);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Dialog localDialog = getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
    if (localDialog == null) {
      return false;
    }
    showDialog(paramActivity, localDialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public void showErrorNotification(Context paramContext, int paramInt)
  {
    createNotification(paramContext, paramInt, null, init(paramContext, paramInt, 0, "n"));
  }
  
  public void showErrorNotification(Context paramContext, ConnectionResult paramConnectionResult)
  {
    PendingIntent localPendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    createNotification(paramContext, paramConnectionResult.getErrorCode(), null, localPendingIntent);
  }
  
  public final void zzbt(Context paramContext)
  {
    new zza(paramContext).sendEmptyMessageDelayed(1, 120000L);
  }
  
  @SuppressLint({"HandlerLeak"})
  public final class zza
    extends Handler
  {
    public final Context mApplicationContext;
    
    public zza(Context paramContext)
    {
      super();
      mApplicationContext = paramContext.getApplicationContext();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i = what;
      if (i != 1)
      {
        paramMessage = new StringBuilder(50);
        paramMessage.append("Don't know how to handle this message: ");
        paramMessage.append(i);
        paramMessage.toString();
        return;
      }
      i = isGooglePlayServicesAvailable(mApplicationContext);
      if (isUserResolvableError(i)) {
        showErrorNotification(mApplicationContext, i);
      }
    }
  }
}
