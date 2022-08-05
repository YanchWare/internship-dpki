# Chapter on PKI/DPKI operations


## Introduction to PKI operations:
In the public key infrastructure (PKI), there are two main operations, which are: **signing request**, and **revocation request**. 
There is also another operation that is nothing more than a composition of revocation and signing, namely updating.

## Certificate signing request (CSR):
A CSR is a message from an entity to a trusted authority of the PKI, which contains information about the entity's identity and it is called *certification request information*. Specifically, it contains the name of the entity, the public key of the entity, and optionally a set of attributes. All of that information is signed with the private key of the entity.

A certification request consists of three parts: 
- certification request information. 
- a signature algorithm identifier.
- digital signature on the certification request information.


If everything is correct, the trusted authority will sign the certification request and return an X.509 certificate. This certificate contains the public key of the entity, a serial number, a validity period, the signature algorithm, and other information. [[1](#references)]

## Certificate Revocation List (CRL):
When a certificate expires or is revoked, the trusted authority will create a CRL. This CRL contains a list of revoked certificates, who made the revocation, and other information. It is signed with the private key of the trusted authority and it is freely available in a public repository. Each revoked certificate is identified in a CRL by its certificate serial number. 
When a certificate-using system uses a certificate (e.g., for verifying a remote user's digital signature), that system not only checks the certificate signature and validity but also acquires a suitably recent CRL and checks the certificate serial number is not on that CRL.
A possible problem with this approach is that the CRL is not updated frequently. If a certificate is revoked, the CRL is updated, but the system may not be able to use the new CRL. [[2](#references)]

---

## Introduction to DPKI operations:
The idea is to try to implement the same operations as in the PKI but, in some cases, with some additional features/changes. 
For the CSR and CRL, we will use the same cryptographic algorithm as in the PKI. 
In this case, the CRL will be stored in the blockchain. This solution could eliminate the problem of CRL updates because each of them is stored in the blockchain. We can call this solution **distributed CRL**.
As regards CSR, it may not change compared to the centralized variant.


## References:

[1] RFC 2986, PKCS #10: Certification Request Syntax Specification. Available at: https://datatracker.ietf.org/doc/html/rfc2986

[2] RFC 5280, Internet X.509 Public Key Infrastructure Certificate and Certificate Revocation List (CRL) Profile. Available at: https://www.rfc-editor.org/rfc/rfc5280.html#section-3.3

