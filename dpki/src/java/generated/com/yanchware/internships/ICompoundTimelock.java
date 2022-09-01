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
import org.web3j.abi.datatypes.Utf8String;
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
public class ICompoundTimelock extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_GRACE_PERIOD = "GRACE_PERIOD";

    public static final String FUNC_MAXIMUM_DELAY = "MAXIMUM_DELAY";

    public static final String FUNC_MINIMUM_DELAY = "MINIMUM_DELAY";

    public static final String FUNC_ACCEPTADMIN = "acceptAdmin";

    public static final String FUNC_ADMIN = "admin";

    public static final String FUNC_CANCELTRANSACTION = "cancelTransaction";

    public static final String FUNC_DELAY = "delay";

    public static final String FUNC_EXECUTETRANSACTION = "executeTransaction";

    public static final String FUNC_PENDINGADMIN = "pendingAdmin";

    public static final String FUNC_QUEUETRANSACTION = "queueTransaction";

    public static final String FUNC_QUEUEDTRANSACTIONS = "queuedTransactions";

    public static final String FUNC_SETDELAY = "setDelay";

    public static final String FUNC_SETPENDINGADMIN = "setPendingAdmin";

    public static final Event CANCELTRANSACTION_EVENT = new Event("CancelTransaction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event EXECUTETRANSACTION_EVENT = new Event("ExecuteTransaction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event NEWADMIN_EVENT = new Event("NewAdmin", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event NEWDELAY_EVENT = new Event("NewDelay", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    public static final Event NEWPENDINGADMIN_EVENT = new Event("NewPendingAdmin", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event QUEUETRANSACTION_EVENT = new Event("QueueTransaction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected ICompoundTimelock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ICompoundTimelock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ICompoundTimelock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ICompoundTimelock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<CancelTransactionEventResponse> getCancelTransactionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CANCELTRANSACTION_EVENT, transactionReceipt);
        ArrayList<CancelTransactionEventResponse> responses = new ArrayList<CancelTransactionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CancelTransactionEventResponse typedResponse = new CancelTransactionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.txHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.target = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.signature = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.eta = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CancelTransactionEventResponse> cancelTransactionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CancelTransactionEventResponse>() {
            @Override
            public CancelTransactionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CANCELTRANSACTION_EVENT, log);
                CancelTransactionEventResponse typedResponse = new CancelTransactionEventResponse();
                typedResponse.log = log;
                typedResponse.txHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.target = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.signature = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.eta = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CancelTransactionEventResponse> cancelTransactionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CANCELTRANSACTION_EVENT));
        return cancelTransactionEventFlowable(filter);
    }

    public static List<ExecuteTransactionEventResponse> getExecuteTransactionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(EXECUTETRANSACTION_EVENT, transactionReceipt);
        ArrayList<ExecuteTransactionEventResponse> responses = new ArrayList<ExecuteTransactionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ExecuteTransactionEventResponse typedResponse = new ExecuteTransactionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.txHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.target = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.signature = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.eta = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExecuteTransactionEventResponse> executeTransactionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ExecuteTransactionEventResponse>() {
            @Override
            public ExecuteTransactionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EXECUTETRANSACTION_EVENT, log);
                ExecuteTransactionEventResponse typedResponse = new ExecuteTransactionEventResponse();
                typedResponse.log = log;
                typedResponse.txHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.target = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.signature = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.eta = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ExecuteTransactionEventResponse> executeTransactionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXECUTETRANSACTION_EVENT));
        return executeTransactionEventFlowable(filter);
    }

    public static List<NewAdminEventResponse> getNewAdminEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(NEWADMIN_EVENT, transactionReceipt);
        ArrayList<NewAdminEventResponse> responses = new ArrayList<NewAdminEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewAdminEventResponse typedResponse = new NewAdminEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newAdmin = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewAdminEventResponse> newAdminEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewAdminEventResponse>() {
            @Override
            public NewAdminEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWADMIN_EVENT, log);
                NewAdminEventResponse typedResponse = new NewAdminEventResponse();
                typedResponse.log = log;
                typedResponse.newAdmin = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewAdminEventResponse> newAdminEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWADMIN_EVENT));
        return newAdminEventFlowable(filter);
    }

    public static List<NewDelayEventResponse> getNewDelayEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(NEWDELAY_EVENT, transactionReceipt);
        ArrayList<NewDelayEventResponse> responses = new ArrayList<NewDelayEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewDelayEventResponse typedResponse = new NewDelayEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newDelay = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewDelayEventResponse> newDelayEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewDelayEventResponse>() {
            @Override
            public NewDelayEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWDELAY_EVENT, log);
                NewDelayEventResponse typedResponse = new NewDelayEventResponse();
                typedResponse.log = log;
                typedResponse.newDelay = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewDelayEventResponse> newDelayEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWDELAY_EVENT));
        return newDelayEventFlowable(filter);
    }

    public static List<NewPendingAdminEventResponse> getNewPendingAdminEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(NEWPENDINGADMIN_EVENT, transactionReceipt);
        ArrayList<NewPendingAdminEventResponse> responses = new ArrayList<NewPendingAdminEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewPendingAdminEventResponse typedResponse = new NewPendingAdminEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newPendingAdmin = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewPendingAdminEventResponse> newPendingAdminEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewPendingAdminEventResponse>() {
            @Override
            public NewPendingAdminEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWPENDINGADMIN_EVENT, log);
                NewPendingAdminEventResponse typedResponse = new NewPendingAdminEventResponse();
                typedResponse.log = log;
                typedResponse.newPendingAdmin = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewPendingAdminEventResponse> newPendingAdminEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWPENDINGADMIN_EVENT));
        return newPendingAdminEventFlowable(filter);
    }

    public static List<QueueTransactionEventResponse> getQueueTransactionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(QUEUETRANSACTION_EVENT, transactionReceipt);
        ArrayList<QueueTransactionEventResponse> responses = new ArrayList<QueueTransactionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            QueueTransactionEventResponse typedResponse = new QueueTransactionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.txHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.target = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.signature = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.eta = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<QueueTransactionEventResponse> queueTransactionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, QueueTransactionEventResponse>() {
            @Override
            public QueueTransactionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(QUEUETRANSACTION_EVENT, log);
                QueueTransactionEventResponse typedResponse = new QueueTransactionEventResponse();
                typedResponse.log = log;
                typedResponse.txHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.target = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.signature = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.eta = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<QueueTransactionEventResponse> queueTransactionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(QUEUETRANSACTION_EVENT));
        return queueTransactionEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> GRACE_PERIOD() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GRACE_PERIOD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> MAXIMUM_DELAY() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAXIMUM_DELAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> MINIMUM_DELAY() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MINIMUM_DELAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> acceptAdmin() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ACCEPTADMIN, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> admin() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> cancelTransaction(String target, BigInteger value, String signature, byte[] data, BigInteger eta) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CANCELTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.Utf8String(signature), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Uint256(eta)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> delay() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DELAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> executeTransaction(String target, BigInteger value, String signature, byte[] data, BigInteger eta, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EXECUTETRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.Utf8String(signature), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Uint256(eta)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<String> pendingAdmin() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PENDINGADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> queueTransaction(String target, BigInteger value, String signature, byte[] data, BigInteger eta) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_QUEUETRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.Utf8String(signature), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Uint256(eta)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> queuedTransactions(byte[] param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_QUEUEDTRANSACTIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setDelay(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETDELAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setPendingAdmin(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETPENDINGADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ICompoundTimelock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ICompoundTimelock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ICompoundTimelock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ICompoundTimelock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ICompoundTimelock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ICompoundTimelock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ICompoundTimelock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ICompoundTimelock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ICompoundTimelock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ICompoundTimelock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ICompoundTimelock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ICompoundTimelock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ICompoundTimelock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ICompoundTimelock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ICompoundTimelock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ICompoundTimelock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CancelTransactionEventResponse extends BaseEventResponse {
        public byte[] txHash;

        public String target;

        public BigInteger value;

        public String signature;

        public byte[] data;

        public BigInteger eta;
    }

    public static class ExecuteTransactionEventResponse extends BaseEventResponse {
        public byte[] txHash;

        public String target;

        public BigInteger value;

        public String signature;

        public byte[] data;

        public BigInteger eta;
    }

    public static class NewAdminEventResponse extends BaseEventResponse {
        public String newAdmin;
    }

    public static class NewDelayEventResponse extends BaseEventResponse {
        public BigInteger newDelay;
    }

    public static class NewPendingAdminEventResponse extends BaseEventResponse {
        public String newPendingAdmin;
    }

    public static class QueueTransactionEventResponse extends BaseEventResponse {
        public byte[] txHash;

        public String target;

        public BigInteger value;

        public String signature;

        public byte[] data;

        public BigInteger eta;
    }
}
