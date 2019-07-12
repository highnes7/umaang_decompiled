package support.android.v4.internal;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import b.b.a.K;
import b.b.a.N;
import java.io.File;

@K(21)
@N({b.b.a.N.a.b})
public class f
  extends d
{
  public static final String t = "TypefaceCompatApi21Impl";
  
  public f() {}
  
  private File close(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/proc/self/fd/");
      ((StringBuilder)localObject).append(paramParcelFileDescriptor.getFd());
      paramParcelFileDescriptor = Os.readlink(((StringBuilder)localObject).toString());
      localObject = Os.stat(paramParcelFileDescriptor);
      int i = st_mode;
      boolean bool = OsConstants.S_ISREG(i);
      if (bool)
      {
        paramParcelFileDescriptor = new File(paramParcelFileDescriptor);
        return paramParcelFileDescriptor;
      }
      return null;
    }
    catch (ErrnoException paramParcelFileDescriptor) {}
    return null;
  }
  
  /* Error */
  public android.graphics.Typeface a(android.content.Context paramContext, android.os.CancellationSignal paramCancellationSignal, support.android.v4.tts.Label[] paramArrayOfLabel, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: aload_3
    //   10: iload 4
    //   12: invokevirtual 81	support/android/v4/internal/d:a	([Lsupport/android/v4/tts/Label;I)Lsupport/android/v4/tts/Label;
    //   15: astore_3
    //   16: aload_1
    //   17: invokevirtual 87	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: astore 6
    //   22: aload 6
    //   24: aload_3
    //   25: invokevirtual 93	support/android/v4/tts/Label:getName	()Landroid/net/Uri;
    //   28: ldc 95
    //   30: aload_2
    //   31: invokevirtual 101	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   34: astore_2
    //   35: aload_0
    //   36: aload_2
    //   37: invokespecial 103	support/android/v4/internal/f:close	(Landroid/os/ParcelFileDescriptor;)Ljava/io/File;
    //   40: astore_3
    //   41: aload_3
    //   42: ifnull +32 -> 74
    //   45: aload_3
    //   46: invokevirtual 107	java/io/File:canRead	()Z
    //   49: istore 5
    //   51: iload 5
    //   53: ifne +6 -> 59
    //   56: goto +18 -> 74
    //   59: aload_3
    //   60: invokestatic 113	android/graphics/Typeface:createFromFile	(Ljava/io/File;)Landroid/graphics/Typeface;
    //   63: astore_1
    //   64: aload_2
    //   65: ifnull +116 -> 181
    //   68: aload_2
    //   69: invokevirtual 115	android/os/ParcelFileDescriptor:close	()V
    //   72: aload_1
    //   73: areturn
    //   74: new 117	java/io/FileInputStream
    //   77: dup
    //   78: aload_2
    //   79: invokevirtual 121	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   82: invokespecial 124	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   85: astore_3
    //   86: aload_0
    //   87: aload_1
    //   88: aload_3
    //   89: invokespecial 127	support/android/v4/internal/d:a	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   92: astore_1
    //   93: aload_3
    //   94: invokevirtual 128	java/io/FileInputStream:close	()V
    //   97: aload_2
    //   98: invokevirtual 115	android/os/ParcelFileDescriptor:close	()V
    //   101: aload_1
    //   102: areturn
    //   103: astore_1
    //   104: aload_1
    //   105: athrow
    //   106: astore 6
    //   108: aload_1
    //   109: ifnull +19 -> 128
    //   112: aload_3
    //   113: invokevirtual 128	java/io/FileInputStream:close	()V
    //   116: goto +16 -> 132
    //   119: astore_3
    //   120: aload_1
    //   121: aload_3
    //   122: invokevirtual 132	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   125: goto +7 -> 132
    //   128: aload_3
    //   129: invokevirtual 128	java/io/FileInputStream:close	()V
    //   132: aload 6
    //   134: athrow
    //   135: astore_1
    //   136: aload_1
    //   137: athrow
    //   138: astore_3
    //   139: aload_2
    //   140: ifnull +27 -> 167
    //   143: aload_1
    //   144: ifnull +19 -> 163
    //   147: aload_2
    //   148: invokevirtual 115	android/os/ParcelFileDescriptor:close	()V
    //   151: goto +16 -> 167
    //   154: astore_2
    //   155: aload_1
    //   156: aload_2
    //   157: invokevirtual 132	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   160: goto +7 -> 167
    //   163: aload_2
    //   164: invokevirtual 115	android/os/ParcelFileDescriptor:close	()V
    //   167: aload_3
    //   168: athrow
    //   169: astore_1
    //   170: aconst_null
    //   171: areturn
    //   172: astore_1
    //   173: aconst_null
    //   174: areturn
    //   175: astore_1
    //   176: aconst_null
    //   177: areturn
    //   178: astore_1
    //   179: aconst_null
    //   180: areturn
    //   181: aload_1
    //   182: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	f
    //   0	183	1	paramContext	android.content.Context
    //   0	183	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	183	3	paramArrayOfLabel	support.android.v4.tts.Label[]
    //   0	183	4	paramInt	int
    //   49	3	5	bool	boolean
    //   20	3	6	localContentResolver	android.content.ContentResolver
    //   106	27	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   86	93	103	java/lang/Throwable
    //   104	106	106	java/lang/Throwable
    //   112	116	119	java/lang/Throwable
    //   35	41	135	java/lang/Throwable
    //   45	51	135	java/lang/Throwable
    //   59	64	135	java/lang/Throwable
    //   74	86	135	java/lang/Throwable
    //   93	97	135	java/lang/Throwable
    //   120	125	135	java/lang/Throwable
    //   128	132	135	java/lang/Throwable
    //   132	135	135	java/lang/Throwable
    //   136	138	138	java/lang/Throwable
    //   147	151	154	java/lang/Throwable
    //   22	35	169	java/io/IOException
    //   68	72	172	java/io/IOException
    //   97	101	175	java/io/IOException
    //   155	160	178	java/io/IOException
    //   163	167	178	java/io/IOException
    //   167	169	178	java/io/IOException
  }
}
