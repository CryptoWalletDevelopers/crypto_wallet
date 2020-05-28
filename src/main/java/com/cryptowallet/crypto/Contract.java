package com.cryptowallet.crypto;

public final class Contract {
    private Contract() {}
    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }
    /**
     * Protobuf enum {@code protocol.ResourceCode}
     */
    public enum ResourceCode
            implements com.google.protobuf.ProtocolMessageEnum {
        /**
         * <code>BANDWIDTH = 0;</code>
         */
        BANDWIDTH(0),
        /**
         * <code>ENERGY = 1;</code>
         */
        ENERGY(1),
        UNRECOGNIZED(-1),
        ;

        /**
         * <code>BANDWIDTH = 0;</code>
         */
        public static final int BANDWIDTH_VALUE = 0;
        /**
         * <code>ENERGY = 1;</code>
         */
        public static final int ENERGY_VALUE = 1;


        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new java.lang.IllegalArgumentException(
                        "Can't get the number of an unknown enum value.");
            }
            return value;
        }

        /**
         * @deprecated Use {@link #forNumber(int)} instead.
         */
        @java.lang.Deprecated
        public static ResourceCode valueOf(int value) {
            return forNumber(value);
        }

        public static ResourceCode forNumber(int value) {
            switch (value) {
                case 0: return BANDWIDTH;
                case 1: return ENERGY;
                default: return null;
            }
        }

        public static com.google.protobuf.Internal.EnumLiteMap<ResourceCode>
        internalGetValueMap() {
            return internalValueMap;
        }
        private static final com.google.protobuf.Internal.EnumLiteMap<
                ResourceCode> internalValueMap =
                new com.google.protobuf.Internal.EnumLiteMap<ResourceCode>() {
                    public ResourceCode findValueByNumber(int number) {
                        return ResourceCode.forNumber(number);
                    }
                };

        public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }
        public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
            return getDescriptor();
        }
        public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.getDescriptor().getEnumTypes().get(0);
        }

        private static final ResourceCode[] VALUES = values();

        public static ResourceCode valueOf(
                com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new java.lang.IllegalArgumentException(
                        "EnumValueDescriptor is not for this type.");
            }
            if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[desc.getIndex()];
        }

        private final int value;

        private ResourceCode(int value) {
            this.value = value;
        }

        // @@protoc_insertion_point(enum_scope:protocol.ResourceCode)
    }

    public interface AccountCreateContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.AccountCreateContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>bytes account_address = 2;</code>
         */
        com.google.protobuf.ByteString getAccountAddress();

        /**
         * <code>.protocol.AccountType type = 3;</code>
         */
        int getTypeValue();
        /**
         * <code>.protocol.AccountType type = 3;</code>
         */
        com.cryptowallet.crypto.Protocol.AccountType getType();
    }
    /**
     * Protobuf type {@code protocol.AccountCreateContract}
     */
    public  static final class AccountCreateContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.AccountCreateContract)
            AccountCreateContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use AccountCreateContract.newBuilder() to construct.
        private AccountCreateContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private AccountCreateContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            accountAddress_ = com.google.protobuf.ByteString.EMPTY;
            type_ = 0;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private AccountCreateContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 18: {

                            accountAddress_ = input.readBytes();
                            break;
                        }
                        case 24: {
                            int rawValue = input.readEnum();

                            type_ = rawValue;
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_AccountCreateContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_AccountCreateContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.AccountCreateContract.class, com.cryptowallet.crypto.Contract.AccountCreateContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int ACCOUNT_ADDRESS_FIELD_NUMBER = 2;
        private com.google.protobuf.ByteString accountAddress_;
        /**
         * <code>bytes account_address = 2;</code>
         */
        public com.google.protobuf.ByteString getAccountAddress() {
            return accountAddress_;
        }

        public static final int TYPE_FIELD_NUMBER = 3;
        private int type_;
        /**
         * <code>.protocol.AccountType type = 3;</code>
         */
        public int getTypeValue() {
            return type_;
        }
        /**
         * <code>.protocol.AccountType type = 3;</code>
         */
        public com.cryptowallet.crypto.Protocol.AccountType getType() {
            com.cryptowallet.crypto.Protocol.AccountType result = com.cryptowallet.crypto.Protocol.AccountType.valueOf(type_);
            return result == null ? com.cryptowallet.crypto.Protocol.AccountType.UNRECOGNIZED : result;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (!accountAddress_.isEmpty()) {
                output.writeBytes(2, accountAddress_);
            }
            if (type_ != com.cryptowallet.crypto.Protocol.AccountType.Normal.getNumber()) {
                output.writeEnum(3, type_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (!accountAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(2, accountAddress_);
            }
            if (type_ != com.cryptowallet.crypto.Protocol.AccountType.Normal.getNumber()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeEnumSize(3, type_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.AccountCreateContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.AccountCreateContract other = (com.cryptowallet.crypto.Contract.AccountCreateContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && getAccountAddress()
                    .equals(other.getAccountAddress());
            result = result && type_ == other.type_;
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + ACCOUNT_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getAccountAddress().hashCode();
            hash = (37 * hash) + TYPE_FIELD_NUMBER;
            hash = (53 * hash) + type_;
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.AccountCreateContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.AccountCreateContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AccountCreateContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.AccountCreateContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AccountCreateContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.AccountCreateContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AccountCreateContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.AccountCreateContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AccountCreateContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.AccountCreateContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AccountCreateContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.AccountCreateContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.AccountCreateContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.AccountCreateContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.AccountCreateContract)
                com.cryptowallet.crypto.Contract.AccountCreateContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_AccountCreateContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_AccountCreateContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.AccountCreateContract.class, com.cryptowallet.crypto.Contract.AccountCreateContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.AccountCreateContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                accountAddress_ = com.google.protobuf.ByteString.EMPTY;

                type_ = 0;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_AccountCreateContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.AccountCreateContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.AccountCreateContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.AccountCreateContract build() {
                com.cryptowallet.crypto.Contract.AccountCreateContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.AccountCreateContract buildPartial() {
                com.cryptowallet.crypto.Contract.AccountCreateContract result = new com.cryptowallet.crypto.Contract.AccountCreateContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.accountAddress_ = accountAddress_;
                result.type_ = type_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.AccountCreateContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.AccountCreateContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.AccountCreateContract other) {
                if (other == com.cryptowallet.crypto.Contract.AccountCreateContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getAccountAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setAccountAddress(other.getAccountAddress());
                }
                if (other.type_ != 0) {
                    setTypeValue(other.getTypeValue());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.AccountCreateContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.AccountCreateContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString accountAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes account_address = 2;</code>
             */
            public com.google.protobuf.ByteString getAccountAddress() {
                return accountAddress_;
            }
            /**
             * <code>bytes account_address = 2;</code>
             */
            public Builder setAccountAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                accountAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes account_address = 2;</code>
             */
            public Builder clearAccountAddress() {

                accountAddress_ = getDefaultInstance().getAccountAddress();
                onChanged();
                return this;
            }

            private int type_ = 0;
            /**
             * <code>.protocol.AccountType type = 3;</code>
             */
            public int getTypeValue() {
                return type_;
            }
            /**
             * <code>.protocol.AccountType type = 3;</code>
             */
            public Builder setTypeValue(int value) {
                type_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>.protocol.AccountType type = 3;</code>
             */
            public com.cryptowallet.crypto.Protocol.AccountType getType() {
                com.cryptowallet.crypto.Protocol.AccountType result = com.cryptowallet.crypto.Protocol.AccountType.valueOf(type_);
                return result == null ? com.cryptowallet.crypto.Protocol.AccountType.UNRECOGNIZED : result;
            }
            /**
             * <code>.protocol.AccountType type = 3;</code>
             */
            public Builder setType(com.cryptowallet.crypto.Protocol.AccountType value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                type_ = value.getNumber();
                onChanged();
                return this;
            }
            /**
             * <code>.protocol.AccountType type = 3;</code>
             */
            public Builder clearType() {

                type_ = 0;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.AccountCreateContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.AccountCreateContract)
        private static final com.cryptowallet.crypto.Contract.AccountCreateContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.AccountCreateContract();
        }

        public static com.cryptowallet.crypto.Contract.AccountCreateContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<AccountCreateContract>
                PARSER = new com.google.protobuf.AbstractParser<AccountCreateContract>() {
            public AccountCreateContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new AccountCreateContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<AccountCreateContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<AccountCreateContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.AccountCreateContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface AccountUpdateContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.AccountUpdateContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes account_name = 1;</code>
         */
        com.google.protobuf.ByteString getAccountName();

        /**
         * <code>bytes owner_address = 2;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();
    }
    /**
     * <pre>
     * Update account name. Account name is not unique now.
     * </pre>
     *
     * Protobuf type {@code protocol.AccountUpdateContract}
     */
    public  static final class AccountUpdateContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.AccountUpdateContract)
            AccountUpdateContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use AccountUpdateContract.newBuilder() to construct.
        private AccountUpdateContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private AccountUpdateContract() {
            accountName_ = com.google.protobuf.ByteString.EMPTY;
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private AccountUpdateContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            accountName_ = input.readBytes();
                            break;
                        }
                        case 18: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_AccountUpdateContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_AccountUpdateContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.AccountUpdateContract.class, com.cryptowallet.crypto.Contract.AccountUpdateContract.Builder.class);
        }

        public static final int ACCOUNT_NAME_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString accountName_;
        /**
         * <code>bytes account_name = 1;</code>
         */
        public com.google.protobuf.ByteString getAccountName() {
            return accountName_;
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 2;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 2;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!accountName_.isEmpty()) {
                output.writeBytes(1, accountName_);
            }
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(2, ownerAddress_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!accountName_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, accountName_);
            }
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(2, ownerAddress_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.AccountUpdateContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.AccountUpdateContract other = (com.cryptowallet.crypto.Contract.AccountUpdateContract) obj;

            boolean result = true;
            result = result && getAccountName()
                    .equals(other.getAccountName());
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + ACCOUNT_NAME_FIELD_NUMBER;
            hash = (53 * hash) + getAccountName().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.AccountUpdateContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.AccountUpdateContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AccountUpdateContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.AccountUpdateContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AccountUpdateContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.AccountUpdateContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AccountUpdateContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.AccountUpdateContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AccountUpdateContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.AccountUpdateContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AccountUpdateContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.AccountUpdateContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.AccountUpdateContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * <pre>
         * Update account name. Account name is not unique now.
         * </pre>
         *
         * Protobuf type {@code protocol.AccountUpdateContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.AccountUpdateContract)
                com.cryptowallet.crypto.Contract.AccountUpdateContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_AccountUpdateContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_AccountUpdateContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.AccountUpdateContract.class, com.cryptowallet.crypto.Contract.AccountUpdateContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.AccountUpdateContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                accountName_ = com.google.protobuf.ByteString.EMPTY;

                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_AccountUpdateContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.AccountUpdateContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.AccountUpdateContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.AccountUpdateContract build() {
                com.cryptowallet.crypto.Contract.AccountUpdateContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.AccountUpdateContract buildPartial() {
                com.cryptowallet.crypto.Contract.AccountUpdateContract result = new com.cryptowallet.crypto.Contract.AccountUpdateContract(this);
                result.accountName_ = accountName_;
                result.ownerAddress_ = ownerAddress_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.AccountUpdateContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.AccountUpdateContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.AccountUpdateContract other) {
                if (other == com.cryptowallet.crypto.Contract.AccountUpdateContract.getDefaultInstance()) return this;
                if (other.getAccountName() != com.google.protobuf.ByteString.EMPTY) {
                    setAccountName(other.getAccountName());
                }
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.AccountUpdateContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.AccountUpdateContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString accountName_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes account_name = 1;</code>
             */
            public com.google.protobuf.ByteString getAccountName() {
                return accountName_;
            }
            /**
             * <code>bytes account_name = 1;</code>
             */
            public Builder setAccountName(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                accountName_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes account_name = 1;</code>
             */
            public Builder clearAccountName() {

                accountName_ = getDefaultInstance().getAccountName();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 2;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 2;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 2;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.AccountUpdateContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.AccountUpdateContract)
        private static final com.cryptowallet.crypto.Contract.AccountUpdateContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.AccountUpdateContract();
        }

        public static com.cryptowallet.crypto.Contract.AccountUpdateContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<AccountUpdateContract>
                PARSER = new com.google.protobuf.AbstractParser<AccountUpdateContract>() {
            public AccountUpdateContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new AccountUpdateContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<AccountUpdateContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<AccountUpdateContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.AccountUpdateContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface SetAccountIdContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.SetAccountIdContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes account_id = 1;</code>
         */
        com.google.protobuf.ByteString getAccountId();

        /**
         * <code>bytes owner_address = 2;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();
    }
    /**
     * <pre>
     * Set account id if the account has no id. Account id is unique and case insensitive.
     * </pre>
     *
     * Protobuf type {@code protocol.SetAccountIdContract}
     */
    public  static final class SetAccountIdContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.SetAccountIdContract)
            SetAccountIdContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use SetAccountIdContract.newBuilder() to construct.
        private SetAccountIdContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private SetAccountIdContract() {
            accountId_ = com.google.protobuf.ByteString.EMPTY;
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private SetAccountIdContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            accountId_ = input.readBytes();
                            break;
                        }
                        case 18: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_SetAccountIdContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_SetAccountIdContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.SetAccountIdContract.class, com.cryptowallet.crypto.Contract.SetAccountIdContract.Builder.class);
        }

        public static final int ACCOUNT_ID_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString accountId_;
        /**
         * <code>bytes account_id = 1;</code>
         */
        public com.google.protobuf.ByteString getAccountId() {
            return accountId_;
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 2;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 2;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!accountId_.isEmpty()) {
                output.writeBytes(1, accountId_);
            }
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(2, ownerAddress_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!accountId_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, accountId_);
            }
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(2, ownerAddress_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.SetAccountIdContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.SetAccountIdContract other = (com.cryptowallet.crypto.Contract.SetAccountIdContract) obj;

            boolean result = true;
            result = result && getAccountId()
                    .equals(other.getAccountId());
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + ACCOUNT_ID_FIELD_NUMBER;
            hash = (53 * hash) + getAccountId().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.SetAccountIdContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.SetAccountIdContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.SetAccountIdContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.SetAccountIdContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.SetAccountIdContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.SetAccountIdContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.SetAccountIdContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.SetAccountIdContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.SetAccountIdContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.SetAccountIdContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.SetAccountIdContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.SetAccountIdContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.SetAccountIdContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * <pre>
         * Set account id if the account has no id. Account id is unique and case insensitive.
         * </pre>
         *
         * Protobuf type {@code protocol.SetAccountIdContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.SetAccountIdContract)
                com.cryptowallet.crypto.Contract.SetAccountIdContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_SetAccountIdContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_SetAccountIdContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.SetAccountIdContract.class, com.cryptowallet.crypto.Contract.SetAccountIdContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.SetAccountIdContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                accountId_ = com.google.protobuf.ByteString.EMPTY;

                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_SetAccountIdContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.SetAccountIdContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.SetAccountIdContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.SetAccountIdContract build() {
                com.cryptowallet.crypto.Contract.SetAccountIdContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.SetAccountIdContract buildPartial() {
                com.cryptowallet.crypto.Contract.SetAccountIdContract result = new com.cryptowallet.crypto.Contract.SetAccountIdContract(this);
                result.accountId_ = accountId_;
                result.ownerAddress_ = ownerAddress_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.SetAccountIdContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.SetAccountIdContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.SetAccountIdContract other) {
                if (other == com.cryptowallet.crypto.Contract.SetAccountIdContract.getDefaultInstance()) return this;
                if (other.getAccountId() != com.google.protobuf.ByteString.EMPTY) {
                    setAccountId(other.getAccountId());
                }
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.SetAccountIdContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.SetAccountIdContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString accountId_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes account_id = 1;</code>
             */
            public com.google.protobuf.ByteString getAccountId() {
                return accountId_;
            }
            /**
             * <code>bytes account_id = 1;</code>
             */
            public Builder setAccountId(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                accountId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes account_id = 1;</code>
             */
            public Builder clearAccountId() {

                accountId_ = getDefaultInstance().getAccountId();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 2;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 2;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 2;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.SetAccountIdContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.SetAccountIdContract)
        private static final com.cryptowallet.crypto.Contract.SetAccountIdContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.SetAccountIdContract();
        }

        public static com.cryptowallet.crypto.Contract.SetAccountIdContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<SetAccountIdContract>
                PARSER = new com.google.protobuf.AbstractParser<SetAccountIdContract>() {
            public SetAccountIdContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new SetAccountIdContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<SetAccountIdContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<SetAccountIdContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.SetAccountIdContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface TransferContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.TransferContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>bytes to_address = 2;</code>
         */
        com.google.protobuf.ByteString getToAddress();

        /**
         * <code>int64 amount = 3;</code>
         */
        long getAmount();
    }
    /**
     * Protobuf type {@code protocol.TransferContract}
     */
    public  static final class TransferContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.TransferContract)
            TransferContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use TransferContract.newBuilder() to construct.
        private TransferContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private TransferContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            toAddress_ = com.google.protobuf.ByteString.EMPTY;
            amount_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private TransferContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 18: {

                            toAddress_ = input.readBytes();
                            break;
                        }
                        case 24: {

                            amount_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_TransferContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_TransferContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.TransferContract.class, com.cryptowallet.crypto.Contract.TransferContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int TO_ADDRESS_FIELD_NUMBER = 2;
        private com.google.protobuf.ByteString toAddress_;
        /**
         * <code>bytes to_address = 2;</code>
         */
        public com.google.protobuf.ByteString getToAddress() {
            return toAddress_;
        }

        public static final int AMOUNT_FIELD_NUMBER = 3;
        private long amount_;
        /**
         * <code>int64 amount = 3;</code>
         */
        public long getAmount() {
            return amount_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (!toAddress_.isEmpty()) {
                output.writeBytes(2, toAddress_);
            }
            if (amount_ != 0L) {
                output.writeInt64(3, amount_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (!toAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(2, toAddress_);
            }
            if (amount_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(3, amount_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.TransferContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.TransferContract other = (com.cryptowallet.crypto.Contract.TransferContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && getToAddress()
                    .equals(other.getToAddress());
            result = result && (getAmount()
                    == other.getAmount());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + TO_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getToAddress().hashCode();
            hash = (37 * hash) + AMOUNT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getAmount());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.TransferContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.TransferContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TransferContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.TransferContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TransferContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.TransferContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TransferContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.TransferContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TransferContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.TransferContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TransferContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.TransferContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.TransferContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.TransferContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.TransferContract)
                com.cryptowallet.crypto.Contract.TransferContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_TransferContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_TransferContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.TransferContract.class, com.cryptowallet.crypto.Contract.TransferContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.TransferContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                toAddress_ = com.google.protobuf.ByteString.EMPTY;

                amount_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_TransferContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.TransferContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.TransferContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.TransferContract build() {
                com.cryptowallet.crypto.Contract.TransferContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.TransferContract buildPartial() {
                com.cryptowallet.crypto.Contract.TransferContract result = new com.cryptowallet.crypto.Contract.TransferContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.toAddress_ = toAddress_;
                result.amount_ = amount_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.TransferContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.TransferContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.TransferContract other) {
                if (other == com.cryptowallet.crypto.Contract.TransferContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getToAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setToAddress(other.getToAddress());
                }
                if (other.getAmount() != 0L) {
                    setAmount(other.getAmount());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.TransferContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.TransferContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString toAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes to_address = 2;</code>
             */
            public com.google.protobuf.ByteString getToAddress() {
                return toAddress_;
            }
            /**
             * <code>bytes to_address = 2;</code>
             */
            public Builder setToAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                toAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes to_address = 2;</code>
             */
            public Builder clearToAddress() {

                toAddress_ = getDefaultInstance().getToAddress();
                onChanged();
                return this;
            }

            private long amount_ ;
            /**
             * <code>int64 amount = 3;</code>
             */
            public long getAmount() {
                return amount_;
            }
            /**
             * <code>int64 amount = 3;</code>
             */
            public Builder setAmount(long value) {

                amount_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 amount = 3;</code>
             */
            public Builder clearAmount() {

                amount_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.TransferContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.TransferContract)
        private static final com.cryptowallet.crypto.Contract.TransferContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.TransferContract();
        }

        public static com.cryptowallet.crypto.Contract.TransferContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<TransferContract>
                PARSER = new com.google.protobuf.AbstractParser<TransferContract>() {
            public TransferContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new TransferContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<TransferContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<TransferContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.TransferContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface TransferAssetContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.TransferAssetContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes asset_name = 1;</code>
         */
        com.google.protobuf.ByteString getAssetName();

        /**
         * <code>bytes owner_address = 2;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>bytes to_address = 3;</code>
         */
        com.google.protobuf.ByteString getToAddress();

        /**
         * <code>int64 amount = 4;</code>
         */
        long getAmount();
    }
    /**
     * Protobuf type {@code protocol.TransferAssetContract}
     */
    public  static final class TransferAssetContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.TransferAssetContract)
            TransferAssetContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use TransferAssetContract.newBuilder() to construct.
        private TransferAssetContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private TransferAssetContract() {
            assetName_ = com.google.protobuf.ByteString.EMPTY;
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            toAddress_ = com.google.protobuf.ByteString.EMPTY;
            amount_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private TransferAssetContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            assetName_ = input.readBytes();
                            break;
                        }
                        case 18: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 26: {

                            toAddress_ = input.readBytes();
                            break;
                        }
                        case 32: {

                            amount_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_TransferAssetContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_TransferAssetContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.TransferAssetContract.class, com.cryptowallet.crypto.Contract.TransferAssetContract.Builder.class);
        }

        public static final int ASSET_NAME_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString assetName_;
        /**
         * <code>bytes asset_name = 1;</code>
         */
        public com.google.protobuf.ByteString getAssetName() {
            return assetName_;
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 2;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 2;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int TO_ADDRESS_FIELD_NUMBER = 3;
        private com.google.protobuf.ByteString toAddress_;
        /**
         * <code>bytes to_address = 3;</code>
         */
        public com.google.protobuf.ByteString getToAddress() {
            return toAddress_;
        }

        public static final int AMOUNT_FIELD_NUMBER = 4;
        private long amount_;
        /**
         * <code>int64 amount = 4;</code>
         */
        public long getAmount() {
            return amount_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!assetName_.isEmpty()) {
                output.writeBytes(1, assetName_);
            }
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(2, ownerAddress_);
            }
            if (!toAddress_.isEmpty()) {
                output.writeBytes(3, toAddress_);
            }
            if (amount_ != 0L) {
                output.writeInt64(4, amount_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!assetName_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, assetName_);
            }
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(2, ownerAddress_);
            }
            if (!toAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(3, toAddress_);
            }
            if (amount_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(4, amount_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.TransferAssetContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.TransferAssetContract other = (com.cryptowallet.crypto.Contract.TransferAssetContract) obj;

            boolean result = true;
            result = result && getAssetName()
                    .equals(other.getAssetName());
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && getToAddress()
                    .equals(other.getToAddress());
            result = result && (getAmount()
                    == other.getAmount());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + ASSET_NAME_FIELD_NUMBER;
            hash = (53 * hash) + getAssetName().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + TO_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getToAddress().hashCode();
            hash = (37 * hash) + AMOUNT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getAmount());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.TransferAssetContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.TransferAssetContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TransferAssetContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.TransferAssetContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TransferAssetContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.TransferAssetContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TransferAssetContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.TransferAssetContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TransferAssetContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.TransferAssetContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TransferAssetContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.TransferAssetContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.TransferAssetContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.TransferAssetContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.TransferAssetContract)
                com.cryptowallet.crypto.Contract.TransferAssetContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_TransferAssetContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_TransferAssetContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.TransferAssetContract.class, com.cryptowallet.crypto.Contract.TransferAssetContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.TransferAssetContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                assetName_ = com.google.protobuf.ByteString.EMPTY;

                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                toAddress_ = com.google.protobuf.ByteString.EMPTY;

                amount_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_TransferAssetContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.TransferAssetContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.TransferAssetContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.TransferAssetContract build() {
                com.cryptowallet.crypto.Contract.TransferAssetContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.TransferAssetContract buildPartial() {
                com.cryptowallet.crypto.Contract.TransferAssetContract result = new com.cryptowallet.crypto.Contract.TransferAssetContract(this);
                result.assetName_ = assetName_;
                result.ownerAddress_ = ownerAddress_;
                result.toAddress_ = toAddress_;
                result.amount_ = amount_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.TransferAssetContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.TransferAssetContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.TransferAssetContract other) {
                if (other == com.cryptowallet.crypto.Contract.TransferAssetContract.getDefaultInstance()) return this;
                if (other.getAssetName() != com.google.protobuf.ByteString.EMPTY) {
                    setAssetName(other.getAssetName());
                }
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getToAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setToAddress(other.getToAddress());
                }
                if (other.getAmount() != 0L) {
                    setAmount(other.getAmount());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.TransferAssetContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.TransferAssetContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString assetName_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes asset_name = 1;</code>
             */
            public com.google.protobuf.ByteString getAssetName() {
                return assetName_;
            }
            /**
             * <code>bytes asset_name = 1;</code>
             */
            public Builder setAssetName(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                assetName_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes asset_name = 1;</code>
             */
            public Builder clearAssetName() {

                assetName_ = getDefaultInstance().getAssetName();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 2;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 2;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 2;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString toAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes to_address = 3;</code>
             */
            public com.google.protobuf.ByteString getToAddress() {
                return toAddress_;
            }
            /**
             * <code>bytes to_address = 3;</code>
             */
            public Builder setToAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                toAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes to_address = 3;</code>
             */
            public Builder clearToAddress() {

                toAddress_ = getDefaultInstance().getToAddress();
                onChanged();
                return this;
            }

            private long amount_ ;
            /**
             * <code>int64 amount = 4;</code>
             */
            public long getAmount() {
                return amount_;
            }
            /**
             * <code>int64 amount = 4;</code>
             */
            public Builder setAmount(long value) {

                amount_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 amount = 4;</code>
             */
            public Builder clearAmount() {

                amount_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.TransferAssetContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.TransferAssetContract)
        private static final com.cryptowallet.crypto.Contract.TransferAssetContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.TransferAssetContract();
        }

        public static com.cryptowallet.crypto.Contract.TransferAssetContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<TransferAssetContract>
                PARSER = new com.google.protobuf.AbstractParser<TransferAssetContract>() {
            public TransferAssetContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new TransferAssetContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<TransferAssetContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<TransferAssetContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.TransferAssetContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface VoteAssetContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.VoteAssetContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>repeated bytes vote_address = 2;</code>
         */
        java.util.List<com.google.protobuf.ByteString> getVoteAddressList();
        /**
         * <code>repeated bytes vote_address = 2;</code>
         */
        int getVoteAddressCount();
        /**
         * <code>repeated bytes vote_address = 2;</code>
         */
        com.google.protobuf.ByteString getVoteAddress(int index);

        /**
         * <code>bool support = 3;</code>
         */
        boolean getSupport();

        /**
         * <code>int32 count = 5;</code>
         */
        int getCount();
    }
    /**
     * Protobuf type {@code protocol.VoteAssetContract}
     */
    public  static final class VoteAssetContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.VoteAssetContract)
            VoteAssetContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use VoteAssetContract.newBuilder() to construct.
        private VoteAssetContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private VoteAssetContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            voteAddress_ = java.util.Collections.emptyList();
            support_ = false;
            count_ = 0;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private VoteAssetContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 18: {
                            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                                voteAddress_ = new java.util.ArrayList<com.google.protobuf.ByteString>();
                                mutable_bitField0_ |= 0x00000002;
                            }
                            voteAddress_.add(input.readBytes());
                            break;
                        }
                        case 24: {

                            support_ = input.readBool();
                            break;
                        }
                        case 40: {

                            count_ = input.readInt32();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                    voteAddress_ = java.util.Collections.unmodifiableList(voteAddress_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteAssetContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteAssetContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.VoteAssetContract.class, com.cryptowallet.crypto.Contract.VoteAssetContract.Builder.class);
        }

        private int bitField0_;
        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int VOTE_ADDRESS_FIELD_NUMBER = 2;
        private java.util.List<com.google.protobuf.ByteString> voteAddress_;
        /**
         * <code>repeated bytes vote_address = 2;</code>
         */
        public java.util.List<com.google.protobuf.ByteString>
        getVoteAddressList() {
            return voteAddress_;
        }
        /**
         * <code>repeated bytes vote_address = 2;</code>
         */
        public int getVoteAddressCount() {
            return voteAddress_.size();
        }
        /**
         * <code>repeated bytes vote_address = 2;</code>
         */
        public com.google.protobuf.ByteString getVoteAddress(int index) {
            return voteAddress_.get(index);
        }

        public static final int SUPPORT_FIELD_NUMBER = 3;
        private boolean support_;
        /**
         * <code>bool support = 3;</code>
         */
        public boolean getSupport() {
            return support_;
        }

        public static final int COUNT_FIELD_NUMBER = 5;
        private int count_;
        /**
         * <code>int32 count = 5;</code>
         */
        public int getCount() {
            return count_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            for (int i = 0; i < voteAddress_.size(); i++) {
                output.writeBytes(2, voteAddress_.get(i));
            }
            if (support_ != false) {
                output.writeBool(3, support_);
            }
            if (count_ != 0) {
                output.writeInt32(5, count_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            {
                int dataSize = 0;
                for (int i = 0; i < voteAddress_.size(); i++) {
                    dataSize += com.google.protobuf.CodedOutputStream
                            .computeBytesSizeNoTag(voteAddress_.get(i));
                }
                size += dataSize;
                size += 1 * getVoteAddressList().size();
            }
            if (support_ != false) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBoolSize(3, support_);
            }
            if (count_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(5, count_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.VoteAssetContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.VoteAssetContract other = (com.cryptowallet.crypto.Contract.VoteAssetContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && getVoteAddressList()
                    .equals(other.getVoteAddressList());
            result = result && (getSupport()
                    == other.getSupport());
            result = result && (getCount()
                    == other.getCount());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            if (getVoteAddressCount() > 0) {
                hash = (37 * hash) + VOTE_ADDRESS_FIELD_NUMBER;
                hash = (53 * hash) + getVoteAddressList().hashCode();
            }
            hash = (37 * hash) + SUPPORT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
                    getSupport());
            hash = (37 * hash) + COUNT_FIELD_NUMBER;
            hash = (53 * hash) + getCount();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.VoteAssetContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.VoteAssetContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.VoteAssetContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.VoteAssetContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.VoteAssetContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.VoteAssetContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.VoteAssetContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.VoteAssetContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.VoteAssetContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.VoteAssetContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.VoteAssetContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.VoteAssetContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.VoteAssetContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.VoteAssetContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.VoteAssetContract)
                com.cryptowallet.crypto.Contract.VoteAssetContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteAssetContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteAssetContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.VoteAssetContract.class, com.cryptowallet.crypto.Contract.VoteAssetContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.VoteAssetContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                voteAddress_ = java.util.Collections.emptyList();
                bitField0_ = (bitField0_ & ~0x00000002);
                support_ = false;

                count_ = 0;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteAssetContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.VoteAssetContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.VoteAssetContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.VoteAssetContract build() {
                com.cryptowallet.crypto.Contract.VoteAssetContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.VoteAssetContract buildPartial() {
                com.cryptowallet.crypto.Contract.VoteAssetContract result = new com.cryptowallet.crypto.Contract.VoteAssetContract(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                result.ownerAddress_ = ownerAddress_;
                if (((bitField0_ & 0x00000002) == 0x00000002)) {
                    voteAddress_ = java.util.Collections.unmodifiableList(voteAddress_);
                    bitField0_ = (bitField0_ & ~0x00000002);
                }
                result.voteAddress_ = voteAddress_;
                result.support_ = support_;
                result.count_ = count_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.VoteAssetContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.VoteAssetContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.VoteAssetContract other) {
                if (other == com.cryptowallet.crypto.Contract.VoteAssetContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (!other.voteAddress_.isEmpty()) {
                    if (voteAddress_.isEmpty()) {
                        voteAddress_ = other.voteAddress_;
                        bitField0_ = (bitField0_ & ~0x00000002);
                    } else {
                        ensureVoteAddressIsMutable();
                        voteAddress_.addAll(other.voteAddress_);
                    }
                    onChanged();
                }
                if (other.getSupport() != false) {
                    setSupport(other.getSupport());
                }
                if (other.getCount() != 0) {
                    setCount(other.getCount());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.VoteAssetContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.VoteAssetContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
            private int bitField0_;

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private java.util.List<com.google.protobuf.ByteString> voteAddress_ = java.util.Collections.emptyList();
            private void ensureVoteAddressIsMutable() {
                if (!((bitField0_ & 0x00000002) == 0x00000002)) {
                    voteAddress_ = new java.util.ArrayList<com.google.protobuf.ByteString>(voteAddress_);
                    bitField0_ |= 0x00000002;
                }
            }
            /**
             * <code>repeated bytes vote_address = 2;</code>
             */
            public java.util.List<com.google.protobuf.ByteString>
            getVoteAddressList() {
                return java.util.Collections.unmodifiableList(voteAddress_);
            }
            /**
             * <code>repeated bytes vote_address = 2;</code>
             */
            public int getVoteAddressCount() {
                return voteAddress_.size();
            }
            /**
             * <code>repeated bytes vote_address = 2;</code>
             */
            public com.google.protobuf.ByteString getVoteAddress(int index) {
                return voteAddress_.get(index);
            }
            /**
             * <code>repeated bytes vote_address = 2;</code>
             */
            public Builder setVoteAddress(
                    int index, com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureVoteAddressIsMutable();
                voteAddress_.set(index, value);
                onChanged();
                return this;
            }
            /**
             * <code>repeated bytes vote_address = 2;</code>
             */
            public Builder addVoteAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureVoteAddressIsMutable();
                voteAddress_.add(value);
                onChanged();
                return this;
            }
            /**
             * <code>repeated bytes vote_address = 2;</code>
             */
            public Builder addAllVoteAddress(
                    java.lang.Iterable<? extends com.google.protobuf.ByteString> values) {
                ensureVoteAddressIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll(
                        values, voteAddress_);
                onChanged();
                return this;
            }
            /**
             * <code>repeated bytes vote_address = 2;</code>
             */
            public Builder clearVoteAddress() {
                voteAddress_ = java.util.Collections.emptyList();
                bitField0_ = (bitField0_ & ~0x00000002);
                onChanged();
                return this;
            }

            private boolean support_ ;
            /**
             * <code>bool support = 3;</code>
             */
            public boolean getSupport() {
                return support_;
            }
            /**
             * <code>bool support = 3;</code>
             */
            public Builder setSupport(boolean value) {

                support_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bool support = 3;</code>
             */
            public Builder clearSupport() {

                support_ = false;
                onChanged();
                return this;
            }

            private int count_ ;
            /**
             * <code>int32 count = 5;</code>
             */
            public int getCount() {
                return count_;
            }
            /**
             * <code>int32 count = 5;</code>
             */
            public Builder setCount(int value) {

                count_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int32 count = 5;</code>
             */
            public Builder clearCount() {

                count_ = 0;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.VoteAssetContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.VoteAssetContract)
        private static final com.cryptowallet.crypto.Contract.VoteAssetContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.VoteAssetContract();
        }

        public static com.cryptowallet.crypto.Contract.VoteAssetContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<VoteAssetContract>
                PARSER = new com.google.protobuf.AbstractParser<VoteAssetContract>() {
            public VoteAssetContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new VoteAssetContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<VoteAssetContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<VoteAssetContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.VoteAssetContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface VoteWitnessContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.VoteWitnessContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
         */
        java.util.List<com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote>
        getVotesList();
        /**
         * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
         */
        com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote getVotes(int index);
        /**
         * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
         */
        int getVotesCount();
        /**
         * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
         */
        java.util.List<? extends com.cryptowallet.crypto.Contract.VoteWitnessContract.VoteOrBuilder>
        getVotesOrBuilderList();
        /**
         * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
         */
        com.cryptowallet.crypto.Contract.VoteWitnessContract.VoteOrBuilder getVotesOrBuilder(
                int index);

        /**
         * <code>bool support = 3;</code>
         */
        boolean getSupport();
    }
    /**
     * Protobuf type {@code protocol.VoteWitnessContract}
     */
    public  static final class VoteWitnessContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.VoteWitnessContract)
            VoteWitnessContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use VoteWitnessContract.newBuilder() to construct.
        private VoteWitnessContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private VoteWitnessContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            votes_ = java.util.Collections.emptyList();
            support_ = false;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private VoteWitnessContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 18: {
                            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                                votes_ = new java.util.ArrayList<com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote>();
                                mutable_bitField0_ |= 0x00000002;
                            }
                            votes_.add(
                                    input.readMessage(com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.parser(), extensionRegistry));
                            break;
                        }
                        case 24: {

                            support_ = input.readBool();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                    votes_ = java.util.Collections.unmodifiableList(votes_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteWitnessContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteWitnessContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.VoteWitnessContract.class, com.cryptowallet.crypto.Contract.VoteWitnessContract.Builder.class);
        }

        public interface VoteOrBuilder extends
                // @@protoc_insertion_point(interface_extends:protocol.VoteWitnessContract.Vote)
                com.google.protobuf.MessageOrBuilder {

            /**
             * <code>bytes vote_address = 1;</code>
             */
            com.google.protobuf.ByteString getVoteAddress();

            /**
             * <code>int64 vote_count = 2;</code>
             */
            long getVoteCount();
        }
        /**
         * Protobuf type {@code protocol.VoteWitnessContract.Vote}
         */
        public  static final class Vote extends
                com.google.protobuf.GeneratedMessageV3 implements
                // @@protoc_insertion_point(message_implements:protocol.VoteWitnessContract.Vote)
                VoteOrBuilder {
            private static final long serialVersionUID = 0L;
            // Use Vote.newBuilder() to construct.
            private Vote(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                super(builder);
            }
            private Vote() {
                voteAddress_ = com.google.protobuf.ByteString.EMPTY;
                voteCount_ = 0L;
            }

            @java.lang.Override
            public final com.google.protobuf.UnknownFieldSet
            getUnknownFields() {
                return this.unknownFields;
            }
            private Vote(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                this();
                if (extensionRegistry == null) {
                    throw new java.lang.NullPointerException();
                }
                int mutable_bitField0_ = 0;
                com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                        com.google.protobuf.UnknownFieldSet.newBuilder();
                try {
                    boolean done = false;
                    while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            default: {
                                if (!parseUnknownFieldProto3(
                                        input, unknownFields, extensionRegistry, tag)) {
                                    done = true;
                                }
                                break;
                            }
                            case 10: {

                                voteAddress_ = input.readBytes();
                                break;
                            }
                            case 16: {

                                voteCount_ = input.readInt64();
                                break;
                            }
                        }
                    }
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (java.io.IOException e) {
                    throw new com.google.protobuf.InvalidProtocolBufferException(
                            e).setUnfinishedMessage(this);
                } finally {
                    this.unknownFields = unknownFields.build();
                    makeExtensionsImmutable();
                }
            }
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteWitnessContract_Vote_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteWitnessContract_Vote_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.class, com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.Builder.class);
            }

            public static final int VOTE_ADDRESS_FIELD_NUMBER = 1;
            private com.google.protobuf.ByteString voteAddress_;
            /**
             * <code>bytes vote_address = 1;</code>
             */
            public com.google.protobuf.ByteString getVoteAddress() {
                return voteAddress_;
            }

            public static final int VOTE_COUNT_FIELD_NUMBER = 2;
            private long voteCount_;
            /**
             * <code>int64 vote_count = 2;</code>
             */
            public long getVoteCount() {
                return voteCount_;
            }

            private byte memoizedIsInitialized = -1;
            public final boolean isInitialized() {
                byte isInitialized = memoizedIsInitialized;
                if (isInitialized == 1) return true;
                if (isInitialized == 0) return false;

                memoizedIsInitialized = 1;
                return true;
            }

            public void writeTo(com.google.protobuf.CodedOutputStream output)
                    throws java.io.IOException {
                if (!voteAddress_.isEmpty()) {
                    output.writeBytes(1, voteAddress_);
                }
                if (voteCount_ != 0L) {
                    output.writeInt64(2, voteCount_);
                }
                unknownFields.writeTo(output);
            }

            public int getSerializedSize() {
                int size = memoizedSize;
                if (size != -1) return size;

                size = 0;
                if (!voteAddress_.isEmpty()) {
                    size += com.google.protobuf.CodedOutputStream
                            .computeBytesSize(1, voteAddress_);
                }
                if (voteCount_ != 0L) {
                    size += com.google.protobuf.CodedOutputStream
                            .computeInt64Size(2, voteCount_);
                }
                size += unknownFields.getSerializedSize();
                memoizedSize = size;
                return size;
            }

            @java.lang.Override
            public boolean equals(final java.lang.Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote)) {
                    return super.equals(obj);
                }
                com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote other = (com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote) obj;

                boolean result = true;
                result = result && getVoteAddress()
                        .equals(other.getVoteAddress());
                result = result && (getVoteCount()
                        == other.getVoteCount());
                result = result && unknownFields.equals(other.unknownFields);
                return result;
            }

            @java.lang.Override
            public int hashCode() {
                if (memoizedHashCode != 0) {
                    return memoizedHashCode;
                }
                int hash = 41;
                hash = (19 * hash) + getDescriptor().hashCode();
                hash = (37 * hash) + VOTE_ADDRESS_FIELD_NUMBER;
                hash = (53 * hash) + getVoteAddress().hashCode();
                hash = (37 * hash) + VOTE_COUNT_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                        getVoteCount());
                hash = (29 * hash) + unknownFields.hashCode();
                memoizedHashCode = hash;
                return hash;
            }

            public static com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote parseFrom(
                    java.nio.ByteBuffer data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }
            public static com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote parseFrom(
                    java.nio.ByteBuffer data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }
            public static com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote parseFrom(
                    com.google.protobuf.ByteString data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }
            public static com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote parseFrom(
                    com.google.protobuf.ByteString data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }
            public static com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote parseFrom(byte[] data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }
            public static com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote parseFrom(
                    byte[] data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }
            public static com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote parseFrom(java.io.InputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input);
            }
            public static com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote parseFrom(
                    java.io.InputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input, extensionRegistry);
            }
            public static com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote parseDelimitedFrom(java.io.InputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseDelimitedWithIOException(PARSER, input);
            }
            public static com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote parseDelimitedFrom(
                    java.io.InputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }
            public static com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote parseFrom(
                    com.google.protobuf.CodedInputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input);
            }
            public static com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote parseFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input, extensionRegistry);
            }

            public Builder newBuilderForType() { return newBuilder(); }
            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }
            public static Builder newBuilder(com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote prototype) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
            }
            public Builder toBuilder() {
                return this == DEFAULT_INSTANCE
                        ? new Builder() : new Builder().mergeFrom(this);
            }

            @java.lang.Override
            protected Builder newBuilderForType(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                Builder builder = new Builder(parent);
                return builder;
            }
            /**
             * Protobuf type {@code protocol.VoteWitnessContract.Vote}
             */
            public static final class Builder extends
                    com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                    // @@protoc_insertion_point(builder_implements:protocol.VoteWitnessContract.Vote)
                    com.cryptowallet.crypto.Contract.VoteWitnessContract.VoteOrBuilder {
                public static final com.google.protobuf.Descriptors.Descriptor
                getDescriptor() {
                    return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteWitnessContract_Vote_descriptor;
                }

                protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
                internalGetFieldAccessorTable() {
                    return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteWitnessContract_Vote_fieldAccessorTable
                            .ensureFieldAccessorsInitialized(
                                    com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.class, com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.Builder.class);
                }

                // Construct using com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.newBuilder()
                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(
                        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }
                private void maybeForceBuilderInitialization() {
                    if (com.google.protobuf.GeneratedMessageV3
                            .alwaysUseFieldBuilders) {
                    }
                }
                public Builder clear() {
                    super.clear();
                    voteAddress_ = com.google.protobuf.ByteString.EMPTY;

                    voteCount_ = 0L;

                    return this;
                }

                public com.google.protobuf.Descriptors.Descriptor
                getDescriptorForType() {
                    return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteWitnessContract_Vote_descriptor;
                }

                public com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote getDefaultInstanceForType() {
                    return com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.getDefaultInstance();
                }

                public com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote build() {
                    com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote result = buildPartial();
                    if (!result.isInitialized()) {
                        throw newUninitializedMessageException(result);
                    }
                    return result;
                }

                public com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote buildPartial() {
                    com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote result = new com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote(this);
                    result.voteAddress_ = voteAddress_;
                    result.voteCount_ = voteCount_;
                    onBuilt();
                    return result;
                }

                public Builder clone() {
                    return (Builder) super.clone();
                }
                public Builder setField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        java.lang.Object value) {
                    return (Builder) super.setField(field, value);
                }
                public Builder clearField(
                        com.google.protobuf.Descriptors.FieldDescriptor field) {
                    return (Builder) super.clearField(field);
                }
                public Builder clearOneof(
                        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                    return (Builder) super.clearOneof(oneof);
                }
                public Builder setRepeatedField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        int index, java.lang.Object value) {
                    return (Builder) super.setRepeatedField(field, index, value);
                }
                public Builder addRepeatedField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        java.lang.Object value) {
                    return (Builder) super.addRepeatedField(field, value);
                }
                public Builder mergeFrom(com.google.protobuf.Message other) {
                    if (other instanceof com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote) {
                        return mergeFrom((com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote)other);
                    } else {
                        super.mergeFrom(other);
                        return this;
                    }
                }

                public Builder mergeFrom(com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote other) {
                    if (other == com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.getDefaultInstance()) return this;
                    if (other.getVoteAddress() != com.google.protobuf.ByteString.EMPTY) {
                        setVoteAddress(other.getVoteAddress());
                    }
                    if (other.getVoteCount() != 0L) {
                        setVoteCount(other.getVoteCount());
                    }
                    this.mergeUnknownFields(other.unknownFields);
                    onChanged();
                    return this;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Builder mergeFrom(
                        com.google.protobuf.CodedInputStream input,
                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                        throws java.io.IOException {
                    com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote parsedMessage = null;
                    try {
                        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                        parsedMessage = (com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    } finally {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                    }
                    return this;
                }

                private com.google.protobuf.ByteString voteAddress_ = com.google.protobuf.ByteString.EMPTY;
                /**
                 * <code>bytes vote_address = 1;</code>
                 */
                public com.google.protobuf.ByteString getVoteAddress() {
                    return voteAddress_;
                }
                /**
                 * <code>bytes vote_address = 1;</code>
                 */
                public Builder setVoteAddress(com.google.protobuf.ByteString value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }

                    voteAddress_ = value;
                    onChanged();
                    return this;
                }
                /**
                 * <code>bytes vote_address = 1;</code>
                 */
                public Builder clearVoteAddress() {

                    voteAddress_ = getDefaultInstance().getVoteAddress();
                    onChanged();
                    return this;
                }

                private long voteCount_ ;
                /**
                 * <code>int64 vote_count = 2;</code>
                 */
                public long getVoteCount() {
                    return voteCount_;
                }
                /**
                 * <code>int64 vote_count = 2;</code>
                 */
                public Builder setVoteCount(long value) {

                    voteCount_ = value;
                    onChanged();
                    return this;
                }
                /**
                 * <code>int64 vote_count = 2;</code>
                 */
                public Builder clearVoteCount() {

                    voteCount_ = 0L;
                    onChanged();
                    return this;
                }
                public final Builder setUnknownFields(
                        final com.google.protobuf.UnknownFieldSet unknownFields) {
                    return super.setUnknownFieldsProto3(unknownFields);
                }

                public final Builder mergeUnknownFields(
                        final com.google.protobuf.UnknownFieldSet unknownFields) {
                    return super.mergeUnknownFields(unknownFields);
                }


                // @@protoc_insertion_point(builder_scope:protocol.VoteWitnessContract.Vote)
            }

            // @@protoc_insertion_point(class_scope:protocol.VoteWitnessContract.Vote)
            private static final com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote DEFAULT_INSTANCE;
            static {
                DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote();
            }

            public static com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            private static final com.google.protobuf.Parser<Vote>
                    PARSER = new com.google.protobuf.AbstractParser<Vote>() {
                public Vote parsePartialFrom(
                        com.google.protobuf.CodedInputStream input,
                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                        throws com.google.protobuf.InvalidProtocolBufferException {
                    return new Vote(input, extensionRegistry);
                }
            };

            public static com.google.protobuf.Parser<Vote> parser() {
                return PARSER;
            }

            @java.lang.Override
            public com.google.protobuf.Parser<Vote> getParserForType() {
                return PARSER;
            }

            public com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

        }

        private int bitField0_;
        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int VOTES_FIELD_NUMBER = 2;
        private java.util.List<com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote> votes_;
        /**
         * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
         */
        public java.util.List<com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote> getVotesList() {
            return votes_;
        }
        /**
         * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
         */
        public java.util.List<? extends com.cryptowallet.crypto.Contract.VoteWitnessContract.VoteOrBuilder>
        getVotesOrBuilderList() {
            return votes_;
        }
        /**
         * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
         */
        public int getVotesCount() {
            return votes_.size();
        }
        /**
         * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
         */
        public com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote getVotes(int index) {
            return votes_.get(index);
        }
        /**
         * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
         */
        public com.cryptowallet.crypto.Contract.VoteWitnessContract.VoteOrBuilder getVotesOrBuilder(
                int index) {
            return votes_.get(index);
        }

        public static final int SUPPORT_FIELD_NUMBER = 3;
        private boolean support_;
        /**
         * <code>bool support = 3;</code>
         */
        public boolean getSupport() {
            return support_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            for (int i = 0; i < votes_.size(); i++) {
                output.writeMessage(2, votes_.get(i));
            }
            if (support_ != false) {
                output.writeBool(3, support_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            for (int i = 0; i < votes_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(2, votes_.get(i));
            }
            if (support_ != false) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBoolSize(3, support_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.VoteWitnessContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.VoteWitnessContract other = (com.cryptowallet.crypto.Contract.VoteWitnessContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && getVotesList()
                    .equals(other.getVotesList());
            result = result && (getSupport()
                    == other.getSupport());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            if (getVotesCount() > 0) {
                hash = (37 * hash) + VOTES_FIELD_NUMBER;
                hash = (53 * hash) + getVotesList().hashCode();
            }
            hash = (37 * hash) + SUPPORT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
                    getSupport());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.VoteWitnessContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.VoteWitnessContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.VoteWitnessContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.VoteWitnessContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.VoteWitnessContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.VoteWitnessContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.VoteWitnessContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.VoteWitnessContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.VoteWitnessContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.VoteWitnessContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.VoteWitnessContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.VoteWitnessContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.VoteWitnessContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.VoteWitnessContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.VoteWitnessContract)
                com.cryptowallet.crypto.Contract.VoteWitnessContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteWitnessContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteWitnessContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.VoteWitnessContract.class, com.cryptowallet.crypto.Contract.VoteWitnessContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.VoteWitnessContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                    getVotesFieldBuilder();
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                if (votesBuilder_ == null) {
                    votes_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000002);
                } else {
                    votesBuilder_.clear();
                }
                support_ = false;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_VoteWitnessContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.VoteWitnessContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.VoteWitnessContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.VoteWitnessContract build() {
                com.cryptowallet.crypto.Contract.VoteWitnessContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.VoteWitnessContract buildPartial() {
                com.cryptowallet.crypto.Contract.VoteWitnessContract result = new com.cryptowallet.crypto.Contract.VoteWitnessContract(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                result.ownerAddress_ = ownerAddress_;
                if (votesBuilder_ == null) {
                    if (((bitField0_ & 0x00000002) == 0x00000002)) {
                        votes_ = java.util.Collections.unmodifiableList(votes_);
                        bitField0_ = (bitField0_ & ~0x00000002);
                    }
                    result.votes_ = votes_;
                } else {
                    result.votes_ = votesBuilder_.build();
                }
                result.support_ = support_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.VoteWitnessContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.VoteWitnessContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.VoteWitnessContract other) {
                if (other == com.cryptowallet.crypto.Contract.VoteWitnessContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (votesBuilder_ == null) {
                    if (!other.votes_.isEmpty()) {
                        if (votes_.isEmpty()) {
                            votes_ = other.votes_;
                            bitField0_ = (bitField0_ & ~0x00000002);
                        } else {
                            ensureVotesIsMutable();
                            votes_.addAll(other.votes_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.votes_.isEmpty()) {
                        if (votesBuilder_.isEmpty()) {
                            votesBuilder_.dispose();
                            votesBuilder_ = null;
                            votes_ = other.votes_;
                            bitField0_ = (bitField0_ & ~0x00000002);
                            votesBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                            getVotesFieldBuilder() : null;
                        } else {
                            votesBuilder_.addAllMessages(other.votes_);
                        }
                    }
                }
                if (other.getSupport() != false) {
                    setSupport(other.getSupport());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.VoteWitnessContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.VoteWitnessContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
            private int bitField0_;

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private java.util.List<com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote> votes_ =
                    java.util.Collections.emptyList();
            private void ensureVotesIsMutable() {
                if (!((bitField0_ & 0x00000002) == 0x00000002)) {
                    votes_ = new java.util.ArrayList<com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote>(votes_);
                    bitField0_ |= 0x00000002;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote, com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.Builder, com.cryptowallet.crypto.Contract.VoteWitnessContract.VoteOrBuilder> votesBuilder_;

            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public java.util.List<com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote> getVotesList() {
                if (votesBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(votes_);
                } else {
                    return votesBuilder_.getMessageList();
                }
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public int getVotesCount() {
                if (votesBuilder_ == null) {
                    return votes_.size();
                } else {
                    return votesBuilder_.getCount();
                }
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote getVotes(int index) {
                if (votesBuilder_ == null) {
                    return votes_.get(index);
                } else {
                    return votesBuilder_.getMessage(index);
                }
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public Builder setVotes(
                    int index, com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote value) {
                if (votesBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureVotesIsMutable();
                    votes_.set(index, value);
                    onChanged();
                } else {
                    votesBuilder_.setMessage(index, value);
                }
                return this;
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public Builder setVotes(
                    int index, com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.Builder builderForValue) {
                if (votesBuilder_ == null) {
                    ensureVotesIsMutable();
                    votes_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    votesBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public Builder addVotes(com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote value) {
                if (votesBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureVotesIsMutable();
                    votes_.add(value);
                    onChanged();
                } else {
                    votesBuilder_.addMessage(value);
                }
                return this;
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public Builder addVotes(
                    int index, com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote value) {
                if (votesBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureVotesIsMutable();
                    votes_.add(index, value);
                    onChanged();
                } else {
                    votesBuilder_.addMessage(index, value);
                }
                return this;
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public Builder addVotes(
                    com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.Builder builderForValue) {
                if (votesBuilder_ == null) {
                    ensureVotesIsMutable();
                    votes_.add(builderForValue.build());
                    onChanged();
                } else {
                    votesBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public Builder addVotes(
                    int index, com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.Builder builderForValue) {
                if (votesBuilder_ == null) {
                    ensureVotesIsMutable();
                    votes_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    votesBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public Builder addAllVotes(
                    java.lang.Iterable<? extends com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote> values) {
                if (votesBuilder_ == null) {
                    ensureVotesIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(
                            values, votes_);
                    onChanged();
                } else {
                    votesBuilder_.addAllMessages(values);
                }
                return this;
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public Builder clearVotes() {
                if (votesBuilder_ == null) {
                    votes_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000002);
                    onChanged();
                } else {
                    votesBuilder_.clear();
                }
                return this;
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public Builder removeVotes(int index) {
                if (votesBuilder_ == null) {
                    ensureVotesIsMutable();
                    votes_.remove(index);
                    onChanged();
                } else {
                    votesBuilder_.remove(index);
                }
                return this;
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.Builder getVotesBuilder(
                    int index) {
                return getVotesFieldBuilder().getBuilder(index);
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public com.cryptowallet.crypto.Contract.VoteWitnessContract.VoteOrBuilder getVotesOrBuilder(
                    int index) {
                if (votesBuilder_ == null) {
                    return votes_.get(index);  } else {
                    return votesBuilder_.getMessageOrBuilder(index);
                }
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public java.util.List<? extends com.cryptowallet.crypto.Contract.VoteWitnessContract.VoteOrBuilder>
            getVotesOrBuilderList() {
                if (votesBuilder_ != null) {
                    return votesBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(votes_);
                }
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.Builder addVotesBuilder() {
                return getVotesFieldBuilder().addBuilder(
                        com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.getDefaultInstance());
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.Builder addVotesBuilder(
                    int index) {
                return getVotesFieldBuilder().addBuilder(
                        index, com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.getDefaultInstance());
            }
            /**
             * <code>repeated .protocol.VoteWitnessContract.Vote votes = 2;</code>
             */
            public java.util.List<com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.Builder>
            getVotesBuilderList() {
                return getVotesFieldBuilder().getBuilderList();
            }
            private com.google.protobuf.RepeatedFieldBuilderV3<
                    com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote, com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.Builder, com.cryptowallet.crypto.Contract.VoteWitnessContract.VoteOrBuilder>
            getVotesFieldBuilder() {
                if (votesBuilder_ == null) {
                    votesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                            com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote, com.cryptowallet.crypto.Contract.VoteWitnessContract.Vote.Builder, com.cryptowallet.crypto.Contract.VoteWitnessContract.VoteOrBuilder>(
                            votes_,
                            ((bitField0_ & 0x00000002) == 0x00000002),
                            getParentForChildren(),
                            isClean());
                    votes_ = null;
                }
                return votesBuilder_;
            }

            private boolean support_ ;
            /**
             * <code>bool support = 3;</code>
             */
            public boolean getSupport() {
                return support_;
            }
            /**
             * <code>bool support = 3;</code>
             */
            public Builder setSupport(boolean value) {

                support_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bool support = 3;</code>
             */
            public Builder clearSupport() {

                support_ = false;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.VoteWitnessContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.VoteWitnessContract)
        private static final com.cryptowallet.crypto.Contract.VoteWitnessContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.VoteWitnessContract();
        }

        public static com.cryptowallet.crypto.Contract.VoteWitnessContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<VoteWitnessContract>
                PARSER = new com.google.protobuf.AbstractParser<VoteWitnessContract>() {
            public VoteWitnessContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new VoteWitnessContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<VoteWitnessContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<VoteWitnessContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.VoteWitnessContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface UpdateSettingContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.UpdateSettingContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>bytes contract_address = 2;</code>
         */
        com.google.protobuf.ByteString getContractAddress();

        /**
         * <code>int64 consume_user_resource_percent = 3;</code>
         */
        long getConsumeUserResourcePercent();
    }
    /**
     * Protobuf type {@code protocol.UpdateSettingContract}
     */
    public  static final class UpdateSettingContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.UpdateSettingContract)
            UpdateSettingContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use UpdateSettingContract.newBuilder() to construct.
        private UpdateSettingContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private UpdateSettingContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            contractAddress_ = com.google.protobuf.ByteString.EMPTY;
            consumeUserResourcePercent_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private UpdateSettingContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 18: {

                            contractAddress_ = input.readBytes();
                            break;
                        }
                        case 24: {

                            consumeUserResourcePercent_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateSettingContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateSettingContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.UpdateSettingContract.class, com.cryptowallet.crypto.Contract.UpdateSettingContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int CONTRACT_ADDRESS_FIELD_NUMBER = 2;
        private com.google.protobuf.ByteString contractAddress_;
        /**
         * <code>bytes contract_address = 2;</code>
         */
        public com.google.protobuf.ByteString getContractAddress() {
            return contractAddress_;
        }

        public static final int CONSUME_USER_RESOURCE_PERCENT_FIELD_NUMBER = 3;
        private long consumeUserResourcePercent_;
        /**
         * <code>int64 consume_user_resource_percent = 3;</code>
         */
        public long getConsumeUserResourcePercent() {
            return consumeUserResourcePercent_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (!contractAddress_.isEmpty()) {
                output.writeBytes(2, contractAddress_);
            }
            if (consumeUserResourcePercent_ != 0L) {
                output.writeInt64(3, consumeUserResourcePercent_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (!contractAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(2, contractAddress_);
            }
            if (consumeUserResourcePercent_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(3, consumeUserResourcePercent_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.UpdateSettingContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.UpdateSettingContract other = (com.cryptowallet.crypto.Contract.UpdateSettingContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && getContractAddress()
                    .equals(other.getContractAddress());
            result = result && (getConsumeUserResourcePercent()
                    == other.getConsumeUserResourcePercent());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + CONTRACT_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getContractAddress().hashCode();
            hash = (37 * hash) + CONSUME_USER_RESOURCE_PERCENT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getConsumeUserResourcePercent());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.UpdateSettingContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UpdateSettingContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateSettingContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UpdateSettingContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateSettingContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UpdateSettingContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateSettingContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UpdateSettingContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateSettingContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UpdateSettingContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateSettingContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UpdateSettingContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.UpdateSettingContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.UpdateSettingContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.UpdateSettingContract)
                com.cryptowallet.crypto.Contract.UpdateSettingContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateSettingContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateSettingContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.UpdateSettingContract.class, com.cryptowallet.crypto.Contract.UpdateSettingContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.UpdateSettingContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                contractAddress_ = com.google.protobuf.ByteString.EMPTY;

                consumeUserResourcePercent_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateSettingContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.UpdateSettingContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.UpdateSettingContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.UpdateSettingContract build() {
                com.cryptowallet.crypto.Contract.UpdateSettingContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.UpdateSettingContract buildPartial() {
                com.cryptowallet.crypto.Contract.UpdateSettingContract result = new com.cryptowallet.crypto.Contract.UpdateSettingContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.contractAddress_ = contractAddress_;
                result.consumeUserResourcePercent_ = consumeUserResourcePercent_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.UpdateSettingContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.UpdateSettingContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.UpdateSettingContract other) {
                if (other == com.cryptowallet.crypto.Contract.UpdateSettingContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getContractAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setContractAddress(other.getContractAddress());
                }
                if (other.getConsumeUserResourcePercent() != 0L) {
                    setConsumeUserResourcePercent(other.getConsumeUserResourcePercent());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.UpdateSettingContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.UpdateSettingContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString contractAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes contract_address = 2;</code>
             */
            public com.google.protobuf.ByteString getContractAddress() {
                return contractAddress_;
            }
            /**
             * <code>bytes contract_address = 2;</code>
             */
            public Builder setContractAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                contractAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes contract_address = 2;</code>
             */
            public Builder clearContractAddress() {

                contractAddress_ = getDefaultInstance().getContractAddress();
                onChanged();
                return this;
            }

            private long consumeUserResourcePercent_ ;
            /**
             * <code>int64 consume_user_resource_percent = 3;</code>
             */
            public long getConsumeUserResourcePercent() {
                return consumeUserResourcePercent_;
            }
            /**
             * <code>int64 consume_user_resource_percent = 3;</code>
             */
            public Builder setConsumeUserResourcePercent(long value) {

                consumeUserResourcePercent_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 consume_user_resource_percent = 3;</code>
             */
            public Builder clearConsumeUserResourcePercent() {

                consumeUserResourcePercent_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.UpdateSettingContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.UpdateSettingContract)
        private static final com.cryptowallet.crypto.Contract.UpdateSettingContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.UpdateSettingContract();
        }

        public static com.cryptowallet.crypto.Contract.UpdateSettingContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<UpdateSettingContract>
                PARSER = new com.google.protobuf.AbstractParser<UpdateSettingContract>() {
            public UpdateSettingContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new UpdateSettingContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<UpdateSettingContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<UpdateSettingContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.UpdateSettingContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface UpdateEnergyLimitContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.UpdateEnergyLimitContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>bytes contract_address = 2;</code>
         */
        com.google.protobuf.ByteString getContractAddress();

        /**
         * <code>int64 origin_energy_limit = 3;</code>
         */
        long getOriginEnergyLimit();
    }
    /**
     * Protobuf type {@code protocol.UpdateEnergyLimitContract}
     */
    public  static final class UpdateEnergyLimitContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.UpdateEnergyLimitContract)
            UpdateEnergyLimitContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use UpdateEnergyLimitContract.newBuilder() to construct.
        private UpdateEnergyLimitContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private UpdateEnergyLimitContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            contractAddress_ = com.google.protobuf.ByteString.EMPTY;
            originEnergyLimit_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private UpdateEnergyLimitContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 18: {

                            contractAddress_ = input.readBytes();
                            break;
                        }
                        case 24: {

                            originEnergyLimit_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateEnergyLimitContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateEnergyLimitContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract.class, com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int CONTRACT_ADDRESS_FIELD_NUMBER = 2;
        private com.google.protobuf.ByteString contractAddress_;
        /**
         * <code>bytes contract_address = 2;</code>
         */
        public com.google.protobuf.ByteString getContractAddress() {
            return contractAddress_;
        }

        public static final int ORIGIN_ENERGY_LIMIT_FIELD_NUMBER = 3;
        private long originEnergyLimit_;
        /**
         * <code>int64 origin_energy_limit = 3;</code>
         */
        public long getOriginEnergyLimit() {
            return originEnergyLimit_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (!contractAddress_.isEmpty()) {
                output.writeBytes(2, contractAddress_);
            }
            if (originEnergyLimit_ != 0L) {
                output.writeInt64(3, originEnergyLimit_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (!contractAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(2, contractAddress_);
            }
            if (originEnergyLimit_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(3, originEnergyLimit_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract other = (com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && getContractAddress()
                    .equals(other.getContractAddress());
            result = result && (getOriginEnergyLimit()
                    == other.getOriginEnergyLimit());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + CONTRACT_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getContractAddress().hashCode();
            hash = (37 * hash) + ORIGIN_ENERGY_LIMIT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getOriginEnergyLimit());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.UpdateEnergyLimitContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.UpdateEnergyLimitContract)
                com.cryptowallet.crypto.Contract.UpdateEnergyLimitContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateEnergyLimitContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateEnergyLimitContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract.class, com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                contractAddress_ = com.google.protobuf.ByteString.EMPTY;

                originEnergyLimit_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateEnergyLimitContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract build() {
                com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract buildPartial() {
                com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract result = new com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.contractAddress_ = contractAddress_;
                result.originEnergyLimit_ = originEnergyLimit_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract other) {
                if (other == com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getContractAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setContractAddress(other.getContractAddress());
                }
                if (other.getOriginEnergyLimit() != 0L) {
                    setOriginEnergyLimit(other.getOriginEnergyLimit());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString contractAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes contract_address = 2;</code>
             */
            public com.google.protobuf.ByteString getContractAddress() {
                return contractAddress_;
            }
            /**
             * <code>bytes contract_address = 2;</code>
             */
            public Builder setContractAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                contractAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes contract_address = 2;</code>
             */
            public Builder clearContractAddress() {

                contractAddress_ = getDefaultInstance().getContractAddress();
                onChanged();
                return this;
            }

            private long originEnergyLimit_ ;
            /**
             * <code>int64 origin_energy_limit = 3;</code>
             */
            public long getOriginEnergyLimit() {
                return originEnergyLimit_;
            }
            /**
             * <code>int64 origin_energy_limit = 3;</code>
             */
            public Builder setOriginEnergyLimit(long value) {

                originEnergyLimit_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 origin_energy_limit = 3;</code>
             */
            public Builder clearOriginEnergyLimit() {

                originEnergyLimit_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.UpdateEnergyLimitContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.UpdateEnergyLimitContract)
        private static final com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract();
        }

        public static com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<UpdateEnergyLimitContract>
                PARSER = new com.google.protobuf.AbstractParser<UpdateEnergyLimitContract>() {
            public UpdateEnergyLimitContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new UpdateEnergyLimitContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<UpdateEnergyLimitContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<UpdateEnergyLimitContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.UpdateEnergyLimitContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface WitnessCreateContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.WitnessCreateContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>bytes url = 2;</code>
         */
        com.google.protobuf.ByteString getUrl();
    }
    /**
     * Protobuf type {@code protocol.WitnessCreateContract}
     */
    public  static final class WitnessCreateContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.WitnessCreateContract)
            WitnessCreateContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use WitnessCreateContract.newBuilder() to construct.
        private WitnessCreateContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private WitnessCreateContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            url_ = com.google.protobuf.ByteString.EMPTY;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private WitnessCreateContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 18: {

                            url_ = input.readBytes();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_WitnessCreateContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_WitnessCreateContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.WitnessCreateContract.class, com.cryptowallet.crypto.Contract.WitnessCreateContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int URL_FIELD_NUMBER = 2;
        private com.google.protobuf.ByteString url_;
        /**
         * <code>bytes url = 2;</code>
         */
        public com.google.protobuf.ByteString getUrl() {
            return url_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (!url_.isEmpty()) {
                output.writeBytes(2, url_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (!url_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(2, url_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.WitnessCreateContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.WitnessCreateContract other = (com.cryptowallet.crypto.Contract.WitnessCreateContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && getUrl()
                    .equals(other.getUrl());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + URL_FIELD_NUMBER;
            hash = (53 * hash) + getUrl().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.WitnessCreateContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.WitnessCreateContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WitnessCreateContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.WitnessCreateContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WitnessCreateContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.WitnessCreateContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WitnessCreateContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.WitnessCreateContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WitnessCreateContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.WitnessCreateContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WitnessCreateContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.WitnessCreateContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.WitnessCreateContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.WitnessCreateContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.WitnessCreateContract)
                com.cryptowallet.crypto.Contract.WitnessCreateContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_WitnessCreateContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_WitnessCreateContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.WitnessCreateContract.class, com.cryptowallet.crypto.Contract.WitnessCreateContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.WitnessCreateContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                url_ = com.google.protobuf.ByteString.EMPTY;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_WitnessCreateContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.WitnessCreateContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.WitnessCreateContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.WitnessCreateContract build() {
                com.cryptowallet.crypto.Contract.WitnessCreateContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.WitnessCreateContract buildPartial() {
                com.cryptowallet.crypto.Contract.WitnessCreateContract result = new com.cryptowallet.crypto.Contract.WitnessCreateContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.url_ = url_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.WitnessCreateContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.WitnessCreateContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.WitnessCreateContract other) {
                if (other == com.cryptowallet.crypto.Contract.WitnessCreateContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getUrl() != com.google.protobuf.ByteString.EMPTY) {
                    setUrl(other.getUrl());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.WitnessCreateContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.WitnessCreateContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString url_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes url = 2;</code>
             */
            public com.google.protobuf.ByteString getUrl() {
                return url_;
            }
            /**
             * <code>bytes url = 2;</code>
             */
            public Builder setUrl(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                url_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes url = 2;</code>
             */
            public Builder clearUrl() {

                url_ = getDefaultInstance().getUrl();
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.WitnessCreateContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.WitnessCreateContract)
        private static final com.cryptowallet.crypto.Contract.WitnessCreateContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.WitnessCreateContract();
        }

        public static com.cryptowallet.crypto.Contract.WitnessCreateContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<WitnessCreateContract>
                PARSER = new com.google.protobuf.AbstractParser<WitnessCreateContract>() {
            public WitnessCreateContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new WitnessCreateContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<WitnessCreateContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<WitnessCreateContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.WitnessCreateContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface WitnessUpdateContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.WitnessUpdateContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>bytes update_url = 12;</code>
         */
        com.google.protobuf.ByteString getUpdateUrl();
    }
    /**
     * Protobuf type {@code protocol.WitnessUpdateContract}
     */
    public  static final class WitnessUpdateContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.WitnessUpdateContract)
            WitnessUpdateContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use WitnessUpdateContract.newBuilder() to construct.
        private WitnessUpdateContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private WitnessUpdateContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            updateUrl_ = com.google.protobuf.ByteString.EMPTY;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private WitnessUpdateContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 98: {

                            updateUrl_ = input.readBytes();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_WitnessUpdateContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_WitnessUpdateContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.WitnessUpdateContract.class, com.cryptowallet.crypto.Contract.WitnessUpdateContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int UPDATE_URL_FIELD_NUMBER = 12;
        private com.google.protobuf.ByteString updateUrl_;
        /**
         * <code>bytes update_url = 12;</code>
         */
        public com.google.protobuf.ByteString getUpdateUrl() {
            return updateUrl_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (!updateUrl_.isEmpty()) {
                output.writeBytes(12, updateUrl_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (!updateUrl_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(12, updateUrl_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.WitnessUpdateContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.WitnessUpdateContract other = (com.cryptowallet.crypto.Contract.WitnessUpdateContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && getUpdateUrl()
                    .equals(other.getUpdateUrl());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + UPDATE_URL_FIELD_NUMBER;
            hash = (53 * hash) + getUpdateUrl().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.WitnessUpdateContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.WitnessUpdateContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WitnessUpdateContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.WitnessUpdateContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WitnessUpdateContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.WitnessUpdateContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WitnessUpdateContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.WitnessUpdateContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WitnessUpdateContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.WitnessUpdateContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WitnessUpdateContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.WitnessUpdateContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.WitnessUpdateContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.WitnessUpdateContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.WitnessUpdateContract)
                com.cryptowallet.crypto.Contract.WitnessUpdateContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_WitnessUpdateContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_WitnessUpdateContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.WitnessUpdateContract.class, com.cryptowallet.crypto.Contract.WitnessUpdateContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.WitnessUpdateContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                updateUrl_ = com.google.protobuf.ByteString.EMPTY;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_WitnessUpdateContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.WitnessUpdateContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.WitnessUpdateContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.WitnessUpdateContract build() {
                com.cryptowallet.crypto.Contract.WitnessUpdateContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.WitnessUpdateContract buildPartial() {
                com.cryptowallet.crypto.Contract.WitnessUpdateContract result = new com.cryptowallet.crypto.Contract.WitnessUpdateContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.updateUrl_ = updateUrl_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.WitnessUpdateContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.WitnessUpdateContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.WitnessUpdateContract other) {
                if (other == com.cryptowallet.crypto.Contract.WitnessUpdateContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getUpdateUrl() != com.google.protobuf.ByteString.EMPTY) {
                    setUpdateUrl(other.getUpdateUrl());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.WitnessUpdateContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.WitnessUpdateContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString updateUrl_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes update_url = 12;</code>
             */
            public com.google.protobuf.ByteString getUpdateUrl() {
                return updateUrl_;
            }
            /**
             * <code>bytes update_url = 12;</code>
             */
            public Builder setUpdateUrl(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                updateUrl_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes update_url = 12;</code>
             */
            public Builder clearUpdateUrl() {

                updateUrl_ = getDefaultInstance().getUpdateUrl();
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.WitnessUpdateContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.WitnessUpdateContract)
        private static final com.cryptowallet.crypto.Contract.WitnessUpdateContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.WitnessUpdateContract();
        }

        public static com.cryptowallet.crypto.Contract.WitnessUpdateContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<WitnessUpdateContract>
                PARSER = new com.google.protobuf.AbstractParser<WitnessUpdateContract>() {
            public WitnessUpdateContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new WitnessUpdateContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<WitnessUpdateContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<WitnessUpdateContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.WitnessUpdateContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface AssetIssueContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.AssetIssueContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>bytes name = 2;</code>
         */
        com.google.protobuf.ByteString getName();

        /**
         * <code>bytes abbr = 3;</code>
         */
        com.google.protobuf.ByteString getAbbr();

        /**
         * <code>int64 total_supply = 4;</code>
         */
        long getTotalSupply();

        /**
         * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
         */
        java.util.List<com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply>
        getFrozenSupplyList();
        /**
         * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
         */
        com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply getFrozenSupply(int index);
        /**
         * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
         */
        int getFrozenSupplyCount();
        /**
         * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
         */
        java.util.List<? extends com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupplyOrBuilder>
        getFrozenSupplyOrBuilderList();
        /**
         * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
         */
        com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupplyOrBuilder getFrozenSupplyOrBuilder(
                int index);

        /**
         * <code>int32 trx_num = 6;</code>
         */
        int getTrxNum();

        /**
         * <code>int32 num = 8;</code>
         */
        int getNum();

        /**
         * <code>int64 start_time = 9;</code>
         */
        long getStartTime();

        /**
         * <code>int64 end_time = 10;</code>
         */
        long getEndTime();

        /**
         * <pre>
         * the order of tokens of the same name
         * </pre>
         *
         * <code>int64 order = 11;</code>
         */
        long getOrder();

        /**
         * <code>int32 vote_score = 16;</code>
         */
        int getVoteScore();

        /**
         * <code>bytes description = 20;</code>
         */
        com.google.protobuf.ByteString getDescription();

        /**
         * <code>bytes url = 21;</code>
         */
        com.google.protobuf.ByteString getUrl();

        /**
         * <code>int64 free_asset_net_limit = 22;</code>
         */
        long getFreeAssetNetLimit();

        /**
         * <code>int64 public_free_asset_net_limit = 23;</code>
         */
        long getPublicFreeAssetNetLimit();

        /**
         * <code>int64 public_free_asset_net_usage = 24;</code>
         */
        long getPublicFreeAssetNetUsage();

        /**
         * <code>int64 public_latest_free_net_time = 25;</code>
         */
        long getPublicLatestFreeNetTime();
    }
    /**
     * Protobuf type {@code protocol.AssetIssueContract}
     */
    public  static final class AssetIssueContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.AssetIssueContract)
            AssetIssueContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use AssetIssueContract.newBuilder() to construct.
        private AssetIssueContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private AssetIssueContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            name_ = com.google.protobuf.ByteString.EMPTY;
            abbr_ = com.google.protobuf.ByteString.EMPTY;
            totalSupply_ = 0L;
            frozenSupply_ = java.util.Collections.emptyList();
            trxNum_ = 0;
            num_ = 0;
            startTime_ = 0L;
            endTime_ = 0L;
            order_ = 0L;
            voteScore_ = 0;
            description_ = com.google.protobuf.ByteString.EMPTY;
            url_ = com.google.protobuf.ByteString.EMPTY;
            freeAssetNetLimit_ = 0L;
            publicFreeAssetNetLimit_ = 0L;
            publicFreeAssetNetUsage_ = 0L;
            publicLatestFreeNetTime_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private AssetIssueContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 18: {

                            name_ = input.readBytes();
                            break;
                        }
                        case 26: {

                            abbr_ = input.readBytes();
                            break;
                        }
                        case 32: {

                            totalSupply_ = input.readInt64();
                            break;
                        }
                        case 42: {
                            if (!((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
                                frozenSupply_ = new java.util.ArrayList<com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply>();
                                mutable_bitField0_ |= 0x00000010;
                            }
                            frozenSupply_.add(
                                    input.readMessage(com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.parser(), extensionRegistry));
                            break;
                        }
                        case 48: {

                            trxNum_ = input.readInt32();
                            break;
                        }
                        case 64: {

                            num_ = input.readInt32();
                            break;
                        }
                        case 72: {

                            startTime_ = input.readInt64();
                            break;
                        }
                        case 80: {

                            endTime_ = input.readInt64();
                            break;
                        }
                        case 88: {

                            order_ = input.readInt64();
                            break;
                        }
                        case 128: {

                            voteScore_ = input.readInt32();
                            break;
                        }
                        case 162: {

                            description_ = input.readBytes();
                            break;
                        }
                        case 170: {

                            url_ = input.readBytes();
                            break;
                        }
                        case 176: {

                            freeAssetNetLimit_ = input.readInt64();
                            break;
                        }
                        case 184: {

                            publicFreeAssetNetLimit_ = input.readInt64();
                            break;
                        }
                        case 192: {

                            publicFreeAssetNetUsage_ = input.readInt64();
                            break;
                        }
                        case 200: {

                            publicLatestFreeNetTime_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                if (((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
                    frozenSupply_ = java.util.Collections.unmodifiableList(frozenSupply_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_AssetIssueContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_AssetIssueContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.AssetIssueContract.class, com.cryptowallet.crypto.Contract.AssetIssueContract.Builder.class);
        }

        public interface FrozenSupplyOrBuilder extends
                // @@protoc_insertion_point(interface_extends:protocol.AssetIssueContract.FrozenSupply)
                com.google.protobuf.MessageOrBuilder {

            /**
             * <code>int64 frozen_amount = 1;</code>
             */
            long getFrozenAmount();

            /**
             * <code>int64 frozen_days = 2;</code>
             */
            long getFrozenDays();
        }
        /**
         * Protobuf type {@code protocol.AssetIssueContract.FrozenSupply}
         */
        public  static final class FrozenSupply extends
                com.google.protobuf.GeneratedMessageV3 implements
                // @@protoc_insertion_point(message_implements:protocol.AssetIssueContract.FrozenSupply)
                FrozenSupplyOrBuilder {
            private static final long serialVersionUID = 0L;
            // Use FrozenSupply.newBuilder() to construct.
            private FrozenSupply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
                super(builder);
            }
            private FrozenSupply() {
                frozenAmount_ = 0L;
                frozenDays_ = 0L;
            }

            @java.lang.Override
            public final com.google.protobuf.UnknownFieldSet
            getUnknownFields() {
                return this.unknownFields;
            }
            private FrozenSupply(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                this();
                if (extensionRegistry == null) {
                    throw new java.lang.NullPointerException();
                }
                int mutable_bitField0_ = 0;
                com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                        com.google.protobuf.UnknownFieldSet.newBuilder();
                try {
                    boolean done = false;
                    while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            default: {
                                if (!parseUnknownFieldProto3(
                                        input, unknownFields, extensionRegistry, tag)) {
                                    done = true;
                                }
                                break;
                            }
                            case 8: {

                                frozenAmount_ = input.readInt64();
                                break;
                            }
                            case 16: {

                                frozenDays_ = input.readInt64();
                                break;
                            }
                        }
                    }
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (java.io.IOException e) {
                    throw new com.google.protobuf.InvalidProtocolBufferException(
                            e).setUnfinishedMessage(this);
                } finally {
                    this.unknownFields = unknownFields.build();
                    makeExtensionsImmutable();
                }
            }
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_AssetIssueContract_FrozenSupply_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_AssetIssueContract_FrozenSupply_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.class, com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.Builder.class);
            }

            public static final int FROZEN_AMOUNT_FIELD_NUMBER = 1;
            private long frozenAmount_;
            /**
             * <code>int64 frozen_amount = 1;</code>
             */
            public long getFrozenAmount() {
                return frozenAmount_;
            }

            public static final int FROZEN_DAYS_FIELD_NUMBER = 2;
            private long frozenDays_;
            /**
             * <code>int64 frozen_days = 2;</code>
             */
            public long getFrozenDays() {
                return frozenDays_;
            }

            private byte memoizedIsInitialized = -1;
            public final boolean isInitialized() {
                byte isInitialized = memoizedIsInitialized;
                if (isInitialized == 1) return true;
                if (isInitialized == 0) return false;

                memoizedIsInitialized = 1;
                return true;
            }

            public void writeTo(com.google.protobuf.CodedOutputStream output)
                    throws java.io.IOException {
                if (frozenAmount_ != 0L) {
                    output.writeInt64(1, frozenAmount_);
                }
                if (frozenDays_ != 0L) {
                    output.writeInt64(2, frozenDays_);
                }
                unknownFields.writeTo(output);
            }

            public int getSerializedSize() {
                int size = memoizedSize;
                if (size != -1) return size;

                size = 0;
                if (frozenAmount_ != 0L) {
                    size += com.google.protobuf.CodedOutputStream
                            .computeInt64Size(1, frozenAmount_);
                }
                if (frozenDays_ != 0L) {
                    size += com.google.protobuf.CodedOutputStream
                            .computeInt64Size(2, frozenDays_);
                }
                size += unknownFields.getSerializedSize();
                memoizedSize = size;
                return size;
            }

            @java.lang.Override
            public boolean equals(final java.lang.Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply)) {
                    return super.equals(obj);
                }
                com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply other = (com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply) obj;

                boolean result = true;
                result = result && (getFrozenAmount()
                        == other.getFrozenAmount());
                result = result && (getFrozenDays()
                        == other.getFrozenDays());
                result = result && unknownFields.equals(other.unknownFields);
                return result;
            }

            @java.lang.Override
            public int hashCode() {
                if (memoizedHashCode != 0) {
                    return memoizedHashCode;
                }
                int hash = 41;
                hash = (19 * hash) + getDescriptor().hashCode();
                hash = (37 * hash) + FROZEN_AMOUNT_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                        getFrozenAmount());
                hash = (37 * hash) + FROZEN_DAYS_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                        getFrozenDays());
                hash = (29 * hash) + unknownFields.hashCode();
                memoizedHashCode = hash;
                return hash;
            }

            public static com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply parseFrom(
                    java.nio.ByteBuffer data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }
            public static com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply parseFrom(
                    java.nio.ByteBuffer data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }
            public static com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply parseFrom(
                    com.google.protobuf.ByteString data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }
            public static com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply parseFrom(
                    com.google.protobuf.ByteString data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }
            public static com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply parseFrom(byte[] data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }
            public static com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply parseFrom(
                    byte[] data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }
            public static com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply parseFrom(java.io.InputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input);
            }
            public static com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply parseFrom(
                    java.io.InputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input, extensionRegistry);
            }
            public static com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply parseDelimitedFrom(java.io.InputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseDelimitedWithIOException(PARSER, input);
            }
            public static com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply parseDelimitedFrom(
                    java.io.InputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }
            public static com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply parseFrom(
                    com.google.protobuf.CodedInputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input);
            }
            public static com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply parseFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input, extensionRegistry);
            }

            public Builder newBuilderForType() { return newBuilder(); }
            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }
            public static Builder newBuilder(com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply prototype) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
            }
            public Builder toBuilder() {
                return this == DEFAULT_INSTANCE
                        ? new Builder() : new Builder().mergeFrom(this);
            }

            @java.lang.Override
            protected Builder newBuilderForType(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                Builder builder = new Builder(parent);
                return builder;
            }
            /**
             * Protobuf type {@code protocol.AssetIssueContract.FrozenSupply}
             */
            public static final class Builder extends
                    com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                    // @@protoc_insertion_point(builder_implements:protocol.AssetIssueContract.FrozenSupply)
                    com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupplyOrBuilder {
                public static final com.google.protobuf.Descriptors.Descriptor
                getDescriptor() {
                    return com.cryptowallet.crypto.Contract.internal_static_protocol_AssetIssueContract_FrozenSupply_descriptor;
                }

                protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
                internalGetFieldAccessorTable() {
                    return com.cryptowallet.crypto.Contract.internal_static_protocol_AssetIssueContract_FrozenSupply_fieldAccessorTable
                            .ensureFieldAccessorsInitialized(
                                    com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.class, com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.Builder.class);
                }

                // Construct using com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.newBuilder()
                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(
                        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }
                private void maybeForceBuilderInitialization() {
                    if (com.google.protobuf.GeneratedMessageV3
                            .alwaysUseFieldBuilders) {
                    }
                }
                public Builder clear() {
                    super.clear();
                    frozenAmount_ = 0L;

                    frozenDays_ = 0L;

                    return this;
                }

                public com.google.protobuf.Descriptors.Descriptor
                getDescriptorForType() {
                    return com.cryptowallet.crypto.Contract.internal_static_protocol_AssetIssueContract_FrozenSupply_descriptor;
                }

                public com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply getDefaultInstanceForType() {
                    return com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.getDefaultInstance();
                }

                public com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply build() {
                    com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply result = buildPartial();
                    if (!result.isInitialized()) {
                        throw newUninitializedMessageException(result);
                    }
                    return result;
                }

                public com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply buildPartial() {
                    com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply result = new com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply(this);
                    result.frozenAmount_ = frozenAmount_;
                    result.frozenDays_ = frozenDays_;
                    onBuilt();
                    return result;
                }

                public Builder clone() {
                    return (Builder) super.clone();
                }
                public Builder setField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        java.lang.Object value) {
                    return (Builder) super.setField(field, value);
                }
                public Builder clearField(
                        com.google.protobuf.Descriptors.FieldDescriptor field) {
                    return (Builder) super.clearField(field);
                }
                public Builder clearOneof(
                        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                    return (Builder) super.clearOneof(oneof);
                }
                public Builder setRepeatedField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        int index, java.lang.Object value) {
                    return (Builder) super.setRepeatedField(field, index, value);
                }
                public Builder addRepeatedField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        java.lang.Object value) {
                    return (Builder) super.addRepeatedField(field, value);
                }
                public Builder mergeFrom(com.google.protobuf.Message other) {
                    if (other instanceof com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply) {
                        return mergeFrom((com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply)other);
                    } else {
                        super.mergeFrom(other);
                        return this;
                    }
                }

                public Builder mergeFrom(com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply other) {
                    if (other == com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.getDefaultInstance()) return this;
                    if (other.getFrozenAmount() != 0L) {
                        setFrozenAmount(other.getFrozenAmount());
                    }
                    if (other.getFrozenDays() != 0L) {
                        setFrozenDays(other.getFrozenDays());
                    }
                    this.mergeUnknownFields(other.unknownFields);
                    onChanged();
                    return this;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Builder mergeFrom(
                        com.google.protobuf.CodedInputStream input,
                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                        throws java.io.IOException {
                    com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply parsedMessage = null;
                    try {
                        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                        parsedMessage = (com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    } finally {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                    }
                    return this;
                }

                private long frozenAmount_ ;
                /**
                 * <code>int64 frozen_amount = 1;</code>
                 */
                public long getFrozenAmount() {
                    return frozenAmount_;
                }
                /**
                 * <code>int64 frozen_amount = 1;</code>
                 */
                public Builder setFrozenAmount(long value) {

                    frozenAmount_ = value;
                    onChanged();
                    return this;
                }
                /**
                 * <code>int64 frozen_amount = 1;</code>
                 */
                public Builder clearFrozenAmount() {

                    frozenAmount_ = 0L;
                    onChanged();
                    return this;
                }

                private long frozenDays_ ;
                /**
                 * <code>int64 frozen_days = 2;</code>
                 */
                public long getFrozenDays() {
                    return frozenDays_;
                }
                /**
                 * <code>int64 frozen_days = 2;</code>
                 */
                public Builder setFrozenDays(long value) {

                    frozenDays_ = value;
                    onChanged();
                    return this;
                }
                /**
                 * <code>int64 frozen_days = 2;</code>
                 */
                public Builder clearFrozenDays() {

                    frozenDays_ = 0L;
                    onChanged();
                    return this;
                }
                public final Builder setUnknownFields(
                        final com.google.protobuf.UnknownFieldSet unknownFields) {
                    return super.setUnknownFieldsProto3(unknownFields);
                }

                public final Builder mergeUnknownFields(
                        final com.google.protobuf.UnknownFieldSet unknownFields) {
                    return super.mergeUnknownFields(unknownFields);
                }


                // @@protoc_insertion_point(builder_scope:protocol.AssetIssueContract.FrozenSupply)
            }

            // @@protoc_insertion_point(class_scope:protocol.AssetIssueContract.FrozenSupply)
            private static final com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply DEFAULT_INSTANCE;
            static {
                DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply();
            }

            public static com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            private static final com.google.protobuf.Parser<FrozenSupply>
                    PARSER = new com.google.protobuf.AbstractParser<FrozenSupply>() {
                public FrozenSupply parsePartialFrom(
                        com.google.protobuf.CodedInputStream input,
                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                        throws com.google.protobuf.InvalidProtocolBufferException {
                    return new FrozenSupply(input, extensionRegistry);
                }
            };

            public static com.google.protobuf.Parser<FrozenSupply> parser() {
                return PARSER;
            }

            @java.lang.Override
            public com.google.protobuf.Parser<FrozenSupply> getParserForType() {
                return PARSER;
            }

            public com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

        }

        private int bitField0_;
        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int NAME_FIELD_NUMBER = 2;
        private com.google.protobuf.ByteString name_;
        /**
         * <code>bytes name = 2;</code>
         */
        public com.google.protobuf.ByteString getName() {
            return name_;
        }

        public static final int ABBR_FIELD_NUMBER = 3;
        private com.google.protobuf.ByteString abbr_;
        /**
         * <code>bytes abbr = 3;</code>
         */
        public com.google.protobuf.ByteString getAbbr() {
            return abbr_;
        }

        public static final int TOTAL_SUPPLY_FIELD_NUMBER = 4;
        private long totalSupply_;
        /**
         * <code>int64 total_supply = 4;</code>
         */
        public long getTotalSupply() {
            return totalSupply_;
        }

        public static final int FROZEN_SUPPLY_FIELD_NUMBER = 5;
        private java.util.List<com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply> frozenSupply_;
        /**
         * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
         */
        public java.util.List<com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply> getFrozenSupplyList() {
            return frozenSupply_;
        }
        /**
         * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
         */
        public java.util.List<? extends com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupplyOrBuilder>
        getFrozenSupplyOrBuilderList() {
            return frozenSupply_;
        }
        /**
         * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
         */
        public int getFrozenSupplyCount() {
            return frozenSupply_.size();
        }
        /**
         * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
         */
        public com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply getFrozenSupply(int index) {
            return frozenSupply_.get(index);
        }
        /**
         * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
         */
        public com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupplyOrBuilder getFrozenSupplyOrBuilder(
                int index) {
            return frozenSupply_.get(index);
        }

        public static final int TRX_NUM_FIELD_NUMBER = 6;
        private int trxNum_;
        /**
         * <code>int32 trx_num = 6;</code>
         */
        public int getTrxNum() {
            return trxNum_;
        }

        public static final int NUM_FIELD_NUMBER = 8;
        private int num_;
        /**
         * <code>int32 num = 8;</code>
         */
        public int getNum() {
            return num_;
        }

        public static final int START_TIME_FIELD_NUMBER = 9;
        private long startTime_;
        /**
         * <code>int64 start_time = 9;</code>
         */
        public long getStartTime() {
            return startTime_;
        }

        public static final int END_TIME_FIELD_NUMBER = 10;
        private long endTime_;
        /**
         * <code>int64 end_time = 10;</code>
         */
        public long getEndTime() {
            return endTime_;
        }

        public static final int ORDER_FIELD_NUMBER = 11;
        private long order_;
        /**
         * <pre>
         * the order of tokens of the same name
         * </pre>
         *
         * <code>int64 order = 11;</code>
         */
        public long getOrder() {
            return order_;
        }

        public static final int VOTE_SCORE_FIELD_NUMBER = 16;
        private int voteScore_;
        /**
         * <code>int32 vote_score = 16;</code>
         */
        public int getVoteScore() {
            return voteScore_;
        }

        public static final int DESCRIPTION_FIELD_NUMBER = 20;
        private com.google.protobuf.ByteString description_;
        /**
         * <code>bytes description = 20;</code>
         */
        public com.google.protobuf.ByteString getDescription() {
            return description_;
        }

        public static final int URL_FIELD_NUMBER = 21;
        private com.google.protobuf.ByteString url_;
        /**
         * <code>bytes url = 21;</code>
         */
        public com.google.protobuf.ByteString getUrl() {
            return url_;
        }

        public static final int FREE_ASSET_NET_LIMIT_FIELD_NUMBER = 22;
        private long freeAssetNetLimit_;
        /**
         * <code>int64 free_asset_net_limit = 22;</code>
         */
        public long getFreeAssetNetLimit() {
            return freeAssetNetLimit_;
        }

        public static final int PUBLIC_FREE_ASSET_NET_LIMIT_FIELD_NUMBER = 23;
        private long publicFreeAssetNetLimit_;
        /**
         * <code>int64 public_free_asset_net_limit = 23;</code>
         */
        public long getPublicFreeAssetNetLimit() {
            return publicFreeAssetNetLimit_;
        }

        public static final int PUBLIC_FREE_ASSET_NET_USAGE_FIELD_NUMBER = 24;
        private long publicFreeAssetNetUsage_;
        /**
         * <code>int64 public_free_asset_net_usage = 24;</code>
         */
        public long getPublicFreeAssetNetUsage() {
            return publicFreeAssetNetUsage_;
        }

        public static final int PUBLIC_LATEST_FREE_NET_TIME_FIELD_NUMBER = 25;
        private long publicLatestFreeNetTime_;
        /**
         * <code>int64 public_latest_free_net_time = 25;</code>
         */
        public long getPublicLatestFreeNetTime() {
            return publicLatestFreeNetTime_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (!name_.isEmpty()) {
                output.writeBytes(2, name_);
            }
            if (!abbr_.isEmpty()) {
                output.writeBytes(3, abbr_);
            }
            if (totalSupply_ != 0L) {
                output.writeInt64(4, totalSupply_);
            }
            for (int i = 0; i < frozenSupply_.size(); i++) {
                output.writeMessage(5, frozenSupply_.get(i));
            }
            if (trxNum_ != 0) {
                output.writeInt32(6, trxNum_);
            }
            if (num_ != 0) {
                output.writeInt32(8, num_);
            }
            if (startTime_ != 0L) {
                output.writeInt64(9, startTime_);
            }
            if (endTime_ != 0L) {
                output.writeInt64(10, endTime_);
            }
            if (order_ != 0L) {
                output.writeInt64(11, order_);
            }
            if (voteScore_ != 0) {
                output.writeInt32(16, voteScore_);
            }
            if (!description_.isEmpty()) {
                output.writeBytes(20, description_);
            }
            if (!url_.isEmpty()) {
                output.writeBytes(21, url_);
            }
            if (freeAssetNetLimit_ != 0L) {
                output.writeInt64(22, freeAssetNetLimit_);
            }
            if (publicFreeAssetNetLimit_ != 0L) {
                output.writeInt64(23, publicFreeAssetNetLimit_);
            }
            if (publicFreeAssetNetUsage_ != 0L) {
                output.writeInt64(24, publicFreeAssetNetUsage_);
            }
            if (publicLatestFreeNetTime_ != 0L) {
                output.writeInt64(25, publicLatestFreeNetTime_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (!name_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(2, name_);
            }
            if (!abbr_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(3, abbr_);
            }
            if (totalSupply_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(4, totalSupply_);
            }
            for (int i = 0; i < frozenSupply_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(5, frozenSupply_.get(i));
            }
            if (trxNum_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(6, trxNum_);
            }
            if (num_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(8, num_);
            }
            if (startTime_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(9, startTime_);
            }
            if (endTime_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(10, endTime_);
            }
            if (order_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(11, order_);
            }
            if (voteScore_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(16, voteScore_);
            }
            if (!description_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(20, description_);
            }
            if (!url_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(21, url_);
            }
            if (freeAssetNetLimit_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(22, freeAssetNetLimit_);
            }
            if (publicFreeAssetNetLimit_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(23, publicFreeAssetNetLimit_);
            }
            if (publicFreeAssetNetUsage_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(24, publicFreeAssetNetUsage_);
            }
            if (publicLatestFreeNetTime_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(25, publicLatestFreeNetTime_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.AssetIssueContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.AssetIssueContract other = (com.cryptowallet.crypto.Contract.AssetIssueContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && getName()
                    .equals(other.getName());
            result = result && getAbbr()
                    .equals(other.getAbbr());
            result = result && (getTotalSupply()
                    == other.getTotalSupply());
            result = result && getFrozenSupplyList()
                    .equals(other.getFrozenSupplyList());
            result = result && (getTrxNum()
                    == other.getTrxNum());
            result = result && (getNum()
                    == other.getNum());
            result = result && (getStartTime()
                    == other.getStartTime());
            result = result && (getEndTime()
                    == other.getEndTime());
            result = result && (getOrder()
                    == other.getOrder());
            result = result && (getVoteScore()
                    == other.getVoteScore());
            result = result && getDescription()
                    .equals(other.getDescription());
            result = result && getUrl()
                    .equals(other.getUrl());
            result = result && (getFreeAssetNetLimit()
                    == other.getFreeAssetNetLimit());
            result = result && (getPublicFreeAssetNetLimit()
                    == other.getPublicFreeAssetNetLimit());
            result = result && (getPublicFreeAssetNetUsage()
                    == other.getPublicFreeAssetNetUsage());
            result = result && (getPublicLatestFreeNetTime()
                    == other.getPublicLatestFreeNetTime());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + NAME_FIELD_NUMBER;
            hash = (53 * hash) + getName().hashCode();
            hash = (37 * hash) + ABBR_FIELD_NUMBER;
            hash = (53 * hash) + getAbbr().hashCode();
            hash = (37 * hash) + TOTAL_SUPPLY_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getTotalSupply());
            if (getFrozenSupplyCount() > 0) {
                hash = (37 * hash) + FROZEN_SUPPLY_FIELD_NUMBER;
                hash = (53 * hash) + getFrozenSupplyList().hashCode();
            }
            hash = (37 * hash) + TRX_NUM_FIELD_NUMBER;
            hash = (53 * hash) + getTrxNum();
            hash = (37 * hash) + NUM_FIELD_NUMBER;
            hash = (53 * hash) + getNum();
            hash = (37 * hash) + START_TIME_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getStartTime());
            hash = (37 * hash) + END_TIME_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getEndTime());
            hash = (37 * hash) + ORDER_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getOrder());
            hash = (37 * hash) + VOTE_SCORE_FIELD_NUMBER;
            hash = (53 * hash) + getVoteScore();
            hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
            hash = (53 * hash) + getDescription().hashCode();
            hash = (37 * hash) + URL_FIELD_NUMBER;
            hash = (53 * hash) + getUrl().hashCode();
            hash = (37 * hash) + FREE_ASSET_NET_LIMIT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getFreeAssetNetLimit());
            hash = (37 * hash) + PUBLIC_FREE_ASSET_NET_LIMIT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getPublicFreeAssetNetLimit());
            hash = (37 * hash) + PUBLIC_FREE_ASSET_NET_USAGE_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getPublicFreeAssetNetUsage());
            hash = (37 * hash) + PUBLIC_LATEST_FREE_NET_TIME_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getPublicLatestFreeNetTime());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.AssetIssueContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.AssetIssueContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AssetIssueContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.AssetIssueContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AssetIssueContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.AssetIssueContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AssetIssueContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.AssetIssueContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AssetIssueContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.AssetIssueContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.AssetIssueContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.AssetIssueContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.AssetIssueContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.AssetIssueContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.AssetIssueContract)
                com.cryptowallet.crypto.Contract.AssetIssueContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_AssetIssueContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_AssetIssueContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.AssetIssueContract.class, com.cryptowallet.crypto.Contract.AssetIssueContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.AssetIssueContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                    getFrozenSupplyFieldBuilder();
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                name_ = com.google.protobuf.ByteString.EMPTY;

                abbr_ = com.google.protobuf.ByteString.EMPTY;

                totalSupply_ = 0L;

                if (frozenSupplyBuilder_ == null) {
                    frozenSupply_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000010);
                } else {
                    frozenSupplyBuilder_.clear();
                }
                trxNum_ = 0;

                num_ = 0;

                startTime_ = 0L;

                endTime_ = 0L;

                order_ = 0L;

                voteScore_ = 0;

                description_ = com.google.protobuf.ByteString.EMPTY;

                url_ = com.google.protobuf.ByteString.EMPTY;

                freeAssetNetLimit_ = 0L;

                publicFreeAssetNetLimit_ = 0L;

                publicFreeAssetNetUsage_ = 0L;

                publicLatestFreeNetTime_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_AssetIssueContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.AssetIssueContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.AssetIssueContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.AssetIssueContract build() {
                com.cryptowallet.crypto.Contract.AssetIssueContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.AssetIssueContract buildPartial() {
                com.cryptowallet.crypto.Contract.AssetIssueContract result = new com.cryptowallet.crypto.Contract.AssetIssueContract(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                result.ownerAddress_ = ownerAddress_;
                result.name_ = name_;
                result.abbr_ = abbr_;
                result.totalSupply_ = totalSupply_;
                if (frozenSupplyBuilder_ == null) {
                    if (((bitField0_ & 0x00000010) == 0x00000010)) {
                        frozenSupply_ = java.util.Collections.unmodifiableList(frozenSupply_);
                        bitField0_ = (bitField0_ & ~0x00000010);
                    }
                    result.frozenSupply_ = frozenSupply_;
                } else {
                    result.frozenSupply_ = frozenSupplyBuilder_.build();
                }
                result.trxNum_ = trxNum_;
                result.num_ = num_;
                result.startTime_ = startTime_;
                result.endTime_ = endTime_;
                result.order_ = order_;
                result.voteScore_ = voteScore_;
                result.description_ = description_;
                result.url_ = url_;
                result.freeAssetNetLimit_ = freeAssetNetLimit_;
                result.publicFreeAssetNetLimit_ = publicFreeAssetNetLimit_;
                result.publicFreeAssetNetUsage_ = publicFreeAssetNetUsage_;
                result.publicLatestFreeNetTime_ = publicLatestFreeNetTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.AssetIssueContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.AssetIssueContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.AssetIssueContract other) {
                if (other == com.cryptowallet.crypto.Contract.AssetIssueContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getName() != com.google.protobuf.ByteString.EMPTY) {
                    setName(other.getName());
                }
                if (other.getAbbr() != com.google.protobuf.ByteString.EMPTY) {
                    setAbbr(other.getAbbr());
                }
                if (other.getTotalSupply() != 0L) {
                    setTotalSupply(other.getTotalSupply());
                }
                if (frozenSupplyBuilder_ == null) {
                    if (!other.frozenSupply_.isEmpty()) {
                        if (frozenSupply_.isEmpty()) {
                            frozenSupply_ = other.frozenSupply_;
                            bitField0_ = (bitField0_ & ~0x00000010);
                        } else {
                            ensureFrozenSupplyIsMutable();
                            frozenSupply_.addAll(other.frozenSupply_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.frozenSupply_.isEmpty()) {
                        if (frozenSupplyBuilder_.isEmpty()) {
                            frozenSupplyBuilder_.dispose();
                            frozenSupplyBuilder_ = null;
                            frozenSupply_ = other.frozenSupply_;
                            bitField0_ = (bitField0_ & ~0x00000010);
                            frozenSupplyBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                            getFrozenSupplyFieldBuilder() : null;
                        } else {
                            frozenSupplyBuilder_.addAllMessages(other.frozenSupply_);
                        }
                    }
                }
                if (other.getTrxNum() != 0) {
                    setTrxNum(other.getTrxNum());
                }
                if (other.getNum() != 0) {
                    setNum(other.getNum());
                }
                if (other.getStartTime() != 0L) {
                    setStartTime(other.getStartTime());
                }
                if (other.getEndTime() != 0L) {
                    setEndTime(other.getEndTime());
                }
                if (other.getOrder() != 0L) {
                    setOrder(other.getOrder());
                }
                if (other.getVoteScore() != 0) {
                    setVoteScore(other.getVoteScore());
                }
                if (other.getDescription() != com.google.protobuf.ByteString.EMPTY) {
                    setDescription(other.getDescription());
                }
                if (other.getUrl() != com.google.protobuf.ByteString.EMPTY) {
                    setUrl(other.getUrl());
                }
                if (other.getFreeAssetNetLimit() != 0L) {
                    setFreeAssetNetLimit(other.getFreeAssetNetLimit());
                }
                if (other.getPublicFreeAssetNetLimit() != 0L) {
                    setPublicFreeAssetNetLimit(other.getPublicFreeAssetNetLimit());
                }
                if (other.getPublicFreeAssetNetUsage() != 0L) {
                    setPublicFreeAssetNetUsage(other.getPublicFreeAssetNetUsage());
                }
                if (other.getPublicLatestFreeNetTime() != 0L) {
                    setPublicLatestFreeNetTime(other.getPublicLatestFreeNetTime());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.AssetIssueContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.AssetIssueContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
            private int bitField0_;

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString name_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes name = 2;</code>
             */
            public com.google.protobuf.ByteString getName() {
                return name_;
            }
            /**
             * <code>bytes name = 2;</code>
             */
            public Builder setName(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                name_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes name = 2;</code>
             */
            public Builder clearName() {

                name_ = getDefaultInstance().getName();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString abbr_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes abbr = 3;</code>
             */
            public com.google.protobuf.ByteString getAbbr() {
                return abbr_;
            }
            /**
             * <code>bytes abbr = 3;</code>
             */
            public Builder setAbbr(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                abbr_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes abbr = 3;</code>
             */
            public Builder clearAbbr() {

                abbr_ = getDefaultInstance().getAbbr();
                onChanged();
                return this;
            }

            private long totalSupply_ ;
            /**
             * <code>int64 total_supply = 4;</code>
             */
            public long getTotalSupply() {
                return totalSupply_;
            }
            /**
             * <code>int64 total_supply = 4;</code>
             */
            public Builder setTotalSupply(long value) {

                totalSupply_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 total_supply = 4;</code>
             */
            public Builder clearTotalSupply() {

                totalSupply_ = 0L;
                onChanged();
                return this;
            }

            private java.util.List<com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply> frozenSupply_ =
                    java.util.Collections.emptyList();
            private void ensureFrozenSupplyIsMutable() {
                if (!((bitField0_ & 0x00000010) == 0x00000010)) {
                    frozenSupply_ = new java.util.ArrayList<com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply>(frozenSupply_);
                    bitField0_ |= 0x00000010;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply, com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.Builder, com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupplyOrBuilder> frozenSupplyBuilder_;

            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public java.util.List<com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply> getFrozenSupplyList() {
                if (frozenSupplyBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(frozenSupply_);
                } else {
                    return frozenSupplyBuilder_.getMessageList();
                }
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public int getFrozenSupplyCount() {
                if (frozenSupplyBuilder_ == null) {
                    return frozenSupply_.size();
                } else {
                    return frozenSupplyBuilder_.getCount();
                }
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply getFrozenSupply(int index) {
                if (frozenSupplyBuilder_ == null) {
                    return frozenSupply_.get(index);
                } else {
                    return frozenSupplyBuilder_.getMessage(index);
                }
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public Builder setFrozenSupply(
                    int index, com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply value) {
                if (frozenSupplyBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureFrozenSupplyIsMutable();
                    frozenSupply_.set(index, value);
                    onChanged();
                } else {
                    frozenSupplyBuilder_.setMessage(index, value);
                }
                return this;
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public Builder setFrozenSupply(
                    int index, com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.Builder builderForValue) {
                if (frozenSupplyBuilder_ == null) {
                    ensureFrozenSupplyIsMutable();
                    frozenSupply_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    frozenSupplyBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public Builder addFrozenSupply(com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply value) {
                if (frozenSupplyBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureFrozenSupplyIsMutable();
                    frozenSupply_.add(value);
                    onChanged();
                } else {
                    frozenSupplyBuilder_.addMessage(value);
                }
                return this;
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public Builder addFrozenSupply(
                    int index, com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply value) {
                if (frozenSupplyBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureFrozenSupplyIsMutable();
                    frozenSupply_.add(index, value);
                    onChanged();
                } else {
                    frozenSupplyBuilder_.addMessage(index, value);
                }
                return this;
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public Builder addFrozenSupply(
                    com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.Builder builderForValue) {
                if (frozenSupplyBuilder_ == null) {
                    ensureFrozenSupplyIsMutable();
                    frozenSupply_.add(builderForValue.build());
                    onChanged();
                } else {
                    frozenSupplyBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public Builder addFrozenSupply(
                    int index, com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.Builder builderForValue) {
                if (frozenSupplyBuilder_ == null) {
                    ensureFrozenSupplyIsMutable();
                    frozenSupply_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    frozenSupplyBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public Builder addAllFrozenSupply(
                    java.lang.Iterable<? extends com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply> values) {
                if (frozenSupplyBuilder_ == null) {
                    ensureFrozenSupplyIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(
                            values, frozenSupply_);
                    onChanged();
                } else {
                    frozenSupplyBuilder_.addAllMessages(values);
                }
                return this;
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public Builder clearFrozenSupply() {
                if (frozenSupplyBuilder_ == null) {
                    frozenSupply_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000010);
                    onChanged();
                } else {
                    frozenSupplyBuilder_.clear();
                }
                return this;
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public Builder removeFrozenSupply(int index) {
                if (frozenSupplyBuilder_ == null) {
                    ensureFrozenSupplyIsMutable();
                    frozenSupply_.remove(index);
                    onChanged();
                } else {
                    frozenSupplyBuilder_.remove(index);
                }
                return this;
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.Builder getFrozenSupplyBuilder(
                    int index) {
                return getFrozenSupplyFieldBuilder().getBuilder(index);
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupplyOrBuilder getFrozenSupplyOrBuilder(
                    int index) {
                if (frozenSupplyBuilder_ == null) {
                    return frozenSupply_.get(index);  } else {
                    return frozenSupplyBuilder_.getMessageOrBuilder(index);
                }
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public java.util.List<? extends com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupplyOrBuilder>
            getFrozenSupplyOrBuilderList() {
                if (frozenSupplyBuilder_ != null) {
                    return frozenSupplyBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(frozenSupply_);
                }
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.Builder addFrozenSupplyBuilder() {
                return getFrozenSupplyFieldBuilder().addBuilder(
                        com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.getDefaultInstance());
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.Builder addFrozenSupplyBuilder(
                    int index) {
                return getFrozenSupplyFieldBuilder().addBuilder(
                        index, com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.getDefaultInstance());
            }
            /**
             * <code>repeated .protocol.AssetIssueContract.FrozenSupply frozen_supply = 5;</code>
             */
            public java.util.List<com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.Builder>
            getFrozenSupplyBuilderList() {
                return getFrozenSupplyFieldBuilder().getBuilderList();
            }
            private com.google.protobuf.RepeatedFieldBuilderV3<
                    com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply, com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.Builder, com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupplyOrBuilder>
            getFrozenSupplyFieldBuilder() {
                if (frozenSupplyBuilder_ == null) {
                    frozenSupplyBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                            com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply, com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupply.Builder, com.cryptowallet.crypto.Contract.AssetIssueContract.FrozenSupplyOrBuilder>(
                            frozenSupply_,
                            ((bitField0_ & 0x00000010) == 0x00000010),
                            getParentForChildren(),
                            isClean());
                    frozenSupply_ = null;
                }
                return frozenSupplyBuilder_;
            }

            private int trxNum_ ;
            /**
             * <code>int32 trx_num = 6;</code>
             */
            public int getTrxNum() {
                return trxNum_;
            }
            /**
             * <code>int32 trx_num = 6;</code>
             */
            public Builder setTrxNum(int value) {

                trxNum_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int32 trx_num = 6;</code>
             */
            public Builder clearTrxNum() {

                trxNum_ = 0;
                onChanged();
                return this;
            }

            private int num_ ;
            /**
             * <code>int32 num = 8;</code>
             */
            public int getNum() {
                return num_;
            }
            /**
             * <code>int32 num = 8;</code>
             */
            public Builder setNum(int value) {

                num_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int32 num = 8;</code>
             */
            public Builder clearNum() {

                num_ = 0;
                onChanged();
                return this;
            }

            private long startTime_ ;
            /**
             * <code>int64 start_time = 9;</code>
             */
            public long getStartTime() {
                return startTime_;
            }
            /**
             * <code>int64 start_time = 9;</code>
             */
            public Builder setStartTime(long value) {

                startTime_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 start_time = 9;</code>
             */
            public Builder clearStartTime() {

                startTime_ = 0L;
                onChanged();
                return this;
            }

            private long endTime_ ;
            /**
             * <code>int64 end_time = 10;</code>
             */
            public long getEndTime() {
                return endTime_;
            }
            /**
             * <code>int64 end_time = 10;</code>
             */
            public Builder setEndTime(long value) {

                endTime_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 end_time = 10;</code>
             */
            public Builder clearEndTime() {

                endTime_ = 0L;
                onChanged();
                return this;
            }

            private long order_ ;
            /**
             * <pre>
             * the order of tokens of the same name
             * </pre>
             *
             * <code>int64 order = 11;</code>
             */
            public long getOrder() {
                return order_;
            }
            /**
             * <pre>
             * the order of tokens of the same name
             * </pre>
             *
             * <code>int64 order = 11;</code>
             */
            public Builder setOrder(long value) {

                order_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * the order of tokens of the same name
             * </pre>
             *
             * <code>int64 order = 11;</code>
             */
            public Builder clearOrder() {

                order_ = 0L;
                onChanged();
                return this;
            }

            private int voteScore_ ;
            /**
             * <code>int32 vote_score = 16;</code>
             */
            public int getVoteScore() {
                return voteScore_;
            }
            /**
             * <code>int32 vote_score = 16;</code>
             */
            public Builder setVoteScore(int value) {

                voteScore_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int32 vote_score = 16;</code>
             */
            public Builder clearVoteScore() {

                voteScore_ = 0;
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString description_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes description = 20;</code>
             */
            public com.google.protobuf.ByteString getDescription() {
                return description_;
            }
            /**
             * <code>bytes description = 20;</code>
             */
            public Builder setDescription(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                description_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes description = 20;</code>
             */
            public Builder clearDescription() {

                description_ = getDefaultInstance().getDescription();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString url_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes url = 21;</code>
             */
            public com.google.protobuf.ByteString getUrl() {
                return url_;
            }
            /**
             * <code>bytes url = 21;</code>
             */
            public Builder setUrl(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                url_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes url = 21;</code>
             */
            public Builder clearUrl() {

                url_ = getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            private long freeAssetNetLimit_ ;
            /**
             * <code>int64 free_asset_net_limit = 22;</code>
             */
            public long getFreeAssetNetLimit() {
                return freeAssetNetLimit_;
            }
            /**
             * <code>int64 free_asset_net_limit = 22;</code>
             */
            public Builder setFreeAssetNetLimit(long value) {

                freeAssetNetLimit_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 free_asset_net_limit = 22;</code>
             */
            public Builder clearFreeAssetNetLimit() {

                freeAssetNetLimit_ = 0L;
                onChanged();
                return this;
            }

            private long publicFreeAssetNetLimit_ ;
            /**
             * <code>int64 public_free_asset_net_limit = 23;</code>
             */
            public long getPublicFreeAssetNetLimit() {
                return publicFreeAssetNetLimit_;
            }
            /**
             * <code>int64 public_free_asset_net_limit = 23;</code>
             */
            public Builder setPublicFreeAssetNetLimit(long value) {

                publicFreeAssetNetLimit_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 public_free_asset_net_limit = 23;</code>
             */
            public Builder clearPublicFreeAssetNetLimit() {

                publicFreeAssetNetLimit_ = 0L;
                onChanged();
                return this;
            }

            private long publicFreeAssetNetUsage_ ;
            /**
             * <code>int64 public_free_asset_net_usage = 24;</code>
             */
            public long getPublicFreeAssetNetUsage() {
                return publicFreeAssetNetUsage_;
            }
            /**
             * <code>int64 public_free_asset_net_usage = 24;</code>
             */
            public Builder setPublicFreeAssetNetUsage(long value) {

                publicFreeAssetNetUsage_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 public_free_asset_net_usage = 24;</code>
             */
            public Builder clearPublicFreeAssetNetUsage() {

                publicFreeAssetNetUsage_ = 0L;
                onChanged();
                return this;
            }

            private long publicLatestFreeNetTime_ ;
            /**
             * <code>int64 public_latest_free_net_time = 25;</code>
             */
            public long getPublicLatestFreeNetTime() {
                return publicLatestFreeNetTime_;
            }
            /**
             * <code>int64 public_latest_free_net_time = 25;</code>
             */
            public Builder setPublicLatestFreeNetTime(long value) {

                publicLatestFreeNetTime_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 public_latest_free_net_time = 25;</code>
             */
            public Builder clearPublicLatestFreeNetTime() {

                publicLatestFreeNetTime_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.AssetIssueContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.AssetIssueContract)
        private static final com.cryptowallet.crypto.Contract.AssetIssueContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.AssetIssueContract();
        }

        public static com.cryptowallet.crypto.Contract.AssetIssueContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<AssetIssueContract>
                PARSER = new com.google.protobuf.AbstractParser<AssetIssueContract>() {
            public AssetIssueContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new AssetIssueContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<AssetIssueContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<AssetIssueContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.AssetIssueContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface ParticipateAssetIssueContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.ParticipateAssetIssueContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>bytes to_address = 2;</code>
         */
        com.google.protobuf.ByteString getToAddress();

        /**
         * <pre>
         * the namekey of target asset, include name and order
         * </pre>
         *
         * <code>bytes asset_name = 3;</code>
         */
        com.google.protobuf.ByteString getAssetName();

        /**
         * <pre>
         * the amount of drops
         * </pre>
         *
         * <code>int64 amount = 4;</code>
         */
        long getAmount();
    }
    /**
     * Protobuf type {@code protocol.ParticipateAssetIssueContract}
     */
    public  static final class ParticipateAssetIssueContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.ParticipateAssetIssueContract)
            ParticipateAssetIssueContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use ParticipateAssetIssueContract.newBuilder() to construct.
        private ParticipateAssetIssueContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private ParticipateAssetIssueContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            toAddress_ = com.google.protobuf.ByteString.EMPTY;
            assetName_ = com.google.protobuf.ByteString.EMPTY;
            amount_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private ParticipateAssetIssueContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 18: {

                            toAddress_ = input.readBytes();
                            break;
                        }
                        case 26: {

                            assetName_ = input.readBytes();
                            break;
                        }
                        case 32: {

                            amount_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ParticipateAssetIssueContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ParticipateAssetIssueContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract.class, com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int TO_ADDRESS_FIELD_NUMBER = 2;
        private com.google.protobuf.ByteString toAddress_;
        /**
         * <code>bytes to_address = 2;</code>
         */
        public com.google.protobuf.ByteString getToAddress() {
            return toAddress_;
        }

        public static final int ASSET_NAME_FIELD_NUMBER = 3;
        private com.google.protobuf.ByteString assetName_;
        /**
         * <pre>
         * the namekey of target asset, include name and order
         * </pre>
         *
         * <code>bytes asset_name = 3;</code>
         */
        public com.google.protobuf.ByteString getAssetName() {
            return assetName_;
        }

        public static final int AMOUNT_FIELD_NUMBER = 4;
        private long amount_;
        /**
         * <pre>
         * the amount of drops
         * </pre>
         *
         * <code>int64 amount = 4;</code>
         */
        public long getAmount() {
            return amount_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (!toAddress_.isEmpty()) {
                output.writeBytes(2, toAddress_);
            }
            if (!assetName_.isEmpty()) {
                output.writeBytes(3, assetName_);
            }
            if (amount_ != 0L) {
                output.writeInt64(4, amount_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (!toAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(2, toAddress_);
            }
            if (!assetName_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(3, assetName_);
            }
            if (amount_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(4, amount_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract other = (com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && getToAddress()
                    .equals(other.getToAddress());
            result = result && getAssetName()
                    .equals(other.getAssetName());
            result = result && (getAmount()
                    == other.getAmount());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + TO_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getToAddress().hashCode();
            hash = (37 * hash) + ASSET_NAME_FIELD_NUMBER;
            hash = (53 * hash) + getAssetName().hashCode();
            hash = (37 * hash) + AMOUNT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getAmount());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.ParticipateAssetIssueContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.ParticipateAssetIssueContract)
                com.cryptowallet.crypto.Contract.ParticipateAssetIssueContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ParticipateAssetIssueContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ParticipateAssetIssueContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract.class, com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                toAddress_ = com.google.protobuf.ByteString.EMPTY;

                assetName_ = com.google.protobuf.ByteString.EMPTY;

                amount_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ParticipateAssetIssueContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract build() {
                com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract buildPartial() {
                com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract result = new com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.toAddress_ = toAddress_;
                result.assetName_ = assetName_;
                result.amount_ = amount_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract other) {
                if (other == com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getToAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setToAddress(other.getToAddress());
                }
                if (other.getAssetName() != com.google.protobuf.ByteString.EMPTY) {
                    setAssetName(other.getAssetName());
                }
                if (other.getAmount() != 0L) {
                    setAmount(other.getAmount());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString toAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes to_address = 2;</code>
             */
            public com.google.protobuf.ByteString getToAddress() {
                return toAddress_;
            }
            /**
             * <code>bytes to_address = 2;</code>
             */
            public Builder setToAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                toAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes to_address = 2;</code>
             */
            public Builder clearToAddress() {

                toAddress_ = getDefaultInstance().getToAddress();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString assetName_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <pre>
             * the namekey of target asset, include name and order
             * </pre>
             *
             * <code>bytes asset_name = 3;</code>
             */
            public com.google.protobuf.ByteString getAssetName() {
                return assetName_;
            }
            /**
             * <pre>
             * the namekey of target asset, include name and order
             * </pre>
             *
             * <code>bytes asset_name = 3;</code>
             */
            public Builder setAssetName(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                assetName_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * the namekey of target asset, include name and order
             * </pre>
             *
             * <code>bytes asset_name = 3;</code>
             */
            public Builder clearAssetName() {

                assetName_ = getDefaultInstance().getAssetName();
                onChanged();
                return this;
            }

            private long amount_ ;
            /**
             * <pre>
             * the amount of drops
             * </pre>
             *
             * <code>int64 amount = 4;</code>
             */
            public long getAmount() {
                return amount_;
            }
            /**
             * <pre>
             * the amount of drops
             * </pre>
             *
             * <code>int64 amount = 4;</code>
             */
            public Builder setAmount(long value) {

                amount_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * the amount of drops
             * </pre>
             *
             * <code>int64 amount = 4;</code>
             */
            public Builder clearAmount() {

                amount_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.ParticipateAssetIssueContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.ParticipateAssetIssueContract)
        private static final com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract();
        }

        public static com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<ParticipateAssetIssueContract>
                PARSER = new com.google.protobuf.AbstractParser<ParticipateAssetIssueContract>() {
            public ParticipateAssetIssueContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new ParticipateAssetIssueContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<ParticipateAssetIssueContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<ParticipateAssetIssueContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.ParticipateAssetIssueContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface FreezeBalanceContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.FreezeBalanceContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>int64 frozen_balance = 2;</code>
         */
        long getFrozenBalance();

        /**
         * <code>int64 frozen_duration = 3;</code>
         */
        long getFrozenDuration();

        /**
         * <code>.protocol.ResourceCode resource = 10;</code>
         */
        int getResourceValue();
        /**
         * <code>.protocol.ResourceCode resource = 10;</code>
         */
        com.cryptowallet.crypto.Contract.ResourceCode getResource();

        /**
         * <code>bytes receiver_address = 15;</code>
         */
        com.google.protobuf.ByteString getReceiverAddress();
    }
    /**
     * Protobuf type {@code protocol.FreezeBalanceContract}
     */
    public  static final class FreezeBalanceContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.FreezeBalanceContract)
            FreezeBalanceContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use FreezeBalanceContract.newBuilder() to construct.
        private FreezeBalanceContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private FreezeBalanceContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            frozenBalance_ = 0L;
            frozenDuration_ = 0L;
            resource_ = 0;
            receiverAddress_ = com.google.protobuf.ByteString.EMPTY;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private FreezeBalanceContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 16: {

                            frozenBalance_ = input.readInt64();
                            break;
                        }
                        case 24: {

                            frozenDuration_ = input.readInt64();
                            break;
                        }
                        case 80: {
                            int rawValue = input.readEnum();

                            resource_ = rawValue;
                            break;
                        }
                        case 122: {

                            receiverAddress_ = input.readBytes();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_FreezeBalanceContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_FreezeBalanceContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.FreezeBalanceContract.class, com.cryptowallet.crypto.Contract.FreezeBalanceContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int FROZEN_BALANCE_FIELD_NUMBER = 2;
        private long frozenBalance_;
        /**
         * <code>int64 frozen_balance = 2;</code>
         */
        public long getFrozenBalance() {
            return frozenBalance_;
        }

        public static final int FROZEN_DURATION_FIELD_NUMBER = 3;
        private long frozenDuration_;
        /**
         * <code>int64 frozen_duration = 3;</code>
         */
        public long getFrozenDuration() {
            return frozenDuration_;
        }

        public static final int RESOURCE_FIELD_NUMBER = 10;
        private int resource_;
        /**
         * <code>.protocol.ResourceCode resource = 10;</code>
         */
        public int getResourceValue() {
            return resource_;
        }
        /**
         * <code>.protocol.ResourceCode resource = 10;</code>
         */
        public com.cryptowallet.crypto.Contract.ResourceCode getResource() {
            com.cryptowallet.crypto.Contract.ResourceCode result = com.cryptowallet.crypto.Contract.ResourceCode.valueOf(resource_);
            return result == null ? com.cryptowallet.crypto.Contract.ResourceCode.UNRECOGNIZED : result;
        }

        public static final int RECEIVER_ADDRESS_FIELD_NUMBER = 15;
        private com.google.protobuf.ByteString receiverAddress_;
        /**
         * <code>bytes receiver_address = 15;</code>
         */
        public com.google.protobuf.ByteString getReceiverAddress() {
            return receiverAddress_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (frozenBalance_ != 0L) {
                output.writeInt64(2, frozenBalance_);
            }
            if (frozenDuration_ != 0L) {
                output.writeInt64(3, frozenDuration_);
            }
            if (resource_ != com.cryptowallet.crypto.Contract.ResourceCode.BANDWIDTH.getNumber()) {
                output.writeEnum(10, resource_);
            }
            if (!receiverAddress_.isEmpty()) {
                output.writeBytes(15, receiverAddress_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (frozenBalance_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(2, frozenBalance_);
            }
            if (frozenDuration_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(3, frozenDuration_);
            }
            if (resource_ != com.cryptowallet.crypto.Contract.ResourceCode.BANDWIDTH.getNumber()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeEnumSize(10, resource_);
            }
            if (!receiverAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(15, receiverAddress_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.FreezeBalanceContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.FreezeBalanceContract other = (com.cryptowallet.crypto.Contract.FreezeBalanceContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && (getFrozenBalance()
                    == other.getFrozenBalance());
            result = result && (getFrozenDuration()
                    == other.getFrozenDuration());
            result = result && resource_ == other.resource_;
            result = result && getReceiverAddress()
                    .equals(other.getReceiverAddress());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + FROZEN_BALANCE_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getFrozenBalance());
            hash = (37 * hash) + FROZEN_DURATION_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getFrozenDuration());
            hash = (37 * hash) + RESOURCE_FIELD_NUMBER;
            hash = (53 * hash) + resource_;
            hash = (37 * hash) + RECEIVER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getReceiverAddress().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.FreezeBalanceContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.FreezeBalanceContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.FreezeBalanceContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.FreezeBalanceContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.FreezeBalanceContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.FreezeBalanceContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.FreezeBalanceContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.FreezeBalanceContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.FreezeBalanceContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.FreezeBalanceContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.FreezeBalanceContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.FreezeBalanceContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.FreezeBalanceContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.FreezeBalanceContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.FreezeBalanceContract)
                com.cryptowallet.crypto.Contract.FreezeBalanceContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_FreezeBalanceContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_FreezeBalanceContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.FreezeBalanceContract.class, com.cryptowallet.crypto.Contract.FreezeBalanceContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.FreezeBalanceContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                frozenBalance_ = 0L;

                frozenDuration_ = 0L;

                resource_ = 0;

                receiverAddress_ = com.google.protobuf.ByteString.EMPTY;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_FreezeBalanceContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.FreezeBalanceContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.FreezeBalanceContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.FreezeBalanceContract build() {
                com.cryptowallet.crypto.Contract.FreezeBalanceContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.FreezeBalanceContract buildPartial() {
                com.cryptowallet.crypto.Contract.FreezeBalanceContract result = new com.cryptowallet.crypto.Contract.FreezeBalanceContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.frozenBalance_ = frozenBalance_;
                result.frozenDuration_ = frozenDuration_;
                result.resource_ = resource_;
                result.receiverAddress_ = receiverAddress_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.FreezeBalanceContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.FreezeBalanceContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.FreezeBalanceContract other) {
                if (other == com.cryptowallet.crypto.Contract.FreezeBalanceContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getFrozenBalance() != 0L) {
                    setFrozenBalance(other.getFrozenBalance());
                }
                if (other.getFrozenDuration() != 0L) {
                    setFrozenDuration(other.getFrozenDuration());
                }
                if (other.resource_ != 0) {
                    setResourceValue(other.getResourceValue());
                }
                if (other.getReceiverAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setReceiverAddress(other.getReceiverAddress());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.FreezeBalanceContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.FreezeBalanceContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private long frozenBalance_ ;
            /**
             * <code>int64 frozen_balance = 2;</code>
             */
            public long getFrozenBalance() {
                return frozenBalance_;
            }
            /**
             * <code>int64 frozen_balance = 2;</code>
             */
            public Builder setFrozenBalance(long value) {

                frozenBalance_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 frozen_balance = 2;</code>
             */
            public Builder clearFrozenBalance() {

                frozenBalance_ = 0L;
                onChanged();
                return this;
            }

            private long frozenDuration_ ;
            /**
             * <code>int64 frozen_duration = 3;</code>
             */
            public long getFrozenDuration() {
                return frozenDuration_;
            }
            /**
             * <code>int64 frozen_duration = 3;</code>
             */
            public Builder setFrozenDuration(long value) {

                frozenDuration_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 frozen_duration = 3;</code>
             */
            public Builder clearFrozenDuration() {

                frozenDuration_ = 0L;
                onChanged();
                return this;
            }

            private int resource_ = 0;
            /**
             * <code>.protocol.ResourceCode resource = 10;</code>
             */
            public int getResourceValue() {
                return resource_;
            }
            /**
             * <code>.protocol.ResourceCode resource = 10;</code>
             */
            public Builder setResourceValue(int value) {
                resource_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>.protocol.ResourceCode resource = 10;</code>
             */
            public com.cryptowallet.crypto.Contract.ResourceCode getResource() {
                com.cryptowallet.crypto.Contract.ResourceCode result = com.cryptowallet.crypto.Contract.ResourceCode.valueOf(resource_);
                return result == null ? com.cryptowallet.crypto.Contract.ResourceCode.UNRECOGNIZED : result;
            }
            /**
             * <code>.protocol.ResourceCode resource = 10;</code>
             */
            public Builder setResource(com.cryptowallet.crypto.Contract.ResourceCode value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                resource_ = value.getNumber();
                onChanged();
                return this;
            }
            /**
             * <code>.protocol.ResourceCode resource = 10;</code>
             */
            public Builder clearResource() {

                resource_ = 0;
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString receiverAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes receiver_address = 15;</code>
             */
            public com.google.protobuf.ByteString getReceiverAddress() {
                return receiverAddress_;
            }
            /**
             * <code>bytes receiver_address = 15;</code>
             */
            public Builder setReceiverAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                receiverAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes receiver_address = 15;</code>
             */
            public Builder clearReceiverAddress() {

                receiverAddress_ = getDefaultInstance().getReceiverAddress();
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.FreezeBalanceContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.FreezeBalanceContract)
        private static final com.cryptowallet.crypto.Contract.FreezeBalanceContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.FreezeBalanceContract();
        }

        public static com.cryptowallet.crypto.Contract.FreezeBalanceContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<FreezeBalanceContract>
                PARSER = new com.google.protobuf.AbstractParser<FreezeBalanceContract>() {
            public FreezeBalanceContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new FreezeBalanceContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<FreezeBalanceContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<FreezeBalanceContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.FreezeBalanceContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface UnfreezeBalanceContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.UnfreezeBalanceContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>.protocol.ResourceCode resource = 10;</code>
         */
        int getResourceValue();
        /**
         * <code>.protocol.ResourceCode resource = 10;</code>
         */
        com.cryptowallet.crypto.Contract.ResourceCode getResource();

        /**
         * <code>bytes receiver_address = 15;</code>
         */
        com.google.protobuf.ByteString getReceiverAddress();
    }
    /**
     * Protobuf type {@code protocol.UnfreezeBalanceContract}
     */
    public  static final class UnfreezeBalanceContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.UnfreezeBalanceContract)
            UnfreezeBalanceContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use UnfreezeBalanceContract.newBuilder() to construct.
        private UnfreezeBalanceContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private UnfreezeBalanceContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            resource_ = 0;
            receiverAddress_ = com.google.protobuf.ByteString.EMPTY;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private UnfreezeBalanceContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 80: {
                            int rawValue = input.readEnum();

                            resource_ = rawValue;
                            break;
                        }
                        case 122: {

                            receiverAddress_ = input.readBytes();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_UnfreezeBalanceContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_UnfreezeBalanceContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.UnfreezeBalanceContract.class, com.cryptowallet.crypto.Contract.UnfreezeBalanceContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int RESOURCE_FIELD_NUMBER = 10;
        private int resource_;
        /**
         * <code>.protocol.ResourceCode resource = 10;</code>
         */
        public int getResourceValue() {
            return resource_;
        }
        /**
         * <code>.protocol.ResourceCode resource = 10;</code>
         */
        public com.cryptowallet.crypto.Contract.ResourceCode getResource() {
            com.cryptowallet.crypto.Contract.ResourceCode result = com.cryptowallet.crypto.Contract.ResourceCode.valueOf(resource_);
            return result == null ? com.cryptowallet.crypto.Contract.ResourceCode.UNRECOGNIZED : result;
        }

        public static final int RECEIVER_ADDRESS_FIELD_NUMBER = 15;
        private com.google.protobuf.ByteString receiverAddress_;
        /**
         * <code>bytes receiver_address = 15;</code>
         */
        public com.google.protobuf.ByteString getReceiverAddress() {
            return receiverAddress_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (resource_ != com.cryptowallet.crypto.Contract.ResourceCode.BANDWIDTH.getNumber()) {
                output.writeEnum(10, resource_);
            }
            if (!receiverAddress_.isEmpty()) {
                output.writeBytes(15, receiverAddress_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (resource_ != com.cryptowallet.crypto.Contract.ResourceCode.BANDWIDTH.getNumber()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeEnumSize(10, resource_);
            }
            if (!receiverAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(15, receiverAddress_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.UnfreezeBalanceContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.UnfreezeBalanceContract other = (com.cryptowallet.crypto.Contract.UnfreezeBalanceContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && resource_ == other.resource_;
            result = result && getReceiverAddress()
                    .equals(other.getReceiverAddress());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + RESOURCE_FIELD_NUMBER;
            hash = (53 * hash) + resource_;
            hash = (37 * hash) + RECEIVER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getReceiverAddress().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.UnfreezeBalanceContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeBalanceContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeBalanceContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeBalanceContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeBalanceContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeBalanceContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeBalanceContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeBalanceContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeBalanceContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeBalanceContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeBalanceContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeBalanceContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.UnfreezeBalanceContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.UnfreezeBalanceContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.UnfreezeBalanceContract)
                com.cryptowallet.crypto.Contract.UnfreezeBalanceContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UnfreezeBalanceContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UnfreezeBalanceContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.UnfreezeBalanceContract.class, com.cryptowallet.crypto.Contract.UnfreezeBalanceContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.UnfreezeBalanceContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                resource_ = 0;

                receiverAddress_ = com.google.protobuf.ByteString.EMPTY;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UnfreezeBalanceContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.UnfreezeBalanceContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.UnfreezeBalanceContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.UnfreezeBalanceContract build() {
                com.cryptowallet.crypto.Contract.UnfreezeBalanceContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.UnfreezeBalanceContract buildPartial() {
                com.cryptowallet.crypto.Contract.UnfreezeBalanceContract result = new com.cryptowallet.crypto.Contract.UnfreezeBalanceContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.resource_ = resource_;
                result.receiverAddress_ = receiverAddress_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.UnfreezeBalanceContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.UnfreezeBalanceContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.UnfreezeBalanceContract other) {
                if (other == com.cryptowallet.crypto.Contract.UnfreezeBalanceContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.resource_ != 0) {
                    setResourceValue(other.getResourceValue());
                }
                if (other.getReceiverAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setReceiverAddress(other.getReceiverAddress());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.UnfreezeBalanceContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.UnfreezeBalanceContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private int resource_ = 0;
            /**
             * <code>.protocol.ResourceCode resource = 10;</code>
             */
            public int getResourceValue() {
                return resource_;
            }
            /**
             * <code>.protocol.ResourceCode resource = 10;</code>
             */
            public Builder setResourceValue(int value) {
                resource_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>.protocol.ResourceCode resource = 10;</code>
             */
            public com.cryptowallet.crypto.Contract.ResourceCode getResource() {
                com.cryptowallet.crypto.Contract.ResourceCode result = com.cryptowallet.crypto.Contract.ResourceCode.valueOf(resource_);
                return result == null ? com.cryptowallet.crypto.Contract.ResourceCode.UNRECOGNIZED : result;
            }
            /**
             * <code>.protocol.ResourceCode resource = 10;</code>
             */
            public Builder setResource(com.cryptowallet.crypto.Contract.ResourceCode value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                resource_ = value.getNumber();
                onChanged();
                return this;
            }
            /**
             * <code>.protocol.ResourceCode resource = 10;</code>
             */
            public Builder clearResource() {

                resource_ = 0;
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString receiverAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes receiver_address = 15;</code>
             */
            public com.google.protobuf.ByteString getReceiverAddress() {
                return receiverAddress_;
            }
            /**
             * <code>bytes receiver_address = 15;</code>
             */
            public Builder setReceiverAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                receiverAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes receiver_address = 15;</code>
             */
            public Builder clearReceiverAddress() {

                receiverAddress_ = getDefaultInstance().getReceiverAddress();
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.UnfreezeBalanceContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.UnfreezeBalanceContract)
        private static final com.cryptowallet.crypto.Contract.UnfreezeBalanceContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.UnfreezeBalanceContract();
        }

        public static com.cryptowallet.crypto.Contract.UnfreezeBalanceContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<UnfreezeBalanceContract>
                PARSER = new com.google.protobuf.AbstractParser<UnfreezeBalanceContract>() {
            public UnfreezeBalanceContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new UnfreezeBalanceContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<UnfreezeBalanceContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<UnfreezeBalanceContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.UnfreezeBalanceContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface UnfreezeAssetContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.UnfreezeAssetContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();
    }
    /**
     * Protobuf type {@code protocol.UnfreezeAssetContract}
     */
    public  static final class UnfreezeAssetContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.UnfreezeAssetContract)
            UnfreezeAssetContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use UnfreezeAssetContract.newBuilder() to construct.
        private UnfreezeAssetContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private UnfreezeAssetContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private UnfreezeAssetContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_UnfreezeAssetContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_UnfreezeAssetContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.UnfreezeAssetContract.class, com.cryptowallet.crypto.Contract.UnfreezeAssetContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.UnfreezeAssetContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.UnfreezeAssetContract other = (com.cryptowallet.crypto.Contract.UnfreezeAssetContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.UnfreezeAssetContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeAssetContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeAssetContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeAssetContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeAssetContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeAssetContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeAssetContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeAssetContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeAssetContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeAssetContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeAssetContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UnfreezeAssetContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.UnfreezeAssetContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.UnfreezeAssetContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.UnfreezeAssetContract)
                com.cryptowallet.crypto.Contract.UnfreezeAssetContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UnfreezeAssetContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UnfreezeAssetContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.UnfreezeAssetContract.class, com.cryptowallet.crypto.Contract.UnfreezeAssetContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.UnfreezeAssetContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UnfreezeAssetContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.UnfreezeAssetContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.UnfreezeAssetContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.UnfreezeAssetContract build() {
                com.cryptowallet.crypto.Contract.UnfreezeAssetContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.UnfreezeAssetContract buildPartial() {
                com.cryptowallet.crypto.Contract.UnfreezeAssetContract result = new com.cryptowallet.crypto.Contract.UnfreezeAssetContract(this);
                result.ownerAddress_ = ownerAddress_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.UnfreezeAssetContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.UnfreezeAssetContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.UnfreezeAssetContract other) {
                if (other == com.cryptowallet.crypto.Contract.UnfreezeAssetContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.UnfreezeAssetContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.UnfreezeAssetContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.UnfreezeAssetContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.UnfreezeAssetContract)
        private static final com.cryptowallet.crypto.Contract.UnfreezeAssetContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.UnfreezeAssetContract();
        }

        public static com.cryptowallet.crypto.Contract.UnfreezeAssetContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<UnfreezeAssetContract>
                PARSER = new com.google.protobuf.AbstractParser<UnfreezeAssetContract>() {
            public UnfreezeAssetContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new UnfreezeAssetContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<UnfreezeAssetContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<UnfreezeAssetContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.UnfreezeAssetContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface WithdrawBalanceContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.WithdrawBalanceContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();
    }
    /**
     * Protobuf type {@code protocol.WithdrawBalanceContract}
     */
    public  static final class WithdrawBalanceContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.WithdrawBalanceContract)
            WithdrawBalanceContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use WithdrawBalanceContract.newBuilder() to construct.
        private WithdrawBalanceContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private WithdrawBalanceContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private WithdrawBalanceContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_WithdrawBalanceContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_WithdrawBalanceContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.WithdrawBalanceContract.class, com.cryptowallet.crypto.Contract.WithdrawBalanceContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.WithdrawBalanceContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.WithdrawBalanceContract other = (com.cryptowallet.crypto.Contract.WithdrawBalanceContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.WithdrawBalanceContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.WithdrawBalanceContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WithdrawBalanceContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.WithdrawBalanceContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WithdrawBalanceContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.WithdrawBalanceContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WithdrawBalanceContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.WithdrawBalanceContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WithdrawBalanceContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.WithdrawBalanceContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.WithdrawBalanceContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.WithdrawBalanceContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.WithdrawBalanceContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.WithdrawBalanceContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.WithdrawBalanceContract)
                com.cryptowallet.crypto.Contract.WithdrawBalanceContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_WithdrawBalanceContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_WithdrawBalanceContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.WithdrawBalanceContract.class, com.cryptowallet.crypto.Contract.WithdrawBalanceContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.WithdrawBalanceContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_WithdrawBalanceContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.WithdrawBalanceContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.WithdrawBalanceContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.WithdrawBalanceContract build() {
                com.cryptowallet.crypto.Contract.WithdrawBalanceContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.WithdrawBalanceContract buildPartial() {
                com.cryptowallet.crypto.Contract.WithdrawBalanceContract result = new com.cryptowallet.crypto.Contract.WithdrawBalanceContract(this);
                result.ownerAddress_ = ownerAddress_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.WithdrawBalanceContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.WithdrawBalanceContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.WithdrawBalanceContract other) {
                if (other == com.cryptowallet.crypto.Contract.WithdrawBalanceContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.WithdrawBalanceContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.WithdrawBalanceContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.WithdrawBalanceContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.WithdrawBalanceContract)
        private static final com.cryptowallet.crypto.Contract.WithdrawBalanceContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.WithdrawBalanceContract();
        }

        public static com.cryptowallet.crypto.Contract.WithdrawBalanceContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<WithdrawBalanceContract>
                PARSER = new com.google.protobuf.AbstractParser<WithdrawBalanceContract>() {
            public WithdrawBalanceContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new WithdrawBalanceContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<WithdrawBalanceContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<WithdrawBalanceContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.WithdrawBalanceContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface UpdateAssetContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.UpdateAssetContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>bytes description = 2;</code>
         */
        com.google.protobuf.ByteString getDescription();

        /**
         * <code>bytes url = 3;</code>
         */
        com.google.protobuf.ByteString getUrl();

        /**
         * <code>int64 new_limit = 4;</code>
         */
        long getNewLimit();

        /**
         * <code>int64 new_public_limit = 5;</code>
         */
        long getNewPublicLimit();
    }
    /**
     * Protobuf type {@code protocol.UpdateAssetContract}
     */
    public  static final class UpdateAssetContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.UpdateAssetContract)
            UpdateAssetContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use UpdateAssetContract.newBuilder() to construct.
        private UpdateAssetContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private UpdateAssetContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            description_ = com.google.protobuf.ByteString.EMPTY;
            url_ = com.google.protobuf.ByteString.EMPTY;
            newLimit_ = 0L;
            newPublicLimit_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private UpdateAssetContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 18: {

                            description_ = input.readBytes();
                            break;
                        }
                        case 26: {

                            url_ = input.readBytes();
                            break;
                        }
                        case 32: {

                            newLimit_ = input.readInt64();
                            break;
                        }
                        case 40: {

                            newPublicLimit_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateAssetContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateAssetContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.UpdateAssetContract.class, com.cryptowallet.crypto.Contract.UpdateAssetContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int DESCRIPTION_FIELD_NUMBER = 2;
        private com.google.protobuf.ByteString description_;
        /**
         * <code>bytes description = 2;</code>
         */
        public com.google.protobuf.ByteString getDescription() {
            return description_;
        }

        public static final int URL_FIELD_NUMBER = 3;
        private com.google.protobuf.ByteString url_;
        /**
         * <code>bytes url = 3;</code>
         */
        public com.google.protobuf.ByteString getUrl() {
            return url_;
        }

        public static final int NEW_LIMIT_FIELD_NUMBER = 4;
        private long newLimit_;
        /**
         * <code>int64 new_limit = 4;</code>
         */
        public long getNewLimit() {
            return newLimit_;
        }

        public static final int NEW_PUBLIC_LIMIT_FIELD_NUMBER = 5;
        private long newPublicLimit_;
        /**
         * <code>int64 new_public_limit = 5;</code>
         */
        public long getNewPublicLimit() {
            return newPublicLimit_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (!description_.isEmpty()) {
                output.writeBytes(2, description_);
            }
            if (!url_.isEmpty()) {
                output.writeBytes(3, url_);
            }
            if (newLimit_ != 0L) {
                output.writeInt64(4, newLimit_);
            }
            if (newPublicLimit_ != 0L) {
                output.writeInt64(5, newPublicLimit_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (!description_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(2, description_);
            }
            if (!url_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(3, url_);
            }
            if (newLimit_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(4, newLimit_);
            }
            if (newPublicLimit_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(5, newPublicLimit_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.UpdateAssetContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.UpdateAssetContract other = (com.cryptowallet.crypto.Contract.UpdateAssetContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && getDescription()
                    .equals(other.getDescription());
            result = result && getUrl()
                    .equals(other.getUrl());
            result = result && (getNewLimit()
                    == other.getNewLimit());
            result = result && (getNewPublicLimit()
                    == other.getNewPublicLimit());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
            hash = (53 * hash) + getDescription().hashCode();
            hash = (37 * hash) + URL_FIELD_NUMBER;
            hash = (53 * hash) + getUrl().hashCode();
            hash = (37 * hash) + NEW_LIMIT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getNewLimit());
            hash = (37 * hash) + NEW_PUBLIC_LIMIT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getNewPublicLimit());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.UpdateAssetContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UpdateAssetContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateAssetContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UpdateAssetContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateAssetContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.UpdateAssetContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateAssetContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UpdateAssetContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateAssetContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UpdateAssetContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.UpdateAssetContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.UpdateAssetContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.UpdateAssetContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.UpdateAssetContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.UpdateAssetContract)
                com.cryptowallet.crypto.Contract.UpdateAssetContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateAssetContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateAssetContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.UpdateAssetContract.class, com.cryptowallet.crypto.Contract.UpdateAssetContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.UpdateAssetContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                description_ = com.google.protobuf.ByteString.EMPTY;

                url_ = com.google.protobuf.ByteString.EMPTY;

                newLimit_ = 0L;

                newPublicLimit_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_UpdateAssetContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.UpdateAssetContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.UpdateAssetContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.UpdateAssetContract build() {
                com.cryptowallet.crypto.Contract.UpdateAssetContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.UpdateAssetContract buildPartial() {
                com.cryptowallet.crypto.Contract.UpdateAssetContract result = new com.cryptowallet.crypto.Contract.UpdateAssetContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.description_ = description_;
                result.url_ = url_;
                result.newLimit_ = newLimit_;
                result.newPublicLimit_ = newPublicLimit_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.UpdateAssetContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.UpdateAssetContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.UpdateAssetContract other) {
                if (other == com.cryptowallet.crypto.Contract.UpdateAssetContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getDescription() != com.google.protobuf.ByteString.EMPTY) {
                    setDescription(other.getDescription());
                }
                if (other.getUrl() != com.google.protobuf.ByteString.EMPTY) {
                    setUrl(other.getUrl());
                }
                if (other.getNewLimit() != 0L) {
                    setNewLimit(other.getNewLimit());
                }
                if (other.getNewPublicLimit() != 0L) {
                    setNewPublicLimit(other.getNewPublicLimit());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.UpdateAssetContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.UpdateAssetContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString description_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes description = 2;</code>
             */
            public com.google.protobuf.ByteString getDescription() {
                return description_;
            }
            /**
             * <code>bytes description = 2;</code>
             */
            public Builder setDescription(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                description_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes description = 2;</code>
             */
            public Builder clearDescription() {

                description_ = getDefaultInstance().getDescription();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString url_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes url = 3;</code>
             */
            public com.google.protobuf.ByteString getUrl() {
                return url_;
            }
            /**
             * <code>bytes url = 3;</code>
             */
            public Builder setUrl(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                url_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes url = 3;</code>
             */
            public Builder clearUrl() {

                url_ = getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            private long newLimit_ ;
            /**
             * <code>int64 new_limit = 4;</code>
             */
            public long getNewLimit() {
                return newLimit_;
            }
            /**
             * <code>int64 new_limit = 4;</code>
             */
            public Builder setNewLimit(long value) {

                newLimit_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 new_limit = 4;</code>
             */
            public Builder clearNewLimit() {

                newLimit_ = 0L;
                onChanged();
                return this;
            }

            private long newPublicLimit_ ;
            /**
             * <code>int64 new_public_limit = 5;</code>
             */
            public long getNewPublicLimit() {
                return newPublicLimit_;
            }
            /**
             * <code>int64 new_public_limit = 5;</code>
             */
            public Builder setNewPublicLimit(long value) {

                newPublicLimit_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 new_public_limit = 5;</code>
             */
            public Builder clearNewPublicLimit() {

                newPublicLimit_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.UpdateAssetContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.UpdateAssetContract)
        private static final com.cryptowallet.crypto.Contract.UpdateAssetContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.UpdateAssetContract();
        }

        public static com.cryptowallet.crypto.Contract.UpdateAssetContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<UpdateAssetContract>
                PARSER = new com.google.protobuf.AbstractParser<UpdateAssetContract>() {
            public UpdateAssetContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new UpdateAssetContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<UpdateAssetContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<UpdateAssetContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.UpdateAssetContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface ProposalCreateContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.ProposalCreateContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>map&lt;int64, int64&gt; parameters = 2;</code>
         */
        int getParametersCount();
        /**
         * <code>map&lt;int64, int64&gt; parameters = 2;</code>
         */
        boolean containsParameters(
                long key);
        /**
         * Use {@link #getParametersMap()} instead.
         */
        @java.lang.Deprecated
        java.util.Map<java.lang.Long, java.lang.Long>
        getParameters();
        /**
         * <code>map&lt;int64, int64&gt; parameters = 2;</code>
         */
        java.util.Map<java.lang.Long, java.lang.Long>
        getParametersMap();
        /**
         * <code>map&lt;int64, int64&gt; parameters = 2;</code>
         */

        long getParametersOrDefault(
                long key,
                long defaultValue);
        /**
         * <code>map&lt;int64, int64&gt; parameters = 2;</code>
         */

        long getParametersOrThrow(
                long key);
    }
    /**
     * Protobuf type {@code protocol.ProposalCreateContract}
     */
    public  static final class ProposalCreateContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.ProposalCreateContract)
            ProposalCreateContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use ProposalCreateContract.newBuilder() to construct.
        private ProposalCreateContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private ProposalCreateContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private ProposalCreateContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 18: {
                            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                                parameters_ = com.google.protobuf.MapField.newMapField(
                                        ParametersDefaultEntryHolder.defaultEntry);
                                mutable_bitField0_ |= 0x00000002;
                            }
                            com.google.protobuf.MapEntry<java.lang.Long, java.lang.Long>
                                    parameters__ = input.readMessage(
                                    ParametersDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                            parameters_.getMutableMap().put(
                                    parameters__.getKey(), parameters__.getValue());
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalCreateContract_descriptor;
        }

        @SuppressWarnings({"rawtypes"})
        protected com.google.protobuf.MapField internalGetMapField(
                int number) {
            switch (number) {
                case 2:
                    return internalGetParameters();
                default:
                    throw new RuntimeException(
                            "Invalid map field number: " + number);
            }
        }
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalCreateContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.ProposalCreateContract.class, com.cryptowallet.crypto.Contract.ProposalCreateContract.Builder.class);
        }

        private int bitField0_;
        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int PARAMETERS_FIELD_NUMBER = 2;
        private static final class ParametersDefaultEntryHolder {
            static final com.google.protobuf.MapEntry<
                    java.lang.Long, java.lang.Long> defaultEntry =
                    com.google.protobuf.MapEntry
                            .<java.lang.Long, java.lang.Long>newDefaultInstance(
                                    com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalCreateContract_ParametersEntry_descriptor,
                                    com.google.protobuf.WireFormat.FieldType.INT64,
                                    0L,
                                    com.google.protobuf.WireFormat.FieldType.INT64,
                                    0L);
        }
        private com.google.protobuf.MapField<
                java.lang.Long, java.lang.Long> parameters_;
        private com.google.protobuf.MapField<java.lang.Long, java.lang.Long>
        internalGetParameters() {
            if (parameters_ == null) {
                return com.google.protobuf.MapField.emptyMapField(
                        ParametersDefaultEntryHolder.defaultEntry);
            }
            return parameters_;
        }

        public int getParametersCount() {
            return internalGetParameters().getMap().size();
        }
        /**
         * <code>map&lt;int64, int64&gt; parameters = 2;</code>
         */

        public boolean containsParameters(
                long key) {

            return internalGetParameters().getMap().containsKey(key);
        }
        /**
         * Use {@link #getParametersMap()} instead.
         */
        @java.lang.Deprecated
        public java.util.Map<java.lang.Long, java.lang.Long> getParameters() {
            return getParametersMap();
        }
        /**
         * <code>map&lt;int64, int64&gt; parameters = 2;</code>
         */

        public java.util.Map<java.lang.Long, java.lang.Long> getParametersMap() {
            return internalGetParameters().getMap();
        }
        /**
         * <code>map&lt;int64, int64&gt; parameters = 2;</code>
         */

        public long getParametersOrDefault(
                long key,
                long defaultValue) {

            java.util.Map<java.lang.Long, java.lang.Long> map =
                    internalGetParameters().getMap();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }
        /**
         * <code>map&lt;int64, int64&gt; parameters = 2;</code>
         */

        public long getParametersOrThrow(
                long key) {

            java.util.Map<java.lang.Long, java.lang.Long> map =
                    internalGetParameters().getMap();
            if (!map.containsKey(key)) {
                throw new java.lang.IllegalArgumentException();
            }
            return map.get(key);
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            com.google.protobuf.GeneratedMessageV3
                    .serializeLongMapTo(
                            output,
                            internalGetParameters(),
                            ParametersDefaultEntryHolder.defaultEntry,
                            2);
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            for (java.util.Map.Entry<java.lang.Long, java.lang.Long> entry
                    : internalGetParameters().getMap().entrySet()) {
                com.google.protobuf.MapEntry<java.lang.Long, java.lang.Long>
                        parameters__ = ParametersDefaultEntryHolder.defaultEntry.newBuilderForType()
                        .setKey(entry.getKey())
                        .setValue(entry.getValue())
                        .build();
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(2, parameters__);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.ProposalCreateContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.ProposalCreateContract other = (com.cryptowallet.crypto.Contract.ProposalCreateContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && internalGetParameters().equals(
                    other.internalGetParameters());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            if (!internalGetParameters().getMap().isEmpty()) {
                hash = (37 * hash) + PARAMETERS_FIELD_NUMBER;
                hash = (53 * hash) + internalGetParameters().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.ProposalCreateContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ProposalCreateContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalCreateContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ProposalCreateContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalCreateContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ProposalCreateContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalCreateContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ProposalCreateContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalCreateContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ProposalCreateContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalCreateContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ProposalCreateContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.ProposalCreateContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.ProposalCreateContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.ProposalCreateContract)
                com.cryptowallet.crypto.Contract.ProposalCreateContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalCreateContract_descriptor;
            }

            @SuppressWarnings({"rawtypes"})
            protected com.google.protobuf.MapField internalGetMapField(
                    int number) {
                switch (number) {
                    case 2:
                        return internalGetParameters();
                    default:
                        throw new RuntimeException(
                                "Invalid map field number: " + number);
                }
            }
            @SuppressWarnings({"rawtypes"})
            protected com.google.protobuf.MapField internalGetMutableMapField(
                    int number) {
                switch (number) {
                    case 2:
                        return internalGetMutableParameters();
                    default:
                        throw new RuntimeException(
                                "Invalid map field number: " + number);
                }
            }
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalCreateContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.ProposalCreateContract.class, com.cryptowallet.crypto.Contract.ProposalCreateContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.ProposalCreateContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                internalGetMutableParameters().clear();
                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalCreateContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.ProposalCreateContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.ProposalCreateContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.ProposalCreateContract build() {
                com.cryptowallet.crypto.Contract.ProposalCreateContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.ProposalCreateContract buildPartial() {
                com.cryptowallet.crypto.Contract.ProposalCreateContract result = new com.cryptowallet.crypto.Contract.ProposalCreateContract(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                result.ownerAddress_ = ownerAddress_;
                result.parameters_ = internalGetParameters();
                result.parameters_.makeImmutable();
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.ProposalCreateContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.ProposalCreateContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.ProposalCreateContract other) {
                if (other == com.cryptowallet.crypto.Contract.ProposalCreateContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                internalGetMutableParameters().mergeFrom(
                        other.internalGetParameters());
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.ProposalCreateContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.ProposalCreateContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
            private int bitField0_;

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private com.google.protobuf.MapField<
                    java.lang.Long, java.lang.Long> parameters_;
            private com.google.protobuf.MapField<java.lang.Long, java.lang.Long>
            internalGetParameters() {
                if (parameters_ == null) {
                    return com.google.protobuf.MapField.emptyMapField(
                            ParametersDefaultEntryHolder.defaultEntry);
                }
                return parameters_;
            }
            private com.google.protobuf.MapField<java.lang.Long, java.lang.Long>
            internalGetMutableParameters() {
                onChanged();;
                if (parameters_ == null) {
                    parameters_ = com.google.protobuf.MapField.newMapField(
                            ParametersDefaultEntryHolder.defaultEntry);
                }
                if (!parameters_.isMutable()) {
                    parameters_ = parameters_.copy();
                }
                return parameters_;
            }

            public int getParametersCount() {
                return internalGetParameters().getMap().size();
            }
            /**
             * <code>map&lt;int64, int64&gt; parameters = 2;</code>
             */

            public boolean containsParameters(
                    long key) {

                return internalGetParameters().getMap().containsKey(key);
            }
            /**
             * Use {@link #getParametersMap()} instead.
             */
            @java.lang.Deprecated
            public java.util.Map<java.lang.Long, java.lang.Long> getParameters() {
                return getParametersMap();
            }
            /**
             * <code>map&lt;int64, int64&gt; parameters = 2;</code>
             */

            public java.util.Map<java.lang.Long, java.lang.Long> getParametersMap() {
                return internalGetParameters().getMap();
            }
            /**
             * <code>map&lt;int64, int64&gt; parameters = 2;</code>
             */

            public long getParametersOrDefault(
                    long key,
                    long defaultValue) {

                java.util.Map<java.lang.Long, java.lang.Long> map =
                        internalGetParameters().getMap();
                return map.containsKey(key) ? map.get(key) : defaultValue;
            }
            /**
             * <code>map&lt;int64, int64&gt; parameters = 2;</code>
             */

            public long getParametersOrThrow(
                    long key) {

                java.util.Map<java.lang.Long, java.lang.Long> map =
                        internalGetParameters().getMap();
                if (!map.containsKey(key)) {
                    throw new java.lang.IllegalArgumentException();
                }
                return map.get(key);
            }

            public Builder clearParameters() {
                internalGetMutableParameters().getMutableMap()
                        .clear();
                return this;
            }
            /**
             * <code>map&lt;int64, int64&gt; parameters = 2;</code>
             */

            public Builder removeParameters(
                    long key) {

                internalGetMutableParameters().getMutableMap()
                        .remove(key);
                return this;
            }
            /**
             * Use alternate mutation accessors instead.
             */
            @java.lang.Deprecated
            public java.util.Map<java.lang.Long, java.lang.Long>
            getMutableParameters() {
                return internalGetMutableParameters().getMutableMap();
            }
            /**
             * <code>map&lt;int64, int64&gt; parameters = 2;</code>
             */
            public Builder putParameters(
                    long key,
                    long value) {


                internalGetMutableParameters().getMutableMap()
                        .put(key, value);
                return this;
            }
            /**
             * <code>map&lt;int64, int64&gt; parameters = 2;</code>
             */

            public Builder putAllParameters(
                    java.util.Map<java.lang.Long, java.lang.Long> values) {
                internalGetMutableParameters().getMutableMap()
                        .putAll(values);
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.ProposalCreateContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.ProposalCreateContract)
        private static final com.cryptowallet.crypto.Contract.ProposalCreateContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.ProposalCreateContract();
        }

        public static com.cryptowallet.crypto.Contract.ProposalCreateContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<ProposalCreateContract>
                PARSER = new com.google.protobuf.AbstractParser<ProposalCreateContract>() {
            public ProposalCreateContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new ProposalCreateContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<ProposalCreateContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<ProposalCreateContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.ProposalCreateContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface ProposalApproveContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.ProposalApproveContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>int64 proposal_id = 2;</code>
         */
        long getProposalId();

        /**
         * <pre>
         * add or remove approval
         * </pre>
         *
         * <code>bool is_add_approval = 3;</code>
         */
        boolean getIsAddApproval();
    }
    /**
     * Protobuf type {@code protocol.ProposalApproveContract}
     */
    public  static final class ProposalApproveContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.ProposalApproveContract)
            ProposalApproveContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use ProposalApproveContract.newBuilder() to construct.
        private ProposalApproveContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private ProposalApproveContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            proposalId_ = 0L;
            isAddApproval_ = false;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private ProposalApproveContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 16: {

                            proposalId_ = input.readInt64();
                            break;
                        }
                        case 24: {

                            isAddApproval_ = input.readBool();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalApproveContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalApproveContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.ProposalApproveContract.class, com.cryptowallet.crypto.Contract.ProposalApproveContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int PROPOSAL_ID_FIELD_NUMBER = 2;
        private long proposalId_;
        /**
         * <code>int64 proposal_id = 2;</code>
         */
        public long getProposalId() {
            return proposalId_;
        }

        public static final int IS_ADD_APPROVAL_FIELD_NUMBER = 3;
        private boolean isAddApproval_;
        /**
         * <pre>
         * add or remove approval
         * </pre>
         *
         * <code>bool is_add_approval = 3;</code>
         */
        public boolean getIsAddApproval() {
            return isAddApproval_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (proposalId_ != 0L) {
                output.writeInt64(2, proposalId_);
            }
            if (isAddApproval_ != false) {
                output.writeBool(3, isAddApproval_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (proposalId_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(2, proposalId_);
            }
            if (isAddApproval_ != false) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBoolSize(3, isAddApproval_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.ProposalApproveContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.ProposalApproveContract other = (com.cryptowallet.crypto.Contract.ProposalApproveContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && (getProposalId()
                    == other.getProposalId());
            result = result && (getIsAddApproval()
                    == other.getIsAddApproval());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + PROPOSAL_ID_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getProposalId());
            hash = (37 * hash) + IS_ADD_APPROVAL_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
                    getIsAddApproval());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.ProposalApproveContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ProposalApproveContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalApproveContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ProposalApproveContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalApproveContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ProposalApproveContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalApproveContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ProposalApproveContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalApproveContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ProposalApproveContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalApproveContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ProposalApproveContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.ProposalApproveContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.ProposalApproveContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.ProposalApproveContract)
                com.cryptowallet.crypto.Contract.ProposalApproveContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalApproveContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalApproveContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.ProposalApproveContract.class, com.cryptowallet.crypto.Contract.ProposalApproveContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.ProposalApproveContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                proposalId_ = 0L;

                isAddApproval_ = false;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalApproveContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.ProposalApproveContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.ProposalApproveContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.ProposalApproveContract build() {
                com.cryptowallet.crypto.Contract.ProposalApproveContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.ProposalApproveContract buildPartial() {
                com.cryptowallet.crypto.Contract.ProposalApproveContract result = new com.cryptowallet.crypto.Contract.ProposalApproveContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.proposalId_ = proposalId_;
                result.isAddApproval_ = isAddApproval_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.ProposalApproveContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.ProposalApproveContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.ProposalApproveContract other) {
                if (other == com.cryptowallet.crypto.Contract.ProposalApproveContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getProposalId() != 0L) {
                    setProposalId(other.getProposalId());
                }
                if (other.getIsAddApproval() != false) {
                    setIsAddApproval(other.getIsAddApproval());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.ProposalApproveContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.ProposalApproveContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private long proposalId_ ;
            /**
             * <code>int64 proposal_id = 2;</code>
             */
            public long getProposalId() {
                return proposalId_;
            }
            /**
             * <code>int64 proposal_id = 2;</code>
             */
            public Builder setProposalId(long value) {

                proposalId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 proposal_id = 2;</code>
             */
            public Builder clearProposalId() {

                proposalId_ = 0L;
                onChanged();
                return this;
            }

            private boolean isAddApproval_ ;
            /**
             * <pre>
             * add or remove approval
             * </pre>
             *
             * <code>bool is_add_approval = 3;</code>
             */
            public boolean getIsAddApproval() {
                return isAddApproval_;
            }
            /**
             * <pre>
             * add or remove approval
             * </pre>
             *
             * <code>bool is_add_approval = 3;</code>
             */
            public Builder setIsAddApproval(boolean value) {

                isAddApproval_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * add or remove approval
             * </pre>
             *
             * <code>bool is_add_approval = 3;</code>
             */
            public Builder clearIsAddApproval() {

                isAddApproval_ = false;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.ProposalApproveContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.ProposalApproveContract)
        private static final com.cryptowallet.crypto.Contract.ProposalApproveContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.ProposalApproveContract();
        }

        public static com.cryptowallet.crypto.Contract.ProposalApproveContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<ProposalApproveContract>
                PARSER = new com.google.protobuf.AbstractParser<ProposalApproveContract>() {
            public ProposalApproveContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new ProposalApproveContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<ProposalApproveContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<ProposalApproveContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.ProposalApproveContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface ProposalDeleteContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.ProposalDeleteContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>int64 proposal_id = 2;</code>
         */
        long getProposalId();
    }
    /**
     * Protobuf type {@code protocol.ProposalDeleteContract}
     */
    public  static final class ProposalDeleteContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.ProposalDeleteContract)
            ProposalDeleteContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use ProposalDeleteContract.newBuilder() to construct.
        private ProposalDeleteContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private ProposalDeleteContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            proposalId_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private ProposalDeleteContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 16: {

                            proposalId_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalDeleteContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalDeleteContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.ProposalDeleteContract.class, com.cryptowallet.crypto.Contract.ProposalDeleteContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int PROPOSAL_ID_FIELD_NUMBER = 2;
        private long proposalId_;
        /**
         * <code>int64 proposal_id = 2;</code>
         */
        public long getProposalId() {
            return proposalId_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (proposalId_ != 0L) {
                output.writeInt64(2, proposalId_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (proposalId_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(2, proposalId_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.ProposalDeleteContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.ProposalDeleteContract other = (com.cryptowallet.crypto.Contract.ProposalDeleteContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && (getProposalId()
                    == other.getProposalId());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + PROPOSAL_ID_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getProposalId());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.ProposalDeleteContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ProposalDeleteContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalDeleteContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ProposalDeleteContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalDeleteContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ProposalDeleteContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalDeleteContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ProposalDeleteContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalDeleteContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ProposalDeleteContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ProposalDeleteContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ProposalDeleteContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.ProposalDeleteContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.ProposalDeleteContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.ProposalDeleteContract)
                com.cryptowallet.crypto.Contract.ProposalDeleteContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalDeleteContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalDeleteContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.ProposalDeleteContract.class, com.cryptowallet.crypto.Contract.ProposalDeleteContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.ProposalDeleteContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                proposalId_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ProposalDeleteContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.ProposalDeleteContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.ProposalDeleteContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.ProposalDeleteContract build() {
                com.cryptowallet.crypto.Contract.ProposalDeleteContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.ProposalDeleteContract buildPartial() {
                com.cryptowallet.crypto.Contract.ProposalDeleteContract result = new com.cryptowallet.crypto.Contract.ProposalDeleteContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.proposalId_ = proposalId_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.ProposalDeleteContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.ProposalDeleteContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.ProposalDeleteContract other) {
                if (other == com.cryptowallet.crypto.Contract.ProposalDeleteContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getProposalId() != 0L) {
                    setProposalId(other.getProposalId());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.ProposalDeleteContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.ProposalDeleteContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private long proposalId_ ;
            /**
             * <code>int64 proposal_id = 2;</code>
             */
            public long getProposalId() {
                return proposalId_;
            }
            /**
             * <code>int64 proposal_id = 2;</code>
             */
            public Builder setProposalId(long value) {

                proposalId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 proposal_id = 2;</code>
             */
            public Builder clearProposalId() {

                proposalId_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.ProposalDeleteContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.ProposalDeleteContract)
        private static final com.cryptowallet.crypto.Contract.ProposalDeleteContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.ProposalDeleteContract();
        }

        public static com.cryptowallet.crypto.Contract.ProposalDeleteContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<ProposalDeleteContract>
                PARSER = new com.google.protobuf.AbstractParser<ProposalDeleteContract>() {
            public ProposalDeleteContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new ProposalDeleteContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<ProposalDeleteContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<ProposalDeleteContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.ProposalDeleteContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface CreateSmartContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.CreateSmartContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>.protocol.SmartContract new_contract = 2;</code>
         */
        boolean hasNewContract();
        /**
         * <code>.protocol.SmartContract new_contract = 2;</code>
         */
        com.cryptowallet.crypto.Protocol.SmartContract getNewContract();
        /**
         * <code>.protocol.SmartContract new_contract = 2;</code>
         */
        com.cryptowallet.crypto.Protocol.SmartContractOrBuilder getNewContractOrBuilder();

        /**
         * <code>int64 call_token_value = 3;</code>
         */
        long getCallTokenValue();

        /**
         * <code>string token_id = 4;</code>
         */
        java.lang.String getTokenId();
        /**
         * <code>string token_id = 4;</code>
         */
        com.google.protobuf.ByteString
        getTokenIdBytes();
    }
    /**
     * Protobuf type {@code protocol.CreateSmartContract}
     */
    public  static final class CreateSmartContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.CreateSmartContract)
            CreateSmartContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use CreateSmartContract.newBuilder() to construct.
        private CreateSmartContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private CreateSmartContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            callTokenValue_ = 0L;
            tokenId_ = "";
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private CreateSmartContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 18: {
                            com.cryptowallet.crypto.Protocol.SmartContract.Builder subBuilder = null;
                            if (newContract_ != null) {
                                subBuilder = newContract_.toBuilder();
                            }
                            newContract_ = input.readMessage(com.cryptowallet.crypto.Protocol.SmartContract.parser(), extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(newContract_);
                                newContract_ = subBuilder.buildPartial();
                            }

                            break;
                        }
                        case 24: {

                            callTokenValue_ = input.readInt64();
                            break;
                        }
                        case 34: {
                            java.lang.String s = input.readStringRequireUtf8();

                            tokenId_ = s;
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_CreateSmartContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_CreateSmartContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.CreateSmartContract.class, com.cryptowallet.crypto.Contract.CreateSmartContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int NEW_CONTRACT_FIELD_NUMBER = 2;
        private com.cryptowallet.crypto.Protocol.SmartContract newContract_;
        /**
         * <code>.protocol.SmartContract new_contract = 2;</code>
         */
        public boolean hasNewContract() {
            return newContract_ != null;
        }
        /**
         * <code>.protocol.SmartContract new_contract = 2;</code>
         */
        public com.cryptowallet.crypto.Protocol.SmartContract getNewContract() {
            return newContract_ == null ? com.cryptowallet.crypto.Protocol.SmartContract.getDefaultInstance() : newContract_;
        }
        /**
         * <code>.protocol.SmartContract new_contract = 2;</code>
         */
        public com.cryptowallet.crypto.Protocol.SmartContractOrBuilder getNewContractOrBuilder() {
            return getNewContract();
        }

        public static final int CALL_TOKEN_VALUE_FIELD_NUMBER = 3;
        private long callTokenValue_;
        /**
         * <code>int64 call_token_value = 3;</code>
         */
        public long getCallTokenValue() {
            return callTokenValue_;
        }

        public static final int TOKEN_ID_FIELD_NUMBER = 4;
        private volatile java.lang.Object tokenId_;
        /**
         * <code>string token_id = 4;</code>
         */
        public java.lang.String getTokenId() {
            java.lang.Object ref = tokenId_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                tokenId_ = s;
                return s;
            }
        }
        /**
         * <code>string token_id = 4;</code>
         */
        public com.google.protobuf.ByteString
        getTokenIdBytes() {
            java.lang.Object ref = tokenId_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                tokenId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (newContract_ != null) {
                output.writeMessage(2, getNewContract());
            }
            if (callTokenValue_ != 0L) {
                output.writeInt64(3, callTokenValue_);
            }
            if (!getTokenIdBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 4, tokenId_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (newContract_ != null) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(2, getNewContract());
            }
            if (callTokenValue_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(3, callTokenValue_);
            }
            if (!getTokenIdBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, tokenId_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.CreateSmartContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.CreateSmartContract other = (com.cryptowallet.crypto.Contract.CreateSmartContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && (hasNewContract() == other.hasNewContract());
            if (hasNewContract()) {
                result = result && getNewContract()
                        .equals(other.getNewContract());
            }
            result = result && (getCallTokenValue()
                    == other.getCallTokenValue());
            result = result && getTokenId()
                    .equals(other.getTokenId());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            if (hasNewContract()) {
                hash = (37 * hash) + NEW_CONTRACT_FIELD_NUMBER;
                hash = (53 * hash) + getNewContract().hashCode();
            }
            hash = (37 * hash) + CALL_TOKEN_VALUE_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getCallTokenValue());
            hash = (37 * hash) + TOKEN_ID_FIELD_NUMBER;
            hash = (53 * hash) + getTokenId().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.CreateSmartContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.CreateSmartContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.CreateSmartContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.CreateSmartContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.CreateSmartContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.CreateSmartContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.CreateSmartContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.CreateSmartContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.CreateSmartContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.CreateSmartContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.CreateSmartContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.CreateSmartContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.CreateSmartContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.CreateSmartContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.CreateSmartContract)
                com.cryptowallet.crypto.Contract.CreateSmartContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_CreateSmartContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_CreateSmartContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.CreateSmartContract.class, com.cryptowallet.crypto.Contract.CreateSmartContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.CreateSmartContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                if (newContractBuilder_ == null) {
                    newContract_ = null;
                } else {
                    newContract_ = null;
                    newContractBuilder_ = null;
                }
                callTokenValue_ = 0L;

                tokenId_ = "";

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_CreateSmartContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.CreateSmartContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.CreateSmartContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.CreateSmartContract build() {
                com.cryptowallet.crypto.Contract.CreateSmartContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.CreateSmartContract buildPartial() {
                com.cryptowallet.crypto.Contract.CreateSmartContract result = new com.cryptowallet.crypto.Contract.CreateSmartContract(this);
                result.ownerAddress_ = ownerAddress_;
                if (newContractBuilder_ == null) {
                    result.newContract_ = newContract_;
                } else {
                    result.newContract_ = newContractBuilder_.build();
                }
                result.callTokenValue_ = callTokenValue_;
                result.tokenId_ = tokenId_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.CreateSmartContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.CreateSmartContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.CreateSmartContract other) {
                if (other == com.cryptowallet.crypto.Contract.CreateSmartContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.hasNewContract()) {
                    mergeNewContract(other.getNewContract());
                }
                if (other.getCallTokenValue() != 0L) {
                    setCallTokenValue(other.getCallTokenValue());
                }
                if (!other.getTokenId().isEmpty()) {
                    tokenId_ = other.tokenId_;
                    onChanged();
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.CreateSmartContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.CreateSmartContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private com.cryptowallet.crypto.Protocol.SmartContract newContract_ = null;
            private com.google.protobuf.SingleFieldBuilderV3<
                    com.cryptowallet.crypto.Protocol.SmartContract, com.cryptowallet.crypto.Protocol.SmartContract.Builder, com.cryptowallet.crypto.Protocol.SmartContractOrBuilder> newContractBuilder_;
            /**
             * <code>.protocol.SmartContract new_contract = 2;</code>
             */
            public boolean hasNewContract() {
                return newContractBuilder_ != null || newContract_ != null;
            }
            /**
             * <code>.protocol.SmartContract new_contract = 2;</code>
             */
            public com.cryptowallet.crypto.Protocol.SmartContract getNewContract() {
                if (newContractBuilder_ == null) {
                    return newContract_ == null ? com.cryptowallet.crypto.Protocol.SmartContract.getDefaultInstance() : newContract_;
                } else {
                    return newContractBuilder_.getMessage();
                }
            }
            /**
             * <code>.protocol.SmartContract new_contract = 2;</code>
             */
            public Builder setNewContract(com.cryptowallet.crypto.Protocol.SmartContract value) {
                if (newContractBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    newContract_ = value;
                    onChanged();
                } else {
                    newContractBuilder_.setMessage(value);
                }

                return this;
            }
            /**
             * <code>.protocol.SmartContract new_contract = 2;</code>
             */
            public Builder setNewContract(
                    com.cryptowallet.crypto.Protocol.SmartContract.Builder builderForValue) {
                if (newContractBuilder_ == null) {
                    newContract_ = builderForValue.build();
                    onChanged();
                } else {
                    newContractBuilder_.setMessage(builderForValue.build());
                }

                return this;
            }
            /**
             * <code>.protocol.SmartContract new_contract = 2;</code>
             */
            public Builder mergeNewContract(com.cryptowallet.crypto.Protocol.SmartContract value) {
                if (newContractBuilder_ == null) {
                    if (newContract_ != null) {
                        newContract_ =
                                com.cryptowallet.crypto.Protocol.SmartContract.newBuilder(newContract_).mergeFrom(value).buildPartial();
                    } else {
                        newContract_ = value;
                    }
                    onChanged();
                } else {
                    newContractBuilder_.mergeFrom(value);
                }

                return this;
            }
            /**
             * <code>.protocol.SmartContract new_contract = 2;</code>
             */
            public Builder clearNewContract() {
                if (newContractBuilder_ == null) {
                    newContract_ = null;
                    onChanged();
                } else {
                    newContract_ = null;
                    newContractBuilder_ = null;
                }

                return this;
            }
            /**
             * <code>.protocol.SmartContract new_contract = 2;</code>
             */
            public com.cryptowallet.crypto.Protocol.SmartContract.Builder getNewContractBuilder() {

                onChanged();
                return getNewContractFieldBuilder().getBuilder();
            }
            /**
             * <code>.protocol.SmartContract new_contract = 2;</code>
             */
            public com.cryptowallet.crypto.Protocol.SmartContractOrBuilder getNewContractOrBuilder() {
                if (newContractBuilder_ != null) {
                    return newContractBuilder_.getMessageOrBuilder();
                } else {
                    return newContract_ == null ?
                            com.cryptowallet.crypto.Protocol.SmartContract.getDefaultInstance() : newContract_;
                }
            }
            /**
             * <code>.protocol.SmartContract new_contract = 2;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    com.cryptowallet.crypto.Protocol.SmartContract, com.cryptowallet.crypto.Protocol.SmartContract.Builder, com.cryptowallet.crypto.Protocol.SmartContractOrBuilder>
            getNewContractFieldBuilder() {
                if (newContractBuilder_ == null) {
                    newContractBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            com.cryptowallet.crypto.Protocol.SmartContract, com.cryptowallet.crypto.Protocol.SmartContract.Builder, com.cryptowallet.crypto.Protocol.SmartContractOrBuilder>(
                            getNewContract(),
                            getParentForChildren(),
                            isClean());
                    newContract_ = null;
                }
                return newContractBuilder_;
            }

            private long callTokenValue_ ;
            /**
             * <code>int64 call_token_value = 3;</code>
             */
            public long getCallTokenValue() {
                return callTokenValue_;
            }
            /**
             * <code>int64 call_token_value = 3;</code>
             */
            public Builder setCallTokenValue(long value) {

                callTokenValue_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 call_token_value = 3;</code>
             */
            public Builder clearCallTokenValue() {

                callTokenValue_ = 0L;
                onChanged();
                return this;
            }

            private java.lang.Object tokenId_ = "";
            /**
             * <code>string token_id = 4;</code>
             */
            public java.lang.String getTokenId() {
                java.lang.Object ref = tokenId_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    tokenId_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string token_id = 4;</code>
             */
            public com.google.protobuf.ByteString
            getTokenIdBytes() {
                java.lang.Object ref = tokenId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    tokenId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string token_id = 4;</code>
             */
            public Builder setTokenId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                tokenId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string token_id = 4;</code>
             */
            public Builder clearTokenId() {

                tokenId_ = getDefaultInstance().getTokenId();
                onChanged();
                return this;
            }
            /**
             * <code>string token_id = 4;</code>
             */
            public Builder setTokenIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                tokenId_ = value;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.CreateSmartContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.CreateSmartContract)
        private static final com.cryptowallet.crypto.Contract.CreateSmartContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.CreateSmartContract();
        }

        public static com.cryptowallet.crypto.Contract.CreateSmartContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<CreateSmartContract>
                PARSER = new com.google.protobuf.AbstractParser<CreateSmartContract>() {
            public CreateSmartContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new CreateSmartContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<CreateSmartContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<CreateSmartContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.CreateSmartContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface TriggerSmartContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.TriggerSmartContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>bytes contract_address = 2;</code>
         */
        com.google.protobuf.ByteString getContractAddress();

        /**
         * <code>int64 call_value = 3;</code>
         */
        long getCallValue();

        /**
         * <code>bytes data = 4;</code>
         */
        com.google.protobuf.ByteString getData();

        /**
         * <code>int64 call_token_value = 5;</code>
         */
        long getCallTokenValue();

        /**
         * <code>string token_id = 6;</code>
         */
        java.lang.String getTokenId();
        /**
         * <code>string token_id = 6;</code>
         */
        com.google.protobuf.ByteString
        getTokenIdBytes();
    }
    /**
     * Protobuf type {@code protocol.TriggerSmartContract}
     */
    public  static final class TriggerSmartContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.TriggerSmartContract)
            TriggerSmartContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use TriggerSmartContract.newBuilder() to construct.
        private TriggerSmartContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private TriggerSmartContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            contractAddress_ = com.google.protobuf.ByteString.EMPTY;
            callValue_ = 0L;
            data_ = com.google.protobuf.ByteString.EMPTY;
            callTokenValue_ = 0L;
            tokenId_ = "";
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private TriggerSmartContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 18: {

                            contractAddress_ = input.readBytes();
                            break;
                        }
                        case 24: {

                            callValue_ = input.readInt64();
                            break;
                        }
                        case 34: {

                            data_ = input.readBytes();
                            break;
                        }
                        case 40: {

                            callTokenValue_ = input.readInt64();
                            break;
                        }
                        case 50: {
                            java.lang.String s = input.readStringRequireUtf8();

                            tokenId_ = s;
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_TriggerSmartContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_TriggerSmartContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.TriggerSmartContract.class, com.cryptowallet.crypto.Contract.TriggerSmartContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int CONTRACT_ADDRESS_FIELD_NUMBER = 2;
        private com.google.protobuf.ByteString contractAddress_;
        /**
         * <code>bytes contract_address = 2;</code>
         */
        public com.google.protobuf.ByteString getContractAddress() {
            return contractAddress_;
        }

        public static final int CALL_VALUE_FIELD_NUMBER = 3;
        private long callValue_;
        /**
         * <code>int64 call_value = 3;</code>
         */
        public long getCallValue() {
            return callValue_;
        }

        public static final int DATA_FIELD_NUMBER = 4;
        private com.google.protobuf.ByteString data_;
        /**
         * <code>bytes data = 4;</code>
         */
        public com.google.protobuf.ByteString getData() {
            return data_;
        }

        public static final int CALL_TOKEN_VALUE_FIELD_NUMBER = 5;
        private long callTokenValue_;
        /**
         * <code>int64 call_token_value = 5;</code>
         */
        public long getCallTokenValue() {
            return callTokenValue_;
        }

        public static final int TOKEN_ID_FIELD_NUMBER = 6;
        private volatile java.lang.Object tokenId_;
        /**
         * <code>string token_id = 6;</code>
         */
        public java.lang.String getTokenId() {
            java.lang.Object ref = tokenId_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                tokenId_ = s;
                return s;
            }
        }
        /**
         * <code>string token_id = 6;</code>
         */
        public com.google.protobuf.ByteString
        getTokenIdBytes() {
            java.lang.Object ref = tokenId_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                tokenId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (!contractAddress_.isEmpty()) {
                output.writeBytes(2, contractAddress_);
            }
            if (callValue_ != 0L) {
                output.writeInt64(3, callValue_);
            }
            if (!data_.isEmpty()) {
                output.writeBytes(4, data_);
            }
            if (callTokenValue_ != 0L) {
                output.writeInt64(5, callTokenValue_);
            }
            if (!getTokenIdBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 6, tokenId_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (!contractAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(2, contractAddress_);
            }
            if (callValue_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(3, callValue_);
            }
            if (!data_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(4, data_);
            }
            if (callTokenValue_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(5, callTokenValue_);
            }
            if (!getTokenIdBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, tokenId_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.TriggerSmartContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.TriggerSmartContract other = (com.cryptowallet.crypto.Contract.TriggerSmartContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && getContractAddress()
                    .equals(other.getContractAddress());
            result = result && (getCallValue()
                    == other.getCallValue());
            result = result && getData()
                    .equals(other.getData());
            result = result && (getCallTokenValue()
                    == other.getCallTokenValue());
            result = result && getTokenId()
                    .equals(other.getTokenId());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + CONTRACT_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getContractAddress().hashCode();
            hash = (37 * hash) + CALL_VALUE_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getCallValue());
            hash = (37 * hash) + DATA_FIELD_NUMBER;
            hash = (53 * hash) + getData().hashCode();
            hash = (37 * hash) + CALL_TOKEN_VALUE_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getCallTokenValue());
            hash = (37 * hash) + TOKEN_ID_FIELD_NUMBER;
            hash = (53 * hash) + getTokenId().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.TriggerSmartContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.TriggerSmartContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TriggerSmartContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.TriggerSmartContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TriggerSmartContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.TriggerSmartContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TriggerSmartContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.TriggerSmartContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TriggerSmartContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.TriggerSmartContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.TriggerSmartContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.TriggerSmartContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.TriggerSmartContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.TriggerSmartContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.TriggerSmartContract)
                com.cryptowallet.crypto.Contract.TriggerSmartContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_TriggerSmartContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_TriggerSmartContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.TriggerSmartContract.class, com.cryptowallet.crypto.Contract.TriggerSmartContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.TriggerSmartContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                contractAddress_ = com.google.protobuf.ByteString.EMPTY;

                callValue_ = 0L;

                data_ = com.google.protobuf.ByteString.EMPTY;

                callTokenValue_ = 0L;

                tokenId_ = "";

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_TriggerSmartContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.TriggerSmartContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.TriggerSmartContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.TriggerSmartContract build() {
                com.cryptowallet.crypto.Contract.TriggerSmartContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.TriggerSmartContract buildPartial() {
                com.cryptowallet.crypto.Contract.TriggerSmartContract result = new com.cryptowallet.crypto.Contract.TriggerSmartContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.contractAddress_ = contractAddress_;
                result.callValue_ = callValue_;
                result.data_ = data_;
                result.callTokenValue_ = callTokenValue_;
                result.tokenId_ = tokenId_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.TriggerSmartContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.TriggerSmartContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.TriggerSmartContract other) {
                if (other == com.cryptowallet.crypto.Contract.TriggerSmartContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getContractAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setContractAddress(other.getContractAddress());
                }
                if (other.getCallValue() != 0L) {
                    setCallValue(other.getCallValue());
                }
                if (other.getData() != com.google.protobuf.ByteString.EMPTY) {
                    setData(other.getData());
                }
                if (other.getCallTokenValue() != 0L) {
                    setCallTokenValue(other.getCallTokenValue());
                }
                if (!other.getTokenId().isEmpty()) {
                    tokenId_ = other.tokenId_;
                    onChanged();
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.TriggerSmartContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.TriggerSmartContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString contractAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes contract_address = 2;</code>
             */
            public com.google.protobuf.ByteString getContractAddress() {
                return contractAddress_;
            }
            /**
             * <code>bytes contract_address = 2;</code>
             */
            public Builder setContractAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                contractAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes contract_address = 2;</code>
             */
            public Builder clearContractAddress() {

                contractAddress_ = getDefaultInstance().getContractAddress();
                onChanged();
                return this;
            }

            private long callValue_ ;
            /**
             * <code>int64 call_value = 3;</code>
             */
            public long getCallValue() {
                return callValue_;
            }
            /**
             * <code>int64 call_value = 3;</code>
             */
            public Builder setCallValue(long value) {

                callValue_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 call_value = 3;</code>
             */
            public Builder clearCallValue() {

                callValue_ = 0L;
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes data = 4;</code>
             */
            public com.google.protobuf.ByteString getData() {
                return data_;
            }
            /**
             * <code>bytes data = 4;</code>
             */
            public Builder setData(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                data_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes data = 4;</code>
             */
            public Builder clearData() {

                data_ = getDefaultInstance().getData();
                onChanged();
                return this;
            }

            private long callTokenValue_ ;
            /**
             * <code>int64 call_token_value = 5;</code>
             */
            public long getCallTokenValue() {
                return callTokenValue_;
            }
            /**
             * <code>int64 call_token_value = 5;</code>
             */
            public Builder setCallTokenValue(long value) {

                callTokenValue_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 call_token_value = 5;</code>
             */
            public Builder clearCallTokenValue() {

                callTokenValue_ = 0L;
                onChanged();
                return this;
            }

            private java.lang.Object tokenId_ = "";
            /**
             * <code>string token_id = 6;</code>
             */
            public java.lang.String getTokenId() {
                java.lang.Object ref = tokenId_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    tokenId_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>string token_id = 6;</code>
             */
            public com.google.protobuf.ByteString
            getTokenIdBytes() {
                java.lang.Object ref = tokenId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    tokenId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>string token_id = 6;</code>
             */
            public Builder setTokenId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                tokenId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>string token_id = 6;</code>
             */
            public Builder clearTokenId() {

                tokenId_ = getDefaultInstance().getTokenId();
                onChanged();
                return this;
            }
            /**
             * <code>string token_id = 6;</code>
             */
            public Builder setTokenIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                tokenId_ = value;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.TriggerSmartContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.TriggerSmartContract)
        private static final com.cryptowallet.crypto.Contract.TriggerSmartContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.TriggerSmartContract();
        }

        public static com.cryptowallet.crypto.Contract.TriggerSmartContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<TriggerSmartContract>
                PARSER = new com.google.protobuf.AbstractParser<TriggerSmartContract>() {
            public TriggerSmartContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new TriggerSmartContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<TriggerSmartContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<TriggerSmartContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.TriggerSmartContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface BuyStorageContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.BuyStorageContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <pre>
         * trx quantity for buy storage (sun)
         * </pre>
         *
         * <code>int64 quant = 2;</code>
         */
        long getQuant();
    }
    /**
     * Protobuf type {@code protocol.BuyStorageContract}
     */
    public  static final class BuyStorageContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.BuyStorageContract)
            BuyStorageContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use BuyStorageContract.newBuilder() to construct.
        private BuyStorageContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private BuyStorageContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            quant_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private BuyStorageContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 16: {

                            quant_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_BuyStorageContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_BuyStorageContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.BuyStorageContract.class, com.cryptowallet.crypto.Contract.BuyStorageContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int QUANT_FIELD_NUMBER = 2;
        private long quant_;
        /**
         * <pre>
         * trx quantity for buy storage (sun)
         * </pre>
         *
         * <code>int64 quant = 2;</code>
         */
        public long getQuant() {
            return quant_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (quant_ != 0L) {
                output.writeInt64(2, quant_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (quant_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(2, quant_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.BuyStorageContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.BuyStorageContract other = (com.cryptowallet.crypto.Contract.BuyStorageContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && (getQuant()
                    == other.getQuant());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + QUANT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getQuant());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.BuyStorageContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.BuyStorageContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.BuyStorageContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.BuyStorageContract)
                com.cryptowallet.crypto.Contract.BuyStorageContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_BuyStorageContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_BuyStorageContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.BuyStorageContract.class, com.cryptowallet.crypto.Contract.BuyStorageContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.BuyStorageContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                quant_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_BuyStorageContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.BuyStorageContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.BuyStorageContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.BuyStorageContract build() {
                com.cryptowallet.crypto.Contract.BuyStorageContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.BuyStorageContract buildPartial() {
                com.cryptowallet.crypto.Contract.BuyStorageContract result = new com.cryptowallet.crypto.Contract.BuyStorageContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.quant_ = quant_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.BuyStorageContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.BuyStorageContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.BuyStorageContract other) {
                if (other == com.cryptowallet.crypto.Contract.BuyStorageContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getQuant() != 0L) {
                    setQuant(other.getQuant());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.BuyStorageContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.BuyStorageContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private long quant_ ;
            /**
             * <pre>
             * trx quantity for buy storage (sun)
             * </pre>
             *
             * <code>int64 quant = 2;</code>
             */
            public long getQuant() {
                return quant_;
            }
            /**
             * <pre>
             * trx quantity for buy storage (sun)
             * </pre>
             *
             * <code>int64 quant = 2;</code>
             */
            public Builder setQuant(long value) {

                quant_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * trx quantity for buy storage (sun)
             * </pre>
             *
             * <code>int64 quant = 2;</code>
             */
            public Builder clearQuant() {

                quant_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.BuyStorageContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.BuyStorageContract)
        private static final com.cryptowallet.crypto.Contract.BuyStorageContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.BuyStorageContract();
        }

        public static com.cryptowallet.crypto.Contract.BuyStorageContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<BuyStorageContract>
                PARSER = new com.google.protobuf.AbstractParser<BuyStorageContract>() {
            public BuyStorageContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new BuyStorageContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<BuyStorageContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<BuyStorageContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.BuyStorageContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface BuyStorageBytesContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.BuyStorageBytesContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <pre>
         * storage bytes for buy
         * </pre>
         *
         * <code>int64 bytes = 2;</code>
         */
        long getBytes();
    }
    /**
     * Protobuf type {@code protocol.BuyStorageBytesContract}
     */
    public  static final class BuyStorageBytesContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.BuyStorageBytesContract)
            BuyStorageBytesContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use BuyStorageBytesContract.newBuilder() to construct.
        private BuyStorageBytesContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private BuyStorageBytesContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            bytes_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private BuyStorageBytesContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 16: {

                            bytes_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_BuyStorageBytesContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_BuyStorageBytesContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.BuyStorageBytesContract.class, com.cryptowallet.crypto.Contract.BuyStorageBytesContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int BYTES_FIELD_NUMBER = 2;
        private long bytes_;
        /**
         * <pre>
         * storage bytes for buy
         * </pre>
         *
         * <code>int64 bytes = 2;</code>
         */
        public long getBytes() {
            return bytes_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (bytes_ != 0L) {
                output.writeInt64(2, bytes_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (bytes_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(2, bytes_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.BuyStorageBytesContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.BuyStorageBytesContract other = (com.cryptowallet.crypto.Contract.BuyStorageBytesContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && (getBytes()
                    == other.getBytes());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + BYTES_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getBytes());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.BuyStorageBytesContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageBytesContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageBytesContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageBytesContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageBytesContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageBytesContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageBytesContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageBytesContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageBytesContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageBytesContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageBytesContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.BuyStorageBytesContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.BuyStorageBytesContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.BuyStorageBytesContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.BuyStorageBytesContract)
                com.cryptowallet.crypto.Contract.BuyStorageBytesContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_BuyStorageBytesContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_BuyStorageBytesContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.BuyStorageBytesContract.class, com.cryptowallet.crypto.Contract.BuyStorageBytesContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.BuyStorageBytesContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                bytes_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_BuyStorageBytesContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.BuyStorageBytesContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.BuyStorageBytesContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.BuyStorageBytesContract build() {
                com.cryptowallet.crypto.Contract.BuyStorageBytesContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.BuyStorageBytesContract buildPartial() {
                com.cryptowallet.crypto.Contract.BuyStorageBytesContract result = new com.cryptowallet.crypto.Contract.BuyStorageBytesContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.bytes_ = bytes_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.BuyStorageBytesContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.BuyStorageBytesContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.BuyStorageBytesContract other) {
                if (other == com.cryptowallet.crypto.Contract.BuyStorageBytesContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getBytes() != 0L) {
                    setBytes(other.getBytes());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.BuyStorageBytesContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.BuyStorageBytesContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private long bytes_ ;
            /**
             * <pre>
             * storage bytes for buy
             * </pre>
             *
             * <code>int64 bytes = 2;</code>
             */
            public long getBytes() {
                return bytes_;
            }
            /**
             * <pre>
             * storage bytes for buy
             * </pre>
             *
             * <code>int64 bytes = 2;</code>
             */
            public Builder setBytes(long value) {

                bytes_ = value;
                onChanged();
                return this;
            }
            /**
             * <pre>
             * storage bytes for buy
             * </pre>
             *
             * <code>int64 bytes = 2;</code>
             */
            public Builder clearBytes() {

                bytes_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.BuyStorageBytesContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.BuyStorageBytesContract)
        private static final com.cryptowallet.crypto.Contract.BuyStorageBytesContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.BuyStorageBytesContract();
        }

        public static com.cryptowallet.crypto.Contract.BuyStorageBytesContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<BuyStorageBytesContract>
                PARSER = new com.google.protobuf.AbstractParser<BuyStorageBytesContract>() {
            public BuyStorageBytesContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new BuyStorageBytesContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<BuyStorageBytesContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<BuyStorageBytesContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.BuyStorageBytesContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface SellStorageContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.SellStorageContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>int64 storage_bytes = 2;</code>
         */
        long getStorageBytes();
    }
    /**
     * Protobuf type {@code protocol.SellStorageContract}
     */
    public  static final class SellStorageContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.SellStorageContract)
            SellStorageContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use SellStorageContract.newBuilder() to construct.
        private SellStorageContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private SellStorageContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            storageBytes_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private SellStorageContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 16: {

                            storageBytes_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_SellStorageContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_SellStorageContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.SellStorageContract.class, com.cryptowallet.crypto.Contract.SellStorageContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int STORAGE_BYTES_FIELD_NUMBER = 2;
        private long storageBytes_;
        /**
         * <code>int64 storage_bytes = 2;</code>
         */
        public long getStorageBytes() {
            return storageBytes_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (storageBytes_ != 0L) {
                output.writeInt64(2, storageBytes_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (storageBytes_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(2, storageBytes_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.SellStorageContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.SellStorageContract other = (com.cryptowallet.crypto.Contract.SellStorageContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && (getStorageBytes()
                    == other.getStorageBytes());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + STORAGE_BYTES_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getStorageBytes());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.SellStorageContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.SellStorageContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.SellStorageContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.SellStorageContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.SellStorageContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.SellStorageContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.SellStorageContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.SellStorageContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.SellStorageContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.SellStorageContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.SellStorageContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.SellStorageContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.SellStorageContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.SellStorageContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.SellStorageContract)
                com.cryptowallet.crypto.Contract.SellStorageContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_SellStorageContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_SellStorageContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.SellStorageContract.class, com.cryptowallet.crypto.Contract.SellStorageContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.SellStorageContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                storageBytes_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_SellStorageContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.SellStorageContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.SellStorageContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.SellStorageContract build() {
                com.cryptowallet.crypto.Contract.SellStorageContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.SellStorageContract buildPartial() {
                com.cryptowallet.crypto.Contract.SellStorageContract result = new com.cryptowallet.crypto.Contract.SellStorageContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.storageBytes_ = storageBytes_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.SellStorageContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.SellStorageContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.SellStorageContract other) {
                if (other == com.cryptowallet.crypto.Contract.SellStorageContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getStorageBytes() != 0L) {
                    setStorageBytes(other.getStorageBytes());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.SellStorageContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.SellStorageContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private long storageBytes_ ;
            /**
             * <code>int64 storage_bytes = 2;</code>
             */
            public long getStorageBytes() {
                return storageBytes_;
            }
            /**
             * <code>int64 storage_bytes = 2;</code>
             */
            public Builder setStorageBytes(long value) {

                storageBytes_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 storage_bytes = 2;</code>
             */
            public Builder clearStorageBytes() {

                storageBytes_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.SellStorageContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.SellStorageContract)
        private static final com.cryptowallet.crypto.Contract.SellStorageContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.SellStorageContract();
        }

        public static com.cryptowallet.crypto.Contract.SellStorageContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<SellStorageContract>
                PARSER = new com.google.protobuf.AbstractParser<SellStorageContract>() {
            public SellStorageContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new SellStorageContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<SellStorageContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<SellStorageContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.SellStorageContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface ExchangeCreateContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.ExchangeCreateContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>bytes first_token_id = 2;</code>
         */
        com.google.protobuf.ByteString getFirstTokenId();

        /**
         * <code>int64 first_token_balance = 3;</code>
         */
        long getFirstTokenBalance();

        /**
         * <code>bytes second_token_id = 4;</code>
         */
        com.google.protobuf.ByteString getSecondTokenId();

        /**
         * <code>int64 second_token_balance = 5;</code>
         */
        long getSecondTokenBalance();
    }
    /**
     * Protobuf type {@code protocol.ExchangeCreateContract}
     */
    public  static final class ExchangeCreateContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.ExchangeCreateContract)
            ExchangeCreateContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use ExchangeCreateContract.newBuilder() to construct.
        private ExchangeCreateContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private ExchangeCreateContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            firstTokenId_ = com.google.protobuf.ByteString.EMPTY;
            firstTokenBalance_ = 0L;
            secondTokenId_ = com.google.protobuf.ByteString.EMPTY;
            secondTokenBalance_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private ExchangeCreateContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 18: {

                            firstTokenId_ = input.readBytes();
                            break;
                        }
                        case 24: {

                            firstTokenBalance_ = input.readInt64();
                            break;
                        }
                        case 34: {

                            secondTokenId_ = input.readBytes();
                            break;
                        }
                        case 40: {

                            secondTokenBalance_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeCreateContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeCreateContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.ExchangeCreateContract.class, com.cryptowallet.crypto.Contract.ExchangeCreateContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int FIRST_TOKEN_ID_FIELD_NUMBER = 2;
        private com.google.protobuf.ByteString firstTokenId_;
        /**
         * <code>bytes first_token_id = 2;</code>
         */
        public com.google.protobuf.ByteString getFirstTokenId() {
            return firstTokenId_;
        }

        public static final int FIRST_TOKEN_BALANCE_FIELD_NUMBER = 3;
        private long firstTokenBalance_;
        /**
         * <code>int64 first_token_balance = 3;</code>
         */
        public long getFirstTokenBalance() {
            return firstTokenBalance_;
        }

        public static final int SECOND_TOKEN_ID_FIELD_NUMBER = 4;
        private com.google.protobuf.ByteString secondTokenId_;
        /**
         * <code>bytes second_token_id = 4;</code>
         */
        public com.google.protobuf.ByteString getSecondTokenId() {
            return secondTokenId_;
        }

        public static final int SECOND_TOKEN_BALANCE_FIELD_NUMBER = 5;
        private long secondTokenBalance_;
        /**
         * <code>int64 second_token_balance = 5;</code>
         */
        public long getSecondTokenBalance() {
            return secondTokenBalance_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (!firstTokenId_.isEmpty()) {
                output.writeBytes(2, firstTokenId_);
            }
            if (firstTokenBalance_ != 0L) {
                output.writeInt64(3, firstTokenBalance_);
            }
            if (!secondTokenId_.isEmpty()) {
                output.writeBytes(4, secondTokenId_);
            }
            if (secondTokenBalance_ != 0L) {
                output.writeInt64(5, secondTokenBalance_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (!firstTokenId_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(2, firstTokenId_);
            }
            if (firstTokenBalance_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(3, firstTokenBalance_);
            }
            if (!secondTokenId_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(4, secondTokenId_);
            }
            if (secondTokenBalance_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(5, secondTokenBalance_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.ExchangeCreateContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.ExchangeCreateContract other = (com.cryptowallet.crypto.Contract.ExchangeCreateContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && getFirstTokenId()
                    .equals(other.getFirstTokenId());
            result = result && (getFirstTokenBalance()
                    == other.getFirstTokenBalance());
            result = result && getSecondTokenId()
                    .equals(other.getSecondTokenId());
            result = result && (getSecondTokenBalance()
                    == other.getSecondTokenBalance());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + FIRST_TOKEN_ID_FIELD_NUMBER;
            hash = (53 * hash) + getFirstTokenId().hashCode();
            hash = (37 * hash) + FIRST_TOKEN_BALANCE_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getFirstTokenBalance());
            hash = (37 * hash) + SECOND_TOKEN_ID_FIELD_NUMBER;
            hash = (53 * hash) + getSecondTokenId().hashCode();
            hash = (37 * hash) + SECOND_TOKEN_BALANCE_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getSecondTokenBalance());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.ExchangeCreateContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeCreateContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeCreateContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeCreateContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeCreateContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeCreateContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeCreateContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeCreateContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeCreateContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeCreateContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeCreateContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeCreateContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.ExchangeCreateContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.ExchangeCreateContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.ExchangeCreateContract)
                com.cryptowallet.crypto.Contract.ExchangeCreateContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeCreateContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeCreateContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.ExchangeCreateContract.class, com.cryptowallet.crypto.Contract.ExchangeCreateContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.ExchangeCreateContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                firstTokenId_ = com.google.protobuf.ByteString.EMPTY;

                firstTokenBalance_ = 0L;

                secondTokenId_ = com.google.protobuf.ByteString.EMPTY;

                secondTokenBalance_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeCreateContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.ExchangeCreateContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.ExchangeCreateContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.ExchangeCreateContract build() {
                com.cryptowallet.crypto.Contract.ExchangeCreateContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.ExchangeCreateContract buildPartial() {
                com.cryptowallet.crypto.Contract.ExchangeCreateContract result = new com.cryptowallet.crypto.Contract.ExchangeCreateContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.firstTokenId_ = firstTokenId_;
                result.firstTokenBalance_ = firstTokenBalance_;
                result.secondTokenId_ = secondTokenId_;
                result.secondTokenBalance_ = secondTokenBalance_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.ExchangeCreateContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.ExchangeCreateContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.ExchangeCreateContract other) {
                if (other == com.cryptowallet.crypto.Contract.ExchangeCreateContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getFirstTokenId() != com.google.protobuf.ByteString.EMPTY) {
                    setFirstTokenId(other.getFirstTokenId());
                }
                if (other.getFirstTokenBalance() != 0L) {
                    setFirstTokenBalance(other.getFirstTokenBalance());
                }
                if (other.getSecondTokenId() != com.google.protobuf.ByteString.EMPTY) {
                    setSecondTokenId(other.getSecondTokenId());
                }
                if (other.getSecondTokenBalance() != 0L) {
                    setSecondTokenBalance(other.getSecondTokenBalance());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.ExchangeCreateContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.ExchangeCreateContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString firstTokenId_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes first_token_id = 2;</code>
             */
            public com.google.protobuf.ByteString getFirstTokenId() {
                return firstTokenId_;
            }
            /**
             * <code>bytes first_token_id = 2;</code>
             */
            public Builder setFirstTokenId(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                firstTokenId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes first_token_id = 2;</code>
             */
            public Builder clearFirstTokenId() {

                firstTokenId_ = getDefaultInstance().getFirstTokenId();
                onChanged();
                return this;
            }

            private long firstTokenBalance_ ;
            /**
             * <code>int64 first_token_balance = 3;</code>
             */
            public long getFirstTokenBalance() {
                return firstTokenBalance_;
            }
            /**
             * <code>int64 first_token_balance = 3;</code>
             */
            public Builder setFirstTokenBalance(long value) {

                firstTokenBalance_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 first_token_balance = 3;</code>
             */
            public Builder clearFirstTokenBalance() {

                firstTokenBalance_ = 0L;
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString secondTokenId_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes second_token_id = 4;</code>
             */
            public com.google.protobuf.ByteString getSecondTokenId() {
                return secondTokenId_;
            }
            /**
             * <code>bytes second_token_id = 4;</code>
             */
            public Builder setSecondTokenId(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                secondTokenId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes second_token_id = 4;</code>
             */
            public Builder clearSecondTokenId() {

                secondTokenId_ = getDefaultInstance().getSecondTokenId();
                onChanged();
                return this;
            }

            private long secondTokenBalance_ ;
            /**
             * <code>int64 second_token_balance = 5;</code>
             */
            public long getSecondTokenBalance() {
                return secondTokenBalance_;
            }
            /**
             * <code>int64 second_token_balance = 5;</code>
             */
            public Builder setSecondTokenBalance(long value) {

                secondTokenBalance_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 second_token_balance = 5;</code>
             */
            public Builder clearSecondTokenBalance() {

                secondTokenBalance_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.ExchangeCreateContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.ExchangeCreateContract)
        private static final com.cryptowallet.crypto.Contract.ExchangeCreateContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.ExchangeCreateContract();
        }

        public static com.cryptowallet.crypto.Contract.ExchangeCreateContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<ExchangeCreateContract>
                PARSER = new com.google.protobuf.AbstractParser<ExchangeCreateContract>() {
            public ExchangeCreateContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new ExchangeCreateContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<ExchangeCreateContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<ExchangeCreateContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.ExchangeCreateContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface ExchangeInjectContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.ExchangeInjectContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>int64 exchange_id = 2;</code>
         */
        long getExchangeId();

        /**
         * <code>bytes token_id = 3;</code>
         */
        com.google.protobuf.ByteString getTokenId();

        /**
         * <code>int64 quant = 4;</code>
         */
        long getQuant();
    }
    /**
     * Protobuf type {@code protocol.ExchangeInjectContract}
     */
    public  static final class ExchangeInjectContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.ExchangeInjectContract)
            ExchangeInjectContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use ExchangeInjectContract.newBuilder() to construct.
        private ExchangeInjectContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private ExchangeInjectContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            exchangeId_ = 0L;
            tokenId_ = com.google.protobuf.ByteString.EMPTY;
            quant_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private ExchangeInjectContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 16: {

                            exchangeId_ = input.readInt64();
                            break;
                        }
                        case 26: {

                            tokenId_ = input.readBytes();
                            break;
                        }
                        case 32: {

                            quant_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeInjectContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeInjectContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.ExchangeInjectContract.class, com.cryptowallet.crypto.Contract.ExchangeInjectContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int EXCHANGE_ID_FIELD_NUMBER = 2;
        private long exchangeId_;
        /**
         * <code>int64 exchange_id = 2;</code>
         */
        public long getExchangeId() {
            return exchangeId_;
        }

        public static final int TOKEN_ID_FIELD_NUMBER = 3;
        private com.google.protobuf.ByteString tokenId_;
        /**
         * <code>bytes token_id = 3;</code>
         */
        public com.google.protobuf.ByteString getTokenId() {
            return tokenId_;
        }

        public static final int QUANT_FIELD_NUMBER = 4;
        private long quant_;
        /**
         * <code>int64 quant = 4;</code>
         */
        public long getQuant() {
            return quant_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (exchangeId_ != 0L) {
                output.writeInt64(2, exchangeId_);
            }
            if (!tokenId_.isEmpty()) {
                output.writeBytes(3, tokenId_);
            }
            if (quant_ != 0L) {
                output.writeInt64(4, quant_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (exchangeId_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(2, exchangeId_);
            }
            if (!tokenId_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(3, tokenId_);
            }
            if (quant_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(4, quant_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.ExchangeInjectContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.ExchangeInjectContract other = (com.cryptowallet.crypto.Contract.ExchangeInjectContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && (getExchangeId()
                    == other.getExchangeId());
            result = result && getTokenId()
                    .equals(other.getTokenId());
            result = result && (getQuant()
                    == other.getQuant());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + EXCHANGE_ID_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getExchangeId());
            hash = (37 * hash) + TOKEN_ID_FIELD_NUMBER;
            hash = (53 * hash) + getTokenId().hashCode();
            hash = (37 * hash) + QUANT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getQuant());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.ExchangeInjectContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeInjectContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeInjectContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeInjectContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeInjectContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeInjectContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeInjectContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeInjectContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeInjectContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeInjectContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeInjectContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeInjectContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.ExchangeInjectContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.ExchangeInjectContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.ExchangeInjectContract)
                com.cryptowallet.crypto.Contract.ExchangeInjectContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeInjectContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeInjectContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.ExchangeInjectContract.class, com.cryptowallet.crypto.Contract.ExchangeInjectContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.ExchangeInjectContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                exchangeId_ = 0L;

                tokenId_ = com.google.protobuf.ByteString.EMPTY;

                quant_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeInjectContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.ExchangeInjectContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.ExchangeInjectContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.ExchangeInjectContract build() {
                com.cryptowallet.crypto.Contract.ExchangeInjectContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.ExchangeInjectContract buildPartial() {
                com.cryptowallet.crypto.Contract.ExchangeInjectContract result = new com.cryptowallet.crypto.Contract.ExchangeInjectContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.exchangeId_ = exchangeId_;
                result.tokenId_ = tokenId_;
                result.quant_ = quant_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.ExchangeInjectContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.ExchangeInjectContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.ExchangeInjectContract other) {
                if (other == com.cryptowallet.crypto.Contract.ExchangeInjectContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getExchangeId() != 0L) {
                    setExchangeId(other.getExchangeId());
                }
                if (other.getTokenId() != com.google.protobuf.ByteString.EMPTY) {
                    setTokenId(other.getTokenId());
                }
                if (other.getQuant() != 0L) {
                    setQuant(other.getQuant());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.ExchangeInjectContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.ExchangeInjectContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private long exchangeId_ ;
            /**
             * <code>int64 exchange_id = 2;</code>
             */
            public long getExchangeId() {
                return exchangeId_;
            }
            /**
             * <code>int64 exchange_id = 2;</code>
             */
            public Builder setExchangeId(long value) {

                exchangeId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 exchange_id = 2;</code>
             */
            public Builder clearExchangeId() {

                exchangeId_ = 0L;
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString tokenId_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes token_id = 3;</code>
             */
            public com.google.protobuf.ByteString getTokenId() {
                return tokenId_;
            }
            /**
             * <code>bytes token_id = 3;</code>
             */
            public Builder setTokenId(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                tokenId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes token_id = 3;</code>
             */
            public Builder clearTokenId() {

                tokenId_ = getDefaultInstance().getTokenId();
                onChanged();
                return this;
            }

            private long quant_ ;
            /**
             * <code>int64 quant = 4;</code>
             */
            public long getQuant() {
                return quant_;
            }
            /**
             * <code>int64 quant = 4;</code>
             */
            public Builder setQuant(long value) {

                quant_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 quant = 4;</code>
             */
            public Builder clearQuant() {

                quant_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.ExchangeInjectContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.ExchangeInjectContract)
        private static final com.cryptowallet.crypto.Contract.ExchangeInjectContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.ExchangeInjectContract();
        }

        public static com.cryptowallet.crypto.Contract.ExchangeInjectContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<ExchangeInjectContract>
                PARSER = new com.google.protobuf.AbstractParser<ExchangeInjectContract>() {
            public ExchangeInjectContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new ExchangeInjectContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<ExchangeInjectContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<ExchangeInjectContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.ExchangeInjectContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface ExchangeWithdrawContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.ExchangeWithdrawContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>int64 exchange_id = 2;</code>
         */
        long getExchangeId();

        /**
         * <code>bytes token_id = 3;</code>
         */
        com.google.protobuf.ByteString getTokenId();

        /**
         * <code>int64 quant = 4;</code>
         */
        long getQuant();
    }
    /**
     * Protobuf type {@code protocol.ExchangeWithdrawContract}
     */
    public  static final class ExchangeWithdrawContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.ExchangeWithdrawContract)
            ExchangeWithdrawContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use ExchangeWithdrawContract.newBuilder() to construct.
        private ExchangeWithdrawContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private ExchangeWithdrawContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            exchangeId_ = 0L;
            tokenId_ = com.google.protobuf.ByteString.EMPTY;
            quant_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private ExchangeWithdrawContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 16: {

                            exchangeId_ = input.readInt64();
                            break;
                        }
                        case 26: {

                            tokenId_ = input.readBytes();
                            break;
                        }
                        case 32: {

                            quant_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeWithdrawContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeWithdrawContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.ExchangeWithdrawContract.class, com.cryptowallet.crypto.Contract.ExchangeWithdrawContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int EXCHANGE_ID_FIELD_NUMBER = 2;
        private long exchangeId_;
        /**
         * <code>int64 exchange_id = 2;</code>
         */
        public long getExchangeId() {
            return exchangeId_;
        }

        public static final int TOKEN_ID_FIELD_NUMBER = 3;
        private com.google.protobuf.ByteString tokenId_;
        /**
         * <code>bytes token_id = 3;</code>
         */
        public com.google.protobuf.ByteString getTokenId() {
            return tokenId_;
        }

        public static final int QUANT_FIELD_NUMBER = 4;
        private long quant_;
        /**
         * <code>int64 quant = 4;</code>
         */
        public long getQuant() {
            return quant_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (exchangeId_ != 0L) {
                output.writeInt64(2, exchangeId_);
            }
            if (!tokenId_.isEmpty()) {
                output.writeBytes(3, tokenId_);
            }
            if (quant_ != 0L) {
                output.writeInt64(4, quant_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (exchangeId_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(2, exchangeId_);
            }
            if (!tokenId_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(3, tokenId_);
            }
            if (quant_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(4, quant_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.ExchangeWithdrawContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.ExchangeWithdrawContract other = (com.cryptowallet.crypto.Contract.ExchangeWithdrawContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && (getExchangeId()
                    == other.getExchangeId());
            result = result && getTokenId()
                    .equals(other.getTokenId());
            result = result && (getQuant()
                    == other.getQuant());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + EXCHANGE_ID_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getExchangeId());
            hash = (37 * hash) + TOKEN_ID_FIELD_NUMBER;
            hash = (53 * hash) + getTokenId().hashCode();
            hash = (37 * hash) + QUANT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getQuant());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.ExchangeWithdrawContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeWithdrawContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeWithdrawContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeWithdrawContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeWithdrawContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeWithdrawContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeWithdrawContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeWithdrawContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeWithdrawContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeWithdrawContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeWithdrawContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeWithdrawContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.ExchangeWithdrawContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.ExchangeWithdrawContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.ExchangeWithdrawContract)
                com.cryptowallet.crypto.Contract.ExchangeWithdrawContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeWithdrawContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeWithdrawContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.ExchangeWithdrawContract.class, com.cryptowallet.crypto.Contract.ExchangeWithdrawContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.ExchangeWithdrawContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                exchangeId_ = 0L;

                tokenId_ = com.google.protobuf.ByteString.EMPTY;

                quant_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeWithdrawContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.ExchangeWithdrawContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.ExchangeWithdrawContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.ExchangeWithdrawContract build() {
                com.cryptowallet.crypto.Contract.ExchangeWithdrawContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.ExchangeWithdrawContract buildPartial() {
                com.cryptowallet.crypto.Contract.ExchangeWithdrawContract result = new com.cryptowallet.crypto.Contract.ExchangeWithdrawContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.exchangeId_ = exchangeId_;
                result.tokenId_ = tokenId_;
                result.quant_ = quant_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.ExchangeWithdrawContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.ExchangeWithdrawContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.ExchangeWithdrawContract other) {
                if (other == com.cryptowallet.crypto.Contract.ExchangeWithdrawContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getExchangeId() != 0L) {
                    setExchangeId(other.getExchangeId());
                }
                if (other.getTokenId() != com.google.protobuf.ByteString.EMPTY) {
                    setTokenId(other.getTokenId());
                }
                if (other.getQuant() != 0L) {
                    setQuant(other.getQuant());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.ExchangeWithdrawContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.ExchangeWithdrawContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private long exchangeId_ ;
            /**
             * <code>int64 exchange_id = 2;</code>
             */
            public long getExchangeId() {
                return exchangeId_;
            }
            /**
             * <code>int64 exchange_id = 2;</code>
             */
            public Builder setExchangeId(long value) {

                exchangeId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 exchange_id = 2;</code>
             */
            public Builder clearExchangeId() {

                exchangeId_ = 0L;
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString tokenId_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes token_id = 3;</code>
             */
            public com.google.protobuf.ByteString getTokenId() {
                return tokenId_;
            }
            /**
             * <code>bytes token_id = 3;</code>
             */
            public Builder setTokenId(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                tokenId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes token_id = 3;</code>
             */
            public Builder clearTokenId() {

                tokenId_ = getDefaultInstance().getTokenId();
                onChanged();
                return this;
            }

            private long quant_ ;
            /**
             * <code>int64 quant = 4;</code>
             */
            public long getQuant() {
                return quant_;
            }
            /**
             * <code>int64 quant = 4;</code>
             */
            public Builder setQuant(long value) {

                quant_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 quant = 4;</code>
             */
            public Builder clearQuant() {

                quant_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.ExchangeWithdrawContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.ExchangeWithdrawContract)
        private static final com.cryptowallet.crypto.Contract.ExchangeWithdrawContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.ExchangeWithdrawContract();
        }

        public static com.cryptowallet.crypto.Contract.ExchangeWithdrawContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<ExchangeWithdrawContract>
                PARSER = new com.google.protobuf.AbstractParser<ExchangeWithdrawContract>() {
            public ExchangeWithdrawContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new ExchangeWithdrawContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<ExchangeWithdrawContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<ExchangeWithdrawContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.ExchangeWithdrawContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface ExchangeTransactionContractOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protocol.ExchangeTransactionContract)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>bytes owner_address = 1;</code>
         */
        com.google.protobuf.ByteString getOwnerAddress();

        /**
         * <code>int64 exchange_id = 2;</code>
         */
        long getExchangeId();

        /**
         * <code>bytes token_id = 3;</code>
         */
        com.google.protobuf.ByteString getTokenId();

        /**
         * <code>int64 quant = 4;</code>
         */
        long getQuant();

        /**
         * <code>int64 expected = 5;</code>
         */
        long getExpected();
    }
    /**
     * Protobuf type {@code protocol.ExchangeTransactionContract}
     */
    public  static final class ExchangeTransactionContract extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protocol.ExchangeTransactionContract)
            ExchangeTransactionContractOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use ExchangeTransactionContract.newBuilder() to construct.
        private ExchangeTransactionContract(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private ExchangeTransactionContract() {
            ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            exchangeId_ = 0L;
            tokenId_ = com.google.protobuf.ByteString.EMPTY;
            quant_ = 0L;
            expected_ = 0L;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private ExchangeTransactionContract(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownFieldProto3(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {

                            ownerAddress_ = input.readBytes();
                            break;
                        }
                        case 16: {

                            exchangeId_ = input.readInt64();
                            break;
                        }
                        case 26: {

                            tokenId_ = input.readBytes();
                            break;
                        }
                        case 32: {

                            quant_ = input.readInt64();
                            break;
                        }
                        case 40: {

                            expected_ = input.readInt64();
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeTransactionContract_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeTransactionContract_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.cryptowallet.crypto.Contract.ExchangeTransactionContract.class, com.cryptowallet.crypto.Contract.ExchangeTransactionContract.Builder.class);
        }

        public static final int OWNER_ADDRESS_FIELD_NUMBER = 1;
        private com.google.protobuf.ByteString ownerAddress_;
        /**
         * <code>bytes owner_address = 1;</code>
         */
        public com.google.protobuf.ByteString getOwnerAddress() {
            return ownerAddress_;
        }

        public static final int EXCHANGE_ID_FIELD_NUMBER = 2;
        private long exchangeId_;
        /**
         * <code>int64 exchange_id = 2;</code>
         */
        public long getExchangeId() {
            return exchangeId_;
        }

        public static final int TOKEN_ID_FIELD_NUMBER = 3;
        private com.google.protobuf.ByteString tokenId_;
        /**
         * <code>bytes token_id = 3;</code>
         */
        public com.google.protobuf.ByteString getTokenId() {
            return tokenId_;
        }

        public static final int QUANT_FIELD_NUMBER = 4;
        private long quant_;
        /**
         * <code>int64 quant = 4;</code>
         */
        public long getQuant() {
            return quant_;
        }

        public static final int EXPECTED_FIELD_NUMBER = 5;
        private long expected_;
        /**
         * <code>int64 expected = 5;</code>
         */
        public long getExpected() {
            return expected_;
        }

        private byte memoizedIsInitialized = -1;
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!ownerAddress_.isEmpty()) {
                output.writeBytes(1, ownerAddress_);
            }
            if (exchangeId_ != 0L) {
                output.writeInt64(2, exchangeId_);
            }
            if (!tokenId_.isEmpty()) {
                output.writeBytes(3, tokenId_);
            }
            if (quant_ != 0L) {
                output.writeInt64(4, quant_);
            }
            if (expected_ != 0L) {
                output.writeInt64(5, expected_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!ownerAddress_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(1, ownerAddress_);
            }
            if (exchangeId_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(2, exchangeId_);
            }
            if (!tokenId_.isEmpty()) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBytesSize(3, tokenId_);
            }
            if (quant_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(4, quant_);
            }
            if (expected_ != 0L) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(5, expected_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.cryptowallet.crypto.Contract.ExchangeTransactionContract)) {
                return super.equals(obj);
            }
            com.cryptowallet.crypto.Contract.ExchangeTransactionContract other = (com.cryptowallet.crypto.Contract.ExchangeTransactionContract) obj;

            boolean result = true;
            result = result && getOwnerAddress()
                    .equals(other.getOwnerAddress());
            result = result && (getExchangeId()
                    == other.getExchangeId());
            result = result && getTokenId()
                    .equals(other.getTokenId());
            result = result && (getQuant()
                    == other.getQuant());
            result = result && (getExpected()
                    == other.getExpected());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + OWNER_ADDRESS_FIELD_NUMBER;
            hash = (53 * hash) + getOwnerAddress().hashCode();
            hash = (37 * hash) + EXCHANGE_ID_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getExchangeId());
            hash = (37 * hash) + TOKEN_ID_FIELD_NUMBER;
            hash = (53 * hash) + getTokenId().hashCode();
            hash = (37 * hash) + QUANT_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getQuant());
            hash = (37 * hash) + EXPECTED_FIELD_NUMBER;
            hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                    getExpected());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static com.cryptowallet.crypto.Contract.ExchangeTransactionContract parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeTransactionContract parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeTransactionContract parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeTransactionContract parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeTransactionContract parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeTransactionContract parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeTransactionContract parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeTransactionContract parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeTransactionContract parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeTransactionContract parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeTransactionContract parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static com.cryptowallet.crypto.Contract.ExchangeTransactionContract parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(com.cryptowallet.crypto.Contract.ExchangeTransactionContract prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code protocol.ExchangeTransactionContract}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protocol.ExchangeTransactionContract)
                com.cryptowallet.crypto.Contract.ExchangeTransactionContractOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeTransactionContract_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeTransactionContract_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.cryptowallet.crypto.Contract.ExchangeTransactionContract.class, com.cryptowallet.crypto.Contract.ExchangeTransactionContract.Builder.class);
            }

            // Construct using com.cryptowallet.crypto.Contract.ExchangeTransactionContract.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            public Builder clear() {
                super.clear();
                ownerAddress_ = com.google.protobuf.ByteString.EMPTY;

                exchangeId_ = 0L;

                tokenId_ = com.google.protobuf.ByteString.EMPTY;

                quant_ = 0L;

                expected_ = 0L;

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return com.cryptowallet.crypto.Contract.internal_static_protocol_ExchangeTransactionContract_descriptor;
            }

            public com.cryptowallet.crypto.Contract.ExchangeTransactionContract getDefaultInstanceForType() {
                return com.cryptowallet.crypto.Contract.ExchangeTransactionContract.getDefaultInstance();
            }

            public com.cryptowallet.crypto.Contract.ExchangeTransactionContract build() {
                com.cryptowallet.crypto.Contract.ExchangeTransactionContract result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.cryptowallet.crypto.Contract.ExchangeTransactionContract buildPartial() {
                com.cryptowallet.crypto.Contract.ExchangeTransactionContract result = new com.cryptowallet.crypto.Contract.ExchangeTransactionContract(this);
                result.ownerAddress_ = ownerAddress_;
                result.exchangeId_ = exchangeId_;
                result.tokenId_ = tokenId_;
                result.quant_ = quant_;
                result.expected_ = expected_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.cryptowallet.crypto.Contract.ExchangeTransactionContract) {
                    return mergeFrom((com.cryptowallet.crypto.Contract.ExchangeTransactionContract)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.cryptowallet.crypto.Contract.ExchangeTransactionContract other) {
                if (other == com.cryptowallet.crypto.Contract.ExchangeTransactionContract.getDefaultInstance()) return this;
                if (other.getOwnerAddress() != com.google.protobuf.ByteString.EMPTY) {
                    setOwnerAddress(other.getOwnerAddress());
                }
                if (other.getExchangeId() != 0L) {
                    setExchangeId(other.getExchangeId());
                }
                if (other.getTokenId() != com.google.protobuf.ByteString.EMPTY) {
                    setTokenId(other.getTokenId());
                }
                if (other.getQuant() != 0L) {
                    setQuant(other.getQuant());
                }
                if (other.getExpected() != 0L) {
                    setExpected(other.getExpected());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                com.cryptowallet.crypto.Contract.ExchangeTransactionContract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.cryptowallet.crypto.Contract.ExchangeTransactionContract) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private com.google.protobuf.ByteString ownerAddress_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public com.google.protobuf.ByteString getOwnerAddress() {
                return ownerAddress_;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder setOwnerAddress(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                ownerAddress_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes owner_address = 1;</code>
             */
            public Builder clearOwnerAddress() {

                ownerAddress_ = getDefaultInstance().getOwnerAddress();
                onChanged();
                return this;
            }

            private long exchangeId_ ;
            /**
             * <code>int64 exchange_id = 2;</code>
             */
            public long getExchangeId() {
                return exchangeId_;
            }
            /**
             * <code>int64 exchange_id = 2;</code>
             */
            public Builder setExchangeId(long value) {

                exchangeId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 exchange_id = 2;</code>
             */
            public Builder clearExchangeId() {

                exchangeId_ = 0L;
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString tokenId_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>bytes token_id = 3;</code>
             */
            public com.google.protobuf.ByteString getTokenId() {
                return tokenId_;
            }
            /**
             * <code>bytes token_id = 3;</code>
             */
            public Builder setTokenId(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                tokenId_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>bytes token_id = 3;</code>
             */
            public Builder clearTokenId() {

                tokenId_ = getDefaultInstance().getTokenId();
                onChanged();
                return this;
            }

            private long quant_ ;
            /**
             * <code>int64 quant = 4;</code>
             */
            public long getQuant() {
                return quant_;
            }
            /**
             * <code>int64 quant = 4;</code>
             */
            public Builder setQuant(long value) {

                quant_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 quant = 4;</code>
             */
            public Builder clearQuant() {

                quant_ = 0L;
                onChanged();
                return this;
            }

            private long expected_ ;
            /**
             * <code>int64 expected = 5;</code>
             */
            public long getExpected() {
                return expected_;
            }
            /**
             * <code>int64 expected = 5;</code>
             */
            public Builder setExpected(long value) {

                expected_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>int64 expected = 5;</code>
             */
            public Builder clearExpected() {

                expected_ = 0L;
                onChanged();
                return this;
            }
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFieldsProto3(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:protocol.ExchangeTransactionContract)
        }

        // @@protoc_insertion_point(class_scope:protocol.ExchangeTransactionContract)
        private static final com.cryptowallet.crypto.Contract.ExchangeTransactionContract DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new com.cryptowallet.crypto.Contract.ExchangeTransactionContract();
        }

        public static com.cryptowallet.crypto.Contract.ExchangeTransactionContract getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<ExchangeTransactionContract>
                PARSER = new com.google.protobuf.AbstractParser<ExchangeTransactionContract>() {
            public ExchangeTransactionContract parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new ExchangeTransactionContract(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<ExchangeTransactionContract> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<ExchangeTransactionContract> getParserForType() {
            return PARSER;
        }

        public com.cryptowallet.crypto.Contract.ExchangeTransactionContract getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_AccountCreateContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_AccountCreateContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_AccountUpdateContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_AccountUpdateContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_SetAccountIdContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_SetAccountIdContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_TransferContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_TransferContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_TransferAssetContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_TransferAssetContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_VoteAssetContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_VoteAssetContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_VoteWitnessContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_VoteWitnessContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_VoteWitnessContract_Vote_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_VoteWitnessContract_Vote_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_UpdateSettingContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_UpdateSettingContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_UpdateEnergyLimitContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_UpdateEnergyLimitContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_WitnessCreateContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_WitnessCreateContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_WitnessUpdateContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_WitnessUpdateContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_AssetIssueContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_AssetIssueContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_AssetIssueContract_FrozenSupply_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_AssetIssueContract_FrozenSupply_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_ParticipateAssetIssueContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_ParticipateAssetIssueContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_FreezeBalanceContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_FreezeBalanceContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_UnfreezeBalanceContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_UnfreezeBalanceContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_UnfreezeAssetContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_UnfreezeAssetContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_WithdrawBalanceContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_WithdrawBalanceContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_UpdateAssetContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_UpdateAssetContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_ProposalCreateContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_ProposalCreateContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_ProposalCreateContract_ParametersEntry_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_ProposalCreateContract_ParametersEntry_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_ProposalApproveContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_ProposalApproveContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_ProposalDeleteContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_ProposalDeleteContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_CreateSmartContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_CreateSmartContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_TriggerSmartContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_TriggerSmartContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_BuyStorageContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_BuyStorageContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_BuyStorageBytesContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_BuyStorageBytesContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_SellStorageContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_SellStorageContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_ExchangeCreateContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_ExchangeCreateContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_ExchangeInjectContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_ExchangeInjectContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_ExchangeWithdrawContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_ExchangeWithdrawContract_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protocol_ExchangeTransactionContract_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protocol_ExchangeTransactionContract_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }
    private static  com.google.protobuf.Descriptors.FileDescriptor
            descriptor;
    static {
        java.lang.String[] descriptorData = {
                "\n\023core/Contract.proto\022\010protocol\032\017core/Tr" +
                        "on.proto\"l\n\025AccountCreateContract\022\025\n\rown" +
                        "er_address\030\001 \001(\014\022\027\n\017account_address\030\002 \001(" +
                        "\014\022#\n\004type\030\003 \001(\0162\025.protocol.AccountType\"D" +
                        "\n\025AccountUpdateContract\022\024\n\014account_name\030" +
                        "\001 \001(\014\022\025\n\rowner_address\030\002 \001(\014\"A\n\024SetAccou" +
                        "ntIdContract\022\022\n\naccount_id\030\001 \001(\014\022\025\n\rowne" +
                        "r_address\030\002 \001(\014\"M\n\020TransferContract\022\025\n\ro" +
                        "wner_address\030\001 \001(\014\022\022\n\nto_address\030\002 \001(\014\022\016" +
                        "\n\006amount\030\003 \001(\003\"f\n\025TransferAssetContract\022" +
                        "\022\n\nasset_name\030\001 \001(\014\022\025\n\rowner_address\030\002 \001" +
                        "(\014\022\022\n\nto_address\030\003 \001(\014\022\016\n\006amount\030\004 \001(\003\"`" +
                        "\n\021VoteAssetContract\022\025\n\rowner_address\030\001 \001" +
                        "(\014\022\024\n\014vote_address\030\002 \003(\014\022\017\n\007support\030\003 \001(" +
                        "\010\022\r\n\005count\030\005 \001(\005\"\242\001\n\023VoteWitnessContract" +
                        "\022\025\n\rowner_address\030\001 \001(\014\0221\n\005votes\030\002 \003(\0132\"" +
                        ".protocol.VoteWitnessContract.Vote\022\017\n\007su" +
                        "pport\030\003 \001(\010\0320\n\004Vote\022\024\n\014vote_address\030\001 \001(" +
                        "\014\022\022\n\nvote_count\030\002 \001(\003\"o\n\025UpdateSettingCo" +
                        "ntract\022\025\n\rowner_address\030\001 \001(\014\022\030\n\020contrac" +
                        "t_address\030\002 \001(\014\022%\n\035consume_user_resource" +
                        "_percent\030\003 \001(\003\"i\n\031UpdateEnergyLimitContr" +
                        "act\022\025\n\rowner_address\030\001 \001(\014\022\030\n\020contract_a" +
                        "ddress\030\002 \001(\014\022\033\n\023origin_energy_limit\030\003 \001(" +
                        "\003\";\n\025WitnessCreateContract\022\025\n\rowner_addr" +
                        "ess\030\001 \001(\014\022\013\n\003url\030\002 \001(\014\"B\n\025WitnessUpdateC" +
                        "ontract\022\025\n\rowner_address\030\001 \001(\014\022\022\n\nupdate" +
                        "_url\030\014 \001(\014\"\361\003\n\022AssetIssueContract\022\025\n\rown" +
                        "er_address\030\001 \001(\014\022\014\n\004name\030\002 \001(\014\022\014\n\004abbr\030\003" +
                        " \001(\014\022\024\n\014total_supply\030\004 \001(\003\022@\n\rfrozen_sup" +
                        "ply\030\005 \003(\0132).protocol.AssetIssueContract." +
                        "FrozenSupply\022\017\n\007trx_num\030\006 \001(\005\022\013\n\003num\030\010 \001" +
                        "(\005\022\022\n\nstart_time\030\t \001(\003\022\020\n\010end_time\030\n \001(\003" +
                        "\022\r\n\005order\030\013 \001(\003\022\022\n\nvote_score\030\020 \001(\005\022\023\n\013d" +
                        "escription\030\024 \001(\014\022\013\n\003url\030\025 \001(\014\022\034\n\024free_as" +
                        "set_net_limit\030\026 \001(\003\022#\n\033public_free_asset" +
                        "_net_limit\030\027 \001(\003\022#\n\033public_free_asset_ne" +
                        "t_usage\030\030 \001(\003\022#\n\033public_latest_free_net_" +
                        "time\030\031 \001(\003\032:\n\014FrozenSupply\022\025\n\rfrozen_amo" +
                        "unt\030\001 \001(\003\022\023\n\013frozen_days\030\002 \001(\003\"n\n\035Partic" +
                        "ipateAssetIssueContract\022\025\n\rowner_address" +
                        "\030\001 \001(\014\022\022\n\nto_address\030\002 \001(\014\022\022\n\nasset_name" +
                        "\030\003 \001(\014\022\016\n\006amount\030\004 \001(\003\"\243\001\n\025FreezeBalance" +
                        "Contract\022\025\n\rowner_address\030\001 \001(\014\022\026\n\016froze" +
                        "n_balance\030\002 \001(\003\022\027\n\017frozen_duration\030\003 \001(\003" +
                        "\022(\n\010resource\030\n \001(\0162\026.protocol.ResourceCo" +
                        "de\022\030\n\020receiver_address\030\017 \001(\014\"t\n\027Unfreeze" +
                        "BalanceContract\022\025\n\rowner_address\030\001 \001(\014\022(" +
                        "\n\010resource\030\n \001(\0162\026.protocol.ResourceCode" +
                        "\022\030\n\020receiver_address\030\017 \001(\014\".\n\025UnfreezeAs" +
                        "setContract\022\025\n\rowner_address\030\001 \001(\014\"0\n\027Wi" +
                        "thdrawBalanceContract\022\025\n\rowner_address\030\001" +
                        " \001(\014\"{\n\023UpdateAssetContract\022\025\n\rowner_add" +
                        "ress\030\001 \001(\014\022\023\n\013description\030\002 \001(\014\022\013\n\003url\030\003" +
                        " \001(\014\022\021\n\tnew_limit\030\004 \001(\003\022\030\n\020new_public_li" +
                        "mit\030\005 \001(\003\"\250\001\n\026ProposalCreateContract\022\025\n\r" +
                        "owner_address\030\001 \001(\014\022D\n\nparameters\030\002 \003(\0132" +
                        "0.protocol.ProposalCreateContract.Parame" +
                        "tersEntry\0321\n\017ParametersEntry\022\013\n\003key\030\001 \001(" +
                        "\003\022\r\n\005value\030\002 \001(\003:\0028\001\"^\n\027ProposalApproveC" +
                        "ontract\022\025\n\rowner_address\030\001 \001(\014\022\023\n\013propos" +
                        "al_id\030\002 \001(\003\022\027\n\017is_add_approval\030\003 \001(\010\"D\n\026" +
                        "ProposalDeleteContract\022\025\n\rowner_address\030" +
                        "\001 \001(\014\022\023\n\013proposal_id\030\002 \001(\003\"\207\001\n\023CreateSma" +
                        "rtContract\022\025\n\rowner_address\030\001 \001(\014\022-\n\014new" +
                        "_contract\030\002 \001(\0132\027.protocol.SmartContract" +
                        "\022\030\n\020call_token_value\030\003 \001(\003\022\020\n\010token_id\030\004" +
                        " \001(\t\"\225\001\n\024TriggerSmartContract\022\025\n\rowner_a" +
                        "ddress\030\001 \001(\014\022\030\n\020contract_address\030\002 \001(\014\022\022" +
                        "\n\ncall_value\030\003 \001(\003\022\014\n\004data\030\004 \001(\014\022\030\n\020call" +
                        "_token_value\030\005 \001(\003\022\020\n\010token_id\030\006 \001(\t\":\n\022" +
                        "BuyStorageContract\022\025\n\rowner_address\030\001 \001(" +
                        "\014\022\r\n\005quant\030\002 \001(\003\"?\n\027BuyStorageBytesContr" +
                        "act\022\025\n\rowner_address\030\001 \001(\014\022\r\n\005bytes\030\002 \001(" +
                        "\003\"C\n\023SellStorageContract\022\025\n\rowner_addres" +
                        "s\030\001 \001(\014\022\025\n\rstorage_bytes\030\002 \001(\003\"\233\001\n\026Excha" +
                        "ngeCreateContract\022\025\n\rowner_address\030\001 \001(\014" +
                        "\022\026\n\016first_token_id\030\002 \001(\014\022\033\n\023first_token_" +
                        "balance\030\003 \001(\003\022\027\n\017second_token_id\030\004 \001(\014\022\034" +
                        "\n\024second_token_balance\030\005 \001(\003\"e\n\026Exchange" +
                        "InjectContract\022\025\n\rowner_address\030\001 \001(\014\022\023\n" +
                        "\013exchange_id\030\002 \001(\003\022\020\n\010token_id\030\003 \001(\014\022\r\n\005" +
                        "quant\030\004 \001(\003\"g\n\030ExchangeWithdrawContract\022" +
                        "\025\n\rowner_address\030\001 \001(\014\022\023\n\013exchange_id\030\002 " +
                        "\001(\003\022\020\n\010token_id\030\003 \001(\014\022\r\n\005quant\030\004 \001(\003\"|\n\033" +
                        "ExchangeTransactionContract\022\025\n\rowner_add" +
                        "ress\030\001 \001(\014\022\023\n\013exchange_id\030\002 \001(\003\022\020\n\010token" +
                        "_id\030\003 \001(\014\022\r\n\005quant\030\004 \001(\003\022\020\n\010expected\030\005 \001" +
                        "(\003*)\n\014ResourceCode\022\r\n\tBANDWIDTH\020\000\022\n\n\006ENE" +
                        "RGY\020\001BF\n\017com.cryptowallet.cryptoB\010ContractZ)gith" +
                        "ub.com/tronprotocol/grpc-gateway/coreb\006p" +
                        "roto3"
        };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
                    public com.google.protobuf.ExtensionRegistry assignDescriptors(
                            com.google.protobuf.Descriptors.FileDescriptor root) {
                        descriptor = root;
                        return null;
                    }
                };
        com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[] {
                                com.cryptowallet.crypto.Protocol.getDescriptor(),
                        }, assigner);
        internal_static_protocol_AccountCreateContract_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_protocol_AccountCreateContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_AccountCreateContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "AccountAddress", "Type", });
        internal_static_protocol_AccountUpdateContract_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_protocol_AccountUpdateContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_AccountUpdateContract_descriptor,
                new java.lang.String[] { "AccountName", "OwnerAddress", });
        internal_static_protocol_SetAccountIdContract_descriptor =
                getDescriptor().getMessageTypes().get(2);
        internal_static_protocol_SetAccountIdContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_SetAccountIdContract_descriptor,
                new java.lang.String[] { "AccountId", "OwnerAddress", });
        internal_static_protocol_TransferContract_descriptor =
                getDescriptor().getMessageTypes().get(3);
        internal_static_protocol_TransferContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_TransferContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "ToAddress", "Amount", });
        internal_static_protocol_TransferAssetContract_descriptor =
                getDescriptor().getMessageTypes().get(4);
        internal_static_protocol_TransferAssetContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_TransferAssetContract_descriptor,
                new java.lang.String[] { "AssetName", "OwnerAddress", "ToAddress", "Amount", });
        internal_static_protocol_VoteAssetContract_descriptor =
                getDescriptor().getMessageTypes().get(5);
        internal_static_protocol_VoteAssetContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_VoteAssetContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "VoteAddress", "Support", "Count", });
        internal_static_protocol_VoteWitnessContract_descriptor =
                getDescriptor().getMessageTypes().get(6);
        internal_static_protocol_VoteWitnessContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_VoteWitnessContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "Votes", "Support", });
        internal_static_protocol_VoteWitnessContract_Vote_descriptor =
                internal_static_protocol_VoteWitnessContract_descriptor.getNestedTypes().get(0);
        internal_static_protocol_VoteWitnessContract_Vote_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_VoteWitnessContract_Vote_descriptor,
                new java.lang.String[] { "VoteAddress", "VoteCount", });
        internal_static_protocol_UpdateSettingContract_descriptor =
                getDescriptor().getMessageTypes().get(7);
        internal_static_protocol_UpdateSettingContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_UpdateSettingContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "ContractAddress", "ConsumeUserResourcePercent", });
        internal_static_protocol_UpdateEnergyLimitContract_descriptor =
                getDescriptor().getMessageTypes().get(8);
        internal_static_protocol_UpdateEnergyLimitContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_UpdateEnergyLimitContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "ContractAddress", "OriginEnergyLimit", });
        internal_static_protocol_WitnessCreateContract_descriptor =
                getDescriptor().getMessageTypes().get(9);
        internal_static_protocol_WitnessCreateContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_WitnessCreateContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "Url", });
        internal_static_protocol_WitnessUpdateContract_descriptor =
                getDescriptor().getMessageTypes().get(10);
        internal_static_protocol_WitnessUpdateContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_WitnessUpdateContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "UpdateUrl", });
        internal_static_protocol_AssetIssueContract_descriptor =
                getDescriptor().getMessageTypes().get(11);
        internal_static_protocol_AssetIssueContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_AssetIssueContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "Name", "Abbr", "TotalSupply", "FrozenSupply", "TrxNum", "Num", "StartTime", "EndTime", "Order", "VoteScore", "Description", "Url", "FreeAssetNetLimit", "PublicFreeAssetNetLimit", "PublicFreeAssetNetUsage", "PublicLatestFreeNetTime", });
        internal_static_protocol_AssetIssueContract_FrozenSupply_descriptor =
                internal_static_protocol_AssetIssueContract_descriptor.getNestedTypes().get(0);
        internal_static_protocol_AssetIssueContract_FrozenSupply_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_AssetIssueContract_FrozenSupply_descriptor,
                new java.lang.String[] { "FrozenAmount", "FrozenDays", });
        internal_static_protocol_ParticipateAssetIssueContract_descriptor =
                getDescriptor().getMessageTypes().get(12);
        internal_static_protocol_ParticipateAssetIssueContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_ParticipateAssetIssueContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "ToAddress", "AssetName", "Amount", });
        internal_static_protocol_FreezeBalanceContract_descriptor =
                getDescriptor().getMessageTypes().get(13);
        internal_static_protocol_FreezeBalanceContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_FreezeBalanceContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "FrozenBalance", "FrozenDuration", "Resource", "ReceiverAddress", });
        internal_static_protocol_UnfreezeBalanceContract_descriptor =
                getDescriptor().getMessageTypes().get(14);
        internal_static_protocol_UnfreezeBalanceContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_UnfreezeBalanceContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "Resource", "ReceiverAddress", });
        internal_static_protocol_UnfreezeAssetContract_descriptor =
                getDescriptor().getMessageTypes().get(15);
        internal_static_protocol_UnfreezeAssetContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_UnfreezeAssetContract_descriptor,
                new java.lang.String[] { "OwnerAddress", });
        internal_static_protocol_WithdrawBalanceContract_descriptor =
                getDescriptor().getMessageTypes().get(16);
        internal_static_protocol_WithdrawBalanceContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_WithdrawBalanceContract_descriptor,
                new java.lang.String[] { "OwnerAddress", });
        internal_static_protocol_UpdateAssetContract_descriptor =
                getDescriptor().getMessageTypes().get(17);
        internal_static_protocol_UpdateAssetContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_UpdateAssetContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "Description", "Url", "NewLimit", "NewPublicLimit", });
        internal_static_protocol_ProposalCreateContract_descriptor =
                getDescriptor().getMessageTypes().get(18);
        internal_static_protocol_ProposalCreateContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_ProposalCreateContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "Parameters", });
        internal_static_protocol_ProposalCreateContract_ParametersEntry_descriptor =
                internal_static_protocol_ProposalCreateContract_descriptor.getNestedTypes().get(0);
        internal_static_protocol_ProposalCreateContract_ParametersEntry_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_ProposalCreateContract_ParametersEntry_descriptor,
                new java.lang.String[] { "Key", "Value", });
        internal_static_protocol_ProposalApproveContract_descriptor =
                getDescriptor().getMessageTypes().get(19);
        internal_static_protocol_ProposalApproveContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_ProposalApproveContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "ProposalId", "IsAddApproval", });
        internal_static_protocol_ProposalDeleteContract_descriptor =
                getDescriptor().getMessageTypes().get(20);
        internal_static_protocol_ProposalDeleteContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_ProposalDeleteContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "ProposalId", });
        internal_static_protocol_CreateSmartContract_descriptor =
                getDescriptor().getMessageTypes().get(21);
        internal_static_protocol_CreateSmartContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_CreateSmartContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "NewContract", "CallTokenValue", "TokenId", });
        internal_static_protocol_TriggerSmartContract_descriptor =
                getDescriptor().getMessageTypes().get(22);
        internal_static_protocol_TriggerSmartContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_TriggerSmartContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "ContractAddress", "CallValue", "Data", "CallTokenValue", "TokenId", });
        internal_static_protocol_BuyStorageContract_descriptor =
                getDescriptor().getMessageTypes().get(23);
        internal_static_protocol_BuyStorageContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_BuyStorageContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "Quant", });
        internal_static_protocol_BuyStorageBytesContract_descriptor =
                getDescriptor().getMessageTypes().get(24);
        internal_static_protocol_BuyStorageBytesContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_BuyStorageBytesContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "Bytes", });
        internal_static_protocol_SellStorageContract_descriptor =
                getDescriptor().getMessageTypes().get(25);
        internal_static_protocol_SellStorageContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_SellStorageContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "StorageBytes", });
        internal_static_protocol_ExchangeCreateContract_descriptor =
                getDescriptor().getMessageTypes().get(26);
        internal_static_protocol_ExchangeCreateContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_ExchangeCreateContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "FirstTokenId", "FirstTokenBalance", "SecondTokenId", "SecondTokenBalance", });
        internal_static_protocol_ExchangeInjectContract_descriptor =
                getDescriptor().getMessageTypes().get(27);
        internal_static_protocol_ExchangeInjectContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_ExchangeInjectContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "ExchangeId", "TokenId", "Quant", });
        internal_static_protocol_ExchangeWithdrawContract_descriptor =
                getDescriptor().getMessageTypes().get(28);
        internal_static_protocol_ExchangeWithdrawContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_ExchangeWithdrawContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "ExchangeId", "TokenId", "Quant", });
        internal_static_protocol_ExchangeTransactionContract_descriptor =
                getDescriptor().getMessageTypes().get(29);
        internal_static_protocol_ExchangeTransactionContract_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protocol_ExchangeTransactionContract_descriptor,
                new java.lang.String[] { "OwnerAddress", "ExchangeId", "TokenId", "Quant", "Expected", });
        com.cryptowallet.crypto.Protocol.getDescriptor();
    }

    // @@protoc_insertion_point(outer_class_scope)
}