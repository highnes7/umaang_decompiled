package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public final class NativeAppCallAttachmentStore
{
  public static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
  public static final String NEW = "com.facebook.internal.NativeAppCallAttachmentStore";
  public static File attachmentsDirectory;
  
  public NativeAppCallAttachmentStore() {}
  
  public static void addAttachments(Collection paramCollection)
  {
    if (paramCollection != null)
    {
      if (paramCollection.size() == 0) {
        return;
      }
      if (attachmentsDirectory == null) {
        cleanupAllAttachments();
      }
      ensureAttachmentsDirectoryExists();
      Object localObject1 = new ArrayList();
      try
      {
        paramCollection = paramCollection.iterator();
        for (;;)
        {
          boolean bool = paramCollection.hasNext();
          if (!bool) {
            break;
          }
          localObject2 = paramCollection.next();
          localObject2 = (Attachment)localObject2;
          if (shouldCreateFile)
          {
            Object localObject3 = callId;
            Object localObject4 = attachmentName;
            localObject3 = getAttachmentFile((UUID)localObject3, (String)localObject4, true);
            ((List)localObject1).add(localObject3);
            localObject4 = bitmap;
            if (localObject4 != null)
            {
              processAttachmentBitmap((Bitmap)localObject4, (File)localObject3);
            }
            else
            {
              localObject4 = originalUri;
              if (localObject4 != null)
              {
                bool = isContentUri;
                processAttachmentFile((Uri)localObject4, bool, (File)localObject3);
              }
            }
          }
        }
        return;
      }
      catch (IOException paramCollection)
      {
        Object localObject2 = NEW;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Got unexpected exception:");
        ((StringBuilder)localObject2).append(paramCollection);
        ((StringBuilder)localObject2).toString();
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext()) {
            localObject2 = (File)((Iterator)localObject1).next();
          }
          try
          {
            ((File)localObject2).delete();
          }
          catch (Exception localException) {}
          throw new FacebookException(paramCollection);
        }
      }
    }
  }
  
  public static void cleanupAllAttachments()
  {
    Utility.deleteDirectory(getAttachmentsDirectory());
  }
  
  public static void cleanupAttachmentsForCall(UUID paramUUID)
  {
    paramUUID = getAttachmentsDirectoryForCall(paramUUID, false);
    if (paramUUID != null) {
      Utility.deleteDirectory(paramUUID);
    }
  }
  
  public static Attachment createAttachment(UUID paramUUID, Bitmap paramBitmap)
  {
    Validate.notNull(paramUUID, "callId");
    Validate.notNull(paramBitmap, "attachmentBitmap");
    return new Attachment(paramUUID, paramBitmap, null);
  }
  
  public static Attachment createAttachment(UUID paramUUID, Uri paramUri)
  {
    Validate.notNull(paramUUID, "callId");
    Validate.notNull(paramUri, "attachmentUri");
    return new Attachment(paramUUID, null, paramUri);
  }
  
  public static File ensureAttachmentsDirectoryExists()
  {
    File localFile = getAttachmentsDirectory();
    localFile.mkdirs();
    return localFile;
  }
  
  public static File getAttachmentFile(UUID paramUUID, String paramString, boolean paramBoolean)
    throws IOException
  {
    paramUUID = getAttachmentsDirectoryForCall(paramUUID, paramBoolean);
    if (paramUUID == null) {
      return null;
    }
    try
    {
      paramUUID = new File(paramUUID, URLEncoder.encode(paramString, "UTF-8"));
      return paramUUID;
    }
    catch (UnsupportedEncodingException paramUUID) {}
    return null;
  }
  
  public static File getAttachmentsDirectory()
  {
    try
    {
      if (attachmentsDirectory == null) {
        attachmentsDirectory = new File(FacebookSdk.getApplicationContext().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
      }
      File localFile = attachmentsDirectory;
      return localFile;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static File getAttachmentsDirectoryForCall(UUID paramUUID, boolean paramBoolean)
  {
    File localFile = attachmentsDirectory;
    if (localFile == null) {
      return null;
    }
    paramUUID = new File(localFile, paramUUID.toString());
    if ((paramBoolean) && (!paramUUID.exists())) {
      paramUUID.mkdirs();
    }
    return paramUUID;
  }
  
  public static File openAttachment(UUID paramUUID, String paramString)
    throws FileNotFoundException
  {
    if ((!Utility.isNullOrEmpty(paramString)) && (paramUUID != null)) {}
    try
    {
      paramUUID = getAttachmentFile(paramUUID, paramString, false);
      return paramUUID;
    }
    catch (IOException paramUUID)
    {
      for (;;) {}
    }
    throw new FileNotFoundException();
    throw new FileNotFoundException();
  }
  
  public static void processAttachmentBitmap(Bitmap paramBitmap, File paramFile)
    throws IOException
  {
    paramFile = new FileOutputStream(paramFile);
    try
    {
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, paramFile);
      Utility.closeQuietly(paramFile);
      return;
    }
    catch (Throwable paramBitmap)
    {
      Utility.closeQuietly(paramFile);
      throw paramBitmap;
    }
  }
  
  public static void processAttachmentFile(Uri paramUri, boolean paramBoolean, File paramFile)
    throws IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a5 = a4\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static final class Attachment
  {
    public final String attachmentName;
    public final String attachmentUrl;
    public Bitmap bitmap;
    public final UUID callId;
    public boolean isContentUri;
    public Uri originalUri;
    public boolean shouldCreateFile;
    
    public Attachment(UUID paramUUID, Bitmap paramBitmap, Uri paramUri)
    {
      callId = paramUUID;
      bitmap = paramBitmap;
      originalUri = paramUri;
      boolean bool = true;
      if (paramUri != null)
      {
        paramBitmap = paramUri.getScheme();
        if ("content".equalsIgnoreCase(paramBitmap))
        {
          isContentUri = true;
          if ((paramUri.getAuthority() == null) || (paramUri.getAuthority().startsWith("media"))) {
            bool = false;
          }
          shouldCreateFile = bool;
        }
        else if ("file".equalsIgnoreCase(paramUri.getScheme()))
        {
          shouldCreateFile = true;
        }
        else if (!Utility.isWebUri(paramUri))
        {
          throw new FacebookException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Unsupported scheme for media Uri : ", paramBitmap));
        }
      }
      else
      {
        if (paramBitmap == null) {
          break label192;
        }
        shouldCreateFile = true;
      }
      if (!shouldCreateFile) {
        paramBitmap = null;
      } else {
        paramBitmap = UUID.randomUUID().toString();
      }
      attachmentName = paramBitmap;
      if (!shouldCreateFile) {
        paramUUID = originalUri.toString();
      } else {
        paramUUID = FacebookContentProvider.getAttachmentUrl(FacebookSdk.getApplicationId(), paramUUID, attachmentName);
      }
      attachmentUrl = paramUUID;
      return;
      label192:
      throw new FacebookException("Cannot share media without a bitmap or Uri set");
    }
    
    public String getAttachmentUrl()
    {
      return attachmentUrl;
    }
  }
}
