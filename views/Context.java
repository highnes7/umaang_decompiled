package views;

import android.net.Uri;

public abstract interface Context
{
  public abstract Task getAppLinkFromUrlInBackground(Uri paramUri);
}
