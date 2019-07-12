package com.coremedia.iso.boxes;

import f.h.a.MimeMessage;
import f.h.a.g.c;
import f.slide.asm.ByteBufferList;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.aspectj.lang.JoinPoint;

public class TimeToSampleBox
  extends MimeMessage
{
  public static final String TYPE = "stts";
  public static Map<List<Entry>, SoftReference<long[]>> cache = new WeakHashMap();
  public List<Entry> entries = Collections.emptyList();
  
  static {}
  
  public TimeToSampleBox()
  {
    super("stts");
  }
  
  /* Error */
  public static long[] blowupTimeToSamples(List paramList)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 36	com/coremedia/iso/boxes/TimeToSampleBox:cache	Ljava/util/Map;
    //   6: aload_0
    //   7: invokeinterface 100 2 0
    //   12: checkcast 102	java/lang/ref/SoftReference
    //   15: astore 7
    //   17: aload 7
    //   19: ifnull +24 -> 43
    //   22: aload 7
    //   24: invokevirtual 105	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   27: checkcast 107	[J
    //   30: astore 7
    //   32: aload 7
    //   34: ifnull +9 -> 43
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload 7
    //   42: areturn
    //   43: lconst_0
    //   44: lstore_3
    //   45: aload_0
    //   46: invokeinterface 113 1 0
    //   51: astore 7
    //   53: aload 7
    //   55: invokeinterface 119 1 0
    //   60: ifne +102 -> 162
    //   63: lload_3
    //   64: l2i
    //   65: newarray long
    //   67: astore 7
    //   69: aload_0
    //   70: invokeinterface 113 1 0
    //   75: astore 8
    //   77: iconst_0
    //   78: istore_1
    //   79: aload 8
    //   81: invokeinterface 119 1 0
    //   86: ifne +28 -> 114
    //   89: getstatic 36	com/coremedia/iso/boxes/TimeToSampleBox:cache	Ljava/util/Map;
    //   92: aload_0
    //   93: new 102	java/lang/ref/SoftReference
    //   96: dup
    //   97: aload 7
    //   99: invokespecial 122	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   102: invokeinterface 126 3 0
    //   107: pop
    //   108: ldc 2
    //   110: monitorexit
    //   111: aload 7
    //   113: areturn
    //   114: aload 8
    //   116: invokeinterface 129 1 0
    //   121: checkcast 6	com/coremedia/iso/boxes/TimeToSampleBox$Entry
    //   124: astore 9
    //   126: iconst_0
    //   127: istore_2
    //   128: iload_2
    //   129: i2l
    //   130: aload 9
    //   132: invokevirtual 133	com/coremedia/iso/boxes/TimeToSampleBox$Entry:getCount	()J
    //   135: lcmp
    //   136: iflt +6 -> 142
    //   139: goto -60 -> 79
    //   142: aload 7
    //   144: iload_1
    //   145: aload 9
    //   147: invokevirtual 136	com/coremedia/iso/boxes/TimeToSampleBox$Entry:getDelta	()J
    //   150: lastore
    //   151: iload_2
    //   152: iconst_1
    //   153: iadd
    //   154: istore_2
    //   155: iload_1
    //   156: iconst_1
    //   157: iadd
    //   158: istore_1
    //   159: goto -31 -> 128
    //   162: aload 7
    //   164: invokeinterface 129 1 0
    //   169: checkcast 6	com/coremedia/iso/boxes/TimeToSampleBox$Entry
    //   172: invokevirtual 133	com/coremedia/iso/boxes/TimeToSampleBox$Entry:getCount	()J
    //   175: lstore 5
    //   177: lload_3
    //   178: lload 5
    //   180: ladd
    //   181: lstore_3
    //   182: goto -129 -> 53
    //   185: astore_0
    //   186: ldc 2
    //   188: monitorexit
    //   189: goto +3 -> 192
    //   192: aload_0
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramList	List
    //   78	81	1	i	int
    //   127	28	2	j	int
    //   44	138	3	l1	long
    //   175	4	5	l2	long
    //   15	148	7	localObject	Object
    //   75	40	8	localIterator	Iterator
    //   124	22	9	localEntry	Entry
    // Exception table:
    //   from	to	target	type
    //   3	17	185	java/lang/Throwable
    //   22	32	185	java/lang/Throwable
    //   45	53	185	java/lang/Throwable
    //   53	77	185	java/lang/Throwable
    //   79	108	185	java/lang/Throwable
    //   114	126	185	java/lang/Throwable
    //   128	139	185	java/lang/Throwable
    //   142	151	185	java/lang/Throwable
    //   162	177	185	java/lang/Throwable
  }
  
  public void _parseDetails(ByteBuffer paramByteBuffer)
  {
    parseVersionAndFlags(paramByteBuffer);
    int j = c.a(ByteBufferList.readUInt32(paramByteBuffer));
    entries = new ArrayList(j);
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      entries.add(new Entry(ByteBufferList.readUInt32(paramByteBuffer), ByteBufferList.readUInt32(paramByteBuffer)));
      i += 1;
    }
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    writeVersionAndFlags(paramByteBuffer);
    paramByteBuffer.putInt((int)entries.size());
    Iterator localIterator = entries.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Entry localEntry = (Entry)localIterator.next();
      paramByteBuffer.putInt((int)localEntry.getCount());
      paramByteBuffer.putInt((int)localEntry.getDelta());
    }
  }
  
  public long getContentSize()
  {
    return entries.size() * 8 + 8;
  }
  
  public List getEntries()
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_0, this, this);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    return entries;
  }
  
  public void setEntries(List paramList)
  {
    JoinPoint localJoinPoint = org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_1, this, this, paramList);
    f.h.a.Factory.aspectOf().before(localJoinPoint);
    entries = paramList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.getTag(org.aspectj.runtime.reflect.Factory.makeJP(ajc$tjp_2, this, this), "TimeToSampleBox[entryCount=");
    localStringBuilder.append(entries.size());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static class Entry
  {
    public long count;
    public long delta;
    
    public Entry(long paramLong1, long paramLong2)
    {
      count = paramLong1;
      delta = paramLong2;
    }
    
    public long getCount()
    {
      return count;
    }
    
    public long getDelta()
    {
      return delta;
    }
    
    public void setCount(long paramLong)
    {
      count = paramLong;
    }
    
    public void setDelta(long paramLong)
    {
      delta = paramLong;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Entry{count=");
      localStringBuilder.append(count);
      localStringBuilder.append(", delta=");
      localStringBuilder.append(delta);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}
