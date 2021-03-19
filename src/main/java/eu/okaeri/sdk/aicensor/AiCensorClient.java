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
package eu.okaeri.sdk.aicensor;

import eu.okaeri.sdk.OkaeriSdkClient;
import eu.okaeri.sdk.aicensor.model.AiCensorError;
import eu.okaeri.sdk.aicensor.error.AiCensorException;
import eu.okaeri.sdk.aicensor.model.AiCensorPredictionInfo;
import kong.unirest.Unirest;

import java.util.Collections;

public class AiCensorClient extends OkaeriSdkClient {

    public AiCensorClient() {
        this(null);
    }

    public AiCensorClient(String token) {
        super(Unirest.config()
                .addDefaultHeader("Token", resolveToken("OKAERI_SDK_AICENSOR_TOKEN", token))
                .defaultBaseUrl(resolveBaseUrl("OKAERI_SDK_AICENSOR_BASE_PATH", "https://ai-censor.okaeri.eu"))
        );
    }

    public AiCensorPredictionInfo getPrediction(String phrase) throws AiCensorException {
        return super.getUnirest()
                .post("/predict")
                .body(Collections.singletonMap("phrase", phrase))
                .asObject(AiCensorPredictionInfo.class)
                .ifFailure(AiCensorError.class, AiCensorError.CONSUMER)
                .getBody();
    }
}
