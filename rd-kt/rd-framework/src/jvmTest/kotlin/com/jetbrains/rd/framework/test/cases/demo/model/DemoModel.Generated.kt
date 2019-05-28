@file:Suppress("EXPERIMENTAL_API_USAGE","PackageDirectoryMismatch","UnusedImport","unused","LocalVariableName","CanBeVal","PropertyName","EnumEntryName","ClassName","ObjectPropertyName")
package demo

import com.jetbrains.rd.framework.*
import com.jetbrains.rd.framework.base.*
import com.jetbrains.rd.framework.impl.*

import com.jetbrains.rd.util.lifetime.*
import com.jetbrains.rd.util.reactive.*
import com.jetbrains.rd.util.string.*
import com.jetbrains.rd.util.*
import kotlin.reflect.KClass



class DemoModel private constructor(
    private val _boolean_property: RdOptionalProperty<Boolean>,
    private val _boolean_array: RdOptionalProperty<BooleanArray>,
    private val _scalar: RdOptionalProperty<MyScalar>,
    private val _ubyte: RdOptionalProperty<UByte>,
    private val _ubyte_array: RdOptionalProperty<UByteArray>,
    private val _list: RdList<Int>,
    private val _set: RdSet<Int>,
    private val _mapLongToString: RdMap<Long, String>,
    private val _call: RdEndpoint<Char, String>,
    private val _callback: RdCall<String, Int>,
    private val _interned_string: RdOptionalProperty<String>,
    private val _polymorphic: RdOptionalProperty<Base>,
    private val _enum: RdOptionalProperty<MyEnum>
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers) {
            serializers.register(MyEnum.marshaller)
            serializers.register(MyScalar)
            serializers.register(Derived)
            serializers.register(Base_Unknown)
        }
        
        
        fun create(lifetime: Lifetime, protocol: IProtocol): DemoModel {
            DemoRoot.register(protocol.serializers)
            
            return DemoModel().apply {
                identify(protocol.identity, RdId.Null.mix("DemoModel"))
                bind(lifetime, protocol, "DemoModel")
            }
        }
        
        private val __StringInternedAtProtocolSerializer = FrameworkMarshallers.String.interned("Protocol")
        
        const val serializationHash = -6563454397007024222L
        
        const val const_toplevel = true
    }
    override val serializersOwner: ISerializersOwner get() = DemoModel
    override val serializationHash: Long get() = DemoModel.serializationHash
    
    //fields
    val boolean_property: IOptProperty<Boolean> get() = _boolean_property
    val boolean_array: IOptProperty<BooleanArray> get() = _boolean_array
    val scalar: IOptProperty<MyScalar> get() = _scalar
    val ubyte: IOptProperty<UByte> get() = _ubyte
    val ubyte_array: IOptProperty<UByteArray> get() = _ubyte_array
    val list: IMutableViewableList<Int> get() = _list
    val set: IMutableViewableSet<Int> get() = _set
    val mapLongToString: IMutableViewableMap<Long, String> get() = _mapLongToString
    val call: RdEndpoint<Char, String> get() = _call
    val callback: IRdCall<String, Int> get() = _callback
    val interned_string: IOptProperty<String> get() = _interned_string
    val polymorphic: IOptProperty<Base> get() = _polymorphic
    val enum: IOptProperty<MyEnum> get() = _enum
    //initializer
    init {
        _boolean_property.optimizeNested = true
        _boolean_array.optimizeNested = true
        _scalar.optimizeNested = true
        _ubyte.optimizeNested = true
        _ubyte_array.optimizeNested = true
        _list.optimizeNested = true
        _set.optimizeNested = true
        _mapLongToString.optimizeNested = true
        _interned_string.optimizeNested = true
        _polymorphic.optimizeNested = true
        _enum.optimizeNested = true
    }
    
    init {
        _mapLongToString.master = false
    }
    
    init {
        bindableChildren.add("boolean_property" to _boolean_property)
        bindableChildren.add("boolean_array" to _boolean_array)
        bindableChildren.add("scalar" to _scalar)
        bindableChildren.add("ubyte" to _ubyte)
        bindableChildren.add("ubyte_array" to _ubyte_array)
        bindableChildren.add("list" to _list)
        bindableChildren.add("set" to _set)
        bindableChildren.add("mapLongToString" to _mapLongToString)
        bindableChildren.add("call" to _call)
        bindableChildren.add("callback" to _callback)
        bindableChildren.add("interned_string" to _interned_string)
        bindableChildren.add("polymorphic" to _polymorphic)
        bindableChildren.add("enum" to _enum)
    }
    
    //secondary constructor
    private constructor(
    ) : this(
        RdOptionalProperty<Boolean>(FrameworkMarshallers.Bool),
        RdOptionalProperty<BooleanArray>(FrameworkMarshallers.BooleanArray),
        RdOptionalProperty<MyScalar>(MyScalar),
        RdOptionalProperty<UByte>(FrameworkMarshallers.UByte),
        RdOptionalProperty<UByteArray>(FrameworkMarshallers.UByteArray),
        RdList<Int>(FrameworkMarshallers.Int),
        RdSet<Int>(FrameworkMarshallers.Int),
        RdMap<Long, String>(FrameworkMarshallers.Long, FrameworkMarshallers.String),
        RdEndpoint<Char, String>(FrameworkMarshallers.Char, FrameworkMarshallers.String),
        RdCall<String, Int>(FrameworkMarshallers.String, FrameworkMarshallers.Int),
        RdOptionalProperty<String>(__StringInternedAtProtocolSerializer),
        RdOptionalProperty<Base>(AbstractPolymorphic(Base)),
        RdOptionalProperty<MyEnum>(MyEnum.marshaller)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter) {
        printer.println("DemoModel (")
        printer.indent {
            print("boolean_property = "); _boolean_property.print(printer); println()
            print("boolean_array = "); _boolean_array.print(printer); println()
            print("scalar = "); _scalar.print(printer); println()
            print("ubyte = "); _ubyte.print(printer); println()
            print("ubyte_array = "); _ubyte_array.print(printer); println()
            print("list = "); _list.print(printer); println()
            print("set = "); _set.print(printer); println()
            print("mapLongToString = "); _mapLongToString.print(printer); println()
            print("call = "); _call.print(printer); println()
            print("callback = "); _callback.print(printer); println()
            print("interned_string = "); _interned_string.print(printer); println()
            print("polymorphic = "); _polymorphic.print(printer); println()
            print("enum = "); _enum.print(printer); println()
        }
        printer.print(")")
    }
}


abstract class Base (
) : IPrintable {
    //companion
    
    companion object : IAbstractDeclaration<Base> {
        override fun readUnknownInstance(ctx: SerializationCtx, buffer: AbstractBuffer, unknownId: RdId, size: Int): Base {
            val objectStartPosition = buffer.position
            val unknownBytes = ByteArray(objectStartPosition + size - buffer.position)
            buffer.readByteArrayRaw(unknownBytes)
            return Base_Unknown(unknownId, unknownBytes)
        }
        
        
        const val const_base = 'B'
    }
    //fields
    //initializer
    //secondary constructor
    //equals trait
    //hash code trait
    //pretty print
}


class Base_Unknown (
    override val unknownId: RdId,
    val unknownBytes: ByteArray
) : Base (
), IUnknownInstance {
    //companion
    
    companion object : IMarshaller<Base_Unknown> {
        override val _type: KClass<Base_Unknown> = Base_Unknown::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): Base_Unknown {
            throw NotImplementedError("Unknown instances should not be read via serializer")
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: Base_Unknown) {
            buffer.writeByteArrayRaw(value.unknownBytes)
        }
        
        
    }
    //fields
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as Base_Unknown
        
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int {
        var __r = 0
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter) {
        printer.println("Base_Unknown (")
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
}


class Derived (
    val string: String
) : Base (
) {
    //companion
    
    companion object : IMarshaller<Derived> {
        override val _type: KClass<Derived> = Derived::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): Derived {
            val string = buffer.readString()
            return Derived(string)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: Derived) {
            buffer.writeString(value.string)
        }
        
        
    }
    //fields
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as Derived
        
        if (string != other.string) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int {
        var __r = 0
        __r = __r*31 + string.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter) {
        printer.println("Derived (")
        printer.indent {
            print("string = "); string.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
}


enum class MyEnum {
    default,
    kt,
    net,
    cpp;
    
    companion object { val marshaller = FrameworkMarshallers.enum<MyEnum>() }
}


data class MyScalar (
    val bool: Boolean,
    val byte: Byte,
    val short: Short,
    val int: Int,
    val long: Long,
    val float: Float,
    val double: Double,
    val unsigned_byte: UByte,
    val unsigned_short: UShort,
    val unsigned_int: UInt,
    val unsigned_long: ULong,
    val enum: MyEnum
) : IPrintable {
    //companion
    
    companion object : IMarshaller<MyScalar> {
        override val _type: KClass<MyScalar> = MyScalar::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): MyScalar {
            val bool = buffer.readBool()
            val byte = buffer.readByte()
            val short = buffer.readShort()
            val int = buffer.readInt()
            val long = buffer.readLong()
            val float = buffer.readFloat()
            val double = buffer.readDouble()
            val unsigned_byte = buffer.readUByte()
            val unsigned_short = buffer.readUShort()
            val unsigned_int = buffer.readUInt()
            val unsigned_long = buffer.readULong()
            val enum = buffer.readEnum<MyEnum>()
            return MyScalar(bool, byte, short, int, long, float, double, unsigned_byte, unsigned_short, unsigned_int, unsigned_long, enum)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: MyScalar) {
            buffer.writeBool(value.bool)
            buffer.writeByte(value.byte)
            buffer.writeShort(value.short)
            buffer.writeInt(value.int)
            buffer.writeLong(value.long)
            buffer.writeFloat(value.float)
            buffer.writeDouble(value.double)
            buffer.writeUByte(value.unsigned_byte)
            buffer.writeUShort(value.unsigned_short)
            buffer.writeUInt(value.unsigned_int)
            buffer.writeULong(value.unsigned_long)
            buffer.writeEnum(value.enum)
        }
        
        
        const val const_int = 0
        const val const_string = "const_string_value"
        val const_enum = MyEnum.default
    }
    //fields
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as MyScalar
        
        if (bool != other.bool) return false
        if (byte != other.byte) return false
        if (short != other.short) return false
        if (int != other.int) return false
        if (long != other.long) return false
        if (float != other.float) return false
        if (double != other.double) return false
        if (unsigned_byte != other.unsigned_byte) return false
        if (unsigned_short != other.unsigned_short) return false
        if (unsigned_int != other.unsigned_int) return false
        if (unsigned_long != other.unsigned_long) return false
        if (enum != other.enum) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int {
        var __r = 0
        __r = __r*31 + bool.hashCode()
        __r = __r*31 + byte.hashCode()
        __r = __r*31 + short.hashCode()
        __r = __r*31 + int.hashCode()
        __r = __r*31 + long.hashCode()
        __r = __r*31 + float.hashCode()
        __r = __r*31 + double.hashCode()
        __r = __r*31 + unsigned_byte.hashCode()
        __r = __r*31 + unsigned_short.hashCode()
        __r = __r*31 + unsigned_int.hashCode()
        __r = __r*31 + unsigned_long.hashCode()
        __r = __r*31 + enum.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter) {
        printer.println("MyScalar (")
        printer.indent {
            print("bool = "); bool.print(printer); println()
            print("byte = "); byte.print(printer); println()
            print("short = "); short.print(printer); println()
            print("int = "); int.print(printer); println()
            print("long = "); long.print(printer); println()
            print("float = "); float.print(printer); println()
            print("double = "); double.print(printer); println()
            print("unsigned_byte = "); unsigned_byte.print(printer); println()
            print("unsigned_short = "); unsigned_short.print(printer); println()
            print("unsigned_int = "); unsigned_int.print(printer); println()
            print("unsigned_long = "); unsigned_long.print(printer); println()
            print("enum = "); enum.print(printer); println()
        }
        printer.print(")")
    }
}
