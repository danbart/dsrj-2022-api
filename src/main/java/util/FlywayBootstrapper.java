package util;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.slf4j.Logger;

@Startup
@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class FlywayBootstrapper {

    @Inject
    Logger logger;

//    @Resource(lookup = "java:global/dsrj_api")
    @Resource(lookup = "mysql_conection")
    private DataSource dataSource;

    @PostConstruct
    public void startup(){
        Flyway flyway = new Flyway();

        flyway.setDataSource(dataSource);
        flyway.setLocations("db/sql");
        flyway.setTable("schema_version_dsrj");

        MigrationInfo migrationInfo = flyway.info().current();
        if(migrationInfo == null){
            logger.info("No existing database at the actual datasource");
        }else{
            logger.info("Found a database with the version: " + migrationInfo.getVersion() + "-" + migrationInfo.getDescription());
        }

        flyway.migrate();
        logger.info("Successfully migrated to database version: {}", flyway.info().current().getVersion());
    }
}
