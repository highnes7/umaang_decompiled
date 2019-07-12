package f.g.org.org.util;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Throwables;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IOUtils
{
  public IOUtils() {}
  
  public static long computeLength(StreamingContent paramStreamingContent)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramStreamingContent.writeTo(localByteArrayOutputStream);
      localByteArrayOutputStream.close();
      return count;
    }
    catch (Throwable paramStreamingContent)
    {
      localByteArrayOutputStream.close();
      throw paramStreamingContent;
    }
  }
  
  public static void copy(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException
  {
    try
    {
      WebmExtractor.read(paramInputStream, paramOutputStream);
      if (paramBoolean)
      {
        paramInputStream.close();
        return;
      }
    }
    catch (Throwable paramOutputStream)
    {
      if (paramBoolean) {
        paramInputStream.close();
      }
      throw paramOutputStream;
    }
  }
  
  public static Serializable deserialize(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      Object localObject = new ObjectInputStream(paramInputStream).readObject();
      localObject = (Serializable)localObject;
      paramInputStream.close();
      return localObject;
    }
    catch (Throwable localThrowable) {}catch (ClassNotFoundException localClassNotFoundException)
    {
      IOException localIOException = new IOException("Failed to deserialize object");
      localIOException.initCause(localClassNotFoundException);
      throw localIOException;
    }
    paramInputStream.close();
    throw localClassNotFoundException;
  }
  
  public static Serializable deserialize(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return deserialize(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public static boolean isSymbolicLink(File paramFile)
    throws IOException
  {
    try
    {
      localObject1 = Class.forName("java.nio.file.Files");
    }
    catch (InvocationTargetException paramFile)
    {
      Object localObject1;
      Class localClass;
      Object localObject2;
      boolean bool;
      paramFile = ((InvocationTargetException)paramFile).getCause();
      Throwables.propagateIfInstanceOf(paramFile, IOException.class);
      Throwables.propagateIfPossible(paramFile);
      throw new RuntimeException(paramFile);
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      for (;;) {}
    }
    catch (SecurityException localSecurityException1)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      label79:
      for (;;) {}
    }
    try
    {
      localClass = Class.forName("java.nio.file.Path");
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      break label79;
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      break label79;
    }
    catch (SecurityException localSecurityException2)
    {
      break label79;
    }
    catch (IllegalAccessException localIllegalAccessException2)
    {
      break label79;
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      break label79;
    }
    try
    {
      localObject2 = File.class.getMethod("toPath", new Class[0]);
      localObject2 = ((Method)localObject2).invoke(paramFile, new Object[0]);
      localObject1 = ((Class)localObject1).getMethod("isSymbolicLink", new Class[] { localClass });
      localObject1 = ((Method)localObject1).invoke(null, new Object[] { localObject2 });
      localObject1 = (Boolean)localObject1;
      bool = ((Boolean)localObject1).booleanValue();
      return bool;
    }
    catch (ClassNotFoundException localClassNotFoundException3)
    {
      break label79;
    }
    catch (IllegalArgumentException localIllegalArgumentException3)
    {
      break label79;
    }
    catch (SecurityException localSecurityException3)
    {
      break label79;
    }
    catch (IllegalAccessException localIllegalAccessException3)
    {
      break label79;
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      break label79;
    }
    if (File.separatorChar == '\\') {
      return false;
    }
    localObject1 = paramFile;
    if (paramFile.getParent() != null) {
      localObject1 = new File(paramFile.getParentFile().getCanonicalFile(), paramFile.getName());
    }
    return ((File)localObject1).getCanonicalFile().equals(((File)localObject1).getAbsoluteFile()) ^ true;
  }
  
  public static void serialize(Object paramObject, OutputStream paramOutputStream)
    throws IOException
  {
    try
    {
      new ObjectOutputStream(paramOutputStream).writeObject(paramObject);
      paramOutputStream.close();
      return;
    }
    catch (Throwable paramObject)
    {
      paramOutputStream.close();
      throw paramObject;
    }
  }
  
  public static byte[] serialize(Object paramObject)
    throws IOException
  {
    java.io.ByteArrayOutputStream localByteArrayOutputStream = new java.io.ByteArrayOutputStream();
    serialize(paramObject, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static void writeFile(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    copy(paramInputStream, paramOutputStream, true);
  }
}
