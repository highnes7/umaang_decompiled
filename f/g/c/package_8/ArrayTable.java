package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.d.Ab;
import f.g.c.d.G;
import f.g.c.d.G.a;
import f.g.c.d.Yg;
import f.g.c.d.fe.h;
import f.g.c.d.vb;
import f.g.c.package_10.Objects;
import f.g.c.package_10.Preconditions;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@a
public final class ArrayTable<R, C, V>
  implements Yg<R, C, V>, Serializable
{
  public static final long serialVersionUID = 0L;
  public final V[][] array;
  public transient G<R, C, V>.b cellSet;
  public final Ab<C, Integer> columnKeyToIndex;
  public final vb<C> columnList;
  public transient G<R, C, V>.d columnMap;
  public final Ab<R, Integer> rowKeyToIndex;
  public final vb<R> rowList;
  public transient G<R, C, V>.f rowMap;
  public transient Collection<V> values;
  
  public ArrayTable(ArrayTable paramArrayTable)
  {
    rowList = rowList;
    columnList = columnList;
    rowKeyToIndex = rowKeyToIndex;
    columnKeyToIndex = columnKeyToIndex;
    int i = rowList.size();
    Object localObject1 = columnList;
    ArrayTable localArrayTable = this;
    localObject1 = (Object[][])Array.newInstance(Object.class, new int[] { i, ((Collection)localObject1).size() });
    array = ((Object[][])localObject1);
    i = 0;
    for (;;)
    {
      Object localObject2 = rowList;
      if (i >= ((Collection)localObject2).size()) {
        break;
      }
      localObject2 = array;
      System.arraycopy(localObject2[i], 0, localObject1[i], 0, localObject2[i].length);
      i += 1;
    }
  }
  
  public ArrayTable(Table paramTable)
  {
    this(paramTable.rowKeySet(), paramTable.columnKeySet());
    putAll(paramTable);
  }
  
  public ArrayTable(Iterable paramIterable1, Iterable paramIterable2)
  {
    rowList = ImmutableList.copyOf(paramIterable1);
    columnList = ImmutableList.copyOf(paramIterable2);
    boolean bool1 = rowList.isEmpty();
    boolean bool2 = true;
    if (!bool1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (!columnList.isEmpty()) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    rowKeyToIndex = index(rowList);
    columnKeyToIndex = index(columnList);
    array = ((Object[][])Array.newInstance(Object.class, new int[] { rowList.size(), columnList.size() }));
  }
  
  public static ArrayTable create(ArrayTable paramArrayTable)
  {
    return new ArrayTable(paramArrayTable);
  }
  
  public static ArrayTable create(Table paramTable)
  {
    return new ArrayTable(paramTable);
  }
  
  public static ArrayTable create(Iterable paramIterable1, Iterable paramIterable2)
  {
    return new ArrayTable(paramIterable1, paramIterable2);
  }
  
  public static ImmutableMap index(List paramList)
  {
    Ab.a localA = ImmutableMap.builder();
    int i = 0;
    while (i < paramList.size())
    {
      localA.put(paramList.get(i), Integer.valueOf(i));
      i += 1;
    }
    return localA.build();
  }
  
  public Object at(int paramInt1, int paramInt2)
  {
    return array[paramInt1][paramInt2];
  }
  
  public Set cellSet()
  {
    CellSet localCellSet2 = cellSet;
    CellSet localCellSet1 = localCellSet2;
    if (localCellSet2 == null)
    {
      localCellSet1 = new CellSet(null);
      cellSet = localCellSet1;
    }
    return localCellSet1;
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public Map column(Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = (Integer)columnKeyToIndex.get(paramObject);
      if (paramObject == null) {
        return ImmutableMap.of();
      }
      return new Column(paramObject.intValue());
    }
    throw new NullPointerException();
  }
  
  public ImmutableList columnKeyList()
  {
    return columnList;
  }
  
  public ImmutableSet columnKeySet()
  {
    return columnKeyToIndex.keySet();
  }
  
  public Map columnMap()
  {
    ColumnMap localColumnMap2 = columnMap;
    ColumnMap localColumnMap1 = localColumnMap2;
    if (localColumnMap2 == null)
    {
      localColumnMap1 = new ColumnMap(null);
      columnMap = localColumnMap1;
    }
    return localColumnMap1;
  }
  
  public boolean contains(Object paramObject1, Object paramObject2)
  {
    return (containsRow(paramObject1)) && (containsColumn(paramObject2));
  }
  
  public boolean containsColumn(Object paramObject)
  {
    return columnKeyToIndex.containsKey(paramObject);
  }
  
  public boolean containsRow(Object paramObject)
  {
    return rowKeyToIndex.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    Object[][] arrayOfObject = array;
    int k = arrayOfObject.length;
    int i = 0;
    while (i < k)
    {
      Object[] arrayOfObject1 = arrayOfObject[i];
      int m = arrayOfObject1.length;
      int j = 0;
      while (j < m)
      {
        if (Objects.equal(paramObject, arrayOfObject1[j])) {
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Table))
    {
      paramObject = (Table)paramObject;
      return cellSet().equals(paramObject.cellSet());
    }
    return false;
  }
  
  public Object erase(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (Integer)rowKeyToIndex.get(paramObject1);
    paramObject2 = (Integer)columnKeyToIndex.get(paramObject2);
    if (paramObject1 != null)
    {
      if (paramObject2 == null) {
        return null;
      }
      return set(paramObject1.intValue(), paramObject2.intValue(), null);
    }
    return null;
  }
  
  public void eraseAll()
  {
    Object[][] arrayOfObject = array;
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Arrays.fill(arrayOfObject[i], null);
      i += 1;
    }
  }
  
  public Object get(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (Integer)rowKeyToIndex.get(paramObject1);
    paramObject2 = (Integer)columnKeyToIndex.get(paramObject2);
    if ((paramObject1 != null) && (paramObject2 != null)) {
      return array[paramObject1.intValue()][paramObject2.intValue()];
    }
    return null;
  }
  
  public int hashCode()
  {
    return cellSet().hashCode();
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public Object put(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 != null)
      {
        Integer localInteger = (Integer)rowKeyToIndex.get(paramObject1);
        boolean bool;
        if (localInteger != null) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkArgument(bool, "Row %s not in %s", new Object[] { paramObject1, rowList });
        paramObject1 = (Integer)columnKeyToIndex.get(paramObject2);
        if (paramObject1 != null) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkArgument(bool, "Column %s not in %s", new Object[] { paramObject2, columnList });
        return set(localInteger.intValue(), paramObject1.intValue(), paramObject3);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public void putAll(Table paramTable)
  {
    paramTable = paramTable.cellSet().iterator();
    while (paramTable.hasNext())
    {
      Yg.a localA = (Yg.a)paramTable.next();
      put(localA.getRowKey(), localA.getColumnKey(), localA.getValue());
    }
  }
  
  public Object remove(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException();
  }
  
  public Map row(Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = (Integer)rowKeyToIndex.get(paramObject);
      if (paramObject == null) {
        return ImmutableMap.of();
      }
      return new Row(paramObject.intValue());
    }
    throw new NullPointerException();
  }
  
  public ImmutableList rowKeyList()
  {
    return rowList;
  }
  
  public ImmutableSet rowKeySet()
  {
    return rowKeyToIndex.keySet();
  }
  
  public Map rowMap()
  {
    RowMap localRowMap2 = rowMap;
    RowMap localRowMap1 = localRowMap2;
    if (localRowMap2 == null)
    {
      localRowMap1 = new RowMap(null);
      rowMap = localRowMap1;
    }
    return localRowMap1;
  }
  
  public Object set(int paramInt1, int paramInt2, Object paramObject)
  {
    Object[][] arrayOfObject = array;
    Object localObject = arrayOfObject[paramInt1][paramInt2];
    arrayOfObject[paramInt1][paramInt2] = paramObject;
    return localObject;
  }
  
  public int size()
  {
    int i = rowList.size();
    return columnList.size() * i;
  }
  
  public Object[][] toArray(Class paramClass)
  {
    paramClass = (Object[][])Array.newInstance(paramClass, new int[] { rowList.size(), columnList.size() });
    int i = 0;
    while (i < rowList.size())
    {
      Object[][] arrayOfObject = array;
      System.arraycopy(arrayOfObject[i], 0, paramClass[i], 0, arrayOfObject[i].length);
      i += 1;
    }
    return paramClass;
  }
  
  public String toString()
  {
    return rowMap().toString();
  }
  
  public Collection values()
  {
    Object localObject = values;
    if (localObject == null)
    {
      localObject = new Values(null);
      values = ((Collection)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public abstract class ArrayMap<K, V>
    extends fe.h<K, V>
  {
    public ArrayMap() {}
    
    public void clear()
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean containsKey(Object paramObject)
    {
      return ArrayTable.this.containsKey(paramObject);
    }
    
    public Set createEntrySet()
    {
      return new Maps.TransformedEntriesMap.1(this);
    }
    
    public Object get(Object paramObject)
    {
      paramObject = (Integer)ArrayTable.this.get(paramObject);
      if (paramObject == null) {
        return null;
      }
      return getValue(paramObject.intValue());
    }
    
    public Object getKey(int paramInt)
    {
      return keySet().asList().get(paramInt);
    }
    
    public abstract String getKeyRole();
    
    public abstract Object getValue(int paramInt);
    
    public boolean isEmpty()
    {
      return ArrayTable.this.isEmpty();
    }
    
    public Set keySet()
    {
      return keySet();
    }
    
    public Object put(Object paramObject1, Object paramObject2)
    {
      Integer localInteger = (Integer)ArrayTable.this.get(paramObject1);
      if (localInteger != null) {
        return setValue(localInteger.intValue(), paramObject2);
      }
      paramObject2 = new StringBuilder();
      paramObject2.append(getKeyRole());
      paramObject2.append(" ");
      paramObject2.append(paramObject1);
      paramObject2.append(" not in ");
      paramObject2.append(keySet());
      throw new IllegalArgumentException(paramObject2.toString());
    }
    
    public Object remove(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public abstract Object setValue(int paramInt, Object paramObject);
    
    public int size()
    {
      return ArrayTable.this.size();
    }
  }
  
  public class CellSet
    extends AbstractSet<f.g.c.d.Yg.a<R, C, V>>
  {
    public CellSet() {}
    
    public boolean contains(Object paramObject)
    {
      if ((paramObject instanceof Yg.a))
      {
        paramObject = (Yg.a)paramObject;
        Integer localInteger1 = (Integer)rowKeyToIndex.get(paramObject.getRowKey());
        Integer localInteger2 = (Integer)columnKeyToIndex.get(paramObject.getColumnKey());
        if ((localInteger1 != null) && (localInteger2 != null) && (Objects.equal(array[localInteger1.intValue()][localInteger2.intValue()], paramObject.getValue()))) {
          return true;
        }
      }
      return false;
    }
    
    public Iterator iterator()
    {
      return new ArrayTable.1(this, size());
    }
    
    public int size()
    {
      return ArrayTable.this.size();
    }
  }
  
  public class Column
    extends G.a<R, V>
  {
    public final int columnIndex;
    
    public Column(int paramInt)
    {
      super(null);
      columnIndex = paramInt;
    }
    
    public String getKeyRole()
    {
      return "Row";
    }
    
    public Object getValue(int paramInt)
    {
      return at(paramInt, columnIndex);
    }
    
    public Object setValue(int paramInt, Object paramObject)
    {
      return set(paramInt, columnIndex, paramObject);
    }
  }
  
  public class ColumnMap
    extends G.a<C, Map<R, V>>
  {
    public ColumnMap()
    {
      super(null);
    }
    
    public String getKeyRole()
    {
      return "Column";
    }
    
    public Map getValue(int paramInt)
    {
      return new ArrayTable.Column(ArrayTable.this, paramInt);
    }
    
    public Map put(Object paramObject, Map paramMap)
    {
      throw new UnsupportedOperationException();
    }
    
    public Map setValue(int paramInt, Map paramMap)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  public class Row
    extends G.a<C, V>
  {
    public final int rowIndex;
    
    public Row(int paramInt)
    {
      super(null);
      rowIndex = paramInt;
    }
    
    public String getKeyRole()
    {
      return "Column";
    }
    
    public Object getValue(int paramInt)
    {
      return at(rowIndex, paramInt);
    }
    
    public Object setValue(int paramInt, Object paramObject)
    {
      return set(rowIndex, paramInt, paramObject);
    }
  }
  
  public class RowMap
    extends G.a<R, Map<C, V>>
  {
    public RowMap()
    {
      super(null);
    }
    
    public String getKeyRole()
    {
      return "Row";
    }
    
    public Map getValue(int paramInt)
    {
      return new ArrayTable.Row(ArrayTable.this, paramInt);
    }
    
    public Map put(Object paramObject, Map paramMap)
    {
      throw new UnsupportedOperationException();
    }
    
    public Map setValue(int paramInt, Map paramMap)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  public class Values
    extends AbstractCollection<V>
  {
    public Values() {}
    
    public Iterator iterator()
    {
      return new Maps.FilteredEntryMap.EntrySet.1(this, cellSet().iterator());
    }
    
    public int size()
    {
      return ArrayTable.this.size();
    }
  }
}
