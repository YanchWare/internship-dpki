//SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

// import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/token/ERC721/ERC721.sol";
// import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/token/ERC721/extensions/ERC721URIStorage.sol";
// import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/utils/Counters.sol";
// import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/access/Ownable.sol";
// import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/utils/Strings.sol";

import "@openzeppelin/contracts/token/ERC721/ERC721.sol";
import "@openzeppelin/contracts/token/ERC721/extensions/ERC721URIStorage.sol";
import "@openzeppelin/contracts/utils/Counters.sol";
import "@openzeppelin/contracts/access/Ownable.sol";
import "@openzeppelin/contracts/utils/Strings.sol";



//generate random hash from current timestamp
function generateUniqueHash() view returns (uint256) 
{
    return uint256(keccak256(abi.encodePacked("secret", block.timestamp)));
}


contract dpki is ERC721URIStorage
{
    using Counters for Counters.Counter;
    Counters.Counter private _tokenIds;

    string _nameForConstructor = Strings.toString(generateUniqueHash());

    constructor() ERC721(_nameForConstructor, _nameForConstructor) {}


    struct certificate
    {
        address owner; //owner of the certificate
        uint256 token;
        bytes32 publicKey;

        //information taken from a sample X.509 certificate
        string commonName;
        string organizationName;
        string locality;
        string state;
        string emailAddress;
    }

    struct revokeList
    {
        certificate certificates;
        uint256 revokedDate;
        string reason;
    }

    //publish a unique instance of ERC721 token
    function mintNFT(address to, string memory tokenURI)  public returns (uint256)
    {
        _tokenIds.increment();

        uint256 currentTokenId = _tokenIds.current();

        //bind the token to the owner
        _safeMint(to, currentTokenId);
        _setTokenURI(currentTokenId, tokenURI);

        return currentTokenId;
    }

    certificate[] _certificates;
    revokeList[] _revokeList;

    function certificateSigningRequest(address owner, string memory tokenURI, bytes32 pub_key,
                                       string memory commonName, string memory organizationName, string memory locality, string memory state,    
                                       string memory emailAddress) external returns (uint256)
    {
        uint256 tempTokenId = mintNFT(owner, tokenURI);

        _certificates.push(certificate(owner, tempTokenId, pub_key, commonName, organizationName, locality, state, emailAddress));

        return tempTokenId;
    }


    function certificateRevocationList(uint256 tokenIdParameter, string memory reason) external 
    {
        //find the certificate associated with the tokenId
        for (uint i = 0; i < _certificates.length; i++)
        {
            if (_certificates[i].owner == msg.sender && _certificates[i].token == tokenIdParameter)
            {
                _revokeList.push(revokeList(_certificates[i], block.timestamp, reason));
                break;
            }
        }
    }

    
    //check if there is a certificate associated with the tokenId
    function getCertificateByTokenId(uint256 tokenIdParameter) public view returns (certificate memory)
    {
        for (uint i = 0; i < _certificates.length; i++)
        {
            if (_certificates[i].token == tokenIdParameter)
            {
                return _certificates[i];
            }
        }
        revert("certificate not found");
    }

    //check if there is a certificate associated with commonName
    function getCertificateByCommonName(string memory commonName) public view returns (certificate memory)
    {
        for (uint i = 0; i < _certificates.length; i++)
        {      
            //here we use hash because the cost of gas is lower than the cost of string comparison
            if ( keccak256(abi.encodePacked(_certificates[i].commonName)) == keccak256(abi.encodePacked(commonName)))
            {
                return _certificates[i];
            }
        }
        revert("certificate not found");
    }
   
}