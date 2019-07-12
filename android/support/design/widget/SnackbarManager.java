package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class SnackbarManager
{
  public static final int LONG_DURATION_MS = 2750;
  public static final int MSG_TIMEOUT = 0;
  public static final int SHORT_DURATION_MS = 1500;
  public static SnackbarManager snackbarManager;
  public SnackbarRecord currentSnackbar;
  public final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      if (what != 0) {
        return false;
      }
      handleTimeout((SnackbarManager.SnackbarRecord)obj);
      return true;
    }
  });
  public final Object lock = new Object();
  public SnackbarRecord nextSnackbar;
  
  public SnackbarManager() {}
  
  private boolean cancelSnackbarLocked(SnackbarRecord paramSnackbarRecord, int paramInt)
  {
    Callback localCallback = (Callback)callback.get();
    if (localCallback != null)
    {
      handler.removeCallbacksAndMessages(paramSnackbarRecord);
      localCallback.dismiss(paramInt);
      return true;
    }
    return false;
  }
  
  public static SnackbarManager getInstance()
  {
    if (snackbarManager == null) {
      snackbarManager = new SnackbarManager();
    }
    return snackbarManager;
  }
  
  private boolean isCurrentSnackbarLocked(Callback paramCallback)
  {
    SnackbarRecord localSnackbarRecord = currentSnackbar;
    return (localSnackbarRecord != null) && (localSnackbarRecord.isSnackbar(paramCallback));
  }
  
  private boolean isNextSnackbarLocked(Callback paramCallback)
  {
    SnackbarRecord localSnackbarRecord = nextSnackbar;
    return (localSnackbarRecord != null) && (localSnackbarRecord.isSnackbar(paramCallback));
  }
  
  private void scheduleTimeoutLocked(SnackbarRecord paramSnackbarRecord)
  {
    int i = duration;
    if (i == -2) {
      return;
    }
    if (i <= 0) {
      if (i == -1) {
        i = 1500;
      } else {
        i = 2750;
      }
    }
    handler.removeCallbacksAndMessages(paramSnackbarRecord);
    Handler localHandler = handler;
    localHandler.sendMessageDelayed(Message.obtain(localHandler, 0, paramSnackbarRecord), i);
  }
  
  private void showNextSnackbarLocked()
  {
    Object localObject = nextSnackbar;
    if (localObject != null)
    {
      currentSnackbar = ((SnackbarRecord)localObject);
      nextSnackbar = null;
      localObject = (Callback)currentSnackbar.callback.get();
      if (localObject != null)
      {
        ((Callback)localObject).show();
        return;
      }
      currentSnackbar = null;
    }
  }
  
  public void dismiss(Callback paramCallback, int paramInt)
  {
    Object localObject = lock;
    try
    {
      if (isCurrentSnackbarLocked(paramCallback)) {
        cancelSnackbarLocked(currentSnackbar, paramInt);
      } else if (isNextSnackbarLocked(paramCallback)) {
        cancelSnackbarLocked(nextSnackbar, paramInt);
      }
      return;
    }
    catch (Throwable paramCallback)
    {
      throw paramCallback;
    }
  }
  
  public void handleTimeout(SnackbarRecord paramSnackbarRecord)
  {
    Object localObject = lock;
    try
    {
      if ((currentSnackbar == paramSnackbarRecord) || (nextSnackbar == paramSnackbarRecord)) {
        cancelSnackbarLocked(paramSnackbarRecord, 2);
      }
      return;
    }
    catch (Throwable paramSnackbarRecord)
    {
      throw paramSnackbarRecord;
    }
  }
  
  public boolean isCurrent(Callback paramCallback)
  {
    Object localObject = lock;
    try
    {
      boolean bool = isCurrentSnackbarLocked(paramCallback);
      return bool;
    }
    catch (Throwable paramCallback)
    {
      throw paramCallback;
    }
  }
  
  public boolean isCurrentOrNext(Callback paramCallback)
  {
    Object localObject = lock;
    for (;;)
    {
      try
      {
        if (isCurrentSnackbarLocked(paramCallback)) {
          break label40;
        }
        if (!isNextSnackbarLocked(paramCallback)) {
          break label35;
        }
      }
      catch (Throwable paramCallback)
      {
        throw paramCallback;
      }
      return bool;
      label35:
      boolean bool = false;
      continue;
      label40:
      bool = true;
    }
  }
  
  public void onDismissed(Callback paramCallback)
  {
    Object localObject = lock;
    try
    {
      if (isCurrentSnackbarLocked(paramCallback))
      {
        currentSnackbar = null;
        if (nextSnackbar != null) {
          showNextSnackbarLocked();
        }
      }
      return;
    }
    catch (Throwable paramCallback)
    {
      throw paramCallback;
    }
  }
  
  public void onShown(Callback paramCallback)
  {
    Object localObject = lock;
    try
    {
      if (isCurrentSnackbarLocked(paramCallback)) {
        scheduleTimeoutLocked(currentSnackbar);
      }
      return;
    }
    catch (Throwable paramCallback)
    {
      throw paramCallback;
    }
  }
  
  public void pauseTimeout(Callback paramCallback)
  {
    Object localObject = lock;
    try
    {
      if ((isCurrentSnackbarLocked(paramCallback)) && (!currentSnackbar.paused))
      {
        currentSnackbar.paused = true;
        handler.removeCallbacksAndMessages(currentSnackbar);
      }
      return;
    }
    catch (Throwable paramCallback)
    {
      throw paramCallback;
    }
  }
  
  public void restoreTimeoutIfPaused(Callback paramCallback)
  {
    Object localObject = lock;
    try
    {
      if ((isCurrentSnackbarLocked(paramCallback)) && (currentSnackbar.paused))
      {
        currentSnackbar.paused = false;
        scheduleTimeoutLocked(currentSnackbar);
      }
      return;
    }
    catch (Throwable paramCallback)
    {
      throw paramCallback;
    }
  }
  
  public void show(int paramInt, Callback paramCallback)
  {
    Object localObject = lock;
    try
    {
      if (isCurrentSnackbarLocked(paramCallback))
      {
        currentSnackbar.duration = paramInt;
        handler.removeCallbacksAndMessages(currentSnackbar);
        scheduleTimeoutLocked(currentSnackbar);
        return;
      }
      if (isNextSnackbarLocked(paramCallback)) {
        nextSnackbar.duration = paramInt;
      } else {
        nextSnackbar = new SnackbarRecord(paramInt, paramCallback);
      }
      if ((currentSnackbar != null) && (cancelSnackbarLocked(currentSnackbar, 4))) {
        return;
      }
      currentSnackbar = null;
      showNextSnackbarLocked();
      return;
    }
    catch (Throwable paramCallback)
    {
      throw paramCallback;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void dismiss(int paramInt);
    
    public abstract void show();
  }
  
  private static class SnackbarRecord
  {
    public final WeakReference<SnackbarManager.Callback> callback;
    public int duration;
    public boolean paused;
    
    public SnackbarRecord(int paramInt, SnackbarManager.Callback paramCallback)
    {
      callback = new WeakReference(paramCallback);
      duration = paramInt;
    }
    
    public boolean isSnackbar(SnackbarManager.Callback paramCallback)
    {
      return (paramCallback != null) && (callback.get() == paramCallback);
    }
  }
}
