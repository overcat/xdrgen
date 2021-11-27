// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package MyXDR;


import java.io.IOException;


// === xdr source ============================================================

//  enum UnionKey {
//    ERROR,
//    MULTI
//  };

//  ===========================================================================
public enum UnionKey implements XdrElement {
  ERROR(0),
  MULTI(1),
  ;
  private int mValue;

  UnionKey(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  public static UnionKey decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return ERROR;
      case 1: return MULTI;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, UnionKey value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
}