# This is an automatically generated file.
# DO NOT EDIT or your changes may be overwritten
from __future__ import annotations

import base64
from enum import IntEnum
from typing import List, Optional
from xdrlib3 import Packer, Unpacker
from .base import Integer, UnsignedInteger, Float, Double, Hyper, UnsignedHyper, Boolean, String, Opaque
from .constants import *

__all__ = ['Int64']
class Int64:
    """
    XDR Source Code::

        typedef hyper int64;
    """
    def __init__(self, int64: int) -> None:
        self.int64 = int64
    def pack(self, packer: Packer) -> None:
        Hyper(self.int64).pack(packer)
    @classmethod
    def unpack(cls, unpacker: Unpacker) -> Int64:
        int64 = Hyper.unpack(unpacker)
        return cls(int64)
    def to_xdr_bytes(self) -> bytes:
        packer = Packer()
        self.pack(packer)
        return packer.get_buffer()

    @classmethod
    def from_xdr_bytes(cls, xdr: bytes) -> Int64:
        unpacker = Unpacker(xdr)
        return cls.unpack(unpacker)

    def to_xdr(self) -> str:
        xdr_bytes = self.to_xdr_bytes()
        return base64.b64encode(xdr_bytes).decode()

    @classmethod
    def from_xdr(cls, xdr: str) -> Int64:
        xdr_bytes = base64.b64decode(xdr.encode())
        return cls.from_xdr_bytes(xdr_bytes)
    def __eq__(self, other: object):
        if not isinstance(other, self.__class__):
            return NotImplemented
        return self.int64 == other.int64

    def __str__(self):
        return f"<Int64 [int64={self.int64}]>"
