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
package eu.okaeri.sdk.aicensor.model;

import eu.okaeri.sdk.aicensor.error.AiCensorException;
import kong.unirest.HttpResponse;
import lombok.Data;

import java.util.function.Consumer;

@Data
public class AiCensorError {

    public static final Consumer<HttpResponse<AiCensorError>> CONSUMER = response -> {
        AiCensorError error = response.getBody();
        String message = "Error handling request (" + error.type + " - " + error.message + ")";
        throw new AiCensorException(error, message);
    };

    private final String type;
    private final String message;

    public enum ErrorType {
        UNKNOWN,
        PARSE_ERROR,
        AUTHORIZATION_FAILED,
        ELEMENT_NOT_FOUND,
        INVALID_INPUT
    }
}