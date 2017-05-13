/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mingle.pear.dao.impl;

import org.mingle.pear.dao.AccountDao;
import org.mingle.pear.domain.Account;
import org.mingle.pear.persistence.dao.impl.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * @author mingle
 * @since 1.8
 */
@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account, Long> implements
        AccountDao {

    public AccountDaoImpl() {
        super(Account.class);
    }

}
