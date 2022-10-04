package com.yanchware.internships;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.9.4.
 */
@SuppressWarnings("rawtypes")
public class IBridge extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_ACTIVEOUTBOX = "activeOutbox";

    public static final String FUNC_ALLOWEDINBOXES = "allowedInboxes";

    public static final String FUNC_ALLOWEDOUTBOXES = "allowedOutboxes";

    public static final String FUNC_DELIVERMESSAGETOINBOX = "deliverMessageToInbox";

    public static final String FUNC_EXECUTECALL = "executeCall";

    public static final String FUNC_INBOXACCS = "inboxAccs";

    public static final String FUNC_MESSAGECOUNT = "messageCount";

    public static final String FUNC_SETINBOX = "setInbox";

    public static final String FUNC_SETOUTBOX = "setOutbox";

    public static final Event BRIDGECALLTRIGGERED_EVENT = new Event("BridgeCallTriggered", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event INBOXTOGGLE_EVENT = new Event("InboxToggle", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event MESSAGEDELIVERED_EVENT = new Event("MessageDelivered", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Address>() {}, new TypeReference<Uint8>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}));
    ;

    public static final Event OUTBOXTOGGLE_EVENT = new Event("OutboxToggle", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    @Deprecated
    protected IBridge(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IBridge(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IBridge(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IBridge(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<BridgeCallTriggeredEventResponse> getBridgeCallTriggeredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(BRIDGECALLTRIGGERED_EVENT, transactionReceipt);
        ArrayList<BridgeCallTriggeredEventResponse> responses = new ArrayList<BridgeCallTriggeredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BridgeCallTriggeredEventResponse typedResponse = new BridgeCallTriggeredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.outbox = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.destAddr = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BridgeCallTriggeredEventResponse> bridgeCallTriggeredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BridgeCallTriggeredEventResponse>() {
            @Override
            public BridgeCallTriggeredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BRIDGECALLTRIGGERED_EVENT, log);
                BridgeCallTriggeredEventResponse typedResponse = new BridgeCallTriggeredEventResponse();
                typedResponse.log = log;
                typedResponse.outbox = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.destAddr = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<BridgeCallTriggeredEventResponse> bridgeCallTriggeredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BRIDGECALLTRIGGERED_EVENT));
        return bridgeCallTriggeredEventFlowable(filter);
    }

    public static List<InboxToggleEventResponse> getInboxToggleEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(INBOXTOGGLE_EVENT, transactionReceipt);
        ArrayList<InboxToggleEventResponse> responses = new ArrayList<InboxToggleEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InboxToggleEventResponse typedResponse = new InboxToggleEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.inbox = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.enabled = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<InboxToggleEventResponse> inboxToggleEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, InboxToggleEventResponse>() {
            @Override
            public InboxToggleEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(INBOXTOGGLE_EVENT, log);
                InboxToggleEventResponse typedResponse = new InboxToggleEventResponse();
                typedResponse.log = log;
                typedResponse.inbox = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.enabled = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<InboxToggleEventResponse> inboxToggleEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INBOXTOGGLE_EVENT));
        return inboxToggleEventFlowable(filter);
    }

    public static List<MessageDeliveredEventResponse> getMessageDeliveredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(MESSAGEDELIVERED_EVENT, transactionReceipt);
        ArrayList<MessageDeliveredEventResponse> responses = new ArrayList<MessageDeliveredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MessageDeliveredEventResponse typedResponse = new MessageDeliveredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.messageIndex = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.beforeInboxAcc = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.inbox = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.kind = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.messageDataHash = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<MessageDeliveredEventResponse> messageDeliveredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, MessageDeliveredEventResponse>() {
            @Override
            public MessageDeliveredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MESSAGEDELIVERED_EVENT, log);
                MessageDeliveredEventResponse typedResponse = new MessageDeliveredEventResponse();
                typedResponse.log = log;
                typedResponse.messageIndex = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.beforeInboxAcc = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.inbox = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.kind = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.sender = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.messageDataHash = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<MessageDeliveredEventResponse> messageDeliveredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MESSAGEDELIVERED_EVENT));
        return messageDeliveredEventFlowable(filter);
    }

    public static List<OutboxToggleEventResponse> getOutboxToggleEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OUTBOXTOGGLE_EVENT, transactionReceipt);
        ArrayList<OutboxToggleEventResponse> responses = new ArrayList<OutboxToggleEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OutboxToggleEventResponse typedResponse = new OutboxToggleEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.outbox = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.enabled = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OutboxToggleEventResponse> outboxToggleEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OutboxToggleEventResponse>() {
            @Override
            public OutboxToggleEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OUTBOXTOGGLE_EVENT, log);
                OutboxToggleEventResponse typedResponse = new OutboxToggleEventResponse();
                typedResponse.log = log;
                typedResponse.outbox = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.enabled = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OutboxToggleEventResponse> outboxToggleEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OUTBOXTOGGLE_EVENT));
        return outboxToggleEventFlowable(filter);
    }

    public RemoteFunctionCall<String> activeOutbox() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ACTIVEOUTBOX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> allowedInboxes(String inbox) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ALLOWEDINBOXES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, inbox)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> allowedOutboxes(String outbox) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ALLOWEDOUTBOXES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, outbox)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> deliverMessageToInbox(BigInteger kind, String sender, byte[] messageDataHash, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DELIVERMESSAGETOINBOX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(kind), 
                new org.web3j.abi.datatypes.Address(160, sender), 
                new org.web3j.abi.datatypes.generated.Bytes32(messageDataHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> executeCall(String destAddr, BigInteger amount, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EXECUTECALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, destAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> inboxAccs(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_INBOXACCS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> messageCount() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MESSAGECOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setInbox(String inbox, Boolean enabled) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETINBOX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, inbox), 
                new org.web3j.abi.datatypes.Bool(enabled)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOutbox(String inbox, Boolean enabled) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETOUTBOX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, inbox), 
                new org.web3j.abi.datatypes.Bool(enabled)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IBridge load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IBridge(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IBridge load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IBridge(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IBridge load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IBridge(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IBridge load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IBridge(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IBridge> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IBridge.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IBridge> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IBridge.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IBridge> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IBridge.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IBridge> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IBridge.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class BridgeCallTriggeredEventResponse extends BaseEventResponse {
        public String outbox;

        public String destAddr;

        public BigInteger amount;

        public byte[] data;
    }

    public static class InboxToggleEventResponse extends BaseEventResponse {
        public String inbox;

        public Boolean enabled;
    }

    public static class MessageDeliveredEventResponse extends BaseEventResponse {
        public BigInteger messageIndex;

        public byte[] beforeInboxAcc;

        public String inbox;

        public BigInteger kind;

        public String sender;

        public byte[] messageDataHash;
    }

    public static class OutboxToggleEventResponse extends BaseEventResponse {
        public String outbox;

        public Boolean enabled;
    }
}
