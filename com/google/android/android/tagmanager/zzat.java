package com.google.android.android.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.android.common.util.Clock;
import com.google.android.android.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class zzat
  implements DataLayer.zzc
{
  public static final String zzjqq = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[] { "datalayer", "ID", "key", "value", "expires" });
  public final Context mContext;
  public Log zzasc;
  public final Executor zzjqr;
  public zzax zzjqs;
  public int zzjqt;
  
  public zzat(Context paramContext)
  {
    this(paramContext, Clock.zzfyr, "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
  }
  
  public zzat(Context paramContext, Log paramLog, String paramString, int paramInt, Executor paramExecutor)
  {
    mContext = paramContext;
    zzasc = paramLog;
    zzjqt = 2000;
    zzjqr = paramExecutor;
    zzjqs = new zzax(this, mContext, paramString);
  }
  
  /* Error */
  private final void parse(List paramList, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 66	com/google/android/android/tagmanager/zzat:zzasc	Lcom/google/android/android/common/util/Log;
    //   6: invokeinterface 103 1 0
    //   11: lstore 5
    //   13: aload_0
    //   14: lload 5
    //   16: invokespecial 107	com/google/android/android/tagmanager/zzat:zzbg	(J)V
    //   19: aload_1
    //   20: invokeinterface 113 1 0
    //   25: istore 4
    //   27: aload_0
    //   28: invokespecial 116	com/google/android/android/tagmanager/zzat:zzbdh	()I
    //   31: aload_0
    //   32: getfield 68	com/google/android/android/tagmanager/zzat:zzjqt	I
    //   35: isub
    //   36: iload 4
    //   38: iadd
    //   39: istore 4
    //   41: iload 4
    //   43: ifle +216 -> 259
    //   46: aload_0
    //   47: iload 4
    //   49: invokespecial 120	com/google/android/android/tagmanager/zzat:zzef	(I)Ljava/util/List;
    //   52: astore 7
    //   54: aload 7
    //   56: invokeinterface 113 1 0
    //   61: istore 4
    //   63: new 122	java/lang/StringBuilder
    //   66: dup
    //   67: bipush 64
    //   69: invokespecial 125	java/lang/StringBuilder:<init>	(I)V
    //   72: astore 8
    //   74: aload 8
    //   76: ldc 127
    //   78: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 8
    //   84: iload 4
    //   86: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 8
    //   92: ldc -120
    //   94: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 8
    //   100: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore 8
    //   105: getstatic 146	com/google/android/android/tagmanager/zzdj:zzjss	Lcom/google/android/android/tagmanager/zzdk;
    //   108: aload 8
    //   110: invokeinterface 151 2 0
    //   115: aload 7
    //   117: iconst_0
    //   118: anewarray 34	java/lang/String
    //   121: invokeinterface 155 2 0
    //   126: checkcast 157	[Ljava/lang/String;
    //   129: astore 7
    //   131: aload 7
    //   133: ifnull +126 -> 259
    //   136: aload 7
    //   138: arraylength
    //   139: ifne +6 -> 145
    //   142: goto +117 -> 259
    //   145: aload_0
    //   146: ldc -97
    //   148: invokespecial 163	com/google/android/android/tagmanager/zzat:zzln	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   151: astore 8
    //   153: aload 8
    //   155: ifnull +104 -> 259
    //   158: ldc -91
    //   160: iconst_2
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: ldc 26
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: ldc -89
    //   173: aload 7
    //   175: arraylength
    //   176: ldc -87
    //   178: invokestatic 175	java/util/Collections:nCopies	(ILjava/lang/Object;)Ljava/util/List;
    //   181: invokestatic 181	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   184: aastore
    //   185: invokestatic 38	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   188: astore 9
    //   190: aload 8
    //   192: ldc 24
    //   194: aload 9
    //   196: aload 7
    //   198: invokevirtual 187	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   201: pop
    //   202: goto +57 -> 259
    //   205: aload 7
    //   207: invokestatic 192	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   210: invokestatic 196	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   213: astore 7
    //   215: aload 7
    //   217: invokevirtual 199	java/lang/String:length	()I
    //   220: ifeq +15 -> 235
    //   223: ldc -55
    //   225: aload 7
    //   227: invokevirtual 205	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   230: astore 7
    //   232: goto +14 -> 246
    //   235: new 34	java/lang/String
    //   238: dup
    //   239: ldc -55
    //   241: invokespecial 207	java/lang/String:<init>	(Ljava/lang/String;)V
    //   244: astore 7
    //   246: getstatic 146	com/google/android/android/tagmanager/zzdj:zzjss	Lcom/google/android/android/tagmanager/zzdk;
    //   249: aload 7
    //   251: invokeinterface 210 2 0
    //   256: goto +3 -> 259
    //   259: aload_0
    //   260: aload_1
    //   261: lload 5
    //   263: lload_2
    //   264: ladd
    //   265: invokespecial 213	com/google/android/android/tagmanager/zzat:updateValue	(Ljava/util/List;J)V
    //   268: aload_0
    //   269: getfield 77	com/google/android/android/tagmanager/zzat:zzjqs	Lcom/google/android/android/tagmanager/zzax;
    //   272: astore_1
    //   273: aload_1
    //   274: invokevirtual 218	android/database/sqlite/SQLiteOpenHelper:close	()V
    //   277: aload_0
    //   278: monitorexit
    //   279: return
    //   280: aload_0
    //   281: getfield 77	com/google/android/android/tagmanager/zzat:zzjqs	Lcom/google/android/android/tagmanager/zzax;
    //   284: astore 7
    //   286: aload 7
    //   288: invokevirtual 218	android/database/sqlite/SQLiteOpenHelper:close	()V
    //   291: aload_1
    //   292: athrow
    //   293: astore_1
    //   294: aload_0
    //   295: monitorexit
    //   296: aload_1
    //   297: athrow
    //   298: astore 8
    //   300: goto -95 -> 205
    //   303: astore_1
    //   304: goto -27 -> 277
    //   307: astore 7
    //   309: goto -18 -> 291
    //   312: astore_1
    //   313: goto -33 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	zzat
    //   0	316	1	paramList	List
    //   0	316	2	paramLong	long
    //   25	60	4	i	int
    //   11	251	5	l	long
    //   52	235	7	localObject1	Object
    //   307	1	7	localSQLiteException1	SQLiteException
    //   72	119	8	localObject2	Object
    //   298	1	8	localSQLiteException2	SQLiteException
    //   188	7	9	str	String
    // Exception table:
    //   from	to	target	type
    //   273	277	293	java/lang/Throwable
    //   286	291	293	java/lang/Throwable
    //   291	293	293	java/lang/Throwable
    //   190	202	298	android/database/sqlite/SQLiteException
    //   273	277	303	android/database/sqlite/SQLiteException
    //   286	291	307	android/database/sqlite/SQLiteException
    //   2	41	312	java/lang/Throwable
    //   46	131	312	java/lang/Throwable
    //   136	142	312	java/lang/Throwable
    //   145	153	312	java/lang/Throwable
    //   158	190	312	java/lang/Throwable
    //   190	202	312	java/lang/Throwable
    //   205	232	312	java/lang/Throwable
    //   235	246	312	java/lang/Throwable
    //   246	256	312	java/lang/Throwable
    //   259	268	312	java/lang/Throwable
  }
  
  /* Error */
  public static Object unserialize(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 230	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 233	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_3
    //   9: aconst_null
    //   10: astore_2
    //   11: new 235	java/io/ObjectInputStream
    //   14: dup
    //   15: aload_3
    //   16: invokespecial 238	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 242	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   24: astore_1
    //   25: aload_0
    //   26: invokevirtual 243	java/io/ObjectInputStream:close	()V
    //   29: aload_3
    //   30: invokevirtual 244	java/io/ByteArrayInputStream:close	()V
    //   33: aload_1
    //   34: areturn
    //   35: astore_1
    //   36: goto +6 -> 42
    //   39: astore_1
    //   40: aload_2
    //   41: astore_0
    //   42: aload_0
    //   43: ifnull +7 -> 50
    //   46: aload_0
    //   47: invokevirtual 243	java/io/ObjectInputStream:close	()V
    //   50: aload_3
    //   51: invokevirtual 244	java/io/ByteArrayInputStream:close	()V
    //   54: aload_1
    //   55: athrow
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: ifnull +7 -> 66
    //   62: aload_0
    //   63: invokevirtual 243	java/io/ObjectInputStream:close	()V
    //   66: aload_3
    //   67: invokevirtual 244	java/io/ByteArrayInputStream:close	()V
    //   70: aconst_null
    //   71: areturn
    //   72: aconst_null
    //   73: astore_0
    //   74: aload_0
    //   75: ifnull +7 -> 82
    //   78: aload_0
    //   79: invokevirtual 243	java/io/ObjectInputStream:close	()V
    //   82: aload_3
    //   83: invokevirtual 244	java/io/ByteArrayInputStream:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: goto -17 -> 72
    //   92: astore_0
    //   93: goto -37 -> 56
    //   96: astore_1
    //   97: goto -23 -> 74
    //   100: astore_1
    //   101: goto -43 -> 58
    //   104: astore_0
    //   105: aload_1
    //   106: areturn
    //   107: astore_0
    //   108: goto -54 -> 54
    //   111: astore_0
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aconst_null
    //   116: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramArrayOfByte	byte[]
    //   24	10	1	localObject1	Object
    //   35	1	1	localThrowable1	Throwable
    //   39	16	1	localThrowable2	Throwable
    //   96	1	1	localIOException	java.io.IOException
    //   100	6	1	localClassNotFoundException	ClassNotFoundException
    //   10	31	2	localObject2	Object
    //   8	75	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   20	25	35	java/lang/Throwable
    //   11	20	39	java/lang/Throwable
    //   11	20	88	java/io/IOException
    //   11	20	92	java/lang/ClassNotFoundException
    //   20	25	96	java/io/IOException
    //   20	25	100	java/lang/ClassNotFoundException
    //   25	33	104	java/io/IOException
    //   46	50	107	java/io/IOException
    //   50	54	107	java/io/IOException
    //   62	66	111	java/io/IOException
    //   66	70	111	java/io/IOException
    //   78	82	114	java/io/IOException
    //   82	86	114	java/io/IOException
  }
  
  private final void updateValue(List paramList, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = zzln("Error opening database for writeEntryToDatabase.");
    if (localSQLiteDatabase == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      zzay localZzay = (zzay)paramList.next();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("expires", Long.valueOf(paramLong));
      localContentValues.put("key", zzbff);
      localContentValues.put("value", zzjqz);
      localSQLiteDatabase.insert("datalayer", null, localContentValues);
    }
  }
  
  /* Error */
  public static byte[] zzae(Object paramObject)
  {
    // Byte code:
    //   0: new 294	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 295	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: new 297	java/io/ObjectOutputStream
    //   13: dup
    //   14: aload_3
    //   15: invokespecial 300	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokevirtual 304	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   24: aload_3
    //   25: invokevirtual 308	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   28: astore_0
    //   29: aload_1
    //   30: invokevirtual 309	java/io/ObjectOutputStream:close	()V
    //   33: aload_3
    //   34: invokevirtual 310	java/io/ByteArrayOutputStream:close	()V
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: goto +6 -> 46
    //   43: astore_0
    //   44: aload_2
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +7 -> 54
    //   50: aload_1
    //   51: invokevirtual 309	java/io/ObjectOutputStream:close	()V
    //   54: aload_3
    //   55: invokevirtual 310	java/io/ByteArrayOutputStream:close	()V
    //   58: aload_0
    //   59: athrow
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 309	java/io/ObjectOutputStream:close	()V
    //   70: aload_3
    //   71: invokevirtual 310	java/io/ByteArrayOutputStream:close	()V
    //   74: aconst_null
    //   75: areturn
    //   76: astore_0
    //   77: goto -17 -> 60
    //   80: astore_0
    //   81: goto -19 -> 62
    //   84: astore_1
    //   85: aload_0
    //   86: areturn
    //   87: astore_1
    //   88: goto -30 -> 58
    //   91: astore_0
    //   92: aconst_null
    //   93: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramObject	Object
    //   18	49	1	localObject1	Object
    //   84	1	1	localIOException1	java.io.IOException
    //   87	1	1	localIOException2	java.io.IOException
    //   9	36	2	localObject2	Object
    //   7	64	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   19	29	39	java/lang/Throwable
    //   10	19	43	java/lang/Throwable
    //   10	19	76	java/io/IOException
    //   19	29	80	java/io/IOException
    //   29	37	84	java/io/IOException
    //   50	54	87	java/io/IOException
    //   54	58	87	java/io/IOException
    //   66	70	91	java/io/IOException
    //   70	74	91	java/io/IOException
  }
  
  private final List zzbdf()
  {
    Object localObject1 = this;
    try
    {
      Object localObject2 = zzasc;
      zzat localZzat = this;
      localObject1 = localZzat;
      localZzat.zzbg(((Log)localObject2).currentTimeMillis());
      localObject1 = localZzat;
      Object localObject3 = localZzat.zzbdg();
      localObject1 = localZzat;
      localObject2 = new ArrayList();
      localObject1 = localZzat;
      localObject3 = ((List)localObject3).iterator();
      for (;;)
      {
        localObject1 = localZzat;
        boolean bool = ((Iterator)localObject3).hasNext();
        if (!bool) {
          break;
        }
        localObject1 = localZzat;
        zzay localZzay = (zzay)((Iterator)localObject3).next();
        localObject1 = localZzat;
        ((List)localObject2).add(new DataLayer.zza(zzbff, unserialize(zzjqz)));
      }
      localObject1 = zzjqs;
      try
      {
        ((SQLiteOpenHelper)localObject1).close();
      }
      catch (SQLiteException localSQLiteException2)
      {
        for (;;) {}
      }
    }
    catch (Throwable localThrowable)
    {
      try
      {
        ((SQLiteOpenHelper)localObject1).close();
        return localObject2;
      }
      catch (SQLiteException localSQLiteException1)
      {
        return localObject2;
      }
      localThrowable = localThrowable;
      localObject1 = zzjqs;
    }
    throw localThrowable;
  }
  
  private final List zzbdg()
  {
    Object localObject = zzln("Error opening database for loadSerialized.");
    ArrayList localArrayList = new ArrayList();
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((SQLiteDatabase)localObject).query("datalayer", new String[] { "key", "value" }, null, null, null, null, "ID", null);
    try
    {
      for (;;)
      {
        boolean bool = ((Cursor)localObject).moveToNext();
        if (!bool) {
          break;
        }
        localArrayList.add(new zzay(((Cursor)localObject).getString(0), ((Cursor)localObject).getBlob(1)));
      }
      ((Cursor)localObject).close();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      ((Cursor)localObject).close();
      throw localThrowable;
    }
  }
  
  private final int zzbdh()
  {
    Object localObject2 = zzln("Error opening database for getNumStoredEntries.");
    j = 0;
    if (localObject2 == null) {
      return 0;
    }
    Object localObject1 = null;
    localObject3 = null;
    try
    {
      Cursor localCursor = ((SQLiteDatabase)localObject2).rawQuery("SELECT COUNT(*) from datalayer", null);
      localObject2 = localCursor;
      localObject3 = localObject2;
      localObject1 = localObject2;
      boolean bool = localCursor.moveToFirst();
      i = j;
      localObject1 = localObject2;
      if (bool)
      {
        localObject3 = localObject2;
        localObject1 = localObject2;
        long l = localCursor.getLong(0);
        i = (int)l;
        localObject1 = localObject2;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int i;
        break;
        localObject3 = localThrowable;
        zzdj.zzjss.zzcr("Error getting numStoredEntries");
        if (localThrowable != null) {
          i = j;
        } else {
          return 0;
        }
      }
      if (localObject3 == null) {
        break label144;
      }
      ((Cursor)localObject3).close();
      throw localThrowable;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;) {}
    }
    localObject1.close();
    return i;
  }
  
  private final void zzbdi()
  {
    zzax localZzax = zzjqs;
    try
    {
      localZzax.close();
      return;
    }
    catch (SQLiteException localSQLiteException) {}
  }
  
  private final void zzbg(long paramLong)
  {
    Object localObject1 = zzln("Error opening database for deleteOlderThan.");
    if (localObject1 == null) {
      return;
    }
    try
    {
      Object localObject2 = Long.toString(paramLong);
      int i = ((SQLiteDatabase)localObject1).delete("datalayer", "expires <= ?", new String[] { localObject2 });
      localObject1 = new StringBuilder(33);
      ((StringBuilder)localObject1).append("Deleted ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(" expired items");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = zzdj.zzjss;
      ((zzdk)localObject2).append((String)localObject1);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;) {}
    }
    zzdj.zzjss.zzcr("Error deleting old entries.");
  }
  
  private final List zzef(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt <= 0)
    {
      zzdj.zzjss.zzcr("Invalid maxEntries specified. Skipping.");
      return localArrayList;
    }
    SQLiteDatabase localSQLiteDatabase = zzln("Error opening database for peekEntryIds.");
    if (localSQLiteDatabase == null) {
      return localArrayList;
    }
    Cursor localCursor3 = null;
    Cursor localCursor2 = null;
    Object localObject = localCursor2;
    Cursor localCursor1 = localCursor3;
    try
    {
      String str2 = String.format("%s ASC", new Object[] { "ID" });
      localObject = localCursor2;
      localCursor1 = localCursor3;
      String str3 = Integer.toString(paramInt);
      localObject = localCursor2;
      localCursor1 = localCursor3;
      localCursor3 = localSQLiteDatabase.query("datalayer", new String[] { "ID" }, null, null, null, null, str2, str3);
      localCursor2 = localCursor3;
      localObject = localCursor2;
      localCursor1 = localCursor2;
      boolean bool = localCursor3.moveToFirst();
      localCursor1 = localCursor2;
      if (bool)
      {
        do
        {
          localObject = localCursor2;
          localCursor1 = localCursor2;
          localArrayList.add(String.valueOf(localCursor3.getLong(0)));
          localObject = localCursor2;
          localCursor1 = localCursor2;
          bool = localCursor3.moveToNext();
        } while (bool);
        localCursor1 = localCursor2;
      }
    }
    catch (Throwable localThrowable)
    {
      break label286;
    }
    catch (SQLiteException localSQLiteException)
    {
      localObject = localThrowable;
      String str1 = String.valueOf(localSQLiteException.getMessage());
      localObject = localThrowable;
      paramInt = str1.length();
      if (paramInt != 0)
      {
        localObject = localThrowable;
        str1 = "Error in peekEntries fetching entryIds: ".concat(str1);
      }
      else
      {
        localObject = localThrowable;
        str1 = new String("Error in peekEntries fetching entryIds: ");
      }
      localObject = localThrowable;
      zzdj.zzjss.zzcr(str1);
      if (localThrowable == null) {
        break label303;
      }
    }
    localThrowable.close();
    return localArrayList;
    label286:
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    throw localThrowable;
    label303:
    return localArrayList;
  }
  
  /* Error */
  private final void zzlm(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 404
    //   4: invokespecial 163	com/google/android/android/tagmanager/zzat:zzln	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aload_1
    //   16: invokestatic 196	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   19: ldc_w 406
    //   22: invokevirtual 205	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 5
    //   27: aload 4
    //   29: ldc 24
    //   31: ldc_w 408
    //   34: iconst_2
    //   35: anewarray 34	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: aload_1
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: aload 5
    //   46: aastore
    //   47: invokevirtual 187	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   50: istore_2
    //   51: new 122	java/lang/StringBuilder
    //   54: dup
    //   55: bipush 25
    //   57: invokespecial 125	java/lang/StringBuilder:<init>	(I)V
    //   60: astore 4
    //   62: aload 4
    //   64: ldc_w 410
    //   67: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 4
    //   73: iload_2
    //   74: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 4
    //   80: ldc_w 412
    //   83: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 4
    //   89: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore 4
    //   94: getstatic 146	com/google/android/android/tagmanager/zzdj:zzjss	Lcom/google/android/android/tagmanager/zzdk;
    //   97: astore 5
    //   99: aload 5
    //   101: aload 4
    //   103: invokeinterface 381 2 0
    //   108: aload_0
    //   109: getfield 77	com/google/android/android/tagmanager/zzat:zzjqs	Lcom/google/android/android/tagmanager/zzax;
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 218	android/database/sqlite/SQLiteOpenHelper:close	()V
    //   117: return
    //   118: astore_1
    //   119: goto +108 -> 227
    //   122: astore 4
    //   124: aload 4
    //   126: invokestatic 196	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: astore 4
    //   131: aload_1
    //   132: invokestatic 196	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   135: invokevirtual 199	java/lang/String:length	()I
    //   138: istore_2
    //   139: aload 4
    //   141: invokevirtual 199	java/lang/String:length	()I
    //   144: istore_3
    //   145: new 122	java/lang/StringBuilder
    //   148: dup
    //   149: iload_2
    //   150: bipush 44
    //   152: iadd
    //   153: iload_3
    //   154: iadd
    //   155: invokespecial 125	java/lang/StringBuilder:<init>	(I)V
    //   158: astore 5
    //   160: aload 5
    //   162: ldc_w 414
    //   165: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 5
    //   171: aload_1
    //   172: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 5
    //   178: ldc_w 416
    //   181: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 5
    //   187: aload 4
    //   189: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 5
    //   195: ldc_w 418
    //   198: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 5
    //   204: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: astore_1
    //   208: getstatic 146	com/google/android/android/tagmanager/zzdj:zzjss	Lcom/google/android/android/tagmanager/zzdk;
    //   211: aload_1
    //   212: invokeinterface 210 2 0
    //   217: aload_0
    //   218: getfield 77	com/google/android/android/tagmanager/zzat:zzjqs	Lcom/google/android/android/tagmanager/zzax;
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 218	android/database/sqlite/SQLiteOpenHelper:close	()V
    //   226: return
    //   227: aload_0
    //   228: getfield 77	com/google/android/android/tagmanager/zzat:zzjqs	Lcom/google/android/android/tagmanager/zzax;
    //   231: astore 4
    //   233: aload 4
    //   235: invokevirtual 218	android/database/sqlite/SQLiteOpenHelper:close	()V
    //   238: aload_1
    //   239: athrow
    //   240: astore_1
    //   241: return
    //   242: astore_1
    //   243: return
    //   244: astore 4
    //   246: goto -8 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	zzat
    //   0	249	1	paramString	String
    //   50	103	2	i	int
    //   144	11	3	j	int
    //   7	95	4	localObject1	Object
    //   122	3	4	localSQLiteException1	SQLiteException
    //   129	105	4	localObject2	Object
    //   244	1	4	localSQLiteException2	SQLiteException
    //   25	178	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	27	118	java/lang/Throwable
    //   27	51	118	java/lang/Throwable
    //   51	94	118	java/lang/Throwable
    //   99	108	118	java/lang/Throwable
    //   124	139	118	java/lang/Throwable
    //   139	145	118	java/lang/Throwable
    //   145	217	118	java/lang/Throwable
    //   15	27	122	android/database/sqlite/SQLiteException
    //   27	51	122	android/database/sqlite/SQLiteException
    //   51	94	122	android/database/sqlite/SQLiteException
    //   99	108	122	android/database/sqlite/SQLiteException
    //   113	117	240	android/database/sqlite/SQLiteException
    //   222	226	242	android/database/sqlite/SQLiteException
    //   233	238	244	android/database/sqlite/SQLiteException
  }
  
  private final SQLiteDatabase zzln(String paramString)
  {
    Object localObject = zzjqs;
    try
    {
      localObject = ((zzax)localObject).getWritableDatabase();
      return localObject;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;) {}
    }
    zzdj.zzjss.zzcr(paramString);
    return null;
  }
  
  public final void Save(List paramList, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DataLayer.zza localZza = (DataLayer.zza)paramList.next();
      localArrayList.add(new zzay(zzbff, zzae(mValue)));
    }
    zzjqr.execute(new zzau(this, localArrayList, paramLong));
  }
  
  public final void removeEntry(zzaq paramZzaq)
  {
    zzjqr.execute(new zzav(this, paramZzaq));
  }
  
  public final void zzll(String paramString)
  {
    zzjqr.execute(new zzaw(this, paramString));
  }
}
