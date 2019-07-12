package support.android.asm;

import android.util.SparseArray;
import android.view.View;
import b.b.v.ia;
import b.b.x.n.b;
import b.b.x.n.l;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.LongSparseArray;

public class Graph
{
  public final b<String, View> mAdapters = new ArrayMap();
  public final SparseArray<View> mBitmaps = new SparseArray();
  public final l<View> mSections = new LongSparseArray(10);
  public final b<View, ia> mSongs = new ArrayMap();
  
  public Graph() {}
}
