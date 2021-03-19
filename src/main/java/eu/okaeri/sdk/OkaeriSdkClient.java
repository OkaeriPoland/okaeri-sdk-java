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
package eu.okaeri.sdk;

import kong.unirest.Config;
import kong.unirest.UnirestInstance;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OkaeriSdkClient {

    private final UnirestInstance unirest;

    public OkaeriSdkClient(Config config) {
        config.followRedirects(true).enableCookieManagement(false);
        this.unirest = new UnirestInstance(config);
    }

    protected static int resolveTimeout(String envName, int defaultValue) {
        return Integer.getInteger(envName, defaultValue);
    }

    protected static String resolveToken(String envName, String token) {
        String result = ((token == null) || "".equals(token))
                ? System.getProperty(envName)
                : token;
        if (result == null) {
            throw new IllegalArgumentException("token cannot be null");
        }
        return result;
    }

    protected static String resolveBaseUrl(String envName, String defaultValue) {
        return System.getProperty(envName, defaultValue);
    }
}
