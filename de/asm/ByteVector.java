package de.asm;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import b.b.a.N;
import c.b.g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import support.android.v4.util.NodeList;

@N({b.b.a.N.a.b})
public abstract class ByteVector
{
  public static final int ATTENDEES_INDEX_RELATIONSHIP = 3;
  public static final int CALENDARS_INDEX_CAN_ORGANIZER_RESPOND = 4;
  public static final int ConstructorId_parseFloat = -5;
  public static final int DEFAULT_BLOCK_SIZE = 1;
  public static final int HINT_CONTEXT_CAR_HOME = 2;
  public static final int RESULT_MAX_LENGTH_EXCEEDED = -2;
  public static final int SHELL_EXEC_FAILED = -3;
  public static final int STATE_FIELD2 = -6;
  public static final int VOICE_INPUT = -4;
  public static final int a = -1;
  public static final String b = "VersionedParcel";
  public static final int blockSize = -9;
  public static final int n = 5;
  public static final int size = -7;
  
  public ByteVector() {}
  
  public static h a(String paramString, ByteVector paramByteVector)
  {
    try
    {
      paramString = Class.forName(paramString, true, g.class.getClassLoader());
      paramString = paramString.getDeclaredMethod("read", new Class[] { g.class });
      paramString = paramString.invoke(null, new Object[] { paramByteVector });
      return (h)paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", paramString);
    }
    catch (NoSuchMethodException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", paramString);
    }
    catch (InvocationTargetException paramString)
    {
      if ((paramString.getCause() instanceof RuntimeException)) {
        throw ((RuntimeException)paramString.getCause());
      }
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", paramString);
    }
  }
  
  private Exception a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      break;
    case -8: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown exception code: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" msg ");
      localStringBuilder.append(paramString);
      return new RuntimeException(localStringBuilder.toString());
    case -1: 
      return new SecurityException(paramString);
    case -2: 
      return new BadParcelableException(paramString);
    case -3: 
      return new IllegalArgumentException(paramString);
    case -4: 
      return new NullPointerException(paramString);
    case -5: 
      return new IllegalStateException(paramString);
    case -6: 
      return new NetworkOnMainThreadException();
    case -7: 
      return new UnsupportedOperationException(paramString);
    }
    return (Exception)get();
  }
  
  private Collection a(int paramInt, Collection paramCollection)
  {
    int i = size();
    paramInt = i;
    if (i < 0) {
      return null;
    }
    if (i != 0)
    {
      int j = size();
      if (i < 0) {
        return null;
      }
      i = paramInt;
      if (j != 1)
      {
        i = paramInt;
        if (j != 2)
        {
          i = paramInt;
          if (j != 3)
          {
            i = paramInt;
            if (j != 4)
            {
              if (j != 5) {
                return paramCollection;
              }
              while (paramInt > 0)
              {
                paramCollection.add(s());
                paramInt -= 1;
              }
            }
            while (i > 0)
            {
              paramCollection.add(getValue());
              i -= 1;
            }
          }
          while (i > 0)
          {
            paramCollection.add(read());
            i -= 1;
          }
        }
        while (i > 0)
        {
          paramCollection.add(get());
          i -= 1;
        }
      }
      while (i > 0)
      {
        paramCollection.add(d());
        i -= 1;
      }
    }
    return paramCollection;
  }
  
  private void a(h paramH)
  {
    try
    {
      Class localClass = get(paramH.getClass());
      a(localClass.getName());
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramH.getClass().getSimpleName());
      localStringBuilder.append(" does not have a Parcelizer");
      throw new RuntimeException(localStringBuilder.toString(), localClassNotFoundException);
    }
  }
  
  public static void a(h paramH, ByteVector paramByteVector)
  {
    try
    {
      Object localObject = get(paramH.getClass());
      Class localClass = paramH.getClass();
      localObject = ((Class)localObject).getDeclaredMethod("write", new Class[] { localClass, g.class });
      ((Method)localObject).invoke(null, new Object[] { paramH, paramByteVector });
      return;
    }
    catch (ClassNotFoundException paramH) {}catch (NoSuchMethodException paramH)
    {
      break label79;
    }
    catch (InvocationTargetException paramH)
    {
      break label90;
    }
    catch (IllegalAccessException paramH) {}
    throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", paramH);
    label79:
    throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", paramH);
    label90:
    if ((paramH.getCause() instanceof RuntimeException)) {
      throw ((RuntimeException)paramH.getCause());
    }
    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", paramH);
    throw new RuntimeException("VersionedParcel encountered IllegalAccessException", paramH);
  }
  
  private void a(Collection paramCollection, int paramInt)
  {
    e(paramInt);
    if (paramCollection == null)
    {
      add(-1);
      return;
    }
    paramInt = paramCollection.size();
    add(paramInt);
    if (paramInt > 0)
    {
      paramInt = write(paramCollection.iterator().next());
      add(paramInt);
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return;
              }
              paramCollection = paramCollection.iterator();
              while (paramCollection.hasNext()) {
                a((IBinder)paramCollection.next());
              }
            }
            paramCollection = paramCollection.iterator();
            while (paramCollection.hasNext()) {
              a((String)paramCollection.next());
            }
          }
          paramCollection = paramCollection.iterator();
          while (paramCollection.hasNext()) {
            write((Serializable)paramCollection.next());
          }
        }
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
          a((Parcelable)paramCollection.next());
        }
      }
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        b((h)paramCollection.next());
      }
    }
  }
  
  private Exception add(int paramInt, String paramString)
  {
    return a(paramInt, paramString);
  }
  
  public static Class get(Class paramClass)
    throws ClassNotFoundException
  {
    return Class.forName(String.format("%s.%sParcelizer", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() }), false, paramClass.getClassLoader());
  }
  
  public static Throwable getRootCause(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    return paramThrowable;
  }
  
  private int length()
  {
    return size();
  }
  
  public static Class read(h paramH)
    throws ClassNotFoundException
  {
    return get(paramH.getClass());
  }
  
  private int write(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return 4;
    }
    if ((paramObject instanceof Parcelable)) {
      return 2;
    }
    if ((paramObject instanceof h)) {
      return 1;
    }
    if ((paramObject instanceof Serializable)) {
      return 3;
    }
    if ((paramObject instanceof IBinder)) {
      return 5;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.getClass().getName());
    localStringBuilder.append(" cannot be VersionedParcelled");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void write(Serializable paramSerializable)
  {
    if (paramSerializable == null)
    {
      a(null);
      return;
    }
    String str = paramSerializable.getClass().getName();
    a(str);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramSerializable);
      localObjectOutputStream.close();
      a(localByteArrayOutputStream.toByteArray());
      return;
    }
    catch (IOException paramSerializable)
    {
      throw new RuntimeException(f.sufficientlysecure.rootcommands.util.StringBuilder.append("VersionedParcelable encountered IOException writing serializable object (name = ", str, ")"), paramSerializable);
    }
  }
  
  public double a(double paramDouble, int paramInt)
  {
    if (!a(paramInt)) {
      return paramDouble;
    }
    return clear();
  }
  
  public float a(float paramFloat, int paramInt)
  {
    if (!a(paramInt)) {
      return paramFloat;
    }
    return close();
  }
  
  public IBinder a(IBinder paramIBinder, int paramInt)
  {
    if (!a(paramInt)) {
      return paramIBinder;
    }
    return s();
  }
  
  public Size a(Size paramSize, int paramInt)
  {
    if (!a(paramInt)) {
      return paramSize;
    }
    if (a()) {
      return new Size(size(), size());
    }
    return null;
  }
  
  public SizeF a(SizeF paramSizeF, int paramInt)
  {
    if (!a(paramInt)) {
      return paramSizeF;
    }
    if (a()) {
      return new SizeF(close(), close());
    }
    return null;
  }
  
  public SparseBooleanArray a(SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    if (!a(paramInt)) {
      return paramSparseBooleanArray;
    }
    int i = size();
    if (i < 0) {
      return null;
    }
    paramSparseBooleanArray = new SparseBooleanArray(i);
    paramInt = 0;
    while (paramInt < i)
    {
      paramSparseBooleanArray.put(size(), a());
      paramInt += 1;
    }
    return paramSparseBooleanArray;
  }
  
  public h a(h paramH, int paramInt)
  {
    if (!a(paramInt)) {
      return paramH;
    }
    return d();
  }
  
  public abstract void a(double paramDouble);
  
  public abstract void a(float paramFloat);
  
  public abstract void a(long paramLong);
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void a(IBinder paramIBinder);
  
  public abstract void a(IInterface paramIInterface);
  
  public abstract void a(Parcelable paramParcelable);
  
  public abstract void a(String paramString);
  
  public void a(String paramString, int paramInt)
  {
    e(paramInt);
    a(paramString);
  }
  
  public void a(List paramList, int paramInt)
  {
    a(paramList, paramInt);
  }
  
  public abstract void a(boolean paramBoolean);
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public abstract void a(byte[] paramArrayOfByte);
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    e(paramInt);
    a(paramArrayOfByte);
  }
  
  public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void a(char[] paramArrayOfChar, int paramInt)
  {
    e(paramInt);
    if (paramArrayOfChar != null)
    {
      int i = paramArrayOfChar.length;
      add(i);
      paramInt = 0;
      while (paramInt < i)
      {
        add(paramArrayOfChar[paramInt]);
        paramInt += 1;
      }
    }
    add(-1);
  }
  
  public void a(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble != null)
    {
      int j = paramArrayOfDouble.length;
      add(j);
      int i = 0;
      while (i < j)
      {
        a(paramArrayOfDouble[i]);
        i += 1;
      }
    }
    add(-1);
  }
  
  public void a(Object[] paramArrayOfObject, int paramInt)
  {
    e(paramInt);
    write(paramArrayOfObject);
  }
  
  public void a(boolean[] paramArrayOfBoolean, int paramInt)
  {
    e(paramInt);
    add(paramArrayOfBoolean);
  }
  
  public abstract boolean a();
  
  public abstract boolean a(int paramInt);
  
  public Object[] a(Object[] paramArrayOfObject)
  {
    int j = size();
    int i = j;
    if (j < 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(j);
    if (j != 0)
    {
      int k = size();
      if (j < 0) {
        return null;
      }
      j = i;
      if (k != 1)
      {
        j = i;
        if (k != 2)
        {
          j = i;
          if (k != 3)
          {
            j = i;
            if (k != 4)
            {
              if (k == 5) {
                while (i > 0)
                {
                  localArrayList.add(s());
                  i -= 1;
                }
              }
            }
            else {
              while (j > 0)
              {
                localArrayList.add(getValue());
                j -= 1;
              }
            }
          }
          else
          {
            while (j > 0)
            {
              localArrayList.add(read());
              j -= 1;
            }
          }
        }
        else
        {
          while (j > 0)
          {
            localArrayList.add(get());
            j -= 1;
          }
        }
      }
      else
      {
        while (j > 0)
        {
          localArrayList.add(d());
          j -= 1;
        }
      }
    }
    return localArrayList.toArray(paramArrayOfObject);
  }
  
  public int add(int paramInt1, int paramInt2)
  {
    if (!a(paramInt2)) {
      return paramInt1;
    }
    return size();
  }
  
  public long add(long paramLong, int paramInt)
  {
    if (!a(paramInt)) {
      return paramLong;
    }
    return position();
  }
  
  public abstract Bundle add();
  
  public Bundle add(Bundle paramBundle, int paramInt)
  {
    if (!a(paramInt)) {
      return paramBundle;
    }
    return add();
  }
  
  public Parcelable add(Parcelable paramParcelable, int paramInt)
  {
    if (!a(paramInt)) {
      return paramParcelable;
    }
    return get();
  }
  
  public Exception add(Exception paramException, int paramInt)
  {
    if (!a(paramInt)) {
      return paramException;
    }
    paramInt = size();
    if (paramInt != 0) {
      paramException = a(paramInt, getValue());
    }
    return paramException;
  }
  
  public List add(List paramList, int paramInt)
  {
    if (!a(paramInt)) {
      return paramList;
    }
    return (List)a(paramInt, new ArrayList());
  }
  
  public Set add(Set paramSet, int paramInt)
  {
    if (!a(paramInt)) {
      return paramSet;
    }
    return (Set)a(paramInt, new NodeList(0));
  }
  
  public void add(byte paramByte, int paramInt)
  {
    e(paramInt);
    add(paramByte);
  }
  
  public void add(double paramDouble, int paramInt)
  {
    e(paramInt);
    a(paramDouble);
  }
  
  public abstract void add(int paramInt);
  
  public void add(Size paramSize, int paramInt)
  {
    e(paramInt);
    boolean bool;
    if (paramSize != null) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
    if (paramSize != null)
    {
      add(paramSize.getWidth());
      add(paramSize.getHeight());
    }
  }
  
  public void add(SizeF paramSizeF, int paramInt)
  {
    e(paramInt);
    boolean bool;
    if (paramSizeF != null) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
    if (paramSizeF != null)
    {
      a(paramSizeF.getWidth());
      a(paramSizeF.getHeight());
    }
  }
  
  public void add(Serializable paramSerializable, int paramInt)
  {
    e(paramInt);
    write(paramSerializable);
  }
  
  public void add(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      int j = paramArrayOfInt.length;
      add(j);
      int i = 0;
      while (i < j)
      {
        add(paramArrayOfInt[i]);
        i += 1;
      }
    }
    add(-1);
  }
  
  public void add(int[] paramArrayOfInt, int paramInt)
  {
    e(paramInt);
    add(paramArrayOfInt);
  }
  
  public void add(boolean[] paramArrayOfBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:553)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public boolean add(boolean paramBoolean, int paramInt)
  {
    if (!a(paramInt)) {
      return paramBoolean;
    }
    return a();
  }
  
  public char[] add(char[] paramArrayOfChar, int paramInt)
  {
    if (!a(paramInt)) {
      return paramArrayOfChar;
    }
    int i = size();
    if (i < 0) {
      return null;
    }
    paramArrayOfChar = new char[i];
    paramInt = 0;
    while (paramInt < i)
    {
      paramArrayOfChar[paramInt] = ((char)size());
      paramInt += 1;
    }
    return paramArrayOfChar;
  }
  
  public double[] add(double[] paramArrayOfDouble, int paramInt)
  {
    if (!a(paramInt)) {
      return paramArrayOfDouble;
    }
    return getContent();
  }
  
  public float[] add(float[] paramArrayOfFloat, int paramInt)
  {
    if (!a(paramInt)) {
      return paramArrayOfFloat;
    }
    return copy();
  }
  
  public long[] add(long[] paramArrayOfLong, int paramInt)
  {
    if (!a(paramInt)) {
      return paramArrayOfLong;
    }
    return put();
  }
  
  public Object[] add(Object[] paramArrayOfObject, int paramInt)
  {
    if (!a(paramInt)) {
      return paramArrayOfObject;
    }
    return a(paramArrayOfObject);
  }
  
  public boolean[] add(boolean[] paramArrayOfBoolean, int paramInt)
  {
    if (!a(paramInt)) {
      return paramArrayOfBoolean;
    }
    return remove();
  }
  
  public abstract ByteVector b();
  
  public void b(float paramFloat, int paramInt)
  {
    e(paramInt);
    a(paramFloat);
  }
  
  public void b(long paramLong, int paramInt)
  {
    e(paramInt);
    a(paramLong);
  }
  
  public void b(Bundle paramBundle, int paramInt)
  {
    e(paramInt);
    a(paramBundle);
  }
  
  public void b(IInterface paramIInterface, int paramInt)
  {
    e(paramInt);
    a(paramIInterface);
  }
  
  public void b(h paramH)
  {
    if (paramH == null)
    {
      a(null);
      return;
    }
    a(paramH);
    ByteVector localByteVector = b();
    a(paramH, localByteVector);
    localByteVector.c();
  }
  
  public void b(h paramH, int paramInt)
  {
    e(paramInt);
    b(paramH);
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    e(paramInt);
    a(paramBoolean);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    e(paramInt3);
    a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public abstract void c();
  
  public abstract double clear();
  
  public abstract float close();
  
  public float[] copy()
  {
    int j = size();
    if (j < 0) {
      return null;
    }
    float[] arrayOfFloat = new float[j];
    int i = 0;
    while (i < j)
    {
      arrayOfFloat[i] = close();
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public h d()
  {
    String str = getValue();
    if (str == null) {
      return null;
    }
    return a(str, b());
  }
  
  public void doIt(SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    e(paramInt);
    if (paramSparseBooleanArray == null)
    {
      add(-1);
      return;
    }
    int i = paramSparseBooleanArray.size();
    add(i);
    paramInt = 0;
    while (paramInt < i)
    {
      add(paramSparseBooleanArray.keyAt(paramInt));
      a(paramSparseBooleanArray.valueAt(paramInt));
      paramInt += 1;
    }
  }
  
  public abstract void e(int paramInt);
  
  public abstract Parcelable get();
  
  public String get(String paramString, int paramInt)
  {
    if (!a(paramInt)) {
      return paramString;
    }
    return getValue();
  }
  
  public int[] get(int[] paramArrayOfInt, int paramInt)
  {
    if (!a(paramInt)) {
      return paramArrayOfInt;
    }
    return getChecked();
  }
  
  public int[] getChecked()
  {
    int j = size();
    if (j < 0) {
      return null;
    }
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = size();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public double[] getContent()
  {
    int j = size();
    if (j < 0) {
      return null;
    }
    double[] arrayOfDouble = new double[j];
    int i = 0;
    while (i < j)
    {
      arrayOfDouble[i] = clear();
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public abstract String getValue();
  
  public abstract long position();
  
  public boolean processBytes()
  {
    return false;
  }
  
  public void put(int paramInt1, int paramInt2)
  {
    e(paramInt2);
    add(paramInt1);
  }
  
  public void put(Parcelable paramParcelable, int paramInt)
  {
    e(paramInt);
    a(paramParcelable);
  }
  
  public long[] put()
  {
    int j = size();
    if (j < 0) {
      return null;
    }
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = position();
      i += 1;
    }
    return arrayOfLong;
  }
  
  public Serializable read()
  {
    String str = getValue();
    if (str == null) {
      return null;
    }
    Object localObject = new ByteArrayInputStream(readString());
    try
    {
      localObject = new Type(this, (InputStream)localObject).readObject();
      return (Serializable)localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException(f.sufficientlysecure.rootcommands.util.StringBuilder.append("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = ", str, ")"), localClassNotFoundException);
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(f.sufficientlysecure.rootcommands.util.StringBuilder.append("VersionedParcelable encountered IOException reading a Serializable object (name = ", str, ")"), localIOException);
    }
  }
  
  public abstract byte[] readString();
  
  public boolean[] remove()
  {
    int j = size();
    if (j < 0) {
      return null;
    }
    boolean[] arrayOfBoolean = new boolean[j];
    int i = 0;
    while (i < j)
    {
      int k;
      if (size() != 0) {
        k = 1;
      } else {
        k = 0;
      }
      arrayOfBoolean[i] = k;
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  public abstract IBinder s();
  
  public abstract int size();
  
  public byte write(byte paramByte, int paramInt)
  {
    if (!a(paramInt)) {
      return paramByte;
    }
    return (byte)(size() & 0xFF);
  }
  
  public void write()
  {
    add(0);
  }
  
  public void write(IBinder paramIBinder, int paramInt)
  {
    e(paramInt);
    a(paramIBinder);
  }
  
  public void write(Exception paramException, int paramInt)
  {
    e(paramInt);
    if (paramException == null)
    {
      write();
      return;
    }
    paramInt = 0;
    if (((paramException instanceof Parcelable)) && (paramException.getClass().getClassLoader() == Parcelable.class.getClassLoader())) {
      paramInt = -9;
    } else if ((paramException instanceof SecurityException)) {
      paramInt = -1;
    } else if ((paramException instanceof BadParcelableException)) {
      paramInt = -2;
    } else if ((paramException instanceof IllegalArgumentException)) {
      paramInt = -3;
    } else if ((paramException instanceof NullPointerException)) {
      paramInt = -4;
    } else if ((paramException instanceof IllegalStateException)) {
      paramInt = -5;
    } else if ((paramException instanceof NetworkOnMainThreadException)) {
      paramInt = -6;
    } else if ((paramException instanceof UnsupportedOperationException)) {
      paramInt = -7;
    }
    add(paramInt);
    if (paramInt == 0)
    {
      if ((paramException instanceof RuntimeException)) {
        throw ((RuntimeException)paramException);
      }
      throw new RuntimeException(paramException);
    }
    a(paramException.getMessage());
    if (paramInt != -9) {
      return;
    }
    a((Parcelable)paramException);
  }
  
  public void write(Set paramSet, int paramInt)
  {
    a(paramSet, paramInt);
  }
  
  public void write(double[] paramArrayOfDouble, int paramInt)
  {
    e(paramInt);
    a(paramArrayOfDouble);
  }
  
  public void write(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      int j = paramArrayOfFloat.length;
      add(j);
      int i = 0;
      while (i < j)
      {
        a(paramArrayOfFloat[i]);
        i += 1;
      }
    }
    add(-1);
  }
  
  public void write(float[] paramArrayOfFloat, int paramInt)
  {
    e(paramInt);
    write(paramArrayOfFloat);
  }
  
  public void write(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null)
    {
      int j = paramArrayOfLong.length;
      add(j);
      int i = 0;
      while (i < j)
      {
        a(paramArrayOfLong[i]);
        i += 1;
      }
    }
    add(-1);
  }
  
  public void write(long[] paramArrayOfLong, int paramInt)
  {
    e(paramInt);
    write(paramArrayOfLong);
  }
  
  public void write(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
    {
      add(-1);
      return;
    }
    int i2 = paramArrayOfObject.length;
    add(i2);
    if (i2 > 0)
    {
      int k = 0;
      int m = 0;
      int i1 = 0;
      int i = 0;
      int j = 0;
      int i3 = write(paramArrayOfObject[0]);
      add(i3);
      if (i3 != 1)
      {
        i = i1;
        if (i3 != 2)
        {
          i = m;
          if (i3 != 3)
          {
            i = k;
            if (i3 != 4)
            {
              i = j;
              if (i3 != 5) {
                return;
              }
              while (i < i2)
              {
                a((IBinder)paramArrayOfObject[i]);
                i += 1;
              }
            }
            while (i < i2)
            {
              a((String)paramArrayOfObject[i]);
              i += 1;
            }
          }
          while (i < i2)
          {
            write((Serializable)paramArrayOfObject[i]);
            i += 1;
          }
        }
        while (i < i2)
        {
          a((Parcelable)paramArrayOfObject[i]);
          i += 1;
        }
      }
      while (i < i2)
      {
        b((h)paramArrayOfObject[i]);
        i += 1;
      }
    }
  }
  
  public byte[] write(byte[] paramArrayOfByte, int paramInt)
  {
    if (!a(paramInt)) {
      return paramArrayOfByte;
    }
    return readString();
  }
}
