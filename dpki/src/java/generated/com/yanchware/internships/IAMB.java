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
public class IAMB extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_DESTINATIONCHAINID = "destinationChainId";

    public static final String FUNC_FAILEDMESSAGEDATAHASH = "failedMessageDataHash";

    public static final String FUNC_FAILEDMESSAGERECEIVER = "failedMessageReceiver";

    public static final String FUNC_FAILEDMESSAGESENDER = "failedMessageSender";

    public static final String FUNC_MAXGASPERTX = "maxGasPerTx";

    public static final String FUNC_MESSAGECALLSTATUS = "messageCallStatus";

    public static final String FUNC_MESSAGEID = "messageId";

    public static final String FUNC_MESSAGESENDER = "messageSender";

    public static final String FUNC_MESSAGESOURCECHAINID = "messageSourceChainId";

    public static final String FUNC_REQUIRETOCONFIRMMESSAGE = "requireToConfirmMessage";

    public static final String FUNC_REQUIRETOPASSMESSAGE = "requireToPassMessage";

    public static final String FUNC_SOURCECHAINID = "sourceChainId";

    public static final String FUNC_TRANSACTIONHASH = "transactionHash";

    public static final Event AFFIRMATIONCOMPLETED_EVENT = new Event("AffirmationCompleted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event RELAYEDMESSAGE_EVENT = new Event("RelayedMessage", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event USERREQUESTFORAFFIRMATION_EVENT = new Event("UserRequestForAffirmation", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event USERREQUESTFORSIGNATURE_EVENT = new Event("UserRequestForSignature", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<DynamicBytes>() {}));
    ;

    @Deprecated
    protected IAMB(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IAMB(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IAMB(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IAMB(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<AffirmationCompletedEventResponse> getAffirmationCompletedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(AFFIRMATIONCOMPLETED_EVENT, transactionReceipt);
        ArrayList<AffirmationCompletedEventResponse> responses = new ArrayList<AffirmationCompletedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AffirmationCompletedEventResponse typedResponse = new AffirmationCompletedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.executor = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.messageId = (byte[]) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.status = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AffirmationCompletedEventResponse> affirmationCompletedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AffirmationCompletedEventResponse>() {
            @Override
            public AffirmationCompletedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(AFFIRMATIONCOMPLETED_EVENT, log);
                AffirmationCompletedEventResponse typedResponse = new AffirmationCompletedEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.executor = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.messageId = (byte[]) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.status = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AffirmationCompletedEventResponse> affirmationCompletedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(AFFIRMATIONCOMPLETED_EVENT));
        return affirmationCompletedEventFlowable(filter);
    }

    public static List<RelayedMessageEventResponse> getRelayedMessageEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(RELAYEDMESSAGE_EVENT, transactionReceipt);
        ArrayList<RelayedMessageEventResponse> responses = new ArrayList<RelayedMessageEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RelayedMessageEventResponse typedResponse = new RelayedMessageEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.executor = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.messageId = (byte[]) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.status = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
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
                typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.executor = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.messageId = (byte[]) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.status = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RelayedMessageEventResponse> relayedMessageEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RELAYEDMESSAGE_EVENT));
        return relayedMessageEventFlowable(filter);
    }

    public static List<UserRequestForAffirmationEventResponse> getUserRequestForAffirmationEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(USERREQUESTFORAFFIRMATION_EVENT, transactionReceipt);
        ArrayList<UserRequestForAffirmationEventResponse> responses = new ArrayList<UserRequestForAffirmationEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UserRequestForAffirmationEventResponse typedResponse = new UserRequestForAffirmationEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.messageId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.encodedData = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UserRequestForAffirmationEventResponse> userRequestForAffirmationEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, UserRequestForAffirmationEventResponse>() {
            @Override
            public UserRequestForAffirmationEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(USERREQUESTFORAFFIRMATION_EVENT, log);
                UserRequestForAffirmationEventResponse typedResponse = new UserRequestForAffirmationEventResponse();
                typedResponse.log = log;
                typedResponse.messageId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.encodedData = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UserRequestForAffirmationEventResponse> userRequestForAffirmationEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(USERREQUESTFORAFFIRMATION_EVENT));
        return userRequestForAffirmationEventFlowable(filter);
    }

    public static List<UserRequestForSignatureEventResponse> getUserRequestForSignatureEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(USERREQUESTFORSIGNATURE_EVENT, transactionReceipt);
        ArrayList<UserRequestForSignatureEventResponse> responses = new ArrayList<UserRequestForSignatureEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UserRequestForSignatureEventResponse typedResponse = new UserRequestForSignatureEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.messageId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.encodedData = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UserRequestForSignatureEventResponse> userRequestForSignatureEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, UserRequestForSignatureEventResponse>() {
            @Override
            public UserRequestForSignatureEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(USERREQUESTFORSIGNATURE_EVENT, log);
                UserRequestForSignatureEventResponse typedResponse = new UserRequestForSignatureEventResponse();
                typedResponse.log = log;
                typedResponse.messageId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.encodedData = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UserRequestForSignatureEventResponse> userRequestForSignatureEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(USERREQUESTFORSIGNATURE_EVENT));
        return userRequestForSignatureEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> destinationChainId() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DESTINATIONCHAINID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> failedMessageDataHash(byte[] _messageId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_FAILEDMESSAGEDATAHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_messageId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> failedMessageReceiver(byte[] _messageId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_FAILEDMESSAGERECEIVER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_messageId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> failedMessageSender(byte[] _messageId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_FAILEDMESSAGESENDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_messageId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> maxGasPerTx() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAXGASPERTX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> messageCallStatus(byte[] _messageId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MESSAGECALLSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_messageId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<byte[]> messageId() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MESSAGEID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> messageSender() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MESSAGESENDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<byte[]> messageSourceChainId() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MESSAGESOURCECHAINID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> requireToConfirmMessage(String _contract, byte[] _data, BigInteger _gas) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REQUIRETOCONFIRMMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _contract), 
                new org.web3j.abi.datatypes.DynamicBytes(_data), 
                new org.web3j.abi.datatypes.generated.Uint256(_gas)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> requireToPassMessage(String _contract, byte[] _data, BigInteger _gas) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REQUIRETOPASSMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _contract), 
                new org.web3j.abi.datatypes.DynamicBytes(_data), 
                new org.web3j.abi.datatypes.generated.Uint256(_gas)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> sourceChainId() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SOURCECHAINID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> transactionHash() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TRANSACTIONHASH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    @Deprecated
    public static IAMB load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IAMB(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IAMB load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IAMB(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IAMB load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IAMB(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IAMB load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IAMB(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IAMB> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IAMB.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IAMB> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IAMB.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IAMB> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IAMB.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IAMB> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IAMB.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class AffirmationCompletedEventResponse extends BaseEventResponse {
        public String sender;

        public String executor;

        public byte[] messageId;

        public Boolean status;
    }

    public static class RelayedMessageEventResponse extends BaseEventResponse {
        public String sender;

        public String executor;

        public byte[] messageId;

        public Boolean status;
    }

    public static class UserRequestForAffirmationEventResponse extends BaseEventResponse {
        public byte[] messageId;

        public byte[] encodedData;
    }

    public static class UserRequestForSignatureEventResponse extends BaseEventResponse {
        public byte[] messageId;

        public byte[] encodedData;
    }
}
