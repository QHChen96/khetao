package com.khetao.search;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-05
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.khetao.search")
public class SearchApplication {
}
