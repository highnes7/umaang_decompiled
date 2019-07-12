package support.android.v4.print;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.Margins;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import b.b.a.K;
import java.io.FileNotFoundException;

public final class PrintHelperKitkat
{
  public static final boolean $assertionsDisabled;
  public static final int COLOR_MODE_COLOR = 2;
  @SuppressLint({"InlinedApi"})
  public static final int COLOR_MODE_MONOCHROME = 1;
  public static final String LOG_TAG = "PrintHelper";
  public static final int MAX_PRINT_SIZE = 3500;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  @SuppressLint({"InlinedApi"})
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  public static final boolean e;
  public int mColorMode = 2;
  public final Context mContext;
  public BitmapFactory.Options mDecodeOptions = null;
  public final Object mLock = new Object();
  public int mOrientation = 1;
  public int mScaleMode = 2;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if ((i >= 20) && (i <= 23)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    e = bool1;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT != 23) {
      bool1 = true;
    }
    $assertionsDisabled = bool1;
  }
  
  public PrintHelperKitkat(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public static Matrix getMatrix(int paramInt1, int paramInt2, RectF paramRectF, int paramInt3)
  {
    Matrix localMatrix = new Matrix();
    float f1 = paramRectF.width();
    float f2 = paramInt1;
    f1 /= f2;
    if (paramInt3 == 2) {
      f1 = Math.max(f1, paramRectF.height() / paramInt2);
    } else {
      f1 = Math.min(f1, paramRectF.height() / paramInt2);
    }
    localMatrix.postScale(f1, f1);
    localMatrix.postTranslate((paramRectF.width() - f2 * f1) / 2.0F, (paramRectF.height() - paramInt2 * f1) / 2.0F);
    return localMatrix;
  }
  
  public static boolean isScanAlawaysAvailable()
  {
    int i = Build.VERSION.SDK_INT;
    return true;
  }
  
  /* Error */
  private Bitmap loadBitmap(Uri paramUri, BitmapFactory.Options paramOptions)
    throws FileNotFoundException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +64 -> 65
    //   4: aload_0
    //   5: getfield 68	support/android/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   8: astore 4
    //   10: aload 4
    //   12: ifnull +53 -> 65
    //   15: aconst_null
    //   16: astore_3
    //   17: aload 4
    //   19: invokevirtual 114	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   22: aload_1
    //   23: invokevirtual 120	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   26: astore_1
    //   27: aload_1
    //   28: aconst_null
    //   29: aload_2
    //   30: invokestatic 126	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   33: astore_2
    //   34: aload_1
    //   35: ifnull +47 -> 82
    //   38: aload_1
    //   39: invokevirtual 131	java/io/InputStream:close	()V
    //   42: aload_2
    //   43: areturn
    //   44: astore_3
    //   45: aload_1
    //   46: astore_2
    //   47: aload_3
    //   48: astore_1
    //   49: goto +6 -> 55
    //   52: astore_1
    //   53: aload_3
    //   54: astore_2
    //   55: aload_2
    //   56: ifnull +7 -> 63
    //   59: aload_2
    //   60: invokevirtual 131	java/io/InputStream:close	()V
    //   63: aload_1
    //   64: athrow
    //   65: new 133	java/lang/IllegalArgumentException
    //   68: dup
    //   69: ldc -121
    //   71: invokespecial 138	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: astore_1
    //   76: aload_2
    //   77: areturn
    //   78: astore_2
    //   79: goto -16 -> 63
    //   82: aload_2
    //   83: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	PrintHelperKitkat
    //   0	84	1	paramUri	Uri
    //   0	84	2	paramOptions	BitmapFactory.Options
    //   16	1	3	localObject	Object
    //   44	10	3	localThrowable	Throwable
    //   8	10	4	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   27	34	44	java/lang/Throwable
    //   17	27	52	java/lang/Throwable
    //   38	42	75	java/io/IOException
    //   59	63	78	java/io/IOException
  }
  
  public static PrintAttributes.Builder loadBitmap(PrintAttributes paramPrintAttributes)
  {
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder().setMediaSize(paramPrintAttributes.getMediaSize()).setResolution(paramPrintAttributes.getResolution()).setMinMargins(paramPrintAttributes.getMinMargins());
    if (paramPrintAttributes.getColorMode() != 0) {
      localBuilder.setColorMode(paramPrintAttributes.getColorMode());
    }
    if ((Build.VERSION.SDK_INT >= 23) && (paramPrintAttributes.getDuplexMode() != 0)) {
      localBuilder.setDuplexMode(paramPrintAttributes.getDuplexMode());
    }
    return localBuilder;
  }
  
  public static boolean loadBitmap(Bitmap paramBitmap)
  {
    return paramBitmap.getWidth() <= paramBitmap.getHeight();
  }
  
  public static Bitmap transform(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt != 1) {
      return paramBitmap;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    localCanvas.setBitmap(null);
    return localBitmap;
  }
  
  public int getColorMode()
  {
    return mColorMode;
  }
  
  public int getOrientation()
  {
    int i = Build.VERSION.SDK_INT;
    i = mOrientation;
    if (i == 0) {
      return 1;
    }
    return i;
  }
  
  public int getScaleMode()
  {
    return mScaleMode;
  }
  
  public void loadBitmap(PrintAttributes paramPrintAttributes, int paramInt, Bitmap paramBitmap, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
  {
    PrintAttributes localPrintAttributes;
    if ($assertionsDisabled) {
      localPrintAttributes = paramPrintAttributes;
    } else {
      localPrintAttributes = loadBitmap(paramPrintAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
    }
    new CardThumbnailView.BitmapWorkerTask(this, paramCancellationSignal, localPrintAttributes, paramBitmap, paramPrintAttributes, paramInt, paramParcelFileDescriptor, paramWriteResultCallback).execute(new Void[0]);
  }
  
  /* Error */
  public Bitmap loadConstrainedBitmap(Uri paramUri)
    throws FileNotFoundException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +215 -> 216
    //   4: aload_0
    //   5: getfield 68	support/android/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   8: ifnull +208 -> 216
    //   11: new 266	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 267	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore 6
    //   20: aload 6
    //   22: iconst_1
    //   23: putfield 270	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   26: aload_0
    //   27: aload_1
    //   28: aload 6
    //   30: invokespecial 272	support/android/v4/print/PrintHelperKitkat:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   33: pop
    //   34: aload 6
    //   36: getfield 275	android/graphics/BitmapFactory$Options:outWidth	I
    //   39: istore 4
    //   41: aload 6
    //   43: getfield 278	android/graphics/BitmapFactory$Options:outHeight	I
    //   46: istore 5
    //   48: iload 4
    //   50: ifle +182 -> 232
    //   53: iload 5
    //   55: ifgt +5 -> 60
    //   58: aconst_null
    //   59: areturn
    //   60: iload 4
    //   62: iload 5
    //   64: invokestatic 281	java/lang/Math:max	(II)I
    //   67: istore_3
    //   68: iconst_1
    //   69: istore_2
    //   70: iload_3
    //   71: sipush 3500
    //   74: if_icmple +14 -> 88
    //   77: iload_3
    //   78: iconst_1
    //   79: iushr
    //   80: istore_3
    //   81: iload_2
    //   82: iconst_1
    //   83: ishl
    //   84: istore_2
    //   85: goto -15 -> 70
    //   88: iload_2
    //   89: ifle +143 -> 232
    //   92: iload 4
    //   94: iload 5
    //   96: invokestatic 283	java/lang/Math:min	(II)I
    //   99: iload_2
    //   100: idiv
    //   101: ifgt +5 -> 106
    //   104: aconst_null
    //   105: areturn
    //   106: aload_0
    //   107: getfield 60	support/android/v4/print/PrintHelperKitkat:mLock	Ljava/lang/Object;
    //   110: astore 6
    //   112: aload 6
    //   114: monitorenter
    //   115: aload_0
    //   116: new 266	android/graphics/BitmapFactory$Options
    //   119: dup
    //   120: invokespecial 267	android/graphics/BitmapFactory$Options:<init>	()V
    //   123: putfield 58	support/android/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   126: aload_0
    //   127: getfield 58	support/android/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   130: iconst_1
    //   131: putfield 286	android/graphics/BitmapFactory$Options:inMutable	Z
    //   134: aload_0
    //   135: getfield 58	support/android/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   138: iload_2
    //   139: putfield 289	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   142: aload_0
    //   143: getfield 58	support/android/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   146: astore 7
    //   148: aload 6
    //   150: monitorexit
    //   151: aload_0
    //   152: aload_1
    //   153: aload 7
    //   155: invokespecial 272	support/android/v4/print/PrintHelperKitkat:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   158: astore 6
    //   160: aload_0
    //   161: getfield 60	support/android/v4/print/PrintHelperKitkat:mLock	Ljava/lang/Object;
    //   164: astore_1
    //   165: aload_1
    //   166: monitorenter
    //   167: aload_0
    //   168: aconst_null
    //   169: putfield 58	support/android/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   172: aload_1
    //   173: monitorexit
    //   174: aload 6
    //   176: areturn
    //   177: astore 6
    //   179: aload_1
    //   180: monitorexit
    //   181: aload 6
    //   183: athrow
    //   184: astore 6
    //   186: aload_0
    //   187: getfield 60	support/android/v4/print/PrintHelperKitkat:mLock	Ljava/lang/Object;
    //   190: astore_1
    //   191: aload_1
    //   192: monitorenter
    //   193: aload_0
    //   194: aconst_null
    //   195: putfield 58	support/android/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   198: aload_1
    //   199: monitorexit
    //   200: aload 6
    //   202: athrow
    //   203: astore 6
    //   205: aload_1
    //   206: monitorexit
    //   207: aload 6
    //   209: athrow
    //   210: astore_1
    //   211: aload 6
    //   213: monitorexit
    //   214: aload_1
    //   215: athrow
    //   216: new 133	java/lang/IllegalArgumentException
    //   219: dup
    //   220: ldc_w 291
    //   223: invokespecial 138	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   226: astore_1
    //   227: goto +3 -> 230
    //   230: aload_1
    //   231: athrow
    //   232: aconst_null
    //   233: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	PrintHelperKitkat
    //   0	234	1	paramUri	Uri
    //   69	70	2	i	int
    //   67	14	3	j	int
    //   39	54	4	k	int
    //   46	49	5	m	int
    //   18	157	6	localObject	Object
    //   177	5	6	localThrowable1	Throwable
    //   184	17	6	localThrowable2	Throwable
    //   203	9	6	localThrowable3	Throwable
    //   146	8	7	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   167	174	177	java/lang/Throwable
    //   179	181	177	java/lang/Throwable
    //   151	160	184	java/lang/Throwable
    //   193	200	203	java/lang/Throwable
    //   205	207	203	java/lang/Throwable
    //   115	151	210	java/lang/Throwable
    //   211	214	210	java/lang/Throwable
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap)
  {
    printBitmap(paramString, paramBitmap, null);
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap, OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    int i = Build.VERSION.SDK_INT;
    if (paramBitmap == null) {
      return;
    }
    PrintManager localPrintManager = (PrintManager)mContext.getSystemService("print");
    if (loadBitmap(paramBitmap)) {
      localObject = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
    } else {
      localObject = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
    }
    Object localObject = new PrintAttributes.Builder().setMediaSize((PrintAttributes.MediaSize)localObject).setColorMode(mColorMode).build();
    localPrintManager.print(paramString, new PrintDocumentAdapter()
    {
      public PrintAttributes mAttributes;
      public final int val$bitmap;
      public final PrintHelperKitkat.OnPrintFinishCallback val$callback;
      public final Bitmap val$fittingMode;
      public final String val$jobName;
      
      public void onFinish()
      {
        PrintHelperKitkat.OnPrintFinishCallback localOnPrintFinishCallback = val$callback;
        if (localOnPrintFinishCallback != null) {
          localOnPrintFinishCallback.onFinish();
        }
      }
      
      public void onLayout(PrintAttributes paramAnonymousPrintAttributes1, PrintAttributes paramAnonymousPrintAttributes2, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
      {
        mAttributes = paramAnonymousPrintAttributes2;
        paramAnonymousLayoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(val$jobName).setContentType(1).setPageCount(1).build(), paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1) ^ true);
      }
      
      public void onWrite(PageRange[] paramAnonymousArrayOfPageRange, ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
      {
        loadBitmap(mAttributes, val$bitmap, val$fittingMode, paramAnonymousParcelFileDescriptor, paramAnonymousCancellationSignal, paramAnonymousWriteResultCallback);
      }
    }, (PrintAttributes)localObject);
  }
  
  public void printBitmap(String paramString, Uri paramUri)
    throws FileNotFoundException
  {
    printBitmap(paramString, paramUri, null);
  }
  
  public void printBitmap(String paramString, Uri paramUri, OnPrintFinishCallback paramOnPrintFinishCallback)
    throws FileNotFoundException
  {
    int i = Build.VERSION.SDK_INT;
    paramUri = new PrintDocumentAdapter()
    {
      public PrintAttributes mAttributes;
      public Bitmap mBitmap;
      public AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
      public final PrintHelperKitkat.OnPrintFinishCallback val$callback;
      public final int val$fittingMode;
      public final Uri val$imageFile;
      public final String val$jobName;
      
      public void cancelLoad()
      {
        Object localObject = mLock;
        try
        {
          if (mDecodeOptions != null)
          {
            if (Build.VERSION.SDK_INT < 24) {
              mDecodeOptions.requestCancelDecode();
            }
            mDecodeOptions = null;
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          throw localThrowable;
        }
      }
      
      public void onFinish()
      {
        super.onFinish();
        cancelLoad();
        Object localObject = mLoadBitmap;
        if (localObject != null) {
          ((AsyncTask)localObject).cancel(true);
        }
        localObject = val$callback;
        if (localObject != null) {
          ((PrintHelperKitkat.OnPrintFinishCallback)localObject).onFinish();
        }
        localObject = mBitmap;
        if (localObject != null)
        {
          ((Bitmap)localObject).recycle();
          mBitmap = null;
        }
      }
      
      public void onLayout(PrintAttributes paramAnonymousPrintAttributes1, PrintAttributes paramAnonymousPrintAttributes2, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
      {
        try
        {
          mAttributes = paramAnonymousPrintAttributes2;
          if (paramAnonymousCancellationSignal.isCanceled())
          {
            paramAnonymousLayoutResultCallback.onLayoutCancelled();
            return;
          }
          if (mBitmap != null)
          {
            paramAnonymousLayoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(val$jobName).setContentType(1).setPageCount(1).build(), paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1) ^ true);
            return;
          }
          mLoadBitmap = new PrintHelperKitkat.2.1(this, paramAnonymousCancellationSignal, paramAnonymousPrintAttributes2, paramAnonymousPrintAttributes1, paramAnonymousLayoutResultCallback).execute(new Uri[0]);
          return;
        }
        catch (Throwable paramAnonymousPrintAttributes1)
        {
          throw paramAnonymousPrintAttributes1;
        }
      }
      
      public void onWrite(PageRange[] paramAnonymousArrayOfPageRange, ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
      {
        loadBitmap(mAttributes, val$fittingMode, mBitmap, paramAnonymousParcelFileDescriptor, paramAnonymousCancellationSignal, paramAnonymousWriteResultCallback);
      }
    };
    paramOnPrintFinishCallback = (PrintManager)mContext.getSystemService("print");
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder();
    localBuilder.setColorMode(mColorMode);
    i = mOrientation;
    if ((i != 1) && (i != 0))
    {
      if (i == 2) {
        localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
      }
    }
    else {
      localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
    }
    paramOnPrintFinishCallback.print(paramString, paramUri, localBuilder.build());
  }
  
  public void setColorMode(int paramInt)
  {
    mColorMode = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    mOrientation = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    mScaleMode = paramInt;
  }
  
  public abstract interface OnPrintFinishCallback
  {
    public abstract void onFinish();
  }
}
