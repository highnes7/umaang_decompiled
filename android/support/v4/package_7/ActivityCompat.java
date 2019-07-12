package android.support.v4.package_7;

import android.app.Activity;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.DragEvent;
import android.view.View;
import b.b.a.K;
import b.b.a.N;
import java.util.List;
import java.util.Map;
import support.android.classic.net.ByteVector;
import support.android.v4.content.ContextCompat;

public class ActivityCompat
  extends ContextCompat
{
  public static PermissionCompatDelegate sDelegate;
  
  public ActivityCompat() {}
  
  public static void finishAffinity(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    paramActivity.finishAffinity();
  }
  
  public static void finishAfterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.finishAfterTransition();
      return;
    }
    paramActivity.finish();
  }
  
  public static PermissionCompatDelegate getPermissionCompatDelegate()
  {
    return sDelegate;
  }
  
  public static Uri getReferrer(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      return paramActivity.getReferrer();
    }
    paramActivity = paramActivity.getIntent();
    Uri localUri = (Uri)paramActivity.getParcelableExtra("android.intent.extra.REFERRER");
    if (localUri != null) {
      return localUri;
    }
    paramActivity = paramActivity.getStringExtra("android.intent.extra.REFERRER_NAME");
    if (paramActivity != null) {
      return Uri.parse(paramActivity);
    }
    return null;
  }
  
  public static boolean invalidateOptionsMenu(Activity paramActivity)
  {
    paramActivity.invalidateOptionsMenu();
    return true;
  }
  
  public static void postponeEnterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.postponeEnterTransition();
    }
  }
  
  public static ByteVector requestDragAndDropPermissions(Activity paramActivity, DragEvent paramDragEvent)
  {
    return ByteVector.a(paramActivity, paramDragEvent);
  }
  
  public static void requestPermissions(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    PermissionCompatDelegate localPermissionCompatDelegate = sDelegate;
    if ((localPermissionCompatDelegate != null) && (localPermissionCompatDelegate.requestPermissions(paramActivity, paramArrayOfString, paramInt))) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if ((paramActivity instanceof RequestPermissionsRequestCodeValidator)) {
        ((RequestPermissionsRequestCodeValidator)paramActivity).validateRequestPermissionsRequestCode(paramInt);
      }
      paramActivity.requestPermissions(paramArrayOfString, paramInt);
      return;
    }
    if ((paramActivity instanceof OnRequestPermissionsResultCallback)) {
      new Handler(Looper.getMainLooper()).post(new ActivityCompat.1(paramArrayOfString, paramActivity, paramInt));
    }
  }
  
  public static View requireViewById(Activity paramActivity, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramActivity.requireViewById(paramInt);
    }
    paramActivity = paramActivity.findViewById(paramInt);
    if (paramActivity != null) {
      return paramActivity;
    }
    throw new IllegalArgumentException("ID does not reference a View inside this Activity");
  }
  
  public static void setEnterSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramSharedElementCallback != null) {
        paramSharedElementCallback = new SharedElementCallback21Impl(paramSharedElementCallback);
      } else {
        paramSharedElementCallback = null;
      }
      paramActivity.setEnterSharedElementCallback(paramSharedElementCallback);
    }
  }
  
  public static void setExitSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramSharedElementCallback != null) {
        paramSharedElementCallback = new SharedElementCallback21Impl(paramSharedElementCallback);
      } else {
        paramSharedElementCallback = null;
      }
      paramActivity.setExitSharedElementCallback(paramSharedElementCallback);
    }
  }
  
  public static void setPermissionCompatDelegate(PermissionCompatDelegate paramPermissionCompatDelegate)
  {
    sDelegate = paramPermissionCompatDelegate;
  }
  
  public static boolean shouldShowRequestPermissionRationale(Activity paramActivity, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramActivity.shouldShowRequestPermissionRationale(paramString);
    }
    return false;
  }
  
  public static void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    int i = Build.VERSION.SDK_INT;
    paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public static void startIntentSenderForResult(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    int i = Build.VERSION.SDK_INT;
    paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public static void startPostponedEnterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.startPostponedEnterTransition();
    }
  }
  
  public abstract interface OnRequestPermissionsResultCallback
  {
    public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  }
  
  public abstract interface PermissionCompatDelegate
  {
    public abstract boolean onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
    
    public abstract boolean requestPermissions(Activity paramActivity, String[] paramArrayOfString, int paramInt);
  }
  
  @N({b.b.a.N.a.b})
  public abstract interface RequestPermissionsRequestCodeValidator
  {
    public abstract void validateRequestPermissionsRequestCode(int paramInt);
  }
  
  @K(21)
  public class SharedElementCallback21Impl
    extends android.app.SharedElementCallback
  {
    public SharedElementCallback21Impl() {}
    
    public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
    {
      return ActivityCompat.this.onCaptureSharedElementSnapshot(paramView, paramMatrix, paramRectF);
    }
    
    public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
    {
      return ActivityCompat.this.onCreateSnapshotView(paramContext, paramParcelable);
    }
    
    public void onMapSharedElements(List paramList, Map paramMap)
    {
      ActivityCompat.this.onMapSharedElements(paramList, paramMap);
    }
    
    public void onRejectSharedElements(List paramList)
    {
      ActivityCompat.this.onRejectSharedElements(paramList);
    }
    
    public void onSharedElementEnd(List paramList1, List paramList2, List paramList3)
    {
      ActivityCompat.this.onSharedElementEnd(paramList1, paramList2, paramList3);
    }
    
    public void onSharedElementStart(List paramList1, List paramList2, List paramList3)
    {
      ActivityCompat.this.onSharedElementStart(paramList1, paramList2, paramList3);
    }
    
    public void onSharedElementsArrived(List paramList1, List paramList2, SharedElementCallback.OnSharedElementsReadyListener paramOnSharedElementsReadyListener)
    {
      onSharedElementsArrived(paramList1, paramList2, new ActivityCompat.SharedElementCallback21Impl.1(this, paramOnSharedElementsReadyListener));
    }
  }
}
