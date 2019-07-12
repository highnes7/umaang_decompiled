package com.google.android.android.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.SystemClock;

public final class zzcbs
  extends zzcdu
{
  public final zzcbt zzipl = new zzcbt(this, getContext(), zzcax.zzawj());
  public boolean zzipm;
  
  public zzcbs(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  private final boolean doInBackground(int paramInt, byte[] paramArrayOfByte)
  {
    zzatv();
    zzuj();
    if (zzipm) {
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("type", Integer.valueOf(paramInt));
    localContentValues.put("entry", paramArrayOfByte);
    zzcax.zzawt();
    int i = 0;
    Object localObject5;
    int j;
    Object localObject3;
    for (paramInt = 5;; paramInt = j)
    {
      if (i >= 5) {
        break label618;
      }
      Object localObject1 = null;
      Object localObject4 = null;
      Object localObject2 = null;
      for (;;)
      {
        try
        {
          localSQLiteDatabase = getWritableDatabase();
          paramArrayOfByte = localSQLiteDatabase;
          if (localSQLiteDatabase == null) {
            localObject2 = paramArrayOfByte;
          }
        }
        catch (Throwable localThrowable2)
        {
          SQLiteDatabase localSQLiteDatabase;
          long l2;
          long l1;
          localObject3 = null;
          paramArrayOfByte = null;
        }
        catch (SQLiteException localSQLiteException2)
        {
          boolean bool;
          paramArrayOfByte = null;
          try
          {
            j = Build.VERSION.SDK_INT;
            bool = localSQLiteException2 instanceof SQLiteDatabaseLockedException;
            if (bool)
            {
              SystemClock.sleep(paramInt);
              paramInt += 20;
            }
            else
            {
              if (localObject3 != null)
              {
                bool = ((SQLiteDatabase)localObject3).inTransaction();
                if (bool) {
                  ((SQLiteDatabase)localObject3).endTransaction();
                }
              }
              zzaul().zzayd().append("Error writing entry to local database", localSQLiteException2);
              zzipm = true;
            }
            if (paramArrayOfByte != null) {
              ((Cursor)paramArrayOfByte).close();
            }
            j = paramInt;
            if (localObject3 != null)
            {
              ((SQLiteDatabase)localObject3).close();
              j = paramInt;
            }
          }
          catch (Throwable localThrowable3) {}
        }
        catch (SQLiteFullException localSQLiteFullException3)
        {
          paramArrayOfByte = null;
        }
        try
        {
          zzipm = true;
          if (localSQLiteDatabase == null) {
            break label632;
          }
          localSQLiteDatabase.close();
          return false;
        }
        catch (Throwable localThrowable4)
        {
          paramArrayOfByte = (byte[])localObject5;
          if (paramArrayOfByte == null) {
            break label602;
          }
          ((Cursor)paramArrayOfByte).close();
          if (localObject3 == null) {
            break label615;
          }
          ((SQLiteDatabase)localObject3).close();
          throw localThrowable4;
        }
        try
        {
          localSQLiteDatabase.beginTransaction();
          l2 = 0L;
          localObject2 = localSQLiteDatabase.rawQuery("select count(1) from messages", null);
          localObject1 = localObject2;
          l1 = l2;
          if (localObject2 != null) {
            try
            {
              bool = ((Cursor)localObject2).moveToFirst();
              l1 = l2;
              if (bool) {
                l1 = ((Cursor)localObject2).getLong(0);
              }
            }
            catch (Throwable localThrowable5)
            {
              localObject2 = paramArrayOfByte;
              paramArrayOfByte = localObject1;
              localObject1 = localThrowable5;
              break label589;
            }
            catch (SQLiteException localSQLiteException3)
            {
              paramArrayOfByte = localObject1;
              localObject1 = localSQLiteException3;
              continue;
            }
            catch (SQLiteFullException localSQLiteFullException1)
            {
              localObject1 = localSQLiteException3;
              break label509;
            }
          }
          if (l1 >= 100000L)
          {
            zzaul().zzayd().append("Data loss, local db full");
            l1 = 100000L - l1 + 1L;
            localObject5 = Long.toString(l1);
            j = localSQLiteFullException1.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[] { localObject5 });
            l2 = j;
            if (l2 != l1)
            {
              localObject5 = zzaul().zzayd();
              ((zzcby)localObject5).attribute("Different delete count than expected in local db. expected, received, difference", Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l1 - l2));
            }
          }
          localSQLiteFullException1.insertOrThrow("messages", null, localContentValues);
          localSQLiteFullException1.setTransactionSuccessful();
          localSQLiteFullException1.endTransaction();
          if (localSQLiteException3 != null) {
            localSQLiteException3.close();
          }
          localSQLiteFullException1.close();
          return true;
        }
        catch (Throwable localThrowable1)
        {
          localObject5 = null;
          localObject3 = paramArrayOfByte;
          paramArrayOfByte = (byte[])localObject5;
          break label589;
        }
        catch (SQLiteException localSQLiteException1)
        {
          paramArrayOfByte = null;
          localObject3 = localSQLiteFullException1;
        }
        catch (SQLiteFullException localSQLiteFullException2) {}
      }
      label509:
      localObject5 = localThrowable3;
      localObject3 = paramArrayOfByte;
      zzaul().zzayd().append("Error writing entry to local database", localSQLiteFullException3);
      localObject5 = localThrowable3;
      localObject3 = paramArrayOfByte;
      zzipm = true;
      if (localThrowable3 != null) {
        ((Cursor)localThrowable3).close();
      }
      j = paramInt;
      if (paramArrayOfByte != null)
      {
        ((SQLiteDatabase)paramArrayOfByte).close();
        j = paramInt;
      }
      i += 1;
    }
    label589:
    label602:
    label615:
    label618:
    zzaul().zzayf().append("Failed to write entry to local database");
    return false;
    label632:
    return false;
  }
  
  private final SQLiteDatabase getWritableDatabase()
  {
    if (zzipm) {
      return null;
    }
    SQLiteDatabase localSQLiteDatabase = zzipl.getWritableDatabase();
    if (localSQLiteDatabase == null)
    {
      zzipm = true;
      return null;
    }
    return localSQLiteDatabase;
  }
  
  public final boolean a(zzcbk paramZzcbk)
  {
    Parcel localParcel = Parcel.obtain();
    paramZzcbk.writeToParcel(localParcel, 0);
    paramZzcbk = localParcel.marshall();
    localParcel.recycle();
    if (paramZzcbk.length > 131072)
    {
      zzaul().zzayf().append("Event is too long for local database. Sending event directly to service");
      return false;
    }
    return doInBackground(0, paramZzcbk);
  }
  
  public final boolean c(zzcav paramZzcav)
  {
    zzauh();
    paramZzcav = zzcfw.marshall(paramZzcav);
    if (paramZzcav.length > 131072)
    {
      zzaul().zzayf().append("Conditional user property too long for local database. Sending directly to service");
      return false;
    }
    return doInBackground(2, paramZzcav);
  }
  
  public final boolean startSession(zzcft paramZzcft)
  {
    Parcel localParcel = Parcel.obtain();
    paramZzcft.writeToParcel(localParcel, 0);
    paramZzcft = localParcel.marshall();
    localParcel.recycle();
    if (paramZzcft.length > 131072)
    {
      zzaul().zzayf().append("User property too long for local database. Sending directly to service");
      return false;
    }
    return doInBackground(1, paramZzcft);
  }
  
  public final void zzatu()
  {
    zzccw.zzatu();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void zzatv()
  {
    zzcax.zzawk();
  }
  
  /* Error */
  public final java.util.List zzdw(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 45	com/google/android/android/internal/zzcbs:zzuj	()V
    //   4: aload_0
    //   5: invokevirtual 42	com/google/android/android/internal/zzcbs:zzatv	()V
    //   8: aload_0
    //   9: getfield 47	com/google/android/android/internal/zzcbs:zzipm	Z
    //   12: ifeq +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new 320	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 321	java/util/ArrayList:<init>	()V
    //   24: astore 17
    //   26: aload_0
    //   27: invokevirtual 18	com/google/android/android/internal/zzcbs:getContext	()Landroid/content/Context;
    //   30: invokestatic 24	com/google/android/android/internal/zzcax:zzawj	()Ljava/lang/String;
    //   33: invokevirtual 327	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   36: invokevirtual 332	java/io/File:exists	()Z
    //   39: ifne +6 -> 45
    //   42: aload 17
    //   44: areturn
    //   45: iconst_0
    //   46: istore_3
    //   47: iconst_5
    //   48: istore_1
    //   49: iload_3
    //   50: iconst_5
    //   51: if_icmpge +1151 -> 1202
    //   54: aload_0
    //   55: invokespecial 76	com/google/android/android/internal/zzcbs:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   58: astore 10
    //   60: aload 10
    //   62: ifnonnull +36 -> 98
    //   65: aload_0
    //   66: iconst_1
    //   67: putfield 47	com/google/android/android/internal/zzcbs:zzipm	Z
    //   70: aload 10
    //   72: ifnull +1160 -> 1232
    //   75: aload 10
    //   77: invokevirtual 81	android/database/sqlite/SQLiteClosable:close	()V
    //   80: aconst_null
    //   81: areturn
    //   82: astore 11
    //   84: aconst_null
    //   85: astore 13
    //   87: aload 10
    //   89: astore 14
    //   91: aload 11
    //   93: astore 10
    //   95: goto +1082 -> 1177
    //   98: aload 10
    //   100: invokevirtual 86	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   103: bipush 100
    //   105: invokestatic 335	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   108: astore 12
    //   110: aload 10
    //   112: astore 11
    //   114: aload 10
    //   116: ldc -126
    //   118: iconst_3
    //   119: anewarray 134	java/lang/String
    //   122: dup
    //   123: iconst_0
    //   124: ldc_w 337
    //   127: aastore
    //   128: dup
    //   129: iconst_1
    //   130: ldc 53
    //   132: aastore
    //   133: dup
    //   134: iconst_2
    //   135: ldc 65
    //   137: aastore
    //   138: aconst_null
    //   139: aconst_null
    //   140: aconst_null
    //   141: aconst_null
    //   142: ldc_w 339
    //   145: aload 12
    //   147: invokevirtual 343	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   150: astore 16
    //   152: aload 16
    //   154: astore 12
    //   156: ldc2_w 344
    //   159: lstore 5
    //   161: aload 12
    //   163: astore 13
    //   165: aload 11
    //   167: astore 14
    //   169: aload 16
    //   171: invokeinterface 348 1 0
    //   176: istore 9
    //   178: iload 9
    //   180: ifeq +544 -> 724
    //   183: aload 12
    //   185: astore 13
    //   187: aload 11
    //   189: astore 14
    //   191: aload 16
    //   193: iconst_0
    //   194: invokeinterface 102 2 0
    //   199: lstore 7
    //   201: aload 12
    //   203: astore 13
    //   205: aload 11
    //   207: astore 14
    //   209: aload 16
    //   211: iconst_1
    //   212: invokeinterface 352 2 0
    //   217: istore_2
    //   218: aload 12
    //   220: astore 13
    //   222: aload 11
    //   224: astore 14
    //   226: aload 16
    //   228: iconst_2
    //   229: invokeinterface 356 2 0
    //   234: astore 15
    //   236: iload_2
    //   237: ifne +167 -> 404
    //   240: aload 12
    //   242: astore 13
    //   244: aload 11
    //   246: astore 14
    //   248: invokestatic 194	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   251: astore 18
    //   253: aload 15
    //   255: arraylength
    //   256: istore_2
    //   257: aload 18
    //   259: aload 15
    //   261: iconst_0
    //   262: iload_2
    //   263: invokevirtual 360	android/os/Parcel:unmarshall	([BII)V
    //   266: aload 18
    //   268: iconst_0
    //   269: invokevirtual 364	android/os/Parcel:setDataPosition	(I)V
    //   272: getstatic 368	com/google/android/android/internal/zzcbk:CREATOR	Landroid/os/Parcelable$Creator;
    //   275: astore 13
    //   277: aload 13
    //   279: aload 18
    //   281: invokeinterface 374 2 0
    //   286: astore 13
    //   288: aload 13
    //   290: checkcast 196	com/google/android/android/internal/zzcbk
    //   293: astore 15
    //   295: aload 12
    //   297: astore 13
    //   299: aload 11
    //   301: astore 14
    //   303: aload 18
    //   305: invokevirtual 207	android/os/Parcel:recycle	()V
    //   308: lload 7
    //   310: lstore 5
    //   312: aload 15
    //   314: ifnull -153 -> 161
    //   317: aload 12
    //   319: astore 13
    //   321: aload 11
    //   323: astore 14
    //   325: aload 17
    //   327: aload 15
    //   329: invokeinterface 380 2 0
    //   334: pop
    //   335: lload 7
    //   337: lstore 5
    //   339: goto -178 -> 161
    //   342: astore 10
    //   344: goto +36 -> 380
    //   347: aload_0
    //   348: invokevirtual 108	com/google/android/android/internal/zzcbs:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   351: invokevirtual 114	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   354: ldc_w 382
    //   357: invokevirtual 122	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;)V
    //   360: aload 12
    //   362: astore 13
    //   364: aload 11
    //   366: astore 14
    //   368: aload 18
    //   370: invokevirtual 207	android/os/Parcel:recycle	()V
    //   373: lload 7
    //   375: lstore 5
    //   377: goto -216 -> 161
    //   380: aload 12
    //   382: astore 13
    //   384: aload 11
    //   386: astore 14
    //   388: aload 18
    //   390: invokevirtual 207	android/os/Parcel:recycle	()V
    //   393: aload 12
    //   395: astore 13
    //   397: aload 11
    //   399: astore 14
    //   401: aload 10
    //   403: athrow
    //   404: iload_2
    //   405: iconst_1
    //   406: if_icmpne +144 -> 550
    //   409: aload 12
    //   411: astore 13
    //   413: aload 11
    //   415: astore 14
    //   417: invokestatic 194	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   420: astore 18
    //   422: aload 15
    //   424: arraylength
    //   425: istore_2
    //   426: aload 18
    //   428: aload 15
    //   430: iconst_0
    //   431: iload_2
    //   432: invokevirtual 360	android/os/Parcel:unmarshall	([BII)V
    //   435: aload 18
    //   437: iconst_0
    //   438: invokevirtual 364	android/os/Parcel:setDataPosition	(I)V
    //   441: getstatic 383	com/google/android/android/internal/zzcft:CREATOR	Landroid/os/Parcelable$Creator;
    //   444: astore 13
    //   446: aload 13
    //   448: aload 18
    //   450: invokeinterface 374 2 0
    //   455: astore 13
    //   457: aload 13
    //   459: checkcast 232	com/google/android/android/internal/zzcft
    //   462: astore 15
    //   464: aload 12
    //   466: astore 13
    //   468: aload 11
    //   470: astore 14
    //   472: aload 18
    //   474: invokevirtual 207	android/os/Parcel:recycle	()V
    //   477: goto +37 -> 514
    //   480: astore 10
    //   482: goto +44 -> 526
    //   485: aload_0
    //   486: invokevirtual 108	com/google/android/android/internal/zzcbs:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   489: invokevirtual 114	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   492: ldc_w 385
    //   495: invokevirtual 122	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;)V
    //   498: aload 12
    //   500: astore 13
    //   502: aload 11
    //   504: astore 14
    //   506: aload 18
    //   508: invokevirtual 207	android/os/Parcel:recycle	()V
    //   511: aconst_null
    //   512: astore 15
    //   514: lload 7
    //   516: lstore 5
    //   518: aload 15
    //   520: ifnull -359 -> 161
    //   523: goto -206 -> 317
    //   526: aload 12
    //   528: astore 13
    //   530: aload 11
    //   532: astore 14
    //   534: aload 18
    //   536: invokevirtual 207	android/os/Parcel:recycle	()V
    //   539: aload 12
    //   541: astore 13
    //   543: aload 11
    //   545: astore 14
    //   547: aload 10
    //   549: athrow
    //   550: iload_2
    //   551: iconst_2
    //   552: if_icmpne +144 -> 696
    //   555: aload 12
    //   557: astore 13
    //   559: aload 11
    //   561: astore 14
    //   563: invokestatic 194	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   566: astore 18
    //   568: aload 15
    //   570: arraylength
    //   571: istore_2
    //   572: aload 18
    //   574: aload 15
    //   576: iconst_0
    //   577: iload_2
    //   578: invokevirtual 360	android/os/Parcel:unmarshall	([BII)V
    //   581: aload 18
    //   583: iconst_0
    //   584: invokevirtual 364	android/os/Parcel:setDataPosition	(I)V
    //   587: getstatic 388	com/google/android/android/internal/zzcav:CREATOR	Landroid/os/Parcelable$Creator;
    //   590: astore 13
    //   592: aload 13
    //   594: aload 18
    //   596: invokeinterface 374 2 0
    //   601: astore 13
    //   603: aload 13
    //   605: checkcast 387	com/google/android/android/internal/zzcav
    //   608: astore 15
    //   610: aload 12
    //   612: astore 13
    //   614: aload 11
    //   616: astore 14
    //   618: aload 18
    //   620: invokevirtual 207	android/os/Parcel:recycle	()V
    //   623: goto +37 -> 660
    //   626: astore 10
    //   628: goto +44 -> 672
    //   631: aload_0
    //   632: invokevirtual 108	com/google/android/android/internal/zzcbs:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   635: invokevirtual 114	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   638: ldc_w 385
    //   641: invokevirtual 122	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;)V
    //   644: aload 12
    //   646: astore 13
    //   648: aload 11
    //   650: astore 14
    //   652: aload 18
    //   654: invokevirtual 207	android/os/Parcel:recycle	()V
    //   657: aconst_null
    //   658: astore 15
    //   660: lload 7
    //   662: lstore 5
    //   664: aload 15
    //   666: ifnull -505 -> 161
    //   669: goto -352 -> 317
    //   672: aload 12
    //   674: astore 13
    //   676: aload 11
    //   678: astore 14
    //   680: aload 18
    //   682: invokevirtual 207	android/os/Parcel:recycle	()V
    //   685: aload 12
    //   687: astore 13
    //   689: aload 11
    //   691: astore 14
    //   693: aload 10
    //   695: athrow
    //   696: aload 12
    //   698: astore 13
    //   700: aload 11
    //   702: astore 14
    //   704: aload_0
    //   705: invokevirtual 108	com/google/android/android/internal/zzcbs:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   708: invokevirtual 114	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   711: ldc_w 390
    //   714: invokevirtual 122	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;)V
    //   717: lload 7
    //   719: lstore 5
    //   721: goto -560 -> 161
    //   724: aload 12
    //   726: astore 13
    //   728: aload 11
    //   730: astore 14
    //   732: lload 5
    //   734: invokestatic 128	java/lang/Long:toString	(J)Ljava/lang/String;
    //   737: astore 15
    //   739: aload 12
    //   741: astore 13
    //   743: aload 11
    //   745: astore 14
    //   747: aload 10
    //   749: ldc -126
    //   751: ldc_w 392
    //   754: iconst_1
    //   755: anewarray 134	java/lang/String
    //   758: dup
    //   759: iconst_0
    //   760: aload 15
    //   762: aastore
    //   763: invokevirtual 138	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   766: istore_2
    //   767: aload 12
    //   769: astore 13
    //   771: aload 11
    //   773: astore 14
    //   775: aload 17
    //   777: invokeinterface 395 1 0
    //   782: istore 4
    //   784: iload_2
    //   785: iload 4
    //   787: if_icmpge +24 -> 811
    //   790: aload 12
    //   792: astore 13
    //   794: aload 11
    //   796: astore 14
    //   798: aload_0
    //   799: invokevirtual 108	com/google/android/android/internal/zzcbs:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   802: invokevirtual 114	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   805: ldc_w 397
    //   808: invokevirtual 122	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;)V
    //   811: aload 12
    //   813: astore 13
    //   815: aload 11
    //   817: astore 14
    //   819: aload 10
    //   821: invokevirtual 154	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   824: aload 12
    //   826: astore 13
    //   828: aload 11
    //   830: astore 14
    //   832: aload 10
    //   834: invokevirtual 157	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   837: aload 16
    //   839: invokeinterface 158 1 0
    //   844: aload 10
    //   846: invokevirtual 81	android/database/sqlite/SQLiteClosable:close	()V
    //   849: aload 17
    //   851: areturn
    //   852: astore 13
    //   854: aload 11
    //   856: astore 10
    //   858: aload 13
    //   860: astore 11
    //   862: goto +82 -> 944
    //   865: astore 13
    //   867: aload 11
    //   869: astore 10
    //   871: aload 13
    //   873: astore 11
    //   875: goto +233 -> 1108
    //   878: astore 11
    //   880: goto +15 -> 895
    //   883: astore 11
    //   885: goto +26 -> 911
    //   888: astore 11
    //   890: goto +29 -> 919
    //   893: astore 11
    //   895: aload 10
    //   897: astore 14
    //   899: aconst_null
    //   900: astore 13
    //   902: aload 11
    //   904: astore 10
    //   906: goto +271 -> 1177
    //   909: astore 11
    //   911: aconst_null
    //   912: astore 12
    //   914: goto +30 -> 944
    //   917: astore 11
    //   919: aconst_null
    //   920: astore 12
    //   922: goto +186 -> 1108
    //   925: astore 10
    //   927: aconst_null
    //   928: astore 14
    //   930: aconst_null
    //   931: astore 13
    //   933: goto +244 -> 1177
    //   936: astore 11
    //   938: aconst_null
    //   939: astore 10
    //   941: aconst_null
    //   942: astore 12
    //   944: aload 12
    //   946: astore 13
    //   948: aload 10
    //   950: astore 14
    //   952: getstatic 164	android/os/Build$VERSION:SDK_INT	I
    //   955: istore_2
    //   956: aload 12
    //   958: astore 13
    //   960: aload 10
    //   962: astore 14
    //   964: aload 11
    //   966: instanceof 166
    //   969: istore 9
    //   971: iload 9
    //   973: ifeq +24 -> 997
    //   976: aload 12
    //   978: astore 13
    //   980: aload 10
    //   982: astore 14
    //   984: iload_1
    //   985: i2l
    //   986: invokestatic 172	android/os/SystemClock:sleep	(J)V
    //   989: iload_1
    //   990: bipush 20
    //   992: iadd
    //   993: istore_1
    //   994: goto +77 -> 1071
    //   997: aload 10
    //   999: ifnull +36 -> 1035
    //   1002: aload 12
    //   1004: astore 13
    //   1006: aload 10
    //   1008: astore 14
    //   1010: aload 10
    //   1012: invokevirtual 175	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   1015: istore 9
    //   1017: iload 9
    //   1019: ifeq +16 -> 1035
    //   1022: aload 12
    //   1024: astore 13
    //   1026: aload 10
    //   1028: astore 14
    //   1030: aload 10
    //   1032: invokevirtual 157	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1035: aload 12
    //   1037: astore 13
    //   1039: aload 10
    //   1041: astore 14
    //   1043: aload_0
    //   1044: invokevirtual 108	com/google/android/android/internal/zzcbs:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   1047: invokevirtual 114	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   1050: ldc_w 399
    //   1053: aload 11
    //   1055: invokevirtual 180	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1058: aload 12
    //   1060: astore 13
    //   1062: aload 10
    //   1064: astore 14
    //   1066: aload_0
    //   1067: iconst_1
    //   1068: putfield 47	com/google/android/android/internal/zzcbs:zzipm	Z
    //   1071: aload 12
    //   1073: ifnull +10 -> 1083
    //   1076: aload 12
    //   1078: invokeinterface 158 1 0
    //   1083: iload_1
    //   1084: istore_2
    //   1085: aload 10
    //   1087: ifnull +79 -> 1166
    //   1090: aload 10
    //   1092: invokevirtual 81	android/database/sqlite/SQLiteClosable:close	()V
    //   1095: iload_1
    //   1096: istore_2
    //   1097: goto +69 -> 1166
    //   1100: astore 11
    //   1102: aconst_null
    //   1103: astore 10
    //   1105: aconst_null
    //   1106: astore 12
    //   1108: aload 12
    //   1110: astore 13
    //   1112: aload 10
    //   1114: astore 14
    //   1116: aload_0
    //   1117: invokevirtual 108	com/google/android/android/internal/zzcbs:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   1120: invokevirtual 114	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   1123: ldc_w 399
    //   1126: aload 11
    //   1128: invokevirtual 180	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1131: aload 12
    //   1133: astore 13
    //   1135: aload 10
    //   1137: astore 14
    //   1139: aload_0
    //   1140: iconst_1
    //   1141: putfield 47	com/google/android/android/internal/zzcbs:zzipm	Z
    //   1144: aload 12
    //   1146: ifnull +10 -> 1156
    //   1149: aload 12
    //   1151: invokeinterface 158 1 0
    //   1156: iload_1
    //   1157: istore_2
    //   1158: aload 10
    //   1160: ifnull +6 -> 1166
    //   1163: goto -73 -> 1090
    //   1166: iload_3
    //   1167: iconst_1
    //   1168: iadd
    //   1169: istore_3
    //   1170: iload_2
    //   1171: istore_1
    //   1172: goto -1123 -> 49
    //   1175: astore 10
    //   1177: aload 13
    //   1179: ifnull +10 -> 1189
    //   1182: aload 13
    //   1184: invokeinterface 158 1 0
    //   1189: aload 14
    //   1191: ifnull +8 -> 1199
    //   1194: aload 14
    //   1196: invokevirtual 81	android/database/sqlite/SQLiteClosable:close	()V
    //   1199: aload 10
    //   1201: athrow
    //   1202: aload_0
    //   1203: invokevirtual 108	com/google/android/android/internal/zzcbs:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   1206: invokevirtual 183	com/google/android/android/internal/zzcbw:zzayf	()Lcom/google/android/android/internal/zzcby;
    //   1209: ldc_w 401
    //   1212: invokevirtual 122	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;)V
    //   1215: aconst_null
    //   1216: areturn
    //   1217: astore 13
    //   1219: goto -872 -> 347
    //   1222: astore 13
    //   1224: goto -739 -> 485
    //   1227: astore 13
    //   1229: goto -598 -> 631
    //   1232: aconst_null
    //   1233: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1234	0	this	zzcbs
    //   0	1234	1	paramInt	int
    //   217	954	2	i	int
    //   46	1124	3	j	int
    //   782	6	4	k	int
    //   159	574	5	l1	long
    //   199	519	7	l2	long
    //   176	842	9	bool	boolean
    //   58	57	10	localObject1	Object
    //   342	60	10	localThrowable1	Throwable
    //   480	68	10	localThrowable2	Throwable
    //   626	219	10	localThrowable3	Throwable
    //   856	49	10	localObject2	Object
    //   925	1	10	localThrowable4	Throwable
    //   939	220	10	localObject3	Object
    //   1175	25	10	localThrowable5	Throwable
    //   82	10	11	localThrowable6	Throwable
    //   112	762	11	localObject4	Object
    //   878	1	11	localThrowable7	Throwable
    //   883	1	11	localSQLiteException1	SQLiteException
    //   888	1	11	localSQLiteFullException1	SQLiteFullException
    //   893	10	11	localThrowable8	Throwable
    //   909	1	11	localSQLiteException2	SQLiteException
    //   917	1	11	localSQLiteFullException2	SQLiteFullException
    //   936	118	11	localSQLiteException3	SQLiteException
    //   1100	27	11	localSQLiteFullException3	SQLiteFullException
    //   108	1042	12	localObject5	Object
    //   85	742	13	localObject6	Object
    //   852	7	13	localSQLiteException4	SQLiteException
    //   865	7	13	localSQLiteFullException4	SQLiteFullException
    //   900	283	13	localObject7	Object
    //   1217	1	13	localZzbcm1	zzbcm
    //   1222	1	13	localZzbcm2	zzbcm
    //   1227	1	13	localZzbcm3	zzbcm
    //   89	1106	14	localObject8	Object
    //   234	527	15	localObject9	Object
    //   150	688	16	localCursor	Cursor
    //   24	826	17	localArrayList	java.util.ArrayList
    //   251	430	18	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   65	70	82	java/lang/Throwable
    //   253	257	342	java/lang/Throwable
    //   257	272	342	java/lang/Throwable
    //   272	277	342	java/lang/Throwable
    //   277	288	342	java/lang/Throwable
    //   288	295	342	java/lang/Throwable
    //   347	360	342	java/lang/Throwable
    //   422	426	480	java/lang/Throwable
    //   426	441	480	java/lang/Throwable
    //   441	446	480	java/lang/Throwable
    //   446	457	480	java/lang/Throwable
    //   457	464	480	java/lang/Throwable
    //   485	498	480	java/lang/Throwable
    //   568	572	626	java/lang/Throwable
    //   572	587	626	java/lang/Throwable
    //   587	592	626	java/lang/Throwable
    //   592	603	626	java/lang/Throwable
    //   603	610	626	java/lang/Throwable
    //   631	644	626	java/lang/Throwable
    //   169	178	852	android/database/sqlite/SQLiteException
    //   191	201	852	android/database/sqlite/SQLiteException
    //   209	218	852	android/database/sqlite/SQLiteException
    //   226	236	852	android/database/sqlite/SQLiteException
    //   248	253	852	android/database/sqlite/SQLiteException
    //   303	308	852	android/database/sqlite/SQLiteException
    //   325	335	852	android/database/sqlite/SQLiteException
    //   368	373	852	android/database/sqlite/SQLiteException
    //   388	393	852	android/database/sqlite/SQLiteException
    //   401	404	852	android/database/sqlite/SQLiteException
    //   417	422	852	android/database/sqlite/SQLiteException
    //   472	477	852	android/database/sqlite/SQLiteException
    //   506	511	852	android/database/sqlite/SQLiteException
    //   534	539	852	android/database/sqlite/SQLiteException
    //   547	550	852	android/database/sqlite/SQLiteException
    //   563	568	852	android/database/sqlite/SQLiteException
    //   618	623	852	android/database/sqlite/SQLiteException
    //   652	657	852	android/database/sqlite/SQLiteException
    //   680	685	852	android/database/sqlite/SQLiteException
    //   693	696	852	android/database/sqlite/SQLiteException
    //   704	717	852	android/database/sqlite/SQLiteException
    //   732	739	852	android/database/sqlite/SQLiteException
    //   747	767	852	android/database/sqlite/SQLiteException
    //   775	784	852	android/database/sqlite/SQLiteException
    //   798	811	852	android/database/sqlite/SQLiteException
    //   819	824	852	android/database/sqlite/SQLiteException
    //   832	837	852	android/database/sqlite/SQLiteException
    //   169	178	865	android/database/sqlite/SQLiteFullException
    //   191	201	865	android/database/sqlite/SQLiteFullException
    //   209	218	865	android/database/sqlite/SQLiteFullException
    //   226	236	865	android/database/sqlite/SQLiteFullException
    //   248	253	865	android/database/sqlite/SQLiteFullException
    //   303	308	865	android/database/sqlite/SQLiteFullException
    //   325	335	865	android/database/sqlite/SQLiteFullException
    //   368	373	865	android/database/sqlite/SQLiteFullException
    //   388	393	865	android/database/sqlite/SQLiteFullException
    //   401	404	865	android/database/sqlite/SQLiteFullException
    //   417	422	865	android/database/sqlite/SQLiteFullException
    //   472	477	865	android/database/sqlite/SQLiteFullException
    //   506	511	865	android/database/sqlite/SQLiteFullException
    //   534	539	865	android/database/sqlite/SQLiteFullException
    //   547	550	865	android/database/sqlite/SQLiteFullException
    //   563	568	865	android/database/sqlite/SQLiteFullException
    //   618	623	865	android/database/sqlite/SQLiteFullException
    //   652	657	865	android/database/sqlite/SQLiteFullException
    //   680	685	865	android/database/sqlite/SQLiteFullException
    //   693	696	865	android/database/sqlite/SQLiteFullException
    //   704	717	865	android/database/sqlite/SQLiteFullException
    //   732	739	865	android/database/sqlite/SQLiteFullException
    //   747	767	865	android/database/sqlite/SQLiteFullException
    //   775	784	865	android/database/sqlite/SQLiteFullException
    //   798	811	865	android/database/sqlite/SQLiteFullException
    //   819	824	865	android/database/sqlite/SQLiteFullException
    //   832	837	865	android/database/sqlite/SQLiteFullException
    //   114	152	878	java/lang/Throwable
    //   114	152	883	android/database/sqlite/SQLiteException
    //   114	152	888	android/database/sqlite/SQLiteFullException
    //   98	103	893	java/lang/Throwable
    //   103	110	893	java/lang/Throwable
    //   98	103	909	android/database/sqlite/SQLiteException
    //   103	110	909	android/database/sqlite/SQLiteException
    //   98	103	917	android/database/sqlite/SQLiteFullException
    //   103	110	917	android/database/sqlite/SQLiteFullException
    //   54	60	925	java/lang/Throwable
    //   54	60	936	android/database/sqlite/SQLiteException
    //   54	60	1100	android/database/sqlite/SQLiteFullException
    //   169	178	1175	java/lang/Throwable
    //   191	201	1175	java/lang/Throwable
    //   209	218	1175	java/lang/Throwable
    //   226	236	1175	java/lang/Throwable
    //   248	253	1175	java/lang/Throwable
    //   303	308	1175	java/lang/Throwable
    //   325	335	1175	java/lang/Throwable
    //   368	373	1175	java/lang/Throwable
    //   388	393	1175	java/lang/Throwable
    //   401	404	1175	java/lang/Throwable
    //   417	422	1175	java/lang/Throwable
    //   472	477	1175	java/lang/Throwable
    //   506	511	1175	java/lang/Throwable
    //   534	539	1175	java/lang/Throwable
    //   547	550	1175	java/lang/Throwable
    //   563	568	1175	java/lang/Throwable
    //   618	623	1175	java/lang/Throwable
    //   652	657	1175	java/lang/Throwable
    //   680	685	1175	java/lang/Throwable
    //   693	696	1175	java/lang/Throwable
    //   704	717	1175	java/lang/Throwable
    //   732	739	1175	java/lang/Throwable
    //   747	767	1175	java/lang/Throwable
    //   775	784	1175	java/lang/Throwable
    //   798	811	1175	java/lang/Throwable
    //   819	824	1175	java/lang/Throwable
    //   832	837	1175	java/lang/Throwable
    //   952	956	1175	java/lang/Throwable
    //   964	971	1175	java/lang/Throwable
    //   984	989	1175	java/lang/Throwable
    //   1010	1017	1175	java/lang/Throwable
    //   1030	1035	1175	java/lang/Throwable
    //   1043	1058	1175	java/lang/Throwable
    //   1066	1071	1175	java/lang/Throwable
    //   1116	1131	1175	java/lang/Throwable
    //   1139	1144	1175	java/lang/Throwable
    //   257	272	1217	com/google/android/android/internal/zzbcm
    //   277	288	1217	com/google/android/android/internal/zzbcm
    //   426	441	1222	com/google/android/android/internal/zzbcm
    //   446	457	1222	com/google/android/android/internal/zzbcm
    //   572	587	1227	com/google/android/android/internal/zzbcm
    //   592	603	1227	com/google/android/android/internal/zzbcm
  }
  
  public final void zzuk() {}
}
