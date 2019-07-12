package f.g.c.package_8;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Serialization
{
  public Serialization() {}
  
  public static ag.a getFieldSetter(Class paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass = new ag.a(paramClass, null);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      throw new AssertionError(paramClass);
    }
  }
  
  public static void populateMap(Map paramMap, ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    populateMap(paramMap, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  public static void populateMap(Map paramMap, ObjectInputStream paramObjectInputStream, int paramInt)
    throws IOException, ClassNotFoundException
  {
    int i = 0;
    while (i < paramInt)
    {
      paramMap.put(paramObjectInputStream.readObject(), paramObjectInputStream.readObject());
      i += 1;
    }
  }
  
  public static void populateMultimap(Multimap paramMultimap, ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    populateMultimap(paramMultimap, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  public static void populateMultimap(Multimap paramMultimap, ObjectInputStream paramObjectInputStream, int paramInt)
    throws IOException, ClassNotFoundException
  {
    int i = 0;
    while (i < paramInt)
    {
      Collection localCollection = paramMultimap.get(paramObjectInputStream.readObject());
      int k = paramObjectInputStream.readInt();
      int j = 0;
      while (j < k)
      {
        localCollection.add(paramObjectInputStream.readObject());
        j += 1;
      }
      i += 1;
    }
  }
  
  public static void populateMultiset(Multiset paramMultiset, ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    populateMultiset(paramMultiset, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  public static void populateMultiset(Multiset paramMultiset, ObjectInputStream paramObjectInputStream, int paramInt)
    throws IOException, ClassNotFoundException
  {
    int i = 0;
    while (i < paramInt)
    {
      paramMultiset.add(paramObjectInputStream.readObject(), paramObjectInputStream.readInt());
      i += 1;
    }
  }
  
  public static int readCount(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    return paramObjectInputStream.readInt();
  }
  
  public static void writeMap(Map paramMap, ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
  }
  
  public static void writeMultimap(Multimap paramMultimap, ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(paramMultimap.asMap().size());
    paramMultimap = paramMultimap.asMap().entrySet().iterator();
    while (paramMultimap.hasNext())
    {
      Object localObject = (Map.Entry)paramMultimap.next();
      paramObjectOutputStream.writeObject(((Map.Entry)localObject).getKey());
      paramObjectOutputStream.writeInt(((Collection)((Map.Entry)localObject).getValue()).size());
      localObject = ((Collection)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramObjectOutputStream.writeObject(((Iterator)localObject).next());
      }
    }
  }
  
  public static void writeMultiset(Multiset paramMultiset, ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(paramMultiset.entrySet().size());
    paramMultiset = paramMultiset.entrySet().iterator();
    while (paramMultiset.hasNext())
    {
      Ye.a localA = (Ye.a)paramMultiset.next();
      paramObjectOutputStream.writeObject(localA.getElement());
      paramObjectOutputStream.writeInt(localA.getCount());
    }
  }
}
