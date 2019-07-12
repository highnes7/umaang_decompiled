package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.Entry;
import java.util.Comparator;

public class EntryXIndexComparator
  implements Comparator<Entry>
{
  public EntryXIndexComparator() {}
  
  public int compare(Entry paramEntry1, Entry paramEntry2)
  {
    return paramEntry1.getXIndex() - paramEntry2.getXIndex();
  }
}
