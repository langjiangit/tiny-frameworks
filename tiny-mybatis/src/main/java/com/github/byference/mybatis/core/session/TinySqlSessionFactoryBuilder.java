package com.github.byference.mybatis.core.session;


import com.github.byference.mybatis.core.session.defaults.DefaultTinySqlSessionFactory;
import com.github.byference.mybatis.core.TinyConfiguration;
import com.github.byference.mybatis.core.mapping.TinyEnvironment;
import com.github.byference.mybatis.core.util.XMLParser;

import java.io.InputStream;
import java.util.Properties;

/**
 * TinySqlSessionFactoryBuilder
 *
 * @author byference
 * @since 2019-08-03
 */
public class TinySqlSessionFactoryBuilder {


    public TinySqlSessionFactory build(InputStream inputStream) {

        XMLParser xmlParser = new XMLParser(inputStream);

        Properties properties = xmlParser.getDataSourceProperties();

        TinyConfiguration configuration = new TinyConfiguration();
        TinyEnvironment environment = new TinyEnvironment();

        environment.setDriver(properties.getProperty("driver"));
        environment.setUrl(properties.getProperty("url"));
        environment.setUsername(properties.getProperty("username"));
        environment.setPassword(properties.getProperty("password"));
        configuration.setEnvironment(environment);

        // 初始化statementMap
        configuration.setMapperStatementMap(xmlParser.getMapperStatementMap());

        return new DefaultTinySqlSessionFactory(configuration);
    }

}
