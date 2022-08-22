//SPDX-License-Identifier: MIT
pragma solidity >0.6.0 <0.8.16;

import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/token/ERC721/ERC721.sol";
import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/utils/Counters.sol";
import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/access/Ownable.sol";
import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/utils/Strings.sol";



//generate random hash from current timestamp
function generateUniqueHash() view returns (uint256) 
{
    return uint256(keccak256(abi.encodePacked("secret", block.timestamp)));
}


contract dpki is ERC721
{
    using Counters for Counters.Counter;
    Counters.Counter private _tokenIds;

    string _nameForConstructor = Strings.toString(generateUniqueHash());

    constructor() ERC721(_nameForConstructor, _nameForConstructor) {}


    struct certificate
    {
        address owner; //owner of the certificate
        uint256 startDate; //start date of the certificate
        uint256 expiration; //expiration of the certificate
        uint256 token;

        //information taken from a sample X.509 certificate
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
    function mintNFT(address to) public returns (uint256)
    {
        _tokenIds.increment();

        uint256 currentTokenId = _tokenIds.current();

        //bind the token to the owner
        _safeMint(to, currentTokenId);

        return currentTokenId;
    }

    certificate[] _certificates;
    revokeList[] _revokeList;

    function certificateSigningRequest(address owner, uint256 startDate, uint256 expiration, 
                                       string memory organizationName, string memory locality, string memory state,    
                                       string memory emailAddress) external returns (uint256)
    {
        uint256 tempTokenId = mintNFT(owner);


        _certificates.push(certificate(owner, startDate, expiration, tempTokenId, organizationName, locality, state, emailAddress));

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
   
}