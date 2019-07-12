package support.android.v4.content;

import android.content.SharedPreferences.Editor;

@Deprecated
public final class TableView
{
  public static TableView connection;
  public final p.a.a row = new p.a.a();
  
  public TableView() {}
  
  public static TableView close()
  {
    if (connection == null) {
      connection = new TableView();
    }
    return connection;
  }
  
  public void setBoolean(SharedPreferences.Editor paramEditor)
  {
    row.setString(paramEditor);
  }
}
