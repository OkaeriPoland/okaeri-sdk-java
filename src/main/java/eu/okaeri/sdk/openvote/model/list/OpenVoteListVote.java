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
package eu.okaeri.sdk.openvote.model.list;

import eu.okaeri.sdk.openvote.model.vote.OpenVoteVoteIdentifier;
import lombok.Data;
import unirest.shaded.com.google.gson.annotations.SerializedName;

import java.util.List;

@Data
public class OpenVoteListVote {
    @SerializedName("list") private final String list;
    @SerializedName("server") private final String server;
    @SerializedName("game") private final String game;
    @SerializedName("lang") private final String lang;
    @SerializedName("background") private final String background;
    @SerializedName("background_type") private final String backgroundType;
    @SerializedName("identifiers") private final List<OpenVoteVoteIdentifier> identifiers;
    @SerializedName("identifiers_hash") private final String identifiersHash;
}
