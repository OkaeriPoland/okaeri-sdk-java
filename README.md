# Okaeri SDK for Java

![License](https://img.shields.io/github/license/OkaeriPoland/okaeri-sdk-java)
![Total lines](https://img.shields.io/tokei/lines/github/OkaeriPoland/okaeri-sdk-java)
![Repo size](https://img.shields.io/github/repo-size/OkaeriPoland/okaeri-sdk-java)
![Contributors](https://img.shields.io/github/contributors/OkaeriPoland/okaeri-sdk-java)
[![Discord](https://img.shields.io/discord/589089838200913930)](https://discord.gg/hASN5eX)

Currently supported services:
- [OK! AI.Censor](#ok-aicensor)
- [OK! No.Proxy](#ok-noproxy)
- [OK! OpenVote](#ok-openvote)

Full documentation available on [wiki.okaeri.eu](https://wiki.okaeri.eu/) in:
- [Polish](https://wiki.okaeri.eu/pl/sdk/java)
- [English](https://wiki.okaeri.eu/en/sdk/java)

## Installation
### Maven
Add repository to the `repositories` section:
```xml
<repository>
    <id>okaeri-repo</id>
    <url>https://storehouse.okaeri.eu/repository/maven-public/</url>
</repository>
```
Add dependency to the `dependencies` section:
```xml
<dependency>
    <groupId>eu.okaeri</groupId>
    <artifactId>okaeri-sdk</artifactId>
    <version>1.4.5</version>
</dependency>
```
In public projects that are not standalone systems you may also like to relocate the following:
```xml
<relocation>
    <pattern>kong.unirest.</pattern>
    <shadedPattern>my.package.lib.unirest.</shadedPattern>
</relocation>
<relocation>
    <pattern>org.apache.</pattern>
    <shadedPattern>my.package.lib.apache.</shadedPattern>
</relocation>
<relocation>
    <pattern>com.google.gson.</pattern>
    <shadedPattern>my.package.lib.gson.</shadedPattern>
</relocation>
```
### Gradle
Add repository to the `repositories` section:
```groovy
maven { url "https://storehouse.okaeri.eu/repository/maven-public/" }
```
Add dependency to the `maven` section:
```groovy
implementation('eu.okaeri:okaeri-sdk:1.4.5')
```

## Example usage
### OK! AI.Censor
See full docs in: [Polish](https://wiki.okaeri.eu/pl/sdk/java#ok-aicensor), [English](https://wiki.okaeri.eu/en/sdk/java#ok-aicensor)
```java
import eu.okaeri.sdk.aicensor.AiCensorClient;
import eu.okaeri.sdk.aicensor.error.AiCensorException;
import eu.okaeri.sdk.aicensor.model.AiCensorPredictionInfo;

final class Demo {
    public static void main(String[] args) {
        AiCensorClient aicensor = new AiCensorClient("XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX");
        AiCensorPredictionInfo prediction;
        try {
            prediction = aicensor.getPrediction("o cie k u r//w@!");;
        } catch (AiCensorException exception) {
            exception.printStackTrace(); // FIXME: error handling
            return;
        }
        boolean swear = prediction.getGeneral().isSwear();
        System.out.println(swear ? "Tak, to jest wulgarne." : "Nie, to nie jest wulgarne");
    }
}
```

### OK! No.Proxy
See full docs in: [Polish](https://wiki.okaeri.eu/pl/sdk/java#ok-noproxy), [English](https://wiki.okaeri.eu/en/sdk/java#ok-noproxy)
```java
import eu.okaeri.sdk.noproxy.NoProxyClient;
import eu.okaeri.sdk.noproxy.error.NoProxyException;
import eu.okaeri.sdk.noproxy.model.NoProxyAddressInfo;

final class Demo {
    public static void main(String[] args) {
        NoProxyClient noproxy = new NoProxyClient("XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX");
        NoProxyAddressInfo info;
        try {
            info = noproxy.getInfo("1.1.1.1");
        } catch (NoProxyException exception) {
            exception.printStackTrace(); // FIXME: error handling
            return;
        }
        boolean proxy = info.getRisks().isProxy();
        boolean verify = info.getSuggestions().isVerify();
        boolean block = info.getSuggestions().isBlock();
        System.out.println("proxy: " + proxy + ", verify: " + verify + ", block: " + block);
    }
}
```

### OK! OpenVote
See full docs in: [Polish](https://wiki.okaeri.eu/pl/sdk/java#ok-openvote), [English](https://wiki.okaeri.eu/en/sdk/java#ok-openvote)
```java
import eu.okaeri.sdk.openvote.OpenVoteClient;
import eu.okaeri.sdk.openvote.error.OpenVoteException;
import eu.okaeri.sdk.openvote.model.list.OpenVoteListVote;

import java.util.UUID;

final class Demo {
    public static void main(String[] args) {
        OpenVoteClient openvote = new OpenVoteClient();
        OpenVoteListVote vote;
        try {
            vote = openvote.getListVote(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6"));
        } catch (OpenVoteException exception) {
            exception.printStackTrace(); // FIXME: error handling
            return;
        }
        String server = vote.getServer();
        String list = vote.getList();
        System.out.println("server: " + server + ", list: " + list);
    }
}
```
