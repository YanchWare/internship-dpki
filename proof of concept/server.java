import java.io.IOException;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;


public class server 
{
    public static <Web3j> void main(String[] args) throws IOException 
    {
        //connect to web3j
        Web3j web3j = Web3j.build(new HttpService());
        //get the current block number
        EthBlockNumber blockNumber = web3j.ethBlockNumber().send();
        //get the current gas price
        EthGasPrice gasPrice = web3j.ethGasPrice().send();
        //get the current client version
        Web3ClientVersion clientVersion = web3j.web3ClientVersion().send();
        //print the results
        System.out.println("Block Number: " + blockNumber.getBlockNumber());
        System.out.println("Gas Price: " + gasPrice.getGasPrice());
        System.out.println("Client Version: " + clientVersion.getWeb3ClientVersion());

    }
}