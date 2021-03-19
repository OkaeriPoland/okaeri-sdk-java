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
package eu.okaeri.sdk.openvote.model.vote;

import eu.okaeri.sdk.openvote.error.OpenVoteException;
import kong.unirest.HttpResponse;
import lombok.Data;

import java.util.function.Consumer;

@Data
public class OpenVoteError {

    public static final Consumer<HttpResponse<OpenVoteError>> CONSUMER = response -> {
        OpenVoteError error = response.getBody();
        String message = "Error handling request (" + error.error + " - " + error.message + ")";
        throw new OpenVoteException(error, message);
    };

    private final int status;
    private final String error;
    private final String message;
}