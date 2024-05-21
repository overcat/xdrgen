// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package MyXDR;

import java.io.IOException;

import org.stellar.sdk.Base64Factory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import static MyXDR.Constants.*;

/**
 * TestArray's original definition in the XDR file is:
 * <pre>
 * typedef int TestArray[FOO];
 * </pre>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestArray implements XdrElement {
  private Integer[] TestArray;
  public static void encode(XdrDataOutputStream stream, TestArray  encodedTestArray) throws IOException {
    int TestArraySize = encodedTestArray.getTestArray().length;
    for (int i = 0; i < TestArraySize; i++) {
      stream.writeInt(encodedTestArray.TestArray[i]);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static TestArray decode(XdrDataInputStream stream) throws IOException {
    TestArray decodedTestArray = new TestArray();
    int TestArraySize = FOO;
    decodedTestArray.TestArray = new Integer[TestArraySize];
    for (int i = 0; i < TestArraySize; i++) {
      decodedTestArray.TestArray[i] = stream.readInt();
    }
    return decodedTestArray;
  }

  @Override
  public String toXdrBase64() throws IOException {
    return Base64Factory.getInstance().encodeToString(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static TestArray fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static TestArray fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
