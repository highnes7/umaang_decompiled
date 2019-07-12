package f.g.org.org.util.store;

import f.g.b.a.g.b.c;
import f.g.b.a.g.b.g;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Throwables;
import f.g.org.org.util.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Logger;

public class FileDataStoreFactory
  extends AbstractDataStoreFactory
{
  public static final Logger LOGGER = Logger.getLogger(g.class.getName());
  public final File dataDirectory;
  
  public FileDataStoreFactory(File paramFile)
    throws IOException
  {
    paramFile = paramFile.getCanonicalFile();
    dataDirectory = paramFile;
    if (!IOUtils.isSymbolicLink(paramFile))
    {
      if ((!paramFile.exists()) && (!paramFile.mkdirs()))
      {
        paramFile = String.valueOf(paramFile);
        throw new IOException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(paramFile.length() + 28), "unable to create directory: ", paramFile));
      }
      setPermissionsToOwnerOnly(paramFile);
      return;
    }
    paramFile = String.valueOf(paramFile);
    throw new IOException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(paramFile.length() + 31), "unable to use a symbolic link: ", paramFile));
  }
  
  public static void setPermissionsToOwnerOnly(File paramFile)
    throws IOException
  {
    Object localObject1 = Boolean.TYPE;
    Object localObject2 = Boolean.TYPE;
    for (;;)
    {
      try
      {
        localObject1 = File.class.getMethod("setReadable", new Class[] { localObject1, localObject2 });
        localObject2 = Boolean.TYPE;
        localObject3 = Boolean.TYPE;
      }
      catch (InvocationTargetException paramFile)
      {
        Object localObject3;
        Object localObject4;
        boolean bool;
        String str;
        int i;
        StringBuilder localStringBuilder;
        paramFile = ((InvocationTargetException)paramFile).getCause();
        Throwables.propagateIfInstanceOf(paramFile, IOException.class);
        Throwables.propagateIfPossible(paramFile);
        throw new RuntimeException(paramFile);
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        continue;
      }
      catch (SecurityException paramFile)
      {
        return;
      }
      catch (IllegalAccessException paramFile)
      {
        return;
      }
      catch (IllegalArgumentException paramFile)
      {
        return;
      }
      try
      {
        localObject2 = File.class.getMethod("setWritable", new Class[] { localObject2, localObject3 });
        localObject3 = Boolean.TYPE;
        localObject4 = Boolean.TYPE;
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        continue;
      }
      catch (SecurityException paramFile)
      {
        return;
      }
      catch (IllegalAccessException paramFile)
      {
        return;
      }
      catch (IllegalArgumentException paramFile)
      {
        return;
      }
      try
      {
        localObject3 = File.class.getMethod("setExecutable", new Class[] { localObject3, localObject4 });
        localObject4 = ((Method)localObject1).invoke(paramFile, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
        localObject4 = (Boolean)localObject4;
        bool = ((Boolean)localObject4).booleanValue();
        if (bool)
        {
          localObject4 = ((Method)localObject2).invoke(paramFile, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
          localObject4 = (Boolean)localObject4;
          bool = ((Boolean)localObject4).booleanValue();
          if (bool)
          {
            localObject4 = ((Method)localObject3).invoke(paramFile, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
            localObject4 = (Boolean)localObject4;
            bool = ((Boolean)localObject4).booleanValue();
            if (bool) {
              continue;
            }
          }
        }
        localObject4 = LOGGER;
        str = String.valueOf(paramFile);
        i = str.length();
        localStringBuilder = new StringBuilder(i + 44);
        localStringBuilder.append("unable to change permissions for everybody: ");
        localStringBuilder.append(str);
        ((Logger)localObject4).warning(localStringBuilder.toString());
        localObject1 = ((Method)localObject1).invoke(paramFile, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true) });
        localObject1 = (Boolean)localObject1;
        bool = ((Boolean)localObject1).booleanValue();
        if (bool)
        {
          localObject1 = ((Method)localObject2).invoke(paramFile, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true) });
          localObject1 = (Boolean)localObject1;
          bool = ((Boolean)localObject1).booleanValue();
          if (bool)
          {
            localObject1 = ((Method)localObject3).invoke(paramFile, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true) });
            localObject1 = (Boolean)localObject1;
            bool = ((Boolean)localObject1).booleanValue();
            if (bool) {
              break;
            }
          }
        }
        localObject1 = LOGGER;
        localObject2 = String.valueOf(paramFile);
        i = ((String)localObject2).length();
        localObject3 = new StringBuilder(i + 40);
        ((StringBuilder)localObject3).append("unable to change permissions for owner: ");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((Logger)localObject1).warning(((StringBuilder)localObject3).toString());
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException3) {}catch (SecurityException paramFile)
      {
        return;
      }
      catch (IllegalAccessException paramFile)
      {
        return;
      }
      catch (IllegalArgumentException paramFile) {}
    }
    localObject1 = LOGGER;
    paramFile = String.valueOf(paramFile);
    localObject2 = new StringBuilder(paramFile.length() + 93);
    ((StringBuilder)localObject2).append("Unable to set permissions for ");
    ((StringBuilder)localObject2).append(paramFile);
    ((StringBuilder)localObject2).append(", likely because you are running a version of Java prior to 1.6");
    ((Logger)localObject1).warning(((StringBuilder)localObject2).toString());
    return;
  }
  
  public DataStore createDataStore(String paramString)
    throws IOException
  {
    return new FileDataStore(dataDirectory, paramString);
  }
  
  public final File getDataDirectory()
  {
    return dataDirectory;
  }
  
  public class FileDataStore<V extends Serializable>
    extends c<V>
  {
    public final File dataFile;
    
    public FileDataStore(File paramFile, String paramString)
      throws IOException
    {
      super(paramString);
      dataFile = new File(paramFile, paramString);
      if (!IOUtils.isSymbolicLink(dataFile))
      {
        if (dataFile.createNewFile())
        {
          keyValueMap = new HashMap();
          save();
          return;
        }
        keyValueMap = ((HashMap)IOUtils.deserialize(new FileInputStream(dataFile)));
        return;
      }
      this$1 = String.valueOf(dataFile);
      throw new IOException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(this$1.length() + 31), "unable to use a symbolic link: ", this$1));
    }
    
    public FileDataStoreFactory getDataStoreFactory()
    {
      return (FileDataStoreFactory)dataStoreFactory;
    }
    
    public void save()
      throws IOException
    {
      IOUtils.serialize(keyValueMap, new FileOutputStream(dataFile));
    }
  }
}
