package com.yanchware.internships;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
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
public class BeaconProxy extends Contract {
    public static final String BINARY = "608060405260405161092738038061092783398101604081905261002291610474565b61002e82826000610035565b505061059e565b61003e8361010f565b6040516001600160a01b038416907f1cf3b03a6cf19fa2baba4df148e9dcabedea7f8a5c07840e207e5c089be95d3e90600090a260008251118061007f5750805b1561010a57610108836001600160a01b0316635c60da1b6040518163ffffffff1660e01b815260040160206040518083038186803b1580156100c057600080fd5b505afa1580156100d4573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906100f89190610534565b836102c160201b6100291760201c565b505b505050565b610122816102ed60201b6100551760201c565b6101815760405162461bcd60e51b815260206004820152602560248201527f455243313936373a206e657720626561636f6e206973206e6f74206120636f6e6044820152641d1c9858dd60da1b60648201526084015b60405180910390fd5b610204816001600160a01b0316635c60da1b6040518163ffffffff1660e01b815260040160206040518083038186803b1580156101bd57600080fd5b505afa1580156101d1573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906101f59190610534565b6102ed60201b6100551760201c565b6102695760405162461bcd60e51b815260206004820152603060248201527f455243313936373a20626561636f6e20696d706c656d656e746174696f6e206960448201526f1cc81b9bdd08184818dbdb9d1c9858dd60821b6064820152608401610178565b806102a07fa3f0ad74e5423aebfd80d3ef4346578335a9a72aeaee59ff6cb3582b35133d5060001b6102fc60201b6100641760201c565b80546001600160a01b0319166001600160a01b039290921691909117905550565b60606102e68383604051806060016040528060278152602001610900602791396102ff565b9392505050565b6001600160a01b03163b151590565b90565b60606001600160a01b0384163b6103675760405162461bcd60e51b815260206004820152602660248201527f416464726573733a2064656c65676174652063616c6c20746f206e6f6e2d636f6044820152651b9d1c9858dd60d21b6064820152608401610178565b600080856001600160a01b031685604051610382919061054f565b600060405180830381855af49150503d80600081146103bd576040519150601f19603f3d011682016040523d82523d6000602084013e6103c2565b606091505b5090925090506103d38282866103dd565b9695505050505050565b606083156103ec5750816102e6565b8251156103fc5782518084602001fd5b8160405162461bcd60e51b8152600401610178919061056b565b80516001600160a01b038116811461042d57600080fd5b919050565b634e487b7160e01b600052604160045260246000fd5b60005b8381101561046357818101518382015260200161044b565b838111156101085750506000910152565b6000806040838503121561048757600080fd5b61049083610416565b60208401519092506001600160401b03808211156104ad57600080fd5b818501915085601f8301126104c157600080fd5b8151818111156104d3576104d3610432565b604051601f8201601f19908116603f011681019083821181831017156104fb576104fb610432565b8160405282815288602084870101111561051457600080fd5b610525836020830160208801610448565b80955050505050509250929050565b60006020828403121561054657600080fd5b6102e682610416565b60008251610561818460208701610448565b9190910192915050565b602081526000825180602084015261058a816040850160208701610448565b601f01601f19169190910160400192915050565b610353806105ad6000396000f3fe60806040523661001357610011610017565b005b6100115b610027610022610067565b61010f565b565b606061004e83836040518060600160405280602781526020016102f760279139610133565b9392505050565b6001600160a01b03163b151590565b90565b600061009a7fa3f0ad74e5423aebfd80d3ef4346578335a9a72aeaee59ff6cb3582b35133d50546001600160a01b031690565b6001600160a01b0316635c60da1b6040518163ffffffff1660e01b815260040160206040518083038186803b1580156100d257600080fd5b505afa1580156100e6573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061010a919061024e565b905090565b3660008037600080366000845af43d6000803e80801561012e573d6000f35b3d6000fd5b60606001600160a01b0384163b6101a05760405162461bcd60e51b815260206004820152602660248201527f416464726573733a2064656c65676174652063616c6c20746f206e6f6e2d636f6044820152651b9d1c9858dd60d21b60648201526084015b60405180910390fd5b600080856001600160a01b0316856040516101bb91906102a7565b600060405180830381855af49150503d80600081146101f6576040519150601f19603f3d011682016040523d82523d6000602084013e6101fb565b606091505b509150915061020b828286610215565b9695505050505050565b6060831561022457508161004e565b8251156102345782518084602001fd5b8160405162461bcd60e51b815260040161019791906102c3565b60006020828403121561026057600080fd5b81516001600160a01b038116811461004e57600080fd5b60005b8381101561029257818101518382015260200161027a565b838111156102a1576000848401525b50505050565b600082516102b9818460208701610277565b9190910192915050565b60208152600082518060208401526102e2816040850160208701610277565b601f01601f1916919091016040019291505056fe416464726573733a206c6f772d6c6576656c2064656c65676174652063616c6c206661696c6564a2646970667358221220b0dcd1bf9d4e151c661160b6a86dd3d6cf0cbc97be1285a4d55b4e4eef6fdb0b64736f6c63430008090033416464726573733a206c6f772d6c6576656c2064656c65676174652063616c6c206661696c6564";

    public static final Event ADMINCHANGED_EVENT = new Event("AdminChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event BEACONUPGRADED_EVENT = new Event("BeaconUpgraded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event UPGRADED_EVENT = new Event("Upgraded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected BeaconProxy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BeaconProxy(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BeaconProxy(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BeaconProxy(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<AdminChangedEventResponse> getAdminChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ADMINCHANGED_EVENT, transactionReceipt);
        ArrayList<AdminChangedEventResponse> responses = new ArrayList<AdminChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AdminChangedEventResponse typedResponse = new AdminChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousAdmin = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.newAdmin = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AdminChangedEventResponse> adminChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AdminChangedEventResponse>() {
            @Override
            public AdminChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADMINCHANGED_EVENT, log);
                AdminChangedEventResponse typedResponse = new AdminChangedEventResponse();
                typedResponse.log = log;
                typedResponse.previousAdmin = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.newAdmin = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AdminChangedEventResponse> adminChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADMINCHANGED_EVENT));
        return adminChangedEventFlowable(filter);
    }

    public static List<BeaconUpgradedEventResponse> getBeaconUpgradedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(BEACONUPGRADED_EVENT, transactionReceipt);
        ArrayList<BeaconUpgradedEventResponse> responses = new ArrayList<BeaconUpgradedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BeaconUpgradedEventResponse typedResponse = new BeaconUpgradedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.beacon = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BeaconUpgradedEventResponse> beaconUpgradedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BeaconUpgradedEventResponse>() {
            @Override
            public BeaconUpgradedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BEACONUPGRADED_EVENT, log);
                BeaconUpgradedEventResponse typedResponse = new BeaconUpgradedEventResponse();
                typedResponse.log = log;
                typedResponse.beacon = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<BeaconUpgradedEventResponse> beaconUpgradedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BEACONUPGRADED_EVENT));
        return beaconUpgradedEventFlowable(filter);
    }

    public static List<UpgradedEventResponse> getUpgradedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(UPGRADED_EVENT, transactionReceipt);
        ArrayList<UpgradedEventResponse> responses = new ArrayList<UpgradedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UpgradedEventResponse typedResponse = new UpgradedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.implementation = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UpgradedEventResponse> upgradedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, UpgradedEventResponse>() {
            @Override
            public UpgradedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(UPGRADED_EVENT, log);
                UpgradedEventResponse typedResponse = new UpgradedEventResponse();
                typedResponse.log = log;
                typedResponse.implementation = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UpgradedEventResponse> upgradedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UPGRADED_EVENT));
        return upgradedEventFlowable(filter);
    }

    @Deprecated
    public static BeaconProxy load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BeaconProxy(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BeaconProxy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BeaconProxy(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BeaconProxy load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BeaconProxy(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BeaconProxy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BeaconProxy(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BeaconProxy> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger initialWeiValue, String beacon, byte[] data) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, beacon), 
                new org.web3j.abi.datatypes.DynamicBytes(data)));
        return deployRemoteCall(BeaconProxy.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor, initialWeiValue);
    }

    public static RemoteCall<BeaconProxy> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger initialWeiValue, String beacon, byte[] data) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, beacon), 
                new org.web3j.abi.datatypes.DynamicBytes(data)));
        return deployRemoteCall(BeaconProxy.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor, initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<BeaconProxy> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, String beacon, byte[] data) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, beacon), 
                new org.web3j.abi.datatypes.DynamicBytes(data)));
        return deployRemoteCall(BeaconProxy.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<BeaconProxy> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, String beacon, byte[] data) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, beacon), 
                new org.web3j.abi.datatypes.DynamicBytes(data)));
        return deployRemoteCall(BeaconProxy.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static class AdminChangedEventResponse extends BaseEventResponse {
        public String previousAdmin;

        public String newAdmin;
    }

    public static class BeaconUpgradedEventResponse extends BaseEventResponse {
        public String beacon;
    }

    public static class UpgradedEventResponse extends BaseEventResponse {
        public String implementation;
    }
}
