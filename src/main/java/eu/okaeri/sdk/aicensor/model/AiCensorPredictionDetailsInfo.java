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

import lombok.Data;
import unirest.shaded.com.google.gson.annotations.SerializedName;

import java.util.List;

@Data
public class AiCensorPredictionDetailsInfo {
    @SerializedName("basic_contains_hit") private final boolean basicContainsHit;
    @SerializedName("exact_match_hit") private final boolean exactMatchHit;
    @SerializedName("ai_label") private final String aiLabel;
    @SerializedName("ai_probability") private final double aiProbability;
    @SerializedName("domains_list") private final List<String> domainsList;
}
