// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package MyXDR;

import java.io.IOException;

import static MyXDR.Constants.*;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import com.google.common.base.Objects;

// === xdr source ============================================================

//  typedef int             int1;

//  ===========================================================================
public class Int1 implements XdrElement {
  private Integer int1;

  public Int1() {}

  public Int1(Integer int1) {
    this.int1 = int1;
  }

  public Integer getInt1() {
    return this.int1;
  }

  public void setInt1(Integer value) {
    this.int1 = value;
  }

  public static void encode(XdrDataOutputStream stream, Int1  encodedInt1) throws IOException {
    stream.writeInt(encodedInt1.int1);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static Int1 decode(XdrDataInputStream stream) throws IOException {
    Int1 decodedInt1 = new Int1();
    decodedInt1.int1 = stream.readInt();
    return decodedInt1;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.int1);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Int1)) {
      return false;
    }

    Int1 other = (Int1) object;
    return Objects.equal(this.int1, other.int1);
  }
  @Override
  public String toXdrBase64() throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    return base64Encoding.encode(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static Int1 fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static Int1 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
