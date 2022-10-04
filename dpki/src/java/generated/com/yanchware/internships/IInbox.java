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
public class IInbox extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_BRIDGE = "bridge";

    public static final String FUNC_CREATERETRYABLETICKET = "createRetryableTicket";

    public static final String FUNC_CREATERETRYABLETICKETNOREFUNDALIASREWRITE = "createRetryableTicketNoRefundAliasRewrite";

    public static final String FUNC_DEPOSITETH = "depositEth";

    public static final String FUNC_PAUSECREATERETRYABLES = "pauseCreateRetryables";

    public static final String FUNC_SENDCONTRACTTRANSACTION = "sendContractTransaction";

    public static final String FUNC_SENDL1FUNDEDCONTRACTTRANSACTION = "sendL1FundedContractTransaction";

    public static final String FUNC_SENDL1FUNDEDUNSIGNEDTRANSACTION = "sendL1FundedUnsignedTransaction";

    public static final String FUNC_SENDL2MESSAGE = "sendL2Message";

    public static final String FUNC_SENDUNSIGNEDTRANSACTION = "sendUnsignedTransaction";

    public static final String FUNC_STARTREWRITEADDRESS = "startRewriteAddress";

    public static final String FUNC_STOPREWRITEADDRESS = "stopRewriteAddress";

    public static final String FUNC_UNPAUSECREATERETRYABLES = "unpauseCreateRetryables";

    public static final Event INBOXMESSAGEDELIVERED_EVENT = new Event("InboxMessageDelivered", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event INBOXMESSAGEDELIVEREDFROMORIGIN_EVENT = new Event("InboxMessageDeliveredFromOrigin", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected IInbox(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IInbox(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IInbox(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IInbox(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<InboxMessageDeliveredEventResponse> getInboxMessageDeliveredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(INBOXMESSAGEDELIVERED_EVENT, transactionReceipt);
        ArrayList<InboxMessageDeliveredEventResponse> responses = new ArrayList<InboxMessageDeliveredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InboxMessageDeliveredEventResponse typedResponse = new InboxMessageDeliveredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.messageNum = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<InboxMessageDeliveredEventResponse> inboxMessageDeliveredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, InboxMessageDeliveredEventResponse>() {
            @Override
            public InboxMessageDeliveredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(INBOXMESSAGEDELIVERED_EVENT, log);
                InboxMessageDeliveredEventResponse typedResponse = new InboxMessageDeliveredEventResponse();
                typedResponse.log = log;
                typedResponse.messageNum = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<InboxMessageDeliveredEventResponse> inboxMessageDeliveredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INBOXMESSAGEDELIVERED_EVENT));
        return inboxMessageDeliveredEventFlowable(filter);
    }

    public static List<InboxMessageDeliveredFromOriginEventResponse> getInboxMessageDeliveredFromOriginEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(INBOXMESSAGEDELIVEREDFROMORIGIN_EVENT, transactionReceipt);
        ArrayList<InboxMessageDeliveredFromOriginEventResponse> responses = new ArrayList<InboxMessageDeliveredFromOriginEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InboxMessageDeliveredFromOriginEventResponse typedResponse = new InboxMessageDeliveredFromOriginEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.messageNum = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<InboxMessageDeliveredFromOriginEventResponse> inboxMessageDeliveredFromOriginEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, InboxMessageDeliveredFromOriginEventResponse>() {
            @Override
            public InboxMessageDeliveredFromOriginEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(INBOXMESSAGEDELIVEREDFROMORIGIN_EVENT, log);
                InboxMessageDeliveredFromOriginEventResponse typedResponse = new InboxMessageDeliveredFromOriginEventResponse();
                typedResponse.log = log;
                typedResponse.messageNum = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<InboxMessageDeliveredFromOriginEventResponse> inboxMessageDeliveredFromOriginEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INBOXMESSAGEDELIVEREDFROMORIGIN_EVENT));
        return inboxMessageDeliveredFromOriginEventFlowable(filter);
    }

    public RemoteFunctionCall<String> bridge() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BRIDGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> createRetryableTicket(String destAddr, BigInteger arbTxCallValue, BigInteger maxSubmissionCost, String submissionRefundAddress, String valueRefundAddress, BigInteger maxGas, BigInteger gasPriceBid, byte[] data, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CREATERETRYABLETICKET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, destAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(arbTxCallValue), 
                new org.web3j.abi.datatypes.generated.Uint256(maxSubmissionCost), 
                new org.web3j.abi.datatypes.Address(160, submissionRefundAddress), 
                new org.web3j.abi.datatypes.Address(160, valueRefundAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(maxGas), 
                new org.web3j.abi.datatypes.generated.Uint256(gasPriceBid), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> createRetryableTicketNoRefundAliasRewrite(String destAddr, BigInteger arbTxCallValue, BigInteger maxSubmissionCost, String submissionRefundAddress, String valueRefundAddress, BigInteger maxGas, BigInteger gasPriceBid, byte[] data, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CREATERETRYABLETICKETNOREFUNDALIASREWRITE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, destAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(arbTxCallValue), 
                new org.web3j.abi.datatypes.generated.Uint256(maxSubmissionCost), 
                new org.web3j.abi.datatypes.Address(160, submissionRefundAddress), 
                new org.web3j.abi.datatypes.Address(160, valueRefundAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(maxGas), 
                new org.web3j.abi.datatypes.generated.Uint256(gasPriceBid), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> depositEth(BigInteger maxSubmissionCost, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DEPOSITETH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(maxSubmissionCost)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> pauseCreateRetryables() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PAUSECREATERETRYABLES, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> sendContractTransaction(BigInteger maxGas, BigInteger gasPriceBid, String destAddr, BigInteger amount, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SENDCONTRACTTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(maxGas), 
                new org.web3j.abi.datatypes.generated.Uint256(gasPriceBid), 
                new org.web3j.abi.datatypes.Address(160, destAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> sendL1FundedContractTransaction(BigInteger maxGas, BigInteger gasPriceBid, String destAddr, byte[] data, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SENDL1FUNDEDCONTRACTTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(maxGas), 
                new org.web3j.abi.datatypes.generated.Uint256(gasPriceBid), 
                new org.web3j.abi.datatypes.Address(160, destAddr), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> sendL1FundedUnsignedTransaction(BigInteger maxGas, BigInteger gasPriceBid, BigInteger nonce, String destAddr, byte[] data, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SENDL1FUNDEDUNSIGNEDTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(maxGas), 
                new org.web3j.abi.datatypes.generated.Uint256(gasPriceBid), 
                new org.web3j.abi.datatypes.generated.Uint256(nonce), 
                new org.web3j.abi.datatypes.Address(160, destAddr), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> sendL2Message(byte[] messageData) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SENDL2MESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(messageData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> sendUnsignedTransaction(BigInteger maxGas, BigInteger gasPriceBid, BigInteger nonce, String destAddr, BigInteger amount, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SENDUNSIGNEDTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(maxGas), 
                new org.web3j.abi.datatypes.generated.Uint256(gasPriceBid), 
                new org.web3j.abi.datatypes.generated.Uint256(nonce), 
                new org.web3j.abi.datatypes.Address(160, destAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> startRewriteAddress() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_STARTREWRITEADDRESS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> stopRewriteAddress() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_STOPREWRITEADDRESS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> unpauseCreateRetryables() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UNPAUSECREATERETRYABLES, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IInbox load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IInbox(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IInbox load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IInbox(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IInbox load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IInbox(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IInbox load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IInbox(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IInbox> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IInbox.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IInbox> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IInbox.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IInbox> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IInbox.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IInbox> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IInbox.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class InboxMessageDeliveredEventResponse extends BaseEventResponse {
        public BigInteger messageNum;

        public byte[] data;
    }

    public static class InboxMessageDeliveredFromOriginEventResponse extends BaseEventResponse {
        public BigInteger messageNum;
    }
}
