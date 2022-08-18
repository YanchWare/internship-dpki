//SPDX-License-Identifier: MIT
pragma solidity >0.6.0 <=0.8.0;

import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/release-v3.4/contracts/token/ERC721/ERC721.sol";
import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/release-v3.4/contracts/utils/Counters.sol";
import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/release-v3.4/contracts/access/Ownable.sol";

//generate random hash from current timestamp
function generateUniqueHash() view returns (uint256) 
{
    return uint256(keccak256(abi.encodePacked("secret", block.timestamp)));
}


contract dpki is ERC721
{
    using Counters for Counters.Counter;
    Counters.Counter private _tokenIds;

    constructor() ERC721("testToken1", "tT1") {}


    //publish a unique instance of ERC721 token
    function mint(address to) external returns (uint256)
    {
        _tokenIds.increment();

        uint256 currentTokenId = _tokenIds.current();

        //bind the token to the owner
        _safeMint(to, currentTokenId);

        return currentTokenId;
    }

    struct certificate
    {
        address owner; //owner of the certificate
        uint256 startDate; //start date of the certificate
        uint256 expiration; //expiration of the certificate

        //the tokenId entry is not present because it is uniquely associated with the owner address.
        //Consequently, knowing the owner's address, it is possible to trace the tokenId

        //information taken from a sample X.509 certificate
        string organizationName;
        string locality;
        string state;
        string emailAddress;
    }

    struct revokeList
    {
        //todo: add revoke list
    }

    certificate[] _certificates;

    function certificateSigningRequest(address owner, uint256 startDate, uint256 expiration, 
                                       string memory organizationName, string memory locality, string memory state,    
                                       string memory emailAddress) external returns (uint256)
    {
        require(startDate <= expiration, "start date must be before expiration");


        uint256 tempTokenId = mint(owner);


        _certificates.push(certificate(owner, startDate, expiration, organizationName, locality, state, emailAddress));

        return tempTokenId;
    }
    
}