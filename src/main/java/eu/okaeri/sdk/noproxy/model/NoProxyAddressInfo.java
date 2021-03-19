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
package eu.okaeri.sdk.noproxy.model;

import lombok.Data;
import unirest.shaded.com.google.gson.annotations.SerializedName;

@Data
public class NoProxyAddressInfo {
    @SerializedName("general") private final NoProxyAddressInfoGeneral general;
    @SerializedName("risks") private final NoProxyAddressInfoRisks risks;
    @SerializedName("score") private final NoProxyAddressInfoScore score;
    @SerializedName("suggestions") private final NoProxyAddressInfoSuggestions suggestions;
}
