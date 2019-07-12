package com.google.android.android.common.data;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.internal.zzbck;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class BitmapTeleporter
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.common.data.BitmapTeleporter> CREATOR = new DiscreteSeekBar.CustomState.1();
  public ParcelFileDescriptor zzcqz;
  public int zzdxs;
  public int zzecz;
  public Bitmap zzfqb;
  public boolean zzfqc;
  public File zzfqd;
  
  public BitmapTeleporter(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2)
  {
    zzdxs = paramInt1;
    zzcqz = paramParcelFileDescriptor;
    zzecz = paramInt2;
    zzfqb = null;
    zzfqc = false;
  }
  
  public BitmapTeleporter(Bitmap paramBitmap)
  {
    zzdxs = 1;
    zzcqz = null;
    zzecz = 0;
    zzfqb = paramBitmap;
    zzfqc = true;
  }
  
  public static void safeClose(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  /* Error */
  private final java.io.FileOutputStream zzait()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/google/android/android/common/data/BitmapTeleporter:zzfqd	Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +62 -> 68
    //   9: ldc 60
    //   11: ldc 62
    //   13: aload_1
    //   14: invokestatic 68	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   17: astore_1
    //   18: new 70	java/io/FileOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 73	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   26: astore_2
    //   27: aload_1
    //   28: ldc 74
    //   30: invokestatic 80	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   33: astore_3
    //   34: aload_0
    //   35: aload_3
    //   36: putfield 36	com/google/android/android/common/data/BitmapTeleporter:zzcqz	Landroid/os/ParcelFileDescriptor;
    //   39: aload_1
    //   40: invokevirtual 84	java/io/File:delete	()Z
    //   43: pop
    //   44: aload_2
    //   45: areturn
    //   46: new 86	java/lang/IllegalStateException
    //   49: dup
    //   50: ldc 88
    //   52: invokespecial 91	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    //   56: astore_1
    //   57: new 86	java/lang/IllegalStateException
    //   60: dup
    //   61: ldc 93
    //   63: aload_1
    //   64: invokespecial 96	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   67: athrow
    //   68: new 86	java/lang/IllegalStateException
    //   71: dup
    //   72: ldc 98
    //   74: invokespecial 91	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    //   78: astore_1
    //   79: goto -33 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	BitmapTeleporter
    //   4	36	1	localFile	File
    //   56	8	1	localIOException	IOException
    //   78	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   26	19	2	localFileOutputStream	java.io.FileOutputStream
    //   33	3	3	localParcelFileDescriptor	ParcelFileDescriptor
    // Exception table:
    //   from	to	target	type
    //   9	18	56	java/io/IOException
    //   18	34	78	java/io/FileNotFoundException
  }
  
  public final void parseSequence(File paramFile)
  {
    if (paramFile != null)
    {
      zzfqd = paramFile;
      return;
    }
    throw new NullPointerException("Cannot set null temp directory");
  }
  
  public final void release()
  {
    if (!zzfqc)
    {
      ParcelFileDescriptor localParcelFileDescriptor = zzcqz;
      try
      {
        localParcelFileDescriptor.close();
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  /* Error */
  public void writeToParcel(android.os.Parcel paramParcel, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/google/android/android/common/data/BitmapTeleporter:zzcqz	Landroid/os/ParcelFileDescriptor;
    //   4: ifnonnull +146 -> 150
    //   7: aload_0
    //   8: getfield 40	com/google/android/android/common/data/BitmapTeleporter:zzfqb	Landroid/graphics/Bitmap;
    //   11: astore 5
    //   13: aload 5
    //   15: invokevirtual 116	android/graphics/Bitmap:getRowBytes	()I
    //   18: istore_3
    //   19: aload 5
    //   21: invokevirtual 119	android/graphics/Bitmap:getHeight	()I
    //   24: iload_3
    //   25: imul
    //   26: invokestatic 125	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   29: astore 4
    //   31: aload 5
    //   33: aload 4
    //   35: invokevirtual 129	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   38: aload 4
    //   40: invokevirtual 133	java/nio/ByteBuffer:array	()[B
    //   43: astore 6
    //   45: new 135	java/io/DataOutputStream
    //   48: dup
    //   49: new 137	java/io/BufferedOutputStream
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 139	com/google/android/android/common/data/BitmapTeleporter:zzait	()Ljava/io/FileOutputStream;
    //   57: invokespecial 142	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: invokespecial 143	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   63: astore 4
    //   65: aload 6
    //   67: arraylength
    //   68: istore_3
    //   69: aload 4
    //   71: iload_3
    //   72: invokevirtual 147	java/io/DataOutputStream:writeInt	(I)V
    //   75: aload 4
    //   77: aload 5
    //   79: invokevirtual 150	android/graphics/Bitmap:getWidth	()I
    //   82: invokevirtual 147	java/io/DataOutputStream:writeInt	(I)V
    //   85: aload 4
    //   87: aload 5
    //   89: invokevirtual 119	android/graphics/Bitmap:getHeight	()I
    //   92: invokevirtual 147	java/io/DataOutputStream:writeInt	(I)V
    //   95: aload 4
    //   97: aload 5
    //   99: invokevirtual 154	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   102: invokevirtual 160	java/lang/Enum:toString	()Ljava/lang/String;
    //   105: invokevirtual 163	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   108: aload 4
    //   110: aload 6
    //   112: invokevirtual 167	java/io/DataOutputStream:write	([B)V
    //   115: aload 4
    //   117: invokeinterface 52 1 0
    //   122: goto +28 -> 150
    //   125: astore_1
    //   126: goto +15 -> 141
    //   129: astore_1
    //   130: new 86	java/lang/IllegalStateException
    //   133: dup
    //   134: ldc -87
    //   136: aload_1
    //   137: invokespecial 96	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: athrow
    //   141: aload 4
    //   143: invokeinterface 52 1 0
    //   148: aload_1
    //   149: athrow
    //   150: aload_1
    //   151: invokestatic 175	com/google/android/android/internal/zzbcn:writeValue	(Landroid/os/Parcel;)I
    //   154: istore_3
    //   155: aload_1
    //   156: iconst_1
    //   157: aload_0
    //   158: getfield 34	com/google/android/android/common/data/BitmapTeleporter:zzdxs	I
    //   161: invokestatic 179	com/google/android/android/internal/zzbcn:setCustomVar	(Landroid/os/Parcel;II)V
    //   164: aload_1
    //   165: iconst_2
    //   166: aload_0
    //   167: getfield 36	com/google/android/android/common/data/BitmapTeleporter:zzcqz	Landroid/os/ParcelFileDescriptor;
    //   170: iload_2
    //   171: iconst_1
    //   172: ior
    //   173: iconst_0
    //   174: invokestatic 183	com/google/android/android/internal/zzbcn:addMenuItem	(Landroid/os/Parcel;ILandroid/os/Parcelable;IZ)V
    //   177: aload_1
    //   178: iconst_3
    //   179: aload_0
    //   180: getfield 38	com/google/android/android/common/data/BitmapTeleporter:zzecz	I
    //   183: invokestatic 179	com/google/android/android/internal/zzbcn:setCustomVar	(Landroid/os/Parcel;II)V
    //   186: aload_1
    //   187: iload_3
    //   188: invokestatic 186	com/google/android/android/internal/zzbcn:zzah	(Landroid/os/Parcel;I)V
    //   191: aload_0
    //   192: aconst_null
    //   193: putfield 36	com/google/android/android/common/data/BitmapTeleporter:zzcqz	Landroid/os/ParcelFileDescriptor;
    //   196: return
    //   197: astore 4
    //   199: goto -49 -> 150
    //   202: astore 4
    //   204: goto -56 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	BitmapTeleporter
    //   0	207	1	paramParcel	android.os.Parcel
    //   0	207	2	paramInt	int
    //   18	170	3	i	int
    //   29	113	4	localObject	Object
    //   197	1	4	localIOException1	IOException
    //   202	1	4	localIOException2	IOException
    //   11	87	5	localBitmap	Bitmap
    //   43	68	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   69	115	125	java/lang/Throwable
    //   130	141	125	java/lang/Throwable
    //   69	115	129	java/io/IOException
    //   115	122	197	java/io/IOException
    //   141	148	202	java/io/IOException
  }
  
  /* Error */
  public final Bitmap zzais()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/google/android/android/common/data/BitmapTeleporter:zzfqc	Z
    //   4: ifne +127 -> 131
    //   7: new 190	java/io/DataInputStream
    //   10: dup
    //   11: new 192	android/os/ParcelFileDescriptor$AutoCloseInputStream
    //   14: dup
    //   15: aload_0
    //   16: getfield 36	com/google/android/android/common/data/BitmapTeleporter:zzcqz	Landroid/os/ParcelFileDescriptor;
    //   19: invokespecial 195	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   22: invokespecial 198	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_3
    //   26: aload_3
    //   27: invokevirtual 201	java/io/DataInputStream:readInt	()I
    //   30: istore_1
    //   31: iload_1
    //   32: newarray byte
    //   34: astore 5
    //   36: aload_3
    //   37: invokevirtual 201	java/io/DataInputStream:readInt	()I
    //   40: istore_1
    //   41: aload_3
    //   42: invokevirtual 201	java/io/DataInputStream:readInt	()I
    //   45: istore_2
    //   46: aload_3
    //   47: invokevirtual 204	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   50: invokestatic 210	android/graphics/Bitmap$Config:valueOf	(Ljava/lang/String;)Landroid/graphics/Bitmap$Config;
    //   53: astore 4
    //   55: aload_3
    //   56: aload 5
    //   58: invokevirtual 214	java/io/DataInputStream:read	([B)I
    //   61: pop
    //   62: aload_3
    //   63: invokeinterface 52 1 0
    //   68: aload 5
    //   70: invokestatic 218	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   73: astore_3
    //   74: iload_1
    //   75: iload_2
    //   76: aload 4
    //   78: invokestatic 222	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   81: astore 4
    //   83: aload 4
    //   85: aload_3
    //   86: invokevirtual 225	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   89: aload_0
    //   90: aload 4
    //   92: putfield 40	com/google/android/android/common/data/BitmapTeleporter:zzfqb	Landroid/graphics/Bitmap;
    //   95: aload_0
    //   96: iconst_1
    //   97: putfield 42	com/google/android/android/common/data/BitmapTeleporter:zzfqc	Z
    //   100: goto +31 -> 131
    //   103: astore 4
    //   105: goto +17 -> 122
    //   108: astore 4
    //   110: new 86	java/lang/IllegalStateException
    //   113: dup
    //   114: ldc -29
    //   116: aload 4
    //   118: invokespecial 96	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   121: athrow
    //   122: aload_3
    //   123: invokeinterface 52 1 0
    //   128: aload 4
    //   130: athrow
    //   131: aload_0
    //   132: getfield 40	com/google/android/android/common/data/BitmapTeleporter:zzfqb	Landroid/graphics/Bitmap;
    //   135: areturn
    //   136: astore_3
    //   137: goto -69 -> 68
    //   140: astore_3
    //   141: goto -13 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	BitmapTeleporter
    //   30	45	1	i	int
    //   45	31	2	j	int
    //   25	98	3	localObject1	Object
    //   136	1	3	localIOException1	IOException
    //   140	1	3	localIOException2	IOException
    //   53	38	4	localObject2	Object
    //   103	1	4	localThrowable	Throwable
    //   108	21	4	localIOException3	IOException
    //   34	35	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   26	31	103	java/lang/Throwable
    //   36	62	103	java/lang/Throwable
    //   110	122	103	java/lang/Throwable
    //   26	31	108	java/io/IOException
    //   36	62	108	java/io/IOException
    //   62	68	136	java/io/IOException
    //   122	128	140	java/io/IOException
  }
}
