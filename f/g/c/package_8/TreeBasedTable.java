package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.d.Gg;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

@a
@b(serializable=true)
public class TreeBasedTable<R, C, V>
  extends Gg<R, C, V>
{
  public static final long serialVersionUID = 0L;
  public final Comparator<? super C> columnComparator;
  
  public TreeBasedTable(Comparator paramComparator1, Comparator paramComparator2)
  {
    super(new TreeMap(paramComparator1), new kh.a(paramComparator2));
    columnComparator = paramComparator2;
  }
  
  public static TreeBasedTable create()
  {
    return new TreeBasedTable(Ordering.natural(), Ordering.natural());
  }
  
  public static TreeBasedTable create(TreeBasedTable paramTreeBasedTable)
  {
    TreeBasedTable localTreeBasedTable = new TreeBasedTable(paramTreeBasedTable.rowComparator(), paramTreeBasedTable.columnComparator());
    localTreeBasedTable.putAll(paramTreeBasedTable);
    return localTreeBasedTable;
  }
  
  public static TreeBasedTable create(Comparator paramComparator1, Comparator paramComparator2)
  {
    if (paramComparator1 != null)
    {
      if (paramComparator2 != null) {
        return new TreeBasedTable(paramComparator1, paramComparator2);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public void clear()
  {
    backingMap.clear();
  }
  
  public Map column(Object paramObject)
  {
    return new Ig.c(this, paramObject);
  }
  
  public Comparator columnComparator()
  {
    return columnComparator;
  }
  
  public boolean contains(Object paramObject1, Object paramObject2)
  {
    return super.contains(paramObject1, paramObject2);
  }
  
  public boolean containsColumn(Object paramObject)
  {
    return super.containsColumn(paramObject);
  }
  
  public boolean containsRow(Object paramObject)
  {
    return super.containsRow(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return super.containsValue(paramObject);
  }
  
  public Iterator createColumnKeyIterator()
  {
    Comparator localComparator = columnComparator();
    return new TreeBasedTable.2(this, Iterators.mergeSorted(Iterables.transform(backingMap.values(), new TreeBasedTable.1(this)), localComparator), localComparator);
  }
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public Object get(Object paramObject1, Object paramObject2)
  {
    return super.get(paramObject1, paramObject2);
  }
  
  public Object remove(Object paramObject1, Object paramObject2)
  {
    return super.remove(paramObject1, paramObject2);
  }
  
  public SortedMap row(Object paramObject)
  {
    return new kh.b(this, paramObject, null, null);
  }
  
  public Comparator rowComparator()
  {
    return rowKeySet().comparator();
  }
  
  public SortedSet rowKeySet()
  {
    return super.rowKeySet();
  }
  
  public SortedMap rowMap()
  {
    return super.rowMap();
  }
}
