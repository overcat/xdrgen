# This is an automatically generated file.
# DO NOT EDIT or your changes may be overwritten
import base64
from enum import IntEnum
from typing import List, Optional
from xdrlib3 import Packer, Unpacker
from .base import Integer, UnsignedInteger, Float, Double, Hyper, UnsignedHyper, Boolean, String, Opaque
from .constants import *

__all__ = ['NesterNestedEnum']
class NesterNestedEnum(IntEnum):
    """
    XDR Source Code::

        enum {
            BLAH_1,
            BLAH_2
          }
    """
    BLAH_1 = 0
    BLAH_2 = 1
    def pack(self, packer: Packer) -> None:
        packer.pack_int(self.value)

    @classmethod
    def unpack(cls, unpacker: Unpacker) -> "NesterNestedEnum":
        value = unpacker.unpack_int()
        return cls(value)
    def to_xdr_bytes(self) -> bytes:
        packer = Packer()
        self.pack(packer)
        return packer.get_buffer()

    @classmethod
    def from_xdr_bytes(cls, xdr: bytes) -> "NesterNestedEnum":
        unpacker = Unpacker(xdr)
        return cls.unpack(unpacker)

    def to_xdr(self) -> str:
        xdr_bytes = self.to_xdr_bytes()
        return base64.b64encode(xdr_bytes).decode()

    @classmethod
    def from_xdr(cls, xdr: str) -> "NesterNestedEnum":
        xdr_bytes = base64.b64decode(xdr.encode())
        return cls.from_xdr_bytes(xdr_bytes)
