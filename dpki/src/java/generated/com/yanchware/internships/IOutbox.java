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
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
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
public class IOutbox extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_L2TOL1BATCHNUM = "l2ToL1BatchNum";

    public static final String FUNC_L2TOL1BLOCK = "l2ToL1Block";

    public static final String FUNC_L2TOL1ETHBLOCK = "l2ToL1EthBlock";

    public static final String FUNC_L2TOL1OUTPUTID = "l2ToL1OutputId";

    public static final String FUNC_L2TOL1SENDER = "l2ToL1Sender";

    public static final String FUNC_L2TOL1TIMESTAMP = "l2ToL1Timestamp";

    public static final String FUNC_OUTBOXENTRYEXISTS = "outboxEntryExists";

    public static final String FUNC_PROCESSOUTGOINGMESSAGES = "processOutgoingMessages";

    public static final Event OUTBOXTRANSACTIONEXECUTED_EVENT = new Event("OutBoxTransactionExecuted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OUTBOXENTRYCREATED_EVENT = new Event("OutboxEntryCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected IOutbox(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IOutbox(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IOutbox(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IOutbox(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<OutBoxTransactionExecutedEventResponse> getOutBoxTransactionExecutedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OUTBOXTRANSACTIONEXECUTED_EVENT, transactionReceipt);
        ArrayList<OutBoxTransactionExecutedEventResponse> responses = new ArrayList<OutBoxTransactionExecutedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OutBoxTransactionExecutedEventResponse typedResponse = new OutBoxTransactionExecutedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.destAddr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.l2Sender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.outboxEntryIndex = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.transactionIndex = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OutBoxTransactionExecutedEventResponse> outBoxTransactionExecutedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OutBoxTransactionExecutedEventResponse>() {
            @Override
            public OutBoxTransactionExecutedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OUTBOXTRANSACTIONEXECUTED_EVENT, log);
                OutBoxTransactionExecutedEventResponse typedResponse = new OutBoxTransactionExecutedEventResponse();
                typedResponse.log = log;
                typedResponse.destAddr = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.l2Sender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.outboxEntryIndex = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.transactionIndex = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OutBoxTransactionExecutedEventResponse> outBoxTransactionExecutedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OUTBOXTRANSACTIONEXECUTED_EVENT));
        return outBoxTransactionExecutedEventFlowable(filter);
    }

    public static List<OutboxEntryCreatedEventResponse> getOutboxEntryCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OUTBOXENTRYCREATED_EVENT, transactionReceipt);
        ArrayList<OutboxEntryCreatedEventResponse> responses = new ArrayList<OutboxEntryCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OutboxEntryCreatedEventResponse typedResponse = new OutboxEntryCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.batchNum = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.outboxEntryIndex = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.outputRoot = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.numInBatch = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OutboxEntryCreatedEventResponse> outboxEntryCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OutboxEntryCreatedEventResponse>() {
            @Override
            public OutboxEntryCreatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OUTBOXENTRYCREATED_EVENT, log);
                OutboxEntryCreatedEventResponse typedResponse = new OutboxEntryCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.batchNum = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.outboxEntryIndex = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.outputRoot = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.numInBatch = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OutboxEntryCreatedEventResponse> outboxEntryCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OUTBOXENTRYCREATED_EVENT));
        return outboxEntryCreatedEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> l2ToL1BatchNum() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_L2TOL1BATCHNUM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> l2ToL1Block() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_L2TOL1BLOCK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> l2ToL1EthBlock() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_L2TOL1ETHBLOCK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> l2ToL1OutputId() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_L2TOL1OUTPUTID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> l2ToL1Sender() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_L2TOL1SENDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> l2ToL1Timestamp() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_L2TOL1TIMESTAMP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> outboxEntryExists(BigInteger batchNum) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OUTBOXENTRYEXISTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(batchNum)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> processOutgoingMessages(byte[] sendsData, List<BigInteger> sendLengths) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PROCESSOUTGOINGMESSAGES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(sendsData), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(sendLengths, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IOutbox load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IOutbox(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IOutbox load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IOutbox(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IOutbox load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IOutbox(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IOutbox load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IOutbox(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IOutbox> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IOutbox.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IOutbox> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IOutbox.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IOutbox> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IOutbox.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IOutbox> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IOutbox.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OutBoxTransactionExecutedEventResponse extends BaseEventResponse {
        public String destAddr;

        public String l2Sender;

        public BigInteger outboxEntryIndex;

        public BigInteger transactionIndex;
    }

    public static class OutboxEntryCreatedEventResponse extends BaseEventResponse {
        public BigInteger batchNum;

        public BigInteger outboxEntryIndex;

        public byte[] outputRoot;

        public BigInteger numInBatch;
    }
}
