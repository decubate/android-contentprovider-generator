/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 * 
 * Copyright (C) 2012-2014 Benoit 'BoD' Lubek (BoD@JRAF.org)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jraf.androidcontentprovidergenerator.sample.provider.company;

import java.util.Date;

import android.content.ContentResolver;
import android.net.Uri;

import org.jraf.androidcontentprovidergenerator.sample.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code company} table.
 */
public class CompanyContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return CompanyColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, CompanySelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * The commercial name of this company.
     */
    public CompanyContentValues putName(String value) {
        if (value == null) throw new IllegalArgumentException("value for name must not be null");
        mContentValues.put(CompanyColumns.NAME, value);
        return this;
    }



    /**
     * The full address of this company.
     */
    public CompanyContentValues putAddress(String value) {
        mContentValues.put(CompanyColumns.ADDRESS, value);
        return this;
    }

    public CompanyContentValues putAddressNull() {
        mContentValues.putNull(CompanyColumns.ADDRESS);
        return this;
    }

}
