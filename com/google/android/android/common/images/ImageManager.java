package com.google.android.android.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.widget.ImageView;
import b.b.x.n.m;
import com.google.android.android.common.internal.TextUtils;
import com.google.android.android.internal.zzbcj;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.images.zza;
import com.google.android.gms.common.images.zzb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import support.android.v4.util.LruCache;

public final class ImageManager
{
  public static final Object zzfrb = new Object();
  public static HashSet<Uri> zzfrc = new HashSet();
  public static ImageManager zzfrd;
  public final Context mContext;
  public final Handler mHandler;
  public final ExecutorService zzfre;
  public final zza zzfrf;
  public final zzbcj zzfrg;
  public final Map<zza, com.google.android.gms.common.images.ImageManager.ImageReceiver> zzfrh;
  public final Map<Uri, com.google.android.gms.common.images.ImageManager.ImageReceiver> zzfri;
  public final Map<Uri, Long> zzfrj;
  
  public ImageManager(Context paramContext, boolean paramBoolean)
  {
    mContext = paramContext.getApplicationContext();
    mHandler = new Handler(Looper.getMainLooper());
    zzfre = Executors.newFixedThreadPool(4);
    zzfrf = null;
    zzfrg = new zzbcj();
    zzfrh = new HashMap();
    zzfri = new HashMap();
    zzfrj = new HashMap();
  }
  
  public static ImageManager create(Context paramContext)
  {
    if (zzfrd == null) {
      zzfrd = new ImageManager(paramContext, false);
    }
    return zzfrd;
  }
  
  private final Bitmap get(BitmapLoader paramBitmapLoader)
  {
    zza localZza = zzfrf;
    if (localZza == null) {
      return null;
    }
    return (Bitmap)localZza.get(paramBitmapLoader);
  }
  
  private final void get(ImageLoader paramImageLoader)
  {
    TextUtils.zzfy("ImageManager.loadImage() must be called in the main thread");
    new zzc(paramImageLoader).run();
  }
  
  public final void loadImage(ImageView paramImageView, int paramInt)
  {
    get(new Layer(paramImageView, paramInt));
  }
  
  public final void loadImage(ImageView paramImageView, Uri paramUri)
  {
    get(new Layer(paramImageView, paramUri));
  }
  
  public final void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    paramImageView = new Layer(paramImageView, paramUri);
    zzfrr = paramInt;
    get(paramImageView);
  }
  
  public final void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    get(new Game(paramOnImageLoadedListener, paramUri));
  }
  
  public final void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    paramOnImageLoadedListener = new Game(paramOnImageLoadedListener, paramUri);
    zzfrr = paramInt;
    get(paramOnImageLoadedListener);
  }
  
  @KeepName
  public final class ImageReceiver
    extends ResultReceiver
  {
    public final Uri mUri;
    public final ArrayList<zza> zzfrk;
    
    public ImageReceiver(Uri paramUri)
    {
      super();
      mUri = paramUri;
      zzfrk = new ArrayList();
    }
    
    public final void Refresh(ImageLoader paramImageLoader)
    {
      TextUtils.zzfy("ImageReceiver.addImageRequest() must be called in the main thread");
      zzfrk.add(paramImageLoader);
    }
    
    public final void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.getExecutor(ImageManager.this).execute(new ImageManager.zzb(ImageManager.this, mUri, paramBundle));
    }
    
    public final void setImageUrl(ImageLoader paramImageLoader)
    {
      TextUtils.zzfy("ImageReceiver.removeImageRequest() must be called in the main thread");
      zzfrk.remove(paramImageLoader);
    }
    
    public final void zzaiz()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.getContext(ImageManager.this).sendBroadcast(localIntent);
    }
  }
  
  public abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }
  
  public final class zza
    extends m<zzb, Bitmap>
  {}
  
  public final class zzb
    implements Runnable
  {
    public final Uri mUri;
    public final ParcelFileDescriptor zzfrm;
    
    public zzb(Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      mUri = paramUri;
      zzfrm = paramParcelFileDescriptor;
    }
    
    public final void run()
    {
      if (Looper.getMainLooper().getThread() != Thread.currentThread())
      {
        bool = false;
        localObject1 = null;
        localObject2 = zzfrm;
        if (localObject2 == null) {}
      }
      try
      {
        localObject2 = BitmapFactory.decodeFileDescriptor(((ParcelFileDescriptor)localObject2).getFileDescriptor());
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          ((ParcelFileDescriptor)localObject2).close();
          break label111;
          localObject1 = null;
          bool = false;
          localObject2 = new CountDownLatch(1);
          ImageManager.getHandler(ImageManager.this).post(new ImageManager.zzd(ImageManager.this, mUri, (Bitmap)localObject1, bool, (CountDownLatch)localObject2));
          try
          {
            ((CountDownLatch)localObject2).await();
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            int i;
            for (;;) {}
          }
          localObject1 = String.valueOf(mUri);
          localObject2 = new StringBuilder(((String)localObject1).length() + 32);
          ((StringBuilder)localObject2).append("Latch interrupted while posting ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).toString();
          return;
          localObject1 = String.valueOf(Thread.currentThread());
          localObject2 = String.valueOf(Looper.getMainLooper().getThread());
          i = ((String)localObject1).length();
          StringBuilder localStringBuilder = new StringBuilder(((String)localObject2).length() + (i + 56));
          localStringBuilder.append("checkNotMainThread: current thread ");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(" IS the main thread ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("!");
          localStringBuilder.toString();
          throw new IllegalStateException("LoadBitmapFromDiskRunnable can't be executed in the main thread");
          localOutOfMemoryError = localOutOfMemoryError;
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
      }
      localObject2 = String.valueOf(mUri);
      localStringBuilder = new StringBuilder(((String)localObject2).length() + 34);
      localStringBuilder.append("OOM while loading bitmap for uri: ");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.toString();
      bool = true;
      localObject2 = zzfrm;
    }
  }
  
  public final class zzc
    implements Runnable
  {
    public final ImageLoader zzfrn;
    
    public zzc(ImageLoader paramImageLoader)
    {
      zzfrn = paramImageLoader;
    }
    
    public final void run()
    {
      TextUtils.zzfy("LoadImageRunnable must be executed on the main thread");
      Object localObject1 = (ImageManager.ImageReceiver)ImageManager.put(ImageManager.this).get(zzfrn);
      if (localObject1 != null)
      {
        ImageManager.put(ImageManager.this).remove(zzfrn);
        ((ImageManager.ImageReceiver)localObject1).setImageUrl(zzfrn);
      }
      localObject1 = zzfrn;
      BitmapLoader localBitmapLoader = zzfrp;
      if (uri == null)
      {
        ((ImageLoader)localObject1).load(ImageManager.getContext(ImageManager.this), ImageManager.getAccount(ImageManager.this), true);
        return;
      }
      localObject1 = ImageManager.get(ImageManager.this, localBitmapLoader);
      if (localObject1 != null)
      {
        zzfrn.load(ImageManager.getContext(ImageManager.this), (Bitmap)localObject1, true);
        return;
      }
      localObject1 = (Long)ImageManager.access$getHostnames(ImageManager.this).get(uri);
      if (localObject1 != null)
      {
        if (SystemClock.elapsedRealtime() - ((Long)localObject1).longValue() < 3600000L)
        {
          zzfrn.load(ImageManager.getContext(ImageManager.this), ImageManager.getAccount(ImageManager.this), true);
          return;
        }
        ImageManager.access$getHostnames(ImageManager.this).remove(uri);
      }
      zzfrn.load(ImageManager.getContext(ImageManager.this), ImageManager.getAccount(ImageManager.this));
      Object localObject2 = (ImageManager.ImageReceiver)ImageManager.get(ImageManager.this).get(uri);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ImageManager.ImageReceiver(ImageManager.this, uri);
        ImageManager.get(ImageManager.this).put(uri, localObject1);
      }
      ((ImageManager.ImageReceiver)localObject1).Refresh(zzfrn);
      if (!(zzfrn instanceof Game)) {
        ImageManager.put(ImageManager.this).put(zzfrn, localObject1);
      }
      localObject2 = ImageManager.zzfrb;
      try
      {
        if (!ImageManager.zzfrc.contains(uri))
        {
          ImageManager.zzfrc.add(uri);
          ((ImageManager.ImageReceiver)localObject1).zzaiz();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
  }
  
  public final class zzd
    implements Runnable
  {
    public final Bitmap mBitmap;
    public final Uri mUri;
    public final CountDownLatch zzaof;
    public boolean zzfro;
    
    public zzd(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
    {
      mUri = paramUri;
      mBitmap = paramBitmap;
      zzfro = paramBoolean;
      zzaof = paramCountDownLatch;
    }
    
    public final void run()
    {
      TextUtils.zzfy("OnBitmapLoadedRunnable must be executed in the main thread");
      int i;
      if (mBitmap != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (ImageManager.getCache(ImageManager.this) != null)
      {
        if (zzfro)
        {
          ImageManager.getCache(ImageManager.this).evictAll();
          System.gc();
          zzfro = false;
          ImageManager.getHandler(ImageManager.this).post(this);
          return;
        }
        if (i != 0) {
          ImageManager.getCache(ImageManager.this).put(new BitmapLoader(mUri), mBitmap);
        }
      }
      Object localObject = (ImageManager.ImageReceiver)ImageManager.get(ImageManager.this).remove(mUri);
      if (localObject != null)
      {
        localObject = ImageManager.ImageReceiver.access$getFiles((ImageManager.ImageReceiver)localObject);
        int k = ((ArrayList)localObject).size();
        int j = 0;
        while (j < k)
        {
          ImageLoader localImageLoader = (ImageLoader)((ArrayList)localObject).get(j);
          if (i != 0)
          {
            localImageLoader.load(ImageManager.getContext(ImageManager.this), mBitmap, false);
          }
          else
          {
            ImageManager.access$getHostnames(ImageManager.this).put(mUri, Long.valueOf(SystemClock.elapsedRealtime()));
            localImageLoader.load(ImageManager.getContext(ImageManager.this), ImageManager.getAccount(ImageManager.this), false);
          }
          if (!(localImageLoader instanceof Game)) {
            ImageManager.put(ImageManager.this).remove(localImageLoader);
          }
          j += 1;
        }
      }
      zzaof.countDown();
      localObject = ImageManager.zzfrb;
      try
      {
        ImageManager.zzfrc.remove(mUri);
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
  }
}
