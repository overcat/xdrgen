# This is an automatically generated file.
# DO NOT EDIT or your changes may be overwritten
import base64
from typing import List
from xdrlib import Packer, Unpacker
from .base import Integer
from .constants import *

__all__ = ["TestArray2"]


class TestArray2:
    """
    XDR Source Code::

        typedef int TestArray2<FOO>;
    """

    def __init__(self, test_array2: List[int]) -> None:
        if test_array2 and len(test_array2) > FOO:
            expect_size = FOO
            raise ValueError(
                f"The maximum length of `test_array2` should be {expect_size}, but got {len(test_array2)}."
            )
        self.test_array2 = test_array2

    def pack(self, packer: Packer) -> None:
        packer.pack_uint(len(self.test_array2))
        for test_array2_item in self.test_array2:
            Integer(test_array2_item).pack(packer)

    @classmethod
    def unpack(cls, unpacker: Unpacker) -> "TestArray2":
        length = unpacker.unpack_uint()
        test_array2 = []
        for _ in range(length):
            test_array2.append(Integer.unpack(unpacker))
        return cls(test_array2)

    def to_xdr_bytes(self) -> bytes:
        packer = Packer()
        self.pack(packer)
        return packer.get_buffer()

    @classmethod
    def from_xdr_bytes(cls, xdr: bytes) -> "TestArray2":
        unpacker = Unpacker(xdr)
        return cls.unpack(unpacker)

    def to_xdr(self) -> str:
        xdr_bytes = self.to_xdr_bytes()
        return base64.b64encode(xdr_bytes).decode()

    @classmethod
    def from_xdr(cls, xdr: str) -> "TestArray2":
        xdr_bytes = base64.b64decode(xdr.encode())
        return cls.from_xdr_bytes(xdr_bytes)

    def __eq__(self, other: object):
        if not isinstance(other, self.__class__):
            return NotImplemented
        return self.test_array2 == other.test_array2

    def __str__(self):
        return f"<TestArray2 [test_array2={self.test_array2}]>"
