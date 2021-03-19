/*
 * Okaeri SDK (Java)
 * Copyright (C) 2021 Okaeri, Dawid Sawicki
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.okaeri.sdk.noproxy;

import eu.okaeri.sdk.OkaeriSdkClient;
import eu.okaeri.sdk.noproxy.error.NoProxyException;
import eu.okaeri.sdk.noproxy.model.NoProxyAddressInfo;
import eu.okaeri.sdk.noproxy.model.NoProxyError;
import kong.unirest.Unirest;

public class NoProxyClient extends OkaeriSdkClient {

    public NoProxyClient() {
        this(null);
    }

    public NoProxyClient(String token) {
        this(
                resolveBaseUrl("OKAERI_SDK_NOPROXY_BASE_PATH", "https://noproxy-api.okaeri.eu"),
                resolveTimeout("OKAERI_SDK_TIMEOUT", 5000),
                resolveToken("OKAERI_SDK_NOPROXY_TOKEN", token)
        );
    }

    public NoProxyClient(String baseUrl, int timeout, String token) {
        super(Unirest.config()
                .socketTimeout(timeout)
                .connectTimeout(timeout)
                .addDefaultHeader("Authorization", "Bearer " + token)
                .defaultBaseUrl(baseUrl)
        );
    }

    public NoProxyAddressInfo getInfo(String address) throws NoProxyException {
        return super.getUnirest()
                .get("/v1/" + address)
                .asObject(NoProxyAddressInfo.class)
                .ifFailure(NoProxyError.class, NoProxyError.CONSUMER)
                .getBody();
    }
}
