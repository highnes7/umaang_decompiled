package support.android.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import b.b.a.N;
import f.sufficientlysecure.rootcommands.util.StringBuilder;

public abstract class CursorAdapter
  extends BaseAdapter
  implements Filterable, CursorFilter.CursorFilterClient
{
  @Deprecated
  public static final int FLAG_AUTO_REQUERY = 1;
  public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
  @N({b.b.a.N.a.b})
  public boolean mAutoRequery;
  @N({b.b.a.N.a.b})
  public ChangeObserver mChangeObserver;
  @N({b.b.a.N.a.b})
  public Context mContext;
  @N({b.b.a.N.a.b})
  public Cursor mCursor;
  @N({b.b.a.N.a.b})
  public CursorFilter mCursorFilter;
  @N({b.b.a.N.a.b})
  public DataSetObserver mDataSetObserver;
  @N({b.b.a.N.a.b})
  public boolean mDataValid;
  @N({b.b.a.N.a.b})
  public FilterQueryProvider mFilterQueryProvider;
  @N({b.b.a.N.a.b})
  public int mRowIDColumn;
  
  public CursorAdapter(Context paramContext, Cursor paramCursor)
  {
    init(paramContext, paramCursor, 1);
  }
  
  public CursorAdapter(Context paramContext, Cursor paramCursor, int paramInt)
  {
    init(paramContext, paramCursor, paramInt);
  }
  
  public CursorAdapter(Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    init(paramContext, paramCursor, i);
  }
  
  public abstract void bindView(View paramView, Context paramContext, Cursor paramCursor);
  
  public void changeCursor(Cursor paramCursor)
  {
    paramCursor = swapCursor(paramCursor);
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return "";
    }
    return paramCursor.toString();
  }
  
  public int getCount()
  {
    if (mDataValid)
    {
      Cursor localCursor = mCursor;
      if (localCursor != null) {
        return localCursor.getCount();
      }
    }
    return 0;
  }
  
  public Cursor getCursor()
  {
    return mCursor;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (mDataValid)
    {
      mCursor.moveToPosition(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = newDropDownView(mContext, mCursor, paramViewGroup);
      }
      bindView(localView, mContext, mCursor);
      return localView;
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (mCursorFilter == null) {
      mCursorFilter = new CursorFilter(this);
    }
    return mCursorFilter;
  }
  
  public FilterQueryProvider getFilterQueryProvider()
  {
    return mFilterQueryProvider;
  }
  
  public Object getItem(int paramInt)
  {
    if (mDataValid)
    {
      Cursor localCursor = mCursor;
      if (localCursor != null)
      {
        localCursor.moveToPosition(paramInt);
        return mCursor;
      }
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (mDataValid)
    {
      Cursor localCursor = mCursor;
      if ((localCursor != null) && (localCursor.moveToPosition(paramInt))) {
        return mCursor.getLong(mRowIDColumn);
      }
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (mDataValid)
    {
      if (mCursor.moveToPosition(paramInt))
      {
        View localView = paramView;
        if (paramView == null) {
          localView = newView(mContext, mCursor, paramViewGroup);
        }
        bindView(localView, mContext, mCursor);
        return localView;
      }
      throw new IllegalStateException(StringBuilder.toString("couldn't move cursor to position ", paramInt));
    }
    throw new IllegalStateException("this should only be called when the cursor is valid");
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public void init(Context paramContext, Cursor paramCursor, int paramInt)
  {
    boolean bool = false;
    if ((paramInt & 0x1) == 1)
    {
      paramInt |= 0x2;
      mAutoRequery = true;
    }
    else
    {
      mAutoRequery = false;
    }
    if (paramCursor != null) {
      bool = true;
    }
    mCursor = paramCursor;
    mDataValid = bool;
    mContext = paramContext;
    int i;
    if (bool) {
      i = paramCursor.getColumnIndexOrThrow("_id");
    } else {
      i = -1;
    }
    mRowIDColumn = i;
    if ((paramInt & 0x2) == 2)
    {
      mChangeObserver = new ChangeObserver();
      mDataSetObserver = new MyDataSetObserver();
    }
    else
    {
      mChangeObserver = null;
      mDataSetObserver = null;
    }
    if (bool)
    {
      paramContext = mChangeObserver;
      if (paramContext != null) {
        paramCursor.registerContentObserver(paramContext);
      }
      paramContext = mDataSetObserver;
      if (paramContext != null) {
        paramCursor.registerDataSetObserver(paramContext);
      }
    }
  }
  
  public void init(Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    init(paramContext, paramCursor, i);
  }
  
  public View newDropDownView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return newView(paramContext, paramCursor, paramViewGroup);
  }
  
  public abstract View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  public void onContentChanged()
  {
    if (mAutoRequery)
    {
      Cursor localCursor = mCursor;
      if ((localCursor != null) && (!localCursor.isClosed())) {
        mDataValid = mCursor.requery();
      }
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    FilterQueryProvider localFilterQueryProvider = mFilterQueryProvider;
    if (localFilterQueryProvider != null) {
      return localFilterQueryProvider.runQuery(paramCharSequence);
    }
    return mCursor;
  }
  
  public void setFilterQueryProvider(FilterQueryProvider paramFilterQueryProvider)
  {
    mFilterQueryProvider = paramFilterQueryProvider;
  }
  
  public Cursor swapCursor(Cursor paramCursor)
  {
    Cursor localCursor = mCursor;
    if (paramCursor == localCursor) {
      return null;
    }
    Object localObject;
    if (localCursor != null)
    {
      localObject = mChangeObserver;
      if (localObject != null) {
        localCursor.unregisterContentObserver((ContentObserver)localObject);
      }
      localObject = mDataSetObserver;
      if (localObject != null) {
        localCursor.unregisterDataSetObserver((DataSetObserver)localObject);
      }
    }
    mCursor = paramCursor;
    if (paramCursor != null)
    {
      localObject = mChangeObserver;
      if (localObject != null) {
        paramCursor.registerContentObserver((ContentObserver)localObject);
      }
      localObject = mDataSetObserver;
      if (localObject != null) {
        paramCursor.registerDataSetObserver((DataSetObserver)localObject);
      }
      mRowIDColumn = paramCursor.getColumnIndexOrThrow("_id");
      mDataValid = true;
      notifyDataSetChanged();
      return localCursor;
    }
    mRowIDColumn = -1;
    mDataValid = false;
    notifyDataSetInvalidated();
    return localCursor;
  }
  
  public class ChangeObserver
    extends ContentObserver
  {
    public ChangeObserver()
    {
      super();
    }
    
    public boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public void onChange(boolean paramBoolean)
    {
      onContentChanged();
    }
  }
  
  public class MyDataSetObserver
    extends DataSetObserver
  {
    public MyDataSetObserver() {}
    
    public void onChanged()
    {
      CursorAdapter localCursorAdapter = CursorAdapter.this;
      mDataValid = true;
      localCursorAdapter.notifyDataSetChanged();
    }
    
    public void onInvalidated()
    {
      CursorAdapter localCursorAdapter = CursorAdapter.this;
      mDataValid = false;
      localCursorAdapter.notifyDataSetInvalidated();
    }
  }
}
