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
package eu.okaeri.sdk.openvote.error;

import eu.okaeri.sdk.openvote.model.vote.OpenVoteError;

public class OpenVoteException extends RuntimeException {

    private OpenVoteError apiError;

    public OpenVoteException(OpenVoteError apiError, String s) {
        super(s);
        this.apiError = apiError;
    }

    public OpenVoteException(OpenVoteError apiError, String s, Throwable throwable) {
        super(s, throwable);
        this.apiError = apiError;
    }

    public OpenVoteException(OpenVoteError apiError, Throwable throwable) {
        super(throwable);
        this.apiError = apiError;
    }

    public OpenVoteException(OpenVoteError apiError, String s, Throwable throwable, boolean b1, boolean b2) {
        super(s, throwable, b1, b2);
        this.apiError = apiError;
    }

    public OpenVoteError getApiError() {
        return this.apiError;
    }
}
