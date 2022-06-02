# This is an automatically generated file.
# DO NOT EDIT or your changes may be overwritten
import base64
from xdrlib import Packer, Unpacker
from .base import Integer

__all__ = ["Foo"]


class Foo:
    """
    XDR Source Code::

        typedef int Foo;
    """

    def __init__(self, foo: int) -> None:
        self.foo = foo

    def pack(self, packer: Packer) -> None:
        Integer(self.foo).pack(packer)

    @classmethod
    def unpack(cls, unpacker: Unpacker) -> "Foo":
        foo = Integer.unpack(unpacker)
        return cls(foo)

    def to_xdr_bytes(self) -> bytes:
        packer = Packer()
        self.pack(packer)
        return packer.get_buffer()

    @classmethod
    def from_xdr_bytes(cls, xdr: bytes) -> "Foo":
        unpacker = Unpacker(xdr)
        return cls.unpack(unpacker)

    def to_xdr(self) -> str:
        xdr_bytes = self.to_xdr_bytes()
        return base64.b64encode(xdr_bytes).decode()

    @classmethod
    def from_xdr(cls, xdr: str) -> "Foo":
        xdr_bytes = base64.b64decode(xdr.encode())
        return cls.from_xdr_bytes(xdr_bytes)

    def __eq__(self, other: object):
        if not isinstance(other, self.__class__):
            return NotImplemented
        return self.foo == other.foo

    def __str__(self):
        return f"<Foo [foo={self.foo}]>"
