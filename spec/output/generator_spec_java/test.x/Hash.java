// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package MyXDR;

import java.io.IOException;

import static MyXDR.Constants.*;
import java.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

// === xdr source ============================================================

//  typedef opaque Hash[32];

//  ===========================================================================
public class Hash implements XdrElement {
  private byte[] Hash;

  public Hash() {}

  public Hash(byte[] Hash) {
    this.Hash = Hash;
  }

  public byte[] getHash() {
    return this.Hash;
  }

  public void setHash(byte[] value) {
    this.Hash = value;
  }

  public static void encode(XdrDataOutputStream stream, Hash  encodedHash) throws IOException {
    int Hashsize = encodedHash.Hash.length;
    stream.write(encodedHash.getHash(), 0, Hashsize);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static Hash decode(XdrDataInputStream stream) throws IOException {
    Hash decodedHash = new Hash();
    int Hashsize = 32;
    decodedHash.Hash = new byte[Hashsize];
    stream.read(decodedHash.Hash, 0, Hashsize);
    return decodedHash;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.Hash);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Hash)) {
      return false;
    }

    Hash other = (Hash) object;
    return Arrays.equals(this.Hash, other.Hash);
  }
  @Override
  public String toXdrBase64() throws IOException {
    return Base64.getEncoder().encodeToString(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static Hash fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static Hash fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
