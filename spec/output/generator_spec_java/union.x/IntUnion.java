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
import lombok.Builder;
import static MyXDR.Constants.*;

/**
 * IntUnion's original definition in the XDR file is:
 * <pre>
 * union IntUnion switch (int type)
 * {
 *     case 0:
 *         Error error;
 *     case 1:
 *         Multi things&lt;&gt;;
 * 
 * };
 * </pre>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class IntUnion implements XdrElement {
  private Integer discriminant;
  private Error error;
  private Multi[] things;

  public static void encode(XdrDataOutputStream stream, IntUnion encodedIntUnion) throws IOException {
  //Xdrgen::AST::Typespecs::Int
  //Integer
  stream.writeInt(encodedIntUnion.getDiscriminant().intValue());
  switch (encodedIntUnion.getDiscriminant()) {
  case 0:
  Error.encode(stream, encodedIntUnion.error);
  break;
  case 1:
  int thingsSize = encodedIntUnion.getThings().length;
  stream.writeInt(thingsSize);
  for (int i = 0; i < thingsSize; i++) {
    Multi.encode(stream, encodedIntUnion.things[i]);
  }
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static IntUnion decode(XdrDataInputStream stream) throws IOException {
  IntUnion decodedIntUnion = new IntUnion();
  Integer discriminant = stream.readInt();
  decodedIntUnion.setDiscriminant(discriminant);
  switch (decodedIntUnion.getDiscriminant()) {
  case 0:
  decodedIntUnion.error = Error.decode(stream);
  break;
  case 1:
  int thingsSize = stream.readInt();
  decodedIntUnion.things = new Multi[thingsSize];
  for (int i = 0; i < thingsSize; i++) {
    decodedIntUnion.things[i] = Multi.decode(stream);
  }
  break;
  }
    return decodedIntUnion;
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

  public static IntUnion fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static IntUnion fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
