# Chapter on overview of Ethereum blockchain


## Introduction:

Ethereum is one of the biggest blockchains that is used in the world. It's purpose is to create alternative protocols for building decentralized applications. It is based on the *Ethereum Virtual Machine* (EVM) [[1](#references)]. The main innovation of this blockchain is the use of the *smart contract* [[2](#references)] and the use of it with the *DAPPs* (Decentralized Applications) [[3](#references)].


## Why we chose Ethereum:
We can say that we chose Ethereum blockchain mainly for the following reasons:
- Smart contracts [[2](#references)] are the main ideas of the Ethereum blockchain. Nick Szabo, a computer scientist in 1994, created the term and defined it as *"A smart contract is a computerized transaction protocol that executes the terms of a contract"* [[4](#references)]. He also proposed the metaphor of smart contracts intended as vending machines. With the right inputs, a certain output is guaranteed. 
An important feature is that it is permissionless, anyone can write a smart contract (and call back another smart contract inside of it) and deploy it to the network. The two main programming language for creating smart contract are Solidity[[5](#references)] and Viper[[6](#references)]. 

Here is a simple example taken from [[2](#references)]. 
  
``` solidity
pragma solidity 0.8.7;

contract VendingMachine {

    // Declare state variables of the contract
    address public owner;
    mapping (address => uint) public cupcakeBalances;

    // When 'VendingMachine' contract is deployed:
    // 1. set the deploying address as the owner of the contract
    // 2. set the deployed smart contract's cupcake balance to 100
    constructor() {
        owner = msg.sender;
        cupcakeBalances[address(this)] = 100;
    }

    // Allow the owner to increase the smart contract's cupcake balance
    function refill(uint amount) public {
        require(msg.sender == owner, "Only the owner can refill.");
        cupcakeBalances[address(this)] += amount;
    }

    // Allow anyone to purchase cupcakes
    function purchase(uint amount) public payable {
        require(msg.value >= amount * 1 ether, "You must pay at least 1 ETH per cupcake");
        require(cupcakeBalances[address(this)] >= amount, "Not enough cupcakes in stock to complete this purchase");
        cupcakeBalances[address(this)] -= amount;
        cupcakeBalances[msg.sender] += amount;
    }
}
```


- DAPPs [[3](#references)] is an application built on a decentralized network that combines a smart contract and front-end user interface. It has some advantages, like resistance to censorship, privacy, and trustless computation which is the capacity to analyze a smart contract predictably, without the need to trust a central authority.

-An important aspect that should not be underestimated is the community. It has an extensive community as one of the largest and most important blockchains. 

## Ethereum and DPKI:

The purpose of this subchapter is to analyze Ethereum to understand if it is ready to host distributed-public-key-infrastructure or if some changes need to be made.
First of all, we can say that the trust model is based on Web of Trust (WoT). 
Regarding the consensus on Ethereum, there is PoW, which is not very optimal for our purpose, because the more computing power you have, the more that particular machine will be likely to be chosen. In the case of a malicious node, this would be extremely harmful, as there would be a risk of compromising a certificate. By the end of 2022, Ethereum is expected to change its consensus from PoW to PoS. This could be a big step forward for the DPKI implementation because the node validator is chosen in a random way.



## References:

[1] https://ethereum.org/en/developers/docs/evm/

[2] https://ethereum.org/en/smart-contracts/

[3] https://ethereum.org/en/developers/docs/dapps/

[4] Makoto Yano, Chris Dai, Kenichi Masuda, Yoshio Kishimoto. "Blockchain and Crypt Currency". Available at: https://library.oapen.org/bitstream/handle/20.500.12657/37713/2020_Book_BlockchainAndCryptCurrency.pdf?sequence=1#page=88

[5] https://docs.soliditylang.org/en/v0.8.15/

[6] https://vyper.readthedocs.io/en/stable/

