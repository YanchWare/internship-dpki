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
import org.web3j.abi.datatypes.DynamicBytes;
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
public class ICrossDomainMessenger extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_SENDMESSAGE = "sendMessage";

    public static final String FUNC_XDOMAINMESSAGESENDER = "xDomainMessageSender";

    public static final Event FAILEDRELAYEDMESSAGE_EVENT = new Event("FailedRelayedMessage", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event RELAYEDMESSAGE_EVENT = new Event("RelayedMessage", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event SENTMESSAGE_EVENT = new Event("SentMessage", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected ICrossDomainMessenger(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ICrossDomainMessenger(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ICrossDomainMessenger(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ICrossDomainMessenger(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<FailedRelayedMessageEventResponse> getFailedRelayedMessageEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(FAILEDRELAYEDMESSAGE_EVENT, transactionReceipt);
        ArrayList<FailedRelayedMessageEventResponse> responses = new ArrayList<FailedRelayedMessageEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            FailedRelayedMessageEventResponse typedResponse = new FailedRelayedMessageEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.msgHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<FailedRelayedMessageEventResponse> failedRelayedMessageEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, FailedRelayedMessageEventResponse>() {
            @Override
            public FailedRelayedMessageEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(FAILEDRELAYEDMESSAGE_EVENT, log);
                FailedRelayedMessageEventResponse typedResponse = new FailedRelayedMessageEventResponse();
                typedResponse.log = log;
                typedResponse.msgHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<FailedRelayedMessageEventResponse> failedRelayedMessageEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(FAILEDRELAYEDMESSAGE_EVENT));
        return failedRelayedMessageEventFlowable(filter);
    }

    public static List<RelayedMessageEventResponse> getRelayedMessageEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(RELAYEDMESSAGE_EVENT, transactionReceipt);
        ArrayList<RelayedMessageEventResponse> responses = new ArrayList<RelayedMessageEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RelayedMessageEventResponse typedResponse = new RelayedMessageEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.msgHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RelayedMessageEventResponse> relayedMessageEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RelayedMessageEventResponse>() {
            @Override
            public RelayedMessageEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RELAYEDMESSAGE_EVENT, log);
                RelayedMessageEventResponse typedResponse = new RelayedMessageEventResponse();
                typedResponse.log = log;
                typedResponse.msgHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RelayedMessageEventResponse> relayedMessageEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RELAYEDMESSAGE_EVENT));
        return relayedMessageEventFlowable(filter);
    }

    public static List<SentMessageEventResponse> getSentMessageEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SENTMESSAGE_EVENT, transactionReceipt);
        ArrayList<SentMessageEventResponse> responses = new ArrayList<SentMessageEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SentMessageEventResponse typedResponse = new SentMessageEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.target = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.message = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.messageNonce = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.gasLimit = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SentMessageEventResponse> sentMessageEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SentMessageEventResponse>() {
            @Override
            public SentMessageEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SENTMESSAGE_EVENT, log);
                SentMessageEventResponse typedResponse = new SentMessageEventResponse();
                typedResponse.log = log;
                typedResponse.target = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.message = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.messageNonce = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.gasLimit = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SentMessageEventResponse> sentMessageEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SENTMESSAGE_EVENT));
        return sentMessageEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> sendMessage(String _target, byte[] _message, BigInteger _gasLimit) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SENDMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _target), 
                new org.web3j.abi.datatypes.DynamicBytes(_message), 
                new org.web3j.abi.datatypes.generated.Uint32(_gasLimit)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> xDomainMessageSender() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_XDOMAINMESSAGESENDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static ICrossDomainMessenger load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ICrossDomainMessenger(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ICrossDomainMessenger load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ICrossDomainMessenger(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ICrossDomainMessenger load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ICrossDomainMessenger(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ICrossDomainMessenger load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ICrossDomainMessenger(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ICrossDomainMessenger> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ICrossDomainMessenger.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ICrossDomainMessenger> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ICrossDomainMessenger.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ICrossDomainMessenger> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ICrossDomainMessenger.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ICrossDomainMessenger> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ICrossDomainMessenger.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class FailedRelayedMessageEventResponse extends BaseEventResponse {
        public byte[] msgHash;
    }

    public static class RelayedMessageEventResponse extends BaseEventResponse {
        public byte[] msgHash;
    }

    public static class SentMessageEventResponse extends BaseEventResponse {
        public String target;

        public String sender;

        public byte[] message;

        public BigInteger messageNonce;

        public BigInteger gasLimit;
    }
}
