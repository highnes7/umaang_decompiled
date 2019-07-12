package support.android.v4.widget;

import b.b.a.N;
import b.b.x.n.r.a;
import b.b.x.n.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import support.android.v4.util.Pools.Pool;
import support.android.v4.util.Pools.SimplePool;
import support.android.v4.util.SimpleArrayMap;

@N({b.b.a.N.a.a})
public final class ByteVector<T>
{
  public final r.a<ArrayList<T>> a = new Pools.SimplePool(10);
  public final HashSet<T> mAdapter = new HashSet();
  public final ArrayList<T> mValues = new ArrayList();
  public final t<T, ArrayList<T>> this$0 = new SimpleArrayMap();
  
  public ByteVector() {}
  
  private void add(ArrayList paramArrayList)
  {
    paramArrayList.clear();
    a.release(paramArrayList);
  }
  
  private ArrayList get()
  {
    ArrayList localArrayList2 = (ArrayList)a.acquire();
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    return localArrayList1;
  }
  
  private void get(Object paramObject, ArrayList paramArrayList, HashSet paramHashSet)
  {
    if (paramArrayList.contains(paramObject)) {
      return;
    }
    if (!paramHashSet.contains(paramObject))
    {
      paramHashSet.add(paramObject);
      ArrayList localArrayList = (ArrayList)this$0.get(paramObject);
      if (localArrayList != null)
      {
        int i = 0;
        int j = localArrayList.size();
        while (i < j)
        {
          get(localArrayList.get(i), paramArrayList, paramHashSet);
          i += 1;
        }
      }
      paramHashSet.remove(paramObject);
      paramArrayList.add(paramObject);
      return;
    }
    paramObject = new RuntimeException("This graph contains cyclic dependencies");
    throw paramObject;
  }
  
  public void add()
  {
    int j = this$0.size();
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = (ArrayList)this$0.get(i);
      if (localArrayList != null) {
        add(localArrayList);
      }
      i += 1;
    }
    this$0.clear();
  }
  
  public void add(Object paramObject1, Object paramObject2)
  {
    if ((this$0.containsKey(paramObject1)) && (this$0.containsKey(paramObject2)))
    {
      ArrayList localArrayList2 = (ArrayList)this$0.get(paramObject1);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList2 = get();
        localArrayList1 = localArrayList2;
        this$0.put(paramObject1, localArrayList2);
      }
      localArrayList1.add(paramObject2);
      return;
    }
    throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
  }
  
  public boolean add(Object paramObject)
  {
    return this$0.containsKey(paramObject);
  }
  
  public boolean get(Object paramObject)
  {
    int j = this$0.size();
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = (ArrayList)this$0.get(i);
      if ((localArrayList != null) && (localArrayList.contains(paramObject))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public ArrayList getSelectedItems()
  {
    mValues.clear();
    mAdapter.clear();
    int j = this$0.size();
    int i = 0;
    while (i < j)
    {
      get(this$0.keyAt(i), mValues, mAdapter);
      i += 1;
    }
    return mValues;
  }
  
  public int getSize()
  {
    return this$0.size();
  }
  
  public List process(Object paramObject)
  {
    int j = this$0.size();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = (ArrayList)this$0.get(i);
      Object localObject2 = localObject1;
      if (localArrayList != null)
      {
        localObject2 = localObject1;
        if (localArrayList.contains(paramObject))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(this$0.keyAt(i));
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void put(Object paramObject)
  {
    if (!this$0.containsKey(paramObject)) {
      this$0.put(paramObject, null);
    }
  }
  
  public List read(Object paramObject)
  {
    return (List)this$0.get(paramObject);
  }
}
