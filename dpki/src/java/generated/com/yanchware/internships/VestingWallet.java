package com.yanchware.internships;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
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
public class VestingWallet extends Contract {
    public static final String BINARY = "60e060405234801561001057600080fd5b50604051610c80380380610c8083398101604081905261002f916100dd565b6001600160a01b03831661009c5760405162461bcd60e51b815260206004820152602a60248201527f56657374696e6757616c6c65743a2062656e6566696369617279206973207a65604482015269726f206164647265737360b01b606482015260840160405180910390fd5b6001600160a01b039092166080526001600160401b0390811660a0521660c05261012e565b80516001600160401b03811681146100d857600080fd5b919050565b6000806000606084860312156100f257600080fd5b83516001600160a01b038116811461010957600080fd5b9250610117602085016100c1565b9150610125604085016100c1565b90509250925092565b60805160a05160c051610b086101786000396000818160d80152818161047801526104cd01526000610430015260008181610142015281816102c801526103fd0152610b086000f3fe60806040526004361061008a5760003560e01c8063810ec23b11610059578063810ec23b1461016c57806386d1a69f1461018c57806396132521146101a15780639852595c146101b6578063be9a6555146101ec57600080fd5b80630a17b06b146100965780630fb5a6b4146100c9578063191655871461010657806338af3eed1461012857600080fd5b3661009157005b600080fd5b3480156100a257600080fd5b506100b66100b1366004610912565b610201565b6040519081526020015b60405180910390f35b3480156100d557600080fd5b507f000000000000000000000000000000000000000000000000000000000000000067ffffffffffffffff166100b6565b34801561011257600080fd5b50610126610121366004610944565b610225565b005b34801561013457600080fd5b506040516001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001681526020016100c0565b34801561017857600080fd5b506100b661018736600461095f565b6102f1565b34801561019857600080fd5b50610126610396565b3480156101ad57600080fd5b506000546100b6565b3480156101c257600080fd5b506100b66101d1366004610944565b6001600160a01b031660009081526001602052604090205490565b3480156101f857600080fd5b506100b6610425565b600061021f61020f60005490565b61021990476109a8565b83610453565b92915050565b6001600160a01b03811660009081526001602052604081205461024883426102f1565b61025291906109c0565b6001600160a01b03831660009081526001602052604081208054929350839290919061027f9084906109a8565b90915550506040518181526001600160a01b038316907fc0e523490dd523c33b1878c9eb14ff46991e3f5b2cd33710918618f2a39cba1b9060200160405180910390a26102ed827f00000000000000000000000000000000000000000000000000000000000000008361052d565b5050565b6001600160a01b03821660009081526001602052604081205461038f906040516370a0823160e01b81523060048201526001600160a01b038616906370a082319060240160206040518083038186803b15801561034d57600080fd5b505afa158015610361573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061038591906109d7565b61021991906109a8565b9392505050565b600080546103a342610201565b6103ad91906109c0565b9050806000808282546103c091906109a8565b90915550506040518181527fda9d4e5f101b8b9b1c5b76d0c5a9f7923571acfc02376aa076b75a8c080c956b9060200160405180910390a16104227f000000000000000000000000000000000000000000000000000000000000000082610584565b50565b67ffffffffffffffff7f00000000000000000000000000000000000000000000000000000000000000001690565b600061045d610425565b8267ffffffffffffffff1610156104765750600061021f565b7f000000000000000000000000000000000000000000000000000000000000000067ffffffffffffffff166104a9610425565b6104b391906109a8565b8267ffffffffffffffff1611156104cb57508161021f565b7f000000000000000000000000000000000000000000000000000000000000000067ffffffffffffffff166104fe610425565b6105129067ffffffffffffffff85166109c0565b61051c90856109f0565b6105269190610a0f565b905061021f565b604080516001600160a01b038416602482015260448082018490528251808303909101815260649091019091526020810180516001600160e01b031663a9059cbb60e01b17905261057f9084906106a2565b505050565b804710156105d95760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a20696e73756666696369656e742062616c616e636500000060448201526064015b60405180910390fd5b6000826001600160a01b03168260405160006040518083038185875af1925050503d8060008114610626576040519150601f19603f3d011682016040523d82523d6000602084013e61062b565b606091505b505090508061057f5760405162461bcd60e51b815260206004820152603a60248201527f416464726573733a20756e61626c6520746f2073656e642076616c75652c207260448201527f6563697069656e74206d6179206861766520726576657274656400000000000060648201526084016105d0565b60006106f7826040518060400160405280602081526020017f5361666545524332303a206c6f772d6c6576656c2063616c6c206661696c6564815250856001600160a01b03166107749092919063ffffffff16565b80519091501561057f57808060200190518101906107159190610a31565b61057f5760405162461bcd60e51b815260206004820152602a60248201527f5361666545524332303a204552433230206f7065726174696f6e20646964206e6044820152691bdd081cdd58d8d9595960b21b60648201526084016105d0565b6060610783848460008561078b565b949350505050565b6060824710156107ec5760405162461bcd60e51b815260206004820152602660248201527f416464726573733a20696e73756666696369656e742062616c616e636520666f6044820152651c8818d85b1b60d21b60648201526084016105d0565b6001600160a01b0385163b6108435760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e747261637400000060448201526064016105d0565b600080866001600160a01b0316858760405161085f9190610a83565b60006040518083038185875af1925050503d806000811461089c576040519150601f19603f3d011682016040523d82523d6000602084013e6108a1565b606091505b50915091506108b18282866108bc565b979650505050505050565b606083156108cb57508161038f565b8251156108db5782518084602001fd5b8160405162461bcd60e51b81526004016105d09190610a9f565b803567ffffffffffffffff8116811461090d57600080fd5b919050565b60006020828403121561092457600080fd5b61038f826108f5565b80356001600160a01b038116811461090d57600080fd5b60006020828403121561095657600080fd5b61038f8261092d565b6000806040838503121561097257600080fd5b61097b8361092d565b9150610989602084016108f5565b90509250929050565b634e487b7160e01b600052601160045260246000fd5b600082198211156109bb576109bb610992565b500190565b6000828210156109d2576109d2610992565b500390565b6000602082840312156109e957600080fd5b5051919050565b6000816000190483118215151615610a0a57610a0a610992565b500290565b600082610a2c57634e487b7160e01b600052601260045260246000fd5b500490565b600060208284031215610a4357600080fd5b8151801515811461038f57600080fd5b60005b83811015610a6e578181015183820152602001610a56565b83811115610a7d576000848401525b50505050565b60008251610a95818460208701610a53565b9190910192915050565b6020815260008251806020840152610abe816040850160208701610a53565b601f01601f1916919091016040019291505056fea264697066735822122091a50231350a54a6294faff00305efd0ef846f30e0f321e37662f5a80290228464736f6c63430008090033";

    public static final String FUNC_BENEFICIARY = "beneficiary";

    public static final String FUNC_DURATION = "duration";

    public static final String FUNC_release = "release";

    public static final String FUNC_released = "released";

    public static final String FUNC_START = "start";

    public static final String FUNC_vestedAmount = "vestedAmount";

    public static final Event ERC20RELEASED_EVENT = new Event("ERC20Released", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event ETHERRELEASED_EVENT = new Event("EtherReleased", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected VestingWallet(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected VestingWallet(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected VestingWallet(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected VestingWallet(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ERC20ReleasedEventResponse> getERC20ReleasedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ERC20RELEASED_EVENT, transactionReceipt);
        ArrayList<ERC20ReleasedEventResponse> responses = new ArrayList<ERC20ReleasedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ERC20ReleasedEventResponse typedResponse = new ERC20ReleasedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.token = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ERC20ReleasedEventResponse> eRC20ReleasedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ERC20ReleasedEventResponse>() {
            @Override
            public ERC20ReleasedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ERC20RELEASED_EVENT, log);
                ERC20ReleasedEventResponse typedResponse = new ERC20ReleasedEventResponse();
                typedResponse.log = log;
                typedResponse.token = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ERC20ReleasedEventResponse> eRC20ReleasedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ERC20RELEASED_EVENT));
        return eRC20ReleasedEventFlowable(filter);
    }

    public static List<EtherReleasedEventResponse> getEtherReleasedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ETHERRELEASED_EVENT, transactionReceipt);
        ArrayList<EtherReleasedEventResponse> responses = new ArrayList<EtherReleasedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EtherReleasedEventResponse typedResponse = new EtherReleasedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<EtherReleasedEventResponse> etherReleasedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, EtherReleasedEventResponse>() {
            @Override
            public EtherReleasedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ETHERRELEASED_EVENT, log);
                EtherReleasedEventResponse typedResponse = new EtherReleasedEventResponse();
                typedResponse.log = log;
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<EtherReleasedEventResponse> etherReleasedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ETHERRELEASED_EVENT));
        return etherReleasedEventFlowable(filter);
    }

    public RemoteFunctionCall<String> beneficiary() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BENEFICIARY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> duration() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DURATION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> release(String token) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_release, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> release() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_release, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> released() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_released, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> released(String token) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_released, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> start() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_START, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> vestedAmount(BigInteger timestamp) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_vestedAmount, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(timestamp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> vestedAmount(String token, BigInteger timestamp) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_vestedAmount, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token), 
                new org.web3j.abi.datatypes.generated.Uint64(timestamp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static VestingWallet load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new VestingWallet(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static VestingWallet load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new VestingWallet(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static VestingWallet load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new VestingWallet(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static VestingWallet load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new VestingWallet(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<VestingWallet> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String beneficiaryAddress, BigInteger startTimestamp, BigInteger durationSeconds) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, beneficiaryAddress), 
                new org.web3j.abi.datatypes.generated.Uint64(startTimestamp), 
                new org.web3j.abi.datatypes.generated.Uint64(durationSeconds)));
        return deployRemoteCall(VestingWallet.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<VestingWallet> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String beneficiaryAddress, BigInteger startTimestamp, BigInteger durationSeconds) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, beneficiaryAddress), 
                new org.web3j.abi.datatypes.generated.Uint64(startTimestamp), 
                new org.web3j.abi.datatypes.generated.Uint64(durationSeconds)));
        return deployRemoteCall(VestingWallet.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<VestingWallet> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String beneficiaryAddress, BigInteger startTimestamp, BigInteger durationSeconds) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, beneficiaryAddress), 
                new org.web3j.abi.datatypes.generated.Uint64(startTimestamp), 
                new org.web3j.abi.datatypes.generated.Uint64(durationSeconds)));
        return deployRemoteCall(VestingWallet.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<VestingWallet> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String beneficiaryAddress, BigInteger startTimestamp, BigInteger durationSeconds) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, beneficiaryAddress), 
                new org.web3j.abi.datatypes.generated.Uint64(startTimestamp), 
                new org.web3j.abi.datatypes.generated.Uint64(durationSeconds)));
        return deployRemoteCall(VestingWallet.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ERC20ReleasedEventResponse extends BaseEventResponse {
        public String token;

        public BigInteger amount;
    }

    public static class EtherReleasedEventResponse extends BaseEventResponse {
        public BigInteger amount;
    }
}
