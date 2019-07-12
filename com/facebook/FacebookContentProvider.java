package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.internal.NativeAppCallAttachmentStore;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.FileNotFoundException;
import java.util.UUID;

public class FacebookContentProvider
  extends ContentProvider
{
  public static final String ATTACHMENT_URL_BASE = "content://com.facebook.app.FacebookContentProvider";
  public static final String LOG = "com.facebook.FacebookContentProvider";
  
  public FacebookContentProvider() {}
  
  public static String getAttachmentUrl(String paramString1, UUID paramUUID, String paramString2)
  {
    return String.format("%s%s/%s/%s", new Object[] { "content://com.facebook.app.FacebookContentProvider", paramString1, paramUUID.toString(), paramString2 });
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
    throws FileNotFoundException
  {
    paramString = parseCallIdAndAttachmentName(paramUri);
    if (paramString != null)
    {
      paramUri = (UUID)first;
      paramString = (String)second;
      try
      {
        paramUri = ParcelFileDescriptor.open(NativeAppCallAttachmentStore.openAttachment(paramUri, paramString), 268435456);
        return paramUri;
      }
      catch (FileNotFoundException paramUri)
      {
        paramString = LOG;
        StringBuilder.append("Got unexpected exception:", paramUri);
        throw paramUri;
      }
    }
    throw new FileNotFoundException();
  }
  
  public Pair parseCallIdAndAttachmentName(Uri paramUri)
  {
    try
    {
      Object localObject = paramUri.getPath().substring(1).split("/");
      paramUri = localObject[0];
      localObject = localObject[1];
      paramUri = UUID.fromString(paramUri);
      paramUri = new Pair(paramUri, localObject);
      return paramUri;
    }
    catch (Exception paramUri)
    {
      for (;;) {}
    }
    return null;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}
