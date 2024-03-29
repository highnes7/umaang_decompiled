package android.support.v7.util;

import android.util.SparseArray;
import java.lang.reflect.Array;

public class TileList<T>
{
  public Tile<T> mLastAccessedTile;
  public final int mTileSize;
  public final SparseArray<Tile<T>> mTiles = new SparseArray(10);
  
  public TileList(int paramInt)
  {
    mTileSize = paramInt;
  }
  
  public Tile addOrReplace(Tile paramTile)
  {
    int i = mTiles.indexOfKey(mStartPosition);
    if (i < 0)
    {
      mTiles.put(mStartPosition, paramTile);
      return null;
    }
    Tile localTile = (Tile)mTiles.valueAt(i);
    mTiles.setValueAt(i, paramTile);
    if (mLastAccessedTile == localTile) {
      mLastAccessedTile = paramTile;
    }
    return localTile;
  }
  
  public void clear()
  {
    mTiles.clear();
  }
  
  public Tile getAtIndex(int paramInt)
  {
    return (Tile)mTiles.valueAt(paramInt);
  }
  
  public Object getItemAt(int paramInt)
  {
    Tile localTile = mLastAccessedTile;
    if ((localTile == null) || (!localTile.containsPosition(paramInt)))
    {
      int i = mTileSize;
      i = mTiles.indexOfKey(paramInt - paramInt % i);
      if (i < 0) {
        return null;
      }
      mLastAccessedTile = ((Tile)mTiles.valueAt(i));
    }
    return mLastAccessedTile.getByPosition(paramInt);
  }
  
  public Tile removeAtPos(int paramInt)
  {
    Tile localTile = (Tile)mTiles.get(paramInt);
    if (mLastAccessedTile == localTile) {
      mLastAccessedTile = null;
    }
    mTiles.delete(paramInt);
    return localTile;
  }
  
  public int size()
  {
    return mTiles.size();
  }
  
  public static class Tile<T>
  {
    public int mItemCount;
    public final T[] mItems;
    public Tile<T> mNext;
    public int mStartPosition;
    
    public Tile(Class paramClass, int paramInt)
    {
      mItems = ((Object[])Array.newInstance(paramClass, paramInt));
    }
    
    public boolean containsPosition(int paramInt)
    {
      int i = mStartPosition;
      return (i <= paramInt) && (paramInt < i + mItemCount);
    }
    
    public Object getByPosition(int paramInt)
    {
      return mItems[(paramInt - mStartPosition)];
    }
  }
}
