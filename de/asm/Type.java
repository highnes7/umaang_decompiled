package de.asm;

import c.b.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class Type
  extends ObjectInputStream
{
  public Type(ByteVector paramByteVector, InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public Class resolveClass(ObjectStreamClass paramObjectStreamClass)
    throws IOException, ClassNotFoundException
  {
    Class localClass = Class.forName(paramObjectStreamClass.getName(), false, f.class.getClassLoader());
    if (localClass != null) {
      return localClass;
    }
    return super.resolveClass(paramObjectStreamClass);
  }
}
