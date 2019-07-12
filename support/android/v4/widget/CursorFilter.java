package support.android.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

public class CursorFilter
  extends Filter
{
  public CursorFilterClient mClient;
  
  public CursorFilter(CursorFilterClient paramCursorFilterClient)
  {
    mClient = paramCursorFilterClient;
  }
  
  public CharSequence convertResultToString(Object paramObject)
  {
    return mClient.convertToString((Cursor)paramObject);
  }
  
  public Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    paramCharSequence = mClient.runQueryOnBackgroundThread(paramCharSequence);
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (paramCharSequence != null)
    {
      count = paramCharSequence.getCount();
      values = paramCharSequence;
      return localFilterResults;
    }
    count = 0;
    values = null;
    return localFilterResults;
  }
  
  public void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    paramCharSequence = mClient.getCursor();
    paramFilterResults = values;
    if ((paramFilterResults != null) && (paramFilterResults != paramCharSequence)) {
      mClient.changeCursor((Cursor)paramFilterResults);
    }
  }
  
  public abstract interface CursorFilterClient
  {
    public abstract void changeCursor(Cursor paramCursor);
    
    public abstract CharSequence convertToString(Cursor paramCursor);
    
    public abstract Cursor getCursor();
    
    public abstract Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence);
  }
}
