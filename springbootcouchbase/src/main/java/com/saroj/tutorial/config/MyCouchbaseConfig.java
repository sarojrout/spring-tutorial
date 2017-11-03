/**
 * 
 */
package com.saroj.tutorial.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.convert.MappingCouchbaseConverter;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

/**
 * @author sarojkumarrout
 *
 */
@Configuration
@EnableCouchbaseRepositories(basePackages={"com.saroj.tutorial"})
public class MyCouchbaseConfig extends AbstractCouchbaseConfiguration {

	@Override
	protected List<String> getBootstrapHosts() {
		return Arrays.asList("localhost");
	}

	@Override
	protected String getBucketName() {
		return "employee";
	}

	@Override
	protected String getBucketPassword() {
		return "";
	}
	@Override
	public String typeKey() {
	    // use "javaClass" instead of "_class"
	    return MappingCouchbaseConverter.TYPEKEY_SYNCGATEWAY_COMPATIBLE;
	}
}
