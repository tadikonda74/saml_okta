# Spring Boot SAML 2.0 Integration with Okta

This project demonstrates how to integrate **Spring Boot 3.3.4** with **Okta** using **SAML 2.0** for authentication. It includes configuration for generating service provider metadata, signing credentials, and secure login via Okta as the Identity Provider (IdP).

## 🚀 Features

- SAML 2.0 authentication using Okta
- Service Provider metadata endpoint
- Secure login and logout flows
- PKCS#8 signing credentials
- Configurable via `application.yml`

## 📦 Tech Stack

- Java 17
- Spring Boot 3.3.4
- Spring Security 6.3
- Okta (as SAML IdP)
- OpenSSL (for key generation)

## 🔧 Setup Instructions

### 1. Generate Signing Credentials

Use OpenSSL to create a PKCS#8 private key and self-signed certificate:

```bash
openssl genpkey -algorithm RSA -out private.key -pkeyopt rsa_keygen_bits:2048
openssl req -new -x509 -key private.key -out certificate.crt -days 365
