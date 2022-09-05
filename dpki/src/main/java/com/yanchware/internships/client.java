package com.yanchware.internships;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.web3j.abi.EventValues;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;



public class client 
{   
    private static String contractAddress = "0x780ee570c32a1b565aaee2b7c041e2081d75f618";

    public String getContractAddress() {
        return contractAddress;
    }

    public void configLoad(Dpki contract, File file) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, CipherException, IOException
    {
        final Credentials credential = WalletUtils.loadCredentials("password", file);

        final Web3j web3j = Web3j.build(new HttpService("https://goerli.infura.io/v3/d777809793694d9dacf5e1f94bfec65a"));

        ContractGasProvider contractGasProvider = new DefaultGasProvider();

        contract = Dpki.load(getContractAddress(), web3j, credential, contractGasProvider);
    }

    public EventValues getCsrByCommonName(Dpki contract, String commonName) throws Exception
    {
        final TransactionReceipt transactionReceipt = contract.getCertificateByCommonName(commonName).send();

        EventValues event = (EventValues) contract.getReturnCertificateByCommonNameEvents(transactionReceipt);

        return event;
    }

    public static EventValues getCsrByTokenId(Dpki contract, BigInteger tokenIdParameter) throws Exception
    {
        TransactionReceipt transactionReceipt = contract.getCertificateByTokenId(tokenIdParameter).send();

        EventValues event = (EventValues) contract.getReturnCertificateByCommonNameEvents(transactionReceipt);
        
        return event;
    }

    public static void main(String[] args) 
    {
        try 
        {
            client client = new client();
            Dpki contract = null;
            
            File file = new File("UTC--2022-09-02T11-41-44.574327638Z--183e7bfb82beb62acb4da5ea1e0fb1f369e6dd4e.json");
            
            client.configLoad(contract, file);
            
            EventValues event = client.getCsrByCommonName(contract, "serverexample.com");

            System.out.println(event.getIndexedValues().get(0).getValue().toString());            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }    
    }

    
}
