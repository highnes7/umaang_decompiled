package com.google.android.android.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class zzeve<FieldDescriptorType extends com.google.android.gms.internal.zzevg<FieldDescriptorType>>
{
  public static final zzeve zzoob = new zzeve(true);
  public boolean zzkff;
  public final com.google.android.gms.internal.zzewx<FieldDescriptorType, Object> zzonz;
  public boolean zzooa = false;
  
  public zzeve()
  {
    zzonz = zzewx.zzku(16);
  }
  
  public zzeve(boolean paramBoolean)
  {
    zzonz = zzewx.zzku(0);
    if (!zzkff)
    {
      zzonz.zzbhs();
      zzkff = true;
    }
  }
  
  public static Object readValue(zzeut paramZzeut, zzexu paramZzexu, boolean paramBoolean)
    throws IOException
  {
    zzeya localZzeya = zzeya.zzotf;
    switch (zzext.zzood[paramZzexu.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 18: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    case 17: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    case 16: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    case 15: 
      return localZzeya.readValue(paramZzeut);
    case 14: 
      return Long.valueOf(paramZzeut.zzctb());
    case 13: 
      return Integer.valueOf(paramZzeut.zzcta());
    case 12: 
      return Long.valueOf(paramZzeut.zzcsz());
    case 11: 
      return Integer.valueOf(paramZzeut.zzcsy());
    case 10: 
      return Integer.valueOf(paramZzeut.zzcsw());
    case 9: 
      return paramZzeut.zzcsv();
    case 8: 
      return Boolean.valueOf(paramZzeut.zzcst());
    case 7: 
      return Integer.valueOf(paramZzeut.zzcss());
    case 6: 
      return Long.valueOf(paramZzeut.zzcsr());
    case 5: 
      return Integer.valueOf(paramZzeut.zzcsq());
    case 4: 
      return Long.valueOf(paramZzeut.zzcso());
    case 3: 
      return Long.valueOf(paramZzeut.zzcsp());
    case 2: 
      return Float.valueOf(paramZzeut.readFloat());
    }
    return Double.valueOf(paramZzeut.readDouble());
  }
  
  private void setField(zzevg paramZzevg, Object paramObject)
  {
    if (paramZzevg.zzctx())
    {
      if ((paramObject instanceof List))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((List)paramObject);
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          paramObject = localArrayList.get(i);
          i += 1;
          setField(paramZzevg.zzctw(), paramObject);
        }
        paramObject = localArrayList;
      }
      else
      {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    else {
      setField(paramZzevg.zzctw(), paramObject);
    }
    if ((paramObject instanceof zzewb)) {
      zzooa = true;
    }
    zzonz.put(paramZzevg, paramObject);
  }
  
  /* Error */
  public static void setField(zzexu paramZzexu, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 200	com/google/android/android/internal/zzevu:add	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: getstatic 205	com/google/android/android/internal/zzevf:zzooc	[I
    //   8: aload_0
    //   9: invokevirtual 211	com/google/android/android/internal/zzexu:zzcvx	()Lcom/google/android/android/internal/zzexz;
    //   12: invokevirtual 61	java/lang/Enum:ordinal	()I
    //   15: iaload
    //   16: istore_2
    //   17: iconst_0
    //   18: istore_3
    //   19: iload_2
    //   20: lookupswitch	default:+84->104, 1:+183->203, 2:+175->195, 3:+167->187, 4:+159->179, 5:+151->171, 6:+143->163, 7:+126->146, 8:+107->127, 9:+90->110
    //   104: goto +3 -> 107
    //   107: goto +101 -> 208
    //   110: aload_1
    //   111: instanceof 213
    //   114: ifne +27 -> 141
    //   117: aload_1
    //   118: instanceof 190
    //   121: ifeq +87 -> 208
    //   124: goto +17 -> 141
    //   127: aload_1
    //   128: instanceof 97
    //   131: ifne +10 -> 141
    //   134: aload_1
    //   135: instanceof 215
    //   138: ifeq +70 -> 208
    //   141: iconst_1
    //   142: istore_3
    //   143: goto +65 -> 208
    //   146: aload_1
    //   147: instanceof 217
    //   150: ifne -9 -> 141
    //   153: aload_1
    //   154: instanceof 219
    //   157: ifeq +51 -> 208
    //   160: goto -19 -> 141
    //   163: aload_1
    //   164: instanceof 221
    //   167: istore_3
    //   168: goto +40 -> 208
    //   171: aload_1
    //   172: instanceof 119
    //   175: istore_3
    //   176: goto +32 -> 208
    //   179: aload_1
    //   180: instanceof 152
    //   183: istore_3
    //   184: goto +24 -> 208
    //   187: aload_1
    //   188: instanceof 143
    //   191: istore_3
    //   192: goto +16 -> 208
    //   195: aload_1
    //   196: instanceof 88
    //   199: istore_3
    //   200: goto +8 -> 208
    //   203: aload_1
    //   204: instanceof 97
    //   207: istore_3
    //   208: iload_3
    //   209: ifeq +4 -> 213
    //   212: return
    //   213: new 70	java/lang/IllegalArgumentException
    //   216: dup
    //   217: ldc -68
    //   219: invokespecial 73	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   222: astore_0
    //   223: goto +3 -> 226
    //   226: aload_0
    //   227: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramZzexu	zzexu
    //   0	228	1	paramObject	Object
    //   16	4	2	i	int
    //   18	191	3	bool	boolean
  }
  
  public static int writeField(zzexu paramZzexu, int paramInt, Object paramObject)
  {
    paramInt = zzeuy.zzkb(paramInt);
    int i = paramInt;
    if (paramZzexu == zzexu.zzosh)
    {
      zzevu.writeTag((zzewl)paramObject);
      i = paramInt << 1;
    }
    int j = zzevf.zzood[paramZzexu.ordinal()];
    paramInt = 4;
    switch (j)
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 18: 
      if ((paramObject instanceof zzevv)) {}
      for (paramInt = ((zzevv)paramObject).zzhk();; paramInt = ((Integer)paramObject).intValue())
      {
        paramInt = zzeuy.zzkc(paramInt);
        break;
      }
    case 17: 
      paramInt = zzeuy.zzcw(((Long)paramObject).longValue());
      break;
    case 16: 
      paramInt = zzeuy.zzke(((Integer)paramObject).intValue());
      break;
    case 15: 
      zzeuy.zzcy(((Long)paramObject).longValue());
      break;
    case 14: 
      zzeuy.zzkg(((Integer)paramObject).intValue());
      break;
    case 13: 
      paramInt = zzeuy.zzkd(((Integer)paramObject).intValue());
      break;
    case 12: 
      if (!(paramObject instanceof zzeuk)) {
        paramInt = zzeuy.zzbd((byte[])paramObject);
      }
      break;
    case 11: 
      if ((paramObject instanceof zzeuk)) {
        paramInt = zzeuy.zzan((zzeuk)paramObject);
      } else {
        paramInt = zzeuy.zztk((String)paramObject);
      }
      break;
    case 10: 
      if ((paramObject instanceof zzewb)) {
        paramInt = zzeuy.bitLength((zzewb)paramObject);
      } else {
        paramInt = zzeuy.bitLength((zzewl)paramObject);
      }
      break;
    case 9: 
      paramInt = zzeuy.writeValue((zzewl)paramObject);
      break;
    case 8: 
      zzeuy.zzcy(((Boolean)paramObject).booleanValue());
      paramInt = 1;
      break;
    case 7: 
      zzeuy.zzkf(((Integer)paramObject).intValue());
      break;
    case 6: 
      zzeuy.zzcx(((Long)paramObject).longValue());
      break;
    case 5: 
      paramInt = zzeuy.zzkc(((Integer)paramObject).intValue());
      break;
    case 4: 
      paramInt = zzeuy.zzcv(((Long)paramObject).longValue());
      break;
    case 3: 
      paramInt = zzeuy.zzcv(((Long)paramObject).longValue());
      break;
    case 2: 
      zzeuy.write(((Float)paramObject).floatValue());
      break;
    }
    zzeuy.computeDoubleSizeNoTag(((Double)paramObject).doubleValue());
    paramInt = 8;
    return i + paramInt;
  }
  
  public static void writeField(zzeuy paramZzeuy, zzexu paramZzexu, int paramInt, Object paramObject)
    throws IOException
  {
    if (paramZzexu == zzexu.zzosh)
    {
      paramZzexu = (zzewl)paramObject;
      zzevu.writeTag(paramZzexu);
      paramZzeuy.write(paramInt, 3);
      paramZzexu.writeTo(paramZzeuy);
      paramZzeuy.write(paramInt, 4);
      return;
    }
    paramZzeuy.write(paramInt, paramZzexu.zzcvy());
    switch (zzevf.zzood[paramZzexu.ordinal()])
    {
    default: 
      return;
    case 18: 
      if ((paramObject instanceof zzevv))
      {
        paramZzeuy.zzjx(((zzevv)paramObject).zzhk());
        return;
      }
      paramZzeuy.zzjx(((Integer)paramObject).intValue());
      return;
    case 17: 
      paramZzeuy.zzcs(((Long)paramObject).longValue());
      return;
    case 16: 
      paramZzeuy.zzjz(((Integer)paramObject).intValue());
      return;
    case 15: 
      paramZzeuy.zzct(((Long)paramObject).longValue());
      return;
    case 14: 
      paramZzeuy.zzka(((Integer)paramObject).intValue());
      return;
    case 13: 
      paramZzeuy.zzjy(((Integer)paramObject).intValue());
      return;
    case 12: 
      if ((paramObject instanceof zzeuk))
      {
        paramZzeuy.zzam((zzeuk)paramObject);
        return;
      }
      paramZzexu = (byte[])paramObject;
      paramZzeuy.writeValue(paramZzexu, 0, paramZzexu.length);
      return;
    case 11: 
      if ((paramObject instanceof zzeuk))
      {
        paramZzeuy.zzam((zzeuk)paramObject);
        return;
      }
      paramZzeuy.zztj((String)paramObject);
      return;
    case 10: 
      paramZzeuy.writeTag((zzewl)paramObject);
      return;
    case 9: 
      ((zzewl)paramObject).writeTo(paramZzeuy);
      return;
    case 8: 
      paramZzeuy.write((byte)((Boolean)paramObject).booleanValue());
      return;
    case 7: 
      paramZzeuy.zzka(((Integer)paramObject).intValue());
      return;
    case 6: 
      paramZzeuy.zzct(((Long)paramObject).longValue());
      return;
    case 5: 
      paramZzeuy.zzjx(((Integer)paramObject).intValue());
      return;
    case 4: 
      paramZzeuy.zzcr(((Long)paramObject).longValue());
      return;
    case 3: 
      paramZzeuy.zzcr(((Long)paramObject).longValue());
      return;
    case 2: 
      paramZzeuy.zzka(Float.floatToRawIntBits(((Float)paramObject).floatValue()));
      return;
    }
    paramZzeuy.zzct(Double.doubleToRawLongBits(((Double)paramObject).doubleValue()));
  }
  
  public static zzeve zzctv()
  {
    return new zzeve();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzeve)) {
      return false;
    }
    paramObject = (zzeve)paramObject;
    return zzonz.equals(zzonz);
  }
  
  public final int hashCode()
  {
    return zzonz.hashCode();
  }
  
  public final Iterator iterator()
  {
    if (zzooa) {
      return new zzewe(zzonz.entrySet().iterator());
    }
    return zzonz.entrySet().iterator();
  }
}
