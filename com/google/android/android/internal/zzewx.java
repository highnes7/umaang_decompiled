package com.google.android.android.internal;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class zzewx<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
{
  public boolean zzkff;
  public final int zzoqi;
  public List<com.google.android.gms.internal.zzexc> zzoqj;
  public Map<K, V> zzoqk;
  public volatile com.google.android.gms.internal.zzexe zzoql;
  public Map<K, V> zzoqm;
  
  public zzewx(int paramInt)
  {
    zzoqi = paramInt;
    zzoqj = Collections.emptyList();
    zzoqk = Collections.emptyMap();
    zzoqm = Collections.emptyMap();
  }
  
  private final int binarySearch(Comparable paramComparable)
  {
    int j = zzoqj.size() - 1;
    if (j >= 0)
    {
      i = paramComparable.compareTo((Comparable)((zzexc)zzoqj.get(j)).getKey());
      if (i > 0) {
        return -(j + 2);
      }
      if (i == 0) {
        return j;
      }
    }
    int i = 0;
    while (i <= j)
    {
      int k = (i + j) / 2;
      int m = paramComparable.compareTo((Comparable)((zzexc)zzoqj.get(k)).getKey());
      if (m < 0) {
        j = k - 1;
      } else if (m > 0) {
        i = k + 1;
      } else {
        return k;
      }
    }
    return -(i + 1);
  }
  
  private final void zzcvg()
  {
    if (!zzkff) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  private final SortedMap zzcvh()
  {
    zzcvg();
    if ((zzoqk.isEmpty()) && (!(zzoqk instanceof TreeMap)))
    {
      zzoqk = new TreeMap();
      zzoqm = ((TreeMap)zzoqk).descendingMap();
    }
    return (SortedMap)zzoqk;
  }
  
  public static zzewx zzku(int paramInt)
  {
    return new zzewy(paramInt);
  }
  
  private final Object zzkw(int paramInt)
  {
    zzcvg();
    Object localObject = ((zzexc)zzoqj.remove(paramInt)).getValue();
    if (!zzoqk.isEmpty())
    {
      Iterator localIterator = zzcvh().entrySet().iterator();
      zzoqj.add(new zzexc(this, (Map.Entry)localIterator.next()));
      localIterator.remove();
    }
    return localObject;
  }
  
  public void clear()
  {
    zzcvg();
    if (!zzoqj.isEmpty()) {
      zzoqj.clear();
    }
    if (!zzoqk.isEmpty()) {
      zzoqk.clear();
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    return (binarySearch(paramObject) >= 0) || (zzoqk.containsKey(paramObject));
  }
  
  public Set entrySet()
  {
    if (zzoql == null) {
      zzoql = new zzexe(this, null);
    }
    return zzoql;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzewx)) {
      return super.equals(paramObject);
    }
    paramObject = (zzewx)paramObject;
    int j = size();
    if (j != paramObject.size()) {
      return false;
    }
    int k = zzcve();
    if (k != paramObject.zzcve()) {
      return entrySet().equals(paramObject.entrySet());
    }
    int i = 0;
    while (i < k)
    {
      if (!zzkv(i).equals(paramObject.zzkv(i))) {
        return false;
      }
      i += 1;
    }
    if (k != j) {
      return zzoqk.equals(zzoqk);
    }
    return true;
  }
  
  public Object get(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    int i = binarySearch(paramObject);
    if (i >= 0) {
      return ((zzexc)zzoqj.get(i)).getValue();
    }
    return zzoqk.get(paramObject);
  }
  
  public int hashCode()
  {
    int k = zzcve();
    int j = 0;
    int i = 0;
    while (j < k)
    {
      i += ((zzexc)zzoqj.get(j)).hashCode();
      j += 1;
    }
    j = i;
    if (zzoqk.size() > 0) {
      j = i + zzoqk.hashCode();
    }
    return j;
  }
  
  public final boolean isImmutable()
  {
    return zzkff;
  }
  
  public final Object put(Comparable paramComparable, Object paramObject)
  {
    zzcvg();
    int i = binarySearch(paramComparable);
    if (i >= 0) {
      return ((zzexc)zzoqj.get(i)).setValue(paramObject);
    }
    zzcvg();
    if ((zzoqj.isEmpty()) && (!(zzoqj instanceof ArrayList))) {
      zzoqj = new ArrayList(zzoqi);
    }
    i = -(i + 1);
    if (i >= zzoqi) {
      return zzcvh().put(paramComparable, paramObject);
    }
    int j = zzoqj.size();
    int k = zzoqi;
    if (j == k)
    {
      zzexc localZzexc = (zzexc)zzoqj.remove(k - 1);
      zzcvh().put((Comparable)localZzexc.getKey(), localZzexc.getValue());
    }
    zzoqj.add(i, new zzexc(this, paramComparable, paramObject));
    return null;
  }
  
  public Object remove(Object paramObject)
  {
    zzcvg();
    paramObject = (Comparable)paramObject;
    int i = binarySearch(paramObject);
    if (i >= 0) {
      return zzkw(i);
    }
    if (zzoqk.isEmpty()) {
      return null;
    }
    return zzoqk.remove(paramObject);
  }
  
  public int size()
  {
    int i = zzoqj.size();
    return zzoqk.size() + i;
  }
  
  public void zzbhs()
  {
    if (!zzkff)
    {
      Map localMap;
      if (zzoqk.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(zzoqk);
      }
      zzoqk = localMap;
      if (zzoqm.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(zzoqm);
      }
      zzoqm = localMap;
      zzkff = true;
    }
  }
  
  public final int zzcve()
  {
    return zzoqj.size();
  }
  
  public final Iterable zzcvf()
  {
    if (zzoqk.isEmpty()) {
      return zzewz.zzoqo;
    }
    return zzoqk.entrySet();
  }
  
  public final Map.Entry zzkv(int paramInt)
  {
    return (Map.Entry)zzoqj.get(paramInt);
  }
}
