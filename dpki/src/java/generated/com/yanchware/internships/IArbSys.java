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
public class IArbSys extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_ARBBLOCKNUMBER = "arbBlockNumber";

    public static final String FUNC_ARBCHAINID = "arbChainID";

    public static final String FUNC_ARBOSVERSION = "arbOSVersion";

    public static final String FUNC_GETSTORAGEAT = "getStorageAt";

    public static final String FUNC_GETSTORAGEGASAVAILABLE = "getStorageGasAvailable";

    public static final String FUNC_GETTRANSACTIONCOUNT = "getTransactionCount";

    public static final String FUNC_ISTOPLEVELCALL = "isTopLevelCall";

    public static final String FUNC_MAPL1SENDERCONTRACTADDRESSTOL2ALIAS = "mapL1SenderContractAddressToL2Alias";

    public static final String FUNC_MYCALLERSADDRESSWITHOUTALIASING = "myCallersAddressWithoutAliasing";

    public static final String FUNC_SENDTXTOL1 = "sendTxToL1";

    public static final String FUNC_WASMYCALLERSADDRESSALIASED = "wasMyCallersAddressAliased";

    public static final String FUNC_WITHDRAWETH = "withdrawEth";

    public static final Event L2TOL1TRANSACTION_EVENT = new Event("L2ToL1Transaction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    @Deprecated
    protected IArbSys(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IArbSys(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IArbSys(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IArbSys(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<L2ToL1TransactionEventResponse> getL2ToL1TransactionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(L2TOL1TRANSACTION_EVENT, transactionReceipt);
        ArrayList<L2ToL1TransactionEventResponse> responses = new ArrayList<L2ToL1TransactionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            L2ToL1TransactionEventResponse typedResponse = new L2ToL1TransactionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.destination = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.uniqueId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.batchNumber = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.caller = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.indexInBatch = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.arbBlockNum = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.ethBlockNum = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.callvalue = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(6).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<L2ToL1TransactionEventResponse> l2ToL1TransactionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, L2ToL1TransactionEventResponse>() {
            @Override
            public L2ToL1TransactionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(L2TOL1TRANSACTION_EVENT, log);
                L2ToL1TransactionEventResponse typedResponse = new L2ToL1TransactionEventResponse();
                typedResponse.log = log;
                typedResponse.destination = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.uniqueId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.batchNumber = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.caller = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.indexInBatch = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.arbBlockNum = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.ethBlockNum = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.callvalue = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(6).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<L2ToL1TransactionEventResponse> l2ToL1TransactionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(L2TOL1TRANSACTION_EVENT));
        return l2ToL1TransactionEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> arbBlockNumber() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ARBBLOCKNUMBER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> arbChainID() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ARBCHAINID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> arbOSVersion() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ARBOSVERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getStorageAt(String account, BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETSTORAGEAT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getStorageGasAvailable() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETSTORAGEGASAVAILABLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getTransactionCount(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTRANSACTIONCOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> isTopLevelCall() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISTOPLEVELCALL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> mapL1SenderContractAddressToL2Alias(String sender, String dest) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAPL1SENDERCONTRACTADDRESSTOL2ALIAS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, sender), 
                new org.web3j.abi.datatypes.Address(160, dest)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> myCallersAddressWithoutAliasing() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MYCALLERSADDRESSWITHOUTALIASING, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> sendTxToL1(String destination, byte[] calldataForL1, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SENDTXTOL1, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, destination), 
                new org.web3j.abi.datatypes.DynamicBytes(calldataForL1)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<Boolean> wasMyCallersAddressAliased() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_WASMYCALLERSADDRESSALIASED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawEth(String destination, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WITHDRAWETH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, destination)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    @Deprecated
    public static IArbSys load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IArbSys(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IArbSys load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IArbSys(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IArbSys load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IArbSys(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IArbSys load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IArbSys(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IArbSys> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IArbSys.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IArbSys> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IArbSys.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IArbSys> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IArbSys.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IArbSys> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IArbSys.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class L2ToL1TransactionEventResponse extends BaseEventResponse {
        public String destination;

        public BigInteger uniqueId;

        public BigInteger batchNumber;

        public String caller;

        public BigInteger indexInBatch;

        public BigInteger arbBlockNum;

        public BigInteger ethBlockNum;

        public BigInteger timestamp;

        public BigInteger callvalue;

        public byte[] data;
    }
}
