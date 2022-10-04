package com.yanchware.internships;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class TokenTimelock extends Contract {
    public static final String BINARY = "60e060405234801561001057600080fd5b506040516107c53803806107c583398101604081905261002f916100d0565b42811161009d5760405162461bcd60e51b815260206004820152603260248201527f546f6b656e54696d656c6f636b3a2072656c656173652074696d65206973206260448201527165666f72652063757272656e742074696d6560701b606482015260840160405180910390fd5b6001600160a01b03928316608052911660a05260c052610113565b6001600160a01b03811681146100cd57600080fd5b50565b6000806000606084860312156100e557600080fd5b83516100f0816100b8565b6020850151909350610101816100b8565b80925050604084015190509250925092565b60805160a05160c05161066b61015a60003960008181609f015260f0015260008181605301526102a701526000818160ca015281816101820152610285015261066b6000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c806338af3eed1461005157806386d1a69f14610090578063b91d40011461009a578063fc0c546a146100c8575b600080fd5b7f00000000000000000000000000000000000000000000000000000000000000005b6040516001600160a01b0390911681526020015b60405180910390f35b6100986100ee565b005b6040517f00000000000000000000000000000000000000000000000000000000000000008152602001610087565b7f0000000000000000000000000000000000000000000000000000000000000000610073565b7f000000000000000000000000000000000000000000000000000000000000000042101561017e5760405162461bcd60e51b815260206004820152603260248201527f546f6b656e54696d656c6f636b3a2063757272656e742074696d65206973206260448201527165666f72652072656c656173652074696d6560701b60648201526084015b60405180910390fd5b60007f00000000000000000000000000000000000000000000000000000000000000006040516370a0823160e01b81523060048201526001600160a01b0391909116906370a082319060240160206040518083038186803b1580156101e257600080fd5b505afa1580156101f6573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061021a919061057b565b9050600081116102785760405162461bcd60e51b815260206004820152602360248201527f546f6b656e54696d656c6f636b3a206e6f20746f6b656e7320746f2072656c6560448201526261736560e81b6064820152608401610175565b6102cc6001600160a01b037f0000000000000000000000000000000000000000000000000000000000000000167f0000000000000000000000000000000000000000000000000000000000000000836102cf565b50565b604080516001600160a01b038416602482015260448082018490528251808303909101815260649091019091526020810180516001600160e01b031663a9059cbb60e01b179052610321908490610326565b505050565b600061037b826040518060400160405280602081526020017f5361666545524332303a206c6f772d6c6576656c2063616c6c206661696c6564815250856001600160a01b03166103f89092919063ffffffff16565b80519091501561032157808060200190518101906103999190610594565b6103215760405162461bcd60e51b815260206004820152602a60248201527f5361666545524332303a204552433230206f7065726174696f6e20646964206e6044820152691bdd081cdd58d8d9595960b21b6064820152608401610175565b60606104078484600085610411565b90505b9392505050565b6060824710156104725760405162461bcd60e51b815260206004820152602660248201527f416464726573733a20696e73756666696369656e742062616c616e636520666f6044820152651c8818d85b1b60d21b6064820152608401610175565b6001600160a01b0385163b6104c95760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e74726163740000006044820152606401610175565b600080866001600160a01b031685876040516104e591906105e6565b60006040518083038185875af1925050503d8060008114610522576040519150601f19603f3d011682016040523d82523d6000602084013e610527565b606091505b5091509150610537828286610542565b979650505050505050565b6060831561055157508161040a565b8251156105615782518084602001fd5b8160405162461bcd60e51b81526004016101759190610602565b60006020828403121561058d57600080fd5b5051919050565b6000602082840312156105a657600080fd5b8151801515811461040a57600080fd5b60005b838110156105d15781810151838201526020016105b9565b838111156105e0576000848401525b50505050565b600082516105f88184602087016105b6565b9190910192915050565b60208152600082518060208401526106218160408501602087016105b6565b601f01601f1916919091016040019291505056fea2646970667358221220e1edc714a7a88ff67092120ee516ea0923b2acaa8694e617af532f13bdc8a92264736f6c63430008090033";

    public static final String FUNC_BENEFICIARY = "beneficiary";

    public static final String FUNC_RELEASE = "release";

    public static final String FUNC_RELEASETIME = "releaseTime";

    public static final String FUNC_TOKEN = "token";

    @Deprecated
    protected TokenTimelock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TokenTimelock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TokenTimelock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TokenTimelock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> beneficiary() {
        final Function function = new Function(FUNC_BENEFICIARY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> release() {
        final Function function = new Function(
                FUNC_RELEASE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> releaseTime() {
        final Function function = new Function(FUNC_RELEASETIME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> token() {
        final Function function = new Function(FUNC_TOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static TokenTimelock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TokenTimelock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TokenTimelock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TokenTimelock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TokenTimelock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TokenTimelock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TokenTimelock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TokenTimelock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TokenTimelock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String token_, String beneficiary_, BigInteger releaseTime_) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token_), 
                new org.web3j.abi.datatypes.Address(160, beneficiary_), 
                new org.web3j.abi.datatypes.generated.Uint256(releaseTime_)));
        return deployRemoteCall(TokenTimelock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<TokenTimelock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String token_, String beneficiary_, BigInteger releaseTime_) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token_), 
                new org.web3j.abi.datatypes.Address(160, beneficiary_), 
                new org.web3j.abi.datatypes.generated.Uint256(releaseTime_)));
        return deployRemoteCall(TokenTimelock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TokenTimelock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String token_, String beneficiary_, BigInteger releaseTime_) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token_), 
                new org.web3j.abi.datatypes.Address(160, beneficiary_), 
                new org.web3j.abi.datatypes.generated.Uint256(releaseTime_)));
        return deployRemoteCall(TokenTimelock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TokenTimelock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String token_, String beneficiary_, BigInteger releaseTime_) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token_), 
                new org.web3j.abi.datatypes.Address(160, beneficiary_), 
                new org.web3j.abi.datatypes.generated.Uint256(releaseTime_)));
        return deployRemoteCall(TokenTimelock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
