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

package org.mingle.pear.domain.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.mingle.pear.domain.Account;

/**
 * 账户Mapper
 *
 * @author Mingle
 * @since 1.8
 */
public interface AccountMapper {
    @Select("SELECT * FROM t_account WHERE id = #{accountId}")
    Account getAccount(Long accountId);

    @InsertProvider(type = AccountSqlProvider.class, method = "insert")
    int insertAccount(Account account);

    @Delete("DELETE FROM t_account WHERE id = #{accountId}")
    int deleteAccount(Long accountId);
}
