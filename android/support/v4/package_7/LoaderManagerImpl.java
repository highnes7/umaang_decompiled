package android.support.v4.package_7;

import android.arch.lifecycle.LiveData;
import android.os.Bundle;
import android.os.Looper;
import b.a.b.r;
import b.a.b.s;
import b.b.a.F;
import b.b.a.G;
import b.b.x.b.f;
import b.b.x.b.f.c;
import b.b.x.n.u;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import support.android.v4.content.Loader;
import support.android.v4.util.DebugUtils;
import support.android.v4.util.SparseArrayCompat;
import support.support.asm.Line;
import support.support.asm.Log;
import support.support.asm.Observer;
import support.support.asm.Settings;
import support.support.asm.Track;
import support.support.asm.Type;
import support.support.asm.d;

public class LoaderManagerImpl
  extends LoaderManager
{
  public static boolean DEBUG = false;
  public static final String TAG = "LoaderManager";
  @F
  public final d mLifecycleOwner;
  @F
  public final LoaderViewModel mLoaderViewModel;
  
  public LoaderManagerImpl(d paramD, Line paramLine)
  {
    mLifecycleOwner = paramD;
    mLoaderViewModel = LoaderViewModel.getInstance(paramLine);
  }
  
  private Loader createAndInstallLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks paramLoaderCallbacks, Loader paramLoader)
  {
    try
    {
      mLoaderViewModel.startCreatingLoader();
      Loader localLoader = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
      if (localLoader != null)
      {
        boolean bool = localLoader.getClass().isMemberClass();
        if (bool)
        {
          bool = Modifier.isStatic(localLoader.getClass().getModifiers());
          if (!bool)
          {
            paramBundle = new StringBuilder();
            paramBundle.append("Object returned from onCreateLoader must not be a non-static inner member class: ");
            paramBundle.append(localLoader);
            throw new IllegalArgumentException(paramBundle.toString());
          }
        }
        paramBundle = new LoaderInfo(paramInt, paramBundle, localLoader, paramLoader);
        bool = DEBUG;
        if (bool)
        {
          paramLoader = new StringBuilder();
          paramLoader.append("  Created new loader ");
          paramLoader.append(paramBundle);
          paramLoader.toString();
        }
        mLoaderViewModel.putLoader(paramInt, paramBundle);
        mLoaderViewModel.finishCreatingLoader();
        return paramBundle.setCallback(mLifecycleOwner, paramLoaderCallbacks);
      }
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
    }
    catch (Throwable paramBundle)
    {
      mLoaderViewModel.finishCreatingLoader();
      throw paramBundle;
    }
  }
  
  public void destroyLoader(int paramInt)
  {
    if (!mLoaderViewModel.isCreatingLoader())
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        if (DEBUG)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("destroyLoader in ");
          ((StringBuilder)localObject).append(this);
          ((StringBuilder)localObject).append(" of ");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).toString();
        }
        Object localObject = mLoaderViewModel.getLoader(paramInt);
        if (localObject != null)
        {
          ((LoaderInfo)localObject).destroy(true);
          mLoaderViewModel.removeLoader(paramInt);
        }
      }
      else
      {
        throw new IllegalStateException("destroyLoader must be called on the main thread");
      }
    }
    else {
      throw new IllegalStateException("Called while creating a loader");
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    mLoaderViewModel.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public Loader getLoader(int paramInt)
  {
    if (!mLoaderViewModel.isCreatingLoader())
    {
      LoaderInfo localLoaderInfo = mLoaderViewModel.getLoader(paramInt);
      if (localLoaderInfo != null) {
        return localLoaderInfo.getLoader();
      }
      return null;
    }
    throw new IllegalStateException("Called while creating a loader");
  }
  
  public boolean hasRunningLoaders()
  {
    return mLoaderViewModel.hasRunningLoaders();
  }
  
  public Loader initLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks paramLoaderCallbacks)
  {
    if (!mLoaderViewModel.isCreatingLoader())
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        LoaderInfo localLoaderInfo = mLoaderViewModel.getLoader(paramInt);
        if (DEBUG)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initLoader in ");
          localStringBuilder.append(this);
          localStringBuilder.append(": args=");
          localStringBuilder.append(paramBundle);
          localStringBuilder.toString();
        }
        if (localLoaderInfo == null) {
          return createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks, null);
        }
        if (DEBUG) {
          f.sufficientlysecure.rootcommands.util.StringBuilder.append("  Re-using existing loader ", localLoaderInfo);
        }
        return localLoaderInfo.setCallback(mLifecycleOwner, paramLoaderCallbacks);
      }
      throw new IllegalStateException("initLoader must be called on the main thread");
    }
    throw new IllegalStateException("Called while creating a loader");
  }
  
  public void markForRedelivery()
  {
    mLoaderViewModel.markForRedelivery();
  }
  
  public Loader restartLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks paramLoaderCallbacks)
  {
    if (!mLoaderViewModel.isCreatingLoader())
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        if (DEBUG)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("restartLoader in ");
          ((StringBuilder)localObject).append(this);
          ((StringBuilder)localObject).append(": args=");
          ((StringBuilder)localObject).append(paramBundle);
          ((StringBuilder)localObject).toString();
        }
        LoaderInfo localLoaderInfo = mLoaderViewModel.getLoader(paramInt);
        Object localObject = null;
        if (localLoaderInfo != null) {
          localObject = localLoaderInfo.destroy(false);
        }
        return createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks, (Loader)localObject);
      }
      throw new IllegalStateException("restartLoader must be called on the main thread");
    }
    throw new IllegalStateException("Called while creating a loader");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(mLifecycleOwner, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  public class LoaderInfo<D>
    extends r<D>
    implements f.c<D>
  {
    @G
    public final Bundle mArgs;
    public final int mId;
    public d mLifecycleOwner;
    @F
    public final f<D> mLoader;
    public android.support.v4.app.LoaderManagerImpl.LoaderObserver<D> mObserver;
    public f<D> mPriorLoader;
    
    public LoaderInfo(Bundle paramBundle, Loader paramLoader1, Loader paramLoader2)
    {
      mId = this$1;
      mArgs = paramBundle;
      mLoader = paramLoader1;
      mPriorLoader = paramLoader2;
      mLoader.registerListener(this$1, this);
    }
    
    public Loader destroy(boolean paramBoolean)
    {
      if (LoaderManagerImpl.DEBUG) {
        f.sufficientlysecure.rootcommands.util.StringBuilder.append("  Destroying: ", this);
      }
      mLoader.cancelLoad();
      mLoader.abandon();
      LoaderManagerImpl.LoaderObserver localLoaderObserver = mObserver;
      if (localLoaderObserver != null)
      {
        removeObserver(localLoaderObserver);
        if (paramBoolean) {
          localLoaderObserver.reset();
        }
      }
      mLoader.unregisterListener(this);
      if (((localLoaderObserver != null) && (!localLoaderObserver.hasDeliveredData())) || (paramBoolean))
      {
        mLoader.reset();
        return mPriorLoader;
      }
      return mLoader;
    }
    
    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mId=");
      paramPrintWriter.print(mId);
      paramPrintWriter.print(" mArgs=");
      paramPrintWriter.println(mArgs);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mLoader=");
      paramPrintWriter.println(mLoader);
      mLoader.dump(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, "  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      if (mObserver != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mCallbacks=");
        paramPrintWriter.println(mObserver);
        paramFileDescriptor = mObserver;
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append(paramString);
        paramArrayOfString.append("  ");
        paramFileDescriptor.dump(paramArrayOfString.toString(), paramPrintWriter);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mData=");
      paramPrintWriter.println(getLoader().dataToString(getValue()));
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.println(hasActiveObservers());
    }
    
    public Loader getLoader()
    {
      return mLoader;
    }
    
    public boolean isCallbackWaitingForData()
    {
      if (!hasActiveObservers()) {
        return false;
      }
      LoaderManagerImpl.LoaderObserver localLoaderObserver = mObserver;
      return (localLoaderObserver != null) && (!localLoaderObserver.hasDeliveredData());
    }
    
    public void markForRedelivery()
    {
      d localD = mLifecycleOwner;
      LoaderManagerImpl.LoaderObserver localLoaderObserver = mObserver;
      if ((localD != null) && (localLoaderObserver != null))
      {
        super.removeObserver(localLoaderObserver);
        observe(localD, localLoaderObserver);
      }
    }
    
    public void onActive()
    {
      if (LoaderManagerImpl.DEBUG) {
        f.sufficientlysecure.rootcommands.util.StringBuilder.append("  Starting: ", this);
      }
      mLoader.startLoading();
    }
    
    public void onInactive()
    {
      if (LoaderManagerImpl.DEBUG) {
        f.sufficientlysecure.rootcommands.util.StringBuilder.append("  Stopping: ", this);
      }
      mLoader.stopLoading();
    }
    
    public void onLoadComplete(Loader paramLoader, Object paramObject)
    {
      if (LoaderManagerImpl.DEBUG) {
        f.sufficientlysecure.rootcommands.util.StringBuilder.append("onLoadComplete: ", this);
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        setValue(paramObject);
        return;
      }
      boolean bool = LoaderManagerImpl.DEBUG;
      postValue(paramObject);
    }
    
    public void removeObserver(Observer paramObserver)
    {
      super.removeObserver(paramObserver);
      mLifecycleOwner = null;
      mObserver = null;
    }
    
    public Loader setCallback(d paramD, LoaderManager.LoaderCallbacks paramLoaderCallbacks)
    {
      paramLoaderCallbacks = new LoaderManagerImpl.LoaderObserver(mLoader, paramLoaderCallbacks);
      observe(paramD, paramLoaderCallbacks);
      LoaderManagerImpl.LoaderObserver localLoaderObserver = mObserver;
      if (localLoaderObserver != null) {
        removeObserver(localLoaderObserver);
      }
      mLifecycleOwner = paramD;
      mObserver = paramLoaderCallbacks;
      return mLoader;
    }
    
    public void setValue(Object paramObject)
    {
      super.setValue(paramObject);
      paramObject = mPriorLoader;
      if (paramObject != null)
      {
        paramObject.reset();
        mPriorLoader = null;
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("LoaderInfo{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" #");
      localStringBuilder.append(mId);
      localStringBuilder.append(" : ");
      DebugUtils.buildShortClassTag(mLoader, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
  
  public class LoaderObserver<D>
    implements s<D>
  {
    @F
    public final android.support.v4.app.LoaderManager.LoaderCallbacks<D> mCallback;
    public boolean mDeliveredData = false;
    
    public LoaderObserver(LoaderManager.LoaderCallbacks paramLoaderCallbacks)
    {
      mCallback = paramLoaderCallbacks;
    }
    
    public void dump(String paramString, PrintWriter paramPrintWriter)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mDeliveredData=");
      paramPrintWriter.println(mDeliveredData);
    }
    
    public boolean hasDeliveredData()
    {
      return mDeliveredData;
    }
    
    public void onChanged(Object paramObject)
    {
      if (LoaderManagerImpl.DEBUG)
      {
        StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("  onLoadFinished in ");
        localStringBuilder.append(LoaderManagerImpl.this);
        localStringBuilder.append(": ");
        localStringBuilder.append(dataToString(paramObject));
        localStringBuilder.toString();
      }
      mCallback.onLoadFinished(LoaderManagerImpl.this, paramObject);
      mDeliveredData = true;
    }
    
    public void reset()
    {
      if (mDeliveredData)
      {
        if (LoaderManagerImpl.DEBUG)
        {
          StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("  Resetting: ");
          localStringBuilder.append(LoaderManagerImpl.this);
          localStringBuilder.toString();
        }
        mCallback.onLoaderReset(LoaderManagerImpl.this);
      }
    }
    
    public String toString()
    {
      return mCallback.toString();
    }
  }
  
  public class LoaderViewModel
    extends Track
  {
    public static final Type FACTORY = new Type()
    {
      public Track create(Class paramAnonymousClass)
      {
        return new LoaderManagerImpl.LoaderViewModel();
      }
    };
    public boolean mCreatingLoader = false;
    public u<android.support.v4.app.LoaderManagerImpl.LoaderInfo> mLoaders = new SparseArrayCompat(10);
    
    public LoaderViewModel() {}
    
    public static LoaderViewModel getInstance(Line paramLine)
    {
      return (LoaderViewModel)new Settings(paramLine, FACTORY).build(android.support.v4.app.LoaderManagerImpl.LoaderViewModel.class);
    }
    
    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      if (mLoaders.size() > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Loaders:");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("    ");
        localObject = ((StringBuilder)localObject).toString();
        int i = 0;
        while (i < mLoaders.size())
        {
          LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)mLoaders.valueAt(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(mLoaders.keyAt(i));
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localLoaderInfo.toString());
          localLoaderInfo.dump((String)localObject, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          i += 1;
        }
      }
    }
    
    public void finishCreatingLoader()
    {
      mCreatingLoader = false;
    }
    
    public LoaderManagerImpl.LoaderInfo getLoader(int paramInt)
    {
      return (LoaderManagerImpl.LoaderInfo)mLoaders.get(paramInt);
    }
    
    public boolean hasRunningLoaders()
    {
      int j = mLoaders.size();
      int i = 0;
      while (i < j)
      {
        if (((LoaderManagerImpl.LoaderInfo)mLoaders.valueAt(i)).isCallbackWaitingForData()) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public boolean isCreatingLoader()
    {
      return mCreatingLoader;
    }
    
    public void markForRedelivery()
    {
      int j = mLoaders.size();
      int i = 0;
      while (i < j)
      {
        ((LoaderManagerImpl.LoaderInfo)mLoaders.valueAt(i)).markForRedelivery();
        i += 1;
      }
    }
    
    public void onCleared()
    {
      int j = mLoaders.size();
      int i = 0;
      while (i < j)
      {
        ((LoaderManagerImpl.LoaderInfo)mLoaders.valueAt(i)).destroy(true);
        i += 1;
      }
      mLoaders.clear();
    }
    
    public void putLoader(int paramInt, LoaderManagerImpl.LoaderInfo paramLoaderInfo)
    {
      mLoaders.put(paramInt, paramLoaderInfo);
    }
    
    public void removeLoader(int paramInt)
    {
      mLoaders.put(paramInt);
    }
    
    public void startCreatingLoader()
    {
      mCreatingLoader = true;
    }
  }
}
