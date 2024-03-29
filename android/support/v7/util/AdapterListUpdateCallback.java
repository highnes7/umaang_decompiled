package android.support.v7.util;

import android.support.v7.widget.RecyclerView.Adapter;
import b.b.a.F;

public final class AdapterListUpdateCallback
  implements ListUpdateCallback
{
  @F
  public final RecyclerView.Adapter mAdapter;
  
  public AdapterListUpdateCallback(RecyclerView.Adapter paramAdapter)
  {
    mAdapter = paramAdapter;
  }
  
  public void onChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    mAdapter.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
  }
  
  public void onInserted(int paramInt1, int paramInt2)
  {
    mAdapter.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void onMoved(int paramInt1, int paramInt2)
  {
    mAdapter.notifyItemMoved(paramInt1, paramInt2);
  }
  
  public void onRemoved(int paramInt1, int paramInt2)
  {
    mAdapter.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
}
