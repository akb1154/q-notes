# Schichtenmodelle

[Quelle (inf-schule.de)](https://www.inf-schule.de/rechnernetze/grundlagen/schichtenmodelle)

## Protokollstapel TCP/IP

Das TCP/IP modell stellt einen Defacto-Standard in der Rechkommunikation dar.
Schichten:

Schicht | OSI  | Name | Erklärung | Bsp. 
--------|------|------|-----------|------
4 | 5-7 | ***Verarbeitungsschicht*** | Umfasst protokolle die mit Anwendungen zusammenarbeiten| HTTP (HTTPS), IMAP, POP3, TLS/SSL
3 | 4 | ***Transportschicht*** | Ermöglicht P2P Kommunikation | TCP, UDP
2 | 3 | ***Internetschicht*** | Vermittlung von Paketen, Routing | IPv4, IPv6, [RFC-6214](https://datatracker.ietf.org/doc/rfc6214/), [RFC-1149](https://datatracker.ietf.org/doc/rfc1149/), [RFC-2549](https://datatracker.ietf.org/doc/rfc2549/)
1 | 1-2 | ***Netzzugangsschicht*** | Nicht wirklich Spezifiziert | Ethernet, IEEE 802.11, FDDI

---------

Anfrage:

```HTTP
GET /index.html HTTP/1.1
```

Antwort:

````HTTP
HTTP/1.1 400 Bad Request
Host: 127.0.0.1
````

Die Anfrage/Antwort bekommt einen TCP und IP Header und dann sowohl einen Ethernet Header als auch einen Cyclic Redundancy Check (CRC) anschließend wid es mit einer Start und Stop Bit/Byte sequenz übertragen. 
