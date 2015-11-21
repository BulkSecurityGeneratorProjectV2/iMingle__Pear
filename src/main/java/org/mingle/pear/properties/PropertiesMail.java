/**
 * Copyright (c) 2015, Mingle. All rights reserved.
 */
package org.mingle.pear.properties;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 读取邮件的配置文件信息
 * 
 * @since 1.8
 * @author Mingle
 */
@Component
public class PropertiesMail {
	@Value("${mail.protocol}")
	@Getter private String protocol;
	@Value("${mail.host}")
	@Getter private String host;
	@Value("${mail.port}")
	@Getter private int port;
	@Value("${mail.username}")
	@Getter private String username;
	@Value("${mail.password}")
	@Getter private String password;
}
