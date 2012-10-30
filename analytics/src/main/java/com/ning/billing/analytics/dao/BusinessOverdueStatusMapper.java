/*
 * Copyright 2010-2012 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.analytics.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.ning.billing.analytics.model.BusinessOverdueStatusModelDao;

public class BusinessOverdueStatusMapper implements ResultSetMapper<BusinessOverdueStatusModelDao> {
    @Override
    public BusinessOverdueStatusModelDao map(final int index, final ResultSet r, final StatementContext ctx) throws SQLException {
        final UUID bundleId = UUID.fromString(r.getString(1));
        final String externalKey = r.getString(2);
        final String accountKey = r.getString(3);
        final String status = r.getString(4);
        final DateTime startDate = new DateTime(r.getLong(5), DateTimeZone.UTC);
        final DateTime endDate = new DateTime(r.getLong(6), DateTimeZone.UTC);

        return new BusinessOverdueStatusModelDao(accountKey, bundleId, endDate, externalKey, startDate, status);
    }
}
