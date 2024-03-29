package support.android.v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import b.b.x.b.f.b;
import b.b.x.b.f.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import support.android.v4.util.DebugUtils;

public class Loader<D>
{
  public boolean mAbandoned = false;
  public boolean mContentChanged = false;
  public Context mContext;
  public int mId;
  public f.c<D> mListener;
  public f.b<D> mOnLoadCanceledListener;
  public boolean mProcessingChange = false;
  public boolean mReset = true;
  public boolean mStarted = false;
  
  public Loader(Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
  }
  
  public void abandon()
  {
    mAbandoned = true;
    onAbandon();
  }
  
  public boolean cancelLoad()
  {
    return onCancelLoad();
  }
  
  public void commitContentChanged()
  {
    mProcessingChange = false;
  }
  
  public String dataToString(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    DebugUtils.buildShortClassTag(paramObject, localStringBuilder);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void deliverCancellation()
  {
    OnLoadCanceledListener localOnLoadCanceledListener = mOnLoadCanceledListener;
    if (localOnLoadCanceledListener != null) {
      localOnLoadCanceledListener.onLoadCanceled(this);
    }
  }
  
  public void deliverResult(Object paramObject)
  {
    OnLoadCompleteListener localOnLoadCompleteListener = mListener;
    if (localOnLoadCompleteListener != null) {
      localOnLoadCompleteListener.onLoadComplete(this, paramObject);
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(mId);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(mListener);
    if ((mStarted) || (mContentChanged) || (mProcessingChange))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(mStarted);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(mContentChanged);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(mProcessingChange);
    }
    if ((mAbandoned) || (mReset))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(mAbandoned);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(mReset);
    }
  }
  
  public void forceLoad()
  {
    onForceLoad();
  }
  
  public Context getContext()
  {
    return mContext;
  }
  
  public int getId()
  {
    return mId;
  }
  
  public boolean isAbandoned()
  {
    return mAbandoned;
  }
  
  public boolean isReset()
  {
    return mReset;
  }
  
  public boolean isStarted()
  {
    return mStarted;
  }
  
  public void onAbandon() {}
  
  public boolean onCancelLoad()
  {
    return false;
  }
  
  public void onContentChanged()
  {
    if (mStarted)
    {
      forceLoad();
      return;
    }
    mContentChanged = true;
  }
  
  public void onForceLoad() {}
  
  public void onReset() {}
  
  public void onStartLoading() {}
  
  public void onStopLoading() {}
  
  public void registerListener(int paramInt, OnLoadCompleteListener paramOnLoadCompleteListener)
  {
    if (mListener == null)
    {
      mListener = paramOnLoadCompleteListener;
      mId = paramInt;
      return;
    }
    throw new IllegalStateException("There is already a listener registered");
  }
  
  public void registerOnLoadCanceledListener(OnLoadCanceledListener paramOnLoadCanceledListener)
  {
    if (mOnLoadCanceledListener == null)
    {
      mOnLoadCanceledListener = paramOnLoadCanceledListener;
      return;
    }
    throw new IllegalStateException("There is already a listener registered");
  }
  
  public void reset()
  {
    onReset();
    mReset = true;
    mStarted = false;
    mAbandoned = false;
    mContentChanged = false;
    mProcessingChange = false;
  }
  
  public void rollbackContentChanged()
  {
    if (mProcessingChange) {
      onContentChanged();
    }
  }
  
  public final void startLoading()
  {
    mStarted = true;
    mReset = false;
    mAbandoned = false;
    onStartLoading();
  }
  
  public void stopLoading()
  {
    mStarted = false;
    onStopLoading();
  }
  
  public boolean takeContentChanged()
  {
    boolean bool = mContentChanged;
    mContentChanged = false;
    mProcessingChange |= bool;
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    DebugUtils.buildShortClassTag(this, localStringBuilder);
    localStringBuilder.append(" id=");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, mId, "}");
  }
  
  public void unregisterListener(OnLoadCompleteListener paramOnLoadCompleteListener)
  {
    OnLoadCompleteListener localOnLoadCompleteListener = mListener;
    if (localOnLoadCompleteListener != null)
    {
      if (localOnLoadCompleteListener == paramOnLoadCompleteListener)
      {
        mListener = null;
        return;
      }
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    throw new IllegalStateException("No listener register");
  }
  
  public void unregisterOnLoadCanceledListener(OnLoadCanceledListener paramOnLoadCanceledListener)
  {
    OnLoadCanceledListener localOnLoadCanceledListener = mOnLoadCanceledListener;
    if (localOnLoadCanceledListener != null)
    {
      if (localOnLoadCanceledListener == paramOnLoadCanceledListener)
      {
        mOnLoadCanceledListener = null;
        return;
      }
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    throw new IllegalStateException("No listener register");
  }
  
  public final class ForceLoadContentObserver
    extends ContentObserver
  {
    public ForceLoadContentObserver()
    {
      super();
    }
    
    public boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public void onChange(boolean paramBoolean)
    {
      onContentChanged();
    }
  }
  
  public abstract interface OnLoadCanceledListener<D>
  {
    public abstract void onLoadCanceled(Loader paramLoader);
  }
  
  public abstract interface OnLoadCompleteListener<D>
  {
    public abstract void onLoadComplete(Loader paramLoader, Object paramObject);
  }
}
